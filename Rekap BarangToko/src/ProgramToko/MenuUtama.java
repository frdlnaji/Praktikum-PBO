/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProgramToko;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author ASUS
 */
public class MenuUtama {
    
    public static void main(String[] args){
        GUI g = new GUI();
    }
    
}
class GUI extends JFrame{
   final JTextField fnama = new JTextField(10);
   final JPasswordField fpass = new JPasswordField(10);

   JLabel lnama = new JLabel(" Username ");
   JLabel lpass = new JLabel(" Password ");
   JButton btnSave = new JButton("Login");

public GUI() {

setTitle("Login");
	setDefaultCloseOperation(3);
	setSize(350,250);
        setLocation(500,275);
setLayout(null);
	add(lnama);
	add(fnama);
        add(lpass);
	add(fpass);
        add(btnSave);
   
lnama.setBounds(10,30,120,20);
fnama.setBounds(140,30,150,20);
lpass.setBounds(10,80,120,20);
fpass.setBounds(140,80,150,20);
btnSave.setBounds(125,140,100,20);

        
        btnSave.addActionListener(new ActionListener(){
       
             @Override
             public void actionPerformed(ActionEvent e){
                 if(fnama.getText().length()>0){
                     JOptionPane.showMessageDialog(null, "Login Berhasil!");
                     MVC_ProgramToko mvcp = new MVC_ProgramToko();
                 }
            dispose();
             }
   });
        
               
        setVisible(true);
}
}

