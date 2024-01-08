/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package akun;

/**
 *
 * @author ACER-PC
 */
public class Akun {
    //    deklarasi variable untuk jenis member
    private String id;
    private String username;
    private String password;
    private String email;
    private String nomorHp;
    
//    setter dan getter untuk variable jenis member
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return id;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setNomorHp(String nomorHp){
        this.nomorHp = nomorHp;
    }
    
    public String getNomorHp(){
        return nomorHp;
    }
}
