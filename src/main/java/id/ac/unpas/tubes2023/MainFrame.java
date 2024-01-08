/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package id.ac.unpas.tubes2023;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import akun.AkunFrame;
import mitra.MitraFrame;
import dao.*;
import db.MySqlConnection;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ACER-PC
 */
public class MainFrame extends javax.swing.JFrame {

    private AkunFrame akunFrame;
    private MitraFrame mitraFrame;
    private JButton buttonAkun;
    private JButton buttonMitra;
    private AkunDao akunDao;
    private MitraDao mitraDao;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        //        deklarasi fungsi ketika ditutup aplikasi akan berhenti
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        penyesuaian ukuran aplikasi
        this.setSize(400, 110);
        
//        deklarasi kelas dao
        this.akunDao = new AkunDao();
        this.mitraDao = new MitraDao();
        
//        deklarasi kelas frame
        this.akunFrame = new AkunFrame(akunDao);
        this.mitraFrame = new MitraFrame(mitraDao, akunDao);
        
//        deklarasi layout
        this.setLayout(new FlowLayout());
//        deklarasi kelas button main
        MainButtonActionListener actionListener = new MainButtonActionListener(this);
        
//        deklarasi button
        this.buttonAkun = new JButton("Daftar Akun");
        this.buttonMitra = new JButton("Profile Mitra");
        
        JButton buttonPrint = new JButton("Print");
        JButton buttonPreview = new JButton("Preview");
        JButton buttonExport = new JButton("Export");
        
//        penambahan method aksi untuk button
        this.buttonAkun.addActionListener(actionListener);
        this.buttonMitra.addActionListener(actionListener);
        
        buttonPrint.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e2){
                // TODO add your handling code here:
                try{
                //deklarasi variable dan pengisian value
                String reportPath = System.getProperty("user.dir") + File.separator + "report";
                String path = reportPath + File.separator + "MitraReport.jrxml";
                //deklarasi pemanggilan kelas
                JasperReport jasperReport = JasperCompileManager.compileReport(path);
            
                //deklarasi map
                Map<String, Object> parameters = new HashMap<>();
            
                //deklarasi pemanggilan kelas printmengambil data
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, MySqlConnection.getInstance().getConnection());
            
                //deklarasi menjalankan kelas untuk menampilkan window print
                JasperPrintManager.printReport(jasperPrint, true);
                } catch(JRException e){
                    e.printStackTrace();
                }
            }
        });
        
        buttonPreview.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e3){
                // TODO add your handling code here:
                try{
                //deklarasi variable dan pengisian value
                String reportPath = System.getProperty("user.dir") + File.separator + "report";
                String path = reportPath + File.separator + "MitraReport.jrxml";
                //deklarasi pemanggilan kelas
                JasperReport jasperReport = JasperCompileManager.compileReport(path);
            
                //deklarasi map
                Map<String, Object> parameters = new HashMap<>();
            
                //deklarasi pemanggilan kelas print mengambil data
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, MySqlConnection.getInstance().getConnection());
             
                //deklarasi menjalankan kelas viewer
                JasperViewer.viewReport(jasperPrint);
                } catch(JRException e){
                    e.printStackTrace();
                }
            }
        });
        
        buttonExport.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e4){
               // TODO add your handling code here:
                try{
                //deklarasi variable dan pengisian value
                String reportPath = System.getProperty("user.dir") + File.separator + "report";
                String path = reportPath + File.separator + "MitraReport.jrxml";
                //deklarasi pemanggilan kelas
                JasperReport jasperReport = JasperCompileManager.compileReport(path);
            
                //deklarasi map
                Map<String, Object> parameters = new HashMap<>();
            
                //deklarasi pemanggilan kelas print mengambil data
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, MySqlConnection.getInstance().getConnection());
            
                //deklarasi file
                File outDir = new File(reportPath);
                outDir.mkdirs();
            
                //deklarasi menjalankan kelas export ke pdf
                JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + File.separator + "MitraReport.pdf");
                //deklarasi pop up export berhasil
                JOptionPane.showMessageDialog(MainFrame.this, "Export selesai");
                } catch(JRException e){
                    e.printStackTrace();
                }
           }
        });
        
//        penambahan komponen ke aplikasi
        this.add(buttonAkun);
        this.add(buttonMitra);
        this.add(buttonPrint);
        this.add(buttonPreview);
        this.add(buttonExport);
    }
    
    public JButton getButtonAkun(){
        return buttonAkun;
    }
    
//    method getter button member
    public JButton getButtonMitra(){
        return buttonMitra;
    }
    
//    method tampilkan frame jenis member
    public void showAkunFrame(){
        if(akunFrame == null){
            akunFrame = new AkunFrame(akunDao);
        }
        akunFrame.setVisible(true);
    }
    
//    method tampilkan frame member
    public void showMitraFrame(){
        if(mitraFrame == null){
            mitraFrame = new MitraFrame(mitraDao, akunDao);
        }
        mitraFrame.populateComboJenis();
        mitraFrame.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
