package week2Assignment;

abstract class SalaryAbstract {
    float fullSalary=0;
    abstract void calculateSalary(float fullSalary);

    void displayDetails(){
        if(fullSalary == 0) System.out.println("please enter the fullSalary with method(calculateSalary)");
        else System.out.println("your fullSalary is "+fullSalary+" per year");
    }
}

class FullTimeEmployee extends SalaryAbstract {
    @Override
    void calculateSalary(float salary) {
        fullSalary = salary*12;
        }
    }

class PartTimeEmployee extends SalaryAbstract {

    @Override
    void calculateSalary(float salary) {
         fullSalary = (salary*6);
    }
}

