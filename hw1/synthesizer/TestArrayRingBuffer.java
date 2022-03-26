package synthesizer;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
       // arb.dequeue();
        assertEquals(10,arb.capacity());
        assertEquals(0,arb.fillCount());
        assertTrue(arb.isEmpty());
        assertFalse(arb.isFull());

        for (int i = 0; i < 4; i++) {
            arb.enqueue(i);
        }
        assertEquals(0,arb.peek());
        assertEquals(4,arb.fillCount());
        arb.dequeue();
        //assertEquals(1,arb.peek());
        assertEquals(3,arb.fillCount());
        assertEquals(1,arb.peek());

        for (int i = 0; i < 7; i++) {
            arb.enqueue(i+4);
        }
        assertTrue(arb.isFull());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
