/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import entity.Fournisseurs;
import entity.MatieresP;
import static frontend.Comptes.DB_URL;
import static frontend.Fournisseur.JDBC_DRIVER;
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
public class MatierePri extends javax.swing.JFrame {

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
       boolean Tx = false ;
    
       long id = 0 ;
       long idS = 0 ;
       Integer sm ;
    
    
    public MatierePri() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
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
      
  //       DefaultTableModel dtm=(DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
       sql= "SELECT * FROM matieres_p , famille , sfamille "
               + "WHERE ( famille.id = matieres_p.idf OR famille.nom = matieres_p.condition_livraison )  "
               + "AND ( sfamille.id = matieres_p.idsf OR sfamille.nom = matieres_p.conservation ) ORDER BY description ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
    
        
        
        
        dtm.addRow(new Object[]{
            
    // "ref.Mt", "Code Barre", "Description", "Prix Achat / Unité", "Prix de vente / Unité"
            
    rs.getString("famille.nom") , rs.getString("sfamille.nom") ,   rs.getLong("matieres_p.id") , rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite"), rs.getInt("stockMini")
        
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

    public void setActualiser() {
        this.actualiser.setEnabled(false);
    }

    public void setAjouter() {
        this.ajouter.setEnabled(false);
    }

    public void setHistorique() {
        this.historique.setEnabled(false);
    }

    public void setImprimer() {
        this.imprimer.setEnabled(false);
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
        actualiser = new javax.swing.JButton();
        imprimer = new javax.swing.JButton();
        historique = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cb = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        desc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DES MATIERES PRIMAIRES  ");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        ajouter.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ajouter.setText("AJOUTER");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        modifier.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        modifier.setText("MODIFIER");
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        supprimer.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        supprimer.setText("SUPPRIMER");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        actualiser.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        actualiser.setText("ACTUALISER");
        actualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualiserActionPerformed(evt);
            }
        });

        imprimer.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        imprimer.setText("IMPRIMER");
        imprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimerActionPerformed(evt);
            }
        });

        historique.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        historique.setText("HISTORIQUE");
        historique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historiqueActionPerformed(evt);
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
                    .addComponent(actualiser, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(imprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(historique, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(actualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(historique, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(imprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        cb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("CODE BARRE :");

        desc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("DESCRIPTION :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)))
                .addGap(71, 71, 71))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Famille", "Sous Famille", "ref.Mt", "Code Barre", "Description", "Prix Achat", "Prix vente", "Stock Mini"
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setMinWidth(3);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(5).setMinWidth(3);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(6).setMinWidth(3);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(1);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(479, 479, 479))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
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
            jp.showMessageDialog(null,"Pour supprimer une matiere primaire selectionner dans le tableau","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
            
            
        }else{
        
         if(JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette matiere primaire ? :"+" ","Confirmation",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            
             // ici je supprime le compte utilisateur :
             
             
              SessionFactory sf=new Configuration().configure().buildSessionFactory();
              Session s=sf.openSession();
              Transaction tr = s.beginTransaction();
             
             MatieresP cu = (MatieresP) s.load(MatieresP.class , this.id) ;
             
             
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
        
        this.imprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
       try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\mat_primaire1.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql = "SELECT\n" +
"     matieres_p.`id` AS matieres_p_id,\n" +
"     matieres_p.`id_f` AS matieres_p_id_f,\n" +
"     matieres_p.`code_barre` AS matieres_p_code_barre,\n" +
"     matieres_p.`libelle` AS matieres_p_libelle,\n" +
"     matieres_p.`description` AS matieres_p_description,\n" +
"     matieres_p.`unite_mesure` AS matieres_p_unite_mesure,\n" +
"     matieres_p.`prx_a_unite` AS matieres_p_prx_a_unite,\n" +
"     matieres_p.`date_exp` AS matieres_p_date_exp,\n" +
"     matieres_p.`condition_livraison` AS matieres_p_condition_livraison,\n" +
"     matieres_p.`conservation` AS matieres_p_conservation,\n" +
"     matieres_p.`prx_achat` AS matieres_p_prx_achat,\n" +
"     matieres_p.`qte_achat` AS matieres_p_qte_achat,\n" +
"     matieres_p.`prx_v_unite` AS matieres_p_prx_v_unite,\n" +
"     matieres_p.`datecreat` AS matieres_p_datecreat,\n" +
"     matieres_p.`admin` AS matieres_p_admin\n" +
"FROM\n" +
"     `matieres_p` matieres_p ORDER BY matieres_p.`condition_livraison` ASC , matieres_p.`conservation` ASC , matieres_p.`description` ASC" ;
           
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
        
        
        
          AddMatPr af = new AddMatPr() ;
        
            af.setAdmin(this.user_c) ;
            
        af.setVisible(true) ;
        
        
        
    }//GEN-LAST:event_ajouterActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        
       //  TODO add your handling code here:
        
        
          if(jTable1.getSelectedRow() == -1){
        
       JOptionPane jp=new JOptionPane();
       jp.showMessageDialog(null,"Pour modifier un fournisseur selectionner dans le tableau svp " ,"INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
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
      
       sql= "SELECT * FROM matieres_p , famille , sfamille "
               + "WHERE matieres_p.id = "+this.id+" AND ( famille.id = matieres_p.idf OR famille.nom = matieres_p.condition_livraison )  "
               + "AND ( sfamille.id = matieres_p.idsf OR sfamille.nom = matieres_p.conservation ) ORDER BY description ASC" ;
      
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
             
              MatieresP cu = (MatieresP) s.load(MatieresP.class , this.id) ;
        
        ModMatPr mf = new ModMatPr() ;
          
            mf.setId(cu.getId());
            
            
           
            mf.setCb(cu.getCodeBarre());
         
            mf.setDesc(cu.getDescription());
            
            mf.setRp(this.Tx) ;
            
            mf.setPau(String.valueOf(cu.getPrxAUnite()));
           
            mf.setPvu(String.valueOf(cu.getPrxVUnite()));
       
            mf.setAdmin(this.user_c);
            mf.setDc(cu.getDatecreat());
            
            mf.setF(cu.getConditionLivraison())  ;
            mf.setSf(cu.getConservation()) ;
            
            mf.setStockMini(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
            
            mf.setRp();
            
            
            
             mf.setOldCb(cu.getCodeBarre()) ;
             mf.setOldDescrip(cu.getDescription());
            mf.setOldPa(cu.getPrxAUnite());
            mf.setOldPu(cu.getPrxVUnite()) ;
            mf.setOldSmini(cu.getStockMini()) ;
            mf.setIdS(idS) ;
            
            mf.setVisible(true) ;
            
        
         }
        
      
        
     
    }//GEN-LAST:event_modifierActionPerformed

    private void actualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualiserActionPerformed
        // TODO add your handling code here:
        
        
        
     /*   
        MatierePri cptes = new MatierePri() ;
        
                  cptes.setUser_c(this.user_c);
                  cptes.setRole(this.role);
                  cptes.setPhone(this.phone);
        
        cptes.setVisible(true) ;
        this.setVisible(false) ;
       
        */
        
        
        
        
          MatierePri cptes = new MatierePri() ;
        
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
                      cptes.setHistorique();
                      cptes.setModifier();
                      cptes.setImprimer();
                      cptes.setSupprimer();
                  }
                   
        
        cptes.setVisible(true) ;
        this.setVisible(false) ;
        
       
        
        
        
    }//GEN-LAST:event_actualiserActionPerformed

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
      
        sql= "SELECT * FROM matieres_p WHERE code_barre LIKE '%"+n1+"%' ORDER BY description" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
   // "ref.Mt", "Code Barre", "Description", "Prix Achat / Unité", "Prix de vente / Unité", "Stock Mini"
            
     rs.getString("condition_livraison") , rs.getString("conservation") ,  rs.getLong("id") , rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") , rs.getInt("stockMini")
                
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
        
 
        
        
        
    }//GEN-LAST:event_cbKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
         
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyPressed
        // TODO add your handling code here:
        
        
        String n1 = this.desc.getText().replaceAll("'", "''") ;
        
        
        
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
      
        sql= "SELECT * FROM matieres_p WHERE description LIKE '%"+n1+"%' ORDER BY description" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
    // "ref.Mt", "Code Barre", "Description", "Prix Achat / Unité", "Prix de vente / Unité", "Stock Mini"
            
     rs.getString("condition_livraison") , rs.getString("conservation") ,  rs.getLong("id") , rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") , rs.getInt("stockMini")
          
        }) ;
 
     
              }
      
    
 
            
      // STEP 6: Clean-up environment
      
    //  System.out.println("Goodbye!") ;
      
   
      
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
        
       

    }//GEN-LAST:event_descKeyPressed

    private void historiqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historiqueActionPerformed
        // TODO add your handling code here:
        
        
        // DetailMpri
        
           if(jTable1.getSelectedRow() == -1){
           
            JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null,"selectionner dans le tableau","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
            
            
        }else{
        
            
             // ici je supprime le compte utilisateur :
             
             
              SessionFactory sf=new Configuration().configure().buildSessionFactory();
              Session s=sf.openSession();
              
             
              MatieresP cu = (MatieresP) s.load(MatieresP.class , this.id) ;
             
             
            
             DetailMpri mp = new DetailMpri(cu.getDatecreat() , cu.getAdmin()) ;
             mp.setVisible(true) ;
         
        
        }
        
        
        
        
        
    }//GEN-LAST:event_historiqueActionPerformed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
        
         boolean Tx1 = false ;

        String code = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString() ;

        this.id = Long.parseLong(code) ;
        
         String desi = "" ;
         desi = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4).toString() ;
         

        
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
      
      
      String sql ;
      
        sql= "SELECT * FROM matieres_p WHERE id ="+this.id ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
       if("oui".equalsIgnoreCase(rs.getString("unite_mesure"))){
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

        String code = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString() ;

        this.id = Long.parseLong(code) ;
        
         String desi = "" ;
         desi = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4).toString() ;
         this.sm = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString()) ;
         

        
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
      
      
      String sql ;
      
        sql= "SELECT * FROM matieres_p WHERE id ="+this.id ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
       if("oui".equalsIgnoreCase(rs.getString("unite_mesure"))){
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
            java.util.logging.Logger.getLogger(MatierePri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatierePri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatierePri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatierePri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MatierePri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualiser;
    private javax.swing.JButton ajouter;
    private javax.swing.JTextField cb;
    private javax.swing.JTextField desc;
    private javax.swing.JButton historique;
    private javax.swing.JButton imprimer;
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
