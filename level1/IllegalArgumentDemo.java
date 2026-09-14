import java.util.Scanner;

public class IllegalArgumentDemo {

    // Method to generate the exception
    public static void generateException(String text) {
        // Setting start index greater than end index throws IndexOutOfBoundsException / IllegalArgumentException
        String sub = text.substring(3, 1);
        System.out.println("Substring: " + sub);
    }

    // Method to demonstrate and handle the exception
    public static void handleException(String text) {
        try {
            // Passing start index greater than end index
            String sub = text.substring(3, 1);
            System.out.println("Substring: " + sub);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught IndexOutOfBoundsException (subclass): " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text (at least 4 characters): ");
        String text = scanner.next();

        System.out.println("\nHandling Exception:");
        handleException(text);

        // Uncomment below to test abrupt program termination:
        // generateException(text);

        scanner.close();
    }
}
