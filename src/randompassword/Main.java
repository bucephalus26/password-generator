package randompassword;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Ask user how many passwords they want
        System.out.println("How many passwords do you want? ");
        int numberOfPasswords = in.nextInt();

        // Ask user length of password
        System.out.println("How many characters long do you want your random password to be? ");
        int passwordLength = in.nextInt();

        // Password must be at least 3 characters long. Ask again if it is not
        while (passwordLength < 3) {
            System.out.println("Your password must be at least 3 characters long. Please enter a new password length.");
            passwordLength = in.nextInt();
        }
        // Ask user for password type
        System.out.println("What type of password do you want to generate?\n" +
                "1. Lowercase\n" +
                "2. Uppercase\n" +
                "3. Numeric\n" +
                "4. Lowercase and Uppercase\n" +
                "5. Lowercase, Uppercase, and Numeric\n" +
                "6. Lowercase, Uppercase, Numeric, and Special Characters");

        int passwordType = in.nextInt();

        // Create passwordGenerator object and submit user input to constructor
        PasswordGenerator passwordGenerator = new PasswordGenerator(numberOfPasswords, passwordLength, passwordType);

        String[] passwords = new String[numberOfPasswords];
        // Generate and print out the passwords
        for (int i = 0; i < numberOfPasswords; i++) {
            System.out.println(passwordGenerator.passwords());

            passwords[i] = passwordGenerator.passwords();
        }
    }
}
