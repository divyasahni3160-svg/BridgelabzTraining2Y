import java.util.Scanner;

public class CharacterTypeTable {

    // Check character type using ASCII conversion
    public static String checkCharType(char ch) {
        char lower = ch;
        if (ch >= 'A' && ch <= 'Z') {
            lower = (char) (ch + 32);
        }

        if (lower >= 'a' && lower <= 'z') {
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Returns a 2D array of character and its type
    public static String[][] classifyCharacters(String text) {
        String[][] table = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            table[i][0] = String.valueOf(ch);
            table[i][1] = checkCharType(ch);
        }
        return table;
    }

    // Method to display the 2D array in tabular format
    public static void displayTable(String[][] table) {
        System.out.println("\n----------------------------");
        System.out.printf("%-10s | %-15s\n", "Character", "Type");
        System.out.println("----------------------------");
        for (int i = 0; i < table.length; i++) {
            System.out.printf("%-10s | %-15s\n", table[i][0], table[i][1]);
        }
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] table = classifyCharacters(text);
        displayTable(table);

        scanner.close();
    }
}
