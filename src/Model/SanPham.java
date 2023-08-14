/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author HP
 */
public class SanPham {
    private String may ;
    private String tenSP1;
    private String tenSP2;
    private String tenSP3;
    private double tongtien;

    public SanPham() {
    }

    public SanPham(String may, String tenSP1, String tenSP2, String tenSP3, double tongtien) {
        this.may = may;
        this.tenSP1 = tenSP1;
        this.tenSP2 = tenSP2;
        this.tenSP3 = tenSP3;
        this.tongtien = tongtien;
    }

    public SanPham(String may) {
        this.may = may;
    }

    public String getMay() {
        return may;
    }

    public void setMay(String may) {
        this.may = may;
    }

    public String getTenSP1() {
        return tenSP1;
    }

    public void setTenSP1(String tenSP1) {
        this.tenSP1 = tenSP1;
    }

    public String getTenSP2() {
        return tenSP2;
    }

    public void setTenSP2(String tenSP2) {
        this.tenSP2 = tenSP2;
    }

    public String getTenSP3() {
        return tenSP3;
    }

    public void setTenSP3(String tenSP3) {
        this.tenSP3 = tenSP3;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    
    
    
} 
