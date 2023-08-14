/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataHelper;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author nttai
 */
public class DatabaseHelper {
    public static final String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=QLTIEMNET;"
                    + "user=sa;"
                    + "password=123;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;";
    public static Connection getDBConnect(){
        Connection con = null;
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println("Chưa có Diver!"+e.toString());
        }
        try {
            con = DriverManager.getConnection(connectionUrl);
            return con;
        } catch (Exception e) {
            System.out.println("Lỗi connect"+e.toString());
        }
        return null;
    }

    public static Connection connectDb() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
