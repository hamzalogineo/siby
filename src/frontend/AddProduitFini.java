/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import entity.ComptesU;
import entity.ProduitsF;
import static frontend.AdCompte.state;
import static frontend.FamilleSousF.JDBC_DRIVER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.ComboBoxModel;
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
public class AddProduitFini extends javax.swing.JFrame {

    /**
     * Creates new form AddFournisseur
     */
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
    
     String admin , dc  ;
     String rapport = "" ;
     
     
    public AddProduitFini() {
        //this.setLocation(320, 50);
        initComponents();
        this.setLocationRelativeTo(null);
        
          String format = "dd/MM/yyyy";

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
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
        libel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        desc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        pru = new javax.swing.JTextField();
        cb = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rp = new javax.swing.JCheckBox();
        f = new javax.swing.JComboBox();
        sf = new javax.swing.JComboBox();
        stockMin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AJOUTER UN PRODUIT FINI  ");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Prix d'achat:");

        libel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        libel.setText("0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Description  :");

        desc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Prix de vente   :");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton2.setText("AJOUTER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pru.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pru.setText("0");

        cb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("CODE BARRE :");

        jLabel7.setText("FCFA");

        jLabel8.setText("FCFA");

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Stock minimum *");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(libel, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(pru))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(41, 41, 41))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sf, 0, 229, Short.MAX_VALUE)
                            .addComponent(f, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(libel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(sf, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(rp)
                    .addComponent(stockMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        try{
         
        //  debut transac :
        
              this.rapport = "" ;
         
              String   cb1 , libel1 , desc1 , pru1 , unit1 , f1 , sf1 , stockMiniT;
              long pru11 = 0 ;
              long libel11 = 0 ;
              int stockMini ;
              
        
        cb1 = cb.getText().trim() ; libel1 = libel.getText().trim() ; 
        desc1 = desc.getText().trim() ; pru1 = pru.getText().trim() ;
        unit1 = "vide" ;   
        f1  = this.f.getSelectedItem().toString() ;
        sf1 = this.sf.getSelectedItem().toString() ;
        
        if("".equalsIgnoreCase(stockMin.getText().trim())){
             stockMiniT = "0" ;
        }else{
        stockMiniT = stockMin.getText().trim() ;
        }
        
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
       
                 try{
                     libel11 = Long.parseLong(libel1) ;
                     pru11 = Long.parseLong(pru1) ;
                 
                 }catch(Exception e){
                  
                     JOptionPane jp = new JOptionPane() ;
        jp.showMessageDialog(null," Le prix unitaire en chiffre uniquement avec le prix Achat svp  ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
       
                 }
        
        if("".equalsIgnoreCase(desc1)  || pru11 == 0 || "CHOISIR UNE FAMILLE".equalsIgnoreCase(f1) || "CHOISIR UNE SOUS FAMILLE".equalsIgnoreCase(sf1)){
        
        JOptionPane jp = new JOptionPane() ;
        jp.showMessageDialog(null," Les champs description et prix unitaire de vente sont obligatoire ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
        
        
        }else{
     
        
         SessionFactory sf = new Configuration().configure().buildSessionFactory();
         Session s = sf.openSession() ;
            
            Transaction tr = s.beginTransaction();
            
       ProduitsF cu = new ProduitsF(cb1, libel11, desc1, pru11, this.rapport, this.dc , this.admin , f1 , sf1, stockMini,this.idf,this.idsf) ;
            
       
         List codeb = s.createSQLQuery("SELECT * FROM produits_f WHERE code_barre='"+cb1.replaceAll("'", "''")+"' ").list();
         List lib = s.createSQLQuery("SELECT * FROM produits_f WHERE description='"+desc1.replaceAll("'", "''")+"' ").list();
            
               // verification if qery is ok
            
            if(lib.size() == 1){
                
       JOptionPane jp = new JOptionPane() ;
       jp.showMessageDialog(null," Ce produit fini existe dej? ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
        
                
            }else{
                 if(codeb.size() == 1){
                     if("".equalsIgnoreCase(cb.getText().trim())){
                       
                           s.save(cu) ;
            
                           tr.commit() ;
                           s.close() ;
            
                        libel.setText("0") ;  cb.setText("") ;  
                        desc.setText("") ;  pru.setText("0") ;
                        this.stockMin.setText("0");
                        this.rp.setSelected(false) ;
                        this.f.setSelectedItem("CHOISIR UNE FAMILLE") ;
                        this.sf.setSelectedItem("CHOISIR UNE SOUS FAMILLE") ;
              
        
         
        JOptionPane jp = new JOptionPane() ;
        jp.showMessageDialog(null," Le produit fini a ete cree avec succes","Information",JOptionPane.INFORMATION_MESSAGE) ;
        
                     
                     }else{
                
       JOptionPane jp = new JOptionPane() ;
       jp.showMessageDialog(null," Ce code barre existe deja pour un autre produit fini ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
                     
                     }
                
            }else{
            
            s.save(cu) ;
            
            tr.commit() ;
            s.close() ;
            
             libel.setText("0");  cb.setText("") ;  
             desc.setText("") ;  pru.setText("0") ;
             this.stockMin.setText("0");
             this.rp.setSelected(false) ;
             this.f.setSelectedItem("CHOISIR UNE FAMILLE") ;
             this.sf.setSelectedItem("CHOISIR UNE SOUS FAMILLE") ;
             
        
         
        JOptionPane jp = new JOptionPane() ;
        jp.showMessageDialog(null," Le produit fini a ete cree avec succes","Information",JOptionPane.INFORMATION_MESSAGE) ;
        
                 }
            
            }
            
            
            
            
       
        }
        
        
        
           
        
        
    //   Fin transac :
        
        
        }catch(Exception e1){
            
        }
        
        
        
         AddProduitFini af = new AddProduitFini() ;
        
            af.setAdmin(this.admin) ;
            
        af.setVisible(true) ;
        this.setVisible(false) ;
        
        
    }//GEN-LAST:event_jButton2ActionPerformed
 long idf = 0 ; long idsf = 0 ;
    private void fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fActionPerformed
        // TODO add your handling code here:
        
        
        String rflle = this.f.getSelectedItem().toString().replaceAll("'", "''") ;
        this.idf = 0 ; this.idsf = 0 ;
        
         if(rflle.equalsIgnoreCase("CHOISIR UNE FAMILLE")){
         
             
        //this.sf.removeAllItems() ;
       // this.sf.addItem(new String);
     // this.sf.addItem("VOUS DEVEZ CHOISIR UNE FAMILLE SVP") ;
        
             
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
      
     // this.sf.removeAllItems() ;
     // this.sf.addItem("CHOISIR UNE SOUS FAMILLE") ;
       
      
      
      
        String sql ;
      
       sql = "SELECT distinct id FROM famille WHERE nom = '"+rflle+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
  
       this.idf = rs.getLong("id") ;
          
         
       
     }
    
     
        this.sf.removeAllItems();
        this.sf.addItem(new String("CHOISIR UNE SOUS FAMILLE"));
       String sql2 ;
      
       sql2 = "SELECT * FROM sfamille WHERE rflle = '"+rflle+"'"  ;
      
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
         
             
   //   this.sf.removeAllItems() ;
  //   this.sf.addItem("VOUS DEVEZ CHOISIR UNE FAMILLE SVP") ;
       
             
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
      
  //    this.sf.removeAllItems() ;
      //  this.sf.addItem("CHOISIR UNE SOUS FAMILLE") ;
       
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
            java.util.logging.Logger.getLogger(AddProduitFini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProduitFini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProduitFini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProduitFini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProduitFini().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cb;
    private javax.swing.JTextField desc;
    private javax.swing.JComboBox f;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField libel;
    private javax.swing.JTextField pru;
    private javax.swing.JCheckBox rp;
    private javax.swing.JComboBox sf;
    private javax.swing.JTextField stockMin;
    // End of variables declaration//GEN-END:variables
}
