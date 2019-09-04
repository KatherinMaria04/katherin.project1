package com.revature;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.Dao.AdminDao;
import com.revature.Dao.UserDao;
import com.revature.functions.AdminFunctions;
import com.revature.functions.UserFunctions;



public class Mainclass {
	
	/*static String cus_name=null;
	static long phone_num=0;
	static long accountno=0;
	static String password=null;*/
	static boolean quit = false;
	public static void main(String[] args)  {
	 Scanner sc = new Scanner(System.in);
		 int userchoice;
		 System.out.println("=========welcome ===========");
		 do {
		
   	 
        System.out.println("1. register");

         System.out.println("2. Donar login");
         
         System.out.println("3. Admin login");

         System.out.print("Your choice: ");

         userchoice =sc.nextInt();
         switch (userchoice) {
        
         case 1:
         
        	 System.out.println("Donar Name:");
			 String cus_name = sc.next();
			 System.out.println("phone number:");
			 long phone_num = sc.nextLong();
			 System.out.println("accountnumber:");
			 long accountno = sc.nextLong();
			 System.out.println("password:");
			  String password = sc.next();
			  System.out.println("========Registeration is done sucessfully=======");
			    
			  try {
				
					com.revature.Dao.UserDao.Register(cus_name,password,phone_num,accountno);
					
					}catch(SQLException e) {
						 e.printStackTrace();
					 }
			  break;
			
		
         case 2: 
        	 
	    	  System.out.println("username:");
	    	  String cusname = sc.next();
	 		 System.out.println("password:");
	 		 String  password1 = sc.next();
					
			try {
			boolean b =	UserDao.Login(cusname, password1);
			if(b==true) {
				System.out.println("Welcome "+cusname);
			  UserFunctions.operations();
			}
			else
				System.out.println("Invalid username or password");
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				break;
				
         case 3: 
	    
	    	System.out.println("Admin name:");
	    	  String name = sc.next();
	 		 System.out.println("password:");
	 		 String  password2 = sc.next();
					
			try {
			
			boolean b =	AdminDao.AdminLogin(name, password2);
			if(b==true) {
				System.out.println("Welcome "+name);
				AdminFunctions.operations();
		     
			}
			else
				System.out.println("Invalid username or password");
				
				} catch (SQLException e) {
				
				e.printStackTrace();
			}
			break;
			
					
         case 0:

             quit = true;

             break;

       default:

             System.out.println("Wrong choice.");

             break;

       }

       System.out.println();

 } while (!quit);

 System.out.println("=====thank you========");
	}
}

 
