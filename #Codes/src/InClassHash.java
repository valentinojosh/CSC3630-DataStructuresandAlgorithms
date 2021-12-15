import java.util.ArrayList;
import java.util.HashMap;

//Author: Josh Valentino
//Date: 10/26/2021
//Course: CSC 3630 w/ Professor David Lash

public class InClassHash {
    public static void main(String[] args) {
        ArrayList<String> inRows = getCarData();
        HashMap<String, Integer> topMap = getToppingMap(inRows);
        showTopping( topMap );

        System.out.println();

        HashMap<String, Integer> movieMap = getMovieMap(inRows);
        showMovieMap( movieMap );
    }

    private static void showMovieMap(HashMap<String, Integer> movieMap) {
        System.out.printf("\nData Entries for Movies:");
        movieMap.forEach((key, value) -> System.out.printf("\n" + key + " => " + value));
    }

    private static void showTopping(HashMap<String, Integer> topMap) {
        System.out.printf("\nData Entries for Toppings:");
        topMap.forEach((key, value) -> System.out.printf("\n" + key + " => " + value));
    }

    private static HashMap<String, Integer> getMovieMap(ArrayList<String> inRows) {
        HashMap<String, Integer> movieHash = new HashMap<>();
        for(int i = 0; i < inRows.size(); i++){
            String temp = inRows.get(i).substring(inRows.get(i).indexOf(",")+1);
            int tempInt;
            try {
                tempInt = movieHash.get(temp);
            }
            catch(Exception e) {
                tempInt = 0;
            }
            movieHash.put(temp , tempInt+1);
        }
        return movieHash;
    }

    private static HashMap<String, Integer> getToppingMap(ArrayList<String> inRows) {
        HashMap<String, Integer> toppingHash = new HashMap<>();
        for(int i = 0; i < inRows.size(); i++){
            String temp = inRows.get(i).substring(0, inRows.get(i).indexOf(","));
            int tempInt;
            try {
                tempInt = toppingHash.get(temp);
            }
            catch(Exception e) {
                tempInt = 0;
            }
            toppingHash.put(temp , tempInt+1);
        }
        return toppingHash;
    }

    private static ArrayList<String> getCarData() {
        ArrayList<String> rows = new ArrayList<>();
        // Favorite Topping, Condiment, Movie
        rows.add("Pepperoni,Star Wars");
        rows.add("Pepperoni,Harry Potter");
        rows.add("Cheese,LOTR");
        rows.add("Pepperoni,LOTR");
        rows.add("Sausage,Star Wars");
        rows.add("Cheese,Star Wars");
        rows.add("Pepperoni,LOTR");
        rows.add("Sausage,LOTR");
        rows.add("Sausage,Harry Potter");
        rows.add("Sausage,Star Wars");
        rows.add("Pepperoni,Harry Potter");
        rows.add("Cheese,Star Wars");
        return rows;
    }
}
