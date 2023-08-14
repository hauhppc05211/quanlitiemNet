/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Account;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class accountDao {
     List<Account> list = new ArrayList<>();

    public accountDao() {
        list.add(new Account("Admin1","12345",true));
    }
    public boolean checklogin(String username,String pass){
        for(Account u : list){
            if(u.getUsername().equalsIgnoreCase(username)&&u.getPassWord().equals(pass)){
                return true;
            }
        }
        return false;
    }
}
