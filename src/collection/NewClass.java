/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class NewClass {
    
    public static void main(String[] args){
        try{
        JOptionPane.showMessageDialog(null, "rst = "+(-1 / 100));
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e.getMessage());
        }  
    }
    
}
