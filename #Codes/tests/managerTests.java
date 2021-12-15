import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class managerTests {
    @Test
    public void testLargest1() {
        int [] myList = {2, 4, 6, 8, 9, -1, 0};
        ListManager lm = new ListManager(myList);
        assertEquals( 9, lm.getLargest());
    }
    @Test
    public void testLargestNeg(){
        int [] myList = {-1, -2, -5, -3, -3};
        ListManager lm = new ListManager(myList);
        assertEquals( -1, lm.getLargest());
    }

    // Test for second method
    @Test
    public void testSmallest(){
        int [] myList = {-1, -2, -5, -3, -3};
        ListManager lm = new ListManager(myList);
        assertEquals( -5, lm.getSmallest());
    }

    @Test
    public void testSecondLargest(){
        int [] myList = {1, 2, 5, 6, 3};
        ListManager lm = new ListManager(myList);
        assertEquals( 5, lm.secondLargest());
    }

    @Test
    public void getOddBiggerThan(){
        int [] myList = {1, 2, 5, 6, 3};
        ListManager lm = new ListManager(myList);
        int [] compare = {5};
        Assert.assertArrayEquals(compare, lm.getOddBiggerThan(3));
    }

}
