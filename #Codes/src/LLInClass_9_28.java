public class LLInClass_9_28 {
    public static void main(String[] args) {
        Node_9_28 n1 = new Node_9_28("Apple");

        Node_9_28 n2 = new Node_9_28("Bananas");
        n1.next = n2;

        Node_9_28 n3 = new Node_9_28("Cakes");
        n2.next = n3;

        showMeTheList( n1 );
        // Return the link number in the chain
        //  or -1 if not found
        int thePlace = isItInThere(n1, "Cakes");
        System.out.printf("\n FL1: Rerturn:%s", thePlace);

        thePlace = isItInThere(n1, "Pizza");
        System.out.printf("\n FL2: Rerturn:%s", thePlace);
        Node_9_28 head = addItemToFront( n1, "Pizza");
        System.out.printf("\n-------------------------");
        showMeTheList( head );
        head = addItemBefore( head, 2, "Eggs" );
        System.out.printf("\n-------------------------");
        showMeTheList( head );

    }

    private static Node_9_28 addItemBefore(Node_9_28 head, int theSpot, String item) {
        Node_9_28 newNode = new Node_9_28(item);
        Node_9_28 prevNode;
        if ( theSpot == 0){
            head = addItemToFront( head, item);
        } else {
            // Not the first item
            int ct = 0;
            Node_9_28 theNode = head;
            while (theNode != null) {
                prevNode = theNode;
                if ( ct == theSpot) {
                    // Put it here
                    System.out.printf("\n SPOT:%s", ct);
                    newNode.next = theNode;
                    prevNode.next = newNode;

                }
                theNode = theNode.next;
                ct++;
            }
        }
        return head;
    }

    private static Node_9_28 addItemToFront(Node_9_28 head, String item) {
        Node_9_28 newNode = new Node_9_28(item);
        newNode.next = head;
        return newNode;
    }


    private static int isItInThere(Node_9_28 head, String target) {
        //---
        Node_9_28 theNode = head;
        int ct = 0;
        while ( theNode != null) {
            if ( theNode.value.equals( target )) {
                return ct;
            }
            ct++;
            theNode = theNode.next;
        }
        //---
        return -1;
    }

    private static void showMeTheList(Node_9_28 head) {
        Node_9_28 theNode = head;
        int ct = 0;
        while ( theNode != null) {
            System.out.printf("\n Ct:%s NodeVal:%s", ct, theNode.value);
            ct++;
            theNode = theNode.next;
        }
    }
}
