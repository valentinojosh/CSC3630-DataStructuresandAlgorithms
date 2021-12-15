import java.util.HashSet;
import java.util.Set;

public class HashSet_10_5 {
    public static void main(String[] args) {

        Set<String> mySet = new HashSet<>();
        //Set<String> mySet = new TreeSet<>();
        //Set<String> mySet = new LinkedHashSet<>();
        mySet.add("1");
        mySet.add("2");
        mySet.add("3");
        mySet.add("4");
        mySet.add("4");
        //redundant additions dont increase total size
        String item = "1222";
        System.out.printf("\nNumber of items: %s", mySet.size());
        if(mySet.contains(item)){
            System.out.printf("\nYes we have: %s", item);
        } else{
            System.out.printf("\nNo we don't have: %s", item);
        }
        showMeTheItems(mySet);

        if( mySet.remove("3")){
            System.out.printf("\nRemoved: 3");
        }
        if( mySet.remove("yeeeet")){
            System.out.printf("\nRemoved: yeeeet");
        }else{
            System.out.printf("\nyeeeet is not found");
        }
    }

    private static void showMeTheItems(Set<String> mySet) {
        for(String item : mySet){
            System.out.printf("\nItem: %s", item);
        }
    }
}
