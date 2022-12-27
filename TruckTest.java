
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TruckTest.
 *
 * @author  Kizuki Koyasu 
 * @version Ver.1 
 */
public class TruckTest
{
    /**
     * Default constructor for test class TruckTest
     */
    public TruckTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test 
    // movement of truck
    public void moveTest() {
        assertEquals("Test", "Test");
    }

    @Test
    // @Return returns to miles that truck has driven. 
    public void getMilesTest(){
        assertEquals("Test", "Test");
    }

    @Test
    // Return the value of x-coordinate.
    public void getXTest(){
        assertEquals("Test", "Test");
    }

    @Test
    //@Return the value of y-coordinate.
    public void getYTest(){
        assertEquals("Test", "Test");
    }

    @Test
    //@Return true if the delivery is done. 
    // method to check when the delivery is done.
    public void doneTest(){
        assertEquals("Test", "Test");
    }

    @Test
    // waiting method if all docs are taken by other trucks.
    public void waitingTest(){
        assertEquals("Test", "Test");
    }

    @Test
    // load shipments form docs. 
    public void loadTest(){
        assertEquals("Test", "Test");
    }

    @Test
    // unload shipments from docs 
    public void unloadTest(){
        assertEquals("Test", "Test");

    }

    @Test
    // @return true if truck is done delivering, if not it returns false
    public void emptyTest(){
        assertEquals("Test", "Test");
    }

    @Test
    // @return to see which warehouse to prioritize. 
    // TODO: probably use distance formula or some sort to see which one is closer
    public void compareToTest(){
        assertEquals("Test", "Test");
    }

    @Test
    // get the number of trucks from configuration
    //TODO: This may be done through constructors. 
    public void getTrcukNumTest(){
        assertEquals("Test", "Test");
    }
}
