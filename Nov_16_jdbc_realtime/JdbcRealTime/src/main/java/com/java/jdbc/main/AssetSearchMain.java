package com.java.jdbc.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.jdbc.dao.AssetDaoImp;
import com.java.jdbc.model.Asset;

public class AssetSearchMain {

    public static void main(String[] args) {
        int assetId;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Asset ID: ");
        assetId = sc.nextInt();

        AssetDaoImp assetDao = new AssetDaoImp(); 
        try {
            Asset asset = assetDao.searchAsset(assetId); 
            if (asset != null) {
                System.out.println(asset); 
            } else {
                System.out.println("Asset not found with ID: " + assetId);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); 
        }
    }
}
