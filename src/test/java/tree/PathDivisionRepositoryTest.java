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

class PathDivisionRepositoryTest extends DivisionRepositoryTestBase {
    @BeforeEach
    void setup() {
        Operation operation = sequenceOf(
            truncate("division_path"),
            insertInto("division_path").columns("id", "path")
                .values(1, "1/").values(2, "1/2/").values(3, "1/3/").values(4, "1/3/4/").values(5, "1/3/5/").build()
        );
        DbSetup dbSetup = new DbSetup(dest, operation);
        dbSetupTracker.launchIfNecessary(dbSetup);

        repository = new PathDivisionRepository(factory);
    }
}
