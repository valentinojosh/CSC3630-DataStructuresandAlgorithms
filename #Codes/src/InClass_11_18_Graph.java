import java.util.ArrayList;
import java.util.HashMap;

public class InClass_11_18_Graph {
    public HashMap<String, ArrayList<String>> adjVert = new HashMap<>();

    public void addVertex(String node) {
        ArrayList<String> cList = new ArrayList<>();
        adjVert.put( node, cList);
    }

    public void addEdge(String source, String dest) {
        adjVert.get(source).add(dest);
        //Note this is undirected
        //adjVert.get(dest).add(source);
    }

    public ArrayList<String> getConnected(String vertix ) {
        ArrayList<String> connections = adjVert.get( vertix);
        return connections;
    }
    public ArrayList<String> getSecondaryConnected(String vertix ) {
        ArrayList<String> connections = adjVert.get( vertix);
        ArrayList<String> Secondary = new ArrayList<>();

        for( String item : connections ){
            ArrayList<String> secItems = adjVert.get( item );
            for( String secItem : secItems ) {
                Secondary.add( secItem);
            }

        }
        return Secondary;
    }
}
