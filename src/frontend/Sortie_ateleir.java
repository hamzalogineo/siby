/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
 * @author hp
 */
public class Sortie_ateleir extends javax.swing.JFrame {

   
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/tp3_siby" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
    

  SimpleDateFormat sdf_mysql = new SimpleDateFormat("yyyy-MM-dd") ;
  SimpleDateFormat sdf_mysql_ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
  SimpleDateFormat sdf_java = new SimpleDateFormat("dd-MM-yyyy") ;
  SimpleDateFormat sdf_java_ = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
  
  
  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
 
      
       
      private int id_t;
      private int id_p;
      private String login ;
      
      
      
      Integer mtt = 0 ;
      
    List mlist1 ;
    List mlist2 ;
    
    public Sortie_ateleir(){
        
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
        
     //   -------------------------------------------------------------------
        
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
        
           this.jTable3.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable3.getTableHeader().setOpaque(false); 
            this.jTable3.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable3.getTableHeader().setForeground(Color.white) ;
        
              this.jTable3.setRowHeight(25) ;
              
        

                  for (int i = 0; i < this.jTable3.getModel().getColumnCount(); i++) {
                   
                      this.jTable3.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
                                }
                  
                  
                   //   -------------------------------------------------------------------
                  
                  
        
        //  ---------  2è choix
              
        
        
        
        
       //   ---------------
        
        
        //
        
       
        
     
        
          DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
          DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
          DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
        
          dtm.setRowCount(0) ;
          dtm2.setRowCount(0) ;
          dtm3.setRowCount(0) ;
          
          
          
          
          
           this.jTable3.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 4) ;
        
         
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        if("OUI".equalsIgnoreCase(status)){
            
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
           
        }else if("NON".equalsIgnoreCase(status)){
            
             setBackground(Color.RED) ;
             setForeground(Color.WHITE) ;
            
          } 
        
       
        
        
        if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
            
          
        return this;
        
    }   
});

      
        
               this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 6) ;
        
         
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        if("OUI".equalsIgnoreCase(status)){
            
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
           
        }else if("NON".equalsIgnoreCase(status)){
            
             setBackground(Color.RED) ;
             setForeground(Color.WHITE) ;
            
          } 
        
       
        
        
        if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
            
          
        return this;
        
    }   
});

            
          
          
this.jTable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 4) ;
        
         
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        if("OUI".equalsIgnoreCase(status)){
            
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
           
        }else if("NON".equalsIgnoreCase(status)){
            
             setBackground(Color.RED) ;
             setForeground(Color.WHITE) ;
            
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
      // STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      // STEP 3: Open a connection
     //  System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      // STEP 4: Execute a query
      // System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      // je crai ma requete
       
      
      String sql = null ;
      ResultSet rs = null ;
      
      sql = "select * from technicien where type = 'OUI' order by technicien asc" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
 
           this.tech_r1.addItem(new String(rs.getString("technicien"))) ;
          
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
    
    public void setLogin(String login){
        this.login = login ;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        du = new datechooser.beans.DateChooserCombo();
        jButton1 = new javax.swing.JButton();
        h2 = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        h1 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        au = new datechooser.beans.DateChooserCombo();
        tech_r1 = new javax.swing.JComboBox();
        bl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        mt = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        observ = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SUIVI REPARATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("AU");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("DU");

        du.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));

        jButton1.setBackground(new java.awt.Color(51, 102, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("RECHERCHER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        try {
            h2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h2.setText("23:59");
        h2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        h2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("HEURE");

        try {
            h1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h1.setText("00:00");
        h1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        h1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HEURE");

        au.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));

        tech_r1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUT" }));
        tech_r1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tech_r1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tech_r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tech_r1ActionPerformed(evt);
            }
        });

        bl.setEditable(false);
        bl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("BALANCE ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tech_r1, 0, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bl, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(du, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(au, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(du, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(au, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(1, 1, 1)))
                .addGap(0, 16, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tech_r1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "POS", "ID", "DATE", "TECHNICIEN", "TOTAL", "CB", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(1).setMinWidth(45);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(45);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(45);
            jTable1.getColumnModel().getColumn(2).setMinWidth(120);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(4).setMinWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(5).setMinWidth(0);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(6).setMinWidth(0);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jTable2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DESCRIPTION", "QTE", "P.U", "MTT", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(1).setMinWidth(100);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(100);
            jTable2.getColumnModel().getColumn(2).setMinWidth(100);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable2.getColumnModel().getColumn(3).setMinWidth(100);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(100);
            jTable2.getColumnModel().getColumn(4).setMinWidth(0);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jTable3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "DATE", "MTT", "OBSERVATION", "ETAT"
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
            jTable3.getColumnModel().getColumn(0).setMinWidth(0);
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable3.getColumnModel().getColumn(2).setMinWidth(100);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable3.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable3.getColumnModel().getColumn(4).setMinWidth(0);
            jTable3.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable3.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        mt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        mt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        mt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setText("MTT");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("OBSERVATION");

        observ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        observ.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        observ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                observActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 0, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("AJOUTER");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("ANNULER PY");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 102, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("IMPRIMER");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 0, 0));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("ANNULER OP");
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(mt, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(jLabel6))
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(observ)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jButton5))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mt)
                            .addComponent(observ, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
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

    private void h1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_h1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_h1ActionPerformed

    private void h2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_h2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_h2ActionPerformed

    private void observActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_observActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_observActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
            
        // D : 
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h1.getText() ;
        // System.out.println(this.n1) ;
        
        dte2 = dte2+" "+this.h2.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                             dtm.setRowCount(0) ;
                             
                               this.mlist1 = new ArrayList<>() ;
                               this.mlist2 = new ArrayList<>() ;
                             
                             int vy = 0 ;
                             int du = 0 ; 
                             int av = 0 ;
                             int reste = 0 ;
        
       String sql = null ;
       String sql1 = null ;
       String sql2 = null ;
       ResultSet rs = null ;
       
       if(this.tech_r1.getSelectedItem().toString().equalsIgnoreCase("TOUT")){
       
 //  "POS", "ID", "DATE", "USER", "TECHNICIEN", "TOTAL", "CB"
           
           sql = "select tache_at.pos as pos, tache_at.id_at as id, tache_at.user as login, tache_at.datej as date, technicien.technicien as fourni, "
                   + "tache_at.total as cat, tache_at.cb as cb, tache_at.etat as etat "
              + "from tache_at, technicien "
              + "where tache_at.datej between '"+dte1+"' and '"+dte2+"' and tache_at.type_at = 'OUT' and technicien.id_tech = tache_at.technicien "
              + "order by tache_at.datej desc" ;
           
           sql1 = "select tache_at.pos as pos, tache_at.id_at as id, tache_at.user as login, tache_at.datej as date, technicien.technicien as fourni, "
                   + "tache_at.total as cat, tache_at.cb as cb, tache_at.etat as etat "
              + "from tache_at, technicien "
              + "where tache_at.type_at = 'OUT' and technicien.id_tech = tache_at.technicien "
              + "order by tache_at.datej desc" ;
           
             vy = 0 ;
           
       }else if(this.tech_r1.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false){
       
     //  "POS", "ID", "DATE", "USER", "TECHNICIEN", "TOTAL", "CB"
           
           sql = "select tache_at.pos as pos, tache_at.id_at as id, tache_at.user as login, tache_at.datej as date, technicien.technicien as fourni, "
                   + "tache_at.total as cat, tache_at.cb as cb, tache_at.etat as etat "
              + "from tache_at, technicien "
              + "where tache_at.datej between '"+dte1+"' and '"+dte2+"' and tache_at.type_at = 'OUT' and tache_at.technicien = "+this.id_t+" "
                   + "and technicien.id_tech = tache_at.technicien "
              + "order by tache_at.datej desc" ;
           
           sql1 = "select tache_at.pos as pos, tache_at.id_at as id, tache_at.user as login, tache_at.datej as date, technicien.technicien as fourni, "
                   + "tache_at.total as cat, tache_at.cb as cb, tache_at.etat as etat "
              + "from tache_at, technicien "
              + "where tache_at.type_at = 'OUT' and tache_at.technicien = "+this.id_t+" "
                   + "and technicien.id_tech = tache_at.technicien "
              + "order by tache_at.datej desc" ;
           
           sql2 = "select * from py_technicien where cb_op = "+this.id_t+" order by id_py_tech desc" ;
           
           vy = 1 ;
           
       }
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
    if(rs.getString("etat").equalsIgnoreCase("OUI")){      
          
          HashMap<String, Object> m = new HashMap<>() ;
          
          m.put("pos",  rs.getString("pos")) ;
          m.put("id", rs.getString("id")) ;
          m.put("date", sdf1.format(rs.getTimestamp("date"))) ;
          m.put("technicien",  rs.getString("fourni")) ;
          m.put("total", this.nf3.format(rs.getInt("cat"))) ;
           
                      
                this.mlist1.add(m) ;
     
    }
          
        //  du += rs.getInt("cat") ;
        
   
      dtm.addRow(new Object[]{
     
      //   "POS", "ID", "DATE", "TECHNICIEN", "TOTAL", "CB"
   
  rs.getString("pos"), rs.getString("id") , sdf1.format(rs.getTimestamp("date")), rs.getString("fourni"), this.nf3.format(rs.getInt("cat")) , rs.getInt("cb") ,
  rs.getString("etat")           
        
        }) ;
 
     }
      
      
       rs = stmt.executeQuery(sql1) ;
     
      while(rs.next()){
     
     if(rs.getString("etat").equalsIgnoreCase("OUI")){  
          du += rs.getInt("cat") ;
     }
     
     }
      
      
      
      if(vy == 1){
          
          DefaultTableModel dtm_ = (DefaultTableModel) jTable3.getModel() ;
                            dtm_.setRowCount(0) ;
          
      rs = stmt.executeQuery(sql2) ;
      while(rs.next()){
          
          if(rs.getString("etat").equalsIgnoreCase("OUI")){  
  
           HashMap<String, Object> m = new HashMap<>() ;
           
          m.put("date", this.sdf_java_.format(rs.getTimestamp("datej"))) ;
          m.put("mtt",  this.nf3.format(rs.getInt("mtt"))) ;
          m.put("ob", rs.getString("observation")) ;
           
                      
                this.mlist2.add(m) ;
                
          
          
          av += rs.getInt("mtt") ;
          
          }
          
          //  "ID", "DATE", "MTT", "OBSERVATION", "ETAT"
          
         dtm_.addRow(new Object[]{
     
   //   "ID", "DATE", "MTT", "OBSERVATION"
   
          rs.getLong("id_py_tech"), this.sdf_java_.format(rs.getTimestamp("datej")), this.nf3.format(rs.getInt("mtt")) , rs.getString("observation") ,
           rs.getString("etat")
             
        
         }) ;
         
         
         
      }
              
      reste = (du - av) ;
      this.to = reste ;
      
      bl.setText(this.nf3.format(reste)) ;
              
              }else if(vy == 0){
                   bl.setText(this.nf3.format(du)) ;
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
            
       
        
        
    }catch(Exception e){
        
             DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                               dtm.setRowCount(0) ;
                               
                                this.mlist1 = new ArrayList<>() ;
                                this.mlist2 = new ArrayList<>() ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

long to = 0 ;
private String identity = "0" ;

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
       
         String cb = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 5).toString() ;
         String etat = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 6).toString() ;
      
         
         this.identity = cb ;
        
        
            // D : 
        
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h1.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h2.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
                             dtm.setRowCount(0) ;
                             
         
        
       String sql = null ;
       ResultSet rs = null ;
       
       long to = 0 ;
      
       
 //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
           
           sql = "select * from detail_at where cb_dt = "+cb ;
         
      
         rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
     
            // to += rs.getInt("mtt") ;
      
       dtm.addRow(new Object[]{
     
   //   "DESCRIPTION", "QTE", "P.U", "MTT"
   
          rs.getString("description"), this.nf3.format(rs.getInt("nbre")) , this.nf3.format(rs.getInt("pu")), this.nf3.format(rs.getInt("mtt")) ,
          etat
             
        
         }) ;
 
         }
         
         if(etat.equalsIgnoreCase("NON")){
             
             sql = "select login_an, date_an from tache_at where cb = "+this.identity ;
         
      
             rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
     
JOptionPane.showMessageDialog(null, "LOGIN : "+rs.getString("login_an")+System.getProperty("line.separator")+new String("DATE : "+this.sdf_java_.format(rs.getTimestamp("date_an")))) ;
      
         }
             
             
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
            
       
        
        
        
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void tech_r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tech_r1ActionPerformed
       
              Connection conn = null ;
              Statement stmt = null ;
       
       try{
      // STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      // STEP 3: Open a connection
     //  System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      // STEP 4: Execute a query
      // System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      // je crai ma requete
       
      
      String sql = null ;
      ResultSet rs = null ;
      
      this.id_t = 0 ;
      
      sql = "select * from technicien where technicien = '"+this.tech_r1.getSelectedItem().toString().replaceAll("'", "''")+"' and type = 'OUI' order by technicien asc" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          this.id_t = rs.getInt("id_tech") ;
          this.to = 0 ;
          
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
        
       
        
    }//GEN-LAST:event_tech_r1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        
        if(this.tech_r1.getSelectedItem().toString().equalsIgnoreCase("TOUT") || this.to == 0){
                   JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
        }else{
            
            // String cb = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 5).toString() ;
            
              String mt, observ ;
               mt = this.mt.getText().trim() ;
               observ = this.observ.getText().trim().replaceAll("'", "''") ;
               
               if(mt.isEmpty() || observ.isEmpty()){
                   JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
                }else{
                   
                   long vy_m = Long.parseLong(mt) ;
                   
                   if(vy_m > this.to){
                       JOptionPane.showMessageDialog(null, "MONTANT INCORRECT") ;
                   }else{
                   
                   
                   Connection conn = null ;
                   Statement stmt = null ;
       
       try{
      // STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      // STEP 3: Open a connection
     //  System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      // STEP 4: Execute a query
      // System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      // je crai ma requete
       
      
      
      
     // int mt = Integer.parseInt(mtt) ;
      
      String date ;
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
             
             date = sdf.format(new Date()) ;
          
      
          
    stmt.executeUpdate("insert into py_technicien(datej,mtt,observation,cb_op, etat) values('"
    +date+"' , "+mt+" , '"+observ+"' , "+this.id_t+" , 'OUI')") ;
          
    
     
       this.mt.setText(""); this.observ.setText(""); 
        
       
           this.jTable1.getSelectionModel().clearSelection();
           
           String sql = null ;
           ResultSet rs = null ;
           
           
                                 long to = 0 ;
                                 long py = 0 ;
       
 //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
           
           sql = "select * from tache_at where technicien = "+this.id_t+" and type_at = 'OUT'" ;
         
      
         rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
     
             to += rs.getInt("total") ;
      
      
 
         }
         
         
            DefaultTableModel dtm_ = (DefaultTableModel) jTable3.getModel() ;
                              dtm_.setRowCount(0) ;
                              
                               sql = "select * from py_technicien where cb_op = "+this.id_t+" order by id_py_tech desc" ;
         
      
         rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
             
             if(rs.getString("etat").equalsIgnoreCase("NON")){
                 
             }else if(rs.getString("etat").equalsIgnoreCase("OUI")){
     
             py += rs.getInt("mtt") ;
             
             }
      
       dtm_.addRow(new Object[]{
     
   //   "ID", "DATE", "MTT", "OBSERVATION"
   
          rs.getLong("id_py_tech"), this.sdf_java_.format(rs.getTimestamp("datej")), this.nf3.format(rs.getInt("mtt")) , rs.getString("observation") ,
           rs.getString("etat")
             
        
         }) ;
 
         }
         
         this.to = (to - py) ;

       
       bl.setText(this.nf3.format(this.to)) ;
         
      
      
               
     JOptionPane.showMessageDialog(null, "OPERATION REUSSIT !!!") ;
      
      
        
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
//      rs.close();
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
        
      
            
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

            
        if (JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS ANNULER ?", "CONFIRMATION",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        // yes option
        
        
        if(this.jTable3.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }else{
            
            String id =  this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0).toString() ;
            
                   Connection conn = null ;
                   Statement stmt = null ;
       
       try{
      // STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      // STEP 3: Open a connection
     //  System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      // STEP 4: Execute a query
      // System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      // je crai ma requete
       
      
       String sql = null ;
       ResultSet rs = null ;
      
     
          
    stmt.executeUpdate("update py_technicien set etat = 'NON' , login_an = '"+this.login.replace("'", "''")+"' , date_an = '"+this.sdf_mysql_.format(new Date())+"' "
            + "where id_py_tech = "+id) ;
          
 //   String cb = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 5).toString() ;
    
     DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
                             dtm.setRowCount(0) ;
    
           DefaultTableModel dtm_ = (DefaultTableModel) jTable3.getModel() ;
                             dtm_.setRowCount(0) ;
                             
                               long to = 0 ;
                               long py = 0 ;
       
 //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
           
           sql = "select * from tache_at where technicien = "+this.id_t ;
         
      
         rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
             
             if(rs.getString("etat").equalsIgnoreCase("OUI")){
              
             to += rs.getInt("total") ;
             
             }
      
      
 
         }
        
    
    sql = "select * from py_technicien where cb_op = "+this.id_t+" order by id_py_tech desc" ;
         
      
         rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
             
             if(rs.getString("etat").equalsIgnoreCase("NON")){
                 
             }else if(rs.getString("etat").equalsIgnoreCase("OUI")){
     
             py += rs.getInt("mtt") ;
             
             }
      
       dtm_.addRow(new Object[]{
     
   //   "ID", "DATE", "MTT", "OBSERVATION"
   
          rs.getLong("id_py_tech"), this.sdf_java_.format(rs.getTimestamp("datej")), this.nf3.format(rs.getInt("mtt")) , rs.getString("observation") ,
           rs.getString("etat")
             
        
         }) ;
 
         }
         
         this.to = (to - py) ;

       
       bl.setText(this.nf3.format(this.to)) ;
         
      
      
        
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
//      rs.close();
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
        
        
             }else{
                 
                  // NO OPTION :
                 
                 
                 
                 }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
      if(this.tech_r1.getSelectedItem().toString().equalsIgnoreCase("TOUT") || (this.mlist1.size() == 0)){
          JOptionPane.showMessageDialog(null, "PARAMETRE INCORRECT !") ;
      }else{
          
            try{
            
              this.jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
                  
                        // charge in local
         InputStream in = getClass().getClassLoader().getResourceAsStream("tp3_reporting/py_tech.jrxml") ;
         
               // collection generate
         JRBeanCollectionDataSource data1 = new JRBeanCollectionDataSource(this.mlist1) ;
         JRBeanCollectionDataSource data2 = new JRBeanCollectionDataSource(this.mlist2) ;
            
               // initialise parameter to send in reporting:
                 Map<String, Object> para = new HashMap<>() ;
                 
                 
                 
                 
   para.put("periode", "PERIODE : DU "+this.sdf_java.format(this.du.getSelectedDate().getTime())+" "+this.h1.getText()+" AU "+this.sdf_java.format(this.au.getSelectedDate().getTime())+" "+this.h2.getText()) ;
                 para.put("tech", this.tech_r1.getSelectedItem().toString()) ;
            para.put("balance", "BALANCE : "+this.bl.getText()) ;
            
            para.put("data1", data1) ;
            para.put("data2", data2) ;    
                  
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para,   new JREmptyDataSource()) ; // new JREmptyDataSource());
           
           JasperViewer.viewReport(print, false) ;
            
          //  JasperPrintManager.printReport(print, false) ;
            
            
             this.jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
               
             //   jasper printer :
        //
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        
        
        
        
          
      }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

               
        if (JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS ANNULER ?", "CONFIRMATION",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        // yes option
        
        
        if(this.jTable1.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "PARAMETRE INCORRECT !") ;
            
        }else{
        
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
       
      stmt.executeUpdate("update tache_at set etat = 'NON' , login_an = '"+this.login.replace("'", "''")+"' , date_an = '"+this.sdf_mysql_.format(new Date())+"' "
              + "where cb = "+this.identity) ;
      
      this.jTable1.setValueAt(new String("NON"), this.jTable1.getSelectedRow(), 6);
       
       

     // rs.close();
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
        
        }else{
           // no option : 
         
           }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseReleased
    
        if(this.jTable3.getSelectedRow() == -1){
            
        }else{
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
       String sql = null ;
       ResultSet rs = null ;
      
        if(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4).toString().equalsIgnoreCase("NON")){
             
             sql = "select login_an, date_an from py_technicien where id_py_tech = "+this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0).toString() ;
         
      
             rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
     
JOptionPane.showMessageDialog(null, "LOGIN : "+rs.getString("login_an")+System.getProperty("line.separator")+new String("DATE : "+this.sdf_java_.format(rs.getTimestamp("date_an")))) ;
      
         }
             
         rs.close();
             
         }
        
        
    
       

//        
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
            java.util.logging.Logger.getLogger(Sortie_ateleir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sortie_ateleir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sortie_ateleir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sortie_ateleir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sortie_ateleir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo au;
    private javax.swing.JTextField bl;
    private datechooser.beans.DateChooserCombo du;
    private javax.swing.JFormattedTextField h1;
    private javax.swing.JFormattedTextField h2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JFormattedTextField mt;
    private javax.swing.JTextField observ;
    private javax.swing.JComboBox tech_r1;
    // End of variables declaration//GEN-END:variables
}
