/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ACER-PC
 */
public class MySqlConnection {
    //    deklarasi host, username dan password database menjadi variable
    private final static String DB_URL = "jdbc:mysql://localhost:3306/tubes2023";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "";
    
//    deklarasi instance
    private static MySqlConnection instance;
    
//    getter instance
    public static MySqlConnection getInstance(){
        if(instance == null){
            instance = new MySqlConnection();
        }
        return instance;
    }
    
//    getter connection database
    public Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
