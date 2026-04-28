package level2;

import java.util.Scanner;
import java.util.Arrays;

public class WordSplitter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] manualWords = customSplit(input);
        String[] builtInWords = input.split(" ");

        boolean isEqual = compareArrays(manualWords, builtInWords);
        
        System.out.println("Manual Split: " + Arrays.toString(manualWords));
        System.out.println("Built-in Split: " + Arrays.toString(builtInWords));
        System.out.println("Are results identical? " + isEqual);
    }

    public static String[] customSplit(String text) {
        int spaceCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') spaceCount++;
        }

        // Array to store indexes of spaces
        int[] spaceIndexes = new int[spaceCount];
        int k = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[k++] = i;
            }
        }

        String[] words = new String[spaceCount + 1];
        int start = 0;
        for (int i = 0; i < spaceCount; i++) {
            words[i] = text.substring(start, spaceIndexes[i]);
            start = spaceIndexes[i] + 1;
        }
        words[spaceCount] = text.substring(start); // Last word
        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        return Arrays.equals(arr1, arr2);
    }
}