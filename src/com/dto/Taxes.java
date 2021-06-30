package com.dto;

public class Taxes {
    private String userName;
    private String email;
    private String mobileNo;
    private String taxName;
    private String amount;
    public Taxes() {
    	
    }
	public Taxes(String userName, String email, String mobileNo, String taxName, String amount) {
		super();
		this.userName = userName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.taxName = taxName;
		this.amount = amount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getTaxName() {
		return taxName;
	}
	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Taxes [userName=" + userName + ", email=" + email + ", mobileNo=" + mobileNo + ", taxName=" + taxName
				+ ", amount=" + amount + "]";
	}
	
    
}
