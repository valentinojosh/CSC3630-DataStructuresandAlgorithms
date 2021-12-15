public class booleanTest {
    public static boolean weekday;
    public static boolean vacation;
    public boolean sleepIn() {
        //The simplified version that IntelliJ suggests is better, but I kept my original code for reference of my though process
        if((!weekday)||(vacation)){
            return true;
        }
        else{
            return false;
        }
    }
}
