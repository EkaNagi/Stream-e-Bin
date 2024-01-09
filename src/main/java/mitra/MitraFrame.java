/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mitra;

import akun.Akun;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.util.List;

import akun.AkunFrame;
import akun.AkunTableModel;
import dao.MitraDao;
import dao.AkunDao;
import id.ac.unpas.tubes2023.MainFrame;

/**
 *
 * @author ACER-PC
 */
public class MitraFrame extends JFrame {
    //    deklarasi variable
    private List<Akun> akunList;
    private List<Mitra> mitraList;
    private JTextField textFieldFotoProfile;
    private JTextField textFieldNamaLengkap;
    private JTextField textFieldTanggalLahir;
    private JTextField textFieldNoRekening;
    private JTextField textFieldAlamatTinggal;
    private JTextField textFieldFotoKtp;
    private JTextField textFieldFotoKk;
    private MitraTableModel tableModel;
    private JComboBox comboJenis;
    private MitraDao mitraDao;
    private AkunDao akunDao;
    
    public MitraFrame(MitraDao mitraDao, AkunDao akunDao){
        this.setTitle("Stream e-Bin || Identitas Mitra");
//        deklarasi fungsi ketika app ditutup semua proses yang berjalan akan dibuang
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //      deklarasai borderlayout
        this.setLayout(new BorderLayout());

        //deklarasi judul aplikasi
        JLabel judulAplikasi = new JLabel("Identitas Mitra");
        judulAplikasi.setFont(new Font("Arial", Font.BOLD, 18));
        judulAplikasi.setBounds(130, 10, 350, 30);

//        deklarasi kelas
        this.mitraDao = mitraDao;
        this.akunDao = akunDao;
        
        this.mitraList = mitraDao.findAll();
        this.akunList = akunDao.findAll();
        
//        deklarasi label, text field, combo box
        JLabel labelFotoProfile = new JLabel("Foto Profile: ");
        labelFotoProfile.setBounds(15, 40, 350, 10);

        textFieldFotoProfile = new JTextField();
        textFieldFotoProfile.setBounds(15, 60, 350, 30);

        JLabel labelAkun = new JLabel("Akun: ");
        labelAkun.setBounds(15, 100, 350, 10);

        comboJenis = new JComboBox();
        comboJenis.setBounds(15, 120, 100, 40);

        JLabel labelNamaLengkap = new JLabel("Nama Lengkap: ");
        labelNamaLengkap.setBounds(15, 160, 350, 10);
        
        textFieldNamaLengkap = new JTextField();
        textFieldNamaLengkap.setBounds(15, 180, 350, 30);

        JLabel labelTanggalLahir = new JLabel("Foto Profile: ");
        labelTanggalLahir.setBounds(15, 220, 350, 10);
        
        textFieldTanggalLahir = new JTextField();
        textFieldTanggalLahir.setBounds(15, 240, 350, 30);

        JLabel labelNoRekening = new JLabel("Nomor Rekening: ");
        labelNoRekening.setBounds(15, 280, 350, 10);
        
        textFieldNoRekening = new JTextField();
        textFieldNoRekening.setBounds(15, 300, 350, 30);

        JLabel labelAlamatTinggal = new JLabel("AlamatTinggal: ");
        labelAlamatTinggal.setBounds(15, 340, 350, 10);
        
        textFieldAlamatTinggal = new JTextField();
        textFieldAlamatTinggal.setBounds(15, 360, 350, 30);

        JLabel labelFotoKtp = new JLabel("Foto KTP: ");
        labelFotoKtp.setBounds(15, 400, 350, 10);
        
        textFieldFotoKtp = new JTextField();
        textFieldFotoKtp.setBounds(15, 420, 350, 30);

        JLabel labelFotoKk = new JLabel("Foto KK: ");
        labelFotoKk.setBounds(15, 480, 350, 10);
        
        textFieldFotoKk = new JTextField();
        textFieldFotoKk.setBounds(15, 520, 350, 30);
        
//        deklarasi button simpan
        JButton button = new JButton("Simpan");
        button.setBounds(15, 560, 100, 40);

        //deklarasi button delete
        JButton buttonDelete = new JButton("Delete");
        buttonDelete.setBounds(130, 560, 100, 40);
        
//        deklarasi tabel
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 620, 350, 200);
        
//        deklarasi pemanggilan model
        tableModel = new MitraTableModel(mitraList);
        table.setModel(tableModel);
        
//        deklarasi pemanggilan kelas button simpan
        MitraButtonSimpanActionListener actionListener = new MitraButtonSimpanActionListener(this, mitraDao);

        //deklarasi button delete
        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MitraTableModel tableModel = (MitraTableModel) table.getModel();
                int selectedRow = table.getSelectedRow(); // Mendapatkan baris yang dipilih
                int result = JOptionPane.showConfirmDialog(MitraFrame.this, "Apakah Anda yakin ingin Menghapus data ini?", "Konfirmasi Hapus Data", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    if (selectedRow != -1) {
                        Mitra mitra = tableModel.getAkunAtRow(selectedRow);
                        tableModel.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(MitraFrame.this, "Berhasil Dihapus", "Success", JOptionPane.INFORMATION_MESSAGE);
                        mitraDao.delete(mitra);
                    } else {
                        if (table.getRowCount() == 0) {
                            JOptionPane.showMessageDialog(MitraFrame.this, "Tabel Kosong.", "Error", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(MitraFrame.this, "Pilih satu baris dari tabel untuk dihapus.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

            }
        });
        
//        deklarasi aksi untuk button
        button.addActionListener(actionListener);
        
//        penambahan komponen yang telah dideklarasikan
        this.add(judulAplikasi);
        this.add(button);
        this.add(buttonDelete);
        this.add(textFieldFotoProfile);
        this.add(labelFotoProfile);
        this.add(labelAkun);
        this.add(comboJenis);
        this.add(textFieldNamaLengkap);
        this.add(labelNamaLengkap);
        this.add(textFieldTanggalLahir);
        this.add(labelTanggalLahir);
        this.add(textFieldNoRekening);
        this.add(labelNoRekening);
        this.add(textFieldAlamatTinggal);
        this.add(labelAlamatTinggal);
        this.add(textFieldFotoKtp);
        this.add(labelFotoKtp);
        this.add(textFieldFotoKk);
        this.add(labelFotoKk);
        this.add(scrollableTable);
        
//        penyesuaian ukuran aplikasi
        this.setSize(400, 800);
        this.setLayout(null);
    }
    
//    method pengisian nilai combo box
    public void populateComboJenis(){
        this.akunList = this.akunDao.findAll();
        comboJenis.removeAllItems();
        for(Akun akun : this.akunList){
            comboJenis.addItem(akun.getUsername());
        }
    }
    
//    get value nama
    public String getFotoProfile(){
        return textFieldFotoProfile.getText();
    }
    
//    get value jenis member
    public Akun getAkun(){
        return akunList.get(comboJenis.getSelectedIndex());
    }
    
    public String getNamaLengkap(){
        return textFieldNamaLengkap.getText();
    }
    
    public String getTanggalLahir(){
        return textFieldTanggalLahir.getText();
    }
    
    public String getNoRekening(){
        return textFieldNoRekening.getText();
    }
    
    public String getAlamatTinggal(){
        return textFieldAlamatTinggal.getText();
    }
    
    public String getFotoKtp(){
        return textFieldFotoKtp.getText();
    }
    
    public String getFotoKk(){
        return textFieldFotoKk.getText();
    }
    
//    method tambah member
    public void addMitra(Mitra mitra){
        tableModel.add(mitra);
        textFieldFotoProfile.setText("");
        textFieldNamaLengkap.setText("");
        textFieldTanggalLahir.setText("");
        textFieldNoRekening.setText("");
        textFieldAlamatTinggal.setText("");
        textFieldFotoKtp.setText("");
        textFieldFotoKk.setText("");
    }
    
//    method alert
    public void showAlert(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
