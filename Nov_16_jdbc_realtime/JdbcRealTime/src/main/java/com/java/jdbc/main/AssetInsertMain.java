package com.java.jdbc.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.jdbc.dao.AssetDaoImp;
import com.java.jdbc.model.Asset;

public class AssetInsertMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Asset asset = new Asset(); 
        AssetDaoImp dao = new AssetDaoImp(); 
  
        System.out.println("Enter Asset ID: ");
        asset.setAssetId(sc.nextInt());
        
        System.out.println("Enter Asset Type: ");
        asset.setAssetType(sc.next());
        
        System.out.println("Enter Asset Name: ");
        asset.setAssetName(sc.next());
        
        System.out.println("Enter Asset Model: ");
        asset.setModel(sc.next());
        sc.nextLine();
        System.out.println("Enter Asset Price: ");
        asset.setPrice(sc.nextDouble());
        
        System.out.println("Enter Asset Quantity: ");
        asset.setQuantity(sc.nextInt());

        try {
           
            System.out.println(dao.addAsset(asset));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
