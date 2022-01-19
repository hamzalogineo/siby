/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

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
public class ProductionTFermer2 extends javax.swing.JFrame {

    /**
     * Creates new form ProductionT
     */
    
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
      String user_c ;
      String role ;
      String dc ;
      String rp1 = "" ;
      String rp2 = "" ;
      String article1 = "" ;
      long pv1 = 0 ;
      long pa1 = 0 ;
      String article2 = "" ;
      long pv2 = 0 ;
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
      
      
      // info de la production :
      
      
      String status = "" ;
      String dtec = "" ;
      String admin = "" ;
      
      int nBon = 0;
      
      // end :
    
    public ProductionTFermer2() {
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
        //
        
        DateFormat datef = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss") ;
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
      
        
      
      
     
       String sql2 ;
      
       sql2 = "SELECT * FROM magasins " ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
      //    this.mag.addItem(rs2.getString("magasin"))  ;
         
       
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
        
        
        
        
    }

    
    
    // constructeur avec parem :
    
    
      
    public ProductionTFermer2(String nom , Integer n , String status , String dtec , String admin , String role , String dtef) {
        initComponents();
        this.nom = nom.replaceAll("'", "''") ;
        this.n = n ;
        this.status = status ;
        this.dtec = dtec ;
        this.admin = admin.replaceAll("'", "''") ;
        this.role = role ;
        
        this.dtec2.setText("Fermer :"+" "+dtef) ;
        
        
        this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
      
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
        
        
        
        //
        
        DateFormat datef = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss") ;
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
      
      
      
       clear5() ;
       clear1() ;
       clear2() ;
       clear4() ;
        
     
              long mt = 0 ;
              long mt1 = 0 ;
                 
                  
                 DefaultTableModel dtm4 = (DefaultTableModel) this.jTable4.getModel() ;
            
                 
                 
                 DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                 
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel() ;
         DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel() ;
         
        
      
      
      
       
         String sql1 ;
      
         sql1= "SELECT * FROM pmp WHERE nomp = '"+this.nom+"' ORDER BY article" ;
      
         ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
        while(rs1.next()){
         
        dtm.addRow(new Object[]{
     
     // "DESCRIPTION", "P.A", "P.V" 

            
       rs1.getString("article")  ,
       rs1.getLong("pa") , rs1.getLong("pv") 
        
        }) ;
  
       
     }
      
    String sql ;
      
         sql = "SELECT * FROM ppf WHERE nomp = '"+this.nom+"' ORDER BY article" ;
      
         ResultSet rs = stmt.executeQuery(sql) ;
      
      
        while(rs.next()){        
        
        dtm1.addRow(new Object[]{
     
     //  "DESCRIPTION", "P.A", "P.V"  

            
       rs.getString("article")  ,
       rs.getLong("pa") , rs.getLong("pu") 
        
        }) ;
  
       
     }
        
        
        
        String sql12 ;
      
                  sql12 = "SELECT * FROM prodmp WHERE nom='"+this.nom+"' AND n = "+this.n+" ORDER BY article" ;
      
                  ResultSet rs12 = stmt.executeQuery(sql12) ;
      
      
                 while(rs12.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm2.addRow(new Object[]{
                     
                         rs12.getString("article") , rs12.getLong("qte") , rs12.getLong("pu") , rs12.getLong("montant") 
                     
                     });
         
                     mt += rs12.getLong("montant") ;
        
                     }
                 
                  this.dep.setText(String.valueOf(mt)) ;
                 
                  
                   // tab :
                  String sql13 ;
      
                  sql13 = "SELECT * FROM prodpf WHERE nom='"+this.nom+"' AND n = "+this.n+" ORDER BY article" ;
      
                  ResultSet rs13 = stmt.executeQuery(sql13) ;
      
      
                 while(rs13.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm4.addRow(new Object[]{
                     
                         rs13.getString("article") , rs13.getLong("qte") , rs13.getLong("pu") , rs13.getLong("montant") 
                     
                     });
         
                     mt1 += rs13.getLong("montant") ;
        
                     }
                 
                 this.rec.setText(String.valueOf(mt1)) ;
                 
                 this.prof.setText(String.valueOf(mt1 - Long.parseLong(this.dep.getText().trim()))) ;
                 
                 
        
        String sql2 ;
      
       sql2 = "SELECT * FROM magasins ORDER BY magasin" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
    //      this.mag.addItem(rs2.getString("magasin"))  ;
         
       
     }
     
     ResultSet rs5 =  stmt.executeQuery("SELECT nb FROM prod WHERE nom ='"+this.nom+"' AND n ="+this.n);
    while (rs5.next()){
        this.nBon = rs5.getInt("nb") ;
    }
        
        
        
    this.nom1.setText(this.nom) ;
    this.n1.setText("N°"+" "+String.valueOf(this.n));
    this.status1.setText("Statut "+": "+this.status);
    this.dtec1.setText("Dem."+" "+this.dtec) ;
    this.admin1.setText("Créer :"+" "+this.admin) ;
    
    
     if("ORDINAIRE".equalsIgnoreCase(this.role)){
             this.BtnPrint.setEnabled(false) ;
             this.td.setVisible(false) ;
             this.dep.setVisible(false) ;
             this.tr.setVisible(false) ;
             this.rec.setVisible(false) ;
             this.jPro.setVisible(false) ;
             this.prof.setVisible(false) ;
            
            
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

    
    
    
    // end :
    
    
    
    
    
    
    public void setUser_c(String user_c) {
        this.user_c = user_c;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDtec(String dtec) {
        this.dtec = dtec;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
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
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nom1 = new javax.swing.JLabel();
        n1 = new javax.swing.JLabel();
        status1 = new javax.swing.JLabel();
        dtec1 = new javax.swing.JLabel();
        admin1 = new javax.swing.JLabel();
        dtec2 = new javax.swing.JLabel();
        BtnPrint = new javax.swing.JButton();

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
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
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
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
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

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
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
        jTable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
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

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton4.setText("BON MAGASINIER");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(td, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(63, 63, 63)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(td)
                    .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Production info :");

        nom1.setText("jLabel3");

        n1.setText("jLabel4");

        status1.setText("jLabel6");

        dtec1.setText("jLabel7");

        admin1.setText("jLabel8");

        dtec2.setText("jLabel3");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(n1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(status1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtec1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(admin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtec2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nom1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(n1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtec1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtec2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(admin1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        BtnPrint.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        BtnPrint.setText("IMPRIMER");
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnPrint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(BtnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyPressed
        // TODO add your handling code here:
        
        
          String n1 = this.desc.getText().replaceAll("'", "''") ;
          String n2 = this.nom ;
        
        
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
      
         sql = "SELECT * FROM pmp WHERE nomp ='"+n2+"' AND article LIKE '%"+n1+"%'" ;
      
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
       this.pv1 = Long.parseLong(jTable5.getValueAt(this.jTable5.getSelectedRow(), 2).toString()) ;
       this.pa1 = Long.parseLong(jTable5.getValueAt(this.jTable5.getSelectedRow(), 1).toString()) ;
       
       
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
        
        
        
        
    }//GEN-LAST:event_jTable5MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        
        this.arti1 = "" ;
        this.q1 = 0 ;
        this.sot1 = 0 ;
        
        this.arti1 = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString() ;
        this.q1 = Long.parseLong(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString()) ;
        
          
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        
         this.rp2 = "" ;
     
         this.article2 = "" ;
         this.pv2 = 0 ;
         this.pa2 = 0 ;
         this.stockDispo1 = 0 ;
       
       this.article2 = jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString() ;
       this.pv2 = Long.parseLong(jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString()) ;
       this.pa2 = Long.parseLong(jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()) ;
       
       
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
            
            //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\prodFermer.jrxml")) ;
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\prodFermer.jrxml")) ;
            
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
            para.put("status", this.status);
            para.put("dtec", this.dtec);
            para.put("admin", this.admin);
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
            JasperViewer.viewReport(print, false);
            
       }catch(Exception e){
       
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       
       }

    }//GEN-LAST:event_BtnPrintActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
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
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
            JasperViewer.viewReport(print, false);
            
       }catch(Exception e){
       
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       
       }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductionTFermer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductionTFermer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductionTFermer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductionTFermer2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ProductionTFermer2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPrint;
    private javax.swing.JLabel admin1;
    private javax.swing.JTextField dep;
    private javax.swing.JTextField desc;
    private javax.swing.JLabel dtec1;
    private javax.swing.JLabel dtec2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jPro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JLabel n1;
    private javax.swing.JLabel nom1;
    private javax.swing.JTextField prof;
    private javax.swing.JTextField rec;
    private javax.swing.JLabel status1;
    private javax.swing.JLabel td;
    private javax.swing.JLabel tr;
    // End of variables declaration//GEN-END:variables
}
