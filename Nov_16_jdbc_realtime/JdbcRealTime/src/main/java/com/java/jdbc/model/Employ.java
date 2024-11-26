package com.java.jdbc.model;

public class Employ {
    private int employId;
    private String employName;
    private String gender;
    private String dob;
    private String doj;
    private double salary;
    private String username;
    private String password;

    
	public Employ(int employId, String employName, String gender, String dob, String doj, double salary,
			String username, String password) {
		super();
		this.employId = employId;
		this.employName = employName;
		this.gender = gender;
		this.dob = dob;
		this.doj = doj;
		this.salary = salary;
		this.username = username;
		this.password = password;
	}
	public Employ() {
		// TODO Auto-generated constructor stub
	}
	// Getters and Setters
    public int getEmployId() {
        return employId;
    }
    public void setEmployId(int employId) {
        this.employId = employId;
    }
    public String getEmployName() {
        return employName;
    }
    public void setEmployName(String employName) {
        this.employName = employName;
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
    public double getSalary() {
        return salary;
    }
    
	public void setSalary(double salary) {
        this.salary = salary;
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
		return "Employ [employId=" + employId + ", employName=" + employName + ", gender=" + gender + ", dob=" + dob
				+ ", doj=" + doj + ", salary=" + salary + ", username=" + username + ", password=" + password + "]";
	}
}
