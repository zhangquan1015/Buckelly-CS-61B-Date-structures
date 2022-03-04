public class ArrayDeque<T>{
    int size;
    T[] items;
    /** Creates an empty array deque. */
    public ArrayDeque() {
        size=0;
        items=(T[])new Object[8];
    }
    /**Creates a deep copy of other. */
    public ArrayDeque(ArrayDeque other){

    }
    /**Change the length of items*/
    private void resizeFirst(int Factor){
        T[] a=(T[]) new Object[Factor];
        System.arraycopy(items,0,a,1,size);
        items=a;
    }
    private void resizeLast(int Factor){
        T[] a=(T[]) new Object[Factor];
        System.arraycopy(items,0,a,0,size);
        items=a;
    }
    /**Adds an item of type T to the front of the deque*/
    public void addFirst(T item){
        if(size==items.length){
            resizeFirst(size*2);
        }
        else
            resizeFirst(size);
        items[0]=item;
        size++;
    }

    /**Adds an item of type T to the back of the deque.*/
    public void addLast(T item){
        if(size==items.length){
            resizeLast(size*2);
        }
        items[size]=item;
        size++;
    }
    /**Returns true if deque is emp  ty, false otherwise*/
    public boolean isEmpty(){
        if(size==0) return true;
        else return false;
    }
    /**Returns the number of items in the deque*/
    public int size(){
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    public void printDeque(){
        for (int i=0;i<size-1;i++){
            System.out.print(items[i]);
        }
        System.out.println(items[size-1]);
    }
    private void resizeFirst2(int Factor){
        T[] a=(T[])new Object[Factor];
        System.arraycopy(items,1,a,0,size-1);
    }
    /**Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    public T removeFirst(){
        T temp;
        if(size==0) {
            return null;
        }
        else{
            temp=items[0];
            resizeFirst2(size*2);
        }
        size--;
        return temp;
    }
    /**Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    public T removeLast(){
        if(size==0) {
            return null;
        }
        else if(size<items.length/4&&items.length>=16){
            resizeLast(size*2);
        }
        T temp=items[size-1];
        items[size-1]=null;
        size--;
        return temp;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        if(index>=size)
            return null;
        else return items[index];
    }
}
