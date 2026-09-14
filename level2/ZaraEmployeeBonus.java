import java.util.Scanner;

public class ZaraEmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int TOTAL_EMPLOYEES = 10;

        double[] salaries = new double[TOTAL_EMPLOYEES];
        double[] yearsOfService = new double[TOTAL_EMPLOYEES];
        double[] bonusAmounts = new double[TOTAL_EMPLOYEES];
        double[] newSalaries = new double[TOTAL_EMPLOYEES];

        // Input loop with input validation
        System.out.println("Enter salary and years of service for 10 employees:");
        for (int i = 0; i < TOTAL_EMPLOYEES; i++) {
            System.out.println("\nEmployee " + (i + 1) + ":");
            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            System.out.print("Enter Years of Service: ");
            double service = scanner.nextDouble();

            if (salary <= 0 || service < 0) {
                System.out.println("Invalid input. Salary must be > 0 and years of service >= 0. Please enter again.");
                i--; // Decrement index counter to re-enter
                continue;
            }

            salaries[i] = salary;
            yearsOfService[i] = service;
        }

        // Calculation loop
        double totalOldSalary = 0.0;
        double totalBonus = 0.0;
        double totalNewSalary = 0.0;

        for (int i = 0; i < TOTAL_EMPLOYEES; i++) {
            double rate = (yearsOfService[i] > 5) ? 0.05 : 0.02;
            bonusAmounts[i] = salaries[i] * rate;
            newSalaries[i] = salaries[i] + bonusAmounts[i];

            totalOldSalary += salaries[i];
            totalBonus += bonusAmounts[i];
            totalNewSalary += newSalaries[i];
        }

        // Output summary
        System.out.println("\n--- Payout Summary ---");
        System.out.printf("Total Old Salary Payout: %.2f\n", totalOldSalary);
        System.out.printf("Total Bonus Payout: %.2f\n", totalBonus);
        System.out.printf("Total New Salary Payout: %.2f\n", totalNewSalary);

        scanner.close();
    }
}
