import java.util.Arrays;

public class MyStackArray_9_21 {
    private int top = 0;
    private String[] items;
    private final int DEFAULT_SIZE = 3;
    private int aSize = 0;
    public MyStackArray_9_21(){
        items = new String[DEFAULT_SIZE];
    }
    public int getSize(){
        //This is number of items actually on the list
        return top;
    }
    public int getUsedSize(){
        //This is the actual size of the backing array
        return items.length;
    }
    public void push (String newItem){
        if(top == items.length){
            System.out.printf("\n Uh oh, gotta make it bigger to hold item");
            IncreaseSize();
        }
        items[top++] = newItem;
        //++top is also a thing you can do, but it evaluates after adding instead of before
    }

    private void IncreaseSize() {
        int newSize = items.length*2;
        items = Arrays.copyOf(items, newSize);
    }

}
