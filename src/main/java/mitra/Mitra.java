/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mitra;

import akun.Akun;

/**
 *
 * @author ACER-PC
 */
public class Mitra {
    //    deklarasi variable untuk jenis member
    private String id;
    private String fotoProfile;
    private Akun akun;
    private String namaLengkap;
    private String tanggalLahir;
    private String noRekening;
    private String alamatTinggal;
    private String fotoKtp;
    private String fotoKk;
    
//    setter dan getter untuk variable jenis member
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return id;
    }
    
    public void setFotoProfile(String fotoProfile){
        this.fotoProfile = fotoProfile;
    }
    
    public String getFotoProfile(){
        return fotoProfile;
    }
    
    public void setAkun(Akun akun){
        this.akun = akun;
    }
    
    public Akun getAkun(){
        return akun;
    }
    
    public void setNamaLengkap(String namaLengkap){
        this.namaLengkap = namaLengkap;
    }
    
    public String getNamaLengkap(){
        return namaLengkap;
    }
    
    public void setTanggalLahir(String tanggalLahir){
        this.tanggalLahir = tanggalLahir;
    }
    
    public String getTanggalLahir(){
        return tanggalLahir;
    }
    
    public void setNoRekening(String noRekening){
        this.noRekening = noRekening;
    }
    
    public String getNoRekening(){
        return noRekening;
    }
    
    public void setAlamatTinggal(String alamatTinggal){
        this.alamatTinggal = alamatTinggal;
    }
    
    public String getAlamatTinggal(){
        return alamatTinggal;
    }
    
    public void setFotoKtp(String fotoKtp){
        this.fotoKtp = fotoKtp;
    }
    
    public String getFotoKtp(){
        return fotoKtp;
    }
    
    public void setFotoKk(String fotoKk){
        this.fotoKk = fotoKk;
    }
    
    public String getFotoKk(){
        return fotoKk;
    }
}
