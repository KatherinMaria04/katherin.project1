package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.exception.DBException;
import com.revature.exception.ValidatorException;
import com.revature.model.AdminAccess;
import com.revature.model.UserActivity;

public interface IUserDao {
	void register(String cus_name, String password, long phone_num) throws DBException;

	boolean login(String cusname, String password1) throws ValidatorException;

	List<AdminAccess> findAll() throws SQLException;

	void donarFund(UserActivity user) throws SQLException;

	void updatedonation(AdminAccess admin) throws SQLException;

}