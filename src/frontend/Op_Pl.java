/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.Type_Pro_Pl.JDBC_DRIVER;
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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HAMZA
 */
public class Op_Pl extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      String login ;
      String role ;
      
      long idmp = 0 ;
      int idp = 0 ;
      
      String description = "";
      String depart = "";
      String arriver = "";
      String perso = "";
      String motif = "";
      String magasin = "" ;
      long   oldStock = 0 ;
      long   newStock = 0 ;
      float  oldPrx_pm = 0 ;
      float newPrx_pm = 0 ;
      float p_m_d ;
      
      String magasin_arriver = "" ;
      long   oldStock_arriver = 0 ;
      float   newPrx_pm_arriver = 0 ;
      Integer type_p = 0 ;
      
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      
      Integer cb ;
      Integer line_1 = 0 ;
      long line1_stock = 0 ;
      
      
      String d1 = "" ;
      String a1 = "" ;
      String c1 = "" ;
      String m1 = "" ;
      String etat = "" ;
      
      
      long  qt = 0 ;
      float pu = 0 ;
      long  montant = 0 ;
      long  total ;
      
      String rapport = "" ;
      
      long ndep = 0 ;
      long nariv = 0 ;
      final static long PORTIONS = 0 ;
      long nderiver = 0 ;
      
      
      ArrayList<PlacementList> list = new ArrayList<PlacementList>() ;
      List bonList = new ArrayList() ;
      ArrayList<String> list_vy = new ArrayList<String>() ;
      ArrayList<Integer> vy_print = new ArrayList<Integer>() ;
      
    
      Integer i = 0 ;
      
      String stock1_mag = "" ;
      long ans = 0 ;
      long av = 0 ;
      long new_s = 0 ;
      
      
      
      // Transaction execution in Mysql_Serveur :
      
      Integer transac ;
      Integer vy_derive = 0 ;
      
      
    public Op_Pl() {
        initComponents() ;
    }
    
     public Op_Pl(String login , String role){
         
        initComponents() ;
        
        this.setLocationRelativeTo(null) ;
        this.login = login ;
        this.role = role ;
        this.jButton3.setEnabled(false) ;
        this.p_d.setSelected(true) ;
        
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
                             
                     // matieres_p.prx_v_unite
                             
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
                 
                 
               // p_derive 
                 
                 
                  String sql8 = "" ;
                 sql8 = "select * from p_derive group by description_d order by description_d asc" ;
                 ResultSet rs8 = stmt.executeQuery(sql8) ;
                 
                 while(rs8.next()){
                 
                     dtm.addRow(new Object[]{
                   
                     rs8.getString("description_d") ,
                    "0" ,
                    "0"  
                             
                     
                     }) ;
                     
                     
                 }
                 
                 
            // end :     
                 
                 
                 
                 
                 
                 
               sql = "select placement from point_pl where type = 'oui' order by placement ASC" ;
                 ResultSet rs20 = stmt.executeQuery(sql) ;
                 
                 while(rs20.next()){
                 
                  this.d.addItem(rs20.getString("placement")) ;
                  this.a.addItem(rs20.getString("placement")) ;
                  
               
       }
                 /*
                 
                 sql = "select magasin from magasins where etat = 'oui' limit 1" ;
                 ResultSet rs22 = null ;
                 rs22 = stmt.executeQuery(sql) ;
                 while(rs22.next()){
                     this.stock1_mag = new String(rs22.getString("magasin")) ;
                     this.d.addItem(new String(rs22.getString("magasin"))) ;
                     this.a.addItem(new String(rs22.getString("magasin"))) ;
                 }
                 
                 */
                 
                 sql = "select perso from perso_t where type = 'oui' AND domaine = 'PL' OR domaine = 'CL_PL' order by perso ASC" ;
                 ResultSet rs21 = stmt.executeQuery(sql) ;
                 
                 while(rs21.next()){
                 
                  this.c.addItem(rs21.getString("perso")) ;
                  
                  
               
       }
                 
                  sql = "select motif from motif_pl where type = 'oui' order by motif ASC" ;
                 ResultSet rs221 = stmt.executeQuery(sql) ;
                 
                 while(rs221.next()){
                 
                  this.m.addItem(rs221.getString("motif")) ;
               
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
        jPanel2 = new javax.swing.JPanel();
        d = new javax.swing.JComboBox();
        a = new javax.swing.JComboBox();
        c = new javax.swing.JComboBox();
        m = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        qte = new javax.swing.JTextField();
        comt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        desc2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pere = new javax.swing.JCheckBox();
        derive = new javax.swing.JCheckBox();
        p_d = new javax.swing.JCheckBox();
        stock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        prx = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INITIER L'OPERATION DE PLACEMENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18))); // NOI18N

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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(1);
        }

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
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(175);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(5);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(3);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PARAMETTRE DE PLACEMENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 14))); // NOI18N

        d.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        d.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DEPART" }));
        d.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dMouseReleased(evt);
            }
        });
        d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dActionPerformed(evt);
            }
        });

        a.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        a.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ARRIVER" }));
        a.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });

        c.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        c.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "COMMISSIONNAIRE" }));
        c.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });

        m.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        m.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MOTIF" }));
        m.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("QTE");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("AJOUTER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("ANNULER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("VALIDER");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("DATE :");

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        qte.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        comt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("COMMENTAIRE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(d, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(a, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(c, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(m, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qte)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(m, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qte, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        desc2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desc2KeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel3.setText("DESCRIPTION");

        jLabel4.setText("TOTAL MONTANT  :  ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("0");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        pere.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pere.setText("PRINCIPAL");
        pere.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pereMouseReleased(evt);
            }
        });

        derive.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        derive.setText("P.DERIVE");
        derive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        derive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deriveMouseReleased(evt);
            }
        });

        p_d.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        p_d.setText("P & D");
        p_d.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        p_d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                p_dMouseReleased(evt);
            }
        });
        p_d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_dActionPerformed(evt);
            }
        });

        stock.setEditable(false);
        stock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel6.setText("STOCK :");

        prx.setEditable(false);

        jLabel7.setText("P.M :");

        close.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        close.setText("FERMER");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(desc2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 48, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pere))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(derive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stock))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(prx, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(p_d, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(330, 330, 330)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(prx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(close, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pere)
                    .addComponent(derive)
                    .addComponent(p_d)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

                String sql = null ;

                sql = "SELECT * FROM produits_pl WHERE recherche like '%"+d1+"%' order by recherche ASC" ;

                ResultSet rs = null ;
                          rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    
                    dtm.addRow(new Object[]{
                    
                        rs.getString("recherche") , rs.getLong("pa") , rs.getLong("pu")
                    
                    });
                    
                }
                
                
                if(this.pere.isSelected() == true){
                    
                }else if(this.pere.isSelected() == false){
                
                
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

    }//GEN-LAST:event_desc2KeyReleased

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here :
       
                
        try{
        
        this.jTable2.getSelectionModel().clearSelection() ;
         
         
            this.magasin = "" ;
            this.oldStock = 0 ;
            this.newStock = 0 ;
            this.oldPrx_pm = 0 ;
            this.newPrx_pm = 0 ;
            
            this.type_p = 0 ;
                
            
            this.magasin_arriver = "" ;
            this.oldStock_arriver = 0 ;
            this.newPrx_pm_arriver = 0 ;
            
            
            this.idmp = 0 ;
            this.idp = 0 ;
            
            this.description = "" ;
            this.rapport = "" ;
            this.pu = 0 ;
            this.p_m_d = 0 ;
            
            this.ans = 0 ;
            this.av = 0 ;
           
                    
            
            
            this.description = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString().replaceAll("'", "''") ;
            
         // this.pu = Long.parseLong(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString()) ;
            
            
        
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
      
      
      if(this.depart.equals("") || this.arriver.equals("") || this.perso.equals("") || this.m.getSelectedItem().toString().equalsIgnoreCase(new String("MOTIF"))){
       
          JOptionPane.showMessageDialog(this, "SELECTIONNER TOUS LES PARAMETRES.");
          
      }else{
          
           
          
       
        String sql = null ;
      
       sql = "SELECT * FROM matieres_p WHERE description = '"+this.description+"'" ;
      
       ResultSet rs = null ;
                 rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
  
       this.idmp = rs.getLong("id") ;
       this.rapport = rs.getString("unite_mesure") ;
       this.oldPrx_pm = Float.parseFloat(rs.getString("prx_v_unite")) ;
       this.pu = this.oldPrx_pm ;
     
        //  JOptionPane.showMessageDialog(this, "P.U MP : "+this.pu);
         
       
     }
     
     
     
     // rapport mp :
     
    
     
     
     //
     
  
    
     
        
       String sql2 ;
      
       sql2 = "SELECT * FROM produits_f WHERE description = '"+this.description+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
  
       this.idp = rs2.getInt("id") ; 
       this.rapport = rs2.getString("unite_m") ;
       this.oldPrx_pm = Float.parseFloat(rs2.getString("pu")) ;
       this.pu = this.oldPrx_pm ;
     
         // JOptionPane.showMessageDialog(this, "P.U PF : "+this.pu);
         
          
         
       
     }
     
     
     sql = "select magasin, description, stock_dispo from stock_pl where magasin = '"+this.depart.replaceAll("'", "''")+"' AND description = '"+this.description+"'" ; 
     rs = stmt.executeQuery(sql) ;
     while(rs.next()){
         
         this.magasin = rs.getString("magasin") ;
         this.oldStock = rs.getLong("stock_dispo") ;
         this.ans = rs.getLong("stock_dispo") ;
         
         
         
     }
     
     this.line_1 = 0 ;
     
      /*
     sql = "select stock from stock1 where maga = '"+this.stock1_mag.replaceAll("'", "''")+"' and desi = '"+this.description+"' limit 1" ; 
     rs = stmt.executeQuery(sql) ;
     while(rs.next()){
         this.line_1 = 1 ;
         
         this.magasin = this.stock1_mag ;
         
        
         this.oldStock = rs.getLong("stock") ;
         this.ans = rs.getLong("stock") ;
        
         
         
     }
     
      */
     
     
     
     sql = "select magasin , description, stock_dispo from stock_pl where magasin = '"+this.arriver.replaceAll("'", "''")+"' AND description = '"+this.description+"'" ; 
     rs = stmt.executeQuery(sql) ;
     while(rs.next()){
         
         this.magasin_arriver = rs.getString("magasin") ;
         this.oldStock_arriver = rs.getLong("stock_dispo") ;
         this.av = rs.getLong("stock_dispo") ;
         
      // this.newPrx_pm_arriver = rs.getLong("prx_pm") ;
     //  this.p_m_d = rs1.getFloat("p_m_d") ;
         
         
     }
     
     
     sql = "select * from derive_pl where produit = '"+this.description+"'" ;
     rs = stmt.executeQuery(sql) ;
     while(rs.next()){
         this.type_p = 1 ;
     }
     
     
    if(this.type_p == 1){
        
     sql = "select magasin, description, stock_dispo , prx_pm from stock_pl where magasin = '"+this.depart.replaceAll("'", "''")+"' AND description = '"+this.description+"'" ; 
     rs = stmt.executeQuery(sql) ;
     while(rs.next()){
         
         this.magasin = rs.getString("magasin") ;
         this.oldStock = rs.getLong("stock_dispo") ;
         this.ans = rs.getLong("stock_dispo") ;
         this.oldPrx_pm = rs.getFloat("prx_pm") ;
   //    this.pu = this.oldPrx_pm ;
     
       //   JOptionPane.showMessageDialog(this, "P.U P_Derive_depart : "+this.oldPrx_pm);
         
         
         
     }
     
     
     sql = "select magasin , description, stock_dispo , prx_pm from stock_pl where magasin = '"+this.arriver.replaceAll("'", "''")+"' AND description = '"+this.description+"'" ; 
     rs = stmt.executeQuery(sql) ;
     while(rs.next()){    
         
         this.magasin_arriver = rs.getString("magasin") ;
         this.oldStock_arriver = rs.getLong("stock_dispo") ;
         this.av = rs.getLong("stock_dispo") ;
         this.newPrx_pm_arriver = rs.getFloat("prx_pm") ;
         
         
         //   this.pu = this.oldPrx_pm ;
     
       //    JOptionPane.showMessageDialog(this, "P.U P_Derive_arriver : "+this.newPrx_pm_arriver);
         
      // this.newPrx_pm_arriver = rs.getLong("prx_pm") ;
     //  this.p_m_d = rs1.getFloat("p_m_d") ;
         
         
     }
     
        
        
    }
     
      
      this.vy_derive = 0 ;
    sql = "select * from p_derive where pere = '"+this.description+"'" ;
    rs = stmt.executeQuery(sql) ;
    while(rs.next()){
        this.vy_derive = 1 ;
    }
    
    
    
    
    
         this.stock.setText(this.nf3.format(this.oldStock)) ;
         this.prx.setText(this.nf3.format(this.oldPrx_pm)) ;
         
      
     
    
       
      
  //   JOptionPane.showMessageDialog(this , "THIS.IDMP = "+this.idmp+" THIS.IDP = "+this.idp) ;
                
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs2.close();
      
      }
      
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
        
         
        
        }catch(Exception e){
          
        }
        
        
       
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
        try{
        this.jTable1.getSelectionModel().clearSelection() ;
        
       this.montant = 0 ;
       
       this.montant = Long.parseLong(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 3).toString()) ;
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "CONTACTER ADMIN POUR CE TYPE D'ERREUR : "+e.getMessage()) ;
        }
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dActionPerformed
        // TODO add your handling code here:
        
        this.d1 = "" ;
        
        this.d1 = this.d.getSelectedItem().toString().replaceAll("'", "''") ;
        this.depart = this.d1 ;
        
        if("DEPART".equalsIgnoreCase(this.d1) ){  // || this.d1.equalsIgnoreCase(this.a.getSelectedItem().toString())){
         //   JOptionPane.showMessageDialog(this, "CHOISIR LE POINT DE DEPART CORRECT SVP ") ;
            this.d1 = "" ;
            this.depart = "" ;
        }
        
        if("ZONE DE PRODUCTION".equalsIgnoreCase(this.d1) ){  // || this.d1.equalsIgnoreCase(this.a.getSelectedItem().toString())){
         //   JOptionPane.showMessageDialog(this, "CHOISIR LE POINT DE DEPART CORRECT SVP ") ;
            this.d1 = "" ;
            this.depart = "" ;
            
            JOptionPane.showMessageDialog(null, "POINT DE DEPART INCORRECT") ;
            
        }
        
        
        
         this.jTable1.getSelectionModel().clearSelection() ;
        
        
    }//GEN-LAST:event_dActionPerformed

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
        
        
        this.a1 = "" ;
        
        this.a1 = this.a.getSelectedItem().toString().replaceAll("'", "''") ;
        this.arriver = this.a1 ;
        
        if("ARRIVER".equalsIgnoreCase(this.a1)){
           // JOptionPane.showMessageDialog(this, "CHOISIR LE POINT D'ARRIVER CORRECT SVP ") ;
            
            this.a1 = "" ;
            this.arriver = "" ;
            this.magasin_arriver = "" ;
            
        }
        
           this.jTable1.getSelectionModel().clearSelection() ;
        
        
    }//GEN-LAST:event_aActionPerformed

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        // TODO add your handling code here:
        
        this.c1 = "" ;
        
        this.c1 = this.c.getSelectedItem().toString().replaceAll("'", "''") ;
        
        this.perso = this.c1 ;
        
        if("COMMISSIONNAIRE".equalsIgnoreCase(this.c1)){
          //  JOptionPane.showMessageDialog(this, "CHOISIR LE COMMISSIONNAIRE CORRECT SVP ") ;
            
            this.c1 = "" ;
            this.perso = "" ;
            
        }
        
        
    }//GEN-LAST:event_cActionPerformed

    private void mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mActionPerformed
        // TODO add your handling code here:
        
    //     this.jTable1.getSelectionModel().clearSelection() ;
        
           this.m1 = "" ;
        
        this.m1 = this.m.getSelectedItem().toString().replaceAll("'", "''") ;
        
        this.motif = this.m1 ;
        
        
        if("MOTIF".equalsIgnoreCase(this.m1)){
          
        }else if("DECOUPAGE".equalsIgnoreCase(this.m1)){
           
            /*
            this.m1 = "" ;
            this.motif = "" ;
            */
            
      if(JOptionPane.showConfirmDialog(null, "CONFIRMEZ VOUS ARRIVER : ZONE DE DECOUPAGE ?" , "AVERTISSEMENT" , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            // yes option :
          
          this.a.setSelectedItem(new String("ZONE DE DECOUPAGE")) ;
             
             }else{
            
                   this.m.setSelectedItem(new String("MOTIF")) ;
            
              }
        
        }else if("ARRIVAGE".equalsIgnoreCase(this.m1)){
           
            /*
            this.m1 = "" ;
            this.motif = "" ;
            */
            
            if(JOptionPane.showConfirmDialog(null, "CONFIRMEZ VOUS DEPART : EXTERIEUR ?" , "AVERTISSEMENT" , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            // yes option :
          
                  this.d.setSelectedItem(new String("EXTERIEUR")) ;
             
             }else{
            
                   this.m.setSelectedItem(new String("MOTIF")) ;
            
              }
            
            
            
            
            
            
        }else if("VENTE".equalsIgnoreCase(this.m1)){
           
            /*
            this.m1 = "" ;
            this.motif = "" ;
            */
            
            if(JOptionPane.showConfirmDialog(null, "CONFIRMEZ VOUS ARRIVER : EXTERIEUR ?" , "AVERTISSEMENT" , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            // yes option :
          
                 this.a.setSelectedItem(new String("EXTERIEUR"));
             
             }else{
            
                   this.m.setSelectedItem(new String("MOTIF")) ;
            
              }
            
            
            
            
            
            
        }else if("AVARIER".equalsIgnoreCase(this.m1)){
           
            /*
            this.m1 = "" ;
            this.motif = "" ;
            */
            
             if(JOptionPane.showConfirmDialog(null, "CONFIRMEZ VOUS ARRIVER : EXTERIEUR ?" , "AVERTISSEMENT" , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            // yes option :
          
                 this.a.setSelectedItem(new String("EXTERIEUR"));
             
             }else{
            
                   this.m.setSelectedItem(new String("MOTIF")) ;
            
              }
            
            
            
            
            
            
            
            
        }else if("PERTE".equalsIgnoreCase(this.m1)){
           
            /*
            this.m1 = "" ;
            this.motif = "" ;
            */
            
             if(JOptionPane.showConfirmDialog(null, "CONFIRMEZ VOUS ARRIVER : EXTERIEUR ?" , "AVERTISSEMENT" , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            // yes option :
          
                 this.a.setSelectedItem(new String("EXTERIEUR"));
             
             }else{
            
                   this.m.setSelectedItem(new String("MOTIF")) ;
            
              }
            
            
          
        }
        
        
        if(this.m1.equalsIgnoreCase("ARRIVAGE") == false && this.m1.equalsIgnoreCase("VENTE") == false && this.m1.equalsIgnoreCase("AVARIER") == false && this.m1.equalsIgnoreCase("PERTE") == false){
            
            if("EXTERIEUR".equalsIgnoreCase(a1) || "EXTERIEUR".equalsIgnoreCase(d1)){
                this.d.setSelectedItem(new String("DEPART"));
                this.a.setSelectedItem(new String("ARRIVER"));
                this.m.setSelectedItem(new String("MOTIF")) ;
                JOptionPane.showMessageDialog(null, "POINT : DEPART OU ARRIVER , INCOMPATIBLE AVEC LE MOTIF ! ") ;
            }
            
        }
        
        
        
        if(this.m1.equalsIgnoreCase("DECOUPAGE") == false){
            
             if("ZONE DE DECOUPAGE".equalsIgnoreCase(a1) || "ZONE DE DECOUPAGE".equalsIgnoreCase(d1)){
                this.d.setSelectedItem(new String("DEPART"));
                this.a.setSelectedItem(new String("ARRIVER"));
                this.m.setSelectedItem(new String("MOTIF")) ;
                JOptionPane.showMessageDialog(null, "POINT : DEPART OU ARRIVER , INCOMPATIBLE AVEC LE MOTIF ! ") ;
            }
            
            
        }
        
         
        
         
        
        
        this.jTable1.getSelectionModel().clearSelection() ;
        
        // EXTERIEUR
        
        
    }//GEN-LAST:event_mActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "SELECTIONNER LE PRODUIT !!! ") ;
            
        }else{
        
        if(this.d1.equalsIgnoreCase(this.a1)){
            
            JOptionPane.showMessageDialog(this, "DEPART # ARRIVER !!! ") ;
            
        }else if("DEPART".equalsIgnoreCase(this.d.getSelectedItem().toString()) || "ARRIVER".equalsIgnoreCase(this.a.getSelectedItem().toString()) || "COMMISSIONNAIRE".equalsIgnoreCase(this.c.getSelectedItem().toString()) || "MOTIF".equalsIgnoreCase(this.m.getSelectedItem().toString()) || "".equalsIgnoreCase(this.comt.getText().trim())){
            
            JOptionPane.showMessageDialog(this, "PRECISER LES PARAMETRES !!! ") ;
            
        }else{
            
            if(this.type_p == 1 && this.m1.equalsIgnoreCase("ARRIVAGE")){
              
                JOptionPane.showMessageDialog(this, "PAS D'ENTREE DIRECT DU PRODUIT DERIVE") ;
            
            }else if((this.type_p == 1 && this.m1.equalsIgnoreCase("DECOUPAGE")) || (this.vy_derive == 0 && this.m1.equalsIgnoreCase("DECOUPAGE"))){
                
                        JOptionPane.showMessageDialog(this, "NON RECONNU POUR DECOUPAGE") ;
                 
                  }else{
            
            
            try{
                
                this.newStock = 0 ;
                
                this.qt = 0 ;
                this.montant = 0 ;
                
                this.qt = Long.parseLong(this.qte.getText()) ;
                
  // ------------------------------------------------------ Mouvement de stock placement Debut : -----------------------------------------------               
           
                // Operation de placement standart entre 2 points de placement :
                
    if(this.magasin.equalsIgnoreCase(this.depart) && this.motif.equalsIgnoreCase("DECOUPAGE") == false  && this.motif.equalsIgnoreCase("ARRIVAGE") == false && this.motif.equalsIgnoreCase("PERTE") == false && this.motif.equalsIgnoreCase("AVARIER") == false  && this.motif.equalsIgnoreCase("VENTE") == false && this.qt > 0){    
        
              //   JOptionPane.showMessageDialog(this, "on test la slt entre A et B");
        
                if(this.oldStock >= this.qt){
                    
                    this.newStock = (this.oldStock - this.qt) ;
                    
                        if(this.type_p == 1){
                            
                            
                            float p1 = 0 ;
                            p1 = (this.newPrx_pm_arriver * oldStock_arriver) ;
                            float p2 = 0 ;
                            p2 = (this.oldPrx_pm * this.qt) ;
                            
                            this.oldStock_arriver = (this.oldStock_arriver + this.qt) ;
                            
                            
              
                                    this.newPrx_pm_arriver = ((p1 + p2) / this.oldStock_arriver ) ;
                                  
                                   
                            
                        }else if(this.type_p == 0){
                            
                            this.oldStock_arriver = (this.oldStock_arriver + this.qt) ;
                            this.newPrx_pm_arriver = this.oldPrx_pm ;
                            
                        }
                        
                    
                    
                    
                    if("oui".equalsIgnoreCase(this.rapport)){
                    
                    double qt0 = 0.0 ;
                           qt0 = (this.qt / 1000.0) ;
                    double mtt0 = 0.0 ;
                           mtt0 = (this.oldPrx_pm * qt0) ;
                           this.montant = Math.round(mtt0) ;
                    
                    
                }else{
                    
                    long qt0 = 0 ;
                         qt0 = this.qt ;
                    double mtt0 = 0.0 ;
                           mtt0 = (this.oldPrx_pm * qt0) ;
                           this.montant = Math.round(mtt0) ;
                    
                    
                }
                
                
               String date1 = "" ;
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
               date1 = sdf.format(new Date()) ;
               
               this.etat = "" ;
               
               if(this.m1.equalsIgnoreCase("DECOUPAGE")){
                   this.etat = "OUVERT" ;
               }else{
                   this.etat = "FERMER" ;
               }
               
               this.ndep = 0 ;
               this.ndep = this.qt ;
               this.nariv = 0 ;
               this.nariv = this.qt ;
               this.nderiver = 0 ;
               this.nderiver = this.qt ;
               
               
               DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
               
           // PlacementList(String date1, String depart, String arriver, String perso, String motif, String etat,
          // String admin, String description, long qte, long pu, long mtt, long ndep, long nariv, long portions, 
               
               
               // commence ici :
               
         // String magasin_depart, String magasin_arriver, long new_stock_depart, long new_stock_arriver,
        // long new_prx_depart, long new_prx_arriver, long nderiver)
               
 // PlacementList pl = new PlacementList(date1, this.d1, this.a1, this.c1, this.m1, this.etat, this.login, this.description, this.qt, this.pu, this.montant,  this.ndep, this.nariv, this.PORTIONS) ;

               if(this.list_vy.contains(new String(this.description))){
                   
                    this.qte.setText("") ;
                   JOptionPane.showMessageDialog(null, "LE PRODUIT EXISTE !") ;
                   
               }else{
                   
                   this.list_vy.add(new String(this.description)) ;
               
PlacementList pl1 = new PlacementList(date1, this.d1, this.a1, this.c1, this.m1, this.etat, this.login, this.description, this.qt, this.oldPrx_pm, this.montant,  this.ndep, this.nariv, this.PORTIONS , this.d1 , this.a1 , this.newStock , this.oldStock_arriver, this.oldPrx_pm , this.newPrx_pm_arriver,this.nderiver , this.p_m_d,this.ans,this.av) ;              
               this.list.add(pl1) ;
               
               
               
            // this.list.add(pl1) ;
               
              
                   dtm.addRow(new Object[]{
               // "DESCRIPTION", "QTE", "P U", "MONTANT"
                   
                   pl1.getDescription() , pl1.getQte() , pl1.getPu() , pl1.getMtt()
                   
               }) ;
                   
              
               
                this.total += this.montant ;
                     
                    
                    NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
                    
                    this.jLabel5.setText(nf3.format(this.total)) ;
                    this.qte.setText("") ;
                    
                    if(this.list.size() > 0){
                        
                        this.d.setEnabled(false) ;
                        this.a.setEnabled(false) ;
                        this.c.setEnabled(false) ;
                        this.m.setEnabled(false) ;
                        this.comt.setEditable(false) ;
                        this.jButton3.setEnabled(true) ;
                        
                    }
                
               
               
               }
               
               
               // ici :
               
               
                   
                    
                    
                    
                    
                }else{
                    JOptionPane.showMessageDialog(this, "STOCK DISPONIBLE : "+this.oldStock) ;
                }
                
                }else{
               //    JOptionPane.showMessageDialog(this, "LA QUANTITE 0 EST REJETEE") ;
                 }
      
      // ------------------------------------------------------ Mouvement de stock placement Fin : -----------------------------------------------
      
    
    // -------------------------------------------------------- entree de stock placement  debut : -----------------------------------------------
    
              // entree de stock placement debut :
                
    if(this.motif.equalsIgnoreCase("ARRIVAGE") && this.qt > 0){    
                            this.line1_stock = 0 ;
                            this.oldStock_arriver = (this.oldStock_arriver + this.qt) ;
                            this.newPrx_pm_arriver = this.oldPrx_pm ;
                            this.line1_stock = (this.oldStock - this.qt) ;
                          
                    
                    
                    if("oui".equalsIgnoreCase(this.rapport)){
                    
                    double qt0 = 0.0 ;
                         qt0 = (this.qt / 1000.0) ;
                    double mtt0 = 0.0 ;
                           mtt0 = (this.oldPrx_pm * qt0) ;
                           this.montant = Math.round(mtt0) ;
                    
                    
                }else{
                    
                    long   qt0 = 0 ;
                           qt0 = this.qt ;
                    double mtt0 = 0.0 ;
                           mtt0 = (this.oldPrx_pm * qt0) ;
                           this.montant = Math.round(mtt0) ;
                    
                    
                }
                
                
               String date1 = "" ;
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
               date1 = sdf.format(new Date()) ;
               
               this.etat = "" ;
               
               if(this.m1.equalsIgnoreCase("DECOUPAGE")){
                   this.etat = "OUVERT" ;
               }else{
                   this.etat = "FERMER" ;
               }
               
               this.ndep = 0 ;
               this.ndep = this.qt ;
               this.nariv = 0 ;
               this.nariv = this.qt ;
               this.nderiver = 0 ;
               this.nderiver = this.qt ;
               
               
               DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
               
           // PlacementList(String date1, String depart, String arriver, String perso, String motif, String etat,
          // String admin, String description, long qte, long pu, long mtt, long ndep, long nariv, long portions, 
               
               
               // commence ici :
               
         // String magasin_depart, String magasin_arriver, long new_stock_depart, long new_stock_arriver,
        // long new_prx_depart, long new_prx_arriver, long nderiver)
               
 // PlacementList pl = new PlacementList(date1, this.d1, this.a1, this.c1, this.m1, this.etat, this.login, this.description, this.qt, this.pu, this.montant,  this.ndep, this.nariv, this.PORTIONS) ;
    
           if(this.list_vy.contains(new String(this.description))){
                    this.qte.setText("") ;
                    JOptionPane.showMessageDialog(null, "LE PRODUIT EXISTE !") ;
                   
               }else{
                   
                   this.list_vy.add(new String(this.description)) ;
                   
                                                                                                                                                                                                                              // this.newstock                               
 PlacementList pl1 = new PlacementList(date1, this.d1, this.a1, this.c1, this.m1, this.etat, this.login, this.description, this.qt, this.oldPrx_pm, this.montant,  this.ndep, this.nariv, this.PORTIONS , this.d1 , this.a1 , this.newStock , this.oldStock_arriver, this.oldPrx_pm , this.newPrx_pm_arriver,this.nderiver , this.p_m_d,this.ans,this.av) ;              
               
               this.list.add(pl1) ;
            // this.list.add(pl1) ;
              
               dtm.addRow(new Object[]{
               // "DESCRIPTION", "QTE", "P U", "MONTANT"
                   
                   pl1.getDescription() , pl1.getQte() , pl1.getPu() , pl1.getMtt()
                   
               }) ;
               
                
              this.total += this.montant ;
                     
                    
                    NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
                    
                    this.jLabel5.setText(nf3.format(this.total)) ;
                    this.qte.setText("") ;
                    
                    if(this.list.size() > 0){
                        
                        this.d.setEnabled(false) ;
                        this.a.setEnabled(false) ;
                        this.c.setEnabled(false) ;
                        this.m.setEnabled(false) ;
                        this.comt.setEditable(false);
                        this.jButton3.setEnabled(true) ;
                        
                    }
                
                    
               
               
           }
               
                    
                   
               
                
                }else{
                  // JOptionPane.showMessageDialog(this, "LA QUANTITE 0 EST REJETEE") ;
                 }
      
      // Entree de stock placement Fin :
    
    // --------------------------------------------------------- Fin entree de stock placement :    -------------------------------------------
      
  // -------------------------------------------------------- sorti de stock placement  debut : -----------------------------------------------
    
               // Sortie de stock placement debut :
                
    if(this.magasin.equalsIgnoreCase(this.depart) && this.motif.equalsIgnoreCase("VENTE") && this.qt > 0){    
                    
                if(this.oldStock >= this.qt){
                    
                    this.newStock = (this.oldStock - this.qt) ;
                    
                   
                    if("oui".equalsIgnoreCase(this.rapport)){
                    
                    double qt0 = 0.0 ;
                         qt0 = (this.qt / 1000.0) ;
                    double mtt0 = 0.0 ;
                           mtt0 = (this.oldPrx_pm * qt0) ;
                           this.montant = Math.round(mtt0) ;
                    
                    
                }else{
                    
                    long qt0 = 0 ;
                         qt0 = this.qt ;
                    double mtt0 = 0.0 ;
                           mtt0 = (this.oldPrx_pm * qt0) ;
                           this.montant = Math.round(mtt0) ;
                    
                    
                }
                
                
               String date1 = "" ;
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
               date1 = sdf.format(new Date()) ;
               
               this.etat = "" ;
               
               if(this.m1.equalsIgnoreCase("DECOUPAGE")){
                   this.etat = "OUVERT" ;
               }else{
                   this.etat = "FERMER" ;
               }
               
               this.ndep = 0 ;
               this.ndep = this.qt ;
               this.nariv = 0 ;
               this.nariv = this.qt ;
               this.nderiver = 0 ;
               this.nderiver = this.qt ;
               
               
               DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
               
           // PlacementList(String date1, String depart, String arriver, String perso, String motif, String etat,
          // String admin, String description, long qte, long pu, long mtt, long ndep, long nariv, long portions, 
               
               
               // commence ici :
               
         // String magasin_depart, String magasin_arriver, long new_stock_depart, long new_stock_arriver,
        // long new_prx_depart, long new_prx_arriver, long nderiver)
               
 // PlacementList pl = new PlacementList(date1, this.d1, this.a1, this.c1, this.m1, this.etat, this.login, this.description, this.qt, this.pu, this.montant,  this.ndep, this.nariv, this.PORTIONS) ;
   
               if(this.list_vy.contains(new String(this.description))){
                    this.qte.setText("") ;
                   JOptionPane.showMessageDialog(null, "LE PRODUIT EXISTE !") ;
                   
               }else{
                   
                   this.list_vy.add(new String(this.description)) ;
               
               
  PlacementList pl1 = new PlacementList(date1, this.d1, this.a1, this.c1, this.m1, this.etat, this.login, this.description, this.qt, this.oldPrx_pm, this.montant,  this.ndep, this.nariv, this.PORTIONS , this.d1 , this.a1 , this.newStock , this.oldStock_arriver, this.oldPrx_pm , this.newPrx_pm_arriver,this.nderiver, this.p_m_d,this.ans,this.av) ;              
               this.list.add(pl1) ;
            // this.list.add(pl1) ;
               
               dtm.addRow(new Object[]{
               // "DESCRIPTION", "QTE", "P U", "MONTANT"
                   
                   pl1.getDescription() , pl1.getQte() , pl1.getPu() , pl1.getMtt()
                   
               }) ;
               
               this.total += this.montant ;
                     
                    
                    NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
                    
                    this.jLabel5.setText(nf3.format(this.total)) ;
                    this.qte.setText("") ;
                    
                    if(this.list.size() > 0){
                        
                        this.d.setEnabled(false) ;
                        this.a.setEnabled(false) ;
                        this.c.setEnabled(false) ;
                        this.m.setEnabled(false) ;
                        this.comt.setEditable(false);
                        this.jButton3.setEnabled(true) ;
                        
                    }
                
                    
               
                
               }
               
               
                    
                    
                    
                    
                }else{
                    JOptionPane.showMessageDialog(this, "STOCK DISPONIBLE : "+this.oldStock) ;
                }
                
                }else{
               //    JOptionPane.showMessageDialog(this, "LA QUANTITE 0 EST REJETEE") ;
                 }
      
      // Sortie de stock placement Fin :
      
    
    // --------------------------------------------------------- Fin Sortie de stock placement :    -------------------------------------------
      
    
     // -------------------------------------------------------- AVARIER de stock placement  debut : -----------------------------------------------
    
               // AVARIER de stock placement debut :
                
    if(this.magasin.equalsIgnoreCase(this.depart) && this.motif.equalsIgnoreCase("AVARIER") && this.qt > 0){    
                    
                if(this.oldStock >= this.qt){
                    
                    this.newStock = (this.oldStock - this.qt) ;
                    
                   
                    if("oui".equalsIgnoreCase(this.rapport)){
                    
                    double qt0 = 0.0 ;
                         qt0 = (this.qt / 1000.0) ;
                    double mtt0 = 0.0 ;
                           mtt0 = (this.oldPrx_pm * qt0) ;
                           this.montant = Math.round(mtt0) ;
                    
                    
                }else{
                    
                    long qt0 = 0 ;
                         qt0 = this.qt ;
                    double mtt0 = 0.0 ;
                           mtt0 = (this.oldPrx_pm * qt0) ;
                           this.montant = Math.round(mtt0) ;
                    
                    
                }
                
                
               String date1 = "" ;
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
               date1 = sdf.format(new Date()) ;
               
               this.etat = "" ;
               
               if(this.m1.equalsIgnoreCase("DECOUPAGE")){
                   this.etat = "OUVERT" ;
               }else{
                   this.etat = "FERMER" ;
               }
               
               this.ndep = 0 ;
               this.ndep = this.qt ;
               this.nariv = 0 ;
               this.nariv = this.qt ;
               this.nderiver = 0 ;
               this.nderiver = this.qt ;
               
               
               DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
               
           // PlacementList(String date1, String depart, String arriver, String perso, String motif, String etat,
          // String admin, String description, long qte, long pu, long mtt, long ndep, long nariv, long portions, 
               
               
               // commence ici :
               
         // String magasin_depart, String magasin_arriver, long new_stock_depart, long new_stock_arriver,
        // long new_prx_depart, long new_prx_arriver, long nderiver)
               
 // PlacementList pl = new PlacementList(date1, this.d1, this.a1, this.c1, this.m1, this.etat, this.login, this.description, this.qt, this.pu, this.montant,  this.ndep, this.nariv, this.PORTIONS) ;
   
               if(this.list_vy.contains(new String(this.description))){
                    this.qte.setText("") ;
                   JOptionPane.showMessageDialog(null, "LE PRODUIT EXISTE !") ;
                   
               }else{
                   
                   this.list_vy.add(new String(this.description)) ;
               
               
PlacementList pl1 = new PlacementList(date1, this.d1, this.a1, this.c1, this.m1, this.etat, this.login, this.description, this.qt, this.oldPrx_pm, this.montant,  this.ndep, this.nariv, this.PORTIONS , this.d1 , this.a1 , this.newStock , this.oldStock_arriver, this.oldPrx_pm , this.newPrx_pm_arriver,this.nderiver, this.p_m_d,this.ans,this.av) ;              
               this.list.add(pl1) ;
            // this.list.add(pl1) ;
               
               dtm.addRow(new Object[]{
               // "DESCRIPTION", "QTE", "P U", "MONTANT"
                   
                   pl1.getDescription() , pl1.getQte() , pl1.getPu() , pl1.getMtt()
                   
               }) ;
                
                this.total += this.montant ;
                     
                    
                    NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
                    
                    this.jLabel5.setText(nf3.format(this.total)) ;
                    this.qte.setText("") ;
                    
                    if(this.list.size() > 0){
                        
                        this.d.setEnabled(false) ;
                        this.a.setEnabled(false) ;
                        this.c.setEnabled(false) ;
                        this.m.setEnabled(false) ;
                        this.comt.setEditable(false);
                        this.jButton3.setEnabled(true) ;
                        
                    }
                
                    
               
               }
               
                   
                    
                    
                    
                }else{
                    JOptionPane.showMessageDialog(this, "STOCK DISPONIBLE : "+this.oldStock) ;
                }
                
                }else{
             //      JOptionPane.showMessageDialog(this, "LA QUANTITE 0 EST REJETEE") ;
                 }
      
      // AVARIER de stock placement Fin :
      
    
    // --------------------------------------------------------- Fin AVARIER de stock placement :    -------------------------------------------
      
   // -------------------------------------------------------- PERTE de stock placement  debut : -----------------------------------------------
    
               // PERTE de stock placement debut :
                
    if(this.magasin.equalsIgnoreCase(this.depart) && this.motif.equalsIgnoreCase("PERTE") && this.qt > 0){    
                    
                if(this.oldStock >= this.qt){
                    
                    this.newStock = (this.oldStock - this.qt) ;
                    
                   
                    if("oui".equalsIgnoreCase(this.rapport)){
                    
                    double qt0 = 0.0 ;
                         qt0 = (this.qt / 1000.0) ;
                    double mtt0 = 0.0 ;
                           mtt0 = (this.oldPrx_pm * qt0) ;
                           this.montant = Math.round(mtt0) ;
                    
                    
                }else{
                    
                    long qt0 = 0 ;
                         qt0 = this.qt ;
                    double mtt0 = 0.0 ;
                           mtt0 = (this.oldPrx_pm * qt0) ;
                           this.montant = Math.round(mtt0) ;
                    
                    
                }
                
                
               String date1 = "" ;
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
               date1 = sdf.format(new Date()) ;
               
               this.etat = "" ;
               
               if(this.m1.equalsIgnoreCase("DECOUPAGE")){
                   this.etat = "OUVERT" ;
               }else{
                   this.etat = "FERMER" ;
               }
               
               this.ndep = 0 ;
               this.ndep = this.qt ;
               this.nariv = 0 ;
               this.nariv = this.qt ;
               this.nderiver = 0 ;
               this.nderiver = this.qt ;
               
               
               DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
               
           // PlacementList(String date1, String depart, String arriver, String perso, String motif, String etat,
          // String admin, String description, long qte, long pu, long mtt, long ndep, long nariv, long portions, 
               
               
               // commence ici :
               
         // String magasin_depart, String magasin_arriver, long new_stock_depart, long new_stock_arriver,
        // long new_prx_depart, long new_prx_arriver, long nderiver)
               
 // PlacementList pl = new PlacementList(date1, this.d1, this.a1, this.c1, this.m1, this.etat, this.login, this.description, this.qt, this.pu, this.montant,  this.ndep, this.nariv, this.PORTIONS) ;
   
               if(this.list_vy.contains(new String(this.description))){
                    this.qte.setText("") ;
                   JOptionPane.showMessageDialog(null, "LE PRODUIT EXISTE !") ;
                   
               }else{
                   
                   this.list_vy.add(new String(this.description)) ;
               
               
PlacementList pl1 = new PlacementList(date1, this.d1, this.a1, this.c1, this.m1, this.etat, this.login, this.description, this.qt, this.oldPrx_pm, this.montant,  this.ndep, this.nariv, this.PORTIONS , this.d1 , this.a1 , this.newStock , this.oldStock_arriver, this.oldPrx_pm , this.newPrx_pm_arriver,this.nderiver , this.p_m_d,this.ans,this.av) ;              
          
               this.list.add(pl1) ;
            // this.list.add(pl1) ;
               
               dtm.addRow(new Object[]{
               // "DESCRIPTION", "QTE", "P U", "MONTANT"
                   
                   pl1.getDescription() , pl1.getQte() , pl1.getPu() , pl1.getMtt()
                   
               }) ;
                
               this.total += this.montant ;
                     
                    
                    NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
                    
                    this.jLabel5.setText(nf3.format(this.total)) ;
                    this.qte.setText("") ;
                    
                    if(this.list.size() > 0){
                        
                        this.d.setEnabled(false) ;
                        this.a.setEnabled(false) ;
                        this.c.setEnabled(false) ;
                        this.m.setEnabled(false) ;
                        this.comt.setEditable(false);
                        this.jButton3.setEnabled(true) ;
                        
                    }
                
                    
               
               
               }
               
                    
                    
                    
                    
                }else{
                    JOptionPane.showMessageDialog(this, "STOCK DISPONIBLE : "+this.oldStock) ;
                }
                
                }else{
               //    JOptionPane.showMessageDialog(this, "LA QUANTITE 0 EST REJETEE") ;
                 }
      
      // PERTE de stock placement Fin :
      
    
    // --------------------------------------------------------- Fin PERTE de stock placement :    -------------------------------------------
                 
    // -------------------------------------------------------- DECOUPAGE de stock placement  debut : -----------------------------------------------
    
              
                
    if(this.magasin.equalsIgnoreCase(this.depart) && this.motif.equalsIgnoreCase("DECOUPAGE") && this.qt > 0){    
                    
                if(this.oldStock >= this.qt){
                    
                    this.newStock = (this.oldStock - this.qt) ;
                    
                   
                    if("oui".equalsIgnoreCase(this.rapport)){
                    
                    double qt0 = 0.0 ;
                         qt0 = (this.qt / 1000.0) ;
                    double mtt0 = 0.0 ;
                           mtt0 = (this.oldPrx_pm * qt0) ;
                           this.montant = Math.round(mtt0) ;
                    
                    
                }else{
                    
                    long qt0 = 0 ;
                         qt0 = this.qt ;
                    double mtt0 = 0.0 ;
                           mtt0 = (this.oldPrx_pm * qt0) ;
                           this.montant = Math.round(mtt0) ;
                    
                    
                }
                
                
               String date1 = "" ;
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
               date1 = sdf.format(new Date()) ;
               
               this.etat = "" ;
               
               if(this.m1.equalsIgnoreCase("DECOUPAGE")){
                   this.etat = "OUVERT" ;
               }else{
                   this.etat = "FERMER" ;
               }
               
               this.ndep = 0 ;
               this.ndep = this.qt ;
               this.nariv = 0 ;
               this.nariv = this.qt ;
               this.nderiver = 0 ;
               this.nderiver = this.qt ;
               
               
               DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
               
           // PlacementList(String date1, String depart, String arriver, String perso, String motif, String etat,
          // String admin, String description, long qte, long pu, long mtt, long ndep, long nariv, long portions, 
               
               
               // commence ici :
               
         // String magasin_depart, String magasin_arriver, long new_stock_depart, long new_stock_arriver,
        // long new_prx_depart, long new_prx_arriver, long nderiver)
               
 // PlacementList pl = new PlacementList(date1, this.d1, this.a1, this.c1, this.m1, this.etat, this.login, this.description, this.qt, this.pu, this.montant,  this.ndep, this.nariv, this.PORTIONS) ;
  
      if(this.list_vy.contains(new String(this.description))){
                    this.qte.setText("") ;
                   JOptionPane.showMessageDialog(null, "LE PRODUIT EXISTE !") ;
                   
               }else{
                   
                   this.list_vy.add(new String(this.description)) ;
                        
               
PlacementList pl1 = new PlacementList(date1, this.d1, this.a1, this.c1, this.m1, this.etat, this.login, this.description, this.qt, this.oldPrx_pm, this.montant,  this.ndep, this.nariv, this.PORTIONS , this.d1 , this.a1 , this.newStock , this.oldStock_arriver, this.oldPrx_pm , this.newPrx_pm_arriver,this.nderiver, this.p_m_d,this.ans,this.av) ;              
               this.list.add(pl1) ;
            // this.list.add(pl1) ;
               
               dtm.addRow(new Object[]{
               // "DESCRIPTION", "QTE", "P U", "MONTANT"
                   
                   pl1.getDescription() , pl1.getQte() , pl1.getPu() , pl1.getMtt()
                   
               }) ;
               
               
                this.total += this.montant ;
                     
                    
                    NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
                    
                    this.jLabel5.setText(nf3.format(this.total)) ;
                    this.qte.setText("") ;
                    
                    if(this.list.size() > 0){
                        
                        this.d.setEnabled(false) ;
                        this.a.setEnabled(false) ;
                        this.c.setEnabled(false) ;
                        this.m.setEnabled(false) ;
                        this.comt.setEditable(false);
                        this.jButton3.setEnabled(true) ;
                        
                    }
                
                
               
      }
               
                   
                    
                    
                    
                    
                }else{
                    JOptionPane.showMessageDialog(this, "STOCK DISPONIBLE : "+this.oldStock) ;
                }
                
                }else{
            //       JOptionPane.showMessageDialog(this, "LA QUANTITE 0 EST REJETEE") ;
                 }
      
      // DECOUPAGE de stock placement Fin :
      
    
    // --------------------------------------------------------- Fin DECOUPAGE de stock placement :    -------------------------------------------
                 
    
     
    
                
                    // end :
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "CHIFFRE UNIQUEMENT ") ;
            }
            
            
        }    
            
        }
        
        
        
        
        
        } 
        
        if(this.magasin.equals("")){
            JOptionPane.showMessageDialog(this, "LE PRODUIT N'A PAS DE STOCK !!!");
        }
        
         this.jTable1.getSelectionModel().clearSelection() ;
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
         DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
        
       if(this.jTable2.getSelectedRow() == -1){
           JOptionPane.showMessageDialog(this, "SELECTIONNER LE PRODUIT !!! ") ;
           
       }else{
           
           
                 NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
                 
                 this.total = (this.total - this.montant) ;
                    
                    this.jLabel5.setText(nf3.format(this.total)) ;
                     this.qte.setText("") ;
           
           this.list.remove(this.jTable2.getSelectedRow()) ;
           this.list_vy.remove(this.jTable2.getSelectedRow()) ;
           dtm.removeRow(this.jTable2.getSelectedRow());
           
            if(this.list.size() > 0){
                        
                        this.d.setEnabled(false) ;
                        this.a.setEnabled(false) ;
                        this.c.setEnabled(false) ;
                        this.m.setEnabled(false) ;
                        this.comt.setEditable(false);
                        this.jButton3.setEnabled(true) ;
                        
                    }else if(this.list.size() == 0){
                
                        this.d.setEnabled(true) ;
                        this.a.setEnabled(true) ;
                        this.c.setEnabled(true) ;
                        this.m.setEnabled(true) ;
                        this.comt.setEditable(true);
                        this.jButton3.setEnabled(false) ;
                
            }
           
           
       }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
       // TODO add your handling code here :
        
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        String jour = dt.format(new Date()) ;
        this.transac = 0 ;
        this.vy_print.removeAll(this.vy_print) ;
        
        
        this.jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
              this.close.setEnabled(false) ;
        
        this.bonList.removeAll(this.bonList) ;
        NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
        
        if(this.list.size() > 0 ){
        
        this.cb = 0 ;
        
        Random rx = new Random() ;
        
        this.cb = rx.nextInt() ;
        
        if(this.cb < 0){
            this.cb = Math.abs(this.cb) ;
        }
        
         try{
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" , Locale.getDefault()) ;
       
        String date2 = sdf.format(this.jDateChooser1.getDate())  ;
        
        // saveing ....
        
        
               Connection conn = null ;
               Statement stmt = null  ;
               PreparedStatement ps = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...") ;
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;
      conn.setAutoCommit(false) ;
      

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
      int vy ;
          vy = 0 ;
      
      String sql = null ;
             sql = "select * from op_pl_f where cb = "+this.cb ;
             ResultSet rs = null ;
                     rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                vy = 1 ;
             }
             
             long id = 0 ;
             sql = "select id from op_pl_f order by id desc limit 1" ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                 id = rs.getLong("id") ;
             }
             
             long num = 0 ;
                  num = (id + 1) ;
      
      if(vy == 0){
          
          int i = 0 ;
          
          
          if(stmt.executeUpdate("insert into op_pl_f(cb,date1,date2,depart,arriver,perso,motif,etat,admin,comt) VALUES("
                  +this.cb+" , '"+this.list.get(i).getDate1()+"' , '"+date2+"' , '"+this.list.get(i).getDepart().replaceAll("'", "''")+"' , '"
          +this.list.get(i).getArriver().replaceAll("'", "''")+"' , '"+this.list.get(i).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(i).getMotif().replaceAll("'", "''")+"' , '"
                  +this.etat+"' , '"+this.login.replaceAll("'", "''")+"' , '"+this.comt.getText().trim().replaceAll("'", "''")+"' )") == 1){
                
                  long tmtt = 0 ;
              
              for(int ii = 0 ; this.list.size() > ii ; ii++){
                  
                   HashMap<String, Object> m = new HashMap<>();
                   
                   m.put("description", this.list.get(ii).getDescription()) ;
                   m.put("qte", nf3.format(this.list.get(ii).getQte())) ;
                   m.put("pu", nf3.format(this.list.get(ii).getPu())) ;
                   m.put("mtt", this.list.get(ii).getMtt()) ;
                              tmtt += this.list.get(ii).getMtt() ;
                   m.put("tmtt", "TOTAL MTT : "+nf3.format(tmtt)) ;
                              
                              this.bonList.add(m) ;
                              
                              // update stock_pl or create stock placement with detail operation :
                              
                                    /*
                              
                                   DECOUPAGE
                                   ENTREE
                                   SORTIE
                                   AVARIER
                                   PERTE
                              
                                   */
                              
  // ---------------------------------------------- debut motif entree : -----------------------------------------------------
                              
                              if(this.list.get(ii).getMotif().equalsIgnoreCase("ARRIVAGE")){
                                  
                                   
                                  
                                 int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                 
                                 if(vy0 == 0){
                                     
                                     if(stmt.executeUpdate("insert into stock_pl(magasin,description,stock_dispo,prx_pm,dtec,admin) values( '"
                                             +this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getNew_stock_arriver()+" , "
                                             +this.list.get(ii).getNew_prx_arriver()+" , '"+this.list.get(ii).getDate1()+"' , '"
                                             +this.list.get(ii).getAdmin().replaceAll("'", "''")+"')") == 1){
                                         
                                         // detail stock placement     :
                                         
                                         
                                          if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "
          + this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" ) == 1 ){
                 
                                              
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                          
                                     }     
                                     
                                 }else if(vy0 == 1){
                                     
                                    
                                     
                                     Integer rowAf = stmt.executeUpdate("update stock_pl set stock_dispo = "+this.list.get(ii).getNew_stock_arriver()+" , prx_pm = "
                                             +this.list.get(ii).getNew_prx_arriver()+" where magasin = '"+this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")+"' and description = '"
                                             +this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
                                   
                                     
                                     if(rowAf == 1){
                                         
                                         
                                              // detail stock placement     :
                                         
                                         
                                          if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" ) == 1 ){
                 
                                              
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }   
                                     }
                                     
                                 }
                                 
                                  
                                  
                              }
                              
                  
            // ---------------------------------------------- fin motif entree : -----------------------------------------------------
                              
                              
          // ------------------------------------------------ debut motif sortie : ---------------------------------------------------
                              
                              if(this.list.get(ii).getMotif().equalsIgnoreCase("VENTE")){
                                  
                                
                                  
                                 int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                 
                                 if(vy0 == 0){
                                     
                                     /*
                                     if(stmt.executeUpdate("insert into stock_pl(magasin,description,stock_dispo,prx_pm,dtec,admin) values( '"
                                             +this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getNew_stock_arriver()+" , "
                                             +this.list.get(ii).getNew_prx_arriver()+" , '"+this.list.get(ii).getDate1()+"' , '"
                                             +this.list.get(ii).getAdmin().replaceAll("'", "''")+"')") == 1){
                                         
                                         // detail stock placement     :
                                         
                                         
                                          if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                                              
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                          
                                     }   
                                     
                                     */
                                     
                                     JOptionPane.showMessageDialog(this, "PAS DE STOCK ") ;
                                     
                                     
                                 }else if(vy0 == 1){
                                     
                                     Integer rowAf = stmt.executeUpdate("update stock_pl set stock_dispo = "+this.list.get(ii).getNew_stock_depart()+" where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"
                                             +this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
                                     
                                     if(rowAf == 1){
                                         
                                         
                                              // detail stock placement     :
                                         
                                         
                                          if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" ) == 1 ){
                 
                                              
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                         
                                         
                                     }
                                     
                                     
                                     
                                 }
                                 
                                  
                                  
                              }
                              
        //   ----------------------------------------------- fin motif sortie : ---------------------------------------------------                     
             
     //  ------------------------------------- debut motif PERTE : ---------------------------------------------------
                              
                              if(this.list.get(ii).getMotif().equalsIgnoreCase("PERTE")){
                                  
                                 
                                  
                                 int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                 
                                 if(vy0 == 0){
                                     
                                    
                                     JOptionPane.showMessageDialog(this, "PAS DE STOCK ") ;
                                     
                                     
                                 }else if(vy0 == 1){
                                     Integer rowAf = stmt.executeUpdate("update stock_pl set stock_dispo = "+this.list.get(ii).getNew_stock_depart()+" where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"
                                             +this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
                                     if(rowAf == 1){
                                         
                                         
                                              // detail stock placement     :
                                         
                                         
                                          if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" ) == 1 ){
                 
                                              
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                         
                                         
                                     }
                                     
                                     
                                     
                                 }
                                 
                                  
                                  
                              }
                              
        //   ----------------------------------------------- fin motif PERTE : ---------------------------------------------------                     
        
                              
       //  ------------------------------------- debut motif AVARIER : ---------------------------------------------------
                              
                              if(this.list.get(ii).getMotif().equalsIgnoreCase("AVARIER")){
                              
                                
                                  
                                 int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                 
                                 if(vy0 == 0){
                                     
                                    
                                     JOptionPane.showMessageDialog(this, "PAS DE STOCK ") ;
                                     
                                     
                                 }else if(vy0 == 1){
                                     
                                     Integer rowAf = stmt.executeUpdate("update stock_pl set stock_dispo = "+this.list.get(ii).getNew_stock_depart()+" where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"
                                             +this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
                                     
                                     if(rowAf == 1){
                                         
                                         
                                              // detail stock placement     :
                                         
                                         
                                          if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" ) == 1 ){
                 
                                              
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                         
                                         
                                     }
                                     
                                     
                                     
                                 }
                                 
                                  
                                  
                              }
                              
        //   ----------------------------------------------- fin motif AVARIER : ---------------------------------------------------                     
              
         //  ------------------------------------- debut motif DECOUPAGE : ---------------------------------------------------
                              
                              if(this.list.get(ii).getMotif().equalsIgnoreCase("DECOUPAGE")){
                                  
                               
                                  
                                 int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                 
                                 if(vy0 == 0){
                                     
                                    
                                     JOptionPane.showMessageDialog(this, "PAS DE STOCK ") ;
                                     
                                     
                                 }else if(vy0 == 1){
                                     
                                     long newst = 0 ;
                                     sql = "update stock_pl set stock_dispo = ? where magasin = ? and description = ? " ;
                                     
                                     ps = conn.prepareStatement(sql) ;
                                     ps.setLong(1, this.list.get(ii).getNew_stock_depart());
                                     ps.setString(2, this.list.get(ii).getMagasin_depart().replaceAll("'", "''"));
                                     ps.setString(3, this.list.get(ii).getDescription().replaceAll("'", "''"));
                                     
                                    Integer rowAf = ps.executeUpdate() ;
                                     
                                     /*
                                     
                                     Integer rowAf = stmt.executeUpdate("update stock_pl set stock_dispo = "+this.list.get(ii).getNew_stock_depart()+" where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"
                                             +this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
                                     
                                     */
                                     
                                     if(rowAf == 1){
                                         
                                         
                                              // detail stock placement     :
                                         
                                         
                                          if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" ) == 1 ){
                                              
                                              
                                 sql = "update stock_pl set stock_dispo = ? where magasin = ? and description = ? " ;
                                     
                                     ps = conn.prepareStatement(sql) ;
                                     ps.setLong(1, this.list.get(ii).getNew_stock_depart());
                                     ps.setString(2, this.list.get(ii).getMagasin_depart().replaceAll("'", "''"));
                                     ps.setString(3, this.list.get(ii).getDescription().replaceAll("'", "''"));
                                     
                                     ps.executeUpdate() ;
                 
                                              
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                                                  
                       sql = "update stock_pl set stock_dispo = ? where magasin = ? and description = ? " ;
                                     
                                     ps = conn.prepareStatement(sql) ;
                                     ps.setLong(1, this.list.get(ii).getNew_stock_depart());
                                     ps.setString(2, this.list.get(ii).getMagasin_depart().replaceAll("'", "''"));
                                     ps.setString(3, this.list.get(ii).getDescription().replaceAll("'", "''"));
                                     
                                     ps.executeUpdate() ;
                                     
                                    sql = "select stock_dispo from stock_pl where magasin = ? and description = ?" ;
                                    ps = conn.prepareStatement(sql) ;
                                     ps.setString(1, this.list.get(ii).getMagasin_depart().replaceAll("'", "''"));
                                     ps.setString(2, this.list.get(ii).getDescription().replaceAll("'", "''"));
                                     rs = ps.executeQuery() ;
                                     while(rs.next()){
                                         newst = rs.getLong("stock_dispo") ;
                                     }
                                     
                                     if(newst == this.list.get(ii).getAns()){
                                         Integer a = 0 ;
                                         this.vy_print.add(a) ;
                                     }else{
                                         Integer b = 1 ;
                                         this.vy_print.add(b) ;
                                     }
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                         
                                         
                                     }
                                     
                                     
                                     
                                 }
                                 
                                  
                                  
                              }
                              
        //   ----------------------------------------------- fin motif DECOUPAGE : ---------------------------------------------------                     
              
                                       
      //  ------------------------------------- debut motif standard mouvement d'un point A vers un point B : ---------------------------------------------------
                              
                               
                              if(this.list.get(ii).getMotif().equalsIgnoreCase("DECOUPAGE") == false && this.list.get(ii).getMotif().equalsIgnoreCase("ARRIVAGE") == false && this.list.get(ii).getMotif().equalsIgnoreCase("VENTE") == false && this.list.get(ii).getMotif().equalsIgnoreCase("AVARIER") == false && this.list.get(ii).getMotif().equalsIgnoreCase("PERTE") == false ){
                                  
                               
                                  
                                 int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                  int av = 0 ;
                                         sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getMagasin_arriver().replaceAll("'" , "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                         rs = stmt.executeQuery(sql) ;
                                         while(rs.next()){
                                             av = 1 ;
                                         }
                                 
                                 
                                 if(vy0 == 0){
                                     
                                    
                                     JOptionPane.showMessageDialog(this, "PAS DE STOCK ") ;
                                     
                                     
                                 }else if(vy0 == 1){
                                     
                                      long newst = 0 ;
                              sql = "update stock_pl set stock_dispo = ? , p_m_d = ? where magasin = ? and description = ? " ;
                                     
                                     ps = conn.prepareStatement(sql) ;
                                     ps.setLong(1, this.list.get(ii).getNew_stock_depart());
                                     ps.setFloat(2, this.list.get(ii).getP_m_d());
                                     ps.setString(3, this.list.get(ii).getMagasin_depart().replaceAll("'", "''"));
                                     ps.setString(4, this.list.get(ii).getDescription().replaceAll("'", "''"));
                                     
                                    Integer rowAf = ps.executeUpdate() ;
                                    
                                    
                                    stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" ) ;
                                     
                                    /*
                                     Integer rowAf = stmt.executeUpdate("update stock_pl set stock_dispo = "+this.list.get(ii).getNew_stock_depart()+" , p_m_d = "+this.list.get(ii).getP_m_d()+" where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"
                                             +this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
                                    */ 
                                    
                                    
                                     if(rowAf == 1){
                                         
                                         
                 sql = "update stock_pl set stock_dispo = ? , p_m_d = ? where magasin = ? and description = ? " ;
                                     
                                     ps = conn.prepareStatement(sql) ;
                                     ps.setLong(1, this.list.get(ii).getNew_stock_depart());
                                     ps.setFloat(2, this.list.get(ii).getP_m_d());
                                     ps.setString(3, this.list.get(ii).getMagasin_depart().replaceAll("'", "''"));
                                     ps.setString(4, this.list.get(ii).getDescription().replaceAll("'", "''"));
                                     
                                    ps.executeUpdate() ;
                                             
                                     
                                         //  JOptionPane.showMessageDialog(this, "ENTRE A ET B with arriv == 0 avant arriv == 0") ;
                                        
                                          sql = "select stock_dispo from stock_pl where magasin = ? and description = ?" ;
                                         ps = conn.prepareStatement(sql) ;
                                          ps.setString(1, this.list.get(ii).getMagasin_depart().replaceAll("'", "''"));
                                           ps.setString(2, this.list.get(ii).getDescription().replaceAll("'", "''"));
                                           
                                           rs = ps.executeQuery() ;
                                     
                                           while(rs.next()){
                                               newst = rs.getLong("stock_dispo") ;
                                           }
                                           
                                           if(newst == this.list.get(ii).getAns()){
                                               Integer a = 0 ;
                                               this.vy_print.add(a) ;
                                           }else{
                                               Integer b = 1 ;
                                               this.vy_print.add(b) ;
                                           }
                                         
                                        
                                         
                                         if(av == 0){
                                             
                                             
                                             
                                             if(stmt.executeUpdate("insert into stock_pl(magasin,description,stock_dispo,prx_pm,dtec,admin , p_m_d) values( '"
                                             +this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getNew_stock_arriver()+" , "
                                             +this.list.get(ii).getNew_prx_arriver()+" , '"+this.list.get(ii).getDate1()+"' , '"
                                             +this.list.get(ii).getAdmin().replaceAll("'", "''")+"' , "+this.list.get(ii).getP_m_d()+" )") == 1){
                                         
                                         // detail stock placement     :
                                         
                                         
                                          if(/*stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" )*/ 1 == 1 ){
                 
                                              
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                          
                                     }
                                             
                                             
                   
                                             
                                     }else if(av == 1){
                                         
                                         
               if(this.list.get(ii).getMagasin_arriver().equalsIgnoreCase("CHAMBRE FROIDE")){
                   
          //    JOptionPane.showMessageDialog(null, "PM : "+this.list.get(ii).getNew_prx_arriver());
              
              stmt.executeUpdate("update pmp set pv = "+this.list.get(ii).getNew_prx_arriver()
           +" where article = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
              
             stmt.executeUpdate("update stock1 set pa = "+this.list.get(ii).getNew_prx_arriver()+" "
           +", pv = "+this.list.get(ii).getNew_prx_arriver()+" where desi = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ; 
              
               
          }
                       
               
     sql = "update stock_pl set stock_dispo = ? , prx_pm = ? , p_m_d = ? where magasin = ? and description = ? " ;
                                     
                                     ps = conn.prepareStatement(sql) ;
                                     
                                     ps.setLong(1, this.list.get(ii).getNew_stock_arriver());
                                     ps.setFloat(2, this.list.get(ii).getNew_prx_arriver());
                                     ps.setFloat(3, this.list.get(ii).getP_m_d());
                                     ps.setString(4, this.list.get(ii).getMagasin_arriver().replaceAll("'", "''"));
                                     ps.setString(5, this.list.get(ii).getDescription().replaceAll("'", "''"));
                                     
                                 Integer rowAf_1 =  ps.executeUpdate() ;
               
               
                                        /*
           Integer rowAf_1 = stmt.executeUpdate("update stock_pl set stock_dispo = "+this.list.get(ii).getNew_stock_arriver()+" , prx_pm = "
                                             +this.list.get(ii).getNew_prx_arriver()+" , p_m_d = "+this.list.get(ii).getP_m_d()+" where magasin = '"+this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")+"' and description = '"
                                             +this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
               
                                     */
                                     
                                     
                if(rowAf_1 == 1){
                    
                    
                    
                                         
                                         
                                              // detail stock placement     :
                                         
                                         
                                          if(/*stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" )*/ 1 == 1 ){
                                              
           sql = "update stock_pl set stock_dispo = ? , prx_pm = ? , p_m_d = ? where magasin = ? and description = ? " ;
                                     
                                     ps = conn.prepareStatement(sql) ;
                                     
                                     ps.setLong(1, this.list.get(ii).getNew_stock_arriver());
                                     ps.setFloat(2, this.list.get(ii).getNew_prx_arriver());
                                     ps.setFloat(3, this.list.get(ii).getP_m_d());
                                     ps.setString(4, this.list.get(ii).getMagasin_arriver().replaceAll("'", "''"));
                                     ps.setString(5, this.list.get(ii).getDescription().replaceAll("'", "''"));
                                     
                                          ps.executeUpdate() ;
               
                 
                                              
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 sql = "select stock_dispo from stock_pl where magasin = ? and description = ?" ;
                                     ps = conn.prepareStatement(sql) ;
                                     ps.setString(1, this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")) ;
                                     ps.setString(2, this.list.get(ii).getDescription().replaceAll("'", "''")) ;
                                     
                                     rs = ps.executeQuery() ;
                                     
                                           while(rs.next()){
                                               newst = rs.getLong("stock_dispo") ;
                                           }
                                           
                                           if(newst == this.list.get(ii).getAv()){
                                               Integer a = 0 ;
                                               this.vy_print.add(a) ;
                                           }else{
                                               Integer b = 1 ;
                                               this.vy_print.add(b) ;
                                           }
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                         
                                         
                                     }
                                     
                                     
                                         
                                         
                                     }
                                         
                                 
                                         
                                         
                                     }
                                     
                                     
                                     
                                     }
                                 
                                  
                                  
                                     }
                              
        //   ----------------------------------------------- fin motif standard mouvement dun point A vers un point B : ---------------------------------------------------                     
              
                                       
                              
                              
             
             // fin operation  :
             
             
                  
              }
              
              
              if(this.vy_print.contains(Integer.parseInt("0"))){
                  conn.rollback();
                  JOptionPane.showMessageDialog(null, "REPRENDRE OPERATION") ;
              }else{
              
              conn.commit() ;
              
              
              // Impression du bon JAVA :
              
            //  JOptionPane.showMessageDialog(this, "BON JAVA AS JASPERT REPORTING IREPORT :::: " ) ;
              
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Bon_pl_v2.jrxml")) ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.bonList) ;
            
            Map<String, Object> para = new HashMap<>();
            para.put("data", jrbean);
            para.put("op", "OP : "+this.login) ;  // this.login
            para.put("cb", this.cb) ;
            para.put("num", "N° : "+String.valueOf(num)) ;
            para.put("dep", "DEPART : "+this.list.get(0).getDepart());
            para.put("arriv", "ARRIVER : "+this.list.get(0).getArriver());
            para.put("perso", "COMMIS. : "+this.list.get(0).getPerso()) ;
            para.put("motif", "MOTIF : "+this.list.get(0).getMotif());
            para.put("tmtt", "TOTAL MTT : "+nf3.format(tmtt)) ;
            para.put("comt", "COMMENTAIRE : "+this.comt.getText().trim()) ;
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
       
       //  JasperViewer.viewReport(print, false) ;
            
        JasperPrintManager.printReport(print, false) ;
            
              
           //   
              
              
              
              this.jTable1.getSelectionModel().clearSelection() ;
           // this.jTable1.getSelectionModel().clearSelection() ;
              this.list.removeAll(this.list) ;
              this.list_vy.removeAll(this.list_vy) ;
             
              DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                                dtm.setRowCount(0) ;
                                 
                                this.qte.setText("") ;
                                this.cb = 0 ;
                                this.d.setEnabled(true) ;
                                this.d.setSelectedItem(new String("DEPART"));
                                this.d1 = "" ;
                                this.a.setEnabled(true) ;
                                this.a.setSelectedItem(new String("ARRIVER"));
                                this.a1 = "" ;
                                this.c.setEnabled(true) ;
                                this.c.setSelectedItem(new String("COMMISSIONNAIRE"));
                                this.m.setEnabled(true) ;
                                this.m.setSelectedItem(new String("MOTIF"));
                                this.comt.setEditable(true) ;
                                this.comt.setText("") ;
                                this.jLabel5.setText("0") ;
                                this.total = 0 ;
                                this.jDateChooser1.setDate(null) ;
                                
                                this.jButton3.setEnabled(false) ;
                                this.transac = 0 ;
              
              }
              
          }
          
       // cette partie ne nous interesse pas !!! debut :
          
      }
      
      // fin partie unitile :
      
      
          
      //STEP 6: Clean-up environment
 
      
      stmt.close();
      conn.close();
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
    
       this.transac = 1 ;
       conn.rollback() ;
       
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
        
        
        
        
         
         
         }catch(Exception e){
             
            this.transac = 0 ;
            this.vy_print.removeAll(this.vy_print) ;
        
        // saveing ....
        
        
               Connection conn = null ;
               Statement  stmt = null  ;
               PreparedStatement ps = null ;
               
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...") ;
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;
      conn.setAutoCommit(false) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
      int vy ;
          vy = 0 ;
      
      String sql ;
             sql = "select * from op_pl_f where cb = "+this.cb ;
             ResultSet rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                vy = 1 ;
             }
             
              long id = 0 ;
             sql = "select id from op_pl_f order by id desc limit 1" ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                 id = rs.getLong("id") ;
             }
             
             long num = 0 ;
                  num = (id + 1) ;
      
       
      
      if(vy == 0){
          
          int i = 0 ;
          
          if(stmt.executeUpdate("insert into op_pl_f(cb,date1,date2,depart,arriver,perso,motif,etat,admin,comt) VALUES("
                  +this.cb+" , '"+this.list.get(i).getDate1()+"' , '"+this.list.get(i).getDate1()+"' , '"+this.list.get(i).getDepart().replaceAll("'", "''")+"' , '"
          +this.list.get(i).getArriver().replaceAll("'", "''")+"' , '"+this.list.get(i).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(i).getMotif().replaceAll("'", "''")+"' , '"
          +this.etat+"' , '"+this.login.replaceAll("'", "''")+"' , '"+this.comt.getText().trim().replaceAll("'", "''")+"' )") == 1){
              
                        long tmtt = 0 ;
                        
              for(int ii = 0 ; this.list.size() > ii ; ii++){
                  
                  HashMap<String, Object> m = new HashMap<>();
                   
                    
                   m.put("description", this.list.get(ii).getDescription()) ;
                   m.put("qte", nf3.format(this.list.get(ii).getQte())) ;
                   m.put("pu", nf3.format(this.list.get(ii).getPu())) ;
                   m.put("mtt", this.list.get(ii).getMtt()) ;
                              tmtt += this.list.get(ii).getMtt() ;
                              
                              this.bonList.add(m) ;
                              
                  
                              
                                // update stock_pl or create stock placement with detail operation :
                              
                                    /*
                              
                                   DECOUPAGE
                                   ENTREE
                                   SORTIE
                                   AVARIER
                                   PERTE
                              
                                   */
                              
  // ---------------------------------------------- debut motif entree : -----------------------------------------------------
                              
                              if(this.list.get(ii).getMotif().equalsIgnoreCase("ARRIVAGE")){
                                  
                                 int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                 
                                 if(vy0 == 0){
                                     
                                     if(stmt.executeUpdate("insert into stock_pl(magasin,description,stock_dispo,prx_pm,dtec,admin) values( '"
                                             +this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getNew_stock_arriver()+" , "
                                             +this.list.get(ii).getNew_prx_arriver()+" , '"+this.list.get(ii).getDate1()+"' , '"
                                             +this.list.get(ii).getAdmin().replaceAll("'", "''")+"')") == 1){
                                         
                                         // detail stock placement     :
                                         
                                         
                                          if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" ) == 1 ){
                 
                                              
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                          
                                     }     
                                     
                                 }else if(vy0 == 1){
                                     
                                     
                                     Integer rowAf = stmt.executeUpdate("update stock_pl set stock_dispo = "+this.list.get(ii).getNew_stock_arriver()+" , prx_pm = "
                                             +this.list.get(ii).getNew_prx_arriver()+" where magasin = '"+this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")+"' and description = '"
                                             +this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
                                     
                                     if(rowAf == 1){
                                         
                                         
                                              // detail stock placement     :
                                         
                                         
                                          if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" ) == 1 ){
                 
                                              
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                         
                                         
                                     }
                                     
                                     
                                     
                                 }
                                 
                                  
                                  
                              }
                              
                  
            // ---------------------------------------------- fin motif entree : -----------------------------------------------------
                              
                              
          // ------------------------------------------------ debut motif sortie : ---------------------------------------------------
                              
                              if(this.list.get(ii).getMotif().equalsIgnoreCase("VENTE")){
                                  
                                 
                                  
                                 int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                 
                                 if(vy0 == 0){
                                     
                                     /*
                                     if(stmt.executeUpdate("insert into stock_pl(magasin,description,stock_dispo,prx_pm,dtec,admin) values( '"
                                             +this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getNew_stock_arriver()+" , "
                                             +this.list.get(ii).getNew_prx_arriver()+" , '"+this.list.get(ii).getDate1()+"' , '"
                                             +this.list.get(ii).getAdmin().replaceAll("'", "''")+"')") == 1){
                                         
                                         // detail stock placement     :
                                         
                                         
                                          if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                                              
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                          
                                     }   
                                     
                                     */
                                     
                                     JOptionPane.showMessageDialog(this, "PAS DE STOCK ") ;
                                     
                                     
                                 }else if(vy0 == 1){
                                     
                                     Integer rowAf = stmt.executeUpdate("update stock_pl set stock_dispo = "+this.list.get(ii).getNew_stock_depart()+" where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"
                                             +this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
                                     
                                     if(rowAf == 1){
                                         
                                         
                                              // detail stock placement     :
                                         
                                         
                                          if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" ) == 1 ){
                 
                                              
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                         
                                         
                                     }
                                     
                                     
                                     
                                 }
                                 
                                  
                                  
                              }
                              
        //   ----------------------------------------------- fin motif sortie : ---------------------------------------------------                     
             
     //  ------------------------------------- debut motif PERTE : ---------------------------------------------------
                              
                              if(this.list.get(ii).getMotif().equalsIgnoreCase("PERTE")){
                                  
                             
                                  
                                 int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                 
                                 if(vy0 == 0){
                                     
                                    
                                     JOptionPane.showMessageDialog(this, "PAS DE STOCK ") ;
                                     
                                     
                                 }else if(vy0 == 1){
                                     
                                     Integer rowAf = stmt.executeUpdate("update stock_pl set stock_dispo = "+this.list.get(ii).getNew_stock_depart()+" where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"
                                             +this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
                                     
                                     
                                     if(rowAf == 1){
                                         
                                         
                                              // detail stock placement     :
                                         
                                         
                                          if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" ) == 1 ){
                 
                                              
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                         
                                         
                                     }
                                     
                                     
                                     
                                 }
                                 
                                  
                                  
                              }
                              
        //   ----------------------------------------------- fin motif PERTE : ---------------------------------------------------                     
        
                              
       //  ------------------------------------- debut motif AVARIER : ---------------------------------------------------
                              
                              if(this.list.get(ii).getMotif().equalsIgnoreCase("AVARIER")){
                                  
                                 
                                  
                                 int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                 
                                 if(vy0 == 0){
                                     
                                    
                                     JOptionPane.showMessageDialog(this, "PAS DE STOCK ") ;
                                     
                                     
                                 }else if(vy0 == 1){
                                     
                                     Integer rowAf = stmt.executeUpdate("update stock_pl set stock_dispo = "+this.list.get(ii).getNew_stock_depart()+" where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"
                                             +this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
                                     
                                     if(rowAf == 1){
                                         
                                         
                                              // detail stock placement     :
                                         
                                         
                                          if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" ) == 1 ){
                 
                                              
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                         
                                         
                                     }
                                     
                                     
                                     
                                 }
                                 
                                  
                                  
                              }
                              
        //   ----------------------------------------------- fin motif AVARIER : ---------------------------------------------------                     
              
         //  ------------------------------------- debut motif DECOUPAGE : ---------------------------------------------------
                              
                              if(this.list.get(ii).getMotif().equalsIgnoreCase("DECOUPAGE")){
                                  
                                
                                  
                                  
                                 int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                 
                                 if(vy0 == 0){
                                     
                                    
                                     JOptionPane.showMessageDialog(this, "PAS DE STOCK ") ;
                                     
                                     
                                 }else if(vy0 == 1){
                                     
                                     long newst = 0 ;
                                     sql = "update stock_pl set stock_dispo = ? where magasin = ? and description = ?" ;
                                           
                                     ps = conn.prepareStatement(sql) ;
                                     ps.setLong(1 , this.list.get(ii).getNew_stock_depart()) ;
                                     ps.setString(2 , this.list.get(ii).getMagasin_depart().replaceAll("'", "''")) ;
                                     ps.setString(3 , this.list.get(ii).getDescription().replaceAll("'", "''")) ;
                                     
                                     Integer rowAf = ps.executeUpdate() ;
                                     
                                     
                                     /*
                                     
                                     Integer rowAf = stmt.executeUpdate("update stock_pl set stock_dispo = "+this.list.get(ii).getNew_stock_depart()+" where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"
                                             +this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
                                     
                                     */
                                     
                                     
                                     if(rowAf == 1){
                                         
                                         
                                              // detail stock placement     :
                                         
                                         
                                          if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" ) == 1 ){
                 
                        sql = "update stock_pl set stock_dispo = ? where magasin = ? and description = ?" ;
                                           
                                     ps = conn.prepareStatement(sql) ;
                                     ps.setLong(1 , this.list.get(ii).getNew_stock_depart()) ;
                                     ps.setString(2 , this.list.get(ii).getMagasin_depart().replaceAll("'", "''")) ;
                                     ps.setString(3 , this.list.get(ii).getDescription().replaceAll("'", "''")) ;
                                     
                                            ps.executeUpdate() ;
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 sql = "select stock_dispo from stock_pl where magasin = ? and description = ?" ;
                 ps = conn.prepareStatement(sql) ;
                 
                 ps.setString(1 , this.list.get(ii).getMagasin_depart().replaceAll("'", "''")) ;
                 ps.setString(2 , this.list.get(ii).getDescription().replaceAll("'", "''")) ;
                                     
                 rs = ps.executeQuery() ;
                 while(rs.next()){
                     newst = rs.getLong("stock_dispo") ;
                 }
                 
                 if(newst == this.list.get(ii).getAns()){
                     Integer a = 0 ;
                     this.vy_print.add(a) ;
                 }else{
                     Integer b = 1 ;
                     this.vy_print.add(b) ;
                 }
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                         
                                         
                                     }
                                     
                                     
                                     
                                 }
                                 
                                  
                                  
                              }
                              
        //   ----------------------------------------------- fin motif DECOUPAGE : ---------------------------------------------------                     
              
                                       
      //  ------------------------------------- debut motif standard mouvement d'un point A vers un point B : ---------------------------------------------------
                              
                               
                              if(this.list.get(ii).getMotif().equalsIgnoreCase("DECOUPAGE") == false && this.list.get(ii).getMotif().equalsIgnoreCase("ARRIVAGE") == false && this.list.get(ii).getMotif().equalsIgnoreCase("VENTE") == false && this.list.get(ii).getMotif().equalsIgnoreCase("AVARIER") == false && this.list.get(ii).getMotif().equalsIgnoreCase("PERTE") == false ){
                                  
                                  
                                  
                                 int vy0 = 0 ;
                                 
                                 sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                 rs  = stmt.executeQuery(sql) ;
                                 while(rs.next()){
                                         vy0 = 1 ;                   
                                 }
                                 
                                   int arriv = 0 ;
                                         sql = "select * from stock_pl where magasin = '"+this.list.get(ii).getMagasin_arriver().replaceAll("'" , "''")+"' and description = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' " ;
                                         rs = stmt.executeQuery(sql) ;
                                         while(rs.next()){
                                             arriv = 1 ;
                                         }
                                 
                                 
                                 
                                 if(vy0 == 0){
                                     
                                    
                                     JOptionPane.showMessageDialog(this, "PAS DE STOCK ") ;
                                     
                                     
                                 }else if(vy0 == 1){
                                      
           sql = "update stock_pl set stock_dispo = ? , p_m_d = ? where magasin = ? and description = ?" ;
                                     ps = conn.prepareStatement(sql) ;
                                     ps.setLong(1 , this.list.get(ii).getNew_stock_depart()) ;
                                     ps.setFloat(2 , this.list.get(ii).getP_m_d()) ;
                                     ps.setString(3 , this.list.get(ii).getMagasin_depart().replaceAll("'", "''")) ;
                                     ps.setString(4 , this.list.get(ii).getDescription().replaceAll("'", "''")) ;
                                     
                                     Integer rowAf = ps.executeUpdate() ;
                                     
                                     stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" ) ;
                                     
       
                                     
                                            /*                                     
                                     
                                     Integer rowAf = stmt.executeUpdate("update stock_pl set stock_dispo = "+this.list.get(ii).getNew_stock_depart()+" , p_m_d = "+this.list.get(ii).getP_m_d()+" where magasin = '"+this.list.get(ii).getMagasin_depart().replaceAll("'", "''")+"' and description = '"
                                             +this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
                                     
                                     */ 
                                     
                                     if(rowAf == 1){
                                         
                                       
                                         
                                         if(arriv == 0){
                                             
                                             if(stmt.executeUpdate("insert into stock_pl(magasin,description,stock_dispo,prx_pm,dtec,admin , p_m_d) values( '"
                                             +this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getNew_stock_arriver()+" , "
                                             +this.list.get(ii).getNew_prx_arriver()+" , '"+this.list.get(ii).getDate1()+"' , '"
                                             +this.list.get(ii).getAdmin().replaceAll("'", "''")+"' , "+this.list.get(ii).getP_m_d()+")") == 1){
                                         
                                         // detail stock placement     :
                                         
                                         
                                          if(/*stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" )*/ 1 == 1 ){
                 
                                              long newst = 0 ;
                                                                 
           sql = "update stock_pl set stock_dispo = ? , p_m_d = ? where magasin = ? and description = ?" ;
                                     ps = conn.prepareStatement(sql) ;
                                     ps.setLong(1 , this.list.get(ii).getNew_stock_depart()) ;
                                     ps.setFloat(2 , this.list.get(ii).getP_m_d()) ;
                                     ps.setString(3 , this.list.get(ii).getMagasin_depart().replaceAll("'", "''")) ;
                                     ps.setString(4 , this.list.get(ii).getDescription().replaceAll("'", "''")) ;
                                     
                                     ps.executeUpdate() ;
                                     
                                     sql = "select * from stock_pl where magasin = ? and description = ?" ;
                                     ps = conn.prepareStatement(sql) ;
                                     ps.setString(1 , this.list.get(ii).getMagasin_depart().replaceAll("'", "''")) ;
                                     ps.setString(2 , this.list.get(ii).getDescription().replaceAll("'", "''")) ;
                                     
                                     rs = ps.executeQuery() ;
                                     while(rs.next()){
                                         newst = rs.getLong("stock_dispo") ;
                                     }
                                     
                                     if(newst == this.list.get(ii).getAns()){
                                         Integer a = 0 ;
                                         this.vy_print.add(a) ;
                                         
                                     }else{
                                         Integer b = 1 ;
                                         this.vy_print.add(b) ;
                                         
                                     }
                                     
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                          
                                     }
                                             
                                             
                                     }else if(arriv == 1){
                                         
                                         
        if(this.list.get(ii).getMagasin_arriver().equalsIgnoreCase("CHAMBRE FROIDE")){
                   
          //    JOptionPane.showMessageDialog(null, "PM : "+this.list.get(ii).getNew_prx_arriver());
              
              stmt.executeUpdate("update pmp set pv = "+this.list.get(ii).getNew_prx_arriver()
           +" where article = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
              
             stmt.executeUpdate("update stock1 set pa = "+this.list.get(ii).getNew_prx_arriver()+" "
           +", pv = "+this.list.get(ii).getNew_prx_arriver()+" where desi = '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ; 
              
               
          }
                                           
                                           
           sql = "update stock_pl set stock_dispo = ? , prx_pm = ? , p_m_d = ? where magasin = ? and description = ?" ;
              
              ps = conn.prepareStatement(sql) ;
              
              ps.setLong(1, this.list.get(ii).getNew_stock_arriver()) ;
              ps.setFloat(2 , this.list.get(ii).getNew_prx_arriver()) ;
              ps.setFloat(3 , this.list.get(ii).getP_m_d()) ;
              ps.setString(4, this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")) ;
              ps.setString(5, this.list.get(ii).getDescription().replaceAll("'", "''")) ;
       
               Integer rowAf_1 = ps.executeUpdate() ;
               
               
              
                     /*
            
           Integer rowAf_1 = stmt.executeUpdate("update stock_pl set stock_dispo = "+this.list.get(ii).getNew_stock_arriver()+" , prx_pm = "
                                             +this.list.get(ii).getNew_prx_arriver()+" , p_m_d = "+this.list.get(ii).getP_m_d()+"  where magasin = '"+this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")+"' and description = '"
                                             +this.list.get(ii).getDescription().replaceAll("'", "''")+"'") ;
           
                                                  */
                                                          
                                                          
                                                          
                                         
        if(rowAf_1 == 1){
                                         
                                         
                                              // detail stock placement     :
                                         
                                         
if(/*stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,ans_2) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , "+this.list.get(ii).getNderiver()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , '"
          + this.login.replaceAll("'", "''")+"' , "+this.list.get(ii).getAns()+" , "+this.list.get(ii).getAv()+")" )*/ 1 == 1 ){
                 
  sql = "update stock_pl set stock_dispo = ? , prx_pm = ? , p_m_d = ? where magasin = ? and description = ?" ;
              
              ps = conn.prepareStatement(sql) ;
              
              ps.setLong(1, this.list.get(ii).getNew_stock_arriver()) ;
              ps.setFloat(2 , this.list.get(ii).getNew_prx_arriver()) ;
              ps.setFloat(3 , this.list.get(ii).getP_m_d()) ;
              ps.setString(4, this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")) ;
              ps.setString(5, this.list.get(ii).getDescription().replaceAll("'", "''")) ;
       
                ps.executeUpdate() ;
                
                
                long newst = 0 ;
                
                sql = "select * from stock_pl where magasin = ? and description = ?" ;
                                     ps = conn.prepareStatement(sql) ;
                                     ps.setString(1, this.list.get(ii).getMagasin_arriver().replaceAll("'", "''")) ;
                                     ps.setString(2, this.list.get(ii).getDescription().replaceAll("'", "''")) ;
                                     
                                     rs = ps.executeQuery() ;
                                     while(rs.next()){
                                         newst = rs.getLong("stock_dispo") ;
                                     }
                                     
                                     if(newst == this.list.get(ii).getAv()){
                                         Integer a = 0 ;
                                         this.vy_print.add(a) ;
                                         
                                     }else{
                                         Integer b = 1 ;
                                         this.vy_print.add(b) ;
                                         
                                     }
                                         
                                         // fin detail stock placement :
                                              
                                         // debut detail_pl :
                                              
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
                                     }
                                         
                                         
                                     }
                                     
                                     
                                         
                                         
                                     }
                                         
                                 
                                         
                                         
                                     }
                                     
                                     
                                     
                                     }
                                 
                                  
                                  
                                     }
                              
        //   ----------------------------------------------- fin motif standard mouvement dun point A vers un point B : ---------------------------------------------------                     
              
                                       
                              
                              
             
             // fin operation  :
             
             
                              
                              
                  
              }
              
              
              if(this.vy_print.contains(Integer.parseInt("0"))){
                  conn.rollback() ;
                  JOptionPane.showMessageDialog(null, "REPRENDRE OPERATION") ;
              }else{
              
              
              conn.commit() ;
              
              
              
              // Impression du bon JAVA :
              
             // JOptionPane.showMessageDialog(this, "BON JAVA AS JASPERT REPORTING IREPORT :::: " ) ;
              
             InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Bon_pl_v2.jrxml")) ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.bonList) ;
            
            Map<String, Object> para = new HashMap<>();
            para.put("data", jrbean);
            para.put("op", "OP : "+this.login) ;  // this.login
            para.put("cb", this.cb) ;
            para.put("num", "N° : "+String.valueOf(num)) ;
            para.put("dep", "DEPART : "+this.list.get(0).getDepart());
            para.put("arriv", "ARRIVER : "+this.list.get(0).getArriver());
            para.put("perso", "COMMIS. : "+this.list.get(0).getPerso()) ;
            para.put("motif", "MOTIF : "+this.list.get(0).getMotif());
            
            para.put("tmtt", "TOTAL MTT : "+nf3.format(tmtt)) ;
            para.put("comt", "COMMENTAIRE : "+this.comt.getText().trim()) ;
             
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
           
        //   JasperViewer.viewReport(print, false) ;
            
            
          JasperPrintManager.printReport(print, false) ;            
              
              
              //
              
              
              this.jTable1.getSelectionModel().clearSelection() ;
           // this.jTable1.getSelectionModel().clearSelection() ;
              this.list.removeAll(this.list) ;
              this.list_vy.removeAll(this.list_vy) ;
              DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                                dtm.setRowCount(0) ;
                                this.qte.setText("") ;
                                this.cb = 0 ;
                                this.d.setEnabled(true) ;
                                this.d.setSelectedItem(new String("DEPART"));
                                this.a.setEnabled(true) ;
                                this.a.setSelectedItem(new String("ARRIVER"));
                                this.c.setEnabled(true) ;
                                this.c.setSelectedItem(new String("COMMISSIONNAIRE"));
                                this.m.setEnabled(true) ;
                                this.m.setSelectedItem(new String("MOTIF"));
                                this.jLabel5.setText("0") ;
                                this.total = 0 ;
                                this.jDateChooser1.setDate(null) ;
                                
                                this.comt.setEditable(true) ;
                                this.comt.setText("") ;
                                
                                this.jButton3.setEnabled(false) ;
                                this.transac = 0 ;
                                
              
          }
          
          }
          
       // cette partie ne nous interesse pas !!! debut :
          
      }
      
      // fin partie unitile :
      
      
          
      //STEP 6: Clean-up environment
 
      
      stmt.close();
      conn.close();
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
       
       this.transac = 1 ;
       
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    
                    Logger.getLogger(Op_Pl.class.getName()).log(Level.SEVERE, null, ex);
                }
      
      se.printStackTrace();
      
   }catch(Exception e1){
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
        
            this.close.setEnabled(true) ;
        
        this.jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
         Op_Pl mc = new Op_Pl(this.login, this.role) ;
                  mc.setVisible(true) ;
                  
                  this.setVisible(false) ;
                  
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void pereMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pereMouseReleased
        // TODO add your handling code here:
        
        
        if(this.pere.isSelected()){
            this.derive.setSelected(false) ;
            this.p_d.setSelected(false) ;
            
          
        
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
        
        
    }//GEN-LAST:event_pereMouseReleased

    private void deriveMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deriveMouseReleased
        // TODO add your handling code here:
        
        
         if(this.derive.isSelected()){
            this.pere.setSelected(false) ;
            this.p_d.setSelected(false) ;
            
          
        
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
        
        
        
    }//GEN-LAST:event_deriveMouseReleased

    private void p_dMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_dMouseReleased
        // TODO add your handling code here:
        
        
          if(this.p_d.isSelected()){
            this.derive.setSelected(false) ;
            this.pere.setSelected(false) ;
            
          
        
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
        
        
        
        
    }//GEN-LAST:event_p_dMouseReleased

    private void p_dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_dActionPerformed

    private void dMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_dMouseReleased

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false) ;
        
    }//GEN-LAST:event_closeActionPerformed

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
            java.util.logging.Logger.getLogger(Op_Pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Op_Pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Op_Pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Op_Pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Op_Pl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox a;
    private javax.swing.JComboBox c;
    private javax.swing.JButton close;
    private javax.swing.JTextField comt;
    private javax.swing.JComboBox d;
    private javax.swing.JCheckBox derive;
    private javax.swing.JTextField desc2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox m;
    private javax.swing.JCheckBox p_d;
    private javax.swing.JCheckBox pere;
    private javax.swing.JTextField prx;
    private javax.swing.JTextField qte;
    private javax.swing.JTextField stock;
    // End of variables declaration//GEN-END:variables
}
