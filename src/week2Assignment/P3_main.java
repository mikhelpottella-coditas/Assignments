package week2Assignment;

public class P3_main {
    public static void main(String[] args) {
        SalaryAbstract swarajFullTime = new FullTimeEmployee(); // Object for the full time emp

        SalaryAbstract michaelPartTime = new PartTimeEmployee(); //Object for the part time emp

        swarajFullTime.calculateSalary(60000); // to calculate the annual salary
        swarajFullTime.displayDetails(); //  to display the annual salary

        michaelPartTime.calculateSalary(22000);
        michaelPartTime.displayDetails();
    }
}
