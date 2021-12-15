import java.util.Stack;

public class InClass_9_21_Stack1 {
    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();
        myStack.push( "Apples");
        myStack.push( "Bananas");
        myStack.push( "Cherries");
        myStack.push( "Donuts");

        // return -1 if not there
        int pos = myStack.search( "Apples");
        System.out.printf("\n ----- Found it at :%s", pos);
        String item = myStack.get((pos-1));
        System.out.printf("\n ----- got :%s", item);

        String top = myStack.pop();
        int numb = 22;
        System.out.printf("\ntop1:%s and numb=%s ", top, numb);
        showItemsInALOrder( myStack, numb);
        System.out.printf("\nnumb still is %s ", numb);

        System.out.printf("\n MYSTACK size0: %s", myStack.size());
        showItemsInStackOrderUsingPeak( myStack);
        System.out.printf("\n MYSTACK size1: %s", myStack.size());

        showItemsInStackOrder( myStack);
        System.out.printf("\n MYSTACK size3: %s", myStack.size());
        if ( myStack.empty()) {
            System.out.printf("\n Its dead Jim");
        } else {
            System.out.printf("\n It has values ");

        }

    }

    private static void showItemsInStackOrderUsingPeak(Stack<String> myStack) {
        System.out.printf("\n ---Stack Order Using Peak---------------------");
        int size = myStack.size();
        for( int i=0; i<myStack.size(); i++) {
            System.out.printf("\n ct:%s item:%s", i, myStack.peek());
        }
    }

    private static void showItemsInStackOrder(Stack<String> myStack ) {
        System.out.printf("\n ---Stack Order---------------------");
        int size = myStack.size();
        for( int i=0; i<size; i++) {
            System.out.printf("\n ct:%s item:%s", i, myStack.pop());
        }
    }

    private static void showItemsInALOrder( Stack<String> myStack, int numb ) {
        numb = 0000;
        System.out.printf("\n ------------------------");
        int ct = 0;
        for( String fruit : myStack){
            System.out.printf("\n ct:%s item:%s", ct++, fruit);
        }
    }
}
