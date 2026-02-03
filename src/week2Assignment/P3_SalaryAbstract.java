package week2Assignment;

abstract class SalaryAbstract {
    float sal=0;
    abstract void calculateSalary(float salary);

    void displayDetails(){
        if(sal == 0) System.out.println("please enter the salary with method(calculateSalary)");
        else System.out.println("your salary is "+sal+" per year");
    }
}

class FullTimeEmployee extends SalaryAbstract {
    @Override
    void calculateSalary(float salary) {
        sal = salary*12;
        }
    }

class PartTimeEmployee extends SalaryAbstract {

    @Override
    void calculateSalary(float salary) {
         sal = (salary*6);
    }
}

