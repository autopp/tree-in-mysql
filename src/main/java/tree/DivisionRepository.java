package tree;

import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;

public abstract class DivisionRepository {
    private final SqlSessionFactory factory;
    public DivisionRepository(SqlSessionFactory factory) {
        this.factory = factory;
    };

    public void addDivision(long id, String name, long parentId);
    public Division getParentOf(long id);
    public List<Division> getAncestorsOf(long id);
    public List<Division> getChildsOf(long id);
    public List<Division> getDescendantsOf(long id);
}
