/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.P_Derives.JDBC_DRIVER;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
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

public class Detail_Op extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      String zone  = "" ;
      String description = "" ;
      String dte1 ;
      String dte2 ;
      String m_o = "" ;
      String stock_1 = "" ;
      
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy") ;
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
       long toA = 0 ;
       long toD = 0 ;
       
      List bonList = new ArrayList() ;
      
    public Detail_Op() {
        initComponents();
        this.setLocationRelativeTo(null) ;
        
         Date jour = new Date() ;
        this.jDateChooser1.setDate(jour);
        this.h1.setText("00:00") ;
        this.jDateChooser2.setDate(jour) ;
        this.h2.setText("23:59") ;
        
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
        
       
       
        
        //
       
            this.jTable2.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable2.getTableHeader().setOpaque(false) ; 
            this.jTable2.getTableHeader().setBackground(Color.black) ; 
          
        //    this.jTable1.setBackground(Color.white) ;
        
       
            this.jTable2.getTableHeader().setForeground(Color.white) ;
        
            this.jTable2.setRowHeight(25) ;
              
        
             
                  for (int i = 0; i < this.jTable2.getModel().getColumnCount(); i++) {
                    this.jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
        
        
        
        //  ---------  2è choix
              
        
        
        
        
       //   ---------------
        
        
        //
        
       
        
     
        
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        
      
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm2.setRowCount(0) ;
        
       
        
        this.jTable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 9) ;
        
        String status_ = (String) table.getModel().getValueAt(row, 7) ;
        
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
            setBackground(Color.gray);
            setForeground(Color.WHITE);
        } 
        
        if ("DEPART".equalsIgnoreCase(status_)){
            setBackground(Color.RED);
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
              sql = "select placement from point_pl where type = 'oui' AND NOT placement = 'zone de decoupage' AND NOT placement = 'EXTERIEUR' order by placement ASC" ;
       ResultSet rs = null ;
                 rs = stmt.executeQuery(sql) ;
       while(rs.next()){
           
           this.point.addItem(rs.getString("placement")) ;
           
       }
                 
                 
               sql = "select motif from motif_pl where type = 'oui' order by motif ASC" ;
                 ResultSet rs22 = stmt.executeQuery(sql) ;
                 
                 while(rs22.next()){
                 
                  this.motif.addItem(rs22.getString("motif")) ;
                  
                  
               
       }
                 
                 sql = "select magasin from magasins where etat = 'oui' limit 1" ;
                 rs = stmt.executeQuery(sql) ;
                 while(rs.next()){
                     this.stock_1 = rs.getString("magasin") ;
                     this.point.addItem(new String(rs.getString("magasin"))) ;
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
        
       this.point.setSelectedItem(new String("CHAMBRE FROIDE")) ;
       this.motif.setSelectedItem(new String("TOUT")) ;
        
        
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
        point = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        h1 = new javax.swing.JTextField();
        h2 = new javax.swing.JTextField();
        produit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        motif = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        ta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        td = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        etat = new javax.swing.JTextField();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ETAT DETAILLE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPTION FILTRE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 18))); // NOI18N

        point.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        point.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "POINT DE PLACEMENT" }));
        point.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        point.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pointActionPerformed(evt);
            }
        });

        jLabel1.setText("DU");

        jLabel2.setText("AU");

        h1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h1ActionPerformed(evt);
            }
        });

        h2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h2ActionPerformed(evt);
            }
        });

        produit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                produitKeyReleased(evt);
            }
        });

        jLabel3.setText("HEURE");

        jLabel4.setText("HEURE");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("RECHERCHER PRODUIT");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPTION", "P.V"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        jButton1.setBackground(new java.awt.Color(0, 102, 255));
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

        motif.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        motif.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MOTIF", "TOUT", "ARRIVAGE", "DEPART" }));
        motif.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        motif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(point, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motif, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(produit, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(produit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 17, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel3))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(27, 27, 27)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(point, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(motif, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(87, 87, 87)))
                .addContainerGap())
        );

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID OP", "DATE OP", "OPERA..", "ANCIEN S.", "ARRIVER", "DEPART", "NOUVEAU S.", "MOTIF", "COMMENTATIRE", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(10);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(10);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(10);
            jTable2.getColumnModel().getColumn(7).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(8).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(9).setPreferredWidth(1);
        }

        jLabel6.setText("TOTAL A :");

        ta.setEditable(false);

        jLabel7.setText("TOTAL D :");

        td.setEditable(false);

        jLabel8.setText(" ");

        jLabel9.setText("ETAT (A - D)");

        etat.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(etat, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(td, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ta, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(td, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    private void h1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_h1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_h1ActionPerformed

    private void h2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_h2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_h2ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        
        this.description = "" ;
        this.description = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString().replaceAll("'", "''") ;
         this.jLabel8.setText("DESCRIPTION : "+this.description) ;
         
     // JOptionPane.showMessageDialog(null, this.description);
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void produitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_produitKeyReleased
        // TODO add your handling code here:
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                          dtm.setRowCount(0) ;
                          
                          String article = null ;
                                 article = this.produit.getText().trim().replaceAll("'", "''") ;
                                 
                                 if("".equals(article)){
                                     
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
      
     
       
           
           String sql = null ;
           ResultSet rs = null ;
           
           // matieres primaires :
           
           sql = "select id, description, prx_v_unite from matieres_p where description like '%"+article+"%' "
                   + "order by description asc" ;
       
       
                 rs = stmt.executeQuery(sql) ;
       while(rs.next()){
           
           dtm.addRow(new Object[]{
           rs.getString("id") , rs.getString("description") , rs.getString("prx_v_unite")
           });
           
       }
       
       // produits fini :
       
       sql = "select id, description, pu from produits_f where description like '%"+article+"%' "
                   + "order by description asc" ;
       
       
                 rs = stmt.executeQuery(sql) ;
       while(rs.next()){
           
           dtm.addRow(new Object[]{
           rs.getString("id") , rs.getString("description") , rs.getString("pu")
           });
           
       }
       
       // produit derive :
       
       sql = "select id, produit from derive_pl where produit like '%"+article+"%' "
                   + "AND NOT type = 'non' order by produit asc" ;
       
       
                 rs = stmt.executeQuery(sql) ;
       while(rs.next()){
           
           dtm.addRow(new Object[]{
           rs.getString("id") , rs.getString("produit") , 0
           });
           
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
        
        
    }//GEN-LAST:event_produitKeyReleased

    private void pointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pointActionPerformed
        // TODO add your handling code here:
        
        this.zone = "" ;
        
        this.zone = this.point.getSelectedItem().toString().replaceAll("'", "''") ;
        
    }//GEN-LAST:event_pointActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here :
        
        
        if(this.stock_1.isEmpty() == false && this.stock_1.equalsIgnoreCase(this.point.getSelectedItem().toString()) == false && this.point.getSelectedItem().toString().equalsIgnoreCase("POINT DE PLACEMENT") == false){
            
            long stock_logique = 0 ;
            Integer vy = 0 ;
        
        
        this.bonList.removeAll(this.bonList) ;
        this.toA = 0 ;
        this.toD = 0 ;
        String motif = "" ;
        motif = this.motif.getSelectedItem().toString().replaceAll("'", "''") ;
        
        if(this.jTable1.getSelectedRow() == -1 || this.zone.equals("POINT DE PLACEMENT") || "MOTIF".equalsIgnoreCase(motif)){
            JOptionPane.showMessageDialog(this, "SELECTIONNER LES PARAMETRES SVP") ;
        }else{
            
              try{
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
        SimpleDateFormat sdfT1 = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
       
        this.dte1 = sdfT1.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        this.dte2 = sdfT1.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                          dtm.setRowCount(0) ;
                          
                          
                          Connection conn = null ;
                          Statement  stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...") ;
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
     
       
           
           String sql = null ;
            
           ResultSet rs = null ;
           
           // matieres primaires :
           
           if(motif.equalsIgnoreCase(new String("TOUT"))){
               
               sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , stock_detail_pl.arriver as arv , stock_detail_pl.depart as dp , "
                      + " condition_livraison as f , conservation as sf , matieres_p.id as ref , matieres_p.unite_mesure as rapport , "
                      + " nariv as arriv , ndep as dep , op_pl_f.id as ref_id , op_pl_f.date1 as jour , op_pl_f.admin as op "
                      + " , op_pl_f.motif as ref_mot , op_pl_f.comt as ref_comt , "
                      + " stock_detail_pl.type as vy , stock_detail_pl.ans as st_d , stock_detail_pl.ans_2 as st_a"
                      + " from stock_detail_pl , matieres_p , op_pl_f where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND stock_detail_pl.description = '"+this.description+"' "
                      + " AND ( stock_detail_pl.arriver = '"+zone+"' OR stock_detail_pl.depart = '"+zone+"' ) "
                      + " AND matieres_p.description = stock_detail_pl.description "
                      + " AND op_pl_f.cb = stock_detail_pl.cb_op" ;
               
               
           }else{
               
               sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , stock_detail_pl.arriver as arv , stock_detail_pl.depart as dp , "
                      + " condition_livraison as f , conservation as sf , matieres_p.id as ref , matieres_p.unite_mesure as rapport , "
                      + " nariv as arriv , ndep as dep , op_pl_f.id as ref_id , op_pl_f.date1 as jour , op_pl_f.admin as op "
                      + " , op_pl_f.motif as ref_mot , op_pl_f.comt as ref_comt , "
                      + "stock_detail_pl.type as vy , stock_detail_pl.ans as st_d , stock_detail_pl.ans_2 as st_a"
                      + " from stock_detail_pl , matieres_p , op_pl_f where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND stock_detail_pl.description = '"+this.description+"' "
                      + " AND ( stock_detail_pl.arriver = '"+zone+"' OR stock_detail_pl.depart = '"+zone+"' ) "
                      + " AND matieres_p.description = stock_detail_pl.description "
                      + " AND op_pl_f.cb = stock_detail_pl.cb_op AND op_pl_f.motif = '"+motif+"'" ;
               
               
           }
           
         
           
            
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                
                
                if("non".equalsIgnoreCase(rs.getString("vy"))){
                     
                if(rs.getString("arv").equalsIgnoreCase(this.zone)){
                    
                    if(stock_logique == 0 && vy == 0 ){
                        stock_logique = rs.getLong("st_a") ;
                        vy = 1 ;
                        
                    }
                    
                    //  "ID OP", "ANCIEN S.", "ARRIVER", "DEPART", "NOUVEAU S.", "MOTIF", "COMMENTATIRE", "ETAT"
                    
                    dtm.addRow(new Object[]{
                
                 rs.getLong("ref_id") ,sdfT1.format(rs.getTimestamp("jour")) , rs.getString("op") ,this.nf3.format(stock_logique) , this.nf3.format(rs.getLong("arriv")) , 0 , this.nf3.format((stock_logique+rs.getLong("arriv"))) , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                });
                    
                }else if(rs.getString("dp").equalsIgnoreCase(this.zone)){
                    
                    if(stock_logique == 0 && vy == 0 ){
                        stock_logique = rs.getLong("st_d") ;
                        vy = 1 ;
                        
                    }
                     
                     dtm.addRow(new Object[]{
                
                 rs.getLong("ref_id") ,sdfT1.format(rs.getTimestamp("jour")) , rs.getString("op") ,this.nf3.format(stock_logique) , 0 , this.nf3.format(rs.getLong("dep")) , this.nf3.format((stock_logique-rs.getLong("dep")))  , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                }) ;
                    
                }
                
                    
                    
                }else if("oui".equalsIgnoreCase(rs.getString("vy"))){
                    
                    
                
                // hasmap :
                HashMap<String, Object> m = new HashMap<>() ;
                
                
                
                if(rs.getString("arv").equalsIgnoreCase(this.zone)){
                    
                    if(stock_logique == 0 && vy == 0 ){
                        stock_logique = rs.getLong("st_a") ;
                        vy = 1 ;
                        
                    }
                    
                   m.put("id",  rs.getString("ref_id")) ;
                   m.put("arriver", this.nf3.format(rs.getLong("arriv"))) ;
                   m.put("depart", "0") ;
                   m.put("motif", rs.getString("ref_mot").toUpperCase()) ;
                   m.put("comt", rs.getString("ref_comt").toUpperCase()) ;
                  
                    
                    dtm.addRow(new Object[]{
                
               //  rs.getLong("ref_id") , this.nf3.format(rs.getLong("arriv")) , 0 , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    rs.getLong("ref_id") ,sdfT1.format(rs.getTimestamp("jour")) , rs.getString("op") ,this.nf3.format(stock_logique) , this.nf3.format(rs.getLong("arriv")) , 0 , this.nf3.format((stock_logique += rs.getLong("arriv"))) , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                        
                });
                    
                    
                   m.put("st_a", this.nf3.format(stock_logique-rs.getLong("arriv"))) ;
                   m.put("st_d", this.nf3.format((stock_logique))) ;
                   
                   this.bonList.add(m) ;
                    
                    
                    this.toA += rs.getLong("arriv") ;
                    
                }else if(rs.getString("dp").equalsIgnoreCase(this.zone)){
                    
                    if(stock_logique == 0 && vy == 0 ){
                        stock_logique = rs.getLong("st_d") ;
                        vy = 1 ;
                        
                    }
                    
                   m.put("id",  rs.getString("ref_id")) ;
                   m.put("arriver", "0") ;
                   m.put("depart", this.nf3.format(rs.getLong("dep"))) ;
                   m.put("motif", rs.getString("ref_mot").toUpperCase()) ;
                   m.put("comt", rs.getString("ref_comt").toUpperCase()) ;
                  
                    
                     dtm.addRow(new Object[]{
                
             //    rs.getLong("ref_id") , 0 , this.nf3.format(rs.getLong("dep")) , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                   rs.getLong("ref_id") ,sdfT1.format(rs.getTimestamp("jour")) , rs.getString("op") ,this.nf3.format(stock_logique) , 0 , this.nf3.format(rs.getLong("dep")) , this.nf3.format((stock_logique -= rs.getLong("dep")))  , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                         
                }) ;
                     
                      m.put("st_a", this.nf3.format(stock_logique+rs.getLong("dep"))) ;
                      m.put("st_d", this.nf3.format((stock_logique))) ;
                   
                      this.bonList.add(m) ;
                    
                     this.toD += rs.getLong("dep") ;
                    
                }
                
                
            }  
                
            }
            
            
             // produits fini :
           
              if(motif.equalsIgnoreCase(new String("TOUT"))){
         
           sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , stock_detail_pl.arriver as arv , stock_detail_pl.depart as dp , "
                      + " produits_f.f as f , produits_f.sf as sf , produits_f.id as ref , produits_f.unite_m as rapport , "
                      + " nariv as arriv , ndep as dep , op_pl_f.id as ref_id , op_pl_f.date1 as jour , op_pl_f.admin as op "
                    + " , op_pl_f.motif as ref_mot , op_pl_f.comt as ref_comt , "
                      + "stock_detail_pl.type as vy , stock_detail_pl.ans as st_d , stock_detail_pl.ans_2 as st_a"
                      + " from stock_detail_pl , produits_f , op_pl_f where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND stock_detail_pl.description = '"+this.description+"' "
                      + " AND ( stock_detail_pl.arriver = '"+zone+"' OR stock_detail_pl.depart = '"+zone+"' ) "
                      + " AND produits_f.description = stock_detail_pl.description "
                      + " AND op_pl_f.cb = stock_detail_pl.cb_op" ;
           
              }else{
                  
                  sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , stock_detail_pl.arriver as arv , stock_detail_pl.depart as dp , "
                      + " produits_f.f as f , produits_f.sf as sf , produits_f.id as ref , produits_f.unite_m as rapport , "
                      + " nariv as arriv , ndep as dep , op_pl_f.id as ref_id , op_pl_f.date1 as jour , op_pl_f.admin as op "
                          + " , op_pl_f.motif as ref_mot , op_pl_f.comt as ref_comt , "
                          + "stock_detail_pl.type as vy , stock_detail_pl.ans as st_d , stock_detail_pl.ans_2 as st_a"
                      + " from stock_detail_pl , produits_f , op_pl_f where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND stock_detail_pl.description = '"+this.description+"' "
                      + " AND ( stock_detail_pl.arriver = '"+zone+"' OR stock_detail_pl.depart = '"+zone+"' ) "
                      + " AND produits_f.description = stock_detail_pl.description "
                      + " AND op_pl_f.cb = stock_detail_pl.cb_op AND op_pl_f.motif = '"+motif+"'" ;
                  
              }
            
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                
                 
                if("non".equalsIgnoreCase(rs.getString("vy"))){
                     
                if(rs.getString("arv").equalsIgnoreCase(this.zone)){
                    
                    if(stock_logique == 0 && vy == 0 ){
                        stock_logique = rs.getLong("st_a") ;
                        vy = 1 ;
                        
                    }
                    
                    //  "ID OP", "ANCIEN S.", "ARRIVER", "DEPART", "NOUVEAU S.", "MOTIF", "COMMENTATIRE", "ETAT"
                    
                    dtm.addRow(new Object[]{
                
                 rs.getLong("ref_id") ,sdfT1.format(rs.getTimestamp("jour")) , rs.getString("op") ,this.nf3.format(stock_logique) , this.nf3.format(rs.getLong("arriv")) , 0 , this.nf3.format((stock_logique+rs.getLong("arriv"))) , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                });
                    
                }else if(rs.getString("dp").equalsIgnoreCase(this.zone)){
                    
                    if(stock_logique == 0 && vy == 0 ){
                        stock_logique = rs.getLong("st_d") ;
                        vy = 1 ;
                        
                    }
                     
                     dtm.addRow(new Object[]{
                
                 rs.getLong("ref_id") ,sdfT1.format(rs.getTimestamp("jour")) , rs.getString("op") ,this.nf3.format(stock_logique) , 0 , this.nf3.format(rs.getLong("dep")) , this.nf3.format((stock_logique-rs.getLong("dep")))  , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                }) ;
                    
                }
                
                    
                    
                }else if("oui".equalsIgnoreCase(rs.getString("vy"))){
                    
                    
                
                // hasmap :
                HashMap<String, Object> m = new HashMap<>() ;
                
                
                
                if(rs.getString("arv").equalsIgnoreCase(this.zone)){
                    
                    if(stock_logique == 0 && vy == 0 ){
                        stock_logique = rs.getLong("st_a") ;
                        vy = 1 ;
                        
                    }
                    
                   m.put("id",  rs.getString("ref_id")) ;
                   m.put("arriver", this.nf3.format(rs.getLong("arriv"))) ;
                   m.put("depart", "0") ;
                   m.put("motif", rs.getString("ref_mot").toUpperCase()) ;
                   m.put("comt", rs.getString("ref_comt").toUpperCase()) ;
                  
                    
                    dtm.addRow(new Object[]{
                
               //  rs.getLong("ref_id") , this.nf3.format(rs.getLong("arriv")) , 0 , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    rs.getLong("ref_id") ,sdfT1.format(rs.getTimestamp("jour")) , rs.getString("op") ,this.nf3.format(stock_logique) , this.nf3.format(rs.getLong("arriv")) , 0 , this.nf3.format((stock_logique += rs.getLong("arriv"))) , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                        
                });
                    
                    
                   m.put("st_a", this.nf3.format(stock_logique-rs.getLong("arriv"))) ;
                   m.put("st_d", this.nf3.format((stock_logique))) ;
                   
                   this.bonList.add(m) ;
                    
                    
                    this.toA += rs.getLong("arriv") ;
                    
                }else if(rs.getString("dp").equalsIgnoreCase(this.zone)){
                    
                    if(stock_logique == 0 && vy == 0 ){
                        stock_logique = rs.getLong("st_d") ;
                        vy = 1 ;
                        
                    }
                    
                   m.put("id",  rs.getString("ref_id")) ;
                   m.put("arriver", "0") ;
                   m.put("depart", this.nf3.format(rs.getLong("dep"))) ;
                   m.put("motif", rs.getString("ref_mot").toUpperCase()) ;
                   m.put("comt", rs.getString("ref_comt").toUpperCase()) ;
                  
                    
                     dtm.addRow(new Object[]{
                
             //    rs.getLong("ref_id") , 0 , this.nf3.format(rs.getLong("dep")) , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                   rs.getLong("ref_id") ,sdfT1.format(rs.getTimestamp("jour")) , rs.getString("op") ,this.nf3.format(stock_logique) , 0 , this.nf3.format(rs.getLong("dep")) , this.nf3.format((stock_logique -= rs.getLong("dep")))  , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                         
                }) ;
                     
                      m.put("st_a", this.nf3.format(stock_logique+rs.getLong("dep"))) ;
                      m.put("st_d", this.nf3.format((stock_logique))) ;
                   
                      this.bonList.add(m) ;
                    
                     this.toD += rs.getLong("dep") ;
                    
                }
                
                
            }  
                
                
                /* old code :
                
                if("non".equalsIgnoreCase(rs.getString("vy"))){
                    
                   
                
                if(rs.getString("arv").equalsIgnoreCase(this.zone)){
                    
                  
                    
                    dtm.addRow(new Object[]{
                
                rs.getLong("ref_id") ,this.nf3.format(rs.getLong("st_a")) , this.nf3.format(rs.getLong("arriv")) , 0 , this.nf3.format((rs.getLong("st_a")+rs.getLong("arriv"))) , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                }) ;
                    
                }else if(rs.getString("dp").equalsIgnoreCase(this.zone)){
                    
                   
                    
                     dtm.addRow(new Object[]{
                
                 rs.getLong("ref_id") ,this.nf3.format(rs.getLong("st_d")) , 0 , this.nf3.format(rs.getLong("dep")) , this.nf3.format((rs.getLong("st_d")-rs.getLong("dep")))  , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                }) ; 
                    
                }
                    
                }else if("oui".equalsIgnoreCase(rs.getString("vy"))){
                
                // hasmap :
                HashMap<String, Object> m = new HashMap<>() ;
                
                if(rs.getString("arv").equalsIgnoreCase(this.zone)){
                    
                   m.put("id",  rs.getString("ref_id")) ;
                   m.put("arriver", this.nf3.format(rs.getLong("arriv"))) ;
                   m.put("depart", "0") ;
                   m.put("motif", rs.getString("ref_mot").toUpperCase()) ;
                   m.put("comt", rs.getString("ref_comt").toUpperCase()) ;
                   m.put("st_a", this.nf3.format(rs.getLong("st_a"))) ;
                   m.put("st_d", this.nf3.format((rs.getLong("st_a")+rs.getLong("arriv")))) ;
                   
                   this.bonList.add(m) ;
                    
                    this.toA += rs.getLong("arriv") ;
                    
                    dtm.addRow(new Object[]{
                
                 rs.getLong("ref_id") ,this.nf3.format(rs.getLong("st_a")) , this.nf3.format(rs.getLong("arriv")) , 0 , this.nf3.format((rs.getLong("st_a")+rs.getLong("arriv"))) , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                }) ;
                    
                }else if(rs.getString("dp").equalsIgnoreCase(this.zone)){
                    
                   m.put("id",  rs.getString("ref_id")) ;
                   m.put("arriver", "0") ;
                   m.put("depart", this.nf3.format(rs.getLong("dep"))) ;
                   m.put("motif", rs.getString("ref_mot").toUpperCase()) ;
                   m.put("comt", rs.getString("ref_comt").toUpperCase()) ;
                   m.put("st_a", this.nf3.format(rs.getLong("st_d"))) ;
                   m.put("st_d", this.nf3.format((rs.getLong("st_d")-rs.getLong("dep")))) ;
                   
                   this.bonList.add(m) ;
                    
                    this.toD += rs.getLong("dep") ;
                    
                     dtm.addRow(new Object[]{
                
                 rs.getLong("ref_id") ,this.nf3.format(rs.getLong("st_d")) , 0 , this.nf3.format(rs.getLong("dep")) , this.nf3.format((rs.getLong("st_d")-rs.getLong("dep")))  , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                }) ; 
                    
                }
                
            
                
            }  
                
                */
                        
            }
            
            
             // produit derive pour placement :
           
         if(motif.equalsIgnoreCase(new String("TOUT"))){
             
         
           sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , stock_detail_pl.arriver as arv , stock_detail_pl.depart as dp , "
                      + " nariv as arriv , ndep as dep , op_pl_f.id as ref_id , op_pl_f.date1 as jour , op_pl_f.admin as op "
                   + " , op_pl_f.motif as ref_mot , op_pl_f.comt as ref_comt , "
                   + "stock_detail_pl.type as vy , stock_detail_pl.ans as st_d , stock_detail_pl.ans_2 as st_a"
                      + " from stock_detail_pl , derive_pl , op_pl_f where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND stock_detail_pl.description = '"+this.description+"' "
                      + " AND ( stock_detail_pl.arriver = '"+zone+"' OR stock_detail_pl.depart = '"+zone+"' ) "
                      + " AND derive_pl.produit = stock_detail_pl.description "
                      + " AND op_pl_f.cb = stock_detail_pl.cb_op" ;
           
         }else{
             
              sql = "select stock_detail_pl.description as produit , stock_detail_pl.prx_pm as prix , stock_detail_pl.arriver as arv , stock_detail_pl.depart as dp , "
                      + " nariv as arriv , ndep as dep , op_pl_f.id as ref_id , op_pl_f.date1 as jour , op_pl_f.admin as op "
                      + " , op_pl_f.motif as ref_mot , op_pl_f.comt as ref_comt , "
                      + "stock_detail_pl.type as vy , stock_detail_pl.ans as st_d , stock_detail_pl.ans_2 as st_a"
                      + " from stock_detail_pl , derive_pl , op_pl_f where datej BETWEEN '"+dte1+"' AND '"+dte2+"' "
                      + " AND stock_detail_pl.description = '"+this.description+"' "
                      + " AND ( stock_detail_pl.arriver = '"+zone+"' OR stock_detail_pl.depart = '"+zone+"' ) "
                      + " AND derive_pl.produit = stock_detail_pl.description "
                      + " AND op_pl_f.cb = stock_detail_pl.cb_op AND op_pl_f.motif = '"+motif+"'" ;
              
             
         }
            
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                
                 
                if("non".equalsIgnoreCase(rs.getString("vy"))){
                     
                if(rs.getString("arv").equalsIgnoreCase(this.zone)){
                    
                    if(stock_logique == 0 && vy == 0 ){
                        stock_logique = rs.getLong("st_a") ;
                        vy = 1 ;
                        
                    }
                    
                    //  "ID OP", "ANCIEN S.", "ARRIVER", "DEPART", "NOUVEAU S.", "MOTIF", "COMMENTATIRE", "ETAT"
                    
                    dtm.addRow(new Object[]{
                
                 rs.getLong("ref_id") ,sdfT1.format(rs.getTimestamp("jour")) , rs.getString("op") ,this.nf3.format(stock_logique) , this.nf3.format(rs.getLong("arriv")) , 0 , this.nf3.format((stock_logique+rs.getLong("arriv"))) , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                });
                    
                }else if(rs.getString("dp").equalsIgnoreCase(this.zone)){
                    
                    if(stock_logique == 0 && vy == 0 ){
                        stock_logique = rs.getLong("st_d") ;
                        vy = 1 ;
                        
                    }
                     
                     dtm.addRow(new Object[]{
                
                 rs.getLong("ref_id") ,sdfT1.format(rs.getTimestamp("jour")) , rs.getString("op") ,this.nf3.format(stock_logique) , 0 , this.nf3.format(rs.getLong("dep")) , this.nf3.format((stock_logique-rs.getLong("dep")))  , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                }) ;
                    
                }
                
                    
                    
                }else if("oui".equalsIgnoreCase(rs.getString("vy"))){
                    
                    
                
                // hasmap :
                HashMap<String, Object> m = new HashMap<>() ;
                
                
                
                if(rs.getString("arv").equalsIgnoreCase(this.zone)){
                    
                    if(stock_logique == 0 && vy == 0 ){
                        stock_logique = rs.getLong("st_a") ;
                        vy = 1 ;
                        
                    }
                    
                   m.put("id",  rs.getString("ref_id")) ;
                   m.put("arriver", this.nf3.format(rs.getLong("arriv"))) ;
                   m.put("depart", "0") ;
                   m.put("motif", rs.getString("ref_mot").toUpperCase()) ;
                   m.put("comt", rs.getString("ref_comt").toUpperCase()) ;
                  
                    
                    dtm.addRow(new Object[]{
                
               //  rs.getLong("ref_id") , this.nf3.format(rs.getLong("arriv")) , 0 , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    rs.getLong("ref_id") ,sdfT1.format(rs.getTimestamp("jour")) , rs.getString("op") ,this.nf3.format(stock_logique) , this.nf3.format(rs.getLong("arriv")) , 0 , this.nf3.format((stock_logique += rs.getLong("arriv"))) , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                        
                });
                    
                    
                   m.put("st_a", this.nf3.format(stock_logique-rs.getLong("arriv"))) ;
                   m.put("st_d", this.nf3.format((stock_logique))) ;
                   
                   this.bonList.add(m) ;
                    
                    
                    this.toA += rs.getLong("arriv") ;
                    
                }else if(rs.getString("dp").equalsIgnoreCase(this.zone)){
                    
                    if(stock_logique == 0 && vy == 0 ){
                        stock_logique = rs.getLong("st_d") ;
                        vy = 1 ;
                        
                    }
                    
                   m.put("id",  rs.getString("ref_id")) ;
                   m.put("arriver", "0") ;
                   m.put("depart", this.nf3.format(rs.getLong("dep"))) ;
                   m.put("motif", rs.getString("ref_mot").toUpperCase()) ;
                   m.put("comt", rs.getString("ref_comt").toUpperCase()) ;
                  
                    
                     dtm.addRow(new Object[]{
                
             //    rs.getLong("ref_id") , 0 , this.nf3.format(rs.getLong("dep")) , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                   rs.getLong("ref_id") ,sdfT1.format(rs.getTimestamp("jour")) , rs.getString("op") ,this.nf3.format(stock_logique) , 0 , this.nf3.format(rs.getLong("dep")) , this.nf3.format((stock_logique -= rs.getLong("dep")))  , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                         
                }) ;
                     
                      m.put("st_a", this.nf3.format(stock_logique+rs.getLong("dep"))) ;
                      m.put("st_d", this.nf3.format((stock_logique))) ;
                   
                      this.bonList.add(m) ;
                    
                     this.toD += rs.getLong("dep") ;
                    
                }
                
                
            }  
                
                /* old code :
                
                if("non".equalsIgnoreCase(rs.getString("vy"))){
                    
                    
                if(rs.getString("arv").equalsIgnoreCase(this.zone)){
                    
                  
                    
                    dtm.addRow(new Object[]{
                
                 rs.getLong("ref_id") ,this.nf3.format(rs.getLong("st_a")) , this.nf3.format(rs.getLong("arriv")) , 0 , this.nf3.format((rs.getLong("st_a")+rs.getLong("arriv"))) , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                });
                    
                }else if(rs.getString("dp").equalsIgnoreCase(this.zone)){
                    
                  
                    
                     dtm.addRow(new Object[]{
                
                  rs.getLong("ref_id") ,this.nf3.format(rs.getLong("st_d")) , 0 , this.nf3.format(rs.getLong("dep")) , this.nf3.format((rs.getLong("st_d")-rs.getLong("dep")))  , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                }) ;
                    
                }
                
                    
                }else if("oui".equalsIgnoreCase(rs.getString("vy"))){
                
                // hasmap :
                HashMap<String, Object> m = new HashMap<>() ;
                
                if(rs.getString("arv").equalsIgnoreCase(this.zone)){
                    
                   m.put("id",  rs.getString("ref_id")) ;
                   m.put("arriver", this.nf3.format(rs.getLong("arriv"))) ;
                   m.put("depart", "0") ;
                   m.put("motif", rs.getString("ref_mot").toUpperCase()) ;
                   m.put("comt", rs.getString("ref_comt").toUpperCase()) ;
                   m.put("st_a", this.nf3.format(rs.getLong("st_a"))) ;
                   m.put("st_d", this.nf3.format((rs.getLong("st_a")+rs.getLong("arriv")))) ;
                   
                   
                   this.bonList.add(m) ;
                    
                    this.toA += rs.getLong("arriv") ;
                    
                    dtm.addRow(new Object[]{
                
                  rs.getLong("ref_id") ,this.nf3.format(rs.getLong("st_a")) , this.nf3.format(rs.getLong("arriv")) , 0 , this.nf3.format((rs.getLong("st_a")+rs.getLong("arriv"))) , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                });
                    
                }else if(rs.getString("dp").equalsIgnoreCase(this.zone)){
                    
                   m.put("id",  rs.getString("ref_id")) ;
                   m.put("arriver", "0") ;
                   m.put("depart", this.nf3.format(rs.getLong("dep"))) ;
                   m.put("motif", rs.getString("ref_mot").toUpperCase()) ;
                   m.put("comt", rs.getString("ref_comt").toUpperCase()) ;
                   m.put("st_a", this.nf3.format(rs.getLong("st_d"))) ;
                   m.put("st_d", this.nf3.format((rs.getLong("st_d")-rs.getLong("dep")))) ;
                   
                   this.bonList.add(m) ;
                    
                    this.toD += rs.getLong("dep") ;
                    
                     dtm.addRow(new Object[]{
                
                  rs.getLong("ref_id") ,this.nf3.format(rs.getLong("st_d")) , 0 , this.nf3.format(rs.getLong("dep")) , this.nf3.format((rs.getLong("st_d")-rs.getLong("dep")))  , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                }) ;
                    
                }
                
            
                
            }
                
                */
                        
                        
            }
             
                 this.ta.setText(this.nf3.format(this.toA)); this.td.setText(this.nf3.format(this.toD)) ;
                 this.etat.setText(this.nf3.format((this.toA - this.toD))) ;
      
       
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
              
              
              
              }catch(Exception e){
                 JOptionPane.showMessageDialog(this, "SELECTIONNER LA PERIODE SVP") ;
              }
            
            
        }
        
        
        }else if(this.stock_1.equalsIgnoreCase(this.point.getSelectedItem().toString())){
            
            
        
        this.bonList.removeAll(bonList) ;
        this.toA = 0 ;
        this.toD = 0 ;
        String motif = "" ;
        motif = this.motif.getSelectedItem().toString().replaceAll("'", "''") ;
        
        if(this.jTable1.getSelectedRow() == -1 || this.zone.equals("POINT DE PLACEMENT") || "MOTIF".equalsIgnoreCase(motif)){
            JOptionPane.showMessageDialog(this, "SELECTIONNER LES PARAMETRES SVP") ;
        }else{
            
            motif = this.m_o ;
            
              try{
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
        SimpleDateFormat sdfT1 = new SimpleDateFormat("dd-MM-yyyy") ;
       
        this.dte1 = sdfT1.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        this.dte2 = sdfT1.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                          dtm.setRowCount(0) ;
                          
                          
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
           
           // matieres primaires :
           
           if(motif.equalsIgnoreCase(new String("TOUT"))){
               
               sql = "select stock2.qteet as arriv, stock2.qtest as dep, stock2.type as ref_mot ,facture_fourni.id as ref_id , "
                 + " facture_fourni.comt as ref_comt , stock2.et_ as vy , ans"
                 + " from stock2 , facture_fourni where desi = '"+this.description+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"' "
                 + " AND datec BETWEEN '"+dte1+"' AND '"+dte2+"' "
                 + " AND facture_fourni.cb = stock2.op_" ;
               
               
           }else if(motif.equalsIgnoreCase(new String("achat"))){
               
               sql = "select stock2.qteet as arriv, stock2.qtest as dep, stock2.type as ref_mot ,facture_fourni.id as ref_id , "
                 + " facture_fourni.comt as ref_comt , stock2.et_ as vy , ans"
                 + " from stock2 , facture_fourni where desi = '"+this.description+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"' "
                 + " AND datec BETWEEN '"+dte1+"' AND '"+dte2+"' "
                 + " AND stock2.type = 'achat' "
                 + " AND facture_fourni.cb = stock2.op_" ;
               
               
           }else if(motif.equalsIgnoreCase(new String("sortie"))){
               
               sql = "select stock2.qteet as arriv, stock2.qtest as dep, stock2.type as ref_mot ,facture_fourni.id as ref_id , "
                 + " facture_fourni.comt as ref_comt , stock2.et_ as vy , ans"
                 + " from stock2 , facture_fourni where desi = '"+this.description+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"' "
                 + " AND datec BETWEEN '"+dte1+"' AND '"+dte2+"' "
                 + " AND stock2.type = 'sortie' "
                 + " AND facture_fourni.cb = stock2.op_" ;
               
               
           }
           
         
           
            
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                
                if("non".equalsIgnoreCase(rs.getString("vy"))){
                    
                      
                if(rs.getString("ref_mot").equalsIgnoreCase(new String("achat"))){
                    
                   
                    
                    dtm.addRow(new Object[]{
                
                 rs.getLong("ref_id") , this.nf3.format(rs.getLong("ans")), this.nf3.format(rs.getLong("arriv")) , 0 , this.nf3.format(rs.getLong("ans")+rs.getLong("arriv")) ,rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                });
                    
                }else if(rs.getString("ref_mot").equalsIgnoreCase(new String("sortie"))){
                    
                   
                    
                     dtm.addRow(new Object[]{
                
                 rs.getLong("ref_id") , this.nf3.format(rs.getLong("ans")) , 0 , this.nf3.format(rs.getLong("dep")) , this.nf3.format(rs.getLong("ans")-rs.getLong("dep")) , rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                    
                }) ;
                    
                }
                
                    
                }else if("oui".equalsIgnoreCase(rs.getString("vy"))){
                
                // hasmap :
                HashMap<String, Object> m = new HashMap<>() ;
                
                if(rs.getString("ref_mot").equalsIgnoreCase(new String("achat"))){
                    
                   m.put("id",  rs.getString("ref_id")) ;
                   m.put("arriver", this.nf3.format(rs.getLong("arriv"))) ;
                   m.put("depart", "0") ;
                   m.put("motif", rs.getString("ref_mot").toUpperCase()) ;
                   m.put("comt", rs.getString("ref_comt").toUpperCase()) ;
                   m.put("st_a", this.nf3.format(rs.getLong("ans"))) ;
                   m.put("st_d", this.nf3.format(rs.getLong("ans")+rs.getLong("arriv"))) ;
                   
                   this.bonList.add(m) ;
                    
                    this.toA += rs.getLong("arriv") ;
                    
                    dtm.addRow(new Object[]{
                
                rs.getLong("ref_id") , this.nf3.format(rs.getLong("ans")), this.nf3.format(rs.getLong("arriv")) , 0 , this.nf3.format(rs.getLong("ans")+rs.getLong("arriv")) ,rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                     
                });
                    
                }else if(rs.getString("ref_mot").equalsIgnoreCase(new String("sortie"))){
                    
                   m.put("id",  rs.getString("ref_id")) ;
                   m.put("arriver", "0") ;
                   m.put("depart", this.nf3.format(rs.getLong("dep"))) ;
                   m.put("motif", rs.getString("ref_mot").toUpperCase()) ;
                   m.put("comt", rs.getString("ref_comt").toUpperCase()) ;
                   m.put("st_a", this.nf3.format(rs.getLong("ans"))) ;
                   m.put("st_d", this.nf3.format(rs.getLong("ans")-rs.getLong("dep"))) ;
                   
                   
                   this.bonList.add(m) ;
                    
                    this.toD += rs.getLong("dep") ;
                    
                     dtm.addRow(new Object[]{
                
                rs.getLong("ref_id") , this.nf3.format(rs.getLong("ans")), 0 , this.nf3.format(rs.getLong("dep")) , this.nf3.format(rs.getLong("ans")-rs.getLong("dep")) ,rs.getString("ref_mot").toUpperCase() ,rs.getString("ref_comt").toUpperCase() , rs.getString("vy")
                      
                }) ;
                    
                }
                
           
                
            }    
            }
            
            
             
                 this.ta.setText(this.nf3.format(this.toA)); this.td.setText(this.nf3.format(this.toD)) ;
                 this.etat.setText(this.nf3.format((this.toA - this.toD))) ;
      
       
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
              
              
              
              }catch(Exception e){
                 JOptionPane.showMessageDialog(this, "SELECTIONNER LA PERIODE SVP") ;
              }
            
            
        }
        
         
            
            
        }else if(this.point.getSelectedItem().toString().equalsIgnoreCase("POINT DE PLACEMENT") == true){
            
            JOptionPane.showMessageDialog(null, "CHOISIR UN POINT DE PLACEMENT OU LE MAGASIN PRINCIPAL !!! ") ;
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
         this.jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
         
        try{
                
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\detail_op.jrxml")) ;
              
            
            JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(this.bonList) ;
            
            
            Map<String, Object> para = new HashMap<>() ;
            
            // para.put("data", jrbean);
             
            para.put("periode","PERIODE : DU "+this.dte1+" AU : "+this.dte2) ;
            para.put("zone", "POINT DE PLACEMENT : "+this.zone) ;
            para.put("produit", "PRODUIT : "+this.description) ;
            para.put("toa", "TOTAL A : "+this.ta.getText()) ;
            para.put("tod", "TOTAL D : "+this.td.getText()) ;
            para.put("etat", "ETAT (A - D) : "+this.etat.getText()) ;
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

    private void motifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motifActionPerformed
        // TODO add your handling code here:
        
        this.m_o = "" ;
        
        if(this.motif.getSelectedItem().toString().equalsIgnoreCase("ARRIVAGE")){
            this.m_o = "achat" ;
        }else if(this.motif.getSelectedItem().toString().equalsIgnoreCase("DEPART")){
             this.m_o = "sortie" ;
        }else if(this.motif.getSelectedItem().toString().equalsIgnoreCase("TOUT")){
            
            this.m_o = "TOUT" ;
            
        }
        
    //        JOptionPane.showMessageDialog(null, "ETAT M_O : "+this.m_o) ;
        
        
    }//GEN-LAST:event_motifActionPerformed

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
            java.util.logging.Logger.getLogger(Detail_Op.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detail_Op.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detail_Op.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detail_Op.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Detail_Op().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField etat;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox motif;
    private javax.swing.JComboBox point;
    private javax.swing.JTextField produit;
    private javax.swing.JTextField ta;
    private javax.swing.JTextField td;
    // End of variables declaration//GEN-END:variables
}
