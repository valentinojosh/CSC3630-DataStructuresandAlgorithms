import java.util.Stack;

public class InClass_9_21_Stack {
    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();
        myStack.push("Apples");
        myStack.push("Banana");
        myStack.push("Cherries");
        myStack.push("Donuts");

        int pos = myStack.search("Cherries");
        System.out.printf("\n Found it at: %s", pos);

        String top = myStack.pop();
        System.out.printf("\nTop: %s", top);

        showItemsInALOrder(myStack);

        int example = 50;

        showItemsInStackOrderUsingPeak(myStack, example);

        showItemsInStackOrder(myStack);


        //NOTICE HOW THIS FUNCTION PRINTS NOTHING
        //In java the parent array that is passed through a function
        //is changed. this is only true with arrays, holds true with stacks
        System.out.printf("\nEx b4: %s", example);
        showItemsInStackOrderUsingPeak(myStack, example);
        System.out.printf("\nEx after: %s", example);
        //NOTICE HOW THE INTEGER IS UNCHANGED BUT THE STACK IS

        if ( myStack.empty()) {
            System.out.printf("\n Its dead Jim");
        } else {
            System.out.printf("\n It has values ");

        }

    }

    private static void showItemsInStackOrderUsingPeak(Stack<String> myStack, int example) {
        example = 9999;
        System.out.printf("\n---------------Stack Order Using Peak---------------");
        int size = myStack.size();
        for(int i =0; i < size; i++){
            System.out.printf("\nct: %s Item: %s", i, myStack.peek());
        }
    }

    private static void showItemsInStackOrder(Stack<String> myStack) {
        System.out.printf("\n---------------Stack Order---------------");
        int size = myStack.size();
        for(int i =0; i < size; i++){
            System.out.printf("\nct: %s Item: %s", i, myStack.pop());
        }
    }

    private static void showItemsInALOrder(Stack<String> myStack) {
        System.out.printf("\n---------------Array List Order---------------");
        int ct = 0;
        for(String fruit : myStack){
            System.out.printf("\nct: %s Item: %s", ct++, fruit);
        }
    }
}
