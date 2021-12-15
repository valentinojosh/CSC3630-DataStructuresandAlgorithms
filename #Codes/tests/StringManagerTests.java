import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StringManagerTests {
    @Test
    public void StringManagerTest1(){
        //sm is an object created using the class, StringManagerInClass
        // and we pass "Breadman" into the constructor
        StringManagerInClass sm = new StringManagerInClass("Breadman");
        int ct = sm.howManyOfThese('e');
        assertEquals(1, ct);
    }
    @Test
    public void StringManagerNull(){
        StringManagerInClass sm = new StringManagerInClass("");
        int ct = sm.howManyOfThese('e');
        assertEquals(0, ct);
    }
}
