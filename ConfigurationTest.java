import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ConfigurationTest.
 *
 * @author  Kizuki Koyasu 
 * @version Ver.1
 */
public class ConfigurationTest
{
    /**
     * Default constructor for test class ConfigurationTest
     */
    public ConfigurationTest()
    {
        assertEquals("Test", "Test");

    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        assertEquals("Test", "Test");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        assertEquals("Test", "Test");
    }

    @Test
    // the simulation takes configuration from a file. 
    public void FileIntakeTest(){
        assertEquals("Test", "Test");
    }
}
