import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    // Method to generate the exception
    public static void generateException(String text) {
        // Accessing index equal to length throws StringIndexOutOfBoundsException
        char ch = text.charAt(text.length());
        System.out.println("Character: " + ch);
    }

    // Method to demonstrate and handle the exception
    public static void handleException(String text) {
        try {
            char ch = text.charAt(text.length());
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.next();

        System.out.println("\nHandling Exception:");
        handleException(text);

        // Uncomment below to test abrupt program termination:
        // generateException(text);

        scanner.close();
    }
}
