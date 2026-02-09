package evaluationWeek2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // taking user credential and passing it to the credential method
        String username = sc.next().strip();
        String password = sc.next();

        Credential.credentialAccess(username,password);
    }
}
