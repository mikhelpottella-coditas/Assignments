package handsOn;

import java.util.InputMismatchException;

class NewError extends Exception{
    NewError(){
        super();
        String e = "this is a new error";
        System.out.println(e);
    }
}

public class ExceptionPractice {
    public static void main(String[] args) throws NewError {
        throw new NewError();
    }
}
