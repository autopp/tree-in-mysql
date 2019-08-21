package tree;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PathTreeRepository extends TreeRepository {
    public PathTreeRepository(SqlSessionFactory factory) {
        super(factory);
    }

    public static class PathDivision {
        public int id;
        public Integer parentId;

        public PathDivision(int id, Integer parentId) {
            this.id = id;
            this.parentId = parentId;
        }
    }

    public void addDivision(int id, Integer parentId) {
        try (SqlSession session = factory.openSession()) {
            session.insert("tree.PathDivisionMapper.addDivision", new PathDivision(id, parentId));
            session.commit();
        }
    }

    public Integer getParentOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectOne("tree.PathDivisionMapper.getParentOf", new PathDivision(id, null));
        }
    }

    public List<Integer> getAncestorsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.PathDivisionMapper.getAncestorsOf", new PathDivision(id, null));
        }
    }

    public List<Integer> getChildrenOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.PathDivisionMapper.getChildrenOf", new PathDivision(id, null));
        }
    }

    public List<Integer> getDescendantsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.PathDivisionMapper.getDescendantsOf", new PathDivision(id, null));
        }
    }
}
