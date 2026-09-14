import java.util.Scanner;

public class RockPaperScissorsGame {

    // Method to generate computer choice
    public static String getComputerChoice() {
        int rand = (int) (Math.random() * 3);
        if (rand == 0) return "rock";
        if (rand == 1) return "paper";
        return "scissors";
    }

    // Method to evaluate winner
    public static String evaluateWinner(String user, String computer) {
        if (user.equalsIgnoreCase(computer)) {
            return "Tie";
        }
        if ((user.equalsIgnoreCase("rock") && computer.equals("scissors")) ||
            (user.equalsIgnoreCase("paper") && computer.equals("rock")) ||
            (user.equalsIgnoreCase("scissors") && computer.equals("paper"))) {
            return "User";
        }
        return "Computer";
    }

    // Method to calculate win percentages
    public static String[][] computeStats(int userWins, int compWins, int ties, int totalGames) {
        double userPercent = ((double) userWins / totalGames) * 100;
        double compPercent = ((double) compWins / totalGames) * 100;
        double tiePercent = ((double) ties / totalGames) * 100;

        return new String[][]{
            {"User", String.valueOf(userWins), String.format("%.2f%%", userPercent)},
            {"Computer", String.valueOf(compWins), String.format("%.2f%%", compPercent)},
            {"Ties", String.valueOf(ties), String.format("%.2f%%", tiePercent)}
        };
    }

    // Display method
    public static void displayGameSummary(String[][] gameHistory, String[][] stats) {
        System.out.println("\n================ Game Log ================");
        System.out.printf("%-8s | %-12s | %-12s | %-10s\n", "Game #", "User", "Computer", "Winner");
        System.out.println("------------------------------------------");
        for (int i = 0; i < gameHistory.length; i++) {
            System.out.printf("%-8s | %-12s | %-12s | %-10s\n",
                    gameHistory[i][0], gameHistory[i][1], gameHistory[i][2], gameHistory[i][3]);
        }

        System.out.println("\n================ Overall Stats ================");
        System.out.printf("%-12s | %-8s | %-12s\n", "Participant", "Wins", "Win Percentage");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < stats.length; i++) {
            System.out.printf("%-12s | %-8s | %-12s\n", stats[i][0], stats[i][1], stats[i][2]);
        }
        System.out.println("================================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rounds to play: ");
        int totalRounds = scanner.nextInt();

        String[][] gameHistory = new String[totalRounds][4];
        int userWins = 0;
        int compWins = 0;
        int ties = 0;

        for (int i = 0; i < totalRounds; i++) {
            System.out.print("\nRound " + (i + 1) + " - Enter rock, paper, or scissors: ");
            String userChoice = scanner.next().toLowerCase();

            String compChoice = getComputerChoice();
            String winner = evaluateWinner(userChoice, compChoice);

            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) compWins++;
            else ties++;

            gameHistory[i][0] = String.valueOf(i + 1);
            gameHistory[i][1] = userChoice;
            gameHistory[i][2] = compChoice;
            gameHistory[i][3] = winner;
        }

        String[][] stats = computeStats(userWins, compWins, ties, totalRounds);
        displayGameSummary(gameHistory, stats);

        scanner.close();
    }
}
