/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author HP
 */
public class User {
    private String ma;
    private String ten;
    private String soDT;
    private int namSinh;
    private double soDu;

    public User() {
    }

    public User(String ma, String ten, String soDT, int namSinh, double soDu) {
        this.ma = ma;
        this.ten = ten;
        this.soDT = soDT;
        this.namSinh = namSinh;
        this.soDu = soDu;
    }

    public User(String ma) {
        this.ma = ma;
    }

   

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

  
    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    
    
    
}
