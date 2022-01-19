/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.OpDepot.JDBC_DRIVER;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JOptionPane;
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

 public class OpRetrait1 extends javax.swing.JFrame{

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
    
    
    String loging ;
    Integer rb1 ;
    Integer srb1 ;
    Integer com1 ;
    
    static final String TYPE = "RETRAIT" ;
    
    public OpRetrait1() {
        initComponents() ;
    }
    
    public OpRetrait1(String login){
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        this.loging = login ;
        
        
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
      
        
      String sql ;
      
       sql= "SELECT rub FROM rubrique WHERE NOT type = 'non' ORDER BY rub ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
         this.rb.addItem(rs.getString("rub")) ;
     
     }
     
      String sql2 ;
      
       sql2 = "SELECT perso FROM perso_t WHERE type = 'oui' AND domaine = 'CL' OR domaine = 'CL_PL' ORDER BY perso ASC" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
         
         this.com.addItem(rs2.getString("perso")) ;
     
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
        mt = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        rb = new javax.swing.JComboBox();
        srb = new javax.swing.JComboBox();
        com = new javax.swing.JComboBox();
        motif = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ref = new javax.swing.JTextField();
        sp = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(437, 356));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 51, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPERATION RETRAIT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(437, 356));

        mt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        mt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("MONTANT :");

        rb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR RUBRIQUE" }));
        rb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbActionPerformed(evt);
            }
        });

        srb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        srb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR SOUS RUBRIQUE" }));
        srb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        srb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srbActionPerformed(evt);
            }
        });

        com.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        com.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR COMMISSIONNAIRE" }));
        com.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        com.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comActionPerformed(evt);
            }
        });

        motif.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jCheckBox1.setText("IMPRIMER AVIS");
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("VALIDER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("MOTIF :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("REFERENCE : ");

        ref.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        sp.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        sp.setText("LIBRE");
        sp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        sp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                spMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(motif, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(srb, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(com, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ref, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sp)
                    .addComponent(ref, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(srb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(com, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(motif, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbActionPerformed
        // TODO add your handling code here:
        
        
         this.srb.removeAllItems() ;
          
        String rb = "" ;
               rb = this.rb.getSelectedItem().toString().replaceAll("'", "''") ;
               int id = 0 ;
               this.rb1 = 0 ;
               
               
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
      
       sql= "SELECT distinct id FROM rubrique WHERE rub = '"+rb+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
     
      this.rb1 =  rs.getInt("id")  ;
      id =  rs.getInt("id")  ;
     
     }
      
       
       this.srb.addItem(new String("CHOISIR SOUS RUBRIQUE"));
       String sql2 ;
      
       sql2 = "SELECT srb FROM sousrub where id_r = "+id+" AND NOT type = 'non' ORDER BY srb ASC" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
                 
         this.srb.addItem(rs2.getString("srb"))  ;
         
       
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
     
        
    }//GEN-LAST:event_rbActionPerformed

    private void srbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srbActionPerformed
        // TODO add your handling code here:
        
        
          try{
        String rb = "" ;
               rb = this.srb.getSelectedItem().toString().replaceAll("'", "''") ;
                this.srb1 = 0 ;
               
               
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
      
       sql= "SELECT distinct id_srb FROM sousrub WHERE srb = '"+rb+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
     
      this.srb1 =  rs.getInt("id_srb")  ;
      
     
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
     
          }catch(Exception ex){
              
          }
        
        
        
    }//GEN-LAST:event_srbActionPerformed

    private void comActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comActionPerformed
        // TODO add your handling code here:
        
        
            
          
        String rb = "" ;
               rb = this.com.getSelectedItem().toString().replaceAll("'", "''") ;
               this.com1 = 0 ;
               
               
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
      
       sql= "SELECT distinct id_p FROM perso_t WHERE perso = '"+rb+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
     
      this.com1 =  rs.getInt("id_p")  ;
       
     
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
     
        
        
        
    }//GEN-LAST:event_comActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        String mt , motif , ref ;
        String name = null ;
        mt = this.mt.getText().trim() ;
        motif = this.motif.getText().trim().replaceAll("'", "''") ;
        
        ref = this.ref.getText().trim().replaceAll("'", "''") ;
        
           try{
                  long mtt = 0 ;
                       mtt = Long.parseLong(mt) ;
                 
if(mtt == 0 || this.rb1 == 0 || this.srb1 == 0 || this.com1 == 0 || motif.isEmpty() || (ref.isEmpty() && this.sp.isSelected() == false)){
                     JOptionPane.showMessageDialog(this, "Vous devez remplir correctement le formulaire pour un depot !!! ") ;
                 }else{
                     
                     int i = 0 ;
                         Random rx = new Random() ;
                         i = rx.nextInt() ;
                     
                      if(i < 0){
                         i = Math.abs(i) ;
                     }
                      
                      
                       try{
            InetAddress inetaddress=InetAddress.getLocalHost(); //Get LocalHost refrence
            name = inetaddress.getHostName() ;   //Get Host Name
           
        }
        catch(Exception E){
            E.printStackTrace();  //print Exception StackTrace
           
        }
                     
                     
                     
            
                     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
                     SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
                                      String date = sdf.format(new Date()) ;
                                      
                                      
                            // we are rady to save op depot in our data center now all data to save is ok :::          
                                      
                                      
                              Connection conn = null ;
                              Statement  stmt = null ;
       
       try{
      // STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // STEP 3: Open a connection
     //  System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;
      conn.setAutoCommit(false) ;
      

       // STEP 4: Execute a query
      // System.out.println("Creating statement...") ;
      
          stmt = conn.createStatement();
      
   //   je crai ma requete
          Integer compte = 0 ;
          long cfa_old = 0 ;
          
          String sql ;
                 sql = "select distinct id from comptes_u where login = '"+this.loging+"'" ;
                 ResultSet rs = stmt.executeQuery(sql) ;
                 while(rs.next()){
                     compte = rs.getInt("id") ;
                 }
                 
                  String sql2 ;
                 sql2 = "select solde_cfa_eco from compte_b where nom_cpte = "+compte ;
                 ResultSet rs2 = stmt.executeQuery(sql2) ;
                 while(rs2.next()){
                     cfa_old = rs2.getLong("solde_cfa_eco") ;
                 }
       
                  long new_solde = 0 ;
                  
                   if(cfa_old >= mtt){
                       new_solde = (cfa_old - mtt) ;
                       
                       Integer row = 0 ;
                               row = stmt.executeUpdate("UPDATE compte_b SET solde_cfa_eco = "+new_solde+" WHERE nom_cpte = "+compte) ;
                       
                       
           
          if(stmt.executeUpdate("INSERT INTO depot_retrait(mtt,rubrique,srb,perso_t,motif,dtec,admin,type,cb, a_mt, reference, pos) VALUES("
                  +mtt+" , "+this.rb1+" , "+this.srb1+" , "+this.com1+" , '"+motif+"' , '"+date+"'  , '"+this.loging+"' , '"+TYPE+"' , "+i+" , "
                  +cfa_old+" , '"+ref+"' , '"+name+"')") == 1){
              
              
              String jour = "" ;
              String qery = null ;
              ResultSet rst = null ;
              
              qery = "select dtec , id from depot_retrait where cb = "+i ;
              rst = stmt.executeQuery(qery) ;
              while(rst.next()){
                  jour = sdfT.format(rst.getTimestamp("dtec")) ;
              }
              
              
              
              
              if(row == 1){
                  conn.commit() ;
              
                           if(this.jCheckBox1.isSelected()){
                               
                               
                               this.rb1 = 0 ;
                               this.srb1 = 0 ;
                               this.com1 = 0 ;
                               
                               this.mt.setText("") ;
                               this.rb.setSelectedItem("CHOISIR RUBRIQUE")  ;
                               this.srb.setSelectedItem("CHOISIR SOUS RUBRIQUE") ;
                               this.com.setSelectedItem("CHOISIR COMMISSIONNAIRE") ;
                               this.motif.setText("") ;
                               this.jCheckBox1.setSelected(false) ;
                               this.ref.setText("");
                               this.sp.setSelected(false);
                               
                               
                               
                               this.jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        
       
             try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Bon_d_r.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql10 = "select * , transformation.sousrub.srb as COLUMN_15 \n " +
" from transformation.depot_retrait , transformation.rubrique , transformation.sousrub , transformation.perso_t \n " +
" where transformation.depot_retrait.cb = "+i+" \n " +
" AND transformation.rubrique.id = transformation.depot_retrait.rubrique \n " +
" AND transformation.sousrub.id_srb = transformation.depot_retrait.srb \n " +
" AND transformation.perso_t.id_p = transformation.depot_retrait.perso_t " ;
           
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql10) ;
           jd.setQuery(newQuery) ;
           JasperReport jr = JasperCompileManager.compileReport(jd) ;
           HashMap para = new HashMap() ;
           para.put("ref", "REF. "+ref) ;
           para.put("dtec", "Bamako, le "+jour) ;
           
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
           
           
           
     
            
        }catch(Exception e1){
            
        }
        
         this.jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
                               
                               
                           }else{
                               
                               this.rb1 = 0 ;
                               this.srb1 = 0 ;
                               this.com1 = 0 ;
                               
                               this.mt.setText("") ;
                               this.rb.setSelectedItem("CHOISIR RUBRIQUE")  ;
                               this.srb.setSelectedItem("CHOISIR SOUS RUBRIQUE") ;
                               this.com.setSelectedItem("CHOISIR COMMISSIONNAIRE") ;
                               this.motif.setText("") ;
                               this.jCheckBox1.setSelected(false) ;
                               
                                
                               
                           }
              
                        }else if(row == 0){
                            conn.rollback();
                            JOptionPane.showMessageDialog(null, "REPRENDRE OPERATION") ;
                        }
                        }
          
                 
                   }else{
                       JOptionPane.showMessageDialog(this, "Operation impossible votre solde est insuffisant !!! Solde disponible = "+cfa_old+" FCFA / ECO");
                   }
            
      // STEP 6: Clean-up environment
      
     //  System.out.println("Goodbye!");
      
   
      
   //    STEP 6: Clean-up environment
      
         rs.close() ;
          
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
        
       
     
     // Fin saving in the data center :
              
                                      
                                      
                     
                 }
            
            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "LE montant en chiffre svp !!! "+e.getMessage());
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void spMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spMouseReleased
        // TODO add your handling code here:

        if(this.sp.isSelected()){
            this.ref.setText("LIBRE") ;
            this.ref.setEnabled(false);
        }else{
            this.ref.setText("");
            this.ref.setEnabled(true) ;

        }

    }//GEN-LAST:event_spMouseReleased

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
            java.util.logging.Logger.getLogger(OpRetrait1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpRetrait1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpRetrait1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpRetrait1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpRetrait1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox com;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField motif;
    private javax.swing.JFormattedTextField mt;
    private javax.swing.JComboBox rb;
    private javax.swing.JTextField ref;
    private javax.swing.JCheckBox sp;
    private javax.swing.JComboBox srb;
    // End of variables declaration//GEN-END:variables
}
