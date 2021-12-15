public class ListManager_FromLash {
    private int[] myList;

    public ListManager_FromLash(int[] myList) {
        this.myList = myList;
    }
    public int getLargestFixed( ) {
        int max = Integer.MIN_VALUE;
        if ( myList.length > 0 ) {
            max = myList[0];
        }
        for( int i=0; i< myList.length; i++ ){
            if ( myList[i] > max ){
                max=myList[i];
            }
        }
        return max;
    }
    // Lets do TDD for get Smallest
    // 1. Write the signater
    // 2. make test work ... and test completely-
    // 3. does it work right? Fix it .. find the bug and fix it
    public int getSmallest(  ) {
        int small = myList[0];
        for ( int item : myList ) {
            if ( item < small ) {
                small = item;
            }
        }
       return small;
    }
    public int secondLargest( ) {
        // ToDo: Return the second largest item in the myList array
        //  for example if myList = { 5, 3, 9, 8 } you would return 8
        int ret = 0;
        return ret;
    }
    //public int[] getOddBiggerThan( int item ) {
        // ToDo: Return the an array of odd items in the list bigger than item
        //  for example if myList = { 5, 3, 9, 8, 5, 7, 2 } and item is 3 return 5, 7, 9
        // do not return more items than there are negative numbers > item ... do not use arrayLists
    //    int[] ret;
    //    return ret;
    //}
}
