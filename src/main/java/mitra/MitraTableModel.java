/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mitra;

import akun.Akun;

import javax.swing.table.*;
import java.util.List;

/**
 *
 * @author ACER-PC
 */
public class MitraTableModel extends AbstractTableModel {
    //    deklarasi array dan variable
    private String[] columnNames = {"Foto Profile", "Akun", "Nama Lengkap", "Tanggal Lahir", "Nomor Rekening", "Alamat Tinggal", "Foto KTP", "Foto KK"};
    private List<Mitra> data;
    
//    deklarasi data model
    public MitraTableModel(List<Mitra> data){
        this.data = data;
    }
    
//    getter hitung jumlah kolom
    public int getColumnCount(){
        return columnNames.length;
    }
    
//    getter hitung jumlah baris
    public int getRowCount(){
        return data.size();
    }
    
//    getter nama kolom
    public String getColumnName(int col){
        return columnNames[col];
    }
    
//    getter nilai
    public Object getValueAt(int row, int col){
        Mitra rowItem = data.get(row);
        String value = "";
        
        switch(col){
            case 0:
                value = rowItem.getFotoProfile();
                break;
            case 1:
                value = rowItem.getAkun().getUsername();
                break;
            case 2:
                value = rowItem.getNamaLengkap();
                break;
            case 3:
                value = rowItem.getTanggalLahir();
                break;
            case 4:
                value = rowItem.getNoRekening();
                break;
            case 5:
                value = rowItem.getAlamatTinggal();
                break;
            case 6:
                value = rowItem.getFotoKtp();
                break;
            case 7:
                value = rowItem.getFotoKk();
                break;
        }
        return value;
    }
    
//    method pengubahan sel tabel
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
//    method tambah jenis member
    public void add(Mitra value){
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void removeRow(int row)
    {
        data.remove(row);
        fireTableRowsDeleted(data.size() - 1, data.size()-1);
    }

    public Mitra getAkunAtRow(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < data.size()) {
            return data.get(rowIndex);
        } else {
            return null; // Mengembalikan null jika indeks baris tidak valid
        }
    }
}
