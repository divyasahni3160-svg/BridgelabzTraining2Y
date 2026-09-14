import java.util.Scanner;

public class DeckOfCards {

    // Method to initialize standard 52-card deck
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        String[] deck = new String[suits.length * ranks.length];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    // Method to shuffle deck using Fisher-Yates algorithm
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            // Swap cards
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    // Method to distribute n cards equally among x players
    public static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {
        String[][] playerHands = new String[players][cardsPerPlayer];
        int deckIndex = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playerHands[i][j] = deck[deckIndex++];
            }
        }
        return playerHands;
    }

    // Method to print distributed cards
    public static void printHands(String[][] playerHands) {
        System.out.println("\n--- Player Hands ---");
        for (int i = 0; i < playerHands.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + ":");
            for (int j = 0; j < playerHands[i].length; j++) {
                System.out.println("  • " + playerHands[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] deck = initializeDeck();
        deck = shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int players = scanner.nextInt();
        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = scanner.nextInt();

        int totalRequired = players * cardsPerPlayer;
        if (totalRequired > deck.length || players <= 0 || cardsPerPlayer <= 0) {
            System.err.println("Cannot distribute " + totalRequired + " cards from a 52-card deck.");
            scanner.close();
            return;
        }

        String[][] distribution = distributeCards(deck, players, cardsPerPlayer);
        printHands(distribution);

        scanner.close();
    }
}
