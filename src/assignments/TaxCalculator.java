package assignments;

public class TaxCalculator {
    public static void main(String[] args) {
        System.out.println(tax(500000, "new"));
        System.out.println(tax(1000000, "old"));
        System.out.println(tax(13043000, "old"));
        System.out.println(tax(21354000, "new"));

    }

    private static double tax(int salary, String tax) {
        if (tax == "new") {
            if (salary < 250000) return 0;
            else if (250000 < salary && salary <= 500000) return (salary * 5) / 100;
            else if (500000 < salary && salary <= 750000) return (salary * 10) / 100;
            else if (750000 < salary && salary <= 1000000) return (salary * 15) / 100;
            else if (1000000 < salary && salary <= 1250000) return (salary * 20) / 100;
            else if (1250000 < salary && salary <= 1500000) return (salary * 20) / 100;
            else if (salary > 1500000) return (salary * 30) / 100;

        } else {
            if (salary < 250000) return 0;
            else if (250000 < salary && salary <= 500000) return (salary * 5) / 100;
            else if (500000 < salary && salary <= 1000000) return (salary * 20) / 100;
            else if (salary > 1000000) return (salary * 30) / 100;

        }
        return 0;
    }
}
