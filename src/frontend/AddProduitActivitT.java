/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend ;

import entity.ActiviteTMatieresP;
import entity.ActiviteTProduitFini;
import static frontend.AddMatierePrimairePourActivitT.JDBC_DRIVER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HAMZA
 */
public class AddProduitActivitT extends javax.swing.JFrame {

    /**
     * Creates new form AddProduit
     */
    
    
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
        static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
        static final String USER = "root" ;
        static final String PASS = "interco" ;
      
        String admin , dc  ;
        long id = 0 ;
        
       DefaultListModel produitsG = new DefaultListModel() ;
       DefaultListModel produitsD = new DefaultListModel() ;
    
    
    
    
    public AddProduitActivitT() {
        initComponents();
        this.setLocationRelativeTo(null);
          String format = "dd/MM/yy";

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();

        this.dc = formater.format( date ) ;
        
        
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
     
      
      //
          // you can do java :
      
      //
        
         
      String sql ;
      
       sql= "SELECT * FROM produits_f " ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        produitsG.addElement(rs.getString("libelle")) ;
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
     
      String sql2 ;
      
       sql2= "SELECT * FROM activite_t_produit_fini WHERE id_activite_t ="+this.id ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
     while(rs2.next()){
        
        produitsD.addElement(rs2.getString("nom_produit_fini")) ;
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
     
     
     
     
      
    
          // code patient 
      
      jList1.setModel(produitsG) ;
      jList2.setModel(produitsD);
      
    
            
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
    
    
    public AddProduitActivitT(long id) {
        initComponents();
         this.id = id ;  
         
         
         String format = "dd/MM/yy";

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();

        this.dc = formater.format( date ) ;
        
        
        
        
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
     
      
        //
          // you can do java :
      
      //
        
         
      String sql ;
      
       sql= "SELECT * FROM produits_f " ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        produitsG.addElement(rs.getString("libelle")) ;
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
     
       String sql2 ;
      
       sql2= "SELECT * FROM activite_t_produit_fini WHERE id_activite_t ="+this.id ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
      while(rs2.next()){
        
      produitsD.addElement(rs2.getString("nom_produit_fini")) ;
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
     
     
     
     
      
    
          // code patient 
      
      jList1.setModel(produitsG) ;
      jList2.setModel(produitsD);
      
    
          
            
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

    public void setId(long id) {
        this.id = id;
    }

    public void setMp(String mp0) {
        this.mp.setText(mp0) ;
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        mp = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jButton1.setText("FERMER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SELECTIONNER LES PRODUITS FINI POUR L'ACTIVITER T CHOISIS  :");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jList1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("LES PRODUITS FINIS QUE NOUS FAISONS ICI  :");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton2.setText("AJOUTER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton3.setText("RETIRER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jList2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jScrollPane2.setViewportView(jList2);

        mp.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        mp.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("ID AT:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("PRODUIT(S) FINI OBTENUS A LA FIN DE L'ACTIVITE ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mp, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(mp))
                        .addGap(140, 140, 140)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false) ;
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
         if(jList1.getSelectedIndex() == -1 ){
        
              JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null,"Pour ajouter un produit fini selectionner dans la liste a gauche","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
        
        }else{
            
              try{
                  
            Long idmp = Long.parseLong(mp.getText()) ;
            String product = jList1.getSelectedValue().toString() ;
            
            // debut ::
            
            
                 SessionFactory sf=new Configuration().configure().buildSessionFactory();
                 Session s=sf.openSession();
            
                 Transaction tr = s.beginTransaction();
            
       ActiviteTProduitFini cu = new   ActiviteTProduitFini(idmp, product, this.dc,  this.admin)  ;
            
       
         List entreprise = s.createSQLQuery("SELECT * FROM activite_t_produit_fini WHERE id_activite_t ="+idmp+" AND nom_produit_fini ='"+product.replaceAll("'", "''")+"'").list();
       
         
               // verification if qery is ok
            
            if(entreprise.size() == 1){
                
       JOptionPane jp = new JOptionPane() ;
       jp.showMessageDialog(null," Ce produit fini est dejà ajouter pour l'activité ouverte ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
        
                
            }else{
                 
                           s.save(cu) ;
            
                           tr.commit() ;
                           s.close() ;
            
                           // cursor go to fetch  :
                           
                            
                           
                           produitsD.clear() ;
                           
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
     
      
      //
          // you can do java :
      
      //
     
      String sql2 ;
      
       sql2= "SELECT * FROM activite_t_produit_fini WHERE id_activite_t ="+idmp ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
     while(rs2.next()){
        
        produitsD.addElement(rs2.getString("nom_produit_fini")) ;
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
     
     
     
     
      
    
          // code patient 
      
    //  jList1.setModel(produitsG) ;
     
      jList2.setModel(produitsD);
      
    
            
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

        
                           
                           
                           // end mission
                             
                     
                     }
            
            
            
            // fin ::
            
          
         // System.out.println(jList1.getSelectedValue().toString() + "  date : "+this.dc+"   "+this.admin) ;
                 
              }catch(Exception e){
                  
                  JOptionPane jp = new JOptionPane() ;
       jp.showMessageDialog(null," ERROR EXCEPTION TRAY AGAIN PLEASE ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
        
              }
            
            
        }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
         if(jList2.getSelectedIndex() == -1 ){
        
              JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null,"Pour retirer un produit fini selectionner dans la liste à droite","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
        
        }else{
            
              try{
                  
            Long idmp = Long.parseLong(mp.getText()) ;
            String product = jList2.getSelectedValue().toString() ;
            
            // debut ::
            
            
                 SessionFactory sf=new Configuration().configure().buildSessionFactory();
                 Session s=sf.openSession();
       
         List entreprise = s.createSQLQuery("SELECT * FROM activite_t_produit_fini WHERE id_activite_t ="+idmp+" AND nom_produit_fini ='"+product.replaceAll("'", "''")+"'").list();
       
         
               // verification if qery is ok
            
            if(entreprise.size() == 1){
                
                
                   
                     produitsD.clear() ;
                           
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
     
      
      //
          // you can do java :
      
      if(stmt.executeUpdate("DELETE FROM activite_t_produit_fini WHERE id_activite_t ="+idmp+" AND nom_produit_fini ='"+product.replaceAll("'", "''")+"'") == 1){

          
           //
     
            String sql2 ;
      
            sql2= "SELECT * FROM activite_t_produit_fini WHERE id_activite_t ="+idmp ;
      
            ResultSet rs2 = stmt.executeQuery(sql2);
      
      
            while(rs2.next()){
        
            produitsD.addElement(rs2.getString("nom_produit_fini")) ;
         
           // System.out.print(" LE code patient est Systematique "+cp.getText()) ;
            
           }
     
     
            
            jList2.setModel(produitsD);
     
     
            rs2.close();
          
          
      }
      
     
      
    
          // code patient 
      
    //  jList1.setModel(produitsG) ;
     
      
      
    
            
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

        
                           
                           
                           // end mission
                             
                
        
                
            }else{
                 
                           JOptionPane jp = new JOptionPane() ;
       jp.showMessageDialog(null," Ce produit fin n'existe pas pour identifiant de l'activité = "+mp.getText(),"Avertissement",JOptionPane.WARNING_MESSAGE) ;
        
                            
                        
                     
                     }
            
            
            
            // fin ::
            
          
               // System.out.println(jList1.getSelectedValue().toString() + "  date : "+this.dc+"   "+this.admin) ;
                 
              }catch(Exception e){
                  
                  JOptionPane jp = new JOptionPane() ;
       jp.showMessageDialog(null," ERROR EXCEPTION TRAY AGAIN PLEASE ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
        
              }
            
            
        }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(AddProduitActivitT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProduitActivitT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProduitActivitT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProduitActivitT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProduitActivitT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mp;
    // End of variables declaration//GEN-END:variables
}
