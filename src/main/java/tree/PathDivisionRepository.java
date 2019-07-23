package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.apache.ibatis.annotations.Insert;

public class PathDivisionRepository extends DivisionRepository {
    public PathDivisionRepository(SqlSessionFactory factory) {
        super(factory);
    }

    public static class PathDivision {
        public int id;
        public String path;

        public PathDivision(int id, String path) {
            this.id = id;
            this.path = path;
        }
    }

    public void addDivision(int id, Integer parentId) {
        try (SqlSession session = factory.openSession()) {
            String parentPath = parentId == null ? "" : session.selectOne("tree.PathDivisionMapper.getPathOf", parentId);
            session.insert("tree.PathDivisionMapper.addDivision", new PathDivision(id, parentPath + id + "/"));
            session.commit();
        }
    }

    public Integer getParentOf(int id) {
        try (SqlSession session = factory.openSession()) {
            throw new UnsupportedOperationException();
        }
    }

    public List<Integer> getAncestorsOf(int id) {
        throw new UnsupportedOperationException();
    }

    public List<Integer> getChildsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            throw new UnsupportedOperationException();
        }
    }

    public List<Integer> getDescendantsOf(int id) {
        throw new UnsupportedOperationException();
    }
}
