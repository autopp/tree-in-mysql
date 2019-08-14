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

public class ClosureDivisionRepository extends DivisionRepository {
    public ClosureDivisionRepository(SqlSessionFactory factory) {
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
            session.insert("tree.ClosureDivisionMapper.addDivision", id);
            session.insert("tree.ClosureDivisionMapper.addDivisionPath", new Division(id, parentId));
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
            throw new UnsupportedOperationException();
        }
    }

    public List<Integer> getDescendantsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("tree.ClosureDivisionMapper.getDescendantsOf", id);
        }
    }
}
