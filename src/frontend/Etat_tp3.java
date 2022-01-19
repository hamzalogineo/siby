/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author hp
 */
public class Etat_tp3 extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/tp3_siby" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
    

  SimpleDateFormat sdf_mysql = new SimpleDateFormat("yyyy-MM-dd") ;
  SimpleDateFormat sdf_mysql_ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
  SimpleDateFormat sdf_java = new SimpleDateFormat("dd-MM-yyyy") ;
  SimpleDateFormat sdf_java_ = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
  
  
  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
  
  
   List mlist1 ;
   List mlist2 ;
   List mlist3 ;
   List mlist4 ;
   List mlist5 ;
   
   
    public Etat_tp3() {
        
        initComponents() ;
        this.setLocationRelativeTo(null) ;
        
         
        this.jTable1.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable1.getTableHeader().setOpaque(false); 
            this.jTable1.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable1.getTableHeader().setForeground(Color.white) ;
        
              this.jTable1.setRowHeight(25) ;
              
        
             DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
             
                  headerRenderer.setBackground(Color.green) ;
                  headerRenderer.setForeground(Color.BLACK) ;
                  headerRenderer.setFont(new Font("Segoe UI" , Font.BOLD , 16)) ;

                  for (int i = 0; i < this.jTable1.getModel().getColumnCount(); i++) {
                    this.jTable1.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
         this.jTable2.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable2.getTableHeader().setOpaque(false); 
            this.jTable2.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable2.getTableHeader().setForeground(Color.white) ;
        
              this.jTable2.setRowHeight(25) ;
              
        

                  for (int i = 0; i < this.jTable2.getModel().getColumnCount(); i++) {
                   
                      this.jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
                                }
        
     //   -------------------------------------------------------------------
        
           this.jTable3.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable3.getTableHeader().setOpaque(false); 
            this.jTable3.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable3.getTableHeader().setForeground(Color.white) ;
        
              this.jTable3.setRowHeight(25) ;
              
        

                  for (int i = 0; i < this.jTable3.getModel().getColumnCount(); i++) {
                   
                      this.jTable3.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
                                }
                  
                  
                   //   -------------------------------------------------------------------
                  
                  
            this.jTable4.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable4.getTableHeader().setOpaque(false); 
            this.jTable4.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable4.getTableHeader().setForeground(Color.white) ;
        
              this.jTable4.setRowHeight(25) ;
              
        

                  for (int i = 0; i < this.jTable4.getModel().getColumnCount(); i++) {
                   
                      this.jTable4.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
                                }
                  
                  
    //   -------------------------------------------------------------------
                  
                  
            this.jTable5.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable5.getTableHeader().setOpaque(false); 
            this.jTable5.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable5.getTableHeader().setForeground(Color.white) ;
        
              this.jTable5.setRowHeight(25) ;
              
        

                  for (int i = 0; i < this.jTable5.getModel().getColumnCount(); i++) {
                   
                      this.jTable5.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
                                }
                  
                  
                   //   -------------------------------------------------------------------
                  
                  
        
        //  ---------  2è choix
              
        
        //   -------------------------------------------------------------------
        
            this.jTable13.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable13.getTableHeader().setOpaque(false); 
            this.jTable13.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
              this.jTable13.getTableHeader().setForeground(Color.white) ;
        
              this.jTable13.setRowHeight(25) ;
              
        

                  for (int i = 0; i < this.jTable13.getModel().getColumnCount(); i++) {
                   
                          this.jTable13.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
                                }
                  
                  
                   //   -------------------------------------------------------------------
                  
        
        
                 //   ---------------
        
        
         
        
            this.jTable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 6) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
            setBackground(Color.RED);
            setForeground(Color.WHITE);
        } 
        
       
        
        
        if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
            
          
        return this;
        
    }   
});

      
      this.jTable3.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 6) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
            setBackground(Color.RED);
            setForeground(Color.WHITE);
        } 
        
       
        
        
        if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
            
          
        return this;
        
    }   
});
    
     
      this.jTable4.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 6) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
            setBackground(Color.RED);
            setForeground(Color.WHITE);
        } 
        
       
        
        
        if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
            
          
        return this;
        
    }   
});
      
      
      
      
      this.jTable5.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 7) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
            setBackground(Color.RED);
            setForeground(Color.WHITE);
        } 
        
       
        
        
        if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
            
          
        return this;
        
    }   
});
    
      
       this.jTable13.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){ // jTable13
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 7) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
            setBackground(Color.RED);
            setForeground(Color.WHITE);
        } 
        
       
        
        
        if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
            
          
        return this;
        
    }   
});
    
      
      
    
        
          DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
          DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
          DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
          DefaultTableModel dtm4 = (DefaultTableModel) this.jTable4.getModel() ;
          DefaultTableModel dtm5 = (DefaultTableModel) this.jTable5.getModel() ;
          DefaultTableModel dtm13 = (DefaultTableModel) this.jTable13.getModel() ;
        
          dtm.setRowCount(0) ;
          dtm2.setRowCount(0) ;
          dtm3.setRowCount(0) ;
          
          dtm4.setRowCount(0) ;
          dtm5.setRowCount(0) ; 
          dtm13.setRowCount(0) ; 
        
        
        
        
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        etat = new javax.swing.JPanel();
        vierge = new javax.swing.JPanel();
        session = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        du = new datechooser.beans.DateChooserCombo();
        h1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        au = new datechooser.beans.DateChooserCombo();
        h2 = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        tb = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        ch = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        vd = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        du1 = new datechooser.beans.DateChooserCombo();
        h11 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        au1 = new datechooser.beans.DateChooserCombo();
        h12 = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        tm1 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        rv = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        du2 = new datechooser.beans.DateChooserCombo();
        h22 = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        au2 = new datechooser.beans.DateChooserCombo();
        h21 = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        tm2 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        sav = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        du3 = new datechooser.beans.DateChooserCombo();
        h3 = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        au3 = new datechooser.beans.DateChooserCombo();
        h31 = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        tm3 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        reserv = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        du5 = new datechooser.beans.DateChooserCombo();
        h5 = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        au5 = new datechooser.beans.DateChooserCombo();
        h51 = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        tm4 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        cl = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        s_caisse = new javax.swing.JPanel();
        du6 = new datechooser.beans.DateChooserCombo();
        jLabel47 = new javax.swing.JLabel();
        h15 = new javax.swing.JFormattedTextField();
        jLabel48 = new javax.swing.JLabel();
        au6 = new datechooser.beans.DateChooserCombo();
        jLabel49 = new javax.swing.JLabel();
        h25 = new javax.swing.JFormattedTextField();
        jLabel50 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        t0 = new javax.swing.JLabel();
        ob = new javax.swing.JTextField();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SESSION");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 204));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("VENTE DIRECTE");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 204));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("REPRISE VENTE");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 204));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("SERVICE A V");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 0, 204));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("VENTE A CREDIT");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(0, 0, 204));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("SORTIE CAISSE");
        jButton16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        etat.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ETATS PAR PERIODE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        etat.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout viergeLayout = new javax.swing.GroupLayout(vierge);
        vierge.setLayout(viergeLayout);
        viergeLayout.setHorizontalGroup(
            viergeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        viergeLayout.setVerticalGroup(
            viergeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );

        etat.add(vierge, "card2");

        session.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SESSION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        du.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        du.setNavigateFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));

        h1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h1.setText("00:00");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DU");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HEURE");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("AU");

        au.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        au.setNavigateFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));

        h2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h2.setText("23:59");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("HEURE");

        jButton2.setBackground(new java.awt.Color(51, 102, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("RECHERCHER");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tb.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tb.setText("TOTAL BALANCE :");
        tb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton11.setBackground(new java.awt.Color(51, 102, 0));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("IMPRIMER");
        jButton11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        ch.setBackground(new java.awt.Color(102, 102, 0));
        ch.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        ch.setForeground(new java.awt.Color(255, 255, 255));
        ch.setText("ACTIVER");
        ch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        ch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ch, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(du, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(h1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(au, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tb, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(125, 125, 125))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(au, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ch)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGap(0, 0, 0)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(du, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(tb))
        );

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SESSION POS", "ID", "DATE OPEN", "DATE CLOSE", "FOND DEPART", "BALANCE", "USER", "ETAT", "VENTE DIRECT", "REPRISE VENTE", "SERVICE A V", "      VC         |         REG", "SORTIE CAISSE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMinWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(7).setMinWidth(0);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(11).setMinWidth(150);
            jTable1.getColumnModel().getColumn(11).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(11).setMaxWidth(150);
        }

        javax.swing.GroupLayout sessionLayout = new javax.swing.GroupLayout(session);
        session.setLayout(sessionLayout);
        sessionLayout.setHorizontalGroup(
            sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sessionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        sessionLayout.setVerticalGroup(
            sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sessionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        etat.add(session, "card3");

        vd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VENTE DIRECT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        du1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du1.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        du1.setNavigateFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));

        h11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h11.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h11.setText("00:00");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("DU");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("HEURE");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("AU");

        au1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au1.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        au1.setNavigateFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));

        h12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h12.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h12.setText("23:59");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("HEURE");

        jButton9.setBackground(new java.awt.Color(51, 102, 0));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("RECHERCHER");
        jButton9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        tm1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tm1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tm1.setText("TOTAL MONTANT :");
        tm1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton12.setBackground(new java.awt.Color(51, 102, 0));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("IMPRIMER");
        jButton12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(293, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(du1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(h11)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tm1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(au1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h12)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(du1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(h11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(au1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(h12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(tm1))
        );

        jTable2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "VENTE POS", "ID", "DATE", "MONTANT", "USER", "CB", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(1).setMinWidth(40);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable2.getColumnModel().getColumn(5).setMinWidth(0);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(5).setMaxWidth(0);
            jTable2.getColumnModel().getColumn(6).setMinWidth(0);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        javax.swing.GroupLayout vdLayout = new javax.swing.GroupLayout(vd);
        vd.setLayout(vdLayout);
        vdLayout.setHorizontalGroup(
            vdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vdLayout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );
        vdLayout.setVerticalGroup(
            vdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );

        etat.add(vd, "card4");

        rv.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REPRISE VENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        du2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du2.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        du2.setNavigateFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));

        h22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h22.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h22.setText("00:00");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DU");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("HEURE");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("AU");

        au2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au2.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        au2.setNavigateFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));

        h21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h21.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h21.setText("23:59");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("HEURE");

        jButton7.setBackground(new java.awt.Color(51, 102, 0));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("RECHERCHER");
        jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        tm2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tm2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tm2.setText("TOTAL MONTANT :");
        tm2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton13.setBackground(new java.awt.Color(51, 102, 0));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("IMPRIMER");
        jButton13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(du2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(h22)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tm2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(au2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h21)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(du2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(h22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(au2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(h21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(tm2))
        );

        jTable3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "REPRISE VENTE POS", "ID", "DATE", "MONTANT", "USER", "CB", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable3MouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(1).setMinWidth(40);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable3.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable3.getColumnModel().getColumn(5).setMinWidth(0);
            jTable3.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable3.getColumnModel().getColumn(5).setMaxWidth(0);
            jTable3.getColumnModel().getColumn(6).setMinWidth(0);
            jTable3.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable3.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        javax.swing.GroupLayout rvLayout = new javax.swing.GroupLayout(rv);
        rv.setLayout(rvLayout);
        rvLayout.setHorizontalGroup(
            rvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rvLayout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );
        rvLayout.setVerticalGroup(
            rvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        etat.add(rv, "card5");

        sav.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SERVICE APRES VENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        du3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du3.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        du3.setNavigateFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));

        h3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h3.setText("00:00");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("DU");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("HEURE");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("AU");

        au3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au3.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        au3.setNavigateFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));

        h31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h31.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h31.setText("23:59");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("HEURE");

        jButton8.setBackground(new java.awt.Color(51, 102, 0));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("RECHERCHER");
        jButton8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        tm3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tm3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tm3.setText("TOTAL MONTANT :");
        tm3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton14.setBackground(new java.awt.Color(51, 102, 0));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("IMPRIMER");
        jButton14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tm3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(du3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h3)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(au3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h31)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(du3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(h3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(au3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(h31, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(tm3))
        );

        jTable4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                " POS", "ID", "DATE", "MONTANT", "USER", "CB", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable4.getTableHeader().setReorderingAllowed(false);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable4MouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(1).setMinWidth(45);
            jTable4.getColumnModel().getColumn(1).setPreferredWidth(45);
            jTable4.getColumnModel().getColumn(1).setMaxWidth(45);
            jTable4.getColumnModel().getColumn(5).setMinWidth(0);
            jTable4.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable4.getColumnModel().getColumn(5).setMaxWidth(0);
            jTable4.getColumnModel().getColumn(6).setMinWidth(0);
            jTable4.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable4.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        javax.swing.GroupLayout savLayout = new javax.swing.GroupLayout(sav);
        sav.setLayout(savLayout);
        savLayout.setHorizontalGroup(
            savLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(savLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        savLayout.setVerticalGroup(
            savLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        etat.add(sav, "card6");

        reserv.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VENTE A CREDIT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        du5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du5.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        du5.setNavigateFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));

        h5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h5.setText("00:00");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("DU");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("HEURE");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("AU");

        au5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au5.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        au5.setNavigateFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));

        h51.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h51.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h51.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h51.setText("23:59");
        h51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h51ActionPerformed(evt);
            }
        });

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("HEURE");

        jButton10.setBackground(new java.awt.Color(51, 102, 0));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("RECHERCHER");
        jButton10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        tm4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tm4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tm4.setText("TOTAL MONTANT :");
        tm4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton15.setBackground(new java.awt.Color(51, 102, 0));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("IMPRIMER");
        jButton15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        cl.setBackground(new java.awt.Color(204, 204, 204));
        cl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cl.setForeground(new java.awt.Color(102, 102, 102));
        cl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cl.setText("CLIENT");
        cl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                clFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                clFocusLost(evt);
            }
        });
        cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clActionPerformed(evt);
            }
        });
        cl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(du5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h5)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(au5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h51)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(cl, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tm4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(du5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(h5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(au5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(h51, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tm4))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTable5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RESERVATION POS", "ID", "DATE", "CLIENT", "MONTANT", "USER", "CB", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable5.getTableHeader().setReorderingAllowed(false);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable5MouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(1).setMinWidth(40);
            jTable5.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable5.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable5.getColumnModel().getColumn(6).setMinWidth(0);
            jTable5.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable5.getColumnModel().getColumn(6).setMaxWidth(0);
            jTable5.getColumnModel().getColumn(7).setMinWidth(0);
            jTable5.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable5.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        javax.swing.GroupLayout reservLayout = new javax.swing.GroupLayout(reserv);
        reserv.setLayout(reservLayout);
        reservLayout.setHorizontalGroup(
            reservLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reservLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        reservLayout.setVerticalGroup(
            reservLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );

        etat.add(reserv, "card7");

        s_caisse.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        du6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du6.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 13));

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("DU");

        h15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h15.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h15.setText("00:00");
        h15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("HEURE");

        au6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au6.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 13));

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("AU");

        h25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h25.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h25.setText("23:59");
        h25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("HEURE");

        jButton23.setBackground(new java.awt.Color(0, 0, 204));
        jButton23.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("RECHERCHER");
        jButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jTable13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "POS", "DATE", "ID", "USER", "REF SORTIE", "MONTANT", "OBSERVATION", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable13.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable13.getTableHeader().setReorderingAllowed(false);
        jTable13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable13MouseReleased(evt);
            }
        });
        jScrollPane13.setViewportView(jTable13);
        if (jTable13.getColumnModel().getColumnCount() > 0) {
            jTable13.getColumnModel().getColumn(0).setMinWidth(50);
            jTable13.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable13.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable13.getColumnModel().getColumn(1).setMinWidth(130);
            jTable13.getColumnModel().getColumn(1).setPreferredWidth(130);
            jTable13.getColumnModel().getColumn(1).setMaxWidth(130);
            jTable13.getColumnModel().getColumn(2).setMinWidth(50);
            jTable13.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable13.getColumnModel().getColumn(2).setMaxWidth(50);
            jTable13.getColumnModel().getColumn(3).setMinWidth(100);
            jTable13.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable13.getColumnModel().getColumn(3).setMaxWidth(100);
            jTable13.getColumnModel().getColumn(4).setMinWidth(100);
            jTable13.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable13.getColumnModel().getColumn(4).setMaxWidth(100);
            jTable13.getColumnModel().getColumn(5).setMinWidth(90);
            jTable13.getColumnModel().getColumn(5).setPreferredWidth(90);
            jTable13.getColumnModel().getColumn(5).setMaxWidth(90);
            jTable13.getColumnModel().getColumn(7).setMinWidth(0);
            jTable13.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable13.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        jLabel21.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("ETAT DES SORTIES DE CAISSES");
        jLabel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        t0.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t0.setText("TOTAL = 0 FCFA");
        t0.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        ob.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ob.setText("OBSERVATION");
        ob.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        ob.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                obFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                obFocusLost(evt);
            }
        });
        ob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                obKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout s_caisseLayout = new javax.swing.GroupLayout(s_caisse);
        s_caisse.setLayout(s_caisseLayout);
        s_caisseLayout.setHorizontalGroup(
            s_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(s_caisseLayout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addGroup(s_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(s_caisseLayout.createSequentialGroup()
                        .addGroup(s_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(du6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(s_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(s_caisseLayout.createSequentialGroup()
                                .addGroup(s_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(h15)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(s_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(au6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(s_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(h25)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(ob))))
                .addGap(18, 18, 18)
                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(280, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, s_caisseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(t0, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
            .addGroup(s_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(s_caisseLayout.createSequentialGroup()
                    .addGap(186, 186, 186)
                    .addComponent(jScrollPane13)
                    .addGap(187, 187, 187)))
        );
        s_caisseLayout.setVerticalGroup(
            s_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(s_caisseLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(s_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(s_caisseLayout.createSequentialGroup()
                        .addGroup(s_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48))
                        .addGap(0, 0, 0)
                        .addGroup(s_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h15)
                            .addComponent(du6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(s_caisseLayout.createSequentialGroup()
                        .addGroup(s_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50))
                        .addGap(0, 0, 0)
                        .addGroup(s_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(au6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(h25, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ob, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 453, Short.MAX_VALUE)
                .addComponent(t0)
                .addContainerGap())
            .addGroup(s_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, s_caisseLayout.createSequentialGroup()
                    .addContainerGap(121, Short.MAX_VALUE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(34, 34, 34)))
        );

        etat.add(s_caisse, "card8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        this.session.setVisible(true) ;
        this.vierge.setVisible(false) ;
        this.vd.setVisible(false);
        this.rv.setVisible(false) ;
        this.sav.setVisible(false);
        this.reserv.setVisible(false) ;
        this.s_caisse.setVisible(false) ;
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.session.setVisible(false) ;
        this.vierge.setVisible(false) ;
        this.vd.setVisible(true);
        this.rv.setVisible(false) ;
        this.sav.setVisible(false);
        this.reserv.setVisible(false) ;
        this.s_caisse.setVisible(false) ;
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.session.setVisible(false) ;
        this.vierge.setVisible(false) ;
        this.vd.setVisible(false);
        this.rv.setVisible(true) ;
        this.sav.setVisible(false);
        this.reserv.setVisible(false) ;
        this.s_caisse.setVisible(false) ;
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.session.setVisible(false) ;
        this.vierge.setVisible(false) ;
        this.vd.setVisible(false);
        this.rv.setVisible(false) ;
        this.sav.setVisible(true);
        this.reserv.setVisible(false) ;
        this.s_caisse.setVisible(false) ;
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.session.setVisible(false) ;
        this.vierge.setVisible(false) ;
        this.vd.setVisible(false);
        this.rv.setVisible(false) ;
        this.sav.setVisible(false);
        this.reserv.setVisible(true) ;
        this.s_caisse.setVisible(false) ;
       
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           
        // D : 
        
       long tb = 0 ;
       long tv = 0  ; 
       long trp = 0 ;
       long tsav = 0 ;
       long trv = 0 ;
       long ts = 0 ;
       
       ArrayList<Long>  session = new ArrayList<Long>() ;
        
        if(this.ch.isSelected() == true){
            
              try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h1.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h2.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                             dtm.setRowCount(0) ;
                             
                             this.mlist1 = new ArrayList<>() ;
        
       String sql = null ;
       ResultSet rs = null ;
       
      
        

 // "SESSION POS", "ID", "DATE OPEN", "DATE CLOSE", "FOND DEPART", "BALANCE", "USER", "ETAT", 
// "VENTE DIRECT", "REPRISE VENTE", "SERVICE A V", "VENTE A CREDIT", "SORTIE CAISSE"
           
       /*
       
           sql = "select session.pos as pos, session.date_op as date_op, session.id_ss as id, session.user as login, "
                   + "session.f_c as fond, "
                   + "session.balance as bl, session.etat as etat, sum(op_session.total) as total "
              + "from session "
              + "where session.date_op between '"+dte1+"' and '"+dte2+"' and session.etat = 'OUI' "
              + "order by session.date_op desc" ;
           
           */
                   
       sql = "select session.id_ss as id from session where session.date_op between '"+dte1+"' and '"+dte2+"' and session.etat = 'OUI' "
              + "order by session.date_op desc" ;
        
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            long id = rs.getLong("id") ;
            session.add(id) ;
        }
        
        for(int i = 0 ; i < session.size() ; i++){
            
            long v = 0 ;
            long rp = 0 ;
            long rv = 0 ;
            long rv2 = 0 ;
            long sav = 0 ;
            long s = 0 ;
            
            sql = "select sum(op_session.total) as total from op_session "
                    + "where type = 'vente' and etat = 'OUI' and id_ss = "+session.get(i).intValue()+" group by id_ss" ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                v = rs.getInt("total") ;
            }
            
             sql = "select sum(op_session.total) as total from op_session "
                    + "where type = 'service' and etat = 'OUI' and id_ss = "+session.get(i).intValue()+" group by id_ss" ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                sav = rs.getInt("total") ;
            }
            
             sql = "select sum(op_session.total) as total from op_session "
                    + "where type = 'reprise' and etat = 'OUI' and id_ss = "+session.get(i).intValue()+" group by id_ss" ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                rp = rs.getInt("total") ;
            }
            
             sql = "select sum(op_session.total) as total from op_session "
                    + "where type = 'reservation' and etat = 'OUI' and id_ss = "+session.get(i).intValue()+" group by id_ss" ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                rv = rs.getInt("total") ;
            }
            
            sql = "select sum(payement.mtt) as total from payement "
                    + "where etat = 'OUI' and id_ss = "+session.get(i).intValue()+" group by id_ss" ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                rv2 = rs.getInt("total") ;
            }
            
             sql = "select sum(sortie_caisse.mtt) as total from sortie_caisse "
                    + "where etat = 'OUI' and id_ss = "+session.get(i).intValue()+" group by id_ss" ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                s = rs.getInt("total") ;
            }
            
            
            sql = "select session.pos as pos, session.date_op as date_op, session.date_close as date_cl, session.id_ss as id, session.user as login, "
                 +"session.f_c as fond, session.balance as bl, session.etat as etat "
                 +"from session "
                 +"where session.id_ss = "+session.get(i).intValue()+"" ;
            rs = stmt.executeQuery(sql) ;
            
            
    while(rs.next()){
          
          HashMap<String, Object> m = new HashMap<>() ;
          
          m.put("session",  rs.getString("pos")) ;
          m.put("id", rs.getString("id")) ;
          m.put("date", sdf1.format(rs.getTimestamp("date_op"))) ;
          m.put("date2",  new String("")) ;
          m.put("fond", this.nf3.format(rs.getInt("fond"))) ;
          m.put("balance",  this.nf3.format(rs.getInt("bl"))) ;
          m.put("user", rs.getString("login")) ;
          m.put("etat", rs.getString("etat")) ;
          m.put("v",  this.nf3.format(v)) ;
          m.put("rp",  this.nf3.format(rp)) ;
          m.put("sav",  this.nf3.format(sav)) ;
          m.put("vc",  this.nf3.format(rv)+" | "+this.nf3.format(rv2)) ;
          m.put("sc",  this.nf3.format(s)) ;
                      
                this.mlist1.add(m) ;
     
     
          tb += rs.getInt("bl") ;
          
          tv += v ;
          trp += rp ;
          trv += rv ;
          ts += s ;
          tsav += sav ;
        
   
      dtm.addRow(new Object[]{
     
      //  "SESSION POS", "ID", "DATE OPEN", "DATE CLOSE", "FOND DEPART", "BALANCE", "USER", "ETAT",
     //   "VENTE DIRECT", "REPRISE VENTE", "SERVICE A V", "VENTE A CREDIT", "SORTIE CAISSE"
   
  rs.getString("pos"), rs.getLong("id"), sdf1.format(rs.getTimestamp("date_op")),  new String(""), 
   this.nf3.format(rs.getInt("fond")),  this.nf3.format(rs.getInt("bl")), rs.getString("login"), rs.getString("etat") , v , rp, sav, rv+" | "+rv2, s
             
        
        }) ;
 
     }

       
      
      
            
            
        }
     
        
     this.tb.setText("TOTAL BALANCE : "+this.nf3.format(tb));

        
        
      rs.close();
      stmt.close();
      conn.close();
     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
            
       
        
        
    }catch(Exception e){
        
             DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                               dtm.setRowCount(0) ;
                               
                               this.mlist1 = new ArrayList<>() ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
            
            
        }else  if(this.ch.isSelected() == false){
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h1.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h2.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                             dtm.setRowCount(0) ;
                             
                             this.mlist1 = new ArrayList<>() ;
        
       String sql = null ;
       ResultSet rs = null ;
       
       // long tb = 0 ;
       
           //   "SESSION POS", "ID", "DATE OPEN", "DATE CLOSE", "FOND DEPART", "BALANCE", "USER", "ETAT"
           
            sql = "select session.id_ss as id from session where session.date_op between '"+dte1+"' and '"+dte2+"' and session.etat = 'NON' "
              + "order by session.date_op desc" ;
        
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            long id = rs.getLong("id") ;
            session.add(id) ;
        }
        
        for(int i = 0 ; i < session.size() ; i++){
            
            long v = 0 ;
            long rp = 0 ;
            long rv = 0 ;
            long rv2 = 0 ;
            long sav = 0 ;
            long s = 0 ;
            
            sql = "select sum(op_session.total) as total from op_session "
                    + "where type = 'vente' and etat = 'OUI' and id_ss = "+session.get(i).intValue()+" group by id_ss" ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                v = rs.getInt("total") ;
            }
            
             sql = "select sum(op_session.total) as total from op_session "
                    + "where type = 'service' and etat = 'OUI' and id_ss = "+session.get(i).intValue()+" group by id_ss" ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                sav = rs.getInt("total") ;
            }
            
             sql = "select sum(op_session.total) as total from op_session "
                    + "where type = 'reprise' and etat = 'OUI' and id_ss = "+session.get(i).intValue()+" group by id_ss" ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                rp = rs.getInt("total") ;
            }
            
            sql = "select sum(op_session.total) as total from op_session "
                    + "where type = 'reservation' and etat = 'OUI' and id_ss = "+session.get(i).intValue()+" group by id_ss" ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                rv = rs.getInt("total") ;
            }
            
            sql = "select sum(payement.mtt) as total from payement "
                    + "where etat = 'OUI' and id_ss = "+session.get(i).intValue()+" group by id_ss" ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                rv2 = rs.getInt("total") ;
            }
            
            
             sql = "select sum(sortie_caisse.mtt) as total from sortie_caisse "
                    + "where etat = 'OUI' and id_ss = "+session.get(i).intValue()+" group by id_ss" ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                s = rs.getInt("total") ;
            }
            
            
            sql = "select session.pos as pos, session.date_op as date_op, session.date_close as date_cl , session.id_ss as id, session.user as login, "
                   + "session.f_c as fond, session.balance as bl, session.etat as etat "
              + "from session "
              + "where session.id_ss = "+session.get(i).intValue()+"" ;
            rs = stmt.executeQuery(sql) ;
            
            
    while(rs.next()){
          
          HashMap<String, Object> m = new HashMap<>() ;
          
          m.put("session",  rs.getString("pos")) ;
          m.put("id", rs.getString("id")) ;
          m.put("date", sdf1.format(rs.getTimestamp("date_op"))) ;
          m.put("date2",  sdf1.format(rs.getTimestamp("date_cl"))) ;
          m.put("fond", this.nf3.format(rs.getInt("fond"))) ;
          m.put("balance",  this.nf3.format(rs.getInt("bl"))) ;
          m.put("user", rs.getString("login")) ;
          m.put("etat", rs.getString("etat")) ;
          m.put("v",  this.nf3.format(v)) ;
          m.put("rp",  this.nf3.format(rp)) ;
          m.put("sav",  this.nf3.format(sav)) ;
          m.put("vc",  this.nf3.format(rv)+" | "+this.nf3.format(rv2)) ;
          m.put("sc",  this.nf3.format(s)) ;
                      
                this.mlist1.add(m) ;
     
     
          tb += rs.getInt("bl") ;
          
          tv += v ;
          trp += rp ;
          trv += rv ;
          ts += s ;
          tsav += sav ;
        
   
      dtm.addRow(new Object[]{
     
      //  "SESSION POS", "ID", "DATE OPEN", "DATE CLOSE", "FOND DEPART", "BALANCE", "USER", "ETAT",
     //   "VENTE DIRECT", "REPRISE VENTE", "SERVICE A V", "VENTE A CREDIT", "SORTIE CAISSE"
   
   rs.getString("pos"), rs.getLong("id"), sdf1.format(rs.getTimestamp("date_op")),  sdf1.format(rs.getTimestamp("date_cl")), 
   this.nf3.format(rs.getInt("fond")),  this.nf3.format(rs.getInt("bl")), rs.getString("login"), rs.getString("etat") , v , rp, sav, this.nf3.format(rv)+" | "+this.nf3.format(rv2), s
             
        
        }) ;
 
     }

       
      
      
            
            
        }
     
        
     this.tb.setText("TOTAL BALANCE : "+this.nf3.format(tb));

        

      rs.close();
      stmt.close();
      conn.close();
     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
            
       
        
        
    }catch(Exception e){
        
             DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                               dtm.setRowCount(0) ;
                               
                               this.mlist1 = new ArrayList<>() ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        } 
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
               
          
        // D : 
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du1.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au1.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h11.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h12.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
                             dtm.setRowCount(0) ;
                             
                             this.mlist2 = new ArrayList<>() ;
        
       String sql = null ;
       ResultSet rs = null ;
       
       long tm1 = 0 ;
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' and op_session.type = 'VENTE' "
              + "order by op_session.datej desc" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
          
          if(rs.getString("etat").equalsIgnoreCase("NON")){
              
          }else if(rs.getString("etat").equalsIgnoreCase("OUI")){
              
  
          HashMap<String, Object> m = new HashMap<>() ;
          
          m.put("pos",  rs.getString("pos")) ;
          m.put("id", rs.getString("id")) ;
          m.put("date", sdf1.format(rs.getTimestamp("date"))) ;
          m.put("montant",  this.nf3.format(rs.getInt("total"))) ;
          m.put("user", rs.getString("login")) ;
         
                      
                this.mlist2.add(m) ;
     
     
      tm1 += rs.getInt("total") ;    
        
          }
   
      dtm.addRow(new Object[]{
     
      //  "VENTE POS", "ID", "DATE", "MONTANT", "USER", "ETAT", "CB"
   
  rs.getString("pos"), rs.getString("id"),  sdf1.format(rs.getTimestamp("date")), this.nf3.format(rs.getInt("total")), rs.getString("login")
  , rs.getInt("cb") , rs.getString("etat")
             
        
        }) ;
 
     }

      
      this.tm1.setText("TOTAL MONTANT : "+this.nf3.format(tm1)) ;
       
       

      rs.close();
      stmt.close();
      conn.close();
     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
            
       
        
        
    }catch(Exception e){
        
             DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
                               dtm.setRowCount(0) ;
                               
                               this.mlist2 = new ArrayList<>() ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            
        // D : 
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du2.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au2.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h22.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h21.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel() ;
                             dtm.setRowCount(0) ;
                             
                             this.mlist3 = new ArrayList<>() ;
        
       String sql = null ;
       ResultSet rs = null ;
       
       long tm2 = 0 ;
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' and op_session.type = 'REPRISE' "
              + "order by op_session.datej desc" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
          
          if(rs.getString("etat").equalsIgnoreCase("NON")){
              
              
          }else if(rs.getString("etat").equalsIgnoreCase("OUI")){
          
          HashMap<String, Object> m = new HashMap<>() ;
          
          m.put("pos",  rs.getString("pos")) ;
          m.put("id", rs.getString("id")) ;
          m.put("date", sdf1.format(rs.getTimestamp("date"))) ;
          m.put("montant",  this.nf3.format(rs.getInt("total"))) ;
          m.put("user", rs.getString("login")) ;
         
                      
                this.mlist3.add(m) ;
     
     
          tm2 += rs.getInt("total") ;
        
          }
          
          
      dtm.addRow(new Object[]{
     
      //  "VENTE POS", "ID", "DATE", "MONTANT", "USER", "ETAT", "CB"
   
  rs.getString("pos"), rs.getString("id"),  sdf1.format(rs.getTimestamp("date")), this.nf3.format(rs.getInt("total")), rs.getString("login")
  , rs.getInt("cb") , rs.getString("etat")
             
        
        }) ;
 
     }

       
      this.tm2.setText("TOTAL MONTANT : "+this.nf3.format(tm2)) ;
       

      rs.close();
      stmt.close();
      conn.close();
     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
            
       
        
        
    }catch(Exception e){
        
             DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel() ;
                               dtm.setRowCount(0) ;
      
                               
                                this.mlist3 = new ArrayList<>() ;
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         // D : 
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du3.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au3.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h3.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h31.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel() ;
                             dtm.setRowCount(0) ;
                             
                             this.mlist4 = new ArrayList<>() ;
        
       String sql = null ;
       ResultSet rs = null ;
       
     long  tm3 = 0 ;
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' and op_session.type = 'SERVICE' "
              + "order by op_session.datej desc" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
          if(rs.getString("etat").equalsIgnoreCase("NON")){
              
          }else if(rs.getString("etat").equalsIgnoreCase("OUI")){
          
          HashMap<String, Object> m = new HashMap<>() ;
          
          m.put("pos",  rs.getString("pos")) ;
          m.put("id", rs.getString("id")) ;
          m.put("date", sdf1.format(rs.getTimestamp("date"))) ;
          m.put("montant",  this.nf3.format(rs.getInt("total"))) ;
          m.put("user", rs.getString("login")) ;
         
                      
                this.mlist4.add(m) ;
     
     
          tm3 += rs.getInt("total") ;
        
          }
   
      dtm.addRow(new Object[]{
     
      //  "VENTE POS", "ID", "DATE", "MONTANT", "USER", "ETAT", "CB"
   
  rs.getString("pos"), rs.getString("id"),  sdf1.format(rs.getTimestamp("date")), this.nf3.format(rs.getInt("total")), rs.getString("login")
  , rs.getInt("cb") , rs.getString("etat")
             
        
        }) ;
 
     }

       
     this.tm3.setText("TOTAL MONTANT : "+this.nf3.format(tm3)) ;
      

      rs.close();
      stmt.close();
      conn.close();
     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
            
       
        
        
    }catch(Exception e){
        
             DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel() ;
                               dtm.setRowCount(0) ;
                               
                               this.mlist4 = new ArrayList<>() ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void h51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_h51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_h51ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
      
     // D : 
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du5.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au5.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h5.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h51.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel() ;
                             dtm.setRowCount(0) ;
                             
                             this.mlist5 = new ArrayList<>() ;
        
       String sql = null ;
       ResultSet rs = null ;
       
       long tm4 = 0 ;
       
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' and op_session.type = 'RESERVATION' "
              + "order by op_session.datej desc" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
          
          if(rs.getString("etat").equalsIgnoreCase("NON")){
              
          }else  if(rs.getString("etat").equalsIgnoreCase("OUI")){
      
       HashMap<String, Object> m = new HashMap<>() ;
          
          m.put("pos",  rs.getString("pos")) ;
          m.put("id", rs.getString("id")) ;
          m.put("date", sdf1.format(rs.getTimestamp("date"))) ;
          m.put("montant",  this.nf3.format(rs.getInt("total"))) ;
          m.put("user", rs.getString("login")) ;
         
                      
                this.mlist5.add(m) ;
                
     
          tm4 += rs.getInt("total") ;
        
          }
          
          
      dtm.addRow(new Object[]{
     
      //  "VENTE POS", "ID", "DATE", "MONTANT", "USER", "ETAT", "CB"
   
  rs.getString("pos"), rs.getString("id"),  sdf1.format(rs.getTimestamp("date")), rs.getString("client"), this.nf3.format(rs.getInt("total")), rs.getString("login")
  , rs.getInt("cb") , rs.getString("etat")
             
        
        }) ;
 
     }
      

       this.tm4.setText("TOTAL MONTANT : "+this.nf3.format(tm4)) ;
       
       

      rs.close();
      stmt.close();
      conn.close();
     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
            
       
        
        
    }catch(Exception e){
        
             DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel() ;
                               dtm.setRowCount(0) ;
                               
                               this.mlist5 = new ArrayList<>() ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        
        
         try{
            
              this.jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
                  
                        // charge in local
         InputStream in = getClass().getClassLoader().getResourceAsStream("tp3_reporting/session_1.jrxml") ;
         
               // collection generate
         JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.mlist1) ;
            
               // initialise parameter to send in reporting:
                 Map<String, Object> para = new HashMap<>() ;
                 
                 
                 
                 
   para.put("periode", "PERIODE : DU "+this.sdf_java.format(this.du.getSelectedDate().getTime())+" "+this.h1.getText()+" AU "+this.sdf_java.format(this.au.getSelectedDate().getTime())+" "+this.h2.getText()) ;
   para.put("balance", this.tb.getText()) ;
           
                
                  
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para,   jrbean) ; // new JREmptyDataSource());
           
           JasperViewer.viewReport(print, false) ;
            
          //  JasperPrintManager.printReport(print, false) ;
            
            
             this.jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
               
             //   jasper printer :
        //
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       
        
        
         try{
            
              this.jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
                  
                        // charge in local
         InputStream in = getClass().getClassLoader().getResourceAsStream("tp3_reporting/etat1.jrxml") ;
         
               // collection generate
         JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.mlist2) ;
            
               // initialise parameter to send in reporting:
                 Map<String, Object> para = new HashMap<>() ;
                 
                 
                 
                 
   para.put("periode", "PERIODE : DU "+this.sdf_java.format(this.du1.getSelectedDate().getTime())+" "+this.h11.getText()+" AU "+this.sdf_java.format(this.au1.getSelectedDate().getTime())+" "+this.h12.getText()) ;
                 para.put("total", this.tm1.getText()) ;
                 para.put("titre", "LA LISTE DES VENTES DIRECTES") ;
           
                
                  
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para,   jrbean) ; // new JREmptyDataSource());
           
           JasperViewer.viewReport(print, false) ;
            
          //  JasperPrintManager.printReport(print, false) ;
            
            
             this.jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
               
             //   jasper printer :
        //
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        
        
          try{
            
              this.jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
                  
                        // charge in local
         InputStream in = getClass().getClassLoader().getResourceAsStream("tp3_reporting/etat1.jrxml") ;
         
               // collection generate
         JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.mlist3) ;
            
               // initialise parameter to send in reporting:
                 Map<String, Object> para = new HashMap<>() ;
                 
                 
                 
                 
   para.put("periode", "PERIODE : DU "+this.sdf_java.format(this.du2.getSelectedDate().getTime())+" "+this.h22.getText()+" AU "+this.sdf_java.format(this.au2.getSelectedDate().getTime())+" "+this.h21.getText()) ;
                 para.put("total", this.tm2.getText()) ;
                 para.put("titre", "LA LISTE DES REPRISES VENTES") ;
           
                
                  
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para,   jrbean) ; // new JREmptyDataSource());
           
           JasperViewer.viewReport(print, false) ;
            
          //  JasperPrintManager.printReport(print, false) ;
            
            
             this.jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
               
             //   jasper printer :
        //
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        
        
           try{
            
              this.jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
                  
                        // charge in local
         InputStream in = getClass().getClassLoader().getResourceAsStream("tp3_reporting/etat1.jrxml") ;
         
               // collection generate
         JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.mlist4) ;
            
               // initialise parameter to send in reporting:
                 Map<String, Object> para = new HashMap<>() ;
                 
                 
                 
                 
   para.put("periode", "PERIODE : DU "+this.sdf_java.format(this.du3.getSelectedDate().getTime())+" "+this.h3.getText()+" AU "+this.sdf_java.format(this.au3.getSelectedDate().getTime())+" "+this.h31.getText()) ;
                 para.put("total", this.tm3.getText()) ;
                 para.put("titre", "LA LISTE DES SERVICES APRES VENTES") ;
           
                
                  
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para,   jrbean) ; // new JREmptyDataSource());
           
           JasperViewer.viewReport(print, false) ;
            
          //  JasperPrintManager.printReport(print, false) ;
            
            
             this.jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
               
             //   jasper printer :
        //
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
      
        
           try{
            
              this.jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
                  
                        // charge in local
         InputStream in = getClass().getClassLoader().getResourceAsStream("tp3_reporting/etat1.jrxml") ;
         
               // collection generate
         JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.mlist5) ;
            
               // initialise parameter to send in reporting:
                 Map<String, Object> para = new HashMap<>() ;
                 
                 
                 
                 
   para.put("periode", "PERIODE : DU "+this.sdf_java.format(this.du5.getSelectedDate().getTime())+" "+this.h5.getText()+" AU "+this.sdf_java.format(this.au5.getSelectedDate().getTime())+" "+this.h51.getText()) ;
                 para.put("total", this.tm4.getText()) ;
                 para.put("titre", "LA LISTE DES RESERVATIONS") ;
           
                
                  
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para,   jrbean) ; // new JREmptyDataSource());
           
           JasperViewer.viewReport(print, false) ;
            
          //  JasperPrintManager.printReport(print, false) ;
            
            
             this.jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
               
             //   jasper printer :
        //
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
         String cb = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 5).toString() ;
         String etat = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 6).toString() ;
        
             
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
       
       String sql = null ;
       ResultSet rs = null ;
       
       
        
        if(etat.equalsIgnoreCase(new String("NON"))){
            sql = "select login_an , date_an from op_session where cb = "+cb ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    JOptionPane.showMessageDialog(null, "LOGIN : "+rs.getString("login_an")+System.getProperty("line.separator")+new String("DATE : "+this.sdf_java_.format(rs.getTimestamp("date_an")))) ;
                }
        }
        
        

      rs.close();
      stmt.close();
      conn.close();
     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
            
       
        
        
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void jTable3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseReleased
        String cb = this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 5).toString() ;
         String etat = this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 6).toString() ;
        
             
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
       
       String sql = null ;
       ResultSet rs = null ;
       
       
        
        if(etat.equalsIgnoreCase(new String("NON"))){
            sql = "select login_an , date_an from op_session where cb = "+cb ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    JOptionPane.showMessageDialog(null, "LOGIN : "+rs.getString("login_an")+System.getProperty("line.separator")+new String("DATE : "+this.sdf_java_.format(rs.getTimestamp("date_an")))) ;
                }
        }
        
        

      rs.close();
      stmt.close();
      conn.close();
     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
            
       
        
        
    }//GEN-LAST:event_jTable3MouseReleased

    private void jTable4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseReleased
        String cb = this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 5).toString() ;
         String etat = this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 6).toString() ;
        
             
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
       
       String sql = null ;
       ResultSet rs = null ;
       
       
        
        if(etat.equalsIgnoreCase(new String("NON"))){
            sql = "select login_an , date_an from op_session where cb = "+cb ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    JOptionPane.showMessageDialog(null, "LOGIN : "+rs.getString("login_an")+System.getProperty("line.separator")+new String("DATE : "+this.sdf_java_.format(rs.getTimestamp("date_an")))) ;
                }
        }
        
        

      rs.close();
      stmt.close();
      conn.close();
     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
            
       
        
    }//GEN-LAST:event_jTable4MouseReleased

    private void jTable5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseReleased
        // TODO add your handling code here:
        
         String cb = this.jTable5.getValueAt(this.jTable5.getSelectedRow(), 5).toString() ;
         String etat = this.jTable5.getValueAt(this.jTable5.getSelectedRow(), 6).toString() ;
        
             
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
       
       String sql = null ;
       ResultSet rs = null ;
       
       
        
        if(etat.equalsIgnoreCase(new String("NON"))){
            sql = "select login_an , date_an from op_session where cb = "+cb ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    JOptionPane.showMessageDialog(null, "LOGIN : "+rs.getString("login_an")+System.getProperty("line.separator")+new String("DATE : "+this.sdf_java_.format(rs.getTimestamp("date_an")))) ;
                }
                
                 rs.close();
        }
        
        

     
      stmt.close();
      conn.close();
     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
            
       
        
        
        
    }//GEN-LAST:event_jTable5MouseReleased

    private void clFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clFocusGained
      
        String cl = this.cl.getText() ;
        
               if(cl.equalsIgnoreCase("CLIENT")){
                   this.cl.setText("");
               }
        
    }//GEN-LAST:event_clFocusGained

    private void clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clActionPerformed

    private void clFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clFocusLost
      String cl = this.cl.getText().trim() ;
        
               if(cl.isEmpty()){
                   this.cl.setText("CLIENT");
               }
    }//GEN-LAST:event_clFocusLost

    private void clKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clKeyReleased
        
        
        // D : 
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du5.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au5.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h5.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h51.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel() ;
                             dtm.setRowCount(0) ;
                             
                             this.mlist5 = new ArrayList<>() ;
        
       String sql = null ;
       ResultSet rs = null ;
       
       long tm4 = 0 ;
       
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' and op_session.type = 'RESERVATION' "
                   + "and op_session.client like '%"+this.cl.getText().trim().replaceAll("'", "''")+"%' "
              + "order by op_session.datej desc" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
          
          if(rs.getString("etat").equalsIgnoreCase("NON")){
              
          }else  if(rs.getString("etat").equalsIgnoreCase("OUI")){
      
       HashMap<String, Object> m = new HashMap<>() ;
          
          m.put("pos",  rs.getString("pos")) ;
          m.put("id", rs.getString("id")) ;
          m.put("date", sdf1.format(rs.getTimestamp("date"))) ;
          m.put("montant",  this.nf3.format(rs.getInt("total"))) ;
          m.put("user", rs.getString("login")) ;
         
                      
                this.mlist5.add(m) ;
                
     
          tm4 += rs.getInt("total") ;
        
          }
          
          
      dtm.addRow(new Object[]{
     
      //  "VENTE POS", "ID", "DATE", "MONTANT", "USER", "ETAT", "CB"
   
  rs.getString("pos"), rs.getString("id"),  sdf1.format(rs.getTimestamp("date")), rs.getString("client"), this.nf3.format(rs.getInt("total")), rs.getString("login")
  , rs.getInt("cb") , rs.getString("etat")
             
        
        }) ;
 
     }
      

       this.tm4.setText("TOTAL MONTANT : "+this.nf3.format(tm4)) ;
       
       

      rs.close();
      stmt.close();
      conn.close();
     
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
            
       
        
        
    }catch(Exception e){
        
             DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel() ;
                               dtm.setRowCount(0) ;
                               
                               this.mlist5 = new ArrayList<>() ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
        
    }//GEN-LAST:event_clKeyReleased

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
    
        this.session.setVisible(false) ;
        this.vierge.setVisible(false) ;
        this.vd.setVisible(false);
        this.rv.setVisible(false) ;
        this.sav.setVisible(false);
        this.reserv.setVisible(false) ;
        this.s_caisse.setVisible(true) ;
        
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed

        // D :

        try{

            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;

            String dte1 = sdf.format(this.du6.getSelectedDate().getTime()) ;
            String dte2 = sdf.format(this.au6.getSelectedDate().getTime()) ;

            dte1 = dte1+" "+this.h15.getText() ;
            // System.out.println(this.n1) ;
            dte2 = dte2+" "+this.h25.getText() ;

            //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;

            Connection conn = null;
            Statement stmt = null;

            try{
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                stmt = conn.createStatement();

                DefaultTableModel dtm = (DefaultTableModel) jTable13.getModel() ;
                                  dtm.setRowCount(0) ;
                                  
                                  long to = 0 ;

                String sql = null ;
                ResultSet rs = null ;

                sql = "select sortie_caisse.pos as pos, sortie_caisse.id_st as id, sortie_caisse.user as login, sortie_caisse.datej as date, sortie_caisse.ref as ref, "
                + "sortie_caisse.mtt as mtt, sortie_caisse.observation as observation, sortie_caisse.etat as etat "
                + "from sortie_caisse "
                + "where sortie_caisse.datej between '"+dte1+"' and '"+dte2+"' "
                + "order by sortie_caisse.datej desc" ;

                rs = stmt.executeQuery(sql) ;

                while(rs.next()){
                    // s_caisse
                    
                if("OUI".equalsIgnoreCase(rs.getString("etat"))){
                   
                    to += rs.getInt("mtt") ;
                    
                    }else{}
                     
                    dtm.addRow(new Object[]{

                        //  "POS", "DATE", "ID", "USER", "REF SORTIE", "MONTANT", "OBSERVATION"

                        rs.getString("pos"), sdf1.format(rs.getTimestamp("date"))  , rs.getString("id"), rs.getString("login") , rs.getString("ref"), this.nf3.format(rs.getInt("mtt"))
                        , rs.getString("observation") , rs.getString("etat")

                    }) ;

                }
                
                this.t0.setText("TOTAL = "+this.nf3.format(to)+" FCFA");

                rs.close();
                stmt.close();
                conn.close();

            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                    stmt.close();
                }catch(SQLException se2){
                }// nothing we can do
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try

        }catch(Exception e){

            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
            dtm.setRowCount(0) ;

            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;

            //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

        }

    }//GEN-LAST:event_jButton23ActionPerformed

    private void jTable13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable13MouseReleased

        String id = this.jTable13.getValueAt(this.jTable13.getSelectedRow(), 2).toString() ;
        String etat = this.jTable13.getValueAt(this.jTable13.getSelectedRow(), 7).toString() ;

        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            String sql = null ;
            ResultSet rs = null ;

            if(etat.equalsIgnoreCase(new String("NON"))){
                sql = "select login_an , date_an from sortie_caisse where id_st = "+id ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    JOptionPane.showMessageDialog(null, "LOGIN : "+rs.getString("login_an")+System.getProperty("line.separator")+new String("DATE : "+this.sdf_java_.format(rs.getTimestamp("date_an")))) ;
                }

                rs.close();
            }

            stmt.close();
            conn.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

    }//GEN-LAST:event_jTable13MouseReleased

    private void obFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_obFocusGained
        // TODO add your handling code here:
        
        String ob = this.ob.getText().trim().replace("'", "''") ;
        
        if(ob.equalsIgnoreCase("OBSERVATION")){
            this.ob.setText("");
        }
        
        
    }//GEN-LAST:event_obFocusGained

    private void obFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_obFocusLost
        // TODO add your handling code here:
        
        
         String ob = this.ob.getText().trim().replace("'", "''") ;
        
        if(ob.isEmpty()){
            this.ob.setText("OBSERVATION");
        }
        
        
        
    }//GEN-LAST:event_obFocusLost

    private void obKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_obKeyReleased
        // TODO add your handling code here:
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
        
        
            Connection conn = null;
            Statement stmt = null;

            try{
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                stmt = conn.createStatement();

                DefaultTableModel dtm = (DefaultTableModel) jTable13.getModel() ;
                                  dtm.setRowCount(0) ;
                                  
                                  long to = 0 ;

                String sql = null ;
                ResultSet rs = null ;

                sql = "select sortie_caisse.pos as pos, sortie_caisse.id_st as id, sortie_caisse.user as login, sortie_caisse.datej as date, sortie_caisse.ref as ref, "
                + "sortie_caisse.mtt as mtt, sortie_caisse.observation as observation, sortie_caisse.etat as etat "
                + "from sortie_caisse "
                + "where sortie_caisse.observation like '%"+this.ob.getText().trim().replaceAll("'", "''")+"%' "
                + "order by sortie_caisse.datej desc" ;

                rs = stmt.executeQuery(sql) ;

                while(rs.next()){
                    // s_caisse
                    
                    to += rs.getInt("mtt") ;

                    dtm.addRow(new Object[]{

                        //  "POS", "DATE", "ID", "USER", "REF SORTIE", "MONTANT", "OBSERVATION"

                        rs.getString("pos"), sdf1.format(rs.getTimestamp("date"))  , rs.getString("id"), rs.getString("login") , rs.getString("ref"), this.nf3.format(rs.getInt("mtt"))
                        , rs.getString("observation") , rs.getString("etat")

                    }) ;

                }
                
                this.t0.setText("TOTAL = "+this.nf3.format(to)+" FCFA");

                rs.close();
                stmt.close();
                conn.close();

            }catch(SQLException se){
                //Handle errors for JDBC
                se.printStackTrace();
            }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                    stmt.close();
                }catch(SQLException se2){
                }// nothing we can do
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try
        
        
        
    }//GEN-LAST:event_obKeyReleased

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
            java.util.logging.Logger.getLogger(Etat_tp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Etat_tp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Etat_tp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Etat_tp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Etat_tp3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo au;
    private datechooser.beans.DateChooserCombo au1;
    private datechooser.beans.DateChooserCombo au2;
    private datechooser.beans.DateChooserCombo au3;
    private datechooser.beans.DateChooserCombo au5;
    private datechooser.beans.DateChooserCombo au6;
    private javax.swing.JCheckBox ch;
    private javax.swing.JTextField cl;
    private datechooser.beans.DateChooserCombo du;
    private datechooser.beans.DateChooserCombo du1;
    private datechooser.beans.DateChooserCombo du2;
    private datechooser.beans.DateChooserCombo du3;
    private datechooser.beans.DateChooserCombo du5;
    private datechooser.beans.DateChooserCombo du6;
    private javax.swing.JPanel etat;
    private javax.swing.JFormattedTextField h1;
    private javax.swing.JFormattedTextField h11;
    private javax.swing.JFormattedTextField h12;
    private javax.swing.JFormattedTextField h15;
    private javax.swing.JFormattedTextField h2;
    private javax.swing.JFormattedTextField h21;
    private javax.swing.JFormattedTextField h22;
    private javax.swing.JFormattedTextField h25;
    private javax.swing.JFormattedTextField h3;
    private javax.swing.JFormattedTextField h31;
    private javax.swing.JFormattedTextField h5;
    private javax.swing.JFormattedTextField h51;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField ob;
    private javax.swing.JPanel reserv;
    private javax.swing.JPanel rv;
    private javax.swing.JPanel s_caisse;
    private javax.swing.JPanel sav;
    private javax.swing.JPanel session;
    private javax.swing.JLabel t0;
    private javax.swing.JLabel tb;
    private javax.swing.JLabel tm1;
    private javax.swing.JLabel tm2;
    private javax.swing.JLabel tm3;
    private javax.swing.JLabel tm4;
    private javax.swing.JPanel vd;
    private javax.swing.JPanel vierge;
    // End of variables declaration//GEN-END:variables
}
