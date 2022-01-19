/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import entity.ActiviteT;
import entity.StocksProduitFini;
import entity.TransformationTMatPri;
import entity.TransformationTProduitFini;
import static frontend.ActiviteTransformation.JDBC_DRIVER;
import static frontend.UpdateTtProdf.JDBC_DRIVER;
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
public class Lacaisse extends javax.swing.JFrame {

    /**
     * Creates new form Lacaisse
     */
    
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
      String user_c ;
      String role ;
      String phone ;
      String dc ;
      String barreCode = "" ;
      
      
      long idActiviteT = 0 ;
      double stockMp = 0.0 ;
      double newStockMp = 0.0 ;
      double stockPf = 0.0 ;
      double newStockpf = 0.0 ;
      double pvMp = 0.0 ;
      double pvPf = 0.0 ;
      double qantitiMp = 0.0 ;
      double qantitiPf = 0.0 ;
      double coutTMp = 0.0 ;
      
    
    DefaultListModel mtp = new DefaultListModel() ;
    DefaultListModel pdf = new DefaultListModel() ;
    
    
    public Lacaisse() {
        initComponents() ;
        this.setLocationRelativeTo(null);
        
         String format = "dd/MM/yy" ;

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ) ;
        java.util.Date date = new java.util.Date() ;

        this.dc = formater.format( date ) ;
        
        
         DateFormat datef = new SimpleDateFormat("dd/MM/yyyy") ;
             Date date1 = new Date() ;
             this.dte.setText(datef.format(date1)) ;
        
        
        
        
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
      
       sql = "SELECT * FROM activite_t " ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
       while(rs.next()){
        
       act.addItem(rs.getString("libelle")) ; 
      
         
       
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
        jButton9 = new javax.swing.JButton();
        dte = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        act = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        prodF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nbPro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        uni1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        aj1 = new javax.swing.JButton();
        md1 = new javax.swing.JButton();
        sp1 = new javax.swing.JButton();
        mt = new javax.swing.JTextField();
        pum = new javax.swing.JTextField();
        um = new javax.swing.JLabel();
        qtMp = new javax.swing.JTextField();
        ctmp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        aj = new javax.swing.JButton();
        sp = new javax.swing.JButton();
        md = new javax.swing.JButton();
        ct = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("FERMER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ACTIVITE DE TRANSFORMATION ET VENTE DES PRODUITS FINI :");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton9.setText("IMPRIMER ACTIVITE");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        dte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel14.setText(" DATE / MOIS");

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton10.setText("VENTE DE PRODUIT FINI");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dte, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dte, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(244, Short.MAX_VALUE))
        );

        act.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        act.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR ACTIVITE" }));
        act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("LES PRODUITS OBTENUS A LA FIN DE L'ACTIVITE  :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("LES MATIERES PREMIERES ENTRANT DANS L'ACTIVITE :");

        prodF.setEditable(false);
        prodF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setText("PRODUIT FINI OBTENU :");

        jLabel5.setText("NBRE OBTENU :");

        uni1.setEditable(false);

        jLabel6.setText("QTE / UNITE *");

        aj1.setText("AJOUTER");
        aj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aj1ActionPerformed(evt);
            }
        });

        md1.setText("MODIFIER");
        md1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                md1ActionPerformed(evt);
            }
        });

        sp1.setText("SUPPRIMER");
        sp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sp1ActionPerformed(evt);
            }
        });

        mt.setEditable(false);
        mt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pum.setEditable(false);
        pum.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        um.setText("/");

        qtMp.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        qtMp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qtMpKeyPressed(evt);
            }
        });

        ctmp.setEditable(false);
        ctmp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setText("P.U / UNITE");

        jLabel9.setText("QUANTITE :");

        jLabel10.setText("LE COUT :");

        aj.setText("AJOUTER");
        aj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajActionPerformed(evt);
            }
        });

        sp.setText("SUPPRIMER");
        sp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spActionPerformed(evt);
            }
        });

        md.setText("MODIFIER");
        md.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mdActionPerformed(evt);
            }
        });

        ct.setText("LE COUT");
        ct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ctMouseClicked(evt);
            }
        });

        jLabel13.setText("LA MATIERE PRIMAIRE :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pum, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(um, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(qtMp))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ctmp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(ct)
                        .addGap(18, 18, 18)
                        .addComponent(md, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aj, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prodF, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(nbPro, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(uni1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(md1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(aj1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sp1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nbPro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(prodF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(uni1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(md1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(aj1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(sp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(jLabel8))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pum, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(um)
                            .addComponent(qtMp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ctmp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(ct)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(aj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(md, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jList1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("LES MATIERES PRIMAIRES DE L'ACTIVITE :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("LES PRODUITS FINI DE L'ACTIVITE  :");

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setText("FERMER ACTIVITE");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(312, 312, 312)
                                .addComponent(act, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(act, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void sp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sp1ActionPerformed
        // TODO add your handling code here:
        
        
           String act1 = this.act.getSelectedItem().toString().replaceAll("'", "''") ;
        
        if("CHOISIR ACTIVITE T".equalsIgnoreCase(act1)){
            
            JOptionPane.showMessageDialog(this, "Selectionner une activité de production");
            
        }else{
        
        
        String sql = "" ;
        
       if("CAISSE".equalsIgnoreCase(this.role)){
      
               sql = "SELECT * FROM transformation_t_produit_fini WHERE id_activ_t ="+this.idActiviteT+" AND status = 'ouvert'" ;
       
             
                 }
      
        if("ADMIN1".equalsIgnoreCase(this.role)){
           
             sql = "SELECT * FROM transformation_t_produit_fini WHERE id_activ_t ="+this.idActiviteT+" ORDER BY id DESC" ;
           
          
      }
      
      
       
      if("ADMIN2".equalsIgnoreCase(this.role)){
          
           sql = "SELECT * FROM transformation_t_produit_fini WHERE id_activ_t ="+this.idActiviteT+" ORDER BY id DESC" ;
           
          
      }
      
      
        
        UpdateTtProduitFiDelete up = new UpdateTtProduitFiDelete(this.idActiviteT , act.getSelectedItem().toString() , sql) ;
        up.setUser_c(this.user_c) ;
        
        
        up.setVisible(true) ;
        
        }
        
        
        
    }//GEN-LAST:event_sp1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here :
        
        if(this.role.equalsIgnoreCase("ADMIN1")){
            
             Admin1 e = new Admin1() ;
                  
           
                  e.setUser_c(this.user_c) ;
                  e.setRole(this.role) ;
                  e.setPhone(this.phone) ;
                  e.setLog(e.getUser_c()) ;
        
                  e.setVisible(true) ;
                  
       
        this.setVisible(false) ;
        
        }
        
        
         if(this.role.equalsIgnoreCase("ADMIN2")){
            
             Admin2 e = new Admin2() ;
                  
           
                  e.setUser_c(this.user_c) ;
                  e.setRole(this.role) ;
                  e.setPhone(this.phone) ;
                  e.setLog(e.getUser_c()) ;
        
                  e.setVisible(true) ;
                  
       
        this.setVisible(false) ;
        
        }
         
          if(this.role.equalsIgnoreCase("CAISSE")){
            
             Caisse e = new Caisse() ;
                  
           
                  e.setUser_c(this.user_c) ;
                  e.setRole(this.role) ;
                  e.setPhone(this.phone) ;
                  e.setLog(e.getUser_c()) ;
        
                  e.setVisible(true) ;
                  
       
        this.setVisible(false) ;
        
        }
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        
        
               VentProduitFini e = new VentProduitFini() ;
                  
           
                  e.setUser_c(this.user_c) ;
                  e.setRole(this.role) ;
                  e.setPhone(this.phone) ;
                  
        
                  e.setVisible(true) ;
            this.setVisible(false) ;
        
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void ajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajActionPerformed
        // TODO add your handling code here:
        
         DateFormat datef = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss") ;
         Date date = new Date() ;
         this.dc = datef.format(date) ;
         
         
       //  JOptionPane.showMessageDialog(this, this.dc) ;
         
         
         
         String mt1 , um1 ;
         mt1 = this.mt.getText().trim() ;
         um1 = this.um.getText().trim() ;
        
         
         if("".equalsIgnoreCase(mt1) || "".equalsIgnoreCase(um1) || this.ct.isSelected() == false){
             
             JOptionPane.showMessageDialog(this, "Vous devez activer le cout unitaire pour la production") ;
             
         }else{
               // we can save here :
             
             //  JOptionPane.showMessageDialog(this, "we can save here"+" "+this.dc) ;
               
           //
              
              
                   SessionFactory sf=new Configuration().configure().buildSessionFactory();
                   Session s=sf.openSession();
            
                   Transaction tr = s.beginTransaction();
            
                   TransformationTMatPri cu = new   TransformationTMatPri(this.idActiviteT, mt1, this.pvMp, this.qantitiMp, this.coutTMp, um1, "ouvert", this.dc, this.dc.substring(3), this.dc.substring(6), this.user_c)  ;
       
                   
                 
                           s.save(cu) ;
            
                           tr.commit() ;
                           s.close() ;
            
                  // String   entr1 , nc1 , ad1 , c11 , c22 , email1 , fonc1 , desc1 , pl1  ;
                           
//  System.out.println("id actT :"+cu.getIdActivT()+" mtp :"+cu.getMatiereP()+" PU "+cu.getPrxUnitVent()+" QTE "+cu.getQte()+" COUT  "+cu.getCout()+" UM "+cu.getUnite()+" STATUS "+cu.getStatus()+" DATE "+cu.getDate()+" MOIS "+cu.getMois()+" ANNEE "+cu.getAnnee()+" ADMIN "+cu.getAdmin());
                           
                           //
                           
                           
                                  
                                
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
         
    
      
      if(stmt.executeUpdate("UPDATE stocks_matiere_p SET stock_dispo = "+this.newStockMp+" WHERE matieres_p ='"+mt1.replaceAll("'", "''")+"' AND stock_dispo > 0.0 LIMIT 1") == 1){
          
         //  JOptionPane.showMessageDialog(this, "we can update stock_dispo and our mtp stckdispo is updated") ;
          
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
        
                           
                           
                           
                      //
                           
                           this.mt.setText("") ; this.pum.setText("") ; this.um.setText("") ;
                           this.qtMp.setText("") ; this.ctmp.setText("") ; this.ct.setSelected(false) ;
                        
                        
                     
                     }
            
            
              
              
              //    
         
         
         
         
       
    }//GEN-LAST:event_ajActionPerformed

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
         
         this.stockMp = rs.getDouble("stock_dispo") ;
         
         this.mt.setText(rs.getString("matieres_p")) ;
         this.pum.setText(String.valueOf(rs.getDouble("pu_v")));
         this.um.setText(rs.getString("unite_mes")) ;
         
         
      
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
            jp.showMessageDialog(null,"Selectionner une activité de production svp ","Avertissement",JOptionPane.WARNING_MESSAGE);
  
            
        }
        
     
        
        
    }//GEN-LAST:event_jList1MouseClicked

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        // TODO add your handling code here:
        
            
        try{
            
            String matiere = jList2.getSelectedValue().toString() ;
          
            
            
            
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
      
       sql= "SELECT * FROM produits_f WHERE libelle ='"+matiere.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
         
         this.barreCode = rs.getString("code_barre") ;
         this.pvPf = rs.getDouble("pu") ;
         this.prodF.setText(matiere);
         this.uni1.setText(rs.getString("unite_m")) ;
      
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
            jp.showMessageDialog(null,"Selectionner une activité de production svp ","Avertissement",JOptionPane.WARNING_MESSAGE);
  
            
        }
        
     
        
        
    }//GEN-LAST:event_jList2MouseClicked

    private void actActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actActionPerformed
        // TODO add your handling code here:
       
        
        String act1 = this.act.getSelectedItem().toString().replaceAll("'", "''") ;
        
        if("CHOISIR ACTIVITE T".equalsIgnoreCase(act1)){
        
            JOptionPane jp=new JOptionPane() ;
            jp.showMessageDialog(null,"selectionner une activité T svp","Avertissement",JOptionPane.WARNING_MESSAGE);
  
        
        }else{
            
            
            
              //
            
            
            mtp.clear() ;
            pdf.clear() ;
        
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
      
       sql = "SELECT id FROM activite_t WHERE libelle = '"+act1+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
       while(rs.next()){
        
            this.idActiviteT = rs.getLong("id") ; 
      
         
       
     }
       
       String sql2 ;
      
       sql2 = "SELECT nom_matiere_pri FROM activite_t_matieres_p WHERE id_activite_t ="+this.idActiviteT ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
       while(rs2.next()){
        
              mtp.addElement(rs2.getString("nom_matiere_pri")) ; 
           
           }
      
      String sql3 ;
      
       sql3 = "SELECT nom_produit_fini FROM activite_t_produit_fini WHERE id_activite_t ="+this.idActiviteT ;
      
       ResultSet rs3 = stmt.executeQuery(sql3) ;
      
      
       while(rs3.next()){
        
              pdf.addElement(rs3.getString("nom_produit_fini")) ; 
           
           }
      
          jList1.setModel(mtp) ;
          jList2.setModel(pdf) ;
     
      
    
         //  le blocage et deblocage de la modification et suppression d'une activite T :
    
         SessionFactory sf = new Configuration().configure().buildSessionFactory() ;
         Session s = sf.openSession() ;
            
       
         List matp = s.createSQLQuery("SELECT * FROM transformation_t_mat_pri WHERE id_activ_t = "+this.idActiviteT+" AND status = 'ouvert'").list();
         List pfini = s.createSQLQuery("SELECT * FROM transformation_t_produit_fini WHERE id_activ_t = "+this.idActiviteT+" AND status = 'ouvert'").list() ;
       
         
         
         
         if(this.role.equalsIgnoreCase("ADMIN1")){
              if(matp.size() > 0 && pfini.size() > 0){
                   
                   this.md.setEnabled(true);
                   this.aj.setEnabled(true);
                   this.sp.setEnabled(true);
             
                   this.md1.setEnabled(true);
                   this.aj1.setEnabled(true);
                   this.sp1.setEnabled(true);
                   
               }else{
                   /*
                  
                    this.md.setEnabled(false);
                    this.aj.setEnabled(false);
                    this.sp.setEnabled(false);
             
                    this.md1.setEnabled(false);
                    this.aj1.setEnabled(false);
                    this.sp1.setEnabled(false);
                  */
                  
                  
                  // original admin1
                    this.md.setEnabled(true);
                    this.aj.setEnabled(true);
                    this.sp.setEnabled(true);
             
                    this.md1.setEnabled(true);
                    this.aj1.setEnabled(true);
                    this.sp1.setEnabled(true);
                  
                   
               }
             
             
         }
         
         
          if(this.role.equalsIgnoreCase("ADMIN2")){
              
             if(matp.size() > 0 && pfini.size() > 0){
                   
                   this.md.setEnabled(true);
                   this.aj.setEnabled(true);
                   this.sp.setEnabled(true);
             
                   this.md1.setEnabled(true);
                   this.aj1.setEnabled(true);
                   this.sp1.setEnabled(true);
                   
               }else{
                   
                    this.md.setEnabled(true);
                    this.aj.setEnabled(true);
                    this.sp.setEnabled(true);
             
                    this.md1.setEnabled(true);
                    this.aj1.setEnabled(true);
                    this.sp1.setEnabled(true);
                   
               }
             
             /*
                      ADMIN1
                      ADMIN2
                      CAISSE
             */
             
             
         }
          
          
           if(this.role.equalsIgnoreCase("CAISSE")){
               
               if(matp.size() > 0 && pfini.size() > 0){
                   
                   this.md.setEnabled(true);
                   this.aj.setEnabled(true);
                   this.sp.setEnabled(true);
             
                   this.md1.setEnabled(true);
                   this.aj1.setEnabled(true);
                   this.sp1.setEnabled(true);
                   
               }else{
                   
                    this.md.setEnabled(false);
               //   this.aj.setEnabled(false);
                    this.sp.setEnabled(false);
             
                    this.md1.setEnabled(false);
             //     this.aj1.setEnabled(false);
                    this.sp1.setEnabled(false);
                   
               }
            
             
             
         }
    
    //  End  :
           
    
            
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
        
        
        
        
    }//GEN-LAST:event_actActionPerformed

    private void aj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aj1ActionPerformed
        
                // TODO add your handling code here:
        
        
           String pro1 = this.prodF.getText().trim() ;
      //   String un01 = this.un.getText().trim() ;
           String qt03 = this.nbPro.getText().trim() ;
        
          if("".equalsIgnoreCase(pro1) || "".equalsIgnoreCase(qt03)){
              
              JOptionPane.showMessageDialog(this , "Selectionner un produit fini dans la liste des produits fini svp") ;
              
          }else{
        
        
        if(JOptionPane.showConfirmDialog(null, "Voulez-vous créer un code barre pour cette production ? :"+" ","Confirmation",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            
                   // Oui je veux creer un code barre
            
                this.barreCode = JOptionPane.showInputDialog("SAISIR LE CODE BARRE POUR LA PRODUCTION ") ;
              
                //   this.dc = JOptionPane.showInputDialog("SAISIR LE CODE BARRE POUR LA PRODUCTION ") ;
              
              // JOptionPane.showMessageDialog(null, this.barreCode) ;
              
              if("".equalsIgnoreCase(this.barreCode.trim())){ 
                  
                  JOptionPane.showMessageDialog(null, "Vous devez saisir le code barre pour cette production ou cliquez sur Non ") ;
              
              }else{
                  
                  // je peux créer la production dans le stock pour les ventes etc .
                  
                  // debut ::
                  
                  
                  
                             DateFormat datef = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss") ;
                             Date date = new Date() ;
                             this.dc = datef.format(date) ;
         
         
       //  JOptionPane.showMessageDialog(this, this.dc) ;
         
         try{
             
             this.qantitiPf = Double.parseDouble(this.nbPro.getText().trim()) ;
             
         }catch(Exception e){
           
            JOptionPane.showMessageDialog(this, "Le nombre de produit fin obtenu a la fin de la production est en chiffre uniquement") ;
             
         }
        
         
         if(this.qantitiPf <= 0 ){
             
             JOptionPane.showMessageDialog(this, "Vous devez saisir un nombre positif et superieur a zero pour la production") ;
             
         }else{
               // we can save here :
             
             //  JOptionPane.showMessageDialog(this, "we can save here"+" "+this.dc) ;
               
           //
              
              
                   SessionFactory sf=new Configuration().configure().buildSessionFactory();
                   Session s=sf.openSession();
            
                   Transaction tr = s.beginTransaction();
            
                   StocksProduitFini cu = new  StocksProduitFini(this.idActiviteT, this.barreCode, this.prodF.getText().trim(), this.uni1.getText().trim(), this.pvPf, this.qantitiPf, this.dc, this.dc.substring(3), this.dc.substring(6), this.user_c) ;
                   TransformationTProduitFini cu1 = new TransformationTProduitFini(this.idActiviteT, this.prodF.getText().trim(), this.pvPf, this.qantitiPf, this.uni1.getText().trim() , "ouvert", this.dc, this.dc.substring(3), this.dc.substring(6), this.user_c) ;
                   
                 
                           s.save(cu) ;
                           s.save(cu1) ;
            
                           tr.commit() ;
                           s.close() ;
            
                  
                           
                           this.prodF.setText("") ; this.nbPro.setText("") ; this.uni1.setText("") ;
                          
                        
                     
                     }
            
            
             
                   
                  
                  
             // fin : 
                  
                  
              }
            
            
            }else{
            
               // Non merci :
              //  La production sera save dans le stock pour la vente avec le code barre du produit create par admin yaya :
            
               DateFormat datef = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss") ;
                             Date date = new Date() ;
                             this.dc = datef.format(date) ;
         
         
       //  JOptionPane.showMessageDialog(this, this.dc) ;
         
         try{
             
             this.qantitiPf = Double.parseDouble(this.nbPro.getText().trim()) ;
             
         }catch(Exception e){
           
            JOptionPane.showMessageDialog(this, "Le nombre de produit fin obtenu a la fin de la production est en chiffre uniquement") ;
             
         }
        
         
         if(this.qantitiPf <= 0 ){
             
             JOptionPane.showMessageDialog(this, "Vous devez saisir un nombre positif et superieur a zero pour la production") ;
             
         }else{
               // we can save here :
             
             //  JOptionPane.showMessageDialog(this, "we can save here"+" "+this.dc) ;
               
           //
              
              
                   SessionFactory sf=new Configuration().configure().buildSessionFactory();
                   Session s=sf.openSession();
            
                   Transaction tr = s.beginTransaction();
            
                   StocksProduitFini cu = new  StocksProduitFini(this.idActiviteT, this.barreCode, this.prodF.getText().trim(), this.uni1.getText().trim(), this.pvPf, this.qantitiPf, this.dc, this.dc.substring(3), this.dc.substring(6), this.user_c) ;
                   TransformationTProduitFini cu1 = new TransformationTProduitFini(this.idActiviteT, this.prodF.getText().trim(), this.pvPf, this.qantitiPf, this.uni1.getText().trim() , "ouvert", this.dc, this.dc.substring(3), this.dc.substring(6), this.user_c) ;
                   
                 
                           s.save(cu) ;
                           s.save(cu1) ;
            
                           tr.commit() ;
                           s.close() ;
            
                  
                           
                           this.prodF.setText("") ; this.nbPro.setText("") ; this.uni1.setText("") ;
                          
                        
                     
                     }
            
            
             
                   
                  
                  
             // fin : 
                  
            
                
            
            }
        
         
          }
        
    }//GEN-LAST:event_aj1ActionPerformed

    private void ctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ctMouseClicked
        // TODO add your handling code here:
        
        
        if(ct.isSelected()){
            String qt1 = this.qtMp.getText().trim() ;
            
            if("".equalsIgnoreCase(qt1) || "".equalsIgnoreCase(pum.getText().trim())){
                 JOptionPane.showMessageDialog(this, "Saisir la qté et le pu");
            }else{
              try{
                     this.qantitiMp = Double.parseDouble(qt1) ; 
                 
                 if(qantitiMp > this.stockMp){
                     
                     JOptionPane jp = new JOptionPane() ;
                     jp.showMessageDialog(null , "le stock restant de la matiere pour la règle de PE PS est :"+" "+this.stockMp,"Avertissement",JOptionPane.WARNING_MESSAGE) ;
                     
                     
                 }else{
                     
                       this.pvMp = Double.parseDouble(pum.getText().trim()) ;
                       this.coutTMp = this.pvMp * this.qantitiMp ;
                       this.ctmp.setText(String.valueOf(this.coutTMp)) ;
                       
                       this.newStockMp = ( this.stockMp - qantitiMp ) ;
                       
                     //  JOptionPane.showMessageDialog(this, "stock actuel after operat.."+" "+this.newStockMp);
                 
                 // ............
                 
                 
                 
                 //................
                     
                 }
                     
               
                 
                 }catch(Exception e){
                      JOptionPane.showMessageDialog(this, "la quantite en g et le PU en cfa ==> en chiffre uniquement");
                   }
            
            }
        }else{
            
            JOptionPane.showMessageDialog(this, "Pour obtenir le cout activer cette case svp");
        }
        
        
        
    }//GEN-LAST:event_ctMouseClicked

    private void qtMpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtMpKeyPressed
        // TODO add your handling code here:
        this.ct.setSelected(false) ;
        this.ctmp.setText("") ;
    }//GEN-LAST:event_qtMpKeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
          DateFormat datef = new SimpleDateFormat("dd/MM/yyyy ") ;
          Date date = new Date() ;
          String m2 = datef.format(date) ;
          String m1 = m2.substring(3) ;
         
        
        if(this.idActiviteT == 0){
            JOptionPane.showMessageDialog(this, "Selectionner une activité T svp");
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
         
    
      
      if(stmt.executeUpdate("UPDATE transformation_t_mat_pri SET status ='fermer' WHERE id_activ_t ="+this.idActiviteT) > 0){
          
        //   JOptionPane.showMessageDialog(this, "we can close ActivT mp Transf") ;
          
          
           if(stmt.executeUpdate("UPDATE transformation_t_produit_fini SET status ='fermer' WHERE id_activ_t ="+this.idActiviteT) > 0){
          
                 JOptionPane.showMessageDialog(this, "L'activité de la production a été fermée avec succès ") ;
          
      }else{
               if(stmt.executeUpdate("UPDATE transformation_t_mat_pri SET status ='ouvert' WHERE id_activ_t ="+this.idActiviteT+" AND mois LIKE '%"+m1+"%'") > 0){
                   
                   
                    JOptionPane.showMessageDialog(this, "L'activité T n'a pas de produit fini pour l'instant donc ne pourra pas être fermer") ;
                    
               }
              
           }
      
          
          
          
      }else{
          
//      stmt.executeUpdate("UPDATE transformation_t_mat_pri SET status = 'fermer' WHERE id_activ_t ="+this.idActiviteT) ;
          
          JOptionPane.showMessageDialog(this , "L'Activité est dejà fermer ou ne contient pas de matiere primaire pour l'instant ") ;
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
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void mdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mdActionPerformed
        // TODO add your handling code here:
        
        
         String act1 = this.act.getSelectedItem().toString().replaceAll("'", "''") ;
        
        if("CHOISIR ACTIVITE T".equalsIgnoreCase(act1)){
            
            JOptionPane.showMessageDialog(this, "Selectionner une activité de production");
            
        }else{
        
        
        String sql = "" ;
        
       if("CAISSE".equalsIgnoreCase(this.role)){
      
               sql = "SELECT * FROM transformation_t_mat_pri WHERE id_activ_t ="+this.idActiviteT+" AND status = 'ouvert'" ;
       
             
                 }
      
        if("ADMIN1".equalsIgnoreCase(this.role)){
           
             sql = "SELECT * FROM transformation_t_mat_pri WHERE id_activ_t ="+this.idActiviteT+" ORDER BY id DESC" ;
           
          
      }
      
      
       
      if("ADMIN2".equalsIgnoreCase(this.role)){
          
           sql = "SELECT * FROM transformation_t_mat_pri WHERE id_activ_t ="+this.idActiviteT+" ORDER BY id DESC" ;
           
          
      }
      
      
        
        UpdateTtMatPri up = new UpdateTtMatPri(this.idActiviteT , act.getSelectedItem().toString() , sql) ;
        up.setUser_c(this.user_c) ;
        
        
        up.setVisible(true) ;
        
        }
        
        
    }//GEN-LAST:event_mdActionPerformed

    private void spActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spActionPerformed
        // TODO add your handling code here:
        
           String act1 = this.act.getSelectedItem().toString().replaceAll("'", "''") ;
        
        if("CHOISIR ACTIVITE T".equalsIgnoreCase(act1)){
            
            JOptionPane.showMessageDialog(this, "Selectionner une activité de production");
            
        }else{
        
          String sql = "" ;
        
       if("CAISSE".equalsIgnoreCase(this.role)){
      
               sql = "SELECT * FROM transformation_t_mat_pri WHERE id_activ_t ="+this.idActiviteT+" AND status = 'ouvert'" ;
       
             
                 }
      
        if("ADMIN1".equalsIgnoreCase(this.role)){
           
             sql = "SELECT * FROM transformation_t_mat_pri WHERE id_activ_t ="+this.idActiviteT+" ORDER BY id DESC" ;
           
          
      }
      
      
       
      if("ADMIN2".equalsIgnoreCase(this.role)){
          
           sql = "SELECT * FROM transformation_t_mat_pri WHERE id_activ_t ="+this.idActiviteT+" ORDER BY id DESC" ;
           
          
      }
      
      
        
        UpdateTtMatPriDelete up = new UpdateTtMatPriDelete(this.idActiviteT , act.getSelectedItem().toString() , sql) ;
        up.setUser_c(this.user_c) ;
        
        
        up.setVisible(true) ;
        
        }
        
        
    }//GEN-LAST:event_spActionPerformed

    private void md1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_md1ActionPerformed
        // TODO add your handling code here:
        
        
           String act1 = this.act.getSelectedItem().toString().replaceAll("'", "''") ;
        
        if("CHOISIR ACTIVITE T".equalsIgnoreCase(act1)){
            
            JOptionPane.showMessageDialog(this, "Selectionner une activité de production");
            
        }else{
        
        
        String sql = "" ;
        
       if("CAISSE".equalsIgnoreCase(this.role)){
      
               sql = "SELECT * FROM transformation_t_produit_fini WHERE id_activ_t ="+this.idActiviteT+" AND status = 'ouvert'" ;
       
             
                 }
      
        if("ADMIN1".equalsIgnoreCase(this.role)){
           
             sql = "SELECT * FROM transformation_t_produit_fini WHERE id_activ_t ="+this.idActiviteT+" ORDER BY id DESC" ;
           
          
      }
      
      
       
      if("ADMIN2".equalsIgnoreCase(this.role)){
          
           sql = "SELECT * FROM transformation_t_produit_fini WHERE id_activ_t ="+this.idActiviteT+" ORDER BY id DESC" ;
           
          
      }
      
      
        
        UpdateTtProdf up = new UpdateTtProdf(this.idActiviteT , act.getSelectedItem().toString() , sql) ;
        up.setUser_c(this.user_c) ;
        
        
        up.setVisible(true) ;
        
        }
        
        
        
    }//GEN-LAST:event_md1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        
        
        String dte1 , act1 ;
        dte1 = this.dte.getText().trim() ;
        act1 = this.act.getSelectedItem().toString() ;
        
        if("CHOISIR ACTIVITE T".equalsIgnoreCase(act1) || "".equalsIgnoreCase(dte1)){
            
            JOptionPane.showMessageDialog(this, "pour imprimer une production selectionner l'activite plus une periode") ;
        }else{
            
             SessionFactory sf=new Configuration().configure().buildSessionFactory() ;
             Session s=sf.openSession() ;
       
     List entreprise = s.createSQLQuery("SELECT * FROM transformation_t_mat_pri WHERE id_activ_t ="+this.idActiviteT+" AND status = 'ouvert' AND date LIKE '%"+dte1+"%'").list() ;
       
         
            if(entreprise.size() > 0){
                
                JOptionPane.showMessageDialog(this, "Fermer l'activité de production pour pouvoir imprimer l'etat sinon attender la fin de la production pour l'impression") ;
                
            }else{
                
                
                
                
                 List verifier = s.createSQLQuery("SELECT * FROM transformation_t_mat_pri WHERE id_activ_t ="+this.idActiviteT+" AND status = 'fermer' AND date LIKE '%"+dte1+"%'").list() ;

                 
                 if(verifier.size() > 1){
                     
                     
                     
                     
                     
                      try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\ProductionMatier.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql = "SELECT\n" +
"     transformation_t_mat_pri.`id` AS transformation_t_mat_pri_id,\n" +
"     transformation_t_mat_pri.`id_activ_t` AS transformation_t_mat_pri_id_activ_t,\n" +
"     transformation_t_mat_pri.`matiere_p` AS transformation_t_mat_pri_matiere_p,\n" +
"     transformation_t_mat_pri.`prx_unit_vent` AS transformation_t_mat_pri_prx_unit_vent,\n" +
"     transformation_t_mat_pri.`qte` AS transformation_t_mat_pri_qte,\n" +
"     transformation_t_mat_pri.`cout` AS transformation_t_mat_pri_cout,\n" +
"     transformation_t_mat_pri.`unite` AS transformation_t_mat_pri_unite,\n" +
"     transformation_t_mat_pri.`status` AS transformation_t_mat_pri_status,\n" +
"     transformation_t_mat_pri.`date` AS transformation_t_mat_pri_date,\n" +
"     transformation_t_mat_pri.`mois` AS transformation_t_mat_pri_mois,\n" +
"     transformation_t_mat_pri.`annee` AS transformation_t_mat_pri_annee,\n" +
"     transformation_t_mat_pri.`admin` AS transformation_t_mat_pri_admin,\n" +
"     activite_t.`id` AS activite_t_id,\n" +
"     activite_t.`libelle` AS activite_t_libelle,\n" +
"     activite_t.`description` AS activite_t_description,\n" +
"     activite_t.`datedemarrage` AS activite_t_datedemarrage,\n" +
"     activite_t.`admin` AS activite_t_admin\n" +
"FROM\n" +
"     `transformation_t_mat_pri` transformation_t_mat_pri,\n" +
"     `activite_t` activite_t WHERE transformation_t_mat_pri.`id_activ_t` ="+this.idActiviteT+" AND transformation_t_mat_pri.`date` LIKE '%"+dte1+"%' AND  activite_t.`id` = "+this.idActiviteT ;
   
           // WHERE transformation_t_mat_pri.`id_activ_t` = "+this.idActiviteT+" AND transformation_t_mat_pri.`date` LIKE '%"+dte1+"%' AND transformation_t_produit_fini.`id_activ_t` = "+this.idActiviteT+" AND transformation_t_produit_fini.`date` LIKE '%"+dte1+"%' AND activite_t.`id` ="+this.idActiviteT ;
           // ORDER BY id DESC
           
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
        
                      
                      
                      
                      
                      
                      
                      
                      
                       try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\ProductionProduit.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql = "SELECT\n" +
"     transformation_t_produit_fini.`id` AS transformation_t_produit_fini_id,\n" +
"     transformation_t_produit_fini.`id_activ_t` AS transformation_t_produit_fini_id_activ_t,\n" +
"     transformation_t_produit_fini.`produit_fini` AS transformation_t_produit_fini_produit_fini,\n" +
"     transformation_t_produit_fini.`prx_unit_vent` AS transformation_t_produit_fini_prx_unit_vent,\n" +
"     transformation_t_produit_fini.`qte_obt` AS transformation_t_produit_fini_qte_obt,\n" +
"     transformation_t_produit_fini.`unite` AS transformation_t_produit_fini_unite,\n" +
"     transformation_t_produit_fini.`status` AS transformation_t_produit_fini_status,\n" +
"     transformation_t_produit_fini.`date` AS transformation_t_produit_fini_date,\n" +
"     transformation_t_produit_fini.`mois` AS transformation_t_produit_fini_mois,\n" +
"     transformation_t_produit_fini.`annee` AS transformation_t_produit_fini_annee,\n" +
"     transformation_t_produit_fini.`admin` AS transformation_t_produit_fini_admin,\n" +
"     activite_t.`id` AS activite_t_id,\n" +
"     activite_t.`libelle` AS activite_t_libelle,\n" +
"     activite_t.`description` AS activite_t_description,\n" +
"     activite_t.`datedemarrage` AS activite_t_datedemarrage,\n" +
"     activite_t.`admin` AS activite_t_admin\n" +
"FROM\n" +
"     `transformation_t_produit_fini` transformation_t_produit_fini,\n" +
"     `activite_t` activite_t WHERE transformation_t_produit_fini.`id_activ_t` ="+this.idActiviteT+" AND transformation_t_produit_fini.`date` LIKE '%"+dte1+"%' AND  activite_t.`id` = "+this.idActiviteT ;
           
           // ORDER BY id DESC
           
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
        
                     
                     
                     
                     
                     
                 }else{
                
                
               try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\ProductionEtat.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql = "SELECT\n" +
"     transformation_t_mat_pri.`id` AS transformation_t_mat_pri_id,\n" +
"     transformation_t_mat_pri.`id_activ_t` AS transformation_t_mat_pri_id_activ_t,\n" +
"     transformation_t_mat_pri.`matiere_p` AS transformation_t_mat_pri_matiere_p,\n" +
"     transformation_t_mat_pri.`prx_unit_vent` AS transformation_t_mat_pri_prx_unit_vent,\n" +
"     transformation_t_mat_pri.`qte` AS transformation_t_mat_pri_qte,\n" +
"     transformation_t_mat_pri.`cout` AS transformation_t_mat_pri_cout,\n" +
"     transformation_t_mat_pri.`unite` AS transformation_t_mat_pri_unite,\n" +
"     transformation_t_mat_pri.`status` AS transformation_t_mat_pri_status,\n" +
"     transformation_t_mat_pri.`date` AS transformation_t_mat_pri_date,\n" +
"     transformation_t_mat_pri.`mois` AS transformation_t_mat_pri_mois,\n" +
"     transformation_t_mat_pri.`annee` AS transformation_t_mat_pri_annee,\n" +
"     transformation_t_mat_pri.`admin` AS transformation_t_mat_pri_admin,\n" +
"     transformation_t_produit_fini.`id` AS transformation_t_produit_fini_id,\n" +
"     transformation_t_produit_fini.`id_activ_t` AS transformation_t_produit_fini_id_activ_t,\n" +
"     transformation_t_produit_fini.`produit_fini` AS transformation_t_produit_fini_produit_fini,\n" +
"     transformation_t_produit_fini.`prx_unit_vent` AS transformation_t_produit_fini_prx_unit_vent,\n" +
"     transformation_t_produit_fini.`qte_obt` AS transformation_t_produit_fini_qte_obt,\n" +
"     transformation_t_produit_fini.`unite` AS transformation_t_produit_fini_unite,\n" +
"     transformation_t_produit_fini.`status` AS transformation_t_produit_fini_status,\n" +
"     transformation_t_produit_fini.`date` AS transformation_t_produit_fini_date,\n" +
"     transformation_t_produit_fini.`mois` AS transformation_t_produit_fini_mois,\n" +
"     transformation_t_produit_fini.`annee` AS transformation_t_produit_fini_annee,\n" +
"     transformation_t_produit_fini.`admin` AS transformation_t_produit_fini_admin,\n" +
"     activite_t.`id` AS activite_t_id,\n" +
"     activite_t.`libelle` AS activite_t_libelle,\n" +
"     activite_t.`description` AS activite_t_description,\n" +
"     activite_t.`datedemarrage` AS activite_t_datedemarrage,\n" +
"     activite_t.`admin` AS activite_t_admin\n" +
"FROM\n" +
"     `transformation_t_mat_pri` transformation_t_mat_pri,\n" +
"     `transformation_t_produit_fini` transformation_t_produit_fini,\n" +
"     `activite_t` activite_t WHERE transformation_t_mat_pri.`id_activ_t` = "+this.idActiviteT+" AND transformation_t_mat_pri.`date` LIKE '%"+dte1+"%' AND transformation_t_produit_fini.`id_activ_t` = "+this.idActiviteT+" AND transformation_t_produit_fini.`date` LIKE '%"+dte1+"%' AND activite_t.`id` ="+this.idActiviteT ;
           
           // ORDER BY id DESC
           
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
            
            }
            
            
        }
        
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(Lacaisse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lacaisse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lacaisse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lacaisse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lacaisse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox act;
    private javax.swing.JButton aj;
    private javax.swing.JButton aj1;
    private javax.swing.JCheckBox ct;
    private javax.swing.JTextField ctmp;
    private javax.swing.JTextField dte;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton md;
    private javax.swing.JButton md1;
    private javax.swing.JTextField mt;
    private javax.swing.JTextField nbPro;
    private javax.swing.JTextField prodF;
    private javax.swing.JTextField pum;
    private javax.swing.JTextField qtMp;
    private javax.swing.JButton sp;
    private javax.swing.JButton sp1;
    private javax.swing.JLabel um;
    private javax.swing.JTextField uni1;
    // End of variables declaration//GEN-END:variables
}
