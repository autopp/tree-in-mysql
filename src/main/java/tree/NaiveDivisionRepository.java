package tree;

import java.util.List;

public class NaiveDivisionRepository {
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
        throw new UnsupportedOperationException("not supported");
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
