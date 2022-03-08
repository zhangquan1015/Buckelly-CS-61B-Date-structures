import static org.junit.Assert.*;
import org.junit.Test;

public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }


    @Test
    public void test() {
        for (int i = 0,j = 0; i < 500; ++i, ++j) {
            if (Flik.isSameNumber(i, j)) {
                assertTrue(Flik.isSameNumber(i,j));
            }
        }
    }
}


