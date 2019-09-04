package com.revature.model;

public class UserActivity {
	private String cus_name;
	private String request_type;
	private Long donating_amt;
	private long balance_req_amt;
	public long getBalance_req_amt() {
		return balance_req_amt;
	}
	public void setBalance_req_amt(long balance_req_amt) {
		this.balance_req_amt = balance_req_amt;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getRequest_type() {
		return request_type;
	}
	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}
	public Long getDonating_amt() {
		return donating_amt;
	}
	public void setDonating_amt(Long donating_amt) {
		this.donating_amt = donating_amt;
	}
	
public String toString() {
	return "UserActivity[cus_name=" + cus_name + ", request_type=" + request_type + ",donating_amt=" + donating_amt + 
			                      ",balance_req_amt=" + balance_req_amt + "]";
}
}
