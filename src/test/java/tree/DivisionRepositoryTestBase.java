package tree;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.Destination;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Disabled
abstract class DivisionRepositoryTestBase {
    private static final String URL = "jdbc:mysql://localhost/test?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    protected static Destination dest;

    protected static final DbSetupTracker dbSetupTracker = new DbSetupTracker();
    protected static SqlSessionFactory factory;
    protected DivisionRepository repository;

    @BeforeAll
    static void setupOnce() {
        InputStream in = Main.class.getResourceAsStream("/mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        dest = new DriverManagerDestination(URL, USER, PASSWORD);
    }

    /**
     * Create data set
     * 1-+-2
     *   |
     *   +-3-4
     *     |
     *     +-5
    */
    abstract void setup();

    @Test
    void getParentOf() {
        dbSetupTracker.skipNextLaunch();
        assertThat(repository.getParentOf(1), is(nullValue()));
        assertThat(repository.getParentOf(2), is(Integer.valueOf(1)));
    }

    @Test
    void getAncestorsOf() {
        dbSetupTracker.skipNextLaunch();
        assertThat(repository.getAncestorsOf(1), is(empty()));
        assertThat(repository.getAncestorsOf(2), is(containsInAnyOrder(1)));
        assertThat(repository.getAncestorsOf(5), is(containsInAnyOrder(3, 1)));
    }

    @Test
    void getChildrenOf() {
        dbSetupTracker.skipNextLaunch();
        assertThat(repository.getChildrenOf(1), is(contains(2, 3)));
        assertThat(repository.getChildrenOf(2), is(empty()));
    }

    @Test
    void getDescendantsOf() {
        dbSetupTracker.skipNextLaunch();
        assertThat(repository.getDescendantsOf(1), is(containsInAnyOrder(2, 3, 4, 5)));
        assertThat(repository.getDescendantsOf(2), is(empty()));
    }

    @Test
    void addDivision() {
        repository.addDivision(6, 1);
        assertThat(repository.getChildrenOf(1), is(contains(2, 3, 6)));
    }
}
