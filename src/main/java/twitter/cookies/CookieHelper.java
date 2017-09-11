package twitter.cookies;

import javax.servlet.http.Cookie;

public class CookieHelper {

	public static String getCookieValue(Cookie[] cookies, String cookieName) {

		if (cookies != null) {
			for (Cookie myCookie : cookies) {
				if (myCookie.getName().equals(cookieName)) {
					String cookieValue = myCookie.getValue();
					return cookieValue;
				}
			}
		}

		return null;
	}
}
