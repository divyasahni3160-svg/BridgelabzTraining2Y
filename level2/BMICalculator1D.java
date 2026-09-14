import java.util.Scanner;

public class BMICalculator1D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = scanner.nextInt();

        double[] weights = new double[n];
        double[] heights = new double[n];
        double[] bmis = new double[n];
        String[] statuses = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.print("Enter weight (kg): ");
            weights[i] = scanner.nextDouble();
            System.out.print("Enter height (meters): ");
            heights[i] = scanner.nextDouble();

            if (weights[i] <= 0 || heights[i] <= 0) {
                System.out.println("Invalid values. Must be positive. Re-enter.");
                i--;
                continue;
            }

            // BMI = weight / (height * height)
            bmis[i] = weights[i] / (heights[i] * heights[i]);

            if (bmis[i] < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmis[i] < 25.0) {
                statuses[i] = "Normal";
            } else if (bmis[i] < 30.0) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }

        System.out.println("\n--- Person Health Report ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d -> Height: %.2f m, Weight: %.2f kg, BMI: %.2f, Status: %s\n",
                    (i + 1), heights[i], weights[i], bmis[i], statuses[i]);
        }

        scanner.close();
    }
}
