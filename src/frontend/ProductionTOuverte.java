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
public class ProductionTOuverte extends javax.swing.JFrame{

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
      double pv1 = 0 ;
      long pa1 = 0 ;
      String article2 = "" ;
      double pv2 = 0 ;
      long pa2 = 0 ;
      
      
      List eltModifier1 = new ArrayList() ;
      int nBon = 0;
      long tBon = 0;
      
      
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
      
      // end :
      
      
      
      
      
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
  
      
       String rapport = "" ;
        double pv20 = 0 ;
      
      
    
    public ProductionTOuverte() {
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
        //
        
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
      
        
      
      
     
       String sql2 ;
      
       sql2 = "SELECT * FROM magasins " ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
          this.mag.addItem(rs2.getString("magasin"))  ;
         
       
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
    
    
      
    public ProductionTOuverte( String nom , Integer n , String status , String dtec , String admin , String role) {
        initComponents();
        // this.role = role ;
        this.nom = nom.replaceAll("'", "''") ;
        this.n = n ;
        this.status = status ;
        this.dtec = dtec ;
        this.admin = admin.replaceAll("'", "''") ;
        this.role = role ;
        
        
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
      
        
      
      
              long mt = 0 ;
              long mt1 = 0 ;
                 
              clear5() ;
              clear1() ;
              clear2() ;
              clear4() ;
      
      
                 
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
      
                  sql12 = "SELECT * FROM prodmp WHERE nom='"+this.nom+"' AND n = "+this.n +" ORDER BY article" ;
      
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
      
                  sql13 = "SELECT * FROM prodpf WHERE nom='"+this.nom+"' AND n = "+this.n +" ORDER BY article";
      
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
        
          this.mag.addItem(rs2.getString("magasin"))  ;
         
       
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
             
             // a valider plus tard :
             
             this.an2.setEnabled(false);
            
            
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
        jButton3 = new javax.swing.JButton();
        qte1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ad1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        qte2 = new javax.swing.JTextField();
        ad2 = new javax.swing.JButton();
        mag = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        an1 = new javax.swing.JButton();
        an2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nom1 = new javax.swing.JLabel();
        n1 = new javax.swing.JLabel();
        status1 = new javax.swing.JLabel();
        dtec1 = new javax.swing.JLabel();
        admin1 = new javax.swing.JLabel();
        BtnPrint = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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
        jTable2.getAccessibleContext().setAccessibleName("");

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

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton3.setText("BON MAGASINIER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(td, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(td))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("QUANTITE");

        ad1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ad1.setText("AJOUTER");
        ad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("QTE OBTENUE");

        ad2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ad2.setText("AJOUTER");
        ad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ad2ActionPerformed(evt);
            }
        });

        mag.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Magasin" }));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton5.setText("FERMER ACTIVITE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        an1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        an1.setText("ANNULER");
        an1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                an1ActionPerformed(evt);
            }
        });

        an2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        an2.setText("ANNULER");
        an2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                an2ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Production info :");

        nom1.setText("jLabel3");

        n1.setText("jLabel4");

        status1.setText("jLabel6");

        dtec1.setText("jLabel7");

        admin1.setText("jLabel8");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(n1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(status1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtec1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(admin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
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
                .addComponent(admin1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        BtnPrint.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        BtnPrint.setText("IMPRIMER");
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("MODIFIER");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("MODIFIER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mag, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ad2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(an2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(an1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(qte1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(BtnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qte1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ad1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(an1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(mag, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qte2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ad2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(an2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
        
        
        
        
    }//GEN-LAST:event_jTable5MouseClicked

    private void ad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ad1ActionPerformed
        // TODO add your handling code here:
        
           // cut
        this.profil1 = 0 ;
        //
        
        
        if(this.jTable5.getSelectedRow() == -1){
             JOptionPane.showMessageDialog(this, "Selectionner dans le tableau une production svp") ;
        }else{
        
        String prod1 = this.nom ;
        String np = this.nom1.getText() ;
        
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
                        double mtt01 = (this.pv1 * qt03) ;
                        double t2 = (this.mu1 * qt03) ;
                               mtt = Math.round(mtt01) ;
                       this.profil1 = Math.round(t2) ;        
                               
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
             
            // if(stmt.executeUpdate("INSERT INTO prodmp(nom,n,article,qte,pu,montant,dtec,admin) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article1.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv1+" , "+mtt+" , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") == 1){
             
            if(stmt.executeUpdate("INSERT INTO prodmp(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article1.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv1+" , "+mtt+" , '"+this.dtec+"' , '"+this.admin.replaceAll("'", "''")+"' , '"+this.f1.replaceAll("'", "''")+"' , '"+this.sf1.replaceAll("'", "''")+"' , "+this.idpro1+" , "+this.pa1+" , "+this.profil1+" , "+this.mu1+")") == 1){
                
                this.nBon++ ;

                stmt.executeUpdate("UPDATE prod SET nb ="+this.nBon+" WHERE nom ='"+this.nom+"' AND n ="+this.n);

                HashMap<String, Object> m = new HashMap<>();
                m.put("desi", this.article1);
                m.put("qte", Integer.parseInt(qt01));
                int puB = (int)this.pv1;
                m.put("pu", puB);
                int mont = (int)mtt ;
                tBon += mtt;
                m.put("montant", mont);
                m.put("total", tBon);
                eltModifier1.add(m);
                
                
                long mt = 0 ;
                 
                /*
                 jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                                
             } ,
          new String [] {
           "DESCRIPTION", "QTE", "P.U", "MONTANT"
             })
               ) ;*/
                
                clear2() ;
                 
                 DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                 
if(stmt.executeUpdate("UPDATE stock1 SET qtest ="+qt02+" , stock ="+newStock+" WHERE desi ='"+this.article1.replaceAll("'", "''")+"'") > 0){
           //if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article1.replaceAll("'", "''")+"' , "+this.pa1+" , "+this.pv1+" , "+0+" , "+qt02+" , "+newStock+" , '' , '' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){      
                 
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
                 
                 this.dep.setText(String.valueOf(mt)) ;
                 
                 this.qte1.setText("");
                 
                 rs.close() ;
                 
                 
            // }
                             
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
                        double mtt02 = (this.pv1 * qt03) ;
                        double t5 = (this.mu1 * qt03) ;
                        this.profil1 = Math.round(t5) ;
                       
                   //    System.out.println("mtt  : "+" "+mtt02+" "+50 * 2) ;
                       
                       mtt = Math.round(mtt02) ;
                       
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
               
             // if(stmt.executeUpdate("INSERT INTO prodmp(nom,n,article,qte,pu,montant,dtec,admin) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article1.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv1+" , "+mtt+" , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") == 1){
              if(stmt.executeUpdate("INSERT INTO prodmp(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article1.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv1+" , "+mtt+" , '"+this.dtec+"' , '"+this.admin.replaceAll("'", "''")+"' , '"+this.f1.replaceAll("'", "''")+"' , '"+this.sf1.replaceAll("'", "''")+"' , "+this.idpro1+" , "+this.pa1+" , "+this.profil1+" , "+this.mu1+")") == 1){
                  
                 
               this.nBon++ ;

                stmt.executeUpdate("UPDATE prod SET nb ="+this.nBon+" WHERE nom ='"+this.nom+"' AND n ="+this.n);

                HashMap<String, Object> m = new HashMap<>();
                m.put("desi", this.article1);
                m.put("qte", Integer.parseInt(qt01));
                int puB = (int)this.pv1;
                m.put("pu", puB);
                int mont = (int)mtt ;
                tBon += mtt;
                m.put("montant", mont);
                m.put("total", tBon);
                eltModifier1.add(m);
                  
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
          // if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article1.replaceAll("'", "''")+"' , "+this.pa1+" , "+this.pv1+" , "+0+" , "+qt02+" , "+newStock+" , '' , '' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){      
                 
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
                 
                 this.dep.setText(String.valueOf(mt)) ;
                  this.qte1.setText("");
                 
                 rs.close() ;
                 
                 
           // }
                             
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
        
        //
        
             
        this.arti1 = "" ;
        this.q1 = 0 ;
        this.sot1 = 0 ;
        this.rp2 = "" ;
        this.pv2 = 0;
        this.stockDispo = 0 ;
        
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
      
      
      String sql2 ;
      
       sql2 = "SELECT * FROM stock1 WHERE desi = '"+this.arti1.replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
      while(rs2.next()){
        
        this.stockDispo = rs2.getLong("stock") ;  
       
     }
     
       System.out.println(this.stockDispo) ;
     
      
    
            
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
        
        
        
        
        
        //
        
        
        
        
        /*
        this.arti1 = "" ;
        this.q1 = 0 ;
        this.sot1 = 0 ;
        this.rp2 = "" ;
        this.pv2 = 0;
        this.stockDispo = 0 ;
        
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
      
      
      String sql2 ;
      
       sql2 = "SELECT * FROM stock1 WHERE desi = '"+this.arti1.replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
      while(rs2.next()){
        
        this.stockDispo = rs2.getLong("stock") ;  
       
     }
     
       System.out.println(this.stockDispo) ;
     
      
    
            
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
        
        
        
        */
        
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
        
        
        // debut :
        
        // cut
        this.profil2 = 0 ;
        //
        
           if(this.jTable1.getSelectedRow() == -1){
             JOptionPane.showMessageDialog(this, "Selectionner dans le tableau pour une production svp") ;
        }else{
        
        String prod1 = this.nom ;
        String np = this.nom1.getText() ;
        
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
                        double mtt03 = (this.pv2 * qt03) ;
                        double t2 = (this.mu2 * qt03) ;
                        
                        mtt = Math.round(mtt03) ;
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
             
            if(stmt.executeUpdate("INSERT INTO prodpf(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu,prxv) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article2.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv2+" , "+mtt+" , '"+this.dtec+"' , '"+this.admin.replaceAll("'", "''")+"' , '"+this.f2.replaceAll("'", "''")+"' , '"+this.sf2.replaceAll("'", "''")+"' , "+this.idpro2+" , "+this.pa2+" , "+this.profil2+" , "+this.mu2+" , "+this.prxv2+")") == 1){
                 
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
              
         
      if(stmt.executeUpdate("UPDATE stock1 SET qteet ="+qt02+" , stock ="+newStock+" , four ='"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , maga ='"+mag1.replaceAll("'", "''")+"' , datec ='"+this.dc+"' , admin ='"+this.admin.replaceAll("'", "''")+"' WHERE desi ='"+this.article2.replaceAll("'", "''")+"'") > 0){
          
          //if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){
          
              
               
                 // tab :
                  String sql ;
      
                  sql = "SELECT * FROM prodpf WHERE nom='"+this.nom+"' AND n = "+this.n ;
      
                  ResultSet rs = stmt.executeQuery(sql) ;
      
      
                 while(rs.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     dtm.addRow(new Object[]{
                     
                         rs.getString("article") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("montant") 
                     
                     }) ;
         
                     mt += rs.getLong("montant") ;
        
                     }
                 
                 this.rec.setText(String.valueOf(mt)) ;
                 
                 this.prof.setText(String.valueOf(mt - Long.parseLong(this.dep.getText().trim()))) ;
                 
                 this.qte2.setText("") ;
                 
                 rs.close() ;
                 
                 // tab end :
          
              
              
          
             //}
          
          
      }
      
    
            
           
                
                
            }else{
        //  create my stock please : 
                
                
       
         
         if(stmt.executeUpdate("INSERT INTO stock1(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')") > 0){
           if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')" ) > 0){
          
         
               
                // tab :
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
      
          
         if(stmt.executeUpdate("INSERT INTO prod(nom,n,status,dtec,admin) VALUES('"+this.nom+"' , "+this.n+" , '"+this.st+"' , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')") == 1){
             
              if(lib1.size() == 1){
                
                  JOptionPane.showMessageDialog(this, "Le produit fini existe dejà annuler la et réajouter la pour corriger des erreurs svp");
                
                
            }else{
             
             if(stmt.executeUpdate("INSERT INTO prodpf(nom,n,article,qte,pu,montant,dtec,admin) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article2.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv2+" , "+mtt+" , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')") == 1){
                 
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
                 
                 DefaultTableModel dtm = (DefaultTableModel) this.jTable4.getModel() ;
                 
                 
                 
         if(entreprise.size() == 1){
                
         //  update my stock please :
              
         
      if(stmt.executeUpdate("UPDATE stock1 SET qteet ="+qt02+" , stock ="+newStock+" , four ='"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , maga ='"+mag1.replaceAll("'", "''")+"' , datec ='"+this.dc+"' , admin ='"+this.admin.replaceAll("'", "''")+"' WHERE desi ='"+this.article2.replaceAll("'", "''")+"'") > 0){
          
          if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')") > 0){
          
              
               
                 // tab :
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
                 
                 this.rec.setText(String.valueOf(mt)) ;
                 
                 this.prof.setText(String.valueOf(mt - Long.parseLong(this.dep.getText().trim()))) ;
                 
                 this.qte2.setText("");
                 
                 rs.close() ;
                 
                 // tab end :
          
              
              
          
             }
          
          
      }
      
    
            
           
                
                
            }else{
        //  create my stock please : 
                
                
       
         
         if(stmt.executeUpdate("INSERT INTO stock1(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')") > 0){
           if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')" ) > 0){
          
         
               
                // tab :
               
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
      // Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      // finally block used to close resources
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
                             double mtt05 = (this.pv2 * qt03) ;
                             double t2 = (this.mu2 * qt03) ;
                             mtt = Math.round(mtt05) ;
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
             
             if(stmt.executeUpdate("INSERT INTO prodpf(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu,prxv) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article2.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv2+" , "+mtt+" , '"+this.dtec+"' , '"+this.admin.replaceAll("'", "''")+"' , '"+this.f2.replaceAll("'", "''")+"' , '"+this.sf2.replaceAll("'", "''")+"' , "+this.idpro2+" , "+this.pa2+" , "+this.profil2+" , "+this.mu2+" , "+this.prxv2+")") == 1){
                 
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
              
         
      if(stmt.executeUpdate("UPDATE stock1 SET qteet ="+qt02+" , stock ="+newStock+" , four ='"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , maga ='"+mag1.replaceAll("'", "''")+"' , datec ='"+this.dc+"' , admin ='"+this.admin.replaceAll("'", "''")+"' WHERE desi ='"+this.article2.replaceAll("'", "''")+"'") > 0){
          
       //   if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.user_c.replaceAll("'", "''")+"')") > 0){
          
              
               
                 // tab :
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
                 
                 this.rec.setText(String.valueOf(mt)) ;
                 
                 this.prof.setText(String.valueOf(mt - Long.parseLong(this.dep.getText().trim()))) ;
                 
                 this.qte2.setText("");
                 
                 rs.close() ;
                 
                 // tab end :
          
              
              
          
           //  }
          
          
      }
      
    
            
           
                
                
            }else{
        //  create my stock please : 
                
                
       
         
         if(stmt.executeUpdate("INSERT INTO stock1(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')") > 0){
           if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')" ) > 0){
          
         
               
                // tab :
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
      
          
         if(stmt.executeUpdate("INSERT INTO prod(nom,n,status,dtec,admin) VALUES('"+this.nom+"' , "+this.n+" , '"+this.st+"' , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')") == 1){
             
              if(lib1.size() == 1){
                
                  JOptionPane.showMessageDialog(this, "Le produit fini existe dejà annuler la et réajouter la pour corriger des erreurs svp");
                
                
            }else{
             
             if(stmt.executeUpdate("INSERT INTO prodpf(nom,n,article,qte,pu,montant,dtec,admin) VALUES('"+this.nom+"' , "+this.n+" , '"+this.article2.replaceAll("'", "''")+"' , "+qt02+" , "+this.pv2+" , "+mtt+" , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')") == 1){
                 
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
                 
                 DefaultTableModel dtm = (DefaultTableModel) this.jTable4.getModel() ;
                 
                 
                 
         if(entreprise.size() == 1){
                
         //  update my stock please :
              
         
      if(stmt.executeUpdate("UPDATE stock1 SET qteet ="+qt02+" , stock ="+newStock+" , four ='"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , maga ='"+mag1.replaceAll("'", "''")+"' , datec ='"+this.dc+"' , admin ='"+this.admin.replaceAll("'", "''")+"' WHERE desi ='"+this.article2.replaceAll("'", "''")+"'") > 0){
          
          if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')") > 0){
          
              
               
                 // tab :
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
                 
                 this.rec.setText(String.valueOf(mt)) ;
                 
                 this.prof.setText(String.valueOf(mt - Long.parseLong(this.dep.getText().trim()))) ;
                 
                 this.qte2.setText("");
                 
                 rs.close() ;
                 
                 // tab end :
          
              
              
          
             }
          
          
      }
      
    
            
           
                
                
            }else{
        //  create my stock please : 
                
                
       
         
         if(stmt.executeUpdate("INSERT INTO stock1(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')") > 0){
           if(stmt.executeUpdate("INSERT INTO stock2(cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('' , '"+this.article2.replaceAll("'", "''")+"' , "+this.pa2+" , "+this.pv2+" , "+qt02+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.nom+" "+"N°"+" "+String.valueOf(this.n)+"' , '"+mag1.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')" ) > 0){
          
         
               
                // tab :
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
        this.pv20 = 0 ;
        this.mu2 = 0 ;
        
        this.arti2 = this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 0).toString() ;
        this.q2 = Long.parseLong(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 1).toString()) ;
        this.pv20 = Double.parseDouble(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 2).toString()) ;
        
        this.rapport = "" ;
          
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
     
    
         String sql2 ;
      
       sql2 = "SELECT unite_m FROM produits_f WHERE description = '"+this.arti2.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
      while(rs2.next()){
        
    
       this.rapport = rs2.getString("unite_m") ;
       
       
     }
      
      
       String sql3 ;
      
       sql3 = "SELECT mu FROM prodpf WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" AND article = '"+this.arti2+"' LIMIT 1" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3);
      
      
      while(rs3.next()){
        
    
       this.mu2 = rs3.getLong("mu") ;
       
       
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        
           String prod1 = this.nom ;
           String np = this.nom1.getText() ;
        
        
        if("CHOISIR ACTIVITE".equalsIgnoreCase(prod1) || "LA PRODUCTION".equalsIgnoreCase(np)){
            
            JOptionPane.showMessageDialog(this, "Choisir une production svp") ;
            
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
      
      DateFormat dtef = new SimpleDateFormat("yyyy-MM-dd HH:MM") ;
      Date date = new Date() ;
      String dtf = dtef.format(date) ;
      
      long profil = 0 ;
      profil = ( Long.parseLong(this.rec.getText().trim()) - Long.parseLong(this.dep.getText().trim()) );
          
      if(stmt.executeUpdate("UPDATE prod SET status = 'fermer' , dtef ='"+dtf+"' , dep = "+Long.parseLong(this.dep.getText().trim())+" , rec = "+Long.parseLong(this.rec.getText().trim())+" , profil = "+profil+" WHERE nom ='"+this.nom+"' AND n = "+this.n) == 1){
          this.prof.setText(String.valueOf(profil)) ;
          
          this.qte1.setEditable(false) ;
          this.ad1.setEnabled(false) ;
          this.an1.setEnabled(false) ;
          this.mag.setEnabled(false) ;
          this.qte2.setEditable(false) ;
          this.ad2.setEnabled(false) ;
          this.an2.setEnabled(false) ;
          this.jButton4.setEnabled(false);
          this.status1.setText("FERMER") ;
          
          
          
          
          
          JOptionPane.showMessageDialog(this, "la production a été cloturée avec succès");
          
      }else{
          JOptionPane.showMessageDialog(this, "Demarrer la production ensuite fermer la à la fin merci !!!");
      }
      
      
            
     // STEP 6: Clean-up environment
      
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
     
        
        
        //
        
        
        
        }
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (this.nBon == 1) {
            
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
            
        } else if (this.nBon > 1) {
            
            try {
                
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\bonCommande.jrxml")) ;
                
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(eltModifier1);
            
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
            
        }
        

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String article = "";
        int qte = 0;
        long qt02 = 0;
        int qt = 0;

        if(this.jTable2.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selectionner dans le tableau une production svp") ;
        }else {
            article = this.jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString().replaceAll("'", "''") ;
            qte = Integer.parseInt(this.jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString());

            String qt01 = this.qte1.getText().trim() ;
            
            if("".equalsIgnoreCase(qt01)){

                JOptionPane.showMessageDialog(this, "Choisir une Quantite de la matiere primaire svp") ;

            }else{
                try{
                    qt02 = Long.parseLong(qt01) ;
                    qt = Integer.parseInt(qt01);
                    qt02 += qte;
                    long mtt = 0;
                    long mttB = 0;

                    if(this.stockDispo >= qt02){

                        if("oui".equalsIgnoreCase(this.rp2)) {
                            double qt03 = (qt02 / 1000.0) ;
                            double t1 = (this.pv2 * qt03) ;
                            double t2 = (this.mu1 * qt03) ;
                            mtt = Math.round(t1) ;
                            this.profil1 = Math.round(t2) ;
                            double qt03B = (qt / 1000.0) ;
                            double t1B = (this.pv2 * qt03B) ;
                            mttB = Math.round(t1B) ;
                        }else{
                            double t1 = (this.pv2 * qt02) ;
                            double t2 = (this.mu1 * qt02) ;
                            mtt = Math.round(t1) ;
                            this.profil1 = Math.round(t2) ;
                            
                            double t1B = (this.pv2 * qt) ;
                            mttB = Math.round(t1B) ;
                        }

                        long newStock = (this.stockDispo - qt) ;
                        SessionFactory sf=new Configuration().configure().buildSessionFactory();
                        Session s=sf.openSession();
                        List lib = s.createSQLQuery("SELECT * FROM prod WHERE nom ='"+this.nom+"' AND n ="+this.n).list();
                        List lib1 = s.createSQLQuery("SELECT * FROM prodmp WHERE nom ='"+this.nom+"' AND n ="+this.n+" AND article ='"+article+"' ").list();
                        if(lib.size() == 1){
                            Connection conn = null;
                            Statement stmt = null;
                            try{
                                Class.forName(JDBC_DRIVER);
                                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                                stmt = conn.createStatement();
                                if(lib1.size() == 1) {
                                    if(stmt.executeUpdate("UPDATE prodmp SET qte ="+qt02+" , montant="+mtt+" , profil = "+this.profil1+" WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n
                                            +" AND article = '"+article.replaceAll("'", "''")+"'") == 1 || stmt.executeUpdate("UPDATE prodmp SET qte ="+qt02+" , montant="+mtt+" , profil = "+this.profil1+" WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n
                                            +" AND article = '"+article.replaceAll("'", "''")+"'") > 0){

                                        this.nBon++ ;
                                        System.out.println("\n");
                                        System.out.println(this.nBon);
                                        
                                        stmt.executeUpdate("UPDATE prod SET nb ="+this.nBon+" WHERE nom ='"+this.nom+"' AND n ="+this.n);

                                        HashMap<String, Object> m = new HashMap<>();
                                        m.put("desi", article);
                                        m.put("qte", qt);
                                        int puB = (int)this.pv2;
                                        m.put("pu", puB);
                                        int mont = (int)mttB ;
                                        tBon += mttB;
                                        m.put("montant", mont);
                                        m.put("total", tBon);
                                        eltModifier1.add(m);

                                        long mt = 0 ;
                                       
                                        
                                        clear2() ;

                                        DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                                        dtm.setRowCount(0) ;

                                        if(stmt.executeUpdate("UPDATE stock1 SET qtest ="+qt02+" , stock ="+newStock+" WHERE desi ='"+article+"' ") > 0){

                                            String sql ;

                                            sql = "SELECT * FROM prodmp WHERE nom='"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n ;
                                            ResultSet rs = stmt.executeQuery(sql) ;

                                            while(rs.next()){

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

    }//GEN-LAST:event_jButton4ActionPerformed

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
        this.stockDispo = 0 ;
        
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
      
      // je crai ma requete
      
         
         
       String sql ;
      
       sql= "SELECT * FROM stock1 WHERE desi = '"+this.arti1.replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        this.sot1 = rs.getLong("stock") ;  
       
     }
     
    
       
     String sql1 ;
      
       sql1 = "SELECT unite_mesure FROM matieres_p WHERE description = '"+this.arti1.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
      while(rs1.next()){
        
    
       this.rp2 = rs1.getString("unite_mesure") ;
       
       
     }
      
      
      String sql2 ;
      
       sql2 = "SELECT * FROM stock1 WHERE desi = '"+this.arti1.replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
      while(rs2.next()){
        
        this.stockDispo = rs2.getLong("stock") ;  
       
     }
     
       System.out.println(this.stockDispo) ;
     
      
    
            
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
        this.pv20 = 0 ;
        this.mu2 = 0 ;
        
        this.arti2 = this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 0).toString() ;
        this.q2 = Long.parseLong(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 1).toString()) ;
        this.pv20 = Double.parseDouble(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 2).toString()) ;
        
        this.rapport = "" ;
          
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
     
    
         String sql2 ;
      
       sql2 = "SELECT unite_m FROM produits_f WHERE description = '"+this.arti2.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
      while(rs2.next()){
        
    
       this.rapport = rs2.getString("unite_m") ;
       
       
     }
      
      
       String sql3 ;
      
       sql3 = "SELECT mu FROM prodpf WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" AND article = '"+this.arti2+"' LIMIT 1" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3);
      
      
      while(rs3.next()){
        
    
       this.mu2 = rs3.getLong("mu") ;
       
       
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable4.getSelectedRow() == -1){
        
            JOptionPane.showMessageDialog(this, "Vous devez selectionner dans le tableau svp") ;
            
        }else{
            
            long newQte = 0 ;
       
            
           // "DESCRIPTION", "QTE", "P.U", "MONTANT" 
            
        
           
            
            String saisie = "" ;
            
            saisie = this.qte2.getText().trim() ;
            
            if("".equals(saisie)){
                JOptionPane.showMessageDialog(this, "Vous devez saisir une quantité svp") ;
            }else{
                
          
            
            newQte = (this.q2 + (Long.parseLong(saisie))) ; 
            this.profil2 = 0 ;
            
            if("oui".equalsIgnoreCase(this.rapport)){
                // div par 1000 :
                 try{
                System.out.println("newQte : "+newQte) ;
                long mtt = 0 ;
                
                
                //
                
                        double qt03 = (newQte / 1000.0) ;
                        double mtt03 = (this.pv20 * qt03) ;
                        double t2 = (this.mu2 * qt03) ;
                        
                        mtt = Math.round(mtt03) ;
                        this.profil2 = Math.round(t2) ;
                        
                       // this.dep.setText(String.valueOf(mtt)) ;
                        
                        long newStock = (this.sot2 + (Long.parseLong(this.qte2.getText().trim()))) ;
                        
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
      
         if(stmt.executeUpdate("UPDATE prodpf SET qte = "+newQte+" , montant = "+mtt+" , profil = "+ this.profil2+" WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" AND article = '"+this.arti2+"' LIMIT 1") == 1){
               if(stmt.executeUpdate("UPDATE stock1 SET stock = "+newStock+" WHERE desi = '"+this.arti2.replaceAll("'", "''")+"'") == 1){
                           DefaultTableModel dtm = (DefaultTableModel) this.jTable4.getModel() ;
                           dtm.setRowCount(0) ;
                           
                            long mt = 0 ;
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
                 
                 this.rec.setText(String.valueOf(mt)) ;
                 this.prof.setText(String.valueOf(mt - Long.parseLong(this.dep.getText().trim())));
                 this.qte2.setText("");
                 
                 
                 rs.close() ;    
                           
                            
        }             
                            
        }
      
            
    // STEP 6: Clean-up environment
      
   //  System.out.println("Goodbye!");
      
   
      
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
        
        
                 }catch(Exception e){
                     
                     
                 }
                
                
            }else{
                // else div par 1000 :
                
                
                  try{
                System.out.println("newQte : "+newQte) ;
                long mtt = 0 ;
                
                
                //
                
                        double qt03 = newQte ;
                        double mtt03 = (this.pv20 * qt03) ;
                        double t2 = (this.mu2 * qt03) ;
                        
                        mtt = Math.round(mtt03) ;
                        this.profil2 = Math.round(t2) ;
                        
                       // this.dep.setText(String.valueOf(mtt)) ;
                        
                        long newStock = (this.sot2 + (Long.parseLong(this.qte2.getText().trim()))) ;
                        
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
      
         if(stmt.executeUpdate("UPDATE prodpf SET qte = "+newQte+" , montant = "+mtt+" , profil = "+ this.profil2+" WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" AND article = '"+this.arti2+"' LIMIT 1") == 1){
               if(stmt.executeUpdate("UPDATE stock1 SET stock = "+newStock+" WHERE desi = '"+this.arti2.replaceAll("'", "''")+"'") == 1){
                           DefaultTableModel dtm = (DefaultTableModel) this.jTable4.getModel() ;
                           dtm.setRowCount(0) ;
                           
                            long mt = 0 ;
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
                 
                 this.rec.setText(String.valueOf(mt)) ;
                 this.prof.setText(String.valueOf(mt - Long.parseLong(this.dep.getText().trim())));
                 this.qte2.setText("");
                 
                 
                 rs.close() ;    
                           
                            
        }             
                            
        }
      
            
    // STEP 6: Clean-up environment
      
   //  System.out.println("Goodbye!");
      
   
      
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
        
        
                 }catch(Exception e){
                     
                     
                 }
                
                
            
                
                
                
            }
  
                
                 
                
            }
            
            
            
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductionTOuverte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductionTOuverte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductionTOuverte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductionTOuverte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductionTOuverte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPrint;
    private javax.swing.JButton ad1;
    private javax.swing.JButton ad2;
    private javax.swing.JLabel admin1;
    private javax.swing.JButton an1;
    private javax.swing.JButton an2;
    private javax.swing.JTextField dep;
    private javax.swing.JTextField desc;
    private javax.swing.JLabel dtec1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JComboBox mag;
    private javax.swing.JLabel n1;
    private javax.swing.JLabel nom1;
    private javax.swing.JTextField prof;
    private javax.swing.JTextField qte1;
    private javax.swing.JTextField qte2;
    private javax.swing.JTextField rec;
    private javax.swing.JLabel status1;
    private javax.swing.JLabel td;
    private javax.swing.JLabel tr;
    // End of variables declaration//GEN-END:variables
}
