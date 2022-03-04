public class LinkedListDeque<T> {

    private class IntNode {
        public IntNode prev;
        public T item;
        public IntNode next;

        public IntNode(IntNode m,T i, IntNode n) {
            prev = m;
            item = i;
            next = n;
        }
    }
    // two sentinel topology
    private IntNode sentFront;
    private IntNode sentBack;
    private int size;

    //Adds an item of type T to the front of the deque
    public void addFirst(T item) {
        IntNode temp = new IntNode(sentFront,item,sentFront.next);
        sentFront.next.prev=temp;
        sentFront.next = temp;
        size++;
    }
    //Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        IntNode temp = new IntNode(sentBack.prev,item,sentBack);
        sentBack.prev.next=temp;
        sentBack.prev = temp;
        size++;
    }
    //Returns true if deque is empty, false otherwise
    public boolean isEmpty() {
        if(size==0)
            return true;
        else
            return false;
    }
    //Returns the number of items in the deque
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
      */
    public void printDeque() {
        if(size==0)
            System.out.println();
        else {
            IntNode pr=new IntNode(null,null,sentFront.next);
        for (int i=0;i<size-1;i++) {
            System.out.print(pr.next.item+" ");
            pr=pr.next;
        }
        System.out.println(sentBack.prev.item);
        }
    }
    //Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst() {
        if(size==0)
            return null;
        else {
            size--;
            IntNode temp=new IntNode(sentFront,sentFront.next.item,sentFront.next.next);
            sentFront.next=temp.next;
            temp.next.prev=sentFront;
            return temp.item;
        }
    }
    //Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast() {
        if(size==0) return null;
        else {
            size--;
            IntNode temp=new IntNode(sentBack.prev.prev,sentBack.prev.item,sentBack);
            sentBack.prev=temp.prev;
            temp.prev.next=sentBack;
            return temp.item;
        }
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
      */
    public T get(int index) {
        IntNode temp;
        if(index>=size) return null;
        else if(index<size/2) {
            temp=new IntNode(sentFront,sentFront.next.item, sentFront.next.next);
            for (int i=0;i<index;i++) {
                temp=temp.next;
            }
        }
        else{
            temp=new IntNode(sentBack.prev.prev,sentBack.prev.item, sentBack);
            for (int i=size;i>index+1;i--) {
                temp = temp.prev;
            }
        }
        return temp.item;
    }
    /**Creates an empty linked list deque*/
    public LinkedListDeque() {
        size=0;
        sentFront=new IntNode(null,null,null);
        sentBack=new IntNode(sentFront,null,null);
        sentFront.next=sentBack;
    }
    /**Creates a deep copy of other*/
    public LinkedListDeque(LinkedListDeque other) {
        size=0;
        sentFront=new IntNode(null,null,null);
        sentBack=new IntNode(sentFront,null,null);
        sentFront.next=sentBack;

        for (int i=0;i<other.size;i++) {
            addLast((T)other.get(i));
        }
    }

    /**Same as get, but uses recursion.*/
    public T getRecursive(int index) {
        if (index >=size) {
            return null;
        }
        else
            return getRecursive(0,index,sentFront.next);
    }
    private T getRecursive(int pos,int index,IntNode x) {
        if(pos==index){
            return x.item;
        }
        else
            return getRecursive(pos+1,index,x.next);
    }
}