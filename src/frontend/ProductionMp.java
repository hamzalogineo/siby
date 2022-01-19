/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import entity.ActiviteT;
import static frontend.ActiviteTransformation.JDBC_DRIVER;
import static frontend.AddProduitFini.JDBC_DRIVER;
import static frontend.MatierePri.JDBC_DRIVER;
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
import javax.swing.JLabel;
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
public class ProductionMp extends javax.swing.JFrame {

    /**
     * Creates new form ProductionMp
     */
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
      String user_c = "";
      String role = "";
      String cb = ""; String descD = "" ;
      String descSup = "" ;
      String nomP = "" ;
      String currentDate = "";

    
      long idp = 0 ;
      long pa = 0 ;
      long pv = 0 ;
    
    
    public ProductionMp() {
        initComponents(); 
       this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    
    
    
     public ProductionMp(Long idp, String role, String nomp) {
         
        initComponents() ;
        this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.idp = idp ;
        this.nomP = nomp ;
        this.role = role;
        
        
        DateFormat datef = new SimpleDateFormat("dd/MM/yyyy") ;
        Date date = new Date() ;
        this.currentDate = datef.format(date) ;
        
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
      
        // je crai ma requete
      
       //  DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
         String sql ;
      
         sql= "SELECT * FROM matieres_p ORDER BY description" ;
      
         ResultSet rs = stmt.executeQuery(sql);
      
      
        while(rs.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX DE VENTE"      

            
       rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") 
        
        }) ;
  
       
     }
      
        //
        
            String sql10 ;
      
         sql10= "SELECT * FROM produits_f ORDER BY description" ;
      
         ResultSet rs10 = stmt.executeQuery(sql10);
      
      
        while(rs10.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX DE VENTE"      

            
       rs10.getString("code_barre") , rs10.getString("description")  ,
       rs10.getLong("libelle") , rs10.getLong("pu") 
        
        }) ;
  
       
     }
        
        
        /*
        sql = "select description , prx_pm , produit from stock_pl , derive_pl where derive_pl.produit = "
                + "stock_pl.description order by description ASC" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            dtm.addRow(new Object[]{
            "" , rs.getString("description") , "0" , rs.getLong("prx_pm")
            });
        }
      */
        
          sql = "select placement from point_pl where type = 'oui' order by placement ASC" ;
                 ResultSet rs20 = stmt.executeQuery(sql) ;
                 
                 while(rs20.next()){
                 
                  this.pl.addItem(rs20.getString("placement")) ;
                  
                  
               
       }
        
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
        
       
        
     
        
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable2.getModel() ;
        
      
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm1.setRowCount(0) ;
        
        
        
    
     
  //     DefaultTableModel dtm1 = (DefaultTableModel) jTable2.getModel() ;
         
         String sql1 ;
      
         sql1= "SELECT * FROM pmp WHERE idp = "+this.idp+" ORDER BY article" ;
      
         ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
        while(rs1.next()){
        
    
        
        
        
        dtm1.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX VENTE"   

            
       rs1.getString("cb") , rs1.getString("article")  ,
       rs1.getLong("pa") , rs1.getLong("pv") 
        
        }) ;
  
       
     }
      
    if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR") || this.role.equalsIgnoreCase("ADMINISTRATEUR")){
          
          // ADMINISTRATEUR
        
      }else if(this.role.equalsIgnoreCase("ADMINII")){
          
         
          
      }else{
          
           this.aj.setEnabled(false) ;
           this.sup.setEnabled(false) ;
          
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
   }//end try
        
       
     
     // Fin configure :
     
        
        
        //
        
    
        
     
     }
    
    

    public void setUser_c(String user_c) {
        this.user_c = user_c ;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public void setIdp(long idp) {
        this.idp = idp;
    }

    public void setId(String id) {
        this.id.setText(id) ;
    }

    public void setNom(String nom) {
        this.nom.setText(nom) ;
    }
    
    public String getRole() {
        return role;
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
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nom = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        desc1 = new javax.swing.JTextField();
        cb1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pl = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        desc2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cb2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        aj = new javax.swing.JButton();
        sup = new javax.swing.JButton();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LES ARTICLES POUR LA PRODUCTION  :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID PRODUCT°  :");

        id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NOM PRODUCTION :");

        nom.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        nom.setForeground(new java.awt.Color(255, 255, 255));
        nom.setText("jLabel5");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX DE VENTE"
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
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(3);
        }

        desc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                desc1KeyPressed(evt);
            }
        });

        cb1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cb1KeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("DESCRIPTION :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("CODE BARRE");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setText("NOS ARTICLES :");

        pl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "POINT PLACEMENT" }));
        pl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pl, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(desc1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb1)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pl)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(desc1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(cb1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX VENTE"
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
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(3);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(3);
        }

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("DESCRIPTION :");

        desc2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                desc2KeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("CODE BARRE");

        cb2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cb2KeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setText("POUR LA PRODUCTION :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(cb2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(cb2))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        aj.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        aj.setText("AJOUTER");
        aj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajActionPerformed(evt);
            }
        });

        sup.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sup.setText("SUPPRIMER");
        sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(168, 168, 168))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aj, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sup))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(aj, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(sup, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void desc1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desc1KeyPressed
        
         // TODO add your handling code here:
        
         String d1 = this.desc1.getText().trim().replaceAll("'", "''") ;
        
        if("".equalsIgnoreCase(d1)){
            
        }else{
            
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
      
        // je crai ma requete
      
      
         clear1() ;
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
         String sql ;
      
         sql= "SELECT * FROM matieres_p WHERE description LIKE '%"+d1+"%' ORDER BY description" ;
      
         ResultSet rs = stmt.executeQuery(sql);
      
      
        while(rs.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX DE VENTE"      

            
       rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") 
        
        }) ;
  
       
     }
      
    
      String sql10 ;
      
         sql10= "SELECT * FROM produits_f WHERE description LIKE '%"+d1+"%'" ;
      
         ResultSet rs10 = stmt.executeQuery(sql10);
      
      
        while(rs10.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX DE VENTE"      

            
       rs10.getString("code_barre") , rs10.getString("description")  ,
       rs10.getLong("libelle") , rs10.getLong("pu") 
        
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
        
        
        
    }//GEN-LAST:event_desc1KeyPressed

    private void cb1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb1KeyPressed
        // TODO add your handling code here:
        
        
         String d1 = this.cb1.getText().trim().replaceAll("'", "''") ;
        
        if("".equalsIgnoreCase(d1)){
            
        }else{
            
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
      
        // je crai ma requete
      
      
         clear1() ;
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
         String sql ;
      
         sql= "SELECT * FROM matieres_p WHERE code_barre LIKE '%"+d1+"%'" ;
      
         ResultSet rs = stmt.executeQuery(sql);
      
      
        while(rs.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX DE VENTE"      

            
       rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") 
        
        }) ;
  
       
     }
      
     String sql10 ;
      
         sql10= "SELECT * FROM produits_f WHERE code_barre LIKE '%"+d1+"%'" ;
      
         ResultSet rs10 = stmt.executeQuery(sql10);
      
      
        while(rs10.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX DE VENTE"      

            
       rs10.getString("code_barre") , rs10.getString("description")  ,
       rs10.getLong("libelle") , rs10.getLong("pu") 
        
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
        
        
        
        
    }//GEN-LAST:event_cb1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
       
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void ajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
        
            JOptionPane.showMessageDialog(this, "Selectionner dans le tableau svp") ;
            
        }else{
            
              SessionFactory sf=new Configuration().configure().buildSessionFactory();
              Session s=sf.openSession();
           
            
      
         List entreprise = s.createSQLQuery("SELECT * FROM pmp WHERE idp = "+this.idp+" AND nomp = '"+this.nomP.replaceAll("'", "''")+"' AND article = '"+this.descD.replaceAll("'", "''")+"' ").list();
       
         
               // verification if qery is ok
         
            
            if(entreprise.size() == 1){
                
       JOptionPane jp = new JOptionPane() ;
       jp.showMessageDialog(null," L'article existe dejà pour cette production ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
        
                
            }else{
                 
                           
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
      
        // je crai ma requete
      
     if(stmt.executeUpdate("INSERT INTO pmp(idp,nomp,article,pa,pv,idmp,idpf) VALUES("+this.idp+", '"+this.nomP.replaceAll("'", "''")+"' , '"+this.descD.replaceAll("'", "''")+"' , "+this.pa+" , "+this.pv+" , "
             +this.idmp+" , "+this.idpf+")" ) == 1){
         
          
      
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
         dtm.setRowCount(0) ;
         
         String sql ;
      
         sql= "SELECT * FROM pmp WHERE pmp.idp ="+this.idp+"" ;
      
         ResultSet rs = stmt.executeQuery(sql);
      
      
        while(rs.next()){
        
           
        
        
        
        dtm.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX VENTE"   

            
       rs.getString("cb") , rs.getString("article")  ,
       rs.getLong("pa") , rs.getLong("pv") 
        
        }) ;
  
       
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
        
       
     
     // Fin configure :
     
        
        
        //
        
                     
                     }
            
            
            
            
            
        }
        
    }//GEN-LAST:event_ajActionPerformed

    private void desc2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desc2KeyPressed
        // TODO add your handling code here:
        
        
         String d1 = this.desc2.getText().trim().replaceAll("'", "''") ;
        
        if("".equalsIgnoreCase(d1)){
            
        }else{
            
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
      
        // je crai ma requete
      
      clear2() ;
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
         
         String sql ;
      
         sql= "SELECT * FROM pmp WHERE idp = "+this.idp+" AND nomp = '"+this.nomP.replaceAll("'", "''")+"' AND article LIKE '%"+d1.replaceAll("'", "''")+"%'" ;
      
         ResultSet rs = stmt.executeQuery(sql);
      
      
        while(rs.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX VENTE"   

            
       rs.getString("cb") , rs.getString("article")  ,
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
        
        
        
    }//GEN-LAST:event_desc2KeyPressed

    private void cb2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb2KeyPressed
        // TODO add your handling code here:
        
         String d1 = this.cb2.getText().trim().replaceAll("'", "''") ;
        
        if("".equalsIgnoreCase(d1)){
            
        }else{
            
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
      
        // je crai ma requete
      
        clear2() ;
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
         
         String sql ;
      // SELECT * FROM pmp WHERE idp = "+this.idp+" AND nomp = '"+this.nomP.replaceAll("'", "''")+"' AND cb LIKE '%"+d1.replaceAll("'", "''")+"%'"
         sql= "SELECT * FROM pmp WHERE idp = "+this.idp+" AND nomp = '"+this.nomP.replaceAll("'", "''")+"' AND cb LIKE '%"+d1.replaceAll("'", "''")+"%'" ;
      
         ResultSet rs = stmt.executeQuery(sql);
      
      
        while(rs.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX VENTE"   

            
       rs.getString("cb") , rs.getString("article")  ,
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
        
        
        
        
        
        
    }//GEN-LAST:event_cb2KeyPressed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        
       
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supActionPerformed
        // TODO add your handling code here:
        
         if(this.jTable2.getSelectedRow() == -1){
        
            JOptionPane.showMessageDialog(this, "Selectionner dans le tableau à Droite svp") ;
            
        }else{
            
             
                           
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
      
        // je crai ma requete
      
     if(stmt.executeUpdate("DELETE FROM pmp WHERE idp = "+this.idp+" AND article ='"+this.descSup.replaceAll("'", "''")+"'" ) == 1){
         
          
         DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
         dtm.setRowCount(0) ;
         
         String sql ;
      
         sql = "SELECT * FROM pmp WHERE idp ="+this.idp ;
      
         ResultSet rs = stmt.executeQuery(sql);
      
      
        while(rs.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
     
     //  "CODE BARRE", "DESCRIPTION", "PRIX ACHAT", "PRIX VENTE"   

            
       rs.getString("cb") , rs.getString("article")  ,
       rs.getLong("pa") , rs.getLong("pv") 
        
        }) ;
  
       
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
        
       
     
     // Fin configure :
     
        
        
        //
        
                     
                     }
            
            
            
            
            
        
        
    }//GEN-LAST:event_supActionPerformed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
        this.cb = "" ;
        this.descD = "" ;
        this.pa = 0 ;
        this.pv = 0 ;
        
        
        this.cb = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString() ;
        this.descD = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() ;
        this.pa = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()) ;
        this.pv = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString()) ;
        
        
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyTyped
        // TODO add your handling code here:
        this.descSup = "" ;
        this.descSup = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString() ;
        
    }//GEN-LAST:event_jTable2KeyTyped
       int indice = 0 ;
       int idpf = 0 ;
       long idmp = 0 ;
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        this.cb = "" ;
        this.descD = "" ;
        this.pa = 0 ;
        this.pv = 0 ;
        this.idpf = 0 ;
        this.idmp = 0 ;
        
        this.indice = 0 ;
        
        
         // d :
        
        
             Connection conn = null ;
             Statement  stmt = null ;
       
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
      
     // this.sf.removeAllItems() ;
     // this.sf.addItem("CHOISIR UNE SOUS FAMILLE") ;
       
        String sql ;
      
       sql = "SELECT distinct id FROM matieres_p WHERE description = '"+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString().replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
  
       this.idmp = rs.getLong("id") ;
          
         
       
     }
    
     
        
       String sql2 ;
      
       sql2 = "SELECT distinct id FROM produits_f WHERE description = '"+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString().replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
  
       this.idpf = rs2.getInt("id") ;  
          
         
       
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
        
        
        this.cb = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString() ;
        this.descD = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString() ;
        this.pa = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()) ;
        this.pv = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString()) ;
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
        
         this.descSup = "" ;
         this.descSup = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString() ;
        
        
        
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
        
        sql = "select description , prx_pm , produit from stock_pl , derive_pl where stock_pl.magasin = '"+point+"' AND derive_pl.produit = "
                + "stock_pl.description order by description ASC" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            dtm.addRow(new Object[]{
            "" , rs.getString("description") , "0" , rs.getLong("prx_pm")
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
            java.util.logging.Logger.getLogger(ProductionMp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductionMp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductionMp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductionMp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductionMp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aj;
    private javax.swing.JTextField cb1;
    private javax.swing.JTextField cb2;
    private javax.swing.JTextField desc1;
    private javax.swing.JTextField desc2;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel nom;
    private javax.swing.JComboBox pl;
    private javax.swing.JButton sup;
    // End of variables declaration//GEN-END:variables
}
