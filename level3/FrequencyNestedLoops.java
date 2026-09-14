import java.util.Scanner;

public class FrequencyNestedLoops {

    // Method to compute frequencies using nested loops and '0' marker
    public static String[] findFrequencies(String text) {
        char[] characters = text.toCharArray();
        int[] freq = new int[characters.length];

        for (int i = 0; i < characters.length; i++) {
            freq[i] = 1;
            for (int j = i + 1; j < characters.length; j++) {
                if (characters[i] == characters[j] && characters[i] != '0' && characters[i] != ' ') {
                    freq[i]++;
                    characters[j] = '0'; // Mark duplicate character as visited
                }
            }
        }

        // Count non-visited entries
        int count = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '0' && characters[i] != ' ') {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '0' && characters[i] != ' ') {
                result[index++] = characters[i] + " : " + freq[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] report = findFrequencies(text);

        System.out.println("\nFrequency of each character:");
        for (String item : report) {
            System.out.println(item);
        }

        scanner.close();
    }
}
