package level1;

import java.util.Scanner;

public class StringComparison {
    public static void main(String[] args) {
        // a. Take user input using Scanner next() method
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.next();
        System.out.print("Enter second string: ");
        String s2 = sc.next();

        // b. Call the custom method to compare using charAt()
        boolean customResult = compareUsingCharAt(s1, s2);
        
        // c. Use the built-in String method equals()
        boolean builtInResult = s1.equals(s2);

        System.out.println("\n--- Results ---");
        System.out.println("Custom charAt() comparison: " + customResult);
        System.out.println("Built-in .equals() method: " + builtInResult);
        
        sc.close();
    }

    // b. Method to compare two strings using the charAt() method
    public static boolean compareUsingCharAt(String str1, String str2) {
        // First, check if lengths are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Compare each character one by one
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true; // If the loop finishes, the strings are identical
    }
}