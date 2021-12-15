import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class command_9_23_Driver {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Deque<command_9_23> myStack = new ArrayDeque<>();
        while (true) {
            String uInput = getCommand();
            String uInputArg = getCommandArg();
            System.out.printf("\n I1: %s I2: %s", uInput, uInputArg);
            if (uInput.equals("Show")){
                System.out.printf("\n OK Doing show of: %s",uInputArg);
                myStack.push( new command_9_23(uInput, uInputArg));
            }
        }
    }

    private static String getCommandArg() {
        String ret = "";
        Scanner s = new Scanner(System.in);
        System.out.printf("\n Enter Command Arguments");
        ret = s.next();
        return ret;
    }

    private static String getCommand() {
        String ret = "";
        Scanner s = new Scanner(System.in);
        System.out.printf("\n Enter Command: Add, Delete, Show, Undo");
        ret = s.next();
        return ret;
    }
}
