package tree;

import com.ninja_squad.dbsetup.DbSetup;

import static com.ninja_squad.dbsetup.Operations.*;

import com.ninja_squad.dbsetup.operation.Operation;

import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class NaiveTreeRepositoryTest extends TreeRepositoryTestBase {
    @BeforeEach
    void setup() {
        Operation operation = sequenceOf(
            truncate("tree_naive"),
            insertInto("tree_naive").columns("id", "parent_id")
                .values(1, null).values(2, 1).values(3, 1).values(4, 3).values(5, 3).build()
        );
        DbSetup dbSetup = new DbSetup(dest, operation);
        dbSetupTracker.launchIfNecessary(dbSetup);

        repository = new NaiveTreeRepository(factory);
    }
}
