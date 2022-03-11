import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String [] testTrue = {"racecar","a","noon","","aa"};
        String [] testFalse = {"asdw","hores","Aa","aaaab"};
        for (String s1 : testTrue) {
            assertTrue(palindrome.isPalindrome(s1));
        }
        for (String s2 : testFalse) {
            assertFalse(palindrome.isPalindrome(s2));
        }

        OffByOne obo = new OffByOne();
        String [] testTure2 = {"ab","ba","AcB","arb","falbe","flake","*"};
        String [] testFalse2 = {"asdw","hores","Aa","aaaab"};
        for (String s1 : testTure2) {
            assertTrue(palindrome.isPalindrome(s1,obo));
        }
        for (String s2 : testFalse2) {
            assertFalse(palindrome.isPalindrome(s2,obo));
        }
    }
}
