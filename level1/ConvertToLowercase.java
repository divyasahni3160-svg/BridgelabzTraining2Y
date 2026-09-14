import java.util.Scanner;

public class ConvertToLowercase {

    // User-defined method to convert uppercase characters to lowercase using ASCII difference (32)
    public static String toLower(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                // Add 32 to uppercase ASCII value to get lowercase
                result.append((char) (ch + 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // User-defined method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String text = scanner.nextLine();

        // Custom lowercase conversion
        String customLower = toLower(text);

        // Built-in toLowerCase() conversion
        String builtInLower = text.toLowerCase();

        // Compare both strings
        boolean isIdentical = compareStrings(customLower, builtInLower);

        System.out.println("\nCustom Lowercase: " + customLower);
        System.out.println("Built-in Lowercase: " + builtInLower);
        System.out.println("Do both results match? " + isIdentical);

        scanner.close();
    }
}
