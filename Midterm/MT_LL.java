import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MT_LL {
    public static void main(String[] args) {
        NodeMT n = new NodeMT("Astros", 95, 67);

        NodeMT n2 = new NodeMT("Rays", 100, 62);
        n.next = n2;

        NodeMT n3 = new NodeMT( "Red Sox", 92, 70);
        n2.next = n3;
        NodeMT n4 = new NodeMT( "White Sox", 93, 69);
        n3.next = n4;

        System.out.printf("\n ------- Flag1: Starting List 1");
        //ToDo: 1. Write this method
        showMeTheNodeMTs( n );

        //ToDo: 2. Write a method that outputs the LL in reversed Order
        System.out.printf("\n ------- Flag2: Reverse Order of LL ");
        showMeTheListInReverseOder(n);

        //ToDo: 3 Write a method that removes the last item from the LL
        NodeMT newHead = removeLast( n );
        System.out.printf("\n ------- Flag3: Showing list with Last Removed --- ");
        showMeTheNodeMTs( newHead );

        // Part 2 - Make sure it works properly for a Linked list with 1 element
        //    --- if you properly implemented it there may be nothing to do here
        System.out.printf("\n --- ---- PART 2 Astros Only---------------");
        NodeMT shortN = new NodeMT("Astros", 95, 67);
        showMeTheNodeMTs( shortN );

        NodeMT newHead2 = removeLast( shortN );
        System.out.printf("\n --- Flag4: Short List Remove 1");
        showMeTheNodeMTs( newHead2 );


    }

    private static void showMeTheListInReverseOder(NodeMT head) {
        //Todo: - write this method that will output the LL in reversed order
        // First explain your algorithm
        // Step1 - Check to see if there is only one node
        // Step2 - If more than one node, add all nodes into an ArrayList
        // Step3 - Print out ArrayList in reverse order using a for loop

        if(head.next == null){
            int ct1 = 1;
            System.out.printf("\nct:%s Team:%s: Wins:%s Loss:%s", ct1, head.team, head.wins, head.loss);
        }
        else{
            NodeMT theNode = head;
            ArrayList<NodeMT> reverseOrder = new ArrayList<>();
            int ct = 1;
            while ( theNode != null) {
                reverseOrder.add(theNode);
                theNode = theNode.next;
            }
            for(int i = reverseOrder.size()-1; i >= 0; i--){
                System.out.printf("\nct:%s Team:%s: Wins:%s Loss:%s", (i+1), reverseOrder.get(i).team, reverseOrder.get(i).wins, reverseOrder.get(i).loss);
            }
        }
    }

    private static NodeMT  removeLast( NodeMT head) {
        NodeMT n = head;
        //Todo: - write method that will removes the last node of LL
        //        and returns the new LL
        // First explain your algorithm
        // Step1 -Check if first or second node are null
        // Step2 -Find second to last node
        // Step3 -Remove last node

        if(n == null || n.next == null) {
            return null;
        }
        while(n.next.next != null) {
            n = n.next;
        }
        n.next = null;

        return head;
    }
    private static void showMeTheNodeMTs( NodeMT head) {
        //Todo: - write method that will output all of the nodes in the original order
        // First explain your algorithm
        // Step1 - Check to see if there is only one node
        // Step2 - Print out each node in order using a while loop

        if(head == null){
            System.out.printf("\nNo nodes");
        }
        else if(head.next == null){
            int ct1 = 1;
            System.out.printf("\nct:%s Team:%s: Wins:%s Loss:%s", ct1, head.team, head.wins, head.loss);
        }
        else{
            NodeMT theNode = head;
            int ct = 1;
            while ( theNode != null) {
                System.out.printf("\nct:%s Team:%s: Wins:%s Loss:%s", ct, theNode.team, theNode.wins, theNode.loss);
                ct++;
                theNode = theNode.next;
            }
        }

    }
}
