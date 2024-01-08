/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package akun;

import java.awt.event.*;
import java.util.UUID;
import dao.AkunDao;

/**
 *
 * @author ACER-PC
 */
public class AkunButtonSimpanActionListener implements ActionListener{
    //    deklarasi variable
    private AkunFrame akunFrame;
    private AkunDao akunDao;
    
//    deklarasi kelas frame dan dao
    public AkunButtonSimpanActionListener(AkunFrame akunFrame, AkunDao akunDao){
        this.akunFrame = akunFrame;
        this.akunDao = akunDao;
    }
    
//    method aksi yang akan dilakukan oleh method simpan
    public void actionPerformed(ActionEvent e){
        String username = this.akunFrame.getUsername();
        String password = this.akunFrame.getPassword();
        String email = this.akunFrame.getEmail();
        String nomorHp = this.akunFrame.getNomorHp();
        Akun akun = new Akun();
        akun.setId(UUID.randomUUID().toString());
        akun.setUsername(username);
        akun.setPassword(password);
        akun.setEmail(email);
        akun.setNomorHp(nomorHp);
        
        this.akunFrame.addAkun(akun);
        this.akunDao.insert(akun);
    }
}
