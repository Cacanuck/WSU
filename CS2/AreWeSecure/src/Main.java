public class Main {

    public static void main(String[] args) {

        User user1 = new User("Michelle", "12345");
        System.out.println("1. " + user1.isValidPassword()); // false -- less than 8 characters

        User user2 = new User("Michelle", "12345Michelle");
        System.out.println("2. " + user2.isValidPassword()); // false -- contains username

        User user3 = new User("Michelle", "12345678");
        System.out.println("3. " + user3.isValidPassword()); // true

        System.out.println("4. " + user2.authenticate("ABCDE")); // false -- incorrect password
        System.out.println("5. " + user2.authenticate("12345Michelle")); // true

        System.out.println("6. " + user3.authenticate("12345678")); // true

        User user4 = new SecureUser("Michelle", "hello123");//

        System.out.println("7. " + user4.isValidPassword());// True

        System.out.println("8. " + user4.authenticate("hello"));// False
        System.out.println("9. " + user4.authenticate("hello12"));// False
        System.out.println("10. " + user4.authenticate("hello123"));// True
        System.out.println("11. " + user4.authenticate("Hello123"));// False
        System.out.println("w. " + user4.authenticate("hello123"));// True
        System.out.println("12. " + user4.authenticate("hello12"));// False
        System.out.println("13. " + user4.authenticate("hello"));// False
        System.out.println("14. " + user4.authenticate("hello123"));// False
    }

}