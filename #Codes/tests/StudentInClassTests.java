import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StudentInClassTests {
    @Test
    public void testRows(){
        //Tests for rows, which also indicated how many students are in the file
        String fName = "input/students.txt";
        FileIOManager_9_9 fio = new FileIOManager_9_9( fName );
        try {
            fio.setFileData();
        } catch( FileNotFoundException e) {
            System.out.printf("\n File not found fName:%s message:%s",
                    fName, e.getMessage());
        }
        ArrayList<String> rows = fio.getFileData();
        assertEquals( 15, rows.size() );
    }
    @Test
    public void testAnotherFileCSCStudents(){
        //Tests the main functions with another file to double-check functionality
        String fName = "input/studentsTest.txt";
        FileIOManager_9_9 fIO = new FileIOManager_9_9(fName);
        try {
            fIO.setFileData();
        } catch( FileNotFoundException e) {
            System.out.printf("\n File not found fName:%s message:%s",
                    fName, e.getMessage());
        }

        ArrayList<String> rows = fIO.getFileData();

        ArrayList<StudentsObjectClass> studentRoster = InClassFileIO_9_9.getRowsAsObjects( rows );

        ArrayList<String> cscStudentSeniorsTest = new ArrayList<>();
        cscStudentSeniorsTest.add("Janet Jackson");
        cscStudentSeniorsTest.add("Kyle Kyley");
        cscStudentSeniorsTest.add("Bob Segar");
        cscStudentSeniorsTest.add("Patric Star");

        assertEquals( cscStudentSeniorsTest, InClassFileIO_9_9.getCSCSeniors( studentRoster ) );
        System.out.print("\n");
    }
    @Test
    public void testAnotherFileNonCSCStudents(){
        //Tests the main functions with another file to double-check functionality
        String fName = "input/studentsTest.txt";
        FileIOManager_9_9 fIO = new FileIOManager_9_9(fName);
        try {
            fIO.setFileData();
        } catch( FileNotFoundException e) {
            System.out.printf("\n File not found fName:%s message:%s",
                    fName, e.getMessage());
        }

        ArrayList<String> rows = fIO.getFileData();

        ArrayList<StudentsObjectClass> studentRoster = InClassFileIO_9_9.getRowsAsObjects( rows );

        ArrayList<String> nonCSCStudentSeniorsTest = new ArrayList<>();
        nonCSCStudentSeniorsTest.add("James Jameson");
        nonCSCStudentSeniorsTest.add("Patti Melt");
        nonCSCStudentSeniorsTest.add("Pearl Krabs");
        nonCSCStudentSeniorsTest.add("Larry Lobster");

        assertEquals( nonCSCStudentSeniorsTest, InClassFileIO_9_9.getNonCSCStudents( studentRoster ) );
        System.out.print("\n");
    }

}
