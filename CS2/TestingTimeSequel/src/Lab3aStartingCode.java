public class Lab3aStartingCode {
    public static void main(String[] args) {

        System.out.println();
        /*
         * Test 1: c1 is a.m. and c2 is p.m.
         * 
         * Test 2: c1 is p.m. and c2 is a.m.
         * 
         * Test 3: c1 is 12:00 p.m. and c2 is 1:00 p.m.
         * 
         * Test 4: c1 is 1:00 p.m. and c2 is 12:00 p.m.
         * 
         * Test 5: c1 is 6:00 a.m. and c2 is 7:00 a.m.
         * 
         * Test 6: c1 is 7:00 a.m. and c2 is 6:00 a.m.
         * 
         * Test 7: c1 is 7:30 p.m. and c2 is 7:40 p.m.
         * 
         * Test 8: c1 is 7:40 a.m. and c2 is 7:30 a.m.
         * 
         * Test 9: c1 is 8:32 p.m. and c2 is 8:32 p.m.
         * 
         * Test 10: c2 is 8:32 a.m. and c1 is 8:32 a.m.
         */

        // Test 1
        Clock clock1 = new Clock(3, 20, "a.m.");
        Clock clock2 = new Clock(3, 20, "p.m.");
        Clock result1 = Clock.getEarlier(clock1, clock2);
        System.out.println("Test 1: " + result1);// 3:20 a.m., c1

        // Test 2
        Clock clock3 = new Clock(4, 10, "p.m.");
        Clock clock4 = new Clock(4, 10, "a.m.");
        Clock result2 = Clock.getEarlier(clock3, clock4);
        System.out.println("Test 2: " + result2);// 4:10 a.m., c4

        // Test 3
        Clock clock5 = new Clock(12, 0, "p.m.");
        Clock clock6 = new Clock(1, 0, "p.m.");
        Clock result3 = Clock.getEarlier(clock5, clock6);
        System.out.println("Test 3: " + result3);// 12:00 p.m., c5

        // Test 4
        Clock clock7 = new Clock(1, 0, "p.m.");
        Clock clock8 = new Clock(12, 0, "p.m.");
        Clock result4 = Clock.getEarlier(clock7, clock8);
        System.out.println("Test 4: " + result4);// 12:00 p.m., c8

        // Test 5
        Clock clock9 = new Clock(6, 0, "a.m.");
        Clock clock10 = new Clock(7, 0, "a.m.");
        Clock result5 = Clock.getEarlier(clock9, clock10);
        System.out.println("Test 5: " + result5);// 6:00 a.m., c9

        // Test 6
        Clock clock11 = new Clock(7, 0, "a.m.");
        Clock clock12 = new Clock(6, 0, "a.m.");
        Clock result6 = Clock.getEarlier(clock11, clock12);
        System.out.println("Test 6: " + result6);// 6:00 a.m., c12

        // Test 7
        Clock clock13 = new Clock(7, 30, "p.m.");
        Clock clock14 = new Clock(7, 40, "p.m.");
        Clock result7 = Clock.getEarlier(clock13, clock14);
        System.out.println("Test 7: " + result7);// 7:30 p.m., c13

        // Test 8
        Clock clock15 = new Clock(7, 40, "a.m.");
        Clock clock16 = new Clock(7, 30, "a.m.");
        Clock result8 = Clock.getEarlier(clock15, clock16);
        System.out.println("Test 8: " + result8);// 7:30 a.m., c16

        // Test 9
        Clock clock17 = new Clock(8, 32, "p.m.");
        Clock clock18 = new Clock(8, 32, "p.m.");
        Clock result9 = Clock.getEarlier(clock17, clock18);
        System.out.println("Test 9: " + result9);// 8:32 p.m.

        // Test 10
        Clock clock19 = new Clock(8, 32, "a.m.");
        Clock clock20 = new Clock(8, 32, "a.m.");
        Clock result10 = Clock.getEarlier(clock19, clock20);
        System.out.println("Test 10: " + result10);// 8:32 a.m.

        System.out.println();
    }
}
