package tree;

import com.ninja_squad.dbsetup.DbSetup;

import static com.ninja_squad.dbsetup.Operations.*;

import com.ninja_squad.dbsetup.operation.Operation;

import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PathTreeRepositoryTest extends TreeRepositoryTestBase {
    @BeforeEach
    void setup() {
        Operation operation = sequenceOf(
            truncate("tree_path"),
            insertInto("tree_path").columns("id", "path")
                .values(1, "1/").values(2, "1/2/").values(3, "1/3/").values(4, "1/3/4/").values(5, "1/3/5/").build()
        );
        DbSetup dbSetup = new DbSetup(dest, operation);
        dbSetupTracker.launchIfNecessary(dbSetup);

        repository = new PathTreeRepository(factory);
    }
}
