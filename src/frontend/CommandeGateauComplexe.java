/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import allCollection.ListCommande;
import static frontend.ConsultModelGateau.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class CommandeGateauComplexe extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
      Integer cb ;
      
      String id_ ;
      String description_ ;
      String prx_m_ ;
      String login_ ;
      
      
    ArrayList<Integer> list_cb = new ArrayList<Integer>() ;
    ArrayList<ListCommande> list = new ArrayList<ListCommande>() ;
    
    
    
    public CommandeGateauComplexe(){
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
              
  // tableau 2 :
                  
                  
    this.jTable2.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable2.getTableHeader().setOpaque(false); 
            this.jTable2.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable2.getTableHeader().setForeground(Color.white) ;
        
            this.jTable2.setRowHeight(25) ;
              
        
       //      DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
             
                  headerRenderer.setBackground(Color.green) ;
                  headerRenderer.setForeground(Color.BLACK) ;
                  headerRenderer.setFont(new Font("Segoe UI" , Font.BOLD , 25)) ;

                  for (int i = 0; i < this.jTable2.getModel().getColumnCount(); i++) {
                    this.jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
    // tableau 3 :
                  
            this.jTable3.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable3.getTableHeader().setOpaque(false); 
            this.jTable3.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable3.getTableHeader().setForeground(Color.white) ;
        
            this.jTable3.setRowHeight(25) ;
              
        
             
                  headerRenderer.setBackground(Color.green) ;
                  headerRenderer.setForeground(Color.BLACK) ;
                  headerRenderer.setFont(new Font("Segoe UI" , Font.BOLD , 16)) ;

                  for (int i = 0; i < this.jTable3.getModel().getColumnCount(); i++) {
                    this.jTable3.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
                  
                 DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                               dtm1.setRowCount(0) ;
                               
                               DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                               dtm2.setRowCount(0) ;
                               
                               
                               DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                                 dtm3.setRowCount(0) ;
                               
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
            
          

            sql =  "select * from model_gt order by id desc" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

                dtm1.addRow(new Object[]{

                    //  "ID", "DESCRIPTION / NOM", "PRIX", "LOGIN", "CODE BARRE"

   rs.getLong("id") , rs.getString("description").toUpperCase() , rs.getInt("prx") , rs.getString("login").toUpperCase() , rs.getInt("cb")

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nm = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        prx = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GATEAU PERSONNALISE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "DESCRIPTION / NOM", "PRIX", "LOGIN", "CODE BARRE"
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
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(1).setMinWidth(300);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(300);
            jTable1.getColumnModel().getColumn(2).setMinWidth(90);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(3).setMinWidth(95);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(95);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(95);
        }

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DESCRIPTION / OPTION", "DIMENSION", "PRIX DE BASE", "OBSERVATION"
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
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(253);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(253);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(253);
            jTable2.getColumnModel().getColumn(1).setMinWidth(80);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(80);
            jTable2.getColumnModel().getColumn(2).setMinWidth(90);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(90);
            jTable2.getColumnModel().getColumn(3).setMinWidth(90);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("                                                     MODEL CONSTRUIT");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("DETAIL DU MODEL");

        nm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nmKeyReleased(evt);
            }
        });

        jLabel5.setText("RECHERCHE");

        jButton2.setBackground(new java.awt.Color(51, 0, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("AJOUTER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 0, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("RETIRER");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 0, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("VALIDER");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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
                "ID", "DESCRIPTION", "PRIX", "LOGIN", "CODE BARRE"
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
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable3MouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setMinWidth(50);
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable3.getColumnModel().getColumn(1).setMinWidth(300);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTable3.getColumnModel().getColumn(1).setMaxWidth(300);
            jTable3.getColumnModel().getColumn(2).setMinWidth(90);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable3.getColumnModel().getColumn(2).setMaxWidth(90);
            jTable3.getColumnModel().getColumn(3).setMinWidth(95);
            jTable3.getColumnModel().getColumn(3).setPreferredWidth(95);
            jTable3.getColumnModel().getColumn(3).setMaxWidth(95);
        }

        jLabel7.setText("NOM DU MODEL");

        jLabel8.setText("RECHERCHE");

        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idKeyReleased(evt);
            }
        });

        jLabel9.setText("ID DU MODEL");

        jLabel10.setText("RECHERCHE");

        prx.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prxKeyReleased(evt);
            }
        });

        jLabel11.setText("PRIX DU MODEL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(prx, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                        .addGap(205, 205, 205)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "CHOISIR UN MODEL");
        }else{
            
            
            String m1 = Nouvelle_commande.getDevis() ;
            Integer mtt1 = Integer.parseInt(m1) ;
            Integer mtt2 = Integer.parseInt(this.prx_m_) ;
            
            
            Integer total = (mtt1 + mtt2) ;
            
            Nouvelle_commande.setMtt(total);
            
            
            this.list_cb.add(this.cb) ;
            DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
            
            ListCommande lc = new ListCommande() ;
       
                   
              lc.setDescription(this.description_ );
              lc.setDimension("");
              lc.setPrx(Integer.parseInt(this.prx_m_)) ;
              lc.setObservation("");
              lc.setCb(this.cb) ;
              lc.setCl("model");
              
              
              this.list.add(lc) ;
            
                          dtm3.addRow(new Object[]{
            this.id_ , this.description_ , this.prx_m_ , this.login_ , this.cb
                          });
            
            
        }
      

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        if(this.jTable3.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "CHOISIR UN MODEL");
        }else{
            
            String m1 = Nouvelle_commande.getDevis() ;
            Integer mtt1 = Integer.parseInt(m1) ;
            Integer mtt2 = Integer.parseInt(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2).toString()) ;
            
            
            Integer total = (mtt1 - mtt2) ;
            
            Nouvelle_commande.setMtt(total);
            
            this.list_cb.remove(this.jTable3.getSelectedRow()) ;
            this.list.remove(this.jTable3.getSelectedRow()) ;
            DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                              dtm3.removeRow(this.jTable3.getSelectedRow()) ;
            
            
        }
        

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        
          /*
        
        
        if(this.list_cb.size() > 0){
           
      
        
        this.list.removeAll(this.list) ;
        
        
         
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
            
              
             for (int i = 0 ; i < this.list_cb.size() ; i++){
                
                
            sql = "select * from detail_model_gt where detail_model_gt.cb = "+this.list_cb.get(i).intValue() ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

               ListCommande lc = new ListCommande() ;
       
                   
              lc.setDescription(rs.getString("description"));
              lc.setDimension(rs.getString("dimension"));
              lc.setPrx(rs.getInt("prx")) ;
              lc.setObservation(rs.getString("observation"));
             
              lc.setModel(rs.getString("model")) ;
              lc.setTotal(rs.getInt("total")) ;
              
              
              this.list.add(lc) ;
               
               
               
                
            }

             
             
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
            JOptionPane.showMessageDialog(null, "PAS DE COMMANDE") ;
        }

            */
        
        if(this.list.size() > 0){
        Nouvelle_commande.laodTable1(this.list) ;
        
             this.list.removeAll(list) ;
             this.list_cb.removeAll(list_cb) ;
             this.setVisible(false) ;
           
        }else{
            JOptionPane.showMessageDialog(null, "PAS DE COMMANDE") ;
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        this.jTable2.getSelectionModel().clearSelection();
        this.jTable3.getSelectionModel().clearSelection();
        
        this.id_ = "" ; this.description_ = "" ; this.prx_m_ = "" ; this.login_ = "" ;
        
        this.id_ = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString() ;
        this.description_ = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString() ;
        this.prx_m_ = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString() ;
        this.login_ = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString() ;
        
        this.cb = 0 ;
        
        this.cb = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4).toString()) ;
        
         DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                           dtm2.setRowCount(0) ;
                               
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
            
          

            sql =  "select * from detail_model_gt where cb = "+this.cb ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

                dtm2.addRow(new Object[]{

                    //  "DESCRIPTION / OPTION", "DIMENSION", "PRIX DE BASE", "OBSERVATION"

       rs.getString("description").toUpperCase(), rs.getString("dimension").toUpperCase() ,rs.getInt("prx") , rs.getString("observation").toUpperCase()

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
                  
        
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void nmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nmKeyReleased
        // TODO add your handling code here:
        
         DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                               dtm1.setRowCount(0) ;
                               
                               DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                               dtm2.setRowCount(0) ;
                               
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
            
          

            sql =  "select * from model_gt where description like '%"+this.nm.getText()+"%'" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

                dtm1.addRow(new Object[]{

                    //  "ID", "DESCRIPTION / NOM", "PRIX", "LOGIN", "CODE BARRE"

   rs.getLong("id") , rs.getString("description").toUpperCase() , rs.getInt("prx") , rs.getString("login").toUpperCase() , rs.getInt("cb")

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
                   
        
        
    }//GEN-LAST:event_nmKeyReleased

    private void idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyReleased
        // TODO add your handling code here:
        
        
        
             DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                               dtm1.setRowCount(0) ;
                               
                               DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                               dtm2.setRowCount(0) ;
                               
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
            
          

            sql =  "select * from model_gt where id = "+Long.parseLong(this.id.getText()) ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

                dtm1.addRow(new Object[]{

                    //  "ID", "DESCRIPTION / NOM", "PRIX", "LOGIN", "CODE BARRE"

   rs.getLong("id") , rs.getString("description").toUpperCase() , rs.getInt("prx") , rs.getString("login").toUpperCase() , rs.getInt("cb")

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
                   
        
        
    }//GEN-LAST:event_idKeyReleased

    private void prxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prxKeyReleased
        // TODO add your handling code here:
        
          DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                               dtm1.setRowCount(0) ;
                               
                               DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                               dtm2.setRowCount(0) ;
                               
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
            
          

            sql =  "select * from model_gt where prx like '%"+this.prx.getText()+"%'" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

                dtm1.addRow(new Object[]{

                    //  "ID", "DESCRIPTION / NOM", "PRIX", "LOGIN", "CODE BARRE"

   rs.getLong("id") , rs.getString("description").toUpperCase() , rs.getInt("prx") , rs.getString("login").toUpperCase() , rs.getInt("cb")

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

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
     //   this.jTable1.getSelectionModel().clearSelection();
        this.jTable3.getSelectionModel().clearSelection();
        this.jTable2.getSelectionModel().clearSelection();
       
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void jTable3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseReleased
        // TODO add your handling code here:
        
        this.jTable1.getSelectionModel().clearSelection();
        this.jTable2.getSelectionModel().clearSelection();
        
    }//GEN-LAST:event_jTable3MouseReleased

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
            java.util.logging.Logger.getLogger(CommandeGateauComplexe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CommandeGateauComplexe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CommandeGateauComplexe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CommandeGateauComplexe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CommandeGateauComplexe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField nm;
    private javax.swing.JTextField prx;
    // End of variables declaration//GEN-END:variables
}
