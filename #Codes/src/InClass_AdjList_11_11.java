import java.util.ArrayList;
import java.util.Arrays;

public class InClass_AdjList_11_11 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> myList = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add( 5 );
        row1.add( 10 );
        row1.add( 15 );
        myList.add( row1 );

        ArrayList<Integer> row2 = new ArrayList<>(
                Arrays.asList( 25, 35, 99, 100));
        //ArrayList<String> gfg = new ArrayList<String>(
                //Arrays.asList("Geeks",
                        //"for",
                        //"Geeks"));
        myList.add( row2 );
        showMeTheLists( myList );


        ArrayList<Integer> items = myList.get(0);
        for( Integer item : items ) {
            System.out.printf("\n I:%s", item);
        }

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
