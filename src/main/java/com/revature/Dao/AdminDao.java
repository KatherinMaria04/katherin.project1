package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.util.ConnectionUtil;
import com.revature.exception.DBException;
import com.revature.model.AdminAccess;
import com.revature.model.UserActivity;
import com.revature.model.UserDetails;

public class AdminDao implements IAdminDao {
public boolean adminLogin(String name,String password2) throws SQLException {

        Connection con = ConnectionUtil.getConnection();
        String sql = "select * from adminlogin where name=?  and password=? ";
        PreparedStatement pst;
		pst = con.prepareStatement(sql);
		pst.setString(1, "admin");
        pst.setString(2, "admin");
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
}
public  List<UserActivity> findAll() throws SQLException {
    Connection con = ConnectionUtil.getConnection();
    String sql = "select cus_name,request_type,donating_amt from useractivity";
    PreparedStatement pst = con.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();
    List<UserActivity> list = new ArrayList<UserActivity>();
    while (rs.next()) {
        
        UserActivity user= toRow(rs);
        list.add(user);
    }
    return list;
}
private static UserActivity toRow(ResultSet rs) throws SQLException {
    String cus_name = rs.getString("cus_name");
    String request_type= rs.getString("request_type");
    Long donating_amt= rs.getLong("donating_amt");
    UserActivity user = new UserActivity();
    user.setCustomername(cus_name);
    user.setRequesttype(request_type);
    user.setDonatingamount(donating_amt);
    
    return user;
}
public  List<AdminAccess> requestDetails() throws SQLException {
    Connection con = ConnectionUtil.getConnection();
    String sql = "select request_type,amt_requested,target_amt from adminaccess";
    PreparedStatement pst = con.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();
    List<AdminAccess> list = new ArrayList<AdminAccess>();
    while (rs.next()) {
        
        AdminAccess admin= toRow1(rs);
        list.add(admin);
    }
    return list;
}
private static AdminAccess toRow1(ResultSet rs) throws SQLException {
    String request_type = rs.getString("request_type");
    Integer amt_requested= rs.getInt("amt_requested");
    Long target_amt= rs.getLong("target_amt");
    AdminAccess admin = new AdminAccess();
    admin.setRequesttype(request_type);
    admin.setAmountrequested(amt_requested);
    admin.setTargetamount(target_amt);
    
    return admin;
}

public  void donationsUpdate( AdminAccess admin) throws SQLException {
	try {
		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into adminaccess(request_type,amt_requested,target_amt) values (?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, admin.getRequesttype());
		pst.setLong(2, admin.getAmountrequested());
		pst.setLong(3,admin.getTargetamount());
		pst.executeUpdate();
	} catch (Exception e) {
	
		e.printStackTrace();
		
	}
	
}

public  List<UserDetails> donarDetails() throws SQLException {
    Connection con = ConnectionUtil.getConnection();
    String sql = "select cus_name,password,phone_num from userlogin";
    PreparedStatement pst = con.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();
    List<UserDetails> list = new ArrayList<UserDetails>();
    while (rs.next()) {
        
        UserDetails user= toRow2(rs);
        list.add(user);
    }
    return list;
}
private static UserDetails toRow2(ResultSet rs) throws SQLException {
    String cus_name = rs.getString("cus_name");
    String password= rs.getString("password");
    Long phone_num= rs.getLong("phone_num");
    UserDetails user = new UserDetails();
    user.setCustomername(cus_name);
    user.setPassword(password);
    user.setPhoneno(phone_num);
    
    return user;

}
}

