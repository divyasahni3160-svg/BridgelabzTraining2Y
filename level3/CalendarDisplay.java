import java.util.Scanner;

public class CalendarDisplay {

    // Method to get month name
    public static String getMonthName(int m) {
        String[] months = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return months[m];
    }

    // Method to check leap year
    public static boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    // Method to get number of days in month
    public static int getDaysInMonth(int m, int y) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (m == 2 && isLeapYear(y)) {
            return 29;
        }
        return days[m];
    }

    // Gregorian Algorithm to find day of week for day 1 (0 = Sun, 1 = Mon, ..., 6 = Sat)
    public static int getFirstDayOfMonth(int d, int m, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0;
    }

    public static void printCalendar(int month, int year) {
        System.out.println("\n     " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int startDay = getFirstDayOfMonth(1, month, year);
        int totalDays = getDaysInMonth(month, year);

        // Print initial indentation spaces
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Print calendar days
        for (int day = 1; day <= totalDays; day++) {
            System.out.printf("%3d ", day);
            if ((day + startDay) % 7 == 0 || day == totalDays) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        if (month < 1 || month > 12 || year < 1) {
            System.err.println("Invalid month or year entered.");
            scanner.close();
            return;
        }

        printCalendar(month, year);

        scanner.close();
    }
}
