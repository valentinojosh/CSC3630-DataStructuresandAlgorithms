import java.util.ArrayList;
import java.util.Arrays;

public class InClass_AdjList_11_11_partb {
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
        int nNodes = 5;
        ArrayList<ArrayList<Integer>> myList2 = new ArrayList<>(nNodes);
        // Intialize all the rows
        for( int i=0; i<nNodes; i++ ){
            myList2.add( new ArrayList<>());
        }
        // write a method called addEdge
        // Row 0
        addEdge( myList2, 0, 1);
        addEdge( myList2, 0, 4);
        // Row 1
        addEdge( myList2, 1, 0);
        addEdge( myList2, 1, 2);
        addEdge( myList2, 1, 3);
        addEdge( myList2, 1, 4);

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
