package com.revature.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.AdminDao;
import com.revature.dao.IAdminDao;
import com.revature.dao.IUserDao;
import com.revature.dao.UserDao;
import com.revature.exception.DBException;
import com.revature.exception.ValidatorException;
import com.revature.service.AdminFunctions;
import com.revature.service.UserFunctions;



public class Mainclass {

	static boolean quit = false;

	public static void main(String[] args) throws SQLException, ValidatorException, DBException  {
		Scanner sc = new Scanner(System.in);
		int userchoice;
		System.out.println("******************************************");
		System.out.println("              WELCOME                     ");
		System.out.println("******************************************");
		
		do {

			System.out.println("1. register");

			System.out.println("2. Donar login");

			System.out.println("3. Admin login");

			System.out.print("Your choice: ");

			userchoice = sc.nextInt();
			switch (userchoice) {

			case 1:

				System.out.println("Donar Name:");
				String cus_name = sc.next();
				System.out.println("phone number:");
				long phone_num= sc.nextLong();
				System.out.println("password:");
				String password = sc.next();
				System.out.println("*************** YOUR REGISTERATION HAS DONE SUCCESSFULLY*************");
                 
				IUserDao dao = new UserDao();
				try {
					dao.register(cus_name, password, phone_num);
				} catch (DBException e1) {
					
					 System.out.println("Donar Already");
					throw new DBException("Registration fails");
					
				}
				break;

			case 2:

				System.out.println("username:");
				String cusname = sc.next();
				System.out.println("password:");
				String password1 = sc.next();

					IUserDao dao1 = new UserDao();
					boolean b = false;
				try {
					b = dao1.login(cusname, password1);
				} catch (ValidatorException e) {
					
					throw new ValidatorException("invalid username or password");
				}
				if (b == true) {
						System.out.println("Welcome " + cusname);
						UserFunctions.operations();
					} else
						System.out.println("Invalid username or password");

				break;

			case 3:

				System.out.println("Admin name:");
				String name = sc.next();
				System.out.println("password:");
				String password2 = sc.next();

					IAdminDao dao2 = new AdminDao();
					boolean b1 = dao2.adminLogin(name, password2);
					if (b1 == true) {
						System.out.println("Welcome " + name);
						AdminFunctions.operations();

					} else
						System.out.println("Invalid username or password");

				
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

		System.out.println("*****************THANK YOU****************");
	}
}
