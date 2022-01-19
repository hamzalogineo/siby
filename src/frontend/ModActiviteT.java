/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import entity.ActiviteT;
import static frontend.AddActiviteT.JDBC_DRIVER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
public class ModActiviteT extends javax.swing.JFrame {

    /**
     * Creates new form AddFournisseur
     */
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
    
     long id ;
     
     String admin , dc  ;
     
     String libelle ;
     String oldAct = "" ;
    
     
     
    public ModActiviteT() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
          // jComboBox1
        
           
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
      
       sql= "SELECT * FROM gs ORDER BY nom" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
     
      
        
      this.jComboBox1.addItem(rs.getString("nom")) ;
               
        
         
       
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
    
    
    
    
    
    
    public void setId(long id) {
        this.id = id;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public void setLib(String lib) {
        this.lib.setText(lib) ;
    }

    public void setjComboBox1(String jComboBox1) {
        this.jComboBox1.addItem(new String(jComboBox1));
        this.jComboBox1.setSelectedItem(jComboBox1) ;
    }

    public String getOldAct() {
        return oldAct;
    }

    public void setOldAct(String oldAct) {
        this.oldAct = oldAct;
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
        lib = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MODIFIER ACTIVITER DE TRANSFORMATION");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Description  :");

        lib.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setText("MODIFIER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("GROUPE            :");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECTIONNER UN GROUPE" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(229, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lib))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(55, Short.MAX_VALUE))
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
        
           String   lib1 , desc1  ;
             
              
              
              
        
        lib1 = lib.getText().trim() ; 
       
        desc1 = this.jComboBox1.getSelectedItem().toString() ; ;
       
        
       
                
        
        if("".equalsIgnoreCase(lib1) || "SELECTIONNER UN GROUPE".equalsIgnoreCase(this.jComboBox1.getSelectedItem().toString())){
        
        JOptionPane jp = new JOptionPane() ;
        jp.showMessageDialog(null," Le nom de l'activit� avec son groupe est obligatoire ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
        
        
        }else{
       
        
         SessionFactory sf=new Configuration().configure().buildSessionFactory();
         Session s=sf.openSession();
            
            Transaction tr = s.beginTransaction();
            
       ActiviteT cu = new   ActiviteT(this.id ,desc1 ,  lib1, this.dc , this.admin,this.idg)  ;
            
       
         List entreprise = s.createSQLQuery("SELECT * FROM activite_t WHERE description = '"+lib1.replaceAll("'", "''")+"' ").list();
       
         
               // verification if qery is ok
            
            if(entreprise.size() == 1){
                if(this.libelle.equalsIgnoreCase(lib1)){
                   
                    
                    
                                        
       // debut :
        
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
      
        if(stmt.executeUpdate("UPDATE pmp SET nomp = '"+lib1.replaceAll("'", "''")+"' WHERE idp = "+this.id) > 0 || stmt.executeUpdate("UPDATE pmp SET nomp = '"+lib1.replaceAll("'", "''")+"' WHERE idp = "+this.id) == 0){
            if(stmt.executeUpdate("UPDATE ppf SET nomp = '"+lib1.replaceAll("'", "''")+"' WHERE idp = "+this.id) > 0 || stmt.executeUpdate("UPDATE pmp SET nomp = '"+lib1.replaceAll("'", "''")+"' WHERE idp = "+this.id) == 0){
                  if(stmt.executeUpdate("update prod set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("update prod set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") == 0){
                       if(stmt.executeUpdate("update prodmp set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("update prodmp set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") == 0){
                               if(stmt.executeUpdate("update prodpf set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("update prodpf set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") == 0){
                                   if(stmt.executeUpdate("update histobon set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("update histobon set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") == 0){
                                       
                                   
                           s.update(cu) ;
            
                           tr.commit() ;
                           s.close() ;
            
                           // String   entr1 , nc1 , ad1 , c11 , c22 , email1 , fonc1 , desc1 , pl1  ;
                           
                           lib.setText("");  
                           this.jComboBox1.setSelectedItem("SELECTIONNER UN GROUPE");
                           
              
        
         
        JOptionPane jp = new JOptionPane() ;
        jp.showMessageDialog(null," L'activit� a �t� modifi�e avec succes","Information",JOptionPane.INFORMATION_MESSAGE) ;
               
                  }
                  }
                  
                  }
        
                  }
        
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
     
        
                  
                
                }else{
                
       JOptionPane jp = new JOptionPane() ;
       jp.showMessageDialog(null," L'activit� existe dej� ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
                }
                
            }else{
                
                
                  // debut :
        
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
      
         if(stmt.executeUpdate("UPDATE pmp SET nomp = '"+lib1.replaceAll("'", "''")+"' WHERE idp = "+this.id) > 0 || stmt.executeUpdate("UPDATE pmp SET nomp = '"+lib1.replaceAll("'", "''")+"' WHERE idp = "+this.id) == 0){
            if(stmt.executeUpdate("UPDATE ppf SET nomp = '"+lib1.replaceAll("'", "''")+"' WHERE idp = "+this.id) > 0 || stmt.executeUpdate("UPDATE pmp SET nomp = '"+lib1.replaceAll("'", "''")+"' WHERE idp = "+this.id) == 0){
                  if(stmt.executeUpdate("update prod set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("update prod set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") == 0){
                       if(stmt.executeUpdate("update prodmp set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("update prodmp set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") == 0){
                               if(stmt.executeUpdate("update prodpf set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("update prodpf set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") == 0){
                                   if(stmt.executeUpdate("update histobon set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("update histobon set nom = '"+lib1.replaceAll("'", "''")+"' where nom = '"+this.oldAct.replaceAll("'", "''")+"'") == 0){
                                       
                                   
                           s.update(cu) ;
            
                           tr.commit() ;
                           s.close() ;
            
                           // String   entr1 , nc1 , ad1 , c11 , c22 , email1 , fonc1 , desc1 , pl1  ;
                           
                           lib.setText("");  
                           this.jComboBox1.setSelectedItem("SELECTIONNER UN GROUPE");
                           
              
        
         
        JOptionPane jp = new JOptionPane() ;
        jp.showMessageDialog(null," L'activit� a �t� modifi�e avec succes","Information",JOptionPane.INFORMATION_MESSAGE) ;
               
                  }
                  }
                  
                  }
        
                  }
        
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
     
        
                
                
                
                
                 
                     
                     }
            
            
       
        }
        
        
        
           
        
        
    //   Fin transac :
        
  
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed
Integer idg = 0 ;
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
        
        
        String rflle = this.jComboBox1.getSelectedItem().toString().replaceAll("'", "''") ;
        this.idg = 0 ;  
        
         if(rflle.equalsIgnoreCase("SELECTIONNER UN GROUPE")){
         
              
             
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
      
       sql = "SELECT distinct id FROM gs WHERE nom = '"+rflle+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
  
       this.idg = rs.getInt("id") ;
          
         
       
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
        
        
        
        
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(ModActiviteT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModActiviteT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModActiviteT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModActiviteT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new ModActiviteT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lib;
    // End of variables declaration//GEN-END:variables
}