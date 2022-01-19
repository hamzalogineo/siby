/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import entity.Factures;
import entity.MatiereProduitF;
import static frontend.Clients1.JDBC_DRIVER;
import static frontend.Lacaisse.JDBC_DRIVER;
import static frontend.UpdateTtMatPri.JDBC_DRIVER;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HAMZA
 */
public class VentProduitFini extends javax.swing.JFrame {

    /**
     * Creates new form VentProduitFini
     */
    
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
      String user_c ;
      String role ;
      String phone ;
      
      int idCl = 0 ;
      int indice = 0 ;
      
      // fact :
      


     String produitMatiere;
     Double prxUnite = 0.0 ;
     Double qteAchat = 0.0 ;
     Double montant = 0.0 ;
     Double remise = 0.0 ;
     Double recu = 0.0 ;
     Double reliquat = 0.0 ;
            String dette = "oui" ;
    static final String type = "vide" ; 
    
      
      // fact :
      
      
    double stockDMp = 0.0 ;
    double newStock = 0.0 ;
 // double stockDPf = 0.0 ;
    
    
// gestion client :
    
    double vPfCl = 0.0 ;
    double VmtFac = 0.0 ;
    
      DefaultListModel vente = new DefaultListModel() ;
      DefaultListModel fact = new DefaultListModel() ;
    
        public VentProduitFini() {
             initComponents();
             this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
             DateFormat datef = new SimpleDateFormat("dd/MM/yyyy") ;
             Date date = new Date() ;
             this.dte.setText(datef.format(date)) ;
        
        
         //
        
       Connection conn = null;
       Statement stmt = null;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

       // STEP 4: Execute a query
      //  System.out.println("Creating statement...");
          stmt = conn.createStatement();
      
   // je crai ma requete
         
      String sql ;
      
       sql= "SELECT * FROM clients " ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
       this.cl.addItem(rs.getString("entreprise")) ; 

       
     }
      
     
     
     String sql1 ;
      
       sql1= "SELECT * FROM stocks_produit_fini" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
     while(rs1.next()){
        
       this.vente.addElement(rs1.getString("produits_fini")); 

       
     }
      
     
      String sql2 ;
      
       sql2= "SELECT * FROM stocks_matiere_p" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
         while(rs2.next()){
        
         this.vente.addElement(rs2.getString("matieres_p")) ; 

       
     }
      
         
         jList1.setModel(vente) ;
         
    
     
      
    
            
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
        
        
        
        
        
         
      public String getUser_c() {
        return user_c;
    }

    public void setUser_c(String user_c) {
        this.user_c = user_c;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        dte = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        nb1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        aj1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        nb2 = new javax.swing.JTextField();
        r1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        rpm = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cdebarre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cl = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setText("FERMER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VENTE DES PRODUITS FINI AUX CLIENTS  :");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton5.setText("IMPRIMER FACT.");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel10.setText("DATE / MOIS");

        dte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dteActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton6.setText("PAYEMENT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton4.setText("LA CAISSE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dte)))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dte, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jList1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        nb1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setText("QUANTITE");

        aj1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        aj1.setText("AJOUTER");
        aj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aj1ActionPerformed(evt);
            }
        });

        jList2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jScrollPane2.setViewportView(jList2);

        jLabel3.setText("QUANTITE");

        nb2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        r1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        r1.setText("RETIRER");
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nb1)
                                .addComponent(aj1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                            .addComponent(nb2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nb1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aj1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nb2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("LE NOM DU PRODUIT FINI /  M.P");

        rpm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rpm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rpmKeyPressed(evt);
            }
        });

        jLabel7.setText("CODE BARRE DU PRODUIT FINI / M.P");

        cdebarre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cdebarre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cdebarreKeyPressed(evt);
            }
        });

        jLabel8.setText("RECH. PRODUIT FINI / MP");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rpm, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cdebarre, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cdebarre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        cl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR UN CLIENT" }));
        cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("LES PRODUITS ET M.P DISPONIBLE");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("LE COMPTE CLIENT / FACTURE CLIENT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(259, 259, 259))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(233, 233, 233)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(cl, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        
         Lacaisse e = new Lacaisse() ;
                  
           
                  e.setUser_c(this.user_c) ;
                  e.setRole(this.role) ;
                  e.setPhone(this.phone) ;
                  
        
                  e.setVisible(true) ;
                  
       
        this.setVisible(false) ;
        
      
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        String cliTest = this.cl.getSelectedItem().toString() ;
        
        if("CHOISIR UN CLIENT".equalsIgnoreCase(cliTest)){
            
            JOptionPane.showMessageDialog(this, "SELECTIONNER UN CLIENT POUR SES PAYEMENTS MERCI ") ;
            
        }else{
            
              FactureClient cptes = new FactureClient(this.idCl) ;
        
                  cptes.setUser_c(this.user_c);
                  cptes.setRole(this.role);
                  cptes.setPhone(this.phone);
        
             cptes.setVisible(true) ;
        
        
            
        }
        
      
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        EtatCaisse ec = new EtatCaisse() ;
        
                  ec.setUser_c(this.user_c);
                  ec.setRole(this.role);
                  ec.setPhone(this.phone);
        
        ec.setVisible(true) ;
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void dteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dteActionPerformed

    private void clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clActionPerformed
        // TODO add your handling code here:
        
         String act1 = this.cl.getSelectedItem().toString().replaceAll("'", "''") ;
        
        if("CHOISIR UN CLIENT".equalsIgnoreCase(act1)){
        
            JOptionPane jp=new JOptionPane() ;
            jp.showMessageDialog(null,"selectionner un client svp","Avertissement",JOptionPane.WARNING_MESSAGE);
  
        
        }else{
            
            
            
              //
            
         this.fact.clear() ;
         
        
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
      
       sql = "SELECT * FROM clients WHERE entreprise = '"+act1+"' LIMIT 1" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
       while(rs.next()){
        
            this.idCl = rs.getInt("id") ; 
            this.vPfCl = rs.getDouble("plafon_credit") ;
            this.VmtFac = 0.0 ;
     
     }
       
       
         String sql1 ;
      
       sql1 = "SELECT * FROM factures WHERE id_client = "+this.idCl+" AND dette = 'oui'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
       while(rs1.next()){
        
            this.fact.addElement(rs1.getString("produit_matiere")) ; 
     
     }
       
          
           jList2.setModel(this.fact) ;
    
            
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
        
        
        
        
        
    }//GEN-LAST:event_clActionPerformed

    private void rpmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rpmKeyPressed
        // TODO add your handling code here:
        
        String rpm1 = this.rpm.getText().trim() ;
        
        if("".equalsIgnoreCase(rpm1)){
            
            // vide :
            
        }else{
        
        //
        
            this.vente.clear() ;
            
          
       Connection conn = null;
       Statement stmt = null;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

       // STEP 4: Execute a query
      //  System.out.println("Creating statement...");
          stmt = conn.createStatement();
      
   // je crai ma requete
 
     
     String sql1 ;
      
       sql1= "SELECT * FROM stocks_produit_fini WHERE produits_fini LIKE '%"+rpm1.replaceAll("'", "''")+"%'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
     while(rs1.next()){
        
       this.vente.addElement(rs1.getString("produits_fini")); 

       
     }
      
     
      String sql2 ;
      
       sql2= "SELECT * FROM stocks_matiere_p WHERE matieres_p LIKE '%"+rpm1.replaceAll("'", "''")+"%'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
         while(rs2.next()){
        
         this.vente.addElement(rs2.getString("matieres_p")) ; 

       
     }
      
         
         jList1.setModel(vente) ;
         
    
     
      
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
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
        
          
        
    //
        
        }
        
    }//GEN-LAST:event_rpmKeyPressed

    private void cdebarreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cdebarreKeyPressed
        // TODO add your handling code here:
        
          String rpm1 = this.cdebarre.getText().trim() ;
        
        if("".equalsIgnoreCase(rpm1)){
            
            // vide :
            
        }else{
        
        //
        
            this.vente.clear() ;
            
          
       Connection conn = null;
       Statement stmt = null;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

       // STEP 4: Execute a query
      //  System.out.println("Creating statement...");
          stmt = conn.createStatement();
      
   // je crai ma requete
 
     
     String sql1 ;
      
       sql1= "SELECT * FROM stocks_produit_fini WHERE code_barre LIKE '%"+rpm1+"%' LIMIT 1" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
     while(rs1.next()){
        
       this.vente.addElement(rs1.getString("produits_fini")); 

       
     }
      
     
      String sql2 ;
      
       sql2= "SELECT * FROM stocks_matiere_p WHERE code_barre LIKE '%"+rpm1.replaceAll("'", "''")+"%' LIMIT 1" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
         while(rs2.next()){
        
         this.vente.addElement(rs2.getString("matieres_p")) ; 

       
     }
      
         
         jList1.setModel(vente) ;
         
    
     
      
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
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
        
          
        
    //
        
        }
        
        
    }//GEN-LAST:event_cdebarreKeyPressed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        
        
        try{
            
            String matiere = jList1.getSelectedValue().toString() ;
          
            
            
            
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
      
      //je crai ma requete
      
         
         
      String sql ;
      
       sql= "SELECT * FROM stocks_matiere_p WHERE matieres_p ='"+matiere.replaceAll("'", "''")+"' AND stock_dispo > 0.0 LIMIT 1" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
         this.stockDMp = rs.getDouble("stock_dispo") ;
         
         this.produitMatiere = rs.getString("matieres_p") ;
         this.prxUnite = rs.getDouble("pu_v") ;
         
         this.indice = 1 ;
        
         
         
      
//  System.out.println("info mtp"+":  "+ rs.getString("matieres_p")+" "+rs.getString("dateentree")+ " "+this.stockMp) ;
        
         
       
     }
      
     
     
         
      String sql2 ;
      
       sql2 = "SELECT * FROM stocks_produit_fini WHERE produits_fini ='"+matiere.replaceAll("'", "''")+"' AND stock_dispo > 0.0 LIMIT 1" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
         
         this.stockDMp = rs2.getDouble("stock_dispo") ;
         
         this.produitMatiere = rs2.getString("produits_fini") ;
         this.prxUnite = rs2.getDouble("pu_v") ;
        
         this.indice = 2 ;
         
      
//  System.out.println("info mtp"+":  "+ rs.getString("matieres_p")+" "+rs.getString("dateentree")+ " "+this.stockMp) ;
        
         
       
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
        
            
            
            
              
               
        }catch(Exception e){
            
             
             JOptionPane jp=new JOptionPane() ;
            jp.showMessageDialog(null,"Selectionner un article pour le client svp ","Avertissement",JOptionPane.WARNING_MESSAGE);
  
            
        }
        
     
        
        
        
        
    }//GEN-LAST:event_jList1MouseClicked

    private void aj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aj1ActionPerformed
        // TODO add your handling code here:
        
         String act1 = this.cl.getSelectedItem().toString().replaceAll("'", "''") ;
        
        if("CHOISIR UN CLIENT".equalsIgnoreCase(act1)){
        
            JOptionPane jp=new JOptionPane() ;
            jp.showMessageDialog(null,"selectionner un client svp","Avertissement",JOptionPane.WARNING_MESSAGE);
  
        
        }else{
            
            //
            
            
        
        
        String nb01 = this.nb1.getText().trim() ;
        if("".equalsIgnoreCase(nb01)){
            
            JOptionPane.showMessageDialog(this, "saisir la quantité de l'article demander svp") ;
            
        }else{
            
            try{
                this.qteAchat = Double.parseDouble(nb01) ;
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "la quantité est en chiffre uniquement ");
            }
            
            
            
            if(jList1.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(this, "selectionner un article svp");
            }else{
                 if(this.qteAchat > 0){
                     
                 
                if( this.stockDMp > this.qteAchat ){
                    
                    this.newStock = (this.stockDMp - this.qteAchat) ;
                    
                    if(this.indice == 1){
                        
                        
                        // debut :
                        
                             
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
      
      //je crai ma requete
      
       // verification du plafon client :
      
      this.montant = (this.prxUnite * this.qteAchat) ;
      
      String sql1 ;
      
       sql1 = "SELECT * FROM factures WHERE id_client = "+this.idCl+" AND dette = 'oui'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
       while(rs1.next()){
        
            this.VmtFac += rs1.getDouble("montant") ; 
     
     }
       
       double mfinal = (this.montant + this.VmtFac) ;
       
       if(mfinal <= this.vPfCl){
           
           // transaction can do :
           
           
             
           if(stmt.executeUpdate("UPDATE stocks_matiere_p SET stock_dispo ="+this.newStock+" WHERE matieres_p ='"+this.produitMatiere.replaceAll("'", "''")+"' AND stock_dispo > 0.0 LIMIT 1") == 1){
                  
                 // end :

                        //
                        
                             // debut ::
                        
                        String dc ;
                        DateFormat datef = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss") ;
                        Date dt = new Date() ;
                        dc = datef.format(dt) ;
            
                 SessionFactory sf=new Configuration().configure().buildSessionFactory();
                 Session s=sf.openSession();
            
                 Transaction tr = s.beginTransaction();
            
         Factures cu = new   Factures(this.idCl , this.produitMatiere, this.prxUnite, this.qteAchat, this.montant, this.remise, this.recu, this.montant, "oui", this.type, dc, dc.substring(3), dc.substring(6), this.user_c)  ;
         
               // verification if qery is ok
            
           
                           s.save(cu) ;
            
                           tr.commit() ;
                           s.close() ;
            
                           // cursor go to fetch  :
      
                           
                        //
                        
                           this.fact.addElement(this.produitMatiere) ;
               
               
                            jList2.setModel(fact) ;
                            this.nb1.setText("") ;
               
               
               
               
           }
    
     
      
    
                
           
           // end transaction :
           
       }else{
           
         
           
           JOptionPane.showMessageDialog(this, "Votre plafon credit est :"+this.vPfCl+" et votre dette + la transaction est :"+(this.VmtFac + this.montant)+" ALORS : transaction annulée") ;
           this.VmtFac = 0.0 ;
           
       }
       
      
      // end : verification ::
      
      
      
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
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
        
            
            
            
        }
        
                        
                        
                      
                        
                    
                    
                    if(this.indice == 2){
                        
                        // debut :
                        
                             
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
      
      //je crai ma requete
      
       this.montant = (this.prxUnite * this.qteAchat) ;
      
      
        String sql1 ;
      
       sql1 = "SELECT * FROM factures WHERE id_client = "+this.idCl+" AND dette = 'oui'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
       while(rs1.next()){
        
            this.VmtFac += rs1.getDouble("montant") ; 
     
     }
       
       double mfinal = (this.montant + this.VmtFac) ;
       
       if(mfinal <= this.vPfCl){
           
           // transaction can do :
           
           
            
      
      
      
      
           if(stmt.executeUpdate("UPDATE stocks_produit_fini SET stock_dispo ="+this.newStock+" WHERE produits_fini ='"+this.produitMatiere.replaceAll("'", "''")+"' AND stock_dispo > 0.0 LIMIT 1") == 1){
               
             
               
             
                 // end :
                             // debut ::
                        
                        String dc ;
                        DateFormat datef = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss") ;
                        Date dt = new Date() ;
                        dc = datef.format(dt) ;
            
                 SessionFactory sf=new Configuration().configure().buildSessionFactory();
                 Session s=sf.openSession();
            
                 Transaction tr = s.beginTransaction();
            
         Factures cu = new   Factures(this.idCl , this.produitMatiere, this.prxUnite, this.qteAchat, this.montant, this.remise, this.recu, this.montant, "oui", this.type, dc, dc.substring(3), dc.substring(6), this.user_c)  ;
         
               // verification if qery is ok
            
           
                           s.save(cu) ;
            
                           tr.commit() ;
                           s.close() ;
            
                           // cursor go to fetch  :
      
                           
                        //
                        
                           this.fact.addElement(this.produitMatiere) ;
               
               
                            jList2.setModel(fact) ;
                             this.nb1.setText("") ;
               
               
               
               
           }
    
     
      
  
       
         // end transaction :
           
       }else{
           
            
           
           JOptionPane.showMessageDialog(this, "Votre plafon credit est :"+this.vPfCl +" et votre dette + la transaction est :"+(this.VmtFac + this.montant)+" Alors : transaction annulée") ;
           this.VmtFac = 0.0 ;
        
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
        
       
     
     // Fin configure :
     
        
        
        //
        
            
                        
                    }
                    
                    
                    
                    
                }else{
                    JOptionPane.showMessageDialog(this, "le stock disponible est insuffisant et reste : "+this.stockDMp );
                }
            }else{
                     JOptionPane.showMessageDialog(this, "La quantite doit etre positive et supperieur à zero svp "); 
                 }
            
        }
            
            
            
        }
            
            //
        }
            
        
    }//GEN-LAST:event_aj1ActionPerformed

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        // TODO add your handling code here:
        
        
        String client = this.cl.getSelectedItem().toString().replaceAll("'", "''") ;
        String nb02 = this.nb2.getText().trim() ;
        
        
        if("CHOISIR UN CLIENT".equalsIgnoreCase(client) || "".equalsIgnoreCase(nb02)){
            JOptionPane.showMessageDialog(this, "Selectionner un client et un nombre svp") ;
        }else{
              
            try{
                
        if(jList2.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(this, "Selectionner un article dans le compte client svp");
        }else{
            
            // ici .....
            
            String article = jList2.getSelectedValue().toString() ;
            double qtRp = 0.0 ;
            try{
                qtRp = Double.parseDouble(nb02) ;
                
                if(qtRp > 0){
                
                    
                    
                    // debut transaction :
                    
                         
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
      
       // declaration variable :
      
          double qteF = 0.0 ;
          double prxF = 0.0 ;
          double montantF = 0.0 ;
          double remiseF = 0.0 ;
          double reliqatF = 0.0 ;
          
      
      // end :
       
       
         String sql1 ;
      
       sql1 = "SELECT * FROM factures WHERE id_client = "+this.idCl+" AND produit_matiere = '"+article.replaceAll("'", "''")+"' AND qte_achat > 0.0 AND montant > 0.0 AND dette = 'oui' LIMIT 1" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
       while(rs1.next()){
        // on charge les donnee :
           
           qteF = rs1.getDouble("qte_achat") ;
           prxF = rs1.getDouble("prx_unite") ;
           montantF = rs1.getDouble("montant") ;
           remiseF = rs1.getDouble("remise") ;
           reliqatF = rs1.getDouble("reliquat") ;
           
     
     }
       
       
          
           // java programme :
       
              if(qteF >= qtRp){
                  
           // oui la reprise est possible :

              double newQteF = (qteF - qtRp) ;
              double newMontantF = (prxF * newQteF) ;
              double newReliqaF = newMontantF ;
              double newStockArticle = 0.0 ;   
              
              
               String sql2 ;
      
       sql2 = "SELECT * FROM stocks_matiere_p WHERE matieres_p = '"+article.replaceAll("'", "''")+"' AND pu_v = "+prxF+" LIMIT 1" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
       while(rs2.next()){
        // on charge les donnee :
           
           newStockArticle = (rs2.getDouble("stock_dispo") + qtRp) ;
           
     
     }
       
        String sql3 ;
      
       sql3 = "SELECT * FROM stocks_produit_fini WHERE produits_fini = '"+article.replaceAll("'", "''")+"' AND pu_v = "+prxF+" LIMIT 1" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3) ;
      
      
       while(rs3.next()){
        // on charge les donnee :
           
           newStockArticle = (rs3.getDouble("stock_dispo") + qtRp) ;
           
     
     }
              
              
              // update factures :
              
       if(stmt.executeUpdate("UPDATE factures SET qte_achat = "+newQteF+" , montant = "+newMontantF+" , reliquat = "+newReliqaF+" WHERE id_client = "+this.idCl+" AND produit_matiere = '"+article.replaceAll("'", "''")+"' AND qte_achat > 0.0 AND montant > 0.0 AND dette = 'oui' LIMIT 1") == 1){
     
           
           if(stmt.executeUpdate("UPDATE stocks_matiere_p SET stock_dispo = "+newStockArticle+" WHERE matieres_p = '"+article.replaceAll("'", "''")+"' AND pu_v = "+prxF+" LIMIT 1") == 1){
      
                 this.nb2.setText("") ;
                 JOptionPane.showMessageDialog(this, "reprise effectuée avec succès") ;
       }else{
               
               if(stmt.executeUpdate("UPDATE stocks_produit_fini SET stock_dispo = "+newStockArticle+" WHERE produits_fini = '"+article.replaceAll("'", "''")+"' AND pu_v = "+prxF+" LIMIT 1") == 1){
      
                 this.nb2.setText("") ;
                 JOptionPane.showMessageDialog(this, "reprise effectuée avec succès") ;
       
               }else{
                    JOptionPane.showMessageDialog(this, "operation impossible car le stock a été supprimé") ;
               }
               
           }
           
       }else{
           
            JOptionPane.showMessageDialog(this, "operation impossible car la facture a été supprimé") ;
           
       }
              
              
              
           //
              
              
              
                  
              }else{
                  JOptionPane.showMessageDialog(this, "retirer dabord pour la transaction un ensuite sur le second transaction quantité est : "+qteF) ;
              } 
       
       
         // java programme end :
       
       
       
       
       // satement for update facture and stock produit or matiere primaire debut :
       
       
       
       // end update :
       
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
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
     
                    
                 //  end transaction :
                    
                    
             //   JOptionPane.showMessageDialog(this, "qtRepris :"+qtRp+" article ="+article);
                }else{
                    JOptionPane.showMessageDialog(this, "pour la réprise des articles la quantité doit être supperieur à 0");
                }
                
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "la quantité est en chiffre uniquement");
            }
            
        }
        }catch(Exception e){
                 //  JOptionPane.showMessageDialog(this, "Selectionner un article dans le compte client svp");
                }
            
        }
    }//GEN-LAST:event_r1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String client = this.cl.getSelectedItem().toString() ;
        String dte1 = this.dte.getText().trim() ;
        
        if("".equalsIgnoreCase(dte1) || "CHOISIR UN CLIENT".equalsIgnoreCase(client)){
                  JOptionPane.showMessageDialog(this, "Choisir un client plus une periode svp");
        }else{
            
              try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\FacturesDette.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql = "SELECT\n" +
"     factures.`id` AS factures_id,\n" +
"     factures.`id_client` AS factures_id_client,\n" +
"     factures.`produit_matiere` AS factures_produit_matiere,\n" +
"     factures.`prx_unite` AS factures_prx_unite,\n" +
"     factures.`qte_achat` AS factures_qte_achat,\n" +
"     factures.`montant` AS factures_montant,\n" +
"     factures.`remise` AS factures_remise,\n" +
"     factures.`recu` AS factures_recu,\n" +
"     factures.`reliquat` AS factures_reliquat,\n" +
"     factures.`dette` AS factures_dette,\n" +
"     factures.`type` AS factures_type,\n" +
"     factures.`date` AS factures_date,\n" +
"     factures.`mois` AS factures_mois,\n" +
"     factures.`annee` AS factures_annee,\n" +
"     factures.`admin` AS factures_admin,\n" +
"     clients.`id` AS clients_id,\n" +
"     clients.`entreprise` AS clients_entreprise,\n" +
"     clients.`nom_court` AS clients_nom_court,\n" +
"     clients.`adresse` AS clients_adresse,\n" +
"     clients.`tel1` AS clients_tel1,\n" +
"     clients.`tel2` AS clients_tel2,\n" +
"     clients.`email` AS clients_email,\n" +
"     clients.`fonction` AS clients_fonction,\n" +
"     clients.`description` AS clients_description,\n" +
"     clients.`plafon_credit` AS clients_plafon_credit,\n" +
"     clients.`datecreat` AS clients_datecreat,\n" +
"     clients.`admin` AS clients_admin\n" +
"FROM\n" +
"     `factures` factures,\n" +
"     `clients` clients WHERE factures.`id_client` ="+this.idCl+" AND factures.`dette` = 'oui' AND factures.`date` LIKE '%"+this.dte.getText().trim()+"%' AND clients.`id` ="+this.idCl ;
           
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql) ;
           jd.setQuery(newQuery) ;
           JasperReport jr = JasperCompileManager.compileReport(jd) ;
           HashMap para = new HashMap() ;
           JasperPrint j = JasperFillManager.fillReport(jr, para, DriverManager.getConnection(DB_URL,USER,PASS)) ;
           JasperViewer.viewReport(j , false) ;
          
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
        
            
            
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(VentProduitFini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentProduitFini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentProduitFini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentProduitFini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentProduitFini().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aj1;
    private javax.swing.JTextField cdebarre;
    private javax.swing.JComboBox cl;
    private javax.swing.JTextField dte;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nb1;
    private javax.swing.JTextField nb2;
    private javax.swing.JButton r1;
    private javax.swing.JTextField rpm;
    // End of variables declaration//GEN-END:variables
}
