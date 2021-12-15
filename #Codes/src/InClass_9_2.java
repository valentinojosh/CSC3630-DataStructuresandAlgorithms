import java.util.ArrayList;

public class InClass_9_2 {
    public static void main(String[] args) {
        String[] cats = {"Meat", "Bannana", "Chicken", "Pizza"};
        System.out.printf("first item:%s", cats[0]);
        cats[3] = "Grapes";
        ArrayList<Integer> myNumbs = new ArrayList<>(200);
        myNumbs.add(12);

        ArrayList<String> myString = new ArrayList<>(300);
        myString.add("Corn");
        myString.add("Cheese");
        myString.add("Taco");
        myString.add("Turtle");
        myString.add("Meow");
        myString.add("Yeet");
        System.out.printf("3rd string item:%s", myString.get(2));
//        myString.remove(3);
//        System.out.printf("myString is:%s", myString.toString());
//        String item12 = myString.get(12);

        for(String item : myString){
            System.out.printf("\n Item:%s", item);
            if(item.equals("Corn")){
                System.out.printf("\n---------CORN IS HERE-----------");
            }
            if(item.equals("Yeet")){
                System.out.printf("\n---------Y33 Y33 Y33 MATE-----------");
            }
        }

    }
}
