/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import allCollection.ListCommande;
import com.github.royken.converter.FrenchNumberToWords;
import static frontend.ProduitFini.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HAMZA
 */
public class Construire_model_gteau extends javax.swing.JFrame {

    /**
     * Creates new form Construire_model_gteau
     */
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
      String login ;
      
      String description;
      String dimension;
      Integer prx_ ;
      String observation;
      
      String option ;
      Integer prx_option ;
      
      Integer montant = 0 ;
      
      Integer counter_gs = 0 ;
      Integer counter_og = 0 ;
      Integer nombre_option = 0 ;
      Integer check = 1 ;
     
      Integer vy_1 = 0 ;
      Integer vy_2 = 0 ;
      
      
      DefaultListModel dlm = new DefaultListModel() ;
    
      ArrayList<ListCommande> list = new ArrayList<ListCommande>() ;
      ArrayList<ListCommande> list_gateau_standard = new ArrayList<ListCommande>() ;
      ArrayList<ListCommande> list_option_gateau = new ArrayList<ListCommande>() ;
    
     NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
     
     Integer d_f_g = 0 ;
     
     Integer d_f_go = 0 ;
     
     
    public Construire_model_gteau(){
        initComponents() ;
        this.setLocationRelativeTo(null) ;
               
        
    }
    
    
    public Construire_model_gteau(String login){
        
        initComponents() ;
        this.setLocationRelativeTo(null) ;
        this.login = login ;
        
        dlm.clear();
        
     // this.save.setEnabled(true) ;
        
        
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
              
    // jtable 2 :
          
            this.jTable2.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable2.getTableHeader().setOpaque(false) ; 
            this.jTable2.getTableHeader().setBackground(Color.black) ; 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable2.getTableHeader().setForeground(Color.white) ;
        
            this.jTable2.setRowHeight(25) ;
 
                  headerRenderer.setBackground(Color.green) ;
                  headerRenderer.setForeground(Color.BLACK) ;
                  headerRenderer.setFont(new Font("Segoe UI" , Font.BOLD , 16)) ;

                  for (int i = 0; i < this.jTable2.getModel().getColumnCount(); i++) {
                    this.jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
              
                  
                  // tableau 3 :
                  
            this.jTable3.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable3.getTableHeader().setOpaque(false) ; 
            this.jTable3.getTableHeader().setBackground(Color.black) ; 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable3.getTableHeader().setForeground(Color.white) ;
            this.jTable3.setRowHeight(25) ;
                          
                  headerRenderer.setBackground(Color.green) ;
                  headerRenderer.setForeground(Color.BLACK) ;
                  headerRenderer.setFont(new Font("Segoe UI" , Font.BOLD , 16)) ;

                  for (int i = 0; i < this.jTable3.getModel().getColumnCount(); i++) {
                    this.jTable3.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
                        }
                  
                  DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                    dtm3.setRowCount(0) ;
                                    
              
                  
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
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      String sql = null ;
      ResultSet rs = null ;
      
      sql = "select * from t_gateau where type = 'oui' " ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          this.tg.addItem(new String(rs.getString("description"))) ;
      }
      
     DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                       dtm1.setRowCount(0) ;
     
    sql = "select * from gest_format where type = 'oui' order by description asc" ;
    rs = stmt.executeQuery(sql) ;
    while(rs.next()){
        dtm1.addRow(new Object[]{
    rs.getString("description") , rs.getString("dimension") , rs.getInt("prx") , rs.getString("observation")
        });
    }
     
     DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                       dtm2.setRowCount(0) ;
     
    sql = "select * from gest_option where type = 'oui' order by description asc" ;
    rs = stmt.executeQuery(sql) ;
    while(rs.next()){
        dtm2.addRow(new Object[]{
    rs.getString("description") , rs.getInt("prx")
        });
    }
      
      dlm.clear();
      this.jList1.setModel(dlm) ;
      
    
            
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
        jTextField1 = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        desc = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        dim = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        prx = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        opt_gateau = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        tg = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONSTRUCTION D'UN MODEL GATEAU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("        PRIX DU MODEL");

        jTextField1.setEditable(false);

        save.setBackground(new java.awt.Color(0, 0, 255));
        save.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("ENREGISTRER LE MODEL");
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("                           DESCRIPTION / NOM DU MODEL");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("DESCRIPTION");

        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("DIMENSION");

        dim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dimKeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("PRIX DE BASE");

        prx.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prxKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("LISTE GATEAU STANDARD");

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DESCRIPTION", "DIMENSION", "PRIX DE BASE", "OBSERVATION"
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
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(260);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(260);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(260);
            jTable1.getColumnModel().getColumn(1).setMinWidth(80);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(2).setMinWidth(90);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(90);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("      OPTION GATEAU");

        opt_gateau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                opt_gateauKeyReleased(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "DESCRIPTION", "PRIX"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jTable2);

        jList1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jList1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jList1MouseReleased(evt);
            }
        });
        jScrollPane7.setViewportView(jList1);

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AJOUTER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("RETIRER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("AJOUTER");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("RETIRER");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(102, 102, 0));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("VALIDER");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jTable3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DESCRIPTION / OPTION", "DIMENSION", "PRIX DE BASE", "OBSERVATION", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable3.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable3MouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setMinWidth(330);
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(330);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(330);
            jTable3.getColumnModel().getColumn(1).setMinWidth(80);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable3.getColumnModel().getColumn(1).setMaxWidth(80);
            jTable3.getColumnModel().getColumn(2).setMinWidth(90);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable3.getColumnModel().getColumn(2).setMaxWidth(90);
            jTable3.getColumnModel().getColumn(4).setMinWidth(0);
            jTable3.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable3.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("          STRUCTURE GATEAU");

        tg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR UN TYPE GATEAU" }));
        tg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton5.setBackground(new java.awt.Color(0, 0, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("REFRESH");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(75, 75, 75)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(92, 92, 92)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(dim, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(prx, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(opt_gateau, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tg, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                                    .addComponent(jTextField3))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(opt_gateau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3)
                            .addComponent(tg, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jTextField1)))
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

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        // TODO add your handling code here:
        this.save.setEnabled(true); 

    }//GEN-LAST:event_jTextField3FocusGained

    private void descKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyReleased
        // TODO add your handling code here:

        Connection conn = null ;
        Statement stmt = null ;

        try{

            // STEP 2: Register JDBC driver :
            Class.forName(JDBC_DRIVER) ;

            //STEP 3: Open a connection
            // System.out.println("Connecting to database...");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 4: Execute a query
            // System.out.println("Creating statement...") ;

            stmt = conn.createStatement() ;

            // je crai ma requete

            String sql = null ;
            ResultSet rs = null ;

            DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
            dtm.setRowCount(0) ;

            sql = "SELECT * FROM gest_format where description like '%"+this.desc.getText().replaceAll("'", "''")+"%' order by description asc" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

                dtm.addRow(new Object[]{

                    // "ref.produit", "Code Barre", "Description", "Prix Achat", "Prix vente"

                    rs.getString("description") , rs.getString("dimension"), rs.getInt("prx") , rs.getString("observation")

                }) ;

                // System.out.print(" LE code patient est Systematique "+cp.getText()) ;

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

    }//GEN-LAST:event_descKeyReleased

    private void dimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dimKeyReleased
        // TODO add your handling code here:

        Connection conn = null ;
        Statement stmt = null ;

        try{

            // STEP 2: Register JDBC driver :
            Class.forName(JDBC_DRIVER) ;

            //STEP 3: Open a connection
            // System.out.println("Connecting to database...");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 4: Execute a query
            // System.out.println("Creating statement...") ;

            stmt = conn.createStatement() ;

            // je crai ma requete

            String sql = null ;
            ResultSet rs = null ;

            DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
            dtm.setRowCount(0) ;

            sql = "SELECT * FROM gest_format where dimension like '%"+this.dim.getText().replaceAll("'", "''")+"%' order by description asc" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

                dtm.addRow(new Object[]{

                    // "ref.produit", "Code Barre", "Description", "Prix Achat", "Prix vente"

                    rs.getString("description") , rs.getString("dimension"), rs.getInt("prx") , rs.getString("observation")

                }) ;

                // System.out.print(" LE code patient est Systematique "+cp.getText()) ;

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

    }//GEN-LAST:event_dimKeyReleased

    private void prxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prxKeyReleased
        // TODO add your handling code here:

        Connection conn = null ;
        Statement stmt = null ;

        try{

            // STEP 2: Register JDBC driver :
            Class.forName(JDBC_DRIVER) ;

            //STEP 3: Open a connection
            // System.out.println("Connecting to database...");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 4: Execute a query
            // System.out.println("Creating statement...") ;

            stmt = conn.createStatement() ;

            // je crai ma requete

            String sql = null ;
            ResultSet rs = null ;
            Integer prx  = 0 ;

            try{
                prx = Integer.parseInt(this.prx.getText()) ;

            }catch(Exception ax){

            }

            DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
            dtm.setRowCount(0) ;

            sql = "SELECT * FROM gest_format where prx like '%"+prx+"%' order by description asc" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

                dtm.addRow(new Object[]{

                    // "ref.produit", "Code Barre", "Description", "Prix Achat", "Prix vente"

                    rs.getString("description") , rs.getString("dimension"), rs.getInt("prx") , rs.getString("observation")

                }) ;

                // System.out.print(" LE code patient est Systematique "+cp.getText()) ;

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

    }//GEN-LAST:event_prxKeyReleased

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        
       // TODO add your handling code here :
        
       this.description = "" ;
       this.dimension = "" ;
       this.prx_ = 0 ;
       this.observation = "" ;
       
       this.description = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString().replaceAll("'", "''") ;
       this.dimension = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString().replaceAll("'", "''") ;
       this.prx_ = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString()) ;
       this.observation = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString().replaceAll("'", "''") ;
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
        this.option = "" ;
        this.prx_option = 0 ;
        
        this.option = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString().replaceAll("'", "''") ;
        this.prx_option = Integer.parseInt(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString()) ;
        
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(this.counter_gs == this.counter_og){
            this.check = 1 ;
        }else{
            this.check = 0 ;
        }
        
        if(this.check == 1){
            
            this.vy_1 = 1 ;
            this.vy_2 = 0 ;
            
            this.counter_gs += 1 ;
            this.check = 0 ;
            ListCommande lc = new ListCommande(this.description,this.dimension,this.prx_,this.observation) ;
                         this.list_gateau_standard.add(lc) ;
                         this.list.addAll(this.list_gateau_standard) ;
                         this.list_gateau_standard.removeAll(this.list_gateau_standard) ;
                         
                         this.montant += this.prx_ ;
        
        DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                          dtm3.addRow(new Object[]{
            this.description,this.dimension,this.prx_,this.observation,"gs"                      
                                    }) ;
                          
                           this.jTextField1.setText(this.nf3.format(this.montant)) ;
                          
        }else{
            JOptionPane.showMessageDialog(null, "PARAMETRE INCORRECT") ; 
        }
        
        this.d_f_g = 1 ;
        this.d_f_go = 0 ;
                          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        if(this.jTable3.getSelectedRow() == -1){
        
            JOptionPane.showMessageDialog(null, "SELECTIONNER DANS LA LISTE A DROITE") ;
        
        }else{
            if(this.etat.equalsIgnoreCase("gs")){
        
         this.counter_gs -= 1 ;
         this.montant -= this.mt ;
         
         this.vy_1 = 0 ;
         this.d_f_g = 0 ;
         
         if(this.counter_gs > 0){
             this.d_f_go = 1 ;
         }
         
         
         this.list.remove(this.jTable3.getSelectedRow()) ;
         
         DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
         
                           dtm3.removeRow(this.jTable3.getSelectedRow()) ;
                           
                            this.jTextField1.setText(this.nf3.format(this.montant)) ;
         
         
        /*
         try{
             
             Integer ligne = this.jTable3.getSelectedRow() ;
             JOptionPane.showMessageDialog(null, ""+ligne);
             
              this.list.remove(ligne) ;
              this.list.remove((ligne + Integer.parseInt("1"))) ;
         
         DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
         
                           dtm3.removeRow((ligne + Integer.parseInt("1"))) ;
                           dtm3.removeRow(this.jTable3.getSelectedRow()) ;
                           
                           
                            this.jTextField1.setText(this.nf3.format(this.montant)) ;
                            
             
         }catch(Exception e){
         
        // this.list.remove(this.jTable3.getSelectedRow()) ;
         
         DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
         
                           dtm3.removeRow(this.jTable3.getSelectedRow()) ;
                           
                            this.jTextField1.setText(this.nf3.format(this.montant)) ;
                            
                            
         }     
           
         */
                            
            
            }else{
                JOptionPane.showMessageDialog(null, "CHOISIR UN GATEAU STANDARD POUR RETIRER") ;
            }
        
        }
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
       this.nombre_option += 1 ;
       this.montant += this.prx_option ;
       
       ListCommande lc = new ListCommande(this.option+"["+this.prx_option+"]") ;
       this.list_option_gateau.add(lc) ;
        dlm.addElement("OPTION = "+lc.getDescription()) ;
        this.jList1.setModel(dlm) ;
        
         this.jTextField1.setText(this.nf3.format(this.montant)) ;
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here :
        
        if(this.d_f_g == 0){
            
             JOptionPane.showMessageDialog(null, "PARAMETRE INCORRECT") ;
             
             
        }else if(this.d_f_g == 1){
        
        if(this.counter_gs == (this.counter_og+1)){
        
            this.counter_og += 1 ;
            this.check = 1 ;
            this.d_f_go = 1 ;
            this.vy_2 = 1 ;
            
        String option = "" ;
        
        for(int i = 0 ; i < this.list_option_gateau.size(); i++){
            option += this.list_option_gateau.get(i).getDescription()+" , " ;
            
        }
        
        if(option.isEmpty() == true){
            
        }else{
        
        ListCommande lc = new ListCommande(option,"",Integer.parseInt("0"),"") ;
        this.list.add(lc) ;
        
        
        //
        for(int i = 0 ; i < this.list.size(); i++){
            System.out.println(this.list.get(i).getDescription()) ;  
        }
        //
        
        DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                          dtm3.addRow(new Object[]{
                          option ,"","","","go"
                          });
        
     this.list_option_gateau.removeAll(this.list_option_gateau) ;
     this.dlm.clear();
     this.jList1.setModel(dlm) ;
     
     
     
        }
     
        }else{
            JOptionPane.showMessageDialog(null, "PARAMETRE INCORRECT") ;
        }
        
        
        }
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void opt_gateauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_opt_gateauKeyReleased
        // TODO add your handling code here:
        
        Connection conn = null ;
        Statement stmt = null ;

        try{

            // STEP 2: Register JDBC driver :
            Class.forName(JDBC_DRIVER) ;

            //STEP 3: Open a connection
            // System.out.println("Connecting to database...");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 4: Execute a query
            // System.out.println("Creating statement...") ;

            stmt = conn.createStatement() ;

            // je crai ma requete

            String sql = null ;
            ResultSet rs = null ;

            DefaultTableModel dtm2 =(DefaultTableModel) jTable2.getModel() ;
            dtm2.setRowCount(0) ;

            sql = "SELECT * FROM gest_option where description like '%"+this.opt_gateau.getText().replaceAll("'", "''")+"%' order by description asc" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

                dtm2.addRow(new Object[]{

                    // "ref.produit", "Code Barre", "Description", "Prix Achat", "Prix vente"

                    rs.getString("description") , rs.getInt("prx")

                }) ;
 

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
        
        
    }//GEN-LAST:event_opt_gateauKeyReleased
String etat = "" ;
Integer mt = 0 ;
    private void jTable3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseReleased
        // TODO add your handling code here:
        
        try{
        this.etat = this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4).toString() ;
        this.mt = Integer.parseInt(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2).toString()) ;
        }catch(Exception e){
            
        }
        
        
    }//GEN-LAST:event_jTable3MouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        try{
            
            if(this.jList1.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "CHOISIR OPTION") ;
            }else{
                this.nombre_option -= 1 ;
                this.montant -= this.mt_op ;
                
                this.list_option_gateau.remove(this.jList1.getSelectedIndex()) ;
                dlm.remove(this.jList1.getSelectedIndex()) ;
                this.jList1.setModel(dlm) ;
                
                 this.jTextField1.setText(this.nf3.format(this.montant)) ;
                
                
                 //
                
                   for(int i = 0 ; i < this.list_option_gateau.size(); i++){
                       // System.out.println("OPTION : "+this.list_option_gateau.get(i).getDescription()) ;
                   }
                
                //
                
            }
            
        }catch(Exception e){
            
            
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed
String nom_model ;
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        
      
        
        Integer ID_CB = 0 ;
        
         String type_g = "" ;
               type_g = this.tg.getSelectedItem().toString() ;
               
               if("CHOISIR UN TYPE GATEAU".equalsIgnoreCase(type_g) || this.montant == 0 || this.d_f_go == 0 || (this.vy_1 != this.vy_2)){
                   JOptionPane.showMessageDialog(null, "ELEMENT IMCOMPLET");
               }else{
                   
           this.nom_model = type_g+" "+FrenchNumberToWords.convert(this.counter_gs)+" , OPTION "+FrenchNumberToWords.convert(this.nombre_option)  ;  //  +" , "+this.nf3.format(this.montant) ;
           this.jTextField3.setText((this.nom_model).toUpperCase()) ;
           
           
           
           
        // System.out.println("nb gs : "+this.counter_gs+" nb og : "+this.counter_og+" nb nbre option : "+this.nombre_option) ;
        
        this.jTextField1.setText(this.nf3.format(this.montant)) ;
        
     //   JOptionPane.showMessageDialog(null, this.montant) ;
        
        // saving in my database serveur for all neddd :
        
         Connection conn = null ;
         Statement stmt = null ;

        try{

            // STEP 2: Register JDBC driver :
            Class.forName(JDBC_DRIVER) ;

            //STEP 3: Open a connection
            // System.out.println("Connecting to database...");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 4: Execute a query
            // System.out.println("Creating statement...") ;

            stmt = conn.createStatement() ;

            // je crai ma requete
            
            
            String sql = null ;
            ResultSet rs = null ;
            
            ArrayList<String> list_DB_m = new ArrayList<String>() ;
            ArrayList<String> list_DB_d = new ArrayList<String>() ;
            ArrayList<String> list_R_m = new ArrayList<String>() ;
            ArrayList<String> list_R_d = new ArrayList<String>() ;
            ArrayList<Integer> list_cb = new ArrayList<Integer>() ;
            
            ArrayList<Integer> list_vy = new ArrayList<Integer>() ;
            
            list_R_m.add(new String(this.nom_model)) ;
            for(int i = 0 ; i < this.list.size() ; i++){
                list_R_d.add(new String(this.list.get(i).getDescription())) ;
            }
            
            /*
            sql = "select model_gt.description as model , model_gt.cb as code , detail_model_gt.description asc detail "
                    + "from model_gt , detail_model_gt "
                    + "where detail_model_gt.cb = model_gt.cb" ;
            */
            
            sql = "select description , cb from model_gt where description = '"+this.nom_model+"'" ;
            
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                list_DB_m.add(new String(rs.getString("description"))) ;
                list_cb.add(rs.getInt("cb")) ;
                
            }
            
            for(int i = 0 ; i < list_cb.size(); i++){
                
                list_DB_d.removeAll(list_DB_d) ;
                
                sql = "select description from detail_model_gt where cb = "+list_cb.get(i).intValue() ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    list_DB_d.add(new String(rs.getString("description"))) ;
                }
                
                if(list_R_d.equals(list_DB_d) == true){
                    
                    list_vy.add(Integer.parseInt("1")) ;
                    ID_CB = list_cb.get(i).intValue() ;
                    
                    
                    // JOptionPane.showMessageDialog(null, "CE MODEL EXISTE DEJA");
                    
                }else if(list_R_d.equals(list_DB_d) == false){
                    
                    // saving model here :
                    
                      list_vy.add(Integer.parseInt("0")) ;
                    
                    // end saving model :
                    
                }
                
                
            }
            
            if(list_vy.contains(Integer.parseInt("1"))){
                String ID = "" ;
                sql = "select id from model_gt where cb = "+ID_CB ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    ID = rs.getString("id") ;
                }
                
                JOptionPane.showMessageDialog(null, "MODEL EXISTANT"+System.getProperty("line.separator")+"ID MODEL = "+ID) ;
                
                 Construire_model_gteau cmg = new Construire_model_gteau(this.login) ;
                               cmg.setVisible(true) ;
                               this.setVisible(false) ;
                
            }else{
                
                 Integer cb ;
             
            
                    
            Random rx = new Random() ;
            cb = rx.nextInt() ;
            
            if(cb < 0){
                cb = Math.abs(cb) ;
            }
            
       stmt.executeUpdate("insert into model_gt(description,prx,login,cb) values('"+this.nom_model+"' , "
               +this.montant+" , '"+this.login+"' , "+cb+")") ;
       
       for(int i = 0 ; i < this.list.size() ; i++){
           
            stmt.executeUpdate("insert into detail_model_gt(description,dimension,prx,observation,cb,model,total) values('"+this.list.get(i).getDescription().replaceAll("'", "''")+"' , '"+this.list.get(i).getDimension().replaceAll("'", "''")+"' , "
            +this.list.get(i).getPrx()+" , '"+this.list.get(i).getObservation().replaceAll("'", "''")+"' , "+cb+" , '"
            +this.nom_model+"' , "+this.montant+")") ;
            
           
              }
       
       this.list.removeAll(this.list) ;
       this.list_gateau_standard.removeAll(list_gateau_standard) ;
       this.list_option_gateau.removeAll(list_option_gateau) ;
       
       this.counter_gs = 0 ;
       this.counter_og = 0 ;
       this.nombre_option = 0 ;
       
       
       JOptionPane.showMessageDialog(null, "MODEL CONSTRUIT AVEC SUCCES !") ;
       
       Construire_model_gteau cmg = new Construire_model_gteau(this.login) ;
                               cmg.setVisible(true) ;
                               this.setVisible(false) ;
       
      
       
            
            }
            
        
           
            

            //STEP 6: Clean-up environment

            // System.out.println("Goodbye!");

            //STEP 6: Clean-up environment
            
        //  rs.close();
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
        
        // and persistence system .
        
               
                  
               
               }
               
             
                               
       
               
               
               
    }//GEN-LAST:event_saveActionPerformed
Integer mt_op ;
    private void jList1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseReleased
        // TODO add your handling code here:
        
       
        
        String valeur ;
               valeur = this.jList1.getSelectedValue().toString() ;
               int index_ = valeur.indexOf("[") ;
               int index =  valeur.lastIndexOf("]") ;
               String mt =  valeur.substring(index_+1 , index) ;
           //    JOptionPane.showMessageDialog(null, "mtt = "+mt);
               try{
                   
                   this.mt_op = Integer.parseInt(mt) ;
                   
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null, e.getMessage()) ;
               }
                
             
        
    }//GEN-LAST:event_jList1MouseReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
         Construire_model_gteau cmg = new Construire_model_gteau(this.login) ;
                                cmg.setVisible(true) ;
                                
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
            java.util.logging.Logger.getLogger(Construire_model_gteau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Construire_model_gteau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Construire_model_gteau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Construire_model_gteau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Construire_model_gteau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField desc;
    private javax.swing.JTextField dim;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField opt_gateau;
    private javax.swing.JTextField prx;
    private javax.swing.JButton save;
    private javax.swing.JComboBox tg;
    // End of variables declaration//GEN-END:variables
}
