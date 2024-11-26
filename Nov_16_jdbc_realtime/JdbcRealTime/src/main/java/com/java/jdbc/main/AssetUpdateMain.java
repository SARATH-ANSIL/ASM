package com.java.jdbc.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.jdbc.dao.AssetDaoImp;
import com.java.jdbc.model.Asset;

public class AssetUpdateMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Asset asset = new Asset();  
        AssetDaoImp dao = new AssetDaoImp();  
        
    
        System.out.println("Enter Asset Id  ");
        asset.setAssetId(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter Asset Type  ");
        asset.setAssetType(sc.nextLine());
        System.out.println("Enter Asset Name  ");
        asset.setAssetName(sc.nextLine());
        System.out.println("Enter Model  ");
        asset.setModel(sc.nextLine());
        System.out.println("Enter Price  ");
        asset.setPrice(sc.nextDouble());
        System.out.println("Enter Quantity  ");
        asset.setQuantity(sc.nextInt());

        try {
           
            System.out.println(dao.updateAsset(asset));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();  
        }
    }
}
