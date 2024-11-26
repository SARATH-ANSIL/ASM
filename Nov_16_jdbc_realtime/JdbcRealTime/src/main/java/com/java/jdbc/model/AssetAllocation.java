package com.java.jdbc.model;

public class AssetAllocation {
    private int allocationId;
    private int employId;
    private int adminId;
    private int assetId;
    private String allocationDate;
    private String comments;

    
	public AssetAllocation(int allocationId, int employId, int adminId, int assetId, String allocationDate,
			String comments) {
		super();
		this.allocationId = allocationId;
		this.employId = employId;
		this.adminId = adminId;
		this.assetId = assetId;
		this.allocationDate = allocationDate;
		this.comments = comments;
	}
	public AssetAllocation() {
		// TODO Auto-generated constructor stub
	}
	// Getters and Setters
    public int getAllocationId() {
        return allocationId;
    }
    public void setAllocationId(int allocationId) {
        this.allocationId = allocationId;
    }
    public int getEmployId() {
        return employId;
    }
    public void setEmployId(int employId) {
        this.employId = employId;
    }
    public int getAdminId() {
        return adminId;
    }
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
    public int getAssetId() {
        return assetId;
    }
    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }
    public String getAllocationDate() {
        return allocationDate;
    }
    public void setAllocationDate(String allocationDate) {
        this.allocationDate = allocationDate;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
	@Override
	public String toString() {
		return "AssetAllocation [allocationId=" + allocationId + ", employId=" + employId + ", adminId=" + adminId
				+ ", assetId=" + assetId + ", allocationDate=" + allocationDate + ", comments=" + comments + "]";
	}
    
}
