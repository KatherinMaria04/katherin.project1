package com.revature.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.Util.ConnectionUtil;
import com.revature.model.AdminAccess;
import com.revature.model.UserDetails;

public class UserDao {

	public static void Register( String cus_name, String password, long phone_num,long accountno) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into userlogin(cus_name,password,phone_num,accountno) values (?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, cus_name);
		pst.setString(2, password);
		pst.setLong(3, phone_num);
		pst.setLong(4,accountno);
		pst.executeUpdate();
		
	}
	public static boolean Login(String cusname,String password1) throws SQLException {
        
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

}
	public static List<AdminAccess> findAll() throws SQLException {
	    Connection con = ConnectionUtil.getConnection();
	    String sql = "select request_type,amt_requested,active from adminaccess";
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
	    int active= rs.getInt("active");
	    AdminAccess admin = new AdminAccess();
	    admin.setRequest_type(request_type);
	    admin.setAmt_requested(amt_requested);
	    admin.setActive(active);
	    
	    return admin;
	}
	public static void donarFund( UserDetails user) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into useractivity(request_type,cus_name,donating_amt) values (?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, user.getRequest_type());
		pst.setString(2, user.getCus_name());
		pst.setLong(3,user.getDonating_amt());
		pst.executeUpdate();
		
    }

}