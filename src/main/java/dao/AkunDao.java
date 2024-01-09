/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList; 
import akun.Akun;

/**
 *
 * @author ACER-PC
 */
public class AkunDao {
    //    method insert ke database
    public int insert(Akun akun){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();){
            PreparedStatement statement = connection.prepareStatement("Insert into akun (id, username, password, email, nomor_hp) values (?, ?, ?, ?, ?)");
            statement.setString(1, akun.getId());
            statement.setString(2, akun.getUsername());
            statement.setString(3, akun.getPassword());
            statement.setString(4, akun.getEmail());
            statement.setString(5, akun.getNomorHp());
            
            result = statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
//    method ubah ke database
    public int update(Akun akun){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();){
            PreparedStatement statement = connection.prepareStatement("Update jenis_member set nama = ?, password = ?, email = ?, nomor_hp = ? where id = ?");
            statement.setString(1, akun.getUsername());
            statement.setString(2, akun.getPassword());
            statement.setString(3, akun.getEmail());
            statement.setString(4, akun.getNomorHp());
            statement.setString(5, akun.getId());
            
            result = statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
//    method hapus ke database
    public int delete(Akun akun){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();){
            PreparedStatement statement = connection.prepareStatement("delete from akun where id = ?");
            statement.setString(1, akun.getId());
            
            result = statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
//    method mencari data yang ada di database
    public List<Akun> findAll(){
        List<Akun> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();){
            try(ResultSet resultSet = statement.executeQuery("select * from akun");){
                while(resultSet.next()){
                    Akun akun = new Akun();
                    akun.setId(resultSet.getString("id"));
                    akun.setUsername(resultSet.getString("username"));
                    akun.setPassword(resultSet.getString("password"));
                    akun.setEmail(resultSet.getString("email"));
                    akun.setNomorHp(resultSet.getString("nomor_hp"));
                    list.add(akun);
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
