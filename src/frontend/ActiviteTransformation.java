/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import entity.ActiviteT;
import entity.Clients;
import static frontend.Clients1.JDBC_DRIVER;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
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
public class ActiviteTransformation extends javax.swing.JFrame {

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
    
      long id = 0 ;
      
      String nom;
      
      
    public ActiviteTransformation() {
        initComponents();
       this.setLocationRelativeTo(null) ;
        //this.setExtendedState(MAXIMIZED_BOTH) ;
        
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
      
 //    DefaultTableModel dtm=(DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
       sql= "SELECT * FROM activite_t , gs WHERE (gs.id = activite_t.idg OR gs.nom = activite_t.libelle) ORDER BY description" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
     
      
        
        dtm.addRow(new Object[]{
            
   // "ref.Activité", "Description", "Groupe", "Date Demarrage", "Admin"
            
          rs.getLong("id") , rs.getString("description") ,rs.getString("gs.nom") , rs.getString("datedemarrage") 
       ,  rs.getString("admin")
        
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
    
    
     public ActiviteTransformation(String role) {
        initComponents();
       this.setLocationRelativeTo(null) ;
        //this.setExtendedState(MAXIMIZED_BOTH) ;
        
             //
       this.role = role ;
       
       if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR")){
           
       }else{
           
           this.jButton3.setEnabled(false) ;
           this.supprimer.setEnabled(false) ;
           
       }
       
       
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
      
 //    DefaultTableModel dtm=(DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
       sql= "SELECT * FROM activite_t , gs WHERE (gs.id = activite_t.idg OR gs.nom = activite_t.libelle) ORDER BY description" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
     
      
        
        dtm.addRow(new Object[]{
            
   // "ref.Activité", "Description", "Groupe", "Date Demarrage", "Admin"
            
          rs.getLong("id") , rs.getString("description") ,rs.getString("gs.nom") , rs.getString("datedemarrage") 
       ,  rs.getString("admin")
        
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

    public void setSupprimer() {
        this.supprimer.setEnabled(false);
    }

    public void setModifier() {
        this.modifier.setEnabled(false);
    }

    public void setImprimer() {
        this.imprimer.setEnabled(false);
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
        imprimer = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        desc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1097, 628));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 53));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DES ACTIVITES DE TRANSFORMATIONS ");

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

        imprimer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        imprimer.setText("IMPRIMER");
        imprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimerActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("LES PRODUITS FINIS");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText(" MATIERES PREMIERES");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("FORMULAIRE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("GESTION DE GROUPE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                    .addComponent(imprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(imprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("SAISIR LA DESCRIPTION :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ref.Activité", "Description", "Groupe", "Date Demarrage", "Admin"
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(283, 283, 283))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        // TODO add your handling code here:

        AddActiviteT af = new AddActiviteT() ;

        af.setAdmin(this.user_c) ;

        af.setVisible(true) ;
    }//GEN-LAST:event_ajouterActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        // TODO add your handling code here:

        if(jTable1.getSelectedRow() == -1){

            JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null,"Pour modifier une activité selectionner dans le tableau svp " ,"INFORMATION",JOptionPane.INFORMATION_MESSAGE);

        }else{

            SessionFactory sf = new Configuration().configure().buildSessionFactory();
            Session s = sf.openSession();

            ActiviteT cu = (ActiviteT) s.load(ActiviteT.class , this.id) ;

            ModActiviteT mf = new ModActiviteT() ;
            mf.setOldAct(this.oldDesc) ;
            mf.setId(cu.getId());

            mf.setLib(cu.getDescription());

            mf.setAdmin(this.user_c);
            mf.setDc(cu.getDatedemarrage());

            mf.setLibelle(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString()) ;

            mf.setjComboBox1(this.jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()) ;

            mf.setVisible(true) ;

        }
    }//GEN-LAST:event_modifierActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        // TODO add your handling code here:

        if(jTable1.getSelectedRow() == -1){

            JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null,"Pour supprimer une activité selectionner dans le tableau","INFORMATION",JOptionPane.INFORMATION_MESSAGE);

        }else{

            if(JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette Activité ? :"+" ","Confirmation",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){

                // ici je supprime le compte utilisateur :

                SessionFactory sf=new Configuration().configure().buildSessionFactory();
                Session s=sf.openSession();
                Transaction tr = s.beginTransaction();

                ActiviteT cu = (ActiviteT) s.load(ActiviteT.class , this.id) ;

                s.delete(cu) ;

                tr.commit();
                s.close();

                JOptionPane jp=new JOptionPane();
                jp.showMessageDialog(null," suppression reussit avec succes","INFORMATION",JOptionPane.INFORMATION_MESSAGE);

            }else{

            }

        }
    }//GEN-LAST:event_supprimerActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        /*
        ActiviteTransformation cptes = new ActiviteTransformation() ;

        cptes.setUser_c(this.user_c) ;
        cptes.setRole(this.role) ;
        cptes.setPhone(this.phone) ;

        if(this.role.equalsIgnoreCase("ADMINISTRATEUR")){
            cptes.setAjouter();
            cptes.setModifier();
            cptes.setSupprimer();
        }

        if(this.role.equalsIgnoreCase("ORDINAIRE")){
            cptes.setAjouter();
            cptes.setSupprimer();
            cptes.setModifier();
            cptes.setImprimer();
        }

        cptes.setVisible(true) ;
        this.setVisible(false) ;
        */

        // new

        ActiviteTransformation cptes = new ActiviteTransformation(this.role) ;

        cptes.setUser_c(this.user_c) ;
        cptes.setRole(this.role) ;
        cptes.setPhone(this.phone) ;

        if(this.role.equalsIgnoreCase("ORDINAIRE")){
            cptes.setAjouter();
            cptes.setSupprimer();
            cptes.setModifier();
            cptes.setImprimer();
        }

        cptes.setVisible(true) ;
        this.setVisible(false) ;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void imprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimerActionPerformed
        // TODO add your handling code here:

        this.imprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;

        try{

            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\transf.jrxml")) ;
            JasperDesign jd = JRXmlLoader.load(in) ;

            String sql = "SELECT\n" +
            "     activite_t.`id` AS activite_t_id,\n" +
            "     activite_t.`libelle` AS activite_t_libelle,\n" +
            "     activite_t.`description` AS activite_t_description,\n" +
            "     activite_t.`datedemarrage` AS activite_t_datedemarrage,\n" +
            "     activite_t.`admin` AS activite_t_admin\n" +
            "FROM\n" +
            "     `activite_t` activite_t ORDER BY activite_t.`description`" ;

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

        this.imprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_imprimerActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:

        if(jTable1.getSelectedRow() == -1){

            JOptionPane jp=new JOptionPane() ;
            jp.showMessageDialog(null,"Selectionner dans le tableau","INFORMATION",JOptionPane.INFORMATION_MESSAGE) ;

        }else{

            ProductionPf pf = new ProductionPf(this.id , this.role, jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString()) ;

            pf.setUser_c(this.user_c) ;

            //   pf.setIdp(this.id) ;
            pf.setId(String.valueOf(this.id)) ;
            //  pf.setNomP(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString()) ;
            pf.setNom(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());

            pf.setVisible(true) ;

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

        if(jTable1.getSelectedRow() == -1){

            JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null,"Selectionner dans le tableau","INFORMATION",JOptionPane.INFORMATION_MESSAGE);

        }else{

            ProductionMp pf = new ProductionMp(this.id, this.role, jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString()) ;

            pf.setUser_c(this.user_c) ;
            //   pf.setIdp(this.id) ;
            pf.setId(String.valueOf(this.id)) ;
            //  pf.setNomP(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString()) ;
            pf.setNom(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());

            pf.setVisible(true) ;

        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selectionner une production svp") ;
        }else{

            this.nom = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString().replaceAll("'", "''") ;

            try{
                Class.forName(JDBC_DRIVER);
                Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY);

                Connection connection2 = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement statement2 = connection2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY);

                ResultSet resultat = statement.executeQuery("SELECT nomp as nom , article as article, "
                    + " pv as pu FROM pmp WHERE nomp = '"+this.nom+"' AND idp = "+this.id+" ORDER BY article");

                ResultSet resultat2 = statement2.executeQuery("SELECT article as article2, "
                    + " pa as pu2 FROM ppf WHERE nomp = '"+this.nom+"' AND idp = "+this.id+" ORDER BY article ");

                //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\formulaire.jrxml")) ;
                InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\formulaire.jrxml")) ;

                List mlist;
                mlist = new ArrayList<>();
                while(resultat.next()) {
                    HashMap<String, Object> m = new HashMap<>();
                    m.put("nom", resultat.getString("nom"));
                    m.put("article", resultat.getString("article"));
                    m.put("pu", resultat.getInt("pu"));
                    mlist.add(m);
                }

                List mlist2;
                mlist2 = new ArrayList<>();
                while(resultat2.next()) {
                    HashMap<String, Object> m = new HashMap<>();
                    m.put("article2", resultat2.getString("article2"));
                    m.put("pu2", resultat2.getInt("pu2"));;
                    mlist2.add(m);
                }

                JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
                JRBeanCollectionDataSource jrbean2 = new JRBeanCollectionDataSource(mlist2);

                Map<String, Object> para = new HashMap<>();
                para.put("sql", jrbean);
                para.put("data", jrbean2);

                JasperReport report = JasperCompileManager.compileReport(in);
                JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
                JasperViewer.viewReport(print, false);

            }catch(Exception e){

                JOptionPane.showMessageDialog(null, e) ;
                System.out.println(e) ;

            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // TODO add your handling code here:

        Ggroupe gg = new Ggroupe() ;
        gg.setUser_c(user_c);
        gg.setVisible(true) ;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyPressed
        // TODO add your handling code here:

        String n1 = this.desc.getText().replaceAll("'", "''") ;

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

                clear() ;

                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;

                String sql ;

                sql = "SELECT * FROM activite_t WHERE description LIKE '%"+n1+"%' ORDER BY description" ;

                ResultSet rs = stmt.executeQuery(sql) ;

                while(rs.next()){

                    dtm.addRow(new Object[]{

                        // "ref.Activité", "Description", "Date Demarrage", "Admin"

                        rs.getLong("id") , rs.getString("description") , rs.getString("libelle") , rs.getString("datedemarrage")
                        ,  rs.getString("admin")

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
    }//GEN-LAST:event_descKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        
        // TODO add your handling code here :

        String code = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString() ;

        this.id = Long.parseLong(code) ;

        this.oldDesc = "" ;
        this.oldDesc = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString() ;
        System.out.println("oldDesc "+this.oldDesc) ;
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:

        String code = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString() ;

        this.id = Long.parseLong(code) ;
    }//GEN-LAST:event_jTable1KeyTyped
String oldDesc = "" ;
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
            java.util.logging.Logger.getLogger(ActiviteTransformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActiviteTransformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActiviteTransformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActiviteTransformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActiviteTransformation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JTextField desc;
    private javax.swing.JButton imprimer;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modifier;
    private javax.swing.JButton supprimer;
    // End of variables declaration//GEN-END:variables
}
