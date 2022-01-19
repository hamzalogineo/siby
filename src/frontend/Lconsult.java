/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.StatistiqueFinal.JDBC_DRIVER;
import static frontend.TransfertOp.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HAMZA
 */
public class Lconsult extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      
      String role ;
      
    public Lconsult() {
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
        
       
        
     
        
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
        
        
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm1.setRowCount(0) ;
        
       
        this.jDateChooser1.setDate(new Date()) ;
        this.h1.setText("00:00") ;
        this.jDateChooser2.setDate(new Date()) ;
        this.h2.setText("23:59:59") ;
        this.jButton1.setVisible(false) ;
        
        
        
        
          Connection conn = null ;
          Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
     String query = null ;
     ResultSet resultat = null ;
     
     query = "select login from comptes_u " ;
     resultat = stmt.executeQuery(query) ;
     while(resultat.next()){
         this.util.addItem(new String(resultat.getString("login"))) ;
     }
     
      
      
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      
      resultat.close();
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
    
    
    
    
    public Lconsult(String role){
        
        
        initComponents();
        
        this.role = role ;
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
        
       
        
     
        
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
        
        
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm1.setRowCount(0) ;
        
       
        this.jDateChooser1.setDate(new Date()) ;
        this.h1.setText("00:00") ;
        this.jDateChooser2.setDate(new Date()) ;
        this.h2.setText("23:59:59") ;
        this.jButton1.setVisible(false) ;
        
        
        
        
          Connection conn = null ;
          Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
     String query = null ;
     ResultSet resultat = null ;
     
     query = "select login from comptes_u " ;
     resultat = stmt.executeQuery(query) ;
     while(resultat.next()){
         this.util.addItem(new String(resultat.getString("login"))) ;
     }
     
     
     if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR")){
         
     }else{
         
     this.util.setSelectedItem(new String("TOUT")) ;
     this.util.setEnabled(false) ;
         
     }
     
      
      
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      
      resultat.close();
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
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        h2 = new javax.swing.JTextField();
        h1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        motif = new javax.swing.JTextField();
        util = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTE CONSULTATION DES OPERATIONS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel1.setText("DU :");

        jLabel2.setText("HEURE");

        jLabel3.setText("AU :");

        jLabel4.setText("HEURE");

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

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DATE & HEURE", "N°", "T", "A. CFA", "CFA", "N. CFA", "A. EURO", "EURO", "N. EURO", "A. USD", "USD", "N. USD", "LOGIN", "MOTIF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(160);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(160);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(20);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(9).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(10).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(11).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(11).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(12).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(12).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(13).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(13).setMaxWidth(150);
        }

        motif.setText("MOTIF");
        motif.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                motifFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                motifFocusLost(evt);
            }
        });
        motif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                motifKeyReleased(evt);
            }
        });

        util.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        util.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUT" }));
        util.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        util.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utilActionPerformed(evt);
            }
        });

        jLabel5.setText("UTILISATEUR ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(util, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(113, 113, 113)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(163, 163, 163)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(motif))
                        .addGap(29, 29, 29)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 183, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(motif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(util, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void motifFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_motifFocusGained
        // TODO add your handling code here:
        
        String motif = this.motif.getText() ;
        
        if(motif.equalsIgnoreCase("MOTIF")){
        
        
        this.motif.setText("") ;
        
        }
        
    }//GEN-LAST:event_motifFocusGained

    private void motifFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_motifFocusLost
        // TODO add your handling code here:
        
        String motif = this.motif.getText() ;
        
        if(motif.equals("") || motif.equals("MOTIF")){
            this.motif.setText("MOTIF") ;
        }
        
    }//GEN-LAST:event_motifFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ; 
            
       
        
            Connection conn = null;
            Statement stmt = null;
            PreparedStatement pst = null ;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
     DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                       dtm.setRowCount(0) ;
      
      String sql = null ;
      ResultSet rs = null ;
      
      // consultation operation depot retrait :
     
      sql = "select dtec,id,mtt,admin,motif,type,a_mt from depot_retrait where dtec between ? and ?" ;
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, dte1) ;
      pst.setString(2, dte2) ;
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if("DEPOT".equalsIgnoreCase(rs.getString("type"))){
              
          dtm.addRow(new Object[]{
// "DATE & HEURE", "N°", "OPERATION", "A. CFA", "CFA", "N. CFA", "A. EURO", "EURO", "N. EURO", "A. USD", "USD", "N. USD", "LOGIN", "MOTIF"          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"D",nf3.format(rs.getLong("a_mt")),"+ "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_mt")+rs.getLong("mtt")),"","","","","","",rs.getString("admin") ,
          rs.getString("motif")
              
          });
          
          }else if("RETRAIT".equalsIgnoreCase(rs.getString("type"))){
              
              dtm.addRow(new Object[]{
          
          // "DATE & HEURE", "N°", "OPERATION", "A. CFA", "CFA", "N. CFA", "A. EURO", "EURO", "N. EURO", "A. USD", "USD", "N. USD", "LOGIN", "MOTIF"          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"R",nf3.format(rs.getLong("a_mt")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_mt")-rs.getLong("mtt")),"","","","","","",rs.getString("admin") ,
          rs.getString("motif")
              
          });
              
          }
          
      }
      
      
      // end :
      
      
      // consultation operation echange :
      
     
      
      sql = "select dtec,id,mtt_d,depart,mtt_a,arrive,admin,a_c,a_e,a_d from echange_xe where dtec between ? and ?" ;
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, dte1) ;
      pst.setString(2, dte2) ;
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if("FCFA ECO".equalsIgnoreCase(rs.getString("depart")) && "EURO".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"- "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_c")-rs.getLong("mtt_d")),nf3.format(rs.getLong("a_e")),"+ "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("a_e")+rs.getLong("mtt_a")),"","","",rs.getString("admin") ,
          "   "
              
          });
          
          }else if("FCFA ECO".equalsIgnoreCase(rs.getString("depart")) && "DOLLAR".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"- "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_c")-rs.getLong("mtt_d")),"","","",nf3.format(rs.getLong("a_d")),"+ "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("mtt_a")+rs.getLong("a_d")),rs.getString("admin") ,
          "   "
              
          });
          
          }else if("EURO".equalsIgnoreCase(rs.getString("depart")) && "FCFA ECO".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"+ "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("mtt_a")+rs.getLong("a_c")),nf3.format(rs.getLong("a_e")),"- "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_e")-rs.getLong("mtt_d")),"","","",rs.getString("admin") ,
          "   "
              
          });
          
          }else if("DOLLAR".equalsIgnoreCase(rs.getString("depart")) && "FCFA ECO".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"+ "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("mtt_a")+rs.getLong("a_c"))," "," "," ",nf3.format(rs.getLong("a_d")),"- "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_d")-rs.getLong("mtt_d")),rs.getString("admin") ,
          "   "
              
          });
          
          } 
          
          
          
          
      }
      
      
      
      // end :
      
       
      
      // consultation java pour les transferds :
      
      sql = "select dtec,id,mtt,devise,admin,motif,a_cfa,a_eu,a_dol from virement where dtec between ? and ?" ;
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, dte1) ;
      pst.setString(2, dte2) ;
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if("FRANC CFA".equalsIgnoreCase(rs.getString("devise"))){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"T",nf3.format(rs.getLong("a_cfa")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_cfa")-rs.getLong("mtt")),"","","","","","",rs.getString("admin") ,
          rs.getString("motif")
              
          }) ;
          
          }else if("EURO".equalsIgnoreCase(rs.getString("devise"))){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"T"," "," "," ",nf3.format(rs.getLong("a_eu")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_eu")-rs.getLong("mtt"))," "," "," ",rs.getString("admin") ,
          rs.getString("motif")
              
          });
          
          }else if("DOLLAR".equalsIgnoreCase(rs.getString("devise"))){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"T"," "," "," "," "," "," ",nf3.format(rs.getLong("a_dol")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_dol")-rs.getLong("mtt")),rs.getString("admin") ,
          rs.getString("motif")
              
          });
          
          }
          
      }
      
      
      // end :
      
      
      
      rs.close() ;
      stmt.close() ;
      pst.close() ;
      conn.close() ;
     
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
             
              DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                       dtm.setRowCount(0) ;
             
            JOptionPane.showMessageDialog(null, "SELECTIONNER LES DEUX DATES SVP") ;
             
             
         }
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void motifKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_motifKeyReleased
        // TODO add your handling code here:
        
        String motif = this.motif.getText().replaceAll("'", "''").trim() ;
        
        if(motif.equals("") && this.user.equalsIgnoreCase("TOUT")){
            
            
               try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ; 
            
       
        
            Connection conn = null;
            Statement stmt = null;
            PreparedStatement pst = null ;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
     DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                       dtm.setRowCount(0) ;
      
      String sql = null ;
      ResultSet rs = null ;
      
      // consultation operation depot retrait :
     
      sql = "select dtec,id,mtt,admin,motif,type,a_mt from depot_retrait where dtec between ? and ?" ;
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, dte1) ;
      pst.setString(2, dte2) ;
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if("DEPOT".equalsIgnoreCase(rs.getString("type"))){
              
          dtm.addRow(new Object[]{
// "DATE & HEURE", "N°", "OPERATION", "A. CFA", "CFA", "N. CFA", "A. EURO", "EURO", "N. EURO", "A. USD", "USD", "N. USD", "LOGIN", "MOTIF"          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"D",nf3.format(rs.getLong("a_mt")),"+ "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_mt")+rs.getLong("mtt")),"","","","","","",rs.getString("admin") ,
          rs.getString("motif")
              
          });
          
          }else if("RETRAIT".equalsIgnoreCase(rs.getString("type"))){
              
              dtm.addRow(new Object[]{
          
          // "DATE & HEURE", "N°", "OPERATION", "A. CFA", "CFA", "N. CFA", "A. EURO", "EURO", "N. EURO", "A. USD", "USD", "N. USD", "LOGIN", "MOTIF"          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"R",nf3.format(rs.getLong("a_mt")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_mt")-rs.getLong("mtt")),"","","","","","",rs.getString("admin") ,
          rs.getString("motif")
              
          });
              
          }
          
      }
      
      
      // end :
      
      
      // consultation operation echange :
      
     
      
      sql = "select dtec,id,mtt_d,depart,mtt_a,arrive,admin,a_c,a_e,a_d from echange_xe where dtec between ? and ?" ;
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, dte1) ;
      pst.setString(2, dte2) ;
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if("FCFA ECO".equalsIgnoreCase(rs.getString("depart")) && "EURO".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"+ "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_c")+rs.getLong("mtt_d")),nf3.format(rs.getLong("a_e")),"- "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("a_e")-rs.getLong("mtt_a")),"","","",rs.getString("admin") ,
          "   "
              
          });
          
          }else if("FCFA ECO".equalsIgnoreCase(rs.getString("depart")) && "DOLLAR".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"+ "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_c")+rs.getLong("mtt_d")),"","","",nf3.format(rs.getLong("a_d")),"- "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("a_d")-rs.getLong("mtt_a")),rs.getString("admin") ,
          "   "
              
          });
          
          }else if("EURO".equalsIgnoreCase(rs.getString("depart")) && "FCFA ECO".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"- "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("a_c")-rs.getLong("mtt_a")),nf3.format(rs.getLong("a_e")),"+ "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_e")+rs.getLong("mtt_d")),"","","",rs.getString("admin") ,
          "   "
              
          });
          
          }else if("DOLLAR".equalsIgnoreCase(rs.getString("depart")) && "FCFA ECO".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"- "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("a_c")-rs.getLong("mtt_a"))," "," "," ",nf3.format(rs.getLong("a_d")),"+ "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_d")+rs.getLong("mtt_d")),rs.getString("admin") ,
          "   "
              
          });
          
          } 
          
          
          
          
      }
      
      
      
      // end :
      
       
      
      // consultation java pour les transferds :
      
      sql = "select dtec,id,mtt,devise,admin,motif,a_cfa,a_eu,a_dol from virement where dtec between ? and ?" ;
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, dte1) ;
      pst.setString(2, dte2) ;
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if("FRANC CFA".equalsIgnoreCase(rs.getString("devise"))){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"T",nf3.format(rs.getLong("a_cfa")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_cfa")-rs.getLong("mtt")),"","","","","","",rs.getString("admin") ,
          rs.getString("motif")
              
          }) ;
          
          }else if("EURO".equalsIgnoreCase(rs.getString("devise"))){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"T"," "," "," ",nf3.format(rs.getLong("a_eu")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_eu")-rs.getLong("mtt"))," "," "," ",rs.getString("admin") ,
          rs.getString("motif")
              
          });
          
          }else if("DOLLAR".equalsIgnoreCase(rs.getString("devise"))){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"T"," "," "," "," "," "," ",nf3.format(rs.getLong("a_dol")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_dol")-rs.getLong("mtt")),rs.getString("admin") ,
          rs.getString("motif")
              
          });
          
          }
          
      }
      
      
      // end :
      
      
      
      rs.close() ;
      stmt.close() ;
      pst.close() ;
      conn.close() ;
     
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
             
              DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                       dtm.setRowCount(0) ;
             
            JOptionPane.showMessageDialog(null, "SELECTIONNER LES DEUX DATES SVP") ;
             
             
         }
        
        
        
        
        
        
        
        
            
            
        }else if(motif.isEmpty() == false && this.user.equalsIgnoreCase("TOUT")){
            
            
            
            
            
              try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ; 
            
       
        
            Connection conn = null;
            Statement stmt = null;
            PreparedStatement pst = null ;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
     DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                       dtm.setRowCount(0) ;
      
      String sql = null ;
      ResultSet rs = null ;
      
      // consultation operation depot retrait :
     
      sql = "select dtec,id,mtt,admin,motif,type,a_mt from depot_retrait where dtec between ? and ? and motif like ?" ;
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, dte1) ;
      pst.setString(2, dte2) ;
      pst.setString(3, "%"+motif+"%");
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if("DEPOT".equalsIgnoreCase(rs.getString("type"))){
              
          dtm.addRow(new Object[]{
// "DATE & HEURE", "N°", "OPERATION", "A. CFA", "CFA", "N. CFA", "A. EURO", "EURO", "N. EURO", "A. USD", "USD", "N. USD", "LOGIN", "MOTIF"          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"D",nf3.format(rs.getLong("a_mt")),"+ "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_mt")+rs.getLong("mtt")),"","","","","","",rs.getString("admin") ,
          rs.getString("motif")
              
          });
          
          }else if("RETRAIT".equalsIgnoreCase(rs.getString("type"))){
              
              dtm.addRow(new Object[]{
          
          // "DATE & HEURE", "N°", "OPERATION", "A. CFA", "CFA", "N. CFA", "A. EURO", "EURO", "N. EURO", "A. USD", "USD", "N. USD", "LOGIN", "MOTIF"          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"R",nf3.format(rs.getLong("a_mt")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_mt")-rs.getLong("mtt")),"","","","","","",rs.getString("admin") ,
          rs.getString("motif")
              
          });
              
          }
          
      }
      
      
      // end :
      
      
      // consultation operation echange :
      
     /*
      
      sql = "select dtec,id,mtt_d,depart,mtt_a,arrive,admin,a_c,a_e,a_d from echange_xe where dtec between ? and ?" ;
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, dte1) ;
      pst.setString(2, dte2) ;
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if("FCFA ECO".equalsIgnoreCase(rs.getString("depart")) && "EURO".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"- "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_c")-rs.getLong("mtt_d")),nf3.format(rs.getLong("a_e")),"+ "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("a_e")+rs.getLong("mtt_a")),"","","",rs.getString("admin") ,
          "   "
              
          });
          
          }else if("FCFA ECO".equalsIgnoreCase(rs.getString("depart")) && "DOLLAR".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"- "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_c")-rs.getLong("mtt_d")),"","","",nf3.format(rs.getLong("a_d")),"+ "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("mtt_a")+rs.getLong("a_d")),rs.getString("admin") ,
          "   "
              
          });
          
          }else if("EURO".equalsIgnoreCase(rs.getString("depart")) && "FCFA ECO".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"+ "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("mtt_a")+rs.getLong("a_c")),nf3.format(rs.getLong("a_e")),"- "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_e")-rs.getLong("mtt_d")),"","","",rs.getString("admin") ,
          "   "
              
          });
          
          }else if("DOLLAR".equalsIgnoreCase(rs.getString("depart")) && "FCFA ECO".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"+ "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("mtt_a")+rs.getLong("a_c"))," "," "," ",nf3.format(rs.getLong("a_d")),"- "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_d")-rs.getLong("mtt_d")),rs.getString("admin") ,
          "   "
              
          });
          
          } 
          
          
          
          
      }
      
      */
      
      // end :
      
       
      
      // consultation java pour les transferds :
      
      sql = "select dtec,id,mtt,devise,admin,motif,a_cfa,a_eu,a_dol from virement where dtec between ? and ? and motif like ?" ;
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, dte1) ;
      pst.setString(2, dte2) ;
      pst.setString(3, "%"+motif+"%");
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if("FRANC CFA".equalsIgnoreCase(rs.getString("devise"))){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"T",nf3.format(rs.getLong("a_cfa")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_cfa")-rs.getLong("mtt")),"","","","","","",rs.getString("admin") ,
          rs.getString("motif")
              
          }) ;
          
          }else if("EURO".equalsIgnoreCase(rs.getString("devise"))){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"T"," "," "," ",nf3.format(rs.getLong("a_eu")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_eu")-rs.getLong("mtt"))," "," "," ",rs.getString("admin") ,
          rs.getString("motif")
              
          });
          
          }else if("DOLLAR".equalsIgnoreCase(rs.getString("devise"))){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"T"," "," "," "," "," "," ",nf3.format(rs.getLong("a_dol")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_dol")-rs.getLong("mtt")),rs.getString("admin") ,
          rs.getString("motif")
              
          });
          
          }
          
      }
      
      
      // end :
      
      
      
      rs.close() ;
      stmt.close() ;
      pst.close() ;
      conn.close() ;
     
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
             
              DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                       dtm.setRowCount(0) ;
             
            JOptionPane.showMessageDialog(null, "SELECTIONNER LES DEUX DATES SVP") ;
             
             
         }
        
        
        
        
        
        
            
     //       JOptionPane.showMessageDialog(null, "OK TEST MOTIF : "+motif) ;
            
        }else if(this.user.equalsIgnoreCase("TOUT") == false && motif.equals("")){

            
             try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ; 
            
       
        
            Connection conn = null;
            Statement stmt = null;
            PreparedStatement pst = null ;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
     DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                       dtm.setRowCount(0) ;
      
      String sql = null ;
      ResultSet rs = null ;
      
      // consultation operation depot retrait :
     
      sql = "select dtec,id,mtt,admin,motif,type,a_mt from depot_retrait where dtec between ? and ? and admin = ?" ;
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, dte1) ;
      pst.setString(2, dte2) ;
      pst.setString(3, this.user) ;
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if("DEPOT".equalsIgnoreCase(rs.getString("type"))){
              
          dtm.addRow(new Object[]{
// "DATE & HEURE", "N°", "OPERATION", "A. CFA", "CFA", "N. CFA", "A. EURO", "EURO", "N. EURO", "A. USD", "USD", "N. USD", "LOGIN", "MOTIF"          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"D",nf3.format(rs.getLong("a_mt")),"+ "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_mt")+rs.getLong("mtt")),"","","","","","",rs.getString("admin") ,
          rs.getString("motif")
              
          });
          
          }else if("RETRAIT".equalsIgnoreCase(rs.getString("type"))){
              
              dtm.addRow(new Object[]{
          
          // "DATE & HEURE", "N°", "OPERATION", "A. CFA", "CFA", "N. CFA", "A. EURO", "EURO", "N. EURO", "A. USD", "USD", "N. USD", "LOGIN", "MOTIF"          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"R",nf3.format(rs.getLong("a_mt")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_mt")-rs.getLong("mtt")),"","","","","","",rs.getString("admin") ,
          rs.getString("motif")
              
          });
              
          }
          
      }
      
      
      // end :
      
      
      // consultation operation echange :
      
     
      
      sql = "select dtec,id,mtt_d,depart,mtt_a,arrive,admin,a_c,a_e,a_d from echange_xe where dtec between ? and ? and admin = ?" ;
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, dte1) ;
      pst.setString(2, dte2) ;
      pst.setString(3, this.user) ;
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if("FCFA ECO".equalsIgnoreCase(rs.getString("depart")) && "EURO".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"+ "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_c")+rs.getLong("mtt_d")),nf3.format(rs.getLong("a_e")),"- "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("a_e")-rs.getLong("mtt_a")),"","","",rs.getString("admin") ,
          "   "
              
          });
          
          }else if("FCFA ECO".equalsIgnoreCase(rs.getString("depart")) && "DOLLAR".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"+ "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_c")+rs.getLong("mtt_d")),"","","",nf3.format(rs.getLong("a_d")),"- "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("a_d")-rs.getLong("mtt_a")),rs.getString("admin") ,
          "   "
              
          });
          
          }else if("EURO".equalsIgnoreCase(rs.getString("depart")) && "FCFA ECO".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"- "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("a_c")-rs.getLong("mtt_a")),nf3.format(rs.getLong("a_e")),"+ "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_e")+rs.getLong("mtt_d")),"","","",rs.getString("admin") ,
          "   "
              
          });
          
          }else if("DOLLAR".equalsIgnoreCase(rs.getString("depart")) && "FCFA ECO".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"- "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("a_c")-rs.getLong("mtt_a"))," "," "," ",nf3.format(rs.getLong("a_d")),"+ "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_d")+rs.getLong("mtt_d")),rs.getString("admin") ,
          "   "
              
          });
          
          } 
          
          
          
          
      }
      
      
      
      // end :
      
       
      
      // consultation java pour les transferds :
      
      sql = "select dtec,id,mtt,devise,admin,motif,a_cfa,a_eu,a_dol from virement where dtec between ? and ? and admin = ?" ;
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, dte1) ;
      pst.setString(2, dte2) ;
      pst.setString(3, this.user) ;
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if("FRANC CFA".equalsIgnoreCase(rs.getString("devise"))){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"T",nf3.format(rs.getLong("a_cfa")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_cfa")-rs.getLong("mtt")),"","","","","","",rs.getString("admin") ,
          rs.getString("motif")
              
          }) ;
          
          }else if("EURO".equalsIgnoreCase(rs.getString("devise"))){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"T"," "," "," ",nf3.format(rs.getLong("a_eu")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_eu")-rs.getLong("mtt"))," "," "," ",rs.getString("admin") ,
          rs.getString("motif")
              
          });
          
          }else if("DOLLAR".equalsIgnoreCase(rs.getString("devise"))){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"T"," "," "," "," "," "," ",nf3.format(rs.getLong("a_dol")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_dol")-rs.getLong("mtt")),rs.getString("admin") ,
          rs.getString("motif")
              
          });
          
          }
          
      }
      
      
      // end :
      
      
      
      rs.close() ;
      stmt.close() ;
      pst.close() ;
      conn.close() ;
     
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
             
              DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                       dtm.setRowCount(0) ;
             
            JOptionPane.showMessageDialog(null, "SELECTIONNER LES DEUX DATES SVP") ;
             
             
         }
        
        
        
        
        
            
            
        }else if(this.user.equalsIgnoreCase("TOUT") == false && motif.equals("") == false){
            
            
            
            
              try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ; 
            
       
        
            Connection conn = null;
            Statement stmt = null;
            PreparedStatement pst = null ;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
     DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                       dtm.setRowCount(0) ;
      
      String sql = null ;
      ResultSet rs = null ;
      
      // consultation operation depot retrait :
     
      sql = "select dtec,id,mtt,admin,motif,type,a_mt from depot_retrait where dtec between ? and ? and motif like ? and admin = ?" ;
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, dte1) ;
      pst.setString(2, dte2) ;
      pst.setString(3, "%"+motif+"%");
      pst.setString(4, this.user);
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if("DEPOT".equalsIgnoreCase(rs.getString("type"))){
              
          dtm.addRow(new Object[]{
// "DATE & HEURE", "N°", "OPERATION", "A. CFA", "CFA", "N. CFA", "A. EURO", "EURO", "N. EURO", "A. USD", "USD", "N. USD", "LOGIN", "MOTIF"          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"D",nf3.format(rs.getLong("a_mt")),"+ "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_mt")+rs.getLong("mtt")),"","","","","","",rs.getString("admin") ,
          rs.getString("motif")
              
          });
          
          }else if("RETRAIT".equalsIgnoreCase(rs.getString("type"))){
              
              dtm.addRow(new Object[]{
          
          // "DATE & HEURE", "N°", "OPERATION", "A. CFA", "CFA", "N. CFA", "A. EURO", "EURO", "N. EURO", "A. USD", "USD", "N. USD", "LOGIN", "MOTIF"          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"R",nf3.format(rs.getLong("a_mt")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_mt")-rs.getLong("mtt")),"","","","","","",rs.getString("admin") ,
          rs.getString("motif")
              
          });
              
          }
          
      }
      
      
      // end :
      
      
      // consultation operation echange :
      
     /*
      
      sql = "select dtec,id,mtt_d,depart,mtt_a,arrive,admin,a_c,a_e,a_d from echange_xe where dtec between ? and ?" ;
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, dte1) ;
      pst.setString(2, dte2) ;
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if("FCFA ECO".equalsIgnoreCase(rs.getString("depart")) && "EURO".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"- "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_c")-rs.getLong("mtt_d")),nf3.format(rs.getLong("a_e")),"+ "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("a_e")+rs.getLong("mtt_a")),"","","",rs.getString("admin") ,
          "   "
              
          });
          
          }else if("FCFA ECO".equalsIgnoreCase(rs.getString("depart")) && "DOLLAR".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"- "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_c")-rs.getLong("mtt_d")),"","","",nf3.format(rs.getLong("a_d")),"+ "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("mtt_a")+rs.getLong("a_d")),rs.getString("admin") ,
          "   "
              
          });
          
          }else if("EURO".equalsIgnoreCase(rs.getString("depart")) && "FCFA ECO".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"+ "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("mtt_a")+rs.getLong("a_c")),nf3.format(rs.getLong("a_e")),"- "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_e")-rs.getLong("mtt_d")),"","","",rs.getString("admin") ,
          "   "
              
          });
          
          }else if("DOLLAR".equalsIgnoreCase(rs.getString("depart")) && "FCFA ECO".equalsIgnoreCase(rs.getString("arrive")) ){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"E",nf3.format(rs.getLong("a_c")),"+ "+nf3.format(rs.getLong("mtt_a")),nf3.format(rs.getLong("mtt_a")+rs.getLong("a_c"))," "," "," ",nf3.format(rs.getLong("a_d")),"- "+nf3.format(rs.getLong("mtt_d")),nf3.format(rs.getLong("a_d")-rs.getLong("mtt_d")),rs.getString("admin") ,
          "   "
              
          });
          
          } 
          
          
          
          
      }
      
      */
      
      // end :
      
       
      
      // consultation java pour les transferds :
      
      sql = "select dtec,id,mtt,devise,admin,motif,a_cfa,a_eu,a_dol from virement where dtec between ? and ? and motif like ? and admin = ?" ;
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, dte1) ;
      pst.setString(2, dte2) ;
      pst.setString(3, "%"+motif+"%");
      pst.setString(4, this.user);
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if("FRANC CFA".equalsIgnoreCase(rs.getString("devise"))){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"T",nf3.format(rs.getLong("a_cfa")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_cfa")-rs.getLong("mtt")),"","","","","","",rs.getString("admin") ,
          rs.getString("motif")
              
          }) ;
          
          }else if("EURO".equalsIgnoreCase(rs.getString("devise"))){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"T"," "," "," ",nf3.format(rs.getLong("a_eu")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_eu")-rs.getLong("mtt"))," "," "," ",rs.getString("admin") ,
          rs.getString("motif")
              
          });
          
          }else if("DOLLAR".equalsIgnoreCase(rs.getString("devise"))){
              
          dtm.addRow(new Object[]{
          
          sdf1.format(rs.getTimestamp("dtec")) , rs.getLong("id"),"T"," "," "," "," "," "," ",nf3.format(rs.getLong("a_dol")),"- "+nf3.format(rs.getLong("mtt")),nf3.format(rs.getLong("a_dol")-rs.getLong("mtt")),rs.getString("admin") ,
          rs.getString("motif")
              
          });
          
          }
          
      }
      
      
      // end :
      
      
      
      rs.close() ;
      stmt.close() ;
      pst.close() ;
      conn.close() ;
     
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
             
              DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                       dtm.setRowCount(0) ;
             
            JOptionPane.showMessageDialog(null, "SELECTIONNER LES DEUX DATES SVP") ;
             
             
         }
        
        
        
        
            
            
            
            
        }
        
        
        
        
    }//GEN-LAST:event_motifKeyReleased
String user = "TOUT" ;
    private void utilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utilActionPerformed
        // TODO add your handling code here:
        
        this.user = this.util.getSelectedItem().toString().replaceAll("'", "''") ;
        
        
    }//GEN-LAST:event_utilActionPerformed

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
            java.util.logging.Logger.getLogger(Lconsult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lconsult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lconsult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lconsult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lconsult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField h1;
    private javax.swing.JTextField h2;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField motif;
    private javax.swing.JComboBox util;
    // End of variables declaration//GEN-END:variables
}
