/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.Gdevises.JDBC_DRIVER;
import static frontend.OpDepot.DB_URL;
import static frontend.OpRetrait1.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
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
public class Xe extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
    String login ;
    private float mtt_d = 0 ;
    private float mtt_a = 0 ;
    String d1 = "";
    String a1 = "" ;
    String date ;
    
    NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
    
    public Xe() {
        initComponents();
    }

    public Xe(String login) {
        initComponents();
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
      
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                          dtm.setRowCount(0) ;
        
        String sql ;
      
       sql= "SELECT * FROM devise where type = 'OUI' ORDER BY type_d asc" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
        //   "DEVISE", "TAUX", "TYPE"
         
          dtm.addRow(new Object[]{
          rs.getInt("id") , rs.getString("monnaie") , rs.getLong("xe_cfa_eco") , rs.getString("type_d")
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
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        rst_ = new javax.swing.JTextPane();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONVERSION DE DEVISE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Nirmala UI", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        mt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        mt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(mt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 151, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MONTANT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("CHOISIR LE TAUX");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("CALCULER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 150, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setText("VALIDER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 150, 30));

        jCheckBox1.setText("IMPRIMER UN BON");
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 150, -1));

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "DEVISE", "TAUX", "TYPE"
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
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 250, 180));

        rst_.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        rst_.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        rst_.setText("RESULTAT : ");
        jScrollPane2.setViewportView(rst_);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 260, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "PRECISER LA DEVISE");
        }else{
            
            String mt = this.mt.getText().trim() ;
            Integer mt1 = 0 ;
             
            try{
                mt1 = Integer.parseInt(mt) ;
                
                long resultat = (mt1 * this.taux_) ;
                
                this.rst_.setText("CHANGE DE : "+nf3.format(mt1)+" "+this.devise.replace("1", "")+" POUR "+this.nf3.format(resultat)+" FCFA"+System.getProperty("line.separator")+"");
                
                
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
            
        }
        
        
        
        /*
        
      
         String mt , a_v ;
         a_v = this.a_v.getSelectedItem().toString() ;
         
         if(a_v.equalsIgnoreCase("CHOISIR TYPE")){
             JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT !");
         }else{
        
        try{
        
        
               mt = this.mt.getText().trim() ;
               String de ;
                      de = this.de.getSelectedItem().toString() ;
                      String a ;
                             a = this.a.getSelectedItem().toString() ;
                             
                            
                             
                             try{
                                 
                                 float mtt_d = 0 ;
                                      mtt_d = Float.parseFloat(mt) ;
                                      this.mtt_d = mtt_d ;
                                      this.d1 = de ;
                                      this.a1 = a ;
                                      
                                      /*
                                       EURO
                                       DOLLAR
                                       FCFA ECO
                                       EURO -> DOLLAR
                                       DOLLAR -> EURO
                           
                                      
              if("EURO".equals(de) && "FCFA ECO".equals(a)){
                                          
                                          
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
      
      /*
       1¤
       1$
       1¤ -> $
       1$ -> ¤
 
      
      long cfa = 0 ;
      String date = null ;
      
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
        
      String sql ;
      
       sql= "SELECT xe_cfa_eco , dtec FROM devise WHERE monnaie = '1¤' and type_d = '"+a_v+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
         cfa = rs.getLong("xe_cfa_eco") ;
         date = sdf.format(rs.getTimestamp("dtec")) ;         
     
     }
     
     this.mtt_a = 0 ;
     this.mtt_a = (this.mtt_d * cfa) ;
     
     this.date = date ;
     
     String result = nf3.format(this.mtt_a) ;
     
     this.rst.setText("Resultat : "+result+" FCFA") ;
     this.date1.setText("Derniere mise à jour : "+this.date) ;
     
     
      
            
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
     
        
                                          
                                          
                                      }else if("DOLLAR".equals(de) && "FCFA ECO".equals(a)){
                                          
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
      
      /*
       1¤
       1$
       1¤ -> $
       1$ -> ¤
  
      
      long cfa = 0 ;
      String date = null ;
      
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
        
      String sql ;
      
       sql= "SELECT xe_cfa_eco , dtec FROM devise WHERE monnaie = '1$' and type_d = '"+a_v+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
         cfa = rs.getLong("xe_cfa_eco") ;
         date = sdf.format(rs.getTimestamp("dtec")) ;         
     
     }
     
     this.mtt_a = 0 ;
     this.mtt_a = (this.mtt_d * cfa) ;
     
     this.date = date ;
     
     String result = nf3.format(this.mtt_a) ;
     
     this.rst.setText("Resultat : "+result+" FCFA") ;
     this.date1.setText("Derniere mise à jour : "+this.date) ;
     
     
      
            
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
     
        
                                          
                                      }else if("FCFA ECO".equals(de) && "EURO".equals(a)){
                                          
                                          
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
      
      /*
       1¤
       1$
       1¤ -> $
       1$ -> ¤
       
      
      long cfa = 0 ;
      String date = null ;
      
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
        
      String sql ;
      
       sql= "SELECT xe_cfa_eco , dtec FROM devise WHERE monnaie = '1¤' and type_d = '"+a_v+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
         cfa = rs.getLong("xe_cfa_eco") ;
         date = sdf.format(rs.getTimestamp("dtec")) ;         
     
     }
     
     this.mtt_a = 0 ;
     this.mtt_a = (this.mtt_d / cfa) ;
     
     this.date = date ;
     
     String result = nf3.format(this.mtt_a) ;
     
     this.rst.setText("Resultat : "+result+" EURO") ;
     this.date1.setText("Derniere mise à jour : "+this.date) ;
     
     
      
            
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
     
        
                                      
                                          
                                          
                                      }else if("FCFA ECO".equals(de) && "DOLLAR".equals(a)){
                                          
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
      
      /*
       1¤
       1$
       1¤ -> $
       1$ -> ¤
      
      
      long cfa = 0 ;
      String date = null ;
      
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
        
      String sql ;
      
       sql= "SELECT xe_cfa_eco , dtec FROM devise WHERE monnaie = '1$' and type_d = '"+a_v+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
         cfa = rs.getLong("xe_cfa_eco") ;
         date = sdf.format(rs.getTimestamp("dtec")) ;         
     
     }
     
     this.mtt_a = 0 ;
     this.mtt_a = (this.mtt_d / cfa) ;
     
     this.date = date ;
     
     this.rst.setText("Resultat : "+nf3.format(this.mtt_a)+" DOLLAR") ;
     this.date1.setText("Derniere mise à jour : "+this.date) ;
     
     
      
            
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
     
                                          
                                      }else if("EURO -> DOLLAR".equals(de) && "DOLLAR".equals(a)){
                                          
                                          JOptionPane.showMessageDialog(this, "CETTE OPERATION N'EST PAS PREVUE ") ;
                                          
                                      }else if("DOLLAR -> EURO".equals(de) && "EURO".equals(a)){
                                          
                                          JOptionPane.showMessageDialog(this, "CETTE OPERATION N'EST PAS PREVUE ") ;
                                          
                                      }else if("CHOISIR DEVISE".equals(de) || "CHOISIR DEVISE".equals(a)){
                                          
                                          JOptionPane.showMessageDialog(this, "CHOISIR DEVISE DE DEPART ET D'ARRIVER SVP !!!") ;
                                          
                                      }
                                      
                                      /*
                                      
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
      
       sql2 = "SELECT perso FROM perso_t WHERE type = 'oui' ORDER BY perso ASC" ;
      
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
     
        
                                
                                      
                                      
                                      
                                 
                             }catch(Exception e){
                                 JOptionPane.showMessageDialog(this, "SAISIR LE MONTANT EN CHIFFRE UNIQUEMENT SVP !!!") ;
                             }
                             
        }catch(Exception e10){
            JOptionPane.showMessageDialog(this, "CHOISIR LES DEVISES ET MONTANT !!!") ;
        }
        
        }
         
         
         */
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
          int i = 0 ;
        
        Random rx = new Random() ;
                i = rx.nextInt() ;
         
                 if(i < 0){
                     i = Math.abs(i) ;
                 }
                 
              //   JOptionPane.showMessageDialog(null, i) ;
                 
                 
        try{
   
                 
                 
                                            Connection conn = null ;
                                            Statement stmt = null ;
       
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
      
      //je crai ma requete
      
     
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        
     
      long solde_cfa_eco = 0 ;
      long solde_euro = 0 ;
      long solde_dollar = 0 ;
      int nom_cpte = 0 ;
      
      String sql ;
             sql = "select distinct id from comptes_u where login = '"+this.login.replaceAll("'", "''")+"'" ;
             ResultSet rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                 nom_cpte = rs.getInt("id") ;
             }
             
             String sql1 ;
             sql1 = "select solde_cfa_eco , solde_euro , solde_dollar from compte_b where nom_cpte = "+nom_cpte ;
             ResultSet rs1 = stmt.executeQuery(sql1) ;
             while(rs1.next()){
                 solde_cfa_eco = rs1.getLong("solde_cfa_eco") ;
                 solde_euro = rs1.getLong("solde_euro") ;
                 solde_dollar = rs1.getLong("solde_dollar") ;
             }
             
             
             
             /*
             EURO
             DOLLAR
             FCFA ECO
             */
             
             if(this.type_d.equalsIgnoreCase("ACHAT") && this.devise.equalsIgnoreCase("1$")){
                 
                 // debut :
                 
                   
                 int mt = 0 ;
                 try{
                 mt = Integer.parseInt(this.mt.getText().trim()) ;
                 }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT");
                 }
                 
                 
                 int rst = (this.taux_ * mt) ;
                 
                                  if(solde_cfa_eco >= rst){
                     
                     
                     long new_euro = 0 ;
                     long new_cfa = 0 ;
                     
                     new_euro = (long) (solde_dollar + mt) ;
                     new_cfa = (long) (solde_cfa_eco - rst) ;
                     
                     Integer row1 = 0 ;
                     Integer row2 = 0 ;
                     
                     row1 = stmt.executeUpdate("update compte_b set solde_cfa_eco = "+new_cfa+" where nom_cpte = "+nom_cpte) ;
                     row2 = stmt.executeUpdate("update compte_b set solde_dollar = "+new_euro+" where nom_cpte = "+nom_cpte) ;
                     
                     
                     
                     if(row1 == 1 && row2 == 1){

                         // this.devise.replace("1", "")
                         
                         if(stmt.executeUpdate("insert into echange_xe(mtt_d,depart,mtt_a,arrive,dtec,admin,cb,a_c,a_e,a_d, type_op) values("
                                 +rst+" , 'CFA' , "+mt+" , '"+this.devise.replace("1", "")+"' , '"+sdf.format(new Date())+"' , '"
                                 +this.login.replaceAll("'", "''")+"' , "+i+" , "
                                 +solde_cfa_eco+" , "+solde_euro+" , "+solde_dollar+" , '"+this.type_d+"')") == 1){
                             
                             
                             
                             if(this.jCheckBox1.isSelected()){
                                 
                                 this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        
       
             try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Bon_xe.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql10 = "select * from transformation.echange_xe where cb = "+i ;
           
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql10) ;
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
           
           
           
     
            
        }catch(Exception e1){
            
        }
        
         this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
           
                                 
                                 this.jCheckBox1.setSelected(false) ;
                             }else{
                                
                             }

                         
                         
                     }
                         
                         conn.commit();
                         this.jTable1.getSelectionModel().clearSelection();
                         this.mt.setText("");
                         this.rst_.setText("RESULTAT : ");
                         this.jCheckBox1.setSelected(false) ;
                         
                     }else{
                         conn.rollback();
                         JOptionPane.showMessageDialog(null , "REPRENDE OPERATION") ;
                     }
                     
                     
                     
                 }else{
                     JOptionPane.showMessageDialog(this, "Solde insuffisant et votre CFA est : "+solde_cfa_eco) ;
                 }
                 
                 // fin :
                 
             }else if(this.type_d.equalsIgnoreCase("ACHAT") && this.devise.equalsIgnoreCase("1¤")){
                 
                  // debut :
                 
                 int mt = 0 ;
                 try{
                 mt = Integer.parseInt(this.mt.getText().trim()) ;
                 }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT");
                 }
                 
                 int rst = (this.taux_ * mt) ;
                 
              if(solde_cfa_eco >= rst){
                     
                     
                     long new_euro = 0 ;
                     long new_cfa = 0 ;
                     
                     new_euro = (long) (solde_euro + mt) ;
                     new_cfa = (long) (solde_cfa_eco - rst) ;
                     
                     Integer row1 = 0 ;
                     Integer row2 = 0 ;
                     
                     row1 = stmt.executeUpdate("update compte_b set solde_cfa_eco = "+new_cfa+" where nom_cpte = "+nom_cpte) ;
                     row2 = stmt.executeUpdate("update compte_b set solde_euro = "+new_euro+" where nom_cpte = "+nom_cpte) ;
                     
                     
                     
                     if(row1 == 1 && row2 == 1){

                         if(stmt.executeUpdate("insert into echange_xe(mtt_d,depart,mtt_a,arrive,dtec,admin,cb,a_c,a_e,a_d, type_op) values("
                                 +rst+" , 'CFA' , "+mt+" , '"+this.devise.replace("1", "")+"' , '"+sdf.format(new Date())+"' , '"
                                 +this.login.replaceAll("'", "''")+"' , "+i+" , "
                                 +solde_cfa_eco+" , "+solde_euro+" , "+solde_dollar+" , '"+this.type_d+"')") == 1){
                             
                             
                             
                             if(this.jCheckBox1.isSelected()){
                                 
                                 this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        
       
             try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Bon_xe.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql10 = "select * from transformation.echange_xe where cb = "+i ;
           
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql10) ;
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
           
           
           
     
            
        }catch(Exception e1){
            
        }
        
         this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
                               
                                 
                                 
                                 this.jCheckBox1.setSelected(false) ;
                             }else{
                                
                             }

                         
                         
                     }
                         
                         conn.commit();
                         this.jTable1.getSelectionModel().clearSelection();
                         this.mt.setText("");
                         this.rst_.setText("RESULTAT : ");
                         this.jCheckBox1.setSelected(false) ;
                         
                     }else{
                         conn.rollback();
                         JOptionPane.showMessageDialog(null , "REPRENDE OPERATION") ;
                     }
                     
                     
                     
                 }else{
                     JOptionPane.showMessageDialog(this, "Solde insuffisant et votre CFA est : "+solde_cfa_eco) ;
                 }
                 
                 // fin :
                 
             }else if(this.type_d.equalsIgnoreCase("VENTE") && this.devise.equalsIgnoreCase("1¤")){
                 
                  // debut :
                 
                    
                 int mt = 0 ;
                 try{
                 mt = Integer.parseInt(this.mt.getText().trim()) ;
                 }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT");
                 }
                 
                 
                 int rst = (this.taux_ * mt) ;
                 
              if(solde_euro >= mt){
                     
                     
                     long new_euro = 0 ;
                     long new_cfa = 0 ;
                     
                     new_euro = (long) (solde_euro - mt) ;
                     new_cfa = (long) (solde_cfa_eco + rst) ;
                     
                     Integer row1 = 0 ;
                     Integer row2 = 0 ;
                     
                     row1 = stmt.executeUpdate("update compte_b set solde_cfa_eco = "+new_cfa+" where nom_cpte = "+nom_cpte) ;
                     row2 = stmt.executeUpdate("update compte_b set solde_euro = "+new_euro+" where nom_cpte = "+nom_cpte) ;
                     
                     
                     
                     if(row1 == 1 && row2 == 1){

                         if(stmt.executeUpdate("insert into echange_xe(mtt_d,depart,mtt_a,arrive,dtec,admin,cb,a_c,a_e,a_d, type_op) values("
                                 +rst+" , 'CFA' , "+mt+" , '"+this.devise.replace("1", "")+"' , '"+sdf.format(new Date())+"' , '"
                                 +this.login.replaceAll("'", "''")+"' , "+i+" , "
                                 +solde_cfa_eco+" , "+solde_euro+" , "+solde_dollar+" , '"+this.type_d+"')") == 1){
                             
                             
                             
                             if(this.jCheckBox1.isSelected()){
                                 
                                 this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        
       
             try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Bon_xe.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql10 = "select * from transformation.echange_xe where cb = "+i ;
           
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql10) ;
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
           
           
           
     
            
        }catch(Exception e1){
            
        }
        
         this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
                               
                                 
                                 
                                 this.jCheckBox1.setSelected(false) ;
                             }else{
                                
                             }

                         
                         
                     }
                         
                         conn.commit();
                         this.jTable1.getSelectionModel().clearSelection();
                         this.mt.setText("");
                         this.rst_.setText("RESULTAT : ");
                         this.jCheckBox1.setSelected(false) ;
                         
                     }else{
                         conn.rollback();
                         JOptionPane.showMessageDialog(null , "REPRENDE OPERATION") ;
                     }
                     
                     
                     
                 }else{
                     JOptionPane.showMessageDialog(this, "Solde insuffisant et votre euro est : "+solde_euro) ;
                 }
                 
                 // fin :
                 
             }else if(this.type_d.equalsIgnoreCase("VENTE") && this.devise.equalsIgnoreCase("1$")){
                 
                 // debut :
                 
                     
                 int mt = 0 ;
                 try{
                 mt = Integer.parseInt(this.mt.getText().trim()) ;
                 }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT");
                 }
                 
                 
                 int rst = (this.taux_ * mt) ;
                 
              if(solde_dollar >= mt){
                     
                     
                     long new_euro = 0 ;
                     long new_cfa = 0 ;
                     
                     new_euro = (long) (solde_dollar - mt) ;
                     new_cfa = (long) (solde_cfa_eco + rst) ;
                     
                     Integer row1 = 0 ;
                     Integer row2 = 0 ;
                     
                     row1 = stmt.executeUpdate("update compte_b set solde_cfa_eco = "+new_cfa+" where nom_cpte = "+nom_cpte) ;
                     row2 = stmt.executeUpdate("update compte_b set solde_dollar = "+new_euro+" where nom_cpte = "+nom_cpte) ;
                     
                     
                     
                     if(row1 == 1 && row2 == 1){

                         if(stmt.executeUpdate("insert into echange_xe(mtt_d,depart,mtt_a,arrive,dtec,admin,cb,a_c,a_e,a_d, type_op) values("
                                 +rst+" , 'CFA' , "+mt+" , '"+this.devise.replace("1", "")+"' , '"+sdf.format(new Date())+"' , '"
                                 +this.login.replaceAll("'", "''")+"' , "+i+" , "
                                 +solde_cfa_eco+" , "+solde_euro+" , "+solde_dollar+" , '"+this.type_d+"')") == 1){
                             
                             
                             
                             if(this.jCheckBox1.isSelected()){
                                 
                                 this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        
       
             try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Bon_xe.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql10 = "select * from transformation.echange_xe where cb = "+i ;
           
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql10) ;
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
           
           
           
     
            
        }catch(Exception e1){
            
        }
        
         this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
                               
                                 
                                 
                                 this.jCheckBox1.setSelected(false) ;
                             }else{
                                
                             }

                         
                         
                     }
                         
                         conn.commit();
                         this.jTable1.getSelectionModel().clearSelection();
                         this.mt.setText("");
                         this.rst_.setText("RESULTAT : ");
                         this.jCheckBox1.setSelected(false) ;
                         
                     }else{
                         conn.rollback();
                         JOptionPane.showMessageDialog(null , "REPRENDE OPERATION") ;
                     }
                     
                     
                     
                 }else{
                     JOptionPane.showMessageDialog(this, "Solde insuffisant et votre dollar est : "+solde_dollar) ;
                 }
                 
                 // fin :
                 
                 
             }
             
             
             // A DELIMITER ICI :
             
             
             
             //----------------------------------------------------------------------------------------------
             
             
             /*
             
            if("FCFA ECO".equals(d1) && "EURO".equals(a1)){
                 
                 if(solde_euro >= this.mtt_a){
                     
                     long new_euro = 0 ;
                     long new_cfa = 0 ;
                     
                     new_euro = (long) (solde_euro - this.mtt_a) ;
                     new_cfa = (long) (solde_cfa_eco + this.mtt_d) ;
                     
                     Integer row1 = 0 ; 
                     Integer row2 = 0 ;
                     
row1 =  stmt.executeUpdate("update compte_b set solde_cfa_eco = "+new_cfa+" where nom_cpte = "+nom_cpte) ;
row2 = stmt.executeUpdate("update compte_b set solde_euro = "+new_euro+" where nom_cpte = "+nom_cpte) ;

// row = stmt.executeUpdate("update compte_b set solde_cfa_eco = "+new_cfa+" , solde_euro = "+new_euro+" where nom_cpte = "+nom_cpte) ;
                     
                     if(row1 == 1 && row2 == 1){

                         if(stmt.executeUpdate("insert into echange_xe(mtt_d,depart,mtt_a,arrive,dtec,admin,cb,a_c,a_e,a_d) values("
                                 +this.mtt_d+" , '"+this.d1+"' , "+this.mtt_a+" , '"+this.a1+"' , '"+sdf.format(new Date())+"' , '"
                                 +this.login.replaceAll("'", "''")+"' , "+i+" , "
                                 +solde_cfa_eco+" , "+solde_euro+" , "+solde_dollar+")") == 1){
                             
                             this.mtt_a = 0 ;
                             this.mtt_d = 0 ;
                             this.d1 = "" ;
                             this.a1 = "" ;
                             this.de.setSelectedItem("CHOISIR DEVISE");
                             this.mt.setText("");
                             this.a.setSelectedItem("CHOISIR DEVISE");
                             this.rst.setText("Resultat : ");
                             this.date1.setText("Derniere mise à jour :");
                             
                             if(this.jCheckBox1.isSelected()){
                                 
                                  this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        
       
             try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Bon_xe.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql10 = "select * from transformation.echange_xe where cb = "+i ;
           
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql10) ;
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
           
           
           
     
            
        }catch(Exception e1){
            
        }
        
         this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
                               
                                 
                                 
                                 this.jCheckBox1.setSelected(false) ;
                                 
                             }else{
                                 
                                 
                                 
                             }

                         
                         
                     }
                         
                         conn.commit();
                         
                     }else{
                         conn.rollback();
                         JOptionPane.showMessageDialog(null, "REPRENDRE VOTRE OPERATION") ;
                     }
                     
                 }else{
                     JOptionPane.showMessageDialog(this, "Solde insuffisant et votre euro est : "+solde_euro) ;
                 }
                 
             }else if("FCFA ECO".equals(d1) && this.a1.equals("DOLLAR")){
                 
                 if(solde_dollar >= this.mtt_a){
                     
                     
                     long new_euro = 0 ;
                     long new_cfa = 0 ;
                     
                     new_euro = (long) (solde_dollar - this.mtt_a) ;
                     new_cfa = (long) (solde_cfa_eco + this.mtt_d) ;
                     
                     Integer row1 = 0 ;
                     Integer row2 = 0 ;
                     
                     row1 = stmt.executeUpdate("update compte_b set solde_cfa_eco = "+new_cfa+" where nom_cpte = "+nom_cpte) ;
                     row2 = stmt.executeUpdate("update compte_b set solde_dollar = "+new_euro+" where nom_cpte = "+nom_cpte) ;
                     
                     
                     
                     if(row1 == 1 && row2 == 1){

                         if(stmt.executeUpdate("insert into echange_xe(mtt_d,depart,mtt_a,arrive,dtec,admin,cb,a_c,a_e,a_d) values("
                                 +this.mtt_d+" , '"+this.d1+"' , "+this.mtt_a+" , '"+this.a1+"' , '"+sdf.format(new Date())+"' , '"
                                 +this.login.replaceAll("'", "''")+"' , "+i+" , "
                                 +solde_cfa_eco+" , "+solde_euro+" , "+solde_dollar+")") == 1){
                             
                             this.mtt_a = 0 ;
                             this.mtt_d = 0 ;
                             this.d1 = "" ;
                             this.a1 = "" ;
                             this.de.setSelectedItem("CHOISIR DEVISE");
                             this.mt.setText("");
                             this.a.setSelectedItem("CHOISIR DEVISE");
                             this.rst.setText("Resultat : ");
                             this.date1.setText("Derniere mise à jour :");
                             
                             if(this.jCheckBox1.isSelected()){
                                 this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        
       
             try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Bon_xe.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql10 = "select * from transformation.echange_xe where cb = "+i ;
           
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql10) ;
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
           
           
           
     
            
        }catch(Exception e1){
            
        }
        
         this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
                               
                                 
                                 
                                 this.jCheckBox1.setSelected(false) ;
                             }else{
                                
                             }

                         
                         
                     }
                         
                         conn.commit();
                         
                     }else{
                         conn.rollback();
                         JOptionPane.showMessageDialog(null , "REPRENDE OPERATION") ;
                     }
                     
                     
                     
                 }else{
                     JOptionPane.showMessageDialog(this, "Solde insuffisant et votre dollar est : "+solde_dollar) ;
                 }
                 
             }else if(this.a1.equals("FCFA ECO") && this.d1.equals("EURO")){
                 
                 if(solde_cfa_eco >= this.mtt_a){
                     
                     long new_euro = 0 ;
                     long new_cfa = 0 ;
                     
                     new_euro = (long) (solde_euro + this.mtt_d) ;
                     new_cfa = (long) (solde_cfa_eco - this.mtt_a) ;
                     
                     Integer row1 = 0 ;
                     Integer row2 = 0 ;
                     
                     row1 = stmt.executeUpdate("update compte_b set solde_cfa_eco = "+new_cfa+" where nom_cpte = "+nom_cpte) ;
                     row2 = stmt.executeUpdate("update compte_b set solde_euro = "+new_euro+" where nom_cpte = "+nom_cpte) ;
                     
                     
                     
                     if(row1 == 1 && row2 == 1){

                         if(stmt.executeUpdate("insert into echange_xe(mtt_d,depart,mtt_a,arrive,dtec,admin,cb,a_c,a_e,a_d) values("
                                 +this.mtt_d+" , '"+this.d1+"' , "+this.mtt_a+" , '"+this.a1+"' , '"+sdf.format(new Date())+"' , '"
                                 +this.login.replaceAll("'", "''")+"' , "+i+" , "
                                 +solde_cfa_eco+" , "+solde_euro+" , "+solde_dollar+")") == 1){
                             
                             this.mtt_a = 0 ;
                             this.mtt_d = 0 ;
                             this.d1 = "" ;
                             this.a1 = "" ;
                             this.de.setSelectedItem("CHOISIR DEVISE");
                             this.mt.setText("");
                             this.a.setSelectedItem("CHOISIR DEVISE");
                             this.rst.setText("Resultat : ");
                             this.date1.setText("Derniere mise à jour :");
                             
                             if(this.jCheckBox1.isSelected()){
                                 this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        
       
             try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Bon_xe.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql10 = "select * from transformation.echange_xe where cb = "+i ;
           
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql10) ;
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
           
           
           
     
            
        }catch(Exception e1){
            
        }
        
         this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
                               
                                 
                                 
                                 
                                 this.jCheckBox1.setSelected(false) ;
                             }else{
                                  
                             }

                         
                         
                     }
                         
                         conn.commit();
                         
                     }else{
                         conn.rollback();
                         JOptionPane.showMessageDialog(null, "REPRENDRE OPERATION") ;
                     }
                     
                     
                     
                 }else{
                     JOptionPane.showMessageDialog(this, "Solde insuffisant et votre FCFA / ECO est : "+solde_cfa_eco) ;
                 }
                 
             }else if(this.a1.equals("FCFA ECO") && this.d1.equals("DOLLAR")){
                 
                 if(solde_cfa_eco >= this.mtt_a){
                     
                     long new_euro = 0 ;
                     long new_cfa = 0 ;
                     
                     new_euro = (long) (solde_dollar + this.mtt_d) ;
                     new_cfa = (long) (solde_cfa_eco - this.mtt_a) ;
                     
                     
                     Integer row1 = 0 ;
                     Integer row2 = 0 ;
                             row1 = stmt.executeUpdate("update compte_b set solde_cfa_eco = "+new_cfa+" where nom_cpte = "+nom_cpte);
                             row2 = stmt.executeUpdate("update compte_b set solde_dollar = "+new_euro+" where nom_cpte = "+nom_cpte) ;
                             
                             
                     if(row1 == 1 && row2 == 1){

                         if(stmt.executeUpdate("insert into echange_xe(mtt_d,depart,mtt_a,arrive,dtec,admin,cb,a_c,a_e,a_d) values("
                                 +this.mtt_d+" , '"+this.d1+"' , "+this.mtt_a+" , '"+this.a1+"' , '"+sdf.format(new Date())+"' , '"
                                 +this.login.replaceAll("'", "''")+"' , "+i+" , "
                                 +solde_cfa_eco+" , "+solde_euro+" , "+solde_dollar+")") == 1){
                             
                             this.mtt_a = 0 ;
                             this.mtt_d = 0 ;
                             this.d1 = "" ;
                             this.a1 = "" ;
                             this.de.setSelectedItem("CHOISIR DEVISE");
                             this.mt.setText("");
                             this.a.setSelectedItem("CHOISIR DEVISE");
                             this.rst.setText("Resultat : ");
                             this.date1.setText("Derniere mise à jour :");
                             
                             if(this.jCheckBox1.isSelected()){
                                this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        
       
             try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Bon_xe.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql10 = "select * from transformation.echange_xe where cb = "+i ;
           
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql10) ;
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
           
           
           
     
            
        }catch(Exception e1){
            
        }
        
         this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
                               
                                 
                                 
                                 
                                 this.jCheckBox1.setSelected(false) ;
                             }else{
                                  
                             }

                         
                         
                     }
                      
                         conn.commit();
                         
                     }else{
                         conn.rollback();
                         JOptionPane.showMessageDialog(null, "REPRENDRE OPERATION");
                     }
                     
                     
                     
                 }else{
                     JOptionPane.showMessageDialog(this, "Solde insuffisant et votre FCFA / ECO est : "+solde_cfa_eco) ;
                 }
                 
             }else{
                  JOptionPane.showMessageDialog(this, "PAS DE DONNEE A VALIDER") ;
             }
      
      
      
      
      // ---------------------------------------------------------------------------------------------
            
            
            */
      
      
      
            
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
        
        }catch(Exception nb){
        
            JOptionPane.showMessageDialog(this, "CHOISIR LES DEVISES CORRECTS ET LE MONTANT CORRECT ");
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed
String devise = "" ;
String taux = "0" ;
String type_d = "" ;
String id_xe = "0" ;

private Integer taux_ = 0 ;

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
       
        this.id_xe = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString() ;
        this.devise = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString() ;
        this.taux = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString() ;
        this.type_d = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString() ;
        
        try{
            this.taux_ = Integer.parseInt(this.taux) ;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage()) ;
        }
        
        
    }//GEN-LAST:event_jTable1MouseReleased

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
            java.util.logging.Logger.getLogger(Xe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Xe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Xe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Xe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Xe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JFormattedTextField mt;
    private javax.swing.JTextPane rst_;
    // End of variables declaration//GEN-END:variables
}
