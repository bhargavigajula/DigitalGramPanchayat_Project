package com.dto;

public class Users {
	private String userName;
	private String email;
	private String mobileNo;
	private String state;
	private String city;
	private String aadharNo;
	private String password;
	public Users() {
		
	}
	public Users(String userName, String email, String mobileNo, String state, String city, String aadharNo,
			String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.state = state;
		this.city = city;
		this.aadharNo = aadharNo;
		this.password = password;
	}
	public Users(String userName, String email, String mobileNo, String state, String city, String aadharNo) {
		super();
		this.userName = userName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.state = state;
		this.city = city;
		this.aadharNo = aadharNo;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [userName=" + userName + ", email=" + email + ", mobileNo=" + mobileNo + ", state=" + state
				+ ", city=" + city + ", aadharNo=" + aadharNo + ", password=" + password + "]";
	}

}
