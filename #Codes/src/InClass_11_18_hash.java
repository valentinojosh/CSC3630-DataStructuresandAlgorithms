import java.util.ArrayList;

public class InClass_11_18_hash {
    public static void main(String[] args) {
        InClass_11_18_Graph graph = createGraph();
        ArrayList<String> connected = graph.getConnected("Rob");
        showTheConnection( "Rob", connected);

        ArrayList<String> secConnected = graph.getSecondaryConnected("Rob");
        showTheConnection( "Rob", secConnected );
   }

    private static void showTheConnection(String node, ArrayList<String> connected) {
        System.out.printf("\n From Node:%s connections:", node );
        for( String item : connected){
            System.out.printf("item:%s",item);
        }
    }

    private static InClass_11_18_Graph createGraph() {
        InClass_11_18_Graph graph = new InClass_11_18_Graph();
        // Add all the vertices
        graph.addVertex( "Bob");
        graph.addVertex( "Alice");
        graph.addVertex( "Mark");
        graph.addVertex( "Rob");
        graph.addVertex( "Maria");
        // Add all the connections ot the vertices
        graph.addEdge( "Bob", "Alice");
        graph.addEdge( "Rob", "Bob");
        graph.addEdge( "Rob", "Mark");
        graph.addEdge( "Rob", "Maria");
        graph.addEdge( "Mark", "Alice");
        graph.addEdge( "Alice", "Maria");
        return graph;
    }
}
