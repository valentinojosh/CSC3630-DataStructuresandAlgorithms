import java.util.ArrayList;
import java.util.Scanner;

//Author: Josh Valentino
//Date: 12/03/2021
//Course: CSC 3630 w/ Professor David Lash

public class GraphWeightedDriver {
    public static void main(String[] args) {
        int vertices = 6;
        System.out.printf("\nStarted");
        GraphWeightedGraph gwg = buildGraph(vertices);

        gwg.printGraph();
        String source = "Chicago";
        String startCity = getStartCity(gwg.getSourceKeys());

        ArrayList<String> routes = gwg.getPossibleRoutes(source, startCity);
        showTheRoutes(source, startCity, routes, gwg);
    }

    private static void showTheRoutes(String source, String startCity, ArrayList<String> routes, GraphWeightedGraph gwg) {
        System.out.printf("\nStart Node:%s to:%s", source, startCity);
        System.out.printf("\n------------ Cities connected to %s, starting at %s", startCity, source);
        for(int i = 0; i < routes.size(); i++){
            String weight = gwg.getWeight(startCity, routes.get(i), source);
            System.out.printf("\n------------ %s : %s", routes.get(i), weight);
        }
    }

    private static String getStartCity(ArrayList<String> sourceKeys) {
        String city = "";
        Scanner s = new Scanner(System.in);

        System.out.printf("\nSelect a source city-> (");
        for(int i = 0; i < sourceKeys.size(); i++){
            System.out.printf(sourceKeys.get(i));
            if(i != sourceKeys.size()-1){
                System.out.printf(", ");
            }
        }
        System.out.printf(")");

        city = s.nextLine();
        while(!sourceKeys.contains(city)){
            System.out.printf("\nInput Invalid(The input is either not an option or there are no flights coming out of that city)");
            System.out.printf("\nSelect a source city->");
            city = s.nextLine();
        }

        return city;
    }

    private static GraphWeightedGraph buildGraph(int vertices) {
        GraphWeightedGraph gwg = new GraphWeightedGraph(vertices);
        gwg.addEdge(0,"Chicago", "New York", 790);
        gwg.addEdge(0,"Chicago", "Atlanta", 718);
        gwg.addEdge(0,"Chicago", "Dallas", 968);

        gwg.addEdge(1,"New York", "Orlando", 1080);
        gwg.addEdge(1,"New York", "Houston", 1647);

        gwg.addEdge(2,"Atlanta", "Dallas", 781);
        gwg.addEdge(2,"Atlanta", "Orlando", 438);
        gwg.addEdge(2,"Atlanta", "New York", 870);

        gwg.addEdge(3,"Dallas", "Houston", 239);
        gwg.addEdge(3,"Dallas", "Orlando", 1120);

        gwg.addEdge(4,"Houston", "Orlando", 967);
        return gwg;
    }
}
