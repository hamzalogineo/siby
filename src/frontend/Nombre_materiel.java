/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.ListeMateriel.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author hp
 */
public class Nombre_materiel extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
      Integer id;
      Integer categorie_id ;
      String image ;
      String etat ;
      Integer old_nbre ;
      
      String login ;
      
      private NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      
    public Nombre_materiel() {
        initComponents();
        
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
        
       
        
     
        
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
        
        
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm1.setRowCount(0) ;
        
        
        this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 8) ;
        
         
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
            setBackground(Color.gray);
            setForeground(Color.WHITE);
        } 
        
       
        
        
        if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
            
          
        return this;
        
    }   
});

      
            Connection conn = null ;
            Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
       
      
      
      String sql = null ;
      ResultSet rs = null ;
      
       
      
      
        DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         
   
      
       sql = "SELECT * , c_m.categorie as cate FROM materiel_l , c_m where NOT materiel_l.etat = 'NON' AND c_m.id = materiel_l.categorie order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        //  "ID", "CATEGORIE", "DESCRIPTION", "DIMENSION", "PRIX", "QTE MIN", "PRIX C", "CODE IMAGE", "ETAT", "NOMBRE"
            
           rs.getString("id") , rs.getString("cate") , rs.getString("description") , rs.getString("dimension") , rs.getString("prix") , rs.getString("qte_m") , rs.getString("prx_c") ,
           rs.getString("code_img") , rs.getString("etat"),rs.getInt("nombre")
         
        }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
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
        
          
       
       
        
        
        
        
    }

    public String getLogin() {
        return login;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        rech = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        rapport = new javax.swing.JTextPane();
        anbre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        reference = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        mr = new javax.swing.JTextPane();
        nbre = new javax.swing.JTextField();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GESTION NOMBRE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CATEGORIE", "DESCRIPTION", "DIMENSION", "PRIX", "QTE MIN", "PRIX C", "CODE IMAGE", "ETAT", "NOMBRE"
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(25);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(25);
            jTable1.getColumnModel().getColumn(1).setMinWidth(150);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(2).setMinWidth(250);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(250);
            jTable1.getColumnModel().getColumn(3).setMinWidth(75);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(4).setMinWidth(75);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(5).setMinWidth(0);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(6).setMinWidth(0);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(7).setMinWidth(75);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(8).setMinWidth(0);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(9).setMinWidth(75);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(9).setMaxWidth(75);
        }

        rech.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rechKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("RECHERCHER");

        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AJOUTER UN RAPPORT");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("MODIFIER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        rapport.setBackground(new java.awt.Color(102, 102, 102));
        rapport.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        rapport.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(rapport);

        anbre.setEditable(false);
        anbre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel3.setText("NOMBRE");

        jLabel4.setText("    ANCIEN NOMBRE");

        reference.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                referenceKeyReleased(evt);
            }
        });

        jLabel5.setText("ID");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("RAPPORT MATERIEL");

        jButton3.setBackground(new java.awt.Color(0, 51, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("IMPRIMER LISTE");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        mr.setEditable(false);
        mr.setBackground(new java.awt.Color(153, 153, 0));
        mr.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        mr.setForeground(new java.awt.Color(255, 255, 255));
        mr.setPreferredSize(new java.awt.Dimension(0, 0));
        jScrollPane4.setViewportView(mr);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rech, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nbre, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(anbre)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(anbre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(nbre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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

    private void rechKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechKeyReleased
        // TODO add your handling code here:
        
        
        
        
          String rech = this.rech.getText().trim().replaceAll("'", "''") ;
        
        if(rech.isEmpty()){
                
             Connection conn = null ;
             Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
       
      
      
      String sql = null ;
      ResultSet rs = null ;
      
     
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         
   
      
        sql = "SELECT * , c_m.categorie as cate FROM materiel_l , c_m where NOT materiel_l.etat = 'NON' AND c_m.id = materiel_l.categorie order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ID", "CATEGORIE", "DESCRIPTION", "DIMENSION", "PRIX", "QTE MIN", "PRIX C", "CODE IMAGE", "ETAT"
            
           rs.getString("id") , rs.getString("cate") , rs.getString("description") , rs.getString("dimension") , rs.getString("prix") , rs.getString("qte_m") , rs.getString("prx_c") ,
           rs.getString("code_img") , rs.getString("etat"), rs.getInt("nombre")
         
        }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
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
        
          
        }else{
            
             Connection conn = null ;
             Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
       
      
      
      String sql = null ;
      ResultSet rs = null ;
      
     
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         
   
      
     //   sql = "SELECT * FROM c_m where categorie like '%"+rech+"%' order by categorie asc" ;
      
       sql = "SELECT * , c_m.categorie as cate FROM materiel_l , c_m where description like '%"+rech+"%' and c_m.id = materiel_l.categorie order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ID", "CATEGORIE", "DESCRIPTION", "DIMENSION", "PRIX", "QTE MIN", "PRIX C", "CODE IMAGE", "ETAT"
            
           rs.getString("id") , rs.getString("cate") , rs.getString("description") , rs.getString("dimension") , rs.getString("prix") , rs.getString("qte_m") , rs.getString("prx_c") ,
           rs.getString("code_img") , rs.getString("etat"), rs.getInt("nombre")
         
        }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
        
        
        
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
        
          
            
            
              }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_rechKeyReleased

    private void referenceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_referenceKeyReleased
       
        // TODO add your handling code here :
       
       
          String rech = this.reference.getText().trim().replaceAll("'", "''") ;
        
        if(rech.isEmpty()){
                
             Connection conn = null ;
             Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
       
      
      
      String sql = null ;
      ResultSet rs = null ;
      
     
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         
   
      
        sql = "SELECT * , c_m.categorie as cate FROM materiel_l , c_m where NOT materiel_l.etat = 'NON' AND c_m.id = materiel_l.categorie order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ID", "CATEGORIE", "DESCRIPTION", "DIMENSION", "PRIX", "QTE MIN", "PRIX C", "CODE IMAGE", "ETAT"
            
           rs.getString("id") , rs.getString("cate") , rs.getString("description") , rs.getString("dimension") , rs.getString("prix") , rs.getString("qte_m") , rs.getString("prx_c") ,
           rs.getString("code_img") , rs.getString("etat"), rs.getInt("nombre")
         
        }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
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
        
          
        }else{
            
             Connection conn = null ;
             Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
       
      
      
      String sql = null ;
      ResultSet rs = null ;
      
     
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         
   
      
     //   sql = "SELECT * FROM c_m where categorie like '%"+rech+"%' order by categorie asc" ;
      
       sql = "SELECT * , c_m.categorie as cate FROM materiel_l , c_m where materiel_l.id like '%"+rech+"%' and c_m.id = materiel_l.categorie order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ID", "CATEGORIE", "DESCRIPTION", "DIMENSION", "PRIX", "QTE MIN", "PRIX C", "CODE IMAGE", "ETAT"
            
           rs.getString("id") , rs.getString("cate") , rs.getString("description") , rs.getString("dimension") , rs.getString("prix") , rs.getString("qte_m") , rs.getString("prx_c") ,
           rs.getString("code_img") , rs.getString("etat"), rs.getInt("nombre")
         
        }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
        
        
        
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
        
          
            
            
              }
        
        
        
        
        
        
        
    }//GEN-LAST:event_referenceKeyReleased

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        
        this.id = 0 ;
        this.image = "" ;
        this.etat = "" ;
        this.old_nbre = 0 ;
        
        
        this.etat = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 8).toString() ;
        
        
        this.id = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString()) ;
        this.image = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 7).toString() ;
        
        ImageIcon icon = new ImageIcon("\\\\192.168.1.117\\TEST_IMG_LOCATION\\"+this.image) ;
        
        this.img.setIcon(icon) ;
        
        
                   Connection conn = null ;
                   Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
       
 
      
      String sql = null ;
      ResultSet rs = null ;
    
      
       
         
   
      
       sql = "SELECT a_nombre , nombre , rapport, datej  FROM materiel_l  where id = "+this.id ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        this.anbre.setText(nf3.format(rs.getInt("a_nombre"))) ;
        this.mr.setText(rs.getString("rapport")) ;
        
        this.old_nbre = rs.getInt("nombre") ;
       
     }
      
    
   
      
     
      
      rs.close();
      
      
      this.nbre.setText(new String("")) ;
      
      
      
       
      
      
     
      
    
            
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
           
       
       
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
   // TODO add your handling code here :
   
        String nbre = "" ;
        nbre = this.nbre.getText() ;
               Integer nbre1 = 0 ;
        
        if(nbre.isEmpty() || this.jTable1.getSelectedRow() == -1){
            
              JOptionPane.showMessageDialog(null, "SAISIR UN NOMBRE DE MATERIEL SVP") ;
            
        }else{
               
               
               
               try{
                  
                   nbre1 = Integer.parseInt(nbre) ;
                   
                   Connection conn = null ;
                   Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
       
 
      
      String sql = null ;
      ResultSet rs = null ;
      
      String entete = "" ;
      String rapport = "" ;
       SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
       
       // sdf1.format(new Date())+" "+System.getProperty("line.separator")+"OP:"+this.login+" "+System.getProperty("line.separator") ;
        
      entete = sdf1.format(new Date())+""+System.getProperty("line.separator")+"OP:"+this.login+System.getProperty("line.separator")+"ANCIEN = "+this.old_nbre+" NOUVEAU = "+nbre1+" "+System.getProperty("line.separator")+"---------------------------"+System.getProperty("line.separator") ; 
      
      sql = "select rapport from materiel_l where id = "+this.id ; 
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          rapport = rs.getString("rapport") ;
      }
      
      rapport = rapport+" "+entete ;
      
      if(stmt.executeUpdate("update materiel_l set nombre = "+nbre1+" , a_nombre = "+this.old_nbre+" , rapport = '"+rapport+"'"
              + " where id = "+this.id) == 1){
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         
   
      
       sql = "SELECT * , c_m.categorie as cate FROM materiel_l , c_m where c_m.id = materiel_l.categorie order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ID", "CATEGORIE", "DESCRIPTION", "DIMENSION", "PRIX", "QTE MIN", "PRIX C", "CODE IMAGE", "ETAT"
            
           rs.getString("id") , rs.getString("cate") , rs.getString("description") , rs.getString("dimension") , rs.getString("prix") , rs.getString("qte_m") , rs.getString("prx_c") ,
           rs.getString("code_img") , rs.getString("etat"), rs.getInt("nombre")
         
        }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
    
   
      
      
      }
      
      rs.close();
      
      
      this.nbre.setText(new String("")) ;
      
      
      ImageIcon ic = new ImageIcon() ;
       this.img.setIcon(ic) ;
       
      
      
     
      
    
            
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
           
                   
                   
                   
               }catch(Exception e){
                   
                   JOptionPane.showMessageDialog(null, e.getMessage()) ;
                   
               }
        
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String entete = "" ;
        
        
        
        String rapport = "" ;
        String rapport_c = "" ;        
               
               
                   
                     Connection conn = null ;
                     Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
       
      String datej ;
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
      SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
      datej = sdf.format(new Date()) ;
 
      String oldRapport = "";
      
      String sql = null ;
      ResultSet rs = null ;
      
      sql = "select rapport from materiel_l where id = "+this.id ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          
          oldRapport = rs.getString("rapport") ;
      
        
          
      }
      
      
      rapport = this.rapport.getText().trim().replaceAll("'", "''")+""+System.getProperty("line.separator")+"---------------------------"+System.getProperty("line.separator")+oldRapport ;
      rapport_c = this.rapport.getText() ;
      
       if(rapport.isEmpty() || this.jTable1.getSelectedRow() == -1 || rapport_c.isEmpty()){
                   
                   JOptionPane.showMessageDialog(null, "SAISIR UN RAPPORT SVP") ;
                   
               }else{
      
      
      entete = sdf1.format(new Date())+""+System.getProperty("line.separator")+"OP:"+this.login+" "+System.getProperty("line.separator") ;
      
      if(stmt.executeUpdate("update materiel_l set rapport = '"+entete+""+rapport+"' , datej = '"+datej+"'"
              + " where id = "+this.id) == 1){
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         
   
      
       sql = "SELECT * , c_m.categorie as cate FROM materiel_l , c_m where c_m.id = materiel_l.categorie order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ID", "CATEGORIE", "DESCRIPTION", "DIMENSION", "PRIX", "QTE MIN", "PRIX C", "CODE IMAGE", "ETAT"
            
           rs.getString("id") , rs.getString("cate") , rs.getString("description") , rs.getString("dimension") , rs.getString("prix") , rs.getString("qte_m") , rs.getString("prx_c") ,
           rs.getString("code_img") , rs.getString("etat"), rs.getInt("nombre")
         
        }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
    
   
      
      
      }
      
      rs.close();
      
      
      this.nbre.setText(new String("")) ;
      
      
      ImageIcon ic = new ImageIcon() ;
       this.img.setIcon(ic) ;
       
      this.rapport.setText(""); this.mr.setText("") ;
      
     
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
           
                   
          
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        this.jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
        
                   Connection conn = null ;
                   Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
       
 
      
      String sql = null ;
      ResultSet rs = null ;
        
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\m_l_1.jrxml")) ;
            
          

            List mlist ;
            mlist = new ArrayList<>() ;
            
            
            sql = "select materiel_l.id as id ,materiel_l.description as description  , "
                    + "materiel_l.dimension as dimension , materiel_l.prix as prix, "
                    + "materiel_l.code_img as code_img , materiel_l.nombre as nombre ,c_m.categorie as cat from materiel_l , c_m where c_m.id = materiel_l.categorie order by description asc" ;
            
            rs = stmt.executeQuery(sql) ;
        
            while(rs.next()) {
                
                HashMap<String, Object> m = new HashMap<>();
                
                 
                m.put("id".toUpperCase(), nf3.format(rs.getInt("id"))) ;
                m.put("categorie".toUpperCase(), rs.getString("cat").toUpperCase()) ;
                m.put("description".toUpperCase(), rs.getString("description").toUpperCase()) ;
                m.put("dimension".toUpperCase(), rs.getString("dimension").toUpperCase());
                m.put("prix".toUpperCase(), nf3.format(rs.getInt("prix")));
                m.put("code image".toUpperCase(), rs.getString("code_img").toUpperCase());
                m.put("nombre".toUpperCase(), nf3.format(rs.getInt("nombre")));
                 
               
                
                mlist.add(m) ;
                
            }
            
            
         
             
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist) ;
             

            SimpleDateFormat sdf10 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
            
            Map<String, Object> para = new HashMap<>();
            
           // para.put("sql", jrbean);
            
          
           

            JasperReport report = JasperCompileManager.compileReport(in);
            
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print, false) ;
 
        
        // END FOR JASPERPRINT BON COMMANDE :
            
            
            
        
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
                   
        
        this.jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
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
            java.util.logging.Logger.getLogger(Nombre_materiel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nombre_materiel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nombre_materiel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nombre_materiel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nombre_materiel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anbre;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane mr;
    private javax.swing.JTextField nbre;
    private javax.swing.JTextPane rapport;
    private javax.swing.JTextField rech;
    private javax.swing.JTextField reference;
    // End of variables declaration//GEN-END:variables
}
