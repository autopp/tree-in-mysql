package tree;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.apache.ibatis.annotations.Insert;

public class NaiveDivisionRepository extends DivisionRepository {
    public NaiveDivisionRepository(SqlSessionFactory factory) {
        super(factory);
    }

    public class NaiveDivision {
        public long id;
        public String name;
        public long parentId;

        public NaiveDivision(long id, String name, long parentId) {
            this.id = id;
            this.name = name;
            this.parentId = parentId;
        }
    }

    public void addDivision(long id, String name, long parentId) {
        try (SqlSession session = factory.openSession()) {
            session.insert("tree.NaiveDivisionMapper.addDivision", new NaiveDivision(id, name, parentId));
        }
    }

    public Division getParentOf(long id) {
        throw new UnsupportedOperationException("not supported");
    }

    public List<Division> getAncestorsOf(long id) {
        throw new UnsupportedOperationException("not supported");
    }

    public List<Division> getChildsOf(long id) {
        throw new UnsupportedOperationException("not supported");
    }

    public List<Division> getDescendantsOf(long id) {
        throw new UnsupportedOperationException("not supported");
    }
}
