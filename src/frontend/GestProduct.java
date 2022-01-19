/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import com.sun.glass.events.KeyEvent;
import static frontend.CumulProdPfObtenu.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HAMZA
 */
public class GestProduct extends javax.swing.JFrame {

   
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
    String login ;
    Integer id ;
    
    public GestProduct() {
        this.setTitle("Gestion des producteurs") ;
        initComponents() ;
        
        this.setLocationRelativeTo(null) ;
        
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
        
         this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 4) ;
        
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        if ("oui".equalsIgnoreCase(status)) {
            setBackground(Color.darkGray);
            setForeground(Color.WHITE);
        } else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }   
               if(isSelected){
                   this.setBackground(Color.BLUE) ;
                   this.setForeground(Color.WHITE);
               }else{
                   
               }
          
        return this ;
        
    }   
});

        
     
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
        dtm.setRowCount(0) ;
         
        
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
      // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
         
            
        
         Connection conn = null ;
         Statement stmt = null ;
       
       try{
      Class.forName(JDBC_DRIVER);
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      
       
         
      String sql ;
      // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
       sql = "SELECT * FROM productaire ORDER BY producteur ASC" ;
       ResultSet rs = stmt.executeQuery(sql) ;
    
       while(rs.next()){
        
        dtm.addRow(new Object[]{
            
    // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
            
       rs.getInt("productaire.id") , rs.getString("productaire.producteur")  , new String(sdf1.format(rs.getDate("productaire.dtec"))) ,
       rs.getString("user"),rs.getString("type")
                
        }) ;
               
         
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
   
             
        
        //
        
        
        
    }
    
    

    public void setLogin(String login) {
        this.login = login;
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        producteur = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        rch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur", "ETAT"
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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        producteur.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        producteur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                producteurKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Producteur / Groupe de producteur");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("AJOUTER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("MODIFIER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setText("VEILLEUSE");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        rch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rchKeyReleased(evt);
            }
        });

        jLabel2.setText("Producteur");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(producteur, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(195, 195, 195))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rch))
                        .addGap(150, 150, 150))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(producteur, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        this.id = 0 ;
        this.id = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString()) ;
        this.producteur.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString());
        
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        
        String producteur = "" ;
        producteur = this.producteur.getText().trim().replaceAll("'", "''") ;
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy") ; 
        
        if("".equals(producteur)){
            JOptionPane jp = new JOptionPane() ;
            jp.showMessageDialog(this , "Saisir un producteur ou groupe de producteur") ;
            
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") ;
            
            Connection conn = null ;
         Statement stmt = null ;
       
       try{
      Class.forName(JDBC_DRIVER);
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      
       
        if(stmt.executeUpdate("insert into productaire(producteur,dtec,user,type) VALUES('"
                +producteur+"' , '"+sdf.format(new Date())+"' , '"+this.login+"' , 'non'"
                + ")") == 1){
            
                       DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                                         dtm.setRowCount(0) ;
                                         this.producteur.setText("");
                       
                         String sql ;
      // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
       sql = "SELECT * FROM productaire ORDER BY producteur ASC" ;
       ResultSet rs = stmt.executeQuery(sql) ;
    
       while(rs.next()){
        
        dtm.addRow(new Object[]{
            
    // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
            
       rs.getInt("productaire.id") , rs.getString("productaire.producteur")  , new String(sdf1.format(rs.getDate("productaire.dtec"))) ,
       rs.getString("user")
                
        }) ;
               
         
     }
            
            
                        }
       
     
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
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane jp = new JOptionPane() ;
            jp.showMessageDialog(this , "Selectionner un producteur ou groupe de producteur") ;
            
        }else{
            
            String producteur = "" ;
        producteur = this.producteur.getText().trim().replaceAll("'", "''") ;
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ; 
        
        if("".equals(producteur)){
            JOptionPane jp = new JOptionPane() ;
            jp.showMessageDialog(this , "Saisir un producteur ou groupe de producteur") ;
            
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") ;
            
            Connection conn = null ;
            Statement stmt = null ;
       
       try{
      Class.forName(JDBC_DRIVER);
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      
       
        if(stmt.executeUpdate("UPDATE productaire SET producteur = '"+producteur+"' WHERE id = "+this.id) > 0){
            
                       DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                                         dtm.setRowCount(0) ;
                                         this.producteur.setText("");
                       
                         String sql ;
      // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
       sql = "SELECT * FROM productaire ORDER BY producteur ASC" ;
       ResultSet rs = stmt.executeQuery(sql) ;
    
       while(rs.next()){
        
        dtm.addRow(new Object[]{
            
    // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
            
       rs.getInt("productaire.id") , rs.getString("productaire.producteur")  , new String(sdf1.format(rs.getDate("productaire.dtec"))) ,
       rs.getString("user") , rs.getString("type")
                
        }) ;
               
         
     }
            
            
                        }
       
     
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
        
            
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
          if(this.jTable1.getSelectedRow() == -1){
            JOptionPane jp = new JOptionPane() ;
            jp.showMessageDialog(this , "Selectionner un producteur ou groupe de producteur") ;
            
        }else{
            
            String producteur = "" ;
        producteur = this.producteur.getText().trim().replaceAll("'", "''") ;
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ; 
        
        if("".equals(producteur)){
            JOptionPane jp = new JOptionPane() ;
            jp.showMessageDialog(this , "Saisir un producteur ou groupe de producteur") ;
            
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") ;
            
            Connection conn = null ;
            Statement stmt = null ;
       
       try{
      Class.forName(JDBC_DRIVER);
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      
       
        if(stmt.executeUpdate("UPDATE productaire SET type = 'oui' WHERE id = "+this.id) == 1){
            
                       DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                                         dtm.setRowCount(0) ;
                                         this.producteur.setText("");
                       
                         String sql ;
      // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
       sql = "SELECT * FROM productaire ORDER BY producteur ASC" ;
       ResultSet rs = stmt.executeQuery(sql) ;
    
       while(rs.next()){
        
        dtm.addRow(new Object[]{
            
    // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
            
       rs.getInt("productaire.id") , rs.getString("productaire.producteur")  , new String(sdf1.format(rs.getDate("productaire.dtec"))) ,
       rs.getString("user") , rs.getString("type")
                
        }) ;
               
         
     }
            
            
                        }
       
     
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
        
            
        }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void rchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rchKeyReleased
        // TODO add your handling code here:
        
        String rch = "" ;
        rch = this.rch.getText().trim().replaceAll("'", "''") ;
        
        if(rch.equals("")){
            
        }else{
        
            
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
        dtm.setRowCount(0) ;
         
        
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
      // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
         
            
        
         Connection conn = null ;
         Statement stmt = null ;
       
       try{
      Class.forName(JDBC_DRIVER);
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      
       
         
      String sql ;
      // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
       sql = "SELECT * FROM productaire WHERE productaire.producteur LIKE '%"+rch+"%' ORDER BY producteur ASC" ;
       ResultSet rs = stmt.executeQuery(sql) ;
    
       while(rs.next()){
        
        dtm.addRow(new Object[]{
            
    // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
            
       rs.getInt("productaire.id") , rs.getString("productaire.producteur")  , new String(sdf1.format(rs.getDate("productaire.dtec"))) ,
       rs.getString("user")
                
        }) ;
               
         
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
   
             
        
        //
        
            
        }
        
        
    }//GEN-LAST:event_rchKeyReleased

    private void producteurKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_producteurKeyReleased
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
        String producteur = "" ;
        producteur = this.producteur.getText().trim().replaceAll("'", "''") ;
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy") ; 
        
        if("".equals(producteur)){
            JOptionPane jp = new JOptionPane() ;
            jp.showMessageDialog(this , "Saisir un producteur ou groupe de producteur") ;
            
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") ;
            
            Connection conn = null ;
         Statement stmt = null ;
       
       try{
      Class.forName(JDBC_DRIVER);
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      
       
        if(stmt.executeUpdate("insert into productaire(producteur,dtec,user) VALUES('"
                +producteur+"' , '"+sdf.format(new Date())+"' , '"+this.login+"'"
                + ")") == 1){
            
                       DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                                         dtm.setRowCount(0) ;
                                         this.producteur.setText("");
                       
                         String sql ;
      // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
       sql = "SELECT * FROM productaire ORDER BY producteur ASC" ;
       ResultSet rs = stmt.executeQuery(sql) ;
    
       while(rs.next()){
        
        dtm.addRow(new Object[]{
            
    // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
            
       rs.getInt("productaire.id") , rs.getString("productaire.producteur")  , new String(sdf1.format(rs.getDate("productaire.dtec"))) ,
       rs.getString("user")
                
        }) ;
               
         
     }
            
            
                        }
       
     
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
        
        }
        
        
    }//GEN-LAST:event_producteurKeyReleased

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
            java.util.logging.Logger.getLogger(GestProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField producteur;
    private javax.swing.JTextField rch;
    // End of variables declaration//GEN-END:variables
}
