import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

//Author: Josh Valentino
//Date: 09/14/2021
//Course: CSC 3630 w/ Professor David Lash

public class HW_AutoInventory {
    String make;
    String model;
    int year;
    double baseCost;
    String description;

    public HW_AutoInventory(String make, String model, int year, double baseCost, String description) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.baseCost = baseCost;
        this.description = description;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public String getDescription() {
        return description;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static void main(String[] args) {
        ArrayList<HW_AutoInventory> inventory = getInventory();
        // Output any record that does not have exactly a 4 digit year
        showBadYears(  inventory );
        // Prompt the user for a words to search for in the description
        String searchTerm = getTermToSearchFor();
        // output any record that has the
        // search term in the description
        showMatchingItems( searchTerm, inventory);
        // Prompt for a comma separated input  of Makes (e.g., Honda,Ford)
        String makes = getMakesToSearch(inventory);
        // output records that match one of the input makes
        showTheseMakes( makes, inventory );
        System.out.print("\n");
    }

    private static ArrayList<HW_AutoInventory> getInventory() {
        ArrayList<HW_AutoInventory> inventory = new ArrayList<>();
        // (String make, String model, int year double baseCost, String description)
        inventory.add( new HW_AutoInventory("Honda", "Accord", 1990, 999.99, "Peril black 4-door sedan with dent in door") );
        inventory.add( new HW_AutoInventory("Honda","Accord", 2000, 1999.99, "Blue sedan never in accident but non-Perfect condition"));
        inventory.add( new HW_AutoInventory("Ford","Taurus", 2019, 19999.99, "Scratch in bumper, dent in door"));
        inventory.add( new HW_AutoInventory("Ford","Taurus", 12019, 19999.99, "Perfect condition"));
        inventory.add( new HW_AutoInventory("Ford","Taurus", 2010, 1099.99, "Perfect condition but a dent in side and scratch in door"));
        inventory.add( new HW_AutoInventory("Honda","CRV", 2010, 19099.99, "Perfect condition but a broken tail pipe and Dent in molding."));
        inventory.add( new HW_AutoInventory("Chevy","Impala", 199010, 99.99,"No Dents at all"));
        inventory.add( new HW_AutoInventory("Chevy","Blazer", 2006, 5099.99,"Looks great. Has new tires without Dent."));
        inventory.add( new HW_AutoInventory("Honda","CRV", 2020, 49099.99,"Dent on side molding otherwise Perfect Condition."));
        return inventory;
    }

    public static void showBadYears(ArrayList<HW_AutoInventory> inventory){
        System.out.printf("\n--------Bad Year Inventory Search");
        for(HW_AutoInventory item : inventory){
            int numDigits = String.valueOf(item.getYear()).length();
            if(numDigits != 4){
                System.out.printf("\n Bad Year - Make: %s, Model: %s, Year: %s, Desc: %s", item.getMake(), item.getModel(), item.getYear(), item.getDescription());
            }
        }
    }

    private static String getTermToSearchFor() {
        Scanner sc= new Scanner(System.in);
        System.out.print("\nEnter Term to search description for->");
        String str= sc.nextLine();
        return str;
    }

    private static void showMatchingItems(String searchTerm, ArrayList<HW_AutoInventory> inventory) {
        System.out.printf("\n--------Matching Description Inventory Search Term: %s",searchTerm);
        int totalCount = 0;
        for(HW_AutoInventory item : inventory){
            String str = item.getDescription();
            String[] splitStr = str.trim().split("\\s+");
            for(int i = 0; i < splitStr.length; i++){
                String c1 = splitStr[i].toLowerCase();
                String c2 = searchTerm.toLowerCase();
                if(c1.equals(c2)){
                    System.out.printf("\n Desc - Make: %s, Model: %s, Year: %s, Desc: %s", item.getMake(), item.getModel(), item.getYear(), item.getDescription());
                    totalCount++;
                }
            }
        }
        if(totalCount == 0){
            System.out.printf("\n Desc - No matches found for the entered search term");
        }
    }

    private static String getMakesToSearch(ArrayList<HW_AutoInventory> inventory) {
        Scanner sc= new Scanner(System.in);
        System.out.print("\nEnter Comma Separate Makes to search for(E.g: Honda, Ford)->");
        String str= sc.nextLine();
        return str;
    }

    private static void showTheseMakes(String makes, ArrayList<HW_AutoInventory> inventory) {
        String[] splitStr = makes.split(",");
        for (int i = 0; i < splitStr.length; i++) {
            splitStr[i] = splitStr[i].trim();
        }
        System.out.printf("\n--------Model Search For Makes: %s", Arrays.toString(splitStr));
        for(int i=0; i < splitStr.length; i++){
            for(HW_AutoInventory item : inventory){
                String c1 = item.getMake().toLowerCase();
                String c2 = splitStr[i].toLowerCase();
                if(c1.equals(c2)){
                    System.out.printf("\nMake search - Make: %s, Model: %s, Year: %s, Desc: %s",item.getMake(), item.getModel(), item.getYear(), item.getDescription());
                }
            }
        }
    }

}
