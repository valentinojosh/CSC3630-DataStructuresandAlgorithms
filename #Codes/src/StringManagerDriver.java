public class StringManagerDriver {
    public static void main(String[] args) {
        StringManagerInClass sm = new StringManagerInClass("Hey");
        System.out.printf("The String I just set is:%s", sm.getTheString());
        sm.setTheString("Pancakes");

        String myString = "Apple";
        myString += " Pie";
        //this is basically copy and pasting the same string ovr n ovr just adding x, using more and more memory
        for (int i=0; i<1000; i++){
            myString += "x";
        }

        //this is not duplicating the string, therefore it saves memory
        StringBuilder myString2 = new StringBuilder("Apple");
        for (int i=0; i<1000; i++){
            myString2.append("x");
        }
        System.out.printf("\n MyString is:%s", myString2.toString() );

    }
}
