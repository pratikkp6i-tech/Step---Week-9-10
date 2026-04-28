package level2;

import java.util.Scanner;

public class WordLengthMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[] words = customSplit(input);
        String[][] matrix = generate2DArray(words);

        System.out.println("\nWORD\t\tLENGTH");
        System.out.println("----------------------");
        for (String[] row : matrix) {
            // Converting String length back to Integer for display as requested
            int len = Integer.parseInt(row[1]);
            System.out.println(row[0] + "\t\t" + len);
        }
    }

    public static String[] customSplit(String text) {
        return text.split(" "); // Reusing logic for brevity
    }

    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) { str.charAt(count); count++; }
        } catch (Exception e) { return count; }
    }

    public static String[][] generate2DArray(String[] words) {
        String[][] data = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            data[i][0] = words[i];
            // Using String.valueOf() to store number in String array
            data[i][1] = String.valueOf(getLength(words[i]));
        }
        return data;
    }
}