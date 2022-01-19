/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import entity.Fournisseurs;
import entity.ProduitsF;
import static frontend.ProduitFini.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Font;
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
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
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
public class Fournisseur extends javax.swing.JFrame {

    /**
     * Creates new form Fournisseur
     */
    
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
      String user_c ;
      String role ;
      String phone ;
    
      int id = 0 ;
      
      
      
    public Fournisseur() {
        initComponents();
        this.setLocationRelativeTo(null);
    
    
        //
        
        
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
      
       sql= "SELECT * FROM fournisseurs ORDER BY entreprise" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
      
        
        dtm.addRow(new Object[]{
            
      //   "ref.four", "Entreprise ", "Tel 1", "Tel 2", "Description", "Adresse", "Email"
            
           rs.getInt("id") ,  rs.getString("entreprise") , rs.getString("tel1") , rs.getString("tel2") ,
           rs.getString("description") , rs.getString("adresse") , rs.getString("email")
           
                
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
    
    
    // Gestion compte fourni :
    
         public Fournisseur(String role){
             
         initComponents() ;
         this.setLocationRelativeTo(null) ;
         this.role = role ;
         
         if(this.role.equalsIgnoreCase("ORDINAIRE")){
             
             this.ajouter.setEnabled(false)   ;
             this.modifier.setEnabled(false)  ;
             this.supprimer.setEnabled(false) ;
             this.jButton6.setEnabled(false)  ;
             this.jButton2.setEnabled(false)  ;
             
             
             
             
         }
        
    
    
        //
        
        
            this.jTable1.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable1.getTableHeader().setOpaque(false) ; 
            this.jTable1.getTableHeader().setBackground(Color.black) ; 
          
        //    this.jTable1.setBackground(Color.white) ;
        
       
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
      
       sql= "SELECT * FROM fournisseurs ORDER BY entreprise" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
      
        
        dtm.addRow(new Object[]{
            
      //   "ref.four", "Entreprise ", "Tel 1", "Tel 2", "Description", "Adresse", "Email"
            
           rs.getInt("id") ,  rs.getString("entreprise") , rs.getString("tel1") , rs.getString("tel2") ,
           rs.getString("description") , rs.getString("adresse") , rs.getString("email")
           
                
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
    
    
  //  End Gestion compte :
    
    
    
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

    public void setAjouter() {
        this.ajouter.setEnabled(false);
    }

    public void setModifier() {
        this.modifier.setEnabled(false);
    }

    public void setSupprimer() {
        this.supprimer.setEnabled(false);
    }

    
    private void clear() {

        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
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
        ajouter = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        fr = new javax.swing.JTextField();
        desc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DES FOURNISSEURS");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        ajouter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ajouter.setText("AJOUTER");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        modifier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        modifier.setText("MODIFIER");
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        supprimer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        supprimer.setText("SUPPRIMER");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("ACTUALISER");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("IMPRIMER");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton7.setText("DETAIL");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("COMPTE FOURNI.");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("OPERATIONS");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("SORTIE STOCK");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        fr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                frKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                frKeyTyped(evt);
            }
        });

        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("FOURNISSEUR / ENTREPRISE :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("DESCRIPTION");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(fr, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fr, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ref.four", "Entreprise ", "Tel 1", "Tel 2", "Description", "Adresse", "Email"
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(130);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(328, 328, 328))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
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

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        // TODO add your handling code here:
        
         if(jTable1.getSelectedRow() == -1){
           
            JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null,"Pour supprimer un fournisseur selectionner dans le tableau","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
            
            
        }else{
        
         if(JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer le fournisseur ? :"+" ","Confirmation",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            
             // ici je supprime le compte utilisateur :
             
             
              SessionFactory sf=new Configuration().configure().buildSessionFactory();
              Session s=sf.openSession();
              Transaction tr = s.beginTransaction();
             
             Fournisseurs cu = (Fournisseurs) s.load(Fournisseurs.class , this.id) ;
             
             
              s.delete(cu) ;
            
            
            
            tr.commit();
            s.close();
            
            
             JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null," suppression reussit avec succes","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
       
            
            }else{
            
                
            
            }
         
         
        
        }
        
        
    }//GEN-LAST:event_supprimerActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
         try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Fournissaire.jrxml")) ;
           //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\new-version-siby\\UtpaSibyCenter\\src\\reports\\Fournissaire.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql = "SELECT\n" +
"     fournisseurs.`id` AS fournisseurs_id,\n" +
"     fournisseurs.`entreprise` AS fournisseurs_entreprise,\n" +
"     fournisseurs.`tel1` AS fournisseurs_tel1,\n" +
"     fournisseurs.`tel2` AS fournisseurs_tel2,\n" +
"     fournisseurs.`nom_court` AS fournisseurs_nom_court,\n" +
"     fournisseurs.`service` AS fournisseurs_service,\n" +
"     fournisseurs.`description` AS fournisseurs_description,\n" +
"     fournisseurs.`adresse` AS fournisseurs_adresse,\n" +
"     fournisseurs.`email` AS fournisseurs_email,\n" +
"     fournisseurs.`datecreat` AS fournisseurs_datecreat,\n" +
"     fournisseurs.`admin` AS fournisseurs_admin\n" +
"FROM\n" +
"     `fournisseurs` fournisseurs ORDER BY fournisseurs.`entreprise`" ;
           
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
        this.jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        // TODO add your handling code here:
         AddFournisseur af = new AddFournisseur() ;
        
            af.setAdmin(this.user_c) ;
            
        af.setVisible(true) ;
        
        
        
    }//GEN-LAST:event_ajouterActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        // TODO add your handling code here:
        
        if(jTable1.getSelectedRow() == -1){
        
       JOptionPane jp=new JOptionPane();
       jp.showMessageDialog(null,"Pour modifier un fournisseur selectionner dans le tableau svp " ,"INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
        }else{
             
              SessionFactory sf = new Configuration().configure().buildSessionFactory();
              Session s = sf.openSession();
             
             Fournisseurs cu = (Fournisseurs) s.load(Fournisseurs.class , this.id) ;
        
          ModFournisseur mf = new ModFournisseur() ;
          
            mf.setId(cu.getId());
            mf.setEntr(cu.getEntreprise());
            mf.setTel(cu.getTel1());
            mf.setTel2(cu.getTel2());
            mf.setDesc(cu.getDescription());
            mf.setAdr(cu.getAdresse());
            mf.setEmail(cu.getEmail());
            mf.setAdmin(this.user_c);
            mf.setDc(cu.getDatecreat());
            mf.setFourniser(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString()) ;
           
            mf.setVisible(true) ;
            
        
         }
        
      
        
    }//GEN-LAST:event_modifierActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
       
        
        if(this.role.equalsIgnoreCase("ORDINAIRE")){
            
             Fournisseur cptes = new Fournisseur(this.role) ;

        cptes.setUser_c(this.user_c) ;
        cptes.setRole(this.role) ;
        cptes.setPhone(this.phone) ;

        cptes.setVisible(true) ;
        this.setVisible(false) ;
        
            
        }else if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR")){
            
             Fournisseur cptes = new Fournisseur() ;
        
                  cptes.setUser_c(this.user_c);
                  cptes.setRole(this.role);
                  cptes.setPhone(this.phone);
                  
                   cptes.setVisible(true) ;
                   this.setVisible(false) ;
            
            
            
        }else if(this.role.equalsIgnoreCase("ADMINISTRATEUR")){
            
            
            Fournisseur cptes = new Fournisseur() ;
        
                  cptes.setUser_c(this.user_c);
                  cptes.setRole(this.role);
                  cptes.setPhone(this.phone);
          
                  cptes.setSupprimer();
              
        
        cptes.setVisible(true) ;
        this.setVisible(false) ;
        
        }else if(this.role.equalsIgnoreCase("ADMINII")){
            
              Fournisseur cptes = new Fournisseur() ;
        
                  cptes.setUser_c(this.user_c);
                  cptes.setRole(this.role);
                  cptes.setPhone(this.phone);
          
                  cptes.setSupprimer();
              
        
        cptes.setVisible(true) ;
        this.setVisible(false) ;
            
        }
        
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void frKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_frKeyTyped
       
       //  TODO add your handling code here :
        
        
    //   System.out.println("enter is pressed") ;
        
    }//GEN-LAST:event_frKeyTyped

    private void frKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_frKeyPressed
        // TODO add your handling code here:
        
         
        String n1 = this.fr.getText().replaceAll("'", "''") ;
        
        
        if("".equalsIgnoreCase(n1)){
        
            // JOptionPane jp=new JOptionPane() ;
            // jp.showMessageDialog(null,"selectionner un fournisseur svp","Avertissement",JOptionPane.WARNING_MESSAGE);
  
        
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
      
      
      
       clear() ;
      
      
      
        DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
         
        String sql ;
      
        sql = "SELECT * FROM fournisseurs WHERE entreprise LIKE '%"+n1+"%' ORDER BY entreprise" ;
      
        ResultSet rs = stmt.executeQuery(sql) ;
      
      
        while(rs.next()){
        
        dtm.addRow(new Object[]{
            
     //  "ref.four", "Entreprise ", "Tel 1", "Tel 2", "Description", "Adresse", "Email"
            
          rs.getInt("id") ,  rs.getString("entreprise") , rs.getString("tel1") , rs.getString("tel2") ,
          rs.getString("description") , rs.getString("adresse") , rs.getString("email")
        
        
                
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
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_frKeyPressed

    private void descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyPressed
        // TODO add your handling code here:
        
        
        String n1 = this.desc.getText().replaceAll("'", "''") ;
        
        
        if("".equalsIgnoreCase(n1)){
        
            // JOptionPane jp=new JOptionPane() ;
            // jp.showMessageDialog(null,"selectionner un fournisseur svp","Avertissement",JOptionPane.WARNING_MESSAGE);
  
        
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
      
      
      
       clear() ;
      
      
      
        DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
         
        String sql ;
      
        sql = "SELECT * FROM fournisseurs WHERE description LIKE '%"+n1+"%' ORDER BY entreprise" ;
      
        ResultSet rs = stmt.executeQuery(sql) ;
      
      
        while(rs.next()){
        
        dtm.addRow(new Object[]{
            
     //  "ref.four", "Entreprise ", "Tel 1", "Tel 2", "Description", "Adresse", "Email"
            
          rs.getInt("id") ,  rs.getString("entreprise") , rs.getString("tel1") , rs.getString("tel2") ,
          rs.getString("description") , rs.getString("adresse") , rs.getString("email")
                
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

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
        
          if(jTable1.getSelectedRow() == -1){
           
            JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null," selectionner dans le tableau","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
            
            
        }else{
        
          
             
              SessionFactory sf=new Configuration().configure().buildSessionFactory();
              Session s=sf.openSession();
            
             
             Fournisseurs cu = (Fournisseurs) s.load(Fournisseurs.class , this.id) ;
             
             DetailFourni dpf = new DetailFourni(cu.getDatecreat() , cu.getAdmin()) ;
             dpf.setVisible(true) ;
            
            
           
         
        
        }
        
        
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
        
        String code = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString() ;
        
         this.id = Integer.parseInt(code) ;
         
         
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        
         String code = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString() ;
        
         this.id = Integer.parseInt(code) ;
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
              JOptionPane.showMessageDialog(null, "SELECTIONNER FOURNISSEUR") ;
          }else{
            
             Compte_fourni cf = new Compte_fourni(this.user_c, this.role, this.id) ;
                      cf.setVisible(true) ;
            
        }
        
       
                      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        Compte_fourni1 cf = new Compte_fourni1(this.user_c, this.role) ;
                      cf.setVisible(true) ;
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
          // TODO add your handling code here :
        
        Point_Sortie_stk dep = new Point_Sortie_stk(this.user_c , this.role) ; // Departement(this.user_c, this.role) ;
                    dep.setVisible(true) ;
                    
        
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
            java.util.logging.Logger.getLogger(Fournisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fournisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fournisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fournisseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fournisseur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JTextField desc;
    private javax.swing.JTextField fr;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modifier;
    private javax.swing.JButton supprimer;
    // End of variables declaration//GEN-END:variables
}
