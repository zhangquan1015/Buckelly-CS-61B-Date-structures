import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByN = new OffByN(1);

    // Your tests go here.
    @Test
    public void testEqualChars() {
        OffByN obn = new OffByN(5);

        assertTrue(obn.equalChars('a', 'f'));
        assertTrue(obn.equalChars('f', 'a'));
        assertFalse(obn.equalChars('h', 'g'));
        assertFalse(obn.equalChars('z', 's'));
        assertFalse(obn.equalChars('a', 'k'));
    }
}
