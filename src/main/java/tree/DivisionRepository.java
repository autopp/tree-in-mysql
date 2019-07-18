package tree;

import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;

public abstract class DivisionRepository {
    protected SqlSessionFactory factory;
    public DivisionRepository(SqlSessionFactory factory) {
        this.factory = factory;
    };

    abstract public void addDivision(int id, Integer parentId);
    abstract public Integer getParentOf(int id);
    abstract public List<Integer> getAncestorsOf(int id);
    abstract public List<Integer> getChildsOf(int id);
    abstract public List<Integer> getDescendantsOf(int id);
}
