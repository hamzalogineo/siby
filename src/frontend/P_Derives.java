/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.Clients1.DB_URL;
import static frontend.Op_Pl.JDBC_DRIVER;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HAMZA
 */
public class P_Derives extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      String login ;
      String role ;
      long idmp = 0 ;
      int idp = 0 ;
      String pere ;
      Integer id ;
      String produit ;
      
      String derive_p ;
      String pereToDelete ;
      
      
    public P_Derives() {
        initComponents();
        this.setLocationRelativeTo(null) ;
        
    }
    
    public P_Derives(String login) {
        initComponents();
        this.setLocationRelativeTo(null) ;
        this.login = login ;
        
        
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
      
     
      
           
           DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
           dtm.setRowCount(0);
           
            
           
          String sql = "" ;
                 sql = "select * from produits_pl , matieres_p "
                     + "where matieres_p.id = produits_pl.matieres_id order by description ASC" ;
                 ResultSet rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                 
                     dtm.addRow(new Object[]{
                   
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
                     
                     rs2.getString("produits_f.description") ,
                     rs2.getString("produits_f.libelle") ,
                     rs2.getString("produits_f.pu") 
                             
                     
                     }) ;
               
       }
               
                 
                   
                                   
               
                 
               
                 sql = "select description_d , pere , derive_pl.id as ref from p_derive , derive_pl "
                         + "where derive_pl.produit = p_derive.description_d order by description_d ASC" ;
                rs = stmt.executeQuery(sql) ;
                 while(rs.next()){
                     
                     //  "ID", "DESCRIPTION PRODUIT DERIVE", "PRODUIT PERE", "ACTIVER"
                     
                     dtm2.addRow(new Object[]{
                     rs.getInt("ref") , rs.getString("description_d") , rs.getString("pere")
                     });
                     
                 }
                 
                 
                 sql = "select * from derive_pl where not type = 'non' order by produit asc" ;
                 rs = stmt.executeQuery(sql) ;
                 while(rs.next()){
                     this.derive.addItem(new String(rs.getString("produit"))) ;
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
        desc2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        derive = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GESTION DES PRODUITS DERIVES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 16))); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPTION", "P.A", "P.U"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(220);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(15);
        }

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_PRODUIT_D", "DESCRIPTION PRODUIT DERIVE", "PRINCIPAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(220);
        }

        desc2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desc2KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("DESCRIPTION DU PRODUIT PRINCIPAL");

        rch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rchKeyReleased(evt);
            }
        });

        jLabel2.setText("RECHERCHER");

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jButton1.setText("AFFECTER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("IMPRIMER");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setText("LISTE P . DERIVE");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        derive.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        derive.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECTIONNER UN PRODUIT DERIVE" }));
        derive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jButton2.setText("SUPPRIMER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("ACTUALISER");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(derive, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(desc2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(367, 367, 367))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rch, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(desc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(derive, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1345, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;

                dtm.setRowCount(0) ;

                String sql ;

                sql= "SELECT distinct id FROM matieres_p WHERE description = '"+d1+"'" ;

                ResultSet rs = stmt.executeQuery(sql) ;

                while(rs.next()){

                    this.idmp = rs.getLong("id") ;

                }

                String sql10 ;

                sql10= "SELECT distinct id FROM produits_f WHERE description = '"+d1+"'" ;

                ResultSet rs10 = stmt.executeQuery(sql10) ;

                while(rs10.next()){

                    this.idp = rs10.getInt("id") ;

                }

                int vyp = 0 ;

                String sql11  ;

                sql11 = "SELECT distinct id FROM produits_f WHERE id = "+this.idp ;

                ResultSet rs11 = stmt.executeQuery(sql11) ;

                while(rs11.next()){

                    vyp = 1 ;

                }

                int vym = 0 ;

                String sql12  ;

                sql12 = "SELECT distinct id FROM matieres_p WHERE id = "+this.idmp ;

                ResultSet rs12 = stmt.executeQuery(sql12) ;

                while(rs12.next()){

                    vym = 1 ;

                }

                if(vym == 1){

                    String sql0 = "" ;
                    sql0 = "select * from produits_pl , matieres_p "
                    + "where matieres_id = "+this.idmp+" AND matieres_p.id = matieres_id order by description ASC" ;
                    ResultSet rs0 = stmt.executeQuery(sql0) ;

                    while(rs0.next()){

                        dtm.addRow(new Object[]{
                            
                            rs0.getString("matieres_p.description") ,
                            rs0.getString("matieres_p.prx_a_unite") ,
                            rs0.getString("matieres_p.prx_v_unite")

                        }) ;

                    }

                }else if(vyp == 1){

                    String sql0 = "" ;
                    sql0 = "select * from produits_pl , produits_f "
                    + "where produits_id = "+this.idp+" AND produits_f.id = produits_id order by description ASC" ;

                    ResultSet rs0 = stmt.executeQuery(sql0) ;

                    while(rs0.next()){

                        dtm.addRow(new Object[]{
                          
                            rs0.getString("produits_f.description") ,
                            rs0.getString("produits_f.libelle") ,
                            rs0.getString("produits_f.pu")

                        }) ;

                    }

                }else if(vym == 0 && vyp == 0){

                    //   JOptionPane.showMessageDialog(this, "Produit introuvable !!! ") ;

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

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        this.pere = "" ;
        this.pere = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString().replaceAll("'", "''") ;
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "SELECTIONNER LE PRODUIT PERE DANS LE TABLEAU") ;
        }else{
            
            String derive ;
                   derive = this.derive.getSelectedItem().toString().replaceAll("'", "''") ;
                   
                   if(derive.equals("SELECTIONNER UN PRODUIT DERIVE")){
                       JOptionPane.showMessageDialog(this, "SELECTIONNER LE PRODUIT DERIVE") ;
                   }else{
                       
                        Connection conn = null ;
                        Statement stmt = null  ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...") ;
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
        String type , dtec ;
               type = "OUI" ;
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
             dtec = sdf.format(new Date()) ;
       
        if(stmt.executeUpdate("insert into p_derive(description_d,pere,type,dtec,admin) values('"+derive+"' , '"
                +this.pere+"' , '"+type+"' , '"+dtec+"' , '"+this.login+"')") == 1){ 
            
                 DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                                   dtm.setRowCount(0) ;
                                  
     // "ID_PRODUIT_D", "DESCRIPTION PRODUIT DERIVE", "PRODUIT PERE"                            
               
                 String sql ;
                 sql = "select description_d , pere , derive_pl.id as ref from p_derive , derive_pl "
                         + "where derive_pl.produit = p_derive.description_d order by description_d ASC" ;
                 ResultSet rs = stmt.executeQuery(sql) ;
                 while(rs.next()){
                     
                     //  "ID", "DESCRIPTION PRODUIT DERIVE", "PRODUIT PERE", "ACTIVER"
                     
                     dtm.addRow(new Object[]{
                     rs.getInt("ref") , rs.getString("description_d") , rs.getString("pere")
                     });
                     
                 }
                 
                 rs.close();
                 this.derive.setSelectedItem(new String("SELECTIONNER UN PRODUIT DERIVE"));
                 this.jTable1.getSelectionModel().clearSelection();
                 // fin d'instruction java :
            
        }
      
      
      // fin partie unitile :
      
      
          
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
        
        
        
    // end saveing .....
        
        
                       
                       
                   }
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
        this.id = 0 ;
        this.produit = "" ;
        this.derive_p = "" ;
        this.pereToDelete = "" ;
        
        this.id = Integer.parseInt(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString()) ;
        this.produit = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString() ;
        
        this.derive_p = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString() ;
        this.pereToDelete = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 2).toString() ;
        
     //   this.derive.setText(this.produit) ;
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        
        this.jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
          try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Derive.jrxml")) ;
           //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\new-version-siby\\UtpaSibyCenter\\src\\reports\\clientss.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql = "select description_d , pere , p_derive.type as type , dtec , admin , derive_pl.id as id from p_derive , derive_pl "
                         + "where derive_pl.produit = description_d order by pere ASC" ;
           
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql) ;
           jd.setQuery(newQuery) ;
           JasperReport jr = JasperCompileManager.compileReport(jd) ;
           HashMap para = new HashMap() ;
           
           
           JasperPrint j = JasperFillManager.fillReport(jr, para, DriverManager.getConnection(DB_URL,USER,PASS)) ;
          
           JasperViewer.viewReport(j , false) ;
           
           /*
           MyJasperViewerPrint jv = new MyJasperViewerPrint(j, false);
         
            jv.setVisible(true);
           */
           
       //    JasperViewer.viewReport(j , false) ;
           
           /*
                 JasperPrint jp = JasperFillManager.fillReport(url.openStream(), map, conn);
 
                 MyJasperViewer jv = new MyJasperViewer(jp, false);
                 jv.setVisible(true);     
             
           */
           
          
         // ((JPanel) jRViewer.getComponent(0)).setEnabled(false); 
           
           
           
           // JasperViewer.viewReport(j , false) ;
          
        //    ((JPanel)jRViewer.getComponent(0)).remove(0);

         // ((JPanel) jRViewer.getComponent(0).Remove(0);
          
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
      
          this.jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void rchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rchKeyReleased
       
        // TODO add your handling code here:
        
           String rch ;
               rch = this.rch.getText().trim().replaceAll("'", "''") ;
               
               if(rch.equals("")){
                   
               }else{
        
                         Connection conn = null ;
                         Statement stmt = null  ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...") ;
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
      
            
                 DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                                   dtm.setRowCount(0) ;
                                   
               
                 String sql ;
                 sql = "select description_d , pere , derive_pl.id as ref from p_derive , derive_pl "
                         + "where description_d like '%"+rch+"%' AND derive_pl.produit = p_derive.description_d order by description_d ASC" ;
                 ResultSet rs = stmt.executeQuery(sql) ;
                 while(rs.next()){
                     
                     //  "ID", "DESCRIPTION PRODUIT DERIVE", "PRODUIT PERE", "ACTIVER"
                     
                     dtm.addRow(new Object[]{
                     rs.getInt("ref") , rs.getString("description_d") , rs.getString("pere")
                     });
                     
                 }
                 
                 
                 rs.close();
                  
                 this.jTable1.getSelectionModel().clearSelection();
                 // fin d'instruction java :
            
     
      
      
      // fin partie unitile :
      
      
          
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
        
        
        
    // end saveing .....
        
               }
        
    }//GEN-LAST:event_rchKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        Derive_Pl dpl = new Derive_Pl() ;
                  dpl.setVisible(true) ;
                  
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        if(this.jTable2.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "SELECTIONNER L'AFFECTATION") ;
        }else{
        
                        Connection conn = null ;
                        Statement stmt = null  ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...") ;
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
        
        if(stmt.executeUpdate("delete from p_derive where description_d = '"+this.derive_p.replaceAll("'", "''")+"' and pere = '"
                +this.pereToDelete.replaceAll("'", "''")+"'") > 0){ 
            
                 DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                                   dtm.setRowCount(0) ;
                                  
     // "ID_PRODUIT_D", "DESCRIPTION PRODUIT DERIVE", "PRODUIT PERE"                            
               
                 String sql ;
                 sql = "select description_d , pere , derive_pl.id as ref from p_derive , derive_pl "
                         + "where derive_pl.produit = p_derive.description_d order by description_d ASC" ;
                 ResultSet rs = stmt.executeQuery(sql) ;
                 while(rs.next()){
                     
                     //  "ID", "DESCRIPTION PRODUIT DERIVE", "PRODUIT PERE", "ACTIVER"
                     
                     dtm.addRow(new Object[]{
                     rs.getInt("ref") , rs.getString("description_d") , rs.getString("pere")
                     });
                     
                 }
                 
                 rs.close();
                 this.derive.setSelectedItem(new String("SELECTIONNER UN PRODUIT DERIVE"));
                 this.jTable1.getSelectionModel().clearSelection();
                 this.jTable2.getSelectionModel().clearSelection();
                 
                 // fin d'instruction java :
            
        }
      
      
      // fin partie unitile :
      
      
          
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
        
        
        
    // end saveing .....
        
        
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        P_Derives pd = new P_Derives(this.login) ;
                  pd.setVisible(true) ;
                  
                  this.setVisible(false) ;
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(P_Derives.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(P_Derives.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(P_Derives.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(P_Derives.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P_Derives().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox derive;
    private javax.swing.JTextField desc2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField rch;
    // End of variables declaration//GEN-END:variables
}
