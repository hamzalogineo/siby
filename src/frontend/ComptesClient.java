/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.ProduitFini.JDBC_DRIVER;
import static frontend.VenteArticles.JDBC_DRIVER;
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
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRResultSetDataSource;
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
public class ComptesClient extends javax.swing.JFrame {

    /**
     * Creates new form ComptesClient
     */
    
    
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
      
      int rm1 = 0 ;
      int rm2 = 0 ;
      int rm3 = 0 ;
      int n = 0 ;
      long montant = 0 ;
      
      int rf = 0 ;
     
     String admin = "" ;
     String role = "" ;
     String dc = "" ;
     
     String cl = "" ;
       
     DefaultListModel dlm = new DefaultListModel() ;
     
     NumberFormat nf = NumberFormat.getInstance(new Locale("da", "DK"));
     
  
    
    
    public ComptesClient() {
          initComponents() ;
        this.setLocationRelativeTo(null);
          DateFormat datef = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
          Date date = new Date() ;
          this.dc = datef.format(date) ;
          
          
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
        
       
       
        
        //
       
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
        
        
        
        
        //  ---------  2è choix
              
        
        
        
        
       //   ---------------
        
        
        //
        
       
        
     
        
     //
       
            this.jTable3.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable3.getTableHeader().setOpaque(false) ; 
            this.jTable3.getTableHeader().setBackground(Color.black) ; 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable3.getTableHeader().setForeground(Color.white) ;
        
              this.jTable3.setRowHeight(25) ;
              
        
            

                  for (int i = 0; i < this.jTable3.getModel().getColumnCount(); i++) {
                    this.jTable3.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     
        
        
       
       
          
          
           Connection conn = null ;
           Statement stmt = null  ; 
       
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
      
        
         dlm.clear() ;
         
   
         String sql ;
      
         sql = "SELECT * FROM remises LIMIT 1" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
          while(rs.next()){
        
              this.rm1 = Integer.parseInt(rs.getString("remise1")) ;
              this.r1.setText("REMISE"+" DE "+rs.getString("remise1")+" %") ;
              this.rm2 = Integer.parseInt(rs.getString("remise2")) ;
              this.r2.setText("REMISE"+" DE "+rs.getString("remise2")+" %") ;
              this.rm3 = Integer.parseInt(rs.getString("remise3")) ;
              this.r3.setText("REMISE"+" DE "+rs.getString("remise3")+" %") ;
            
       
           }
     
     
     
       String sql4 ;
      
       sql4 = "SELECT * FROM clients ORDER BY entreprise" ;
      
       ResultSet rs4 = stmt.executeQuery(sql4) ;
      
      
          while(rs4.next()){
        
              dlm.addElement(rs4.getString("entreprise")) ;
       
           }
      
    this.jList1.setModel(dlm) ;
      
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs4.close();
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
    
    
    
    //
    
        public ComptesClient(String role){
          initComponents() ;
        this.setLocationRelativeTo(null);
          DateFormat datef = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
          Date date = new Date() ;
          this.dc = datef.format(date) ;
          
          this.role = role ;
          
          
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
        
       
       
        
        //
       
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
        
        
        
        
        //  ---------  2è choix
              
        
        
        
        
       //   ---------------
        
        
        //
        
       
        
     
        
     //
       
            this.jTable3.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable3.getTableHeader().setOpaque(false) ; 
            this.jTable3.getTableHeader().setBackground(Color.black) ; 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable3.getTableHeader().setForeground(Color.white) ;
        
              this.jTable3.setRowHeight(25) ;
              
        
            

                  for (int i = 0; i < this.jTable3.getModel().getColumnCount(); i++) {
                    this.jTable3.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     
        
        
       
       
          
          
           Connection conn = null ;
           Statement stmt = null  ; 
       
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
      
        
         dlm.clear() ;
         
   
         String sql ;
      
         sql = "SELECT * FROM remises LIMIT 1" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
          while(rs.next()){
        
              this.rm1 = Integer.parseInt(rs.getString("remise1")) ;
              this.r1.setText("REMISE"+" DE "+rs.getString("remise1")+" %") ;
              this.rm2 = Integer.parseInt(rs.getString("remise2")) ;
              this.r2.setText("REMISE"+" DE "+rs.getString("remise2")+" %") ;
              this.rm3 = Integer.parseInt(rs.getString("remise3")) ;
              this.r3.setText("REMISE"+" DE "+rs.getString("remise3")+" %") ;
            
       
           }
     
     
     
       String sql4 ;
      
       sql4 = "SELECT * FROM clients ORDER BY entreprise" ;
      
       ResultSet rs4 = stmt.executeQuery(sql4) ;
      
      
          while(rs4.next()){
        
              dlm.addElement(rs4.getString("entreprise")) ;
       
           }
      
    this.jList1.setModel(dlm) ;
      
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs4.close();
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
        
        
       if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR") || this.role.equalsIgnoreCase("ADMINISTRATEUR")){
          
          
      }else{
          
         this.r1.setEnabled(false);
         this.r2.setEnabled(false);
         this.r3.setEnabled(false);
         this.qte.setEnabled(false);
         this.rm.setEnabled(false);
         this.jButton4.setEnabled(false);
         this.jButton5.setEnabled(false);
         
          
      }
    
       
       
        
    }
    
    
    //
    
    
    

    public void setAdmin(String admin) {
        this.admin = admin;
    }
    
    
     private void clear1() {

        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        int n = model.getRowCount() ;
        for (int i = n - 1; i >= 0; --i) {
            model.removeRow(i);
        }
        
        
        
    }
     
     
     
     private void clear2() {

        DefaultTableModel model = (DefaultTableModel) this.jTable2.getModel();
        int n = model.getRowCount() ;
        for (int i = n - 1; i >= 0; --i) {
            model.removeRow(i);
        }
        
        
        
    }
     
     
     private void clear3() {

        DefaultTableModel model = (DefaultTableModel) this.jTable3.getModel() ;
        int n = model.getRowCount() ;
        for (int i = n - 1; i >= 0; --i) {
            model.removeRow(i);
        }
        
        
        
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        r1 = new javax.swing.JButton();
        client = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        r2 = new javax.swing.JButton();
        r3 = new javax.swing.JButton();
        py = new javax.swing.JButton();
        qte = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rm = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        tc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton18 = new javax.swing.JButton();
        ms = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("COMPTES CLIENT :");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("DETTE");

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Transaction", "Date", "Montant", "Remise %", "Utilisateur", "Client"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(85);
        }

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Transaction", "Date", "Montant", "Remise", "Utilisateur", "Client"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable2.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(3);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(35);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(3);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(5);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(60);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("REGLER");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESIGNATION", "QTE", "P.U", "MONTANT", "REPRISE"
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable3MouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(10);
            jTable3.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTable3.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        r1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        r1.setText("remise 1");
        r1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });

        client.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clientKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("CLIENT :");

        jList1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jList1MouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jList1);

        r2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        r2.setText("remise 2");
        r2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });

        r3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        r3.setText("remise 3");
        r3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3ActionPerformed(evt);
            }
        });

        py.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        py.setText("PAYER");
        py.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        py.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pyActionPerformed(evt);
            }
        });

        qte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setText("QTE");

        rm.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rm.setText("REPRISE");
        rm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton5.setText("FACTURE");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton4.setText("TICKET");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tc.setEditable(false);
        tc.setText("0");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("TOTAL DETTE  :");

        jLabel7.setText("MONTANT SOLDER PAR CE CLIENT");

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jDateChooser2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.jpg"))); // NOI18N
        jButton18.setBorder(null);
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.setMargin(new java.awt.Insets(6, 10, 6, 10));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        ms.setEditable(false);
        ms.setText("0");

        jLabel8.setText("Montant :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(qte, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rm, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tc, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(py, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(r3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(r2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(r1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ms)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(120, 120, 120))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(r2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(r3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(py, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rm, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(qte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(431, 431, 431))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 617, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
      
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jTable2MouseClicked

    private void clientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clientKeyPressed
        // TODO add your handling code here:
        
            String n1 = this.client.getText().replaceAll("'", "''").trim() ;
        
        
        if("".equalsIgnoreCase(n1)){
        
         //   JOptionPane jp=new JOptionPane() ;
        //   jp.showMessageDialog(null,"selectionner une matière primaire svp","Avertissement",JOptionPane.WARNING_MESSAGE);
  
        
        }else{
        
        
        
         Connection conn = null ;
         Statement stmt = null ;
       
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
      
      
      
          this.dlm.clear() ;
      
      
         
         
        String sql ;
      
         sql= "SELECT * FROM clients WHERE entreprise LIKE '%"+n1+"%' ORDER BY entreprise" ;
      
         ResultSet rs = stmt.executeQuery(sql) ;
      
      
       while(rs.next()){
      
        dlm.addElement(rs.getString("entreprise")) ;
        
                  }
        
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
        
       
     
     // Fin configure :
     
        
        
        //
        
        
        
        
        
        }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_clientKeyPressed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_jList1MouseClicked

    private void rmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1 || this.jTable3.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(this, "selectionner une facture et un produit pour la reprise svp ");
            
        }else{
            
            String q = this.qte.getText().trim() ;
            
            if("0".equalsIgnoreCase(q) || "".equalsIgnoreCase(q)){
                JOptionPane.showMessageDialog(this, "SAISIR LE MONTANT POUR LA REPRISE SVP") ;
            }else{
                try{
                 long q1 =(this.qt - Integer.parseInt(q)) ;
                 
                 if("oui".equalsIgnoreCase(this.rapport)){
                     
                     double q0 = 0.0 ;
                     q0 = (q1/1000.0) ;
                     double mt = 0.0 ;
                            mt = (this.pu * q0) ;
                            this.mt = Math.round(mt) ;
                            
                            
                            Connection conn = null ;
                            Statement stmt = null ;
       
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
      
      
if(stmt.executeUpdate("UPDATE detailfact SET qte = "+q1+" , montant = "+this.mt+" , reprise = "+Integer.parseInt(q)+" WHERE n = "+this.n+" AND desi = '"+this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0).toString().replaceAll("'", "''")+"' LIMIT 1") == 1){
      
      clear3() ;
      
       
      
         DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel() ;
         
         
         long newMt = 0 ;
         
         String sql ;
      
         sql = "SELECT * FROM detailfact WHERE n = "+this.n ;
      
         ResultSet rs = stmt.executeQuery(sql);
      
      
       while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
    // "DESIGNATION", "QTE", "P.U", "MONTANT", "REPRISE"
            
       rs.getString("desi") , rs.getLong("qte") ,
       rs.getLong("pu") , nf.format(rs.getLong("montant")) , rs.getInt("reprise")
          
        });
         
     
        newMt += rs.getLong("montant") ;
        
     }
      
       long nmt = 0 ;
       
       try{
        nmt = ((newMt * this.rf)/100) ;
       }catch(Exception e){
           
       }
       
       newMt = ( newMt - nmt ) ;
       
       stmt.executeUpdate("UPDATE facturef SET montant = "+newMt+" WHERE n = "+this.n) ;
       
       
       rs.close();
       this.qte.setText("0") ;
       
       JOptionPane.showMessageDialog(this, "reprise éffectuée avec succès") ;
       
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
        
       
     
     // Fin configure :
     
        
            
         //  fact :
                            
                            
                            
                            
                 }else{
                     
                     double q0 = 0.0 ;
                     q0 = q1  ;
                     double mt = 0.0 ;
                            mt = (this.pu * q0) ;
                            this.mt = Math.round(mt) ;
                            
                            
                            
                            
                             Connection conn = null ;
                            Statement stmt = null ;
       
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
      
      
if(stmt.executeUpdate("UPDATE detailfact SET qte = "+q1+" , montant = "+this.mt+" , reprise = "+Integer.parseInt(q)+" WHERE n = "+this.n+" AND desi = '"+this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0).toString().replaceAll("'", "''")+"' LIMIT 1") == 1){
      
      clear3() ;
      
       
      
         DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel() ;
         
         
         long newMt = 0 ;
         
         String sql ;
      
         sql = "SELECT * FROM detailfact WHERE n = "+this.n ;
      
         ResultSet rs = stmt.executeQuery(sql);
      
      
       while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
    // "DESIGNATION", "QTE", "P.U", "MONTANT", "REPRISE"
            
       rs.getString("desi") , rs.getLong("qte") ,
       rs.getLong("pu") , nf.format(rs.getLong("montant")) , rs.getInt("reprise")
          
        });
         
     
        newMt += rs.getLong("montant") ;
        
     }
      
       long nmt = 0 ;
       
       try{
        nmt = ((newMt * this.rf)/100) ;
       }catch(Exception e){
           
       }
       
       newMt = ( newMt - nmt ) ;
       
       stmt.executeUpdate("UPDATE facturef SET montant = "+newMt+" WHERE n = "+this.n) ;
       
       
       rs.close();
       this.qte.setText("0") ;
       
       JOptionPane.showMessageDialog(this, "reprise éffectuée avec succès") ;
       
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
        
       
     
     // Fin configure :
     
        
            
         //  fact :
                            
                            
                            
                     
                     
                 }
                 
                 
                
            
                 
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "LE MONTANT POUR LA REPRISE EST EN CHIFFRE UNIQUEMENT SVP") ;
                }
            }
            
        }
        
    }//GEN-LAST:event_rmActionPerformed

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selectionner une facture pour la remise svp") ;
        }else{
            
            double mtr1 = (this.montant - (this.montant * this.rm1)/100) ;           
            long mtr = Math.round(mtr1) ;
            
             // fact :
            
                Connection conn = null ;
                Statement stmt = null ;
       
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
      
      
      
    clear1() ;
      
      
       
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
    
         
         if(stmt.executeUpdate("UPDATE facturef SET remise = "+this.rm1+" , mttr = "+mtr+"  , reliqat = "+mtr+" WHERE n = "+this.n) == 1){
         
                            
         
         String sql ;
       
         sql= "SELECT * FROM facturef WHERE cl = '"+this.cl.replaceAll("'", "''")+"' AND type = 'd' ORDER BY id DESC" ;
      
         ResultSet rs = stmt.executeQuery(sql);
      
      
       while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
    // "N° Transaction", "Date", "Montant", "Remise", "Utilisateur", "Client"
            
       rs.getInt("n"), rs.getString("dtc") , nf.format(rs.getLong("montant")) ,
       rs.getInt("remise") , rs.getString("util")  ,
       rs.getString("cl") 
          
        });
         
     
        
     }
       
       
        rs.close();
        JOptionPane.showMessageDialog(this, "Remise appliquée sur la transaction") ;
        
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
        
       
     
     // Fin configure :
     
        
            
         //  fact :
            
            
            
            
            
        }
        
    }//GEN-LAST:event_r1ActionPerformed

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        // TODO add your handling code here:
        
        
         
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selectionner une facture pour la remise svp") ;
        }else{
            
            double mtr1 = (this.montant - (this.montant * this.rm2)/100) ;           
            long mtr = Math.round(mtr1) ;
            
             // fact :
            
                Connection conn = null ;
                Statement stmt = null ;
       
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
      
      
      
     clear1() ;
      
       
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
    
         
         if(stmt.executeUpdate("UPDATE facturef SET remise = "+this.rm2+" , mttr = "+mtr+"  , reliqat = "+mtr+" WHERE n = "+this.n) == 1){
         
                            
         
         String sql ;
       
         sql= "SELECT * FROM facturef WHERE cl = '"+this.cl.replaceAll("'", "''")+"' AND type = 'd' ORDER BY id DESC" ;
      
         ResultSet rs = stmt.executeQuery(sql);
      
      
       while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
    // "N° Transaction", "Date", "Montant", "Remise", "Utilisateur", "Client"
            
       rs.getInt("n"), rs.getString("dtc") , nf.format(rs.getLong("montant")) ,
       rs.getInt("remise") , rs.getString("util")  ,
       rs.getString("cl") 
          
        });
         
     
        
     }
       
       
        rs.close();
        JOptionPane.showMessageDialog(this, "Remise appliquée sur la transaction") ;
        
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
        
       
     
     // Fin configure :
     
        
            
         //  fact :
            
            
            
            
            
        }
        
        
    }//GEN-LAST:event_r2ActionPerformed

    private void r3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3ActionPerformed
        // TODO add your handling code here:
        
         
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selectionner une facture pour la remise svp") ;
        }else{
            
            double mtr1 = (this.montant - (this.montant * this.rm3)/100) ;           
            long mtr = Math.round(mtr1) ;
            
             // fact :
            
                Connection conn = null ;
                Statement stmt = null ;
       
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
      
      
      
     clear1() ;
      
      
       
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
    
         
         if(stmt.executeUpdate("UPDATE facturef SET remise = "+this.rm3+" , mttr = "+mtr+"  , reliqat = "+mtr+" WHERE n = "+this.n) == 1){
         
                            
         
         String sql ;
       
         sql= "SELECT * FROM facturef WHERE cl = '"+this.cl.replaceAll("'", "''")+"' AND type = 'd' ORDER BY id DESC" ;
      
         ResultSet rs = stmt.executeQuery(sql);
      
      
       while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
    // "N° Transaction", "Date", "Montant", "Remise", "Utilisateur", "Client"
            
       rs.getInt("n"), rs.getString("dtc") , nf.format(rs.getLong("montant")) ,
       rs.getInt("remise") , rs.getString("util")  ,
       rs.getString("cl") 
          
        });
         
     
        
     }
       
       
        rs.close();
        JOptionPane.showMessageDialog(this, "Remise appliquée sur la transaction") ;
        
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
        
       
     
     // Fin configure :
     
        
            
         //  fact :
            
            
            
            
            
        }
        
        
        
    }//GEN-LAST:event_r3ActionPerformed

    private void pyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pyActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selectionner une transaction pour le payement svp");
        }else{
            
           int reprise1 = 0 ;
           
           double mtr1 = (this.montant - (this.montant * this.rf)/100) ;
           long mtr = Math.round(mtr1) ;
           
                Connection conn = null ;
                Statement stmt = null ;
       
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
      
       
         
        String sql ;
      
        sql= "SELECT sum(reprise) FROM detailfact WHERE n = "+this.n ;
      
        ResultSet rs = stmt.executeQuery(sql);
      
      
       while(rs.next()){
        
        
        reprise1 = rs.getInt("sum(reprise)") ;
     
        
     }
       
       
       long montF = (mtr - reprise1) ;
       
       if(montF > 0){
           
       PayeFact  py = new   PayeFact(montF , this.n , this.cl.replaceAll("'", "''")) ;
       py.setVisible(true) ;
           
       }else{
           JOptionPane.showMessageDialog(this, "Verifier la facture il y'a des erreurs ");
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
        
        
    }//GEN-LAST:event_pyActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         try{
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS); 
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY); 
            ResultSet resultat = statement.executeQuery("SELECT id as id, desi as desi, qte as qte, "
                    + "pu as pu, reprise as remise, montant as montant, cl as client FROM detailfact WHERE cl = '"+this.cl+"' AND n = "+this.n+" ");
            
            Connection connection2 = DriverManager.getConnection(DB_URL,USER,PASS); 
            Statement statement2 = connection2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY); 
            ResultSet resultat2 = statement2.executeQuery("SELECT n as nData, cl as clientData FROM detailfact WHERE cl = '"+this.cl+"' AND n = "+this.n+" ");
            
            Connection connection3 = DriverManager.getConnection(DB_URL,USER,PASS); 
            Statement statement3 = connection3.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY); 
            ResultSet resultat3 = statement3.executeQuery("SELECT remise as remise FROM facturef WHERE cl = '"+this.cl+"' AND n = "+this.n+" ");
            
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\comptesClient.jrxml")) ;
            //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\comptesClient.jrxml")) ;
            
            
            long total = 0 ;
            long remise = 0;
            long net = 0;
            
            while(resultat3.next()) {
                remise = resultat3.getInt("remise");
            }
            
            List mlist;
            mlist = new ArrayList<>();
            
            while(resultat.next()) {
                HashMap<String, Object> m = new HashMap<>(); 
                m.put("id", resultat.getInt("id"));
                m.put("desi", resultat.getString("desi"));
                m.put("qte", resultat.getInt("qte"));
                m.put("pu", resultat.getInt("pu"));
                m.put("remise", resultat.getInt("remise"));
                m.put("montant", resultat.getInt("montant"));
                m.put("client", resultat.getString("client"));
                total += resultat.getInt("montant");
                net = total - ((total * remise) / 100);
                m.put("total", total);
                m.put("remise", remise);
                m.put("net", net);
                mlist.add(m);
            }
            
            List list;
            list = new ArrayList<>();
            while(resultat2.next()) {
                HashMap<String, Object> m = new HashMap<>(); 
                m.put("nData", resultat2.getInt("nData"));
                m.put("clientData", resultat2.getString("clientData"));
                list.add(m);
            }
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            JRBeanCollectionDataSource jrbean2 = new JRBeanCollectionDataSource(list);
            
            Map<String, Object> para = new HashMap<>();
            para.put("sql", jrbean);
            para.put("data", jrbean2);
            para.put("user", this.admin);
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean2);
            JasperViewer.viewReport(print, false);
            
       }catch(Exception e){
       
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       
       }
       
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here

                    try{

                        // n,cl,desi,qte,pu,montant,reprise

                        Class.forName(JDBC_DRIVER);
                        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
                        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY);
                        ResultSet resultat = statement.executeQuery("SELECT desi as desi, qte as qte, "
                            + "pu as pu, montant as montant FROM detailfact WHERE n = "+this.n+" AND cl = '"+this.cl+"'");

                        InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\venteArticles.jrxml")) ;
                        //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\venteArticles.jrxml")) ;

                        long total = 0 ;

                        List mlist;
                        mlist = new ArrayList<>();

                        while(resultat.next()) {
                            HashMap<String, Object> m = new HashMap<>();
                            m.put("desi", resultat.getString("desi"));
                            m.put("qte", resultat.getInt("qte"));
                            m.put("pu", resultat.getInt("pu"));
                            m.put("montant", resultat.getInt("montant"));
                            total += resultat.getInt("montant");
                            m.put("total", total);
                            mlist.add(m);
                        }

                        JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);

                        Map<String, Object> para = new HashMap<>();
                        para.put("sql", jrbean);
                        para.put("user", this.admin);
                        para.put("nData", this.n);
                        para.put("clientData", this.cl);

                        JasperReport report = JasperCompileManager.compileReport(in);
                        JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
                        JasperViewer.viewReport(print, false);

                    }catch(Exception e){

                        JOptionPane.showMessageDialog(null, e) ;
                        System.out.println(e) ;

                    }

    }//GEN-LAST:event_jButton4ActionPerformed
      long qt = 0 ; 
      long pu = 0 ;
      long mt = 0 ;
      String rapport = "" ;
      
    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
     
        try{
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy hh:mm") ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate()) ;
        String dte2 = sdf.format(this.jDateChooser2.getDate()) ;
        
        if(this.jList1.getSelectedIndex() == -1){
           
            JOptionPane.showMessageDialog(this,"Selectionner le client concerné dans la liste des clients et les 2 dates svp");
            
        }else{
            
             
            //  debut 
            
               
        long mt = 0 ;
        
       
            this.cl = "" ;
            this.cl = this.jList1.getSelectedValue().toString() ;
            
            
            // fact :
            
                Connection conn = null ;
                Statement stmt = null ;
       
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
      
      
      
     clear1() ;
     clear2() ;
     clear3() ;
      
      
      
      
    //   DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         DefaultTableModel dtm2 = (DefaultTableModel) jTable2.getModel() ;
         
         
      String sql ;
      
        sql= "SELECT * FROM facturef WHERE cl = '"+this.cl.replaceAll("'", "''")+"' AND dtc BETWEEN '"+dte1+"' AND '"+dte2+"' AND type = 'r' ORDER BY id DESC" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
       while(rs.next()){
        
        
        dtm2.addRow(new Object[]{
            
    // "N° Transaction", "Date", "Montant", "Remise", "Utilisateur", "Client"
            
       rs.getInt("n"), sdf1.format(rs.getDate("dtc")) , nf.format(rs.getLong("montant")) ,
       rs.getInt("remise") , rs.getString("util")  ,
       rs.getString("cl") 
          
        }) ;
         
        mt += rs.getLong("montant") ;
        
     }
       
          
      
     this.ms.setText(nf.format(mt)) ;
      
    
            
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
        
       
     
     // Fin configure :
     
        
            
         //  fact :
            
      
            
         // : end
            
            
        }
        

        }catch(Exception e){
              JOptionPane.showMessageDialog(this,"Selectionner le client concerné dans la liste des clients et les 2 dates svp");
        }

    }//GEN-LAST:event_jButton18ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        
          this.n = 0 ;
        this.montant = 0 ; 
        this.rf = 0 ;
        
        this.n = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString()) ;
        this.montant = Long.parseLong(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString().replaceAll("\\.", "")) ;
        this.rf = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString()) ;
        
        // debut :
        
                Connection conn = null ;
                Statement stmt = null ;
       
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
      
      
      
     clear3() ;
      
       
      
         DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel() ;
         
         
         
        String sql ;
      
        sql= "SELECT * FROM detailfact WHERE n = "+this.n ;
      
        ResultSet rs = stmt.executeQuery(sql);
      
      
       while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
    // "DESIGNATION", "QTE", "P.U", "MONTANT", "REPRISE"
            
       rs.getString("desi") , rs.getLong("qte") ,
       rs.getLong("pu") , nf.format(rs.getLong("montant")) , rs.getInt("reprise")
          
        });
         
     
        
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
        
       
     
     // Fin configure :
     
        
            
         //  fact :
            
            
        
        // fin   :
        
        
         this.py.setEnabled(true) ;
         this.rm.setEnabled(true) ;
         this.qte.setEditable(true) ;
         this.r1.setEnabled(true) ;
         this.r2.setEnabled(true) ;
         this.r3.setEnabled(true) ;
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
        
         try{
        this.n = 0 ;
        this.montant = 0 ; 
        this.rf = 0 ;
        
        this.n = Integer.parseInt(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString()) ;
        this.montant = Long.parseLong(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 2).toString().replaceAll("\\.", "")) ;
        this.rf = Integer.parseInt(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 3).toString()) ;
        
        // debut :
        
                Connection conn = null ;
                Statement stmt = null ;
       
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
      
      
      
      clear3() ;
      
       
      
         DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel() ;
         
         
         
        String sql ;
      
        sql= "SELECT * FROM detailfact WHERE n = "+this.n ;
      
        ResultSet rs = stmt.executeQuery(sql);
      
      
       while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
    // "DESIGNATION", "QTE", "P.U", "MONTANT", "REPRISE"
            
       rs.getString("desi") , rs.getLong("qte") ,
       rs.getLong("pu") , nf.format(rs.getLong("montant")) , rs.getInt("reprise")
          
        });
         
     
        
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
        
       
     
     // Fin configure :
     
        
            
         //  fact :
            
            
        
        // fin   :
        
      
        
         this.py.setEnabled(false) ;
         this.rm.setEnabled(false) ;
         this.qte.setEditable(false) ;
         this.r1.setEnabled(false) ;
         this.r2.setEnabled(false) ;
         this.r3.setEnabled(false) ;
      }catch(Exception e){
          JOptionPane.showMessageDialog(this, "Selectionner bien la transaction svp ") ;
      }
        
        
        
        
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void jList1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseReleased
        // TODO add your handling code here:
        
        
         long mt = 0 ;
        this.ms.setText("0");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        
        try{
            this.cl = "" ;
            this.cl = this.jList1.getSelectedValue().toString() ;
            
            
            // fact :
            
                Connection conn = null ;
                Statement stmt = null ;
       
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
      
      
      
     clear1() ;
     clear2() ;
     clear3() ;
      
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         DefaultTableModel dtm2 = (DefaultTableModel) jTable2.getModel() ;
         
         
      String sql ;
      
        sql= "SELECT * FROM facturef WHERE cl = '"+this.cl.replaceAll("'", "''")+"' AND type = 'd' ORDER BY id DESC" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
       while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
    // "N° Transaction", "Date", "Montant", "Remise", "Utilisateur", "Client"
            
       rs.getInt("n"), rs.getString("dtc") , nf.format(rs.getLong("montant")) ,
       rs.getInt("remise") , rs.getString("util")  ,
       rs.getString("cl") 
          
        }) ;
         
        mt += rs.getLong("montant") ;
        
     }
       
       
       
       
          String sql2 ;
      
        sql2 = "SELECT * FROM facturef WHERE cl = '"+this.cl.replaceAll("'", "''")+"' AND type = 'r' ORDER BY id DESC" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
       while(rs2.next()){
        
        
        dtm2.addRow(new Object[]{
            
    // "N° Transaction", "Date", "Montant", "Remise", "Utilisateur", "Client"
            
       rs2.getInt("n"), rs2.getString("dtc") , nf.format(rs2.getLong("montant")) ,
       rs2.getInt("remise") , rs2.getString("util")  ,
       rs2.getString("cl") 
          
        });
         
     
        
     }
       
    
          
      
     this.tc.setText(nf.format(mt)) ;
      
    
            
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
        
       
     
     // Fin configure :
     
        
            
         //  fact :
            
            
            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "SELECTIONNER UN CLIENT DANS LA LISTE SVP") ;
        }
        
        
        
        
        
        
    }//GEN-LAST:event_jList1MouseReleased

    private void jTable3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseReleased
        // TODO add your handling code here:
        
        
         String desi , qte , pu , mt ;
         desi = this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0).toString().replaceAll("'", "''") ;
         qte = this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1).toString() ;
         pu = this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2).toString() ;
         mt = this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3).toString() ;
        
        try{
            
            //
            this.qt = 0 ;
            this.mt = 0 ;
            this.pu = 0 ;
            
            this.qt = Long.parseLong(qte) ;
            this.mt = Long.parseLong(mt) ;
            this.pu = Long.parseLong(pu) ;
            
            
            
            
           Connection conn = null ;
           Statement stmt = null ;
       
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
      
      
       
       
      String sql ;
      
       sql = "SELECT * FROM produits_f WHERE description = '"+desi.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
      this.rapport = rs.getString("unite_m") ;
        
     
        
     }
     
      
      String sql1 ;
      
        sql1= "SELECT * FROM matieres_p WHERE description = '"+desi.replaceAll("'", "''")+"' LIMIT 1" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1);
      
      
     while(rs1.next()){
        
        
      this.rapport = rs1.getString("unite_mesure") ;
       
        
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
        
       
     
     // Fin configure :
     
        
        
        //
        
            this.qte.setText("0");
            //
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Bien selectionner dans le tableau svp") ;
        }
                
        
        
        
        
        
        
        
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
            java.util.logging.Logger.getLogger(ComptesClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComptesClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComptesClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComptesClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComptesClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField client;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField ms;
    private javax.swing.JButton py;
    private javax.swing.JTextField qte;
    private javax.swing.JButton r1;
    private javax.swing.JButton r2;
    private javax.swing.JButton r3;
    private javax.swing.JButton rm;
    private javax.swing.JTextField tc;
    // End of variables declaration//GEN-END:variables
}
