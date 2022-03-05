public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T [] items;

    /** Creates an empty array deque. */
    public ArrayDeque() {
        size=0;
        items = (T []) new Object[8];
        nextLast=nextFirst+1;
    }

    private void reSize(int factor) {
        T [] a = (T []) new Object[factor];
        if(nextFirst == 0) {
            System.arraycopy(items,nextFirst,a,0,size);
            items = a;
            nextLast = size;
        }
        else if(nextLast == items.length-1){
            System.arraycopy(items,0,a,0,size);
            items = a;
            nextFirst = items.length-1;
        }
        else {
            System.arraycopy(items,nextFirst,a,0,items.length-nextFirst);
            System.arraycopy(items,0,a,items.length-nextFirst,nextLast);
            nextFirst = 0;
            nextLast = items.length;
            items = a;
        }
    }

    /**Adds an item of type T to the front of the deque*/
    public void addFirst(T item) {
        size++;
        if (nextFirst == nextLast)
            reSize(size*2);
        items[nextFirst] = item;
        nextFirst--;
        if(nextFirst == -1)
            nextFirst = items.length-1;
    }

    /**Adds an item of type T to the back of the deque.*/
    public void addLast(T item) {
        size++;
        if (nextFirst == nextLast)
            reSize(size*2);
        items[nextLast] = item;
        nextLast++;
        if(nextLast == items.length)
            nextLast=0;
    }

    /**Returns true if deque is emp  ty, false otherwise*/
    public boolean isEmpty() {
        if(size == 0)
            return true;
        else
            return false;
    }

    /**Returns the number of items in the deque*/
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        for (int i = 1 ; i < size ; i++){
            if(nextFirst+i >= items.length)
                System.out.print(items[nextFirst+i-items.length]+" ");
            else
                System.out.print(items[nextFirst+i]+" ");
        }
        if(nextLast == 0)
            System.out.println(items[items.length-1]);
        else
            System.out.println(items[nextLast-1]);
    }

    /**Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public T removeFirst() {
        T temp;
        if (size == 0)
            return null;
        else {
            size--;
            if(nextFirst == items.length-1) {
                temp = items[0];
                items[0] = null;
                nextFirst = 0;
            }
            else {
                temp = items[nextFirst+1];
                items[nextFirst+1] = null;
                nextFirst++;
            }
            return temp;
        }
    }

    /**Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public T removeLast() {
        T temp;
        if (size == 0)
            return null;
        else {
            size--;
            if(nextLast == 0) {
                temp = items[items.length-1];
                items[items.length-1] = null;
                nextLast = items.length-1;
            }
            else {
                temp = items[nextLast-1];
                items[nextLast-1] = null;
                nextLast--;
            }
            return temp;
        }
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        if(index >= size)
            return null;
        else {
            if(nextFirst+index < items.length-1)
                return items[nextFirst+1+index];
            else
                return items[nextFirst+1+index-items.length];
       }
    }

}
