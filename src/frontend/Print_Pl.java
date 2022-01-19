/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.Op_Pl.JDBC_DRIVER;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
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
public class Print_Pl extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
    
    String login = "" ;
    
     List bonList = new ArrayList() ;
     List bonList_d = new ArrayList() ;
     
     String dte1 ;
     String dte2 ;
     String zone = "0" ;
     Integer vy = 0 ;
     ArrayList<Integer> list_v = new ArrayList<Integer>() ;
     
     String stock1 = new String("") ;
    
    
    public Print_Pl() {
        initComponents();
    }
    
    public Print_Pl(String login){
        initComponents() ;
        
        this.login = login ;
        
        
        this.f.setSelectedItem(new String("TOUTE")) ;
        this.sf.setSelectedItem(new String("TOUTE")) ;
        
         Date jour = new Date() ;
        this.jDateChooser1.setDate(jour);
        this.h1.setText("00:00") ;
        this.jDateChooser2.setDate(jour) ;
        this.h2.setText("23:59") ;
        
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

                  for (int i = 0; i < this.jTable1.getModel().getColumnCount(); i++) {
                    this.jTable1.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                          dtm.setRowCount(0) ;
                          
                          
                           // ---------------- 1è choix --------------
            this.jTable2.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable2.getTableHeader().setOpaque(false); 
            this.jTable2.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable2.getTableHeader().setForeground(Color.white) ;
        
              this.jTable2.setRowHeight(25) ;
              
         

                  for (int i = 0; i < this.jTable2.getModel().getColumnCount(); i++) {
                    this.jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                          dtm2.setRowCount(0) ;
                          
                          
                            Connection conn = null ;
                            Statement  stmt = null ;
       
       try{
      // STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
       String sql = null ;
              sql = "select placement from point_pl where type = 'oui' AND NOT placement = 'zone de decoupage' AND NOT placement = 'EXTERIEUR' order by placement ASC" ;
       ResultSet rs = null ;
                 rs = stmt.executeQuery(sql) ;
       while(rs.next()){
           
           this.pl.addItem(rs.getString("placement")) ;
           
       }
       
       sql = "select nom from famille " ;
       rs = stmt.executeQuery(sql) ;
       while(rs.next()){
           String nom = new String(rs.getString("nom")) ;
                 
                  
           this.f.addItem(nom) ;
       }
                 
       
       sql = "select magasin from magasins where etat = 'oui' limit 1" ;
       rs = stmt.executeQuery(sql) ;
       while(rs.next()){
           this.stock1 = rs.getString("magasin") ;
           this.pl.addItem(new String(rs.getString("magasin"))) ;
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
        
            
            
       
       this.pl.setSelectedItem(new String("CHAMBRE FROIDE")) ;
        
        
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
        pl = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        h1 = new javax.swing.JTextField();
        h2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        f = new javax.swing.JComboBox();
        sf = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ETAT CUMULATIF DES PLACEMENTS PAR PERIODE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPTION DE FILTRE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 14))); // NOI18N

        pl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "POINT DE PLACEMENT" }));
        pl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jDateChooser2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setText("DU");

        jLabel2.setText("AU");

        jButton1.setBackground(new java.awt.Color(102, 0, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("RECHERCHER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 204, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("IMPRIMER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("HEURE");

        jLabel4.setText("HEURE");

        f.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        f.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FAMILLE", "TOUTE" }));
        f.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fActionPerformed(evt);
            }
        });

        sf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SOUS FAMILLE", "TOUTE" }));
        sf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pl, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sf, 0, 205, Short.MAX_VALUE)
                    .addComponent(f, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPTION", "PRIX VENTE / P.M", "QTE ARRIVER"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(3);
        }

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPTION", "PRIX VENTE / P.M", "QTE DEPART"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable2.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(3);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(3);
        }

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 0));
        jLabel5.setText("ARRIVER");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 0));
        jLabel6.setText("DEPART");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addGap(0, 24, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
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
 long mtt = 0 ;
 NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here :
        
        if(this.stock1.equalsIgnoreCase(this.pl.getSelectedItem().toString())){
            
            
            // debut traitement :
            
        this.bonList.removeAll(this.bonList) ;
        this.bonList_d.removeAll(this.bonList_d) ;
        
        this.list_v.removeAll(this.list_v) ;
        
        NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
        try{
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
        SimpleDateFormat sdfT1 = new SimpleDateFormat("dd-MM-yyyy") ;
       
        this.dte1 = sdfT1.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        this.dte2 = sdfT1.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
        String point ;
               point = this.pl.getSelectedItem().toString().replaceAll("'", "''") ;
               this.zone = point ;
               
               if("POINT DE PLACEMENT".equalsIgnoreCase(point)){
                   
                   JOptionPane.showMessageDialog(this, "CHOISIR UN POINT DE PLACEMENT SVP ! ") ;
                   this.zone = "0" ;
                   
               }else{
                   
                   
                   DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                          dtm.setRowCount(0) ;
                          
                          DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                          dtm2.setRowCount(0) ;
                          
                            
                       //     SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
                          
                            Connection conn = null ;
                            Statement  stmt = null ;
       
       try{
      // STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...") ;
      
       stmt = conn.createStatement() ;
      
       String sql = null ;
       String sql2 = null ;
       ResultSet rs = null ;
       
    //   -------------------------------------- matiere primaire ------------------------------------------------------- 
       
// "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "PRIX VENTE", "QTE DEPART", "QTE ARRIVER", "ETAT", "CONCLUSION"
        
         long ndep  = 0 ;
         long nariv = 0 ;
        
         this.mtt = 0 ;
       
                // sql matieres_p :
         
         
         if(this.f.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sf.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){ // N°1 :
       
              
             
             sql = "select id as ref , desi as produit , pa as prix , "
                      +"f as f , sf as sf , "
                      +"sum(qteet) as arriv "
                      + " from stock2 where maga = '"+this.stock1.replaceAll("'", "''")+"' "
                     + "AND datec BETWEEN '"+dte1+"' AND '"+dte2+"' AND type = 'achat' AND et_ = 'oui' " 
        + " group by f, sf, produit order by f asc, sf asc, produit asc" ;
             
             
            sql2 = "select id as ref , desi as produit , pv as prix , "
                      +"f as f , sf as sf , "
                      +"sum(qtest) as dep "
                      + " from stock2 where maga = '"+this.stock1.replaceAll("'", "''")+"' "
                     + "AND datec BETWEEN '"+dte1+"' AND '"+dte2+"' AND type = 'sortie' AND et_ = 'oui' " 
        + " group by f, sf, produit order by f asc, sf asc, produit asc" ;
 
 
         }else if(this.f.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false && this.sf.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){

               sql = "select id as ref , desi as produit , pa as prix , "
                      + "f as f , sf as sf , "
                      + "sum(qteet) as arriv "
                      + " from stock2 where f = '"+this.f.getSelectedItem().toString().replaceAll("'", "''")+"' AND "
                      + "maga = '"+this.stock1.replaceAll("'", "''")+"' "
                      + "AND datec BETWEEN '"+dte1+"' AND '"+dte2+"' AND type = 'achat' AND et_ = 'oui' " 
                      + " group by f, sf, produit order by f asc, sf asc, produit asc" ;
             
             
            sql2 = "select id as ref , desi as produit , pv as prix , "
                      + "f as f , sf as sf , "
                      + "sum(qtest) as dep "
                      + " from stock2 where f = '"+this.f.getSelectedItem().toString().replaceAll("'", "''")+"' AND "
                      + "maga = '"+this.stock1.replaceAll("'", "''")+"' "
                      + "AND datec BETWEEN '"+dte1+"' AND '"+dte2+"' AND type = 'sortie' AND et_ = 'oui' " 
                      + " group by f, sf, produit order by f asc, sf asc, produit asc" ;
 
            
         }else if(this.f.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false && this.sf.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false){
             
             
             
               sql = "select id as ref , desi as produit , pa as prix , "
                      + "f as f , sf as sf , "
                      + "sum(qteet) as arriv "
                      + " from stock2 where f = '"+this.f.getSelectedItem().toString().replaceAll("'", "''")+"' AND "
                      + "sf = '"+this.sf.getSelectedItem().toString().replaceAll("'", "''")+"' AND "
                      + "maga = '"+this.stock1.replaceAll("'", "''")+"' "
                      + "AND datec BETWEEN '"+dte1+"' AND '"+dte2+"' AND type = 'achat' AND et_ = 'oui' " 
                      + " group by f, sf, produit order by f asc, sf asc, produit asc" ;
             
             
            sql2 = "select id as ref , desi as produit , pv as prix , "
                      + "f as f , sf as sf , "
                      + "sum(qtest) as dep "
                      + " from stock2 where f = '"+this.f.getSelectedItem().toString().replaceAll("'", "''")+"' AND "
                      + "sf = '"+this.sf.getSelectedItem().toString().replaceAll("'", "''")+"' AND "
                      + "maga = '"+this.stock1.replaceAll("'", "''")+"' "
                      + "AND datec BETWEEN '"+dte1+"' AND '"+dte2+"' AND type = 'sortie' AND et_ = 'oui' " 
                      + " group by f, sf, produit order by f asc, sf asc, produit asc" ;
 
             
             
         }else if(this.f.getSelectedItem().toString().equalsIgnoreCase("FAMILLE") || this.sf.getSelectedItem().toString().equalsIgnoreCase("SOUS FAMILLE")){
             JOptionPane.showMessageDialog(this, "REMPLISSEZ LES FILTRES CORRECTEMENT SVP !!") ;
         }
         
         
         
             rs = stmt.executeQuery(sql) ;
             
       while(rs.next()){
           // "ID", "DESCRIPTION", "PRIX VENTE / P.M", "QTE ARRIVER"
             
            HashMap<String, Object> m = new HashMap<>() ;
            
            // debut :
            
                       
                   m.put("id",  rs.getString("ref")) ;
                   m.put("description", rs.getString("produit")) ;
                   m.put("pu", nf3.format(rs.getLong("prix"))) ;
                   m.put("qtea", nf3.format(rs.getLong("arriv"))) ;
                   
                       
                        // mtt += (rs.getLong("arriv") * rs.getLong("prix")) ;
                        
                  
                   
                    this.bonList.add(m) ;
           
                  dtm.addRow(new Object[]{
               rs.getLong("ref"),rs.getString("produit"),nf3.format(rs.getLong("prix")),nf3.format(rs.getLong("arriv"))
                          
           }) ;
                       
                  
            
            
           // end :
            
           
                   
                }
       
       
       rs = stmt.executeQuery(sql2) ;
            while(rs.next()){
           // "ID", "DESCRIPTION", "PRIX VENTE / P.M", "QTE ARRIVER"
             
            HashMap<String, Object> m = new HashMap<>() ;
            
            // debut :
                 
                   m.put("id",  rs.getString("ref")) ;
                   m.put("description", rs.getString("produit")) ;
                   m.put("pu", nf3.format(rs.getLong("prix"))) ;
                   m.put("qted", nf3.format(rs.getLong("dep"))) ;
                   
                       
                        // mtt += (rs.getLong("dep") * rs.getLong("prix")) ;
                        
                    
                   
                    this.bonList_d.add(m) ;
           
                  dtm2.addRow(new Object[]{
               rs.getLong("ref"),rs.getString("produit"),nf3.format(rs.getLong("prix")),nf3.format(rs.getLong("dep"))
                          
           }) ;
                       
                  
            
            
           // end :
            
           
                   
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
        
                   
                   
                   
               }
        
        
        
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(this, "CHOISIR LES 2 PERIODES OBLIGATOIRES AVEC L'HEURE SVP ! ") ;
            
        }
            
         //  end traitement :
            
            
            
      //    JOptionPane.showMessageDialog(null, "STOCK1 PROCESS CALLING ...") ;
            
            
            
            
        }else{
        
        this.bonList.removeAll(this.bonList) ;
        this.bonList_d.removeAll(this.bonList_d) ;
        
        this.list_v.removeAll(this.list_v) ;
        
        NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
        try{
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
        SimpleDateFormat sdfT1 = new SimpleDateFormat("dd-MM-yyyy") ;
       
        this.dte1 = sdfT1.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        this.dte2 = sdfT1.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
        String point ;
               point = this.pl.getSelectedItem().toString().replaceAll("'", "''") ;
               this.zone = point ;
               
               if("POINT DE PLACEMENT".equalsIgnoreCase(point)){
                   
                   JOptionPane.showMessageDialog(this, "CHOISIR UN POINT DE PLACEMENT SVP ! ") ;
                   this.zone = "0" ;
                   
               }else{
                   
                   
                   DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                          dtm.setRowCount(0) ;
                          
                          DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                          dtm2.setRowCount(0) ;
                          
                            
                       //     SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
                          
                            Connection conn = null ;
                            Statement  stmt = null ;
       
       try{
      // STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...") ;
      
       stmt = conn.createStatement() ;
      
       String sql = null ;
       String sql2 = null ;
       ResultSet rs = null ;
       
    //   -------------------------------------- matiere primaire ------------------------------------------------------- 
       
// "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "PRIX VENTE", "QTE DEPART", "QTE ARRIVER", "ETAT", "CONCLUSION"
        
         long ndep  = 0 ;
         long nariv = 0 ;
        
         this.mtt = 0 ;
       
                // sql matieres_p :
         
         
         if(this.f.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sf.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
       
             
                      /*
             
 sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , depart , arriver , "
                      +"condition_livraison as f , conservation as sf , matieres_p.id as ref , matieres_p.unite_mesure as rapport , "
                      +"sum(nariv) as arriv , sum(ndep) as dep "
                      + " from stock_detail_pl , matieres_p where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND ( arriver = '"+point+"' OR depart = '"+point+"' ) AND matieres_p.description = stock_detail_pl.description "
        + " group by arriver , depart , produit order by produit asc" ;
 
                         */
             
             
             sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , arriver , "
                      +"condition_livraison as f , conservation as sf , matieres_p.id as ref , matieres_p.unite_mesure as rapport , "
                      +"sum(nariv) as arriv "
                      + " from stock_detail_pl , matieres_p where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND arriver = '"+point+"' AND stock_detail_pl.type = 'oui' AND matieres_p.description = stock_detail_pl.description "
        + " group by arriver , produit order by produit asc" ;
             
             
            sql2 = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , depart , "
                      +"condition_livraison as f , conservation as sf , matieres_p.id as ref , matieres_p.unite_mesure as rapport , "
                      +"sum(ndep) as dep "
                      + " from stock_detail_pl , matieres_p where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND depart = '"+point+"' AND stock_detail_pl.type = 'oui' AND matieres_p.description = stock_detail_pl.description "
        + " group by depart , produit order by produit asc" ; 
 
 
         }else if(this.f.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false && this.sf.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){

             sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , arriver , "
                      +"condition_livraison as f , conservation as sf , matieres_p.id as ref , matieres_p.unite_mesure as rapport , "
                      +"sum(nariv) as arriv "
                      + " from stock_detail_pl , matieres_p where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND arriver = '"+point+"' AND stock_detail_pl.type = 'oui' AND matieres_p.description = stock_detail_pl.description "
                      + " AND matieres_p.condition_livraison = '"+this.f.getSelectedItem().toString().replaceAll("'", "''")+"' "
        + " group by arriver , produit order by produit asc" ;
             
             
            sql2 = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , depart , "
                      +"condition_livraison as f , conservation as sf , matieres_p.id as ref , matieres_p.unite_mesure as rapport , "
                      +"sum(ndep) as dep "
                      + " from stock_detail_pl , matieres_p where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND depart = '"+point+"' AND stock_detail_pl.type = 'oui' AND matieres_p.description = stock_detail_pl.description "
                      + " AND matieres_p.condition_livraison = '"+this.f.getSelectedItem().toString().replaceAll("'", "''")+"' "
        + " group by depart , produit order by produit asc" ; 
             
             
         }else if(this.f.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false && this.sf.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false){
             
             
             
               sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , arriver , "
                      +"condition_livraison as f , conservation as sf , matieres_p.id as ref , matieres_p.unite_mesure as rapport , "
                      +"sum(nariv) as arriv "
                      + " from stock_detail_pl , matieres_p where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND arriver = '"+point+"' AND stock_detail_pl.type = 'oui' AND matieres_p.description = stock_detail_pl.description "
                      + " AND matieres_p.condition_livraison = '"+this.f.getSelectedItem().toString().replaceAll("'", "''")+"' "
                      + " AND matieres_p.conservation = '"+this.sf.getSelectedItem().toString().replaceAll("'", "''")+"' "
        + " group by arriver , produit order by produit asc" ;
             
             
            sql2 = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , depart , "
                      +"condition_livraison as f , conservation as sf , matieres_p.id as ref , matieres_p.unite_mesure as rapport , "
                      +"sum(ndep) as dep "
                      + " from stock_detail_pl , matieres_p where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND depart = '"+point+"' AND stock_detail_pl.type = 'oui' AND matieres_p.description = stock_detail_pl.description "
                      + " AND matieres_p.condition_livraison = '"+this.f.getSelectedItem().toString().replaceAll("'", "''")+"' "
                      + " AND matieres_p.conservation = '"+this.sf.getSelectedItem().toString().replaceAll("'", "''")+"' "
        + " group by depart , produit order by produit asc" ; 
             
             
             
         }else if(this.f.getSelectedItem().toString().equalsIgnoreCase("FAMILLE") || this.sf.getSelectedItem().toString().equalsIgnoreCase("SOUS FAMILLE")){
           //  JOptionPane.showMessageDialog(this, "REMPLISSEZ LES FILTRES CORRECTEMENT SVP !!") ;
         }
         
         
         
             rs = stmt.executeQuery(sql) ;
             
       while(rs.next()){
           // "ID", "DESCRIPTION", "PRIX VENTE / P.M", "QTE ARRIVER"
             
            HashMap<String, Object> m = new HashMap<>() ;
            
            // debut :
            
                  
                   
                   
                   if("OUI".equalsIgnoreCase(rs.getString("rapport"))){
                       
                   m.put("id",  rs.getString("ref")) ;
                   m.put("description", rs.getString("produit")) ;
                   m.put("pu", nf3.format(rs.getLong("prix"))) ;
                   m.put("qtea", nf3.format(rs.getLong("arriv"))) ;
                   
                       
                          mtt += (((rs.getLong("arriv")) / 1000) * rs.getLong("prix")) ;
                        
                    //    m.put("mtt", nf3.format(((rs.getLong("arriv") / 1000) * rs.getLong("prix")))) ;
                   
                    this.bonList.add(m) ;
           
                  dtm.addRow(new Object[]{
               rs.getLong("ref"),rs.getString("produit"),nf3.format(rs.getLong("prix")),nf3.format(rs.getLong("arriv"))
                          
           }) ;
                       
                   }else{
                       
                   m.put("id",  rs.getString("ref")) ;
                   m.put("description", rs.getString("produit")) ;
                   m.put("pu", nf3.format(rs.getLong("prix"))) ;
                   m.put("qtea", nf3.format(rs.getLong("arriv"))) ;
                   
                     
                           mtt += ((rs.getLong("arriv")) * rs.getLong("prix")) ;
                   
                        // m.put("mtt", nf3.format(((rs.getLong("arriv")) * rs.getLong("prix")))) ;
                       
                    this.bonList.add(m) ;
           
                   dtm.addRow(new Object[]{
               rs.getLong("ref"),rs.getString("produit"),nf3.format(rs.getLong("prix")),nf3.format(rs.getLong("arriv"))
                     
           }) ;
                        
                        
                }
            
            
           // end :
            
           
                   
                }
       
       
       rs = stmt.executeQuery(sql2) ;
            while(rs.next()){
           // "ID", "DESCRIPTION", "PRIX VENTE / P.M", "QTE ARRIVER"
             
            HashMap<String, Object> m = new HashMap<>() ;
            
            // debut :
            
                  
                   
                   if("OUI".equalsIgnoreCase(rs.getString("rapport"))){
                       
                   m.put("id",  rs.getString("ref")) ;
                   m.put("description", rs.getString("produit")) ;
                   m.put("pu", nf3.format(rs.getLong("prix"))) ;
                   m.put("qted", nf3.format(rs.getLong("dep"))) ;
                   
                       
                        mtt += (((rs.getLong("dep")) / 1000) * rs.getLong("prix")) ;
                        
                      //  m.put("mtt", nf3.format(((rs.getLong("dep") / 1000) * rs.getLong("prix")))) ;
                   
                    this.bonList_d.add(m) ;
           
                  dtm2.addRow(new Object[]{
               rs.getLong("ref"),rs.getString("produit"),nf3.format(rs.getLong("prix")),nf3.format(rs.getLong("dep"))
                          
           }) ;
                       
                   }else{
                       
                   m.put("id",  rs.getString("ref")) ;
                   m.put("description", rs.getString("produit")) ;
                   m.put("pu", nf3.format(rs.getLong("prix"))) ;
                   m.put("qted", nf3.format(rs.getLong("dep"))) ;
                   
                     
                       mtt += ((rs.getLong("dep")) * rs.getLong("prix")) ;
                   
                       // m.put("mtt", nf3.format(((rs.getLong("dep")) * rs.getLong("prix")))) ;
                       
                    this.bonList_d.add(m) ;
           
                   dtm2.addRow(new Object[]{
               rs.getLong("ref"),rs.getString("produit"),nf3.format(rs.getLong("prix")),nf3.format(rs.getLong("dep"))
                     
           }) ;
                        
                        
                }
            
            
           // end :
            
           
                   
                }
                 
                 // sql produits fini :
       
       
       // ----------------------------------------------- produit fini : ----------------------------------------------------------
       
       
       
       
                  long ndep1  = 0 ;
                  long nariv1 = 0 ;
                 
        
              //  long mtt = 0 ;
       
                // sql matieres_p :
                  
 if(this.f.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sf.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
       
     
               /*
     sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , depart , arriver , "
                      +"produits_f.f as f , produits_f.sf as sf , produits_f.id as ref , produits_f.unite_m as rapport , "
                      +"sum(nariv) as arriv , sum(ndep) as dep "
                      + " from stock_detail_pl , produits_f where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND ( arriver = '"+point+"' OR depart = '"+point+"' ) AND produits_f.description = stock_detail_pl.description "
        + " group by arriver , depart , produit order by produit asc" ;
                 */
       
     sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , arriver , "
                      +"produits_f.f as f , produits_f.sf as sf , produits_f.id as ref , produits_f.unite_m as rapport , "
                      +"sum(nariv) as arriv "
                      + " from stock_detail_pl , produits_f where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND  arriver = '"+point+"' AND stock_detail_pl.type = 'oui' AND produits_f.description = stock_detail_pl.description "
        + " group by arriver , produit order by produit asc" ;
     
      sql2 = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , depart , "
                      +"produits_f.f as f , produits_f.sf as sf , produits_f.id as ref , produits_f.unite_m as rapport , "
                      +"sum(ndep) as dep "
                      + " from stock_detail_pl , produits_f where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND  depart = '"+point+"' AND stock_detail_pl.type = 'oui' AND produits_f.description = stock_detail_pl.description "
        + " group by depart , produit order by produit asc" ;
     
     
   }else if(this.f.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false && this.sf.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){

            
            
             sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , arriver , "
                      +"produits_f.f as f , produits_f.sf as sf , produits_f.id as ref , produits_f.unite_m as rapport , "
                      +"sum(nariv) as arriv "
                      + " from stock_detail_pl , produits_f where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND  arriver = '"+point+"' AND stock_detail_pl.type = 'oui' AND produits_f.description = stock_detail_pl.description "
                      + " AND produits_f.f = '"+this.f.getSelectedItem().toString().replaceAll("'", "''")+"' "
        + " group by arriver , produit order by produit asc" ;
     
      sql2 = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , depart , "
                      +"produits_f.f as f , produits_f.sf as sf , produits_f.id as ref , produits_f.unite_m as rapport , "
                      +"sum(ndep) as dep "
                      + " from stock_detail_pl , produits_f where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND  depart = '"+point+"' AND stock_detail_pl.type = 'oui' AND produits_f.description = stock_detail_pl.description "
                      + " AND produits_f.f = '"+this.f.getSelectedItem().toString().replaceAll("'", "''")+"' "
        + " group by depart , produit order by produit asc" ;
             
             
         }else if(this.f.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false && this.sf.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false){
             
            
            sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , arriver , "
                      +"produits_f.f as f , produits_f.sf as sf , produits_f.id as ref , produits_f.unite_m as rapport , "
                      +"sum(nariv) as arriv "
                      + " from stock_detail_pl , produits_f where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND  arriver = '"+point+"' AND stock_detail_pl.type = 'oui' AND produits_f.description = stock_detail_pl.description "
                      + " AND produits_f.f = '"+this.f.getSelectedItem().toString().replaceAll("'", "''")+"' "
                      + " AND produits_f.sf = '"+this.sf.getSelectedItem().toString().replaceAll("'", "''")+"' "
        + " group by arriver , produit order by produit asc" ;
     
      sql2 = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , depart , "
                      +"produits_f.f as f , produits_f.sf as sf , produits_f.id as ref , produits_f.unite_m as rapport , "
                      +"sum(ndep) as dep "
                      + " from stock_detail_pl , produits_f where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND  depart = '"+point+"' AND stock_detail_pl.type = 'oui' AND produits_f.description = stock_detail_pl.description "
                      + " AND produits_f.f = '"+this.f.getSelectedItem().toString().replaceAll("'", "''")+"' "
                      + " AND produits_f.sf = '"+this.sf.getSelectedItem().toString().replaceAll("'", "''")+"' "
        + " group by depart , produit order by produit asc" ;
             
             
             
         }else if(this.f.getSelectedItem().toString().equalsIgnoreCase("FAMILLE") || this.sf.getSelectedItem().toString().equalsIgnoreCase("SOUS FAMILLE")){
           //  JOptionPane.showMessageDialog(this, "REMPLISSEZ LES FILTRES CORRECTEMENT SVP !!") ;
         }
         
  
       
                 rs = stmt.executeQuery(sql) ;
               while(rs.next()){
                   
                 
            HashMap<String, Object> m = new HashMap<>() ;
              
                   
                   
                        
                   
                    // debut :
                   
                        if("OUI".equalsIgnoreCase(rs.getString("rapport"))){
                            
                   m.put("id",  rs.getString("ref")) ;
                   m.put("description", rs.getString("produit")) ;
                   m.put("pu", nf3.format(rs.getLong("prix"))) ;
                   m.put("qtea", nf3.format(rs.getLong("arriv"))) ;
                   
                       
                        mtt += (((rs.getLong("arriv")) / 1000) * rs.getLong("prix")) ;
                        
                   //     m.put("mtt", nf3.format((((rs.getLong("arriv")) / 1000) * rs.getLong("prix")))) ;
                       
                   
                    this.bonList.add(m) ;
           
                  dtm.addRow(new Object[]{
           rs.getLong("ref"),rs.getString("produit"),nf3.format(rs.getLong("prix")),nf3.format(rs.getLong("arriv"))
                          
           }) ;
          
                       
           
                   }else{
                            
                   m.put("id",  rs.getString("ref")) ;
                   m.put("description", rs.getString("produit")) ;
                   m.put("pu", nf3.format(rs.getLong("prix"))) ;
                   m.put("qtea", nf3.format(rs.getLong("arriv"))) ;
                   
                     
                       mtt += ((rs.getLong("arriv")) * rs.getLong("prix")) ;
                       
                     //  m.put("mtt", nf3.format(((rs.getLong("arriv")) * rs.getLong("prix")))) ;
                   
                    this.bonList.add(m) ;
           
                  dtm.addRow(new Object[]{
           rs.getLong("ref"),rs.getString("produit"),nf3.format(rs.getLong("prix")),nf3.format(rs.getLong("arriv"))
                          
           }) ;
                        
                        
                }
                   
                   // end :
            
            
                }
               
               rs = stmt.executeQuery(sql2) ;
                 while(rs.next()){
                   
                 
            HashMap<String, Object> m = new HashMap<>() ;
              
                  
                        
                   
                    // debut :
                   
                        if("OUI".equalsIgnoreCase(rs.getString("rapport"))){
                            
                   m.put("id",  rs.getString("ref")) ;
                   m.put("description", rs.getString("produit")) ;
                   m.put("pu", nf3.format(rs.getLong("prix"))) ;
                   m.put("qted", nf3.format(rs.getLong("dep"))) ;
                   
                       
                        mtt += (((rs.getLong("dep")) / 1000) * rs.getLong("prix")) ;
                        
                      //   m.put("mtt", nf3.format((((rs.getLong("dep")) / 1000) * rs.getLong("prix")))) ;
                       
                   
                    this.bonList_d.add(m) ;
           
                  dtm2.addRow(new Object[]{
           rs.getLong("ref"),rs.getString("produit"),nf3.format(rs.getLong("prix")),nf3.format(rs.getLong("dep"))
                          
           }) ;
          
                       
           
                   }else{
           
                   m.put("id",  rs.getString("ref")) ;
                   m.put("description", rs.getString("produit")) ;
                   m.put("pu", nf3.format(rs.getLong("prix"))) ;
                   m.put("qted", nf3.format(rs.getLong("dep"))) ;
                   
                            
                       mtt += ((rs.getLong("dep")) * rs.getLong("prix")) ;
                       
                     //  m.put("mtt", nf3.format(((rs.getLong("dep")) * rs.getLong("prix")))) ;
                   
                    this.bonList_d.add(m) ;
           
                  dtm2.addRow(new Object[]{
           rs.getLong("ref"),rs.getString("produit"),nf3.format(rs.getLong("prix")),nf3.format(rs.getLong("dep"))
                          
           }) ;
                        
                        
                }
                   
                   // end :
            
            
                }
               
                 
                 // sql produits fini :
       
   
       
       // ----------------------------------------------- fin produit fini : ------------------------------------------------------
       
     // ------------------------------------------------- debut produit derive ----------------------------------------------------
       
       
         long ndep2  = 0 ;
         long nariv2 = 0 ;
        
      // long mtt = 0 ;
       
                // sql matieres_p :
       
         
               /*
         
        sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , depart , arriver , "
                      +"derive_pl.id as ref , "
                      +"sum(nariv) as arriv , sum(ndep) as dep "
                      + " from stock_detail_pl , derive_pl where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND ( arriver = '"+point+"' OR depart = '"+point+"' ) AND derive_pl.produit = stock_detail_pl.description "
        + " group by arriver , depart , produit order by produit asc" ;
   
                      */
         
         sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , arriver , "
                      +"derive_pl.id as ref , "
                      +"sum(nariv) as arriv "
                      + " from stock_detail_pl , derive_pl where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND arriver = '"+point+"' AND stock_detail_pl.type = 'oui' AND derive_pl.produit = stock_detail_pl.description "
        + " group by arriver , produit order by produit asc" ;
        
       sql2 = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , depart , "
                      +"derive_pl.id as ref , "
                      +"sum(ndep) as dep "
                      + " from stock_detail_pl , derive_pl where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND depart = '"+point+"' AND stock_detail_pl.type = 'oui' AND derive_pl.produit = stock_detail_pl.description "
        + " group by depart , produit order by produit asc" ;
        
         
         
                 rs = stmt.executeQuery(sql) ;
       while(rs.next()){
            
           
            HashMap<String, Object> m = new HashMap<>() ;
            
                   m.put("id",  rs.getString("ref")) ;
                   m.put("description", rs.getString("produit")) ;
                   m.put("pu", nf3.format(rs.getLong("prix"))) ;
                   m.put("qtea", nf3.format(rs.getLong("arriv"))) ;
                   
                     
                       mtt += ((rs.getLong("arriv")) * rs.getLong("prix")) ;
                   
                    this.bonList.add(m) ;
           
                  dtm.addRow(new Object[]{
           rs.getLong("ref"),rs.getString("produit"),nf3.format(rs.getLong("prix")),nf3.format(rs.getLong("arriv"))
                          
                  }) ;
           
            
           
                }
       
               rs = stmt.executeQuery(sql2) ;
                    while(rs.next()){
            
           
            HashMap<String, Object> m = new HashMap<>() ;
            
                   m.put("id",  rs.getString("ref")) ;
                   m.put("description", rs.getString("produit")) ;
                   m.put("pu", nf3.format(rs.getLong("prix"))) ;
                   m.put("qted", nf3.format(rs.getLong("dep"))) ;
                   
                     
                       mtt += ((rs.getLong("dep")) * rs.getLong("prix")) ;
                   
                    this.bonList_d.add(m) ;
           
                  dtm2.addRow(new Object[]{
           rs.getLong("ref"),rs.getString("produit"),nf3.format(rs.getLong("prix")),nf3.format(rs.getLong("dep"))
                          
                  }) ;
           
            
           
                }
       
               
                 
                 // sql produits fini :
       
   
       
       
   // --------------------------------------------------- fin produit derive ------------------------------------------------------
       
       
             //    this.jLabel5.setText(nf3.format(mtt)) ;
       
      
       
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
        
        
        
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(this, "CHOISIR LES 2 PERIODES OBLIGATOIRES AVEC L'HEURE SVP ! ") ;
            
        }
        
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
         this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
         
        if("0".equalsIgnoreCase(this.zone)){
            JOptionPane.showMessageDialog(this, "CHOISIR LES 2 PERIODES OBLIGATOIRES AVEC L'HEURE ET LE POINT DE PLACEMENT SVP ! ") ;
        }else{
            
            try{
                
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\etat_pl_final.jrxml")) ;
              
            
            JRBeanCollectionDataSource data1 = new JRBeanCollectionDataSource(this.bonList) ;
            JRBeanCollectionDataSource data2 = new JRBeanCollectionDataSource(this.bonList_d) ;
            
            Map<String, Object> para = new HashMap<>();
         // para.put("data", jrbean);
            para.put("op", "OP : "+this.login) ;  // this.login
            para.put("periode","LA PERIODE : DU "+this.dte1+" AU : "+this.dte2) ;
            para.put("zone", "LE POINT DE PLACEMENT : "+this.zone) ;
            para.put("f", "FAMILLE : "+this.f.getSelectedItem().toString()) ;
            para.put("sf", "SOUS FAMILLE : "+this.sf.getSelectedItem().toString()) ;
            para.put("data1", data1) ;
            para.put("data2", data2) ;
            
         // para.put("Total", "TOTAL MONTANT : "+this.nf3.format(this.mtt)) ;
           
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource()) ;
            
            JasperViewer.viewReport(print, false);
            
                
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage()) ;
            }
            
            
        }
        
        this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Print_Pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Print_Pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Print_Pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Print_Pl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Print_Pl().setVisible(true);
            }
        }) ;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox f;
    private javax.swing.JTextField h1;
    private javax.swing.JTextField h2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox pl;
    private javax.swing.JComboBox sf;
    // End of variables declaration//GEN-END:variables
}
