import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {

    @Test
    public void testDeque(){

        StudentArrayDeque<Integer> studentDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solutionDeque = new ArrayDequeSolution<>();
        StringBuilder message = new StringBuilder();
        message.append("\n");

        while(true) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            int numberInDeque = StdRandom.uniform(9);
            if (numberBetweenZeroAndOne <= 0.3) {
                studentDeque.addFirst(numberInDeque);
                solutionDeque.addFirst(numberInDeque);
                message.append("addFirst(" + numberInDeque + ")\n");
            }
            else if (numberBetweenZeroAndOne <= 0.6) {
                studentDeque.addLast(numberInDeque);
                solutionDeque.addLast(numberInDeque);
                message.append("addLast(" + numberInDeque + ")\n");
            }
            else if (numberBetweenZeroAndOne < 0.8 && solutionDeque.size() != 0) {
                Integer expected = solutionDeque.removeFirst();
                Integer actual = studentDeque.removeFirst();
                message.append("removeFirst()\n");
                assertEquals(message.toString(), expected, actual);
            }
            else if(solutionDeque.size() != 0) {
                Integer expected = solutionDeque.removeLast();
                Integer actual = studentDeque.removeLast();
                message.append("removeLast()\n");
                assertEquals(message.toString(), expected, actual);
            }
        }


    }
}
