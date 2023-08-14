/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DataHelper.DatabaseHelper;
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
public class KhachHangDAO {
     Connection con = null;
    PreparedStatement sttm = null;
    public List<User> getAll(){
       List<User>list = new ArrayList<>();
       ResultSet rs = null;
       Statement sttm = null;
       try {
           String sSQL = "SELECT * FROM NGUOIDUNG";
           con = DatabaseHelper.getDBConnect();
           sttm = con.createStatement();
           rs = sttm.executeQuery(sSQL);
           while(rs.next()){
               User st = new User();
               st.setMa(rs.getString("MAND"));
               st.setTen(rs.getString("TENND"));
               st.setSoDT(rs.getString("SDT"));
               st.setNamSinh(rs.getInt("NAMSINH"));
               st.setSoDu(rs.getDouble("SODU"));
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
    public int add(User st){
       try {
           String sSQL ="Insert into NGUOIDUNG "
                   + "values (?,?,?,?,?)";
                   
           con = DatabaseHelper.getDBConnect();
           sttm = con.prepareStatement(sSQL);
           sttm.setString(1,st.getMa());
           sttm.setString(2,st.getTen());
           sttm.setString(3,st.getSoDT());
           sttm.setInt(4,st.getNamSinh());        
           sttm.setDouble(5,st.getSoDu()); 
           if(sttm.executeUpdate()>0){
               System.out.println("Insert thanh cong");
               return 1;
           }
       } catch (Exception e) {
           System.out.println("Error"+e.toString());
       }
       return -1;
   }
     public int update(User st) {
   try {
       String sSQL = "UPDATE NGUOIDUNG SET TENND = ?, SDT = ?, NAMSINH = ?, SODU = ? WHERE MAND = ?";
       con = DatabaseHelper.getDBConnect();
       sttm = con.prepareStatement(sSQL);      
       sttm.setString(1, st.getTen());
       sttm.setString(2, st.getSoDT());
       sttm.setInt(3, st.getNamSinh());
       sttm.setDouble(4, st.getSoDu());
       sttm.setString(5, st.getMa());
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
     public int delete(User st){
       try {
           String sSQL ="delete NGUOIDUNG where MAND = ?;";
           con = DatabaseHelper.getDBConnect();
           sttm = con.prepareStatement(sSQL);      
           sttm.setString(1,st.getMa());
           if(sttm.executeUpdate()>0){
               System.out.println("xoa thanh cong");
               return 1;
           }
       } catch (Exception e) {
           System.out.println("Error"+e.toString());
       }
       return -1;
   }
     public User findStudentByID(String SDT){
       List<User>list = new ArrayList<>();
       ResultSet rs = null;
       Statement sttm = null;
       try {
           String sSQL = "Select * from NGUOIDUNG where SDT ='"+SDT+"'";
           con = DatabaseHelper.getDBConnect();
           sttm = con.createStatement();
           rs = sttm.executeQuery(sSQL);
           while(rs.next()){
               User st = new User();
               st.setMa(rs.getString("MAND"));
               st.setTen(rs.getString("TENND"));
               st.setSoDT(rs.getString("SDT"));
               st.setNamSinh(rs.getInt("NAMSINH"));
               st.setSoDu(rs.getDouble("SODU"));
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
