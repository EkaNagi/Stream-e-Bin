/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mitra;

import akun.Akun;
import java.awt.event.*;
import java.util.UUID;
import dao.MitraDao;

/**
 *
 * @author ACER-PC
 */
public class MitraButtonSimpanActionListener implements ActionListener {
    //    deklarasi variable
    private MitraFrame mitraFrame;
    private MitraDao mitraDao;
    
//    deklarasi kelas
    public MitraButtonSimpanActionListener(MitraFrame mitraFrame, MitraDao mitraDao){
        this.mitraFrame = mitraFrame;
        this.mitraDao = mitraDao;
    }
    
//    method aksi yang akan dilakukan oleh method simpan
    public void actionPerformed(ActionEvent e){
        String fotoProfile = this.mitraFrame.getFotoProfile();
        String namaLengkap = this.mitraFrame.getNamaLengkap();
        String tanggalLahir = this.mitraFrame.getTanggalLahir();
        String noRekening = this.mitraFrame.getNoRekening();
        String alamatTinggal = this.mitraFrame.getAlamatTinggal();
        String fotoKtp = this.mitraFrame.getFotoKtp();
        String fotoKk = this.mitraFrame.getFotoKk();
        if(fotoProfile.isEmpty()){
            this.mitraFrame.showAlert("Nama Tidak Boleh Kosong");
        } else {
            Akun akun = this.mitraFrame.getAkun();
            Mitra mitra = new Mitra();
            mitra.setId(UUID.randomUUID().toString());
            mitra.setFotoProfile(fotoProfile);
            mitra.setAkun(akun);
            mitra.setNamaLengkap(namaLengkap);
            mitra.setTanggalLahir(tanggalLahir);
            mitra.setNoRekening(noRekening);
            mitra.setAlamatTinggal(alamatTinggal);
            mitra.setFotoKtp(fotoKtp);
            mitra.setFotoKk(fotoKk);
            
            this.mitraFrame.addMitra(mitra);
            this.mitraDao.insert(mitra);
        }
    }
}
