package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        public Integer parentId;

        public PathDivision(int id, Integer parentId) {
            this.id = id;
            this.parentId = parentId;
        }
    }

    public void addDivision(int id, Integer parentId) {
        try (SqlSession session = factory.openSession()) {
            // String parentPath = parentId == null ? "" : session.selectOne("tree.PathDivisionMapper.getPathOf", parentId);
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

    public List<Integer> getChildsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.PathDivisionMapper.getChildsOf", new PathDivision(id, null));
        }
    }

    public List<Integer> getDescendantsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.PathDivisionMapper.getDescendantsOf", new PathDivision(id, null));
        }
    }
}
