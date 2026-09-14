import java.util.Scanner;

public class TeamBMICalculator {

    // Method to calculate BMI and determine weight status
    public static String[] computeBMIAndStatus(double weightKg, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weightKg / (heightM * heightM);

        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25.0) {
            status = "Normal";
        } else if (bmi < 30.0) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{String.format("%.2f", bmi), status};
    }

    // Method that processes the 2D array of inputs and populates the 2D String report
    public static String[][] generateBMIReport(double[][] teamData) {
        String[][] report = new String[teamData.length][4];

        for (int i = 0; i < teamData.length; i++) {
            double weight = teamData[i][0];
            double height = teamData[i][1];

            String[] calculated = computeBMIAndStatus(weight, height);

            report[i][0] = String.format("%.1f cm", height);
            report[i][1] = String.format("%.1f kg", weight);
            report[i][2] = calculated[0];
            report[i][3] = calculated[1];
        }
        return report;
    }

    // Method to display the report in tabular format
    public static void displayTable(String[][] report) {
        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-12s | %-10s | %-12s\n", "Member", "Height", "Weight", "BMI", "Status");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < report.length; i++) {
            System.out.printf("%-10s | %-12s | %-12s | %-10s | %-12s\n",
                    "Member " + (i + 1), report[i][0], report[i][1], report[i][2], report[i][3]);
        }
        System.out.println("-------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MEMBERS = 10;
        double[][] teamData = new double[MEMBERS][2]; // Col 0: Weight, Col 1: Height

        System.out.println("Enter weight (kg) and height (cm) for 10 team members:");
        for (int i = 0; i < MEMBERS; i++) {
            System.out.println("\nMember " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            double weight = scanner.nextDouble();
            System.out.print("Height (cm): ");
            double height = scanner.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.out.println("Invalid input. Values must be positive. Re-enter.");
                i--;
                continue;
            }

            teamData[i][0] = weight;
            teamData[i][1] = height;
        }

        String[][] report = generateBMIReport(teamData);
        displayTable(report);

        scanner.close();
    }
}
