public class Palindrome {
    /**Given a String, wordToDeque should return a Deque where the characters appear in the same order as in the String.
     *  For example, if the word is “persiflage”, then the returned Deque should have ‘p’ at the front, followed by ‘e’, and so forth.*/
    public Deque<Character> wordToDeque(String word){
        Deque<Character> deque = new ArrayDeque<>();
        int len = word.length();
        char c;
        for (int i = 0;i < len;i++) {
            c = word.charAt(i);
            deque.addLast(c);
        }
        return deque;
    }
}
