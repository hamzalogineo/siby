/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import entity.ActiviteT;
import static frontend.ActiviteTransformation.JDBC_DRIVER;
import static frontend.ProdOuverte.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HAMZA
 */
public class ProdFermer extends javax.swing.JFrame {

    /**
     * Creates new form ProdOuverte
     */
    
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
      String user_c ;
      String role ;
      String phone ;
    
      String nom = "" ;
      int n = 0 ;
      String status = "" ;
      String dtec = "" ;
      String dtef = "" ;
      String admin = "" ;
      private long ida ;
      
      
      static final String et = "ANNULER" ;
                   String verify = "" ;      
                   String verifyD = "" ; 
                   
    NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
    
    public ProdFermer() {
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
        
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
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
       sql= "SELECT * FROM prod WHERE status = 'fermer' ORDER BY nom , id DESC LIMIT 3000" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
     
      
        
        dtm.addRow(new Object[]{
            
   //   "PRODUCTION", "N°", "STATUS", "DEMARRER LE :", "FERMER LE", "UTILISATEUR  :"
            
          rs.getString("nom") , rs.getInt("n") , rs.getString("status") , rs.getString("etat") , rs.getString("dtec") 
       , rs.getString("dtef") , rs.getString("admin")
        
        });
               
        
         
       
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
    
    
    
    
    // parem :
    
    
        public ProdFermer(String role){
        initComponents() ;
        
           this.setLocationRelativeTo(null) ;
        // this.setExtendedState(MAXIMIZED_BOTH) ;
           this.role = role ;
           
        Date jour = new Date() ;
        this.jDateChooser1.setDate(jour);
   //     this.h1.setText("00:00") ;
        this.jDateChooser2.setDate(jour) ;
 //       this.h2.setText("23:59") ;
          
           
      if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR") || this.role.equalsIgnoreCase("ADMINISTRATEUR")){
          
    
          
      }else{
          
          this.an.setEnabled(false) ;
          this.r.setVisible(false) ;
          this.d.setVisible(false) ;
          this.p.setVisible(false) ;
          this.r1.setVisible(false) ;
          this.d1.setVisible(false) ;
          this.p1.setVisible(false) ;
          
      }
        
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
        
        
        
            
          
        DateFormat datef = new SimpleDateFormat("yyyy-MM-dd hh:mm") ;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        
        Date date = new Date() ;
        this.verifyD = datef.format(date) ;
        
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
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
       sql= "SELECT * FROM prod WHERE status = 'fermer' ORDER BY id DESC LIMIT 3000" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
     
      
        
        dtm.addRow(new Object[]{
            
   //   "PRODUCTION", "N°", "STATUS", "DEMARRER LE :", "UTILISATEUR  :"
            
          rs.getString("nom") , rs.getInt("n") , rs.getString("status") , rs.getString("etat") , sdf.format(rs.getTimestamp("dtec")) 
         , sdf.format(rs.getTimestamp("dtef")) , rs.getString("admin")
        
        });
               
        
         
       
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
    
    
    
    
    // end  :
    
    
    
    
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

    

    
     private void clear1() {

        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pr = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton18 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        an = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        r = new javax.swing.JFormattedTextField();
        d = new javax.swing.JFormattedTextField();
        p = new javax.swing.JFormattedTextField();
        r1 = new javax.swing.JLabel();
        d1 = new javax.swing.JLabel();
        p1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LES PRODUCTIONS FINIES :");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("PRODUCTION :");

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCTION", "N°", "STATUT", "ETAT", "DEMARRER LE :", "FERMER LE", "UTILISATEUR  :"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(220);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(2);
        }

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseReleased(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.jpg"))); // NOI18N
        jButton18.setBorder(null);
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.setMargin(new java.awt.Insets(6, 10, 6, 10));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jDateChooser2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jDateChooser2MouseReleased(evt);
            }
        });

        jLabel3.setText("Ouverture");

        jLabel4.setText("Fermeture");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pr, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pr, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setText("VOIR");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        an.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        an.setText("ANNULER");
        an.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        an.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton5.setText("ACTUALISER");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        r.setEditable(false);
        r.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        r.setText("0");
        r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rActionPerformed(evt);
            }
        });

        d.setEditable(false);
        d.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        d.setText("0");

        p.setEditable(false);
        p.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));

        r1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        r1.setText("Recette");

        d1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        d1.setText("Depence");

        p1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        p1.setText("Profit");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Historique Bon");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(an, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(r1))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(40, 40, 40))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(p)
                                .addComponent(d)
                                .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(an, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(r1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(d1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(377, 377, 377))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 31, Short.MAX_VALUE))
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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
      
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void prKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prKeyPressed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_prKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
       ProdFermer cptes = new ProdFermer(this.role) ;
        
                  cptes.setUser_c(this.user_c);
                  //cptes.setRole(this.role);
                  cptes.setPhone(this.phone);
                  
        
        cptes.setVisible(true) ;
        this.setVisible(false) ;
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
      if(this.jTable1.getSelectedRow() == -1){
        
            JOptionPane.showMessageDialog(this, "pour ouvrir une activité en cour de production selectionner dans le tableau svp ");
            
        }else{
            
            if(this.et.equalsIgnoreCase(this.verify)){
                
                JOptionPane.showMessageDialog(this, "Cette production a été annulée et elle est vide ") ;
                
            }else{
            
            // ProductionTOuverte
            
                                         // ProductionTOuverte( String nom , Integer n , String status , String dtec , String admin , String role)
          
                 
                
                // newprod : debut
                
    this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        
                                                     // this.admin
    
        NewProd11 np = new NewProd11(this.nom , this.n , this.user_c , this.role, this.ida) ;
        
               // np.setLogin(this.user_c) ;
              //  np.setRole(this.role);
                np.setVisible(true) ;
        
      this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));  
        
        
               
                //  newProd : end
                
                /*
        if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR") || this.role.equalsIgnoreCase("ADMINISTRATEUR")){
            
            ProductionTOuverte cptes = new ProductionTOuverte( this.nom , this.n , this.status , this.dtec , this.admin , this.role) ;
        
              //    cptes.setUser_c(this.user_c);
              //    cptes.setRole(this.role);
                  
        
                cptes.setVisible(true) ;
      //  this.setVisible(false) ;
            
        }else{
        
        ProductionTOuverteOrdi cptes = new ProductionTOuverteOrdi( this.nom , this.n , this.status , this.dtec , this.admin , this.role) ; ;
        
              //    cptes.setUser_c(this.user_c);
              //    cptes.setRole(this.role);
                  
        
                cptes.setVisible(true) ;
      //  this.setVisible(false) ;
            
        
        }
         */
                
        
               
            
            
            } 
            
            }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void anActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anActionPerformed
        // TODO add your handling code here:
        
      
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "POUR ANNULER UNE PRODUCTION SELECTIONNER DANS LE TABLEAU") ;
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
      
     int vy1 = 0 ;
     int vy2 = 0 ;
      
        String s1 = "SELECT * , sum(qte) FROM prodmp WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" GROUP BY article ORDER BY article ASC" ;
        String s2 = "SELECT * , sum(qte) FROM prodpf WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" GROUP BY article ORDER BY article ASC" ;
       
         
               // verification if qery is ok
     
         ResultSet rs10 = stmt.executeQuery(s1) ;
      
      
          while(rs10.next()){
              
      if(rs10.getLong("sum(qte)") > 0){
          vy1 = 1 ;
      }else if(rs10.getLong("sum(qte)") == 0){
          vy1 = 0 ;
          
      }  
       
     }
     
     
       ResultSet rs12 = stmt.executeQuery(s2) ;
      
      
     while(rs12.next()){
              
      if(rs12.getLong("sum(qte)") > 0){
          vy2 = 1 ;
      }else if(rs12.getLong("sum(qte)") == 0){
          vy2 = 0 ;
          
      }  
       
     }
     
        if(vy1 == 0 && vy2 == 0){
            
            
        clear1() ;
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
         
         
         
         if(stmt.executeUpdate("UPDATE prod SET status = 'fermer' , dtef = '"+this.verifyD+"' , etat = '"+this.et+"' WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n) == 1){
         
       String sql ;
      
       sql= "SELECT * FROM prod WHERE status = 'ouverte'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
     
      
        
        dtm.addRow(new Object[]{
            
   //   "PRODUCTION", "N°", "STATUS", "DEMARRER LE :", "UTILISATEUR  :"
            
          rs.getString("nom") , rs.getInt("n") , rs.getString("status") , rs.getString("etat") , rs.getString("dtec") 
       ,  rs.getString("admin")
        
        });
               
        
         
       
     }
      
         rs.close() ;
    
       
         }
      
    
            
        }else{
        
                
       JOptionPane jp = new JOptionPane() ;
       jp.showMessageDialog(null," Supprimer les matieres de la production pour pouvoir annuler svp ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
        
       
      
        }  
           
            
                //
      
            
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
            
            
            
            
        }
        
        
        
    }//GEN-LAST:event_anActionPerformed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
        
           
       this.nom = "" ;
       this.n = 0 ;
       this.status = "" ;
       this.dtec = "" ;
       this.dtef = "" ;
       this.admin = "" ;
       this.verify = "" ;
       
       
       this.nom = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString() ;
       this.n = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString()) ;
       this.status = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString() ;
       this.dtec = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString() ;
       this.dtef = jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString() ;
       this.admin = jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString() ;
       this.verify = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString() ;
        
          Connection conn = null ;
         Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...") ;
      
      stmt = conn.createStatement() ;
      
      // je crai ma requete
      
      
      
         
            long mt = 0 ;
            long mt1 = 0 ;
            
            String sql12 ; 
      
                  sql12 = "SELECT * FROM prodmp WHERE nom='"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n +" ORDER BY article" ;
      
                  ResultSet rs12 = stmt.executeQuery(sql12) ;
      
      
                 while(rs12.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                    
         
                     mt += rs12.getLong("montant") ;
        
                     }
                 
                  this.d.setText(nf3.format(mt)) ;
                 
                  
                   // tab :
                  String sql13 ;
      
                  sql13 = "SELECT * FROM prodpf WHERE nom='"+this.nom+"' AND n = "+this.n +" ORDER BY article";
      
                  ResultSet rs13 = stmt.executeQuery(sql13) ;
      
      
                 while(rs13.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     
                     mt1 += rs13.getLong("montant") ;
        
                     }
                 
                 
                 
                 this.r.setText(nf3.format(mt1)) ;
                 
                 this.p.setText(nf3.format((mt1 - mt) )) ;
                 
                 
        
/*
         
       this.r.setText(String.valueOf(rs.getLong("rec")));
       this.d.setText(String.valueOf(rs.getLong("dep")));
       this.p.setText(String.valueOf((rs.getLong("rec") - rs.getLong("dep"))));
               
  */      
         
       
     
      
          
      
     
      
    
            
      //STEP 6: Clean-up environment
      
     // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs13.close();
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
     
        
        
    }//GEN-LAST:event_jTable1KeyTyped

    private void rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:

      
        
        
        try{
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
       
        String dte1 = sdf.format(this.jDateChooser2.getDate()) ;
        String dte2 = sdf.format(this.jDateChooser1.getDate()) ;
     
        
        
          //  JOptionPane jp=new JOptionPane() ;
         //  jp.showMessageDialog(null,"selectionner une activité T svp","Avertissement",JOptionPane.WARNING_MESSAGE);
  
       
        
         Connection conn = null ;
         Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...") ;
      
      stmt = conn.createStatement();
      
      // je crai ma requete
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         dtm.setRowCount(0) ;
         this.d.setText(""); this.r.setText(""); this.p.setText("");
         
         String sql ;
      
       sql = "SELECT * FROM prod WHERE ( dtec LIKE '%"+dte1+"%' OR dtef LIKE '%"+dte2+"%' ) AND status = 'fermer' ORDER BY nom ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        

           dtm.addRow(new Object[]{
            
         //   "PRODUCTION", "N°", "STATUS", "DEMARRER LE :", "UTILISATEUR  :"
            
           rs.getString("nom") , rs.getInt("n") , rs.getString("status") , rs.getString("etat") , sdf1.format(rs.getTimestamp("dtec")) 
       , sdf1.format(rs.getTimestamp("dtef")) , rs.getString("admin")
        
        
        });
               
               
        
         
       
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
             try{
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss") ;
       
        String dte1 = sdf.format(this.jDateChooser2.getDate()) ;
    //    String dte2 = sdf.format(this.jDateChooser1.getDate()) ;
     
        
        
          //  JOptionPane jp=new JOptionPane() ;
         //  jp.showMessageDialog(null,"selectionner une activité T svp","Avertissement",JOptionPane.WARNING_MESSAGE);
  
       
        
         Connection conn = null ;
         Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...") ;
      
      stmt = conn.createStatement();
      
      // je crai ma requete
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         dtm.setRowCount(0) ;
         this.d.setText(""); this.r.setText(""); this.p.setText("");
         
         String sql ;
      
       sql = "SELECT * FROM prod WHERE dtec LIKE '%"+dte1+"%' AND status = 'fermer' ORDER BY nom ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        

          dtm.addRow(new Object[]{
            
         //   "PRODUCTION", "N°", "STATUS", "DEMARRER LE :", "UTILISATEUR  :"
            
           rs.getString("nom") , rs.getInt("n") , rs.getString("status") , rs.getString("etat") , sdf1.format(rs.getTimestamp("dtec")) 
       , sdf1.format(rs.getTimestamp("dtef")) , rs.getString("admin")
        
        
        });
               
        
         
       
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
   }catch(Exception e2){
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
        
        
      
        
        }catch(Exception e1){
             try{
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss") ;
       
       // String dte1 = sdf.format(this.jDateChooser2.getDate()) ;
          String dte2 = sdf.format(this.jDateChooser1.getDate()) ;
     
        
        
          //  JOptionPane jp=new JOptionPane() ;
         //  jp.showMessageDialog(null,"selectionner une activité T svp","Avertissement",JOptionPane.WARNING_MESSAGE);
  
       
        
         Connection conn = null ;
         Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...") ;
      
      stmt = conn.createStatement();
      
      // je crai ma requete
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         dtm.setRowCount(0) ;
         this.d.setText(""); this.r.setText(""); this.p.setText("");
         
         String sql ;
      
       sql = "SELECT * FROM prod WHERE dtef LIKE '%"+dte2+"%' AND status = 'fermer' ORDER BY nom ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        

          dtm.addRow(new Object[]{
            
         //   "PRODUCTION", "N°", "STATUS", "DEMARRER LE :", "UTILISATEUR  :"
            
           rs.getString("nom") , rs.getInt("n") , rs.getString("status") , rs.getString("etat") , sdf1.format(rs.getTimestamp("dtec")) 
       , sdf1.format(rs.getTimestamp("dtef")) , rs.getString("admin")
        
        
        });
               
        
         
       
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
   }catch(Exception e4){
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
        
        
      
        
        }catch(Exception e3){
            JOptionPane.showMessageDialog(this,"Selectionner les 2 date svp");
        }
        
        }
        
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
         if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selectionner une production dans le tableau") ;
        }else{
        this.jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        
        HistoriqueBon hb = new HistoriqueBon(this.nom , this.n , this.role, Long.parseLong("0")) ;
        
        
        hb.setVisible(true);
        
       this.jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
       
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        
          
       this.nom = "" ;
       this.n = 0 ;
       this.status = "" ;
       this.dtec = "" ;
       this.dtef = "" ;
       this.admin = "" ;
       this.verify = "" ;
       this.ida = 0 ;
       
       
       this.nom = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString() ;
       this.n = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString()) ;
       this.status = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString() ;
       this.dtec = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString() ;
       this.dtef = jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString() ;
       this.admin = jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString() ;
       this.verify = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString() ;
        
           Connection conn = null ;
         Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...") ;
      
      stmt = conn.createStatement() ;
      
      // je crai ma requete
      
      
      
         
            long mt = 0 ;
            long mt1 = 0 ;
            
            String sql12 ; 
      
                  sql12 = "SELECT * FROM prodmp WHERE nom='"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n +" ORDER BY article" ;
      
                  ResultSet rs12 = stmt.executeQuery(sql12) ;
      
      
                 while(rs12.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                    
         
                     mt += rs12.getLong("montant") ;
        
                     }
                 
                  this.d.setText(nf3.format(mt)) ;
                 
                  
                   // tab :
                  String sql13 ;
      
                  sql13 = "SELECT * FROM prodpf WHERE nom='"+this.nom+"' AND n = "+this.n +" ORDER BY article";
      
                  ResultSet rs13 = stmt.executeQuery(sql13) ;
      
      
                 while(rs13.next()){
   
                     // "DESCRIPTION", "QTE", "P.U", "MONTANT"
                     
                     
                     mt1 += rs13.getLong("montant") ;
        
                     }
                 
                 this.r.setText(nf3.format(mt1)) ;
                 
                 this.p.setText(nf3.format((mt1 - mt) )) ;
                 
                 
        
/*
         
       this.r.setText(String.valueOf(rs.getLong("rec")));
       this.d.setText(String.valueOf(rs.getLong("dep")));
       this.p.setText(String.valueOf((rs.getLong("rec") - rs.getLong("dep"))));
               
  */      
         
       //  this.ida = 0 ;
         // ( nomp = '"+this.nom.replaceAll("'", "''")+"' OR idp = "+this.ida+" )
         String sql0 ;
      
       sql0 = "SELECT distinct id FROM activite_t WHERE description = '"+this.nom+"'" ;
      
       ResultSet rs0 = stmt.executeQuery(sql0);
      
      
     while(rs0.next()){
        
        this.ida = rs0.getLong("id") ;
        
       
     }
         
     
      
          
      
     
      
    
            
      //STEP 6: Clean-up environment
      
     // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs13.close();
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
     
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased
int et1 = 0 ; int et2 = 0 ;
    private void prKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prKeyReleased
        // TODO add your handling code here:
        
        if(et1 == 0 && et2 == 0){
        
        
         String n1 = this.pr.getText().replaceAll("'", "''") ;
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        
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
      
      
  
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         dtm.setRowCount(0) ;
         
       String sql ;
      
       sql = "SELECT * FROM prod WHERE nom LIKE '%"+n1+"%' AND status = 'fermer' ORDER BY id DESC LIMIT 110" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        

        dtm.addRow(new Object[]{
            
         //   "PRODUCTION", "N°", "STATUS", "DEMARRER LE :", "UTILISATEUR  :"
            
           rs.getString("nom") , rs.getInt("n") , rs.getString("status") , rs.getString("etat") , sdf1.format(rs.getTimestamp("dtec")) 
         , sdf1.format(rs.getTimestamp("dtef")) , rs.getString("admin")
        
        
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
        
        
        
        }else if(et1 == 1 ){
            
            
            
         String n1 = this.pr.getText().replaceAll("'", "''") ;
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        
        if("".equalsIgnoreCase(n1)){
        
          //  JOptionPane jp=new JOptionPane() ;
         //  jp.showMessageDialog(null,"selectionner une activité T svp","Avertissement",JOptionPane.WARNING_MESSAGE);
  
        
        }else{
        
        
        
         Connection conn = null ;
         Statement stmt = null ;
       
       try{
           
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
           String dte1 = sdf.format(this.jDateChooser2.getDate()) ;
           
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
      
  
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         dtm.setRowCount(0) ;
         
       String sql ;
      
       sql = "SELECT * FROM prod WHERE nom LIKE '%"+n1+"%' AND status = 'fermer' AND dtec LIKE '%"+dte1+"%' ORDER BY id DESC LIMIT 110" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        

        dtm.addRow(new Object[]{
            
         //   "PRODUCTION", "N°", "STATUS", "DEMARRER LE :", "UTILISATEUR  :"
            
           rs.getString("nom") , rs.getInt("n") , rs.getString("status") , rs.getString("etat") , sdf1.format(rs.getTimestamp("dtec")) 
       , sdf1.format(rs.getTimestamp("dtef")) , rs.getString("admin")
        
        
        });
               
        
         
       
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
        
        
            
            
        }else if(et2 == 1){
        
                 
         String n1 = this.pr.getText().replaceAll("'", "''") ;
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
        
        if("".equalsIgnoreCase(n1)){
        
          //  JOptionPane jp=new JOptionPane() ;
         //  jp.showMessageDialog(null,"selectionner une activité T svp","Avertissement",JOptionPane.WARNING_MESSAGE);
  
        
        }else{
        
        
        
         Connection conn = null ;
         Statement stmt = null ;
       
       try{
           
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
           String dte1 = sdf.format(this.jDateChooser2.getDate()) ;
           
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
      
  
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         dtm.setRowCount(0) ;
         
       String sql ;
      
       sql = "SELECT * FROM prod WHERE nom LIKE '%"+n1+"%' AND status = 'fermer' AND dtef LIKE '%"+dte1+"%' ORDER BY id DESC LIMIT 110" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        

        dtm.addRow(new Object[]{
            
         //   "PRODUCTION", "N°", "STATUS", "DEMARRER LE :", "UTILISATEUR  :"
            
           rs.getString("nom") , rs.getInt("n") , rs.getString("status") , rs.getString("etat") , sdf1.format(rs.getTimestamp("dtec")) 
       , sdf1.format(rs.getTimestamp("dtef")) , rs.getString("admin")
        
        
        });
               
        
         
       
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
        
        
          
            
        }else if(et1 == 1 && et2 == 1){
            
        }
        
        
        
    }//GEN-LAST:event_prKeyReleased

    private void jDateChooser2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser2MouseReleased
        // TODO add your handling code here:
        
        this.et1 = 1 ;
        
    }//GEN-LAST:event_jDateChooser2MouseReleased

    private void jDateChooser1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseReleased
        // TODO add your handling code here:
        
        this.et2 = 1 ;
        
    }//GEN-LAST:event_jDateChooser1MouseReleased

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
            java.util.logging.Logger.getLogger(ProdFermer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdFermer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdFermer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdFermer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ProdFermer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton an;
    private javax.swing.JFormattedTextField d;
    private javax.swing.JLabel d1;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JFormattedTextField p;
    private javax.swing.JLabel p1;
    private javax.swing.JTextField pr;
    private javax.swing.JFormattedTextField r;
    private javax.swing.JLabel r1;
    // End of variables declaration//GEN-END:variables
}
