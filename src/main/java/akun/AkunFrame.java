/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package akun;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.util.List;

import dao.AkunDao;
import id.ac.unpas.tubes2023.MainFrame;

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
        this.setTitle("Stream e-Bin || Daftar Akun");
//        deklarasi kelas
        this.akunDao = akunDao;
        this.akunList = akunDao.findAll();
//        deklarasi fungsi ketika app ditutup semua proses yang berjalan akan dibuang
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //      deklarasai borderlayout
        this.setLayout(new BorderLayout());

        //deklarasi judul aplikasi
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel judulAplikasi = new JLabel("Daftar Akun");
        judulAplikasi.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(judulAplikasi);
        
//        deklarasi label dan text field nama
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Username: "));
        
        textFieldUsername = new JTextField();
        inputPanel.add(textFieldUsername);

        inputPanel.add(new JLabel("Password: "));
        
        textFieldPassword = new JTextField();
        inputPanel.add(textFieldPassword);

        inputPanel.add(new JLabel("Email: "));
        
        textFieldEmail = new JTextField();
        inputPanel.add(textFieldEmail);

        inputPanel.add(new JLabel("Nomor Hp: "));
        
        textFieldNomorHp = new JTextField();
        inputPanel.add(textFieldNomorHp);
        
//        deklarasi button simpan
        JButton button = new JButton("Simpan");

        //deklarasi button delete
        JButton buttonDelete = new JButton("Delete");
        
//        deklarasi tabel
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 360, 350, 200);
        
//        deklarasi pemanggilan model
        tableModel = new AkunTableModel(akunList);

        table.setModel(tableModel);
        
//        deklarasi pemanggilan kelas button simpan
        AkunButtonSimpanActionListener actionListener = new AkunButtonSimpanActionListener(this, akunDao);

        // deklarasai pemanggilan kelas button delete
        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AkunTableModel tableModel = (AkunTableModel) table.getModel();
                int selectedRow = table.getSelectedRow(); // Mendapatkan baris yang dipilih
                int result = JOptionPane.showConfirmDialog(AkunFrame.this, "Apakah Anda yakin ingin Menghapus data ini?", "Konfirmasi Hapus Data", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    if (selectedRow != -1) {
                        Akun akun = tableModel.getAkunAtRow(selectedRow);
                        tableModel.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(AkunFrame.this, "Berhasil Dihapus", "Success", JOptionPane.INFORMATION_MESSAGE);
                        akunDao.delete(akun);
                    } else {
                        if (table.getRowCount() == 0) {
                            JOptionPane.showMessageDialog(AkunFrame.this, "Tabel Kosong.", "Error", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(AkunFrame.this, "Pilih satu baris dari tabel untuk dihapus.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }

            }
        });
        
//        deklarasi aksi untuk button
        button.addActionListener(actionListener);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);
        buttonPanel.add(buttonDelete);

//        penambahan komponen yang telah dideklarasikan
//        this.add(button);
//        this.add(textFieldUsername);
//        this.add(labelUsername);
//        this.add(textFieldPassword);
//        this.add(labelPassword);
//        this.add(textFieldEmail);
//        this.add(labelEmail);
//        this.add(textFieldNomorHp);
//        this.add(labelNomorHp);
//        this.add(scrollableTable);
//        this.add(buttonDelete);


//        this.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(inputPanel, BorderLayout.NORTH);
        centerPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

//        penyesuaian ukuran aplikasi
        this.setSize(600, 400);
//        this.setLayout(null);
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
