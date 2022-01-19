/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.CategorieM_tp3.JDBC_DRIVER;
import static frontend.Cmd.JDBC_DRIVER;
import static frontend.Sortie_ateleir.JDBC_DRIVER;
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
public class Gest_fond_achat extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/tp3_siby" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      private String pos;
      private String login;
      
  SimpleDateFormat sdf_mysql = new SimpleDateFormat("yyyy-MM-dd") ;
  SimpleDateFormat sdf_mysql_ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
  SimpleDateFormat sdf_java = new SimpleDateFormat("dd-MM-yyyy") ;
  SimpleDateFormat sdf_java_ = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
  
      
      
      
NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;


List mlist ;
      
    
    public Gest_fond_achat(){
        
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
        
    
        
        //  ---------  2è choix
              
        
        
        
        
       //   ---------------
        
        
        //
        
       
        
     
        
          DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
  
        
                            dtm.setRowCount(0) ;
         
        
        
        

    }
    

     public Gest_fond_achat(String login, String pos){
        
        initComponents() ;
        this.setLocationRelativeTo(null) ;
        
        this.login = login ;
        this.pos = pos ;
        
        this.h1.setText("00:00");
        this.h2.setText("23:59");
        
         // this.observ.setText(this.login+" "+this.pos) ;
         
            this.jTable1.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable1.getTableHeader().setOpaque(false) ; 
            this.jTable1.getTableHeader().setBackground(Color.black) ; 
          
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
                  
                  
                  
this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 7) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
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

      
        
                  
        
     
        
          DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                            dtm.setRowCount(0) ;
         
        
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
   
         
         
   
      
      sql = "SELECT * FROM fournisseur where type = 'OUI' order by fournisseur asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
            
        this.fr.addItem(new String(rs.getString("fournisseur"))) ;
        this.fr1.addItem(new String(rs.getString("fournisseur"))) ;
       
         
      
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        du = new datechooser.beans.DateChooserCombo();
        rech = new javax.swing.JButton();
        h2 = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        h1 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        au = new datechooser.beans.DateChooserCombo();
        t1 = new javax.swing.JLabel();
        fr = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        mtt = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        observ = new javax.swing.JTextField();
        fr1 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        rech1 = new javax.swing.JButton();
        observ1 = new javax.swing.JTextField();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GESTION FOND D'ACHAT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("AU");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("DU");

        du.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));

        rech.setBackground(new java.awt.Color(51, 102, 0));
        rech.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rech.setForeground(new java.awt.Color(255, 255, 255));
        rech.setText("RECHERCHER");
        rech.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechActionPerformed(evt);
            }
        });

        try {
            h2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        h1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        t1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t1.setText("TOTAL :");
        t1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        fr.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUT" }));
        fr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fr, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
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
                .addGap(18, 18, 18)
                .addComponent(rech, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(du, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rech)
                                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(2, 2, 2)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(au, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(fr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "POS", "DATE", "USER", "FOURNISSEUR", "ID", "MONTANT", "OBSERVATION", "TYPE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(4).setMinWidth(45);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(45);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(45);
            jTable1.getColumnModel().getColumn(5).setMinWidth(90);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(7).setMinWidth(0);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        jLabel5.setText("MONTANT ");

        mtt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        mtt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setText("OBSERVATION ");

        observ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        fr1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fr1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR FOURNISSEUR" }));
        fr1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fr1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 102, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("AJOUTER");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 0, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("ANNULER");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        rech1.setBackground(new java.awt.Color(51, 102, 0));
        rech1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rech1.setForeground(new java.awt.Color(255, 255, 255));
        rech1.setText("IMPRIMER");
        rech1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rech1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rech1ActionPerformed(evt);
            }
        });

        observ1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        observ1.setText("OBSERVATION RECHERCHE");
        observ1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                observ1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                observ1FocusLost(evt);
            }
        });
        observ1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                observ1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fr1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mtt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(observ, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rech1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(observ1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(fr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel6)
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(observ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rech1)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addComponent(mtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(observ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        
         
         String fr1 , mtt, observ ;
        fr1 = this.fr1.getSelectedItem().toString().trim().replaceAll("'", "''") ;
        mtt = this.mtt.getText().trim().replaceAll("'", "''") ;
        observ = this.observ.getText().trim().replaceAll("'", "''") ;
         
        
        if(fr1.equalsIgnoreCase("CHOISIR FOURNISSEUR") || mtt.isEmpty() || observ.isEmpty()){
            JOptionPane.showMessageDialog(this, "PARAMETRE INCORRECT") ;
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
       
      
      
      String sql = null ;
      ResultSet rs = null ;
      
     // int mt = Integer.parseInt(mtt) ;
      
      String date ;
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
             
             date = sdf.format(new Date()) ;
      
      if(stmt.executeUpdate("insert into fond_achat(pos,datej,user,fournisseur,mtt,observation,type) "
              + "values('"+this.pos+"' , '"+date+"' , '"+this.login+"', "+this.fourni_1+" , "+mtt+" , '"+observ+"' , 'OUI')") == 1){
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         /*
   
      
       sql = "SELECT * FROM categorie where type = 'oui' order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ref.produit", "Code Barre", "Description", "Prix Achat", "Prix vente"
            
           rs.getString("id_cat") , rs.getString("description"), rs.getString("ratio") , rs.getString("type")
         
        });
        
     }
      
    */
     
      this.fr1.setSelectedItem(new String("CHOISIR FOURNISSEUR")) ; this.mtt.setText("") ; this.observ.setText("");
      
      JOptionPane.showMessageDialog(null, "OPERATION REUSSIT !!!") ;
      
      
      }
      
      
     
      
    
            
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
        
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed
 private String id;
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
      
    this.id =  this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4).toString() ;
    
    String type =  this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 7).toString() ;
    
    
    
    if(type.equalsIgnoreCase("OUI")){
        
        this.jButton4.setEnabled(true);
        
    }else if(type.equalsIgnoreCase("NON")){
        
        this.jButton4.setEnabled(false);
        
        
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
       String sql = null ;
       ResultSet rs = null ;
      
         
             
             sql = "select login_an, date_an from fond_achat where id_fond = "+this.id ;
         
      
             rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
     
JOptionPane.showMessageDialog(null, "LOGIN : "+rs.getString("login_an")+System.getProperty("line.separator")+new String("DATE : "+this.sdf_java_.format(rs.getTimestamp("date_an")))) ;
      
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
        
        // fond_achat
        
        
    }
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 
               
        if (JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS ANNULER ?", "CONFIRMATION",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        // yes option 
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "PARAMETRE INCORRECT") ;
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
       
      
      
      String sql = null ;
      ResultSet rs = null ;
      
  
      
if(stmt.executeUpdate("update fond_achat set type = 'NON' , login_an = '"+this.login.replace("'", "''")+"' , date_an = '"+this.sdf_mysql_.format(new Date())+"' "
              + "where id_fond = "+this.id) == 1){
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         /*
   
      
       sql = "SELECT * FROM categorie where type = 'oui' order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        // "ref.produit", "Code Barre", "Description", "Prix Achat", "Prix vente"
            
           rs.getString("id_cat") , rs.getString("description"), rs.getString("ratio") , rs.getString("type")
         
        });
        
     }
      
    */
     
      this.fr1.setSelectedItem(new String("CHOISIR FOURNISSEUR")) ; this.mtt.setText("") ; this.observ.setText("");
      
      JOptionPane.showMessageDialog(null, "OPERATION REUSSIT !!!") ;
      
      
      }
      
      
     
      
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
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
            
            
            }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private int fourni = 0 ;
    
    private void frActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frActionPerformed
       
        
          
        String rech = this.fr.getSelectedItem().toString().trim().replaceAll("'", "''") ;
        
         
                
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
       
      
      this.fourni = 0 ;
      
      String sql = null ;
      ResultSet rs = null ;
      
     
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         
   
      
      sql = "SELECT id_fr FROM fournisseur where fournisseur = '"+rech+"' limit 1" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
       this.fourni = rs.getInt("id_fr") ;
        
         
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
        
          
      
        
        
    }//GEN-LAST:event_frActionPerformed

    private int fourni_1 = 0 ;

    private void fr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fr1ActionPerformed
       
        String rech = this.fr1.getSelectedItem().toString().trim().replaceAll("'", "''") ;
        
         
                
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
       
      
      this.fourni_1 = 0 ;
      
      String sql = null ;
      ResultSet rs = null ;
      
     
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
         
         
   
      
      sql = "SELECT id_fr FROM fournisseur where fournisseur = '"+rech+"' limit 1" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
       this.fourni_1 = rs.getInt("id_fr") ;
        
         
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
        
          
      
        
    }//GEN-LAST:event_fr1ActionPerformed

    private void rechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechActionPerformed

        
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
      
       
      long to = 0 ;
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                             dtm.setRowCount(0) ;
                             
                              this.mlist = new ArrayList<>() ;
                              
        
       String sql = null ;
       ResultSet rs = null ;
       
       if(this.fr.getSelectedItem().toString().equalsIgnoreCase("TOUT")){
           
           //  "POS", "DATE", "USER", "FOURNISSEUR", "ID", "MONTANT", "OBSERVATION", "TYPE"
      
      sql = "select fond_achat.pos as pos, fond_achat.datej as date, fond_achat.user as login, fournisseur.fournisseur as fourni, fond_achat.id_fond as id, "
              + "fond_achat.mtt as mtt, "
              + "fond_achat.observation as observ, fond_achat.type as type "
              + "from fond_achat, fournisseur "
              + "where fond_achat.datej between '"+dte1+"' and '"+dte2+"' and fournisseur.id_fr = fond_achat.fournisseur "
              + "order by fond_achat.datej desc" ;
       
       }else if(this.fr.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false){
           
           sql = "select fond_achat.pos as pos, fond_achat.datej as date, fond_achat.user as login, fournisseur.fournisseur as fourni, fond_achat.id_fond as id, "
                   + "fond_achat.mtt as mtt, "
              + "fond_achat.observation as observ, fond_achat.type as type "
              + "from fond_achat, fournisseur "
              + "where fond_achat.datej between '"+dte1+"' and '"+dte2+"' and fond_achat.fournisseur = "+this.fourni+" and fournisseur.id_fr = fond_achat.fournisseur "
              + "order by fond_achat.datej desc" ;
           
           
       }
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
          
          if(rs.getString("type").equalsIgnoreCase("NON")){
              
          }else if(rs.getString("type").equalsIgnoreCase("OUI")){
              
                HashMap<String, Object> m = new HashMap<>() ;
          
          m.put("pos",  rs.getString("pos")) ;
          m.put("date", sdf1.format(rs.getTimestamp("date"))) ;
          m.put("user", rs.getString("login")) ;
          m.put("four",  rs.getString("fourni")) ;
          m.put("id", rs.getString("id")) ;
          m.put("mtt", this.nf3.format(rs.getInt("mtt"))) ;
          m.put("ob", rs.getString("observ")) ;
                      
                this.mlist.add(m) ;
     
          
          to += rs.getInt("mtt") ;
          
          }
   
      dtm.addRow(new Object[]{
     
   //  "POS", "DATE", "USER", "FOURNISSEUR", "ID", "MONTANT", "OBSERVATION", "TYPE"
   
       rs.getString("pos"), sdf1.format(rs.getTimestamp("date")), rs.getString("login"), rs.getString("fourni") , rs.getString("id") 
              , this.nf3.format(rs.getInt("mtt")) , rs.getString("observ") , rs.getString("type")
        
        }) ;
 
     }

       this.t1.setText("TOTAL : "+nf3.format(to)) ;
       

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
                               
                               this.mlist = new ArrayList<>() ;
      
             t1.setText("TOTAL : 0") ;  
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
    }//GEN-LAST:event_rechActionPerformed

    private void rech1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rech1ActionPerformed
        // TODO add your handling code here:
        
        
         try{
            
              this.rech1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
                  
                        // charge in local
         InputStream in = getClass().getClassLoader().getResourceAsStream("tp3_reporting/fond_achat.jrxml") ;
         
               // collection generate
         JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.mlist) ;
            
               // initialise parameter to send in reporting:
                 Map<String, Object> para = new HashMap<>() ;
                 
                 
                 
                 
   para.put("periode", "PERIODE : DU "+this.sdf_java.format(this.du.getSelectedDate().getTime())+" "+this.h1.getText()+" AU "+this.sdf_java.format(this.au.getSelectedDate().getTime())+" "+this.h2.getText()) ;
                 para.put("total", this.t1.getText()) ;
            para.put("four", "FOURNISSEUR : "+this.fr.getSelectedItem().toString()) ;
                
                  
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para,   jrbean) ; // new JREmptyDataSource());
           
           JasperViewer.viewReport(print, false) ;
            
          //  JasperPrintManager.printReport(print, false) ;
            
            
             this.rech1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
               
             //   jasper printer :
        //
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_rech1ActionPerformed

    private void observ1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_observ1FocusGained
        // TODO add your handling code here:
        
        String ob = this.observ1.getText().trim().replaceAll("'", "''") ;
               
        if(ob.equalsIgnoreCase("OBSERVATION RECHERCHE")){
            this.observ1.setText("") ;
        }
        
        
    }//GEN-LAST:event_observ1FocusGained

    private void observ1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_observ1FocusLost
       
        String ob = this.observ1.getText().trim().replaceAll("'", "''") ;
               
        if(ob.isEmpty()){
            this.observ1.setText("OBSERVATION RECHERCHE") ;
        }
        
    }//GEN-LAST:event_observ1FocusLost

    private void observ1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_observ1KeyReleased
        // TODO add your handling code here:

         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;    
        
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
       
      long to = 0 ;
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                             dtm.setRowCount(0) ;
                             
                              this.mlist = new ArrayList<>() ;
                              
        
       String sql = null ;
       ResultSet rs = null ;
       
       if(this.fr.getSelectedItem().toString().equalsIgnoreCase("TOUT")){
           
           //  "POS", "DATE", "USER", "FOURNISSEUR", "ID", "MONTANT", "OBSERVATION", "TYPE"
      
      sql = "select fond_achat.pos as pos, fond_achat.datej as date, fond_achat.user as login, fournisseur.fournisseur as fourni, fond_achat.id_fond as id, "
              + "fond_achat.mtt as mtt, "
              + "fond_achat.observation as observ, fond_achat.type as type "
              + "from fond_achat, fournisseur "
              + "where fond_achat.observation like '%"+this.observ1.getText().trim().replaceAll("'", "''")+"%' and fournisseur.id_fr = fond_achat.fournisseur "
              + "order by fond_achat.datej desc" ;
       
       }else if(this.fr.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false){
           
           sql = "select fond_achat.pos as pos, fond_achat.datej as date, fond_achat.user as login, fournisseur.fournisseur as fourni, fond_achat.id_fond as id, "
                   + "fond_achat.mtt as mtt, "
              + "fond_achat.observation as observ, fond_achat.type as type "
              + "from fond_achat, fournisseur "
              + "where fond_achat.observation like '%"+this.observ1.getText().trim().replaceAll("'", "''")+"%' and fond_achat.fournisseur = "+this.fourni+" and fournisseur.id_fr = fond_achat.fournisseur "
              + "order by fond_achat.datej desc" ;
           
           
       }
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
          
          if(rs.getString("type").equalsIgnoreCase("NON")){
              
          }else if(rs.getString("type").equalsIgnoreCase("OUI")){
              
                HashMap<String, Object> m = new HashMap<>() ;
          
          m.put("pos",  rs.getString("pos")) ;
          m.put("date", sdf1.format(rs.getTimestamp("date"))) ;
          m.put("user", rs.getString("login")) ;
          m.put("four",  rs.getString("fourni")) ;
          m.put("id", rs.getString("id")) ;
          m.put("mtt", this.nf3.format(rs.getInt("mtt"))) ;
          m.put("ob", rs.getString("observ")) ;
                      
                this.mlist.add(m) ;
     
          
          to += rs.getInt("mtt") ;
          
          }
   
      dtm.addRow(new Object[]{
     
   //  "POS", "DATE", "USER", "FOURNISSEUR", "ID", "MONTANT", "OBSERVATION", "TYPE"
   
       rs.getString("pos"), sdf1.format(rs.getTimestamp("date")), rs.getString("login"), rs.getString("fourni") , rs.getString("id") 
              , this.nf3.format(rs.getInt("mtt")) , rs.getString("observ") , rs.getString("type")
        
        }) ;
 
     }

       this.t1.setText("TOTAL : "+nf3.format(to)) ;
       

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
            
       
            
        
        
        
    }//GEN-LAST:event_observ1KeyReleased

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
            java.util.logging.Logger.getLogger(Gest_fond_achat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gest_fond_achat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gest_fond_achat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gest_fond_achat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gest_fond_achat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo au;
    private datechooser.beans.DateChooserCombo du;
    private javax.swing.JComboBox fr;
    private javax.swing.JComboBox fr1;
    private javax.swing.JFormattedTextField h1;
    private javax.swing.JFormattedTextField h2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JFormattedTextField mtt;
    private javax.swing.JTextField observ;
    private javax.swing.JTextField observ1;
    private javax.swing.JButton rech;
    private javax.swing.JButton rech1;
    private javax.swing.JLabel t1;
    // End of variables declaration//GEN-END:variables
}
