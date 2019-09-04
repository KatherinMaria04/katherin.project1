package com.revature.functions;

import java.sql.Connection;
import java.util.List;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.Dao.UserDao;
import com.revature.Util.ConnectionUtil;
import com.revature.model.AdminAccess;
import com.revature.model.UserDetails;

public class UserFunctions {
	 static Scanner sc=new Scanner(System.in);
	    static Connection con = ConnectionUtil.getConnection();
	public static void operations() throws SQLException
	    {
	    
	        System.out.println("select your choice");
	        System.out.println("1.Donation Details");
	        System.out.println("2.User Donation");
	        
	        Scanner sc = new Scanner(System.in);
	        int userchoice = sc.nextInt();
	        switch (userchoice) {
	        case 1:
	            
	            donationDetails();
	            break;
	       
	        case 2:
	            
	        	userDonation() ;
	            break;
	           
	        }
	    }
	public static void donationDetails()
	{
	    try {
	        List<AdminAccess> list = UserDao.findAll();
	        for (AdminAccess admin : list) {
	            
	            System.out.println(admin);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	    
	public static void userDonation() throws SQLException
	{
	    
	    System.out.println("Enter you request type:");
	    String request_type=sc.next();
	    System.out.println("Enter donar name:");
	    String cus_name=sc.next();
	    System.out.println("Enter the donating amount:");
	    Long donating_amt=sc.nextLong();

	    UserDetails user=new UserDetails ();
	  user.setRequest_type(request_type);
	    user.setCus_name(cus_name);
	    user.setDonating_amt(donating_amt);
	    UserDao.donarFund(user);
	   
	    
	   
	}

}
