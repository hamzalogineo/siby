/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.Decoupage.JDBC_DRIVER;
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
import java.util.Random;
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
public class Envoi_op_fini extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
      Integer cb_op ;
      Integer cb ;
      String  description ;
      Integer nbp_pl = 0 ;
      Integer nbp_ob = 0 ;
      long    pu_p ;
      long    mtt ;
      String  arriver ;
      String  perso ;
      String  datej ;
      String  login ;
      Integer solde = 0 ;
      String  role ;
      Integer vy = 0 ;
      
      List bonList = new ArrayList() ;
      
      
    public Envoi_op_fini() {
        initComponents();
    }
    
    
     public Envoi_op_fini(String login , Integer cb_op){
        initComponents();
        this.login = login ;
        this.cb_op = cb_op ;
        
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
        
               Connection conn = null ;
               Statement  stmt = null  ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...") ;
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
         SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
         NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      
      /*
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      
      --------------------------------------------- variables global ---------------------------------
      
      Integer cb_op ;
      Integer cb ;
      String  description ;
      Integer nbp_pl ;
      long    pu_p ;
      long    mtt ;
      String  arriver ;
      String  perso ;
      String  datej ;
      String  login ;
      Integer solde ;
      String  role ;
      
      
      */
      
  
      String sql ;
             sql = "select * from portions where cb_op = "+this.cb_op ;
      ResultSet rs ; 
                rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          // do some things please :
          
          this.description = rs.getString("description") ;
          this.pu_p = rs.getLong("pu_p") ;
          this.nbp_ob = rs.getInt("nbp_ob") ;
          
          
          
          
      }
      
      this.d.setText("DESCRIPTION : "+this.description) ;
      this.p2.setText("PRIX UNITAIRE / PORTION : "+this.pu_p) ;
      this.nb1.setText("NOMBRE DE PORTION OBTENUE APRES DECOUPAGE :  "+nf3.format(this.nbp_ob)) ;
      
              this.solde = this.nbp_ob ;
       
              sql = "select * from envoies_pts where cb_op = "+this.cb_op ;
              rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          // do some things please :
          
          this.nbp_pl += rs.getInt("nbp_pl") ;
          this.vy = 1 ;
          this.solde = (this.nbp_ob - this.nbp_pl) ;
          
        
          
      }
      
      this.nb2.setText("NOMBRE DE PORTION PLACEE APRES DECOUPAGE :  "+nf3.format(this.nbp_pl)) ;
      
      if(this.vy == 1){
      this.nb3.setText("NOMBRE DE PORTION RESTANTE APRES DECOUPAGE : "+nf3.format(this.solde)) ;
      }else if(this.vy == 0){
          this.nb3.setText("NOMBRE DE PORTION RESTANTE APRES DECOUPAGE : "+nf3.format(this.solde)) ;
      }
      
      
      this.op.setText("OPERATEUR ACTIF : "+this.login) ;
      
      
       sql = "select placement from point_pl where type = 'oui' order by placement ASC" ;
              rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          // do some things please :
          
           this.a.addItem(rs.getString("placement")) ;
        
         
          
      }
      
      
       sql = "select perso from perso_t where type = 'oui' AND domaine = 'PL' OR domaine = 'CL_PL' order by perso ASC" ;
              rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          // do some things please :
          
          this.c.addItem(rs.getString("perso")) ;
        
         
          
      }
      
      
      
      if(this.solde == 0){
          
         this.a.setEnabled(false) ;
         this.c.setEnabled(false) ;
         this.nbp.setEnabled(false) ;
         this.jButton1.setEnabled(false) ;
         
      }else if(this.solde > 0){
          
         this.a.setEnabled(true) ;
         this.c.setEnabled(true) ;
         this.nbp.setEnabled(true) ;
         this.jButton1.setEnabled(true) ;
         
      }
      
      long mtt = 0 ;
      
       sql = "select * from envoies_pts where cb_op = "+this.cb_op ;
              rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          // do some things please :
          
          dtm1.addRow(new Object[]{
          
// "CODE BARRE", "ID", "DESCRIPTION", "NBRE  P", "P.U / P", "MONTANT", "PT.ARRIVER", "COMMISSIONNAIRE", "DATE", "LOGIN"
              
    rs.getInt("cb") , rs.getLong("id") , rs.getString("description") , nf3.format(rs.getInt("nbp_pl")) ,
    nf3.format(rs.getLong("pu_p")) , nf3.format(rs.getLong("mtt")) , rs.getString("arriver") , rs.getString("perso") ,
    sdfT.format(rs.getTimestamp("datej")) , rs.getString("op") 
    
              
          }) ;
          
         mtt += rs.getLong("mtt") ;
        
      }
      
      
     
      this.jLabel2.setText(nf3.format(mtt)) ;
      
      
      // fin partie unitile :
      
      
          
      //STEP 6: Clean-up environment
 
      rs.close() ;
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
        d = new javax.swing.JLabel();
        p2 = new javax.swing.JLabel();
        nb1 = new javax.swing.JLabel();
        nb2 = new javax.swing.JLabel();
        nb3 = new javax.swing.JLabel();
        op = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        nbp = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        a = new javax.swing.JComboBox();
        c = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PLACEMENT DES PORTIONS OBTENUES APRES DECOUPAGE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMATIONS GENERALES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18))); // NOI18N

        d.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        d.setText("DESCRIPTION :");

        p2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        p2.setText("PRIX UNITAIRE / PORTION :");

        nb1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nb1.setText("NOMBRE DE PORTION OBTENUE APRES DECOUPAGE :   0");

        nb2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nb2.setText("NOMBRE DE PORTION PLACEE APRES DECOUPAGE :   0");

        nb3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nb3.setText("NOMBRE DE PORTION RESTANTE APRES DECOUPAGE :   0");

        op.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        op.setText("OPERATEUR ACTIF :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(d, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nb2, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addComponent(nb3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(op, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(d)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nb1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nb2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nb3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(op)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PLACEMENT DE PORTION DANS UN POINT DE PLACEMENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 14))); // NOI18N

        nbp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        nbp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nbp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nbpKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel7.setText("NOMBRE DE PORTION");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("VALIDER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("P.DEPART : ZONE DE  DECOUPAGE");

        a.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        a.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ARRIVER" }));
        a.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });

        c.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        c.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "COMMISSIONNAIRE" }));
        c.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(nbp, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(a, 0, 220, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nbp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HISTORIQUE DE PLACEMENT POUR CE PRODUIT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 18))); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE BARRE", "ID", "DESCRIPTION", "NBRE  P", "P.U / P", "MONTANT", "PT.ARRIVER", "COMMISSIONNAIRE", "DATE", "LOGIN"
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
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(10);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("TOTAL MONTANT :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 255));
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
        
        this.arriver = this.a.getSelectedItem().toString().replaceAll("'", "''") ;
        
        if("ARRIVER".equalsIgnoreCase(this.arriver)){
           // JOptionPane.showMessageDialog(this,"SELECTIONNER LE POINT DE PLACEMENT SVP !!! ") ;
        }
        
    }//GEN-LAST:event_aActionPerformed

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        // TODO add your handling code here:
        
        
         this.perso = this.c.getSelectedItem().toString().replaceAll("'", "''") ;
        
        if("COMMISSIONNAIRE".equalsIgnoreCase(this.perso)){
            // JOptionPane.showMessageDialog(this,"SELECTIONNER LE COMMISSIONNAIRE SVP !!! ") ;
        }
        
        
    }//GEN-LAST:event_cActionPerformed
Integer nbp_pl1 = 0 ;

    private void nbpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nbpKeyReleased
        // TODO add your handling code here:
        
        NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        try{
            
            this.nbp_pl1 = Integer.parseInt(this.nbp.getText()) ;
            
            System.out.println(this.nbp_pl1+" Est le nbp a l'envoi :::") ;
            
            /*
            Integer nb ;
                nb = Integer.parseInt(this.nbp.getText()) ;
            this.nbp_pl = (this.nbp_pl + nb) ;
            
            if(this.solde >= nb){
                
                this.solde = (this.solde - nb) ;
                
                 this.nb2.setText("NOMBRE DE PORTION PLACEE APRES DECOUPAGE :  "+nf3.format(this.nbp_pl)) ;
                 this.nb3.setText("NOMBRE DE PORTION RESTANTE APRES DECOUPAGE : "+nf3.format(this.solde)) ;
                
                
            }else{
                JOptionPane.showMessageDialog(this, "OPERATION IMPOSSIBLE IL VOUS RESTE : "+this.solde+" PORTIONS OU MORCEAUX !") ;
            }
            
            */
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "SAISIR LE NOMBRE DE PORTIONS EN CHIFFRE SVP !") ;
        }
        
        
        
    }//GEN-LAST:event_nbpKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         this.bonList.removeAll(this.bonList) ;
         
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
        try{
        
        this.jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
        if(JOptionPane.showConfirmDialog(null, "QUESTION : VOULEZ-VOUS VALIDER LES : "+this.nbp_pl1+" PORTIONS OU MORCEAUX ?" , "AVERTISSEMENT" , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            // yes option :
            
            if("ARRIVER".equalsIgnoreCase(this.arriver) || "COMMISSIONNAIRE".equalsIgnoreCase(this.perso) || this.nbp_pl1 == 0){
                
                JOptionPane.showMessageDialog(this, "RENSEIGNER TOUTES LES INFORMATIONS CORRECTEMENT SVP") ;
                
            }else{
                
                if(this.nbp_pl1 > 0){
                    
                  //  this.nbp_pl = (this.nbp_pl + this.nbp_pl1) ;
                    
                    if(this.solde >= this.nbp_pl1){
                        
                        Random rx = new Random() ;
                        this.cb = rx.nextInt() ;
                        
                        if(this.cb < 0){
                            this.cb = Math.abs(this.cb) ;
                        }
                        
                        this.mtt = (this.pu_p * this.nbp_pl1) ;
                        
                    Integer vy ;
                    
                            vy = (this.solde - this.nbp_pl1) ;
                            
                            if(vy == 0){
                                // Tous les portions ont été placées :
                                
                                // saving .......
                                
                                     Connection conn = null ;
                                     Statement  stmt = null  ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...") ;
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
      
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      SimpleDateFormat sdfT1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      
      this.datej = sdfT1.format(new Date()) ;
      
      
      String depart = "" ;
      long portions = 0 ;
      
      String sql ;
             sql = "select * from detail_pl where cb_op = "+this.cb_op+" limit 1" ;
      ResultSet rs ;
                rs = stmt.executeQuery(sql) ;
                
                while(rs.next()){
                    depart = rs.getString("depart") ;
                    portions = rs.getLong("portions") ;
                    
                }
                
                
                 long id = 0 ;
             sql = "select distinct id from envoies_pts" ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                 id = rs.getLong("id") ;
             }
             
             long num ;
                  num = (id + 1) ;
      
     /*
      
      Integer cb_op ;
      Integer cb ;
      String  description ;
      Integer nbp_pl = 0 ;
      Integer nbp_ob = 0 ;
      long    pu_p ;
      long    mtt ;
      String  arriver ;
      String  perso ;
      String  datej ;
      String  login ;
      Integer solde = 0 ;
      String  role ;
      Integer vy = 0 ;
      
      
      
      
          stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) ;  
      
   */
      
     long tmtt = 0 ;
     
                HashMap<String, Object> m = new HashMap<>();
                   
                   m.put("description", this.description) ;
                   m.put("qte", nf3.format(this.nbp_pl1)) ;
                   m.put("pu", nf3.format(this.pu_p)) ;
                   m.put("mtt", nf3.format(this.mtt)) ;
                              tmtt += this.mtt ;
                   m.put("tmtt", "TOTAL MTT : "+nf3.format(tmtt)) ;
                              
                              this.bonList.add(m) ;
                
if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,depart,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
        +this.cb_op+" , '"+this.datej+"' , '"+this.description.replaceAll("'", "''")+"' , '"+depart.replaceAll("'", "''")+"' , '"
        +this.arriver.replaceAll("'", "''")+"' , "+this.nbp_pl1+" , '"+this.perso.replaceAll("'", "''")+"' , 'decoupage' , "
        +portions+" , 'ouvert' , '"+this.login.replaceAll("'", "''")+"')") == 1){
    if(stmt.executeUpdate("update op_pl_f set etat = 'fermer' where cb = "+this.cb_op) > 0){
        if(stmt.executeUpdate("update detail_pl set etat = 'fermer' where cb_op = "+this.cb_op) > 0){
            if(stmt.executeUpdate("insert into envoies_pts(cb_op,cb,description,nbp_pl,pu_p,mtt,arriver,perso,datej,op) VALUES("
        +this.cb_op+" , "+this.cb+" , '"+this.description.replaceAll("'", "''")+"' , "+this.nbp_pl1+" , "
        +this.pu_p+" , "+this.mtt+" , '"+this.arriver.replaceAll("'", "''")+"' , '"+this.perso.replaceAll("'", "''")+"' , '"+this.datej+"' , '"
        +this.login.replaceAll("'", "''")+"')") == 1){
                
                this.nbp_pl = 0 ;
                
                long mtt = 0 ;
                
              sql = "select * from envoies_pts where cb_op = "+this.cb_op ;
              rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          // do some things please :
          
          this.nbp_pl += rs.getInt("nbp_pl") ;
          this.solde = (this.nbp_ob - this.nbp_pl) ;
          
        
          
      }
                
                   this.nb2.setText("NOMBRE DE PORTION PLACEE APRES DECOUPAGE :  "+nf3.format(this.nbp_pl)) ;
      
      
                   this.nb3.setText("NOMBRE DE PORTION RESTANTE APRES DECOUPAGE : "+nf3.format(this.solde)) ;
       
                
           
            DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                              dtm1.setRowCount(0) ;
             
      
       sql = "select * from envoies_pts where cb_op = "+this.cb_op ;
              rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          // do some things please :
          
          dtm1.addRow(new Object[]{
          
// "CODE BARRE", "ID", "DESCRIPTION", "NBRE  P", "P.U / P", "MONTANT", "PT.ARRIVER", "COMMISSIONNAIRE", "DATE", "LOGIN"
              
    rs.getInt("cb") , rs.getLong("id") , rs.getString("description") , nf3.format(rs.getInt("nbp_pl")) ,
    nf3.format(rs.getLong("pu_p")) , nf3.format(rs.getLong("mtt")) , rs.getString("arriver") , rs.getString("perso") ,
    sdfT.format(rs.getTimestamp("datej")) , rs.getString("op") 
    
              
          }) ;
          
        mtt += rs.getLong("mtt") ;
        
      }
      
      
     
      this.jLabel2.setText(nf3.format(mtt)) ;
      
      // JOptionPane.showMessageDialog(this, "Bon placement") ;
      
                InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\BonPlacement.jrxml")) ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.bonList) ;
            
            Map<String, Object> para = new HashMap<>();
            para.put("data", jrbean);
            para.put("op", "OP : "+this.login) ;  // this.login
            para.put("cb", this.cb) ;
            para.put("num", "N° : "+num) ;
            para.put("dep", "POINT DEPART : "+depart);
            para.put("arriv", "POINT ARRIVER : "+this.arriver);
            para.put("perso", "COMMISSIONNAIRE : "+this.perso) ;
            para.put("motif", "LE MOTIF : "+"ENVOIS DES PORTIONS OU MORCEAUX") ;
            para.put("tmtt", "TOTAL MTT : "+nf3.format(tmtt)) ;
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
            JasperViewer.viewReport(print, false);
            
      
      //
         this.a.setEnabled(false) ;
         this.c.setEnabled(false) ;
         this.nbp.setEnabled(false) ;
         this.jButton1.setEnabled(false) ;
         
       
        
}    
}       
}    
}
                    
                
      
      
       
      
      
          
      //STEP 6: Clean-up environment
 
     // rs.close() ;
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
        
        
                                
                                // saving .......
                                
                                
                                
                            }else if(vy > 0){
                                 // Tous les portions n'ont pas été placées :
                                
                                 // saving .......
                                
                                     Connection conn = null ;
                                     Statement  stmt = null  ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...") ;
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
      
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      SimpleDateFormat sdfT1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      
      this.datej = sdfT1.format(new Date()) ;
      
      
      String depart = "" ;
      long portions = 0 ;
      
      String sql ;
             sql = "select * from detail_pl where cb_op = "+this.cb_op+" limit 1" ;
      ResultSet rs ;
                rs = stmt.executeQuery(sql) ;
                
                while(rs.next()){
                    depart = rs.getString("depart") ;
                    portions = rs.getLong("portions") ;
                    
                }
                
                long id = 0 ;
             sql = "select distinct id from envoies_pts" ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                 id = rs.getLong("id") ;
             }
             
             long num ;
                  num = (id + 1) ;
      
      
     /*
      
      Integer cb_op ;
      Integer cb ;
      String  description ;
      Integer nbp_pl = 0 ;
      Integer nbp_ob = 0 ;
      long    pu_p ;
      long    mtt ;
      String  arriver ;
      String  perso ;
      String  datej ;
      String  login ;
      Integer solde = 0 ;
      String  role ;
      Integer vy = 0 ;
      
      
      
      
          stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,qte,pu,mtt,depart,ndep,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
                  +this.cb+" , '"+this.list.get(ii).getDate1()+"' , '"+this.list.get(ii).getDescription().replaceAll("'", "''")+"' , "+this.list.get(ii).getQte()+" , "
          + this.list.get(ii).getPu()+" , "+this.list.get(ii).getMtt()+" , '"+this.list.get(ii).getDepart().replaceAll("'", "''")+"' , "
          + this.list.get(ii).getNdep()+" , '"+this.list.get(ii).getArriver().replaceAll("'", "''")+"' , "+this.list.get(ii).getNariv()+" , '"
          + this.list.get(ii).getPerso().replaceAll("'", "''")+"' , '"+this.list.get(ii).getMotif().replaceAll("'", "''")+"' , "
          + this.PORTIONS +" , '"+this.etat+"' , '"+this.login.replaceAll("'", "''")+"' )" ) ;  
      
   */
      
                  long tmtt = 0 ;
     
                HashMap<String, Object> m = new HashMap<>();
                   
                   m.put("description", this.description) ;
                   m.put("qte", nf3.format(this.nbp_pl1)) ;
                   m.put("pu", nf3.format(this.pu_p)) ;
                   m.put("mtt", nf3.format(this.mtt)) ;
                              tmtt += this.mtt ;
                   m.put("tmtt", "TOTAL MTT : "+nf3.format(tmtt)) ;
                              
                              this.bonList.add(m) ;
     
                
if(stmt.executeUpdate("insert into detail_pl(cb_op,datej,description,depart,arriver,nariv,perso,motif,portions,etat,admin) VALUES("
        +this.cb_op+" , '"+this.datej+"' , '"+this.description.replaceAll("'", "''")+"' , '"+depart.replaceAll("'", "''")+"' , '"
        +this.arriver.replaceAll("'", "''")+"' , "+this.nbp_pl1+" , '"+this.perso.replaceAll("'", "''")+"' , 'decoupage' , "
        +portions+" , 'ouvert' , '"+this.login.replaceAll("'", "''")+"')") == 1){
            if(stmt.executeUpdate("insert into envoies_pts(cb_op,cb,description,nbp_pl,pu_p,mtt,arriver,perso,datej,op) VALUES("
        +this.cb_op+" , "+this.cb+" , '"+this.description.replaceAll("'", "''")+"' , "+this.nbp_pl1+" , "
        +this.pu_p+" , "+this.mtt+" , '"+this.arriver.replaceAll("'", "''")+"' , '"+this.perso.replaceAll("'", "''")+"' , '"+this.datej+"' , '"
        +this.login.replaceAll("'", "''")+"')") == 1){
                
                  this.nbp_pl = 0 ;
                
              sql = "select * from envoies_pts where cb_op = "+this.cb_op ;
              rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          // do some things please :
          
          this.nbp_pl += rs.getInt("nbp_pl") ;
          this.solde = (this.nbp_ob - this.nbp_pl) ;
          
        
          
      }
                
                   this.nb2.setText("NOMBRE DE PORTION PLACEE APRES DECOUPAGE :  "+nf3.format(this.nbp_pl)) ;
      
      
                   this.nb3.setText("NOMBRE DE PORTION RESTANTE APRES DECOUPAGE : "+nf3.format(this.solde)) ;
       
                
           
            DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                              dtm1.setRowCount(0) ;
             
                              long mtt = 0 ;
      
       sql = "select * from envoies_pts where cb_op = "+this.cb_op ;
              rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          // do some things please :
          
          dtm1.addRow(new Object[]{
          
// "CODE BARRE", "ID", "DESCRIPTION", "NBRE  P", "P.U / P", "MONTANT", "PT.ARRIVER", "COMMISSIONNAIRE", "DATE", "LOGIN"
              
    rs.getInt("cb") , rs.getLong("id") , rs.getString("description") , nf3.format(rs.getInt("nbp_pl")) ,
    nf3.format(rs.getLong("pu_p")) , nf3.format(rs.getLong("mtt")) , rs.getString("arriver") , rs.getString("perso") ,
    sdfT.format(rs.getTimestamp("datej")) , rs.getString("op") 
    
              
          }) ;
          
       mtt += rs.getLong("mtt") ;
        
      }
      
      
     
      this.jLabel2.setText(nf3.format(mtt)) ;
      
      // JOptionPane.showMessageDialog(this, "Bon placement") ;
      
             InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\BonPlacement.jrxml")) ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.bonList) ;
            
            Map<String, Object> para = new HashMap<>();
            para.put("data", jrbean);
            para.put("op", "OP : "+this.login) ;  // this.login
            para.put("cb", this.cb) ;
            para.put("num", "N° : "+num) ;
            para.put("dep", "POINT DEPART : "+depart);
            para.put("arriv", "POINT ARRIVER : "+this.arriver);
            para.put("perso", "COMMISSIONNAIRE : "+this.perso) ;
            para.put("motif", "LE MOTIF : "+"ENVOIS DES PORTIONS OU MORCEAUX") ;
            para.put("tmtt", "TOTAL MTT : "+nf3.format(tmtt)) ;
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
            JasperViewer.viewReport(print, false);
            
        
      
   // 
      
      
         this.a.setSelectedItem(new String("ARRIVER")) ;
         this.c.setSelectedItem(new String("COMMISSIONNAIRE")) ;
         this.nbp.setText("0") ;
      
         this.a.setEnabled(true) ;
         this.c.setEnabled(true) ;
         this.nbp.setEnabled(true) ;
         this.jButton1.setEnabled(true) ;
              
}    
}
                    
                
      
      
       
      
      
          
      //STEP 6: Clean-up environment
 
     // rs.close() ;
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
        
        
                                
                                // saving .......
                               
                                
                                
                            }
                            
                    
                    }else{
                    JOptionPane.showMessageDialog(this, "Operation impossible il vous reste juste : "+this.solde+" portions ou morceaux ") ;
                    }
                    
                    
                }else{
                     JOptionPane.showMessageDialog(this, "LE NOMBRE DE PORTION EST STRICTEMENT POSITIF ! ") ;
                }
                
                
            }
            
            
        }else{
            
            // No option :
            
        }
        
        this.jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "SELECTIONNER LE POINT DE PLACEMENT ET CORRECT ET LE COMMISSIONNAIRE PLUS LE NOMBRE DE MORCEAU EN CHIFFRE SVP !!! ") ;
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
            java.util.logging.Logger.getLogger(Envoi_op_fini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Envoi_op_fini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Envoi_op_fini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Envoi_op_fini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Envoi_op_fini().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox a;
    private javax.swing.JComboBox c;
    private javax.swing.JLabel d;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nb1;
    private javax.swing.JLabel nb2;
    private javax.swing.JLabel nb3;
    private javax.swing.JFormattedTextField nbp;
    private javax.swing.JLabel op;
    private javax.swing.JLabel p2;
    // End of variables declaration//GEN-END:variables
}
