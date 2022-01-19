/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.ProduitFini.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HAMZA
 */
public class Gp_cl extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      Integer id = 0 ;
      String type = "" ;
      String oldGp = "";
      
    public Gp_cl() {
        initComponents();
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
        
        
        
        
        //  ---------  2è choix
              
        
        
        
        
       //   ---------------
        
        
        //
        
       
        
     
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
        
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm.setRowCount(0) ;
        
         Connection conn = null;
         Statement stmt = null;
         PreparedStatement pst = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
    String sql = null ;
    ResultSet rs = null ;
    
    sql = "select * from groupe_cl" ;
    pst = conn.prepareStatement(sql) ;
    rs = pst.executeQuery() ;
    
    while(rs.next()){
        
        dtm.addRow(new Object[]{
            
      rs.getInt("id") , rs.getString("groupe") , rs.getString("type")
                
          }) ;
        
    }
      
      
      
    
            
      // STEP 6: Clean-up environment
      
   //    System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      pst.close();
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
        gp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        find = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        imprimer = new javax.swing.JButton();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GESTION GROUPE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        gp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gpActionPerformed(evt);
            }
        });

        jLabel1.setText("SAISIR LE GROUPE");

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AJOUTER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("MODIFIER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("VEILLEUSE");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "GROUPE", "ACTIVER"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(60);
        }

        find.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                findKeyReleased(evt);
            }
        });

        jLabel2.setText("RECHERCHER UN GROUPE");

        imprimer.setBackground(new java.awt.Color(0, 51, 255));
        imprimer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        imprimer.setForeground(new java.awt.Color(255, 255, 255));
        imprimer.setText("IMPRIMER");
        imprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gp, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(119, 119, 119)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(find)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(77, 77, 77))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(161, 161, 161))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(imprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(gp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(find, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(imprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String groupe = this.gp.getText().replaceAll("'", "''").trim() ;
        
        if(groupe.equals("")){
            JOptionPane.showMessageDialog(null, "SAISIR UN GROUPE SVP") ;
        }else if(groupe.equals("") == false){
            
            Connection conn = null;
            Statement stmt = null;
            PreparedStatement pst = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
      DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                        dtm.setRowCount(0);
      
    String sql = null ;
    ResultSet rs = null ;
    Integer vy = 0 ;
    
    sql = "select * from groupe_cl where groupe = ?";
    pst = conn.prepareStatement(sql) ;
    pst.setString(1, groupe) ;
    rs = pst.executeQuery() ;
    while(rs.next()){
        vy = 1 ;
    }
    
    if(vy == 0){
    
    
    sql = "insert into groupe_cl(groupe,type) values(?,?)" ;
    pst = conn.prepareStatement(sql) ;
    pst.setString(1, groupe);
    pst.setString(2, "OUI");
    pst.execute();
    
    
    sql = "select * from groupe_cl" ;
    pst = conn.prepareStatement(sql) ;
    rs = pst.executeQuery() ;
    
    while(rs.next()){
        
        dtm.addRow(new Object[]{
            
      rs.getInt("id") , rs.getString("groupe") , rs.getString("type")
                
          }) ;
        
    }
    
    
    }else if(vy == 1){
        sql = "select * from groupe_cl" ;
    pst = conn.prepareStatement(sql) ;
    rs = pst.executeQuery() ;
    
    while(rs.next()){
        
        dtm.addRow(new Object[]{
            
      rs.getInt("id") , rs.getString("groupe") , rs.getString("type")
                
          }) ;
        
    }
    
        JOptionPane.showMessageDialog(null, "LE GROUPE EXISTE") ;
    }
    
    
      
      
      this.gp.setText("") ;
    
            
      // STEP 6: Clean-up environment
      
   //    System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      pst.close();
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
        
            
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        this.id = 0 ;
        this.type = "" ;
        this.oldGp = "" ;
        
        this.id = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString()) ;
        
        this.gp.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString());
        
        this.type = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString() ;
        this.oldGp = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString() ;
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "CHOISIR UN GROUPE SVP") ;
        }else{
            
            
              String groupe = this.gp.getText().replaceAll("'", "''").trim() ;
        
        if(groupe.equals("")){
            JOptionPane.showMessageDialog(null, "SAISIR UN GROUPE SVP") ;
        }else if(groupe.equals("") == false){
            
            Connection conn = null;
            Statement stmt = null;
            PreparedStatement pst = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
      DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                        dtm.setRowCount(0);
      
    String sql = null ;
    ResultSet rs = null ;
    
    
    sql = "update groupe_cl set groupe = ? where id = ? " ;
    pst = conn.prepareStatement(sql) ;
    pst.setString(1, groupe);
    pst.setInt(2, this.id);
    pst.execute();
    
    sql = "update rubrique set groupe = ? where groupe = ?" ;
    pst = conn.prepareStatement(sql);
    pst.setString(1, groupe) ;
    pst.setString(2, this.oldGp);
    
    pst.execute() ;
    
    
    
    
    sql = "select * from groupe_cl" ;
    pst = conn.prepareStatement(sql) ;
    rs = pst.executeQuery() ;
    
    while(rs.next()){
        
        dtm.addRow(new Object[]{
            
      rs.getInt("id") , rs.getString("groupe") , rs.getString("type")
                
          }) ;
        
    }
      
      
      this.gp.setText("") ;
    
            
      // STEP 6: Clean-up environment
      
   //    System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      pst.close();
      conn.close();
      
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage()) ;
        }
        }
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
           
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "CHOISIR UN GROUPE SVP") ;
        }else{
            
            
            
            Connection conn = null;
            Statement stmt = null;
            PreparedStatement pst = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
      DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                        dtm.setRowCount(0);
      
    String sql = null ;
    ResultSet rs = null ;
    
    if(this.type.equalsIgnoreCase("OUI")){
    
    sql = "update groupe_cl set type = ? where id = ? " ;
    pst = conn.prepareStatement(sql) ;
    pst.setString(1, "NON");
    pst.setInt(2, this.id);
    pst.execute();
    
    }else if(this.type.equalsIgnoreCase("NON")){
        
    sql = "update groupe_cl set type = ? where id = ? " ;
    pst = conn.prepareStatement(sql) ;
    pst.setString(1, "OUI");
    pst.setInt(2, this.id);
    pst.execute();
        
    }
    
    
    sql = "select * from groupe_cl" ;
    pst = conn.prepareStatement(sql) ;
    rs = pst.executeQuery() ;
    
    while(rs.next()){
        
        dtm.addRow(new Object[]{
            
      rs.getInt("id") , rs.getString("groupe") , rs.getString("type")
                
          }) ;
        
    }
      
      
      this.gp.setText("") ;
    
            
      // STEP 6: Clean-up environment
      
   //    System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      pst.close();
      conn.close();
      
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage()) ;
        }
    
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void findKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_findKeyReleased
        // TODO add your handling code here:
        
        String find = this.find.getText().replaceAll("'", "''").trim() ;
        
        if(find.equals("")){
            
         Connection conn = null;
         Statement stmt = null;
         PreparedStatement pst = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
    DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                      dtm.setRowCount(0) ;
      
    String sql = null ;
    ResultSet rs = null ;
    
    sql = "select * from groupe_cl" ;
    pst = conn.prepareStatement(sql) ;
    rs = pst.executeQuery() ;
    
    while(rs.next()){
        
        dtm.addRow(new Object[]{
            
      rs.getInt("id") , rs.getString("groupe") , rs.getString("type")
                
          }) ;
        
    }
      
      
      
    
            
      // STEP 6: Clean-up environment
      
   //    System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      pst.close();
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
        
            
        }else if(find.equals("") == false){
            
            
         Connection conn = null;
         Statement stmt = null;
         PreparedStatement pst = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
    DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                      dtm.setRowCount(0) ;
      
    String sql = null ;
    ResultSet rs = null ;
    
    sql = "select * from groupe_cl where groupe like ?" ;
    pst = conn.prepareStatement(sql) ;
    pst.setString(1, "%"+find+"%") ;
    rs = pst.executeQuery() ;
    
    while(rs.next()){
        
        dtm.addRow(new Object[]{
            
      rs.getInt("id") , rs.getString("groupe") , rs.getString("type")
                
          }) ;
        
    }
      
      
      
    
            
      // STEP 6: Clean-up environment
      
   //    System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      pst.close();
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
        
            
            
            
        }
        
        
    }//GEN-LAST:event_findKeyReleased

    private void imprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimerActionPerformed
        // TODO add your handling code here:
        
        
        
        this.imprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        
       try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\groupe_cl.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql = "select \n" +
" rubrique.id as ref ,\n" +
"rubrique.rub as description , rubrique.type as activer , \n" +
"rubrique.groupe as gp \n" +
"from \n" +
"transformation.rubrique order by gp asc , description asc" ;
           
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql) ;
           jd.setQuery(newQuery) ;
           JasperReport jr = JasperCompileManager.compileReport(jd) ;
           HashMap para = new HashMap() ;
           JasperPrint j = JasperFillManager.fillReport(jr, para, DriverManager.getConnection(DB_URL,USER,PASS)) ;
           JasperViewer.viewReport(j , false) ;
          
            //  si besoin :
           
               File f = new File("E:\\reports") ;
           
                if(f.exists()){
                  if(f.setWritable(true)){
                 
                    
                   OutputStream os = new FileOutputStream(f) ;
                                    
                    JasperExportManager.exportReportToPdfStream(j, os) ;
                  
                     os.flush();
                     os.close() ;
                   
                   JOptionPane.showMessageDialog(null, "Enregistrement terminer avec succes") ;
           
                
                }
              
              }

           
           //
           
           
           
       }catch(Exception e){
       
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       
       }
        
       this.imprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
        
        
    }//GEN-LAST:event_imprimerActionPerformed

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
            java.util.logging.Logger.getLogger(Gp_cl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gp_cl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gp_cl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gp_cl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gp_cl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField find;
    private javax.swing.JTextField gp;
    private javax.swing.JButton imprimer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
