package tree;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.Operations;
import static com.ninja_squad.dbsetup.Operations.*;
import com.ninja_squad.dbsetup.destination.Destination;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class NaiveDivisionRepositoryTest extends DivisionRepositoryTestBase {
    @BeforeEach
    void setup() {
        Operation operation = sequenceOf(
            truncate("tree_naive"),
            insertInto("tree_naive").columns("id", "parent_id")
                .values(1, null).values(2, 1).values(3, 1).values(4, 3).values(5, 3).build()
        );
        DbSetup dbSetup = new DbSetup(dest, operation);
        dbSetupTracker.launchIfNecessary(dbSetup);

        repository = new NaiveDivisionRepository(factory);
    }
}
