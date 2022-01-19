/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import entity.ProduitsF;
import static frontend.AddProduitFini.JDBC_DRIVER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HAMZA
 */
public class ModProduitFini1 extends javax.swing.JFrame {

    /**
     * Creates new form AddFournisseur
     */
    
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
    
    int id ;
     
     String admin , dc  ;
     String rapport = "" ;
     
     String cpfNom ;
     
     
     
     // old <Data update :
     
      String oldCb ;
      String oldDescrip ;
      long oldPa ;
      long oldPu ;
      int oldSmini ;
      long idS = 0 ;
      String rflle = "vide" ;
     
     
    public ModProduitFini1() {
        initComponents();
        this.setLocationRelativeTo(null);
        
         
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
      
     
     String sql2 ;
      
       sql2 = "SELECT * FROM sfamille" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
             
        this.sf.addItem(rs2.getString("nom"))  ;
 
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
    
    
    
    
    
    
     public ModProduitFini1(String rflle) {
        initComponents();
        this.setLocationRelativeTo(null);
        
         
        // d :
           
          this.rflle = rflle ;
        
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
      
     
     String sql2 ;
      
       sql2 = "SELECT * FROM sfamille" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
             
        this.sf.addItem(rs2.getString("nom"))  ;
 
     }  
     
     
      // this.rflle = rflle ;
     
      this.sf.setSelectedItem(this.rflle) ;
    
            
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
    
    
    
    
    // debut :

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getCpfNom() {
        return cpfNom;
    }

    public void setCpfNom(String cpfNom) {
        this.cpfNom = cpfNom;
    }

    public JTextField getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb.setText(cb) ;
    }

    public JTextField getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc.setText(desc) ;
    }

    public JTextField getLibel() {
        return libel;
    }

    public void setLibel(String libel) {
        this.libel.setText(libel) ;
    }

    public JTextField getPru() {
        return pru;
    }

    public void setPru(String pru) {
        this.pru.setText(pru) ;
    }

    public void setRp(boolean rp) {
        this.rp.setSelected(rp) ;
    }

    public void setF(String f) {
        this.f.setSelectedItem(f);
    }

    public void setSf(String sf) {
        this.sf.addItem(sf) ;
        this.sf.setSelectedItem(sf) ;
    }

   
   public void setStockMini(String stockMin) {
        this.stockMin.setText(stockMin);
    }
   public void setRp() {
        this.rp.setEnabled(false);
    }

    public void setOldCb(String oldCb) {
        this.oldCb = oldCb;
    }

    public void setOldDescrip(String oldDescrip) {
        this.oldDescrip = oldDescrip;
    }

    public void setOldPa(long oldPa) {
        this.oldPa = oldPa;
    }

    public void setOldPu(long oldPu) {
        this.oldPu = oldPu;
    }

    public void setOldSmini(int oldSmini) {
        this.oldSmini = oldSmini;
    }

    public void setIdS(long idS) {
        this.idS = idS;
    }

    public String getRflle() {
        return rflle;
    }

    public void setRflle(String rflle) {
        this.rflle = rflle;
    }
    
    
    
    
    
  // fin :
    
    
    

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
        jLabel5 = new javax.swing.JLabel();
        stockMin = new javax.swing.JTextField();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MODIFIER UN PRODUIT FINI  ");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Prix Achat :");

        libel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        libel.setText("0");
        libel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Description  :");

        desc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Prix de vente   :");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton2.setText("MODIFIER");
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f, 0, 225, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(libel, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(pru))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rp, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(stockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251))
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
                            .addComponent(jLabel3)
                            .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(libel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(rp)))
                    .addComponent(sf, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stockMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))
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
                .addContainerGap(51, Short.MAX_VALUE))
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
     //   System.out.println("id stock1 = "+this.idS);
        
              this.rapport = "" ;
        
         
              String   cb1 , libel1 , desc1 , pru1 , unit1 , f1 , sf1, stockMiniT ;
              long pru11 = 0 ;
              long libel11 = 0 ;
              int stockMini;
              
        
        cb1 = cb.getText().trim() ; libel1 = libel.getText().trim() ; 
        desc1 = desc.getText().trim().replaceAll("'", "''") ; pru1 = pru.getText().trim() ;
        unit1 = "vide" ;  
        f1  = this.f.getSelectedItem().toString() ;
        sf1 = this.sf.getSelectedItem().toString() ;
        
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
       
       
                 try{
                     libel11 = Long.parseLong(libel1) ;
                     pru11 = Long.parseLong(pru1) ;
                 
                 }catch(Exception e){
                  
                     JOptionPane jp = new JOptionPane() ;
        jp.showMessageDialog(null," Le prix unitaire en chiffre uniquement avec le prix achat svp  ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
       
                 }
        
        if("".equalsIgnoreCase(desc1)  || pru11 == 0 || "CHOISIR UNE FAMILLE".equalsIgnoreCase(f1) || "CHOISIR UNE SOUS FAMILLE".equalsIgnoreCase(sf1)){
        
        JOptionPane jp = new JOptionPane() ;
        jp.showMessageDialog(null," Les champs description et prix unitaire de vente sont obligatoire ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
        
        
        }else{
     
        
         SessionFactory sf=new Configuration().configure().buildSessionFactory();
         Session s=sf.openSession();
            
            Transaction tr = s.beginTransaction();
            
       ProduitsF cu = new   ProduitsF(this.id, cb1, libel11, desc1, pru11, this.rapport, this.dc , this.admin , f1 , sf1, stockMini , this.idf , this.idsf) ;
            
       
       //  List codeb = s.createSQLQuery("SELECT * FROM produits_f WHERE code_barre='"+cb1.replaceAll("'", "''")+"' ").list();
         List lib = s.createSQLQuery("SELECT * FROM produits_f WHERE description = '"+desc1.replaceAll("'", "''")+"' ").list();
            
               // verification if qery is ok
            
            
             
                
                    
                    Connection conn = null ;
                    Statement stmt = null  ; 
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      
           System.out.println(this.desc.getText());
           
      stmt = conn.createStatement();
      
      // je crai ma requete
      
           if(stmt.executeUpdate("UPDATE ppf SET cb = '"+this.cb.getText()+"' , article = '"+this.desc.getText().replaceAll("'", "''").trim()+"' , pa ="+Long.parseLong(this.libel.getText())+" , pu = "+Long.parseLong(this.pru.getText())+" WHERE article = '"+this.oldDescrip.replaceAll("'", "''").trim()+"'") >= 0 ){
                if(stmt.executeUpdate("UPDATE pmp SET cb = '"+this.cb.getText()+"' , article = '"+this.desc.getText().replaceAll("'", "''").trim()+"' , pa ="+Long.parseLong(this.libel.getText())+" , pv = "+Long.parseLong(this.pru.getText())+" WHERE article = '"+this.oldDescrip.replaceAll("'", "''").trim()+"'") >= 0 ){
                    
                   if(stmt.executeUpdate("UPDATE stock1 SET f = '"+this.f.getSelectedItem().toString().replaceAll("'", "''")+"' , sf = '"+this.sf.getSelectedItem().toString().replaceAll("'", "''")+"' , cb = '"+this.cb.getText()+"' , desi = '"+this.desc.getText().replaceAll("'", "''").trim()+"' , pa ="+Long.parseLong(this.libel.getText())+" , pv = "+Long.parseLong(this.pru.getText())+" WHERE desi = '"+this.oldDescrip.replaceAll("'", "''")+"'") >= 0 ){
                 // System.out.println("id stock1 last = "+this.idS) ;  
                            
                              s.update(cu) ;
            
                              tr.commit();
                              s.close();
             
                             libel.setText("0");  cb.setText("") ;  
                             desc.setText("") ;  pru.setText("0") ;
                             this.stockMin.setText("0") ;
                             this.rp.setSelected(false) ;
                             this.f.setSelectedItem("CHOISIR UNE FAMILLE") ;
                             this.sf.setSelectedItem("CHOISIR UNE SOUS FAMILLE") ;
              
                             
         
                   
                           
                   
               
                 }
               
               
                
                
                }
           
               
           }
           
                
stmt.executeUpdate("update stock_pl set description = '"+desc1+"' where description = '"+this.oldDescrip.replaceAll("'", "''")+"'") ;
stmt.executeUpdate("update detail_pl set description = '"+desc1+"' where description = '"+this.oldDescrip.replaceAll("'", "''")+"'") ;
stmt.executeUpdate("update stock_detail_pl set description = '"+desc1+"' where description = '"+this.oldDescrip.replaceAll("'", "''")+"'") ;
stmt.executeUpdate("update p_derive set pere = '"+desc1+"' where pere = '"+this.oldDescrip.replaceAll("'", "''")+"'") ;

stmt.executeUpdate("update produits_pl set cb = '"+cb1+"' where recherche = '"+this.oldDescrip.replaceAll("'", "''")+"'") ;
stmt.executeUpdate("update produits_pl set pa = "+libel11+" where recherche = '"+this.oldDescrip.replaceAll("'", "''")+"'") ;
stmt.executeUpdate("update produits_pl set pu = "+pru11+" where recherche = '"+this.oldDescrip.replaceAll("'", "''")+"'") ;

stmt.executeUpdate("update produits_pl set recherche = '"+desc1+"' where recherche = '"+this.oldDescrip.replaceAll("'", "''")+"'") ;
              
                     JOptionPane jp = new JOptionPane() ;
                     jp.showMessageDialog(null," Le produit fini a été modifié avec succes","Information",JOptionPane.INFORMATION_MESSAGE) ;
                     this.dispose() ;
            
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
                    
                    
                    
                    
                           
                
                
                
            }
            
            
            
       
        
        
        
        
           
        
        
    //   Fin transac :
        
        
         }catch(Exception e1){
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void libelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_libelActionPerformed
  long idf = 0 ; long idsf = 0 ;
    private void fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fActionPerformed
        // TODO add your handling code here:
        
        
        String rflle = this.f.getSelectedItem().toString().replaceAll("'", "''") ;
        this.idf = 0 ; this.idsf = 0 ;
        
         if(rflle.equalsIgnoreCase("CHOISIR UNE FAMILLE")){
         
             
      this.sf.removeAllItems() ;
      this.sf.addItem("VOUS DEVEZ CHOISIR UNE FAMILLE SVP") ;
       
             
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
      
       sql2 = "SELECT * FROM sfamille WHERE (rflle = '"+rflle+"' OR idf = "+this.idf+" )" ;
      
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
        
        
         try{
           
                  rflle = this.sf.getSelectedItem().toString().replaceAll("'", "''") ;
             
         }catch(Exception e){
//                  rflle = this.sf.getSelectedItem().toString().replaceAll("'", "''") ;
         }
         
        this.idsf = 0 ;
        
         if(rflle.equalsIgnoreCase("CHOISIR UNE SOUS FAMILLE")){
         
             
    //  this.sf.removeAllItems() ;
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
      
    //  this.sf.removeAllItems() ;
    //  this.sf.addItem("CHOISIR UNE SOUS FAMILLE") ;
       
        String sql ;
      
       sql = "SELECT distinct id FROM sfamille WHERE nom = '"+rflle+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
  
       this.idsf = rs.getLong("id") ;
          
      //   JOptionPane.showMessageDialog(this, idsf);
       
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
            java.util.logging.Logger.getLogger(ModProduitFini1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModProduitFini1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModProduitFini1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModProduitFini1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ModProduitFini1().setVisible(true);
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
