/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.ProductionMp.JDBC_DRIVER;
import static frontend.Rubrique.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HAMZA
 */
public class Type_Pro_Pl extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
    
    
      String login = "" ;
      long idmp = 0 ;
      int  idp = 0 ;
      String dtec ;
      String produit ;
      long pa ;
      long pu ;
      String cb ;
      
      
    
    public Type_Pro_Pl() {
        initComponents();
    }
    
    public Type_Pro_Pl(String login){
        initComponents() ;
        
         this.login = login ;
        
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
        
       
       
        
        //
       
            this.jTable2.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable2.getTableHeader().setOpaque(false) ; 
            this.jTable2.getTableHeader().setBackground(Color.black) ; 
          
        //    this.jTable1.setBackground(Color.white) ;
        
       
            this.jTable2.getTableHeader().setForeground(Color.white) ;
        
            this.jTable2.setRowHeight(25) ;
              
        
             
                  for (int i = 0; i < this.jTable2.getModel().getColumnCount(); i++) {
                    this.jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
        
        
        
        //  ---------  2è choix
              
        
        
        
        
       //   ---------------
        
        
        //
        
       
        
     
        
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        
      
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm2.setRowCount(0) ;
        
       
                       Connection conn = null;
                       Statement stmt = null;
       
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
      
        
       String sql ;
      
         sql= "SELECT * FROM matieres_p ORDER BY description" ;
      
         ResultSet rs = stmt.executeQuery(sql);
      
      
        while(rs.next()){
        
    
        
        
        
        dtm1.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX DE VENTE"      

            
       rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") 
        
        }) ;
  
       
     }
      
        //
        
            String sql10 ;
      
         sql10= "SELECT * FROM produits_f ORDER BY description" ;
      
         ResultSet rs10 = stmt.executeQuery(sql10);
      
      
        while(rs10.next()){
        
    
        
        
        
        dtm1.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX DE VENTE"      

            
       rs10.getString("code_barre") , rs10.getString("description")  ,
       rs10.getLong("libelle") , rs10.getLong("pu") 
        
        }) ;
  
       
     }
        
        
        dtm2.setRowCount(0) ;
        
          sql = "" ;
                 sql = "select * from produits_pl , matieres_p "
                     + "where matieres_p.id = produits_pl.matieres_id order by description ASC" ;
                 ResultSet rs1 = stmt.executeQuery(sql) ;
                 
                 while(rs1.next()){
                 
                     dtm2.addRow(new Object[]{
                     rs1.getString("matieres_p.code_barre") ,
                     rs1.getString("matieres_p.description") ,
                     rs1.getString("matieres_p.prx_a_unite") ,
                     rs1.getString("matieres_p.prx_v_unite")  
                             
                     
                     }) ;
                     
                     
                 }
                 
                 
                 
                 sql = "select * from produits_pl , produits_f "
                     + "where produits_f.id = produits_pl.produits_id order by description ASC" ;
                 ResultSet rs2 = stmt.executeQuery(sql) ;
                 
                 while(rs2.next()){
                 
                     dtm2.addRow(new Object[]{
                     rs2.getString("produits_f.code_barre") ,
                     rs2.getString("produits_f.description") ,
                     rs2.getString("produits_f.libelle") ,
                     rs2.getString("produits_f.pu") 
                             
                     
                     }) ;
                     
                     
                 }
                 
                 
      
        
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        desc1 = new javax.swing.JTextField();
        cb1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        desc2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONFIGURATION DE LA LISTE DES PRODUITS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18))); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX VENTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(3);
        }

        desc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desc1KeyReleased(evt);
            }
        });

        cb1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cb1KeyReleased(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX VENTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable2.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(3);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(3);
        }

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("AJOUTER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("SUPPRIMER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        desc2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desc2KeyReleased(evt);
            }
        });

        jLabel1.setText("DESCRIPTION");

        jLabel2.setText("CODE BARRE");

        jLabel3.setText("  DESCRIPTION                                                                                  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(desc1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cb1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desc2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(desc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(desc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:  
        
        this.jTable2.getSelectionModel().clearSelection() ;
        
        this.produit = "" ;
        this.pa = 0 ;
        this.pu = 0 ;
        this.cb = "" ;
        
        
        this.produit = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString().replaceAll("'", "''") ;
        this.cb = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString().replaceAll("'", "''") ;
        this.pa = Long.parseLong(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString()) ;
        this.pu = Long.parseLong(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString()) ;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
            Date date = new Date() ;
            
            this.dtec = "" ;
            
            this.dtec = sdf.format(date) ;
            this.idmp = 0 ;
            this.idp = 0 ;
            
        
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
      
      //je crai ma requete
      
     // this.sf.removeAllItems() ;
     // this.sf.addItem("CHOISIR UNE SOUS FAMILLE") ;
       
        String sql ;
      
       sql = "SELECT distinct id FROM matieres_p WHERE description = '"+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString().replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
  
       this.idmp = rs.getLong("id") ;
          
         
       
     }
    
     
        
       String sql2 ;
      
       sql2 = "SELECT distinct id FROM produits_f WHERE description = '"+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString().replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
  
       this.idp = rs2.getInt("id") ;  
          
         
       
     }
    
     
      
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs2.close();
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
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
         this.jTable1.getSelectionModel().clearSelection() ;
         
         
            this.idmp = 0 ;
            this.idp = 0 ;
            
        
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
      
      //je crai ma requete
      
     // this.sf.removeAllItems() ;
     // this.sf.addItem("CHOISIR UNE SOUS FAMILLE") ;
       
        String sql ;
      
       sql = "SELECT distinct id FROM matieres_p WHERE description = '"+this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString().replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
  
       this.idmp = rs.getLong("id") ;
          
         
       
     }
    
     
        
       String sql2 ;
      
       sql2 = "SELECT distinct id FROM produits_f WHERE description = '"+this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString().replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
  
       this.idp = rs2.getInt("id") ;  
          
         
       
     }
    
     
      
  //   JOptionPane.showMessageDialog(this , "THIS.IDMP = "+this.idmp+" THIS.IDP = "+this.idp) ;
                
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs2.close();
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
        
         
         
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void desc1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desc1KeyReleased
        // TODO add your handling code here:
        
         String d1 = this.desc1.getText().trim().replaceAll("'", "''") ;
        
        if("".equalsIgnoreCase(d1)){
            
        }else{
            
            //
        
       Connection conn = null;
       Statement stmt = null;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
        // je crai ma requete
      
      
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
                           dtm.setRowCount(0) ;
                           
         
         String sql ;
      
         sql= "SELECT * FROM matieres_p WHERE description LIKE '%"+d1+"%' ORDER BY description" ;
      
         ResultSet rs = stmt.executeQuery(sql);
      
      
        while(rs.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX DE VENTE"      

            
       rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") 
        
        }) ;
  
       
     }
      
    
      String sql10 ;
      
         sql10= "SELECT * FROM produits_f WHERE description LIKE '%"+d1+"%'" ;
      
         ResultSet rs10 = stmt.executeQuery(sql10);
      
      
        while(rs10.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX DE VENTE"      

            
       rs10.getString("code_barre") , rs10.getString("description")  ,
       rs10.getLong("libelle") , rs10.getLong("pu") 
        
        }) ;
  
       
     }
      
      
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
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
        
        
            
            
        }
        
        
        
        
    }//GEN-LAST:event_desc1KeyReleased

    private void cb1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb1KeyReleased
        // TODO add your handling code here:
        
        
        String d1 = this.cb1.getText().trim().replaceAll("'", "''") ;
        
        if("".equalsIgnoreCase(d1)){
            
        }else{
            
            //
        
       Connection conn = null;
       Statement stmt = null;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
        // je crai ma requete
      
      
         
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
                           
         
         String sql ;
      
         sql= "SELECT * FROM matieres_p WHERE code_barre LIKE '%"+d1+"%'" ;
      
         ResultSet rs = stmt.executeQuery(sql);
      
      
        while(rs.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX DE VENTE"      

            
       rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") 
        
        }) ;
  
       
     }
      
     String sql10 ;
      
         sql10= "SELECT * FROM produits_f WHERE code_barre LIKE '%"+d1+"%'" ;
      
         ResultSet rs10 = stmt.executeQuery(sql10);
      
      
        while(rs10.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX DE VENTE"      

            
       rs10.getString("code_barre") , rs10.getString("description")  ,
       rs10.getLong("libelle") , rs10.getLong("pu") 
        
        }) ;
  
       
     }
      
     
      
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
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
        
        
            
            
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_cb1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Integer test = 0 ;
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "OPERATION IMPOSSIBLE");
        }else{
            
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
      
      String query ;
             query = "select * from produits_pl where recherche = '"+this.produit+"'" ;
             ResultSet r ;
                       r = stmt.executeQuery(query) ;
                       
                       while(r.next()){
                           test = 1 ;
                       }
                       
                       if(test == 0){
      
     
       if(stmt.executeUpdate("insert into produits_pl(matieres_id, produits_id,dtec,admin,recherche,pa,pu,cb) VALUES("+this.idmp+" , "
               +this.idp+" , '"+this.dtec+"' , '"+this.login+"' , '"+this.produit+"' , "+this.pa+" , "+this.pu+" , '"+this.cb+"')") >= 1){
           
           DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
           dtm.setRowCount(0);
           
          String sql = "" ;
                 sql = "select * from produits_pl , matieres_p "
                     + "where matieres_p.id = produits_pl.matieres_id order by description ASC" ;
                 ResultSet rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                 
                     dtm.addRow(new Object[]{
                     rs.getString("matieres_p.code_barre") ,
                     rs.getString("matieres_p.description") ,
                     rs.getString("matieres_p.prx_a_unite") ,
                     rs.getString("matieres_p.prx_v_unite")  
                             
                     
                     }) ;
                     
                     
                 }
                 
                 
                 sql = "select * from produits_pl , produits_f "
                     + "where produits_f.id = produits_pl.produits_id order by description ASC" ;
                 ResultSet rs2 = stmt.executeQuery(sql) ;
                 
                 while(rs2.next()){
                 
                     dtm.addRow(new Object[]{
                     rs2.getString("produits_f.code_barre") ,
                     rs2.getString("produits_f.description") ,
                     rs2.getString("produits_f.libelle") ,
                     rs2.getString("produits_f.pu") 
                             
                     
                     }) ;
                     
                     
                 }
                 
                 
          
       }
       
                       }else if(test == 1){
                           JOptionPane.showMessageDialog(this, "LES DOUBLONS NE SONT PAS ACCEPTES !!!") ;
                       }
      
       
      //STEP 6: Clean-up environment
   // rs2.close();
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
        
            
            
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable2.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "SELECTIONNER LE PRODUITS A DROITE SVP !!! ") ;
        }else{
            
            DefaultTableModel dtm1 = (DefaultTableModel) this.jTable2.getModel() ;
              
             Connection conn = null ;
             Statement  stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      // STEP 4: Execute a query
      // System.out.println("Creating statement...") ;
      
      stmt = conn.createStatement();
      
      if(this.idmp > 0){
           if(stmt.executeUpdate("delete from produits_pl where matieres_id = "+this.idmp) >= 1){
          
          dtm1.removeRow(this.jTable2.getSelectedRow()) ;
                
      }
          
      }else if(this.idp > 0){
          
          if(stmt.executeUpdate("delete from produits_pl where produits_id = "+this.idp) >= 1){
          
          dtm1.removeRow(this.jTable2.getSelectedRow()) ;
                
      }    
      }
      
     
      
     //  STEP 6: Clean-up environment
    //   rs2.close() ;
      
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
        
            
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void desc2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desc2KeyReleased
        // TODO add your handling code here: 
        
        this.idmp = 0 ;
        this.idp = 0 ;
        
         String d1 = this.desc2.getText().trim().replaceAll("'", "''") ;
        
        if("".equalsIgnoreCase(d1)){
            
            }else{
            
            //
        
       Connection conn = null;
       Statement stmt = null;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
        // je crai ma requete
      
      
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
         
                           dtm.setRowCount(0) ;
                           
         
       String sql ;

                sql= "SELECT * FROM produits_pl WHERE recherche like '%"+d1+"%' order by recherche ASC" ;

                ResultSet rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    
                    dtm.addRow(new Object[]{
                    
                        rs.getString("cb") , rs.getString("recherche") , rs.getLong("pa") , rs.getLong("pu")
                    
                    }) ;
                    
                }
                 
                
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
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
        
        
            
            
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_desc2KeyReleased

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
            java.util.logging.Logger.getLogger(Type_Pro_Pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Type_Pro_Pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Type_Pro_Pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Type_Pro_Pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Type_Pro_Pl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cb1;
    private javax.swing.JTextField desc1;
    private javax.swing.JTextField desc2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
