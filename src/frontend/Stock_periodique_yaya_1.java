/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.Stock_periodique_yaya_sortie.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HAMZA
 */
public class Stock_periodique_yaya_1 extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy") ;
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
       long toA = 0 ;
       long toD = 0 ;
       
      List bonList = new ArrayList() ;
      
      long t_1 = 0 ;
      long t_2 = 0 ;
    
    String op ;
     
    
    public Stock_periodique_yaya_1() {
        initComponents();
        this.setLocationRelativeTo(null) ;
        
         // ---------------- 1è choix --------------
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
                  
                  //
                  
                     // right align 2nd column
                   
                  
                  //

                  for (int i = 0; i < this.jTable1.getModel().getColumnCount(); i++) {
                    this.jTable1.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
                  DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                     dtm1.addRow(new Object[]{1 , "xxxxxxxxxxxxxxxxxxxx","100.000","150.000",0,0,1}) ;
                     
                     dtm1.setRowCount(0) ;
                     
                     
                     //
                     
                        // right align 2nd column
                    TableColumnModel columnModel = this.jTable1.getColumnModel();
                    TableColumn column_0 = columnModel.getColumn(0);
                    TableColumn column_1 = columnModel.getColumn(1);
                    TableColumn column_2 = columnModel.getColumn(2);
                    TableColumn column_3 = columnModel.getColumn(3);
                    TableColumn column_4 = columnModel.getColumn(4);
                    TableColumn column_5 = columnModel.getColumn(5);
                    TableColumn column_6 = columnModel.getColumn(6);
                    TableColumn column_7 = columnModel.getColumn(7);
                    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                    
                    DefaultTableCellRenderer renderer_ = new DefaultTableCellRenderer();
                    renderer.setHorizontalAlignment(JLabel.LEFT); // RIGHT
                    renderer_.setHorizontalAlignment(JLabel.RIGHT); // RIGHT
                    column_0.setCellRenderer(renderer_);
                    column_1.setCellRenderer(renderer_);
                    column_2.setCellRenderer(renderer);
                    column_3.setCellRenderer(renderer_);
                    column_4.setCellRenderer(renderer_);
                    column_5.setCellRenderer(renderer_);
                    column_6.setCellRenderer(renderer_);
                    column_7.setCellRenderer(renderer_);
                     
                     //
                    
                    this.jTable1.getColumnModel().getColumn(0).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
                    
                   this.jTable1.getColumnModel().getColumn(1).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
                   
                   this.jTable1.getColumnModel().getColumn(2).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
                   
                   this.jTable1.getColumnModel().getColumn(3).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER)) ;
                   
                   this.jTable1.getColumnModel().getColumn(4).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER)) ;
                   
                   this.jTable1.getColumnModel().getColumn(5).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
                   
                   this.jTable1.getColumnModel().getColumn(6).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER)); 
                   
                   this.jTable1.getColumnModel().getColumn(7).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
                   
                   
                     
                     
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
      
     
       
           
       String sql = null ;
               
       ResultSet rs = null ;
                  
         
                 
                 sql = "select magasin from magasins where etat = 'oui' limit 1" ;
                 rs = stmt.executeQuery(sql) ;
                 while(rs.next()){
                      
                     this.mg.addItem(new String(rs.getString("magasin"))) ;
                 }
                 
                 sql = "select nom from famille " ;
                 rs = stmt.executeQuery(sql) ;
                 while(rs.next()){
                    String nom = new String(rs.getString("nom")) ;
                     this.f.addItem(nom) ;
                    }
                 
                 
                 
      
       
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
        
        
        
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
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
        mg = new javax.swing.JComboBox();
        f = new javax.swing.JComboBox();
        sf = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ETAT STOCK ACTUEL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 18))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FILTRE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        mg.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        mg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOSIR UN MAGASIN", "TOUT" }));
        mg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        f.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        f.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FAMILLE", "TOUTE" }));
        f.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fActionPerformed(evt);
            }
        });

        sf.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        sf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SOUS-FAMILLE", "TOUTE" }));
        sf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton1.setBackground(new java.awt.Color(51, 0, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("RECHERCHER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("IMPRIMER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mg, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sf, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mg)
                    .addComponent(f)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sf))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CODE BARRE", "DESCRIPTION", "STOCK ACTUEL", "P.A", "VALEUR STOCK ACHAT", "P.V", "VALEUR STOCK VENTE"
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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(15);
        }

        jLabel1.setText("TOTAL V.S.A :");

        t1.setEditable(false);

        jLabel2.setText("TOTAL V.S.V :");

        t2.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fActionPerformed
        // TODO add your handling code here:
        
        
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
      
      
      this.sf.removeAllItems();
      this.sf.addItem(new String("SOUS FAMILLE"));
      this.sf.addItem(new String("TOUTE"));
      
      
       String sql = null ;
              sql = "select nom from sfamille where rflle = '"+this.f.getSelectedItem().toString().replaceAll("'", "''")+"' " ; 
       ResultSet rs = null ;
                 rs = stmt.executeQuery(sql) ;
       while(rs.next()){
           
            this.sf.addItem(new String(rs.getString("nom")));
           
       }
       
          
       
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
        
            
        
        
        
    }//GEN-LAST:event_fActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         if(this.mg.getSelectedItem().toString().equalsIgnoreCase("CHOSIR UN MAGASIN") || this.f.getSelectedItem().toString().equalsIgnoreCase("FAMILLE") || this.sf.getSelectedItem().toString().equalsIgnoreCase("SOUS FAMILLE")){
            JOptionPane.showMessageDialog(null, "CHOISIR LES PARAMETRES !!!") ;
        }else{
            // try and catch clause :
            
            //  JOptionPane.showMessageDialog(null, "on try catch !!!") ;
            
            
            
            try{
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        SimpleDateFormat sdfT1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
       
        String jour = sdf.format(new Date()) ;
       
       
        
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                          dtm.setRowCount(0) ;
             
                          // acces au données :
                          
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
      
     
           String mg ;
                  mg = this.mg.getSelectedItem().toString().replaceAll("'", "''") ;
                  String f ;
                         f = this.f.getSelectedItem().toString().replaceAll("'", "''") ;
                  String sf ;
                         sf = this.sf.getSelectedItem().toString().replaceAll("'", "''") ;
                         
                         this.t_1 = 0 ;
                         this.t_2 = 0 ;
                         this.bonList.removeAll(this.bonList) ;
                         
                         
       
           
           String sql = null ;
           String sql_1 = null ;
           String sql_0 = null ;
           ResultSet rs = null ;
           
           if(mg.equals("TOUT") && f.equals("TOUTE") && sf.equals("TOUTE")){
               // JOptionPane.showMessageDialog(null, "Query tout !!! n° 1 ") ;
  //  "ID", "CODE BARRE", "DESCRIPTION", "QTE ENTREE", "P.A", "VALEUR STOCK ACHAT", "P.V", "VALEUR STOCK VENTE"
               
               sql = "select idpro,cb,desi,stock as qte,pa,pv,stock1.unite_m as rp from stock1, produits_f where "
                   + "produits_f.description = stock1.desi "
                   + "group by stock1.f,stock1.sf,stock1.desi order by stock1.f,stock1.sf,stock1.desi" ;
               
               sql_1 = "select idpro,cb,desi,stock as qte,pa,pv,unite_mesure as rp from stock1, matieres_p where "
                   + "matieres_p.description = stock1.desi "
                   + "group by stock1.f,stock1.sf,stock1.desi order by stock1.f,stock1.sf,stock1.desi" ;
               
               sql_0 = "select idpro,cb,desi,stock as qte,pa,pv,produit as pr from stock1, derive_pl where "
                   + " derive_pl.produit = stock1.desi "
                   + "group by f,sf,desi order by f,sf,desi" ;
               
               
           }else if(mg.equals("TOUT") == false && f.equals("TOUTE") && sf.equals("TOUTE")){
               
                sql = "select idpro,cb,desi,stock as qte,pa,pv,stock1.unite_m as rp from stock1, produits_f where "
                   + "maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND produits_f.description = stock1.desi "
                   + "group by stock1.f,stock1.sf,stock1.desi order by stock1.f,stock1.sf,stock1.desi" ;
               
               sql_1 = "select idpro,cb,desi,stock as qte,pa,pv,unite_mesure as rp from stock1, matieres_p where "
                      +"maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND matieres_p.description = stock1.desi "
                      +"group by stock1.f,stock1.sf,stock1.desi order by stock1.f,stock1.sf,stock1.desi" ;
               
               sql_0 = "select idpro,cb,desi,stock as qte,pa,pv,produit as pr from stock1, derive_pl where "
                       +"maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND derive_pl.produit = stock1.desi "
                       +"group by f,sf,desi order by f,sf,desi" ;
               
               
               
               
           }else if(mg.equals("TOUT") == false && f.equals("TOUTE") == false && sf.equals("TOUTE")){
               
                sql = "select idpro,cb,desi,stock as qte,pa,pv,stock1.unite_m as rp from stock1, produits_f where "
                   + "stock1.f = '"+f.replaceAll("'", "''")+"' AND "
                   + "maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND produits_f.description = stock1.desi "
                   + "group by stock1.f,stock1.sf,stock1.desi order by stock1.f,stock1.sf,stock1.desi" ;
               
               sql_1 = "select idpro,cb,desi,stock as qte,pa,pv,unite_mesure as rp from stock1, matieres_p where "
                      +"stock1.f = '"+f.replaceAll("'", "''")+"' AND "
                      +"maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND matieres_p.description = stock1.desi "
                      +"group by stock1.f,stock1.sf,stock1.desi order by stock1.f,stock1.sf,stock1.desi" ;
               
               sql_0 = "select idpro,cb,desi,stock as qte,pa,pv,produit as pr from stock1, derive_pl where "
                       +"stock1.f = '"+f.replaceAll("'", "''")+"' AND "
                       +"maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND derive_pl.produit = stock1.desi "
                       +"group by f,sf,desi order by f,sf,desi" ;
               
               
               
           }else if(mg.equals("TOUT") == false && f.equals("TOUTE") == false && sf.equals("TOUTE") == false){
               
                sql = "select idpro,cb,desi,stock as qte,pa,pv,stock1.unite_m as rp from stock1, produits_f where "
                   + "stock1.f = '"+f.replaceAll("'", "''")+"' AND stock1.sf = '"+sf.replaceAll("'", "''")+"' AND "
                   + "maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND produits_f.description = stock1.desi "
                   + "group by stock1.f,stock1.sf,stock1.desi order by stock1.f,stock1.sf,stock1.desi" ;
               
               sql_1 = "select idpro,cb,desi,stock as qte,pa,pv,unite_mesure as rp from stock1, matieres_p where "
                      +"stock1.f = '"+f.replaceAll("'", "''")+"' AND stock1.sf = '"+sf.replaceAll("'", "''")+"' AND "
                      +"maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND matieres_p.description = stock1.desi "
                      +"group by stock1.f,stock1.sf,stock1.desi order by stock1.f,stock1.sf,stock1.desi" ;
               
               sql_0 = "select idpro,cb,desi,stock as qte,pa,pv,produit as pr from stock1, derive_pl where "
                       +"stock1.f = '"+f.replaceAll("'", "''")+"' AND stock1.sf = '"+sf.replaceAll("'", "''")+"' AND "
                       +"maga = '"+this.mg.getSelectedItem().toString().replaceAll("'", "''")+"' AND derive_pl.produit = stock1.desi "
                       +"group by f,sf,desi order by f,sf,desi" ;
               
               
               
           }else if(mg.equals("TOUT") && f.equals("TOUTE") == false && sf.equals("TOUTE") == false){
               
                sql = "select idpro,cb,desi,stock as qte,pa,pv,stock1.unite_m as rp from stock1, produits_f where "
                   + "stock1.f = '"+f.replaceAll("'", "''")+"' AND stock1.sf = '"+sf.replaceAll("'", "''")+"' AND produits_f.description = stock1.desi "
                   + "group by stock1.f,stock1.sf,stock1.desi order by stock1.f,stock1.sf,stock1.desi" ;
               
               sql_1 = "select idpro,cb,desi,stock as qte,pa,pv,unite_mesure as rp from stock1, matieres_p where "
                      +"stock1.f = '"+f.replaceAll("'", "''")+"' AND stock1.sf = '"+sf.replaceAll("'", "''")+"' AND matieres_p.description = stock1.desi "
                      +"group by stock1.f,stock1.sf,stock1.desi order by stock1.f,stock1.sf,stock1.desi" ;
               
               sql_0 = "select idpro,cb,desi,stock as qte,pa,pv,produit as pr from stock1, derive_pl where "
                       +"stock1.f = '"+f.replaceAll("'", "''")+"' AND stock1.sf = '"+sf.replaceAll("'", "''")+"' AND derive_pl.produit = stock1.desi "
                       +"group by f,sf,desi order by f,sf,desi" ;
               
               
               
           }
           
           // les matieres primaire :
           
            rs = stmt.executeQuery(sql_1) ;
            while(rs.next()){
                
                // hasmap :
                HashMap<String, Object> m = new HashMap<>() ;
                
                
                if("oui".equalsIgnoreCase(rs.getString("rp"))){
                    
                   m.put("id",  rs.getString("idpro")+"   ") ;
                   m.put("cb", rs.getString("cb")+"   ") ;
                   m.put("desi", "   "+rs.getString("desi")) ;
                   m.put("qte", this.nf3.format(rs.getLong("qte"))+"   ") ;
                   m.put("pa", this.nf3.format(rs.getLong("pa"))+"   ") ;
                   m.put("vsa", this.nf3.format(Math.round((rs.getLong("pa") * (rs.getLong("qte")/1000.0))))+"   ") ;
                   m.put("pv", this.nf3.format(rs.getLong("pv"))+"   ") ;
                   m.put("vsv", this.nf3.format(Math.round((rs.getLong("pv") * (rs.getLong("qte")/1000.0))))+"  ") ;
                   
                   this.bonList.add(m) ;
                   
                    
                this.t_1 += Math.round((rs.getLong("pa") * (rs.getLong("qte")/1000.0))) ;
                this.t_2 += Math.round((rs.getLong("pv") * (rs.getLong("qte")/1000.0))) ;
                
    // "ID", "CODE BARRE", "DESCRIPTION", "QTE ENTREE", "P.A", "VALEUR STOCK ACHAT", "P.V", "VALEUR STOCK VENTE"
               
                dtm.addRow(new Object[]{
                    
 rs.getLong("idpro")+"   " , rs.getString("cb")+"   "  , "   "+rs.getString("desi") , this.nf3.format(rs.getLong("qte"))+"   ", this.nf3.format(rs.getLong("pa"))+"   "  ,
 this.nf3.format(Math.round((rs.getLong("pa") * (rs.getLong("qte")/1000.0))))+"   "  , this.nf3.format(rs.getLong("pv"))+"   "  , this.nf3.format(Math.round((rs.getLong("pv") * (rs.getLong("qte")/1000.0))))+"   " 
                
                });
                    
                    
                }else{
                    
                   m.put("id",  rs.getString("idpro")+"   ") ;
                   m.put("cb", rs.getString("cb")+"   ") ;
                   m.put("desi", "   "+rs.getString("desi")) ;
                   m.put("qte", this.nf3.format(rs.getLong("qte"))+"   ") ;
                   m.put("pa", this.nf3.format(rs.getLong("pa"))+"   ") ;
                   m.put("vsa", this.nf3.format((rs.getLong("pa") * rs.getLong("qte")))+"   ") ;
                   m.put("pv", this.nf3.format(rs.getLong("pv"))+"   ") ;
                   m.put("vsv", this.nf3.format((rs.getLong("pv") * rs.getLong("qte")))+"  ") ;
                   
                   this.bonList.add(m) ;
                
                this.t_1 += (rs.getLong("pa") * rs.getLong("qte")) ;
                this.t_2 += (rs.getLong("pv") * rs.getLong("qte")) ;
                
    // "ID", "CODE BARRE", "DESCRIPTION", "QTE ENTREE", "P.A", "VALEUR STOCK ACHAT", "P.V", "VALEUR STOCK VENTE"
               
                dtm.addRow(new Object[]{
                    
     rs.getLong("idpro")+"   "  , rs.getString("cb")+"   "  , "   "+rs.getString("desi") , this.nf3.format(rs.getLong("qte"))+"   " , this.nf3.format(rs.getLong("pa"))+"   "  ,
                    this.nf3.format((rs.getLong("pa") * rs.getLong("qte")))+"   "  , this.nf3.format(rs.getLong("pv"))+"   "  , this.nf3.format((rs.getLong("pv") * rs.getLong("qte")))+"   " 
                
                });
                
                }
                
            }
            
            // end matieres primaire :
            
            
            //les produits finis :
            
              rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                
                // hasmap :
                HashMap<String, Object> m = new HashMap<>() ;
                
                
                if("oui".equalsIgnoreCase(rs.getString("rp"))){
                    
                   m.put("id",  rs.getString("idpro")+"   ") ;
                   m.put("cb", rs.getString("cb")+"   ") ;
                   m.put("desi", "   "+rs.getString("desi")) ;
                   m.put("qte", this.nf3.format(rs.getLong("qte"))+"   ") ;
                   m.put("pa", this.nf3.format(rs.getLong("pa"))+"   ") ;
                   m.put("vsa", this.nf3.format(Math.round((rs.getLong("pa") * (rs.getLong("qte")/1000.0))))+"   ") ;
                   m.put("pv", this.nf3.format(rs.getLong("pv"))+"   ") ;
                   m.put("vsv", this.nf3.format(Math.round((rs.getLong("pv") * (rs.getLong("qte")/1000.0))))+"  ") ;
                   
                   this.bonList.add(m) ;
                    
                this.t_1 += Math.round((rs.getLong("pa") * (rs.getLong("qte")/1000.0))) ;
                this.t_2 += Math.round((rs.getLong("pv") * (rs.getLong("qte")/1000.0))) ;
                
    // "ID", "CODE BARRE", "DESCRIPTION", "QTE ENTREE", "P.A", "VALEUR STOCK ACHAT", "P.V", "VALEUR STOCK VENTE"
               
                dtm.addRow(new Object[]{
                    
 rs.getLong("idpro")+"   "  , rs.getString("cb")+"   "  , "   "+rs.getString("desi") , this.nf3.format(rs.getLong("qte"))+"   " , this.nf3.format(rs.getLong("pa"))+"   "  ,
 this.nf3.format(Math.round((rs.getLong("pa") * (rs.getLong("qte")/1000.0))))+"   "  , this.nf3.format(rs.getLong("pv"))+"   "  , this.nf3.format(Math.round((rs.getLong("pv") * (rs.getLong("qte")/1000.0))))+"   " 
                
                });
                    
                    
                }else{
                    
                   m.put("id",  rs.getString("idpro")+"   ") ;
                   m.put("cb", rs.getString("cb")+"   ") ;
                   m.put("desi", "   "+rs.getString("desi")) ;
                   m.put("qte", this.nf3.format(rs.getLong("qte"))+"   ") ;
                   m.put("pa", this.nf3.format(rs.getLong("pa"))+"   ") ;
                   m.put("vsa", this.nf3.format((rs.getLong("pa") * rs.getLong("qte")))+"   ") ;
                   m.put("pv", this.nf3.format(rs.getLong("pv"))+"   ") ;
                   m.put("vsv", this.nf3.format((rs.getLong("pv") * rs.getLong("qte")))+"  ") ;
                   
                   this.bonList.add(m) ;
                
                this.t_1 += (rs.getLong("pa") * rs.getLong("qte")) ;
                this.t_2 += (rs.getLong("pv") * rs.getLong("qte")) ;
                
    // "ID", "CODE BARRE", "DESCRIPTION", "QTE ENTREE", "P.A", "VALEUR STOCK ACHAT", "P.V", "VALEUR STOCK VENTE"
               
                dtm.addRow(new Object[]{
                    
     rs.getLong("idpro")+"   "  , rs.getString("cb")+"   "  , "   "+rs.getString("desi") , this.nf3.format(rs.getLong("qte"))+"   " , this.nf3.format(rs.getLong("pa"))+"   "  ,
          this.nf3.format((rs.getLong("pa") * rs.getLong("qte")))+"   "  , this.nf3.format(rs.getLong("pv"))+"   "  , this.nf3.format((rs.getLong("pv") * rs.getLong("qte")))+"   " 
                
                });
                
                }
                
            }
            
            
            
            // end les produits fini :
            
            
            // debut derive produit :
            
                rs = stmt.executeQuery(sql_0) ;
                while(rs.next()){
                
              // hasmap :
                HashMap<String, Object> m = new HashMap<>() ;
                
                   m.put("id",  rs.getString("idpro")+"   ") ;
                   m.put("cb", rs.getString("cb")+"   ") ;
                   m.put("desi", "   "+rs.getString("desi")) ;
                   m.put("qte", this.nf3.format(rs.getLong("qte"))+"   ") ;
                   m.put("pa", this.nf3.format(rs.getLong("pa"))+"   ") ;
                   m.put("vsa", this.nf3.format((rs.getLong("pa") * rs.getLong("qte")))+"   ") ;
                   m.put("pv", this.nf3.format(rs.getLong("pv"))+"   ") ;
                   m.put("vsv", this.nf3.format((rs.getLong("pv") * rs.getLong("qte")))+"  ") ;
                   
                   this.bonList.add(m) ;
                
                
                this.t_1 += (rs.getLong("pa") * rs.getLong("qte")) ;
                this.t_2 += (rs.getLong("pv") * rs.getLong("qte")) ;
                
    // "ID", "CODE BARRE", "DESCRIPTION", "QTE ENTREE", "P.A", "VALEUR STOCK ACHAT", "P.V", "VALEUR STOCK VENTE"
               
                dtm.addRow(new Object[]{
                    
     rs.getLong("idpro")+"   "  , rs.getString("cb")+"   "  , "   "+rs.getString("desi") , this.nf3.format(rs.getLong("qte"))+"   " , this.nf3.format(rs.getLong("pa"))+"   "  ,
                    this.nf3.format((rs.getLong("pa") * rs.getLong("qte")))+"   "  , this.nf3.format(rs.getLong("pv"))+"   "  , this.nf3.format((rs.getLong("pv") * rs.getLong("qte")))+"   " 
                
                });
                
               
                
            }
            
            
            
            // end derive produit :
            
            
            
           
           this.t1.setText(this.nf3.format(this.t_1)); 
           this.t2.setText(this.nf3.format(this.t_2));
           
           
           
           
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
     
       
                          // end acces au data-center :
                          
                          
                          
            }catch(Exception e){
                
                
                JOptionPane.showMessageDialog(null, "CHOISIR LA PERIODE !!") ;
                
            }
            
            
        }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
        
         this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
         
        try{
                
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\stock_etat.jrxml")) ;
              
            
            JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(this.bonList) ;
            
            
            Map<String, Object> para = new HashMap<>() ;
            
            // para.put("data", jrbean);
            
            para.put("titre","ETAT STOCK ACTUEL") ;
            para.put("op","OP : "+this.op) ; 
            para.put("magasin","MAGASIN : "+this.mg.getSelectedItem().toString()) ;
            para.put("periode","PERIODE : "+sdf.format(new Date())) ;
            para.put("f","FAMILLE : "+this.f.getSelectedItem().toString()) ;
            para.put("sf","SOUS FAMILLE : "+this.sf.getSelectedItem().toString()) ;
            para.put("ta","TOTAL V.S.A : "+this.t1.getText()) ;
            para.put("tv","TOTAL V.S.V : "+this.t2.getText()) ;
           
            para.put("data", data) ;
      
            
         // para.put("Total", "TOTAL MONTANT : "+this.nf3.format(this.mtt)) ;
           
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource()) ;
            
            JasperViewer.viewReport(print, false);
            
                
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage()) ;
            }
            
        this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Stock_periodique_yaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock_periodique_yaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock_periodique_yaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock_periodique_yaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock_periodique_yaya().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox f;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox mg;
    private javax.swing.JComboBox sf;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    // End of variables declaration//GEN-END:variables
}
