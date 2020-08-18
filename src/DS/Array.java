package DS;

public class Array {
    private int[] items;
    private int count;

    public Array (int length){
        items = new int[length];
    }

    public void insert(int item){
        // if array is full, resize it
        if (items.length == count){
            //create a new array (twice the size)
            int [] newItems = new int[count * 2];
            //copy all the existing items
            for (int i = 0 ; i < count; i++){
                newItems[i] = items[i];
            }
            // items to this new array
            items = newItems;
        }

        //add the new item at the end
//        items[count]  = item;
//        count++;
        items[count++] = item;
    }

    public int indexOf(int item){
        //if we find it, return index
        //otherwise, return -1

        for (int i = 0; i < count; i++){
            if(items[i]==item){
                return i;
            }
        }
        return -1;
    }

    public void removeAt(int index){
        //validate the index
        if (index < 0 || index >= count) // count = 4, index = 3
            throw new IllegalArgumentException();

        //shift the items to the left to fill the hole
        //[10,20,30,40] remove index 1 (20)
        //to remove, you shift each element to the left
        for (int i = index; i < count; i++)
            items [i] = items [i+1];
            //[10,30,40,40]
            count--;
    }
    public void print(){
        for (int i = 0; i < count; i++){
            System.out.println(items[i]);
        }
    }
}
