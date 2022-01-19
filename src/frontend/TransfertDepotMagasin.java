/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend ;

import entity.ActiviteT;
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
import java.sql.ResultSet ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.text.DateFormat ;
import java.text.ParseException;
import java.text.SimpleDateFormat ;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date ;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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


public class TransfertDepotMagasin extends javax.swing.JFrame {

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
      String fourni = "" ;
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
      
    
    public TransfertDepotMagasin() {
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
    
    
     public TransfertDepotMagasin(String role) {
        initComponents() ;
        this.role = role ;
        
        
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
      
       sql4 = "SELECT * FROM magasins ORDER BY magasin" ;
      
       ResultSet rs4 = stmt.executeQuery(sql4) ;
      
      
     while(rs4.next()){
        
     
      
        
      this.mg.addItem(rs4.getString("magasin")) ; 
       
     }
     
     
     sql = "select placement from point_pl where type = 'oui' order by placement ASC" ;
                 ResultSet rs20 = stmt.executeQuery(sql) ;
                 
                 while(rs20.next()){
                 
                  this.pl.addItem(rs20.getString("placement")) ;
                  
                  
               
       }
      
    
       if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR") || this.role.equalsIgnoreCase("ADMINISTRATEUR")){
                      
                      
                      
                  }else{
             
                          this.jButton6.setEnabled(false) ;
           
          
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
        jLabel13 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        fr = new javax.swing.JComboBox();
        mg = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        pl = new javax.swing.JComboBox();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        qt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DE STOCK DES ARTICLES :");

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
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(18);
            jTable1.getColumnModel().getColumn(2).setMinWidth(210);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(210);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(3);
        }

        cb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbKeyPressed(evt);
            }
        });

        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descKeyPressed(evt);
            }
        });

        dispo.setEditable(false);

        jLabel3.setText("STOCK DISPONIBLE");

        jLabel4.setText("CODE BARRE ");

        jLabel5.setText("DESCRIPTION");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("NOS ARTICLES :");

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );

        st.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPTION", "QTE ENTREE", "P.A", "MONTANT"
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
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(3);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(3);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(3);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("RENTREE DE STOCK DES ARTICLES");

        jLabel8.setText("BAMAKO le ,");

        dt.setText("jLabel9");

        jLabel10.setText("TOTAL :");

        jLabel13.setText("jLabel13");

        javax.swing.GroupLayout stLayout = new javax.swing.GroupLayout(st);
        st.setLayout(stLayout);
        stLayout.setHorizontalGroup(
            stLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stLayout.createSequentialGroup()
                .addGroup(stLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                    .addGroup(stLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(stLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(stLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(stLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(8, 8, 8)))))
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
                .addComponent(jLabel13)
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
        fr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MAGASIN DEPART" }));
        fr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MAGASIN ARRIVER" }));
        mg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mgActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("NON SUPPRIMER");

        jDateChooser2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FILTRE OPTIONEL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        pl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "POINT PLACEMENT" }));
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
            .addComponent(pl, javax.swing.GroupLayout.Alignment.TRAILING, 0, 240, Short.MAX_VALUE)
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

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton8.setText("VALIDER");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "IMPRIMER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton6.setText("EDITION");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton5.setText("RETRAIT");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        qt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("QTE :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fr, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(mg, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(qt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(494, 494, 494)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fr, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mg, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(8, 8, 8)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        EditStoctOld ed1 = new EditStoctOld() ;
        ed1.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyPressed
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
            
       rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") , rs.getLong("id")
          
        });
               
           
        
         
     
        
     }
       
       
       
       
         String sql2 ;
      
       sql2 = "SELECT * FROM produits_f WHERE description LIKE '%"+n1+"%' ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
         dtm.addRow(new Object[]{
            
           // "ref.produit", "Code Barre", "Description", "Prix Achat", "Prix vente"
            
           rs2.getString("code_barre") , rs2.getString("description") , rs2.getLong("libelle") 
         , rs2.getLong("pu") , rs2.getInt("id")
         
                
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
     
    }//GEN-LAST:event_descKeyPressed

    private void cbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbKeyPressed
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
            
       rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") , rs.getLong("id")
                
        }) ;
               
           
        
         
     
        
     }
     
     
     
     
      String sql2 ;
      
       sql2 = "SELECT * FROM produits_f WHERE code_barre = '"+n1+"' ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
        dtm.addRow(new Object[]{
            
         //   "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getString("code_barre") , rs2.getString("description") , rs2.getLong("libelle") 
         ,  rs2.getLong("pu") , rs2.getInt("id")
         
                
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
      
    }//GEN-LAST:event_cbKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        
      
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
            String dte1 = sdf.format(this.jDateChooser2.getDate()) ;
            this.date_expi = dte1;
            
        }catch(Exception e){
            
            this.date_expi = "2100-01-20";
         // JOptionPane.showMessageDialog(this, this.date_expi) ;
            
        }
        
            DateFormat datef = new SimpleDateFormat("yyyy-MM-dd") ;
        Calendar cal = Calendar.getInstance();
          try {
              cal.setTime(datef.parse(this.date_expi));
          } catch (ParseException ex) {
              Logger.getLogger(Admin1.class.getName()).log(Level.SEVERE, null, ex);
          }
               cal.add(Calendar.DAY_OF_YEAR, -15) ;
        Date tomorrow = cal.getTime();
        this.date_expiMoins15 = datef.format(tomorrow) ;
        System.out.println(this.date_expiMoins15);
        
        
        
         
        if(jTable1.getSelectedRow() == -1){
         
            JOptionPane.showMessageDialog(this, "Selectionner un article dans le tableau svp !!!") ;
            
        }else{
        
        qte = 0 ;
        long newStock = 0 ;
        fourni = "" ;
        magasi = "" ;
        unite_m = "";
        
        fourni = fr.getSelectedItem().toString() ;
        magasi = this.mg.getSelectedItem().toString() ;
        String Q = this.qt.getText().trim() ;
        
        if("FOURNISSEUR".equalsIgnoreCase(fourni) || "MAGASIN".equalsIgnoreCase(magasi) || "".equalsIgnoreCase(Q)){
            JOptionPane.showMessageDialog(this, "Selectionner un fournisseur , un magasin et la quantité de stock svp !!!") ;
        }else{
            
            try{
                this.qte = Long.parseLong(Q) ;
                newStock = (this.oldStock + this.qte) ;
                
                 SessionFactory sf=new Configuration().configure().buildSessionFactory();
                 Session s=sf.openSession();
            
          
         List entreprise = s.createSQLQuery("SELECT * FROM stock1 WHERE desi = '"+this.desi.replaceAll("'", "''")+"' AND idpro = "+this.idpro).list();
       
         
               // verification if qery is ok
            
            if(entreprise.size() == 1){
                
         //  update my stock please :
                
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
      
      String sql1 ;
      
       sql1 = "SELECT unite_mesure FROM matieres_p WHERE description = '"+this.desi+"' AND prx_a_unite = "+pa+" " ;
      
       ResultSet rs1 = stmt.executeQuery(sql1);
      
      
     while(rs1.next()){
       unite_m = rs1.getString("unite_mesure");
     }
     
     String sql2 ;
      
       sql2 = "SELECT unite_m FROM produits_f WHERE description = '"+this.desi+"' AND libelle = "+pa+" " ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
     while(rs2.next()){
       unite_m = rs2.getString("unite_m");
     }
      
      DefaultTableModel dtm2 = (DefaultTableModel) jTable2.getModel() ;
         
      if(stmt.executeUpdate("UPDATE stock1 SET cb = '"+this.cbr.replaceAll("'", "''")+"' , pa ="+this.pa+" , pv ="+this.pv+" , qteet ="+this.qte+" , stock ="+newStock+" , four ='"+this.fourni.replaceAll("'", "''")+"' , maga ='"+this.magasi.replaceAll("'", "''")+"' , datec ='"+this.dc+"' , admin ='"+this.admin.replaceAll("'", "''")+"' , date_expi = '"+this.date_expi+"' , date_expiMoins15 = '"+this.date_expiMoins15+"', unite_m = '"+unite_m+"' WHERE desi ='"+this.desi.replaceAll("'", "''")+"' AND idpro = "+this.idpro) > 0){
          
          if(stmt.executeUpdate("INSERT INTO stock2(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('"+this.f.replaceAll("'", "''")+"' , '"+this.sf.replaceAll("'", "''")+"' , '"+this.cbr.replaceAll("'", "''")+"' , '"+this.desi.replaceAll("'", "''")+"' , "+this.pa+" , "+this.pv+" , "+this.qte+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.fourni.replaceAll("'", "''")+"' , '"+this.magasi.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')") > 0){
          
              //  "DESCRIPTION", "QTE ENTREE", "P.A", "P.V", "NEW STOCK"
              
                     dtm2.addRow(new Object[]{
        this.desi , this.qte  , this.pa , this.pv , newStock 
        
        }) ;
          
                     this.qt.setText("") ;
          
             }
          
          
      }
      
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
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
   }//end try
   }else{
       
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
      
         
      DefaultTableModel dtm2 = (DefaultTableModel) jTable2.getModel() ;
      
      String[] st1 = {
          "INSERT INTO stock1(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin,date_expi,date_expiMoins15) VALUES('"+this.f.replaceAll("'", "''")+"' , '"+this.sf.replaceAll("'", "''")+"' , cb = '"+this.cbr+"' , desi='"+this.desi.replaceAll("'", "''")+"' , pa ="+this.pa+" , pv ="+this.pv+" , qteet ="+this.qte+" , qtest ="+Long.parseLong("0")+" , stock ="+newStock+" , four ='"+this.fourni.replaceAll("'", "''")+"' , maga ='"+this.magasi.replaceAll("'", "''")+"' , datec ='"+this.dc+"' , admin ='"+this.admin.replaceAll("'", "''")+"', '"+this.date_expi+"', '"+this.date_expiMoins15+"')" ,
          "INSERT INTO stock2(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('"+this.f.replaceAll("'", "''")+"' , '"+this.sf.replaceAll("'", "''")+"' , cb = '"+this.cbr+"' , desi='"+this.desi.replaceAll("'", "''")+"' , pa ="+this.pa+" , pv ="+this.pv+" , qteet ="+this.qte+" , qtest ="+Long.parseLong("0")+" , stock ="+newStock+" , four ='"+this.fourni.replaceAll("'", "''")+"' , maga ='"+this.magasi.replaceAll("'", "''")+"' , datec ='"+this.dc+"' , admin ='"+this.admin.replaceAll("'", "''")+"')" 
       } ;
      
      String sql ;
      
       sql= "SELECT unite_mesure FROM matieres_p WHERE description = '"+this.desi+"' AND prx_a_unite = "+pa+" " ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
     while(rs.next()){
       unite_m = rs.getString("unite_mesure");
     }
     
     String sql3 ;
      
       sql3 = "SELECT unite_m FROM produits_f WHERE description = '"+this.desi+"' AND libelle = "+pa+" " ;
      
       ResultSet rs3 = stmt.executeQuery(sql3);
      
      
     while(rs3.next()){
       unite_m = rs3.getString("unite_m");
     }
     
         
         if(stmt.executeUpdate("INSERT INTO stock1(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin,date_expi,date_expiMoins15,unite_m,idpro) VALUES('"+this.f.replaceAll("'", "''")+"' , '"+this.sf.replaceAll("'", "''")+"' , '"+this.cbr.replaceAll("'", "''")+"' , '"+this.desi.replaceAll("'", "''")+"' , "+this.pa+" , "+this.pv+" , "+this.qte+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.fourni.replaceAll("'", "''")+"' , '"+this.magasi.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"', '"+this.date_expi+"', '"+this.date_expiMoins15+"', '"+unite_m+"' , "+this.idpro+" )") > 0){
           if(stmt.executeUpdate("INSERT INTO stock2(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,datec,admin) VALUES('"+this.f.replaceAll("'", "''")+"' , '"+this.sf.replaceAll("'", "''")+"' , '"+this.cbr.replaceAll("'", "''")+"' , '"+this.desi.replaceAll("'", "''")+"' , "+this.pa+" , "+this.pv+" , "+this.qte+" , "+Long.parseLong("0")+" , "+newStock+" , '"+this.fourni.replaceAll("'", "''")+"' , '"+this.magasi.replaceAll("'", "''")+"' , '"+this.dc+"' , '"+this.admin.replaceAll("'", "''")+"')" ) > 0){
          
          // "DESCRIPTION", "QTE ENTREE", "P.A", "P.V", "NEW STOCK"
              
                     dtm2.addRow(new Object[]{
              this.desi , this.qte  , this.pa , this.pv , newStock 
        
        }) ;
          
                      this.qt.setText("") ;
          
           }
    
        
         }
      
      //STEP 6: Clean-up environment
    //  rs.close();
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
               
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "La qantité en chiffre uniquement") ;
            }    
            
        }
        
        } 
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        if(jTable2.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(this, "Selectionner dans le tableau de stock provisoir s'il vous plait") ;
            
        }else{
            
             long oldS = 0 ;
             oldS = (servStock - servQte) ;
           
             
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
      
      DefaultTableModel dtm2 = (DefaultTableModel) jTable2.getModel() ;
         
      if(stmt.executeUpdate("UPDATE stock1 SET qteet ="+0+" , stock ="+oldS+" WHERE desi='"+this.servDesi.replaceAll("'", "''")+"' AND idpro = "+this.idpro) > 0){
          
          if(stmt.executeUpdate("DELETE FROM stock2 WHERE desi='"+this.servDesi.replaceAll("'", "''")+"' AND admin ='"+this.admin.replaceAll("'", "''")+"'") > 0){
          
              // "DESCRIPTION", "QTE ENTREE", "P.A", "P.V", "NEW STOCK"
               
                 dtm2.removeRow(this.jTable2.getSelectedRow()) ;
     
             }
         
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
 }
      
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        
         
    }//GEN-LAST:event_jTable2MouseClicked

    private void mgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mgActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
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
        
        
        cbr = "" ;
        desi = "" ;
        pa = 0 ;
        pv = 0 ;
        oldStock = 0 ;
        f = "" ;
        sf = "" ;
        this.idpro = 0 ;
        
        cbr  = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString() ;
        desi = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() ;
        pa   = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()) ;
        pv   = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString()) ;
        idpro   = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString()) ;
        
        
        
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
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
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
     
     if(stmt.executeUpdate("update stock1 set idpro = "+this.idpro+" where desi = '"+this.desi.replaceAll("'", "''")+"' limit 1" ) > 0 || stmt.executeUpdate("update stock1 set idpro = "+this.idpro+" where desi = '"+this.desi.replaceAll("'", "''")+"' limit 1" ) == 0  ){
           String sql0 ;
      
       sql0 = "SELECT * FROM stock1 WHERE desi = '"+this.desi.replaceAll("'", "''")+"' AND idpro = "+this.idpro ;
      
       ResultSet rs0 = stmt.executeQuery(sql0);
      
      
     while(rs0.next()){
        
        this.oldStock = rs0.getLong("stock") ;  
       
     }
     this.dispo.setText(String.valueOf(this.oldStock)) ;
     
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
        
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
        
            servDesi = "" ;
            servQte = 0 ;
            servStock = 0 ;
           
            servDesi = jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString() ;
            servQte = Long.parseLong(jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString()) ;
            servStock = Long.parseLong(jTable2.getValueAt(this.jTable2.getSelectedRow(), 4).toString()) ;
          
        
        
        
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void plActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plActionPerformed
        // TODO add your handling code here:

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
                        "" , rs.getString("description") , "0" , rs.getLong("prx_pm") , rs.getInt("ref")
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

    }//GEN-LAST:event_plActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(TransfertDepotMagasin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransfertDepotMagasin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransfertDepotMagasin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransfertDepotMagasin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransfertDepotMagasin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cb;
    private javax.swing.JTextField desc;
    private javax.swing.JTextField dispo;
    private javax.swing.JLabel dt;
    private javax.swing.JComboBox fr;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox mg;
    private javax.swing.JComboBox pl;
    private javax.swing.JTextField qt;
    private javax.swing.JPanel st;
    // End of variables declaration//GEN-END:variables
}
