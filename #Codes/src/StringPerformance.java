public class StringPerformance {
    public static void main(String[] args) {
        int nTimes = 1000000;
        long start1 = System.currentTimeMillis();
        String theString = createMeAString(nTimes);
        long end1 = System.currentTimeMillis();
        System.out.printf("\nString: \n time:%s milliseconds", end1-start1);
        if(end1-start1 > 60000){
            double yeet = (end1-start1)/60000;
            System.out.printf("\ntime:%s minutes", yeet);
        }

        long start2 = System.currentTimeMillis();
        String theString2 = createMeAStringBuffer(nTimes);
        long end2 = System.currentTimeMillis();
        System.out.printf("\nStringBuilder: \n time:%s seconds", end2-start2);
    }

    private static String createMeAString(int nTimes) {
        String myString = "";
        for(int i = 0; i<nTimes; i++){
            myString += "X";
        }
        return myString;
    }

    private static String createMeAStringBuffer(int nTimes) {
        StringBuilder myString = new StringBuilder("");
        for(int i = 0; i<nTimes; i++){
            myString.append("X");
        }
        return myString.toString();
    }
}
