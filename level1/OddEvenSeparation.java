import java.util.Scanner;

public class OddEvenSeparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        // Validate natural number
        if (number <= 0) {
            System.err.println("Error: Please enter a natural number (greater than 0).");
            scanner.close();
            return;
        }

        int arraySize = (number / 2) + 1;
        int[] evenNumbers = new int[arraySize];
        int[] oddNumbers = new int[arraySize];

        int evenIndex = 0;
        int oddIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        // Display odd numbers
        System.out.print("Odd Numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        System.out.println();

        // Display even numbers
        System.out.print("Even Numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
