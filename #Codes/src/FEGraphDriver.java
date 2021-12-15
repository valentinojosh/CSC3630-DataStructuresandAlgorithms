import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class FEGraphDriver {
    public static void main(String[] args) {

        //Todo: Properly fix the adjancy matric in this method
        int[][] adjMatrix = getAdjMatrix();
        LinkedHashMap<String, Integer> nodeNames = getNodeNames();
        //Todo: Write this method
        showTheConnectedNodes("Dallas", adjMatrix, nodeNames );

        showTheConnectedNodes("Boston", adjMatrix, nodeNames );

        showTheConnectedNodes("Chicago", adjMatrix, nodeNames );
    }

    private static void showTheConnectedNodes(String startNode, int[][] adjMatrix,
                                              LinkedHashMap<String, Integer> nodeNames) {
        // ToDo: Write this method that shows the names of the
        //       cities connected to the startNode in the adjacency matrix
        ArrayList<String> oStr = new ArrayList<>();
        for (int i=0; i< adjMatrix.length; i++){
            if(i == nodeNames.get(startNode)){
                for (int j=0; j< adjMatrix.length; j++){
                    if(adjMatrix[i][j] == 1){
                        oStr.add(getKey(nodeNames, j));
                    }
                }
            }
        }
        System.out.printf("\nCities connected to %s: %s", startNode, oStr.toString());
    }

    private static String getKey(LinkedHashMap<String, Integer> nodeNames, int i) {
        StringBuilder result = new StringBuilder();
        if (nodeNames.containsValue(i)) {
            for (Map.Entry<String, Integer> entry : nodeNames.entrySet()) {
                if (entry.getValue().equals(i)) {
                    result.append(entry.getKey());
                }
            }
        }
        return result.toString();
    }

    private static int[][] getAdjMatrix() {
        //ToDo: properly create this adjancy matrix
        //  for the graph
        int[][] theMat = {
                {0, 1, 1 , 1},
                {1, 0, 0 , 0},
                {1, 0, 0 , 1},
                {1, 1, 1,  0},
        };
        return theMat;
    }
    private static LinkedHashMap<String, Integer> getNodeNames(){
        // ToDo: Use this linkedHashMap
        LinkedHashMap<String, Integer> nodeNames = new LinkedHashMap<>();
        nodeNames.put( "Boston", 0);
        nodeNames.put( "Chicago", 1);
        nodeNames.put( "New York", 2);
        nodeNames.put( "Dallas", 3);
        return nodeNames;
    }
}
