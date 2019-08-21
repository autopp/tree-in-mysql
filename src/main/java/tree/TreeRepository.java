package tree;

import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;

public abstract class TreeRepository {
    protected SqlSessionFactory factory;
    public TreeRepository(SqlSessionFactory factory) {
        this.factory = factory;
    };

    abstract public void addDivision(int id, Integer parentId);
    abstract public Integer getParentOf(int id);
    abstract public List<Integer> getAncestorsOf(int id);
    abstract public List<Integer> getChildrenOf(int id);
    abstract public List<Integer> getDescendantsOf(int id);
}
