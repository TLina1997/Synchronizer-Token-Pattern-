package attack.identifiers;

import java.util.function.Function;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;


public class Functions {
	
	public static final Function<HttpSession, Cookie> COOKIE_WITH_SESSION_ID = session -> new Cookie("SessionID", session.getId());

}
