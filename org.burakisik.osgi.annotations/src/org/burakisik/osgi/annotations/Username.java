package org.burakisik.osgi.annotations;

public @interface Username {
	
	String message() default "User name must be at least 3 characters and maximum length of 15, can't start with underscore or hyphen, can't end with underscore or hyphen and underscore and hyphen can't be the one after the other";  
}
