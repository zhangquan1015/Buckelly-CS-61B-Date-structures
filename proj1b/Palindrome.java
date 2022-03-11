public class Palindrome {

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
    /**
     * //Do not use recursion
    public boolean isPalindrome(String word) {
        int len = word.length();
        Deque<Character> deque = new ArrayDeque<>();
        if (len <= 1)
            return true;
        else {
           deque =  wordToDeque(word);
        }
        while (!(deque.size() == 1 || deque.size() == 0)){
            if (deque.removeFirst() != deque.removeLast())
                return false;
        }
        return true;
    }*/

    /**use recursion*/
    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeRecursion(deque);
    }
    private boolean isPalindromeRecursion(Deque<Character> deque) {
        if (deque.size() <= 1)
            return true;
        else if(deque.removeFirst() != deque.removeLast())
            return false;
        else
            return isPalindromeRecursion(deque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeRecursion2(deque,cc);
    }

    private boolean isPalindromeRecursion2(Deque<Character> deque,CharacterComparator cc) {
        if (deque.size() <= 1)
            return true;
        else if(!cc.equalChars(deque.removeFirst(),deque.removeLast()))
            return false;
        else
            return isPalindromeRecursion2(deque,cc);
    }
}
