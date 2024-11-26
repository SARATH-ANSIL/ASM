package com.java.jdbc.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.jdbc.dao.AssetDaoImp;
import com.java.jdbc.model.Asset;

public class AssetDeleteMain {

    public static void main(String[] args) {
        int assetId;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Asset ID to delete: ");
        assetId = sc.nextInt();
        AssetDaoImp dao = new AssetDaoImp();
        try {
            System.out.println(dao.deleteAsset(assetId));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
