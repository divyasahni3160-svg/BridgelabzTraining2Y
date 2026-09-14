import java.util.Scanner;

public class CustomWordSplit {

    // Method to calculate length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    // Method to split text into words using charAt() and space tracking
    public static String[] splitIntoWords(String text) {
        int len = findLength(text);

        // Count spaces to determine the number of words
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int totalWords = spaceCount + 1;
        String[] words = new String[totalWords];
        StringBuilder currentWord = new StringBuilder();
        int wordIndex = 0;

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                words[wordIndex++] = currentWord.toString();
                currentWord.setLength(0); // Reset buffer
            } else {
                currentWord.append(ch);
            }
        }
        words[wordIndex] = currentWord.toString();

        return words;
    }

    // Method to compare two string arrays
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        // Custom split implementation
        String[] customWords = splitIntoWords(text);

        // Built-in split implementation
        String[] builtInWords = text.split(" ");

        // Compare both arrays
        boolean isIdentical = compareStringArrays(customWords, builtInWords);

        System.out.println("\n--- Extracted Words ---");
        for (int i = 0; i < customWords.length; i++) {
            System.out.println("Word " + (i + 1) + ": " + customWords[i]);
        }

        System.out.println("\nDo both split results match? " + isIdentical);

        scanner.close();
    }
}
