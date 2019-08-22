package tree;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PathTreeRepository extends TreeRepository {
    public PathTreeRepository(SqlSessionFactory factory) {
        super(factory);
    }

    public static class PathNode {
        public int id;
        public Integer parentId;

        public PathNode(int id, Integer parentId) {
            this.id = id;
            this.parentId = parentId;
        }
    }

    public void addDivision(int id, Integer parentId) {
        try (SqlSession session = factory.openSession()) {
            session.insert("tree.PathTreeMapper.addDivision", new PathNode(id, parentId));
            session.commit();
        }
    }

    public Integer getParentOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectOne("tree.PathTreeMapper.getParentOf", new PathNode(id, null));
        }
    }

    public List<Integer> getAncestorsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.PathTreeMapper.getAncestorsOf", new PathNode(id, null));
        }
    }

    public List<Integer> getChildrenOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.PathTreeMapper.getChildrenOf", new PathNode(id, null));
        }
    }

    public List<Integer> getDescendantsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.PathTreeMapper.getDescendantsOf", new PathNode(id, null));
        }
    }
}
