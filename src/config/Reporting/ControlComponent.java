/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.Reporting;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author HAMZA
 */
public class ControlComponent extends JFrame{
    Integer id ;
    String nom ;
    String prenom ;
    String statu ;
    
    public ControlComponent(){
        
        this.setTitle("Control");
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null) ;
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE) ;
        
       // this.setBackground(Color.BLUE) ;
        
        JTextField textNom = new JTextField() ;
        this.add(textNom) ;
        
    }
    
    public ControlComponent(Integer id, String nom, String prenom, String statu){
        this.setTitle("Control");
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null) ;
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE) ;
        
        this.setBackground(Color.BLUE) ;
        
        JTextField textNom = new JTextField() ;
        this.add(textNom) ;
        
        this.id = id ;
        this.nom = nom ;
        this.prenom = prenom ;
        this.statu = statu ;
    }
    
    
    
    
    public static void main(String[] args){
        ControlComponent cc = new ControlComponent() ;
        cc.setVisible(true);
    }
    
}
