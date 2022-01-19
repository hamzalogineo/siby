/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.Detail_Op.JDBC_DRIVER;
import static frontend.Print_Pl.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HAMZA
 */
public class Stock_periodique_yaya extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy") ;
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
       long toA = 0 ;
       long toD = 0 ;
       
      List bonList = new ArrayList() ;
      
      long t_1 = 0 ;
      long t_2 = 0 ;
    
    String op ;
    String dte1 ;
    String dte2 ;
    
    public Stock_periodique_yaya() {
        initComponents();
        this.setLocationRelativeTo(null) ;
        
        
         Date jour = new Date() ;
        this.jDateChooser1.setDate(jour);
        this.h1.setText("00:00") ;
        this.jDateChooser2.setDate(jour) ;
        this.h2.setText("23:59") ;
        
        
         // ---------------- 1è choix --------------
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
                  
                  //
                  
                     // right align 2nd column
                   
                  
                  //

                  for (int i = 0; i < this.jTable1.getModel().getColumnCount(); i++) {
                    this.jTable1.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
                  DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                     dtm1.addRow(new Object[]{1 , "xxxxxxxxxxxxxxxxxxxx","100.000","150.000",0,0,1}) ;
                     
                     dtm1.setRowCount(0) ;
                     
                     
                     //
                     
                         // right align 2nd column
                    TableColumnModel columnModel = this.jTable1.getColumnModel();
                    TableColumn column_0 = columnModel.getColumn(0);
                    TableColumn column_1 = columnModel.getColumn(1);
                    TableColumn column_2 = columnModel.getColumn(2);
                    TableColumn column_3 = columnModel.getColumn(3);
                    TableColumn column_4 = columnModel.getColumn(4);
                    TableColumn column_5 = columnModel.getColumn(5);
                    TableColumn column_6 = columnModel.getColumn(6);
                    TableColumn column_7 = columnModel.getColumn(7);
                    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                    
                    DefaultTableCellRenderer renderer_ = new DefaultTableCellRenderer();
                    renderer.setHorizontalAlignment(JLabel.LEFT); // RIGHT
                    renderer_.setHorizontalAlignment(JLabel.RIGHT); // RIGHT
                    column_0.setCellRenderer(renderer_);
                    column_1.setCellRenderer(renderer_);
                    column_2.setCellRenderer(renderer);
                    column_3.setCellRenderer(renderer_);
                    column_4.setCellRenderer(renderer_);
                    column_5.setCellRenderer(renderer_);
                    column_6.setCellRenderer(renderer_);
                    column_7.setCellRenderer(renderer_);
                     
                     //
                    
                    this.jTable1.getColumnModel().getColumn(0).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
                    
                   this.jTable1.getColumnModel().getColumn(1).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
                   
                   this.jTable1.getColumnModel().getColumn(2).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
                   
                   this.jTable1.getColumnModel().getColumn(3).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER)) ;
                   
                   this.jTable1.getColumnModel().getColumn(4).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER)) ;
                   
                   this.jTable1.getColumnModel().getColumn(5).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
                   
                   this.jTable1.getColumnModel().getColumn(6).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER)); 
                   
                   this.jTable1.getColumnModel().getColumn(7).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
                   
                   
                     
                     
                      Connection conn = null ;
                      Statement  stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
     
       
           
       String sql = null ;
               
       ResultSet rs = null ;
                  
         
                 
                 sql = "select magasin from magasins where etat = 'oui' limit 1" ;
                 rs = stmt.executeQuery(sql) ;
                 while(rs.next()){
                      
                     this.mg.addItem(new String(rs.getString("magasin"))) ;
                 }
                 
                 sql = "select nom from famille " ;
                 rs = stmt.executeQuery(sql) ;
                 while(rs.next()){
                    String nom = new String(rs.getString("nom")) ;
                     this.f.addItem(nom) ;
                    }
                 
                 
                 
      
       
      //STEP 6: Clean-up environment
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
        
       
     
     // Fin configure :
        
        
        
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
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
        mg = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        h1 = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        h2 = new javax.swing.JTextField();
        f = new javax.swing.JComboBox();
        sf = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ETAT ENTREE STOCK SUR UNE PERIODE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 18))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FILTRE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        mg.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        mg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOSIR UN MAGASIN", "TOUT" }));
        mg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        h2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h2ActionPerformed(evt);
            }
        });

        f.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        f.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FAMILLE", "TOUTE" }));
        f.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fActionPerformed(evt);
            }
        });

        sf.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        sf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SOUS-FAMILLE", "TOUTE" }));
        sf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton1.setBackground(new java.awt.Color(51, 0, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("RECHERCHER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("IMPRIMER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("DU");

        jLabel4.setText("HEURE");

        jLabel5.setText("AU");

        jLabel6.setText("HEURE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mg, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sf, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mg)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(h1)
                    .addComponent(h2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(f)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CODE BARRE", "DESCRIPTION", "QTE ENTREE", "P.A", "VALEUR STOCK ACHAT", "P.V", "VALEUR STOCK VENTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(15);
        }

        jLabel1.setText("TOTAL V.S.A :");

        t1.setEditable(false);

        jLabel2.setText("TOTAL V.S.V :");

        t2.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void h2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_h2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_h2ActionPerformed

    private void fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fActionPerformed
        // TODO add your handling code here:
        
        
                             Connection conn = null ;
                             Statement  stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      
      this.sf.removeAllItems();
      this.sf.addItem(new String("SOUS FAMILLE"));
      this.sf.addItem(new String("TOUTE"));
      
      
       String sql = null ;
              sql = "select nom from sfamille where rflle = '"+this.f.getSelectedItem().toString().replaceAll("'", "''")+"' " ; 
       ResultSet rs = null ;
                 rs = stmt.executeQuery(sql) ;
       while(rs.next()){
           
            this.sf.addItem(new String(rs.getString("nom")));
           
       }
       
          
       
      //STEP 6: Clean-up environment
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
        
       
     
     // Fin configure :
     
        
        
        //
        
            
        
        
        
    }//GEN-LAST:event_fActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(this.mg.getSelectedItem().toString().equalsIgnoreCase("CHOSIR UN MAGASIN") || this.f.getSelectedItem().toString().equalsIgnoreCase("FAMILLE") || this.sf.getSelectedItem().toString().equalsIgnoreCase("SOUS FAMILLE")){
            JOptionPane.showMessageDialog(null, "CHOISIR LES PARAMETRES !!!") ;
        }else{
            // try and catch clause :
            
            //  JOptionPane.showMessageDialog(null, "on try catch !!!") ;
            
            
            
            try{
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
        SimpleDateFormat sdfT1 = new SimpleDateFormat("dd-MM-yyyy") ;
       
        this.dte1 = sdfT1.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        this.dte2 = sdfT1.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                          dtm.setRowCount(0) ;
             
                          // acces au données :
                          
                                  Connection conn = null ;
                                  Statement  stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
     
           String mg ;
                  mg = this.mg.getSelectedItem().toString().replaceAll("'", "''") ;
                  String f ;
                         f = this.f.getSelectedItem().toString().replaceAll("'", "''") ;
                  String sf ;
                         sf = this.sf.getSelectedItem().toString().replaceAll("'", "''") ;
                         
                         this.t_1 = 0 ;
                         this.t_2 = 0 ;
                         this.bonList.removeAll(this.bonList) ;
                         
                         
       
           
           String sql = null ;
           String sql_1 = null ;
           String sql_0 = null ;
           ResultSet rs = null ;
           
           if(mg.equals("TOUT") && f.equals("TOUTE") && sf.equals("TOUTE")){
               // JOptionPane.showMessageDialog(null, "Query tout !!! n° 1 ") ;
  //  "ID", "CODE BARRE", "DESCRIPTION", "QTE ENTREE", "P.A", "VALEUR STOCK ACHAT", "P.V", "VALEUR STOCK VENTE"
               
               sql = "select idpro,cb,desi,sum(qteet) as qte,pa,pv,unite_m as rp from stock2, produits_f where datec between '"+dte1+"' AND '"+dte2+"' "
                   + "AND type = 'achat' AND et_ = 'oui' AND produits_f.description = stock2.desi "
                   + "group by stock2.f,stock2.sf,stock2.desi order by stock2.f,stock2.sf,stock2.desi" ;
               
               sql_1 = "select idpro,cb,desi,sum(qteet) as qte,pa,pv,unite_mesure as rp from stock2, matieres_p where datec between '"+dte1+"' AND '"+dte2+"' "
                   + "AND type = 'achat' AND et_ = 'oui' AND matieres_p.description = stock2.desi "
                   + "group by stock2.f,stock2.sf,stock2.desi order by stock2.f,stock2.sf,stock2.desi" ;
               
               sql_0 = "select idpro,cb,desi,sum(qteet) as qte,pa,pv,produit as pr from stock2, derive_pl where datec between '"+dte1+"' AND '"+dte2+"' "
                   + " AND stock2.type = 'achat' AND et_ = 'oui' AND derive_pl.produit = stock2.desi "
                   + "group by f,sf,desi order by f,sf,desi" ;
               
               
           }else if(mg.equals("TOUT") == false && f.equals("TOUTE") && sf.equals("TOUTE")){
               
                sql = "select idpro,cb,desi,sum(qteet) as qte,pa,pv,unite_m as rp from stock2, produits_f where "
                   + "maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND "
                   + "datec between '"+dte1+"' AND '"+dte2+"' "
                   + "AND type = 'achat' AND et_ = 'oui' AND produits_f.description = stock2.desi "
                   + "group by stock2.f,stock2.sf,stock2.desi order by stock2.f,stock2.sf,stock2.desi" ;
               
               sql_1 = "select idpro,cb,desi,sum(qteet) as qte,pa,pv,unite_mesure as rp from stock2, matieres_p where "
                      +"maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND "
                      +"datec between '"+dte1+"' AND '"+dte2+"' "
                      +"AND type = 'achat' AND et_ = 'oui' AND matieres_p.description = stock2.desi "
                      +"group by stock2.f,stock2.sf,stock2.desi order by stock2.f,stock2.sf,stock2.desi" ;
               
               sql_0 = "select idpro,cb,desi,sum(qteet) as qte,pa,pv,produit as pr from stock2, derive_pl where "
                       +"maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND "
                       +"datec between '"+dte1+"' AND '"+dte2+"' "
                       +"AND stock2.type = 'achat' AND et_ = 'oui' AND derive_pl.produit = stock2.desi "
                       +"group by f,sf,desi order by f,sf,desi" ;
               
               
               
               
           }else if(mg.equals("TOUT") == false && f.equals("TOUTE") == false && sf.equals("TOUTE")){
               
                sql = "select idpro,cb,desi,sum(qteet) as qte,pa,pv,unite_m as rp from stock2, produits_f where "
                   + "stock2.f = '"+f.replaceAll("'", "''")+"' AND "
                   + "maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND "
                   + "datec between '"+dte1+"' AND '"+dte2+"' "
                   + "AND type = 'achat' AND et_ = 'oui' AND produits_f.description = stock2.desi "
                   + "group by stock2.f,stock2.sf,stock2.desi order by stock2.f,stock2.sf,stock2.desi" ;
               
               sql_1 = "select idpro,cb,desi,sum(qteet) as qte,pa,pv,unite_mesure as rp from stock2, matieres_p where "
                      +"stock2.f = '"+f.replaceAll("'", "''")+"' AND "
                      +"maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND "
                      +"datec between '"+dte1+"' AND '"+dte2+"' "
                      +"AND type = 'achat' AND et_ = 'oui' AND matieres_p.description = stock2.desi "
                      +"group by stock2.f,stock2.sf,stock2.desi order by stock2.f,stock2.sf,stock2.desi" ;
               
               sql_0 = "select idpro,cb,desi,sum(qteet) as qte,pa,pv,produit as pr from stock2, derive_pl where "
                       +"stock2.f = '"+f.replaceAll("'", "''")+"' AND "
                       +"maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND "
                       +"datec between '"+dte1+"' AND '"+dte2+"' "
                       +"AND stock2.type = 'achat' AND et_ = 'oui' AND derive_pl.produit = stock2.desi "
                       +"group by f,sf,desi order by f,sf,desi" ;
               
               
               
           }else if(mg.equals("TOUT") == false && f.equals("TOUTE") == false && sf.equals("TOUTE") == false){
               
                sql = "select idpro,cb,desi,sum(qteet) as qte,pa,pv,unite_m as rp from stock2, produits_f where "
                   + "stock2.f = '"+f.replaceAll("'", "''")+"' AND stock2.sf = '"+sf.replaceAll("'", "''")+"' AND "
                   + "maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND "
                   + "datec between '"+dte1+"' AND '"+dte2+"' "
                   + "AND type = 'achat' AND et_ = 'oui' AND produits_f.description = stock2.desi "
                   + "group by stock2.f,stock2.sf,stock2.desi order by stock2.f,stock2.sf,stock2.desi" ;
               
               sql_1 = "select idpro,cb,desi,sum(qteet) as qte,pa,pv,unite_mesure as rp from stock2, matieres_p where "
                      +"stock2.f = '"+f.replaceAll("'", "''")+"' AND stock2.sf = '"+sf.replaceAll("'", "''")+"' AND "
                      +"maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND "
                      +"datec between '"+dte1+"' AND '"+dte2+"' "
                      +"AND type = 'achat' AND et_ = 'oui' AND matieres_p.description = stock2.desi "
                      +"group by stock2.f,stock2.sf,stock2.desi order by stock2.f,stock2.sf,stock2.desi" ;
               
               sql_0 = "select idpro,cb,desi,sum(qteet) as qte,pa,pv,produit as pr from stock2, derive_pl where "
                       +"stock2.f = '"+f.replaceAll("'", "''")+"' AND stock2.sf = '"+sf.replaceAll("'", "''")+"' AND "
                       +"maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND "
                       +"datec between '"+dte1+"' AND '"+dte2+"' "
                       +"AND stock2.type = 'achat' AND et_ = 'oui' AND derive_pl.produit = stock2.desi "
                       +"group by f,sf,desi order by f,sf,desi" ;
               
               
               
           }else if(mg.equals("TOUT") && f.equals("TOUTE") == false && sf.equals("TOUTE") == false){
               
                sql = "select idpro,cb,desi,sum(qteet) as qte,pa,pv,unite_m as rp from stock2, produits_f where "
                   + "stock2.f = '"+f.replaceAll("'", "''")+"' AND stock2.sf = '"+sf.replaceAll("'", "''")+"' AND "
                   + "datec between '"+dte1+"' AND '"+dte2+"' "
                   + "AND type = 'achat' AND et_ = 'oui' AND produits_f.description = stock2.desi "
                   + "group by stock2.f,stock2.sf,stock2.desi order by stock2.f,stock2.sf,stock2.desi" ;
               
               sql_1 = "select idpro,cb,desi,sum(qteet) as qte,pa,pv,unite_mesure as rp from stock2, matieres_p where "
                      +"stock2.f = '"+f.replaceAll("'", "''")+"' AND stock2.sf = '"+sf.replaceAll("'", "''")+"' AND "
                      +"datec between '"+dte1+"' AND '"+dte2+"' "
                      +"AND type = 'achat' AND et_ = 'oui' AND matieres_p.description = stock2.desi "
                      +"group by stock2.f,stock2.sf,stock2.desi order by stock2.f,stock2.sf,stock2.desi" ;
               
               sql_0 = "select idpro,cb,desi,sum(qteet) as qte,pa,pv,produit as pr from stock2, derive_pl where "
                       +"stock2.f = '"+f.replaceAll("'", "''")+"' AND stock2.sf = '"+sf.replaceAll("'", "''")+"' AND "
                       +"datec between '"+dte1+"' AND '"+dte2+"' "
                       +"AND stock2.type = 'achat' AND et_ = 'oui' AND derive_pl.produit = stock2.desi "
                       +"group by f,sf,desi order by f,sf,desi" ;
               
               
               
           }
           
           // les matieres primaire :
           
            rs = stmt.executeQuery(sql_1) ;
            while(rs.next()){
                
                // hasmap :
                HashMap<String, Object> m = new HashMap<>() ;
                
                
                if("oui".equalsIgnoreCase(rs.getString("rp"))){
                    
                   m.put("id",  rs.getString("idpro")+"   ") ;
                   m.put("cb", rs.getString("cb")+"   ") ;
                   m.put("desi", "   "+rs.getString("desi")) ;
                   m.put("qte", this.nf3.format(rs.getLong("qte"))+"   ") ;
                   m.put("pa", this.nf3.format(rs.getLong("pa"))+"   ") ;
                   m.put("vsa", this.nf3.format(Math.round((rs.getLong("pa") * (rs.getLong("qte")/1000.0))))+"   ") ;
                   m.put("pv", this.nf3.format(rs.getLong("pv"))+"   ") ;
                   m.put("vsv", this.nf3.format(Math.round((rs.getLong("pv") * (rs.getLong("qte")/1000.0))))+"  ") ;
                   
                   this.bonList.add(m) ;
                   
                    
                this.t_1 += Math.round((rs.getLong("pa") * (rs.getLong("qte")/1000.0))) ;
                this.t_2 += Math.round((rs.getLong("pv") * (rs.getLong("qte")/1000.0))) ;
                
    // "ID", "CODE BARRE", "DESCRIPTION", "QTE ENTREE", "P.A", "VALEUR STOCK ACHAT", "P.V", "VALEUR STOCK VENTE"
               
                dtm.addRow(new Object[]{
                    
 rs.getLong("idpro")+"   " , rs.getString("cb")+"   "  , "   "+rs.getString("desi") , this.nf3.format(rs.getLong("qte"))+"   ", this.nf3.format(rs.getLong("pa"))+"   "  ,
 this.nf3.format(Math.round((rs.getLong("pa") * (rs.getLong("qte")/1000.0))))+"   "  , this.nf3.format(rs.getLong("pv"))+"   "  , this.nf3.format(Math.round((rs.getLong("pv") * (rs.getLong("qte")/1000.0))))+"   " 
                
                });
                    
                    
                }else{
                    
                   m.put("id",  rs.getString("idpro")+"   ") ;
                   m.put("cb", rs.getString("cb")+"   ") ;
                   m.put("desi", "   "+rs.getString("desi")) ;
                   m.put("qte", this.nf3.format(rs.getLong("qte"))+"   ") ;
                   m.put("pa", this.nf3.format(rs.getLong("pa"))+"   ") ;
                   m.put("vsa", this.nf3.format((rs.getLong("pa") * rs.getLong("qte")))+"   ") ;
                   m.put("pv", this.nf3.format(rs.getLong("pv"))+"   ") ;
                   m.put("vsv", this.nf3.format((rs.getLong("pv") * rs.getLong("qte")))+"  ") ;
                   
                   this.bonList.add(m) ;
                
                this.t_1 += (rs.getLong("pa") * rs.getLong("qte")) ;
                this.t_2 += (rs.getLong("pv") * rs.getLong("qte")) ;
                
    // "ID", "CODE BARRE", "DESCRIPTION", "QTE ENTREE", "P.A", "VALEUR STOCK ACHAT", "P.V", "VALEUR STOCK VENTE"
               
                dtm.addRow(new Object[]{
                    
     rs.getLong("idpro")+"   "  , rs.getString("cb")+"   "  , "   "+rs.getString("desi") , this.nf3.format(rs.getLong("qte"))+"   " , this.nf3.format(rs.getLong("pa"))+"   "  ,
                    this.nf3.format((rs.getLong("pa") * rs.getLong("qte")))+"   "  , this.nf3.format(rs.getLong("pv"))+"   "  , this.nf3.format((rs.getLong("pv") * rs.getLong("qte")))+"   " 
                
                });
                
                }
                
            }
            
            // end matieres primaire :
            
            
            //les produits finis :
            
              rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                
                // hasmap :
                HashMap<String, Object> m = new HashMap<>() ;
                
                
                if("oui".equalsIgnoreCase(rs.getString("rp"))){
                    
                   m.put("id",  rs.getString("idpro")+"   ") ;
                   m.put("cb", rs.getString("cb")+"   ") ;
                   m.put("desi", "   "+rs.getString("desi")) ;
                   m.put("qte", this.nf3.format(rs.getLong("qte"))+"   ") ;
                   m.put("pa", this.nf3.format(rs.getLong("pa"))+"   ") ;
                   m.put("vsa", this.nf3.format(Math.round((rs.getLong("pa") * (rs.getLong("qte")/1000.0))))+"   ") ;
                   m.put("pv", this.nf3.format(rs.getLong("pv"))+"   ") ;
                   m.put("vsv", this.nf3.format(Math.round((rs.getLong("pv") * (rs.getLong("qte")/1000.0))))+"  ") ;
                   
                   this.bonList.add(m) ;
                    
                this.t_1 += Math.round((rs.getLong("pa") * (rs.getLong("qte")/1000.0))) ;
                this.t_2 += Math.round((rs.getLong("pv") * (rs.getLong("qte")/1000.0))) ;
                
    // "ID", "CODE BARRE", "DESCRIPTION", "QTE ENTREE", "P.A", "VALEUR STOCK ACHAT", "P.V", "VALEUR STOCK VENTE"
               
                dtm.addRow(new Object[]{
                    
 rs.getLong("idpro")+"   "  , rs.getString("cb")+"   "  , "   "+rs.getString("desi") , this.nf3.format(rs.getLong("qte"))+"   " , this.nf3.format(rs.getLong("pa"))+"   "  ,
 this.nf3.format(Math.round((rs.getLong("pa") * (rs.getLong("qte")/1000.0))))+"   "  , this.nf3.format(rs.getLong("pv"))+"   "  , this.nf3.format(Math.round((rs.getLong("pv") * (rs.getLong("qte")/1000.0))))+"   " 
                
                });
                    
                    
                }else{
                    
                   m.put("id",  rs.getString("idpro")+"   ") ;
                   m.put("cb", rs.getString("cb")+"   ") ;
                   m.put("desi", "   "+rs.getString("desi")) ;
                   m.put("qte", this.nf3.format(rs.getLong("qte"))+"   ") ;
                   m.put("pa", this.nf3.format(rs.getLong("pa"))+"   ") ;
                   m.put("vsa", this.nf3.format((rs.getLong("pa") * rs.getLong("qte")))+"   ") ;
                   m.put("pv", this.nf3.format(rs.getLong("pv"))+"   ") ;
                   m.put("vsv", this.nf3.format((rs.getLong("pv") * rs.getLong("qte")))+"  ") ;
                   
                   this.bonList.add(m) ;
                
                this.t_1 += (rs.getLong("pa") * rs.getLong("qte")) ;
                this.t_2 += (rs.getLong("pv") * rs.getLong("qte")) ;
                
    // "ID", "CODE BARRE", "DESCRIPTION", "QTE ENTREE", "P.A", "VALEUR STOCK ACHAT", "P.V", "VALEUR STOCK VENTE"
               
                dtm.addRow(new Object[]{
                    
     rs.getLong("idpro")+"   "  , rs.getString("cb")+"   "  , "   "+rs.getString("desi") , this.nf3.format(rs.getLong("qte"))+"   " , this.nf3.format(rs.getLong("pa"))+"   "  ,
          this.nf3.format((rs.getLong("pa") * rs.getLong("qte")))+"   "  , this.nf3.format(rs.getLong("pv"))+"   "  , this.nf3.format((rs.getLong("pv") * rs.getLong("qte")))+"   " 
                
                });
                
                }
                
            }
            
            
            
            // end les produits fini :
            
            
            // debut derive produit :
            
                rs = stmt.executeQuery(sql_0) ;
                while(rs.next()){
                
              // hasmap :
                HashMap<String, Object> m = new HashMap<>() ;
                
                   m.put("id",  rs.getString("idpro")+"   ") ;
                   m.put("cb", rs.getString("cb")+"   ") ;
                   m.put("desi", "   "+rs.getString("desi")) ;
                   m.put("qte", this.nf3.format(rs.getLong("qte"))+"   ") ;
                   m.put("pa", this.nf3.format(rs.getLong("pa"))+"   ") ;
                   m.put("vsa", this.nf3.format((rs.getLong("pa") * rs.getLong("qte")))+"   ") ;
                   m.put("pv", this.nf3.format(rs.getLong("pv"))+"   ") ;
                   m.put("vsv", this.nf3.format((rs.getLong("pv") * rs.getLong("qte")))+"  ") ;
                   
                   this.bonList.add(m) ;
                
                
                this.t_1 += (rs.getLong("pa") * rs.getLong("qte")) ;
                this.t_2 += (rs.getLong("pv") * rs.getLong("qte")) ;
                
    // "ID", "CODE BARRE", "DESCRIPTION", "QTE ENTREE", "P.A", "VALEUR STOCK ACHAT", "P.V", "VALEUR STOCK VENTE"
               
                dtm.addRow(new Object[]{
                    
     rs.getLong("idpro")+"   "  , rs.getString("cb")+"   "  , "   "+rs.getString("desi") , this.nf3.format(rs.getLong("qte"))+"   " , this.nf3.format(rs.getLong("pa"))+"   "  ,
                    this.nf3.format((rs.getLong("pa") * rs.getLong("qte")))+"   "  , this.nf3.format(rs.getLong("pv"))+"   "  , this.nf3.format((rs.getLong("pv") * rs.getLong("qte")))+"   " 
                
                });
                
               
                
            }
            
            
            
            // end derive produit :
            
            
            
            
            
           
           this.t1.setText(this.nf3.format(this.t_1)); 
           this.t2.setText(this.nf3.format(this.t_2));
           
           
           
           
      //STEP 6: Clean-up environment
                 
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
     
       
                          // end acces au data-center :
                          
                          
                          
            }catch(Exception e){
                
                
                JOptionPane.showMessageDialog(null, "CHOISIR LA PERIODE !!") ;
                
            }
            
            
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
         
        try{
                
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\stock_etat.jrxml")) ;
              
            
            JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(this.bonList) ;
            
            
            Map<String, Object> para = new HashMap<>() ;
            
            // para.put("data", jrbean);
            
            para.put("titre","ETAT ENTREE STOCK SUR UNE PERIODE") ;
            para.put("op","OP : "+this.op) ; 
            para.put("magasin","MAGASIN : "+this.mg.getSelectedItem().toString()) ;
            para.put("periode","PERIODE : DU "+this.dte1+" AU : "+this.dte2) ;
            para.put("f","FAMILLE : "+this.f.getSelectedItem().toString()) ;
            para.put("sf","SOUS FAMILLE : "+this.sf.getSelectedItem().toString()) ;
            para.put("ta","TOTAL V.S.A : "+this.t1.getText()) ;
            para.put("tv","TOTAL V.S.V : "+this.t2.getText()) ;
           
            para.put("data", data) ;
      
            
         // para.put("Total", "TOTAL MONTANT : "+this.nf3.format(this.mtt)) ;
           
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource()) ;
            
            JasperViewer.viewReport(print, false);
            
                
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage()) ;
            }
            
        this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Stock_periodique_yaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock_periodique_yaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock_periodique_yaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock_periodique_yaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock_periodique_yaya().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox f;
    private javax.swing.JTextField h1;
    private javax.swing.JTextField h2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox mg;
    private javax.swing.JComboBox sf;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    // End of variables declaration//GEN-END:variables
}
