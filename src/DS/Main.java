package DS;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Array array = new Array(3);
//        array.insert(10);
//        array.insert(20);
//        array.insert(30);
//        array.insert(40);
////        array.removeAt(1);
////        System.out.println(array.indexOf(100));
////        array.print();
//
//        //vector class: will grow 100% of its size - synchronized.
//        //arraylist : will grow 50% of its size
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(10);
//        list.add(20);
//        list.add(30);
//        list.toArray();
//        System.out.println(list);


        //linkedList ===========================================================================================

        LinkedList list = new LinkedList();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        System.out.println(list.getKthFromTheEnd(2));

//        System.out.println(list.size());
        var array = list.toArray();
        System.out.println(Arrays.toString(array));


//        list.removeLast();
//        System.out.println(list.size());

//        System.out.println(list.indexOf(20));
//        System.out.println(list.containsItem(40));



    }
}
