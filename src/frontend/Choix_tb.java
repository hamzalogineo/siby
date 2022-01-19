/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.Lconsult.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HAMZA
 */
public class Choix_tb extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      String tb ;
      Integer id_r ;
      Integer id_sr ;
      
      boolean rb = false ;
      boolean srb = false ;
      
      
      ArrayList<ListChoixCl> list_1 = new ArrayList<ListChoixCl>() ;
      
      ArrayList<Integer> list_id_r = new ArrayList<Integer>() ;
      ArrayList<Integer> list_id_srb = new ArrayList<Integer>() ;
      ArrayList<String> list_tb = new ArrayList<String>() ;
      
      ArrayList<Integer> tb_conf_rubrique = new ArrayList<Integer>() ;
      ArrayList<Integer> tb_conf_srb = new ArrayList<Integer>() ;
      
      
      
    public Choix_tb() {
        initComponents() ;
        
        
        this.setLocationRelativeTo(null) ;
        
    }
    
    
    
    public Choix_tb(String tb) {
        
        initComponents() ;
        
        this.tb = tb.replaceAll("'", "''").trim() ;
        this.jLabel3.setText("TABLEAU DE BORD : "+this.tb) ;
        this.setLocationRelativeTo(null) ;
        
        
         this.jTable1.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable1.getTableHeader().setOpaque(false); 
            this.jTable1.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable1.getTableHeader().setForeground(Color.white) ;
        
            this.jTable1.setRowHeight(17) ;
              
        
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
        
        
        
        
         this.jTable2.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable2.getTableHeader().setOpaque(false); 
            this.jTable2.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable2.getTableHeader().setForeground(Color.white) ;
        
            this.jTable2.setRowHeight(17) ;
               

                  for (int i = 0; i < this.jTable2.getModel().getColumnCount(); i++) {
                    this.jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
        
        
        
        //  ---------  2è choix
              
        
        
        
        
       //   ---------------
        
        
        //
        
       
        
     
        
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        
                          dtm2.setRowCount(0) ;
         
                          
                          
            Connection conn = null;
            Statement stmt = null;
            PreparedStatement pst = null ;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
     
      String sql = null ;
      ResultSet rs = null ;
      
      sql = "select * from conf_tb where tb_name = '"+this.tb+"'" ;
      rs = stmt.executeQuery(sql) ;
      
      while(rs.next()){
          this.tb_conf_rubrique.add(rs.getInt("id_rubrique")) ;
          this.tb_conf_srb.add(rs.getInt("id_srub")) ;
          
          
      }
      
     sql = "select * from rubrique where type = 'oui' " ;
     pst = conn.prepareStatement(sql) ;
     rs = pst.executeQuery() ;
     
     while(rs.next()){
         
         if(this.tb_conf_rubrique.contains(rs.getInt("id"))){
             
             dtm1.addRow(new Object[]{
         // "ID", "RUBRIQUE", "GROUPE", "CHOISIR"
 rs.getInt("id") , rs.getString("rub") , rs.getString("groupe") , true
         
         });
     
             
         }else{
         
         dtm1.addRow(new Object[]{
         // "ID", "RUBRIQUE", "GROUPE", "CHOISIR"
 rs.getInt("id") , rs.getString("rub") , rs.getString("groupe") , false
         
         });
     
         
         }
     
         }
      
     
     
      this.list_id_r.removeAll(this.list_id_r) ;
      this.list_id_srb.removeAll(this.list_id_srb) ;
      this.list_tb.removeAll(this.list_tb) ;
      
      
     sql = "select * from conf_tb where tb_name = ?" ;
     pst = conn.prepareStatement(sql) ;
     pst.setString(1, this.tb) ;
     
     rs = pst.executeQuery() ;
     
     while(rs.next()){
         
         this.list_id_r.add(rs.getInt("id_rubrique")) ;
         this.list_id_srb.add(rs.getInt("id_srub")) ;
         this.list_tb.add(rs.getString("tb_name")) ;
         
          }
      
      
      rs.close() ;
      stmt.close() ;
      pst.close() ;
      conn.close() ;
     
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
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHOISIR LES RUBRIQUES , SOUS-RUBRIQUES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "RUBRIQUE", "GROUPE", "CHOISIR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(270);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(270);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(180);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(180);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "SOUS-RUBRIQUE", "CHOISIR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable2.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("LISTE DES RUBRIQUES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("LISTE DES SOUS RUBRIQUE");

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AJOUTER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 51, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("RETIRER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 51, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("REINITIALISER");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("TABLEAU DE BORD : ");

        jButton4.setBackground(new java.awt.Color(0, 51, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("CONSULTER CONFIG");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 51, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("ACTUALISER");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
            Connection conn = null;
            Statement stmt = null;
            PreparedStatement pst = null ;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
     
      String sql = null ;
      ResultSet rs = null ;
      
       
        if(this.list_1.size() > 0){
        for(int i = 0 ; i < this.list_1.size(); i++){
            
            if(this.list_id_r.contains(this.list_1.get(i).getId_r()) && this.list_id_srb.contains(this.list_1.get(i).getId_sr()) 
                    && this.list_tb.contains(new String(this.list_1.get(i).getTb()))){
            
                    JOptionPane.showMessageDialog(null, "CE PARAMETRE PARMIS VOS CHOIX EXISTE DEJA !!!") ;
           
            }else{
                
            sql = "insert into conf_tb(id_rubrique , id_srub , tb_name) values(?,?,?)" ;
            pst = conn.prepareStatement(sql) ;
            pst.setInt(1, this.list_1.get(i).getId_r()) ;
            pst.setInt(2, this.list_1.get(i).getId_sr()) ;
            pst.setString(3, this.list_1.get(i).getTb());
            
            pst.execute() ;
             
                
            
            }
            
            
            /*
            System.out.println(" id rub : "+this.list_1.get(i).getId_r()+" , id srb : "+this.list_1.get(i).getId_sr()+" TB N° : "+
                    this.list_1.get(i).getTb()) ;
            */
            
            
            
        } // end for our boucle list_1 :
        
        
      this.list_id_r.removeAll(this.list_id_r) ;
      this.list_id_srb.removeAll(this.list_id_srb) ;
      this.list_tb.removeAll(this.list_tb) ;
      
      
     sql = "select * from conf_tb where tb_name = ?" ;
     pst = conn.prepareStatement(sql) ;
     pst.setString(1, this.tb) ;
     
     rs = pst.executeQuery() ;
     
     while(rs.next()){
         
         this.list_id_r.add(rs.getInt("id_rubrique")) ;
         this.list_id_srb.add(rs.getInt("id_srub")) ;
         this.list_tb.add(rs.getString("tb_name")) ;
         
          }
      
        
         JOptionPane.showMessageDialog(null, "CONFIGURATION REUSSIT AVEC SUCCES !!! ");
        
        }else if(this.list_1.size() == 0){
            JOptionPane.showMessageDialog(null, "VOUS DEVEZ FAIRE DES CHOIX AVANT !!! ");
        }
        
        this.list_1.removeAll(this.list_1) ;
      
      
      
//    rs.close() ;
      stmt.close() ;
      pst.close() ;
      conn.close() ;
     
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
        
        
      
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        this.rb = false ;
        this.srb = false ;
         
        
        this.id_r = 0 ;
        this.id_r = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString()) ;
        
        rb = Boolean.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString()) ;
        
        if(this.rb == true && this.srb == true){
            
            if (JOptionPane.showConfirmDialog(null, "CONFIRMEZ VOUS VOTRE CHOIX ?", "QUESTION",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    // yes option
                
                 ListChoixCl choix = new   ListChoixCl(this.id_r, this.id_sr, this.tb) ;
                 this.list_1.add(choix) ;
                 
                  
         
} else {
    // no option
}
            
        
         
        }
        
        
    //    JOptionPane.showMessageDialog(null, this.id_r+" rb , groupe : "+this.groupe) ;
        
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                          dtm2.setRowCount(0);

                          
            Connection conn = null;
            Statement stmt = null;
            PreparedStatement pst = null ;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
     
      String sql = null ;
      ResultSet rs = null ;
      
     sql = "select * from sousrub where id_r = ? " ;
     pst = conn.prepareStatement(sql) ;
     pst.setInt(1, this.id_r);
     rs = pst.executeQuery() ;
     
     while(rs.next()){
         
         if(this.tb_conf_srb.contains(rs.getInt("id_srb"))){
             
             dtm2.addRow(new Object[]{
         //  "ID", "SOUS-RUBRIQUE", "CHOISIR"
 rs.getInt("id_srb") , rs.getString("srb") , true
         
         }) ;
             
         }else{
             
         dtm2.addRow(new Object[]{
         //  "ID", "SOUS-RUBRIQUE", "CHOISIR"
 rs.getInt("id_srb") , rs.getString("srb") , false
         
         }) ;
     
         }
         }
      
      
      
      
      rs.close() ;
      stmt.close() ;
      pst.close() ;
      conn.close() ;
     
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
        
        
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
        
        
        this.id_sr = 0 ;
        
        this.id_sr = Integer.parseInt(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString()) ;
        
        srb = Boolean.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 2).toString()) ;
        
        if(this.rb == true && this.srb == true){
            
            if (JOptionPane.showConfirmDialog(null, "CONFIRMEZ VOUS VOTRE CHOIX ?", "QUESTION",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    // yes option
                
                 ListChoixCl choix = new ListChoixCl(this.id_r, this.id_sr, this.tb) ;
                 this.list_1.add(choix) ;
                 
                 
         
} else {
    // no option
                
}
            
        
         
        }
        
        
        
      //  JOptionPane.showMessageDialog(null, this.id_sr+" srb , groupe : "+this.groupe) ;
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
            Connection conn = null;
            Statement stmt = null;
            PreparedStatement pst = null ;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
     
      String sql = null ;
      ResultSet rs = null ;
      
      
      if (JOptionPane.showConfirmDialog(null, "ETES VOUS SUR ?", "AVERTISSEMENT",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    // yes option
          
            sql = "delete from conf_tb where tb_name = ?" ;
            pst = conn.prepareStatement(sql) ;
            pst.setString(1, this.tb) ;
             
            pst.execute() ;
            
            
      this.list_id_r.removeAll(this.list_id_r) ;
      this.list_id_srb.removeAll(this.list_id_srb) ;
      this.list_tb.removeAll(this.list_tb) ;
      
      
     sql = "select * from conf_tb where tb_name = ?" ;
     pst = conn.prepareStatement(sql) ;
     pst.setString(1, this.tb) ;
     
     rs = pst.executeQuery() ;
     
     while(rs.next()){
         
         this.list_id_r.add(rs.getInt("id_rubrique")) ;
         this.list_id_srb.add(rs.getInt("id_srub")) ;
         this.list_tb.add(rs.getString("tb_name")) ;
         
          }
      
          
          
} else {
    // no option
     }
       
        
         JOptionPane.showMessageDialog(null, "REINITIALISATION REUSSIT AVEC SUCCES !!! ");
        
         
        
        this.list_1.removeAll(this.list_1) ;
      
      
      
   //   rs.close() ;
      stmt.close() ;
      pst.close() ;
      conn.close() ;
     
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
        
        
      
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
            Connection conn = null;
            Statement stmt = null;
            PreparedStatement pst = null ;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
     
      String sql = null ;
      ResultSet rs = null ;
      
       
        if(this.list_1.size() > 0){
        for(int i = 0 ; i < this.list_1.size(); i++){
            
            sql = "delete from conf_tb where id_rubrique = ? and id_srub = ? and tb_name = ?" ;
            pst = conn.prepareStatement(sql) ;
            pst.setInt(1, this.list_1.get(i).getId_r()) ;
            pst.setInt(2, this.list_1.get(i).getId_sr()) ;
            pst.setString(3, this.list_1.get(i).getTb());
            
            pst.execute() ;
             
            /*
            System.out.println(" id rub : "+this.list_1.get(i).getId_r()+" , id srb : "+this.list_1.get(i).getId_sr()+" TB N° : "+
                    this.list_1.get(i).getTb()) ;
            */
            
            
            
        } // end for our boucle list_1 :
        
      this.list_id_r.removeAll(this.list_id_r) ;
      this.list_id_srb.removeAll(this.list_id_srb) ;
      this.list_tb.removeAll(this.list_tb) ;
      
      
     sql = "select * from conf_tb where tb_name = ?" ;
     pst = conn.prepareStatement(sql) ;
     pst.setString(1, this.tb) ;
     
     rs = pst.executeQuery() ;
     
     while(rs.next()){
         
         this.list_id_r.add(rs.getInt("id_rubrique")) ;
         this.list_id_srb.add(rs.getInt("id_srub")) ;
         this.list_tb.add(rs.getString("tb_name")) ;
         
          }
      
        
         JOptionPane.showMessageDialog(null, "PARAMETRE RETIRER AVEC SUCCES !!! ");
        
        }else if(this.list_1.size() == 0){
            JOptionPane.showMessageDialog(null, "VOUS DEVEZ FAIRE DES CHOIX AVANT !!! ");
        }
        
        this.list_1.removeAll(this.list_1) ;
      
      
      
  //    rs.close() ;
      stmt.close() ;
      pst.close() ;
      conn.close() ;
     
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
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        Consult_tb ctb = new Consult_tb(this.tb) ;
                   ctb.setVisible(true) ;
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
         Choix_tb ch = new Choix_tb(this.tb) ;
                 ch.setVisible(true) ;
                 this.setVisible(false) ;
                 
        
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Choix_tb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Choix_tb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Choix_tb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Choix_tb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Choix_tb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
