/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import entity.Bon;
import entity.ProduitsF;
import static frontend.ActiviteTransformation.JDBC_DRIVER;
import static frontend.MatierePri.JDBC_DRIVER;
import static frontend.ProductionMp.JDBC_DRIVER;
import static frontend.StockFinal.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HAMZA
 */
public class ProductionTOrdi extends javax.swing.JFrame {

    /**
     * Creates new form ProductionT
     */
    
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      // ArrayModifier
      List eltModifier1 = new ArrayList() ;
      int nBon = 0;
      long tBon = 0;
      
      String user_c ;
      String role ;
      String dc ;
      String rp1 = "" ;
      String rp2 = "" ;
      String article1 = "" ;
      double pv1 = 0 ;
      long pa1 = 0 ;
      String article2 = "" ;
      double pv2 = 0 ;
      long pa2 = 0 ;
      
      
      // update stock :
      
      long stockDispo = 0 ;
      long stockDispo1 = 0 ;
      
      
      // Gestion de la production :
      
      String nom = "" ;
      String st = "" ;
      int n = 0 ;
      
      
        // status valeur : "ouverte"
      // -----------------------------------------------
      
      String arti1 = "" ;
      long q1 = 0 ;
      
      
      String arti2 = "" ;
      long q2 = 0 ;
      
    //  stock annuler
      
      long sot1 = 0 ;
      long sot2 = 0 ;
      
      
      // NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
      
    String groupe = "" ;
    
    
    // data for cumul matiere primaire :
    
        String f1 = "" ;
        String sf1 = "" ;
        long idpro1 = 0 ;
        long pac1 = 0 ;
        long profil1 = 0 ;
        long mu1 = 0 ;
    
    
    
    // end :
    
    
    // cumul data for produit obtenu suite a des productions :
    
        String f2 = "" ;
        String sf2 = "" ;
        long idpro2 = 0 ;
        long pac2 = 0 ;
        long profil2 = 0 ;
        long mu2 = 0 ;
        long prxv2 = 0 ;
    
    
    // end :
        
        static final String et = "NORMAL" ;
      
      
        public ProductionTOrdi() {
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
        //
        
        
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
        
     //   -------------------------------------------------------------------
        
        
        // ---------------- 1è choix --------------
            this.jTable5.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable5.getTableHeader().setOpaque(false); 
            this.jTable5.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable5.getTableHeader().setForeground(Color.white) ;
        
              this.jTable5.setRowHeight(25) ;
              
        
          
                  for (int i = 0; i < this.jTable5.getModel().getColumnCount(); i++) {
                    this.jTable5.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
                  
                  
                  // ---------------- 1è choix --------------
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
        
        // ---------------- 1è choix --------------
            this.jTable4.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable4.getTableHeader().setOpaque(false); 
            this.jTable4.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable4.getTableHeader().setForeground(Color.white) ;
        
            this.jTable4.setRowHeight(25) ;
              
        
            

                  for (int i = 0; i < this.jTable4.getModel().getColumnCount(); i++) {
                    this.jTable4.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
        
        
         
     
        
        DateFormat datef = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss") ;
        Date date = new Date() ;
        this.dc = datef.format(date) ;
      //  System.out.println(this.dc) ;
        
        
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
      
       sql= "SELECT * FROM activite_t ORDER BY description" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
      this.pro.addItem(rs.getString("description")) ;  
     
     }
      
     
       String sql2 ;
      
       sql2 = "SELECT * FROM magasins ORDER BY magasin" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
          this.mag.addItem(rs2.getString("magasin"))  ;
         
       
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
        
        if("ORDINAIRE".equalsIgnoreCase(this.role)){
             this.BtnPrint.setEnabled(false) ;
             this.td.setVisible(false) ;
             this.dep.setVisible(false) ;
             this.tr.setVisible(false) ;
             this.rec.setVisible(false) ;
             this.jPro.setVisible(false) ;
             this.prof.setVisible(false) ;
            
            
        }
        
        
    }      
      
      
 
    
    // pt.setRole(this.role) ;
    
         public ProductionTOrdi(String role) {
        initComponents();
        this.role = role ;
        
        
        
        this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
        //
        
          
        
        // date
        
           
             
           
        
        // date
        
        
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
        
     //   -------------------------------------------------------------------
        
        
        // ---------------- 1è choix --------------
            this.jTable5.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable5.getTableHeader().setOpaque(false); 
            this.jTable5.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable5.getTableHeader().setForeground(Color.white) ;
        
              this.jTable5.setRowHeight(25) ;
              
        
          
                  for (int i = 0; i < this.jTable5.getModel().getColumnCount(); i++) {
                    this.jTable5.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
                  
                  
                  // ---------------- 1è choix --------------
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
        
        // ---------------- 1è choix --------------
            this.jTable4.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable4.getTableHeader().setOpaque(false); 
            this.jTable4.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable4.getTableHeader().setForeground(Color.white) ;
        
            this.jTable4.setRowHeight(25) ;
              
        
            

                  for (int i = 0; i < this.jTable4.getModel().getColumnCount(); i++) {
                    this.jTable4.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
        
          
        DateFormat datef = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
        Date date = new Date() ;
        this.dc = datef.format(date) ;
      //  System.out.println(this.dc) ;
        
        
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
      
       sql= "SELECT * FROM activite_t ORDER BY description" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
      this.pro.addItem(rs.getString("description")) ;  
     
     }
      
     
       String sql2 ;
      
       sql2 = "SELECT * FROM magasins ORDER BY magasin" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
          this.mag.addItem(rs2.getString("magasin"))  ;
         
       
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
     //  System.out.print("this.role = "+this.role);
        
        if("ORDINAIRE".equalsIgnoreCase(this.role)){
             this.BtnPrint.setEnabled(false) ;
             this.td.setVisible(false) ;
             this.dep.setVisible(false) ;
             this.tr.setVisible(false) ;
             this.rec.setVisible(false) ;
             this.jPro.setVisible(false) ;
             this.prof.setVisible(false) ;
            
            
        }
        
        
    }
    
    
    // end 
    
    

    public void setUser_c(String user_c) {
        this.user_c = user_c;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
    
    
    
     private void clear5() {

        DefaultTableModel model = (DefaultTableModel) this.jTable5.getModel();
        int n = model.getRowCount() ;
        for (int i = n - 1; i >= 0; --i) {
            model.removeRow(i);
        }
        
        
        
    }
     
     
     
     private void clear1() {

        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        int n = model.getRowCount() ;
        for (int i = n - 1; i >= 0; --i) {
            model.removeRow(i);
        }
        
        
        
    }
     
     
     private void clear2() {

        DefaultTableModel model = (DefaultTableModel) this.jTable2.getModel() ;
        int n = model.getRowCount() ;
        for (int i = n - 1; i >= 0; --i) {
            model.removeRow(i);
        }
        
        
        
    }
     
     
     
     private void clear4() {

        DefaultTableModel model = (DefaultTableModel) this.jTable4.getModel();
        int n = model.getRowCount() ;
        for (int i = n - 1; i >= 0; --i) {
            model.removeRow(i);
        }
        
        
        
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pro = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        desc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        td = new javax.swing.JLabel();
        dep = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        tr = new javax.swing.JLabel();
        rec = new javax.swing.JTextField();
        jPro = new javax.swing.JLabel();
        prof = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        npro = new javax.swing.JLabel();
        nupro = new javax.swing.JLabel();
        stf = new javax.swing.JLabel();
        stat = new javax.swing.JLabel();
        qte1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ad1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        qte2 = new javax.swing.JTextField();
        ad2 = new javax.swing.JButton();
        mag = new javax.swing.JComboBox();
        an1 = new javax.swing.JButton();
        an2 = new javax.swing.JButton();
        BtnPrint = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        an3 = new javax.swing.JButton();
        an4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setText("FERMER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PRODUCTION DES ARTICLES DE L'ENTREPRISE :");

        pro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR ACTIVITE" }));
        pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PRODUCTION :");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descKeyPressed(evt);
            }
        });

        jLabel11.setText("DESCRIPTION :");

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPTION", "P.A", "P.V"
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(3);
        }

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("LES MATIERES PREMIERES");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText(" PRODUIT FINI :");

        jTable5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPTION", "P.A", "P.V"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable5.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable5.getTableHeader().setReorderingAllowed(false);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jTable5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable5KeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable5.getColumnModel().getColumn(1).setPreferredWidth(3);
            jTable5.getColumnModel().getColumn(2).setPreferredWidth(3);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPTION", "QTE", "P.U", "MONTANT"
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable2KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(160);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(3);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(3);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(3);
        }

        td.setText("TOTAL DEPENSE : ");

        dep.setEditable(false);
        dep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dep.setText("0");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("LES MATIERES PREMIERES");

        jTable4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPTION", "QTE", "P.U", "MONTANT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable4.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable4.getTableHeader().setReorderingAllowed(false);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jTable4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable4KeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setPreferredWidth(160);
            jTable4.getColumnModel().getColumn(1).setPreferredWidth(3);
            jTable4.getColumnModel().getColumn(2).setPreferredWidth(3);
            jTable4.getColumnModel().getColumn(3).setPreferredWidth(3);
        }

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("LES PRODUITS OBTENUS");

        tr.setText("TOTAL RECETTE :");

        rec.setEditable(false);
        rec.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rec.setText("0");

        jPro.setText("LE PROFIL :");

        prof.setEditable(false);
        prof.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prof.setText("0");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setText("BON MAGASINIER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(td, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(tr, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rec, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPro, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prof))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(td)
                            .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tr)
                    .addComponent(rec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPro)
                    .addComponent(prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        npro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        npro.setForeground(new java.awt.Color(255, 255, 255));
        npro.setText("LA PRODUCTION");

        nupro.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        nupro.setForeground(new java.awt.Color(255, 255, 255));
        nupro.setText("N° ........");

        stf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stf.setForeground(new java.awt.Color(255, 255, 255));

        stat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stat.setForeground(new java.awt.Color(255, 255, 255));
        stat.setText(" ");

        qte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qte1ActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("QUANTITE");

        ad1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ad1.setText("Nouv.Ope..");
        ad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("QTE OBTENUE");

        ad2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ad2.setText("Nouv.Ope..");
        ad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad2ActionPerformed(evt);
            }
        });

        mag.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Magasin" }));

        an1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        an1.setText("ANNULER");
        an1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                an1ActionPerformed(evt);
            }
        });

        an2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        an2.setText("ANNULER");
        an2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                an2ActionPerformed(evt);
            }
        });

        BtnPrint.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        BtnPrint.setText("IMPRIMER");
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("SYNCHRONISER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        an3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        an3.setText("VALIDER");
        an3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                an3ActionPerformed(evt);
            }
        });

        an4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        an4.setText("VALIDER");
        an4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                an4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(pro, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(258, 258, 258)
                                .addComponent(BtnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(npro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mag, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(stf, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(stat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(qte1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(qte2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(ad2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(an2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(an4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addComponent(nupro, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(ad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(an1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(an3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(549, 549, 549))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(npro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nupro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(stf, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stat))
                                .addGap(33, 33, 33)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qte1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ad1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(an1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(an3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(mag, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qte2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ad2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(an2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(an4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 11, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1289, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false) ;
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
           public boolean isCellEditable(int row, int column){
               return false ;
           }
    
    
    private void proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proActionPerformed
        // TODO add your handling code here:
        
        
        this.nom = "" ;
        this.st = "" ;
        this.n = 0 ;
        
        this.groupe = "" ;
        
        String pro1 = this.pro.getSelectedItem().toString().replaceAll("'", "''") ;
        this.nom = pro1 ;
        
        
        if("CHOISIR ACTIVITE".equalsIgnoreCase(pro1)){
            
         
            clear5() ;
            clear1() ;
            clear2() ;
            clear4() ;
          
          
          
          
            
            JOptionPane.showMessageDialog(this , "CHOISIR UNE PRODUCTION SVP") ;
            
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
      
    
        
      
            clear5() ;
            clear1() ;
            // clear2() ;
            // clear4() ;
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel() ;
         
      
         DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel() ;
         
         
         String sql1 ;
      
         sql1 = "SELECT * FROM pmp WHERE nomp = '"+pro1+"' ORDER BY article" ;
      
         ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
        while(rs1.next()){
         
        dtm.addRow(new Object[]{
     
     // "DESCRIPTION", "P.A", "P.V" 

            
       rs1.getString("article")  ,
       rs1.getLong("pa") , rs1.getLong("pv") 
        
        }) ;
  
       
     }
      
    String sql ;
      
         sql = "SELECT * FROM ppf WHERE nomp = '"+pro1+"' ORDER BY article" ;
      
         ResultSet rs = stmt.executeQuery(sql) ;
      
      
        while(rs.next()){        
        
        dtm1.addRow(new Object[]{
     
     //  "DESCRIPTION", "P.A", "P.V"  

            
       rs.getString("article")  ,
       rs.getLong("pa") , rs.getLong("pu") 
        
        }) ;
  
       
     }
        
        
        //
        
             String sql4 ;
      
         sql4 = "SELECT libelle FROM activite_t WHERE description = '"+this.nom+"'" ;
               
         ResultSet rs4 = stmt.executeQuery(sql4) ;
      
      
        while(rs4.next()){        
        
       this.groupe = rs4.getString("libelle") ;
       
     }
        
        //
        
        
         String sql3 ;
      
         sql3 = "SELECT count(*) FROM prod WHERE nom = '"+this.nom+"'" ;
               
         ResultSet rs3 = stmt.executeQuery(sql3) ;
      
      
        while(rs3.next()){        
        
       this.n = (rs3.getInt(1) + 1) ;
       
     }
        
        this.st = "ouverte" ;
        this.npro.setText(this.nom) ;
        this.nupro.setText("N° "+String.valueOf(this.n)) ;
        this.stf.setText("STATUT :") ;
        this.stat.setText(this.st) ;
        
        
          this.qte1.setEditable(true) ;
          this.ad1.setEnabled(true) ;
          this.an1.setEnabled(true) ;
          this.mag.setEnabled(true) ;
          this.qte2.setEditable(true) ;
          this.ad2.setEnabled(true) ;
          this.an2.setEnabled(true) ;
        
          
        /*
          jTable2.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
                                
             } ,
          new String [] {
            "DESCRIPTION", "QTE", "P.U", "MONTANT"
             })
               ) ;
      */
          clear2() ;
      
        /*
          jTable4.setModel(new javax.swing.table.DefaultTableModel(
              new Object [][] {
                                
                   } ,
               new String [] {
                 "DESCRIPTION", "QTE", "P.U", "MONTANT"
               })
                  ) ;
            
               */
          clear4() ;
    
            
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
        
        
        
    }//GEN-LAST:event_proActionPerformed

    private void descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyPressed
        // TODO add your handling code here:
        
        
          String n1 = this.desc.getText().replaceAll("'", "''") ;
          String n2 = this.pro.getSelectedItem().toString().replaceAll("'", "''") ;
        
        
        if("".equalsIgnoreCase(n1)){
        
          //  JOptionPane jp=new JOptionPane() ;
         //  jp.showMessageDialog(null,"selectionner une activité T svp","Avertissement",JOptionPane.WARNING_MESSAGE);
  
        
        }else{
        
        
        
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
      
      
      
     clear5() ;
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel() ;
         
       String sql ;
      
         sql = "SELECT * FROM pmp WHERE nomp ='"+n2+"' AND article LIKE '%"+n1+"%' ORDER BY article" ;
      
         ResultSet rs = stmt.executeQuery(sql) ;
      
      
        while(rs.next()){
         
        dtm.addRow(new Object[]{
     
     // "DESCRIPTION", "P.A", "P.V" 

            
       rs.getString("article")  ,
       rs.getLong("pa") , rs.getLong("pv") 
        
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
        
        
        
        
        
        
    }//GEN-LAST:event_descKeyPressed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
        
         this.rp1 = "" ;
     
         this.article1 = "" ;
         this.pv1 = 0 ;
         this.pa1 = 0 ;
         this.stockDispo = 0 ;
       
       this.article1 = jTable5.getValueAt(this.jTable5.getSelectedRow(), 0).toString() ;
       this.pv1 = Double.parseDouble(jTable5.getValueAt(this.jTable5.getSelectedRow(), 2).toString()) ;
       this.pa1 = Long.parseLong(jTable5.getValueAt(this.jTable5.getSelectedRow(), 1).toString()) ;
       
       
      
        this.f1 = "" ;
        this.sf1 = "" ;
        this.idpro1 = 0 ;
        this.pac1 = 0 ;
        
        
        
        this.mu1 = 0 ;
        
        this.mu1 = Math.round(this.pv1 - this.pa1) ;
        this.pac1 = this.pa1 ;
       
       
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
      
       sql= "SELECT unite_mesure FROM matieres_p WHERE description = '"+this.article1.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
      while(rs.next()){
        
    
       this.rp1 = rs.getString("unite_mesure") ;
       
       
     }
      
       String sql1 ;
      
       sql1 = "SELECT * FROM stock1 WHERE desi = '"+this.article1.replaceAll("'", "''")+"'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
      while(rs1.next()){
        
        this.stockDispo = rs1.getLong("stock") ;  
       
     }
      
      
      
      String sql2 ;
      
       sql2 = "SELECT * FROM matieres_p WHERE description = '"+this.article1.replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
      while(rs2.next()){
        
        this.idpro1 = rs2.getLong("id") ;
        this.f1 = rs2.getString("condition_livraison") ;
        this.sf1 = rs2.getString("conservation") ;
        
         
     }
      
      String sql3 ;
      
       sql3 = "SELECT * FROM produits_f WHERE description = '"+this.article1.replaceAll("'", "''")+"'" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3) ;
      
      
      while(rs3.next()){
        
        this.idpro1 = rs3.getInt("id") ;
        this.f1 = rs3.getString("f") ;
        this.sf1 = rs3.getString("sf") ;
        
         
     }
     
       System.out.println(this.stockDispo) ;
     
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs.close();
      rs1.close();
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
        
        
      
       
     // this.jTable5.setCellEditable(nBon, nBon) ;
        
        
    }//GEN-LAST:event_jTable5MouseClicked

    private void ad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad1ActionPerformed
        // TODO add your handling code here:
        
        // cut
        this.profil1 = 0 ;
        //
        
        DefaultTableModel dtm50 = (DefaultTableModel) jTable5.getModel() ;
        int ligne ;
        
        String prod1 = "";
        String np = "";
        
        if(this.jTable5.getSelectedRow() == -1){
             JOptionPane.showMessageDialog(this, "Selectionner dans le tableau une production svp") ;
        }else{
        
      
        
        prod1 = this.pro.getSelectedItem().toString() ;
        np = this.npro.getText().trim() ;
        
        if("CHOISIR ACTIVITE".equalsIgnoreCase(prod1) || "LA PRODUCTION".equalsIgnoreCase(np)){
            
            JOptionPane.showMessageDialog(this, "Choisir une production svp") ;
            
        }else{
            
            String qt01 = this.qte1.getText().trim() ;
            
            if("".equalsIgnoreCase(qt01)){
                
                  JOptionPane.showMessageDialog(this, "Choisir une Quantite de la matiere primaire svp") ;
            
            }else{
                try{
                long qt02 = Long.parseLong(qt01) ;
                long mtt = 0 ;
                
                if(this.stockDispo >= qt02){
                    
                    if("oui".equalsIgnoreCase(this.rp1)){
                        double qt03 = (qt02 / 1000.0) ;
                        double t1 = (this.pv1 * qt03) ;
                        double t2 = (this.mu1 * qt03) ;
                        
                       
                        mtt = Math.round(t1) ;
                        this.profil1 = Math.round(t2) ;
                       
                        long newStock = (this.stockDispo - qt02) ;
                       
                          SessionFactory sf=new Configuration().configure().buildSessionFactory();
                          Session s=sf.openSession();

              List lib = s.createSQLQuery("SELECT * FROM prod WHERE nom ='"+this.nom+"' AND n ="+this.n).list();
              List lib1 = s.createSQLQuery("SELECT * FROM prodmp WHERE nom ='"+this.nom+"' AND n ="+this.n+" AND article ='"+this.article1.replaceAll("'", "''")+"'").list();
            
               // verification if qery is ok
            
            if(lib.size() == 1){
                
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
      
             
              if(lib1.size() == 1){
                
                  JOptionPane.showMessageDialog(this, "Cette matiere primaire existe dejà annuler la et réajouter la pour corriger des erreurs svp");
                
                
            }else{
             
             if(stmt.executeUpdate("INSERT INTO prodmp(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article1.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv1+" , "+mtt+" , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"' , '"+this.f1.replaceAll("'", "''")+"' , '"+this.sf1.replaceAll("'", "''")+"' , "+this.idpro1+" , "+this.pa1+" , "+this.profil1+" , "+this.mu1+")") == 1){
 
                 
                   ligne = this.jTable5.getSelectedRow();  
                   dtm50.removeRow(ligne);
                 
                 long mt = 0 ;
                 
                 /*
                 jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                                
             } ,
          new String [] {
           "DESCRIPTION", "QTE", "P.U", "MONTANT"
             })
               ) ;
                 */
                 
                 clear2() ;
            
                 
                 DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                 
if(stmt.executeUpdate("UPDATE stock1 SET qtest ="+qt02+" , stock ="+newStock+" WHERE desi ='"+this.article1.replaceAll("'", "''")+"'") > 0){
           if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article1.replaceAll("'", "''")+"' , "+this.pa1+" , "+this.pv1+" , "+0+" , "+qt02+" , "+newStock+" , '' , '' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){      
                 
                  String sql ;
      
                  sql = "SELECT * FROM prodmp WHERE nom='"+this.nom+"' AND n = "+this.n +" ORDER BY article" ;
      
                  ResultSet rs = stmt.executeQuery(sql) ;
      
      
                 while(rs.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm.addRow(new Object[]{
                     
                         rs.getString("article") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("montant") 
                     
                     });
         
                     mt += rs.getLong("montant") ;
        
                     }
                 
                 this.dep.setText(String.valueOf(mt)) ;
                 
                 this.qte1.setText("");
                 
                 rs.close() ;
                 
                 
           }
                             
        }
                 
                 
             }
             
              }
              
         
      
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
                
                // acces au server :
                
                
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
      
         this.nBon = 1 ;
          
         if(stmt.executeUpdate("INSERT INTO prod(nom,n,status,dtec,admin,dep,rec,profil,nb,grouper,etat) VALUES('"+this.nom+"' , "+this.n+" , '"+this.st+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"' , 0 , 0 , 0 , "+this.nBon+" , '"+this.groupe.replaceAll("'", "''")+"' , '"+this.et+"' )") == 1){
             
              if(lib1.size() == 1){
                
                  JOptionPane.showMessageDialog(this, "Cette matiere primaire existe dejà annuler la et réajouter la pour corriger des erreurs svp");
                
                
            }else{
             
             if(stmt.executeUpdate("INSERT INTO prodmp(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article1.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv1+" , "+mtt+" , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"' , '"+this.f1.replaceAll("'", "''")+"' , '"+this.sf1.replaceAll("'", "''")+"' , "+this.idpro1+" , "+this.pa1+" , "+this.profil1+" , "+this.mu1+")") == 1){
                   ligne = this.jTable5.getSelectedRow();  
                   dtm50.removeRow(ligne);
                 long mt = 0 ;
                 
                 /*
                 jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                                
             } ,
          new String [] {
           "DESCRIPTION", "QTE", "P.U", "MONTANT"
             })
               ) ;
                 */
                 
                 clear2() ;
                 
                 DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                 
if(stmt.executeUpdate("UPDATE stock1 SET qtest ="+qt02+" , stock ="+newStock+" WHERE desi ='"+this.article1.replaceAll("'", "''")+"'") > 0){
           if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article1.replaceAll("'", "''")+"' , "+this.pa1+" , "+this.pv1+" , "+0+" , "+qt02+" , "+newStock+" , '' , '' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){      
                 
                  String sql ;
      
                  sql = "SELECT * FROM prodmp WHERE nom='"+this.nom+"' AND n = "+this.n +" ORDER BY article";
      
                  ResultSet rs = stmt.executeQuery(sql) ;
      
      
                 while(rs.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm.addRow(new Object[]{
                     
                         rs.getString("article") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("montant") 
                     
                     });
         
                     mt += rs.getLong("montant") ;
        
                     }
                 
                 this.dep.setText(String.valueOf(mt)) ;
                 this.qte1.setText("");
                 
                 rs.close() ;
                 
                 
           }
                             
        }
                 
                 
             }
             
              }
              
         }
      
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
                      
                        
                    }else{
                        
                        double qt03 = qt02 ;
                        double mt01 = this.pv1 * qt03 ;
                        mtt = Math.round(mt01) ;
                        
                        double t4 = (this.mu1 * qt03) ;
                        
                        this.profil1 = Math.round(t4) ;
                        
                       // this.dep.setText(String.valueOf(mtt)) ;
                        
                        long newStock = (this.stockDispo - qt02) ;
                        
                        
                        // verification si la production existe :
                        // si oui on fait rien sur la production et on crai article 
                        // si non on la crea et on cree tjr larticle
                        
                          SessionFactory sf=new Configuration().configure().buildSessionFactory();
                          Session s=sf.openSession();

              List lib = s.createSQLQuery("SELECT * FROM prod WHERE nom ='"+this.nom+"' AND n ="+this.n).list();
              List lib1 = s.createSQLQuery("SELECT * FROM prodmp WHERE nom ='"+this.nom+"' AND n ="+this.n+" AND article ='"+this.article1.replaceAll("'", "''")+"'").list();
            
               // verification if qery is ok
            
            if(lib.size() == 1){
                
   
                          // acces au server :
                
                
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
      
             
              if(lib1.size() == 1){
                
                  JOptionPane.showMessageDialog(this, "Cette matiere primaire existe dejà annuler la et réajouter la pour corriger des erreurs svp");
                
                
            }else{
             
             if(stmt.executeUpdate("INSERT INTO prodmp(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article1.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv1+" , "+mtt+" , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"' , '"+this.f1.replaceAll("'", "''")+"' , '"+this.sf1.replaceAll("'", "''")+"' , "+this.idpro1+" , "+this.pa1+" , "+this.profil1+" , "+this.mu1+")") == 1){
                   ligne = this.jTable5.getSelectedRow();  
                   dtm50.removeRow(ligne);
                 long mt = 0 ;
                 
                 
                 /*
                 jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                                
             } ,
          new String [] {
           "DESCRIPTION", "QTE", "P.U", "MONTANT"
             })
               ) ;
                 */
                 
                 clear2() ;
                 
   DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                 
if(stmt.executeUpdate("UPDATE stock1 SET qtest ="+qt02+" , stock ="+newStock+" WHERE desi ='"+this.article1.replaceAll("'", "''")+"'") > 0){
           if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article1.replaceAll("'", "''")+"' , "+this.pa1+" , "+this.pv1+" , "+0+" , "+qt02+" , "+newStock+" , '' , '' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){      
                 
                  String sql ;
      
                  sql = "SELECT * FROM prodmp WHERE nom='"+this.nom+"' AND n = "+this.n+" ORDER BY article";
      
                  ResultSet rs = stmt.executeQuery(sql) ;
      
      
                 while(rs.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm.addRow(new Object[]{
                     
                         rs.getString("article") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("montant") 
                     
                     });
         
                     mt += rs.getLong("montant") ;
        
                     }
                 
                 this.dep.setText(String.valueOf(mt)) ;
                  this.qte1.setText("");
                 
                 rs.close() ;
                 
                 
           }
                             
        }
                 
                 
             }
             
              }
              
         
      
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
                
                // acces au server :
                
                
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
      
          this.nBon = 1 ;
         if(stmt.executeUpdate("INSERT INTO prod(nom,n,status,dtec,admin,dep,rec,profil,nb,grouper,etat) VALUES('"+this.nom+"' , "+this.n+" , '"+this.st+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"' , 0 , 0 , 0, "+this.nBon+" , '"+this.groupe.replaceAll("'", "''")+"' , '"+this.et+"' )") == 1){
             
              if(lib1.size() == 1){
                
                  JOptionPane.showMessageDialog(this, "Cette matiere primaire existe dejà annuler la et réajouter la pour corriger des erreurs svp");
                
                
            }else{
             
             if(stmt.executeUpdate("INSERT INTO prodmp(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article1.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv1+" , "+mtt+" , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"' , '"+this.f1.replaceAll("'", "''")+"' , '"+this.sf1.replaceAll("'", "''")+"' , "+this.idpro1+" , "+this.pa1+" , "+this.profil1+" , "+this.mu1+")") == 1){
                   ligne = this.jTable5.getSelectedRow();  
                   dtm50.removeRow(ligne);
                 long mt = 0 ;
                 
                 /*
                 jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                                
             } ,
          new String [] {
           "DESCRIPTION", "QTE", "P.U", "MONTANT"
             })
               ) ;
                 */
                 
                 clear2() ;
                 
                 DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                 
if(stmt.executeUpdate("UPDATE stock1 SET qtest ="+qt02+" , stock ="+newStock+" WHERE desi ='"+this.article1.replaceAll("'", "''")+"'") > 0){
           if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article1.replaceAll("'", "''")+"' , "+this.pa1+" , "+this.pv1+" , "+0+" , "+qt02+" , "+newStock+" , '' , '' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){      
                 
                  String sql ;
      
                  sql = "SELECT * FROM prodmp WHERE nom='"+this.nom+"' AND n = "+this.n +" ORDER BY article";
      
                  ResultSet rs = stmt.executeQuery(sql) ;
      
      
                 while(rs.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm.addRow(new Object[]{
                     
                         rs.getString("article") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("montant") 
                     
                     });
         
                     mt += rs.getLong("montant") ;
        
                     }
                 
                 this.dep.setText(String.valueOf(mt)) ;
                  this.qte1.setText("");
                 
                 rs.close() ;
                 
                 
           }
                             
        }
                 
                 
             }
             
              }
              
         }
      
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
            
                        
                        
                        
                        
                        
                        
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(this, "le stock est insuffisant et reste :"+this.stockDispo) ;
                }
                
                
            }catch(Exception e){
              JOptionPane.showMessageDialog(this, "Choisir une Quantite en nombre entier uniquement") ;
                    }
            }
            
            
        }
        
        }
        
    }//GEN-LAST:event_ad1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        
        this.arti1 = "" ;
        this.q1 = 0 ;
        this.sot1 = 0 ;
        this.rp2 = "" ;
        this.pv2 = 0;
        
        this.arti1 = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString() ;
        this.q1 = Long.parseLong(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString()) ;
        this.pv2 = Double.parseDouble(jTable2.getValueAt(this.jTable2.getSelectedRow(), 2).toString()) ;
        
          
         Connection conn = null ;
         Statement stmt = null  ; 
       
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
      
       sql= "SELECT * FROM stock1 WHERE desi = '"+this.arti1.replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        this.sot1 = rs.getLong("stock") ;  
       
     }
     
    
       
     String sql1 ;
      
       sql1 = "SELECT unite_mesure FROM matieres_p WHERE description = '"+this.arti1.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
      while(rs1.next()){
        
    
       this.rp2 = rs1.getString("unite_mesure") ;
       
       
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
        
        
        
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void an1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_an1ActionPerformed
        // TODO add your handling code here:
        
        
        if(this.jTable2.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(this, "Pour annuler une operation selectionner dans le tableau à droite svp") ;
            
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
      
          long newStock = (this.sot1 + this.q1) ;
         if(stmt.executeUpdate("DELETE FROM prodmp WHERE nom = '"+this.nom+"' AND n = "+this.n+" AND article = '"+this.arti1.replaceAll("'", "''")+"'" ) == 1){
             
              
             if(stmt.executeUpdate("UPDATE stock1 SET stock ="+newStock+" WHERE desi ='"+this.arti1.replaceAll("'", "''")+"'") > 0){
                 
                 long mt = 0 ;
                 
                 /*
                 
                 
                 jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                                
             } ,
          new String [] {
           "DESCRIPTION", "QTE", "P.U", "MONTANT"
             })
               ) ;
                 
                 */
                 
                 clear2() ;
                 
                 DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                 
                  String sql ;
      
                  sql = "SELECT * FROM prodmp WHERE nom='"+this.nom+"' AND n = "+this.n ;
      
                  ResultSet rs = stmt.executeQuery(sql) ;
      
      
                 while(rs.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm.addRow(new Object[]{
                     
                         rs.getString("article") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("montant") 
                     
                     });
         
                     mt += rs.getLong("montant") ;
        
                     }
                 
                 
                 
                 // 
                 
                 
               DefaultTableModel dtm50 = (DefaultTableModel) jTable5.getModel() ;   
                 
         String sql1 ;
      
         sql1= "SELECT * FROM pmp WHERE nomp = '"+this.pro.getSelectedItem().toString().replaceAll("'", "''")+"' AND article = '"+this.arti1.replaceAll("'", "''")+"' " ;
      
         ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
        while(rs1.next()){
         
        dtm50.addRow(new Object[]{
     
     // "DESCRIPTION", "P.A", "P.V" 

            
       rs1.getString("article")  ,
       rs1.getLong("pa") , rs1.getLong("pv") 
        
        }) ;
  
       
     }
                 //
                 
                 
                 
                 this.dep.setText(String.valueOf(mt)) ;
                  this.qte1.setText("");
                 
                 rs.close() ;
                 
                
             }
             
              
     }
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
        
    }//GEN-LAST:event_an1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        
         this.rp2 = "" ;
     
         this.article2 = "" ;
         this.pv2 = 0 ;
         this.pa2 = 0 ;
         this.stockDispo1 = 0 ;
       
       this.article2 = jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString() ;
       this.pv2 = Double.parseDouble(jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()) ;
       this.pa2 = Long.parseLong(jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()) ;
       
       
        this.f2 = "" ;
        this.sf2 = "" ;
        this.idpro2 = 0 ;
        this.pac2 = 0 ;
        this.prxv2 = 0 ;
        
        this.pac2 = Long.parseLong(jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString())  ;
        
        this.prxv2 = this.pac2 ;
        
        this.mu2 = 0 ;
        
        this.mu2 = Math.round(this.pac2 - this.pa2) ;
       
       
       
       
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
      
       sql= "SELECT unite_m FROM produits_f WHERE description = '"+this.article2.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
      while(rs.next()){
        
    
       this.rp2 = rs.getString("unite_m") ;
       
       
     }
      
       String sql1 ;
      
       sql1 = "SELECT * FROM stock1 WHERE desi = '"+this.article2.replaceAll("'", "''")+"'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
      while(rs1.next()){
        
        this.stockDispo1 = rs1.getLong("stock") ;  
       
     }
     
        String sql2 ;
      
       sql2 = "SELECT * FROM matieres_p WHERE description = '"+this.article2.replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
      while(rs2.next()){
        
        this.idpro2 = rs2.getLong("id") ;
        this.f2 = rs2.getString("condition_livraison") ;
        this.sf2 = rs2.getString("conservation") ;
        
         
     }
      
      String sql3 ;
      
       sql3 = "SELECT * FROM produits_f WHERE description = '"+this.article2.replaceAll("'", "''")+"'" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3) ;
      
      
      while(rs3.next()){
        
        this.idpro2 = rs3.getInt("id") ;
        this.f2 = rs3.getString("f") ;
        this.sf2 = rs3.getString("sf") ;
        
         
     }
     
       System.out.println(this.stockDispo1) ;
     
    
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs.close();
      rs1.close();
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
        
        
        
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void ad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad2ActionPerformed
        // TODO add your handling code here:
        
        // cut
        this.profil2 = 0 ;
        //
        
        // debut :
        DefaultTableModel dtm11 = (DefaultTableModel) jTable1.getModel() ;
        int ligne ;
        
        
           if(this.jTable1.getSelectedRow() == -1){
             JOptionPane.showMessageDialog(this, "Selectionner dans le tableau pour une production svp") ;
        }else{
        
        String prod1 = this.pro.getSelectedItem().toString() ;
        String np = this.npro.getText().trim() ;
        String mag1 = this.mag.getSelectedItem().toString().replaceAll("'", "''") ;
        
        
        
        if("CHOISIR ACTIVITE".equalsIgnoreCase(prod1) || "LA PRODUCTION".equalsIgnoreCase(np) || "Magasin".equalsIgnoreCase(mag1)){
            
            JOptionPane.showMessageDialog(this, "Choisir un magasin svp") ;
            
        }else{
            
            String qt01 = this.qte2.getText().trim() ;
            
            if("".equalsIgnoreCase(qt01)){
                
                  JOptionPane.showMessageDialog(this, "Choisir une Quantite des produits fini obtenue svp") ;
            
            }else{
                try{
                long qt02 = Long.parseLong(qt01) ;
                long mtt = 0 ;
                
               
                    
                    if("oui".equalsIgnoreCase(this.rp2)){
                        double qt03 = (qt02 / 1000.0) ;
                        double mt03 = (this.pv2 * qt03) ;
                        double t2 = (this.mu2 * qt03) ;
                        mtt = Math.round(mt03) ;
                        
                        this.profil2 = Math.round(t2) ;
                        
                       // this.dep.setText(String.valueOf(mtt)) ;
                        
                        long newStock = (this.stockDispo1 + qt02) ;
                        
                        
                        // verification si la production existe :
                        // si oui on fait rien sur la production et on crai article 
                        // si non on la crea et on cree tjr larticle
                        
                          SessionFactory sf=new Configuration().configure().buildSessionFactory();
                          Session s=sf.openSession();

              List lib = s.createSQLQuery("SELECT * FROM prod WHERE nom ='"+this.nom+"' AND n ="+this.n).list();
              List lib1 = s.createSQLQuery("SELECT * FROM prodpf WHERE nom ='"+this.nom+"' AND n ="+this.n+" AND article ='"+this.article2.replaceAll("'", "''")+"'").list();
              List entreprise = s.createSQLQuery("SELECT * FROM stock1 WHERE desi = '"+this.article2.replaceAll("'", "''")+"' ").list();
               // verification if qery is ok
            
            if(lib.size() == 1){
                
   
                          // acces au server :
                
                
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
      
             
              if(lib1.size() == 1){
                
                  JOptionPane.showMessageDialog(this, "Ce produit fini existe dejà annuler la et réajouter la pour corriger des erreurs svp");
                
                
            }else{
             
             if(stmt.executeUpdate("INSERT INTO prodpf(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu,prxv) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article2.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv2+" , "+mtt+" , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"' , '"+this.f2.replaceAll("'", "''")+"' , '"+this.sf2.replaceAll("'", "''")+"' , "+this.idpro2+" , "+this.pa2+" , "+this.profil2+" , "+this.mu2+" , "+this.prxv2+")") == 1){
                  ligne = this.jTable1.getSelectedRow();  
                  dtm11.removeRow(ligne);
                 long mt = 0 ;
                 
                 /*
                 jTable4.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                                
             } ,
          new String [] {
           "DESCRIPTION", "QTE", "P.U", "MONTANT"
             })
               ) ;
                 */
                 
                 clear4() ;
                 
                 DefaultTableModel dtm = (DefaultTableModel) this.jTable4.getModel() ;
            
                 
                 // debut :
                 
                 
                    if(entreprise.size() == 1){
                
         //  update my stock please :
              
         
      if(stmt.executeUpdate("UPDATE stock1 SET qteet ="+qt02+" , stock ="+newStock+" , four ='"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , maga ='"+mag1.replaceAll("'", "''")+"' , datec ='"+this.dc+"' , admin ='"+this.user_c.replaceAll("'", "''")+"' WHERE desi ='"+this.article2.replaceAll("'", "''")+"'") > 0){
          
          if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){
          
              
               
                 // tab :
                  String sql ;
      
                  sql = "SELECT * FROM prodpf WHERE nom='"+this.nom+"' AND n = "+this.n +" ORDER BY article";
      
                  ResultSet rs = stmt.executeQuery(sql) ;
      
      
                 while(rs.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm.addRow(new Object[]{
                     
                         rs.getString("article") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("montant") 
                     
                     });
         
                     mt += rs.getLong("montant") ;
        
                     }
                 
                 this.rec.setText(String.valueOf(mt)) ;
                 
                 this.prof.setText(String.valueOf(mt - Long.parseLong(this.dep.getText().trim()))) ;
                 
                 this.qte2.setText("");
                 
                 rs.close() ;
                 
                 // tab end :
          
              
              
          
             }
          
          
      }
      
    
            
           
                
                
            }else{
        //  create my stock please : 
                
                
       
         
         if(stmt.executeUpdate("INSERT INTO stock1(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){
           if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')" ) > 0){
          
         
               
                // tab :
                  String sql ;
      
                  sql = "SELECT * FROM prodpf WHERE nom='"+this.nom+"' AND n = "+this.n +" ORDER BY article" ;
      
                  ResultSet rs = stmt.executeQuery(sql) ;
      
      
                 while(rs.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm.addRow(new Object[]{
                     
                         rs.getString("article") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("montant") 
                     
                     });
         
                     mt += rs.getLong("montant") ;
        
                     }
                 
                 this.rec.setText(String.valueOf(mt)) ;
                 
                 this.prof.setText(String.valueOf(mt - Long.parseLong(this.dep.getText().trim()))) ;
                 
                 this.qte2.setText("");
                 
                 rs.close() ;
                 
                 // tab end :
          
               
               
          
           }
    
        
         }
    
              
         
                 
            }
                 
                 
                 // end stock :
                 
                 
                 
                
                 
                 
             }
             
              }
              
         
      
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
                
                // acces au server :
                
                
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
      
          
         if(stmt.executeUpdate("INSERT INTO prod(nom,n,status,dtec,admin,dep,rec,profil) VALUES('"+this.nom+"' , "+this.n+" , '"+this.st+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"' , 0 , 0 , 0)") == 1){
             
              if(lib1.size() == 1){
                
                  JOptionPane.showMessageDialog(this, "Le produit fini existe dejà annuler la et réajouter la pour corriger des erreurs svp");
                
                
            }else{
             
              if(stmt.executeUpdate("INSERT INTO prodpf(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu,prxv) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article2.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv2+" , "+mtt+" , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"' , '"+this.f2.replaceAll("'", "''")+"' , '"+this.sf2.replaceAll("'", "''")+"' , "+this.idpro2+" , "+this.pa2+" , "+this.profil2+" , "+this.mu2+" , "+this.prxv2+")") == 1){
                 ligne = this.jTable1.getSelectedRow();  
                 dtm11.removeRow(ligne);
                  long mt = 0 ;
                 
                  
                  /*
                  
                  
                 jTable4.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                                
             } ,
          new String [] {
           "DESCRIPTION", "QTE", "P.U", "MONTANT"
             })
               ) ;
                  
                  */
                  
                  clear4() ;
                 
      DefaultTableModel dtm = (DefaultTableModel) this.jTable4.getModel() ;
                 
                 
                 
         if(entreprise.size() == 1){
                
         //  update my stock please :
              
         
      if(stmt.executeUpdate("UPDATE stock1 SET qteet ="+qt02+" , stock ="+newStock+" , four ='"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , maga ='"+mag1.replaceAll("'", "''")+"' , datec ='"+this.dc+"' , admin ='"+this.user_c.replaceAll("'", "''")+"' WHERE desi ='"+this.article2.replaceAll("'", "''")+"'") > 0){
          
          if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){
          
              
               
                 // tab :
                  String sql ;
      
                  sql = "SELECT * FROM prodpf WHERE nom='"+this.nom+"' AND n = "+this.n+" ORDER BY article" ;
      
                  ResultSet rs = stmt.executeQuery(sql) ;
      
      
                 while(rs.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm.addRow(new Object[]{
                     
                         rs.getString("article") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("montant") 
                     
                     });
         
                     mt += rs.getLong("montant") ;
        
                     }
                 
                 this.rec.setText(String.valueOf(mt)) ;
                 
                 this.prof.setText(String.valueOf(mt - Long.parseLong(this.dep.getText().trim()))) ;
                 
                 this.qte2.setText("");
                 
                 rs.close() ;
                 
                 // tab end :
          
              
              
          
             }
          
          
      }
      
    
            
           
                
                
            }else{
        //  create my stock please : 
                
                
       
         
         if(stmt.executeUpdate("INSERT INTO stock1(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){
           if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')" ) > 0){
          
         
               
                // tab :
                  String sql ;
      
                  sql = "SELECT * FROM prodpf WHERE nom='"+this.nom+"' AND n = "+this.n +" ORDER BY article" ;
      
                  ResultSet rs = stmt.executeQuery(sql) ;
      
      
                 while(rs.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm.addRow(new Object[]{
                     
                         rs.getString("article") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("montant") 
                     
                     });
         
                     mt += rs.getLong("montant") ;
        
                     }
                 
                 this.rec.setText(String.valueOf(mt)) ;
                 
                 this.prof.setText(String.valueOf(mt - Long.parseLong(this.dep.getText().trim()))) ;
                 
                 this.qte2.setText("");
                 
                 rs.close() ;
                 
                 // tab end :
          
               
               
          
           }
    
        
         }
    
              
         
                 
            }
                 
                 
                 // end stock :
                 
                 
                 
                 
             }
             
              }
              
         }
      
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
                        
                        
                    }else{
                        
                        long qt03 = qt02 ;
                        double mtt01 = (this.pv2 * qt03) ;
                        double t4 = (this.mu2 * qt03) ;
                        mtt = Math.round(mtt01) ;
                        
                        this.profil2 = Math.round(t4) ;
                        
                       // this.dep.setText(String.valueOf(mtt)) ;
                        
                        long newStock = (this.stockDispo1 + qt02) ;
                        
                        
                        // verification si la production existe :
                        // si oui on fait rien sur la production et on crai article 
                        // si non on la crea et on cree tjr larticle
                        
                          SessionFactory sf=new Configuration().configure().buildSessionFactory();
                          Session s=sf.openSession();

              List lib = s.createSQLQuery("SELECT * FROM prod WHERE nom ='"+this.nom+"' AND n ="+this.n).list();
              List lib1 = s.createSQLQuery("SELECT * FROM prodpf WHERE nom ='"+this.nom+"' AND n ="+this.n+" AND article ='"+this.article2.replaceAll("'", "''")+"'").list();
              List entreprise = s.createSQLQuery("SELECT * FROM stock1 WHERE desi = '"+this.article2.replaceAll("'", "''")+"' ").list();
               // verification if qery is ok
            
            if(lib.size() == 1){
                
   
                          // acces au server :
                
                
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
      
             
              if(lib1.size() == 1){
                
                  JOptionPane.showMessageDialog(this, "Ce produit fini existe dejà annuler la et réajouter la pour corriger des erreurs svp");
                
                
            }else{
             
             if(stmt.executeUpdate("INSERT INTO prodpf(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu,prxv) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article2.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv2+" , "+mtt+" , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"' , '"+this.f2.replaceAll("'", "''")+"' , '"+this.sf2.replaceAll("'", "''")+"' , "+this.idpro2+" , "+this.pa2+" , "+this.profil2+" , "+this.mu2+" , "+this.prxv2+")") == 1){
                 ligne = this.jTable1.getSelectedRow();  
                 dtm11.removeRow(ligne);
                 long mt = 0 ;
                 
                 /*
                 jTable4.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                                
             } ,
          new String [] {
           "DESCRIPTION", "QTE", "P.U", "MONTANT"
             })
               ) ;
                 */
                 
                 clear4() ;
                 
                 DefaultTableModel dtm = (DefaultTableModel) this.jTable4.getModel() ;
            
                 
                 // debut :
                 
                 
                    if(entreprise.size() == 1){
                
         //  update my stock please :
              
         
      if(stmt.executeUpdate("UPDATE stock1 SET qteet ="+qt02+" , stock ="+newStock+" , four ='"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , maga ='"+mag1.replaceAll("'", "''")+"' , datec ='"+this.dc+"' , admin ='"+this.user_c.replaceAll("'", "''")+"' WHERE desi ='"+this.article2.replaceAll("'", "''")+"'") > 0){
          
          if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){
          
              
               
                 // tab :
                  String sql ;
      
                  sql = "SELECT * FROM prodpf WHERE nom='"+this.nom+"' AND n = "+this.n+" ORDER BY article" ;
      
                  ResultSet rs = stmt.executeQuery(sql) ;
      
      
                 while(rs.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm.addRow(new Object[]{
                     
                         rs.getString("article") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("montant") 
                     
                     });
         
                     mt += rs.getLong("montant") ;
        
                     }
                 
                 this.rec.setText(String.valueOf(mt)) ;
                 
                 this.prof.setText(String.valueOf(mt - Long.parseLong(this.dep.getText().trim()))) ;
                 
                 this.qte2.setText("");
                 
                 rs.close() ;
                 
                 // tab end :
          
              
              
          
             }
          
          
      }
      
    
            
           
                
                
            }else{
        //  create my stock please : 
                
                
       
         
         if(stmt.executeUpdate("INSERT INTO stock1(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){
           if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')" ) > 0){
          
         
               
                // tab :
                  String sql ;
      
                  sql = "SELECT * FROM prodpf WHERE nom='"+this.nom+"' AND n = "+this.n +" ORDER BY article" ;
      
                  ResultSet rs = stmt.executeQuery(sql) ;
      
      
                 while(rs.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm.addRow(new Object[]{
                     
                         rs.getString("article") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("montant") 
                     
                     });
         
                     mt += rs.getLong("montant") ;
        
                     }
                 
                 this.rec.setText(String.valueOf(mt)) ;
                 
                 this.prof.setText(String.valueOf(mt - Long.parseLong(this.dep.getText().trim()))) ;
                 
                 this.qte2.setText("");
                 
                 rs.close() ;
                 
                 // tab end :
          
               
               
          
           }
    
        
         }
    
              
         
                 
            }
                 
                 
                 // end stock :
                 
                 
                 
                
                 
                 
             }
             
              }
              
         
      
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
                
                // acces au server :
                
                
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
      
          
         if(stmt.executeUpdate("INSERT INTO prod(nom,n,status,dtec,admin,dep,rec,profil) VALUES('"+this.nom+"' , "+this.n+" , '"+this.st+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"' , 0 , 0 , 0)") == 1){
             
              if(lib1.size() == 1){
                
                  JOptionPane.showMessageDialog(this, "Le produit fini existe dejà annuler la et réajouter la pour corriger des erreurs svp");
                
                
            }else{
             
              if(stmt.executeUpdate("INSERT INTO prodpf(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu,prxv) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article2.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv2+" , "+mtt+" , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"' , '"+this.f2.replaceAll("'", "''")+"' , '"+this.sf2.replaceAll("'", "''")+"' , "+this.idpro2+" , "+this.pa2+" , "+this.profil2+" , "+this.mu2+" , "+this.prxv2+")") == 1){
                 ligne = this.jTable1.getSelectedRow();  
                 dtm11.removeRow(ligne);
                 long mt = 0 ;
                 
                 
                 /*
                 jTable4.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                                
             } ,
          new String [] {
           "DESCRIPTION", "QTE", "P.U", "MONTANT"
             })
               ) ;
                 */
                 
                 clear4() ;
                 
                 DefaultTableModel dtm = (DefaultTableModel) this.jTable4.getModel() ;
                 
                 
                 
         if(entreprise.size() == 1){
                
         //  update my stock please :
              
         
      if(stmt.executeUpdate("UPDATE stock1 SET qteet ="+qt02+" , stock ="+newStock+" , four ='"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , maga ='"+mag1.replaceAll("'", "''")+"' , datec ='"+this.dc+"' , admin ='"+this.user_c.replaceAll("'", "''")+"' WHERE desi ='"+this.article2.replaceAll("'", "''")+"'") > 0){
          
          if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){
          
              
               
                 // tab :
                  String sql ;
      
                  sql = "SELECT * FROM prodpf WHERE nom='"+this.nom+"' AND n = "+this.n +" ORDER BY article" ;
      
                  ResultSet rs = stmt.executeQuery(sql) ;
      
      
                 while(rs.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm.addRow(new Object[]{
                     
                         rs.getString("article") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("montant") 
                     
                     });
         
                     mt += rs.getLong("montant") ;
        
                     }
                 
                 this.rec.setText(String.valueOf(mt)) ;
                 
                 this.prof.setText(String.valueOf(mt - Long.parseLong(this.dep.getText().trim()))) ;
                 
                 this.qte2.setText("");
                 
                 rs.close() ;
                 
                 // tab end :
          
              
              
          
             }
          
          
      }
      
    
            
           
                
                
            }else{
        //  create my stock please : 
                
                
       
         
         if(stmt.executeUpdate("INSERT INTO stock1(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){
           if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')" ) > 0){
          
         
               
                // tab :
                  String sql ;
      
                  sql = "SELECT * FROM prodpf WHERE nom='"+this.nom+"' AND n = "+this.n+" ORDER BY article" ;
      
                  ResultSet rs = stmt.executeQuery(sql) ;
      
      
                 while(rs.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm.addRow(new Object[]{
                     
                         rs.getString("article") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("montant") 
                     
                     });
         
                     mt += rs.getLong("montant") ;
        
                     }
                 
                 this.rec.setText(String.valueOf(mt)) ;
                 
                 this.prof.setText(String.valueOf(mt - Long.parseLong(this.dep.getText().trim()))) ;
                 
                 this.qte2.setText("");
                 
                 rs.close() ;
                 
                 // tab end :
          
               
               
          
           }
    
        
         }
    
              
         
                 
            }
                 
                 
                 // end stock :
                 
                 
                 
                 
             }
             
              }
              
         }
      
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
             
                        
                        
                    }
                    
               
                
            }catch(Exception e){
              JOptionPane.showMessageDialog(this, "Choisir une Quantite en nombre entier uniquement") ;
                    }
            }
            
            
        }
        
        
        
        }
        
        
        
     //  fin :
        
        
    }//GEN-LAST:event_ad2ActionPerformed

    private void an2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_an2ActionPerformed
        // TODO add your handling code here:
        
        
          if(this.jTable4.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(this, "Pour annuler une operation selectionner dans le tableau à droite svp") ;
            
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
      
          long newStock = (this.sot2 - this.q2) ;
         if(stmt.executeUpdate("DELETE FROM prodpf WHERE nom = '"+this.nom+"' AND n = "+this.n+" AND article = '"+this.arti2.replaceAll("'", "''")+"'" ) == 1){
             
              
             if(stmt.executeUpdate("UPDATE stock1 SET stock ="+newStock+" WHERE desi ='"+this.arti2.replaceAll("'", "''")+"'") > 0){
                 
                 long mt = 0 ;
                 
                 /*
                 jTable4.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                                
             } ,
          new String [] {
           "DESCRIPTION", "QTE", "P.U", "MONTANT"
             })
               ) ;
                 */
                 
                 clear4() ;
                 
                 DefaultTableModel dtm = (DefaultTableModel) this.jTable4.getModel() ;
                 
                  String sql ;
      
                  sql = "SELECT * FROM prodpf WHERE nom='"+this.nom+"' AND n = "+this.n ;
      
                  ResultSet rs = stmt.executeQuery(sql) ;
      
      
                 while(rs.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm.addRow(new Object[]{
                     
                         rs.getString("article") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("montant") 
                     
                     });
         
                     mt += rs.getLong("montant") ;
        
                     }
                 
                 DefaultTableModel dtm11 = (DefaultTableModel) jTable1.getModel() ;   
                 
                String sql1 ;

                sql1= "SELECT * FROM ppf WHERE nomp = '"+this.pro.getSelectedItem().toString().replaceAll("'", "''")+"' AND article = '"+this.arti2.replaceAll("'", "''")+"' " ;

                ResultSet rs1 = stmt.executeQuery(sql1) ;


               while(rs1.next()){

               dtm11.addRow(new Object[]{

            // "DESCRIPTION", "P.A", "P.V" 


              rs1.getString("article")  ,
              rs1.getLong("pa") , rs1.getLong("pu") 

               }) ;


            }
                 
                 this.rec.setText(String.valueOf(mt)) ;
                 this.prof.setText(String.valueOf(mt - Long.parseLong(this.dep.getText().trim())));
                  this.qte2.setText("");
                 
                 rs.close() ;
                 
                
             }
             
              
              
         }
      
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
        
        
        
    }//GEN-LAST:event_an2ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        
         
        this.arti2 = "" ;
        this.q2 = 0 ;
        this.sot2 = 0 ;
        
        this.arti2 = this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 0).toString() ;
        this.q2 = Long.parseLong(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 1).toString()) ;
        
          
         Connection conn = null ;
         Statement stmt = null  ; 
       
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
      
       sql= "SELECT * FROM stock1 WHERE desi = '"+this.arti2.replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        this.sot2 = rs.getLong("stock") ;  
       
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
        
        
        
        
        
        
    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS); 
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY); 
            ResultSet resultat = statement.executeQuery("SELECT article as desi , qte as qte, "
                    + " pu as pu, montant as montant FROM prodmp WHERE nom = '"+this.nom+"' AND n = "+this.n+" ");
            
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\bonCommande.jrxml")) ;
            //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\bonCommande.jrxml")) ;
            
            long total = 0 ;
            
            List mlist;
            mlist = new ArrayList<>();
            while(resultat.next()) {
                HashMap<String, Object> m = new HashMap<>(); 
                m.put("desi", resultat.getString("desi"));
                m.put("qte", resultat.getInt("qte"));
                m.put("pu", resultat.getInt("pu"));
                m.put("montant", resultat.getInt("montant"));
                total += resultat.getInt("montant");
                m.put("total", total);
                mlist.add(m);
            }
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("sql", jrbean);
            para.put("nBon", this.nBon);
            para.put("nom", this.nom);
            para.put("n", this.n);
            para.put("login", this.user_c) ;
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
            JasperViewer.viewReport(print, false);
            
       }catch(Exception e){
       
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       
       }
       
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed

        try{
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY);

            Connection connection2 = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement statement2 = connection2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY);

            ResultSet resultat = statement.executeQuery("SELECT article as desi , qte as qte, "
                + " pu as pu, montant as montant FROM prodmp WHERE nom = '"+this.nom+"' AND n = "+this.n+" ");

            ResultSet resultat2 = statement2.executeQuery("SELECT article as desi2 , qte as qte2, "
                + " pu as pu2, montant as montant2 FROM prodpf WHERE nom = '"+this.nom+"' AND n = "+this.n+" ");

            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\prodOuverte.jrxml")) ;
            //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\prodOuverte.jrxml")) ;
            
            long total = 0 ;
            long total2 = 0;
            long profil = 0;

            List mlist;
            mlist = new ArrayList<>();
            while(resultat.next()) {
                HashMap<String, Object> m = new HashMap<>();
                m.put("desi", resultat.getString("desi"));
                m.put("qte", resultat.getInt("qte"));
                m.put("pu", resultat.getInt("pu"));
                m.put("montant", resultat.getInt("montant"));
                total += resultat.getInt("montant");
                m.put("total", total);
                mlist.add(m);
            }

            List mlist2;
            mlist2 = new ArrayList<>();
            while(resultat2.next()) {
                HashMap<String, Object> m = new HashMap<>();
                m.put("desi2", resultat2.getString("desi2"));
                m.put("qte2", resultat2.getInt("qte2"));
                m.put("pu2", resultat2.getInt("pu2"));
                m.put("montant2", resultat2.getInt("montant2"));
                total2 += resultat2.getInt("montant2");
                profil = total2 - total;
                m.put("total2", total2);
                m.put("profil", profil);
                mlist2.add(m);
            }

            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            JRBeanCollectionDataSource jrbean2 = new JRBeanCollectionDataSource(mlist2);

            Map<String, Object> para = new HashMap<>();
            para.put("sql", jrbean);
            para.put("data", jrbean2);
            para.put("nom", this.nom); 
            para.put("n", this.n);
            para.put("status", this.st);
            para.put("dtec", this.dc);
            para.put("admin", this.user_c);

            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
            JasperViewer.viewReport(print, false);

        }catch(Exception e){

            JOptionPane.showMessageDialog(null, e) ;
            System.out.println(e) ;

        }

    }//GEN-LAST:event_BtnPrintActionPerformed

    private void qte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qte1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qte1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        ProductionTOrdi pt = new ProductionTOrdi(this.role) ;
        
        pt.setUser_c(this.user_c) ;
        pt.setRole(this.role) ;
        
        pt.setVisible(true) ;
    
        this.setVisible(false) ;
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable5KeyTyped
        // TODO add your handling code here:
        this.rp1 = "" ;
     
         this.article1 = "" ;
         this.pv1 = 0 ;
         this.pa1 = 0 ;
         this.stockDispo = 0 ;
       
       this.article1 = jTable5.getValueAt(this.jTable5.getSelectedRow(), 0).toString() ;
       this.pv1 = Double.parseDouble(jTable5.getValueAt(this.jTable5.getSelectedRow(), 2).toString()) ;
       this.pa1 = Long.parseLong(jTable5.getValueAt(this.jTable5.getSelectedRow(), 1).toString()) ;
       
       
      
        this.f1 = "" ;
        this.sf1 = "" ;
        this.idpro1 = 0 ;
        this.pac1 = 0 ;
        
        
        
        this.mu1 = 0 ;
        
        this.mu1 = Math.round(this.pv1 - this.pa1) ;
        this.pac1 = this.pa1 ;
       
       
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
      
       sql= "SELECT unite_mesure FROM matieres_p WHERE description = '"+this.article1.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
      while(rs.next()){
        
    
       this.rp1 = rs.getString("unite_mesure") ;
       
       
     }
      
       String sql1 ;
      
       sql1 = "SELECT * FROM stock1 WHERE desi = '"+this.article1.replaceAll("'", "''")+"'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
      while(rs1.next()){
        
        this.stockDispo = rs1.getLong("stock") ;  
       
     }
      
      
      
      String sql2 ;
      
       sql2 = "SELECT * FROM matieres_p WHERE description = '"+this.article1.replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
      while(rs2.next()){
        
        this.idpro1 = rs2.getLong("id") ;
        this.f1 = rs2.getString("condition_livraison") ;
        this.sf1 = rs2.getString("conservation") ;
        
         
     }
      
      String sql3 ;
      
       sql3 = "SELECT * FROM produits_f WHERE description = '"+this.article1.replaceAll("'", "''")+"'" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3) ;
      
      
      while(rs3.next()){
        
        this.idpro1 = rs3.getInt("id") ;
        this.f1 = rs3.getString("f") ;
        this.sf1 = rs3.getString("sf") ;
        
         
     }
     
       System.out.println(this.stockDispo) ;
     
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs.close();
      rs1.close();
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
        
        
      
       
     // this.jTable5.setCellEditable(nBon, nBon) ;
        
        
    }//GEN-LAST:event_jTable5KeyTyped

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
        
         this.rp2 = "" ;
     
         this.article2 = "" ;
         this.pv2 = 0 ;
         this.pa2 = 0 ;
         this.stockDispo1 = 0 ;
       
       this.article2 = jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString() ;
       this.pv2 = Double.parseDouble(jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()) ;
       this.pa2 = Long.parseLong(jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()) ;
       
       
        this.f2 = "" ;
        this.sf2 = "" ;
        this.idpro2 = 0 ;
        this.pac2 = 0 ;
        this.prxv2 = 0 ;
        
        this.pac2 = Long.parseLong(jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString())  ;
        
        this.prxv2 = this.pac2 ;
        
        this.mu2 = 0 ;
        
        this.mu2 = Math.round(this.pac2 - this.pa2) ;
       
       
       
       
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
      
       sql= "SELECT unite_m FROM produits_f WHERE description = '"+this.article2.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
      while(rs.next()){
        
    
       this.rp2 = rs.getString("unite_m") ;
       
       
     }
      
       String sql1 ;
      
       sql1 = "SELECT * FROM stock1 WHERE desi = '"+this.article2.replaceAll("'", "''")+"'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
      while(rs1.next()){
        
        this.stockDispo1 = rs1.getLong("stock") ;  
       
     }
     
        String sql2 ;
      
       sql2 = "SELECT * FROM matieres_p WHERE description = '"+this.article2.replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
      while(rs2.next()){
        
        this.idpro2 = rs2.getLong("id") ;
        this.f2 = rs2.getString("condition_livraison") ;
        this.sf2 = rs2.getString("conservation") ;
        
         
     }
      
      String sql3 ;
      
       sql3 = "SELECT * FROM produits_f WHERE description = '"+this.article2.replaceAll("'", "''")+"'" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3) ;
      
      
      while(rs3.next()){
        
        this.idpro2 = rs3.getInt("id") ;
        this.f2 = rs3.getString("f") ;
        this.sf2 = rs3.getString("sf") ;
        
         
     }
     
       System.out.println(this.stockDispo1) ;
     
    
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs.close();
      rs1.close();
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
        
        
        
        
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyTyped
        // TODO add your handling code here:
         this.arti1 = "" ;
        this.q1 = 0 ;
        this.sot1 = 0 ;
        this.rp2 = "" ;
        this.pv2 = 0;
        
        this.arti1 = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString() ;
        this.q1 = Long.parseLong(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString()) ;
        this.pv2 = Double.parseDouble(jTable2.getValueAt(this.jTable2.getSelectedRow(), 2).toString()) ;
        
          
         Connection conn = null ;
         Statement stmt = null  ; 
       
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
      
       sql= "SELECT * FROM stock1 WHERE desi = '"+this.arti1.replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        this.sot1 = rs.getLong("stock") ;  
       
     }
     
    
       
     String sql1 ;
      
       sql1 = "SELECT unite_mesure FROM matieres_p WHERE description = '"+this.arti1.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
      while(rs1.next()){
        
    
       this.rp2 = rs1.getString("unite_mesure") ;
       
       
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
        
        
        
        
    }//GEN-LAST:event_jTable2KeyTyped

    private void jTable4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable4KeyTyped
        // TODO add your handling code here:
        
         
        this.arti2 = "" ;
        this.q2 = 0 ;
        this.sot2 = 0 ;
        
        this.arti2 = this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 0).toString() ;
        this.q2 = Long.parseLong(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 1).toString()) ;
        
          
         Connection conn = null ;
         Statement stmt = null  ; 
       
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
      
       sql= "SELECT * FROM stock1 WHERE desi = '"+this.arti2.replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        this.sot2 = rs.getLong("stock") ;  
       
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
        
        
        
        
    }//GEN-LAST:event_jTable4KeyTyped

    private void an3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_an3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_an3ActionPerformed

    private void an4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_an4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_an4ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductionTOrdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductionTOrdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductionTOrdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductionTOrdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductionTOrdi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPrint;
    private javax.swing.JButton ad1;
    private javax.swing.JButton ad2;
    private javax.swing.JButton an1;
    private javax.swing.JButton an2;
    private javax.swing.JButton an3;
    private javax.swing.JButton an4;
    private javax.swing.JTextField dep;
    private javax.swing.JTextField desc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jPro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JComboBox mag;
    private javax.swing.JLabel npro;
    private javax.swing.JLabel nupro;
    private javax.swing.JComboBox pro;
    private javax.swing.JTextField prof;
    private javax.swing.JTextField qte1;
    private javax.swing.JTextField qte2;
    private javax.swing.JTextField rec;
    private javax.swing.JLabel stat;
    private javax.swing.JLabel stf;
    private javax.swing.JLabel td;
    private javax.swing.JLabel tr;
    // End of variables declaration//GEN-END:variables
}
