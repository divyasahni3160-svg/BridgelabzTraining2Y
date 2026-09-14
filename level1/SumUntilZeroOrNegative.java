import java.util.Scanner;

public class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] values = new double[10];
        int index = 0;

        System.out.println("Enter numbers (enter 0 or a negative number to stop, max 10):");
        while (true) {
            if (index == 10) {
                System.out.println("Array capacity reached (max 10).");
                break;
            }

            System.out.print("Enter value: ");
            double entry = scanner.nextDouble();

            if (entry <= 0) {
                break;
            }

            values[index] = entry;
            index++;
        }

        // Calculate sum and display stored values
        double total = 0.0;
        System.out.println("\nStored elements:");
        for (int i = 0; i < index; i++) {
            System.out.println("Value " + (i + 1) + ": " + values[i]);
            total += values[i];
        }

        System.out.println("Total Sum: " + total);

        scanner.close();
    }
}
