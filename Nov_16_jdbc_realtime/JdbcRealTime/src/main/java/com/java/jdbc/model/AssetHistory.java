package com.java.jdbc.model;

public class AssetHistory {
    private int historyId;
    private int assetId;
    private int employId;
    private String allocationDate;
    private String returnDate;
    private String status;

    public AssetHistory(int historyId, int assetId, int employId, String allocationDate, String returnDate,
			String status) {
		super();
		this.historyId = historyId;
		this.assetId = assetId;
		this.employId = employId;
		this.allocationDate = allocationDate;
		this.returnDate = returnDate;
		this.status = status;
	}
	public AssetHistory() {
		// TODO Auto-generated constructor stub
	}
	// Getters and Setters
    public int getHistoryId() {
        return historyId;
    }
    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }
    public int getAssetId() {
        return assetId;
    }
    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }
    public int getEmployId() {
        return employId;
    }
    public void setEmployId(int employId) {
        this.employId = employId;
    }
    public String getAllocationDate() {
        return allocationDate;
    }
    public void setAllocationDate(String allocationDate) {
        this.allocationDate = allocationDate;
    }
    public String getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
	@Override
	public String toString() {
		return "AssetHistory [historyId=" + historyId + ", assetId=" + assetId + ", employId=" + employId
				+ ", allocationDate=" + allocationDate + ", returnDate=" + returnDate + ", status=" + status + "]";
	}
    
}
