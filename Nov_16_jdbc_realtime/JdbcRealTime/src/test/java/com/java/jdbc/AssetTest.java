package com.java.jdbc;

import org.junit.Before;
import org.junit.Test;
import com.java.jdbc.dao.AssetDaoImp;
import com.java.jdbc.model.Asset;
import com.java.jdbc.model.Admin;
import com.java.jdbc.model.Employ;
import com.java.jdbc.model.AssetHistory;

import static org.junit.Assert.*;

import java.util.List;

public class AssetTest {

    private AssetDaoImp assetDao;

    @Before
    public void setUp() {
        // Initialize the AssetDaoImp object before each test
        assetDao = new AssetDaoImp();
    }

    // Test for adding an admin
    @Test
    public void testAddAdmin() {
        Admin admin = new Admin(9, "John Doe", "Male", "1990-01-01", "2020-01-01", "1234567890", "john.doe@email.com", "johndoe", "password123");
        try {
            String result = assetDao.addAdmin(admin);
            assertEquals("Admin added successfully", result); // Success message check
        } catch (Exception e) {
            fail("Exception occurred while adding admin: " + e.getMessage());
        }
    }

    // Test for admin login
    @Test
    public void testLoginAdmin() {
        try {
            boolean isAuthenticated = assetDao.loginAdmin("johndoe", "password123");
            assertTrue("Login should be successful with valid credentials.", isAuthenticated);
        } catch (Exception e) {
            fail("Exception occurred during admin login: " + e.getMessage());
        }
    }

    // Test for searching an admin by username
    @Test
    public void testSearchAdminByUsername() {
        try {
            Admin admin = assetDao.searchAdminByUsername("johndoe");
            assertNotNull("Admin should be found with the given username.", admin);
            assertEquals("John Doe", admin.getAdminName());
        } catch (Exception e) {
            fail("Exception occurred while searching admin by username: " + e.getMessage());
        }
    }

    // Test for listing all admins
    @Test
    public void testShowAdmin() {
        try {
            List<Admin> adminList = assetDao.showAdmin();
            assertNotNull("Admin list should not be null.", adminList);
            assertTrue("Admin list should have at least one admin.", adminList.size() > 0);
        } catch (Exception e) {
            fail("Exception occurred while showing all admins: " + e.getMessage());
        }
    }

    // Test for adding an employee
    @Test
    public void testAddEmployee() {
        Employ employee = new Employ(0, "Jane Smith", "Female", "1995-05-10", "2021-06-15", 50000, "janesmith", "password123");
        try {
            String result = assetDao.addEmploy(employee);
            assertEquals("Employee added successfully", result); // Success message check
        } catch (Exception e) {
            fail("Exception occurred while adding employee: " + e.getMessage());
        }
    }

    // Test for searching an employee by ID
    @Test
    public void testSearchEmployee() {
        try {
            Employ employee = assetDao.searchEmploy(1); // Assuming employee with ID 1 exists
            assertNotNull("Employee should be found with the given ID.", employee);
            assertEquals("Jane Smith", employee.getEmployName());
        } catch (Exception e) {
            fail("Exception occurred while searching employee: " + e.getMessage());
        }
    }

    // Test for listing all employees
    @Test
    public void testShowEmployee() {
        try {
            List<Employ> employeeList = assetDao.showEmploy();
            assertNotNull("Employee list should not be null.", employeeList);
            assertTrue("Employee list should have at least one employee.", employeeList.size() > 0);
        } catch (Exception e) {
            fail("Exception occurred while showing all employees: " + e.getMessage());
        }
    }

    // Test for adding an asset
    @Test
    public void testAddAsset() {
        Asset asset = new Asset(0, "Laptop", "Dell XPS", "XPS 13", 1500.0, 10);
        try {
            String result = assetDao.addAsset(asset);
            assertEquals("Asset added successfully", result); // Success message check
        } catch (Exception e) {
            fail("Exception occurred while adding asset: " + e.getMessage());
        }
    }

    // Test for updating an asset
    @Test
    public void testUpdateAsset() {
        Asset asset = new Asset(0, "Laptop", "Dell XPS", "XPS 13", 1600.0, 15);
        asset.setAssetId(1); // Assuming asset with ID 1 exists
        try {
            String result = assetDao.updateAsset(asset);
            assertEquals("Asset updated successfully", result); // Success message check
        } catch (Exception e) {
            fail("Exception occurred while updating asset: " + e.getMessage());
        }
    }

    // Test for deleting an asset
    @Test
    public void testDeleteAsset() {
        try {
            String result = assetDao.deleteAsset(1); // Assuming asset with ID 1 exists
            assertEquals("Asset deleted successfully", result); // Success message check
        } catch (Exception e) {
            fail("Exception occurred while deleting asset: " + e.getMessage());
        }
    }

    // Test for adding asset history
    @Test
    public void testAddAssetHistory() {
        AssetHistory assetHistory = new AssetHistory(1, 1, 1, "2024-11-24", "Allocated", null);
        try {
            String result = assetDao.addAssetHistory(assetHistory);
            assertEquals("Asset history added successfully", result); // Success message check
        } catch (Exception e) {
            fail("Exception occurred while adding asset history: " + e.getMessage());
        }
    }

    // Test for showing asset history for an employee
    @Test
    public void testShowAssetHistoryForEmployee() {
        try {
            List<AssetHistory> historyList = assetDao.showAssetHistoryForEmployee(1); // Assuming employee ID 1 exists
            assertNotNull("Asset history list should not be null.", historyList);
            assertTrue("Asset history list should have at least one entry.", historyList.size() > 0);
        } catch (Exception e) {
            fail("Exception occurred while showing asset history for employee: " + e.getMessage());
        }
    }

    // Test for showing assets allocated to an employee
    @Test
    public void testShowAssetsAllocatedToEmployee() {
        try {
            List<Asset> allocatedAssets = assetDao.showAssetsAllocatedToEmployee(1); // Assuming employee ID 1 exists
            assertNotNull("Allocated assets list should not be null.", allocatedAssets);
            assertTrue("Allocated assets list should have at least one asset.", allocatedAssets.size() > 0);
        } catch (Exception e) {
            fail("Exception occurred while showing assets allocated to employee: " + e.getMessage());
        }
    }

    // Test for showing assets not allocated
    @Test
    public void testShowAssetsNotAllocated() {
        try {
            List<Asset> unallocatedAssets = assetDao.showAssetsNotAllocated();
            assertNotNull("Unallocated assets list should not be null.", unallocatedAssets);
            assertTrue("Unallocated assets list should have at least one asset.", unallocatedAssets.size() > 0);
        } catch (Exception e) {
            fail("Exception occurred while showing unallocated assets: " + e.getMessage());
        }
    }

    // Test for asset not found scenarios
    @Test
    public void testSearchAssetNotFound() {
        try {
            Asset asset = assetDao.searchAsset(999); // Assuming no asset with ID 999
            assertNull("Asset with ID 999 should not exist.", asset);
        } catch (Exception e) {
            fail("Exception occurred while searching for non-existent asset: " + e.getMessage());
        }
    }

    // Test for unsuccessful login attempts
    @Test
    public void testLoginAdminFailure() {
        try {
            boolean isAuthenticated = assetDao.loginAdmin("invaliduser", "wrongpassword");
            assertFalse("Login should fail with invalid credentials.", isAuthenticated);
        } catch (Exception e) {
            fail("Exception occurred during admin login failure: " + e.getMessage());
        }
    }

    // Test for searching an employee by an invalid ID
    @Test
    public void testSearchEmployeeNotFound() {
        try {
            Employ employee = assetDao.searchEmploy(999); // Assuming no employee with ID 999
            assertNull("Employee with ID 999 should not exist.", employee);
        } catch (Exception e) {
            fail("Exception occurred while searching for non-existent employee: " + e.getMessage());
        }
    }
}
