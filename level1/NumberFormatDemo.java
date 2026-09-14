import java.util.Scanner;

public class NumberFormatDemo {

    // Method to generate the exception
    public static void generateException(String text) {
        // Trying to parse non-numeric string throws NumberFormatException
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }

    // Method to demonstrate and handle the exception
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter non-numeric text (e.g. 'hello'): ");
        String text = scanner.next();

        System.out.println("\nHandling Exception:");
        handleException(text);

        // Uncomment below to test abrupt program termination:
        // generateException(text);

        scanner.close();
    }
}
