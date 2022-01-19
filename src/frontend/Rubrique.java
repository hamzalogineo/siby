/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.NewProd.JDBC_DRIVER;
import static frontend.ProduitFini.DB_URL;
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
public class Rubrique extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
    
    
      String login = "" ;
      String groupe ;
    
     public Rubrique() {
        initComponents() ;
        
        this.setLocationRelativeTo(null) ;
        
        
    }
    
    
    public Rubrique(String login){
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
                       PreparedStatement pst = null ;
       
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
      
       sql= "SELECT * FROM rubrique ORDER BY rub ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
      dtm1.addRow(new Object[]{
          rs.getInt("id") , rs.getString("rub") , rs.getString("type"), rs.getString("groupe")
      }) ;
     
     }
      
     
       String sql2 ;
      
       sql2 = "SELECT * FROM sousrub ORDER BY srb ASC" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
          dtm2.addRow(new Object[]{
          rs2.getInt("id_srb") , rs2.getString("srb") , rs2.getInt("id_r"), rs2.getString("type")
          }) ;
         
       
     }
     
     
     sql = "select * from groupe_cl where not type = ?" ;
     pst = conn.prepareStatement(sql) ;
     pst.setString(1, "NON") ;
     rs = pst.executeQuery() ;
     while (rs.next()){
         
         this.gp.addItem(new String(rs.getString("groupe"))) ;
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        rb = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        rc1 = new javax.swing.JTextField();
        rc2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rc3 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        print = new javax.swing.JButton();
        gp = new javax.swing.JComboBox();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Rubrique", "ACTIVER", "GROUPE"
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(140);
        }

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Sous-Rubrique", "Rubrique", "ACTIVER"
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
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(55);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        rb.setText("Rubrique");
        rb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rbFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rbFocusLost(evt);
            }
        });
        rb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("AJOUTER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("MODIFIER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("VEILLEUSE");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        rc1.setText("RECHERCHER");
        rc1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rc1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rc1FocusLost(evt);
            }
        });
        rc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rc1KeyReleased(evt);
            }
        });

        rc2.setText("SAISIR UNE SOUS - RUBRIQUE");
        rc2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rc2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rc2FocusLost(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("AJOUTER");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("VEILLEUSE");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2.setText("ID_R");

        rc3.setText("RECHERCHER");
        rc3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rc3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rc3FocusLost(evt);
            }
        });
        rc3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rc3KeyReleased(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("MODIFIER");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        print.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        print.setText("IMPRIMER");
        print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        gp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR UN GROUPE" }));
        gp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gpActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3)
                            .addComponent(rb, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(34, 34, 34)
                                .addComponent(jButton2))
                            .addComponent(rc1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                            .addComponent(gp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(rc3, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addGap(25, 25, 25)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                            .addComponent(rc2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(gp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(print, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rc3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rb, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
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

    private void rbFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rbFocusGained
        // TODO add your handling code here:
        if(this.rb.getText().equalsIgnoreCase("rubrique")){
        this.rb.setText("") ;
        }
        
    }//GEN-LAST:event_rbFocusGained

    private void rbFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rbFocusLost
        // TODO add your handling code here:
        
        if(this.rb.getText().equalsIgnoreCase("") || "Rubrique".equalsIgnoreCase(this.rb.getText())){
            this.rb.setText("Rubrique") ;
            
        }
    }//GEN-LAST:event_rbFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String rb = "" ;
        
        rb = this.rb.getText().trim().replaceAll("'", "''") ;
        
        if(rb.isEmpty() || "Rubrique".equalsIgnoreCase(rb) || this.groupe.isEmpty()){
            JOptionPane.showMessageDialog(this, "Saisir la rubrique et choisir un groupe svp !") ;
        }else{
            
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
      
        if(stmt.executeUpdate("insert into rubrique(rub,type,groupe) VALUES('"+rb+"' , 'oui' , '"+this.groupe+"')") == 1){
            this.rb.setText("");
            this.groupe = "" ;
            this.gp.setSelectedItem(new String("CHOISIR UN GROUPE"));
            
            DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
            dtm1.setRowCount(0) ;
            
             String sql ;
      
            sql= "SELECT * FROM rubrique ORDER BY rub ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
      dtm1.addRow(new Object[]{
          rs.getInt("id") , rs.getString("rub") , rs.getString("type") , rs.getString("groupe")
      }) ;
     
     }
      
     rs.close();
     
        }
       
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
       
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
        
    }//GEN-LAST:event_jButton1ActionPerformed
  int id = 0 ; 
  String rb1 = "" ;
  
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        this.id = 0 ;
        this.rb1 = "" ;
        
        this.id = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString()) ;
        this.rb1 = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString() ;
        
        this.rb.setText(rb1) ;
        this.jLabel1.setText(String.valueOf(this.id)) ;
        
        this.gp.setSelectedItem(new String(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString()));
        
        
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
      
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        dtm2.setRowCount(0);
        
       String sql ;
      
       sql= "SELECT * FROM sousrub WHERE id_r = "+this.id+" ORDER BY srb ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
      dtm2.addRow(new Object[]{
          rs.getInt("id_srb") , rs.getString("srb") , rs.getInt("id_r"), rs.getString("type")
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
     
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selectionner dans le tableau svp !") ;
        }else{        
        
        String rb = "" ;
        
        rb = this.rb.getText().trim().replaceAll("'", "''") ;
        
        if(rb.isEmpty() || "Rubrique".equalsIgnoreCase(rb) || this.groupe.isEmpty()){
            JOptionPane.showMessageDialog(this, "Saisir la rubrique et choisir un groupe svp !") ;
        }else{
            
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
      
        if(stmt.executeUpdate("update rubrique SET rub = '"+rb+"' , groupe = '"+this.groupe+"' WHERE id = "+this.id) == 1){
            
            this.groupe = "" ;
            this.gp.setSelectedItem(new String("CHOISIR UN GROUPE"));
            
            DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
            dtm1.setRowCount(0) ;
            
             String sql ;
      
            sql= "SELECT * FROM rubrique ORDER BY rub ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
      dtm1.addRow(new Object[]{
          rs.getInt("id") , rs.getString("rub") , rs.getString("type") , rs.getString("groupe")
      }) ;
     
     }
      
     rs.close();
     
        }
       
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
       
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
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rc1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rc1KeyReleased
        // TODO add your handling code here:
        
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
      
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
        dtm1.setRowCount(0);
        
       String sql ;
      
       sql= "SELECT * FROM rubrique WHERE rub LIKE '%"+this.rc1.getText().trim().replaceAll("'", "''")+"%' ORDER BY rub ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
      dtm1.addRow(new Object[]{
          rs.getInt("id") , rs.getString("rub") , rs.getString("type") , rs.getString("groupe")
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
     
        
        
        
    }//GEN-LAST:event_rc1KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
         if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selectionner dans le tableau svp !") ;
        }else{        
        
        String rb = "" ;
        
        rb = this.rb.getText().trim().replaceAll("'", "''") ;
        
        if(rb.isEmpty()){
            JOptionPane.showMessageDialog(this, "Saisir la rubrique svp !") ;
        }else{
            
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
      
        if(stmt.executeUpdate("update rubrique SET type = 'non' WHERE id = "+this.id) == 1){
            DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
            dtm1.setRowCount(0) ;
            
             String sql ;
      
            sql= "SELECT * FROM rubrique ORDER BY rub ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
      dtm1.addRow(new Object[]{
          rs.getInt("id") , rs.getString("rub") , rs.getString("type") , rs.getString("groupe")
      }) ;
     
     }
      
     rs.close();
     
        }
       
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
       
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
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void rbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1 || this.jLabel1.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Selectionner la rubrique pour cette sous rubrique svp !");
        }else{
            
            String rb = "" ;
        
        rb = this.rc2.getText().trim().replaceAll("'", "''") ;
        
        if(rb.isEmpty()){
            JOptionPane.showMessageDialog(this, "Saisir la sous rubrique svp !");
        }else{
            
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
      
        if(stmt.executeUpdate("insert into sousrub(srb,id_r) VALUES('"+rb+"' , "+this.id+")") == 1){
            this.rc2.setText("");
            DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
            dtm2.setRowCount(0) ;
            
             String sql ;
      
            sql= "SELECT * FROM sousrub ORDER BY srb ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
      dtm2.addRow(new Object[]{
          rs.getInt("id_srb") , rs.getString("srb") , rs.getInt("id_r"), rs.getString("type")
      }) ;
     
     }
      
     rs.close();
     
        }
       
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
       
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
        
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed
     int idSrb = 0 ;
     String srb1 = "" ;
    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
         this.idSrb = 0 ;
         this.srb1 = "" ;
        
        this.idSrb = Integer.parseInt(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString()) ;
        this.srb1 = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString() ;
        
        this.rc2.setText(srb1) ;
        this.jLabel1.setText(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 2).toString()) ;
        
        
        
        
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void rc3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rc3KeyReleased
        // TODO add your handling code here:
        
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
      
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        dtm2.setRowCount(0);
        
       String sql ;
      
       sql= "SELECT * FROM sousrub WHERE srb LIKE '%"+this.rc3.getText().trim().replaceAll("'", "''")+"%' ORDER BY srb ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
      dtm2.addRow(new Object[]{
          rs.getInt("id_srb") , rs.getString("srb") , rs.getInt("id_r"), rs.getString("type")
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
     
        
        
        
        
    }//GEN-LAST:event_rc3KeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
        
        
        if(this.jTable2.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selectionner dans le tableau svp !") ;
        }else{        
        
        String rb = "" ;
        
        rb = this.rc2.getText().trim().replaceAll("'", "''") ;
        
        if(rb.isEmpty()){
            JOptionPane.showMessageDialog(this, "Saisir la sous rubrique svp !") ;
        }else{
            
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
      
        if(stmt.executeUpdate("update sousrub SET srb = '"+rb+"' WHERE id_srb = "+this.idSrb) == 1){
            DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
            dtm2.setRowCount(0) ;
            
             String sql ;
      
            sql= "SELECT * FROM sousrub ORDER BY srb ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
      dtm2.addRow(new Object[]{
          rs.getInt("id_srb") , rs.getString("srb") , rs.getInt("id_r"), rs.getString("type")
      }) ;
     
     }
      
     rs.close();
     
        }
       
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
       
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
        }
        
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        
        if(this.jTable2.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selectionner dans le tableau svp !") ;
        }else{        
        
        String rb = "" ;
        
        rb = this.rc2.getText().trim().replaceAll("'", "''") ;
        
        if(rb.isEmpty()){
            JOptionPane.showMessageDialog(this, "Saisir la sous rubrique svp !") ;
        }else{
            
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
      
        if(stmt.executeUpdate("update sousrub SET type = 'non' WHERE id_srb = "+this.idSrb) == 1){
            DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
            dtm2.setRowCount(0) ;
            
             String sql ;
      
            sql= "SELECT * FROM sousrub ORDER BY srb ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
      dtm2.addRow(new Object[]{
          rs.getInt("id_srb") , rs.getString("srb") , rs.getInt("id_r") , rs.getString("type")
      }) ;
     
     }
      
     rs.close();
     
        }
       
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
       
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
        }
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void rc1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rc1FocusGained
        // TODO add your handling code here:
        
          if(this.rc1.getText().equalsIgnoreCase("RECHERCHER")){
        this.rc1.setText("") ;
        }
    }//GEN-LAST:event_rc1FocusGained

    private void rc1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rc1FocusLost
        // TODO add your handling code here:
        
           
        if(this.rc1.getText().equalsIgnoreCase("") || "RECHERCHER".equalsIgnoreCase(this.rc1.getText())){
            this.rc1.setText("RECHERCHER") ;
            
        }
        
    }//GEN-LAST:event_rc1FocusLost

    private void rc2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rc2FocusGained
        // TODO add your handling code here:
        
        if(this.rc2.getText().equalsIgnoreCase("SAISIR UNE SOUS - RUBRIQUE")){
        this.rc2.setText("") ;
        }
    }//GEN-LAST:event_rc2FocusGained

    private void rc2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rc2FocusLost
        // TODO add your handling code here:
             
        if(this.rc2.getText().equalsIgnoreCase("") || "SAISIR UNE SOUS - RUBRIQUE".equalsIgnoreCase(this.rc2.getText())){
            this.rc2.setText("SAISIR UNE SOUS - RUBRIQUE") ;
            
        }
    }//GEN-LAST:event_rc2FocusLost

    private void rc3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rc3FocusLost
        // TODO add your handling code here:
        
             
        if(this.rc3.getText().equalsIgnoreCase("") || "RECHERCHER".equalsIgnoreCase(this.rc3.getText())){
            this.rc3.setText("RECHERCHER") ;
            
        }
    }//GEN-LAST:event_rc3FocusLost

    private void rc3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rc3FocusGained
        // TODO add your handling code here:
          if(this.rc3.getText().equalsIgnoreCase("RECHERCHER")){
        this.rc3.setText("") ;
        }
    }//GEN-LAST:event_rc3FocusGained

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        
        
           this.print.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        
       try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\rub_srb.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql = "select \n" +
"id_srb as ref , srb , sousrub.type as etat , rub\n" +
"from \n" +
"sousrub , rubrique \n" +
"where rubrique.id = sousrub.id_r \n" +
"order by rub asc , srb asc" ;
           
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
        
       this.print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
        
        
    }//GEN-LAST:event_printActionPerformed

    private void gpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gpActionPerformed
        // TODO add your handling code here:
        String groupe = this.gp.getSelectedItem().toString().replaceAll("'", "''").trim() ;
        
        if(groupe.equals("CHOISIR UN GROUPE")){
            this.groupe = "" ;
        }else{
            this.groupe = groupe ;
        }
        
    }//GEN-LAST:event_gpActionPerformed

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
            java.util.logging.Logger.getLogger(Rubrique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rubrique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rubrique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rubrique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rubrique().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox gp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton print;
    private javax.swing.JTextField rb;
    private javax.swing.JTextField rc1;
    private javax.swing.JTextField rc2;
    private javax.swing.JTextField rc3;
    // End of variables declaration//GEN-END:variables
}
