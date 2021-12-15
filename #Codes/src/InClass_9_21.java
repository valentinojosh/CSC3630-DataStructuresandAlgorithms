public class InClass_9_21 {
    public static int main(String[] args) {
        String row = "Apple,Baker,C10";
        String[] toks = row.split(",");
        String name1= toks[0];
        String name2= toks[1];
        try {
            int numb1 = Integer.parseInt(toks[2]);
        } catch (Exception e ) {
            System.out.printf("hello");
        }
        return 1;
    }
}
