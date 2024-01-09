/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package akun;

import java.awt.event.*;
import java.util.UUID;
import dao.AkunDao;
import id.ac.unpas.tubes2023.MainFrame;

import javax.swing.*;

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

        if("".equals(username)){
            JOptionPane.showMessageDialog(this.akunFrame, "Nama belum diisi!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if("".equals(password)){
            JOptionPane.showMessageDialog(this.akunFrame, "Password belum diisi!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if("".equals(email)){
            JOptionPane.showMessageDialog(this.akunFrame, "Email belum diisi!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if("".equals(nomorHp)){
            JOptionPane.showMessageDialog(this.akunFrame, "Nomor HP belum diisi!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int result = JOptionPane.showConfirmDialog(this.akunFrame, "Apakah Anda yakin dengan data yang telah diisi?", "Konfirmasi Simpan Data", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    this.akunFrame.addAkun(akun);
                    this.akunDao.insert(akun);
                }
        }




    }
}
