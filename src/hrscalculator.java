import java.util.Scanner;

public class hrscalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Employee Name: ");
        String employeeName = scanner.nextLine();

       
        System.out.print("Employee ID: ");
        String employeeID = scanner.nextLine();

        
        int totalHoursWorked = 0;
        double totalSalary = 0;

        
        for (int day = 1; day <= 7; day++) {
            System.out.println("Day " + day);
           
            System.out.print("Enter login time (HHMM): ");
            int loginTime = scanner.nextInt();

           
            System.out.print("Enter logout time (HHMM): ");
            int logoutTime = scanner.nextInt();

           
            int hoursWorked = calculateHoursWorked(loginTime, logoutTime);
            totalHoursWorked += hoursWorked;


            System.out.print("Enter rate per hour: ");
            double ratePerHour = scanner.nextDouble();

           
            double salary = calculateSalary(hoursWorked, ratePerHour);
            totalSalary += salary;

            
            System.out.println("Total hours worked: " + hoursWorked);
            System.out.println("Salary earned for Day " + day + ": P" + salary);
        }


        double grossWeeklySalary = totalSalary;

        
        double pagIbigDeduction = calculatePagIbigDeduction(grossWeeklySalary);
        double sssDeduction = calculateSSSDeduction(grossWeeklySalary);
        double philHealthDeduction = calculatePhilHealthDeduction(grossWeeklySalary);
        double withholdingTax = calculateWithholdingTax(grossWeeklySalary);

      
        double netWeeklySalary = grossWeeklySalary - pagIbigDeduction - sssDeduction - philHealthDeduction - withholdingTax;

        
        System.out.println("\nEmployee Name: " + employeeName);
        System.out.println("Employee ID: " + employeeID);
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

   
    private static int calculateHoursWorked(int loginTime, int logoutTime) {
        
        int loginHours = loginTime / 100;
        int loginMinutes = loginTime % 100;

        int logoutHours = logoutTime / 100;
        int logoutMinutes = logoutTime % 100;

        
        int totalMinutesWorked = (logoutHours * 60 + logoutMinutes) - (loginHours * 60 + loginMinutes);

       
        int hoursWorked = totalMinutesWorked / 60;

        return hoursWorked;
    }

   
    private static double calculateSalary(int hoursWorked, double ratePerHour) {
        return hoursWorked * ratePerHour;
    }

   
    private static double calculatePagIbigDeduction(double grossWeeklySalary) {
       
        double pagIbigRate = 0.02; 
        return grossWeeklySalary * pagIbigRate;
    }

   
    private static double calculateSSSDeduction(double grossWeeklySalary) {
       
        double sssRate = 0.03; 
        return grossWeeklySalary * sssRate;
    }

   
    private static double calculatePhilHealthDeduction(double grossWeeklySalary) {
     
        double philHealthRate = 0.03;
        return grossWeeklySalary * philHealthRate;
    }

    // Method to calculate withholding tax
    private static double calculateWithholdingTax(double grossWeeklySalary) {

        double taxRate = 0.10;
        return grossWeeklySalary * taxRate;
    }
}