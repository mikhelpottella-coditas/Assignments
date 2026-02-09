package evaluationWeek2;

public class Credential {
    public static void credentialAccess(String username,String password ){
        if(username.equalsIgnoreCase("a") && password.equals("a") ) {
            AdminPanel.adminPanel();
        } else if (username.equalsIgnoreCase("u") && password.equals("u")) {
            UserPanel.userPanel();
        }
        else System.out.println("Invalid Credentials");

    }
}
