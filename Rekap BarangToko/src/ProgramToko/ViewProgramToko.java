/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProgramToko;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ViewProgramToko extends JFrame {
    JLabel lProgramToko= new JLabel("Program Toko");
   JTextField tfNo = new JTextField(); 
   JTextField tfID = new JTextField();
   JLabel lNama= new JLabel("Nama :");
   JTextField tfNama = new JTextField();
   JLabel lJenis = new JLabel("Jenis :");
   JTextField tfJenis = new JTextField();
   JLabel lKeterangan = new JLabel("Keterangan :");
   String[] namaketerangan =
            {" Masih"," Habis"};
   JComboBox cmbKeterangan = new JComboBox(namaketerangan);

   JLabel lStok = new JLabel("Stok :");
   JTextField tfStok = new JTextField();
   JLabel lPabrik = new JLabel("Pabrik :");
   JTextField tfPabrik = new JTextField();
   JLabel lHarga = new JLabel("Harga :");
   JTextField tfHarga = new JTextField();
   
   JButton btnCari = new JButton("Cari");
   JTextField tfCari = new JTextField();
   JButton btnSegarkanPanel = new JButton("Segarkan");
   JButton btnTambahPanel = new JButton("Tambah");
   JButton btnEditPanel = new JButton("Edit");
   JButton btnHapusPanel = new JButton("Hapus");
   JButton btnExitPanel = new JButton("Exit");
   
   JTable tabel;
   DefaultTableModel tableModel;
   JScrollPane scrollPane;
   Object namaKolom[] = {"ID","Nama","Jenis","Stok","Pabrik","Keterangan","Harga"};
    
   public ViewProgramToko(){
        tableModel = new DefaultTableModel (namaKolom,0);
       tabel = new JTable(tableModel);
       scrollPane = new JScrollPane(tabel);
       
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       //setVisible(true);
       setLayout(null);
       setSize(850,630);
       setLocation(225,75);
       
       add(lProgramToko);
       lProgramToko.setBounds(345,15,90,20);
      
       add(tfID);
       add(lNama);
       lNama.setBounds(5,350,90,20);
       add(tfNama);
       tfNama.setBounds(5,370,245,20);
       add(lJenis);
       lJenis.setBounds(5,390,90,20);
       add(tfJenis);
       tfJenis.setBounds(5,410,120,20);
       add(lKeterangan);
       lKeterangan.setBounds(130,390,90,20);
       add(cmbKeterangan);
       cmbKeterangan.setBounds(130,410,120,20);
       add(lStok);
       lStok.setBounds(5,430,90,20);
       add(tfStok);
       tfStok.setBounds(5,450,120,20);
       add(lPabrik);
       lPabrik.setBounds(130,430,90,20);
       add(tfPabrik);
       tfPabrik.setBounds(130,450,120,20);
       add(lHarga);
       lHarga.setBounds(5,480,90,20);
       add(tfHarga);
       tfHarga.setBounds(5,500,245,20);
       add(btnCari);
       btnCari.setBounds(400,370,90,20);
       add(tfCari);
       tfCari.setBounds(300,370,90,20);
       
       add(btnSegarkanPanel);
       btnSegarkanPanel.setBounds(300,500,90,20);
       add(btnTambahPanel);
       btnTambahPanel.setBounds(400,500,90,20);
       add(btnEditPanel);
       btnEditPanel.setBounds(500,500,90,20);
       add(btnHapusPanel);
       btnHapusPanel.setBounds(600,500,90,20);
       add(btnExitPanel);
       btnExitPanel.setBounds(700,500,90,20);

       //Tabel
       add(scrollPane);
       scrollPane.setBounds(5,85,600,200);
       scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
   
       
        btnExitPanel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
    dispose();

        }
   });         

       setVisible(true);
   }
    public String getID(){
       return tfID.getText();
   }
   public String getNama(){
       return tfNama.getText();
   }
   public String getJenis(){
       return tfJenis.getText();
   }
   public String getStok(){
       return tfStok.getText();
   }
   public String getPabrik(){
       return tfPabrik.getText();
   }
   public String getKeterangan(){
       return (String) cmbKeterangan.getSelectedItem();
   }
   public String getHarga(){
       return tfHarga.getText();
   }
  
   public String getCari(){
       return tfCari.getText();
   }
  
 }
   



