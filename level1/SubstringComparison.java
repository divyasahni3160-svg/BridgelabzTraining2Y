import java.util.Scanner;

public class SubstringComparison {

    // User-defined method to create a substring using charAt()
    public static String createSubstring(String text, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    // User-defined method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = scanner.next();

        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        // Validation for bounds
        if (start < 0 || end > text.length() || start > end) {
            System.err.println("Invalid start or end indices.");
            scanner.close();
            return;
        }

        // Custom substring
        String customSub = createSubstring(text, start, end);

        // Built-in substring
        String builtInSub = text.substring(start, end);

        System.out.println("\nCustom Substring: " + customSub);
        System.out.println("Built-in Substring: " + builtInSub);

        // Compare both substrings
        boolean isEqual = compareStrings(customSub, builtInSub);
        System.out.println("Are both substrings identical? " + isEqual);

        scanner.close();
    }
}
