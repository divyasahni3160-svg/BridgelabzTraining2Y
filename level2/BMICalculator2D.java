import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = scanner.nextInt();

        // personData columns: [0] = weight, [1] = height, [2] = BMI
        double[][] personData = new double[n][3];
        String[] weightStatus = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.print("Enter weight (kg): ");
            double weight = scanner.nextDouble();
            System.out.print("Enter height (meters): ");
            double height = scanner.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.out.println("Invalid values. Please enter positive values.");
                i--;
                continue;
            }

            double bmi = weight / (height * height);

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;

            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25.0) {
                weightStatus[i] = "Normal";
            } else if (bmi < 30.0) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\n--- 2D Array BMI Report ---");
        for (int i = 0; i < personData.length; i++) {
            System.out.printf("Person %d -> Height: %.2f m, Weight: %.2f kg, BMI: %.2f, Status: %s\n",
                    (i + 1), personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }

        scanner.close();
    }
}
