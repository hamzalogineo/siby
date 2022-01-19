/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.Magasin.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HAMZA
 */
public class Departement extends javax.swing.JFrame {

    /**
     * Creates new form Departement
     */
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
    String login ;
    String role ;
    Integer id = 0 ;
    
    public Departement() {
        initComponents();
    }
    
    
    public Departement(String login, String role){
        initComponents() ;
        
        this.setLocationRelativeTo(null) ;
        this.login = login ;
        this.role = role ;
        
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

                  for (int i = 0; i < this.jTable1.getModel().getColumnCount(); i++) {
                    this.jTable1.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
                  DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                     dtm1.addRow(new Object[]{1 , "xxxxxxxxxxxxxxxxxxxx","100.000","150.000",0}) ;
        
     //   -------------------------------------------------------------------
                   
                     dtm1.setRowCount(0)  ;
                     
                     
                       if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR") || this.role.equalsIgnoreCase("ADMINISTRATEUR")){
                      
                       
                      
                               }else{
                           
                                            /*    
                                         this.an.setEnabled(false) ;
                                         this.an1.setEnabled(false) ;
                                         this.pyer.setEnabled(false) ;
                                             */
                           
                           
                                      }
                      
                      
                      
                      
                      this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 3) ;
        
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        if ("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        } else {
            setBackground(Color.gray);
            setForeground(Color.WHITE);
        }   
        
        if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
            
          
        return this ;
        
    }   
}) ;

                     
                     
                    Connection conn = null;
                    Statement stmt = null;
                    PreparedStatement ps = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      conn.setAutoCommit(false) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
        // je crai ma requete
      
      String sql = null ;
      ResultSet rs = null ;
      
      int vy = 0 ;
      
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      
       
          
         sql = "select * from departements order by description asc " ;
         ps = conn.prepareStatement(sql) ;
         rs = ps.executeQuery() ;
         while(rs.next()){
             // "DATE", "ID", "DESCRIPTION", "ACTIVER", "LOGIN"
             dtm1.addRow(new Object[]{
         sdfT.format(rs.getTimestamp("datej")) , rs.getInt("id") , rs.getString("description") , rs.getString("type") , rs.getString("login")
             });
             
         }
          
         
     
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close();
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
                             
                     
        jButton4.setVisible(false) ;
        jButton5.setVisible(false) ;
        
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
        depart = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        aj = new javax.swing.JButton();
        mod = new javax.swing.JButton();
        sup = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rdepart = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "COMPTE SORTIE DE STOCK", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("        DESCRIPTION");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));

        aj.setBackground(new java.awt.Color(51, 51, 255));
        aj.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        aj.setForeground(new java.awt.Color(255, 255, 255));
        aj.setText("AJOUTER");
        aj.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajActionPerformed(evt);
            }
        });

        mod.setBackground(new java.awt.Color(51, 51, 255));
        mod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mod.setForeground(new java.awt.Color(255, 255, 255));
        mod.setText("MODIFIER");
        mod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modActionPerformed(evt);
            }
        });

        sup.setBackground(new java.awt.Color(51, 51, 255));
        sup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sup.setForeground(new java.awt.Color(255, 255, 255));
        sup.setText("VEILLEUSE");
        sup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("        RECHERCHER");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));

        rdepart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rdepartKeyReleased(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DATE", "ID", "DESCRIPTION", "ACTIVER", "LOGIN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(170);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(170);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(280);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(280);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(90);
        }

        jButton4.setBackground(new java.awt.Color(51, 51, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("COMPTE DEPARTEMENT");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 51, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("TOUT DEPARTEMENT");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(119, 119, 119)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(rdepart, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(247, 247, 247)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(128, 128, 128)
                                    .addComponent(depart, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(143, 143, 143)
                                    .addComponent(sup)
                                    .addGap(18, 18, 18)
                                    .addComponent(aj, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(mod)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(depart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aj, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mod, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sup, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here :
        
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        if(this.jTable1.getSelectedRow() == -1){
              JOptionPane.showMessageDialog(null, "SELECTIONNER UN DEPARTEMENT") ;
          }else{
            
             Compte_fourni_Departement cf = new Compte_fourni_Departement(this.login, this.role, "ch") ; //this.id) ;
                      cf.setVisible(true) ;
            
        }
         
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
         Compte_fourni1_Departement cf = new Compte_fourni1_Departement(this.login, this.role) ;
                      cf.setVisible(true) ;
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void ajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajActionPerformed
        // TODO add your handling code here:
        
        
               String departement = "" ;
               departement = this.depart.getText().replaceAll("'", "''").trim() ;
               
               if(departement.isEmpty()){
                   JOptionPane.showMessageDialog(null, "SAISIR UN DEPARTEMENT SVP") ;
               }else{
                   
                   
                    Connection conn = null;
                    Statement stmt = null;
                    PreparedStatement ps = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      conn.setAutoCommit(false) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
        // je crai ma requete
      
      String sql = null ;
      ResultSet rs = null ;
      
      int vy = 0 ;
      
      sql = "select * from departements where description = '"+departement+"'" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          vy = 1 ;
      }
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      
      String datej = sdf.format(new Date()) ;
      
      
      sql = "insert into departements (description,type,datej,login) values('"+departement+"' , 'OUI' , '"
              +datej+"' , '"+this.login.replaceAll("'", "''")+"')" ;
      stmt.executeUpdate(sql) ;
      
      
      if(vy == 1){
          conn.rollback();
          JOptionPane.showMessageDialog(null, "LE DEPARTEMENT EXISTE DEJA");
      }else if(vy == 0){
      
          conn.commit();
          this.depart.setText("") ;
         
          DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                            dtm1.setRowCount(0) ;
      
      
          
         sql = "select * from departements order by description asc " ;
         ps = conn.prepareStatement(sql) ;
         rs = ps.executeQuery() ;
         while(rs.next()){
             // "DATE", "ID", "DESCRIPTION", "ACTIVER", "LOGIN"
             dtm1.addRow(new Object[]{
         sdfT.format(rs.getTimestamp("datej")) , rs.getInt("id") , rs.getString("description") , rs.getString("type") , rs.getString("login")
             });
             
         }
         
    
      
         
         
         
         
         
     
      
     }
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close();
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
        
        
    }//GEN-LAST:event_ajActionPerformed
String etat ;
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        this.etat = "" ;
        this.id = 0 ;
        this.id = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()) ;
        
        this.depart.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString()) ;
        this.etat = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString() ;
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modActionPerformed
        // TODO add your handling code here:
        
        
               String departement = "" ;
               departement = this.depart.getText().replaceAll("'", "''").trim() ;
               
               if(departement.isEmpty() || this.jTable1.getSelectedRow() == -1){
                   JOptionPane.showMessageDialog(null, "SAISIR UN DEPARTEMENT ET SELECTIONNER DANS LA LISTE SVP") ;
               }else{
                   
                   
                    Connection conn = null;
                    Statement stmt = null;
                    PreparedStatement ps = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      conn.setAutoCommit(false) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
        // je crai ma requete
      
      String sql = null ;
      ResultSet rs = null ;
      
      int vy = 0 ;
      
      sql = "select * from departements where description = '"+departement+"'" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          vy = 1 ;
      }
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      
      String datej = sdf.format(new Date()) ;
      
      /*
      sql = "insert into departements (description,type,datej,login) values('"+departement+"' , 'OUI' , '"
              +datej+"' , '"+this.login.replaceAll("'", "''")+"')" ;
      */
      
      
      sql = "update departements set description = ? where id = ?" ;
      ps = conn.prepareStatement(sql) ;
      ps.setString(1, departement);
      ps.setInt(2, this.id) ;
      
      ps.execute() ;
      
      // stmt.executeUpdate(sql) ;
      
      
      if(vy == 1){
          conn.rollback();
          JOptionPane.showMessageDialog(null, "LE DEPARTEMENT EXISTE DEJA OU PAS DE SELECTION DANS LA LISTE");
      }else if(vy == 0){
      
          conn.commit();
          this.depart.setText("") ;
         
          DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                            dtm1.setRowCount(0) ;
      
      
          
         sql = "select * from departements order by description asc " ;
         ps = conn.prepareStatement(sql) ;
         rs = ps.executeQuery() ;
         while(rs.next()){
             // "DATE", "ID", "DESCRIPTION", "ACTIVER", "LOGIN"
             dtm1.addRow(new Object[]{
         sdfT.format(rs.getTimestamp("datej")) , rs.getInt("id") , rs.getString("description") , rs.getString("type") , rs.getString("login")
             });
             
         }
         
    
      
         
         
         
         
         
     
      
     }
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close();
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
        
        
        
    }//GEN-LAST:event_modActionPerformed

    private void supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supActionPerformed
        // TODO add your handling code here:
         
               
               if(this.jTable1.getSelectedRow() == -1){
                   JOptionPane.showMessageDialog(null, "SELECTIONNER DANS LA LISTE SVP") ;
               }else{
                   
                   
                    Connection conn = null;
                    Statement stmt = null;
                    PreparedStatement ps = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      conn.setAutoCommit(false) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
        // je crai ma requete
      
      String sql = null ;
      ResultSet rs = null ;
      
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      
      String datej = sdf.format(new Date()) ;
      
      /*
      sql = "insert into departements (description,type,datej,login) values('"+departement+"' , 'OUI' , '"
              +datej+"' , '"+this.login.replaceAll("'", "''")+"')" ;
      */
      
      if(this.etat.equalsIgnoreCase("OUI")){
          
      sql = "update departements set type = ? where id = ?" ;
      ps = conn.prepareStatement(sql) ;
      ps.setString(1, "NON");
      ps.setInt(2, this.id) ;
      
      ps.execute() ;
      
      }else if(this.etat.equalsIgnoreCase("NON")){
          
      sql = "update departements set type = ? where id = ?" ;
      ps = conn.prepareStatement(sql) ;
      ps.setString(1, "OUI");
      ps.setInt(2, this.id) ;
      
      ps.execute() ;
          
      }
      
      // stmt.executeUpdate(sql) ;
       
          conn.commit() ;
          this.depart.setText("") ;
         
          DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                            dtm1.setRowCount(0) ;
      
      
          
         sql = "select * from departements order by description asc " ;
         ps = conn.prepareStatement(sql) ;
         rs = ps.executeQuery() ;
         while(rs.next()){
             // "DATE", "ID", "DESCRIPTION", "ACTIVER", "LOGIN"
             dtm1.addRow(new Object[]{
         sdfT.format(rs.getTimestamp("datej")) , rs.getInt("id") , rs.getString("description") , rs.getString("type") , rs.getString("login")
             });
             
         }
         
    
      
         
   
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close();
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
        
        
        
        
        
    }//GEN-LAST:event_supActionPerformed

    private void rdepartKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdepartKeyReleased
        // TODO add your handling code here:
        
        String desc = "" ;
               desc = this.rdepart.getText().replaceAll("'", "''").trim() ;
               
                    Connection conn = null;
                    Statement stmt = null;
                    PreparedStatement ps = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      conn.setAutoCommit(false) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
        // je crai ma requete
      
      String sql = null ;
      ResultSet rs = null ;
      
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      
      
      
       
          conn.commit() ;
          this.depart.setText("") ;
         
          DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                            dtm1.setRowCount(0) ;
      
      sql = "select * from departements where description like ? order by description asc" ;
      ps = conn.prepareStatement(sql) ;
      ps.setString(1, "%"+desc+"%");
         rs = ps.executeQuery() ;
         while(rs.next()){
             // "DATE", "ID", "DESCRIPTION", "ACTIVER", "LOGIN"
             dtm1.addRow(new Object[]{
         sdfT.format(rs.getTimestamp("datej")) , rs.getInt("id") , rs.getString("description") , rs.getString("type") , rs.getString("login")
             });
             
         }
         
    
      
         
   
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close();
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
                   
        
    }//GEN-LAST:event_rdepartKeyReleased

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
            java.util.logging.Logger.getLogger(Departement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Departement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Departement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Departement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Departement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aj;
    private javax.swing.JTextField depart;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton mod;
    private javax.swing.JTextField rdepart;
    private javax.swing.JButton sup;
    // End of variables declaration//GEN-END:variables
}
