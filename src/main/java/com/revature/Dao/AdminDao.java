package com.revature.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.Util.ConnectionUtil;
import com.revature.model.AdminAccess;
import com.revature.model.UserActivity;
import com.revature.model.UserDetails;

public class AdminDao {
public static boolean AdminLogin(String name,String password2) throws SQLException {

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
public static List<UserActivity> findAll() throws SQLException {
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
    user.setCus_name(cus_name);
    user.setRequest_type(request_type);
    user.setDonating_amt(donating_amt);
    
    return user;
}
public static List<AdminAccess> requestDetails() throws SQLException {
    Connection con = ConnectionUtil.getConnection();
    String sql = "select request_type,amt_requested,active from adminaccess";
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
    int active= rs.getInt("active");
    AdminAccess admin = new AdminAccess();
    admin.setRequest_type(request_type);
    admin.setAmt_requested(amt_requested);
    admin.setActive(active);
    
    return admin;
}

public static void donationsUpdate( AdminAccess admin) throws SQLException {
	Connection con = ConnectionUtil.getConnection();
	String sql = "insert into adminaccess(request_type,amt_requested,active) values (?,?,?)";
	PreparedStatement pst = con.prepareStatement(sql);
	pst.setString(1, admin.getRequest_type());
	pst.setLong(2, admin.getAmt_requested());
	pst.setInt(3,admin.getActive());
	pst.executeUpdate();
	
}





}
