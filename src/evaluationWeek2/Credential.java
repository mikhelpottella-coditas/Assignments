package evaluationWeek2;

public class Credential {
    public static void credentialAccess(String username,String password ){
        if(username.equalsIgnoreCase("a") && password.equals("a") ) {
            AdminPanel.adminPanel(); // calling the admin panel
        } else if (username.equalsIgnoreCase("u") && password.equals("u")) {
            UserPanel.userPanel();// calling the user panel
        }
        else System.out.println("Invalid Credentials"); // if te credentials are wrong

    }
}
