package tree;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ClosureTreeRepository extends TreeRepository {
    public ClosureTreeRepository(SqlSessionFactory factory) {
        super(factory);
    }

    public static class ClosureNode {
        public final int id;
        public final Integer parentId;

        public ClosureNode(int id, Integer parentId) {
            this.id = id;
            this.parentId = parentId;
        }
    }
    public void addDivision(int id, Integer parentId) {
        try (SqlSession session = factory.openSession()) {
            ClosureNode division = new ClosureNode(id, parentId);
            session.insert("tree.ClosureTreeMapper.addDivision", division);
            session.insert("tree.ClosureTreeMapper.addDivisionPath", division);
            session.commit();
        }
    }

    public Integer getParentOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectOne("tree.ClosureTreeMapper.getParentOf", id);
        }
    }

    public List<Integer> getAncestorsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.ClosureTreeMapper.getAncestorsOf", id);
        }
    }

    public List<Integer> getChildrenOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.ClosureTreeMapper.getChildrenOf", id);
        }
    }

    public List<Integer> getDescendantsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.ClosureTreeMapper.getDescendantsOf", id);
        }
    }
}
