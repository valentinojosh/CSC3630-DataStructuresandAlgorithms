import java.util.ArrayList;

public class InClass_AdjList_11_16_partb {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> myList = new ArrayList<>();
        ArrayList<Integer> row0 = new ArrayList<>();
        row0.add( 1 );
        row0.add( 4 );
        myList.add( row0 );
       // Row 1
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add( 0 );
        row1.add( 2 );
        row1.add( 3 );
        row1.add( 4 );
        myList.add( row1 );
        // Row 2
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add( 1 );
        row2.add( 3 );
        myList.add( row2 );
        // Row 3
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add( 1 );
        row3.add( 2 );
        row3.add( 4 );
        myList.add( row3 );
        // Row 4
        ArrayList<Integer> row4 = new ArrayList<>();
        row4.add( 0 );
        row4.add( 1 );
        row4.add( 3 );
        myList.add( row4 );
        showMeTheLists( myList );
        // --- Do it again but be more eligant
        int nNodes = 6;
        ArrayList<ArrayList<Integer>> myList2 = new ArrayList<>(nNodes);
        // Intialize all the rows
        for( int i=0; i<nNodes; i++ ){
            myList2.add( new ArrayList<>());
        }
        // write a method called addEdge
        // Row 0
        int node = 0;
        // Since java allows array and arraylist to change by a method
        //     that change will impact the global method or the scope is impacted globably
        //     Primitive data types (e.g., int) are passed by value ... and that does NOT
        //      impact it parent method
        addEdge( myList2, node, 1);
        //System.out.printf("\n NOde:%s", node);
        //showMeTheLists( myList2 );
        //System.exit(1);
        addEdge( myList2, 0, 4);
        // Row 1
        addEdge( myList2, 1, 0);
        addEdge( myList2, 1, 2);
        addEdge( myList2, 1, 3);
        addEdge( myList2, 1, 4);
        // ---------------------
        // Row 2
        addEdge( myList2, 2, 1);
        addEdge( myList2, 2, 3);
        // Row 3
        addEdge( myList2, 3, 1);
        addEdge( myList2, 3, 2);
        addEdge( myList2, 3, 4);
        addEdge( myList2, 3, 5);
        // Row 4
        addEdge( myList2, 4, 0);
        addEdge( myList2, 4, 1);
        addEdge( myList2, 4, 3);
        // Row 5
        addEdge( myList2, 5, 3);

        System.out.printf("\n -----------------------------------------");
        showMeTheLists( myList2 );
        System.out.printf("\n -----NEXT-------------------------------");
        //
        showMeThisNode( myList2,2 );
        System.out.printf("\n -----And Now node 4--------------");
        showMeThisNode( myList2,4 );

        show2Away( myList2,0 );

        System.out.printf("\n -----2 away from 5-------------");
        show2Away( myList2,5 );


        System.out.printf("\n -----And Now A Directed Graph ---");
        int nNodes2 = 6;
        ArrayList<ArrayList<Integer>> myDirGraph = new ArrayList<>(nNodes2);
        // Intialize all the rows
        for( int i=0; i<nNodes2; i++ ){
            myDirGraph.add( new ArrayList<>());
        }
        // ROw 0
        addEdge( myDirGraph, 0, 1);
        addEdge( myDirGraph, 0, 4);
        // Row 1
        addEdge( myDirGraph, 1, 2);
        addEdge( myDirGraph, 1, 4);
        // ---------------------
        // Row 2
        // Row 3
        addEdge( myDirGraph, 3, 1);
        addEdge( myDirGraph, 3, 2);
        addEdge( myDirGraph, 3, 5);
        // Row 4
        addEdge( myDirGraph, 4, 3);
        // Row 5
        showMeTheLists( myDirGraph);
        show2Away( myDirGraph,1 );

        show2Away( myDirGraph,0 );

    }

    private static void show2Away(ArrayList<ArrayList<Integer>> myList2, int i) {
        ArrayList<Integer> theRow = myList2.get(i);
        for( Integer item : theRow) {
            ArrayList<Integer> the2Row = myList2.get(item);
            for( Integer item2 : the2Row) {
                System.out.printf("\n Second Connection for node:%s is item:%s", i, item2);
            }
        }
    }

    private static void showMeThisNode(ArrayList<ArrayList<Integer>> myList2, int i) {
        //ToDo: Output just the contents of node i
        ArrayList<Integer> row = myList2.get(i);
        System.out.printf("\n Row:%s", i );
        for( Integer item : row) {
            System.out.printf(" i:%s ", item);
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> myList2, int node, int item) {
        myList2.get(node).add(item);
    }

    private static void showMeTheLists(ArrayList<ArrayList<Integer>> myList) {
        int ct = 0;
        for( ArrayList<Integer> row : myList ){
            System.out.printf("\n Row:%s", ct++ );
            for( Integer i : row) {
                System.out.printf(" i:%s ", i);
            }
        }
    }
}
