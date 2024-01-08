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
import mitra.Mitra;
import akun.Akun;

/**
 *
 * @author ACER-PC
 */
public class MitraDao {
    //    method insert ke database
    public int insert(Mitra mitra){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();){
            PreparedStatement statement = connection.prepareStatement("insert into mitra (id, foto_profile, akun_id, nama_lengkap, tanggal_lahir, no_rekening, alamat_tinggal, foto_ktp, foto_kk) values (?, ?, ?, ?, ?, ?, ?, ?, ?)" );
            statement.setString(1, mitra.getId());
            statement.setString(2, mitra.getFotoProfile());
            statement.setString(3, mitra.getAkun().getId());
            statement.setString(4, mitra.getNamaLengkap());
            statement.setString(5, mitra.getTanggalLahir());
            statement.setString(6, mitra.getNoRekening());
            statement.setString(7, mitra.getAlamatTinggal());
            statement.setString(8, mitra.getFotoKtp());
            statement.setString(9, mitra.getFotoKk());
            
            result = statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
//    method ubah ke database
    public int update(Mitra mitra){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();){
            PreparedStatement statement = connection.prepareStatement("update member set foto_profile = ?, akun_id = ?, nama_lengkap = ?, tanggal_lahir = ?, no_rekening = ?, alamat_tinggal = ?, foto_ktp = ?, foto_kk = ? where id = ?");
            statement.setString(1, mitra.getId());
            statement.setString(9, mitra.getAkun().getId());
            statement.setString(2, mitra.getFotoProfile());
            statement.setString(3, mitra.getNamaLengkap());
            statement.setString(4, mitra.getTanggalLahir());
            statement.setString(5, mitra.getNoRekening());
            statement.setString(6, mitra.getAlamatTinggal());
            statement.setString(7, mitra.getFotoKtp());
            statement.setString(8, mitra.getFotoKk());
            
            result = statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
//    method hapus ke database
    public int delete(Mitra mitra){
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();){
            PreparedStatement statement = connection.prepareStatement("delete from mitra where id = ?");
            statement.setString(1, mitra.getId());
            
            result = statement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
//    method mencari data yang ada di database
    public List<Mitra> findAll(){
        List<Mitra> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();){
            try(ResultSet resultSet = statement.executeQuery("select mitra.id, mitra.foto_profile,  mitra.nama_lengkap, mitra.tanggal_lahir, mitra.no_rekening, mitra.alamat_tinggal, mitra.foto_ktp, mitra.foto_kk, akun.id akun_id, akun.username " + 
                    "akun_username from mitra join akun on akun.id = mitra.akun_id");){
                while(resultSet.next()){
                    Mitra mitra = new Mitra();
                    mitra.setId(resultSet.getString("id"));
                    mitra.setFotoProfile(resultSet.getString("foto_profile"));
                    
                    Akun akun = new Akun();
                    akun.setId(resultSet.getString("akun_id"));
                    akun.setUsername(resultSet.getString("akun_username"));
                    
                    mitra.setAkun(akun);
                    
                    mitra.setNamaLengkap(resultSet.getString("nama_lengkap"));
                    mitra.setTanggalLahir(resultSet.getString("tanggal_lahir"));
                    mitra.setNoRekening(resultSet.getString("no_rekening"));
                    mitra.setAlamatTinggal(resultSet.getString("alamat_tinggal"));
                    mitra.setFotoKtp(resultSet.getString("foto_ktp"));
                    mitra.setFotoKk(resultSet.getString("foto_kk"));
                    
                    list.add(mitra);
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
