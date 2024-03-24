import java.util.Scanner;

public class hrscalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize variables to hold total hours worked and total salary for the week
        int totalHoursWorked = 0;
        double totalSalary = 0;

        // Iterate over 5 working days (you can change this number as needed)
        for (int day = 1; day <= 5; day++) {
            System.out.println("Day " + day);
            // Prompt user to input login time
            System.out.print("Enter login time (HHMM): ");
            int loginTime = scanner.nextInt();

            // Prompt user to input logout time
            System.out.print("Enter logout time (HHMM): ");
            int logoutTime = scanner.nextInt();

            // Calculate hours worked
            int hoursWorked = calculateHoursWorked(loginTime, logoutTime);
            totalHoursWorked += hoursWorked;

            // Prompt user to input rate per hour
            System.out.print("Enter rate per hour: ");
            double ratePerHour = scanner.nextDouble();

            // Calculate salary for the day
            double salary = calculateSalary(hoursWorked, ratePerHour);
            totalSalary += salary;

            // Display result for the day
            System.out.println("Total hours worked: " + hoursWorked);
            System.out.println("Salary earned for Day " + day + ": P" + salary);
        }

        // Calculate gross weekly salary
        double grossWeeklySalary = totalSalary;

        // Calculate deductions
        double pagIbigDeduction = calculatePagIbigDeduction(grossWeeklySalary);
        double sssDeduction = calculateSSSDeduction(grossWeeklySalary);
        double philHealthDeduction = calculatePhilHealthDeduction(grossWeeklySalary);
        double withholdingTax = calculateWithholdingTax(grossWeeklySalary);

        // Calculate net weekly salary after deductions
        double netWeeklySalary = grossWeeklySalary - pagIbigDeduction - sssDeduction - philHealthDeduction - withholdingTax;

        // Display total result for the week including deductions
        System.out.println("Total hours worked for the week: " + totalHoursWorked);
        System.out.println("Gross weekly salary: P" + grossWeeklySalary);
        System.out.println("Deductions:");
        System.out.println("  Pag-IBIG: P" + pagIbigDeduction);
        System.out.println("  SSS: P" + sssDeduction);
        System.out.println("  PhilHealth: P" + philHealthDeduction);
        System.out.println("  Withholding Tax: P" + withholdingTax);
        System.out.println("Net weekly salary after deductions: P" + netWeeklySalary);

        scanner.close();
    }

    // Method to calculate hours worked
    private static int calculateHoursWorked(int loginTime, int logoutTime) {
        // Extract hours and minutes from login and logout times
        int loginHours = loginTime / 100;
        int loginMinutes = loginTime % 100;

        int logoutHours = logoutTime / 100;
        int logoutMinutes = logoutTime % 100;

        // Calculate total minutes worked
        int totalMinutesWorked = (logoutHours * 60 + logoutMinutes) - (loginHours * 60 + loginMinutes);

        // Convert total minutes worked to hours
        int hoursWorked = totalMinutesWorked / 60;

        return hoursWorked;
    }

    // Method to calculate salary
    private static double calculateSalary(int hoursWorked, double ratePerHour) {
        return hoursWorked * ratePerHour;
    }

    // Method to calculate Pag-IBIG deduction
    private static double calculatePagIbigDeduction(double grossWeeklySalary) {
        // Pag-IBIG deduction rate (as a percentage)
        double pagIbigRate = 0.02; // Assuming 2% rate
        return grossWeeklySalary * pagIbigRate;
    }

    // Method to calculate SSS deduction
    private static double calculateSSSDeduction(double grossWeeklySalary) {
        // SSS deduction rate (as a percentage)
        double sssRate = 0.03; // Assuming 3% rate
        return grossWeeklySalary * sssRate;
    }

    // Method to calculate PhilHealth deduction
    private static double calculatePhilHealthDeduction(double grossWeeklySalary) {
        // PhilHealth deduction rate (as a percentage)
        double philHealthRate = 0.035; // Assuming 3.5% rate
        return grossWeeklySalary * philHealthRate;
    }

    // Method to calculate withholding tax
    private static double calculateWithholdingTax(double grossWeeklySalary) {
        // Withholding tax rate (as a percentage)
        double taxRate = 0.10; // Assuming 10% rate
        return grossWeeklySalary * taxRate;
    }
}