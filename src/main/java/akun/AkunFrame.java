/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package akun;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import dao.AkunDao;

/**
 *
 * @author ACER-PC
 */
public class AkunFrame extends JFrame {
    //    deklarasi variable
    private List<Akun> akunList;
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private JTextField textFieldEmail;
    private JTextField textFieldNomorHp;
    private AkunTableModel tableModel;
    private AkunDao akunDao;
    
    public AkunFrame(AkunDao akunDao){
//        deklarasi kelas
        this.akunDao = akunDao;
        this.akunList = akunDao.findAll();
//        deklarasi fungsi ketika app ditutup semua proses yang berjalan akan dibuang
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
//        deklarasi label dan text field nama
        JLabel labelUsername = new JLabel("Username: ");
        labelUsername.setBounds(15, 40, 350, 10);
        
        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(15, 60, 350, 30);
        
        JLabel labelPassword = new JLabel("Password: ");
        labelPassword.setBounds(15, 100, 350, 10);
        
        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(15, 120, 350, 30);
        
        JLabel labelEmail = new JLabel("Email: ");
        labelEmail.setBounds(15, 160, 350, 10);
        
        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(15, 180, 350, 30);
        
        JLabel labelNomorHp = new JLabel("Nomor Hp: ");
        labelNomorHp.setBounds(15, 220, 350, 10);
        
        textFieldNomorHp = new JTextField();
        textFieldNomorHp.setBounds(15, 240, 350, 30);
        
//        deklarasi button simpan
        JButton button = new JButton("Simpan");
        button.setBounds(15, 280, 100, 40);
        
//        deklarasi tabel
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 320, 350, 200);
        
//        deklarasi pemanggilan model
        tableModel = new AkunTableModel(akunList);
        table.setModel(tableModel);
        
//        deklarasi pemanggilan kelas button simpan
        AkunButtonSimpanActionListener actionListener = new AkunButtonSimpanActionListener(this, akunDao);
        
//        deklarasi aksi untuk button
        button.addActionListener(actionListener);
        
//        penambahan komponen yang telah dideklarasikan
        this.add(button);
        this.add(textFieldUsername);
        this.add(labelUsername);
        this.add(textFieldPassword);
        this.add(labelPassword);
        this.add(textFieldEmail);
        this.add(labelEmail);
        this.add(textFieldNomorHp);
        this.add(labelNomorHp);
        this.add(scrollableTable);
        
//        penyesuaian ukuran aplikasi
        this.setSize(400, 700);
        this.setLayout(null);
    }
    
//    get value nama
    public String getUsername(){
        return textFieldUsername.getText();
    }
    
    public String getPassword(){
        return textFieldPassword.getText();
    }
    
    public String getEmail(){
        return textFieldEmail.getText();
    }
    
    public String getNomorHp(){
        return textFieldNomorHp.getText();
    }
    
//    method tambah jenis member
    public void addAkun(Akun akun){
        tableModel.add(akun);
        textFieldUsername.setText("");
        textFieldPassword.setText("");
        textFieldEmail.setText("");
        textFieldNomorHp.setText("");
    }
}
