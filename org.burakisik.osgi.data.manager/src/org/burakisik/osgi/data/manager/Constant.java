package org.burakisik.osgi.data.manager;

public class Constant {

	public static final String USER_TABLE_NAME = "User";
	
	public static final String USER_TABLE_ID_COLUMN = "id";

	public static final String USER_TABLE_USER_NAME_COLUMN = "user_name";
	
	public static final String USER_TABLE_PASSWORD_COLUMN = "password";
	
	public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM " + USER_TABLE_NAME;

	public static final String SQL_DELETE_USER_BY_ID = "DELETE FROM " + USER_TABLE_NAME + " where id=?";

	public static final String SQL_SELECT_USER_BY_NAME = "SELECT * FROM " + USER_TABLE_NAME + " where user_name=?";

	public static final String SQL_SELECT_USER_BY_PK = "SELECT * FROM " + USER_TABLE_NAME + " where id=?";

	public static final String SQL_INSERT_USER = "INSERT INTO " + USER_TABLE_NAME + "(user_name,password) VALUES(?,?)";

	public static final String SQL_UPDATE_USER_BY_PK = "UPDATE " + USER_TABLE_NAME + " SET user_name=?, password=? WHERE id=?";

	public static final String SQL_QUERY = "CREATE TABLE IF NOT EXIST " + USER_TABLE_NAME + " (" 
			+ "user_name varchar(30) NOT NULL,"
			+ "password varchar(30) NOT NULL,"
			+ "id bigint NOT NULL,"
			+"PRIMARY KEY (id)" + ") ;";

	private Constant() {

	}
}
