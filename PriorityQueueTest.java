
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PriorityQueueTest.
 *
 * @author  Kizuki Koyasu
 * @version Ver.1
 */
public class PriorityQueueTest
{
    PriorityQueue<Integer> pq;
    /**
     * Default constructor for test class PriorityQueueTest
     */
    public PriorityQueueTest()
    {
        pq = new PriorityQueue<Integer>();
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
    public void addTest(){
        assertEquals(12, pq.add(12));
        pq.add(1000);
        assertEquals(4649, pq.add(4649));
    }

    @Test
    public void peekTest(){
        pq.add(0);
        assertEquals(0, pq.peek());
        pq.add(500);
        pq.add(10);
        assertEquals(500, pq.peek());
        pq.remove();
        assertEquals(10,pq.peek());
    }
    
    @Test
    public void removeTest(){
        pq.add(0);
        pq.add(100);
        pq.add(50);
        pq.remove();
        assertEquals(50, pq.peek());
        pq.remove();
        pq.remove();
        assertEquals(null, pq.remove());
    }
    
    @Test
    public void sizeTest(){
        assertEquals(0, pq.size());
        pq.add(0);
        assertEquals(1, pq.size());
        pq.add(0);
        assertEquals(2, pq.size());
    }
}
