/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

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
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.DefaultListModel;
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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HAMZA
 */
public class VenteArticles extends javax.swing.JFrame {

    /**
     * Creates new form VenteArticles
     */
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
      
      // vente des articles : Mes variables : debut :
      
      
      // facture :
      
      int n = 0 ;
      String cl = "" ;
      long montant = 0 ;
      long remise = 0 ;
      long mttr = 0 ;
      long reliqat = 0 ;
      String type = "d"  ;
      
      // fact : end :
      
      // detailfact :
      
      long qtev = 0 ;
      long pu = 0 ;
      long mtarti = 0 ;
      int reprise = 0 ;
      
      // detailfact : end :
      
      
      // cumulvente : debut :
      
      
           String f = "" ;
           String sf = "" ;
           long idpro = 0 ;
           long pa = 0 ;
           long mu = 0 ;
           long profil = 0 ;
      
      
      // end cumulvente : :
      
      
      String admin = "" ;
      String dc = "" ;
      String desi = "" ;
      long oldStock = 0 ;
      String rp = "" ;
      
      
      // client info :
      
      long plafonCl = 0 ;
      long detteCl = 0 ;
      private Integer type_c = 0 ;
      
      
      // vente article :
      
      String desiv = "" ;
      long qtv = 0 ;
      long montV = 0 ;
      
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
      DefaultListModel dlm = new DefaultListModel() ;
      
      String stock_1 = new String("") ;
      
  // vente des produits : Mes variables end :
    
    
    public VenteArticles() {
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
         DateFormat datef = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
         Date date = new Date() ;
         this.dc = datef.format(date) ;
         
         //
       
         this.jTable1.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable1.getTableHeader().setOpaque(false) ; 
            this.jTable1.getTableHeader().setBackground(Color.black) ; 
          
        //    this.jTable1.setBackground(Color.white) ;
        
       
            this.jTable1.getTableHeader().setForeground(Color.white) ;
        
              this.jTable1.setRowHeight(25) ;
              
        
             DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() ;
             
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
        
        
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm.setRowCount(0) ;
        
       
       
         
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
      
          
         dlm.clear() ;
         
      String sql ;
      
       sql= "SELECT * FROM matieres_p ORDER BY description" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
            
    // "Code Barre", "Description", "Prix Achat / Unité", "Prix de vente / Unité"
            
       rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") 
        
        }) ;
  
       
     }
     
     
       String sql2 ;
      
       sql2 = "SELECT * FROM produits_f ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
        
        dtm.addRow(new Object[]{
            
       //  "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getString("code_barre") , rs2.getString("description") , rs2.getLong("libelle") 
         ,  rs2.getLong("pu")
         
        }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
      
     
     
     
       String sql4 ;
      
       sql4 = "SELECT * FROM clients ORDER BY entreprise" ;
      
       ResultSet rs4 = stmt.executeQuery(sql4) ;
      
      
          while(rs4.next()){
        
              dlm.addElement(rs4.getString("entreprise")) ;
       
           }
      
    this.jList1.setModel(dlm) ;
    
    
    String qery = null ;
    ResultSet rs_ = null ;
    qery = "select magasin from magasins where etat = 'oui' limit 1" ;
    rs_ = stmt.executeQuery(qery) ;
    while(rs_.next()){
        this.stock_1 = rs_.getString("magasin") ;
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
        
             
             
             //
       
         this.jTable2.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable2.getTableHeader().setOpaque(false); 
            this.jTable2.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable2.getTableHeader().setForeground(Color.white) ;
        
              this.jTable2.setRowHeight(25) ;
              
        
          

                  for (int i = 0; i < this.jTable2.getModel().getColumnCount(); i++){
                    this.jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
        
        
        
        //  ---------  2è choix
              
        
        
        
        
       //   ---------------
        
        
        //
        
       
        
     
        
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable2.getModel() ;
        
       
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm1.setRowCount(0) ;
        
       
       
        
        
        
        
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
        cb = new javax.swing.JTextField();
        desc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dispo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        nf = new javax.swing.JLabel();
        dtf = new javax.swing.JLabel();
        mf = new javax.swing.JLabel();
        uf = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        clf = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        qt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        client = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VENTE DES ARTICLES ");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel3.setText("CODE BARRE ");

        jLabel4.setText("DESCRIPTION");

        jLabel5.setText("NOS  PRODUITS  FINIS  ET LES MATIERES PREMIERES :");

        jLabel6.setText("DISPONIBLE EN STOCK :");

        dispo.setEditable(false);

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE BARRE", "DESCRIPTION", "P.A", "P.V / P.U"
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(desc)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dispo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dispo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("FACTURE CLIENT :");

        nf.setText("Transaction N°  :");

        dtf.setText("Date :");

        mf.setText("Montant :");

        uf.setText("Utilisateur :");

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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable2KeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(200);
        }

        clf.setText("Client :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nf, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(dtf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clf)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("QUANTITE");

        qt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        qt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton2.setText("AJOUTER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("CLIENTS :");

        client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientActionPerformed(evt);
            }
        });
        client.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clientKeyPressed(evt);
            }
        });

        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jList1MouseReleased(evt);
            }
        });
        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jList1KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel8.setText("LES CLIENTS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(client)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton3.setText("ANNULER");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton4.setText("VALIDER");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(395, 395, 395))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton2)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(88, 88, 88))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(88, 88, 88)
                                        .addComponent(qt, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(129, 129, 129)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(8, 8, 8)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 464, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))))
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
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") 
                
        }) ;
               
           
        
         
     
        
     }
     
     
     
     
      String sql2 ;
      
       sql2 = "SELECT * FROM produits_f WHERE code_barre = '"+n1+"' ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
        dtm.addRow(new Object[]{
            
         //   "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getString("code_barre") , rs2.getString("description") , rs2.getLong("libelle") 
         ,  rs2.getLong("pu")
         
                
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
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_cbKeyPressed

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
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") 
          
        });
               
           
        
         
     
        
     }
       
       
       
       
         String sql2 ;
      
       sql2 = "SELECT * FROM produits_f WHERE description LIKE '%"+n1+"%' ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
         dtm.addRow(new Object[]{
            
           // "ref.produit", "Code Barre", "Description", "Prix Achat", "Prix vente"
            
           rs2.getString("code_barre") , rs2.getString("description") , rs2.getLong("libelle") 
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
   }//end try
        
       
     
     // Fin configure :
     
        
        
        //
        
        
        
        
        
        }
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_descKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
      
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void clientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clientKeyPressed
        // TODO add your handling code here:
        
          String n1 = this.client.getText().replaceAll("'", "''").trim() ;
        
        
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
      
      
      
          this.dlm.clear() ;
      
      
         
         
        String sql ;
      
         sql= "SELECT * FROM clients WHERE entreprise LIKE '%"+n1+"%' ORDER BY entreprise" ;
      
         ResultSet rs = stmt.executeQuery(sql) ;
      
      
       while(rs.next()){
      
        dlm.addElement(rs.getString("entreprise")) ;
        
                  }
        
       this.jList1.setModel(dlm) ;
    
          
  
    
            
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
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_clientKeyPressed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
                
        
        
        String qt1 = this.qt.getText().trim() ;
        
          DateFormat datef = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
             Date date = new Date() ;
             
             String dc = datef.format(date) ;
             
        
        if(this.jTable1.getSelectedRow() == -1 || this.jList1.getSelectedIndex() == -1 || "".equalsIgnoreCase(qt1)){
            JOptionPane.showMessageDialog(this, "Selectionner un produit avec la quantité prise et un client pour une transaction svp : ");
        }else{
            try{
                
                Long qt2 = Long.parseLong(qt1) ;
                long mtrans = 0 ;
                long newStock = 0 ;
                double prof = 0 ;
                
        
                // debut cl info :
                
                
                 // info cl :
            
                this.plafonCl = 0 ;
                this.detteCl = 0 ;
        
        
                
                    Connection conn = null ;
                    Statement stmt = null  ; 
       
                try{
            // STEP 2: Register JDBC driver
              Class.forName(JDBC_DRIVER);

                  //  STEP 3: Open a connection
                 // System.out.println("Connecting to database...");
      
                conn = DriverManager.getConnection(DB_URL,USER,PASS);

                 // STEP 4: Execute a query
                //System.out.println("Creating statement...");
                     stmt = conn.createStatement();
      
                            //je crai ma requete
      
         
         
                           String sql ;
      
       sql= "SELECT * FROM clients WHERE entreprise = '"+this.cl.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        this.plafonCl = rs.getLong("plafon_credit") ;  
        
        System.out.println("this.plafonCl : "+" "+this.plafonCl) ;
       
     }
     
     
        
      
       
       String sql2 ;
      
       sql2 = "SELECT mttr FROM facturef WHERE cl = '"+this.cl.replaceAll("'", "''")+"' AND type = 'd' " ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
        this.detteCl += rs2.getLong("mttr") ;  
        
        System.out.println("this.detteCl : "+" "+this.detteCl) ;
       
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
        
        
        
                
              //  end cl info :
               
                
                
                
                if(this.oldStock >= qt2 && qt2 > 0){
                    
                    if("oui".equalsIgnoreCase(this.rp)){
                        
                        double qt3 = (qt2 / 1000.0) ;
                        double mt = (this.pu * qt3) ;
                               mtrans = Math.round(mt) ;
                        this.montant += Math.round(mt) ;
                        this.detteCl += this.montant ;
                        
                        this.mf.setText("Montant :"+" "+String.valueOf(nf3.format(this.montant))) ;
                    //  this.mu = (this.pu - this.pa) ;
                             prof = (this.mu * qt3) ;
                        this.profil = Math.round(prof) ;
                             newStock = (this.oldStock - qt2) ;
                        
                             
                             // hibernat for save control :
                             
                                
                                   SessionFactory sf=new Configuration().configure().buildSessionFactory();
                                   Session s=sf.openSession();

                  List fact = s.createSQLQuery("SELECT * FROM facturef WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"'").list();
    
     //           List article = s.createSQLQuery("SELECT * FROM detailfact WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"' AND desi = '"+this.desi.replaceAll("'", "''")+"'").list() ;
    //            List cumulvente = s.createSQLQuery("SELECT * FROM cumulvente WHERE desi = '"+this.desi.replaceAll("'", "''")+"' AND n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"'").list() ;       
     
                  
                    //  verification if qery is ok
            
                  if(fact.size() == 1){
                
                      
                      //
                      
                      
                              
                      if(this.plafonCl >= this.detteCl){
                          
                            //  debut ::
                          
                                Connection conn1 = null ;
                                Statement  stmt1 = null  ; 
       
                                  try{
                             // STEP 2: Register JDBC driver
                           Class.forName(JDBC_DRIVER);

                  //  STEP 3: Open a connection
                 // System.out.println("Connecting to database...");
      
                conn1 = DriverManager.getConnection(DB_URL,USER,PASS);

                 // STEP 4: Execute a query
                //System.out.println("Creating statement...");
                     stmt1 = conn1.createStatement();
      
                            //je crai ma requete
      
         
                   
                         
                              if(stmt1.executeUpdate("INSERT INTO detailfact(n,cl,desi,qte,pu,montant,reprise) VALUES("+this.n+" , '"+this.cl.replaceAll("'", "''")+"' , '"+this.desi.replaceAll("'", "''")+"' , "+qt2+" , "+this.pu+" ,  "+mtrans+", 0 )") == 1){
                         
                                    clear2() ;
                                  
                                    DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                                    
                                    
                                    
                                           String sql ;
      
                                      sql = "SELECT * FROM detailfact WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"'" ;
      
                                      ResultSet rs = stmt1.executeQuery(sql) ;
      
      
                                                      while(rs.next()){
         
                                                  dtm.addRow(new Object[]{
            
                                         // "DESCRIPTION", "QTE", "P.U", "MONTANT"
            
                                         rs.getString("desi") , rs.getLong("qte")  ,
                                         rs.getLong("pu") , nf3.format(rs.getLong("montant"))
        
                                                    }) ;
  
       
                                                    }
     
                                    
                                    
                                    if(stmt1.executeUpdate("INSERT INTO cumulvente(f,sf,idpro,desi,qte,pa,pv,mu,profil,admin,n,cl,periode) VALUES('"+this.f.replaceAll("'", "''")+"' , '"+this.sf.replaceAll("'", "''")+"' , "+this.idpro+" , '"+this.desi.replaceAll("'", "''")+"' , "+qt2+" , "+this.pa+" , "+this.pu+" , "+this.mu+" , "+this.profil+" , '"+this.admin.replaceAll("'", "''")+"' , "+this.n+" , '"+this.cl.replaceAll("'" , "''")+"' , '"+dc+"')") == 1){
                                         stmt1.executeUpdate("INSERT INTO cumul_v_mp(idpro,qte,dtec,type) values("+this.idpro+" , "+qt2+" , '"+this.dc+"' , "+this.type_c+")") ;
       
                                           
                                        
                                                                              
    if(stmt1.executeUpdate("UPDATE stock1 SET qtest ="+qt2+" , stock ="+newStock+" WHERE desi = '"+this.desi.replaceAll("'", "''")+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"'") > 0){
         // detail stock2 : 
         
  if(stmt.executeUpdate("insert into stock2(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,admin,datec,type,idpro) values('"
 +this.f.replaceAll("'", "''")+"' , '"+this.sf.replaceAll("'", "''")+"' , '"
 +" "+"' , '"+this.desi.replaceAll("'", "''")+"' , "+this.pa+" , "
 +this.pu+" , "+0+" , "+qt2+" , "
 +newStock+" , '"+"SIBY CENTER"+"' , '"
 +this.stock_1.replaceAll("'", "''")+"' , '"+this.admin.replaceAll("'", "''")+"' , '"
 +dc+"' , 'vente' , "+this.idpro+" )") == 1){
         
         // end :
          
                              
                                        
                                        
                                       
                                          this.qt.setText("") ;
                                          this.client.setEditable(false) ;
                                          this.jList1.setEnabled(false) ;
                        
                                        
          

            
                                      
            } // stock 2 end :
          
          
      }
                                        
                                        
       
                                        
                                        
                                        
                                    }
                                    
                         
                                                                 
                         
                                          }
                          
                         
                         
                         
                 
          
      
     
     
            
                 //STEP 6: Clean-up environment
      
                // System.out.println("Goodbye!");
      
   
       
              //STEP 6: Clean-up environment
    
               stmt1.close();
               conn1.close();
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt1!=null)
            stmt1.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn1!=null)
            conn1.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
        
       
     
     // Fin configure :
     
        
        
        //
        
        
                          
                          // end ::
                          
                          
                      }else{
                          JOptionPane.showMessageDialog(this, "Votre plafon de credit est atteint : votre dette est :"+this.detteCl +" et votre plafon est : "+this.plafonCl) ;
                      }
                      
                      
                      
                    
                      
                      
                      //
                      
                      
   
                  }else{
                      
                      if(this.plafonCl >= this.detteCl){
                          
                            //  debut ::
                          
                                Connection conn1 = null ;
                                Statement  stmt1 = null  ; 
       
                                  try{
                             // STEP 2: Register JDBC driver
                           Class.forName(JDBC_DRIVER);

                  //  STEP 3: Open a connection
                 // System.out.println("Connecting to database...");
      
                conn1 = DriverManager.getConnection(DB_URL,USER,PASS);

                 // STEP 4: Execute a query
                //System.out.println("Creating statement...");
                     stmt1 = conn1.createStatement();
      
                            //je crai ma requete
      
         
                     if(stmt1.executeUpdate("INSERT INTO facturef(n,cl,dtc,montant,util,remise,mttr,reliqat,type) VALUES("+this.n+" , '"+this.cl.replaceAll("'", "''")+"' , '"+dc+"' , 0 , '"+this.admin.replaceAll("'", "''")+"' , 0 , 0 , 0 , 'd')") == 1){
                         
                              if(stmt1.executeUpdate("INSERT INTO detailfact(n,cl,desi,qte,pu,montant,reprise) VALUES("+this.n+" , '"+this.cl.replaceAll("'", "''")+"' , '"+this.desi.replaceAll("'", "''")+"' , "+qt2+" , "+this.pu+" ,  "+mtrans+", 0 )") == 1){
                         
                                         clear2() ;    
                                  
                                    DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                                    
                                    
                                    
                                           String sql ;
      
                                      sql = "SELECT * FROM detailfact WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"'" ;
      
                                      ResultSet rs = stmt1.executeQuery(sql) ;
      
      
                                                      while(rs.next()){
         
                                                  dtm.addRow(new Object[]{
            
                                         // "DESCRIPTION", "QTE", "P.U", "MONTANT"
            
                                         rs.getString("desi") , rs.getLong("qte")  ,
                                         rs.getLong("pu") , nf3.format(rs.getLong("montant"))
        
                                                    }) ;
  
       
                                                    }
     
                                    
                                    
                                    if(stmt1.executeUpdate("INSERT INTO cumulvente(f,sf,idpro,desi,qte,pa,pv,mu,profil,admin,n,cl,periode) VALUES('"+this.f.replaceAll("'", "''")+"' , '"+this.sf.replaceAll("'", "''")+"' , "+this.idpro+" , '"+this.desi.replaceAll("'", "''")+"' , "+qt2+" , "+this.pa+" , "+this.pu+" , "+this.mu+" , "+this.profil+" , '"+this.admin.replaceAll("'", "''")+"' , "+this.n+" , '"+this.cl.replaceAll("'" , "''")+"' , '"+dc+"')") == 1){
                                            stmt1.executeUpdate("INSERT INTO cumul_v_mp(idpro,qte,dtec,type) values("+this.idpro+" , "+qt2+" , '"+dc+"' , "+this.type_c+")") ;
                                        
                                                                              
    if(stmt1.executeUpdate("UPDATE stock1 SET qtest ="+qt2+" , stock ="+newStock+" WHERE desi ='"+this.desi.replaceAll("'", "''")+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"'") > 0){
          
           // detail stock2 : 
         
  if(stmt.executeUpdate("insert into stock2(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,admin,datec,type,idpro) values('"
 +this.f.replaceAll("'", "''")+"' , '"+this.sf.replaceAll("'", "''")+"' , '"
 +" "+"' , '"+this.desi.replaceAll("'", "''")+"' , "+this.pa+" , "
 +this.pu+" , "+0+" , "+qt2+" , "
 +newStock+" , '"+"SIBY CENTER"+"' , '"
 +this.stock_1.replaceAll("'", "''")+"' , '"+this.admin.replaceAll("'", "''")+"' , '"
 +dc+"' , 'vente' , "+this.idpro+" )") == 1){
         
         // end :
          
          

                              
                                        
                                        
                                           
                                          this.qt.setText("") ;
                                          this.client.setEditable(false) ;
                                          this.jList1.setEnabled(false) ;
                        
                                        
          

            
            }
          
          
      }
                                        
                                        
       
                                        
                                        
                                        
                                    }
                                    
                         
                                                                 
                         
                                          }
                          
                         
                         
                         
                     }
          
      
     
     
            
                 //STEP 6: Clean-up environment
      
                // System.out.println("Goodbye!");
      
   
       
              //STEP 6: Clean-up environment
    
               stmt1.close();
               conn1.close();
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt1!=null)
            stmt1.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn1!=null)
            conn1.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
        
       
     
     // Fin configure :
     
        
        
        //
        
        
                          
                          // end ::
                          
                          
                      }else{
                          JOptionPane.showMessageDialog(this, "Votre plafon de credit est atteint : votre dette est :"+this.detteCl +" et votre plafon est : "+this.plafonCl) ;
                      }
                      
                      
                      
                      
                      
                  }  
                             
                             // end :
                        
                        
                             
                        
                      
                        
                    }else{
                        
                        // sans la division par mille ::
                        
                               
                        long qt3 = qt2  ;
                        
                        double mt = (this.pu * qt3) ;
                               mtrans = Math.round(mt) ;
                        this.montant += Math.round(mt) ;
                        this.detteCl += this.montant ;
                        
                        this.mf.setText("Montant :"+" "+String.valueOf(nf3.format(this.montant))) ;
                    //  this.mu = (this.pu - this.pa) ;
                             prof = (this.mu * qt3) ;
                        this.profil = Math.round(prof) ;
                             newStock = (this.oldStock - qt2) ;
                        
                             
                             // hibernat for save control :
                             
                                
                                   SessionFactory sf=new Configuration().configure().buildSessionFactory();
                                   Session s=sf.openSession();

                  List fact = s.createSQLQuery("SELECT * FROM facturef WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"'").list();
    
     //           List article = s.createSQLQuery("SELECT * FROM detailfact WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"' AND desi = '"+this.desi.replaceAll("'", "''")+"'").list() ;
    //            List cumulvente = s.createSQLQuery("SELECT * FROM cumulvente WHERE desi = '"+this.desi.replaceAll("'", "''")+"' AND n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"'").list() ;       
     
                  
                    //  verification if qery is ok
            
                  if(fact.size() == 1){
                
                      
                      //
                      
                      
                              
                      if(this.plafonCl >= this.detteCl){
                          
                            //  debut ::
                          
                                Connection conn1 = null ;
                                Statement  stmt1 = null  ; 
       
                                  try{
                             // STEP 2: Register JDBC driver
                           Class.forName(JDBC_DRIVER);

                  //  STEP 3: Open a connection
                 // System.out.println("Connecting to database...");
      
                conn1 = DriverManager.getConnection(DB_URL,USER,PASS);

                 // STEP 4: Execute a query
                //System.out.println("Creating statement...");
                     stmt1 = conn1.createStatement();
      
                            //je crai ma requete
      
         
                   
                         
                              if(stmt1.executeUpdate("INSERT INTO detailfact(n,cl,desi,qte,pu,montant,reprise) VALUES("+this.n+" , '"+this.cl.replaceAll("'", "''")+"' , '"+this.desi.replaceAll("'", "''")+"' , "+qt2+" , "+this.pu+" ,  "+mtrans+", 0 )") == 1){
                         
                                         clear2() ;  
                                  
                                    DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                                    
                                    
                                    
                                           String sql ;
      
                                      sql = "SELECT * FROM detailfact WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"'" ;
      
                                      ResultSet rs = stmt1.executeQuery(sql) ;
      
      
                                                      while(rs.next()){
         
                                                  dtm.addRow(new Object[]{
            
                                         // "DESCRIPTION", "QTE", "P.U", "MONTANT"
            
                                         rs.getString("desi") , rs.getLong("qte")  ,
                                         rs.getLong("pu") , nf3.format(rs.getLong("montant"))
        
                                                    }) ;
  
       
                                                    }
     
                                    
                                    
               if(stmt1.executeUpdate("INSERT INTO cumulvente(f,sf,idpro,desi,qte,pa,pv,mu,profil,periode,admin,n,cl) VALUES('"+this.f.replaceAll("'", "''")+"' , '"+this.sf.replaceAll("'", "''")+"' , "+this.idpro+" , '"+this.desi.replaceAll("'", "''")+"' , "+qt2+" , "+this.pa+" , "+this.pu+" , "+this.mu+" , "+this.profil+" , '"+dc+"' , '"+this.admin.replaceAll("'", "''")+"' , "+this.n+" , '"+this.cl.replaceAll("'" , "''")+"')") == 1){
                        stmt1.executeUpdate("INSERT INTO cumul_v_mp(idpro,qte,dtec,type) values("+this.idpro+" , "+qt2+" , '"+this.dc+"' , "+this.type_c+")") ;                  
                                        
                                        // stock operation :
                                         
                                        
    if(stmt1.executeUpdate("UPDATE stock1 SET qtest ="+qt2+" , stock ="+newStock+" WHERE desi ='"+this.desi.replaceAll("'", "''")+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"'") > 0){
          
            // detail stock2 : 
         
  if(stmt.executeUpdate("insert into stock2(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,admin,datec,type,idpro) values('"
 +this.f.replaceAll("'", "''")+"' , '"+this.sf.replaceAll("'", "''")+"' , '"
 +" "+"' , '"+this.desi.replaceAll("'", "''")+"' , "+this.pa+" , "
 +this.pu+" , "+0+" , "+qt2+" , "
 +newStock+" , '"+"SIBY CENTER"+"' , '"
 +this.stock_1.replaceAll("'", "''")+"' , '"+this.admin.replaceAll("'", "''")+"' , '"
 +dc+"' , 'vente' , "+this.idpro+" )") == 1){
         
         // end :
          
          

                              
                                        
                                        
                                           
                                          this.qt.setText("") ;
                                          this.client.setEditable(false) ;
                                          this.jList1.setEnabled(false) ;
                        
                                        
          

            
            }
          
          
      }
                                        
                                        
                                        // end :
                                        
                                        
                                        
                                        
                                    }
                                    
                         
                                                                 
                         
                                          }
                          
                         
                         
                         
                 
          
      
     
     
            
                 //STEP 6: Clean-up environment
      
                // System.out.println("Goodbye!");
      
   
       
              //STEP 6: Clean-up environment
    
               stmt1.close();
               conn1.close();
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt1!=null)
            stmt1.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn1!=null)
            conn1.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
        
       
     
     // Fin configure :
     
        
        
        //
        
        
                          
                          // end ::
                          
                          
                      }else{
                          JOptionPane.showMessageDialog(this, "Votre plafon de credit est atteint : votre dette est :"+this.detteCl +" et votre plafon est : "+this.plafonCl) ;
                      }
                      
                      
                      
                    
                      
                      
                      //
                      
                      
   
                  }else{
                      
                      if(this.plafonCl >= this.detteCl){
                          
                            //  debut ::
                          
                                Connection conn1 = null ;
                                Statement  stmt1 = null  ; 
       
                                  try{
                             // STEP 2: Register JDBC driver
                           Class.forName(JDBC_DRIVER);

                  //  STEP 3: Open a connection
                 // System.out.println("Connecting to database...");
      
                conn1 = DriverManager.getConnection(DB_URL,USER,PASS);

                 // STEP 4: Execute a query
                //System.out.println("Creating statement...");
                     stmt1 = conn1.createStatement();
      
                            //je crai ma requete
      
         
                     if(stmt1.executeUpdate("INSERT INTO facturef(n,cl,dtc,montant,util,remise,mttr,reliqat,type) VALUES("+this.n+" , '"+this.cl.replaceAll("'", "''")+"' , '"+dc+"' , 0 , '"+this.admin.replaceAll("'", "''")+"' , 0 , 0 , 0 , 'd')") == 1){
                         
                              if(stmt1.executeUpdate("INSERT INTO detailfact(n,cl,desi,qte,pu,montant,reprise) VALUES("+this.n+" , '"+this.cl.replaceAll("'", "''")+"' , '"+this.desi.replaceAll("'", "''")+"' , "+qt2+" , "+this.pu+" ,  "+mtrans+", 0 )") == 1){
                         
                                        clear2() ;     
                                  
                                    DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                                    
                                    
                                    
                                           String sql ;
      
                                      sql = "SELECT * FROM detailfact WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"'" ;
      
                                      ResultSet rs = stmt1.executeQuery(sql) ;
      
      
                                                      while(rs.next()){
         
                                                  dtm.addRow(new Object[]{
            
                                         // "DESCRIPTION", "QTE", "P.U", "MONTANT"
            
                                         rs.getString("desi") , rs.getLong("qte")  ,
                                         rs.getLong("pu") , nf3.format(rs.getLong("montant"))
        
                                                    }) ;
  
       
                                                    }
     
                                    SimpleDateFormat dtef = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") ;
                                    
                                    if(stmt1.executeUpdate("INSERT INTO cumulvente(f,sf,idpro,desi,qte,pa,pv,mu,profil,admin,n,cl,periode) VALUES('"+this.f.replaceAll("'", "''")+"' , '"+this.sf.replaceAll("'", "''")+"' , "+this.idpro+" , '"+this.desi.replaceAll("'", "''")+"' , "+qt2+" , "+this.pa+" , "+this.pu+" , "+this.mu+" , "+this.profil+" , '"+this.admin.replaceAll("'", "''")+"' , "+this.n+" , '"+this.cl.replaceAll("'" , "''")+"' , '"+this.dc+"')") == 1){
                                                      stmt1.executeUpdate("INSERT INTO cumul_v_mp(idpro,qte,dtec,type) values("+this.idpro+" , "+qt2+" , '"+dtef.format(new Date())+"' , "+this.type_c+")") ;
                                                                              
    if(stmt1.executeUpdate("UPDATE stock1 SET qtest ="+qt2+" , stock ="+newStock+" WHERE desi ='"+this.desi.replaceAll("'", "''")+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"'") > 0){
          
           // detail stock2 : 
         
  if(stmt.executeUpdate("insert into stock2(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,admin,datec,type,idpro) values('"
 +this.f.replaceAll("'", "''")+"' , '"+this.sf.replaceAll("'", "''")+"' , '"
 +" "+"' , '"+this.desi.replaceAll("'", "''")+"' , "+this.pa+" , "
 +this.pu+" , "+0+" , "+qt2+" , "
 +newStock+" , '"+"SIBY CENTER"+"' , '"
 +this.stock_1.replaceAll("'", "''")+"' , '"+this.admin.replaceAll("'", "''")+"' , '"
 +dc+"' , 'vente' , "+this.idpro+" )") == 1){
         
         // end :
          
          

                              
                                        
                                        
                                           
                                          this.qt.setText("") ;
                                          this.client.setEditable(false) ;
                                          this.jList1.setEnabled(false) ;
                        
                                        
          

            
            }
          
          
      }
                                        
                                        
       
                                        
                                        
                                        
                                    }
                                    
                         
                                                                 
                         
                                          }
                          
                         
                         
                         
                     }
          
      
     
     
            
                 //STEP 6: Clean-up environment
      
                // System.out.println("Goodbye!");
      
   
       
              //STEP 6: Clean-up environment
    
               stmt1.close();
               conn1.close();
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt1!=null)
            stmt1.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn1!=null)
            conn1.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
        
       
     
     // Fin configure :
     
        
        
        //
        
        
                          
                          // end ::
                          
                          
                      }else{
                          JOptionPane.showMessageDialog(this, "Votre plafon de credit est atteint : votre dette est :"+this.detteCl +" et votre plafon est : "+this.plafonCl) ;
                      }
                      
                      
                      
                      
                      
                  }  
                             
                             // end :
                        
                        
                             
                        
                     
                        
                        
                    }
                      
                }else{
                    JOptionPane.showMessageDialog(this, "stock inssufisant et reste : "+this.oldStock) ;
                }
                
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "La qantité est en chiffre uniquement");
            }
            
            
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void qtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtActionPerformed

    private void clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
   
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
        if(this.jTable2.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selectionner une vente dans le tableau à droite svp : ");
        }else{
            
        long newStock = (this.oldStock + this.qtv) ;
        long mt = (this.montant - this.montV) ;
        this.montant = mt ;
        
        
        
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
      
          
         
       if(stmt.executeUpdate("DELETE FROM detailfact WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"' AND desi = '"+this.desiv+"'") > 0){
            if(stmt.executeUpdate("DELETE FROM cumulvente WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"' AND desi = '"+this.desiv+"'") > 0){

               if(stmt.executeUpdate("UPDATE stock1 SET stock = "+newStock+" WHERE desi = '"+this.desiv+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"'") >= 0){
                             
                                 clear2() ;
                                  
                                    DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                                    
                                    
                                    
                                           String sql ;
      
                                      sql = "SELECT * FROM detailfact WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"'" ;
      
                                      ResultSet rs = stmt.executeQuery(sql) ;
      
      
                                                      while(rs.next()){
         
                                                  dtm.addRow(new Object[]{
            
                                         // "DESCRIPTION", "QTE", "P.U", "MONTANT"
            
                                         rs.getString("desi") , rs.getLong("qte")  ,
                                         rs.getLong("pu") , nf3.format(rs.getLong("montant"))
        
                                                    }) ;
  
       
                                                    }
     
                                                      
                                             this.mf.setText("Montant :"+" "+String.valueOf(this.montant)) ;         
                                    
                            
           
           
                   }
            
            }
            
           
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
     
        
        
        //
     
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int n = model.getRowCount();
        if (n <= 0) {
            
            // D
            
              
                 Connection conn1 = null ;
                 Statement stmt1 = null  ; 
       
             try{
          //STEP 2: Register JDBC driver
         Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn1 = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt1 = conn1.createStatement();
      
      //je crai ma requete
      
          if(stmt1.executeUpdate("DELETE FROM facturef WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"'") == 1){
              
              
         
            this.qt.setText("") ;
            this.client.setEditable(true) ;
            this.jList1.setEnabled(true) ;
              
          }
     
      
      
     
    
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      
      stmt1.close();
      conn1.close();
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt1!=null)
            stmt1.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn1!=null)
            conn1.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
        
       
     
     // Fin configure :
     
        
            
            
            // F
            
            
        }
        
        
        
        
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        this.jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
        if(this.montant > 0){
            
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
      
          
         
   if(stmt.executeUpdate("UPDATE facturef SET montant = "+this.montant+" , mttr = "+this.montant+" , reliqat = "+this.montant+" , type = 'd' WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"'") == 1){
           
            // facture :
            
            
            // impression ireport ici :
     
      try{
          
          // n,cl,desi,qte,pu,montant,reprise   
          
          
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS); 
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY); 
            ResultSet resultat = statement.executeQuery("SELECT desi as desi, qte as qte, "
                    + "pu as pu, montant as montant FROM detailfact WHERE n = "+this.n+" AND cl = '"+this.cl+"'");
            
            
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\venteArticles.jrxml")) ;
            //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\venteArticles.jrxml")) ;
            
            long total = 0 ;
            
            
            List mlist;
            mlist = new ArrayList<>() ;
            
            while(resultat.next()){
                
                HashMap<String, Object> m = new HashMap<>() ; 
                m.put("desi", resultat.getString("desi")) ;
                m.put("qte", resultat.getInt("qte")) ;
                m.put("pu", resultat.getInt("pu")) ;
                m.put("montant", resultat.getInt("montant")) ;
                total += resultat.getInt("montant") ;
                m.put("total", total) ; 
                mlist.add(m) ;
                
            }
            
            
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("sql", jrbean);
            para.put("user", this.admin);
            para.put("nData", this.n);
            para.put("clientData", this.cl);
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
     //     JasperViewer.viewReport(print, false);
            JasperPrintManager.printReport(print, false) ;
            
       }catch(Exception e){
       
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       
       }
            
            
      
    //  this.n = 0 ;
      this.cl = "" ;
      this.montant = 0 ;
      this.remise = 0 ;
      this.mttr = 0 ;
      this.reliqat = 0 ;
      this.type = "d"  ;
      
      // fact : end :
      
       this.nf.setText("Transaction N°  :"+" "+String.valueOf(this.n + 1)) ;          
       this.dtf.setText("Date :"+" "+this.dc) ;
       this.mf.setText("Montant :"+" "+String.valueOf(this.montant)) ;
       this.uf.setText("Utilisateur :"+" "+this.admin) ;
       this.clf.setText("Client :"+" "+this.cl) ;
       
       
       
          
         this.qt.setText("") ;
         this.client.setEditable(true) ;
         this.client.setText("") ;
         this.jList1.setEnabled(true) ;
                        
       
         
         
       this.dlm.clear() ;
       
        String sql4 ;
      
       sql4 = "SELECT * FROM clients" ;
      
       ResultSet rs4 = stmt.executeQuery(sql4) ;
      
      
          while(rs4.next()){
        
              dlm.addElement(rs4.getString("entreprise")) ;
       
           }
      
        this.jList1.setModel(dlm) ;
        
        
         clear2() ;    
      
      
      //  JOptionPane.showMessageDialog(this, "Facture valider avec succès") ;
      
           
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
        
       
     
     
      
            
        }else{
            JOptionPane.showMessageDialog(this, "La facture est vide pour la validation") ;
        }
        
       this.jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ; 
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
          f = "" ;
            sf = "" ;
            idpro = 0 ;
            desi = "" ;
            pa = 0 ;
            pu = 0 ;
            mu = 0 ;
            oldStock = 0 ;
            this.rp = "" ;
                     
            
          
      
          desi = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() ;
          pa   = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()) ;
          pu   = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString()) ;
          this.mu = (this.pu - this.pa) ; 
        
        
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
       
 
      
    
     
       String sql01 ;
      
        sql01 = "SELECT * FROM matieres_p WHERE description = '"+this.desi.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs01 = stmt.executeQuery(sql01) ;
      
      
       while(rs01.next()){
 
     this.idpro = rs01.getLong("id") ;
     this.f =  rs01.getString("condition_livraison") ;
     this.sf = rs01.getString("conservation")  ;
     this.rp = rs01.getString("unite_mesure") ;
     
     System.out.println("matieres primaire :"+" "+"f = "+f+" sf = "+sf+" id = "+idpro+" "+"1 => 1000 : "+this.rp);
     
        
     }
       
       
       
       
         String sql2 ;
      
       sql2 = "SELECT * FROM produits_f WHERE description = '"+this.desi.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
       this.idpro = rs2.getLong("id") ;
       this.f =  rs2.getString("f") ;
       this.sf = rs2.getString("sf")  ;
       this.rp = rs2.getString("unite_m") ;
     
       System.out.println( "produits fini : "+" "+"f = "+f+" sf = "+sf+" id = "+idpro+" Rapport / 1000 : "+this.rp) ;
     
               
        
         
     
        
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
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyTyped
        // TODO add your handling code here:
             
  // vente article :
      
     this.desiv = "" ;
     this.qtv = 0 ;
     this.montV = 0 ;
     this.oldStock = 0 ;
      
     this.desiv = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString().replaceAll("'", "''") ;
     
     
     
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
      
       sql= "SELECT sum(qte) FROM detailfact WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"' AND desi = '"+this.desiv+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
    this.qtv = rs.getLong("sum(qte)") ;
    System.out.println("qtev = "+rs.getLong("sum(qte)")) ;
       
     }
     
     
       String sql2 ;
      
       sql2 = "SELECT sum(montant) FROM detailfact WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"' AND desi = '"+this.desiv+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
       while(rs2.next()){
        
    this.montV = rs2.getLong("sum(montant)") ;
    System.out.println("montv = "+rs2.getLong("sum(montant)")) ;
       
     }
      
          
      String sql3 ;
      
       sql3 = "SELECT * FROM stock1 WHERE desi = '"+this.desiv+"'" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3);
      
      
     while(rs3.next()){
        
        this.oldStock = rs3.getLong("stock") ;  
       
     }
     
   //  this.dispo.setText(String.valueOf(this.oldStock)) ;
       
     
    
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

    private void jList1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyTyped
        // TODO add your handling code here:
        
        try{
            this.cl = "" ;
            this.montant = 0 ;
            this.remise = 0 ;
            this.mttr = 0 ;
            this.reliqat = mttr ;
            this.type = "d" ;
            
            
      
            
            
            this.cl = this.jList1.getSelectedValue().toString() ;
            
            
            //  debut :
            
               Connection conn = null ;
               Statement stmt = null  ; 
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...") ;
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
         
         
       String sql ;
      
       sql= "SELECT count(*) FROM facturef" ;
      
       ResultSet rs = stmt.executeQuery(sql) ; 
      
      
      while(rs.next()){
        
        this.n = (rs.getInt(1) + 1) ;  
       
     }
 
      
    
     
       this.nf.setText("Transaction N°  :"+" "+String.valueOf(this.n)) ;          
       this.dtf.setText("Date :"+" "+this.dc) ;
       this.mf.setText("Montant :"+" "+String.valueOf(nf3.format(this.montant))) ;
       this.uf.setText("Utilisateur :"+" "+this.admin) ;
       this.clf.setText("Client :"+" "+this.cl) ;
     
     
            
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
        
        
        
        
        
            
          //   end :
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Selectionner un client svp") ;
        }
        
        
    }//GEN-LAST:event_jList1KeyTyped

    private void jList1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseReleased
        // TODO add your handling code here:
        
         try{
            this.cl = "" ;
            this.montant = 0 ;
            this.remise = 0 ;
            this.mttr = 0 ;
            this.reliqat = mttr ;
            this.type = "d" ;
            
            
      
            
            
            this.cl = this.jList1.getSelectedValue().toString() ;
            
            
            //  debut :
            
               Connection conn = null ;
               Statement stmt = null  ; 
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...") ;
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
         
         
       String sql ;
      
       sql= "SELECT count(*) FROM facturef" ;
      
       ResultSet rs = stmt.executeQuery(sql) ; 
      
      
      while(rs.next()){
        
        this.n = (rs.getInt(1) + 1) ;  
       
     }
 
      
    
     
       this.nf.setText("Transaction N°  :"+" "+String.valueOf(this.n)) ;          
       this.dtf.setText("Date :"+" "+this.dc) ;
       this.mf.setText("Montant :"+" "+String.valueOf(nf3.format(this.montant))) ;
       this.uf.setText("Utilisateur :"+" "+this.admin) ;
       this.clf.setText("Client :"+" "+this.cl) ;
     
     
            
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
        
        
        
        
        
            
          //   end :
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Selectionner un client svp") ;
        }
        
        
        
    }//GEN-LAST:event_jList1MouseReleased

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        if(this.stock_1.isEmpty()){
            JOptionPane.showMessageDialog(null, "ADMIN DOIT DECLARER UN MAGASIN PRINCIPAL PAR DEFAUT !!! ") ;
        }else{
          
            f = "" ;
            sf = "" ;
            idpro = 0 ;
            desi = "" ;
            pa = 0 ;
            pu = 0 ;
            mu = 0 ;
            oldStock = 0 ;
            this.rp = "" ;
                     
            
          
      
          desi = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() ;
          pa   = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()) ;
          pu   = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString()) ;
          this.mu = (this.pu - this.pa) ; 
          this.type_c = 0 ;
        
        
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
      
       sql= "SELECT * FROM stock1 WHERE desi = '"+this.desi.replaceAll("'", "''")+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        this.oldStock = rs.getLong("stock") ;  
       
     }
     
     this.dispo.setText(String.valueOf(this.oldStock)) ;
       
 
      
    
     
       String sql01 ;
      
        sql01 = "SELECT * FROM matieres_p WHERE description = '"+this.desi.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs01 = stmt.executeQuery(sql01) ;
      
      
       while(rs01.next()){
 
     this.idpro = rs01.getLong("id") ;
     this.f =  rs01.getString("condition_livraison") ;
     this.sf = rs01.getString("conservation")  ;
     this.rp = rs01.getString("unite_mesure") ;
     this.type_c = 1 ;
     
     System.out.println("matieres primaire :"+" "+"f = "+f+" sf = "+sf+" id = "+idpro+" "+"1 => 1000 : "+this.rp);
     
        
     }
       
       
       
       
         String sql2 ;
      
       sql2 = "SELECT * FROM produits_f WHERE description = '"+this.desi.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
       this.idpro = rs2.getLong("id") ;
       this.f =  rs2.getString("f") ;
       this.sf = rs2.getString("sf")  ;
       this.rp = rs2.getString("unite_m") ;
       this.type_c = 0 ;
       
       System.out.println( "produits fini : "+" "+"f = "+f+" sf = "+sf+" id = "+idpro+" Rapport / 1000 : "+this.rp) ;
     
               
        
         
     
        
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
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
        
             
        
  // vente article :
      
     this.desiv = "" ;
     this.qtv = 0 ;
     this.montV = 0 ;
     this.oldStock = 0 ;
      
     this.desiv = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString().replaceAll("'", "''") ;
     
     
     
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
      
       sql= "SELECT sum(qte) FROM detailfact WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"' AND desi = '"+this.desiv+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
    this.qtv = rs.getLong("sum(qte)") ;
    System.out.println("qtev = "+rs.getLong("sum(qte)")) ;
       
     }
     
     
       String sql2 ;
      
       sql2 = "SELECT sum(montant) FROM detailfact WHERE n = "+this.n+" AND cl = '"+this.cl.replaceAll("'", "''")+"' AND desi = '"+this.desiv+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
       while(rs2.next()){
        
    this.montV = rs2.getLong("sum(montant)") ;
    System.out.println("montv = "+rs2.getLong("sum(montant)")) ;
       
     }
      
          
      String sql3 ;
      
       sql3 = "SELECT * FROM stock1 WHERE desi = '"+this.desiv+"'" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3);
      
      
     while(rs3.next()){
        
        this.oldStock = rs3.getLong("stock") ;  
       
     }
     
   //  this.dispo.setText(String.valueOf(this.oldStock)) ;
       
     
    
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
            java.util.logging.Logger.getLogger(VenteArticles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VenteArticles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VenteArticles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VenteArticles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VenteArticles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cb;
    private javax.swing.JLabel clf;
    private javax.swing.JTextField client;
    private javax.swing.JTextField desc;
    private javax.swing.JTextField dispo;
    private javax.swing.JLabel dtf;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel mf;
    private javax.swing.JLabel nf;
    private javax.swing.JTextField qt;
    private javax.swing.JLabel uf;
    // End of variables declaration//GEN-END:variables
}
