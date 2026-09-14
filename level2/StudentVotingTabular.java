import java.util.Scanner;

public class StudentVotingTabular {

    // Method to generate random 2-digit ages (10 to 99)
    public static int[] generateRandomAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            // Generates integer between 10 and 99
            ages[i] = (int) (Math.random() * 90) + 10;
        }
        return ages;
    }

    // Method returning 2D String array with age and eligibility
    public static String[][] checkEligibility(int[] ages) {
        String[][] report = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            report[i][0] = String.valueOf(age);

            if (age < 0) {
                report[i][1] = "false (Invalid)";
            } else if (age >= 18) {
                report[i][1] = "true";
            } else {
                report[i][1] = "false";
            }
        }
        return report;
    }

    // Display tabular format
    public static void displayTable(String[][] report) {
        System.out.println("\n-----------------------------");
        System.out.printf("%-10s | %-15s\n", "Age", "Can Vote");
        System.out.println("-----------------------------");
        for (int i = 0; i < report.length; i++) {
            System.out.printf("%-10s | %-15s\n", report[i][0], report[i][1]);
        }
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students (e.g., 10): ");
        int totalStudents = scanner.nextInt();

        int[] ages = generateRandomAges(totalStudents);
        String[][] eligibilityTable = checkEligibility(ages);

        displayTable(eligibilityTable);

        scanner.close();
    }
}
