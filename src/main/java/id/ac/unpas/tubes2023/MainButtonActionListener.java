/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.tubes2023;

import java.awt.event.*;

/**
 *
 * @author ACER-PC
 */
public class MainButtonActionListener implements ActionListener {
    private MainFrame mainFrame;
    
//    deklarasi kelas main frame
    public MainButtonActionListener(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }
    
//    method aksi untuk pemilihan menu
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == mainFrame.getButtonAkun()){
            mainFrame.showAkunFrame();
        } else {
            mainFrame.showMitraFrame();
        }
    }
}
