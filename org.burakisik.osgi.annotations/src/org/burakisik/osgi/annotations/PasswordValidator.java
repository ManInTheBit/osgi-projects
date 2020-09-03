package org.burakisik.osgi.annotations;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

	private final static String PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
	
	@Override
	public void initialize(Password arg0) {
		
	}

	public static boolean validate(String password) {
		
		boolean isValid = Pattern.matches(PASSWORD_PATTERN, password);
		return isValid;
	}
	
	@Override
	public boolean isValid(String password, ConstraintValidatorContext arg1) {
		return password == null || validate(password);
	}
}
