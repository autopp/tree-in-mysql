package tree;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ClosureTreeRepository extends TreeRepository {
    public ClosureTreeRepository(SqlSessionFactory factory) {
        super(factory);
    }

    public static class Division {
        public final int id;
        public final Integer parentId;

        public Division(int id, Integer parentId) {
            this.id = id;
            this.parentId = parentId;
        }
    }
    public void addDivision(int id, Integer parentId) {
        try (SqlSession session = factory.openSession()) {
            Division division = new Division(id, parentId);
            session.insert("tree.ClosureDivisionMapper.addDivision", division);
            session.insert("tree.ClosureDivisionMapper.addDivisionPath", division);
            session.commit();
        }
    }

    public Integer getParentOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectOne("tree.ClosureDivisionMapper.getParentOf", id);
        }
    }

    public List<Integer> getAncestorsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.ClosureDivisionMapper.getAncestorsOf", id);
        }
    }

    public List<Integer> getChildrenOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.ClosureDivisionMapper.getChildrenOf", id);
        }
    }

    public List<Integer> getDescendantsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.ClosureDivisionMapper.getDescendantsOf", id);
        }
    }
}
