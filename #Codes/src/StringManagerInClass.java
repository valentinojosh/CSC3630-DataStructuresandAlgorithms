public class StringManagerInClass {
    //string global to the class: attributes or property
    private String theString;

    public String getTheString() {
        return theString;
    }

    public void setTheString(String theString) {
        this.theString = theString;
    }

    public StringManagerInClass(String theString) {
        this.theString = theString;
    }

    public int howManyOfThese(char tok){
        //Count how many times tok appears in theString
        int numTimes = 0;
        for(int i = 0; i<theString.length();i++){
           if (theString.charAt(i) == tok){
               numTimes++;
           }
        }
        return numTimes;
    }
}
