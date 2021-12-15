import java.util.Comparator;

public class MovieRatingCompare implements Comparator<MovieInClass> {
    @Override
    public int compare(MovieInClass m1, MovieInClass m2) {
        if ( m1.getRating() < m2.getRating() ) return -1;
        else if ( m1.getRating() > m2.getRating() ) return 1;
        else return 0;
    }
}
