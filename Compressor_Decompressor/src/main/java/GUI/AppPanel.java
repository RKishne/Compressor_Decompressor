/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Comp_Dcomp.compressor;
import Comp_Dcomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kishn
 */
public class AppPanel extends JFrame implements ActionListener{
    JFrame frame;
    JButton compressButton;
    JButton decompressButton;
    
    AppPanel(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame=new JFrame();
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(1000,500);
        frame.setBackground(Color.blue);
        frame.getContentPane().setBackground(Color.BLACK);
        
        
        compressButton=new JButton("Select File to Compress");//button1
        compressButton.setBounds(20,100 , 200, 30);
        compressButton.addActionListener(this);
        
        decompressButton=new JButton("Select File to Decompress");//button2
        decompressButton.setBounds(250,100, 200, 30);
        decompressButton.addActionListener(this);
        
        frame.add(compressButton);//add button on frame
        frame.add(decompressButton);//add button on frame
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
    
}
