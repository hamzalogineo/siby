/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import entity.ActiviteT;
import static frontend.ProductionT.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
public class FamilleSousF extends javax.swing.JFrame {

    /**
     * Creates new form FamilleSousF
     */
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      String dc = "" ;
      String admin = "" ;
      
      long id = 0 ;
      long id1 = 0 ;
      String role = "" ;
    
    public FamilleSousF() {
        initComponents() ;
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
        
       
        
     
        
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
        
        
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm1.setRowCount(0) ;
        
       
       
        
        //
       
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
        
        
        
        
        //  ---------  2è choix
              
        
        
        
        
       //   ---------------
        
        
        //
        
       
        
     
        
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        
      
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm2.setRowCount(0) ;
        
       
       
        
        //
        
        DateFormat datef = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss") ;
        Date date = new Date() ;
        this.dc = datef.format(date) ;
      //  System.out.println(this.dc) ;
        
        
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
      
      
      
      
          
      
        
       String sql ;
      
       sql= "SELECT * FROM famille ORDER BY nom" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
             
        dtm2.addRow(new Object[]{
     
     //  "REF", "FAMILLES", "DATE", "UTILISATEUR"

       rs.getInt("id") , rs.getString("nom") , rs.getString("dtc") , rs.getString("admin")
       
        }) ;
    
 
     }
     
     
     
      
     
      String sql0 ;
      
         sql0 = "SELECT * FROM sfamille , famille Where (famille.id = sfamille.idf OR famille.nom = sfamille.rflle) ORDER BY sfamille.nom" ;
      
         ResultSet rs0 = stmt.executeQuery(sql0) ;
      
      
        while(rs0.next()){
         
        dtm1.addRow(new Object[]{
     
     //  "REF", "FAMILLES", "DATE", "UTILISATEUR"

       rs0.getInt("sfamille.id") , rs0.getString("sfamille.nom") , rs0.getString("famille.nom"), rs0.getString("sfamille.dtc") , 
       rs0.getString("sfamille.admin")
       
        }) ;
  
       
     }
          
        
     
     String sql3 ;
      
       sql3 = "SELECT * FROM famille ORDER BY nom" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3) ;
      
      
     while(rs3.next()){
             
        this.rf.addItem(rs3.getString("nom"))  ;
 
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

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public void setAjouterf() {
        this.ajouterf.setEnabled(false);
    }

    public void setAjoutersf() {
        this.ajoutersf.setEnabled(false);
    }

    public void setModifierf() {
        this.modifierf.setEnabled(false);
    }

    public void setModifiersf() {
        this.modifiersf.setEnabled(false);
    }

    public void setSupprimerf() {
        this.supprimerf.setEnabled(false);
    }

    public void setSupprimersf() {
        this.supprimersf.setEnabled(false);
    }

    public void setRole(String role) {
        this.role = role;
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
        f = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ajouterf = new javax.swing.JButton();
        modifierf = new javax.swing.JButton();
        supprimerf = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        sf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ajoutersf = new javax.swing.JButton();
        modifiersf = new javax.swing.JButton();
        supprimersf = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        f1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        f2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rf = new javax.swing.JComboBox();
        jButton8 = new javax.swing.JButton();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DES FAMILLE ET SOUS FAMILLE ");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        f.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("FAMILLE PRODUIT :");

        ajouterf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ajouterf.setText("AJOUTER");
        ajouterf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterfActionPerformed(evt);
            }
        });

        modifierf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        modifierf.setText("MODIFIER");
        modifierf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierfActionPerformed(evt);
            }
        });

        supprimerf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        supprimerf.setText("SUPPRIMER");
        supprimerf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerfActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "REF", "SOUS - FAMILLES", "FAMILLE", "DATE", "UTILISATEUR"
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(2);
        }

        sf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("SOUS FAMILLE PRODUIT :");

        ajoutersf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ajoutersf.setText("AJOUTER");
        ajoutersf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutersfActionPerformed(evt);
            }
        });

        modifiersf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        modifiersf.setText("MODIFIER");
        modifiersf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifiersfActionPerformed(evt);
            }
        });

        supprimersf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        supprimersf.setText("SUPPRIMER");
        supprimersf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimersfActionPerformed(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "REF", "FAMILLES", "DATE", "UTILISATEUR"
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
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(2);
        }

        f1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f1KeyPressed(evt);
            }
        });

        jLabel6.setText("FAMILLE");

        f2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f2KeyPressed(evt);
            }
        });

        jLabel7.setText("SOUS FAMILLE");

        rf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR UNE FAMILLE" }));
        rf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(supprimerf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ajouterf, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modifierf, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(supprimersf)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ajoutersf, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(modifiersf, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(sf)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(rf, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modifiersf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ajoutersf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(supprimersf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(f2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ajouterf, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(supprimerf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(modifierf)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(22, 22, 22))
        );

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton8.setText("ACTUALISER");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void f1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f1KeyPressed
        // TODO add your handling code here:
        
        
           String r1 = this.f1.getText().replaceAll("'", "''").trim() ;
           
           if("".equalsIgnoreCase(r1)){
               
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
      
      
      
     clear2() ;
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
         
       String sql ;
      
         sql = "SELECT * FROM famille WHERE nom LIKE '%"+r1+"%' ORDER BY nom" ;
      
         ResultSet rs = stmt.executeQuery(sql) ;
      
      
        while(rs.next()){
         
        dtm.addRow(new Object[]{
     
     //  "REF", "FAMILLES", "DATE", "UTILISATEUR"

       rs.getInt("id") , rs.getString("nom") , rs.getString("dtc") , rs.getString("admin")
       
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
        
        
    }//GEN-LAST:event_f1KeyPressed

    private void f2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f2KeyPressed
        // TODO add your handling code here:
        
        
        
           String r1 = this.f2.getText().replaceAll("'", "''").trim() ;
           
           if("".equalsIgnoreCase(r1)){
               
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
      
         sql = "SELECT * FROM sfamille WHERE nom LIKE '%"+r1+"%' ORDER BY nom" ;
      
         ResultSet rs = stmt.executeQuery(sql) ;
      
      
        while(rs.next()){
         
        dtm.addRow(new Object[]{
     
     //  "REF", "FAMILLES", "DATE", "UTILISATEUR"

       rs.getInt("id") , rs.getString("nom") , rs.getString("rflle"), rs.getString("dtc") , rs.getString("admin")
       
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
        
        
        
        
        
    }//GEN-LAST:event_f2KeyPressed

    private void ajouterfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterfActionPerformed
        // TODO add your handling code here:
                
                
                       SessionFactory sf=new Configuration().configure().buildSessionFactory();
                       Session s=sf.openSession();
           
         List entreprise = s.createSQLQuery("SELECT * FROM famille WHERE nom = '"+this.f.getText().trim().replaceAll("'", "''")+"' ").list();
       
         
               // verification if qery is ok
            
            if(entreprise.size() == 1){
                JOptionPane.showMessageDialog(this, "La famille existe dejà ")  ;
             }else{
                
                
        
           String r1 = this.f.getText().replaceAll("'", "''").trim() ;
           
           if("".equalsIgnoreCase(r1)){
               JOptionPane.showMessageDialog(this, "SAISIR UNE FAMILLE SVP") ;
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
      
      
      
      jTable2.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
                                
    },
    new String [] {
          "REF", "FAMILLES", "DATE", "UTILISATEUR"
    })
) ;
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
         
         
         if(stmt.executeUpdate("INSERT INTO famille(nom,dtc,admin) VALUES('"+r1+"' , '"+this.dc+"' , '"+this.admin+"')") == 1){
         
             this.f.setText("") ;
         
         String sql ;
      
         sql = "SELECT * FROM famille ORDER BY nom" ;
      
         ResultSet rs = stmt.executeQuery(sql) ;
      
      
        while(rs.next()){
         
        dtm.addRow(new Object[]{
     
     //  "REF", "FAMILLES", "DATE", "UTILISATEUR"

       rs.getInt("id") , rs.getString("nom") , rs.getString("dtc") , rs.getString("admin")
       
        }) ;
  
       
     }
          
        
          rs.close();
      
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
        
        
               
               
               
           }
        
            }
            
            
    }//GEN-LAST:event_ajouterfActionPerformed

    private void ajoutersfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutersfActionPerformed
        // TODO add your handling code here:
        
        
            SessionFactory sf=new Configuration().configure().buildSessionFactory();
                       Session s=sf.openSession();
           
         List entreprise = s.createSQLQuery("SELECT * FROM sfamille WHERE nom = '"+this.sf.getText().trim().replaceAll("'", "''")+"' ").list();
       
         
               // verification if qery is ok
            
            if(entreprise.size() == 1){
                JOptionPane.showMessageDialog(this, "La sous - famille existe dejà ")  ;
             }else{
                
                
        
        
            String r1 = this.sf.getText().replaceAll("'", "''").trim() ;
           
           if("".equalsIgnoreCase(r1) || this.rf.getSelectedItem().toString().equalsIgnoreCase("CHOISIR UNE FAMILLE")){
               JOptionPane.showMessageDialog(this, "SAISIR UNE SOUS - FAMILLE ET SELECTIONNER SA FAMILLE SVP") ;
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
      
      
      
      jTable1.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
                                
    },
    new String [] {
          "REF", "SOUS - FAMILLES", "FAMILLE", "DATE", "UTILISATEUR"
    })
) ;
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
         
         if(stmt.executeUpdate("INSERT INTO sfamille(nom,dtc,admin,rflle,idf) VALUES('"+r1+"' , '"+this.dc+"' , '"+this.admin+"' , '"+this.rf.getSelectedItem().toString().replaceAll("'", "''").trim()+"' , "+this.idf+")") == 1){
         
             this.sf.setText("") ;
             this.rf.setSelectedItem("CHOISIR UNE FAMILLE") ;
         
         String sql ;
      
         sql = "SELECT * FROM sfamille , famille Where (famille.id = sfamille.idf OR famille.nom = sfamille.rflle) ORDER BY sfamille.nom" ;
      
         ResultSet rs = stmt.executeQuery(sql) ;
      
      
        while(rs.next()){
         
        dtm.addRow(new Object[]{
     
     //  "REF", "FAMILLES", "DATE", "UTILISATEUR"

       rs.getInt("sfamille.id") , rs.getString("sfamille.nom") , rs.getString("famille.nom"), rs.getString("sfamille.dtc") , rs.getString("sfamille.admin")
       
        }) ;
  
       
     }
          
        
          rs.close();
      
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
        
        
               
               
               
           }
        
        
            }
        
    }//GEN-LAST:event_ajoutersfActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        
       
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void modifierfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierfActionPerformed
        // TODO add your handling code here:
        String oldF = "" ;
        
        if(this.jTable2.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "SELCTIONNER DANS LE TABLEAU SVP");
        }else{
            
            oldF = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString() ;
            
            String fn = this.f.getText().trim().replaceAll("'", "''") ;
            
            if("".equalsIgnoreCase(fn)){
                
                JOptionPane.showMessageDialog(this, "Saisir une famille SVP");
                
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
      
      
      
      jTable2.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
                                
    },
    new String [] {
          "REF", "FAMILLES", "DATE", "UTILISATEUR"
    })
) ;
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
         
         
         if(stmt.executeUpdate("UPDATE famille SET nom = '"+fn+"' WHERE id = "+this.id) == 1){
              if(stmt.executeUpdate("UPDATE produits_f SET f = '"+fn+"' WHERE f = '"+oldF.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("UPDATE produits_f SET f = '"+fn+"' WHERE f = '"+oldF.replaceAll("'", "''")+"'") == 0){
                   if(stmt.executeUpdate("UPDATE matieres_p SET condition_livraison = '"+fn+"' WHERE condition_livraison = '"+oldF.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("UPDATE matieres_p SET condition_livraison = '"+fn+"' WHERE condition_livraison = '"+oldF.replaceAll("'", "''")+"'") == 0){
                       if(stmt.executeUpdate("UPDATE stock1 SET f = '"+fn+"' WHERE f = '"+oldF.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("UPDATE stock1 SET f = '"+fn+"' WHERE f = '"+oldF.replaceAll("'", "''")+"'") == 0){
                            if(stmt.executeUpdate("UPDATE sfamille SET rflle = '"+fn+"' WHERE rflle = '"+oldF.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("UPDATE sfamille SET rflle = '"+fn+"' WHERE rflle = '"+oldF.replaceAll("'", "''")+"'") == 0){
                                if(stmt.executeUpdate("UPDATE cumulvente SET f = '"+fn+"' WHERE f = '"+oldF.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("UPDATE cumulvente SET f = '"+fn+"' WHERE f = '"+oldF.replaceAll("'", "''")+"'") == 0){
         
                                // cumulvente
                                
              this.f.setText("") ;
         
         String sql ;
      
         sql = "SELECT * FROM famille ORDER BY nom" ;
      
         ResultSet rs = stmt.executeQuery(sql) ;
      
      
        while(rs.next()){
         
        dtm.addRow(new Object[]{
     
     //  "REF", "FAMILLES", "DATE", "UTILISATEUR"

       rs.getInt("id") , rs.getString("nom") , rs.getString("dtc") , rs.getString("admin")
       
        }) ;
  
       
     }
          
        
          rs.close();
      
         }
      
       }
              
       }
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
        
        
               
            }     
            
            
        }
        
    }//GEN-LAST:event_modifierfActionPerformed

    private void modifiersfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifiersfActionPerformed
        // TODO add your handling code here:
        
        
          if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "SELCTIONNER DANS LE TABLEAU SVP");
        }else{
            String oldF = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString() ;
            
            String fn = this.sf.getText().trim().replaceAll("'", "''") ;
            
            if("".equalsIgnoreCase(fn) || this.rf.getSelectedItem().toString().equalsIgnoreCase("CHOISIR UNE FAMILLE")){
               JOptionPane.showMessageDialog(this, " SELECTIONNER SA FAMILLE SVP") ;
                
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
      
      
      
      jTable1.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
                                
    },
    new String [] {
          "REF", "SOUS - FAMILLES", "FAMILLE", "DATE", "UTILISATEUR"
    })
) ;
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
         
         if(stmt.executeUpdate("UPDATE sfamille SET nom = '"+fn+"' , rflle = '"+this.rf.getSelectedItem().toString().replaceAll("'", "''")+"' WHERE id = "+this.id1) == 1){
            if(stmt.executeUpdate("UPDATE produits_f SET sf = '"+fn+"' WHERE sf = '"+oldF.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("UPDATE produits_f SET sf = '"+fn+"' WHERE sf = '"+oldF.replaceAll("'", "''")+"'") == 0){
                   if(stmt.executeUpdate("UPDATE matieres_p SET conservation = '"+fn+"' WHERE conservation = '"+oldF.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("UPDATE matieres_p SET conservation = '"+fn+"' WHERE conservation = '"+oldF.replaceAll("'", "''")+"'") == 0){
                       if(stmt.executeUpdate("UPDATE stock1 SET sf = '"+fn+"' WHERE sf = '"+oldF.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("UPDATE stock1 SET sf = '"+fn+"' WHERE sf = '"+oldF.replaceAll("'", "''")+"'") == 0){
                           if(stmt.executeUpdate("UPDATE cumulvente SET sf = '"+fn+"' WHERE sf = '"+oldF.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("UPDATE cumulvente SET sf = '"+fn+"' WHERE sf = '"+oldF.replaceAll("'", "''")+"'") == 0){
         
             this.sf.setText("") ;
             this.rf.setSelectedItem("CHOISIR UNE FAMILLE") ;
         
         String sql ;
      
         sql = "SELECT * FROM sfamille ORDER BY nom" ;
      
         ResultSet rs = stmt.executeQuery(sql) ;
      
      
        while(rs.next()){
         
        dtm.addRow(new Object[]{
     
     //  "REF", "FAMILLES", "DATE", "UTILISATEUR"

       rs.getInt("id") , rs.getString("nom") , rs.getString("rflle") , rs.getString("dtc") , rs.getString("admin")
       
        }) ;
  
       
     }
          
        
          rs.close();
      
         }
      
         }
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
        
        
               
            }     
            
            
        }
        
        
        
    }//GEN-LAST:event_modifiersfActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        
         
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void supprimerfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerfActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable2.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this , "Selectionner dans le tableau svp") ;
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
      
      
      
      jTable2.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
                                
    },
    new String [] {
          "REF", "FAMILLES", "DATE", "UTILISATEUR"
    })
) ;
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
         
         
         if(stmt.executeUpdate("DELETE FROM famille WHERE id = "+this.id) == 1){
         
              this.f.setText("") ;
         
         String sql ;
      
         sql = "SELECT * FROM famille ORDER BY nom" ;
      
         ResultSet rs = stmt.executeQuery(sql) ;
      
      
        while(rs.next()){
         
        dtm.addRow(new Object[]{
     
     //  "REF", "FAMILLES", "DATE", "UTILISATEUR"

       rs.getInt("id") , rs.getString("nom") , rs.getString("dtc") , rs.getString("admin")
       
        }) ;
  
       
     }
          
        
          rs.close();
      
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
                 
            
            
        }
        
        
    }//GEN-LAST:event_supprimerfActionPerformed

    private void supprimersfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimersfActionPerformed
        // TODO add your handling code here:
        
        
          
          if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "SELCTIONNER DANS LE TABLEAU SVP");
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
      
      
      
      jTable1.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
                                
    },
    new String [] {
          "REF", "SOUS - FAMILLES", "FAMILLE", "DATE", "UTILISATEUR"
    })
) ;
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
         
         if(stmt.executeUpdate("DELETE FROM sfamille WHERE id = "+this.id1) == 1){
         
             this.sf.setText("") ;
             this.rf.setSelectedItem("CHOISIR UNE FAMILLE") ;
         
         String sql ;
      
         sql = "SELECT * FROM sfamille ORDER BY nom" ;
      
         ResultSet rs = stmt.executeQuery(sql) ;
      
      
        while(rs.next()){
         
        dtm.addRow(new Object[]{
     
     //  "REF", "FAMILLES", "DATE", "UTILISATEUR"

       rs.getInt("id") , rs.getString("nom") , rs.getString("rflle") , rs.getString("dtc") , rs.getString("admin")
       
        }) ;
  
       
     }
          
        
          rs.close();
      
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
        
        
               
            }     
            
            
      
        
        
        
        
        
    }//GEN-LAST:event_supprimersfActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
      
        /*
         FamilleSousF fl = new FamilleSousF() ;
        
              fl.setAdmin(this.admin) ;
        
        fl.setVisible(true) ;
        this.setVisible(false) ;
        */
        
         FamilleSousF fl = new FamilleSousF() ;
        
              fl.setAdmin(this.admin) ;
              fl.setRole(role);
              
              if(this.role.equalsIgnoreCase("ADMINISTRATEUR") || this.role.equalsIgnoreCase("ADMINII")){
                    fl.setAjouterf();
                    fl.setAjoutersf();
                    fl.setModifierf();
                    fl.setModifiersf();
                    fl.setSupprimerf();
                    fl.setSupprimersf();
                  }
        
        fl.setVisible(true) ;
        this.setVisible(false) ;
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyTyped
        // TODO add your handling code here:
        
          this.id = 0 ;
        
        this.id = Long.parseLong(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString()) ;
        
        this.f.setText(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString());
        
        
    }//GEN-LAST:event_jTable2KeyTyped

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
        
        
            this.id1 = 0 ;
        
            this.id1 = Long.parseLong(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString()) ;
        
            this.sf.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString());
        
        
            
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
         this.id = 0 ;
        
         this.id = Long.parseLong(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString()) ;
        
         this.f.setText(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString());
        
        
        
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
            this.id1 = 0 ;
        
            this.id1 = Long.parseLong(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString()) ;
        
            this.sf.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString());
        
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased
long idf = 0 ;
    private void rfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfActionPerformed
        // TODO add your handling code here:
        
        this.idf = 0 ;
        String fm = this.rf.getSelectedItem().toString().replaceAll("'", "''") ;
        
        if(fm.equalsIgnoreCase("CHOISIR UNE FAMILLE")){
            
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
       
        
       String sql ;
      
       sql= "SELECT distinct id FROM famille WHERE nom = '"+this.rf.getSelectedItem().toString().replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
             
        this.idf = rs.getLong("id") ;
    
 
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
        
        
    }//GEN-LAST:event_rfActionPerformed

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
            java.util.logging.Logger.getLogger(FamilleSousF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FamilleSousF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FamilleSousF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FamilleSousF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FamilleSousF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouterf;
    private javax.swing.JButton ajoutersf;
    private javax.swing.JTextField f;
    private javax.swing.JTextField f1;
    private javax.swing.JTextField f2;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton modifierf;
    private javax.swing.JButton modifiersf;
    private javax.swing.JComboBox rf;
    private javax.swing.JTextField sf;
    private javax.swing.JButton supprimerf;
    private javax.swing.JButton supprimersf;
    // End of variables declaration//GEN-END:variables
}
