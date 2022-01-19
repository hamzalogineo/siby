/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import entity.ComptesU;
import entity.ProduitsF;
import static frontend.Comptes.JDBC_DRIVER;
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
public class ProduitFini extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
      String user_c ;
      String role ;
      String phone ;
      boolean Tx = false ;
    
      int id = 0 ;
      long idS = 0 ;
    Integer sm ;
      
      
      
    public ProduitFini() {
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
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
       sql= "SELECT * FROM produits_f , famille , sfamille "
               + "WHERE ( famille.id = produits_f.idf OR famille.nom = produits_f.f )  "
               + "AND ( sfamille.id = produits_f.idsf OR sfamille.nom = produits_f.sf ) ORDER BY description ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ref.produit", "Code Barre", "Description", "Prix Achat", "Prix vente"
            
           rs.getString("famille.nom") , rs.getString("sfamille.nom") , rs.getInt("id") ,  rs.getString("code_barre") , rs.getString("description") , rs.getLong("libelle") 
         ,  rs.getLong("pu"), rs.getInt("stockMini")
         
        });
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
    
          // code patient 
      
     
      
    
            
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
    
    
    
    
    
    
    
    
     // Getter and setter :
    
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

    public void setImprimer() {
        this.imprimer.setEnabled(false);
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
    
    public void setDetail() {
        this.detail.setEnabled(false);
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
        detail = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cb = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        desi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DES PRODUITS FINIS");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        ajouter.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ajouter.setText("AJOUTER");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        modifier.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        modifier.setText("MODIFIER");
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        supprimer.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        supprimer.setText("SUPPRIMER");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton5.setText("ACTUALISER");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        imprimer.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        imprimer.setText("IMPRIMER");
        imprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimerActionPerformed(evt);
            }
        });

        detail.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        detail.setText("Detail");
        detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailActionPerformed(evt);
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
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(imprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(detail, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        cb.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("PRODUIT CODE BARRE");

        desi.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        desi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                desiKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("DESCRIPTION");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(desi, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addGap(29, 29, 29))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb)
                    .addComponent(desi))
                .addContainerGap())
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Famille", "Sous Famille", "ref.produit", "Code Barre", "Description", "Prix Achat", "Prix vente", "Stock Mini"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(348, 348, 348))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
                .addGap(20, 20, 20))
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
            jp.showMessageDialog(null,"Pour supprimer un produit fini selectionner dans le tableau","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
            
            
        }else{
        
         if(JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer le produit ? :"+" ","Confirmation",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            
             // ici je supprime le compte utilisateur :
             
             
              SessionFactory sf=new Configuration().configure().buildSessionFactory();
              Session s=sf.openSession();
              Transaction tr = s.beginTransaction();
             
             ProduitsF cu = (ProduitsF) s.load(ProduitsF.class , this.id) ;
             
             
              s.delete(cu) ;
            
            
            
            tr.commit();
            s.close();
            
             DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                               dtm.removeRow(this.jTable1.getSelectedRow()) ;
                              
             JOptionPane jp=new JOptionPane();
             jp.showMessageDialog(null," suppression reussit avec succes","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
       
            
            }else{
            
                
            
            }
         
         
        
        }
        
    }//GEN-LAST:event_supprimerActionPerformed

    private void imprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimerActionPerformed
        // TODO add your handling code here:
        
        this.imprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        
       try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\produit_fini1.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql = "SELECT\n" +
"     produits_f.`id` AS produits_f_id,\n" +
"     produits_f.`code_barre` AS produits_f_code_barre,\n" +
"     produits_f.`libelle` AS produits_f_libelle,\n" +
"     produits_f.`description` AS produits_f_description,\n" +
"     produits_f.`pu` AS produits_f_pu,\n" +
"     produits_f.`unite_m` AS produits_f_unite_m,\n" +
"     produits_f.`datecreat` AS produits_f_datecreat,\n" +
"     produits_f.`admin` AS produits_f_admin,\n" +
"     produits_f.`f` AS produits_f_f,\n" +
"     produits_f.`sf` AS produits_f_sf\n" +
"FROM\n" +
"     `produits_f` produits_f ORDER BY produits_f.`f` ASC , produits_f.`sf` ASC , produits_f.`description` ASC" ;
           
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
        
       this.imprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
    }//GEN-LAST:event_imprimerActionPerformed

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        // TODO add your handling code here:
        
        AddProduitFini af = new AddProduitFini() ;
        
            af.setAdmin(this.user_c) ;
            
        af.setVisible(true) ;
        
    }//GEN-LAST:event_ajouterActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        // TODO add your handling code here:
        
         if(jTable1.getSelectedRow() == -1){
        
             JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null,"Pour modifier un produit fini selectionner dans le tableau svp " ,"INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
        }else{
             
             String famille = "" ;
             String sfamille = "" ;
             
             
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
      
       sql= "SELECT * FROM produits_f , famille , sfamille "
               + "WHERE produits_f.id = "+this.id+" AND ( famille.id = produits_f.idf OR famille.nom = produits_f.f )  "
               + "AND ( sfamille.id = produits_f.idsf OR sfamille.nom = produits_f.sf ) ORDER BY description ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
            
          famille = rs.getString("famille.nom")  ;
          sfamille = rs.getString("sfamille.nom") ; 
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
    
          // code patient 
      
     
      
    
            
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
        
       
             
             
              SessionFactory sf = new Configuration().configure().buildSessionFactory();
              Session s = sf.openSession();
             
             ProduitsF cu = (ProduitsF) s.load(ProduitsF.class , this.id) ;
        
          ModProduitFini1 mf = new ModProduitFini1(sfamille) ;
          
            mf.setId(cu.getId());
            mf.setCb(cu.getCodeBarre());
            mf.setLibel(String.valueOf(cu.getLibelle()));
            mf.setDesc(cu.getDescription());
            mf.setPru(String.valueOf(cu.getPu()));
            mf.setRp(this.Tx) ;
            mf.setAdmin(this.user_c);
            mf.setDc(cu.getDatecreat());
            mf.setCpfNom(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString()) ;
            mf.setF(famille) ;
            mf.setSf(sfamille) ;
           // mf.setRflle(sfamille);
            mf.setStockMini(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
            mf.setRp();
            
            mf.setOldCb(cu.getCodeBarre()) ;
            mf.setOldDescrip(cu.getDescription());
            mf.setOldPa(cu.getLibelle());
            mf.setOldPu(cu.getPu());
            
            if(this.sm == 0){
               mf.setOldSmini(Integer.parseInt("0")) ; 
            }else if(this.sm > 0){
            mf.setOldSmini(cu.getStockMini()) ;
            }
            
         // System.out.println("id stock1 = "+this.idS);
            mf.setIdS(this.idS) ;
           
            mf.setVisible(true) ;
            
        
         }
        
      
         
         
    }//GEN-LAST:event_modifierActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
       /* 
         ProduitFini cptes = new ProduitFini() ;
        
                  cptes.setUser_c(this.user_c);
                  cptes.setRole(this.role);
                  cptes.setPhone(this.phone);
        
        cptes.setVisible(true) ;
        this.setVisible(false) ;
        */
        
        
        
          ProduitFini cptes = new ProduitFini() ;
        
                  cptes.setUser_c(this.user_c);
                  cptes.setRole(this.role);
                  cptes.setPhone(this.phone);
                  
                  if(this.role.equalsIgnoreCase("ADMINISTRATEUR") || this.role.equalsIgnoreCase("ADMINII")){
                    //  cptes.setAjouter();
                   //   cptes.setModifier();
                      cptes.setSupprimer();
                  }
                  
                     if(this.role.equalsIgnoreCase("ORDINAIRE")){
                      cptes.setAjouter();
                      cptes.setModifier();
                      cptes.setImprimer();
                      cptes.setSupprimer();
                      cptes.setDetail();
                  }
                     
                     
        
        cptes.setVisible(true) ;
        this.setVisible(false) ;
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
         
         
         
    }//GEN-LAST:event_jTable1MouseClicked

    private void cbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbKeyPressed
        // TODO add your handling code here:
        
        
          String n1 = this.cb.getText().trim().replaceAll("'", "''") ;
 
        
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
      
       sql= "SELECT * FROM produits_f , famille , sfamille "
               + "WHERE produits_f.code_barre LIKE '%"+n1+"%' AND ( famille.id = produits_f.idf OR famille.nom = produits_f.f )  "
               + "AND ( sfamille.id = produits_f.idsf OR sfamille.nom = produits_f.sf ) ORDER BY description ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ref.produit", "Code Barre", "Description", "Prix Achat", "Prix vente"
            
           rs.getString("famille.nom") , rs.getString("sfamille.nom") , rs.getInt("id") ,  rs.getString("code_barre") , rs.getString("description") , rs.getLong("libelle") 
         ,  rs.getLong("pu"), rs.getInt("stockMini")
         
        });
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
    
          // code patient 
      
     
      
    
            
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
 
        
        
        
        
       //  System.out.println("touche enter from keybord is pressed  :::: :");
        
        
    }//GEN-LAST:event_cbKeyPressed

    private void desiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desiKeyPressed
        // TODO add your handling code here : 
        
        
        String n1 = this.desi.getText().trim().replaceAll("'", "''") ;
   
        
         Connection conn = null ;
         Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

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
      
       sql= "SELECT * FROM produits_f , famille , sfamille "
               + "WHERE produits_f.description LIKE '%"+n1+"%' AND ( famille.id = produits_f.idf OR famille.nom = produits_f.f )  "
               + "AND ( sfamille.id = produits_f.idsf OR sfamille.nom = produits_f.sf ) ORDER BY description ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ref.produit", "Code Barre", "Description", "Prix Achat", "Prix vente"
            
           rs.getString("famille.nom") , rs.getString("sfamille.nom") , rs.getInt("id") ,  rs.getString("code_barre") , rs.getString("description") , rs.getLong("libelle") 
         ,  rs.getLong("pu"), rs.getInt("stockMini")
         
        });
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
    
          // code patient 
      
      
     
      
    
            
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
  
        
        
        
        
        
       //  System.out.println("touche enter from keybord is pressed  :::: :");
        
        
        
    }//GEN-LAST:event_desiKeyPressed

    private void detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailActionPerformed
        // TODO add your handling code here:
        
        
        if(jTable1.getSelectedRow() == -1){
           
            JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null,"Pour consulter les details d'un produit fini selectionner dans le tableau","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
            
            
        }else{
        
            
             // ici je supprime le compte utilisateur :
             
             
              SessionFactory sf=new Configuration().configure().buildSessionFactory();
              Session s=sf.openSession();
              
             
             ProduitsF cu = (ProduitsF) s.load(ProduitsF.class , this.id) ;
             
             //
             
              String ddv = "" ;     
        
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
      
       sql= "SELECT periode FROM cumulvente WHERE desi = '"+cu.getDescription().replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
    if(rs.last()){
        
        ddv = rs.getString("periode") ;
        
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
             
             System.out.println(cu.getDescription()) ;
             
             DetailPFinis dpf = new DetailPFinis(cu.getDatecreat() , ddv , cu.getAdmin()) ;
             dpf.setVisible(true) ;
            
           
         
        
        }
        
        
    }//GEN-LAST:event_detailActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        
        /*
          boolean Tx1 = false ;
        
         String code = "" ;
                code = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString() ;
        
         id = Integer.parseInt(code) ;
         
         String desi = "" ;
         desi = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString() ;
         
         
             
                  
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
      
      
      
       String sql2 ;
      
       sql2 = "SELECT id FROM stock1 WHERE desi = '"+desi.replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
      this.idS = rs2.getLong("id") ;
     
        
     }
      System.out.println("id stock1 = "+this.idS);
      
       
      String sql ;
      
       sql = "SELECT * FROM produits_f WHERE id="+this.id ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
       if("oui".equalsIgnoreCase(rs.getString("unite_m"))){
           Tx1 = true ;
       }else{
           Tx1 = false ;
       }
     
        
     }
     
     
     
        this.Tx = Tx1 ; 
      
    
            
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
        
         
         */
              
         
        
        
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
        
        boolean Tx1 = false ;
        
         String code = "" ;
                code = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString() ;
        
         id = Integer.parseInt(code) ;
         
         String desi = "" ;
         desi = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString() ;
         
         
             
                  
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
      
      
      
       String sql2 ;
      
       sql2 = "SELECT id FROM stock1 WHERE desi = '"+desi.replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
      this.idS = rs2.getLong("id") ;
     
        
     }
      System.out.println("id stock1 = "+this.idS);
      
       
      String sql ;
      
       sql = "SELECT * FROM produits_f WHERE id="+this.id ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
       if("oui".equalsIgnoreCase(rs.getString("unite_m"))){
           Tx1 = true ;
       }else{
           Tx1 = false ;
       }
     
        
     }
     
     
     
        this.Tx = Tx1 ; 
      
    
            
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

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        this.sm = 0 ;
        
         boolean Tx1 = false ;
        
         String code = "" ;
                code = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString() ;
                this.sm = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString()) ;
        
         id = Integer.parseInt(code) ;
         
         String desi = "" ;
         desi = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString() ;
         
         
             
                  
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
      
      
      
       String sql2 ;
      
       sql2 = "SELECT id FROM stock1 WHERE desi = '"+desi.replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
      this.idS = rs2.getLong("id") ;
     
        
     }
      System.out.println("id stock1 = "+this.idS);
      
       
      String sql ;
      
       sql = "SELECT * FROM produits_f WHERE id="+this.id ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
       if("oui".equalsIgnoreCase(rs.getString("unite_m"))){
           Tx1 = true ;
       }else{
           Tx1 = false ;
       }
     
        
     }
     
     
     
        this.Tx = Tx1 ; 
      
    
            
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
        
         
         
              
        
        
    }//GEN-LAST:event_jTable1MouseReleased

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
            java.util.logging.Logger.getLogger(ProduitFini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProduitFini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProduitFini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProduitFini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProduitFini().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JTextField cb;
    private javax.swing.JTextField desi;
    private javax.swing.JButton detail;
    private javax.swing.JButton imprimer;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modifier;
    private javax.swing.JButton supprimer;
    // End of variables declaration//GEN-END:variables
}
