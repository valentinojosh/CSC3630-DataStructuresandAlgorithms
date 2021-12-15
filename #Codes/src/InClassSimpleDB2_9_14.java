import java.util.ArrayList;

public class InClassSimpleDB2_9_14 {
    public static void main(String[] args) {
        String path = "input/pw.txt";
        String dbName = "45.55.136.114:3306/csc3610";
        DBAbstract db = new DBAbstract(dbName, path);
        ArrayList<String> categories = getGenre( db );
        for( String cat : categories){
            System.out.printf("\nCat:%s", cat);
        }
    }

    private static ArrayList<String> getGenre(DBAbstract db) {
        //ArrayList<String> theCats = new ArrayList<>();
        //String sql = "Select distinct genre from BestSellingBooks order by genre";
        String sql = "Select title,sale,genre from BestSellingBooks order by genre";
        ArrayList<String> theCats = db.doQueryAL(sql);
        return theCats;
    }

}
