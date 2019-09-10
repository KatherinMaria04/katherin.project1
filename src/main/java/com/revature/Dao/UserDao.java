package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.util.ConnectionUtil;
import com.revature.exception.DBException;
import com.revature.exception.ValidatorException;
import com.revature.model.AdminAccess;
import com.revature.model.UserActivity;


public class UserDao implements IUserDao {

	public  void register( String cus_name, String password, long phone_num) throws DBException {
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "insert into userlogin(cus_name,password,phone_num) values (?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cus_name);
			pst.setString(2, password);
			pst.setLong(3, phone_num);
			pst.executeUpdate();
		} catch (Exception e) {

	      throw new DBException("invalid username");
		}
		
	}
	public boolean login(String cusname,String password1) throws ValidatorException {
        
        try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "select * from userlogin where cus_name=?  and password=? ";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, cusname);
			pst.setString(2, password1);
			ResultSet rs = pst.executeQuery();
			
 
      boolean isValid;
			   if(rs.next()){
			       isValid=true;
			   }
			   else
			   {
			       isValid = false;
			       
			     
			   }
			   return isValid;
		} catch (Exception e) {
			throw new ValidatorException("invalid username and password");
		}

}
	public  List<AdminAccess> findAll() throws SQLException {
	    Connection con = ConnectionUtil.getConnection();
	    String sql = "select request_type,amt_requested,target_amt from adminaccess";
	    PreparedStatement pst = con.prepareStatement(sql);
	    ResultSet rs = pst.executeQuery();
	    List<AdminAccess> list = new ArrayList<AdminAccess>();
	    while (rs.next()) {
	        
	        AdminAccess admin= toRow(rs);
	        list.add(admin);
	    }
	    return list;
	}
	private static AdminAccess toRow(ResultSet rs) throws SQLException {
	    String request_type = rs.getString("request_type");
	    Integer amt_requested= rs.getInt("amt_requested");
	    long target_amt= rs.getLong("target_amt");
	    AdminAccess admin = new AdminAccess();
	    admin.setRequesttype(request_type);
	    admin.setAmountrequested(amt_requested);
		admin.setTargetamount(target_amt);
	    
	    return admin;
	}
	public  void donarFund( UserActivity user) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into useractivity(request_type,cus_name,donating_amt) values (?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, user.getRequesttype());
		pst.setString(2, user.getCustomername());
		pst.setLong(3,user.getDonatingamount());
		pst.executeUpdate();
		
    }
	public  void updatedonation( AdminAccess admin) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "update  adminaccess set amt_requested=amt_requested-? where request_type=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setLong(1, admin.getAmountrequested());
		pst.setString(2,admin.getRequesttype());
		pst.executeUpdate();
		
    }

}