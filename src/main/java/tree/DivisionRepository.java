package tree;

import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;

public abstract class DivisionRepository {
    protected SqlSessionFactory factory;
    public DivisionRepository(SqlSessionFactory factory) {
        this.factory = factory;
    };

    abstract public void addDivision(long id, String name, Long parentId);
    abstract public Division getParentOf(long id);
    abstract public List<Division> getAncestorsOf(long id);
    abstract public List<Division> getChildsOf(long id);
    abstract public List<Division> getDescendantsOf(long id);
}
