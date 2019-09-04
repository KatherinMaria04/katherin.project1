package com.revature.DBexception;

public class DBException extends Exception{
	public DBException(String message) {
		super(message);
	}
	
	public void DBException(String message, Throwable t) {
		super(message,t);
	}

}
