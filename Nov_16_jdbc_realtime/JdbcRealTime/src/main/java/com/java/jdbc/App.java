package com.java.jdbc;

import java.util.List;
import java.util.Scanner;
import com.java.jdbc.dao.AssetDaoImp;
import com.java.jdbc.model.Asset;
import com.java.jdbc.model.AssetAllocation;
import com.java.jdbc.model.AssetHistory;
import com.java.jdbc.model.Admin;
import com.java.jdbc.model.Employ;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AssetDaoImp assetDao = new AssetDaoImp();
        
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add Admin");
            System.out.println("2. Login Admin");
            System.out.println("3. Search Admin");
            System.out.println("4. Show All Admins");
            System.out.println("5. Add Employee");
            System.out.println("6. Search Employee");
            System.out.println("7. Show All Employees");
            System.out.println("8. Add Asset");
            System.out.println("9. Update Asset");
            System.out.println("10. Delete Asset");
            System.out.println("11. Add Asset Allocation");
            System.out.println("12. Show Assets Allocated to Employee");
            System.out.println("13. Show Assets Not Allocated");
            System.out.println("14. Show Asset History for Employee");
            System.out.println("15. Add Asset History");
            System.out.println("16. Exit");
            scanner.nextLine();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Admin
                    System.out.println("Enter Admin details:");
                    System.out.print("Admin ID: ");
                    int adminId = scanner.nextInt();
                    System.out.print("Admin Name: ");
                    String adminName = scanner.next();
                    System.out.print("Gender: ");
                    String gender = scanner.next();
                    System.out.print("DOB (YYYY-MM-DD): ");
                    String dob = scanner.next();
                    System.out.print("DOJ (YYYY-MM-DD): ");
                    String doj = scanner.next();
                    System.out.print("Mobile: ");
                    String mobile = scanner.next();
                    System.out.print("Email: ");
                    String email = scanner.next();
                    System.out.print("Username: ");
                    String username = scanner.next();
                    System.out.print("Password: ");
                    String password = scanner.next();
//                    private int adminId;
//                    private String adminName;
//                    private String gender;
//                    private String dob;
//                    private String doj;
//                    private String mobile;
//                    private String email;
//                    private String username;
//                    private String password;
                    Admin admin = new Admin(adminId,adminName, gender, dob, doj, mobile, email, username, password);
                    try {
                        String message = assetDao.addAdmin(admin);
                        System.out.println(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    // Login Admin
                    System.out.print("Enter Username: ");
                    String loginUsername = scanner.next();
                    System.out.print("Enter Password: ");
                    String loginPassword = scanner.next();

                    try {
                        boolean isAuthenticated = assetDao.loginAdmin(loginUsername, loginPassword);
                        if (isAuthenticated) {
                            System.out.println("Admin logged in successfully.");
                        } else {
                            System.out.println("Invalid credentials.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    // Search Admin
                    System.out.print("Enter Admin Username: ");
                    String searchUsername = scanner.next();

                    try {
                        Admin foundAdmin = assetDao.searchAdminByUsername(searchUsername);
                        if (foundAdmin != null) {
                            System.out.println(foundAdmin);
                        } else {
                            System.out.println("Admin not found.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    // Show All Admins
                    try {
                        List<Admin> adminList = assetDao.showAdmin();
                        for (Admin a : adminList) {
                            System.out.println(a);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    // Add Employee
                    System.out.println("Enter Employee details:");
                    System.out.print("Employee ID: ");
                    int empId = scanner.nextInt();
                    System.out.print("Employee Name: ");
                    String employName = scanner.next();
                    System.out.print("Gender: ");
                    String employGender = scanner.next();
                    System.out.print("DOB (YYYY-MM-DD): ");
                    String employDob = scanner.next();
                    System.out.print("DOJ (YYYY-MM-DD): ");
                    String employDoj = scanner.next();
                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();
                    System.out.print("Username: ");
                    String employUsername = scanner.next();
                    System.out.print("Password: ");
                    String employPassword = scanner.next();
                    
                    Employ employ = new Employ(empId,employName, employGender, employDob, employDoj, salary, employUsername, employPassword);
                    try {
                        String message = assetDao.addEmploy(employ);
                        System.out.println(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 6:
                    // Search Employee
                    System.out.print("Enter Employee ID: ");
                    int employId = scanner.nextInt();

                    try {
                        Employ foundEmploy = assetDao.searchEmploy(employId);
                        if (foundEmploy != null) {
                            System.out.println(foundEmploy);
                        } else {
                            System.out.println("Employee not found.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 7:
                    // Show All Employees
                    try {
                        List<Employ> employList = assetDao.showEmploy();
                        for (Employ e : employList) {
                            System.out.println(e);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 8:
                    // Add Asset
                    System.out.println("Enter Asset details:");
                    System.out.print("AssetId: ");
                    int assetId = scanner.nextInt();
                    System.out.print("Asset Type: ");
                    String assetType = scanner.next();
                    System.out.print("Asset Name: ");
                    String assetName = scanner.next();
                    System.out.print("Model: ");
                    String model = scanner.next();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Quantity: ");
                    int quantity = scanner.nextInt();

                    Asset asset = new Asset(assetId, assetType, assetName, model, price, quantity);
                    try {
                        String message = assetDao.addAsset(asset);
                        System.out.println(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 9:
                    // Update Asset
                    System.out.print("Enter Asset ID to update: ");
                    int assetIdToUpdate = scanner.nextInt();
                    System.out.println("Enter updated Asset details:");
                    System.out.print("Asset Type: ");
                    String updatedAssetType = scanner.next();
                    System.out.print("Asset Name: ");
                    String updatedAssetName = scanner.next();
                    System.out.print("Model: ");
                    String updatedModel = scanner.next();
                    System.out.print("Price: ");
                    double updatedPrice = scanner.nextDouble();
                    System.out.print("Quantity: ");
                    int updatedQuantity = scanner.nextInt();

                    Asset updatedAsset = new Asset(assetIdToUpdate,updatedAssetType, updatedAssetName, updatedModel, updatedPrice, updatedQuantity);
                    updatedAsset.setAssetId(assetIdToUpdate);
                    try {
                        String message = assetDao.updateAsset(updatedAsset);
                        System.out.println(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 10:
                    // Delete Asset
                    System.out.print("Enter Asset ID to delete: ");
                    int assetIdToDelete = scanner.nextInt();

                    try {
                        String message = assetDao.deleteAsset(assetIdToDelete);
                        System.out.println(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 11:
                    // Add Asset Allocation
                    System.out.println("Enter Asset Allocation details:");
                    System.out.print("	Allocation ID: ");
                    int allocId = scanner.nextInt();
                    System.out.print("Employee ID: ");
                    int allocEmployId = scanner.nextInt();
                    System.out.print("Admin ID: ");
                    int allocAdminId = scanner.nextInt();
                    System.out.print("Asset ID: ");
                    int allocAssetId = scanner.nextInt();
                    System.out.print("Allocation Date (YYYY-MM-DD): ");
                    String allocDate = scanner.next();
                    System.out.print("Comments: ");
                    String comments = scanner.next();
                  
                    AssetAllocation allocation = new AssetAllocation(allocId,allocEmployId, allocAdminId, allocAssetId, allocDate, comments);
                    try {
                        String message = assetDao.addAssetAllocation(allocation);
                        System.out.println(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 12:
                    // Show Assets Allocated to Employee
                    System.out.print("Enter Employee ID: ");
                    int employeeId = scanner.nextInt();

                    try {
                        List<Asset> allocatedAssets = assetDao.showAssetsAllocatedToEmployee(employeeId);
                        for (Asset a : allocatedAssets) {
                            System.out.println(a);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 13:
                    // Show Assets Not Allocated
                    try {
                        List<Asset> unallocatedAssets = assetDao.showAssetsNotAllocated();
                        for (Asset a : unallocatedAssets) {
                            System.out.println(a);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 14:
                    // Show Asset History for Employee
                    System.out.print("Enter Employee ID: ");
                    int historyEmployId = scanner.nextInt();

                    try {
                        List<AssetHistory> historyList = assetDao.showAssetHistoryForEmployee(historyEmployId);
                        for (AssetHistory history : historyList) {
                            System.out.println(history);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 15:
                    // Add Asset History
                    System.out.println("Enter Asset History details:");
                    System.out.print("Asset ID: ");
                    int assetHistoryId = scanner.nextInt();
                    System.out.print("Employee ID: ");
                    int employeeHistoryId = scanner.nextInt();
                    System.out.print("Admin ID: ");
                    int adminHistoryId = scanner.nextInt();
                    System.out.print("Action Date (YYYY-MM-DD): ");
                    String actionDate = scanner.next();
                    System.out.print("Return Date (YYYY-MM-DD): ");
                    String returnDate = scanner.next();
                    System.out.print("Action: ");
                    String action = scanner.next();
                    
                    AssetHistory assetHistory = new AssetHistory(assetHistoryId, employeeHistoryId, adminHistoryId, actionDate,returnDate, action);
                    try {
                        String message = assetDao.addAssetHistory(assetHistory);
                        System.out.println(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 16:
                    // Exit
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
