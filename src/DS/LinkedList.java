package DS;


import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        public Node next;
        private int value;

        public Node(int value) {
            this.value = value;
            next = null;
        }

    }

    private Node first;
    private Node last;
    private int size;


    // to clean up code and increase readability
    private boolean isEmpty() {
        return first == null;
    }

    //addFirst
    public void addFirst(int data) {
        Node new_node = new Node(data);
        if (isEmpty()) first = last = new_node;
        else {
            new_node.next = first;
            first = new_node;
        }
        size++;
    }

    //addLast
    public void addLast(int data) {
        Node new_node = new Node(data);

        if (isEmpty())
            first = last = new_node;
        else {
            last.next = new_node;
            last = new_node;
        }
        size++;
    }

    public int indexOf(int data){
        int index = 0;
        Node current = first;
        while (current != null){
            if (current.value == data) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    //contains
    public boolean containsItem(int data){
        return indexOf(data) != -1;
    }

    //deleteFirst

    public void deleteFirst() {
        //[10] -> [20]-> [30]
//        if (first == null) {
//            return;
//        } else {
//            if (first == last) {
//                first = null;
//                last = null;
//            } else {
//                first = first.next;
//            }
//        }
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last){
            first = null;
            last = null;
            return;
        }

        //works for at least two items
        var second = first.next; //pointing to 20
        first.next = null; // removes the link between 10 and 20
        first = second; //set first to the second node
        size--;

    }
    //deleteLast
    public void removeLast(){
        //10 - > 20 - > 30
        //last - > 30
        //traverse the list and set last ->20

        //if list is empty
        if (isEmpty())
            throw new NoSuchElementException();

        //if there is only 1 element
        if (first == last){
            first = last = null;
            size = 0;
            return;
        }

        //previous -> 20
        //last - > 20
       var previous =  getPrevious(last);
       last = previous;
       last.next = null;
       size--;


    }

    private Node getPrevious(Node node){
        var current = first; // set  a current to first node
        while (current!=null){ // as long as current is not null, traverse the list
            if (current.next == node) return current; //
            current = current.next;// otherwise, set current to the next node. At this point, we have the last node
        }
        return null;
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        int[] array = new int [size];
        var current = first;
        var index = 0;
        while (current !=null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }


    public void reverse(){

        if (isEmpty())return;
        //initialize pointers
        Node previous = null;
        Node current = first;
        Node following = null;

        while (current !=null){
            following = following.next;
            current.next = previous;
            previous = current;
            current = following;
        }

        first = previous;

    }

    //find the kth node from the end of a linked list in one pass
    public int getKthFromTheEnd(int k){
        Node A = first;
        Node B = first;

        for (int i = 0; i < k-1; i++){
            B = B.next;
        }
        while (B!= last){
            A = A.next;
            B= B.next;
        }
        return A.value;
    }


}
