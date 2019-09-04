package com.revature.functions;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.Dao.AdminDao;
import com.revature.Dao.UserDao;
import com.revature.Util.ConnectionUtil;
import com.revature.model.AdminAccess;
import com.revature.model.UserActivity;
import com.revature.model.UserDetails;

public class AdminFunctions {
	 
	    static Scanner sc=new Scanner(System.in);
	    static Connection con = ConnectionUtil.getConnection();
	public static void operations() throws SQLException
	    {
	    

        System.out.println("select your choice");
        System.out.println("1.Donation Details");
        System.out.println("2.Donor Activity");
        System.out.println("3.Update Donation details");
        System.out.println("Enter your choice:");

        
        Scanner sc = new Scanner(System.in);
        int userchoice = sc.nextInt();
        switch (userchoice) {
        case 1:
            
            donationDetails();
            break;
       
        case 2:
            
            donarActivity();
            break;
     case 3:
            
	     UpdateRequest();
            break;
           
        }
    }
public static void donationDetails()
{
    try {
       List<AdminAccess> list = AdminDao.requestDetails();
        for (AdminAccess admin : list) {
            
            System.out.println(admin);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
public static void donarActivity() throws SQLException
{
    
	 try {
	       List<UserActivity> list = AdminDao.findAll();
	       
	       
	        for (UserActivity user : list) {
	            
	            System.out.println(user);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
    
   
}
public static void UpdateRequest() throws SQLException
{    
	
	 System.out.println("Enter  request type:");
	    String request_type=sc.nextLine();
	    System.out.println("Amount requested");
	    Long amt_requested=sc.nextLong();
	    System.out.println("Active Status:");
	    Integer active=sc.nextInt();
	    AdminAccess admin=new AdminAccess();
	    admin.setRequest_type(request_type);
	    admin.setAmt_requested(amt_requested);
	    admin.setActive(active);
	    AdminDao.donationsUpdate(admin);
	   
}

}

