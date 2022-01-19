/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.Clients1.DB_URL;
import static frontend.Op_Pl.JDBC_DRIVER;
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
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HAMZA
 */
public class EtatStock_PL extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      String login ;
      String role ;
      
      
      String sql = "" ;
      String sql2 = "" ;
      String sql3 = "" ;
      
      String point = "" ;
      String mot = "" ;
      String dte1 ;
      long mtt = 0 ;
      String jour = null ;
      
      
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
       List bonList = new ArrayList() ;
       SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
       SimpleDateFormat sdf_jdch = new SimpleDateFormat("dd-MM-yyyy" , Locale.getDefault()) ;
       
       Integer vy = 0 ;
       
       String js_pl ;
      
      
    public EtatStock_PL() {
        initComponents();
    }
    
    public EtatStock_PL(String login) {
        initComponents();
        
        this.setLocationRelativeTo(null) ;
        this.login = login ;
        
        this.jLabel3.setVisible(false) ;
        this.jLabel4.setVisible(false) ;
        this.jDateChooser1.setVisible(false) ;
        this.h1.setVisible(false) ;
        
        this.placement.setSelectedItem(new String("TOUT POINT DE PLACEMENT")) ;
        
        
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
        
       
        
     
        
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
        
        
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm1.setRowCount(0) ;
        
        
        
        
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
      
     
      
           String sql ;
           ResultSet rs ;
                 
                
                 
                 
               sql = "select placement from point_pl where type = 'oui' AND NOT placement = 'zone de decoupage' AND NOT placement = 'EXTERIEUR' order by placement ASC" ;
                 ResultSet rs20 = stmt.executeQuery(sql) ;
                 
                 while(rs20.next()){
                 
                  this.placement.addItem(rs20.getString("placement")) ;
                 
                  
               
       }
                 
                  
                 
                  sql = "select motif from motif_pl where type = 'oui' order by motif ASC" ;
                 ResultSet rs22 = stmt.executeQuery(sql) ;
                 
                 while(rs22.next()){
                 
                 // this.motif.addItem(rs22.getString("motif")) ;
                  
                  
               
       }
                 
                 
                 
                 
      
       
      //STEP 6: Clean-up environment
   // rs2.close();
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        placement = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        h1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ETAT DE STOCK DES PRODUITS PAR INSTANT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPTION", "STOCK", "P.U / P.M", "MONTANT"
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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(15);
        }

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("IMPRIMER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("TOTAL MONTANT :");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("RECHERCHER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        placement.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        placement.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR POINT DE PLACEMENT" }));
        placement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        placement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placementActionPerformed(evt);
            }
        });

        jLabel3.setText("DATE");

        jLabel4.setText("HEURE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addComponent(placement, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addGap(6, 6, 6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(placement, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        this.bonList.removeAll(this.bonList) ;
        
        
         try{
             DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                               dtm.setRowCount(0) ;
                               
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
        SimpleDateFormat sdfT1 = new SimpleDateFormat("dd-MM-yyyy") ;
        
       
        this.dte1 = sdfT1.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        
        
      String dte2 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
      ResultSet rs = null ;
      
      if("TOUT POINT DE PLACEMENT".equalsIgnoreCase(this.point) || "".equals(this.point)){
                
// "MAGASIN / P.PL", "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "STOCK", "P.U / P.M", "MONTANT"
                
                this.sql = "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "matieres_p.id as ref , matieres_p.condition_livraison as f , matieres_p.conservation as sf , "
                        +  "matieres_p.description as mat_desc , matieres_p.unite_mesure as mesure , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , matieres_p where stock_pl.dtec <= '"+dte2+"' AND matieres_p.description = stock_pl.description" ;
                
                this.sql2 = "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "produits_f.id as ref , produits_f.f as f , produits_f.sf as sf , "
                        +  "produits_f.description as prod_desc , produits_f.unite_m as mesure , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , produits_f where stock_pl.dtec <= '"+dte2+"' AND produits_f.description = stock_pl.description" ;
                
                this.sql3 = "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "derive_pl.id as ref , derive_pl.produit as prod , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , derive_pl where stock_pl.dtec <= '"+dte2+"' AND derive_pl.produit = stock_pl.description" ;
                
                
            }else{
            
            // "MAGASIN / P.PL", "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "STOCK", "P.U / P.M", "MONTANT"
                
                this.sql = "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "matieres_p.id as ref , matieres_p.condition_livraison as f , matieres_p.conservation as sf , "
                        +  "matieres_p.description as mat_desc , matieres_p.unite_mesure as mesure , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , matieres_p where stock_pl.magasin = '"+this.point+"' AND stock_pl.dtec <= '"+dte2+"' AND  matieres_p.description = stock_pl.description" ;
                
                this.sql2 = "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "produits_f.id as ref , produits_f.f as f , produits_f.sf as sf , "
                        +  "produits_f.description as prod_desc , produits_f.unite_m as mesure , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , produits_f where stock_pl.magasin = '"+this.point+"' AND stock_pl.dtec <= '"+dte2+"' AND produits_f.description = stock_pl.description" ;
                
                this.sql3 = "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "derive_pl.id as ref , derive_pl.produit as prod , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , derive_pl where stock_pl.magasin = '"+this.point+"' AND stock_pl.dtec <= '"+dte2+"' AND derive_pl.produit = stock_pl.description" ;
                
           
                
                
            }
      
     
        
        
      
         
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
      
            this.mtt = 0 ;
            long qt = 0 ;
            double q1 = 0.0 ;
            double mt = 0.0 ;
            float pu = 0 ;
       
                             
                             rs = stmt.executeQuery(this.sql) ;
                             
                             while(rs.next()){
                                 
                                  HashMap<String, Object> m = new HashMap<>() ;
                                 
                                 if("OUI".equalsIgnoreCase(rs.getString("mesure"))){
                                     // divise par 1000
                                     qt = 0 ;
                                     pu = 0 ;
                                     q1 = 0.0 ;
                                     mt = 0.0 ;
                                     
                                     qt = rs.getLong("stock") ;
                                     pu = rs.getFloat("pu") ;
                                     q1 = (qt / 1000.0) ;
                                     mt = (q1 * pu) ;
                                     
                                      
                                     this.mtt += mt ;
                             
                              
                                /*
                                "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "matieres_p.id as ref , matieres_p.condition_livraison as f , matieres_p.conservation as sf , "
                        +  "matieres_p.description as mat_desc , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , matieres_p where matieres_p.description = stock_pl.description" ;
                                */
                                 
             // "MAGASIN / P.PL", "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "STOCK", "P.U / P.M", "MONTANT"
                  
                   m.put("mag",rs.getString("mag")) ;                  
                   m.put("f",  rs.getString("f")) ;
                   m.put("sf", rs.getString("sf")) ;
                   m.put("ref",rs.getLong("ref")) ;
                   m.put("descrip",rs.getString("descrip")) ;
                   m.put("stock",rs.getLong("stock")) ;
                   m.put("pu", this.nf3.format(rs.getFloat("pu"))) ;
                   m.put("montant", this.nf3.format(mt)) ; // Math.round(3,568) ;
                  
                     //  mtt += ((nariv - ndep) * rs.getLong("prix")) ;
                   
                    this.bonList.add(m) ;
            
                                 dtm.addRow(new Object[]{
                                 rs.getString("mag") , rs.getString("f") , rs.getString("sf") , rs.getLong("ref") , 
                                 rs.getString("descrip") , this.nf3.format(rs.getLong("stock")) , this.nf3.format(rs.getFloat("pu")) ,
                                this.nf3.format(mt)
                                         
                                 }) ;
                                 
                                     
                                 }else{
                                     
                                     mtt += (rs.getLong("stock") * rs.getFloat("pu")) ;
                             
                   m.put("mag",rs.getString("mag")) ;                  
                   m.put("f",  rs.getString("f")) ;
                   m.put("sf", rs.getString("sf")) ;
                   m.put("ref",rs.getLong("ref")) ;
                   m.put("descrip",rs.getString("descrip")) ;
                   m.put("stock",rs.getLong("stock")) ;
                   m.put("pu", this.nf3.format(rs.getFloat("pu"))) ;
                   m.put("montant", this.nf3.format((Float) (rs.getLong("stock") * rs.getFloat("pu")))) ;
                  
                     //  mtt += ((nariv - ndep) * rs.getLong("prix")) ;
                   
                    this.bonList.add(m) ;
                                     
                              
                                /*
                                "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "matieres_p.id as ref , matieres_p.condition_livraison as f , matieres_p.conservation as sf , "
                        +  "matieres_p.description as mat_desc , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , matieres_p where matieres_p.description = stock_pl.description" ;
                                */
                                 
             // "MAGASIN / P.PL", "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "STOCK", "P.U / P.M", "MONTANT"
            
                                 dtm.addRow(new Object[]{
                                 rs.getString("mag") , rs.getString("f") , rs.getString("sf") , rs.getLong("ref") , 
                                 rs.getString("descrip") , this.nf3.format(rs.getLong("stock")) , this.nf3.format(rs.getFloat("pu")) ,
                                 this.nf3.format((rs.getLong("stock") * rs.getFloat("pu")))
                                 });
                                 
                                     
                                     
                                 }
                                 
                                
                                 
                             }
                             
                             
                             rs = stmt.executeQuery(this.sql2) ;
                             
                             while(rs.next()){
                                 
                                 HashMap<String, Object> m = new HashMap<>() ;
                                 
                                if("OUI".equalsIgnoreCase(rs.getString("mesure"))){
                                    
                                     // divise par 1000
                                    
                                     qt = 0 ;
                                     pu = 0 ;
                                     q1 = 0.0 ;
                                     mt = 0.0 ;
                                     
                                     qt = rs.getLong("stock") ;
                                     pu = rs.getFloat("pu") ;
                                     q1 = (qt / 1000.0) ;
                                     mt = (q1 * pu) ;
                                     
                                      
                                     this.mtt += mt ;
                             
                              
                             
                   m.put("mag",rs.getString("mag")) ;                  
                   m.put("f",  rs.getString("f")) ;
                   m.put("sf", rs.getString("sf")) ;
                   m.put("ref",rs.getLong("ref")) ;
                   m.put("descrip",rs.getString("descrip")) ;
                   m.put("stock",rs.getLong("stock")) ;
                   m.put("pu", this.nf3.format(rs.getFloat("pu"))) ;
                   m.put("montant", this.nf3.format(mt)) ;
                  
                     //  mtt += ((nariv - ndep) * rs.getLong("prix")) ;
                   
                    this.bonList.add(m) ;
            
                              
                                /*
                                "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "matieres_p.id as ref , matieres_p.condition_livraison as f , matieres_p.conservation as sf , "
                        +  "matieres_p.description as mat_desc , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , matieres_p where matieres_p.description = stock_pl.description" ;
                                */
                                 
             // "MAGASIN / P.PL", "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "STOCK", "P.U / P.M", "MONTANT"
            
                                 dtm.addRow(new Object[]{
                                 rs.getString("mag") , rs.getString("f") , rs.getString("sf") , rs.getLong("ref") , 
                                 rs.getString("descrip") , this.nf3.format(rs.getLong("stock")) , this.nf3.format(rs.getFloat("pu")) ,
                                 this.nf3.format(mt)
                                 });
                                 
                                     
                                 }else{
                                     
                                     mtt += (rs.getLong("stock") * rs.getFloat("pu")) ;
                             
                   m.put("mag",rs.getString("mag")) ;                  
                   m.put("f",  rs.getString("f")) ;
                   m.put("sf", rs.getString("sf")) ;
                   m.put("ref",rs.getLong("ref")) ;
                   m.put("descrip",rs.getString("descrip")) ;
                   m.put("stock",rs.getLong("stock")) ;
                   m.put("pu", this.nf3.format(rs.getFloat("pu"))) ;
                   m.put("montant", this.nf3.format( (Float) ((rs.getLong("stock")) * rs.getFloat("pu")))) ;
                  
                     //  mtt += ((nariv - ndep) * rs.getLong("prix")) ;
                   
                    this.bonList.add(m) ;
            
                              
                                /*
                                "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "matieres_p.id as ref , matieres_p.condition_livraison as f , matieres_p.conservation as sf , "
                        +  "matieres_p.description as mat_desc , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , matieres_p where matieres_p.description = stock_pl.description" ;
                                */
                                 
             // "MAGASIN / P.PL", "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "STOCK", "P.U / P.M", "MONTANT"
            
                                 dtm.addRow(new Object[]{
                                 rs.getString("mag") , rs.getString("f") , rs.getString("sf") , rs.getLong("ref") , 
                                 rs.getString("descrip") , this.nf3.format(rs.getLong("stock")) , this.nf3.format(rs.getFloat("pu")) ,
                                 this.nf3.format((rs.getLong("stock") * rs.getFloat("pu")))
                                 });
                                 
                                     
                                     
                                 }
                                 
                                
                                 
                             }
                             
                             
                             
                               rs = stmt.executeQuery(this.sql3) ;
                             
                             while(rs.next()){
                                 
                                 HashMap<String, Object> m = new HashMap<>() ;
                                 
                                mtt += (rs.getLong("stock") * rs.getFloat("pu")) ;
                             
                   m.put("mag",rs.getString("mag")) ;                  
                   m.put("f",  "PRODUIT DERIVE") ;
                   m.put("sf", "PRODUIT DERIVE") ;
                   m.put("ref",rs.getLong("ref")) ;
                   m.put("descrip",rs.getString("descrip")) ;
                   m.put("stock",rs.getLong("stock")) ;
                   m.put("pu", this.nf3.format(rs.getFloat("pu"))) ;
                   m.put("montant", this.nf3.format((Float) ((rs.getLong("stock")) * rs.getFloat("pu")))) ;
                   
                  
                  //  mtt += ((nariv - ndep) * rs.getLong("prix")) ;
                   
                    this.bonList.add(m) ;
            
                                
                                /*
                                "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "matieres_p.id as ref , matieres_p.condition_livraison as f , matieres_p.conservation as sf , "
                        +  "matieres_p.description as mat_desc , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , matieres_p where matieres_p.description = stock_pl.description" ;
                                */
                                 
             // "MAGASIN / P.PL", "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "STOCK", "P.U / P.M", "MONTANT"
            
                                 dtm.addRow(new Object[]{
                                 rs.getString("mag") , "PRODUIT DERIVE" , "PRODUIT DERIVE" , rs.getLong("ref") , 
                                 rs.getString("descrip") , this.nf3.format(rs.getLong("stock")) , this.nf3.format(rs.getFloat("pu")) ,
                                 this.nf3.format((rs.getLong("stock") * rs.getFloat("pu")))
                                 });
                                 
                                 
                             }
                             
                             this.jLabel2.setText("TOTAL MONTANT : "+this.nf3.format(this.mtt)) ;
                 
      
       
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e1){
      //Handle errors for Class.forName
      e1.printStackTrace();
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
        
       
                  
      
        
        
         }catch(Exception e){
        
             this.dte1 = this.sdf.format(new Date()) ;
             
        if(this.point.equals("")){
            JOptionPane.showMessageDialog(this, "SELECTIONNER UN POINT DE PLACEMENT SVP !!! ") ;
        }else{
        
            
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
      
            this.mtt = 0 ;
            long qt = 0 ;
            double q1 = 0.0 ;
            double mt = 0.0 ;
            float pu = 0 ;
       
      
           ResultSet rs ;
                 
       
           DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                             dtm.setRowCount(0) ;
                             
                             rs = stmt.executeQuery(this.sql) ;
                             
                             while(rs.next()){
                                 
                                 HashMap<String, Object> m = new HashMap<>() ;
                                 
                                 if("OUI".equalsIgnoreCase(rs.getString("mesure"))){
                                    
                                     // divise par 1000
                                     qt = 0 ;
                                     pu = 0 ;
                                     q1 = 0.0 ;
                                     mt = 0.0 ;
                                     
                                     qt = rs.getLong("stock") ;
                                     pu = rs.getFloat("pu") ;
                                     q1 = (qt / 1000.0) ;
                                     mt = (q1 * pu) ;
                                     
                                      
                                     this.mtt += mt ;
                             
                              
                                     
                     
                             
                //   m.put("mag",rs.getString("mag")) ;                  
                //   m.put("f",  rs.getString("f")) ;
               //    m.put("sf", rs.getString("sf")) ;
                   m.put("ref",rs.getLong("ref")) ;
                   m.put("descrip",rs.getString("descrip")) ;
                   m.put("stock",rs.getLong("stock")) ;
                   m.put("pu", this.nf3.format(rs.getFloat("pu"))) ;
                   m.put("montant", this.nf3.format(mt)) ;
                   
                   this.bonList.add(m) ;
                  
                              
                                /*
                                "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "matieres_p.id as ref , matieres_p.condition_livraison as f , matieres_p.conservation as sf , "
                        +  "matieres_p.description as mat_desc , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , matieres_p where matieres_p.description = stock_pl.description" ;
                                */
                                 
             // "MAGASIN / P.PL", "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "STOCK", "P.U / P.M", "MONTANT"
            
                                 dtm.addRow(new Object[]{
                                  rs.getLong("ref") , 
                                 rs.getString("descrip") , this.nf3.format(rs.getLong("stock")) , this.nf3.format(rs.getFloat("pu")) ,
                                this.nf3.format(mt)
                                 }) ;
                                 
                                     
                                 }else{
                                     
                   mtt += (rs.getLong("stock") * rs.getFloat("pu")) ;
                             
           //      m.put("mag",rs.getString("mag")) ;                  
          //       m.put("f",  rs.getString("f")) ;
         //        m.put("sf", rs.getString("sf")) ;
                   m.put("ref",rs.getLong("ref")) ;
                   m.put("descrip",rs.getString("descrip")) ;
                   m.put("stock",rs.getLong("stock")) ;
                   m.put("pu", this.nf3.format(rs.getFloat("pu"))) ;
                   m.put("montant", this.nf3.format((Float) (rs.getLong("stock") * rs.getFloat("pu")))) ;
                   
                   this.bonList.add(m) ;
                  
                              
                                /*
                                "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "matieres_p.id as ref , matieres_p.condition_livraison as f , matieres_p.conservation as sf , "
                        +  "matieres_p.description as mat_desc , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , matieres_p where matieres_p.description = stock_pl.description" ;
                                */
                                 
             // "MAGASIN / P.PL", "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "STOCK", "P.U / P.M", "MONTANT"
            
                                 dtm.addRow(new Object[]{
                                 rs.getLong("ref") , 
                                 rs.getString("descrip") , this.nf3.format(rs.getLong("stock")) , this.nf3.format(rs.getFloat("pu")) ,
                                 this.nf3.format((rs.getLong("stock") * rs.getFloat("pu")))
                                 }) ;
                                 
                                     
                                     
                                 }
                                 
                                
                                 
                             }
                             
                             
                               rs = stmt.executeQuery(this.sql2) ;
                             
                             while(rs.next()){
                                 
                                  HashMap<String, Object> m = new HashMap<>() ;
                                  
                                if("OUI".equalsIgnoreCase(rs.getString("mesure"))){
                                    
                                     // divise par 1000
                                     qt = 0 ;
                                     pu = 0 ;
                                     q1 = 0.0 ;
                                     mt = 0.0 ;
                                     
                                     qt = rs.getLong("stock") ;
                                     pu = rs.getFloat("pu") ;
                                     q1 = (qt / 1000.0) ;
                                     mt = (q1 * pu) ;
                                     
                                      
                                     this.mtt += Math.round(mt) ;
                             
                              
                                     
                   
                   m.put("ref",rs.getLong("ref")) ;
                   m.put("descrip",rs.getString("descrip")) ;
                   m.put("stock",rs.getLong("stock")) ;
                   m.put("pu", this.nf3.format(rs.getFloat("pu"))) ;
                   m.put("montant", this.nf3.format(mt)) ;
                   
                   this.bonList.add(m) ;
                             
                              
                                /*
                                "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "matieres_p.id as ref , matieres_p.condition_livraison as f , matieres_p.conservation as sf , "
                        +  "matieres_p.description as mat_desc , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , matieres_p where matieres_p.description = stock_pl.description" ;
                                */
                                 
             // "MAGASIN / P.PL", "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "STOCK", "P.U / P.M", "MONTANT"
            
                                 dtm.addRow(new Object[]{
                                 rs.getLong("ref") , 
                                 rs.getString("descrip") , this.nf3.format(rs.getLong("stock")) , this.nf3.format(rs.getFloat("pu")) ,
                                 this.nf3.format(mt)
                                 });
                                 
                                     
                                 }else{
                                     
                                     mtt += (rs.getLong("stock") * rs.getFloat("pu")) ;
                             
                  
                   m.put("ref",rs.getLong("ref")) ;
                   m.put("descrip",rs.getString("descrip")) ;
                   m.put("stock",rs.getLong("stock")) ;
                   m.put("pu", this.nf3.format(rs.getFloat("pu"))) ;
                   m.put("montant", this.nf3.format((Float) (rs.getLong("stock") * rs.getFloat("pu")))) ;
                   
                   this.bonList.add(m) ;
                              
                                /*
                                "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "matieres_p.id as ref , matieres_p.condition_livraison as f , matieres_p.conservation as sf , "
                        +  "matieres_p.description as mat_desc , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , matieres_p where matieres_p.description = stock_pl.description" ;
                                */
                                 
             // "MAGASIN / P.PL", "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "STOCK", "P.U / P.M", "MONTANT"
            
                                 dtm.addRow(new Object[]{
                                 rs.getLong("ref") , 
                                 rs.getString("descrip") , this.nf3.format(rs.getLong("stock")) , this.nf3.format(rs.getFloat("pu")) ,
                                 this.nf3.format((rs.getLong("stock") * rs.getFloat("pu")))
                                 });
                                 
                                     
                                     
                                 }
                                 
                                
                                 
                             }
                             
                             
                             
                               rs = stmt.executeQuery(this.sql3) ;
                             
                             while(rs.next()){
                                 
                                 HashMap<String, Object> m = new HashMap<>() ;
                                 
                                mtt += (rs.getLong("stock") * rs.getFloat("pu")) ;
                             
              
                   m.put("ref",rs.getLong("ref")) ;
                   m.put("descrip",rs.getString("descrip")) ;
                   m.put("stock",rs.getLong("stock")) ;
                   m.put("pu", this.nf3.format(rs.getFloat("pu"))) ;
                   m.put("montant", this.nf3.format((Float) (rs.getLong("stock") * rs.getFloat("pu")))) ;
                   
                   this.bonList.add(m) ;
                   
                   
                                /*
                                "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "matieres_p.id as ref , matieres_p.condition_livraison as f , matieres_p.conservation as sf , "
                        +  "matieres_p.description as mat_desc , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , matieres_p where matieres_p.description = stock_pl.description" ;
                                */
                                 
             // "MAGASIN / P.PL", "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "STOCK", "P.U / P.M", "MONTANT"
            
                                 dtm.addRow(new Object[]{
                                 rs.getLong("ref") , 
                                 rs.getString("descrip") , this.nf3.format(rs.getLong("stock")) , this.nf3.format(rs.getFloat("pu")) ,
                                 this.nf3.format((rs.getLong("stock") * rs.getFloat("pu")))
                                 });
                                 
                                 
                             }
                             
                             this.jLabel2.setText("TOTAL MONTANT : "+this.nf3.format(mtt)) ;
                 
      
       
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e1){
      //Handle errors for Class.forName
      e1.printStackTrace();
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
     //   JOptionPane.showMessageDialog(this, "test catch ...");
         }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void placementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placementActionPerformed
        // TODO add your handling code here:
        
        this.point = "" ;
        this.vy = 0 ;
        
        this.point = this.placement.getSelectedItem().toString().replaceAll("'", "''") ;
        this.js_pl = new String("") ;
        this.js_pl = this.point.replaceAll("''", "'") ;
        
        
        //  CHOISIR POINT DE PLACEMENT
       //   TOUT POINT DE PLACEMENT
      //
        
        if(this.point.equalsIgnoreCase("CHOISIR POINT DE PLACEMENT")){
            this.point = "" ;
        }else{
            if("TOUT POINT DE PLACEMENT".equalsIgnoreCase(this.point)){
               
// "MAGASIN / P.PL", "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "STOCK", "P.U / P.M", "MONTANT"
                
                this.sql = "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "matieres_p.id as ref , matieres_p.condition_livraison as f , matieres_p.conservation as sf , "
                        +  "matieres_p.description as mat_desc , matieres_p.unite_mesure as mesure , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , matieres_p where NOT stock_pl.magasin = 'zone de decoupage' AND NOT stock_pl.magasin = 'EXTERIEUR' AND "
                        + "matieres_p.description = stock_pl.description group by f , sf order by f asc , sf asc" ;
                
                this.sql2 = "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "produits_f.id as ref , produits_f.f as f , produits_f.sf as sf , "
                        +  "produits_f.description as prod_desc , produits_f.unite_m as mesure , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , produits_f where NOT stock_pl.magasin = 'zone de decoupage' AND NOT stock_pl.magasin = 'EXTERIEUR' AND "
                        + "produits_f.description = stock_pl.description group by f , sf order by f asc , sf asc" ;
                
                this.sql3 = "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "derive_pl.id as ref , derive_pl.produit as prod , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , derive_pl where NOT stock_pl.magasin = 'zone de decoupage' AND NOT stock_pl.magasin = 'EXTERIEUR' AND "
                        + "derive_pl.produit = stock_pl.description " ;
                
             
                
                /*
                       this.sql = "" ;
                       
                           this.sql = "select \n" +
"mag,f,sf,ref,descrip,stock,pu , mesure \n" +
"from (\n" +
"select magasin as mag, condition_livraison as f , conservation as sf , matieres_p.id as ref , matieres_p.description as descrip ,\n" +
"stock_dispo as stock , prx_pm as pu , unite_mesure as mesure \n" +
"from stock_pl , matieres_p where not magasin = 'zone de decoupage' and not magasin = 'exterieur' and matieres_p.description = stock_pl.description \n" +
"union all \n" +
"select magasin as mag, f as f, sf as sf, produits_f.id as ref , produits_f.description as descrip , stock_dispo as stock , prx_pm as pu ,\n" +
"unite_m as mesure \n" +
"from stock_pl , produits_f where not magasin = 'zone de decoupage' and not magasin = 'exterieur' and produits_f.description = stock_pl.description \n" +
"union all \n" +
"select magasin as mag , '' as f , '' as sf , derive_pl.id as ref , derive_pl.produit as descrip , stock_dispo as stock , prx_pm as pu , \n" +
"'' as mesure \n" +
"from stock_pl , derive_pl where not magasin = 'zone de decoupage' and not magasin = 'exterieur' and derive_pl.produit = stock_pl.description \n" +
") as tab1 group by mag order by mag asc , descrip asc " ;
                
                */
                           
                           
                               this.vy = 1 ;
                
                
            }else{
            
            // "MAGASIN / P.PL", "FAMILLE", "SOUS FAMILLE", "ID", "DESCRIPTION", "STOCK", "P.U / P.M", "MONTANT"
                
                this.sql = "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "matieres_p.id as ref , matieres_p.condition_livraison as f , matieres_p.conservation as sf , "
                        +  "matieres_p.description as mat_desc , matieres_p.unite_mesure as mesure , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , matieres_p where stock_pl.magasin = '"+this.point+"' AND  matieres_p.description = stock_pl.description "
                        + " order by descrip asc" ;
                
               this.sql2 = "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "produits_f.id as ref , produits_f.f as f , produits_f.sf as sf , "
                        +  "produits_f.description as prod_desc , produits_f.unite_m as mesure , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , produits_f where stock_pl.magasin = '"+this.point+"' AND produits_f.description = stock_pl.description "
                        + " order by descrip asc" ;
                
                this.sql3 = "select stock_pl.magasin as mag , stock_pl.description as descrip , "
                        +  "derive_pl.id as ref , derive_pl.produit as prod , stock_pl.stock_dispo as stock , "
                        +  "stock_pl.prx_pm as pu "
                + "from stock_pl , derive_pl where stock_pl.magasin = '"+this.point+"' AND  derive_pl.produit = stock_pl.description "
                        + " order by descrip" ;
                
                                    this.vy = 0 ;
                
                
            }
            
        }
        
        
    }//GEN-LAST:event_placementActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(this.vy == 0){
        
        this.jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
        try{
                
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\stock.jrxml")) ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.bonList) ;
            
            Map<String, Object> para = new HashMap<>();
         // para.put("data", jrbean);
            para.put("op", "OP : "+this.login) ;  // this.login
            para.put("periode","LA PERIODE : "+this.dte1) ;
            para.put("zone", "POINT PLACEMENT : "+this.js_pl) ;
            para.put("mtt", "TOTAL MONTANT : "+this.nf3.format(this.mtt)) ;
           
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print, false);
            
                
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage()) ;
            }
            
            
        
        
        this.jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        }else if(this.vy == 1){
            
            this.jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
            
            
            /*
            
             this.sql = "" ;
                       
                           this.sql = "select \n" +
"mag,f,sf,ref,descrip,stock,pu , mesure \n" +
"from (\n" +
"select magasin as mag, condition_livraison as f , conservation as sf , matieres_p.id as ref , matieres_p.description as descrip ,\n" +
"stock_dispo as stock , prx_pm as pu , unite_mesure as mesure \n" +
"from stock_pl , matieres_p where not magasin = 'zone de decoupage' and not magasin = 'exterieur' and matieres_p.description = stock_pl.description \n" +
"union all \n" +
"select magasin as mag, f as f, sf as sf, produits_f.id as ref , produits_f.description as descrip , stock_dispo as stock , prx_pm as pu ,\n" +
"unite_m as mesure \n" +
"from stock_pl , produits_f where not magasin = 'zone de decoupage' and not magasin = 'exterieur' and produits_f.description = stock_pl.description \n" +
"union all \n" +
"select magasin as mag , '' as f , '' as sf , derive_pl.id as ref , derive_pl.produit as descrip , stock_dispo as stock , prx_pm as pu , \n" +
"'' as mesure \n" +
"from stock_pl , derive_pl where not magasin = 'zone de decoupage' and not magasin = 'exterieur' and derive_pl.produit = stock_pl.description \n" +
") as tab1 group by mag order by mag asc , descrip asc " ;
                
            
             this.bonList.removeAll(this.bonList) ;
             
              this.dte1 = this.sdf.format(new Date()) ;
            
            
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
      
            this.mtt = 0 ;
            long qt = 0 ;
            double q1 = 0.0 ;
            double mt = 0.0 ;
            long pu = 0 ;
       
      
           ResultSet rs ;
           
                             
                             rs = stmt.executeQuery(this.sql) ;
                             
                             while(rs.next()){
                                 
                                 HashMap<String, Object> m = new HashMap<>() ;
                                 
                                 if("OUI".equalsIgnoreCase(rs.getString("mesure"))){
                                    
                                     // divise par 1000
                                     qt = 0 ;
                                     pu = 0 ;
                                     q1 = 0.0 ;
                                     mt = 0.0 ;
                                     
                                     qt = rs.getLong("stock") ;
                                     pu = rs.getLong("pu") ;
                                     q1 = (qt / 1000.0) ;
                                     mt = (q1 * pu) ;
                                     
                                      
                                     this.mtt += Math.round(mt) ;
                             
                              
                                     
                     
                             
                   m.put("mag",rs.getString("mag")) ;                  
                   m.put("f",  rs.getString("f")) ;
                   m.put("sf", rs.getString("sf")) ;
                   m.put("ref",rs.getLong("ref")) ;
                   m.put("descrip",rs.getString("descrip")) ;
                   m.put("stock",rs.getLong("stock")) ;
                   m.put("pu", rs.getLong("pu")) ;
                   m.put("montant", Math.round(mt)) ;
                   
                   this.bonList.add(m) ;
                  
                                 }else{
                                     
                   mtt += (rs.getLong("stock") * rs.getLong("pu")) ;
                             
                   m.put("mag",rs.getString("mag")) ;  
                   if(rs.getString("f").isEmpty()){
                       m.put("f",  "PRODUIT DERIVE") ; 
                   }else{
                   m.put("f",  rs.getString("f")) ;
                   }
                   
                   if(rs.getString("sf").isEmpty()){
                       m.put("sf",  "PRODUIT DERIVE") ; 
                   }else{
                   m.put("sf", rs.getString("sf")) ;
                   }
                   
                   
                   m.put("ref",rs.getLong("ref")) ;
                   m.put("descrip",rs.getString("descrip")) ;
                   m.put("stock",rs.getLong("stock")) ;
                   m.put("pu", rs.getLong("pu")) ;
                   m.put("montant", (rs.getLong("stock") * rs.getLong("pu"))) ;
                   
                   this.bonList.add(m) ;
                  
                               
                                 }
                                 
                                
                                 
                             }
                            
                             this.jLabel2.setText("TOTAL MONTANT : "+this.nf3.format(mtt)) ;
                 
      
       
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e1){
      //Handle errors for Class.forName
      e1.printStackTrace();
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
     
            
            
            
        
        try{
                
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\stock_05h00.jrxml")) ;
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.bonList) ;
            
            Map<String, Object> para = new HashMap<>();
         // para.put("data", jrbean);
            para.put("op", "OP : "+this.login) ;  // this.login
            para.put("periode","LA PERIODE : "+this.dte1) ;
            para.put("zone", "LE POINT DE PLACEMENT : ") ;
            para.put("mtt", "TOTAL MONTANT : "+this.nf3.format(this.mtt)) ;
           
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print, false);
            
                
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage()) ;
            }
            
            
        */
            
            
            try{
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\stock_05h00.jrxml")) ;
           //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\new-version-siby\\UtpaSibyCenter\\src\\reports\\clientss.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql = "select \n" +
"mag,f,sf,ref,descrip,stock,pu , mesure \n" +
"from (\n" +
"select magasin as mag, condition_livraison as f , conservation as sf , matieres_p.id as ref , matieres_p.description as descrip ,\n" +
"stock_dispo as stock , prx_pm as pu , unite_mesure as mesure \n" +
"from stock_pl , matieres_p where not magasin = 'zone de decoupage' and not magasin = 'exterieur' and matieres_p.description = stock_pl.description \n" +
"union all \n" +
"select magasin as mag, f as f, sf as sf, produits_f.id as ref , produits_f.description as descrip , stock_dispo as stock , prx_pm as pu ,\n" +
"unite_m as mesure \n" +
"from stock_pl , produits_f where not magasin = 'zone de decoupage' and not magasin = 'exterieur' and produits_f.description = stock_pl.description \n" +
"union all \n" +
"select magasin as mag , '' as f , '' as sf , derive_pl.id as ref , derive_pl.produit as descrip , stock_dispo as stock , prx_pm as pu , \n" +
"'' as mesure \n" +
"from stock_pl , derive_pl where not magasin = 'zone de decoupage' and not magasin = 'exterieur' and derive_pl.produit = stock_pl.description \n" +
") as tab1 order by mag asc , descrip asc " ;
           
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql) ;
           jd.setQuery(newQuery) ;
           JasperReport jr = JasperCompileManager.compileReport(jd) ;
           
           HashMap para = new HashMap() ;
         
         // para.put("data", jrbean);
            para.put("op", "OP : "+this.login) ;  // this.login
            para.put("periode","LA PERIODE : "+this.dte1) ;
            para.put("zone", "LE POINT DE PLACEMENT : ") ;
            para.put("mtt", "TOTAL MONTANT : "+this.nf3.format(this.mtt)) ;
           
           
           JasperPrint j = JasperFillManager.fillReport(jr, para, DriverManager.getConnection(DB_URL,USER,PASS)) ;
          
           JasperViewer.viewReport(j , false) ;
           
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
      
            
        
        this.jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
             
        }
           
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EtatStock_PL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EtatStock_PL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EtatStock_PL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EtatStock_PL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EtatStock_PL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField h1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox placement;
    // End of variables declaration//GEN-END:variables
}
