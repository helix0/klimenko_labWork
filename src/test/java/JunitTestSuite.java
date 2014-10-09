import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        RegistrationPageTest.class,
        Creation.class,
        Editing.class,
        Search.class,
        Remove.class
})
public class JunitTestSuite {
}
