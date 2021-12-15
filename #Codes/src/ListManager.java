import java.util.Arrays;

public class ListManager {
    //This is the object class
    private int[] inList;

    public ListManager(int[] inList) {
        this.inList = inList;
    }

    public int[] getInList() {
        return inList;
    }

    public void setInList(int[] inList) {
        this.inList = inList;
    }

    public int getLargest(){
        if (inList.length <= 0){
            System.out.printf("The array is missing");
            System.exit(1);
        }

        int largest = inList[0];
        for( int item : inList){
            if(item>largest){
                largest = item;
            }
        }
        return largest;

    }

    public int getSmallest() {
        if (inList.length <= 0){
            System.out.printf("The array is missing");
            System.exit(1);
        }

        int smallest = inList[0];
        for( int item : inList){
            if(item<smallest){
                smallest = item;
            }
        }
        return smallest;
    }

    public int secondLargest( ) {
        // ToDo: Return the second largest item in the myList array
        //  for example if myList = { 5, 3, 9, 8 } you would return 8
        int ret = 0;
        if (inList.length <= 0){
            System.out.printf("The array is missing");
            System.exit(1);
        }
        else if (inList.length == 1){
            ret = inList[0];
        }
        else {
            int temp;
            for (int i=0; i < inList.length; i++){
                for (int j= i+1; j < inList.length; j++){
                    if (inList[i] > inList[j]){
                        temp = inList[i];
                        inList[i] = inList[j];
                        inList[j] = temp;
                    }
                }
            }
            ret = inList[inList.length-2];
        }
        return ret;
    }

    public int[] getOddBiggerThan(int item){
        if (inList.length <= 0){
            System.out.printf("The array is missing");
            System.exit(1);
        }
        int newarraylength = 0;
        for (int i = 0; i< inList.length; i++){
            if( (inList[i] > item) && (inList[i] % 2 != 0) ){
                newarraylength++;
            }
        }
        int[] temp = new int[newarraylength];
        int j = 0;
        for (int i = 0; i< inList.length; i++){
            if( (inList[i] > item) && (inList[i] % 2 != 0) ){
                temp[j] = inList[i];
                j++;
            }
        }
        return temp;
    }
}
