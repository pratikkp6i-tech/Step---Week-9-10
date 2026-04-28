package level3;

import java.util.Scanner;

public class UniqueCharFinder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // c. Call methods and display result
        char[] uniqueChars = findUniqueChars(input);
        
        System.out.print("Unique characters: ");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
    }

    // a. Find length without using .length()
    public static int getCustomLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    // b. Find unique characters using charAt() and nested loops
    public static char[] findUniqueChars(String text) {
        int len = getCustomLength(text);
        char[] tempArray = new char[len];
        int uniqueCount = 0;

        // ii. Nested loop logic
        for (int i = 0; i < len; i++) {
            char currentChar = text.charAt(i);
            boolean isAlreadyFound = false;

            // Check if character appeared previously in the string
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isAlreadyFound = true;
                    break;
                }
            }

            // If it's the first time we see this character, store it
            if (!isAlreadyFound) {
                tempArray[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        // iii. Create a new array of the exact size needed
        char[] finalArray = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            finalArray[i] = tempArray[i];
        }
        return finalArray;
    }
}