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

    public void addDivision(int id, Integer parentId) {
        try (SqlSession session = factory.openSession()) {
            throw new UnsupportedOperationException();
        }
    }

    public Integer getParentOf(int id) {
        try (SqlSession session = factory.openSession()) {
            throw new UnsupportedOperationException();
        }
    }

    public List<Integer> getAncestorsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            throw new UnsupportedOperationException();
        }
    }

    public List<Integer> getChildsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            throw new UnsupportedOperationException();
        }
    }

    public List<Integer> getDescendantsOf(int id) {
        try (SqlSession session = factory.openSession()) {
            throw new UnsupportedOperationException();
        }
    }
}
