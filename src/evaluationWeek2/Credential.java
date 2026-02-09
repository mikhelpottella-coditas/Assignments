package evaluationWeek2;

public class Credential {
    public static void credentialAccess(String username,String password ){
        if(username.equalsIgnoreCase("admin") || password.equals("admin") ) AdminPanel.adminPanel();
        else if(username.equalsIgnoreCase("user") || password.equals("pass123") ) UserPanel.userPanel();;


    }
}
