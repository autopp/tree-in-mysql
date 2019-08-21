package tree;

import com.ninja_squad.dbsetup.DbSetup;

import static com.ninja_squad.dbsetup.Operations.*;

import com.ninja_squad.dbsetup.operation.Operation;

import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ClosureTreeRepositoryTest extends TreeRepositoryTestBase {
    @BeforeEach
    void setup() {
        Operation operation = sequenceOf(
            deleteAllFrom("tree_closure_path", "tree_closure"),
            insertInto("tree_closure").columns("id", "depth")
                .values(1, 1).values(2, 2).values(3, 2).values(4, 3).values(5, 3).build(),
            insertInto("tree_closure_path").columns("ancestor", "descendant")
                .values(1, 1).values(1, 2).values(2, 2).values(1, 3).values(3, 3)
                .values(1, 4).values(3, 4).values(4, 4).values(1, 5).values(3, 5).values(5, 5).build()
        );

        DbSetup dbSetup = new DbSetup(dest, operation);
        dbSetupTracker.launchIfNecessary(dbSetup);

        repository = new ClosureTreeRepository(factory);
    }
}
