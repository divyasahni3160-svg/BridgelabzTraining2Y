public class NullPointerDemo {

    // Method to intentionally generate NullPointerException
    public static void generateException() {
        String text = null;
        // Calling a method on a null reference triggers NullPointerException
        System.out.println("String length: " + text.length());
    }

    // Method to demonstrate and handle NullPointerException with try-catch
    public static void handleException() {
        String text = null;
        try {
            System.out.println("Attempting to access string length...");
            System.out.println("String length: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException successfully: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Calling handleException():");
        handleException();

        // Uncomment the line below to see an unhandled runtime crash:
        // generateException();
    }
}
