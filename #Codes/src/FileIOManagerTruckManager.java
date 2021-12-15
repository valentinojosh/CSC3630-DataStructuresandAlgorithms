import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIOManagerTruckManager {
    private ArrayList<String > fileRows = new ArrayList<>();
    private String fName;
    public FileIOManagerTruckManager(String  fName) {
        this.fName = fName;
    }
    public void setFileData() throws FileNotFoundException{
        String path = new File( fName).getAbsolutePath();
        File inFileHandle = new File(path);
        try {
            Scanner sc = new Scanner( inFileHandle );
            String line = null;
            while( sc.hasNextLine()) {
                line = sc.nextLine();
                fileRows.add( line );
            }
        } catch( FileNotFoundException e ){
            String msg = "File Not Found";
            throw new FileNotFoundException( msg );
        }
    }
    public ArrayList<String> getFileData() {
        return fileRows;
    }
}
