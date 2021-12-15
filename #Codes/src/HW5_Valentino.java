import java.io.FileNotFoundException;
import java.util.*;

//Author: Josh Valentino
//Date: 10/29/2021
//Course: CSC 3630 w/ Professor David Lash

public class HW5_Valentino {
    public static void main(String[] args) {
        ArrayList<String> inputDataRows = getCourseData();
        ArrayList<courseObject> dataRowsAsObjects = getRowsAsObjects(inputDataRows);
        HashMap<String, ArrayList<courseObject>> courseHashMap = populateMap(dataRowsAsObjects);
        showAggregateCourses(courseHashMap);

        String userInput = "";
        Scanner sc = new Scanner(System.in);
        while(!userInput.equals("Q")){
            System.out.printf("\nEnter Course ID or Q to quit->");
            userInput = sc.nextLine();
            if(userInput.equals("Q")){
                System.out.printf("\nSystem quit, goodbye");
            }
            else{
                showMatchingCourses(userInput, courseHashMap);
            }
        }

    }

    private static ArrayList<String> getCourseData() {
        String fName = "input/courses.txt";
        FileIO_HW5 fIO = new FileIO_HW5(fName);
        try {
            fIO.setFileData();
        } catch( FileNotFoundException e) {
            System.out.printf("\n File not found fName:%s message:%s",
                    fName, e.getMessage());
        }
        return fIO.getFileData();
    }

    private static ArrayList<courseObject> getRowsAsObjects(ArrayList<String> inputDataRows) {
        ArrayList<courseObject> dataRowsAsObjects = new ArrayList<>();
        for(int i = 1; i < inputDataRows.size(); i++){
            String[] toks = inputDataRows.get(i).split(",");
            String Course = toks[0];
            String Section = toks[1];
            String Title = toks[2];

            //Note: Error in courses.txt file, the header labels the fifth column as NSeats and
            // the fourth column as NStudents, when in fact the data itself is switched
            //Hence why the tokens are out of order for NStudents and NSeats
            int NStudents = Integer.parseInt(toks[4]);
            int NSeats = Integer.parseInt(toks[3]);

            String Instructor = toks[5];
            int Year = Integer.parseInt(toks[6]);
            courseObject item = new courseObject(Course, Section, Title, NStudents, NSeats, Instructor, Year);
            dataRowsAsObjects.add( item );
        }
        return dataRowsAsObjects;
    }

    private static HashMap<String, ArrayList<courseObject>> populateMap(ArrayList<courseObject> dataRowsAsObjects) {
        HashMap<String, ArrayList<courseObject>> courseHash = new HashMap<>();

        for (courseObject o : dataRowsAsObjects){
            if(!courseHash.containsKey(o.getCourse())){
                String courseKey = o.getCourse();
                ArrayList<courseObject> currentList = new ArrayList<>();
                currentList.add(o);
                courseHash.put(courseKey, currentList);
            }else{
                ArrayList<courseObject> currentList = courseHash.get(o.getCourse());
                currentList.add(o);
                courseHash.put(o.getCourse(), currentList);
            }
        }
        return courseHash;
    }

    private static void showAggregateCourses(HashMap<String, ArrayList<courseObject>> courseHashMap) {
        //TreeMap is used because it stores them sorted automatically
        TreeMap<String, ArrayList<courseObject>> courseTreeMap = new TreeMap<>(courseHashMap);
        courseTreeMap.forEach((k, v) -> {

            courseObject tempAggregateObj = new courseObject(v.get(0).getCourse(),v.get(0).getSection(),v.get(0).getTitle(), v.get(0).getNStudents(), v.get(0).getNSeats(), v.get(0).getInstructor(), v.get(0).getYear());
            int tempOffered = 0;

            boolean first = true;
            for(courseObject o: v){
                tempOffered++;
                if (first){
                    first = false;
                    continue;
                }
                tempAggregateObj.setNSeats(tempAggregateObj.getNSeats()+o.getNSeats());
                tempAggregateObj.setNStudents(tempAggregateObj.getNStudents()+o.getNStudents());
                tempAggregateObj.setInstructor(tempAggregateObj.getInstructor() + "," +
                        o.getInstructor());
            }
            String[] duplicateInstructors = tempAggregateObj.getInstructor().split(",");
            String[] distinctInstructors = Arrays.stream(duplicateInstructors).distinct().toArray(String[]::new);
            Arrays.sort(distinctInstructors);
            System.out.printf("\n Cid:%s Title:%s Offered:%s Students:%s Seats:%s Instructors:%s", tempAggregateObj.getCourse(), tempAggregateObj.getTitle(), tempOffered, tempAggregateObj.getNStudents(), tempAggregateObj.getNSeats(), Arrays.toString(distinctInstructors));
        });
    }

    private static void showMatchingCourses(String userInput, HashMap<String, ArrayList<courseObject>> courseHashMap) {
        if(!courseHashMap.containsKey(userInput)){
            System.out.printf("\nNo Courses for: %s", userInput);
        }
        else{
            ArrayList<courseObject> currentList = courseHashMap.get(userInput);
            //Sort by year
            currentList.sort(new Comparator<courseObject>() {
                @Override
                public int compare(courseObject o1, courseObject o2) {
                    return o1.getYear() - o2.getYear(); // Ascending
                }
            });

            System.out.printf("\n----Showing courses for ID:%s", userInput);
            for(courseObject o: currentList){
                System.out.printf("\n Course:%s Year:%s Section:%s, Title:%s Students:%s Seats:%s Instructor:%s", o.getCourse(), o.getYear(), o.getSection(), o.getTitle(), o.getNStudents(), o.getNSeats(), o.getInstructor());            }
        }
    }

}
