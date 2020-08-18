package DS;


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


    //addFirst
    public void addFirst(int data){
        Node new_node = new Node(data);
        new_node.next = first;
        first = new_node;
    }

    //addLast
    public void addLast(int data){
        Node new_node = new Node(data);

        if (first == null) {
            first = new_node;
            last = new_node;
            return;
        } else {
            last.next = new_node;
            last =new_node;
        }
    }

    //deleteFirst
    //deleteLast
    //contains
    //indexOf
}
