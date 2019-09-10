package com.revature.model;

public class UserDetails {
	private String customername;
	private String password;
	private long accountno;
	private long phoneno ;
	private boolean active;
	private String requesttype;
	 
	
	public String getCustomername() {
		return customername;
	}


	public void setCustomername(String customername) {
		this.customername = customername;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public long getAccountno() {
		return accountno;
	}


	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}


	public long getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public String getRequesttype() {
		return requesttype;
	}


	public void setRequesttype(String requesttype) {
		this.requesttype = requesttype;
	}


	public String toString() {
		return "UserDetails[cus_name=" + customername + ", password=" + password +  ",phone_num=" + phoneno + "]";
	}
	}
	