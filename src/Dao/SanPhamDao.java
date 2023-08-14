/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DataHelper.DatabaseHelper;
import Model.SanPham;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class SanPhamDao {
     Connection con = null;
    PreparedStatement sttm = null;
    public List<SanPham> getAll(){
       List<SanPham>list = new ArrayList<>();
       ResultSet rs = null;
       Statement sttm = null;
       try {
           String sSQL = "SELECT * FROM SANPHAM";
           con = DatabaseHelper.getDBConnect();
           sttm = con.createStatement();
           rs = sttm.executeQuery(sSQL);
           while(rs.next()){
               SanPham st = new SanPham();
               st.setMay(rs.getString("MAY"));
               st.setTenSP1(rs.getString("TENSP1"));
               st.setTenSP2(rs.getString("TENSP2"));
               st.setTenSP3(rs.getString("TENSP3"));
               st.setTongtien(rs.getDouble("TONGTIEN"));               
               list.add(st);
           }
           
       } catch (Exception e) {
           System.out.println("Error"+e.toString());
       }
       finally{
           try {
               rs.close();
               sttm.close();
               con.close();
           } catch (Exception e) {
           }
       }
       return list;
       
   }
    public int add(SanPham st){
       try {
           String sSQL ="Insert into SANPHAM "
                   + "values (?,?,?,?,?)";
                   
           con = DatabaseHelper.getDBConnect();
           sttm = con.prepareStatement(sSQL);
           sttm.setString(1,st.getMay());
           sttm.setString(2,st.getTenSP1());
           sttm.setString(3,st.getTenSP2());
           sttm.setString(4,st.getTenSP3());        
           sttm.setDouble(5,st.getTongtien()); 
           if(sttm.executeUpdate()>0){
               System.out.println("Insert thanh cong");
               return 1;
           }
       } catch (Exception e) {
           System.out.println("Error"+e.toString());
       }
       return -1;
   }
     public int update(SanPham st) {
   try {
       String sSQL = "UPDATE SANPHAM SET TENSP1 = ?, TENSP2 = ?, TENSP3 = ?, TONGTIEN = ? WHERE MAY = ?";
       con = DatabaseHelper.getDBConnect();
       sttm = con.prepareStatement(sSQL);      
       sttm.setString(1, st.getTenSP1());
       sttm.setString(2, st.getTenSP2());
       sttm.setString(3, st.getTenSP3());
       sttm.setDouble(4, st.getTongtien());
       sttm.setString(5, st.getMay());
       if (sttm.executeUpdate() > 0) {
           System.out.println("Update thành công");
           return 1;
       }
   } catch (Exception e) {
       System.out.println("Lỗi: " + e.toString());
   } finally {
       // Đóng kết nối và tài nguyên liên quan tại đây (con, sttm, ...)
   }
   return -1;
}
     public int delete(SanPham st){
       try {
           String sSQL ="delete SANPHAM where MAY = ?;";
           con = DatabaseHelper.getDBConnect();
           sttm = con.prepareStatement(sSQL);      
           sttm.setString(1,st.getMay());
           if(sttm.executeUpdate()>0){
               System.out.println("xoa thanh cong");
               return 1;
           }
       } catch (Exception e) {
           System.out.println("Error"+e.toString());
       }
       return -1;
   }
     public SanPham findHoaDon(String may){
       List<SanPham>list = new ArrayList<>();
       ResultSet rs = null;
       Statement sttm = null;
       try {
           String sSQL = "Select * from SANPHAM where MAY ='"+may+"'";
           con = DatabaseHelper.getDBConnect();
           sttm = con.createStatement();
           rs = sttm.executeQuery(sSQL);
           while(rs.next()){
               SanPham st = new SanPham();
               st.setMay(rs.getString("MAY"));
               st.setTenSP1(rs.getString("TENSP1"));
               st.setTenSP2(rs.getString("TENSP2"));
               st.setTenSP3(rs.getString("TENSP3"));
               st.setTongtien(rs.getDouble("TONGTIEN"));
               
               return st;
           }
           
       } catch (Exception e) {
           System.out.println("Error"+e.toString());
       }
       finally{
           try {
               rs.close();
               sttm.close();
               con.close();
           } catch (Exception e) {
           }
       }
       return null;    
   }
}
