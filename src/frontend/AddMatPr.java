/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import entity.Fournisseurs;
import entity.MatieresP;
import static frontend.AddProduitFini.JDBC_DRIVER;
import static frontend.Fournisseur.JDBC_DRIVER;
import static frontend.ModProduitFini1.JDBC_DRIVER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HAMZA
 */
public class AddMatPr extends javax.swing.JFrame {

    /**
     * Creates new form AddMatPr1
     */
      
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
        static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
        static final String USER = "root" ;
        static final String PASS = "interco" ;
    
       String admin , dc  ;
       String rapport = "" ;
    
    public AddMatPr() {
        initComponents();
        this.setLocationRelativeTo(null);
        
         String format = "dd/MM/yyyy" ;

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ) ;
        java.util.Date date = new java.util.Date();

        this.dc = formater.format( date ) ;
        
        
        
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
      
       
       String sql ;
      
       sql= "SELECT * FROM famille" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
             
        this.f.addItem(rs.getString("nom"))  ;
 
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
     
        
        
        // f :
     
        
        
        
    }

    
    
      
    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
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
        jLabel2 = new javax.swing.JLabel();
        cb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        desc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pau = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        pvu = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        rp = new javax.swing.JCheckBox();
        f = new javax.swing.JComboBox();
        sf = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        stockMin = new javax.swing.JTextField();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AJOUTER UNE MATIERE PRIMAIRE ");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("CODE BARRE MATIERE :");

        cb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("DESCRIPTION :");

        desc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Prix Achat / Unit�  :");

        pau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pau.setText("0");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Prix de vente / unit�  :");

        pvu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pvu.setText("0");
        pvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pvuMouseClicked(evt);
            }
        });

        jLabel15.setText("FCFA");

        jLabel17.setText("FCFA");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton2.setText("AJOUTER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        rp.setText("1 => 1000");

        f.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR UNE FAMILLE" }));
        f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fActionPerformed(evt);
            }
        });

        sf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR UNE SOUS FAMILLE" }));
        sf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sfMouseReleased(evt);
            }
        });
        sf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sfActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Stock minimum *");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pau, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pvu, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(rp))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(f, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sf, 0, 232, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(stockMin))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(sf, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(pvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(rp))
                    .addComponent(stockMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         
        try{
        
            this.rapport = "" ;
        
        //  debut transac :
        
         
              String four1 , cb1 , lib1 , desc1 , unit1 , pau1 , dtexp1 , cl1 , conserv1 , pa1 , qt1 , pvu1 , stockMiniT ;
              
              int four2 = 0 ;
              long pau2 = 0 ; Double pa2 = 0.0 ; Double qt2 = 0.0 ; long pvu2 = 0 ;
              int stockMini;
              
        
        cb1 = cb.getText().trim() ; 
        lib1 = "vide" ; desc1 = desc.getText().trim() ;
        unit1 = "vide" ; pau1 = pau.getText().trim() ;
        dtexp1 = "vide" ; cl1 = this.f.getSelectedItem().toString() ;
        conserv1 = this.sf.getSelectedItem().toString() ;
        pa1 = "0" ;
        qt1 = "0" ; pvu1 = pvu.getText().trim() ;
        
        if("".equalsIgnoreCase(stockMin.getText().trim())){
             stockMiniT = "0" ;
        }else{
        stockMiniT = stockMin.getText().trim() ;
        }
        
        // stockMiniT = stockMin.getText();
       
       if(this.rp.isSelected()){
            this.rapport = "oui" ;
        }else{
            this.rapport = unit1 ;
        }
       
       if (stockMiniT == null) {
            stockMini = 0;
        } else {
           stockMini = Integer.parseInt(stockMiniT); 
        }
       
        
        if("".equalsIgnoreCase(desc1) || "0".equalsIgnoreCase(pvu1) || "0".equalsIgnoreCase(pau1) || "CHOISIR UNE FAMILLE".equalsIgnoreCase(cl1) || "CHOISIR UNE SOUS FAMILLE".equalsIgnoreCase(conserv1)){
        
        JOptionPane jp = new JOptionPane() ;
        jp.showMessageDialog(null," Les champs desc , P.A et prix de vente sont obligatoire ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
        
        
        }else{
     
            try{
            
                four2 = Integer.parseInt("0") ;
                pau2 = Long.parseLong(pau1) ;
                pa2 = Double.parseDouble("0") ;
                qt2 = Double.parseDouble("0") ;
                pvu2 = Long.parseLong(pvu1) ;
                
                
            }catch(Exception e){
            
                 JOptionPane jp = new JOptionPane() ;
        jp.showMessageDialog(null," Les champs prix achat et prix de vente sont en chiffre uniquement ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
        
            }
        
         SessionFactory sf=new Configuration().configure().buildSessionFactory() ;
         Session s=sf.openSession();
            
            Transaction tr = s.beginTransaction();
            
       MatieresP cu = new   MatieresP(four2, cb1, lib1, desc1, this.rapport, pau2, dtexp1, cl1, conserv1, pa2, qt2, pvu2, this.dc, this.admin, stockMini , this.idf , this.idsf)  ;
            
       
       //  List entreprise = s.createSQLQuery("SELECT * FROM fournisseurs WHERE entreprise='"+entr1.replaceAll("'", "''")+"' ").list();
       
         
               // verification if qery is ok
       
       
          List entreprise = s.createSQLQuery("SELECT * FROM matieres_p WHERE description = '"+desc1.replaceAll("'", "''")+"' ").list() ;
       
         
               // verification if qery is ok
            
            if(entreprise.size() == 1){
                
       JOptionPane jp = new JOptionPane() ;
       jp.showMessageDialog(null," La matiere existe dej� ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
        
                
            }else{
            
           
                           s.save(cu) ;
            
                           tr.commit();
                           s.close();
            
                        cb.setText("") ; 
                        desc.setText("");  
                        pau.setText("0"); 
                        pvu.setText("0") ;
                        this.stockMin.setText("0") ;
                        this.rp.setSelected(false) ;
                        this.f.setSelectedItem("CHOISIR UNE FAMILLE") ;
                        this.sf.addItem(new String("CHOISIR UNE SOUS FAMILLE"));
                        this.sf.setSelectedItem("CHOISIR UNE SOUS FAMILLE") ;
              
                      
        
         
        JOptionPane jp = new JOptionPane() ;
        jp.showMessageDialog(null," La matiere primaire a ete cree avec succes","Information",JOptionPane.INFORMATION_MESSAGE) ;
        
                     
            }   
            
            
       
        }
        
        
        
           
        
        
    //   Fin transac :
        
  
        
        
         }catch(Exception e1){
            
        }
        
        
        AddMatPr af = new AddMatPr() ;
        
            af.setAdmin(this.admin) ;
            
        af.setVisible(true) ;
        this.setVisible(false) ;
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pvuMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_pvuMouseClicked

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbActionPerformed
   long idf = 0 ; long idsf = 0 ;
    private void fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fActionPerformed
        // TODO add your handling code here:
        
         String rflle = this.f.getSelectedItem().toString().replaceAll("'", "''") ;
         this.idf = 0 ; this.idsf = 0 ;
        
         if(rflle.equalsIgnoreCase("CHOISIR UNE FAMILLE")){
         
             
 //     this.sf.removeAllItems() ;
   //   this.sf.addItem(new String("CHOISIR UNE SOUS FAMILLE"));
     // this.sf.setSelectedItem("CHOISIR UNE SOUS FAMILLE") ;
       
             
         }else{
             
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
      
      this.sf.removeAllItems() ;
      this.sf.addItem("CHOISIR UNE SOUS FAMILLE") ;
       
        String sql ;
      
       sql = "SELECT distinct id FROM famille WHERE nom = '"+rflle+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
  
       this.idf = rs.getLong("id") ;
          
         
       
     }
    
     
        
       String sql2 ;
      
       sql2 = "SELECT * FROM sfamille WHERE rflle = '"+rflle+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
  
       this.sf.addItem(rs2.getString("nom")) ;  
          
         
       
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
        
        
        
        
        
        
        
        // f :
             
             
         }
        
        
        
    }//GEN-LAST:event_fActionPerformed

    private void sfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sfActionPerformed
        // TODO add your handling code here:
        
        
           
        
    }//GEN-LAST:event_sfActionPerformed

    private void sfMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sfMouseReleased
        // TODO add your handling code here:
        
         String rflle = "" ;
         rflle = this.sf.getSelectedItem().toString().replaceAll("'", "''") ;
         this.idsf = 0 ;
        
         if(rflle.equalsIgnoreCase("CHOISIR UNE SOUS FAMILLE")){
         
             
  //    this.sf.removeAllItems() ;
  //    this.sf.addItem("VOUS DEVEZ CHOISIR UNE FAMILLE SVP") ;
       
             
         }else{
             
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
      
   //   this.sf.removeAllItems() ;
   //   this.sf.addItem("CHOISIR UNE SOUS FAMILLE") ;
       
        String sql ;
      
       sql = "SELECT distinct id FROM sfamille WHERE nom = '"+rflle+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
  
       this.idsf = rs.getLong("id") ;
          
         
       
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
        
        
        
        
        
        
        
        // f :
             
             
         }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_sfMouseReleased

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
            java.util.logging.Logger.getLogger(AddMatPr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMatPr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMatPr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMatPr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMatPr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cb;
    private javax.swing.JTextField desc;
    private javax.swing.JComboBox f;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField pau;
    private javax.swing.JTextField pvu;
    private javax.swing.JCheckBox rp;
    private javax.swing.JComboBox sf;
    private javax.swing.JTextField stockMin;
    // End of variables declaration//GEN-END:variables
}
