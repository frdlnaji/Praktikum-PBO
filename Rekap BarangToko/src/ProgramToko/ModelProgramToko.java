/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProgramToko;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class ModelProgramToko {
    static final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
    static final String DB_URL ="jdbc:mysql://localhost/toko";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    public ModelProgramToko(){
    try{
    Class.forName(JDBC_DRIVER);
    koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
    System.out.println("Koneksi berhasil");
        }
    catch(Exception ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
    System.out.println("Koneksi gagal");
    }
            
    }
    public void createBarang(String nama, String jenis, String stok, String pabrik, String keterangan, String harga){
        try{
            String query ="INSERT INTO `daftar barang`(`Nama`, `Jenis`, `Stok`,`Pabrik`,`Keterangan`,`Harga`)VALUES('"+nama+"','"+jenis+"','"+stok+"','"+pabrik+"','"+keterangan+"','"+harga+"')";
            statement =(Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil Ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        }
        catch (Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    public String[][] bacaBarang(){
    try{
        int jmlData = 0;
        String data[][]= new String[getBanyakData()][7];
        String query="Select * from `daftar barang`";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            data[jmlData][0] =resultSet.getString("ID");
            data[jmlData][1] =resultSet.getString("Nama");
            data[jmlData][2] =resultSet.getString("Jenis");
            data[jmlData][3] =resultSet.getString("Stok");
            data[jmlData][4] =resultSet.getString("Pabrik");
            data[jmlData][5] =resultSet.getString("Keterangan");
            data[jmlData][6] =resultSet.getString("Harga");
            jmlData++;
        }
        return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}

public int getBanyakData(){
    int jmlData=0;
    try{
        statement = koneksi.createStatement();
        String query ="Select * from `daftar barang`";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        }
        return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return 0;
    }
}



public int getBanyakDataSearch(String getSearch){
    int jmlData=0;
    try{
        statement = koneksi.createStatement();
        String query ="Select * from `daftar barang`where `Nama` like '%"+getSearch+"%'";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            jmlData++;
        }
        return jmlData;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return 0;
    }
}


public String[][] cariBarang(String getSearch){
    try{
        
        int jmlData = 0;
        String data[][]= new String[getBanyakDataSearch(getSearch)][7];
        String query="Select * from `daftar barang` where `Nama` like '%"+getSearch+"%'";
        ResultSet resultSet =statement.executeQuery(query);
        while(resultSet.next()){
            data[jmlData][0] =resultSet.getString("ID");
            data[jmlData][1] =resultSet.getString("Nama");
            data[jmlData][2] =resultSet.getString("Jenis");
            data[jmlData][3] =resultSet.getString("Stok");
            data[jmlData][4] =resultSet.getString("Pabrik");
            data[jmlData][5] =resultSet.getString("Keterangan");
            data[jmlData][6] =resultSet.getString("Harga");
            jmlData++;
        }
        
        return data;
    }
    catch(SQLException e){
        System.out.println(e.getMessage());
        System.out.println("SQL ERROR");
        return null;
    }
}


public void UpdateBarang(String ID,String Nama,String Jenis, String Stok, String Pabrik,String Keterangan, String Harga) {                                         
       
    try {
      
 String query ="UPDATE `daftar barang` SET `Nama` = '"+Nama+"', `Jenis` = '"+Jenis+"',`Stok` = '"+Stok+"',`Pabrik`= '"+Pabrik+"',`Keterangan` = '"+Keterangan+"',`Harga`= '"+Harga+"' "
         + "WHERE `ID` = '"+ ID+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Data berhasil Dirubah");
                       
        } catch(SQLException sql){
            System.out.println(sql.getMessage());
    }
    } 

public void hapusBarang(String ID){
    try{
        String query ="DELETE FROM `daftar barang` WHERE `ID` = '"+ID+"'";
        statement = koneksi.createStatement();
        statement.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
    }
    catch(SQLException sql){
            System.out.println(sql.getMessage());
    }
    
}

}
