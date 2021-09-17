import java.util.ArrayList;
import java.util.Scanner;

public class HW2_Valentino {
    public static void main(String[] args) {
        String path = "input/pw.txt";
        String dbName = "45.55.136.114:3306/csc3610";
        DBAbstractHW2 db = new DBAbstractHW2(dbName, path);

        System.out.println();

        ArrayList<String> years = getYearsFromDB( db );
        int userInputYear = getUserYearSelection( years );

        System.out.printf("\n---- Average Temp For The Year = %s ----", userInputYear);
        System.out.println();
        System.out.println();

        if(yearInDB(years, userInputYear)){
            printAvgHighHottestColdest( db, userInputYear );
        }
        else{
            System.out.printf("Sorry, no data for year = %s", userInputYear);
        }
        System.out.println();

    }

    private static boolean yearInDB(ArrayList<String> years, int userInputYear) {
        int totalCount = 0;
        for (int i = 0; i < years.size(); i++){
            if ( userInputYear == Integer.parseInt(years.get(i)) ) {
                totalCount++;
            }
        }
        if(totalCount == 0){
            return false;
        }
        else{
            return true;
        }
    }

    private static void printAvgHighHottestColdest(DBAbstractHW2 db, int userInputYear) {
        String hottest = " Hottest Month: ";
        String coldest = " Coldest Month: ";
        int[] allTemps = new int[12];
        String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String sql = String.format( "Select `Jan`,`Feb`,`Mar`,`Apr`,`May`,`Jun`,`Jul`,`Aug`,`Sep`,`Oct`,`Nov`,`Dec` from ChicagoHiPerMonth where Year = '%s'", userInputYear);
        ArrayList<String> DBResults = db.doQueryAL(sql);
        for (String row : DBResults){
            String[] toks = row.split(";");
            int Jan = Integer.parseInt(toks[0]);
            int Feb = Integer.parseInt(toks[1]);
            int Mar = Integer.parseInt(toks[2]);
            int Apr = Integer.parseInt(toks[3]);
            int May = Integer.parseInt(toks[4]);
            int Jun = Integer.parseInt(toks[5]);
            int Jul = Integer.parseInt(toks[6]);
            int Aug = Integer.parseInt(toks[7]);
            int Sep = Integer.parseInt(toks[8]);
            int Oct = Integer.parseInt(toks[9]);
            int Nov = Integer.parseInt(toks[10]);
            int Dec = Integer.parseInt(toks[11]);
            allTemps = new int[]{Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec};
        }

        System.out.printf("Jan: %s, Feb: %s, Mar: %s, Apr: %s", allTemps[0], allTemps[1], allTemps[2], allTemps[3]);
        System.out.printf("\nMay: %s, Jun: %s, Jul: %s, Aug: %s", allTemps[4], allTemps[5], allTemps[6], allTemps[7]);
        System.out.printf("\nSep: %s, Oct: %s, Nov: %s, Dec: %s", allTemps[8], allTemps[9], allTemps[10], allTemps[11]);

        int hottestIndex = 0;
        for(int i = 0; i < allTemps.length; i++){
            if(allTemps[i] > allTemps[hottestIndex]){
                hottestIndex = i;
            }
        }
        int coldestIndex = 0;
        for(int i = 0; i < allTemps.length; i++){
            if(allTemps[i] < allTemps[coldestIndex]){
                coldestIndex = i;
            }
        }

        hottest += months[hottestIndex] + ", Temp: " + allTemps[hottestIndex];
        coldest += months[coldestIndex] + ", Temp: " + allTemps[coldestIndex];
        System.out.println();
        System.out.printf(hottest);
        System.out.println();
        System.out.printf(coldest);

    }

    private static ArrayList<String> getYearsFromDB(DBAbstractHW2 db) {
        String sql = "SELECT Year FROM `ChicagoHiPerMonth`;";

        return db.doQueryAL(sql);
    }

    private static int getUserYearSelection(ArrayList<String> years) {
        String cma = "";
        String strUserYear;
        System.out.printf(" Chicago Monthly Average Data ----");
        printSelectYear(years);

        Scanner s = new Scanner(System.in);
        strUserYear = s.next();

        while(!isNumber(strUserYear)){
            System.out.printf(" That input appears to be invalid");
            printSelectYear(years);
            strUserYear = s.next();
        }

        return Integer.parseInt(strUserYear);
    }

    private static void printSelectYear(ArrayList<String> years) {
        System.out.println();
        System.out.printf(" Select a year:");
        System.out.println();
        for(int i = 0; i < years.size(); i++){
            if( (i != 0) && (i % 5 == 0) ){
                System.out.println();
            }
            System.out.printf(years.get(i));
            if(i != years.size()-1){
                System.out.printf(", ");
            }
        }
        System.out.printf(" ->");
    }

    static boolean isNumber(String in)
    {
        try
        {
            Integer.parseInt(in);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
    }
}
