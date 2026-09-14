import java.util.Scanner;

public class CharacterFrequency2D {

    // Method to compute frequencies and return a 2D array of distinct characters and counts
    public static String[][] getFrequencies(String text) {
        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        // Count distinct characters
        int distinct = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                distinct++;
            }
        }

        String[][] result = new String[distinct][2];
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] > 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                freq[ch] = 0; // Prevent duplicate rows
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = scanner.nextLine();

        String[][] freqTable = getFrequencies(text);

        System.out.println("\n--- Character Frequency ---");
        for (int i = 0; i < freqTable.length; i++) {
            System.out.println("'" + freqTable[i][0] + "' occurs " + freqTable[i][1] + " time(s)");
        }

        scanner.close();
    }
}
