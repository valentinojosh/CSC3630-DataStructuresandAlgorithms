import java.util.Arrays;
import java.util.Scanner;

public class InClass_11_18_Matrix {
    public static void main(String[] args) {
        int[][] adjMatrix = getAdjMatrix();
        String[] nodeNames = setNodeNames();
        // ToDo: Ask the user for a node-
        String startNode = getStartNodeFromUser( nodeNames );
        System.out.printf("\n Start:%s", startNode);
        int inx = findThisCityInList( startNode, nodeNames);
        if ( inx == -1 ){
            System.out.printf("Sorry node:%s is not in the list", startNode);
        } else {
            // given the row we have (inx) output all the cities connected to it
            String outStr = showWhatIsConnected( inx, nodeNames, adjMatrix);
            System.out.printf("\n Node:%s is  connected To :%s", startNode, outStr);

        }

        // ToDo: Show all the nodes connected to their input
    }

    private static String showWhatIsConnected(int inx, String[] nodeNames, int[][] adjMatrix) {
        String oStr = "";
        if ( inx > adjMatrix.length | inx < 0 ){
            System.out.printf("\n Oh No Error inx:%s is more than number rows", inx);
        } else {
            int[] row = adjMatrix[inx];
            int ct = 0;
            for ( int i : row){
                if ( i == 1 ){
                    String city = nodeNames[ct];
                    oStr += " " + city;
                }
                ct++;
            }
        }
        return oStr;
    }

    private static int findThisCityInList(String startNode, String[] nodeNames) {
        // -1 indicates not found
        int inx = -1;
        int ct = 0;
        for( String item : nodeNames){
            if ( item.equals(startNode)) {
                return ct;
            }
            ct++;
        }

        return inx;
    }

    private static String getStartNodeFromUser(String[] nodeNames) {
        String uNode = null;
        String csvMsg = createCSVFromList( nodeNames );
        System.out.printf("\n Pick a City (%s)->", csvMsg);
        Scanner s = new Scanner(System.in);
        // ToDo: should check they actually entered a valid city
        uNode = s.next();

        return uNode;
    }

    private static String createCSVFromList(String[] inList ) {
        String csvMsg = null;
        boolean first = true;
        for( String item : inList ){
            if ( first ) {
               csvMsg =  item;
               first = false;
            } else {
                csvMsg += ", " + item;
            }
        }
        return csvMsg;
    }

    private static int[][] getAdjMatrix() {
        int[][] adjMatrix = {
                {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0}, // Seattle
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, // San Francisco
                {0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0}, // Los Angeles
                {1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0}, // Denver
                {0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0}, // Kansas City
                {1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0}, // Chicago
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, // Boston
                {0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0}, // New York
                {0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1}, // Atlanta
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1}, // Miami
                {0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1}, // Dallas
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0}  // Houston
        };
        return adjMatrix;
    }


    private static String[] setNodeNames( ) {
        String[] nodeNames = {"Seattle", "San Francisco", "Los Angeles",
                "Denver", "Kansas City", "Chicago", "Boston",
                "New York", "Atlanta", "Miami", "Dallas", "Houston"
        };
        return nodeNames;
    }
}
