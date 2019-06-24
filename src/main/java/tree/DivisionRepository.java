package tree;

import java.util.List;

public interface DivisionRepository {
    public void addDivision(long id, String name, long parentId);
    public Division getParentOf(long id);
    public List<Division> getAncestorsOf(long id);
    public List<Division> getChildsOf(long id);
    public List<Division> getDescendantsOf(long id);
}
