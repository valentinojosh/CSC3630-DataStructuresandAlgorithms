import java.util.ArrayList;
import java.util.HashMap;

public class FEManagers {
    public static void main(String[] args) {
        ArrayList<String> dataSet = getManagerData();
        //ToDo: Write this method with to transform dataset to a results data structure
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, ArrayList<String>> results = populateResult( dataSet );
        //ToDo: Write this method to show the results
        showResults ( results);
    }

    private static void showResults(HashMap<String, ArrayList<String>> results) {
        results.entrySet().forEach(entry -> {
            System.out.println("\n"+ entry.getKey() + "->" + entry.getValue().toString());
        });
    }

    private static HashMap<String, ArrayList<String>> populateResult(ArrayList<String> dataSet) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : dataSet){
            String[] toks = s.split(",");

            if(!map.containsKey(toks[1])){
                ArrayList<String> myList = new ArrayList<String>();
                myList.add(toks[0]);
                map.put(toks[1], myList);
            }
            else{
                ArrayList<String> myList2 = map.get(toks[1]);
                myList2.add(toks[0]);
                map.replace(toks[1], myList2);
            }
        }
        return map;
    }

    private static ArrayList<String> getManagerData() {
        ArrayList<String> dataSet = new ArrayList<>();
        dataSet.add("Abbey,Clyde");
        dataSet.add("Becky,Clyde");
        dataSet.add("Clyde,Frank");
        dataSet.add("Doug,Edger");
        dataSet.add("Edger,Frank");
        dataSet.add("Frank,Frank");
        dataSet.add("George,Clyde");
        return dataSet;
    }
}
