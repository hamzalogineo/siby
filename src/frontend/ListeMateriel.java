/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.CategorieM.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static org.slf4j.helpers.Util.report;

/**
 *
 * @author hp
 */
public class ListeMateriel extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
      Integer id;
      Integer categorie_id ;
      String image ;
      String etat ;
      
      
    public ListeMateriel() {
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
      
      
   
      
       sql = "SELECT * FROM c_m where etat = 'oui' order by categorie asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
      this.c.addItem(new String(rs.getString("categorie")) ) ;
      
     }
      
    
    
        DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         
   
      
       sql = "SELECT * , c_m.categorie as cate FROM materiel_l , c_m where c_m.id = materiel_l.categorie order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ID", "CATEGORIE", "DESCRIPTION", "DIMENSION", "PRIX", "QTE MIN", "PRIX C", "CODE IMAGE", "ETAT"
            
           rs.getString("id") , rs.getString("cate") , rs.getString("description") , rs.getString("dimension") , rs.getString("prix") , rs.getString("qte_m") , rs.getString("prx_c") ,
           rs.getString("code_img") , rs.getString("etat")
         
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
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        c = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        d = new javax.swing.JTextField();
        dim = new javax.swing.JTextField();
        prx = new javax.swing.JTextField();
        qm = new javax.swing.JTextField();
        pc = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        ci = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rech = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        monitor = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTE MATERIEL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        c.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        c.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR" }));
        c.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c.setMaximumSize(new java.awt.Dimension(0, 25));
        c.setMinimumSize(new java.awt.Dimension(0, 25));
        c.setPreferredSize(new java.awt.Dimension(150, 25));
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("CATEGORIE");

        d.setMaximumSize(new java.awt.Dimension(0, 25));
        d.setMinimumSize(new java.awt.Dimension(0, 25));
        d.setPreferredSize(new java.awt.Dimension(6, 25));
        d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dActionPerformed(evt);
            }
        });

        dim.setMaximumSize(new java.awt.Dimension(0, 25));
        dim.setMinimumSize(new java.awt.Dimension(0, 25));
        dim.setPreferredSize(new java.awt.Dimension(6, 25));
        dim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dimActionPerformed(evt);
            }
        });

        prx.setMaximumSize(new java.awt.Dimension(100, 25));
        prx.setMinimumSize(new java.awt.Dimension(100, 25));
        prx.setPreferredSize(new java.awt.Dimension(100, 25));

        qm.setMaximumSize(new java.awt.Dimension(100, 25));
        qm.setMinimumSize(new java.awt.Dimension(100, 25));
        qm.setPreferredSize(new java.awt.Dimension(100, 25));

        pc.setMaximumSize(new java.awt.Dimension(0, 25));
        pc.setMinimumSize(new java.awt.Dimension(0, 25));
        pc.setPreferredSize(new java.awt.Dimension(100, 25));

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("IMAGE");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ci.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("PRIX C");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("DESCRIPTION");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("      DIMENSION");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("             PRIX");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("        QTE MIN");

        rech.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rechKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("RECHERCHER");

        img.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton3.setBackground(new java.awt.Color(0, 51, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("VEILLEUSE");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("AJOUTER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 51, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("MODIFIER");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CATEGORIE", "DESCRIPTION", "DIMENSION", "PRIX", "QTE MIN", "PRIX C", "CODE IMAGE", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setMinWidth(35);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(35);
            jTable1.getColumnModel().getColumn(1).setMinWidth(150);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(2).setMinWidth(250);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(250);
            jTable1.getColumnModel().getColumn(3).setMinWidth(90);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(4).setMinWidth(90);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(5).setMinWidth(80);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(6).setMinWidth(80);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(8).setMinWidth(0);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        monitor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        monitor.setText("xxxx");
        monitor.setMaximumSize(new java.awt.Dimension(0, 25));
        monitor.setMinimumSize(new java.awt.Dimension(0, 25));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monitor, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(prx, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(pc, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(qm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rech, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(99, 99, 99)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ci, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(img, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monitor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, 0)
                                .addComponent(qm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, 0)
                                .addComponent(pc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, 0)
                                .addComponent(prx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton4)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ci, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dimActionPerformed

    private void dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        // TODO add your handling code here :
        
        
    JFileChooser fileChooser = new JFileChooser(); 
    fileChooser.setDialogTitle("CHOISIR UN FICHIER A TELECHARGER") ;

       int response = fileChooser.showOpenDialog(this) ; 
       
       if (response == JFileChooser.APPROVE_OPTION) {

            
            File selectedFile = fileChooser.getSelectedFile() ;
            String chemin = selectedFile.getAbsolutePath() ;
            String nom = selectedFile.getName() ;
            
            System.out.println(selectedFile.getAbsolutePath()) ;
            System.out.print("Name : "+selectedFile.getName()) ;
            
            
            // debut :
             
                
            
           //  end :

    
    try {
        
         ImageIcon icon = new ImageIcon(chemin) ; 
        // Rectangle rec = this.img.getBounds() ;
      //   Image img = icon.getImage().getScaledInstance(rec.width, rec.height, Image.SCALE_SMOOTH) ;
         
               //   icon = new ImageIcon(img) ;
         
       
         this.img.setIcon(icon) ;
         
         this.ci.setText(nom) ;
         
            
    }catch(Exception e){
        
        
    }
    
        

    } 
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        // TODO add your handling code here:
        
        if(this.c.getSelectedItem().toString().equalsIgnoreCase("CHOISIR")){
            
            this.monitor.setText("xxxx") ;
            this.categorie_id = 0 ;
            
        }
        
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
      
      this.categorie_id = 0 ;
      
      
   
      
       sql = "SELECT distinct id FROM c_m where categorie = '"+this.c.getSelectedItem().toString().replaceAll("'", "''")+"'" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
      this.categorie_id = rs.getInt("id") ;
      this.monitor.setText(""+this.categorie_id) ;
      
      
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
        
          
       
        
        
        
        
        
    }//GEN-LAST:event_cActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        String d,dim,prx,pc,qm,ci ;
        
        d = this.d.getText().trim().replaceAll("'", "''") ;
        dim = this.dim.getText().trim().replaceAll("'", "''") ;
        prx = this.prx.getText() ;
        pc = this.pc.getText() ;
        qm = this.qm.getText() ;
        ci = this.ci.getText().trim() ;
        
        
        int prx1 = 0 ;
        int pc1 = 0 ;
        int qm1 = 0 ;
        
       try{
         
           prx1 = Integer.parseInt(prx) ;
           pc1 = Integer.parseInt(pc) ;
           qm1 = Integer.parseInt(qm) ;
           
           
           //
           
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
       
      
      if(this.categorie_id == 0 || d.isEmpty() || dim.isEmpty() || prx1 == 0 || pc1 == 0 || qm1 == 0){
          JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT");
      }else{
      
      
      String sql = null ;
      ResultSet rs = null ;
      
      if(stmt.executeUpdate("insert into materiel_l(categorie,description,dimension,prix,qte_m,prx_c,code_img,etat) "
              + "values("+this.categorie_id+" , '"+d+"' , '"+dim+"' , "
              +prx1+" , "+qm1+" , "+pc1+" , '"+ci+"' , 'OUI')") == 1){
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         
   
      
       sql = "SELECT * , c_m.categorie as cate FROM materiel_l , c_m where c_m.id = materiel_l.categorie order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ID", "CATEGORIE", "DESCRIPTION", "DIMENSION", "PRIX", "QTE MIN", "PRIX C", "CODE IMAGE", "ETAT"
            
           rs.getString("id") , rs.getString("cate") , rs.getString("description") , rs.getString("dimension") , rs.getString("prix") , rs.getString("qte_m") , rs.getString("prx_c") ,
           rs.getString("code_img") , rs.getString("etat")
         
        }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
    
   
      
      
      }
      
      rs.close();
      
      
      this.c.setSelectedItem(new String("CHOISIR"));
      this.d.setText(""); this.dim.setText(""); this.prx.setText(""); 
      this.pc.setText(""); this.qm.setText(""); this.ci.setText("") ;
      
      ImageIcon ic = new ImageIcon() ;
       this.img.setIcon(ic) ;
       
      
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
           
           //
           
           
           
           
       }catch(Exception e){
           
           JOptionPane.showMessageDialog(null, e.getMessage()) ;
           
       }
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
         
         
   
      
        sql = "SELECT * , c_m.categorie as cate FROM materiel_l , c_m where c_m.id = materiel_l.categorie order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ID", "CATEGORIE", "DESCRIPTION", "DIMENSION", "PRIX", "QTE MIN", "PRIX C", "CODE IMAGE", "ETAT"
            
           rs.getString("id") , rs.getString("cate") , rs.getString("description") , rs.getString("dimension") , rs.getString("prix") , rs.getString("qte_m") , rs.getString("prx_c") ,
           rs.getString("code_img") , rs.getString("etat")
         
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
           rs.getString("code_img") , rs.getString("etat")
         
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

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        this.id = 0 ;
        this.image = "" ;
        this.etat = "" ;
        
        this.c.setSelectedItem(new String(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()));
        this.d.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString());
        this.dim.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString()) ;
        this.prx.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4).toString()) ;
        this.qm.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 5).toString()) ;
        this.pc.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 6).toString()) ;
        this.ci.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 7).toString());
        
        
        this.etat = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 8).toString() ;
        
        
        this.id = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString()) ;
        this.image = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 7).toString() ;
        
        ImageIcon icon = new ImageIcon("\\\\192.168.1.117\\TEST_IMG_LOCATION\\"+this.image) ;
        
        this.img.setIcon(icon) ;
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
       String d,dim,prx,pc,qm,ci ;
        
        d = this.d.getText().trim().replaceAll("'", "''") ;
        dim = this.dim.getText().trim().replaceAll("'", "''") ;
        prx = this.prx.getText() ;
        pc = this.pc.getText() ;
        qm = this.qm.getText() ;
        ci = this.ci.getText().trim() ;
        
        
        int prx1 = 0 ;
        int pc1 = 0 ;
        int qm1 = 0 ;
        
       try{
         
           prx1 = Integer.parseInt(prx) ;
           pc1 = Integer.parseInt(pc) ;
           qm1 = Integer.parseInt(qm) ;
           
           
           //
           
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
       
      
      if(this.categorie_id == 0 || d.isEmpty() || dim.isEmpty() || prx1 == 0 || pc1 == 0 || qm1 == 0){
          JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT");
      }else{
      
      
      String sql = null ;
      ResultSet rs = null ;
      
      if(stmt.executeUpdate("update materiel_l set categorie = "+this.categorie_id+" , description = '"+d+"', dimension = '"+dim+"', "
              + "prix = "+prx1+" , qte_m = "+qm1+" ,prx_c = "+pc1+" , code_img = '"+this.ci.getText()+"'"
              + " where id = "+this.id) == 1){
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         
   
      
       sql = "SELECT * , c_m.categorie as cate FROM materiel_l , c_m where c_m.id = materiel_l.categorie order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ID", "CATEGORIE", "DESCRIPTION", "DIMENSION", "PRIX", "QTE MIN", "PRIX C", "CODE IMAGE", "ETAT"
            
           rs.getString("id") , rs.getString("cate") , rs.getString("description") , rs.getString("dimension") , rs.getString("prix") , rs.getString("qte_m") , rs.getString("prx_c") ,
           rs.getString("code_img") , rs.getString("etat")
         
        }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
    
   
      
      
      }
      
      rs.close();
      
      
      this.c.setSelectedItem(new String("CHOISIR"));
      this.d.setText(""); this.dim.setText(""); this.prx.setText(""); 
      this.pc.setText(""); this.qm.setText(""); this.ci.setText("") ;
      
      ImageIcon ic = new ImageIcon() ;
       this.img.setIcon(ic) ;
       
      
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
           
           //
           
           
           
           
       }catch(Exception e){
           
           JOptionPane.showMessageDialog(null, e.getMessage()) ;
           
       }
        
        
        
           
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "SELECTIONNER UN MATERIEL SVP") ;
        }else{
            //
            
            if(this.etat.equalsIgnoreCase("OUI")){
                
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
      
      if(stmt.executeUpdate("update materiel_l set etat = 'NON'"
              + " where id = "+this.id) == 1){
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         
   
      
       sql = "SELECT * , c_m.categorie as cate FROM materiel_l , c_m where c_m.id = materiel_l.categorie order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ID", "CATEGORIE", "DESCRIPTION", "DIMENSION", "PRIX", "QTE MIN", "PRIX C", "CODE IMAGE", "ETAT"
            
           rs.getString("id") , rs.getString("cate") , rs.getString("description") , rs.getString("dimension") , rs.getString("prix") , rs.getString("qte_m") , rs.getString("prx_c") ,
           rs.getString("code_img") , rs.getString("etat")
         
        }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
    
   
      
      
      }
      
      rs.close();
      
      
      this.c.setSelectedItem(new String("CHOISIR"));
      this.d.setText(""); this.dim.setText(""); this.prx.setText(""); 
      this.pc.setText(""); this.qm.setText(""); this.ci.setText("") ;
      
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
           
           //
           
                
            }else if(this.etat.equalsIgnoreCase("NON")){
                
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
      
      if(stmt.executeUpdate("update materiel_l set etat = 'OUI'"
              + " where id = "+this.id) == 1){
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         
   
      
       sql = "SELECT * , c_m.categorie as cate FROM materiel_l , c_m where c_m.id = materiel_l.categorie order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ID", "CATEGORIE", "DESCRIPTION", "DIMENSION", "PRIX", "QTE MIN", "PRIX C", "CODE IMAGE", "ETAT"
            
           rs.getString("id") , rs.getString("cate") , rs.getString("description") , rs.getString("dimension") , rs.getString("prix") , rs.getString("qte_m") , rs.getString("prx_c") ,
           rs.getString("code_img") , rs.getString("etat")
         
        }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
    
   
      
      
      }
      
      rs.close();
      
      
      this.c.setSelectedItem(new String("CHOISIR"));
      this.d.setText(""); this.dim.setText(""); this.prx.setText(""); 
      this.pc.setText(""); this.qm.setText(""); this.ci.setText("") ;
      
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
           
                
                
                
            }
            
            //
        }
        
        
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
            java.util.logging.Logger.getLogger(ListeMateriel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListeMateriel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListeMateriel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListeMateriel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListeMateriel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox c;
    private javax.swing.JLabel ci;
    private javax.swing.JTextField d;
    private javax.swing.JTextField dim;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel monitor;
    private javax.swing.JTextField pc;
    private javax.swing.JTextField prx;
    private javax.swing.JTextField qm;
    private javax.swing.JTextField rech;
    // End of variables declaration//GEN-END:variables
}
