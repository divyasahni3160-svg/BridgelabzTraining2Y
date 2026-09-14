import java.util.Scanner;

public class LargestDigitsFixed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        long number = scanner.nextLong();

        if (number <= 0) {
            System.err.println("Invalid number. Please enter a positive value.");
            scanner.close();
            return;
        }

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Store up to 10 digits
        while (number != 0) {
            digits[index] = (int) (number % 10);
            number /= 10;
            index++;
            if (index == maxDigit) {
                break;
            }
        }

        // Find largest and second largest
        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);

        scanner.close();
    }
}
