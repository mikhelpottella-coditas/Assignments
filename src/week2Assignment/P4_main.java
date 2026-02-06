package week2Assignment;

/*
* Create a class BankAccount with: -
• A private variable balance
• An inner class Transaction that can: -
o Deposit money
o Withdraw money

Demonstrate how the inner class accesses private members of the outer class.
* */

public class P4_main {
    public static void main(String[] args) {
        P4_InnerClass bank = new P4_InnerClass(); // create the object for the outer class

        P4_InnerClass.Transactions program = bank.new Transactions(); // create the object for the inner class using the outerclass obj.


        program.Deposit(2000);

        program.withdraw(300);
    }
}
