package week2Assignment;

public class P3_main {
    public static void main(String[] args) {
        SalaryAbstract swarajFull = new FullTimeEmployee(); // Object for the full time emp

        SalaryAbstract michaelPart = new PartTimeEmployee(); //Object for the part time emp

        swarajFull.calculateSalary(60000); // to calculate the annual salary
        swarajFull.displayDetails(); //  to display the annual salary

        michaelPart.calculateSalary(22000);
        michaelPart.displayDetails();
    }
}
