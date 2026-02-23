package Week4AssignmentQuestions;

//    Create a sealed class hierarchy where Animal is a sealed class and Dog and Cat are
//    its permitted subclasses

sealed class Animal permits Dog, Cat { // this is thesealed class given permit to Dog and Cat
    void makeSound() {
    }

    ;
}

final class Dog extends Animal { //  this is the final class and it extends the Animal
    void makeSoung() {
        System.out.println("Bark!! Bark!!");
    }
}

//class Lion extends Animal{ }; tring to access the Animal and throws an error

non-sealed class Cat extends Animal { // non-sealed class which extend Animal
    void makeSoung() {
        System.out.println("Meow  Meow!!");
    }
}

public class P4_SealedClass {
    public static void main(String[] args) {
        var dog = new Dog();
        var cat =  new Cat();
        dog.makeSoung();
        cat.makeSoung();
    }

}
// output:
//  Bark!! Bark!!
//  Meow  Meow!!