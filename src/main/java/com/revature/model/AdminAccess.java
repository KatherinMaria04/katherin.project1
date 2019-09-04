package com.revature.model;

public class AdminAccess {
	private String request_type;
	private long amt_requested;
	private int active;
	
	public int getActive() {
		return active;
	}
	public void setActive(int active2) {
		if(active2==1||active2==0) {
		this.active = active2;
	}else {
		throw new IllegalArgumentException("invalid active status");
	}
	}
	public String getRequest_type() {
		return request_type;
	}
	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}
	public long getAmt_requested() {
		return amt_requested;
	}
	public void setAmt_requested(long amt_requested) {
		this.amt_requested = amt_requested;
	}
	
	public String toString() {
		return "adminDetails[request_type=" + request_type + ", amt_requested=" + amt_requested + ",active=" +active + "]";
	}
	
}
