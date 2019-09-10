package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.exception.DBException;
import com.revature.model.AdminAccess;
import com.revature.model.UserActivity;
import com.revature.model.UserDetails;

public interface IAdminDao {
	boolean adminLogin(String name,String password2) throws SQLException;
	List<UserActivity> findAll() throws SQLException;
	 List<AdminAccess> requestDetails() throws SQLException;
	 List<UserDetails> donarDetails() throws SQLException ;
	 void donationsUpdate( AdminAccess admin) throws SQLException;
	
}