package level3;

import java.util.Scanner;

public class BMIOrganization {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] measurements = new double[10][2];

        // a. Take user input for 10 members
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            measurements[i][0] = sc.nextDouble();
            System.out.print("Height (cm): ");
            measurements[i][1] = sc.nextDouble();
        }

        // c & e. Process data and display
        String[][] report = processData(measurements);
        displayTable(report);
    }

    // b. Method to find BMI and Status for one person
    public static String[] getBMIAndStatus(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        String status;

        if (bmi <= 18.4) status = "Underweight";
        else if (bmi <= 24.9) status = "Normal";
        else if (bmi <= 39.9) status = "Overweight";
        else status = "Obese";

        return new String[]{String.format("%.2f", bmi), status};
    }

    // c. Method to create the full 2D String array
    public static String[][] processData(double[][] data) {
        String[][] results = new String[10][4];
        for (int i = 0; i < 10; i++) {
            String[] bmiInfo = getBMIAndStatus(data[i][0], data[i][1]);
            results[i][0] = String.valueOf(data[i][1]); // Height
            results[i][1] = String.valueOf(data[i][0]); // Weight
            results[i][2] = bmiInfo[0];                // BMI
            results[i][3] = bmiInfo[1];                // Status
        }
        return results;
    }

    // d. Method to display in tabular format
    public static void displayTable(String[][] table) {
        System.out.println("\n-----------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height", "Weight", "BMI", "Status");
        System.out.println("-----------------------------------------------------------");
        for (String[] row : table) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", row[0], row[1], row[2], row[3]);
        }
    }
}