/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.Op_Pl.JDBC_DRIVER;
import static frontend.ProduitFini.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author HAMZA
 */
public class Op_pl_final extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      
      String login = "" ;
      String role = "" ;
      
      long to = 0 ;
      long mtt = 0;
      
      String description = "" ;
      long old_stock_depart = 0 ;
      long old_stock_arriver = 0 ;
      long new_stock_depart = 0;
      long new_stock_arriver =0;
      String p_depart = "";
      String p_arriver ="";
      String comm_ ="";
      String motif_ ="";
      long qte_ = 0;
      String comt_ ="";
      float pm_depart =0;
      float pm_arriver =0;
      int vy_pderive =0;
      int vy_derive = 0 ;
      Integer cb =0;
      String rapport ="";
      String etat = "" ;
      
      
      ArrayList<Transaction_pl> list = new ArrayList<Transaction_pl>() ;
      ArrayList<String> vy_list = new ArrayList<String>() ;
      
      List bonList = new ArrayList() ;
      
      // id produit in our stock :
      Integer id_st ;
      Integer id_st_d ;
      
    public Op_pl_final() {
        initComponents();
        
        this.setLocationRelativeTo(null) ;
        
    }
    
    public Op_pl_final(String login, String role) {
        initComponents();
        
        this.login = login ;
        this.role = role ;
         this.valider.setEnabled(false);
        
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
       
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
        dtm1.setRowCount(0) ;
        
        
        // tableau 2 :
        
         this.jTable2.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable2.getTableHeader().setOpaque(false); 
            this.jTable2.getTableHeader().setBackground(Color.black); 
          
            this.jTable2.getTableHeader().setForeground(Color.white) ;
        
              this.jTable2.setRowHeight(25) ;
             
                  headerRenderer.setBackground(Color.green) ;
                  headerRenderer.setForeground(Color.BLACK) ;
                  headerRenderer.setFont(new Font("Segoe UI" , Font.BOLD , 16)) ;

                  for (int i = 0; i < this.jTable2.getModel().getColumnCount(); i++) {
                    this.jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
       
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        dtm2.setRowCount(0) ;
        
        
        this.pd.setSelected(true) ;
        
        // select query :
        
         Connection conn = null ;
         Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver :
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
     
     sql = "select * from produits_pl , matieres_p "
                     + "where matieres_p.id = produits_pl.matieres_id order by description ASC" ;
      rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                 
                     dtm1.addRow(new Object[]{
                   
                     rs.getString("matieres_p.description") ,
                     rs.getString("matieres_p.prx_a_unite") ,
                     rs.getString("matieres_p.prx_v_unite")  
                             
                     // matieres_p.prx_v_unite
                             
                     }) ;
                     
                     
                 }
                 
                 sql = "select * from produits_pl , produits_f "
                     + "where produits_f.id = produits_pl.produits_id order by description ASC" ;
                 rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                 
                     dtm1.addRow(new Object[]{
                     
                     rs.getString("produits_f.description") ,
                     rs.getString("produits_f.libelle") ,
                     rs.getString("produits_f.pu") 
                             
                     
                     }) ;
               
       }
                 
                 
  sql = "select * from p_derive group by description_d order by description_d asc" ;
  rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                 
                     dtm1.addRow(new Object[]{
                   
                     rs.getString("description_d") ,
                    "0" ,
                    "0"  
                             
                     
                     }) ;
                     
                     
                 }
                 
                 
             sql = "select placement from point_pl where type = 'oui' order by placement ASC" ;
             rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                 
                  this.depart.addItem(rs.getString("placement")) ;
                  this.arriver.addItem(rs.getString("placement")) ;
                  
               
       }
                 
                 
 sql = "select perso from perso_t where type = 'oui' AND domaine = 'PL' OR domaine = 'CL_PL' order by perso ASC" ;
 rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                 
                  this.comm.addItem(rs.getString("perso")) ;
                  
                  
               
       }
                 
 sql = "select motif from motif_pl where type = 'oui' order by motif ASC" ;
 rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                 
                this.motif.addItem(rs.getString("motif")) ;
               
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
        
        
        
        // end for select query :
        
        
        
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
        jLabel1 = new javax.swing.JLabel();
        desc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        stock = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pm = new javax.swing.JTextField();
        p = new javax.swing.JCheckBox();
        d = new javax.swing.JCheckBox();
        pd = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        depart = new javax.swing.JComboBox();
        arriver = new javax.swing.JComboBox();
        comm = new javax.swing.JComboBox();
        motif = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        qte = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comt = new javax.swing.JTextField();
        ajouter = new javax.swing.JButton();
        annuler = new javax.swing.JButton();
        valider = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        total = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INITIER L'OPERATION PLACEMENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("           DESCRIPTION");

        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("STOCK :");

        stock.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("P.M :");

        pm.setEditable(false);

        p.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        p.setText("PRINCIPAL");
        p.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pMouseReleased(evt);
            }
        });

        d.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        d.setText("P.DERIVE");
        d.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dMouseReleased(evt);
            }
        });

        pd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pd.setText("P & D");
        pd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pdMouseReleased(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPTION", "P A", "P U"
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(280);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(280);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PARAMETTRE PLACEMENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        depart.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        depart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DEPART" }));
        depart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        depart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departActionPerformed(evt);
            }
        });

        arriver.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        arriver.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ARRIVER" }));
        arriver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        arriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arriverActionPerformed(evt);
            }
        });

        comm.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        comm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "COMMISSIONNAIRE" }));
        comm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commActionPerformed(evt);
            }
        });

        motif.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        motif.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MOTIF" }));
        motif.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        motif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motifActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("QTE");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("        COMMENTAIRE");

        ajouter.setBackground(new java.awt.Color(0, 0, 255));
        ajouter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ajouter.setForeground(new java.awt.Color(255, 255, 255));
        ajouter.setText("AJOUTER");
        ajouter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        annuler.setBackground(new java.awt.Color(51, 0, 255));
        annuler.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        annuler.setForeground(new java.awt.Color(255, 255, 255));
        annuler.setText("ANNULER");
        annuler.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerActionPerformed(evt);
            }
        });

        valider.setBackground(new java.awt.Color(51, 0, 255));
        valider.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valider.setForeground(new java.awt.Color(255, 255, 255));
        valider.setText("VALIDER");
        valider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("        DATE :");

        total.setEditable(false);
        total.setForeground(new java.awt.Color(102, 0, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("                 TOTAL MONTANT :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(depart, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(arriver, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(comm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(motif, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(comt)
            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(total, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(qte)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 63, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(valider, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(annuler, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addComponent(ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(63, 63, 63))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(depart, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(arriver, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comm, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(motif, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(qte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPTION", "QTE", "P U", "MONTANT"
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
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(215);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(215);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(desc)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(d, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pd, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(pm))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(pm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p)
                    .addComponent(d)
                    .addComponent(pd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void descKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyReleased
        // TODO add your handling code here:
        
        
        
        String d1 = this.desc.getText().trim().replaceAll("'", "''") ;

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

                String sql = null ;

                sql = "SELECT * FROM produits_pl WHERE recherche like '%"+d1+"%' order by recherche ASC" ;

                ResultSet rs = null ;
                          rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    
                    dtm.addRow(new Object[]{
                    
                        rs.getString("recherche") , rs.getLong("pa") , rs.getLong("pu")
                    
                    });
                    
                }
                
                
                if(this.p.isSelected() == true){
                    
                }else if(this.p.isSelected() == false){
                
                
                sql = "select produit from derive_pl where produit like '%"+d1+"%' and not type = 'non'" ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    dtm.addRow(new Object[]{
                    rs.getString("produit") , 0 , 0
                    }) ;
                }
                
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

        
        
        
    }//GEN-LAST:event_descKeyReleased

    private void pMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMouseReleased
        // TODO add your handling code here:
        
        
         if(this.p.isSelected()){
            this.d.setSelected(false) ;
            this.pd.setSelected(false) ;
            
          
        
             Connection conn = null ;
             Statement  stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
     
      
           
           DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
           dtm.setRowCount(0);
           
          String sql = null ;
                 sql = "select * from produits_pl , matieres_p "
                     + "where matieres_p.id = produits_pl.matieres_id order by description ASC" ;
                 ResultSet rs = null ;
                           rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                 
                     dtm.addRow(new Object[]{
                   
                     rs.getString("matieres_p.description") ,
                     rs.getString("matieres_p.prx_a_unite") ,
                     rs.getString("matieres_p.prx_v_unite")  
                             
                     
                     }) ;
                     
                     
                 }
                 
                 
                 sql = "select * from produits_pl , produits_f "
                     + "where produits_f.id = produits_pl.produits_id order by description ASC" ;
                 rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                 
                     dtm.addRow(new Object[]{
                     
                     rs.getString("produits_f.description") ,
                     rs.getString("produits_f.libelle") ,
                     rs.getString("produits_f.pu") 
                             
                     
                     }) ;
               
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
        
            
            
             
       
       
            
        }else{
            
            
        }
        
        
        
        
        
        
    }//GEN-LAST:event_pMouseReleased

    private void dMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dMouseReleased
        // TODO add your handling code here:
        
        if(this.d.isSelected()){
            this.p.setSelected(false) ;
            this.pd.setSelected(false) ;
            
          
        
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
                 sql = "select * from p_derive group by description_d order by description_d asc" ;
                 ResultSet rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                 
                     dtm.addRow(new Object[]{
                   
                     rs.getString("description_d") ,
                    "0" ,
                    "0"  
                             
                     
                     }) ;
                     
                     
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
        
            
            
             
       
       
            
        }else{
            
            
        }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_dMouseReleased

    private void pdMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdMouseReleased
        // TODO add your handling code here:
        
         if(this.pd.isSelected()){
            this.d.setSelected(false) ;
            this.p.setSelected(false) ;
            
          
        
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
           
          String sql = null ;
                 sql = "select * from produits_pl , matieres_p "
                     + "where matieres_p.id = produits_pl.matieres_id order by description ASC" ;
                 ResultSet rs = null ; 
                           rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                 
                     dtm.addRow(new Object[]{
                   
                     rs.getString("matieres_p.description") ,
                     rs.getString("matieres_p.prx_a_unite") ,
                     rs.getString("matieres_p.prx_v_unite")  
                             
                     
                     }) ;
                     
                     
                 }
                 
                 
                 sql = "select * from produits_pl , produits_f "
                     + "where produits_f.id = produits_pl.produits_id order by description ASC" ;
                       rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                 
                     dtm.addRow(new Object[]{
                     
                     rs.getString("produits_f.description") ,
                     rs.getString("produits_f.libelle") ,
                     rs.getString("produits_f.pu") 
                             
                     
                     }) ;
               
       }
                 
                 
                 
               
                 sql = "select * from p_derive group by description_d order by description_d" ;
                 rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                 
                     dtm.addRow(new Object[]{
                   
                     rs.getString("description_d") ,
                    "0" ,
                    "0"  
                             
                     
                     }) ;
                     
                     
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
        
            
            
             
       
       
            
        }else{
            
            
        }
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_pdMouseReleased

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed
        // TODO add your handling code here:
        
        ArrayList<Integer> error = new ArrayList<Integer>() ;
        
                           error.add(Integer.parseInt(new String("0"))) ;
        
        this.jDateChooser1.setEnabled(false) ;
                        
                                     
          String q_s_2 = "UPDATE stock_pl SET stock_dispo = ? , prx_pm = ? , p_m_d = ? WHERE magasin = ? AND description = ?" ;
                                     
                                     
        
        this.valider.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
        this.bonList.removeAll(this.bonList) ;
        
         Connection conn = null ;
         Statement  stmt = null ;
      
         PreparedStatement ps2 = null ;
         
       
       try{
      //STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;
      conn.setAutoCommit(false) ;
      

      //STEP 4: Execute a query
      //System.out.println("Creating statement...") ;
      
      stmt = conn.createStatement() ;
      ps2 = conn.prepareStatement(q_s_2) ;
      
      String sql = null ;
      ResultSet rs = null ;
      
      String dte1 = "" ;
      String dte2 = "" ;
      
      
      try{
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" , Locale.getDefault()) ;
        SimpleDateFormat sdfT1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
       
        dte1 = sdfT1.format(new Date()) ;
        dte2 = sdf.format(this.jDateChooser1.getDate()) ;
        
        if(this.list.size() > 0){
             
             this.cb = 0 ;
        
        Random rx = new Random() ;
        
        this.cb = rx.nextInt() ;
        
        if(this.cb < 0){
            this.cb = Math.abs(this.cb) ;
        }
         
        int vy ;
            vy = 0 ;
            sql = "select * from op_pl_f where cb = "+this.cb ;
            rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                vy = 1 ;
                error.add(Integer.parseInt(new String("1"))) ;
             }
             
             
            
                  
      
      if(vy == 0){
          
          int i = 0 ;
          
          
          if(stmt.executeUpdate("insert into op_pl_f(cb,date1,date2,depart,arriver,perso,motif,etat,admin,comt) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+dte2+"' , '"+this.list.get(i).getP_depart().replaceAll("'", "''")+"' , '"
          +this.list.get(i).getP_arriver().replaceAll("'", "''")+"' , '"+this.list.get(i).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(i).getMotif_().replaceAll("'", "''")+"' , '"
                  +this.list.get(i).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' , '"+this.comt.getText().trim().replaceAll("'", "''")+"' )") == 1){
  
              
               long tmtt = 0 ;
              
              for(int ii = 0 ; this.list.size() > ii ; ii++){
                  
                  long old_stock_depart = 0 ;
                  long old_stock_arriver = 0 ;
                  long new_stock_depart = 0 ;
                  long new_stock_arriver = 0 ;
                  
                  
                  
                  
                  
                   HashMap<String, Object> m = new HashMap<>() ;
                   
                   m.put("description", this.list.get(ii).getDescription()) ;
                   m.put("qte", nf3.format(this.list.get(ii).getQte_())) ;
                   m.put("pu", nf3.format(this.list.get(ii).getPm_depart())) ;
                   m.put("mtt", this.list.get(ii).getMtt()) ;
                              tmtt += this.list.get(ii).getMtt() ;
                   m.put("tmtt", "TOTAL MTT : "+nf3.format(tmtt)) ;
                              
                              this.bonList.add(m) ;
                              
                              
                               if(this.list.get(ii).getMotif_().equalsIgnoreCase("DECOUPAGE")){
                                  
                               
                                  
                                 int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'" ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                 
                                 if(vy0 == 0){
                                     
                                     error.add(Integer.parseInt(new String("1"))) ;
                                     JOptionPane.showMessageDialog(this, "PAS DE STOCK ") ;
                                     
                                     
                                 }else if(vy0 == 1){
                                      
                                     sql = "select stock_dispo from stock_pl where magasin = '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' "
                                             + "and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'" ;
                                     rs = stmt.executeQuery(sql) ;
                                     while(rs.next()){
                                         old_stock_depart = rs.getLong("stock_dispo") ;
                                     }
                                     
                                     if(old_stock_depart == this.list.get(ii).getOld_stock_depart()){
                                     
                                      
                                              // detail stock placement     :
                                         
                                         
stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
          + this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "+0+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getOld_stock_depart()+" , "+this.list.get(ii).getOld_stock_arriver()+")" ) ;
                                     
                         // "UPDATE stock_pl SET stock_dispo = ? , prx_pm = ? , p_m_d = ? WHERE magasin = ? AND description = ?" 
                         
                                     ps2.setLong(1, this.list.get(ii).getNew_stock_depart()) ;                                   
                                     ps2.setFloat(2, this.list.get(ii).getPm_depart());
                                     ps2.setFloat(3, this.list.get(ii).getPm_depart());
                                     ps2.setString(4, this.list.get(ii).getP_depart());
                                     ps2.setString(5, this.list.get(ii).getDescription());
                                     
                                     
                                     // add batch : 
                                     
                                 //    ps2.addBatch() ;
                                     
                                     ps2.executeUpdate() ;
                                    
                                               
                                              
       stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0 +" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) ;
                 
                 // if detail_pl is incerted :
                 
                                                  
                       
                 
                 
                 
             
                                              
                                       // fin detail_pl :       
                                              
                                 }else{
                                      
                      if(old_stock_depart >= this.list.get(ii).getQte_()){
                          
                          
                                new_stock_depart = (old_stock_depart - this.list.get(ii).getQte_()) ;
                                
                                 // detail stock placement     :
                                         
                                         
            stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
          + this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "+0+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+old_stock_depart+" , "+this.list.get(ii).getOld_stock_arriver()+")" ) ;
                                     
                         // "UPDATE stock_pl SET stock_dispo = ? , prx_pm = ? , p_m_d = ? WHERE magasin = ? AND description = ?" 
                         
                                     ps2.setLong(1, new_stock_depart) ;                                   
                                     ps2.setFloat(2, this.list.get(ii).getPm_depart());
                                     ps2.setFloat(3, this.list.get(ii).getPm_depart());
                                     ps2.setString(4, this.list.get(ii).getP_depart());
                                     ps2.setString(5, this.list.get(ii).getDescription());
                                     
                                     
                                     // add batch : 
                                     
                                 //    ps2.addBatch() ;
                                     
                                     ps2.executeUpdate() ;
                                    
                                               
                                              
       stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0 +" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) ;
                 
                 // if detail_pl is incerted :
                 
                                                  
                       
                 
                 
                 
             
                                              
                                       // fin detail_pl :    
                                
                                
                                
                                
                              
                                
                            }else{
                                 
                                error.add(Integer.parseInt(new String("1"))) ;
                                JOptionPane.showMessageDialog(null, "STOCK INSUFFISANT A CAUSE D'ACCES CONCURRENCIEL REPRENER L'OPERATION STOCK ACTUEL : "+old_stock_depart) ;
                            }
                                         
                                     
                                     
                                     
                                     }
                                     
                                     
                                     
                                     
                                         
                                 }
                            
                                  
                              }else if(this.list.get(ii).getMotif_().equalsIgnoreCase("DECOUPAGE") == false){
                               
                               
                                    int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                  int av = 0 ;
                                         sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getP_arriver().replaceAll("'" , "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                         rs = stmt.executeQuery(sql) ;
                                         while(rs.next()){
                                             av = 1 ;
                                         }
                                 
                                 
                                 if(vy0 == 0){
                                     
                                     error.add(Integer.parseInt(new String("1"))) ;
                                     JOptionPane.showMessageDialog(this, "PAS DE STOCK ") ;
                                     
                                     
                                 }else if(vy0 == 1){
                                     
                                     
                                   
                                      // je suis ici :
                                     
                                  
                               sql = "select stock_dispo from stock_pl where magasin = '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' "
                                             + "and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'" ;
                                     rs = stmt.executeQuery(sql) ;
                                     while(rs.next()){
                                         old_stock_depart = rs.getLong("stock_dispo") ;
                                     }
                                     
                              sql = "select stock_dispo from stock_pl where magasin = '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' "
                                             + "and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'" ;
                                     rs = stmt.executeQuery(sql) ;
                                     while(rs.next()){
                                         old_stock_arriver = rs.getLong("stock_dispo") ;
                                     }       
                                     
                                     
if((old_stock_depart == this.list.get(ii).getOld_stock_depart()) && (old_stock_arriver == this.list.get(ii).getOld_stock_arriver())){
                                    
                                    
    stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
          + this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "+0+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getOld_stock_depart()+" , "+this.list.get(ii).getOld_stock_arriver()+")" ) ;
                                     
                                    
                                   // "UPDATE stock_pl SET stock_dispo = ? , prx_pm = ? , p_m_d = ? WHERE magasin = ? AND description = ?" 
                         
                                     ps2.setLong(1, this.list.get(ii).getNew_stock_depart()) ;                                   
                                     ps2.setFloat(2, this.list.get(ii).getPm_depart());
                                     ps2.setFloat(3, this.list.get(ii).getPm_depart());
                                     ps2.setString(4, this.list.get(ii).getP_depart());
                                     ps2.setString(5, this.list.get(ii).getDescription());
                                     
                                     
                                     // add batch : 
                                     
                                 //    ps2.addBatch() ;
                                     
                                     ps2.executeUpdate() ;
                                    
                                    
                                   
                                    
                   
                                         
                                         if(av == 0){
                                        
                                             if(stmt.executeUpdate("insert into stock_pl(magasin,description,stock_dispo,prx_pm,dtec,admin , p_m_d) values( '"
                                             +this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getNew_stock_arriver()+" , "
                                             +this.list.get(ii).getPm_arriver()+" , '"+dte1+"' , '"
                                             +this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getPm_arriver()+" )") == 1){
                                       
   if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0+" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 
                 
             }
                                              
                                        
                                         
                                         
                                     
                                          
                                     }
                                             
                                             
                   
                                             
                                     }else if(av == 1){
                                         
                                       
  stmt.executeUpdate("UPDATE stock_pl SET stock_dispo = "+this.list.get(ii).getNew_stock_arriver()+" , "
+ "prx_pm = "+this.list.get(ii).getPm_arriver()+" , p_m_d = "+this.list.get(ii).getPm_arriver()+" WHERE magasin = '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' "
         + "AND description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
 
                                         
                                         
               if(this.list.get(ii).getP_arriver().equalsIgnoreCase("CHAMBRE FROIDE")){
              
              stmt.executeUpdate("update pmp set pv = "+this.list.get(ii).getPm_arriver()
           +" where article = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
              
             stmt.executeUpdate("update stock1 set pa = "+this.list.get(ii).getPm_arriver()+" "
           +", pv = "+this.list.get(ii).getPm_arriver()+" where desi = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ; 
              
               
          }
 
               
                                              
stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0 +" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) ; 
    
    
    
                                   
                 
                  
                 
                 
             
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                 
                                          
                                     }
                                         
                                 
                                         
                                         
                                                                     
         
                                    }else{
    
                         // wait for continues ........................
    
                this.vy_pderive = 0 ;
                
                sql = "select * from derive_pl where produit = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'" ;
                 rs = stmt.executeQuery(sql) ;
                   while(rs.next()){
                        this.vy_pderive = 1 ;
                    }
    
    
    
                 if(this.vy_pderive == 0){
               
           if(old_stock_depart >= this.list.get(ii).getQte_()){
               
               new_stock_depart = (old_stock_depart - this.list.get(ii).getQte_()) ;
            
               
               new_stock_arriver = (old_stock_arriver + this.list.get(ii).getQte_()) ;
               
              // debut :
               
    stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
          + this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "+0+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+old_stock_depart+" , "+old_stock_arriver+")" ) ;
                                     
                                    
                                   // "UPDATE stock_pl SET stock_dispo = ? , prx_pm = ? , p_m_d = ? WHERE magasin = ? AND description = ?" 
                         
                                     ps2.setLong(1, new_stock_depart) ;                                   
                                     ps2.setFloat(2, this.list.get(ii).getPm_depart());
                                     ps2.setFloat(3, this.list.get(ii).getPm_depart());
                                     ps2.setString(4, this.list.get(ii).getP_depart());
                                     ps2.setString(5, this.list.get(ii).getDescription());
                                     
                                     
                                     // add batch : 
                                     
                                 //    ps2.addBatch() ;
                                     
                                     ps2.executeUpdate() ;
                                    
                                    
                                   
                                    
                   
                                         
                                         if(av == 0){
                                        
                                             if(stmt.executeUpdate("insert into stock_pl(magasin,description,stock_dispo,prx_pm,dtec,admin , p_m_d) values( '"
                                             +this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+new_stock_arriver+" , "
                                             +this.list.get(ii).getPm_arriver()+" , '"+dte1+"' , '"
                                             +this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getPm_arriver()+" )") == 1){
                                       
   if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0+" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 
                 
             }
                                              
                                        
                                         
                                         
                                     
                                          
                                     }
                                             
                                             
                   
                                             
                                     }else if(av == 1){
                                         
                                       
  stmt.executeUpdate("UPDATE stock_pl SET stock_dispo = "+new_stock_arriver+" , "
+ "prx_pm = "+this.list.get(ii).getPm_arriver()+" , p_m_d = "+this.list.get(ii).getPm_arriver()+" WHERE magasin = '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' "
         + "AND description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
 
                                         
                                         
               if(this.list.get(ii).getP_arriver().equalsIgnoreCase("CHAMBRE FROIDE")){
              
              stmt.executeUpdate("update pmp set pv = "+this.list.get(ii).getPm_arriver()
           +" where article = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
              
             stmt.executeUpdate("update stock1 set pa = "+this.list.get(ii).getPm_arriver()+" "
           +", pv = "+this.list.get(ii).getPm_arriver()+" where desi = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ; 
              
               
          }
 
               
                                              
stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0 +" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) ; 
    
    
    
                                   
                 
                  
                 
                 
             
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                 
                                          
                                     }
                                         
                                 
                                         
                                         
                                    
               
            // end :
               
               
           }else{
               error.add(Integer.parseInt(new String("1"))) ;
               JOptionPane.showMessageDialog(null, "STOCK INSUFISANT : "+old_stock_depart) ;
           }    
               
               
           }else if(this.vy_pderive == 1){
               
              if(old_stock_depart >= this.list.get(ii).getQte_()){
                  
                  new_stock_depart = (old_stock_depart - this.list.get(ii).getQte_()) ;
                  new_stock_arriver = (old_stock_arriver + this.list.get(ii).getQte_()) ;
                  
                  pm_arriver = 0 ;
                  pm_depart = 0 ;
                  
sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getP_arriver().replaceAll("'","''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'","''")+"' limit 1" ;
         rs = stmt.executeQuery(sql) ;
         while(rs.next()){
        
             this.pm_arriver = rs.getFloat("prx_pm") ;
           
         }                  
                  
sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getP_depart().replaceAll("'","''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'","''")+"' limit 1" ;
         rs = stmt.executeQuery(sql) ;
         while(rs.next()){
        
             this.pm_depart = rs.getFloat("prx_pm") ;
           
         }
         
         float px = 0 ;
         
         sql = "select * from stock_pl where description = '"+this.list.get(ii).getDescription().replaceAll("'","''")+"' limit 1" ;
         rs = stmt.executeQuery(sql) ;
         while(rs.next()){
        
             px = rs.getFloat("prx_pm") ;
           
         }
                  
                  
                    float p1 = 0 ;
                            p1 = (this.pm_arriver * old_stock_arriver) ;
                            float p2 = 0 ;
                            p2 = (this.pm_depart * this.list.get(ii).getQte_()) ;
                            
                            this.pm_arriver = px ; //  ((p1 + p2) / new_stock_arriver ) ;
                                  
                            // debut :
                            
  stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
          + this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "+0+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+old_stock_depart+" , "+old_stock_arriver+")" ) ;
                                     
                                    
                                   // "UPDATE stock_pl SET stock_dispo = ? , prx_pm = ? , p_m_d = ? WHERE magasin = ? AND description = ?" 
                         
                                     ps2.setLong(1, new_stock_depart) ;                                   
                                     ps2.setFloat(2, this.pm_arriver);
                                     ps2.setFloat(3, this.pm_arriver);
                                     ps2.setString(4, this.list.get(ii).getP_depart());
                                     ps2.setString(5, this.list.get(ii).getDescription());
                                     
                                     
                                     // add batch : 
                                     
                                 //    ps2.addBatch() ;
                                     
                                     ps2.executeUpdate() ;
                                    
                                    
                                   
                                    
                   
                                         
                                         if(av == 0){
                                        
                                             if(stmt.executeUpdate("insert into stock_pl(magasin,description,stock_dispo,prx_pm,dtec,admin , p_m_d) values( '"
                                             +this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+new_stock_arriver+" , "
                                             +this.pm_arriver+" , '"+dte1+"' , '"
                                             +this.login.replaceAll("'", "''")+"' , "+this.pm_arriver+" )") == 1){
                                       
   if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0+" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 
                 
             }
                                              
                                        
                                         
                                         
                                     
                                          
                                     }
                                             
                                             
                   
                                             
                                     }else if(av == 1){
                                         
                                       
  stmt.executeUpdate("UPDATE stock_pl SET stock_dispo = "+new_stock_arriver+" , "
+ "prx_pm = "+this.pm_arriver+" , p_m_d = "+this.pm_arriver+" WHERE magasin = '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' "
         + "AND description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
 
                                         
                                         
               if(this.list.get(ii).getP_arriver().equalsIgnoreCase("CHAMBRE FROIDE")){
              
              stmt.executeUpdate("update pmp set pv = "+this.pm_arriver
           +" where article = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
              
             stmt.executeUpdate("update stock1 set pa = "+this.pm_arriver+" "
           +", pv = "+this.pm_arriver+" where desi = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ; 
              
               
          }
 
               
                                              
stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0 +" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) ; 
    
    
    
                                   
                 
                  
                 
                 
             
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                 
                                          
                                     }
                                         
                                 
                                         
                                         
                                    
                            
                            // end :
  
                                   
                  
                  
              }else{
                  error.add(Integer.parseInt(new String("1"))) ;
                  JOptionPane.showMessageDialog(null, "STOCK INSUFISANT : "+old_stock_depart) ;
              }
               
               
           }
    
                        
                       
                       
                       
                       
                       
                                       } // end if acces concu....
                                     
                                     
                                     }
                                 
                                  
                                
                                  
                              
                              }else{
                                  error.add(Integer.parseInt(new String("1"))) ;
                                  JOptionPane.showMessageDialog(null, "REPRENDRE L'OPERATION") ;
                              }
                              
                              
              }  // end for our boucle :
              
              
              
            
             
             
           
             long num = 0 ;
                 
             long id = 0 ;
             sql = "select id from op_pl_f where cb = "+this.cb ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                num = rs.getLong("id") ;
             }
             
                  
                  try{
                
                  
              InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Bon_pl_v2.jrxml")) ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.bonList) ;
            
            Map<String, Object> para = new HashMap<>();
            para.put("data", jrbean);
            para.put("op", "OP : "+this.login) ;  // this.login
            para.put("cb", this.cb) ;
            para.put("num", "N° : "+String.valueOf(num)) ;
            para.put("dep", "DEPART : "+this.list.get(0).getP_depart());
            para.put("arriv", "ARRIVER : "+this.list.get(0).getP_arriver());
            para.put("perso", "COMMIS. : "+this.list.get(0).getComm_()) ;
            para.put("motif", "MOTIF : "+this.list.get(0).getMotif_());
            para.put("tmtt", "TOTAL MTT : "+nf3.format(tmtt)) ;
            para.put("comt", "COMMENTAIRE : "+this.comt.getText().trim()) ;
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
       
       //  JasperViewer.viewReport(print, false) ;
            
        JasperPrintManager.printReport(print, false) ;
        error.add(Integer.parseInt(new String("0"))) ;
        
        
                  }catch(Exception zt){
                      error.add(Integer.parseInt(new String("1"))) ;
                  }
                  
                  
                   if(error.contains(Integer.parseInt(new String("1")))){
                 
                  conn.rollback() ;
                 
                  Op_pl_final mc = new Op_pl_final(this.login, this.role) ;
                              mc.setVisible(true) ;
                       
                              this.setVisible(false) ;
                 
                 
                       }else{
                       
                       conn.commit();
                       
                         }
            
              
           //   
              
              
              
              this.jTable1.getSelectionModel().clearSelection() ;
           // this.jTable1.getSelectionModel().clearSelection() ;
              this.list.removeAll(this.list) ;
              this.vy_list.removeAll(this.vy_list) ;
             
              DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                                dtm.setRowCount(0) ;
                                 
                                this.qte.setText("") ;
                                this.cb = 0 ;
                                this.depart.setEnabled(true) ;
                                this.depart.setSelectedItem(new String("DEPART"));
                                
                                this.arriver.setEnabled(true) ;
                                this.arriver.setSelectedItem(new String("ARRIVER"));
                                
                                this.comm.setEnabled(true) ;
                                this.comm.setSelectedItem(new String("COMMISSIONNAIRE"));
                                this.motif.setEnabled(true) ;
                                this.motif.setSelectedItem(new String("MOTIF"));
                                this.comt.setEditable(true) ;
                                this.comt.setText("") ;
                                this.total.setText("0") ;
                                this.to = 0 ;
                                this.jDateChooser1.setDate(null) ;
                                
                                this.valider.setEnabled(false) ;
                                 this.comt.setEditable(true) ;
                                 this.comt.setEnabled(true);
                               
              
              
              
          }
        
        
        
        
        
        
        
        
            
        }
       
        }
        
        }catch(Exception ex1){
            
          SimpleDateFormat sdfT1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
       
        dte1 = sdfT1.format(new Date()) ;
        dte2 = dte1 ;
        
        // debut list :
        
           if(this.list.size() > 0){
             
             this.cb = 0 ;
        
        Random rx = new Random() ;
        
        this.cb = rx.nextInt() ;
        
        if(this.cb < 0){
            this.cb = Math.abs(this.cb) ;
        }
         
        int vy ;
            vy = 0 ;
            sql = "select * from op_pl_f where cb = "+this.cb ;
            rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                vy = 1 ;
                error.add(Integer.parseInt(new String("1"))) ;
             }
             
             
              
      
      if(vy == 0){
          
          int i = 0 ;
          
          
          if(stmt.executeUpdate("insert into op_pl_f(cb,date1,date2,depart,arriver,perso,motif,etat,admin,comt) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+dte2+"' , '"+this.list.get(i).getP_depart().replaceAll("'", "''")+"' , '"
          +this.list.get(i).getP_arriver().replaceAll("'", "''")+"' , '"+this.list.get(i).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(i).getMotif_().replaceAll("'", "''")+"' , '"
                  +this.list.get(i).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' , '"+this.comt.getText().trim().replaceAll("'", "''")+"' )") == 1){
  
              
               long tmtt = 0 ;
              
              for(int ii = 0 ; this.list.size() > ii ; ii++){
                  
                  long old_stock_depart = 0 ;
                  long old_stock_arriver = 0 ;
                  long new_stock_depart = 0 ;
                  long new_stock_arriver = 0 ;
                  
                  
                  
                  
                  
                   HashMap<String, Object> m = new HashMap<>() ;
                   
                   m.put("description", this.list.get(ii).getDescription()) ;
                   m.put("qte", nf3.format(this.list.get(ii).getQte_())) ;
                   m.put("pu", nf3.format(this.list.get(ii).getPm_depart())) ;
                   m.put("mtt", this.list.get(ii).getMtt()) ;
                              tmtt += this.list.get(ii).getMtt() ;
                   m.put("tmtt", "TOTAL MTT : "+nf3.format(tmtt)) ;
                              
                              this.bonList.add(m) ;
                              
                              
                               if(this.list.get(ii).getMotif_().equalsIgnoreCase("DECOUPAGE")){
                                  
                               
                                  
                                 int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'" ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                 
                                 if(vy0 == 0){
                                     
                                     error.add(Integer.parseInt(new String("1"))) ;
                                     JOptionPane.showMessageDialog(this, "PAS DE STOCK ") ;
                                     
                                     
                                 }else if(vy0 == 1){
                                      
                                     sql = "select stock_dispo from stock_pl where magasin = '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' "
                                             + "and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'" ;
                                     rs = stmt.executeQuery(sql) ;
                                     while(rs.next()){
                                         old_stock_depart = rs.getLong("stock_dispo") ;
                                     }
                                     
                                     if(old_stock_depart == this.list.get(ii).getOld_stock_depart()){
                                     
                                      
                                              // detail stock placement     :
                                         
                                         
stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
          + this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "+0+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getOld_stock_depart()+" , "+this.list.get(ii).getOld_stock_arriver()+")" ) ;
                                     
                         // "UPDATE stock_pl SET stock_dispo = ? , prx_pm = ? , p_m_d = ? WHERE magasin = ? AND description = ?" 
                         
                                     ps2.setLong(1, this.list.get(ii).getNew_stock_depart()) ;                                   
                                     ps2.setFloat(2, this.list.get(ii).getPm_depart());
                                     ps2.setFloat(3, this.list.get(ii).getPm_depart());
                                     ps2.setString(4, this.list.get(ii).getP_depart());
                                     ps2.setString(5, this.list.get(ii).getDescription());
                                     
                                     
                                     // add batch : 
                                     
                                 //    ps2.addBatch() ;
                                     
                                     ps2.executeUpdate() ;
                                    
                                               
                                              
       stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0 +" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) ;
                 
                 // if detail_pl is incerted :
                 
                                                  
                       
                 
                 
                 
             
                                              
                                       // fin detail_pl :       
                                              
                                 }else{
                                      
                      if(old_stock_depart >= this.list.get(ii).getQte_()){
                          
                          
                                new_stock_depart = (old_stock_depart - this.list.get(ii).getQte_()) ;
                                
                                 // detail stock placement     :
                                         
                                         
            stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
          + this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "+0+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+old_stock_depart+" , "+this.list.get(ii).getOld_stock_arriver()+")" ) ;
                                     
                         // "UPDATE stock_pl SET stock_dispo = ? , prx_pm = ? , p_m_d = ? WHERE magasin = ? AND description = ?" 
                         
                                     ps2.setLong(1, new_stock_depart) ;                                   
                                     ps2.setFloat(2, this.list.get(ii).getPm_depart());
                                     ps2.setFloat(3, this.list.get(ii).getPm_depart());
                                     ps2.setString(4, this.list.get(ii).getP_depart());
                                     ps2.setString(5, this.list.get(ii).getDescription());
                                     
                                     
                                     // add batch : 
                                     
                                 //    ps2.addBatch() ;
                                     
                                     ps2.executeUpdate() ;
                                    
                                               
                                              
       stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0 +" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) ;
                 
                 // if detail_pl is incerted :
                 
                                                  
                       
                 
                 
                 
             
                                              
                                       // fin detail_pl :    
                                
                                
                                
                                
                              
                                
                            }else{
                                 
                                error.add(Integer.parseInt(new String("1"))) ;
                                JOptionPane.showMessageDialog(null, "STOCK INSUFFISANT A CAUSE D'ACCES CONCURRENCIEL REPRENER L'OPERATION STOCK ACTUEL : "+old_stock_depart) ;
                            }
                                         
                                     
                                     
                                     
                                     }
                                     
                                     
                                     
                                     
                                         
                                 }
                            
                                  
                              }else if(this.list.get(ii).getMotif_().equalsIgnoreCase("DECOUPAGE") == false){
                               
                               
                                    int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                  int av = 0 ;
                                         sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getP_arriver().replaceAll("'" , "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                         rs = stmt.executeQuery(sql) ;
                                         while(rs.next()){
                                             av = 1 ;
                                         }
                                 
                                 
                                 if(vy0 == 0){
                                     
                                     error.add(Integer.parseInt(new String("1"))) ;
                                     JOptionPane.showMessageDialog(this, "PAS DE STOCK ") ;
                                     
                                     
                                 }else if(vy0 == 1){
                                     
                                     
                                   
                                      // je suis ici :
                                     
                                  
                               sql = "select stock_dispo from stock_pl where magasin = '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' "
                                             + "and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'" ;
                                     rs = stmt.executeQuery(sql) ;
                                     while(rs.next()){
                                         old_stock_depart = rs.getLong("stock_dispo") ;
                                     }
                                     
                              sql = "select stock_dispo from stock_pl where magasin = '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' "
                                             + "and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'" ;
                                     rs = stmt.executeQuery(sql) ;
                                     while(rs.next()){
                                         old_stock_arriver = rs.getLong("stock_dispo") ;
                                     }       
                                     
                                     
if((old_stock_depart == this.list.get(ii).getOld_stock_depart()) && (old_stock_arriver == this.list.get(ii).getOld_stock_arriver())){
                                    
                                    
    stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
          + this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "+0+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getOld_stock_depart()+" , "+this.list.get(ii).getOld_stock_arriver()+")" ) ;
                                     
                                    
                                   // "UPDATE stock_pl SET stock_dispo = ? , prx_pm = ? , p_m_d = ? WHERE magasin = ? AND description = ?" 
                         
                                     ps2.setLong(1, this.list.get(ii).getNew_stock_depart()) ;                                   
                                     ps2.setFloat(2, this.list.get(ii).getPm_depart());
                                     ps2.setFloat(3, this.list.get(ii).getPm_depart());
                                     ps2.setString(4, this.list.get(ii).getP_depart());
                                     ps2.setString(5, this.list.get(ii).getDescription());
                                     
                                     
                                     // add batch : 
                                     
                                 //    ps2.addBatch() ;
                                     
                                     ps2.executeUpdate() ;
                                    
                                    
                                   
                                    
                   
                                         
                                         if(av == 0){
                                        
                                             if(stmt.executeUpdate("insert into stock_pl(magasin,description,stock_dispo,prx_pm,dtec,admin , p_m_d) values( '"
                                             +this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getNew_stock_arriver()+" , "
                                             +this.list.get(ii).getPm_arriver()+" , '"+dte1+"' , '"
                                             +this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getPm_arriver()+" )") == 1){
                                       
   if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0+" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 
                 
             }
                                              
                                        
                                         
                                         
                                     
                                          
                                     }
                                             
                                             
                   
                                             
                                     }else if(av == 1){
                                         
                                       
  stmt.executeUpdate("UPDATE stock_pl SET stock_dispo = "+this.list.get(ii).getNew_stock_arriver()+" , "
+ "prx_pm = "+this.list.get(ii).getPm_arriver()+" , p_m_d = "+this.list.get(ii).getPm_arriver()+" WHERE magasin = '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' "
         + "AND description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
 
                                         
                                         
               if(this.list.get(ii).getP_arriver().equalsIgnoreCase("CHAMBRE FROIDE")){
              
              stmt.executeUpdate("update pmp set pv = "+this.list.get(ii).getPm_arriver()
           +" where article = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
              
             stmt.executeUpdate("update stock1 set pa = "+this.list.get(ii).getPm_arriver()+" "
           +", pv = "+this.list.get(ii).getPm_arriver()+" where desi = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ; 
              
               
          }
 
               
                                              
stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0 +" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) ; 
    
    
    
                                   
                 
                  
                 
                 
             
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                 
                                          
                                     }
                                         
                                 
                                         
                                         
                                                                     
         
                                    }else{
    
                         // wait for continues ........................
    
                this.vy_pderive = 0 ;
                
                sql = "select * from derive_pl where produit = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'" ;
                 rs = stmt.executeQuery(sql) ;
                   while(rs.next()){
                        this.vy_pderive = 1 ;
                    }
    
    
    
                 if(this.vy_pderive == 0){
               
           if(old_stock_depart >= this.list.get(ii).getQte_()){
               
               new_stock_depart = (old_stock_depart - this.list.get(ii).getQte_()) ;
            
               
               new_stock_arriver = (old_stock_arriver + this.list.get(ii).getQte_()) ;
               
              // debut :
               
    stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
          + this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "+0+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+old_stock_depart+" , "+old_stock_arriver+")" ) ;
                                     
                                    
                                   // "UPDATE stock_pl SET stock_dispo = ? , prx_pm = ? , p_m_d = ? WHERE magasin = ? AND description = ?" 
                         
                                     ps2.setLong(1, new_stock_depart) ;                                   
                                     ps2.setFloat(2, this.list.get(ii).getPm_depart());
                                     ps2.setFloat(3, this.list.get(ii).getPm_depart());
                                     ps2.setString(4, this.list.get(ii).getP_depart());
                                     ps2.setString(5, this.list.get(ii).getDescription());
                                     
                                     
                                     // add batch : 
                                     
                                 //    ps2.addBatch() ;
                                     
                                     ps2.executeUpdate() ;
                                    
                                    
                                   
                                    
                   
                                         
                                         if(av == 0){
                                        
                                             if(stmt.executeUpdate("insert into stock_pl(magasin,description,stock_dispo,prx_pm,dtec,admin , p_m_d) values( '"
                                             +this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+new_stock_arriver+" , "
                                             +this.list.get(ii).getPm_arriver()+" , '"+dte1+"' , '"
                                             +this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getPm_arriver()+" )") == 1){
                                       
   if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0+" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 
                 
             }
                                              
                                        
                                         
                                         
                                     
                                          
                                     }
                                             
                                             
                   
                                             
                                     }else if(av == 1){
                                         
                                       
  stmt.executeUpdate("UPDATE stock_pl SET stock_dispo = "+new_stock_arriver+" , "
+ "prx_pm = "+this.list.get(ii).getPm_arriver()+" , p_m_d = "+this.list.get(ii).getPm_arriver()+" WHERE magasin = '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' "
         + "AND description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
 
                                         
                                         
               if(this.list.get(ii).getP_arriver().equalsIgnoreCase("CHAMBRE FROIDE")){
              
              stmt.executeUpdate("update pmp set pv = "+this.list.get(ii).getPm_arriver()
           +" where article = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
              
             stmt.executeUpdate("update stock1 set pa = "+this.list.get(ii).getPm_arriver()+" "
           +", pv = "+this.list.get(ii).getPm_arriver()+" where desi = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ; 
              
               
          }
 
               
                                              
stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0 +" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) ; 
    
    
    
                                   
                 
                  
                 
                 
             
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                 
                                          
                                     }
                                         
                                 
                                         
                                         
                                    
               
            // end :
               
               
           }else{
               error.add(Integer.parseInt(new String("1"))) ;
               JOptionPane.showMessageDialog(null, "STOCK INSUFISANT : "+old_stock_depart) ;
           }    
               
               
           }else if(this.vy_pderive == 1){
               
              if(old_stock_depart >= this.list.get(ii).getQte_()){
                  
                  new_stock_depart = (old_stock_depart - this.list.get(ii).getQte_()) ;
                  new_stock_arriver = (old_stock_arriver + this.list.get(ii).getQte_()) ;
                  
                  pm_arriver = 0 ;
                  pm_depart = 0 ;
                  
sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getP_arriver().replaceAll("'","''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'","''")+"' limit 1" ;
         rs = stmt.executeQuery(sql) ;
         while(rs.next()){
        
             this.pm_arriver = rs.getFloat("prx_pm") ;
           
         }                  
                  
sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getP_depart().replaceAll("'","''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'","''")+"' limit 1" ;
         rs = stmt.executeQuery(sql) ;
         while(rs.next()){
        
             this.pm_depart = rs.getFloat("prx_pm") ;
           
         }
         
         float px = 0 ;
         
         sql = "select * from stock_pl where description = '"+this.list.get(ii).getDescription().replaceAll("'","''")+"' limit 1" ;
         rs = stmt.executeQuery(sql) ;
         while(rs.next()){
        
            px = rs.getFloat("prx_pm") ;
           
         }
                  
                  
                    float p1 = 0 ;
                            p1 = (this.pm_arriver * old_stock_arriver) ;
                            float p2 = 0 ;
                            p2 = (this.pm_depart * this.list.get(ii).getQte_()) ;
                            
                            this.pm_arriver = px ; // ((p1 + p2) / new_stock_arriver ) ;
                                  
                            // debut :
                            
  stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
          + this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "+0+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+old_stock_depart+" , "+old_stock_arriver+")" ) ;
                                     
                                    
                                   // "UPDATE stock_pl SET stock_dispo = ? , prx_pm = ? , p_m_d = ? WHERE magasin = ? AND description = ?" 
                         
                                     ps2.setLong(1, new_stock_depart) ;                                   
                                     ps2.setFloat(2, this.pm_arriver);
                                     ps2.setFloat(3, this.pm_arriver);
                                     ps2.setString(4, this.list.get(ii).getP_depart());
                                     ps2.setString(5, this.list.get(ii).getDescription());
                                     
                                     
                                     // add batch : 
                                     
                                 //    ps2.addBatch() ;
                                     
                                     ps2.executeUpdate() ;
                                    
                                    
                                   
                                    
                   
                                         
                                         if(av == 0){
                                        
                                             if(stmt.executeUpdate("insert into stock_pl(magasin,description,stock_dispo,prx_pm,dtec,admin , p_m_d) values( '"
                                             +this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+new_stock_arriver+" , "
                                             +this.pm_arriver+" , '"+dte1+"' , '"
                                             +this.login.replaceAll("'", "''")+"' , "+this.pm_arriver+" )") == 1){
                                       
   if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0+" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 
                 
             }
                                              
                                        
                                         
                                         
                                     
                                          
                                     }
                                             
                                             
                   
                                             
                                     }else if(av == 1){
                                         
                                       
  stmt.executeUpdate("UPDATE stock_pl SET stock_dispo = "+new_stock_arriver+" , "
+ "prx_pm = "+this.pm_arriver+" , p_m_d = "+this.pm_arriver+" WHERE magasin = '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' "
         + "AND description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
 
                                         
                                         
               if(this.list.get(ii).getP_arriver().equalsIgnoreCase("CHAMBRE FROIDE")){
              
              stmt.executeUpdate("update pmp set pv = "+this.pm_arriver
           +" where article = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
              
             stmt.executeUpdate("update stock1 set pa = "+this.pm_arriver+" "
           +", pv = "+this.pm_arriver+" where desi = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ; 
              
               
          }
 
               
                                              
stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+dte1+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , "
          + this.list.get(ii).getPm_depart()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getP_depart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getQte_()+" , '"+this.list.get(ii).getP_arriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte_()+" , '"
          + this.list.get(ii).getComm_().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif_().replaceAll("'", "''")+"' , "
          + 0 +" , '"+this.list.get(ii).getEtat()+"' , '"+this.login.replaceAll("'", "''")+"' )" ) ; 
    
    
    
                                   
                 
                  
                 
                 
             
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                 
                                          
                                     }
                                         
                                 
                                         
                                         
                                    
                            
                            // end :
  
                                   
                  
                  
              }else{
                  error.add(Integer.parseInt(new String("1"))) ;
                  JOptionPane.showMessageDialog(null, "STOCK INSUFISANT : "+old_stock_depart) ;
              }
               
               
           }
    
                        
                       
                       
                       
                       
                       
                                       } // end if acces concu....
                                     
                                     
                                     }
                                 
                                  
                                
                                  
                              
                              }else{
                                  error.add(Integer.parseInt(new String("1"))) ;
                                  JOptionPane.showMessageDialog(null, "REPRENDRE L'OPERATION") ;
                              }
                              
                              
              }  // end for our boucle :
              
              
              
            
             
             
           
           long num = 0 ;
                 
             long id = 0 ;
             sql = "select id from op_pl_f where cb = "+this.cb ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                num = rs.getLong("id") ;
             }
                  
                  
                  try{
                
                  
              InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Bon_pl_v2.jrxml")) ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.bonList) ;
            
            Map<String, Object> para = new HashMap<>();
            para.put("data", jrbean);
            para.put("op", "OP : "+this.login) ;  // this.login
            para.put("cb", this.cb) ;
            para.put("num", "N° : "+String.valueOf(num)) ;
            para.put("dep", "DEPART : "+this.list.get(0).getP_depart());
            para.put("arriv", "ARRIVER : "+this.list.get(0).getP_arriver());
            para.put("perso", "COMMIS. : "+this.list.get(0).getComm_()) ;
            para.put("motif", "MOTIF : "+this.list.get(0).getMotif_());
            para.put("tmtt", "TOTAL MTT : "+nf3.format(tmtt)) ;
            para.put("comt", "COMMENTAIRE : "+this.comt.getText().trim()) ;
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
       
       //  JasperViewer.viewReport(print, false) ;
            
        JasperPrintManager.printReport(print, false) ;
        error.add(Integer.parseInt(new String("0"))) ;
        
        
                  }catch(Exception zt){
                      error.add(Integer.parseInt(new String("1"))) ;
                  }
                  
                  
                   if(error.contains(Integer.parseInt(new String("1")))){
                 
                  conn.rollback() ;
                 
                  Op_pl_final mc = new Op_pl_final(this.login, this.role) ;
                              mc.setVisible(true) ;
                       
                              this.setVisible(false) ;
                 
                 
                       }else{
                       
                       conn.commit();
                       
                         }
            
              
           //   
              
              
              
              this.jTable1.getSelectionModel().clearSelection() ;
           // this.jTable1.getSelectionModel().clearSelection() ;
              this.list.removeAll(this.list) ;
              this.vy_list.removeAll(this.vy_list) ;
             
              DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                                dtm.setRowCount(0) ;
                                 
                                this.qte.setText("") ;
                                this.cb = 0 ;
                                this.depart.setEnabled(true) ;
                                this.depart.setSelectedItem(new String("DEPART"));
                                
                                this.arriver.setEnabled(true) ;
                                this.arriver.setSelectedItem(new String("ARRIVER"));
                                
                                this.comm.setEnabled(true) ;
                                this.comm.setSelectedItem(new String("COMMISSIONNAIRE"));
                                this.motif.setEnabled(true) ;
                                this.motif.setSelectedItem(new String("MOTIF"));
                                this.comt.setEditable(true) ;
                                this.comt.setText("") ;
                                this.total.setText("0") ;
                                this.to = 0 ;
                                this.jDateChooser1.setDate(null) ;
                                
                                this.valider.setEnabled(false) ;
                                 this.comt.setEditable(true) ;
                                 this.comt.setEnabled(true);
                               
              
              
              
          }
        
        
        
        
        
        
        
        
            
        }
       
        }
        
          
      // end list :  
        
        
      }
      
      
      
      
         
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      
      
      rs.close();
      stmt.close();
      conn.close();
       
      ps2.close();
      
      
      
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
         se.printStackTrace() ;
      } // end finally try
   }   // end try :
        
       
    this.valider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;  
    this.jDateChooser1.setEnabled(true) ;
    
    Op_pl_final mc = new Op_pl_final(this.login, this.role) ;
                              mc.setVisible(true) ;
                       
                              this.setVisible(false) ;
        
        
    }//GEN-LAST:event_validerActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here :
        
     
        
        this.jTable2.getSelectionModel().clearSelection() ;
        
        
        this.description = "" ;
        this.old_stock_depart = 0 ;
        this.old_stock_arriver = 0 ;
        this.vy_pderive = 0 ;
        this.rapport = "" ;
        this.pm_depart = 0 ;
        this.pm_arriver = 0 ;
        this.id_st = 0 ;
        this.id_st_d = 0 ;
        
        
        this.description = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString().replaceAll("'", "''") ;
        
        
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
      
       
      String     sql = null ;
      ResultSet  rs  = null ;
      
    this.vy_derive = 0 ;
    sql = "select * from p_derive where pere = '"+this.description+"'" ;
    rs = stmt.executeQuery(sql) ;
    while(rs.next()){
        this.vy_derive = 1 ;
    }
    
      
      if(this.p_depart.equalsIgnoreCase("") && this.p_arriver.equalsIgnoreCase("") && this.motif_.isEmpty() && this.comm_.isEmpty()){
          
          JOptionPane.showMessageDialog(null, "SELECTIONNER TOUS LES PARAMETRES") ;
          
      }else if(this.p_depart.isEmpty() == false && this.motif_.equalsIgnoreCase("DECOUPAGE") && this.p_arriver.equalsIgnoreCase("ZONE DE DECOUPAGE")){
          
         // JOptionPane.showMessageDialog(null, "Placement decoupage") ;
       
          sql = "select * from matieres_p where description = '"+this.description+"'" ;
          rs = stmt.executeQuery(sql) ;
          while(rs.next()){
              this.rapport = rs.getString("unite_mesure") ;
              this.pm_depart = Float.parseFloat(rs.getString("prx_v_unite")) ;
          }
          
          sql = "select * from produits_f where description = '"+this.description+"'" ;
          rs = stmt.executeQuery(sql) ;
          while(rs.next()){
              this.rapport = rs.getString("unite_m") ;
              this.pm_depart = Float.parseFloat(rs.getString("pu")) ;
          }
          
          sql = "select * from derive_pl where produit = '"+this.description+"'" ;
          rs = stmt.executeQuery(sql) ;
          while(rs.next()){
              this.vy_pderive = 1 ;
          }
          
         sql = "select * from stock_pl where magasin = '"+this.p_depart+"' and description = '"+this.description+"' limit 1" ;
         rs = stmt.executeQuery(sql) ;
         while(rs.next()){
             this.id_st_d = rs.getInt("id") ;
             this.old_stock_depart = rs.getLong("stock_dispo") ;
           
         }
          
         if(this.vy_pderive == 1){
             
         sql = "select * from stock_pl where magasin = '"+this.p_depart+"' and description = '"+this.description+"' limit 1" ;
         rs = stmt.executeQuery(sql) ;
         while(rs.next()){
             
             this.id_st_d = rs.getInt("id") ;
             this.old_stock_depart = rs.getLong("stock_dispo") ;
             this.pm_depart = rs.getFloat("prx_pm") ;
           
         }
             
         }
         
          
          this.stock.setText(nf3.format(this.old_stock_depart)) ;
          this.pm.setText(nf3.format(this.pm_depart));
          
          
          
      }else if(this.p_depart.isEmpty() == false && this.p_arriver.isEmpty() == false && this.p_arriver.equalsIgnoreCase("ZONE DE DECOUPAGE") == false && this.motif_.isEmpty() == false && this.motif_.equalsIgnoreCase("DECOUPAGE") == false && this.p_depart.equalsIgnoreCase(this.p_arriver) == false){
     
      //    JOptionPane.showMessageDialog(null, "Placement entre 2 points !! !")  ;
          
          sql = "select * from matieres_p where description = '"+this.description+"'" ;
          rs = stmt.executeQuery(sql) ;
          while(rs.next()){
              
              this.rapport = rs.getString("unite_mesure") ;
              this.pm_depart =  Float.parseFloat(rs.getString("prx_v_unite")) ;
              this.pm_arriver = Float.parseFloat(rs.getString("prx_v_unite")) ;
              
          }
          
          sql = "select * from produits_f where description = '"+this.description+"'" ;
          rs = stmt.executeQuery(sql) ;
          while(rs.next()){
              this.rapport = rs.getString("unite_m") ;
              this.pm_depart = Float.parseFloat(rs.getString("pu")) ;
              this.pm_arriver = Float.parseFloat(rs.getString("pu")) ;
          }
          
          sql = "select * from derive_pl where produit = '"+this.description+"'" ;
          rs = stmt.executeQuery(sql) ;
          while(rs.next()){
              this.vy_pderive = 1 ;
          }
          
         sql = "select * from stock_pl where magasin = '"+this.p_depart+"' and description = '"+this.description+"' limit 1" ;
         rs = stmt.executeQuery(sql) ;
         while(rs.next()){
             this.id_st_d = rs.getInt("id") ;
             this.old_stock_depart = rs.getLong("stock_dispo") ;
           
         }
          
         sql = "select * from stock_pl where magasin = '"+this.p_arriver+"' and description = '"+this.description+"' limit 1" ;
         rs = stmt.executeQuery(sql) ;
         while(rs.next()){
             this.id_st = rs.getInt("id") ;
             this.old_stock_arriver = rs.getLong("stock_dispo") ;
           
         }
         
         
         if(this.vy_pderive == 1){
             
         sql = "select * from stock_pl where magasin = '"+this.p_depart+"' and description = '"+this.description+"' limit 1" ;
         rs = stmt.executeQuery(sql) ;
         while(rs.next()){
             this.id_st_d = rs.getInt("id") ;
             this.old_stock_depart = rs.getLong("stock_dispo") ;
             this.pm_depart = rs.getFloat("prx_pm") ;
           
         }
         
         
         sql = "select * from stock_pl where magasin = '"+this.p_arriver+"' and description = '"+this.description+"' limit 1" ;
         rs = stmt.executeQuery(sql) ;
         while(rs.next()){
             this.id_st = rs.getInt("id") ;
             this.old_stock_arriver = rs.getLong("stock_dispo") ;
             this.pm_arriver = rs.getFloat("prx_pm") ;
           
         }
         
         
         
             
         }
         
          
          this.stock.setText(nf3.format(this.old_stock_depart)) ;
          this.pm.setText(nf3.format(this.pm_depart));
          
          
          
          
      }else{
          
          JOptionPane.showMessageDialog(null, "PARAMETRES INCORRECT") ;
          
          
      }
    
          
           
          
       
        
      
      
      stmt.close() ;
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
        
       
     
     // Fin configure :
     
        
        
        //
        
         
        
       
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void departActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departActionPerformed
        // TODO add your handling code here:
        
        this.p_depart = "" ;
        this.p_depart = this.depart.getSelectedItem().toString().replaceAll("'", "''") ;
     
        
        if("DEPART".equalsIgnoreCase(this.p_depart ) ){  // || this.d1.equalsIgnoreCase(this.a.getSelectedItem().toString())){
         //   JOptionPane.showMessageDialog(this, "CHOISIR LE POINT DE DEPART CORRECT SVP ") ;
           this.p_depart = "" ;
           
        }
        
        if("ZONE DE PRODUCTION".equalsIgnoreCase(this.p_depart ) ){  // || this.d1.equalsIgnoreCase(this.a.getSelectedItem().toString())){
         //   JOptionPane.showMessageDialog(this, "CHOISIR LE POINT DE DEPART CORRECT SVP ") ;
          
            this.p_depart  = "" ;
            
            JOptionPane.showMessageDialog(null, "POINT DE DEPART INCORRECT") ;
            
        }
        
        if("ZONE DE DECOUPAGE".equalsIgnoreCase(this.p_depart ) ){  // || this.d1.equalsIgnoreCase(this.a.getSelectedItem().toString())){
         //   JOptionPane.showMessageDialog(this, "CHOISIR LE POINT DE DEPART CORRECT SVP ") ;
          
            this.p_depart  = "" ;
            
            JOptionPane.showMessageDialog(null, "POINT DE DEPART INCORRECT") ;
            
        }
        
        
        
         this.jTable1.getSelectionModel().clearSelection() ;
        
        
        
    }//GEN-LAST:event_departActionPerformed

    private void arriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arriverActionPerformed
        // TODO add your handling code here:
        
        
         this.p_arriver = "" ;
        
        this.p_arriver = this.arriver.getSelectedItem().toString().replaceAll("'", "''") ;
        
        
        if("ARRIVER".equalsIgnoreCase(this.p_arriver)){
           // JOptionPane.showMessageDialog(this, "CHOISIR LE POINT D'ARRIVER CORRECT SVP ") ;
            
            this.p_arriver = "" ;
       
            
        }
        
        if(this.p_arriver.equalsIgnoreCase("ZONE DE DECOUPAGE")){
            
        }else{
        
           this.motif.setSelectedItem(new String("MOTIF")) ;
           this.motif_ = "" ;
        }
        
           this.jTable1.getSelectionModel().clearSelection() ;
        
        
        
    }//GEN-LAST:event_arriverActionPerformed

    private void commActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commActionPerformed
        // TODO add your handling code here:
        
        this.comm_ = "" ;
        
        this.comm_ = this.comm.getSelectedItem().toString().replaceAll("'", "''") ;
        
        
        
        if("COMMISSIONNAIRE".equalsIgnoreCase(this.comm_)){
            
          //  JOptionPane.showMessageDialog(this, "CHOISIR LE COMMISSIONNAIRE CORRECT SVP ") ;
            
            this.comm_ = "" ;
            
            
        }
        
         this.jTable1.getSelectionModel().clearSelection() ;
        
        
    }//GEN-LAST:event_commActionPerformed

    private void motifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motifActionPerformed
        // TODO add your handling code here:
        
        this.motif_ = "" ;
        
        this.motif_ = this.motif.getSelectedItem().toString().replaceAll("'", "''") ;
   
        
        
        if("MOTIF".equalsIgnoreCase(this.motif_)){
          
            this.motif_ = "" ;
            
        }else if("DECOUPAGE".equalsIgnoreCase(this.motif_)){
           
           
      if(JOptionPane.showConfirmDialog(null, "CONFIRMEZ VOUS ARRIVER : ZONE DE DECOUPAGE ?" , "AVERTISSEMENT" , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            // yes option :
          
          this.arriver.setSelectedItem(new String("ZONE DE DECOUPAGE")) ;
             
             }else{
            
                   this.motif.setSelectedItem(new String("MOTIF")) ;
                   this.motif_ = "" ;
            
              }
        
            
        }
        
            
       
         
        
         
        
        
        this.jTable1.getSelectionModel().clearSelection() ;
        
        // EXTERIEUR
        
        
        
        
        
    }//GEN-LAST:event_motifActionPerformed

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        // TODO add your handling code here:
        
        // i'm going to Generation my collection data for oracl mysql serveur :
        
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "SELECTIONNER UN PRODUIT") ;
        }else{
            
            if(this.p_depart.equalsIgnoreCase(this.p_arriver)){
            
            JOptionPane.showMessageDialog(this, "DEPART # ARRIVER !!! ") ;
            
        }else if(this.p_depart.isEmpty() || this.p_arriver.isEmpty() || "COMMISSIONNAIRE".equalsIgnoreCase(this.comm.getSelectedItem().toString()) || "MOTIF".equalsIgnoreCase(this.motif.getSelectedItem().toString()) || "".equalsIgnoreCase(this.comt.getText().trim())){
            
            JOptionPane.showMessageDialog(this, "PRECISER LES PARAMETRES !!! ") ;
            
        }else{
            
            if((this.vy_pderive == 1 && this.motif_.equalsIgnoreCase("DECOUPAGE")) || (this.vy_derive == 0 && this.motif_.equalsIgnoreCase("DECOUPAGE"))){
              
                JOptionPane.showMessageDialog(this, "NON RECONNU POUR DECOUPAGE") ;
            
            }else{
                
                try{
                    
                    this.qte_ = 0 ;
                    this.new_stock_depart = 0 ;
                    this.new_stock_arriver = 0 ;
                    String qt = "" ;
                    qt = this.qte.getText().trim() ;
                    if(qt.isEmpty()){
                        JOptionPane.showMessageDialog(null, "SAISIR UNE QUANTITE");
                    }else{
                        
                        this.qte_ = Long.parseLong(qt) ;
                        
                        if(this.p_arriver.equalsIgnoreCase("ZONE DE DECOUPAGE") && this.motif_.equalsIgnoreCase("DECOUPAGE") && this.p_depart.isEmpty() == false){
                            this.etat = "OUVERT" ;
                           
                             if(this.old_stock_depart >= this.qte_){
                                this.new_stock_depart = (this.old_stock_depart - this.qte_) ;
                                
                                if(this.rapport.equalsIgnoreCase("oui")){
                                    
                                    double qte = 0.0 ;
                                           qte = this.qte_ / 1000.0 ;
                                           double mtt = 0.0 ;
                                                  mtt = this.pm_depart * qte ;
                                           this.mtt = Math.round(mtt) ;
                                           
                                           this.to += this.mtt ;
                                    
                                }else{
                                    
                                this.mtt = (long) this.pm_depart * this.qte_ ;
                                this.to += this.mtt ;
                                    
                                }
                                
                                
                             if(this.vy_list.contains(new String(this.description))){
                                 
                                 JOptionPane.showMessageDialog(null, "LE PRODUIT EXIST DEJA");
                                 
                             }else{
                                 
                                 DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                                 
                                 this.vy_list.add(this.description) ;
Transaction_pl tpl = new Transaction_pl(this.mtt, this.description, this.old_stock_depart, this.old_stock_arriver, this.new_stock_depart, this.new_stock_arriver, this.p_depart, this.p_arriver, this.comm_, this.motif_, this.qte_, this.comt_, this.pm_depart, this.pm_arriver, this.etat,this.id_st, this.id_st_d) ;                                 
           this.list.add(tpl) ;
           
           dtm2.addRow(new Object[]{
           tpl.getDescription() , tpl.getQte_() , tpl.getPm_depart() , tpl.getMtt() 
           });
                                 
           this.total.setText(nf3.format(this.to)) ;
                                 
                             this.depart.setEnabled(false);
                             this.arriver.setEnabled(false);
                             this.comm.setEnabled(false);
                             this.motif.setEnabled(false);
                             this.comt.setEnabled(false);
                             this.qte.setText("") ;
                             this.jTable1.getSelectionModel().clearSelection();
                             this.jTable2.getSelectionModel().clearSelection();
                              this.valider.setEnabled(true);
                             
                             }   
                                
                                
                                
                            }else{
                                JOptionPane.showMessageDialog(null, "STOCK INSUFFISANT : "+this.old_stock_depart) ;
                            }
                            
}else if(this.motif_.equalsIgnoreCase("DECOUPAGE") == false && this.motif_.isEmpty() == false && this.p_depart.isEmpty() == false && this.p_arriver.isEmpty() == false && this.p_arriver.equalsIgnoreCase("ZONE DE DECOUPAGE") == false){
     
    this.etat = "FERMER" ;
    String qt2 = "" ;
           qt2 = this.qte.getText().trim() ;
           
           if(qt2.equals("")){
               JOptionPane.showMessageDialog(null, "SAISIR LA QUANTITE");
           }else{
           this.qte_ = Long.parseLong(qt2);
           
           if(this.vy_pderive == 0){
               
           if(this.old_stock_depart >= this.qte_){
               
               this.new_stock_depart = (this.old_stock_depart - this.qte_) ;
               if(this.rapport.equalsIgnoreCase("oui")){
                   double q = 0.0 ;
                          q = this.qte_ / 1000.0 ;
                          double m = 0.0 ;
                                 m = this.pm_depart * q ;
                                 this.mtt = Math.round(m) ;
                                 this.to += this.mtt ;
               }else{
               this.mtt = (long) this.pm_depart * this.qte_ ;
               this.to += this.mtt ;
               }
               
               this.new_stock_arriver = (this.old_stock_arriver + this.qte_) ;
               
               DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
               
               if(this.vy_list.contains(new String(this.description))){
                   JOptionPane.showMessageDialog(null, "LE PRODUIT EXISTE DEJA");
               }else{
                   this.vy_list.add(this.description) ;
                   
                   Transaction_pl tpl = new Transaction_pl(this.mtt, this.description, this.old_stock_depart, this.old_stock_arriver, this.new_stock_depart, this.new_stock_arriver, this.p_depart, this.p_arriver, this.comm_, this.motif_, this.qte_, this.comt_, this.pm_depart, this.pm_arriver , this.etat, this.id_st, this.id_st_d) ;                                 
                   this.list.add(tpl) ;
           
           dtm2.addRow(new Object[]{
           tpl.getDescription() , tpl.getQte_() , tpl.getPm_depart() , tpl.getMtt() 
           });
                                 
           this.total.setText(nf3.format(this.to)) ;
                                 
                             this.depart.setEnabled(false);
                             this.arriver.setEnabled(false);
                             this.comm.setEnabled(false);
                             this.motif.setEnabled(false);
                             this.comt.setEnabled(false);
                             this.qte.setText("") ;
                             this.jTable1.getSelectionModel().clearSelection();
                             this.jTable2.getSelectionModel().clearSelection();
                              this.valider.setEnabled(true);
                             
                   
               }
               
               
           }else{
               JOptionPane.showMessageDialog(null, "STOCK INSUFISANT : "+this.old_stock_depart) ;
           }    
               
               
           }else if(this.vy_pderive == 1){
               
              if(this.old_stock_depart >= this.qte_){
                  
                  this.new_stock_depart = (this.old_stock_depart - this.qte_) ;
                  this.new_stock_arriver = (this.old_stock_arriver + this.qte_) ;
                  
                  this.mtt = (long) this.pm_depart * this.qte_ ;
                  this.to += this.mtt ;
                  
                    float p1 = 0 ;
                            p1 = (this.pm_arriver * this.old_stock_arriver) ;
                            float p2 = 0 ;
                            p2 = (this.pm_depart * this.qte_) ;
                            
                            this.pm_arriver = ((p1 + p2) / this.new_stock_arriver ) ;
                                  
                            DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
               
               if(this.vy_list.contains(new String(this.description))){
                   JOptionPane.showMessageDialog(null, "LE PRODUIT EXISTE DEJA");
               }else{
                   this.vy_list.add(this.description) ;
                   
                   Transaction_pl tpl = new Transaction_pl(this.mtt, this.description, this.old_stock_depart, this.old_stock_arriver, this.new_stock_depart, this.new_stock_arriver, this.p_depart, this.p_arriver, this.comm_, this.motif_, this.qte_, this.comt_, this.pm_depart, this.pm_arriver, this.etat, this.id_st, this.id_st_d) ;                                 
           this.list.add(tpl) ;
           
           dtm2.addRow(new Object[]{
           tpl.getDescription() , tpl.getQte_() , tpl.getPm_depart() , tpl.getMtt() 
           }) ;
                                 
           this.total.setText(nf3.format(this.to)) ;
                                 
                             this.depart.setEnabled(false);
                             this.arriver.setEnabled(false);
                             this.comm.setEnabled(false);
                             this.motif.setEnabled(false);
                             this.comt.setEnabled(false);
                             this.qte.setText("") ;
                             this.jTable1.getSelectionModel().clearSelection();
                             this.jTable2.getSelectionModel().clearSelection();
                             this.valider.setEnabled(true);
                             
                   
               }
                                   
                  
                  
              }else{
                  JOptionPane.showMessageDialog(null, "STOCK INSUFISANT : "+this.old_stock_depart) ;
              }
               
               
           }
           
           
           }
    
    
}else{
    JOptionPane.showMessageDialog(null, "PARAMETRE INCORRECT ") ;
}
                        
                        
                        
                        
                        
                        
                    }
                    
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage()) ;
                }
                
                
                
            }
            
        }
            
            
            
        }
        
        
        
        
    }//GEN-LAST:event_ajouterActionPerformed

    private void annulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerActionPerformed
        // TODO add your handling code here:
      
        if(this.jTable2.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "SELECTIONNER A GAUCHE POUR ANNULER");
        }else{
            
            DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
            
            this.to -= this.m_a ;
            this.list.remove(this.jTable2.getSelectedRow()) ;
            this.vy_list.remove(this.jTable2.getSelectedRow()) ;
            
            
                             
             dtm.removeRow(this.jTable2.getSelectedRow()) ;                 
            
            if(this.list.size() > 0){
                
                this.total.setText(nf3.format(this.to)) ;
                 this.valider.setEnabled(true);
                
            }else if(this.list.size() == 0){
                
                             this.depart.setEnabled(true);
                             this.depart.setSelectedItem(new String("DEPART"));
                             this.arriver.setEnabled(true);
                             this.arriver.setSelectedItem(new String("ARRIVER"));
                             this.comm.setEnabled(true);
                             this.comm.setSelectedItem(new String("COMMISSIONNAIRE"));
                             this.motif.setEnabled(true);
                             this.motif.setSelectedItem(new String("MOTIF"));
                             this.comt.setEnabled(true) ;
                             this.comt.setText("");
                             this.qte.setText("") ;
                             this.jTable1.getSelectionModel().clearSelection();
                             this.jTable2.getSelectionModel().clearSelection();
                             this.valider.setEnabled(false);
                             this.comt.setEditable(true) ;
                             
                
                this.total.setText(nf3.format(this.to)) ; 
                
            }
            
             
             
        }
        
        
    }//GEN-LAST:event_annulerActionPerformed
long m_a = 0 ;
    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here :
        
        this.jTable1.getSelectionModel().clearSelection();
        
        
        this.m_a = 0 ;
        this.m_a = Long.parseLong(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 3).toString()) ;
        
        
    }//GEN-LAST:event_jTable2MouseReleased

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
            java.util.logging.Logger.getLogger(Op_pl_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Op_pl_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Op_pl_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Op_pl_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Op_pl_final().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JButton annuler;
    private javax.swing.JComboBox arriver;
    private javax.swing.JComboBox comm;
    private javax.swing.JTextField comt;
    private javax.swing.JCheckBox d;
    private javax.swing.JComboBox depart;
    private javax.swing.JTextField desc;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox motif;
    private javax.swing.JCheckBox p;
    private javax.swing.JCheckBox pd;
    private javax.swing.JTextField pm;
    private javax.swing.JTextField qte;
    private javax.swing.JTextField stock;
    private javax.swing.JTextField total;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}
