package com.java.jdbc.model;

public class Asset {
    private int assetId;
    private String assetType;
    private String assetName;
    private String model;
    private double price;
    public Asset(int assetId, String assetType, String assetName, String model, double price, int quantity) {
		super();
		this.assetId = assetId;
		this.assetType = assetType;
		this.assetName = assetName;
		this.model = model;
		this.price = price;
		this.quantity = quantity;
	}
	public Asset() {
		// TODO Auto-generated constructor stub
	}
	private int quantity;
  
	// Getters and Setters
    public int getAssetId() {
        return assetId;
    }
    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }
    public String getAssetType() {
        return assetType;
    }
    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }
    public String getAssetName() {
        return assetName;
    }
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", assetType=" + assetType + ", assetName=" + assetName + ", model="
				+ model + ", price=" + price + ", quantity=" + quantity + "]";
	}
    
}
