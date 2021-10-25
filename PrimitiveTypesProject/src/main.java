/**
 * Program made to take hourly wage and expenses to find total savings
 */
public class main {
    public static void main(String[] args){
        //money
        double hourlyWage = 75;
        double monthlyWage = hourlyWage * 40;

        //expenses
        double carPayment = 400;
        double carInsurance = 133;
        double cellPlan = 30;
        double monthlyRent = 921;
        double totalExpenses = carPayment + carInsurance + cellPlan + monthlyRent;

        double totalSavings = monthlyWage - totalExpenses; //subtracting the total expenses by monthly wage to get savings

        System.out.println("Monthly Wage: " + monthlyWage); //printing monthly wage
        System.out.println("Total Expenses: " + totalExpenses); //printing total expenses
        System.out.println("Savings a month: " + totalSavings); //savings a month


    }
}
