package com.java.jdbc.model;

public class Admin {
    private int adminId;
    private String adminName;
    private String gender;
    private String dob;
    private String doj;
    private String mobile;
    private String email;
    private String username;
    private String password;

    public Admin(int adminId, String adminName, String gender, String dob, String doj, String mobile, String email,
			String username, String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.gender = gender;
		this.dob = dob;
		this.doj = doj;
		this.mobile = mobile;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public int getAdminId() {
        return adminId;
    }
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getDoj() {
        return doj;
    }
    public void setDoj(String doj) {
        this.doj = doj;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", gender=" + gender + ", dob=" + dob
				+ ", doj=" + doj + ", mobile=" + mobile + ", email=" + email + ", username=" + username + ", password="
				+ password + "]";
	}
}
