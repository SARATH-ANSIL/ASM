package com.java.jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.java.jdbc.model.Asset;
import com.java.jdbc.model.Admin;
import com.java.jdbc.model.Employ;
import com.java.jdbc.model.AssetAllocation;
import com.java.jdbc.model.AssetHistory;
import com.java.jdbc.util.ConnectionHelper;
public class AssetDaoImp implements AssetDao {

    Connection connection;
    PreparedStatement pst;

    // 1. Add Admin
    public String addAdmin(Admin admin) throws ClassNotFoundException, SQLException {
        String cmd = "Insert into Admin(adminName, Gender, Dob, DOJ, Mobile, Email, Username, password) "
                + "values(?, ?, ?, ?, ?, ?, ?, ?)";
        connection = ConnectionHelper.getConnection();
        pst = connection.prepareStatement(cmd);
        pst.setString(1, admin.getAdminName());
        pst.setString(2, admin.getGender());
        pst.setDate(3, Date.valueOf(admin.getDob()));
        pst.setDate(4, Date.valueOf(admin.getDoj()));
        pst.setString(5, admin.getMobile());
        pst.setString(6, admin.getEmail());
        pst.setString(7, admin.getUsername());
        pst.setString(8, admin.getPassword()); 
        pst.executeUpdate();
        return "Admin Record Inserted...";
    }

    // 2. Login Admin (Authentication)
    public boolean loginAdmin(String username, String password) throws ClassNotFoundException, SQLException {
        connection = ConnectionHelper.getConnection();
        String cmd = "SELECT * FROM Admin WHERE Username = ? AND password = ?";
        pst = connection.prepareStatement(cmd);
        pst.setString(1, username);
        pst.setString(2, password); 
        ResultSet rs = pst.executeQuery();
        return rs.next();  
    }

    // 3. Search By AdminUsername
    public Admin searchAdminByUsername(String username) throws ClassNotFoundException, SQLException {
        Admin admin = null;
        connection = ConnectionHelper.getConnection();
        String cmd = "SELECT * FROM Admin WHERE Username = ?";
        pst = connection.prepareStatement(cmd);
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            admin = new Admin();
            admin.setAdminId(rs.getInt("adminId"));
            admin.setAdminName(rs.getString("adminName"));
            admin.setGender(rs.getString("Gender"));
            admin.setDob(rs.getString("Dob"));
            admin.setDoj(rs.getString("DOJ"));
            admin.setMobile(rs.getString("Mobile"));
            admin.setEmail(rs.getString("Email"));
            admin.setUsername(rs.getString("Username"));
            admin.setPassword(rs.getString("password"));
        }
        return admin;
    }

    // 4. Show Admin
    public List<Admin> showAdmin() throws ClassNotFoundException, SQLException {
        List<Admin> adminList = new ArrayList<>();
        connection = ConnectionHelper.getConnection();
        String cmd = "SELECT * FROM Admin";
        pst = connection.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Admin admin = new Admin();
            admin.setAdminId(rs.getInt("adminId"));
            admin.setAdminName(rs.getString("adminName"));
            admin.setGender(rs.getString("Gender"));
            admin.setDob(rs.getString("Dob"));
            admin.setDoj(rs.getString("DOJ"));
            admin.setMobile(rs.getString("Mobile"));
            admin.setEmail(rs.getString("Email"));
            admin.setUsername(rs.getString("Username"));
            admin.setPassword(rs.getString("password"));
            adminList.add(admin);
        }
        return adminList;
    }

    // 5. Add Employ
    public String addEmploy(Employ employ) throws ClassNotFoundException, SQLException {
        String cmd = "Insert into Employ(EmployName, Gender, Dob, Doj, Salary, Username, password) "
                + "values(?, ?, ?, ?, ?, ?, ?)";
        connection = ConnectionHelper.getConnection();
        pst = connection.prepareStatement(cmd);
        pst.setString(1, employ.getEmployName());
        pst.setString(2, employ.getGender());
        pst.setDate(3, Date.valueOf(employ.getDob()));
        pst.setDate(4, Date.valueOf(employ.getDoj()));
        pst.setDouble(5, employ.getSalary());
        pst.setString(6, employ.getUsername());
        pst.setString(7, employ.getPassword());  
        pst.executeUpdate();
        return "Employee Record Inserted...";
    }

    // 6. Search Employ
    public Employ searchEmploy(int employId) throws ClassNotFoundException, SQLException {
        Employ employ = null;
        connection = ConnectionHelper.getConnection();
        String cmd = "SELECT * FROM Employ WHERE EmployID = ?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, employId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            employ = new Employ();
            employ.setEmployId(rs.getInt("EmployID"));
            employ.setEmployName(rs.getString("EmployName"));
            employ.setGender(rs.getString("Gender"));
            employ.setDob(rs.getString("Dob"));
            employ.setDoj(rs.getString("Doj"));
            employ.setSalary(rs.getDouble("Salary"));
            employ.setUsername(rs.getString("Username"));
            employ.setPassword(rs.getString("password"));
        }
        return employ;
    }

    // 7. Show Employ
    public List<Employ> showEmploy() throws ClassNotFoundException, SQLException {
        List<Employ> employList = new ArrayList<>();
        connection = ConnectionHelper.getConnection();
        String cmd = "SELECT * FROM Employ";
        pst = connection.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Employ employ = new Employ();
            employ.setEmployId(rs.getInt("EmployID"));
            employ.setEmployName(rs.getString("EmployName"));
            employ.setGender(rs.getString("Gender"));
            employ.setDob(rs.getString("Dob"));
            employ.setDoj(rs.getString("Doj"));
            employ.setSalary(rs.getDouble("Salary"));
            employ.setUsername(rs.getString("Username"));
            employ.setPassword(rs.getString("password"));
            employList.add(employ);
        }
        return employList;
    }

    // 8. Add Asset
    public String addAsset(Asset asset) throws ClassNotFoundException, SQLException {
        String cmd = "Insert into Asset(AssetType, AssetName, Model, Price, Quantity) "
                + "values(?, ?, ?, ?, ?)";
        connection = ConnectionHelper.getConnection();
        pst = connection.prepareStatement(cmd);
        pst.setString(1, asset.getAssetType());
        pst.setString(2, asset.getAssetName());
        pst.setString(3, asset.getModel());
        pst.setDouble(4, asset.getPrice());
        pst.setInt(5, asset.getQuantity());
        pst.executeUpdate();
        return "Asset Record Inserted...";
    }

    // 9. Update Asset
    public String updateAsset(Asset asset) throws ClassNotFoundException, SQLException {
        String cmd = "Update Asset set AssetType = ?, AssetName = ?, Model = ?, Price = ?, Quantity = ? "
                + "where AssetId = ?";
        connection = ConnectionHelper.getConnection();
        pst = connection.prepareStatement(cmd);
        pst.setString(1, asset.getAssetType());
        pst.setString(2, asset.getAssetName());
        pst.setString(3, asset.getModel());
        pst.setDouble(4, asset.getPrice());
        pst.setInt(5, asset.getQuantity());
        pst.setInt(6, asset.getAssetId());
        pst.executeUpdate();
        return "Asset Updated...";
    }

    // 10. Remove Asset
    public String deleteAsset(int assetId) throws ClassNotFoundException, SQLException {
        String cmd = "Delete from Asset where AssetId = ?";
        connection = ConnectionHelper.getConnection();
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, assetId);
        pst.executeUpdate();
        return "Asset Deleted...";
    }

    // 11. Add AssetAllocation
    public String addAssetAllocation(AssetAllocation allocation) throws ClassNotFoundException, SQLException {
        String cmd = "Insert into AssetAllocation(EmployId, adminId, assetId, allocationDate, comments) "
                + "values(?, ?, ?, ?, ?)";
        connection = ConnectionHelper.getConnection();
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, allocation.getEmployId());
        pst.setInt(2, allocation.getAdminId());
        pst.setInt(3, allocation.getAssetId());
        pst.setDate(4, Date.valueOf(allocation.getAllocationDate()));
        pst.setString(5, allocation.getComments());
        pst.executeUpdate();
        return "Asset Allocation Added...";
    }

    // 12. Show Assets Allocated to Particular Employee
    public List<Asset> showAssetsAllocatedToEmployee(int employId) throws ClassNotFoundException, SQLException {
        List<Asset> assetList = new ArrayList<>();
        connection = ConnectionHelper.getConnection();
        String cmd = "SELECT a.* FROM Asset a JOIN AssetAllocation aa ON a.AssetId = aa.assetId WHERE aa.EmployId = ?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, employId);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Asset asset = new Asset();
            asset.setAssetId(rs.getInt("AssetId"));
            asset.setAssetType(rs.getString("AssetType"));
            asset.setAssetName(rs.getString("AssetName"));
            asset.setModel(rs.getString("Model"));
            asset.setPrice(rs.getDouble("Price"));
            asset.setQuantity(rs.getInt("Quantity"));
            assetList.add(asset);
        }
        return assetList;
    }

    // 13. Show Assets Which Are Not Allocated
    public List<Asset> showAssetsNotAllocated() throws ClassNotFoundException, SQLException {
        List<Asset> assetList = new ArrayList<>();
        connection = ConnectionHelper.getConnection();
        String cmd = "SELECT * FROM Asset WHERE AssetId NOT IN (SELECT assetId FROM AssetAllocation)";
        pst = connection.prepareStatement(cmd);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Asset asset = new Asset();
            asset.setAssetId(rs.getInt("AssetId"));
            asset.setAssetType(rs.getString("AssetType"));
            asset.setAssetName(rs.getString("AssetName"));
            asset.setModel(rs.getString("Model"));
            asset.setPrice(rs.getDouble("Price"));
            asset.setQuantity(rs.getInt("Quantity"));
            assetList.add(asset);
        }
        return assetList;
    }

    // 14. Show Asset History for Particular Employee
    public List<AssetHistory> showAssetHistoryForEmployee(int employId) throws ClassNotFoundException, SQLException {
        List<AssetHistory> historyList = new ArrayList<>();
        connection = ConnectionHelper.getConnection();
        String cmd = "SELECT * FROM AssetHistory WHERE EmployId = ?";
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, employId);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            AssetHistory history = new AssetHistory();
            history.setHistoryId(rs.getInt("HistoryId"));
            history.setAssetId(rs.getInt("AssetId"));
            history.setEmployId(rs.getInt("EmployId"));
            history.setAllocationDate(rs.getDate("AllocationDate").toString());
            history.setReturnDate(rs.getDate("ReturnDate") != null ? rs.getDate("ReturnDate").toString() : null);
            history.setStatus(rs.getString("feedBack"));
            historyList.add(history);
        }
        return historyList;
    }

    // 15. Add AssetHistory
    public String addAssetHistory(AssetHistory history) throws ClassNotFoundException, SQLException {
        String cmd = "Insert into AssetHistory(AssetId, EmployId, AllocationDate, ReturnDate, feedBack) "
                + "values(?, ?, ?, ?, ?)";
        connection = ConnectionHelper.getConnection();
        pst = connection.prepareStatement(cmd);
        pst.setInt(1, history.getAssetId());
        pst.setInt(2, history.getEmployId());
        pst.setDate(3, Date.valueOf(history.getAllocationDate()));
        pst.setDate(4, history.getReturnDate() != null ? Date.valueOf(history.getReturnDate()) : null);
        pst.setString(5, history.getStatus());
        pst.executeUpdate();
        return "Asset History Added...";
    }

	@Override
	public Asset searchAsset(int assetId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Asset> showAssetDao() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addAssetDao(Asset asset) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateAssetDao(Asset asset) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAssetDao(int assetId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asset getAssetById(int assetId) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Asset> showAssetsAllocatedToEmployeeDao(int employId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Asset> showAssetsNotAllocatedDao() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssetHistory> showAssetHistoryForEmployeeDao(int employId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addAssetHistoryDao(AssetHistory history) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeAsset(int deleteAssetId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
