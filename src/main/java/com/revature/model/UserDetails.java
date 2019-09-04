package com.revature.model;

public class UserDetails {
	private String cus_name;
	private String password;
	private long accountno;
	private long phone_num ;
	private boolean active;
	private String request_type;
	private Long donating_amt;
	 
	public String getRequest_type() {
		return request_type;
	}
	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}
	private long Donating_amt;
	public long getDonating_amt() {
		return Donating_amt;
	}
	public void setDonating_amt(long donating_amt) {
		Donating_amt = donating_amt;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
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
	public long getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(long phone_num) {
		this.phone_num = phone_num;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
		}
	public String toString() {
		return "UserDetails[cus_name=" + cus_name + ", password=" + password + ",accountno=" + accountno + ",phone_num=" + phone_num + "]";
	}
	}
	