import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class booleanTests {
    @Test
    public void yesWeekdayNoVacation(){
       booleanTest.weekday = true;
       booleanTest.vacation = false;
       booleanTest bm = new booleanTest();
       assertEquals(false, bm.sleepIn());
    }
    @Test
    public void yesWeekdayYesVacation(){
        booleanTest.weekday = true;
        booleanTest.vacation = true;
        booleanTest bm = new booleanTest();
        assertEquals(true, bm.sleepIn());
    }
    @Test
    public void noWeekdayNoVacation(){
        booleanTest.weekday = false;
        booleanTest.vacation = false;
        booleanTest bm = new booleanTest();
        assertEquals(true, bm.sleepIn());
    }
    @Test
    public void noWeekdayYesVacation(){
        booleanTest.weekday = false;
        booleanTest.vacation = true;
        booleanTest bm = new booleanTest();
        assertEquals(true, bm.sleepIn());
    }
}
