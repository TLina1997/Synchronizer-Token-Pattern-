package attack.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import attack.identifiers.Functions;
import attack.persist.Database;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet{
	
	  public static Map<String, String> TokenStore = new HashMap<String, String>();
	  private static final long serialVersionUID = 1L;


	  //GET method
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {
	    response.getWriter().append("Served at: ").append(request.getContextPath());
	  }

	  //POST method
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {

	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    HttpSession session = request.getSession(true); // create a new session 

	    if (Database.isValidUser(username, password))
	    {
	      String Token = generateCSRFToken(session.getId());//creating a new CSRF Token from session ID
	      TokenStore.put(session.getId(), Token); // adding to token store
	      response.addCookie(Functions.COOKIE_WITH_SESSION_ID.apply(session));

	      session.removeAttribute("validUser");
	      response.sendRedirect("./Home.jsp");
	    }
	    else
	    {
	      session.setAttribute("invalidUser", "User_not_found");
	      response.sendRedirect("./Login.jsp");
	    }
	  }

	  private String generateCSRFToken(String textInput)
	  {
		  String str = textInput + "." + randomTextGenerate();	//Mixed String using a random UUID
	    return str;
	  }

	  private String randomTextGenerate()
	  {
	    UUID uuid = UUID.randomUUID();
	    String randUUID = uuid.toString();
	    return randUUID;

	  }
}
