package org.burakisik.osgi.annotations;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<Username, String> {

	/**
	 * The pattern of user name
	 * [A-Za-z0-9_-]  # a number or letter or underscore or hyphen
	 * {3,9} 		  # Length at least 3 characters and maximum length of 15
	 * ^(?![_-]). 	  # can't start with underscore or hyphen
	 * (?<![-_])$ 	  # can't end with underscore or hyphen
	 * ((?!_-|-_).)   # underscore and hyphen can't be the one after the other
	 */
	private static final String USERNAME_PATTERN = "^(?![_-]).[A-Za-z0-9_-]((?!_-|-_).)(?<![-_]){3,9}$";

	@Override
	public void initialize(Username arg0) {

	}

	public static boolean validate(String username) {

		boolean isValid = Pattern.matches(USERNAME_PATTERN, username);
		return isValid;
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext arg1) {
		return username == null || validate(username);
	}
}
