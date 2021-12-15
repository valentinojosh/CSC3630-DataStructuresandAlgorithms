//import java.nio.file.Path;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class InClassFileIO_9_9 {
    public static void main(String[] args) {
        String fName = "input/students.txt";
        FileIOManager_9_9 fIO = new FileIOManager_9_9(fName);
        try {
            fIO.setFileData();
        } catch( FileNotFoundException e) {
            System.out.printf("\n File not found fName:%s message:%s",
                    fName, e.getMessage());
        }

        ArrayList<String> rows = fIO.getFileData();

        ArrayList<StudentsObjectClass> studentRoster = getRowsAsObjects( rows );

        getCSCSeniors( studentRoster );
        getNonCSCStudents( studentRoster );
        System.out.print("\n");

    }

    public static ArrayList<String> getCSCSeniors(ArrayList<StudentsObjectClass> studentRoster){
        ArrayList<String> cscStudentSeniors = new ArrayList<>();
        for( StudentsObjectClass item : studentRoster){
            if( item.getMajor().equals("CSC") && (item.getCreditHours()>= 30) ){
                cscStudentSeniors.add(item.getFirstName() + " " + item.getLastName());
            }
        }
        System.out.printf("\n The list of CSC seniors: %s", cscStudentSeniors);
        return cscStudentSeniors;
    }

    public static ArrayList<String> getNonCSCStudents(ArrayList<StudentsObjectClass> studentRoster){
        int nonCSC = 0;
        ArrayList<String> nonCSStudents = new ArrayList<>();
        for( StudentsObjectClass item : studentRoster){
            if( !item.getMajor().equals("CSC")){
                nonCSStudents.add(item.getFirstName() + " " + item.getLastName());
                nonCSC++;
            }
        }
        System.out.printf("\n The number of non-CSC students is: %s", nonCSC);
        System.out.printf("\n The list of non-CSC majors: %s", nonCSStudents);
        return nonCSStudents;
    }

    public static ArrayList<StudentsObjectClass> getRowsAsObjects(ArrayList<String> rows) {
        ArrayList<StudentsObjectClass> myItems = new ArrayList<>();
        for( String row : rows ){
            String[] toks = row.split(",");
            //String uNum, String firstName, String lastName, String major, int creditHours
            String uNum = toks[0];
            String firstName = toks[1];
            String lastName = toks[2];
            String major = toks[3];
            int creditHours = Integer.parseInt(toks[4]);
            StudentsObjectClass item = new StudentsObjectClass( uNum, firstName, lastName, major, creditHours);
            myItems.add( item );
        }
        return myItems;
    }
}
