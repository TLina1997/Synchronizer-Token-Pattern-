package attack.persist;

public class Database {
	
	  private static final String user = "admin";		//hard coded User name

	  private static final String pwd = "password";		//hard coded Password

	  public static boolean isValidUser(String usrname, String pass)
	  {
	    return user.equalsIgnoreCase(usrname) && pwd.equalsIgnoreCase(pass);
	  }

}
