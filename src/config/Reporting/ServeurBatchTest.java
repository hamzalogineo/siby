/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.Reporting;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HAMZA
 */
public class ServeurBatchTest extends javax.swing.JFrame {

    /**
     * Creates new form ServeurBatchTest
     */
    
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
        static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
        static final String USER = "root" ;
        static final String PASS = "interco" ;
        
        
    ArrayList<Articles> list = new ArrayList<Articles>() ;
    ArrayList<String> list_vy = new ArrayList<String>() ;
    
    
    private String magasin ;
    private String desi ;
    private long stock ;
    private long prx ;
    private long qte_ ;
    private long mtt ;
    
    
    
    public ServeurBatchTest() {
        initComponents();
        
        this.setLocationRelativeTo(null) ;
        this.valider.setEnabled(false);
        
        
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
        
        dtm.addRow(new Object[]{"CHAMBRE FROIDE","VIANDE NOIX KG","2000"});
        dtm.addRow(new Object[]{"CHAMBRE FROIDE","FILET BOEUF KG","2000"});
        dtm.addRow(new Object[]{"CHAMBRE FROIDE","POULET LOCAL CRU","3000"});
        dtm.addRow(new Object[]{"CHAMBRE FROIDE","POULET LOCAL CRU.","3500"});
        dtm.addRow(new Object[]{"CHAMBRE FROIDE","FOIE C R MOUTON KG","2000"});
        dtm.addRow(new Object[]{"CHAMBRE FROIDE","PATISSERIE 01","1000"});
        dtm.addRow(new Object[]{"CHAMBRE FROIDE","PATISSERIE 02","1500"});
        dtm.addRow(new Object[]{"CHAMBRE FROIDE","VIANDE MOUTON KG","2500"});
        dtm.addRow(new Object[]{"CHAMBRE FROIDE","ESTOMAC BOEUF","1000"});
        dtm.addRow(new Object[]{"CHAMBRE FROIDE","CHAWARMA VIANDE","1500"});
   
        
        
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
        
        
        
        
        //  ---------  2è choix
              
        
        
        
        
       //   ---------------
        
        
        //
        
       
        
     
        
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        
        dtm2.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm2.setRowCount(0) ;
        
        
        
        
        
        
        
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        qte = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        valider = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        to = new javax.swing.JLabel();
        op = new javax.swing.JComboBox();
        valider1 = new javax.swing.JButton();
        st_1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 204, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "TRAITEMENT PAR LOT DE DONNEE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MAGASIN", "DESCRIPTION", "PRIX"
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
        jTable1.setSelectionBackground(new java.awt.Color(0, 51, 255));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(70);
        }

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MAGASIN", "DESCRIPTION", "QUANTITE", "PRIX"
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
        jTable2.setSelectionBackground(new java.awt.Color(0, 0, 255));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(70);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(70);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUANTITE");

        jButton1.setBackground(new java.awt.Color(51, 0, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AJOUTER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 0, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ANNULER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        valider.setBackground(new java.awt.Color(51, 0, 255));
        valider.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valider.setForeground(new java.awt.Color(255, 255, 255));
        valider.setText("-----------");
        valider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" BON AUTO. DETAIL OP");

        to.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        to.setForeground(new java.awt.Color(255, 255, 255));

        op.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        op.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR OPERATION", "AJOUTER", "SUPPRIMER", "MIS A JOUR" }));
        op.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        op.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opActionPerformed(evt);
            }
        });

        valider1.setBackground(new java.awt.Color(51, 0, 255));
        valider1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valider1.setForeground(new java.awt.Color(255, 255, 255));
        valider1.setText("STOCK ETAT");
        valider1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        valider1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valider1ActionPerformed(evt);
            }
        });

        st_1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        st_1.setForeground(new java.awt.Color(255, 255, 255));
        st_1.setText("STOCK :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(op, 0, 146, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(to, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                    .addComponent(qte, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(valider1)
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(st_1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(valider1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(op, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(st_1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qte, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
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
String vy = "" ;
    private void opActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opActionPerformed
        // TODO add your handling code here:
        
        String op = "" ;
        op = this.op.getSelectedItem().toString() ;
        this.vy = op ;
        
        if(op.isEmpty() || op.equalsIgnoreCase("CHOISIR OPERATION")){
             this.valider.setText("------") ;
            this.valider.setEnabled(false);
        }else{
            
            this.valider.setText("V."+op) ;
            // this.valider.setEnabled(true);
        }
        
    }//GEN-LAST:event_opActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        this.jTable2.getSelectionModel().clearSelection();
        
        this.magasin = "" ;
        this.desi = "" ;
        this.prx = 0 ;
        this.stock = 0 ;
        
        this.magasin = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString().replaceAll("'", "''") ;
        this.desi = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString().replaceAll("'", "''") ;
        this.prx = Long.parseLong(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString()) ;
        
        
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
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      String sql = null ;
      ResultSet rs = null ;
      long stock = 0 ;
       
      sql = "select stock from stock_br_pl where magasin = '"+this.magasin+"' and desi = '"+this.desi+"'" ;
      rs = stmt.executeQuery(sql) ;
       
      
      
     while(rs.next()){
        
         
         stock = rs.getLong("stock") ;
      
     }
      
     this.stock = stock ;
     this.st_1.setText("STOCK : "+this.stock) ;
           
            
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
        
       
         
        
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try{
            String qte = "" ;
                   qte = this.qte.getText().trim() ;
                   if(qte.isEmpty() || this.jTable1.getSelectedRow() == -1){
                      JOptionPane.showMessageDialog(null, "SAISIR LA QUANTITE ET SELECTIONNER A GAUCHE") ; 
                   }else{
                       this.qte_ = 0 ;
                       this.qte_ = Long.parseLong(qte) ;
                       this.mtt = 0 ;
                       
           Articles articles = new Articles(this.magasin, this.desi, this.stock, this.prx, this.qte_, Long.parseLong("0")) ;
           
           if(this.list_vy.contains(new String(this.desi)) || this.vy.equalsIgnoreCase("CHOISIR OPERATION") || this.vy.isEmpty()){
               JOptionPane.showMessageDialog(this, "PRODUIT EXIST DEJA | CHOISIR TYPE OPERATION") ;
           
            }else{
               
             this.list_vy.add(new String(this.desi)) ;
             this.list.add(articles) ;
             this.valider.setEnabled(true) ;
             this.op.setEnabled(false) ;
             
             
             DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
             
             dtm2.addRow(new Object[]{
             // "MAGASIN", "DESCRIPTION", "QUANTITE", "PRIX"
                 
                 articles.getMagasin() , articles.getDesi() , articles.getQte() , articles.getPrx()
                 
             });
           
           
             this.qte.setText("") ;
             
             
           }
                       
                       
                       
                   }
            
            
            
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e.getMessage()) ;
            
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable2.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "CHOISIR DANS LA LIST A DROITE") ;
        }else{
            
            this.list_vy.remove(this.jTable2.getSelectedRow()) ;
            this.list.remove(this.jTable2.getSelectedRow()) ;
            DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                              dtm2.removeRow(this.jTable2.getSelectedRow());
            
                              if(this.list.size() == 0){
                                  this.op.setEnabled(true);
                                  this.op.setSelectedItem(new String("CHOISIR OPERATION"));
                                  this.valider.setEnabled(false) ;
                                  this.valider.setText("-----") ;
                                  
                              }
                              
                              
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
        
         this.jTable1.getSelectionModel().clearSelection();
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed
        // TODO add your handling code here:
        
        /*
        
         AJOUTER
         SUPPRIMER
         MIS A JOUR
        
        */
        
        
        if(this.vy.equalsIgnoreCase("AJOUTER")){
            
            // traitement ajout en lot ou packet de donnee mais pas indivuduellement !
            
            
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
      
      stmt = conn.createStatement() ;
      
      
      //je crai ma requete
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      String sql = null ;
      ResultSet rs = null ;
      
      
      sql = "INSERT INTO stock_br_pl(magasin,desi,stock,prx) VALUES(?,?,?,?)" ;
      ps = conn.prepareStatement(sql) ;
      
      for(int i = 0 ; i < this.list.size() ; i++){
          ps.setString(1, this.list.get(i).getMagasin()) ;
          ps.setString(2, this.list.get(i).getDesi()) ;
          ps.setLong(3, (this.list.get(i).getStock() + this.list.get(i).getQte()) ) ;
          ps.setLong(4, this.list.get(i).getPrx()) ;
          
          ps.addBatch() ;
          
      }
      
      int[] etatLot = ps.executeBatch() ;
      
      
      conn.commit();
      
      System.out.println("Arrays query : "+Arrays.toString(etatLot)) ;
      System.out.println("Nombre de requette(Demande) dans le lot : "+etatLot.length) ;
      
      for(int i = 0 ; i < etatLot.length; i++){
          if(etatLot[i] >= 0){
              System.out.println("ok : "+etatLot[i]) ;
          }else if(etatLot[i] == PreparedStatement.SUCCESS_NO_INFO){
              
              System.out.println("ok : "+etatLot[i]) ;
              
          }else if(etatLot[i] == PreparedStatement.EXECUTE_FAILED){
              
              System.out.println("Failed (requette perdue): "+etatLot[i]) ;
              
          }
          
      }
      
      
      this.list.removeAll(this.list) ;
      this.list_vy.removeAll(this.list_vy) ;
      DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                        dtm2.setRowCount(0) ;
                        this.qte.setText("") ;
                        
                       if(this.list.size() == 0){
                           
                                  this.op.setEnabled(true);
                                  this.op.setSelectedItem(new String("CHOISIR OPERATION"));
                                  this.valider.setEnabled(false) ;
                                  this.valider.setText("-----") ;
                                  
                              }
                       
                       
                       DetailTechnique dt = new DetailTechnique(etatLot) ;
                                       dt.setVisible(true) ;
      
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
                       
//    rs.close();
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
        
       
            
        
            JOptionPane.showMessageDialog(this, "AJOUT PAR LOT FIN !!!") ;
            
            
        }else if(this.vy.equalsIgnoreCase("SUPPRIMER")){
            // traitement de suppression en lot ou packet de donnee mais pas indivuduellement !
            
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
      
      stmt = conn.createStatement() ;
      
      
      //je crai ma requete
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      String sql = null ;
      ResultSet rs = null ;
      
      
      sql = "DELETE FROM stock_br_pl WHERE magasin = ? AND desi = ?" ;
      ps = conn.prepareStatement(sql) ;
      
      for(int i = 0 ; i < this.list.size() ; i++){
          ps.setString(1, this.list.get(i).getMagasin()) ;
          ps.setString(2, this.list.get(i).getDesi()) ;
          
          
          ps.addBatch() ;
          
      }
      
      int[] etatLot = ps.executeBatch() ;
      
      
      conn.commit();
      
      System.out.println("Arrays query : "+Arrays.toString(etatLot)) ;
      System.out.println("Nombre de requette(Demande) dans le lot : "+etatLot.length) ;
      
      for(int i = 0 ; i < etatLot.length; i++){
          if(etatLot[i] >= 0){
              System.out.println("ok : "+etatLot[i]) ;
          }else if(etatLot[i] == PreparedStatement.SUCCESS_NO_INFO){
              
              System.out.println("ok : "+etatLot[i]) ;
              
          }else if(etatLot[i] == PreparedStatement.EXECUTE_FAILED){
              
              System.out.println("Failed (requette perdue): "+etatLot[i]) ;
              
          }
          
      }
      
      
      this.list.removeAll(this.list) ;
      this.list_vy.removeAll(this.list_vy) ;
      DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                        dtm2.setRowCount(0) ;
                        this.qte.setText("") ;
                        
                       if(this.list.size() == 0){
                           
                                  this.op.setEnabled(true);
                                  this.op.setSelectedItem(new String("CHOISIR OPERATION"));
                                  this.valider.setEnabled(false) ;
                                  this.valider.setText("-----") ;
                                  
                              }
                       
                       
                       DetailTechnique dt = new DetailTechnique(etatLot) ;
                                       dt.setVisible(true) ;
      
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
                       
//    rs.close();
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
        
       
            
            
            
            JOptionPane.showMessageDialog(this, "SUPPRESSION PAR LOT FIN !!!") ;
            
        }else if(this.vy.equalsIgnoreCase("MIS A JOUR")){
            
            // traitement de MIS A JOUR en lot ou packet de donnee mais pas indivuduellement !
            
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
      
      stmt = conn.createStatement() ;
      
      
      //je crai ma requete
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      String sql = null ;
      ResultSet rs = null ;
      
      
      sql = "UPDATE stock_br_pl SET stock = ? WHERE magasin = ? AND desi = ?" ;
      ps = conn.prepareStatement(sql) ;
      
      for(int i = 0 ; i < this.list.size() ; i++){
          
          ps.setLong(1, (this.list.get(i).getStock() + this.list.get(i).getQte()) ) ;
          ps.setString(2, this.list.get(i).getMagasin()) ;
          ps.setString(3, this.list.get(i).getDesi()) ;
          
        
          
          ps.addBatch() ;
          
      }
      
      int[] etatLot = ps.executeBatch() ;
      
      
      conn.commit();
      
      System.out.println("Arrays query : "+Arrays.toString(etatLot)) ;
      System.out.println("Nombre de requette(Demande) dans le lot : "+etatLot.length) ;
      
      for(int i = 0 ; i < etatLot.length; i++){
          if(etatLot[i] >= 0){
              System.out.println("ok : "+etatLot[i]) ;
          }else if(etatLot[i] == PreparedStatement.SUCCESS_NO_INFO){
              
              System.out.println("ok : "+etatLot[i]) ;
              
          }else if(etatLot[i] == PreparedStatement.EXECUTE_FAILED){
              
              System.out.println("Failed (requette perdue): "+etatLot[i]) ;
              
          }
          
      }
      
      
      this.list.removeAll(this.list) ;
      this.list_vy.removeAll(this.list_vy) ;
      DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                        dtm2.setRowCount(0) ;
                        this.qte.setText("") ;
                        
                       if(this.list.size() == 0){
                           
                                  this.op.setEnabled(true);
                                  this.op.setSelectedItem(new String("CHOISIR OPERATION"));
                                  this.valider.setEnabled(false) ;
                                  this.valider.setText("-----") ;
                                  
                              }
      
            
                       DetailTechnique dt = new DetailTechnique(etatLot) ;
                                       dt.setVisible(true) ;
                                       
                                       
                       
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
                       
//    rs.close();
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
        
       
            
            
            
            JOptionPane.showMessageDialog(this, "MIS A JOUR PAR LOT FIN !!!") ;
            
        }else{
            
            
           JOptionPane.showMessageDialog(this, "PAS DE TRAITEMENT !!!") ;
            
           
        }
            
        
        
        
        
    }//GEN-LAST:event_validerActionPerformed

    private void valider1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valider1ActionPerformed
        // TODO add your handling code here:
        
        Stock_etat st_et = new Stock_etat() ;
                   st_et.setVisible(true) ;
                   
    }//GEN-LAST:event_valider1ActionPerformed

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
            java.util.logging.Logger.getLogger(ServeurBatchTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServeurBatchTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServeurBatchTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServeurBatchTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServeurBatchTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox op;
    private javax.swing.JTextField qte;
    private javax.swing.JLabel st_1;
    private javax.swing.JLabel to;
    private javax.swing.JButton valider;
    private javax.swing.JButton valider1;
    // End of variables declaration//GEN-END:variables
}
