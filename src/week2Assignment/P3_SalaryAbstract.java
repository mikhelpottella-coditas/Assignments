package week2Assignment;

abstract class SalaryAbstract {
    float salary=0;
    abstract void calculateSalary(float salary);

    void displayDetails(){
        if(salary == 0) System.out.println("please enter the salary with method(calculateSalary)");
        else System.out.println("your salary is "+salary+" per year");
    }
}

class FullTimeEmployee extends SalaryAbstract {
    @Override
    void calculateSalary(float salary) {
        salary = salary*12;
        }
    }

class PartTimeEmployee extends SalaryAbstract {

    @Override
    void calculateSalary(float salary) {
         salary = (salary*6);
    }
}

