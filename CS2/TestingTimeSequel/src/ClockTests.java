import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class ClockTests {

    @Test // Test 1: c1 is a.m. and c2 is p.m.
    public void checkTest1() {
        Clock c1 = new Clock(3, 20, "a.m.");
        Clock c2 = new Clock(3, 20, "p.m.");
        Clock result = Clock.getEarlier(c1, c2);
        assertEquals(result, c1);
    }

    @Test // Test 2: c1 is p.m. and c2 is a.m.
    public void checkTest2() {
        Clock c1 = new Clock(4, 10, "p.m.");
        Clock c2 = new Clock(4, 10, "a.m.");
        Clock result = Clock.getEarlier(c1, c2);
        assertEquals(result, c2);
    }

    @Test // Test 3: c1 is 12:00 p.m. and c2 is 1:00 p.m.
    public void checkTest3() {
        Clock c1 = new Clock(12, 0, "p.m.");
        Clock c2 = new Clock(1, 0, "p.m.");
        Clock result = Clock.getEarlier(c1, c2);
        assertEquals(result, c1);
    }

    @Test // Test 4: c1 is 1:00 p.m. and c2 is 12:00 p.m.
    public void checkTest4() {
        Clock c1 = new Clock(1, 0, "p.m.");
        Clock c2 = new Clock(12, 0, "p.m.");
        Clock result = Clock.getEarlier(c1, c2);
        assertEquals(result, c2);
    }

    @Test // Test 5: c1 is 6:00 a.m. and c2 is 7:00 a.m.
    public void checkTest5() {
        Clock c1 = new Clock(6, 0, "a.m.");
        Clock c2 = new Clock(7, 0, "a.m.");
        Clock result = Clock.getEarlier(c1, c2);
        assertEquals(result, c1);
    }

    @Test // Test 6: c1 is 7:00 a.m. and c2 is 6:00 a.m.
    public void checkTest6() {
        Clock c1 = new Clock(7, 0, "a.m.");
        Clock c2 = new Clock(6, 0, "a.m.");
        Clock result = Clock.getEarlier(c1, c2);
        assertEquals(result, c2);
    }

    @Test // Test 7: c1 is 7:30 p.m. and c2 is 7:40 p.m.
    public void checkTest7() {
        Clock c1 = new Clock(7, 30, "p.m.");
        Clock c2 = new Clock(7, 40, "p.m.");
        Clock result = Clock.getEarlier(c1, c2);
        assertEquals(result, c1);
    }

    @Test // Test 8: c1 is 7:40 a.m. and c2 is 7:30 a.m.
    public void checkTest8() {
        Clock c1 = new Clock(7, 40, "a.m.");
        Clock c2 = new Clock(7, 30, "a.m.");
        Clock result = Clock.getEarlier(c1, c2);
        assertEquals(result, c2);
    }

    @Test // Test 9: c1 is 8:32 p.m. and c2 is 8:32 p.m.
    public void checkTest9() {
        Clock c1 = new Clock(8, 32, "p.m.");
        Clock c2 = new Clock(8, 32, "p.m.");
        Clock result = Clock.getEarlier(c1, c2);
        assertEquals(result, c1);
    }

    @Test // Test 10: c2 is 8:32 a.m. and c1 is 8:32 a.m.
    public void checkTest10() {
        Clock c1 = new Clock(8, 32, "a.m.");
        Clock c2 = new Clock(8, 32, "a.m.");
        Clock result = Clock.getEarlier(c1, c2);
        assertNotEquals(result, c2);
    }

}
