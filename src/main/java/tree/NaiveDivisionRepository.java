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

    public Integer getParentOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectOne("tree.NaiveDivisionMapper.getParentOf", id);
        }
    }

    public List<Integer> getAncestorsOf(int id) {
        List<Integer> list = new ArrayList<Integer>();

        int i = id;
        while (true) {
            Integer ancestor = getParentOf(i);
            if (ancestor == null) {
                break;
            }
            list.add(ancestor);
            i = ancestor;
        }

        return list;
    }

    public List<Integer> getChildsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.NaiveDivisionMapper.getChildsOf", id);
        }
    }

    public List<Integer> getDescendantsOf(int id) {
        List<Integer> list = new ArrayList<Integer>();

        List<Integer> childs = getChildsOf(id);
        list.addAll(childs);
        list.addAll(childs.stream().flatMap((c) -> getDescendantsOf(c).stream()).collect(Collectors.toList()));

        return list;
    }
}
