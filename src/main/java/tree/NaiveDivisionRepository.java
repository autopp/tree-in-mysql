package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.apache.ibatis.annotations.Insert;

public class NaiveDivisionRepository extends DivisionRepository {
    public NaiveDivisionRepository(SqlSessionFactory factory) {
        super(factory);
    }

    public static class NaiveDivision {
        public int id;
        public Integer parentId;

        public NaiveDivision(int id, Integer parentId) {
            this.id = id;
            this.parentId = parentId;
        }
    }

    public void addDivision(int id, Integer parentId) {
        try (SqlSession session = factory.openSession()) {
            session.insert("tree.NaiveDivisionMapper.addDivision", new NaiveDivision(id, parentId));
            session.commit();
        }
    }

    public Division getParentOf(int id) {
        try (SqlSession session = factory.openSession()) {
            Integer result = session.selectOne("tree.NaiveDivisionMapper.getParentOf", id);
            return result == null ? null : new Division(result);
        }
    }

    public List<Division> getAncestorsOf(int id) {
        List<Division> list = new ArrayList<Division>();

        int i = id;
        while (true) {
            Division ancestor = getParentOf(i);
            if (ancestor == null) {
                break;
            }
            list.add(ancestor);
            i = ancestor.id;
        }

        return list;
    }

    public List<Division> getChildsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            List<Integer> ids = session.selectList("tree.NaiveDivisionMapper.getChildsOf", id);
            return ids.stream().map((i) -> new Division(i)).collect(Collectors.toList());
        }
    }

    public List<Division> getDescendantsOf(int id) {
        throw new UnsupportedOperationException("not supported");
    }
}
