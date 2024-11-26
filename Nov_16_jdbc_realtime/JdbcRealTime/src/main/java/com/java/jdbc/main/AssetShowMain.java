//package com.java.jdbc.main;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import com.java.jdbc.dao.AssetDaoImp;
//import com.java.jdbc.model.Asset;
//
//public class AssetShowMain {
//
//    public static void main(String[] args) {
//        AssetDaoImp assetDao = new AssetDaoImp(); 
//        try {
//            List<Asset> assetList = assetDao.showAssetDao(); 
//            for (Asset asset : assetList) {
//                System.out.println(asset); 
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace(); 
//        }
//    }
//}
