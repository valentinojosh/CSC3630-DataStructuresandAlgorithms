public class GraphWeightedEdge {
    int node;
    String source; //The 'from' node
    String destination; //The 'to' node
    int weight; //The edge weight
    //E.g. From 0 to 1 with weight 3

    public GraphWeightedEdge(int node, String source, String destination, int weight) {
        this.node = node;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}