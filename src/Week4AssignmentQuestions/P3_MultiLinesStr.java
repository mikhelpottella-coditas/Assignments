package Week4AssignmentQuestions;

//    Write a program that uses text blocks to store and display a multi-line SQL query.
public class P3_MultiLinesStr {
    public static void main(String[] args) {
        String multiQuery = """
                SELECT column_name(s)
                FROM table1 T1, table1 T2
                WHERE condition;
                
                SELECT A.CustomerName AS CustomerName1, B.CustomerName AS CustomerName2, A.City
                FROM Customers A, Customers B
                WHERE A.CustomerID <> B.CustomerID
                AND A.City = B.City
                ORDER BY A.City;
                """;
        System.out.println(multiQuery);
    }
}



// output:
//    SELECT column_name(s)
//    FROM table1 T1, table1 T2
//    WHERE condition;
//
//    SELECT A.CustomerName AS CustomerName1, B.CustomerName AS CustomerName2, A.City
//    FROM Customers A, Customers B
//    WHERE A.CustomerID <> B.CustomerID
//    AND A.City = B.City
//    ORDER BY A.City;