package com.java.jdbc.dao;

import java.sql.SQLException;
import java.util.List;
import com.java.jdbc.model.Asset;
import com.java.jdbc.model.AssetAllocation;
import com.java.jdbc.model.AssetHistory;
import com.java.jdbc.model.Employ;
import com.java.jdbc.exceptions.AssetException;
import com.java.jdbc.model.Admin;

public interface AssetDao {


    public String addAdmin(Admin admin) throws ClassNotFoundException, SQLException,AssetException;
    public boolean loginAdmin(String username, String password) throws ClassNotFoundException, SQLException,AssetException;
    public Admin searchAdminByUsername(String username) throws ClassNotFoundException, SQLException,AssetException;
    public List<Admin> showAdmin() throws ClassNotFoundException, SQLException,AssetException;

   
    public String addEmploy(Employ employ) throws ClassNotFoundException, SQLException,AssetException;
    public Employ searchEmploy(int employId) throws ClassNotFoundException, SQLException,AssetException;
    public List<Employ> showEmploy() throws ClassNotFoundException, SQLException,AssetException;

    public String addAsset(Asset asset) throws ClassNotFoundException, SQLException,AssetException;
    public String updateAsset(Asset asset) throws ClassNotFoundException, SQLException,AssetException;
    public String deleteAsset(int assetId) throws ClassNotFoundException, SQLException,AssetException;
    public Asset searchAsset(int assetId) throws ClassNotFoundException, SQLException,AssetException;
    public List<Asset> showAssetDao() throws ClassNotFoundException, SQLException,AssetException;
    public String addAssetDao(Asset asset) throws ClassNotFoundException, SQLException,AssetException;
    public String updateAssetDao(Asset asset) throws ClassNotFoundException, SQLException,AssetException;
    public String deleteAssetDao(int assetId) throws ClassNotFoundException, SQLException,AssetException;
    public Asset getAssetById(int assetId) throws SQLException, ClassNotFoundException,AssetException;


    public String addAssetAllocation(AssetAllocation allocation) throws ClassNotFoundException, SQLException,AssetException;
    public List<Asset> showAssetsAllocatedToEmployee(int employId) throws ClassNotFoundException, SQLException,AssetException;
    public List<Asset> showAssetsNotAllocated() throws ClassNotFoundException, SQLException,AssetException;
    public List<Asset> showAssetsAllocatedToEmployeeDao(int employId) throws ClassNotFoundException, SQLException,AssetException;
    public List<Asset> showAssetsNotAllocatedDao() throws ClassNotFoundException, SQLException,AssetException;


    public List<AssetHistory> showAssetHistoryForEmployee(int employId) throws ClassNotFoundException, SQLException,AssetException;
    public String addAssetHistory(AssetHistory history) throws ClassNotFoundException, SQLException,AssetException;
    public List<AssetHistory> showAssetHistoryForEmployeeDao(int employId) throws ClassNotFoundException, SQLException,AssetException;
    public String addAssetHistoryDao(AssetHistory history) throws ClassNotFoundException, SQLException,AssetException;
	public String removeAsset(int deleteAssetId);
}
