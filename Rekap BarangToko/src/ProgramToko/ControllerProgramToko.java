/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProgramToko;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;



/**
 *
 * @author ASUS
 */
public class ControllerProgramToko {
    ModelProgramToko modelProgramToko;
    ViewProgramToko viewProgramToko;
    
    public ControllerProgramToko(ModelProgramToko modelProgramToko, ViewProgramToko viewProgramToko){
        this.modelProgramToko= modelProgramToko;
        this.viewProgramToko= viewProgramToko;
        if(modelProgramToko.getBanyakData() !=0){
            String dataToko[][]= modelProgramToko.bacaBarang();
            viewProgramToko.tabel.setModel((new JTable(dataToko, viewProgramToko.namaKolom)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
         viewProgramToko.btnTambahPanel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (viewProgramToko.getNama().equals("")
                        || viewProgramToko.getJenis().equals("")
                        || viewProgramToko.getStok().equals("")
                        || viewProgramToko.getPabrik().equals("")
                        || viewProgramToko.getKeterangan().equals("")
                        || viewProgramToko.getHarga().equals("")){
                    JOptionPane.showMessageDialog(null, "Kolom tidak boleh kosong");
                       
            }else{
                    String nama = viewProgramToko.getNama();
                    String jenis = viewProgramToko.getJenis();
                    String stok = viewProgramToko.getStok();
                    String pabrik = viewProgramToko.getPabrik();
                    String keterangan = viewProgramToko.getKeterangan();
                    String harga = viewProgramToko.getHarga();
                    modelProgramToko.createBarang(/* ID,*/nama, jenis, stok, pabrik, keterangan, harga);
                    
                    String dataToko[][] = modelProgramToko.bacaBarang();
                    viewProgramToko.tabel.setModel(new JTable (dataToko, viewProgramToko.namaKolom).getModel());
                }
                
        }
        }); 
        
    viewProgramToko.btnSegarkanPanel.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String dataBarang[][] = modelProgramToko.bacaBarang();
                    viewProgramToko.tabel.setModel(new JTable (dataBarang, viewProgramToko.namaKolom).getModel());
                
            viewProgramToko.tfID.setText(null);
            viewProgramToko.tfNama.setText(null);
            viewProgramToko.tfJenis.setText(null);
            viewProgramToko.tfStok.setText(null);
            viewProgramToko.tfPabrik.setText(null);
            viewProgramToko.tfHarga.setText(null);
            viewProgramToko.cmbKeterangan.setSelectedItem(this);
            viewProgramToko.tfCari.setText(null);
        }
    });
        
    viewProgramToko.btnCari.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
        String getSearch= viewProgramToko.getCari();
                String dataToko[][] = modelProgramToko.cariBarang(getSearch);
                    viewProgramToko.tabel.setModel(new JTable (dataToko, viewProgramToko.namaKolom).getModel());
                 }
        }); 

                
    viewProgramToko.tabel.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
           int baris = viewProgramToko.tabel.getSelectedRow();
           int kolom = viewProgramToko.tabel.getSelectedColumn();
        String dataterpilih = viewProgramToko.tabel.getValueAt(baris, 0).toString();
        System.out.println(dataterpilih);
       
        String Nama =viewProgramToko.tabel.getValueAt(baris, 1).toString();
        viewProgramToko.tfNama.setText(Nama);
        String Jenis =viewProgramToko.tabel.getValueAt(baris, 2).toString();
        viewProgramToko.tfJenis.setText(Jenis);
        String Stok =viewProgramToko.tabel.getValueAt(baris, 3).toString();
        viewProgramToko.tfStok.setText(Stok);
        String Pabrik =viewProgramToko.tabel.getValueAt(baris, 4).toString();
        viewProgramToko.tfPabrik.setText(Pabrik);
        String Keterangan =viewProgramToko.tabel.getValueAt(baris, 5).toString();
        viewProgramToko.cmbKeterangan.setSelectedItem(Keterangan);
        String Harga =viewProgramToko.tabel.getValueAt(baris, 6).toString();
        viewProgramToko.tfHarga.setText(Harga);        
        
        viewProgramToko.btnEditPanel.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){ 
                 String id = dataterpilih;
                    
                    String Nama = viewProgramToko.getNama();
                    String Jenis = viewProgramToko.getJenis();
                    String Stok = viewProgramToko.getStok();
                    String Pabrik = viewProgramToko.getPabrik();
                    String Keterangan = viewProgramToko.getKeterangan();
                    String Harga = viewProgramToko.getHarga();
                    modelProgramToko.UpdateBarang( id,Nama, Jenis, Stok, Pabrik, Keterangan,Harga);
                

                String dataToko[][]= modelProgramToko.bacaBarang();
                viewProgramToko.tabel.setModel(new JTable(dataToko, viewProgramToko.namaKolom).getModel());

     }
        });
        
       viewProgramToko.btnHapusPanel.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){    
                    modelProgramToko.hapusBarang(dataterpilih);
                    String dataToko[][]= modelProgramToko.bacaBarang();
                    viewProgramToko.tabel.setModel(new JTable(dataToko, viewProgramToko.namaKolom).getModel());
                  
             }
        });
    
     }
       });
   
   
    }
    }
