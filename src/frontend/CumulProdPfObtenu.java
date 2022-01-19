/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.CumulProdMp.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
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
public class CumulProdPfObtenu extends javax.swing.JFrame {

    /**
     * Creates new form CumulProdMp
     */
    
   
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
    
    String n1;
    String n2;
    String loging = "" ;
    
    public CumulProdPfObtenu() {
 
        initComponents();
        this.setLocationRelativeTo(null);
        
        
         Date jour = new Date() ;
        this.jDateChooser1.setDate(jour);
        this.h1.setText("00:00") ;
        this.jDateChooser2.setDate(jour) ;
        this.h2.setText("23:59") ;
        
        //
       
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
        
       
        
     
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
        
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm.setRowCount(0) ;
        
         Connection conn = null ;
         Statement stmt = null ;
       
       try{
      Class.forName(JDBC_DRIVER);
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      
     String sql ;
      // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
       sql = "SELECT * FROM productaire WHERE NOT type = 'oui' ORDER BY producteur ASC" ;
       ResultSet rs = stmt.executeQuery(sql) ;
    
       while(rs.next()){
        
        
      this.jComboBox1.addItem(rs.getString("productaire.producteur"))  ;
    
         
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
        
        
        
        
       
       
    }
    
    
    private void clear() {

        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        int n = model.getRowCount();
        for (int i = n - 1; i >= 0; --i) {
            model.removeRow(i);
        }
        
    }  

    public void setLoging(String loging) {
        this.loging = loging;
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
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        profil = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        h1 = new javax.swing.JFormattedTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        h2 = new javax.swing.JFormattedTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CUMUL PRODUIT FINI");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setText("RECHERCHER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("DU :");

        jLabel4.setText("AU :");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton3.setText("IMPRIMER");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("TOTAL PROFIT CFA");

        profil.setEditable(false);

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FAMILLES", "SOUS FAMILLES", "N°", "DESCRIPTION", "QTE OBTENUE.", "P.A", "P.U", "T P A", "T P V", "Marge T"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(20);
        }

        h1.setText("00");

        h2.setText("00");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir producteur", "TOUS LES PRODUCTEURS" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.setMinimumSize(new java.awt.Dimension(134, 20));
        jComboBox1.setPreferredSize(new java.awt.Dimension(134, 20));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("IMPRIMER SON COMPTE");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("GESTION PRODUCTEUR");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("TOUT PRODUCTEUR");
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(profil, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(h1)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(h2)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(416, 416, 416))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        
        // ici moi :
        
          // ici moi :
        
           if("    -  -     ".equalsIgnoreCase(this.n1) && "    -  -     ".equalsIgnoreCase(this.n2)) {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner les deux dates svp") ;
        } else {
         try{
             
             /*
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS); 
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY); 
            ResultSet resultat = statement.executeQuery("SELECT f as f, sf as sf , idpro as idpro, article as desi, sum(qte) as qte, pa as pa, pu as pv, mu as mu,sum(profil) as profil FROM prodmp WHERE dtec BETWEEN '"+this.n1+"' AND '"+this.n2+"' GROUP BY sf ORDER BY f") ;
            
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\cumulsventeMP.jrxml")) ;
            
            //InputStream in = new FileInputStream(new File("C:\\Users\\IDRIS\\Desktop\\SIBY ARS FINALE V2\\UtpaSibyCenter\\src\\reports\\cumulsvente.jrxml")) ;
           
            long total = 0 ;
            long totalfinal = 0 ;
            NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
            
            List mlist;
            mlist = new ArrayList<>();
            
            while(resultat.next()) {
                HashMap<String, Object> m = new HashMap<>(); 
                m.put("f", resultat.getString("f"));
                m.put("sf", resultat.getString("sf"));
                m.put("idpro", resultat.getInt("idpro"));  
                m.put("desi", resultat.getString("desi"));
                m.put("qte", resultat.getInt("qte"));
                m.put("pa", resultat.getInt("pa"));
                m.put("pv", resultat.getInt("pv"));
                m.put("mu", resultat.getInt("mu"));
                m.put("profil", resultat.getInt("profil"));
                total = resultat.getInt("profil");
                m.put("total", nf3.format(total));
                totalfinal += total;
                m.put("totalfinal", nf3.format(totalfinal));
                mlist.add(m);
                
                
                m.put("du", this.n1) ;
                m.put("au", this.n2) ;
                
            }
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("sql", jrbean);
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print , false);
             
             */
             
             
              
          
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS); 
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY); 
            ResultSet rs = statement.executeQuery(""
                    + "SELECT * , sum(qte) FROM prodpf , produits_f WHERE (prodpf.dtec BETWEEN '"+this.n1+"' AND '"+this.n2+"') "
              + "AND "
              + ""
              + "produits_f.description = article GROUP BY article "
              + "ORDER BY prodpf.f ASC , prodpf.sf ASC , article ASC") ;
            
            
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\cumulyaya01.jrxml")) ;
            
            
            //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\venteArticles.jrxml")) ;
            
            long total = 0 ;
            
            
            List mlist;
            mlist = new ArrayList<>();
            
            while(rs.next()){
                
                
                if("oui".equalsIgnoreCase(rs.getString("unite_m"))){
                        
                    HashMap<String, Object> m = new HashMap<>(); 
                    m.put("idpro", rs.getLong("idpro"));
                    m.put("article", rs.getString("article"));
                    m.put("qte", rs.getLong("sum(qte)"));
                    m.put("pa", rs.getLong("pa"));
                    m.put("pu", rs.getLong("pu"));
                    m.put("f", rs.getString("f"));
                    m.put("sf", rs.getString("sf"));
                    m.put("tpa", Math.round(((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pa"))));
                    m.put("tpv", Math.round(((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pu"))));
                    m.put("marget", (Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pu")) - Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pa"))));
                   
                     
                    mlist.add(m);
                    
                    
            
        }else{
                    
                    HashMap<String, Object> m = new HashMap<>(); 
                    m.put("idpro", rs.getLong("idpro"));
                    m.put("article", rs.getString("article"));
                    m.put("qte", rs.getLong("sum(qte)"));
                    m.put("pa", rs.getLong("pa"));
                    m.put("pu", rs.getLong("pu"));
                    m.put("f", rs.getString("f"));
                    m.put("sf", rs.getString("sf"));
                    m.put("tpa", (rs.getLong("sum(qte)") * rs.getLong("pa")));
                    m.put("tpv", (rs.getLong("sum(qte)") * rs.getLong("pu")));
                    m.put("marget", ((rs.getLong("sum(qte)") * rs.getLong("pu")) - (rs.getLong("sum(qte)") * rs.getLong("pa"))));
                   
                     
                    mlist.add(m);
                    
      
            }
           
            }
            
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("data", jrbean);
        //  para.put("user", this.admin);
            para.put("du", this.n1) ;
            para.put("au", this.n2) ;
            para.put("producteur", " ") ;
            para.put("cumul", "PRODUITS FINIS") ;
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print, false);
          //  JasperPrintManager.printReport(print, false) ;
            
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       }   
        }
        
      //  end :
        
        
        /*
          if("    -  -     ".equalsIgnoreCase(this.n1) && "    -  -     ".equalsIgnoreCase(this.n2)) {
            JOptionPane.showMessageDialog(this, "Veuillez saisir les deux dates svp") ;
        } else {
         try{
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS); 
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY); 
            ResultSet resultat = statement.executeQuery("SELECT f as f, sf as sf , idpro as idpro, desi as desi, sum(qte) as qte, pa as pa, pv as pv, mu as mu,sum(profil) as profil FROM cumulvente WHERE periode BETWEEN '"+this.n1+"' AND '"+this.n2+"' GROUP BY sf");
            
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\cumulsvente.jrxml")) ;
            
            //InputStream in = new FileInputStream(new File("C:\\Users\\IDRIS\\Desktop\\SIBY ARS FINALE V2\\UtpaSibyCenter\\src\\reports\\cumulsvente.jrxml")) ;
           
            long total = 0 ;
            long totalfinal = 0;
            NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
            
            List mlist;
            mlist = new ArrayList<>();
            
            while(resultat.next()) {
                HashMap<String, Object> m = new HashMap<>(); 
                m.put("f", resultat.getString("f"));
                m.put("sf", resultat.getString("sf"));
                m.put("idpro", resultat.getInt("idpro"));  
                m.put("desi", resultat.getString("desi"));
                m.put("qte", resultat.getInt("qte"));
                m.put("pa", resultat.getInt("pa"));
                m.put("pv", resultat.getInt("pv"));
                m.put("mu", resultat.getInt("mu"));
                m.put("profil", resultat.getInt("profil"));
                total = resultat.getInt("profil");
                m.put("total", nf3.format(total));
                totalfinal += total;
                m.put("totalfinal", nf3.format(totalfinal));
                mlist.add(m);
            }
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("sql", jrbean);
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print , false);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       }   
        }
        */
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        //
        
         try{
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate()) ;
        String dte2 = sdf.format(this.jDateChooser2.getDate()) ; 
            
            
        this.n1 = dte1+" "+this.h1.getText() ;
        System.out.println(this.n1) ;
        this.n2 = dte2+" "+this.h2.getText() ;
        
         NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
     
         Connection conn = null ;
         Statement stmt = null ;
       
       try{
      Class.forName(JDBC_DRIVER);
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      
          clear() ;
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         long pro = 0 ;
         
      String sql ;
      // "FAMILLES", "SOUS FAMILLES", "N°", "DESCRIPTION", "QTE VENDU.", "P.A", "P.U", "M.U", "PROFIL"
      
      sql = "SELECT * , sum(qte) FROM prodpf , produits_f WHERE (prodpf.dtec BETWEEN '"+this.n1+"' AND '"+this.n2+"') "
              + ""
              + "AND "
              + "  produits_f.description = article GROUP BY article , prodpf.f , prodpf.sf "
              + "ORDER BY prodpf.f ASC , prodpf.sf ASC , article ASC " ;
      
       ResultSet rs = stmt.executeQuery(sql);
    
       while(rs.next()){
            
           
        if("oui".equalsIgnoreCase(rs.getString("unite_m"))){

             dtm.addRow(new Object[]{
            
    // "FAMILLES", "SOUS FAMILLES", "N°", "DESCRIPTION", "QTE UTILISEE.", "P.A", "P.U", "M.U", "PROFIT"
            
       rs.getString("f") , rs.getString("sf")  , rs.getLong("idpro") , rs.getString("article") , rs.getLong("sum(qte)") ,
       rs.getLong("pa") , rs.getLong("pu") , nf3.format(Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pa"))) , 
       nf3.format(Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pu"))) ,
       nf3.format((Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pu")) - Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pa"))))
          
        });
               
         pro += (Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pu")) - Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pa"))) ;
         
            
        }else{
        dtm.addRow(new Object[]{
            
    // "FAMILLES", "SOUS FAMILLES", "N°", "DESCRIPTION", "QTE UTILISEE.", "P.A", "P.U", "M.U", "PROFIT"
            
       rs.getString("f") , rs.getString("sf")  , rs.getLong("idpro") , rs.getString("article") , rs.getLong("sum(qte)") ,
       rs.getLong("pa") , rs.getLong("pu") , nf3.format((rs.getLong("sum(qte)") * rs.getLong("pa"))) , 
       nf3.format((rs.getLong("sum(qte)") * rs.getLong("pu"))) ,
       nf3.format(((rs.getLong("sum(qte)") * rs.getLong("pu")) - (rs.getLong("sum(qte)") * rs.getLong("pa"))))
          
        });
               
         pro += ((rs.getLong("sum(qte)") * rs.getLong("pu")) - (rs.getLong("sum(qte)") * rs.getLong("pa"))) ;
         
       }
        
    
       
       }
       
       this.profil.setText(nf3.format(pro)) ;
       
       
      rs.close() ;
      stmt.close() ;
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
 
       }catch(Exception e){
           
       } 
         
        
        //
        
        
        
        /*
        
           this.n1 = du.getText();
         this.n2 = au.getText();
         NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
         
        if("    -  -     ".equalsIgnoreCase(this.n1) && "    -  -     ".equalsIgnoreCase(this.n2)){
            JOptionPane jp=new JOptionPane() ;
           jp.showMessageDialog(null,"Veuillez saisir les deux dates svp","Avertissement",JOptionPane.WARNING_MESSAGE);  
            
} else {
            
         Connection conn = null ;
         Statement stmt = null ;
       
       try{
      Class.forName(JDBC_DRIVER);
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      
      jTable1.setModel(new javax.swing.table.DefaultTableModel(
       new Object [][] {
                                
     },
    new String [] {
          "FAMILLES", "SOUS FAMILLES", "N°", "DESCRIPTION", "QTE VENDU.", "P.A", "P.U", "M.U", "PROFIL"
        })
) ;    
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         long pro = 0 ;
         
      String sql ;
      // "FAMILLES", "SOUS FAMILLES", "N°", "DESCRIPTION", "QTE VENDU.", "P.A", "P.U", "M.U", "PROFIL"
      sql = "SELECT f,sf,idpro,desi,sum(qte),pa,pv,mu,sum(profil) FROM cumulvente WHERE (periode BETWEEN '"+this.n1+"' AND '"+this.n2+"') GROUP BY sf";
       ResultSet rs = stmt.executeQuery(sql);
    
       while(rs.next()){
        
        dtm.addRow(new Object[]{
            
    // "FAMILLES", "SOUS FAMILLES", "N°", "DESCRIPTION", "QTE VENDU.", "P.A", "P.U", "M.U", "PROFIL"
            
       rs.getString("f") , rs.getString("sf")  , rs.getLong("idpro") , rs.getString("desi") , rs.getLong("sum(qte)") ,
       rs.getLong("pa") , rs.getLong("pv") , rs.getLong("mu") , nf3.format(rs.getLong("sum(profil)"))
          
        });
               
         pro += rs.getLong("sum(profil)") ;
        
     }
       
       
       
       this.profil.setText(nf3.format(pro)) ;
       
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
 }
        
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        if("    -  -     ".equalsIgnoreCase(this.n1) && "    -  -     ".equalsIgnoreCase(this.n2)) {
            JOptionPane.showMessageDialog(this, "Veuillez saisir les deux dates svp") ;
        } else {
         try{
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS); 
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY); 
            ResultSet resultat = statement.executeQuery("SELECT f as f, sf as sf , idpro as idpro, desi as desi, sum(qte) as qte, pa as pa, pv as pv, mu as mu,sum(profil) as profil FROM cumulvente WHERE periode BETWEEN '"+this.n1+"' AND '"+this.n2+"' GROUP BY sf");
            
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\cumulsvente.jrxml")) ;
            
            //InputStream in = new FileInputStream(new File("C:\\Users\\IDRIS\\Desktop\\SIBY ARS FINALE V2\\UtpaSibyCenter\\src\\reports\\cumulsvente.jrxml")) ;
           
            long total = 0 ;
            long totalfinal = 0;
            NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
            
            List mlist;
            mlist = new ArrayList<>();
            
            while(resultat.next()) {
                HashMap<String, Object> m = new HashMap<>(); 
                m.put("f", resultat.getString("f"));
                m.put("sf", resultat.getString("sf"));
                m.put("idpro", resultat.getInt("idpro"));  
                m.put("desi", resultat.getString("desi"));
                m.put("qte", resultat.getInt("qte"));
                m.put("pa", resultat.getInt("pa"));
                m.put("pv", resultat.getInt("pv"));
                m.put("mu", resultat.getInt("mu"));
                m.put("profil", resultat.getInt("profil"));
                total = resultat.getInt("profil");
                m.put("total", nf3.format(total));
                totalfinal += total;
                m.put("totalfinal", nf3.format(totalfinal));
                mlist.add(m);
            }
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("sql", jrbean);
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print , false);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       }   
        }
        
        */
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        GestProduct gp = new GestProduct() ;
        gp.setLogin(loging) ;
        gp.setVisible(true) ;
        
        
    }//GEN-LAST:event_jButton5ActionPerformed
Integer idp = 0 ;
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
        String combo = this.jComboBox1.getSelectedItem().toString().replaceAll("'", "''") ;
        
        if(combo.equals("Choisir producteur")){
            JOptionPane.showMessageDialog(this, "Choisir un producteur") ;
        }else{
                 if(combo.equals("TOUS LES PRODUCTEURS")){
                         try{
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate()) ;
        String dte2 = sdf.format(this.jDateChooser2.getDate()) ; 
            
            
        this.n1 = dte1+" "+this.h1.getText() ;
        System.out.println(this.n1) ;
        this.n2 = dte2+" "+this.h2.getText() ;
        
         NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
     
         Connection conn = null ;
         Statement stmt = null ;
       
       try{
      Class.forName(JDBC_DRIVER);
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      this.idp = 0 ;
      
        String sql0 ;
      // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
       sql0 = "SELECT distinct id FROM productaire WHERE producteur = '"+combo+"'" ;
       ResultSet rs0 = stmt.executeQuery(sql0) ;
    
       while(rs0.next()){
           
      this.idp = rs0.getInt("id") ;
      
         
     }
        
      
      
      
          clear() ;
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         long pro = 0 ;
         
      String sql ;
      // "FAMILLES", "SOUS FAMILLES", "N°", "DESCRIPTION", "QTE VENDU.", "P.A", "P.U", "M.U", "PROFIL"
      
      sql = "SELECT * , sum(qte) FROM prodpf , produits_f WHERE (prodpf.dtec BETWEEN '"+this.n1+"' AND '"+this.n2+"') "
              + "AND "
              + "  produits_f.description = article GROUP BY article , prodpf.f , prodpf.sf "
              + "ORDER BY prodpf.f ASC , prodpf.sf ASC , article ASC " ;
      
       ResultSet rs = stmt.executeQuery(sql);
    
       while(rs.next()){
        if("oui".equalsIgnoreCase(rs.getString("unite_m"))){

             dtm.addRow(new Object[]{
            
    // "FAMILLES", "SOUS FAMILLES", "N°", "DESCRIPTION", "QTE UTILISEE.", "P.A", "P.U", "M.U", "PROFIT"
            
       rs.getString("f") , rs.getString("sf")  , rs.getLong("idpro") , rs.getString("article") , rs.getLong("sum(qte)") ,
       rs.getLong("pa") , rs.getLong("pu") , nf3.format(Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pa"))) , 
       nf3.format(Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pu"))) ,
       nf3.format((Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pu")) - Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pa"))))
          
        });
               
         pro += (Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pu")) - Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pa"))) ;
         
            
        }else{
        dtm.addRow(new Object[]{
            
    // "FAMILLES", "SOUS FAMILLES", "N°", "DESCRIPTION", "QTE UTILISEE.", "P.A", "P.U", "M.U", "PROFIT"
            
       rs.getString("f") , rs.getString("sf")  , rs.getLong("idpro") , rs.getString("article") , rs.getLong("sum(qte)") ,
       rs.getLong("pa") , rs.getLong("pu") , nf3.format((rs.getLong("sum(qte)") * rs.getLong("pa"))) , 
       nf3.format((rs.getLong("sum(qte)") * rs.getLong("pu"))) ,
       nf3.format(((rs.getLong("sum(qte)") * rs.getLong("pu")) - (rs.getLong("sum(qte)") * rs.getLong("pa"))))
          
        });
               
         pro += ((rs.getLong("sum(qte)") * rs.getLong("pu")) - (rs.getLong("sum(qte)") * rs.getLong("pa"))) ;
         
        }
        
     }
       
       
       
       this.profil.setText(nf3.format(pro)) ;
       
       
      rs.close() ;
      stmt.close() ;
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
 
       }catch(Exception e){
           
       } 
            
                 }else{
            
             try{
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate()) ;
        String dte2 = sdf.format(this.jDateChooser2.getDate()) ; 
            
            
        this.n1 = dte1+" "+this.h1.getText() ;
        System.out.println(this.n1) ;
        this.n2 = dte2+" "+this.h2.getText() ;
        
         NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
     
         Connection conn = null ;
         Statement stmt = null ;
       
       try{
      Class.forName(JDBC_DRIVER);
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      this.idp = 0 ;
      
        String sql0 ;
      // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
       sql0 = "SELECT distinct id FROM productaire WHERE producteur = '"+combo+"'" ;
       ResultSet rs0 = stmt.executeQuery(sql0) ;
    
       while(rs0.next()){
           
      this.idp = rs0.getInt("id") ;
      
         
     }
        
      
      
      
          clear() ;
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         long pro = 0 ;
         
      String sql ;
      // "FAMILLES", "SOUS FAMILLES", "N°", "DESCRIPTION", "QTE VENDU.", "P.A", "P.U", "M.U", "PROFIL"
      
      sql = "SELECT * , sum(qte) FROM prodpf , produits_f , productaire WHERE (prodpf.dtec BETWEEN '"+this.n1+"' AND '"+this.n2+"') "
              + "AND prodpf.producteur = "+this.idp+" "
              + "AND "
              + "  produits_f.description = article AND productaire.id = prodpf.producteur GROUP BY article , prodpf.f , prodpf.sf "
              + "ORDER BY prodpf.f ASC , prodpf.sf ASC , article ASC " ;
      
       ResultSet rs = stmt.executeQuery(sql);
    
       while(rs.next()){
        if("oui".equalsIgnoreCase(rs.getString("unite_m"))){

             dtm.addRow(new Object[]{
            
    // "FAMILLES", "SOUS FAMILLES", "N°", "DESCRIPTION", "QTE UTILISEE.", "P.A", "P.U", "M.U", "PROFIT"
            
       rs.getString("f") , rs.getString("sf")  , rs.getLong("idpro") , rs.getString("article") , rs.getLong("sum(qte)") ,
       rs.getLong("pa") , rs.getLong("pu") , nf3.format(Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pa"))) , 
       nf3.format(Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pu"))) ,
       nf3.format((Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pu")) - Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pa"))))
          
        });
               
         pro += (Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pu")) - Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pa"))) ;
         
            
        }else{
        dtm.addRow(new Object[]{
            
    // "FAMILLES", "SOUS FAMILLES", "N°", "DESCRIPTION", "QTE UTILISEE.", "P.A", "P.U", "M.U", "PROFIT"
            
       rs.getString("f") , rs.getString("sf")  , rs.getLong("idpro") , rs.getString("article") , rs.getLong("sum(qte)") ,
       rs.getLong("pa") , rs.getLong("pu") , nf3.format((rs.getLong("sum(qte)") * rs.getLong("pa"))) , 
       nf3.format((rs.getLong("sum(qte)") * rs.getLong("pu"))) ,
       nf3.format(((rs.getLong("sum(qte)") * rs.getLong("pu")) - (rs.getLong("sum(qte)") * rs.getLong("pa"))))
          
        });
               
         pro += ((rs.getLong("sum(qte)") * rs.getLong("pu")) - (rs.getLong("sum(qte)") * rs.getLong("pa"))) ;
         
        }
        
     }
       
       
       
       this.profil.setText(nf3.format(pro)) ;
       
       
      rs.close() ;
      stmt.close() ;
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
 
       }catch(Exception e){
           
       } 
                 }
            
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
         // ici moi :
        
          // ici moi :
        
         String combo = this.jComboBox1.getSelectedItem().toString().replaceAll("'", "''") ;
        
        if(combo.equals("TOUS LES PRODUCTEURS")){
            
            if("    -  -     ".equalsIgnoreCase(this.n1) && "    -  -     ".equalsIgnoreCase(this.n2)) {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner les deux dates svp") ;
        } else {
         try{
             
             /*
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS); 
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY); 
            ResultSet resultat = statement.executeQuery("SELECT f as f, sf as sf , idpro as idpro, article as desi, sum(qte) as qte, pa as pa, pu as pv, mu as mu,sum(profil) as profil FROM prodmp WHERE dtec BETWEEN '"+this.n1+"' AND '"+this.n2+"' GROUP BY sf ORDER BY f") ;
            
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\cumulsventeMP.jrxml")) ;
            
            //InputStream in = new FileInputStream(new File("C:\\Users\\IDRIS\\Desktop\\SIBY ARS FINALE V2\\UtpaSibyCenter\\src\\reports\\cumulsvente.jrxml")) ;
           
            long total = 0 ;
            long totalfinal = 0 ;
            NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
            
            List mlist;
            mlist = new ArrayList<>();
            
            while(resultat.next()) {
                HashMap<String, Object> m = new HashMap<>(); 
                m.put("f", resultat.getString("f"));
                m.put("sf", resultat.getString("sf"));
                m.put("idpro", resultat.getInt("idpro"));  
                m.put("desi", resultat.getString("desi"));
                m.put("qte", resultat.getInt("qte"));
                m.put("pa", resultat.getInt("pa"));
                m.put("pv", resultat.getInt("pv"));
                m.put("mu", resultat.getInt("mu"));
                m.put("profil", resultat.getInt("profil"));
                total = resultat.getInt("profil");
                m.put("total", nf3.format(total));
                totalfinal += total;
                m.put("totalfinal", nf3.format(totalfinal));
                mlist.add(m);
                
                
                m.put("du", this.n1) ;
                m.put("au", this.n2) ;
                
            }
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("sql", jrbean);
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print , false);
             
             */
             
             
              
          
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS); 
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY); 
            ResultSet rs = statement.executeQuery(""
                    + "SELECT * , sum(qte) FROM prodpf , produits_f WHERE (prodpf.dtec BETWEEN '"+this.n1+"' AND '"+this.n2+"') "
              + "AND "
              + "  produits_f.description = article GROUP BY article , prodpf.f , prodpf.sf "
              + "ORDER BY prodpf.f ASC , prodpf.sf ASC , article ASC ") ;
            
            
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\cumulyaya01.jrxml")) ;
            
            
            //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\venteArticles.jrxml")) ;
            
            long total = 0 ;
            
            
            List mlist;
            mlist = new ArrayList<>();
            
            while(rs.next()){
                
                 if(rs.getLong("sum(qte)") <= 0){
               
           }else if(rs.getLong("sum(qte)") > 0){
           
                
                if("oui".equalsIgnoreCase(rs.getString("unite_m"))){
                        
                    HashMap<String, Object> m = new HashMap<>(); 
                    m.put("idpro", rs.getLong("idpro"));
                    m.put("article", rs.getString("article"));
                    m.put("qte", rs.getLong("sum(qte)"));
                    m.put("pa", rs.getLong("pa"));
                    m.put("pu", rs.getLong("pu"));
                    m.put("f", rs.getString("f"));
                    m.put("sf", rs.getString("sf"));
                    m.put("tpa", Math.round(((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pa"))));
                    m.put("tpv", Math.round(((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pu"))));
                    m.put("marget", (Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pu")) - Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pa"))));
                   
                     
                    mlist.add(m);
                    
                    
            
        }else{
                    
                    HashMap<String, Object> m = new HashMap<>(); 
                    m.put("idpro", rs.getLong("idpro"));
                    m.put("article", rs.getString("article"));
                    m.put("qte", rs.getLong("sum(qte)"));
                    m.put("pa", rs.getLong("pa"));
                    m.put("pu", rs.getLong("pu"));
                    m.put("f", rs.getString("f"));
                    m.put("sf", rs.getString("sf"));
                    m.put("tpa", (rs.getLong("sum(qte)") * rs.getLong("pa")));
                    m.put("tpv", (rs.getLong("sum(qte)") * rs.getLong("pu")));
                    m.put("marget", ((rs.getLong("sum(qte)") * rs.getLong("pu")) - (rs.getLong("sum(qte)") * rs.getLong("pa"))));
                   
                     
                    mlist.add(m);
                    
      
            }
          
            }
            }
            
            
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("data", jrbean);
        //  para.put("user", this.admin);
            para.put("du", this.n1) ;
            para.put("au", this.n2) ;
            para.put("producteur", "Producteur : "+this.jComboBox1.getSelectedItem().toString()) ;
            para.put("cumul", "PRODUITS FINIS") ;
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print, false);
          //  JasperPrintManager.printReport(print, false) ;
            
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       }   
        }
        
      //  end :
        
            
        }else{
            
            if("    -  -     ".equalsIgnoreCase(this.n1) && "    -  -     ".equalsIgnoreCase(this.n2)) {
            JOptionPane.showMessageDialog(this, "Veuillez selectionner les deux dates svp") ;
        } else {
         try{
             
             /*
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS); 
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY); 
            ResultSet resultat = statement.executeQuery("SELECT f as f, sf as sf , idpro as idpro, article as desi, sum(qte) as qte, pa as pa, pu as pv, mu as mu,sum(profil) as profil FROM prodmp WHERE dtec BETWEEN '"+this.n1+"' AND '"+this.n2+"' GROUP BY sf ORDER BY f") ;
            
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\cumulsventeMP.jrxml")) ;
            
            //InputStream in = new FileInputStream(new File("C:\\Users\\IDRIS\\Desktop\\SIBY ARS FINALE V2\\UtpaSibyCenter\\src\\reports\\cumulsvente.jrxml")) ;
           
            long total = 0 ;
            long totalfinal = 0 ;
            NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
            
            List mlist;
            mlist = new ArrayList<>();
            
            while(resultat.next()) {
                HashMap<String, Object> m = new HashMap<>(); 
                m.put("f", resultat.getString("f"));
                m.put("sf", resultat.getString("sf"));
                m.put("idpro", resultat.getInt("idpro"));  
                m.put("desi", resultat.getString("desi"));
                m.put("qte", resultat.getInt("qte"));
                m.put("pa", resultat.getInt("pa"));
                m.put("pv", resultat.getInt("pv"));
                m.put("mu", resultat.getInt("mu"));
                m.put("profil", resultat.getInt("profil"));
                total = resultat.getInt("profil");
                m.put("total", nf3.format(total));
                totalfinal += total;
                m.put("totalfinal", nf3.format(totalfinal));
                mlist.add(m);
                
                
                m.put("du", this.n1) ;
                m.put("au", this.n2) ;
                
            }
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("sql", jrbean);
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print , false);
             
             */
             
             
              
          
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS); 
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY); 
            ResultSet rs = statement.executeQuery(""
                    + "SELECT * , sum(qte) FROM prodpf , produits_f , productaire WHERE (prodpf.dtec BETWEEN '"+this.n1+"' AND '"+this.n2+"') "
              + "AND prodpf.producteur = "+this.idp+" "
              + "AND "
              + "  produits_f.description = article AND productaire.id = prodpf.producteur GROUP BY article , prodpf.f , prodpf.sf "
              + "ORDER BY prodpf.f ASC , prodpf.sf ASC , article ASC ") ;
            
            
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\cumulyaya01.jrxml")) ;
            
            
            //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\venteArticles.jrxml")) ;
            
            long total = 0 ;
            
            
            List mlist;
            mlist = new ArrayList<>();
            
            while(rs.next()){
                 if(rs.getLong("sum(qte)") <= 0){
               
           }else if(rs.getLong("sum(qte)") > 0){
           
                if("oui".equalsIgnoreCase(rs.getString("unite_m"))){
                        
                    HashMap<String, Object> m = new HashMap<>(); 
                    m.put("idpro", rs.getLong("idpro"));
                    m.put("article", rs.getString("article"));
                    m.put("qte", rs.getLong("sum(qte)"));
                    m.put("pa", rs.getLong("pa"));
                    m.put("pu", rs.getLong("pu"));
                    m.put("f", rs.getString("f"));
                    m.put("sf", rs.getString("sf"));
                    m.put("tpa", Math.round(((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pa"))));
                    m.put("tpv", Math.round(((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pu"))));
                    m.put("marget", (Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pu")) - Math.round((rs.getLong("sum(qte)")/1000.0) * rs.getLong("pa"))));
                   
                     
                    mlist.add(m);
                    
                    
            
        }else{
                    
                    HashMap<String, Object> m = new HashMap<>(); 
                    m.put("idpro", rs.getLong("idpro"));
                    m.put("article", rs.getString("article"));
                    m.put("qte", rs.getLong("sum(qte)"));
                    m.put("pa", rs.getLong("pa"));
                    m.put("pu", rs.getLong("pu"));
                    m.put("f", rs.getString("f"));
                    m.put("sf", rs.getString("sf"));
                    m.put("tpa", (rs.getLong("sum(qte)") * rs.getLong("pa")));
                    m.put("tpv", (rs.getLong("sum(qte)") * rs.getLong("pu")));
                    m.put("marget", ((rs.getLong("sum(qte)") * rs.getLong("pu")) - (rs.getLong("sum(qte)") * rs.getLong("pa"))));
                   
                     
                    mlist.add(m);
                    
      
            }
          
            }
            }
            
            
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("data", jrbean);
        //  para.put("user", this.admin);
            para.put("du", this.n1) ;
            para.put("au", this.n2) ;
            para.put("producteur", "Producteur : "+this.jComboBox1.getSelectedItem().toString()) ;
            para.put("cumul", "PRODUITS FINIS") ;
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean ) ;//new JREmptyDataSource());
            JasperViewer.viewReport(print, false);
          //  JasperPrintManager.printReport(print, false) ;
            
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       }   
        }
        
      //  end :
        
        
        }
        
           
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jCheckBox1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseReleased
        // TODO add your handling code here:
        
        
        if(this.jCheckBox1.isSelected()){
            
            this.jComboBox1.removeAllItems();
            /*
            Choisir producteur
            TOUS LES PRODUCTEURS
            */
            this.jComboBox1.addItem(new String("Choisir producteur")) ;
            this.jComboBox1.addItem(new String("TOUS LES PRODUCTEURS"));
            
            
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
        
        
      this.jComboBox1.addItem(rs.getString("productaire.producteur"))  ;
    
         
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
            
        }else{
            
               this.jComboBox1.removeAllItems();
            /*
            Choisir producteur
            TOUS LES PRODUCTEURS
            */
            this.jComboBox1.addItem(new String("Choisir producteur")) ;
            this.jComboBox1.addItem(new String("TOUS LES PRODUCTEURS"));
            
            
              Connection conn = null ;
              Statement stmt = null ;
       
       try{
      Class.forName(JDBC_DRIVER);
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      
     String sql ;
      // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
       sql = "SELECT * FROM productaire WHERE NOT type = 'oui' ORDER BY producteur ASC" ;
       ResultSet rs = stmt.executeQuery(sql) ;
    
       while(rs.next()){
        
        
      this.jComboBox1.addItem(rs.getString("productaire.producteur"))  ;
    
         
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
            
            
        }
        
        
        
        
    }//GEN-LAST:event_jCheckBox1MouseReleased

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
            java.util.logging.Logger.getLogger(CumulProdPfObtenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CumulProdPfObtenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CumulProdPfObtenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CumulProdPfObtenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CumulProdPfObtenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField h1;
    private javax.swing.JFormattedTextField h2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField profil;
    // End of variables declaration//GEN-END:variables
}
