package handsOn;

import java.util.Objects;

public class Experment {
    public static void main(String[] args) {
        Employe emp1 = new Employe("abc");
        Employe emp2 = new Employe("abc");
        System.out.println(emp1 == emp2);

        System.out.println(emp1.equals(emp2));
    }
}

class Employe{
    String name;

    public Employe(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(name, employe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
