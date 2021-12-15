import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class MovieSortInClass_10_7 {
    public static void main(String[] args) {
        ArrayList<MovieInClass> movies = getMeTheMovies();
        //TreeSet<MovieInClass> mic = new TreeSet<>();
        System.out.printf("\n --------FLAG1 -----------");
        showMeTheMovies( movies );

        System.out.printf("\n --------FLAG2 -----------");
        System.out.println("Movies after sorting : ");
        showMeTheMovies( movies );

        MovieRatingCompare ratingCompare = new MovieRatingCompare();
        Collections.sort(movies, ratingCompare);
        System.out.printf("\n --------FLAG3 -----------");
        System.out.println("Movies after sorting by rating: ");
        showMeTheMovies( movies );
    }

    private static void showMeTheMovies( ArrayList<MovieInClass> movies ) {
        for (MovieInClass movie: movies) {
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }
    }


    private static ArrayList<MovieInClass> getMeTheMovies() {
        ArrayList<MovieInClass> list = new ArrayList<>();
        list.add(new MovieInClass("Force Awakens", 8.3, 2015));
        list.add(new MovieInClass("Star Wars", 8.7, 1977));
        list.add(new MovieInClass("Empire Strikes Back", 8.8, 1980));
        list.add(new MovieInClass("Return of the Jedi", 8.4, 1983));
        return list;
    }
}
