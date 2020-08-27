package org.burakisik.osgi.user.interfaces;

import java.util.Locale;
import java.util.ResourceBundle;

public class InternationalizingManager {

	private static Locale defaultLocale = new Locale("en","US");

	private static ResourceBundle messages = ResourceBundle.getBundle("language", defaultLocale);

	private InternationalizingManager() {
		
	}

	public static String fetchTextfromResourceBundle(String property) {
		String value = messages.getString(property);
		return value;
	}
}
