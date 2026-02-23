package Week4AssignmentQuestions;


//. Write a program that calculates the number of days in a given month using the new
//switch expression.

import java.util.Scanner;

enum Months{ // creating an Enum of all the months that hold there days
    JANUARY {
        public String getDays() {
            return "31";
        }
    },
    FEBRUARY {
        public String getDays() {
            return "28";
        }
    },
    MARCH {

        public String getDays() {
            return "31";
        }
    },
    APRIL {
        public String getDays() {
            return "30";
        }
    },
    MAY {
        public String getDays() {
            return "31";
        }
    },
    JUNE {
        public String getDays() {
            return "31";
        }
    },
    JULY {
        public String getDays() {
            return "30";
        }
    },
    AUGUST {

        public String getDays() {
            return "31";
        }
    },
    SEPTEMBER {
        public String getDays() {
            return "31";
        }
    },
    OCTOBER {
        public String getDays() {
            return "31";
        }
    },
    NOVEMBER {
        public String getDays() {
            return "31";

        }
    },
    DECEMBER {
        public String getDays() {
            return "31";
        }
    };

    public String getDays() {
        return "";
    }
}

public class P1_SwitchExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the month NO.");
        int choice = sc.nextInt();
        String result = switch (choice){  // accessing the MOnths based on the choice
            case 1-> Months.JANUARY.getDays();
            case 2-> Months.FEBRUARY.getDays();
            case 3-> Months.MARCH.getDays();
            case 4-> Months.APRIL.getDays();
            case 5-> Months.MAY.getDays();
            case 6-> Months.JUNE.getDays();
            case 7-> Months.JULY.getDays();
            case 8-> Months.AUGUST.getDays();
            case 9-> Months.SEPTEMBER.getDays();
            case 10 -> Months.OCTOBER.getDays();
            case 11-> Months.NOVEMBER.getDays();
            case 12-> Months.DECEMBER.getDays();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
        System.out.println("the no.of days = "+result);
    }
}

/*
output:-

Please enter the month NO.
2
the no.of days = 28

* */