import java.util.ArrayList;
import java.util.Scanner;

public class DBBooks_inClass_9_16 {
    public static void main(String[] args) {
        String pwFile = "input/pw.txt";
        String dbName = "45.55.136.114/csc3610";
        DBAbstract db = new DBAbstract(dbName, pwFile);

        ArrayList<String> genres = getGenresFromDB( db );

        String theGenre = getUserGenrePreference(db, genres);

        ArrayList<DBBook> theBooks = getBooksFromDB(db, theGenre);

        outputResults(theBooks);
    }

    private static void outputResults(ArrayList<DBBook> theBooks) {
        System.out.printf("\n The Results: ");
        for( DBBook book : theBooks){
            System.out.printf("\n T: %s A: %s Y: %s G: %s", book.getTitle(), book.getAuthor(), book.getYear(), book.getGenre());
        }
    }

    private static ArrayList<DBBook> getBooksFromDB(DBAbstract db, String theGenre) {
        ArrayList<DBBook> theBooks = new ArrayList<>();
        String sql = String.format( "Select `Title`,`Author`,`Year`,`Genre` from BestSellingBooks where genre = '%s'", theGenre);
        ArrayList<String> DBResults = db.doQueryAL(sql);
        for (String row : DBResults){
            String[] toks = row.split(";");
            String title = toks[0];
            String author = toks[1];
            String year = toks[2];
            String genre = toks[3];
            theBooks.add(new DBBook(title, author, year, genre));
        }
        return theBooks;
    }

    private static String getUserGenrePreference(DBAbstract db, ArrayList<String> genres) {
        String theGenre = "";
        String cma = "";
        String gList = "";
        for (String genre : genres){
            //Should use stringbuilder, but for this practice were using string just cuz
            gList += cma + genre;
            cma = ", ";
        }
        System.out.printf("\n Select a Genre: %s ->", gList);
        Scanner s = new Scanner(System.in);
        theGenre = s.next();

        return theGenre;
    }

    private static ArrayList<String> getGenresFromDB(DBAbstract db) {
        ArrayList<String> results = new ArrayList<>();
        String sql = "SELECT distinct genre FROM `BestSellingBooks` order by genre;";
        ArrayList<String> DBResults = db.doQueryAL(sql);

        //technically i should return dbresults, but will copy for practice
        for (String row : DBResults){
            results.add( row );
        }

        return results;
    }
}
