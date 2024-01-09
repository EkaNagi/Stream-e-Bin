/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package akun;

import javax.swing.table.*;
import java.util.List;


/**
 *
 * @author ACER-PC
 */
public class AkunTableModel extends AbstractTableModel {
    //    deklarasi array dan variable
    private String[] columnNames = {"Username", "Password", "Email", "NomorHp"};
    private List<Akun> data;
    
//    deklarasi data model
    public AkunTableModel(List<Akun> data){
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
        Akun rowItem = data.get(row);
        String value = "";
        
        switch(col){
            case 0:
                value = rowItem.getUsername();
                break;
            case 1:
                value = rowItem.getPassword();
                break;
            case 2:
                value = rowItem.getEmail();
                break;
            case 3:
                value = rowItem.getNomorHp();
                break;
        }
        return value;
    }
    
//    method pengubahan sel tabel
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
//    method tambah jenis member
    public void add(Akun value){
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void removeRow(int row)
    {
        data.remove(row);
        fireTableRowsDeleted(data.size() - 1, data.size()-1);
    }

    public Akun getAkunAtRow(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < data.size()) {
            return data.get(rowIndex);
        } else {
            return null; // Mengembalikan null jika indeks baris tidak valid
        }
    }

}
