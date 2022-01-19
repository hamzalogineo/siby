/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frontend ;

import collection.CompteFournisseur;
import entity.ActiviteT;
import static frontend.Fournisseur.JDBC_DRIVER;
import static frontend.MatierePri.JDBC_DRIVER ;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics ;
import java.awt.Graphics2D ;
import java.awt.print.PageFormat ;
import java.awt.print.Printable;
import java.awt.print.PrinterException ;
import java.awt.print.PrinterJob ;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.PreparedStatement;
import java.sql.ResultSet ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.text.DateFormat ;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat ;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date ;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane ;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel ;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
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


public class StockFinal1 extends javax.swing.JFrame {

    /**
     * Creates new form StockFinal
     */
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      String cbr = "" ;
      String desi = "" ;
      long pa = 0 ;
      long pv = 0 ;
      long oldStock = 0 ;
      long qte = 0 ;
      String fourni = "LA SORTIE" ;
      String magasi = "" ;
      String admin = "" ;
      String dc = "" ;
      
      String f = "" ;
      String sf = "" ;
    
      
      //  server stock 
      
      String servDesi = "" ;
      long servQte = 0 ;
      long servStock = 0 ;
      String date_expiMoins15 = "";
      
      String date_expi = "";
      String unite_m = "";
      String role = "" ;
      Integer compte_fourni = 0 ;
      
      private static final String etat = "oui" ;
      Integer vy = 0 ;
      ArrayList<CompteFournisseur> list_com = new ArrayList<CompteFournisseur>() ;
      ArrayList<String> list_vy = new ArrayList<String>() ;
      List bonList = new ArrayList() ;
      private long adition = 0 ;
      
       NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
       String stock_1 = "" ;
       
       long ans ;
       long new_s;
       Integer departement = 0 ;
       Integer id_st ;
       
    public StockFinal1() {
        initComponents() ;
        this.setLocationRelativeTo(null);
        DateFormat datef = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
        Date date = new Date() ;
        this.dc = datef.format(date) ;
        this.dt.setText(this.dc) ;
        
        
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
        
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm.setRowCount(0) ;
        
        
        
        this.jTable2.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable2.getTableHeader().setOpaque(false); 
            this.jTable2.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable2.getTableHeader().setForeground(Color.white) ;
        
              this.jTable2.setRowHeight(25) ;
              
         
                  for (int i = 0; i < this.jTable2.getModel().getColumnCount(); i++) {
                    this.jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     
        
       
        
     
        
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable2.getModel() ;
        
        
        
        dtm1.setRowCount(0) ;
        
        
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
      
       sql= "SELECT * FROM matieres_p ORDER BY description" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
            
    // "Code Barre", "Description", "Prix Achat / Unité", "Prix de vente / Unité"
            
       rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") , rs.getLong("id")
        
        }) ;
  
       
     }
     
     
       String sql2 ;
      
       sql2 = "SELECT * FROM produits_f ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
        
        dtm.addRow(new Object[]{
            
       //  "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getString("code_barre") , rs2.getString("description") , rs2.getLong("libelle") 
         ,  rs2.getLong("pu"), rs2.getInt("id")
         
        }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
      
    
       String sql3 ;
      
       sql3 = "SELECT * FROM fournisseurs ORDER BY entreprise" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3) ;
      
      
     while(rs3.next()){
        
      
        
    this.fr.addItem(rs3.getString("entreprise")) ; 
         
       
     }
     
     
     
      String sql4 ;
      
       sql4 = "SELECT * FROM magasins ORDER BY magasin" ;
      
       ResultSet rs4 = stmt.executeQuery(sql4) ;
      
      
     while(rs4.next()){
        
     
      
        
      this.mg.addItem(rs4.getString("magasin")) ; 
       
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
    
    
     public StockFinal1(String role) {
         
        initComponents() ;
        this.role = role ;
        this.saving.setEnabled(false) ;
        // this.fr.setEnabled(false) ;
        this.jDateChooser2.setVisible(false) ;
        jLabel11.setVisible(false) ;
        rfs.setVisible(false) ;
        jButton6.setVisible(false) ;
        reinitialiser.setVisible(false) ;
        
        
        
        
        this.setLocationRelativeTo(null) ;
        DateFormat datef = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
        DateFormat datefT = new SimpleDateFormat("dd-MMMM-yyyy HH:mm") ;
        Date date = new Date() ;
        this.dc = datef.format(date) ;
        this.dt.setText(datefT.format(new Date())) ;
        this.totau.setText("0") ;
        
        
        this.jTable1.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable1.getTableHeader().setOpaque(false) ; 
            this.jTable1.getTableHeader().setBackground(Color.black) ; 
          
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
        
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm.setRowCount(0) ;
        
        
        
        this.jTable2.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable2.getTableHeader().setOpaque(false); 
            this.jTable2.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable2.getTableHeader().setForeground(Color.white) ;
        
              this.jTable2.setRowHeight(25) ;
              
         
                  for (int i = 0; i < this.jTable2.getModel().getColumnCount(); i++) {
                    this.jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     
        
       
        
     
        
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable2.getModel() ;
        
        
        
        dtm1.setRowCount(0) ;
        
        
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
      
       sql= "SELECT * FROM matieres_p ORDER BY description ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
            
    // "ID", "CODE BARRE", "DESCRIPTION", "P.A", "P.V"
            
       rs.getLong("id") ,  rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") 
        
        }) ;
  
       
     }
     
     
       String sql2 ;
      
       sql2 = "SELECT * FROM produits_f ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
        
        dtm.addRow(new Object[]{
            
       //  "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getInt("id") , rs2.getString("code_barre") , rs2.getString("description") , rs2.getLong("libelle") 
         ,  rs2.getLong("pu")
         
        }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
      
    
       String sql3 ;
      
       sql3 = "SELECT description FROM departements where type = 'OUI' ORDER BY description" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3) ;
      
      
     while(rs3.next()){
        
      
        
    this.fr.addItem(rs3.getString("description")) ; 
         
       
     }
     
     
     /*
     sql = "select description , prx_pm , produit , derive_pl.id as ref from stock_pl , derive_pl where derive_pl.produit = "
                + "stock_pl.description order by description ASC" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            
// "CODE BARRE", "DESCRIPTION", "P.A", "P.V", "ID"
            
            dtm.addRow(new Object[]{
            "" , rs.getString("description") , "0" , rs.getLong("prx_pm") , rs.getString("ref")
            });
        }
     
     */
     
     
     
      String sql4 ;
      
       sql4 = "SELECT magasin FROM magasins where etat = 'oui' limit 1" ;
      
       ResultSet rs4 = stmt.executeQuery(sql4) ;
      
      
     while(rs4.next()){
      
      this.stock_1 = rs4.getString("magasin") ;
      this.mg.addItem(rs4.getString("magasin")) ; 
       
     }
     
     
     sql = "select placement from point_pl where type = 'oui' order by placement ASC" ;
                 ResultSet rs20 = stmt.executeQuery(sql) ;
                 
                 while(rs20.next()){
                 
                  this.pl.addItem(rs20.getString("placement")) ;
                  
                  
               
       }
                 
       sql = "select placement from point_pl where type = 'oui' order by placement ASC" ;
                 ResultSet rs21 = stmt.executeQuery(sql) ;
                 
                 while(rs21.next()){
                 
                  this.mg.addItem(new String(rs21.getString("placement"))) ;
                 
       }          
      
    
        if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR")){
                      
                      
                      
                  }else{
             
                          this.reinitialiser.setEnabled(false) ;
           
          
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
    
    

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public void setReinitialiser() {
        this.reinitialiser.setEnabled(false);
    }
    
    
    
    
    
    
    
    
    
    
    
     private void clear1() {

        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        int n = model.getRowCount();
        for (int i = n - 1; i >= 0; --i) {
            model.removeRow(i);
        }
        
    }
    
    
     
      private void clear2() {

        DefaultTableModel model = (DefaultTableModel) this.jTable2.getModel();
        int n = model.getRowCount();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cb = new javax.swing.JTextField();
        desc = new javax.swing.JTextField();
        dispo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        st = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dt = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        totau = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        fr = new javax.swing.JComboBox();
        mg = new javax.swing.JComboBox();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        pl = new javax.swing.JComboBox();
        jButton7 = new javax.swing.JButton();
        saving = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        rfs = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmt = new javax.swing.JTextField();
        qt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        reinitialiser = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1312, 646));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("          SORTIE DE STOCK ");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODE BARRE", "DESCRIPTION", "P.A", "P.V"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(68);
            jTable1.getColumnModel().getColumn(2).setMinWidth(210);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(210);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(3);
        }

        cb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbKeyReleased(evt);
            }
        });

        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descKeyReleased(evt);
            }
        });

        dispo.setEditable(false);

        jLabel3.setText("STOCK DISPONIBLE");

        jLabel4.setText("CODE BARRE ");

        jLabel5.setText("DESCRIPTION");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("NOS ARTICLES ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dispo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(desc))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dispo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );

        st.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPTION", "QTE ENTREE", "P.V", "MONTANT"
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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable2KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(180);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(3);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(3);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(3);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("SORTIE DE STOCK");

        jLabel8.setText("Bamako le ,");

        dt.setText("jLabel9");

        jLabel10.setText("TOTAL :");

        totau.setText("jLabel13");

        javax.swing.GroupLayout stLayout = new javax.swing.GroupLayout(st);
        st.setLayout(stLayout);
        stLayout.setHorizontalGroup(
            stLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(stLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addGroup(stLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(stLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(totau, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        stLayout.setVerticalGroup(
            stLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(stLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(dt)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton4.setText("AJOUTER");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        fr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "COMPTE" }));
        fr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                frMouseReleased(evt);
            }
        });
        fr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frActionPerformed(evt);
            }
        });

        mg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MAGASIN" }));
        mg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mgActionPerformed(evt);
            }
        });

        jDateChooser2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FILTRE OPTIONEL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        pl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "POINT PLACEMENT", "LISTE MATIERE ET PRODUIT FINI" }));
        pl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(pl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(pl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton7.setText("ANNULER");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        saving.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        saving.setText("VALIDER");
        saving.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saving.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savingActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("MOTIF");

        rfs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("COMT.");

        cmt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        qt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("QTE :");

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton6.setText("EDITION");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        reinitialiser.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        reinitialiser.setText("REINIT.");
        reinitialiser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reinitialiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reinitialiserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reinitialiser, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rfs, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(saving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mg, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fr, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(qt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saving, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rfs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(reinitialiser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addComponent(st, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
       
       Menu_Stock_Read msr = new Menu_Stock_Read() ;
                        msr.setOp(this.admin) ;
                        msr.setVisible(true) ;
                       
        
         /*
        EditStoctOld ed1 = new EditStoctOld() ;
        ed1.setVisible(true);
         */
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyPressed
        // TODO add your handling code here:
        
        
        
     
    }//GEN-LAST:event_descKeyPressed

    private void cbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbKeyPressed
        // TODO add your handling code here:
        
        
         
    }//GEN-LAST:event_cbKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        
      
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
            String dte1 = sdf.format(this.jDateChooser2.getDate()) ;
            this.date_expi = dte1 ;
            
        }catch(Exception e){
            
            this.date_expi = "2100-01-20";
         // JOptionPane.showMessageDialog(this, this.date_expi) ;
            
        }
        
            DateFormat datef = new SimpleDateFormat("yyyy-MM-dd") ;
            Calendar cal = Calendar.getInstance();
          try {
              cal.setTime(datef.parse(this.date_expi)) ;
          } catch (ParseException ex) {
              Logger.getLogger(Admin1.class.getName()).log(Level.SEVERE, null, ex);
          }
               cal.add(Calendar.DAY_OF_YEAR, -15) ;
        Date tomorrow = cal.getTime() ;
        this.date_expiMoins15 = datef.format(tomorrow) ;
        System.out.println(this.date_expiMoins15) ;
        
        
        
         
        if(jTable1.getSelectedRow() == -1 || this.mg.getSelectedItem().toString().equalsIgnoreCase("MAGASIN") || "".equalsIgnoreCase(this.cmt.getText().trim()) || "".equalsIgnoreCase(this.qt.getText().trim()) || this.departement == 0){
         
            JOptionPane.showMessageDialog(this, "PRICISER LES PARAMETRES !!!") ;
            
        }else{
            
            if(this.list_vy.contains(new String(this.desi))){
                JOptionPane.showMessageDialog(this, "LE PRODUIT EXIST !!!") ;
            }else{
                
             
                
                this.qte = Long.parseLong(this.qt.getText().trim()) ;
                
                if(this.oldStock >= this.qte && this.qte > 0){
                
                String datej ;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
                datej = sdf.format(new Date()) ;
                long mtt_detail = 0;
                int cb_four ;
                Random rx = new Random() ;
                cb_four = rx.nextInt() ;
                
                if(cb_four < 0){
                    cb_four = Math.abs(cb_four) ;
                }
                
            
                  
                  
                  if(this.unite_m.equalsIgnoreCase("oui")){
                    
                    double qt = 0.0 ;
                    qt = (this.qte / 1000.0) ;
                    double mt = 0.0 ;
                    long m = 0 ;
                    mt = (this.pv * qt) ;
                    m = Math.round(mt) ;
                    mtt_detail = m ;
                    this.adition += mtt_detail ;
                    
                }else{
                    
                     
                    double mt = 0.0 ;
                    long m = 0 ;
                    mt = (this.pv * this.qte) ;
                    m = (this.pv * this.qte) ;
                    mtt_detail = m ;
                    this.adition += mtt_detail ;
                    
                }
                
                String rfs = this.rfs.getText().trim().replaceAll("'", "''") ; // motif : 
                String cmt = this.cmt.getText().trim().replaceAll("'", "''") ;
                
                this.new_s = 0 ;
                long newStock = 0 ;
                     newStock = (this.oldStock - this.qte) ;
                     this.new_s = newStock ;
                     this.fourni = this.fr.getSelectedItem().toString().replaceAll("'", "''") ;
                     this.magasi = this.mg.getSelectedItem().toString().replaceAll("'", "''") ;
                     
                     DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                     
CompteFournisseur cpe = new CompteFournisseur(this.f, this.sf, this.unite_m, this.cbr, this.desi, this.pa, this.pv, newStock, datej, this.admin, this.idpro, this.qte, this.date_expi, this.date_expiMoins15, this.qte, this.fourni, this.magasi, cb_four, rfs, cmt, this.departement, this.etat, mtt_detail, this.ans, this.new_s, this.id_st) ;
                this.list_vy.add(new String(cpe.getDesi())) ;
                
      this.list_com.add(cpe) ;
      
      dtm.addRow(new Object[]{
        cpe.getDesi() , this.nf3.format(cpe.getQte()) , this.nf3.format(cpe.getPu()) , this.nf3.format(cpe.getMtt_detail())
      }) ;
                
                
                this.jTable1.getSelectionModel().clearSelection();
                this.fr.setEnabled(false);
                this.mg.setEnabled(false);
                this.rfs.setEnabled(false);
                this.cmt.setEnabled(false);
                this.qt.setText("") ;
                this.jDateChooser2.setDate(null) ;
                this.totau.setText(this.nf3.format(this.adition));
                this.saving.setEnabled(true);
                
                }else{
                    JOptionPane.showMessageDialog(null, "OPERATION IMPOSSIBLE LE STOCK EST : "+this.oldStock+" ET ZERO NON VALIDE POUR UNE SORTIE") ;
                }
                
            }  // end :
            
        
     
        } 
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        
         
    }//GEN-LAST:event_jTable2MouseClicked

    private void reinitialiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reinitialiserActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Pour la reinitialisation du stock selectionner dans le tableau à gauche") ;
        }else{
            
            
             if(JOptionPane.showConfirmDialog(null, "VOULEZ VOUS réinitialiser le stock de ce produit ?" , "AVERTISSEMENT" , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                // yes option :
                 
             
            
                 Connection conn = null ;
                 Statement stmt = null  ; 
       
              try{
            //STEP 2: Register JDBC driver
             Class.forName(JDBC_DRIVER);

           // STEP 3: Open a connection
          //  System.out.println("Connecting to database...");
      
       conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
     
         
      if(stmt.executeUpdate("UPDATE stock1 SET qteet ="+0+" , stock ="+0+" WHERE desi='"+this.desi.replaceAll("'", "''")+"' AND idpro = "+this.idpro) > 0){
          
                    this.dispo.setText("0") ;
          
             }
          
   // rs.close();
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
  
             }else{
                 //No option :
                 
                 
             }
             
             
        
        
        
        }    
        
    }//GEN-LAST:event_reinitialiserActionPerformed

    private void mgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mgActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
        
        /*
        
        cbr = "" ;
        desi = "" ;
        pa = 0 ;
        pv = 0 ;
        oldStock = 0 ;
        f = "" ;
        sf = "" ;
        
        cbr  = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString() ;
        desi = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() ;
        pa   = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()) ;
        pv   = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString()) ;
        
        
        
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
      
       sql= "SELECT * FROM stock1 WHERE desi = '"+this.desi.replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        this.oldStock = rs.getLong("stock") ;  
       
     }
     this.dispo.setText(String.valueOf(this.oldStock)) ;
     
     String sql1 ;
      
       sql1 = "SELECT f, sf FROM produits_f WHERE description = '"+this.desi.replaceAll("'", "''")+"'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1);
      
      
     while(rs1.next()){
        this.f = rs1.getString("f");
        this.sf = rs1.getString("sf");
       }
     
     String sql2 ;
      
       sql2 = "SELECT condition_livraison, conservation FROM matieres_p WHERE description = '"+this.desi.replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
     while(rs2.next()){ 
        this.f = rs2.getString("condition_livraison");
        this.sf = rs2.getString("conservation");
     }
     
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
   }
       
       */
               
               
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyTyped
        // TODO add your handling code here:
        
            servDesi = "" ;
            servQte = 0 ;
            servStock = 0 ;
           
            servDesi = jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString() ;
            servQte = Long.parseLong(jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString()) ;
            servStock = Long.parseLong(jTable2.getValueAt(this.jTable2.getSelectedRow(), 4).toString()) ;
          
        
    }//GEN-LAST:event_jTable2KeyTyped

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed
 
long idpro = 0 ;
 
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        if(this.mg.getSelectedItem().toString().equalsIgnoreCase(new String("MAGASIN"))){
            
            this.jTable1.getSelectionModel().clearSelection() ;
            
            JOptionPane.showMessageDialog(null, "PRECISER UN MAGASIN OU POINT PLACEMENT !!!") ;
            
        }else{
        
        cbr = "" ;
        desi = "" ;
        pa = 0 ;
        pv = 0 ;
        oldStock = 0 ;
        f = "" ;
        sf = "" ;
        this.idpro = 0 ;
        
        cbr  = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() ;
        desi = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString().replaceAll("'", "''") ;
        pa   = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString()) ;
        pv   = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString()) ;
        idpro   = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()) ;
        this.ans = 0 ;
        this.id_st = 0 ;
        
        
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
       
     
     String sql1 ;
      
       sql1 = "SELECT f, sf, unite_m FROM produits_f WHERE description = '"+this.desi.replaceAll("'", "''")+"'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
     while(rs1.next()){
        this.f = rs1.getString("f");
        this.sf = rs1.getString("sf");
        this.unite_m = rs1.getString("unite_m") ;
       }
     
     String sql2 ;
      
       sql2 = "SELECT condition_livraison, conservation, unite_mesure FROM matieres_p WHERE description = '"+this.desi.replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
     while(rs2.next()){ 
        this.f = rs2.getString("condition_livraison");
        this.sf = rs2.getString("conservation");
        this.unite_m = rs2.getString("unite_mesure") ;
     }
     
     if(stmt.executeUpdate("update stock1 set idpro = "+this.idpro+" where desi = '"+this.desi.replaceAll("'", "''")+"' limit 1" ) > 0 || stmt.executeUpdate("update stock1 set idpro = "+this.idpro+" where desi = '"+this.desi.replaceAll("'", "''")+"' limit 1" ) == 0  ){
          
     }
     
           String sql0 = null ;
           ResultSet rs0 = null ;
      
       sql0 = "SELECT * FROM stock1 WHERE desi = '"+this.desi.replaceAll("'", "''")+"' AND maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"'" ; // "SELECT * FROM stock1 WHERE desi = '"+this.desi.replaceAll("'", "''")+"' AND idpro = "+this.idpro ;
      
       rs0 = stmt.executeQuery(sql0);
      
      
     while(rs0.next()){
        
        this.ans = rs0.getLong("stock") ;  
        this.oldStock = rs0.getLong("stock") ;  
       
     }
     
       sql0 = "SELECT id,stock_dispo FROM stock_pl WHERE magasin = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND description = '"+this.desi.replaceAll("'", "''")+"'" ; // "SELECT * FROM stock1 WHERE desi = '"+this.desi.replaceAll("'", "''")+"' AND idpro = "+this.idpro ;
      
       rs0 = stmt.executeQuery(sql0);
      
      
     while(rs0.next()){
        
        this.id_st = rs0.getInt("id") ;
        this.ans = rs0.getLong("stock_dispo") ;
        this.oldStock = rs0.getLong("stock_dispo") ;  
       
     }
     
     
     
     
     this.dispo.setText(this.nf3.format(this.oldStock)) ;
     
     
     
     
      rs0.close();
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
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
        
             this.servDesi = "" ;
             
           
             this.servDesi = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString() ;
             
        
        
        
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void plActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plActionPerformed
        // TODO add your handling code here :

        String point = this.pl.getSelectedItem().toString().replaceAll("'", "''") ;

        if(point.equalsIgnoreCase("POINT PLACEMENT")){

        }else{

            DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
            dtm.setRowCount(0) ;

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

                //  DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;

                String sql = null ;
                ResultSet rs = null ;

                sql = "select description , prx_pm , produit , derive_pl.id as ref from stock_pl , derive_pl where stock_pl.magasin = '"+point+"' AND derive_pl.produit = "
                + "stock_pl.description order by description ASC" ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    dtm.addRow(new Object[]{
                        rs.getInt("ref") , "" , rs.getString("description") , rs.getLong("prx_pm") , rs.getLong("prx_pm")
                    });
                }

                //

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
        
        if(point.equalsIgnoreCase("LISTE MATIERE ET PRODUIT FINI")){
            
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
      
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                          dtm.setRowCount(0) ;
                          
         
      String sql ;
      
       sql= "SELECT * FROM matieres_p ORDER BY description ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
            
    // "ID", "CODE BARRE", "DESCRIPTION", "P.A", "P.V"
            
       rs.getLong("id") ,  rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") 
        
        }) ;
  
       
     }
     
     
       String sql2 ;
      
       sql2 = "SELECT * FROM produits_f ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
        
        dtm.addRow(new Object[]{
            
       //  "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getInt("id") , rs2.getString("code_barre") , rs2.getString("description") , rs2.getLong("libelle") 
         ,  rs2.getLong("pu")
         
        }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
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

    }//GEN-LAST:event_plActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable2.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(this, "SELECTIONNER LE PRODUIT A DROITE");
            
        }else{
            long mtt = 0 ;
            try{
                 mtt = Long.parseLong(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 3).toString().replaceAll("[^a-zA-Z0-9]", "")) ;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            this.adition = (this.adition - mtt) ;
            this.totau.setText(this.nf3.format(this.adition));
            
            this.list_vy.remove(this.jTable2.getSelectedRow()) ;
            this.list_com.remove(this.jTable2.getSelectedRow()) ;
            
            
            DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                              dtm.removeRow(this.jTable2.getSelectedRow()) ;
            
                              if(this.list_com.size() == 0){
                                  
                                this.fr.setEnabled(true);
                                this.fr.setSelectedItem(new String("COMPTE"));
                                  this.mg.setEnabled(true) ;
                                  this.mg.setSelectedItem(new String("MAGASIN"));
                                  this.rfs.setEnabled(true) ;
                                  this.rfs.setText("");
                                  this.cmt.setEnabled(true) ;
                                  this.cmt.setText("");
                                  this.qt.setText("") ;
                                  this.jDateChooser2.setDate(null) ;
                                  
                                  this.saving.setEnabled(false);
                                  
                              }else{
                                // TODO add your handling code here:
                                  
                                  
                              }
        
        }        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void savingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savingActionPerformed
        // TODO add your handling code here :
               
                this.saving.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
                
                 
                
                 this.bonList.removeAll(this.bonList) ;
                 
                 
        
                Integer cb_four ;
                Random rx = new Random() ;
                cb_four = rx.nextInt() ;
                
                if(cb_four < 0){
                    cb_four = Math.abs(cb_four) ;
                }
                
                 long num = 0 ;
                 
                 
                 
                 
                 
      if(this.stock_1.equalsIgnoreCase(this.mg.getSelectedItem().toString())){
        
           if(this.list_com.size() > 0){
             //
                 String q_s = "UPDATE stock1 SET stock = ? WHERE desi = ? AND maga = ?" ;
                 Connection conn = null ;
                 Statement stmt = null  ; 
                 PreparedStatement ps = null ;
       
              try{
            //STEP 2: Register JDBC driver
             Class.forName(JDBC_DRIVER);

           // STEP 3: Open a connection
          //  System.out.println("Connecting to database...");
      
       conn = DriverManager.getConnection(DB_URL,USER,PASS);
       conn.setAutoCommit(false);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      ps = conn.prepareStatement(q_s) ;
      
      
      //je crai ma requete
      
      String sql = null ;
      ResultSet rs = null ;
            
            for(int i = 0; i < this.list_com.size(); i++){
                
                // hasmap collector data instance :
                
                 HashMap<String, Object> m = new HashMap<>() ;
                   
                   m.put("description", this.list_com.get(i).getDesi()) ;
                   m.put("qte", nf3.format(this.list_com.get(i).getQte())) ;
                   m.put("pa", nf3.format(this.list_com.get(i).getPu())) ;
                   m.put("mtt", this.list_com.get(i).getMtt_detail()) ;
                              
                   
                              
                              this.bonList.add(m) ;
                
                
                // end hasmap :
                
                  
                
         //  update my stock please :
                
                
                              
                              
      int vy = 0 ;
      
       sql = "SELECT * FROM facture_fourni WHERE cb = "+cb_four ;
      
       rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
              vy = 1 ;
                 }
     
     
             
   
  if(stmt.executeUpdate("insert into stock2(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,admin,datec,type,idpro,op_ , ans , new_s) values('"
 +this.list_com.get(i).getF().replaceAll("'", "''")+"' , '"+this.list_com.get(i).getSf().replaceAll("'", "''")+"' , '"
 +this.list_com.get(i).getCbr()+"' , '"+this.list_com.get(i).getDesi().replaceAll("'", "''")+"' , "+this.list_com.get(i).getPa()+" , "
 +this.list_com.get(i).getPu()+" , "+0+" , "+this.list_com.get(i).getQte()+" , "
 +this.list_com.get(i).getNewStock()+" , '"+this.list_com.get(i).getFourni()+"' , '"
 +this.list_com.get(i).getMagasin().replaceAll("'", "''")+"' , '"+this.admin.replaceAll("'", "''")+"' , '"
 +this.list_com.get(i).getDatej()+"' , 'sortie' , "+this.list_com.get(i).getIdpro()+" , "+cb_four+" , "
   +this.list_com.get(i).getAns()+" , "+this.list_com.get(i).getNew_s()+")") == 1){
         
         // stmt.executeUpdate("UPDATE stock1 SET stock = "+this.list_com.get(i).getNewStock()+" WHERE desi = '"+this.list_com.get(i).getDesi().replaceAll("'", "''")+"' AND maga = '"+this.list_com.get(i).getMagasin().replaceAll("'", "''")+"' ") ;
         
         ps.setLong(1, this.list_com.get(i).getNewStock()) ;
         ps.setString(2, this.list_com.get(i).getDesi().replaceAll("'", "''")) ;
         ps.setString(3, this.list_com.get(i).getMagasin().replaceAll("'", "''")) ;
         
         ps.addBatch() ;
         
              
                   if(vy == 0){
              if(stmt.executeUpdate("insert into facture_fourni(cb,datej,ref_saisie,comt,fourni,mtt,op,etat) values("
                      +cb_four+", '"+this.list_com.get(i).getDatej()+"' , '"+this.list_com.get(i).getMagasin()+"' , '"
                      +this.list_com.get(i).getComt()+"' , "+this.list_com.get(i).getCompte_fourni()+" , "+this.adition+" , '"
                      +this.admin+"' , 'sortie' )") == 1){
                  if(stmt.executeUpdate("insert into detail_facture(cb_fact,description,qte,pa,mtt,etat) values("
                          +cb_four+" , '"+this.list_com.get(i).getDesi()+"' , "+this.list_com.get(i).getQte()+" , "
                          +this.list_com.get(i).getPu()+" , "+this.list_com.get(i).getMtt_detail()+" , 'sortie' )") == 1){
                                     // do some thing.
                      
                      
                                  }
                                  }
              
          }else if(vy == 1){
              if(stmt.executeUpdate("insert into detail_facture(cb_fact,description,qte,pa,mtt,etat) values("
                          +cb_four+" , '"+this.list_com.get(i).getDesi()+"' , "+this.list_com.get(i).getQte()+" , "
                          +this.list_com.get(i).getPu()+" , "+this.list_com.get(i).getMtt_detail()+" , 'sortie' )") == 1){
                                     // do some thing.
                      
                      
                                  }
              
          }
             
          }
  
   
     
          
      
    
            
   
            
        
                
                // end metier :
                
            } // end for our boucle for commande collection.
            
            
            ps.executeBatch() ;
            
             long id = 0 ;
             sql = "select id from facture_fourni where cb = "+cb_four ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                 id = rs.getLong("id") ;
             }
             
            
                  num = id  ;
      
              conn.commit();
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
     
      rs.close();
      stmt.close();
      conn.close();
      ps = null ;
      
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
            
            // end num :
            
            
            
            // Impression du bon JAVA :
              
            //  JOptionPane.showMessageDialog(this, "BON JAVA AS JASPERT REPORTING IREPORT :::: " ) ;
            
            try{
              
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Ticket_fournisseur.jrxml")) ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.bonList) ;
            
            Map<String, Object> para = new HashMap<>();
            
            para.put("t", "TICKET SORTIE DE STOCK, USAGE INTERNE") ;
            para.put("data", jrbean);
            para.put("op", "OP : "+this.admin) ;  // this.login
            para.put("cb", cb_four) ;
            para.put("num", "N° : "+String.valueOf(num)) ;
            para.put("four", "COMPTE : "+this.fr.getSelectedItem().toString());
            para.put("mag", "MAGASIN : "+this.mg.getSelectedItem().toString());
            para.put("rfs", "REF.FACTURE : "+this.rfs.getText()) ;
            para.put("cmt", "COMMENTAIRE : "+this.cmt.getText());
            para.put("total", "TOTAL MTT : "+nf3.format(this.adition)) ;
           
            
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
       
          // JasperViewer.viewReport(print, false) ;
            
           JasperPrintManager.printReport(print, false) ;
            
              
           //   
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
            
            
            this.list_com.removeAll(this.list_com) ;
            this.list_vy.removeAll(this.list_vy) ;
            
            
                                  if(this.list_com.size() == 0 && this.list_vy.size() == 0){
                                  
                                  this.fr.setEnabled(true);
                                  this.fr.setSelectedItem(new String("COMPTE"));
                                  this.mg.setEnabled(true) ;
                                  this.mg.setSelectedItem(new String("MAGASIN"));
                                  this.rfs.setEnabled(true) ;
                                  this.rfs.setText("");
                                  this.cmt.setEnabled(true) ;
                                  this.cmt.setText("");
                                  this.qt.setText("") ;
                                  this.jDateChooser2.setDate(null) ;
                                  this.adition = 0 ;
                                  this.totau.setText(String.valueOf(this.adition));
                                  
                                  this.saving.setEnabled(false);
                                  
                              }
                                  
                                  DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                                                    dtm.setRowCount(0) ;
                                  
                          //        JOptionPane.showMessageDialog(null, "JASPER REPORTING BON") ;
            
            
            
            
            
        } // end depot principal :
        
           
       }else if(this.stock_1.isEmpty() == false && this.stock_1.equalsIgnoreCase(this.mg.getSelectedItem().toString()) == false){
           
           // JOptionPane.showMessageDialog(null, "SORTIE PLACEMENT : DEPART") ;
           
           
           
           if(this.list_com.size() > 0){
             //
               
                 // String q_s = "UPDATE stock_pl SET stock_dispo = ? WHERE magasin = ? AND description = ?" ;
                ArrayList<Integer> error = new ArrayList<Integer>() ;
                                   error.add(Integer.parseInt(new String("0"))) ;
                
                String q_s = "UPDATE stock_pl SET stock_dispo = ? WHERE magasin = ? AND description = ?" ;
                
                
                 Connection conn = null ;
                 Statement stmt = null  ; 
                 PreparedStatement ps = null ;
                 
       
              try{
            //STEP 2: Register JDBC driver
             Class.forName(JDBC_DRIVER) ;

           // STEP 3: Open a connection
          //  System.out.println("Connecting to database...");
      
       conn = DriverManager.getConnection(DB_URL,USER,PASS) ;
       conn.setAutoCommit(false) ;
       

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      ps = conn.prepareStatement(q_s) ;
      
      //je crai ma requete
      
      String sql = null ;
      ResultSet rs = null ;
            
            for(int i = 0; i < this.list_com.size(); i++){
                
                long old_stock_depart = 0 ;
                   
                  long new_stock_depart = 0 ;
                
                // hasmap collector data instance :
                
                 HashMap<String, Object> m = new HashMap<>() ;
                   
                   m.put("description", this.list_com.get(i).getDesi()) ;
                   m.put("qte", nf3.format(this.list_com.get(i).getQte())) ;
                   m.put("pa", nf3.format(this.list_com.get(i).getPu())) ;
                   m.put("mtt", this.list_com.get(i).getMtt_detail()) ;
                              
                   
                              
                              this.bonList.add(m) ;
                              
                              
sql = "select stock_dispo from stock_pl where magasin = '"+this.list_com.get(i).getMagasin().replaceAll("'", "''")+"' and description = '"+this.list_com.get(i).getDesi().replaceAll("'", "''")+"'" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
           
              old_stock_depart = rs.getLong("stock_dispo") ;
             
          
               }
      
      if(old_stock_depart >= this.list_com.get(i).getQte()){
      
      
      new_stock_depart = (old_stock_depart - this.list_com.get(i).getQte()) ;
                
                
                // end hasmap :
                
                  
                
         //  update my stock please :
                
      int vy = 0 ;
      
       sql = "SELECT * FROM facture_fourni WHERE cb = "+cb_four ;
      
       rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
              vy = 1 ;
                 }
     
     
             long id = 0 ;
             sql = "select id from facture_fourni order by id desc limit 1" ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                 id = rs.getLong("id") ;
             }
             
            
                  num = (id + 1) ;
      
     
       ps.setLong(1, new_stock_depart) ;
       ps.setString(2, this.list_com.get(i).getMagasin()) ;
       ps.setString(3, this.list_com.get(i).getDesi()) ;
       
       ps.executeUpdate() ;
       
         
     
           
             int vy_pl ;
                 vy_pl = 0 ;
      
      
             sql = "select * from op_pl_f where cb = "+cb_four ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                vy_pl = 1 ;
             }
             
             if(vy_pl == 0){
                 
                 if(stmt.executeUpdate("insert into op_pl_f(cb,date1,date2,depart,arriver,perso,motif,etat,admin,comt) VALUES("
                  +cb_four+" , '"+this.list_com.get(i).getDatej()+"' , '"+this.list_com.get(i).getDatej()+"' , '"+this.list_com.get(i).getMagasin().replaceAll("'", "''")+"' , '"
          +new String("EXTERIEUR")+"' , 'ANONYME' , 'DEPART' , '"
                  +new String("FERMER")+"' , '"+this.admin.replaceAll("'", "''")+"' , '"+this.list_com.get(i).getComt().replaceAll("'", "''")+"' )") == 1){
                     
                                
                                        // debut :
                                       // detail stock placement     :
                                         
                                         
                                          if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,new_s) VALUES("
                  +cb_four+" , '"+this.list_com.get(i).getDatej()+"' , '"+this.list_com.get(i).getDesi().replaceAll("'", "''")+"' , "+this.list_com.get(i).getQte()+" , "
          + this.list_com.get(i).getPu()+" , "+this.list_com.get(i).getMtt_detail()+" , '"+this.list_com.get(i).getMagasin().replaceAll("'", "''")+"' , "
          + this.list_com.get(i).getQte()+" , 'EXTERIEUR' , "+this.list_com.get(i).getQte()+" , "+0+" , '"
          + new String("ANONYME")+"' , 'DEPART' , '"
          + this.admin.replaceAll("'", "''")+"' , "
          +old_stock_depart+" , "+new_stock_depart+")" ) == 1 ){
                 
                                              
                                         
                                         
   if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +cb_four+" , '"+this.list_com.get(i).getDatej()+"' , '"+this.list_com.get(i).getDesi().replaceAll("'", "''")+"' , "+this.list_com.get(i).getQte()+" , "
          + this.list_com.get(i).getPu()+" , "+this.list_com.get(i).getMtt_detail()+" , '"+this.list_com.get(i).getMagasin().replaceAll("'", "''")+"' , "
          + this.list_com.get(i).getQte()+" , 'EXTERIEUR' , "+this.list_com.get(i).getQte()+" , '"
          + new String("ANONYME")+"' , 'DEPART' , "
          + 0 +" , 'FERMER' , '"+this.admin.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                // fournisseur :
                                                  
                          if(vy == 0){
              if(stmt.executeUpdate("insert into facture_fourni(cb,datej,ref_saisie,comt,fourni,mtt,op,etat) values("
                      +cb_four+", '"+this.list_com.get(i).getDatej()+"' , '"+this.list_com.get(i).getMagasin()+"' , '"
                      +this.list_com.get(i).getComt()+"' , "+this.list_com.get(i).getCompte_fourni()+" , "+this.adition+" , '"
                      +this.admin+"' , 'sortie')") == 1){
                  if(stmt.executeUpdate("insert into detail_facture(cb_fact,description,qte,pa,mtt,etat) values("
                          +cb_four+" , '"+this.list_com.get(i).getDesi()+"' , "+this.list_com.get(i).getQte()+" , "
                          +this.list_com.get(i).getPu()+" , "+this.list_com.get(i).getMtt_detail()+" , '"
                          +new String("sortie")+"')") == 1){
                                     // do some thing.
                      
                      
                                  }
                                  }
              
          }else if(vy == 1){
              if(stmt.executeUpdate("insert into detail_facture(cb_fact,description,qte,pa,mtt,etat) values("
                          +cb_four+" , '"+this.list_com.get(i).getDesi()+"' , "+this.list_com.get(i).getQte()+" , "
                          +this.list_com.get(i).getPu()+" , "+this.list_com.get(i).getMtt_detail()+" , '"
                          +new String("sortie")+"')") == 1){
                                     // do some thing.
                      
                      
                                  }
              
          }
                                       
                                                  
              // end fournisseur :                                    
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
            }
                                         
                                         
                                  
                                     
                                     
                                     
                             
                                 
                                 // end :
                                 
                                 
                     
                     
                                } // end op_pl_f :
             
             
             }else if(vy_pl == 1){   // partie 1
                 
                 if(stmt.executeUpdate("insert into stock_detail_pl(cb_op,datej,description,qte,prx_pm,mtt,depart,ndep,arriver,nariv,nderive,perso,type_op,admin,ans,new_s) VALUES("
                  +cb_four+" , '"+this.list_com.get(i).getDatej()+"' , '"+this.list_com.get(i).getDesi().replaceAll("'", "''")+"' , "+this.list_com.get(i).getQte()+" , "
          + this.list_com.get(i).getPu()+" , "+this.list_com.get(i).getMtt_detail()+" , '"+this.list_com.get(i).getMagasin().replaceAll("'", "''")+"' , "
          + this.list_com.get(i).getQte()+" , 'EXTERIEUR' , "+this.list_com.get(i).getQte()+" , "+0+" , '"
          + new String("ANONYME")+"' , 'DEPART' , '"
          + this.admin.replaceAll("'", "''")+"' , "
          +old_stock_depart+" , "+new_stock_depart+")" ) == 1 ){
                 
                                            
                                            
                                              if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +cb_four+" , '"+this.list_com.get(i).getDatej()+"' , '"+this.list_com.get(i).getDesi().replaceAll("'", "''")+"' , "+this.list_com.get(i).getQte()+" , "
          + this.list_com.get(i).getPu()+" , "+this.list_com.get(i).getMtt_detail()+" , '"+this.list_com.get(i).getMagasin().replaceAll("'", "''")+"' , "
          + this.list_com.get(i).getQte()+" , 'EXTERIEUR' , "+this.list_com.get(i).getQte()+" , '"
          + new String("ANONYME")+"' , 'DEPART' , "
          + 0 +" , 'FERMER' , '"+this.admin.replaceAll("'", "''")+"' )" ) == 1 ){
                 
                 // if detail_pl is incerted :
                 
                // fournisseur :
                                                  
                          if(vy == 0){
              if(stmt.executeUpdate("insert into facture_fourni(cb,datej,ref_saisie,comt,fourni,mtt,op,etat) values("
                      +cb_four+", '"+this.list_com.get(i).getDatej()+"' , '"+this.list_com.get(i).getMagasin()+"' , '"
                      +this.list_com.get(i).getComt()+"' , "+this.list_com.get(i).getCompte_fourni()+" , "+this.adition+" , '"
                      +this.admin+"' , 'sortie')") == 1){
                  if(stmt.executeUpdate("insert into detail_facture(cb_fact,description,qte,pa,mtt,etat) values("
                          +cb_four+" , '"+this.list_com.get(i).getDesi()+"' , "+this.list_com.get(i).getQte()+" , "
                          +this.list_com.get(i).getPu()+" , "+this.list_com.get(i).getMtt_detail()+" , '"
                          +new String("sortie")+"')") == 1){
                                     // do some thing.
                      
                      
                                  }
                                  }
              
          }else if(vy == 1){
              if(stmt.executeUpdate("insert into detail_facture(cb_fact,description,qte,pa,mtt,etat) values("
                          +cb_four+" , '"+this.list_com.get(i).getDesi()+"' , "+this.list_com.get(i).getQte()+" , "
                          +this.list_com.get(i).getPu()+" , "+this.list_com.get(i).getMtt_detail()+" , '"
                          +new String("sortie")+"')") == 1){
                                     // do some thing.
                      
                      
                                  }
              
          }
                                       
                                                  
              // end fournisseur :                                    
                 
                 
                 
                 
             }
                                              
                                       // fin detail_pl :       
                                              
                                         
                                         
            }
                                         
                                         
                                  
                                     
                                     
                                     
                             
                                 
                                 // end :
                                 
                                 
                     
                 
                 
             }
              
                  
             
       //   } // end stock2 inserted :
             
             
              
     error.add(Integer.parseInt(new String("0"))) ;
            
     
            }else{
                    
          error.add(Integer.parseInt(new String("1"))) ;
          JOptionPane.showMessageDialog(null, "ERREUR");
                
                    
                  }
        
                
                // end metier :
                
            } // end for our boucle for commande collection.
            
             
            
            
             // num :
            
                
     
             long id = 0 ;
             sql = "select id from op_pl_f where cb = "+cb_four ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                 id = rs.getLong("id") ;
             }
             
            
                  num = id  ;
                  
                  
               try{
              
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Ticket_fournisseur.jrxml")) ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.bonList) ;
            
            Map<String, Object> para = new HashMap<>();
            
            para.put("t", "TICKET SORTIE DE STOCK, USAGE INTERNE") ;
            para.put("data", jrbean);
            para.put("op", "OP : "+this.admin) ;  // this.login
            para.put("cb", cb_four) ;
            para.put("num", "N° : "+String.valueOf(num)) ;
            para.put("four", "COMPTE : "+this.fr.getSelectedItem().toString());
            para.put("mag", "MAGASIN : "+this.mg.getSelectedItem().toString());
            para.put("rfs", "REF.FACTURE : "+this.rfs.getText()) ;
            para.put("cmt", "COMMENTAIRE : "+this.cmt.getText());
            para.put("total", "TOTAL MTT : "+nf3.format(this.adition)) ;
           
            
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
       
        //   JasperViewer.viewReport(print, false) ;
            
          JasperPrintManager.printReport(print, false) ;
           error.add(Integer.parseInt(new String("0"))) ;
            
              
           //   
            }catch(Exception e){
                error.add(Integer.parseInt(new String("1"))) ;
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
            
            
            this.list_com.removeAll(this.list_com) ;
            this.list_vy.removeAll(this.list_vy) ;
            
            
                                  if(this.list_com.size() == 0 && this.list_vy.size() == 0){
                                  
                                  this.fr.setEnabled(true);
                                  this.fr.setSelectedItem(new String("COMPTE"));
                                  this.mg.setEnabled(true) ;
                                  this.mg.setSelectedItem(new String("MAGASIN"));
                                  this.rfs.setEnabled(true) ;
                                  this.rfs.setText("");
                                  this.cmt.setEnabled(true) ;
                                  this.cmt.setText("");
                                  this.qt.setText("") ;
                                  this.jDateChooser2.setDate(null) ;
                                  this.adition = 0 ;
                                  this.totau.setText(String.valueOf(this.adition));
                                  
                                  this.saving.setEnabled(false);
                                  
                              }
                                  
                                  DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                                                    dtm.setRowCount(0) ;
                                  
                          //        JOptionPane.showMessageDialog(null, "JASPER REPORTING BON") ;
            
            
            
               
                  
      if(error.contains(Integer.parseInt(new String("1")))){
          
          conn.rollback();
          
      }else if(error.contains(Integer.parseInt(new String("1"))) == false){
     
            conn.commit();
            
      }
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
            
      rs.close() ;
      stmt.close() ;
      conn.close() ;
      ps = null ;
      
      
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
            
            // end num :
            
            
            
            // Impression du bon JAVA :
              
            //  JOptionPane.showMessageDialog(this, "BON JAVA AS JASPERT REPORTING IREPORT :::: " ) ;
            
            
            
        } // end depot principal :
        
           
           
           
       }else if(this.stock_1.isEmpty()){
           
           
            JOptionPane.showMessageDialog(null, "ADMIN DOIT DESIGNER UN MAGASIN PRINCIPAL PAR DEFAUT !!! ") ;
           
       }
        
     
       
       this.saving.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
       
       
        StockFinal1 cptes = new StockFinal1(this.role) ;
        
        cptes.setAdmin(this.admin) ;
                
        
        cptes.setVisible(true) ;
        
        this.setVisible(false) ;
        
    }//GEN-LAST:event_savingActionPerformed

    private void cbKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbKeyReleased
        // TODO add your handling code here:
        
        String n1 = this.cb.getText().trim().replaceAll("'", "''") ;
        
        
        if("".equalsIgnoreCase(n1)){
        
          //  JOptionPane jp=new JOptionPane() ;
         //   jp.showMessageDialog(null,"selectionner une matière primaire svp","Avertissement",JOptionPane.WARNING_MESSAGE);
  
        
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
      
      
      
      clear1() ;
      
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
        sql= "SELECT * FROM matieres_p WHERE code_barre LIKE '%"+n1+"%' ORDER BY description" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
   // "ref.Mt", "Code Barre", "Description", "Prix Achat / Unité", "Prix de vente / Unité"
            
       rs.getLong("id") ,  rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") 
                
        }) ;
               
           
        
         
     
        
     }
     
     
     
     
      String sql2 ;
      
       sql2 = "SELECT * FROM produits_f WHERE code_barre = '"+n1+"' ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
        dtm.addRow(new Object[]{
            
         //   "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getInt("id") , rs2.getString("code_barre") , rs2.getString("description") , rs2.getLong("libelle") 
         ,  rs2.getLong("pu") 
         
                
        }) ;
                      
     
     }
     
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
   }  
 }
      
        
    }//GEN-LAST:event_cbKeyReleased

    private void descKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyReleased
        // TODO add your handling code here:
        
         
        String n1 = this.desc.getText().replaceAll("'", "''") ;
        
        
        if("".equalsIgnoreCase(n1)){
        
         //   JOptionPane jp=new JOptionPane() ;
        //   jp.showMessageDialog(null,"selectionner une matière primaire svp","Avertissement",JOptionPane.WARNING_MESSAGE);
  
        
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
      
      
      
      clear1() ;
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
        sql= "SELECT * FROM matieres_p WHERE description LIKE '%"+n1+"%' ORDER BY description" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
       while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
    // "CODE BARRE", "DESCRIPTION", "P.A", "P.V"
            
       rs.getLong("id") , rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") 
          
        });
               
           
        
         
     
        
     }
       
       
       
       
         String sql2 ;
      
       sql2 = "SELECT * FROM produits_f WHERE description LIKE '%"+n1+"%' ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
         dtm.addRow(new Object[]{
            
           // "ref.produit", "Code Barre", "Description", "Prix Achat", "Prix vente"
            
          rs2.getInt("id") , rs2.getString("code_barre") , rs2.getString("description") , rs2.getLong("libelle") 
         , rs2.getLong("pu") 
         
                
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
   }
 }
        
        
    }//GEN-LAST:event_descKeyReleased

    private void frActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frActionPerformed
        // TODO add your handling code here:
        
        
        
        /*
        this.compte_fourni = 0 ;
        
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
         
       String sql ;
      
       sql= "SELECT id FROM fournisseurs WHERE entreprise = '"+this.fr.getSelectedItem().toString().replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
         
         this.compte_fourni = rs.getInt("id") ;  
           
     }
      
    
     
     // JOptionPane.showMessageDialog(this, "fournisseur id : "+this.compte_fourni) ;
    
            
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
        
       */
        
        
        
        
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
      
      this.departement = 0 ;
        
         
      String sql ;
      
       sql = "SELECT id FROM departements where description = '"+this.fr.getSelectedItem().toString().replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
         this.departement = rs.getInt("id") ;
     
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
     
        
    }//GEN-LAST:event_frActionPerformed

    private void frMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frMouseReleased
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_frMouseReleased

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
            java.util.logging.Logger.getLogger(StockFinal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockFinal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockFinal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockFinal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockFinal1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cb;
    private javax.swing.JTextField cmt;
    private javax.swing.JTextField desc;
    private javax.swing.JTextField dispo;
    private javax.swing.JLabel dt;
    private javax.swing.JComboBox fr;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox mg;
    private javax.swing.JComboBox pl;
    private javax.swing.JTextField qt;
    private javax.swing.JButton reinitialiser;
    private javax.swing.JTextField rfs;
    private javax.swing.JButton saving;
    private javax.swing.JPanel st;
    private javax.swing.JLabel totau;
    // End of variables declaration//GEN-END:variables
}
