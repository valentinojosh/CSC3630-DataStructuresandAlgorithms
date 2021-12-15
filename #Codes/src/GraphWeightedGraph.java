import java.util.ArrayList;

//Author: Josh Valentino
//Date: 12/03/2021
//Course: CSC 3630 w/ Professor David Lash

public class GraphWeightedGraph {
    int vertices; //How many nodes are in the graph
    ArrayList<ArrayList<GraphWeightedEdge>> adjList = new ArrayList<ArrayList<GraphWeightedEdge>>(vertices);

    public GraphWeightedGraph(int vertices) {
        this.vertices = vertices;

        for(int i = 0; i < vertices; i++){
            adjList.add(new ArrayList<GraphWeightedEdge>());
        }
    }

    public void addEdge(int node, String source, String dest, int weight){
        GraphWeightedEdge gwe = new GraphWeightedEdge(node, source, dest, weight);
        adjList.get(node).add(gwe);
    }

    public void printGraph(){
        for(int i = 0; i < vertices; i++){
            int aSize = adjList.get(i).size();
            for(int j = 0; j < aSize; j++){
                GraphWeightedEdge node = adjList.get(i).get(j);

                System.out.printf("\n Node:%s is connected to:%s with weight:%s",
                        node.source, node.destination, node.weight);

            }
        }
    }

    public ArrayList<String> getSourceKeys(){
        ArrayList<String> keys = new ArrayList<String>();

        for(int i = 0; i < adjList.size()-1; i++){
            GraphWeightedEdge node = adjList.get(i).get(0);
            keys.add(node.source);
        }
        return keys;
    }

    public ArrayList<String> getPossibleRoutes(String source, String startCity){
        ArrayList<String> routes = new ArrayList<>();

        //Gets the index of the edge that contains the startCity
        int index = 0;
        for(ArrayList<GraphWeightedEdge> edge : adjList){
            for(int i = 0; i < edge.size(); i++){
                if(edge.get(i).source.equals(startCity)){
                    index = i;
                }
            }
        }

        for(int i = 0; i < adjList.get(index).size(); i++){
            routes.add(adjList.get(index).get(i).destination);
        }
        return routes;
    }

    public String getWeight(String startCity, String routeCity, String source) {
        StringBuilder weight = new StringBuilder();
        int sum = 0;

        //Gets the weight for the connection between the source and startCity
        for(ArrayList<GraphWeightedEdge> edge : adjList){
            for(int i = 0; i < edge.size(); i++){
                if(edge.get(i).destination.equals(startCity) && edge.get(i).source.equals(source)){
                    weight.append(edge.get(i).weight);
                    sum += edge.get(i).weight;
                }
            }
        }
        weight.append("+");

        //Gets the weight for the connection between the startCity and route
        for(ArrayList<GraphWeightedEdge> edge : adjList){
            for(int i = 0; i < edge.size(); i++){
                if(edge.get(i).destination.equals(routeCity) && edge.get(i).source.equals(startCity)){
                    weight.append(edge.get(i).weight);
                    sum += edge.get(i).weight;
                }
            }
        }
        weight.append("=").append(sum);

        return weight.toString();
    }

}
