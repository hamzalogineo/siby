/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.Nouvelle_commande.JDBC_DRIVER;
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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
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
public class Suivit_gateau extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      
      private NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      
      long id ;
      Integer cb ;
      String etat ;
      String login ;
      String role ;
      Integer cb_model ;
      
        SimpleDateFormat sdf_ = new SimpleDateFormat("dd-MM-yyyy") ;
        
        String aujourdui = sdf_.format(new Date()) ;
      
    public Suivit_gateau() {
        initComponents();
        this.setTitle("SUIVI COMMANDE GATEAU");
        this.setLocationRelativeTo(null);
        this.an.setEnabled(false) ;
        
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
                         
                  headerRenderer.setBackground(Color.green) ;
                  headerRenderer.setForeground(Color.BLACK) ;
                  headerRenderer.setFont(new Font("Segoe UI" , Font.BOLD , 16)) ;

                  for (int i = 0; i < this.jTable2.getModel().getColumnCount(); i++) {
                    this.jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
                  
                  
                  
              
                  
                  
// COLORATION DE MES LISTE CODE DE PERSONNALISATION DE MA LISTE :
                   
    this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;
        
     //   Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 7) ;
        String bn = (String) table.getModel().getValueAt(row, 8) ;
        String cd = (String) table.getModel().getValueAt(row, 9) ;
        
      
        String rdv = (String) table.getModel().getValueAt(row, 3).toString().substring(0, 10) ;
     // String rdv_compare = rdv.substring(0,10) ;
        
       // System.out.println(rdv);
        
        // :
        
          // conf :
                  
                   // right align 2nd column
                    TableColumnModel columnModel = jTable1.getColumnModel();
                    
                    TableColumn column_0 = columnModel.getColumn(0);
                    TableColumn column_1 = columnModel.getColumn(1);
                    TableColumn column_2 = columnModel.getColumn(2);
                    TableColumn column_3 = columnModel.getColumn(3);
                    TableColumn column_4 = columnModel.getColumn(4);
                    TableColumn column_5 = columnModel.getColumn(5);
                    TableColumn column_6 = columnModel.getColumn(6);
                    TableColumn column_7 = columnModel.getColumn(9);
                    
                    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTable1.getCellRenderer(row, col) ;
                    DefaultTableCellRenderer renderer_ = (DefaultTableCellRenderer) jTable1.getCellRenderer(row, col) ;
                    
                     
                    
                    
                   // nouveauR.setHorizontalAlignment(JLabel.RIGHT); // RIGHT
                    
                     column_1.setCellRenderer(renderer);
                     column_4.setCellRenderer(renderer);
                     
                    
                    
                    renderer.setHorizontalAlignment(JLabel.RIGHT); // RIGHT
                    
                    renderer_.setHorizontalAlignment(JLabel.LEFT); // RIGHT
                    
                    
                    column_0.setCellRenderer(renderer_);
                   
                    column_2.setCellRenderer(renderer_);
                    column_3.setCellRenderer(renderer_);
                    
                    column_5.setCellRenderer(renderer_);
                    column_6.setCellRenderer(renderer_);
                    column_7.setCellRenderer(renderer_);
                     
                     //
                    
                    
                     
                    
                    jTable1.getColumnModel().getColumn(0).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
                    
                   jTable1.getColumnModel().getColumn(1).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
                   
                   jTable1.getColumnModel().getColumn(2).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
                   
                   jTable1.getColumnModel().getColumn(3).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER)) ;
                   
                   jTable1.getColumnModel().getColumn(4).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER)) ;
                   
                   jTable1.getColumnModel().getColumn(5).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
                   
                   jTable1.getColumnModel().getColumn(6).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER)); 
                   
                   jTable1.getColumnModel().getColumn(7).setHeaderRenderer(
        new HorizontalAlignmentHeaderRenderer(SwingConstants.CENTER));
                   
                   
                  
                  // conf :
                  
        
        // :
           
                    
                    DefaultTableCellRenderer MyCellrendar = new DefaultTableCellRenderer() ;
                    
                    
                    if(cd.equalsIgnoreCase("NON")){
                     
                        MyCellrendar.setBackground(Color.WHITE) ;
                        MyCellrendar.setForeground(Color.BLACK);
                        
                        jTable1.getColumnModel().getColumn(9).setCellRenderer(MyCellrendar) ;
    
                          
                        
                    }else if(cd.equalsIgnoreCase("OUI")){
                        
                       MyCellrendar.setBackground(Color.GREEN) ;
                       MyCellrendar.setForeground(Color.WHITE);
                       jTable1.getColumnModel().getColumn(9).setCellRenderer(MyCellrendar) ;
                        
                    }
                    
                    
               
         if(aujourdui.equalsIgnoreCase(rdv) && "oui".equalsIgnoreCase(status)){
        
            this.setBackground(Color.ORANGE);
            this.setForeground(Color.white);
            
        }else if("oui".equalsIgnoreCase(status) && aujourdui.equalsIgnoreCase(rdv) == false) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
            setBackground(Color.red);
            setForeground(Color.WHITE);
            
        } 
        
       
        
        
       if(bn.equalsIgnoreCase("1")){
            setBackground(Color.gray);
            setForeground(Color.WHITE);
       }
        
        if("non".equalsIgnoreCase(status)){
            setBackground(Color.red);
            setForeground(Color.WHITE);
            
        } 
        
       if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
            
          
        return this;
        
    }   
});



    

// tableau 2 :


  this.jTable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 5) ;
        
         
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        
         
        if("gs".equalsIgnoreCase(status)) {
            
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
          
        }else if("model".equalsIgnoreCase(status)){
             
             setBackground(Color.BLUE);
             setForeground(Color.WHITE);
            
        }else{
             setBackground(Color.WHITE);
             setForeground(Color.BLACK);
        } 
        
   
        
        
        if(isSelected){
            
            setBackground(Color.gray);
            setForeground(Color.WHITE);
        }
            
          
        return this;
        
    }   
}) ;
  

  

                   
                   
                                // END  JTABLE CELL COLORATION FOR PERSONNALISATION : 
                                    
                                    



                  
             
                  
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
            
          SimpleDateFormat sdf_1 = new SimpleDateFormat("yyyy-MM-dd") ;
        
        
        Date aujourdui = sdf_1.parse(sdf_1.format(new Date())) ;
        

            sql =  "select * from commande_client order by id desc , rdv asc limit 3000" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){
                
                if(rs.getDate("rdv").compareTo(aujourdui) < 0 || rs.getString("etat").equalsIgnoreCase("NON")){
                    
                    
                }else{

            // "DATE", "ID", "CLIENT", "RDV", "PRIX", "LOGIN", "CODE BARRE", "ETAT"
                
                dtm1.addRow(new Object[]{
                    
this.sdf.format(rs.getTimestamp("jour")) , rs.getLong("id") , rs.getString("client") , this.sdf.format(rs.getTimestamp("rdv")) ,
nf3.format(rs.getLong("devis")) , rs.getString("login") , rs.getInt("cb") , rs.getString("etat") , rs.getString("bon") , 
rs.getString("cd")
                        
                }) ;
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
                   
        
        
                                    
        Calendar cal = Calendar.getInstance();
        
        Date j = cal.getTime() ;
        this.jDateChooser1.setDate(j) ;
      
        
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bnt = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        an = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cp = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SUIVI COMMANDE GATEAU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("RDV :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("      HEURE");

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("RECHERCHER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DATE", "ID", "CLIENT", "RDV", "PRIX", "LOGIN", "CODE BARRE", "ETAT", "BON", "CONF.D"
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
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(125);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(125);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(125);
            jTable1.getColumnModel().getColumn(1).setMinWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(2).setMinWidth(150);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(3).setMinWidth(125);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(125);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(125);
            jTable1.getColumnModel().getColumn(4).setMinWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(5).setMinWidth(90);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(6).setMinWidth(0);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(7).setMinWidth(45);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(45);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(45);
            jTable1.getColumnModel().getColumn(8).setMinWidth(0);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(9).setMinWidth(55);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(55);
            jTable1.getColumnModel().getColumn(9).setMaxWidth(55);
        }

        bnt.setBackground(new java.awt.Color(51, 51, 255));
        bnt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bnt.setForeground(new java.awt.Color(255, 255, 255));
        bnt.setText("COPIE BON");
        bnt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("CONF. DISPO. ");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        an.setBackground(new java.awt.Color(51, 51, 255));
        an.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        an.setForeground(new java.awt.Color(255, 255, 255));
        an.setText("ANNULER");
        an.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        an.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("OBSERVATION");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "DESCRIPTION / OPTION", "DIMENSION", "PRIX DE BASE", "OBSERVATION", "CB", "CL"
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
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(260);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(260);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(260);
            jTable2.getColumnModel().getColumn(1).setMinWidth(90);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(90);
            jTable2.getColumnModel().getColumn(2).setMinWidth(90);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(90);
            jTable2.getColumnModel().getColumn(4).setMinWidth(0);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(4).setMaxWidth(0);
            jTable2.getColumnModel().getColumn(5).setMinWidth(0);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        jButton4.setBackground(new java.awt.Color(51, 51, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("DETAIL CMD");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("PANIER DE LA COMMANDE");

        cl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("        RECHERCHER PAR CLIENT");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        try {
            jTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("RDV PROCHE");

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 102, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("COMMANDE ANNULER");

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("COPIE EDITER");

        jPanel5.setBackground(new java.awt.Color(0, 255, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("DISPONIBILITER");

        code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codeKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ID");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        cp.setText(" ");
        cp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(an, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTextField2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60)
                        .addComponent(bnt, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cl, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(37, 37, 37))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(cl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(an, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)))
                        .addContainerGap())
                    .addComponent(bnt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "SELECTIONNER UNE COMMANDE") ;
        }else{
        
        DetailCommandeSuivit dcs = new DetailCommandeSuivit(this.id , this.cb) ;
                             dcs.setVisible(true) ;
                             
        
        }
                             
    }//GEN-LAST:event_jButton4ActionPerformed
String bn_a ;
String cod ;
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        this.jTable2.getSelectionModel().clearSelection() ;
        
        this.id = 0 ;
        this.cb = 0 ;
        this.cod = "" ;
        
        
        this.id = Long.parseLong(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()) ;
        this.cb = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 6).toString()) ;
        this.etat = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 7).toString() ;
        this.bn_a = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 8).toString() ;
        this.cod = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 9).toString() ;
        
       
        
        
        if(this.cod.equalsIgnoreCase("OUI")){
            
            this.jButton3.setEnabled(false) ;
           
            
        }else if(this.cod.equalsIgnoreCase("NON")){
            
            this.jButton3.setEnabled(true) ;
            
        }
        
        
         if(this.etat.equalsIgnoreCase("OUI")){
            
            this.an.setEnabled(true) ;
            this.jTextField2.setEditable(true);
            this.bnt.setEnabled(true) ;
            this.jButton3.setEnabled(true) ;
            
        }else if(this.etat.equalsIgnoreCase("NON")){
            
            this.an.setEnabled(false) ;
            this.jTextField2.setEditable(false);
            this.bnt.setEnabled(false) ;
            this.jButton3.setEnabled(false) ;
            
        }
        
        
        
        
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
            
          

            sql =  "select * from detail_commande_client where cb = "+this.cb ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

            // "DESCRIPTION / OPTION", "DIMENSION", "PRIX DE BASE", "OBSERVATION"
                
                dtm2.addRow(new Object[]{
                    
rs.getString("description") , rs.getString("dimension") , this.nf3.format(rs.getInt("prx")) , rs.getString("observation") , rs.getInt("cb_model") ,
                    rs.getString("couleur")
                        
                }) ;

                
            }
            
            sql = "select motif , user_d from commande_client where id = "+this.id ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
            
                if(rs.getString("motif").isEmpty()){
                    
                }else{
                    JOptionPane.showMessageDialog(null, "OPERATEUR : "+rs.getString("user_d")+System.getProperty("line.separator")+" OBSERVATION : "+rs.getString("motif")+System.getProperty("line.separator")) ;
                }
                
            }
 
            sql = "select bon , user_bon from commande_client where id = "+this.id ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                
                if(rs.getString("bon").equalsIgnoreCase("0")){
                    
                }else if(rs.getString("bon").equalsIgnoreCase("1")){
                    
                    JOptionPane.showMessageDialog(null, "COPIE EDITER"+System.getProperty("line.separator")+" OP : "+rs.getString("user_bon"));
                    
                }
                
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
            
            sql = "select cd , user_cd , date_cd from commande_client where id = "+this.id ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                
                if(rs.getString("cd").equalsIgnoreCase("NON")){
                    
                }else if(rs.getString("cd").equalsIgnoreCase("OUI")){
                    
JOptionPane.showMessageDialog(null, "CONF.D INFO : "+System.getProperty("line.separator")+" OP : "+rs.getString("user_cd")+" "
        +System.getProperty("line.separator")+" DATE TIME : "+sdf.format(rs.getTimestamp("date_cd"))) ;
                    
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
                   
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
        this.jTable1.getSelectionModel().clearSelection();
        
        this.cb_model = 0 ;

  this.cb_model = Integer.parseInt(jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString()) ;


if(this.cb_model == Integer.parseInt("0")){
    
}else{
    
    Detail_Panier_Gt dpc = new Detail_Panier_Gt(this.cb_model) ;
                     dpc.setVisible(true);
    
    }
        
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try{

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate()) ; // +" "+this.jTextField1.getText() ;
        
        
         DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                           dtm1.setRowCount(0) ;
               
                             
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
            
          

            sql =  "select * from commande_client where rdv like '%"+dte1+"%' order by rdv asc" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

            // "DATE", "ID", "CLIENT", "RDV", "PRIX", "LOGIN", "CODE BARRE", "ETAT"
                
                dtm1.addRow(new Object[]{
                    
this.sdf.format(rs.getTimestamp("jour")) , rs.getLong("id") , rs.getString("client") , this.sdf.format(rs.getTimestamp("rdv")) ,
nf3.format(rs.getLong("devis")) , rs.getString("login") , rs.getInt("cb") , rs.getString("etat"),rs.getString("bon") ,
 rs.getString("cd")
                }) ;

                
            }
            
            
            
   sql =  "select count(*) from commande_client where rdv like '%"+dte1+"%' and etat = 'OUI'" ;

   rs = stmt.executeQuery(sql) ;

            while(rs.next()){

            this.cp.setText("SIBY-CENTER A "+nf3.format(rs.getInt(1))+" COMMANDE(S)") ;

                
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
                   
        
        
        
        
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "CHOISIR UN RDV DE LIVRAISON");
            
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void anActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anActionPerformed
        // TODO add your handling code here:
        
        
        
        if(role.equalsIgnoreCase("ORDINAIRE")){
            JOptionPane.showMessageDialog(null, "DEMANDE REFUSEE") ;
        }else{
        String motif = "" ;
               motif = this.jTextField2.getText().trim().replaceAll("'", "''") ;
               
               
               if(this.jTable1.getSelectedRow() == -1 || motif.isEmpty()){
                   
                   JOptionPane.showMessageDialog(null, "PARAMETRE INCORRECT") ;
                   
               }else{
                   
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
            
          stmt.executeUpdate("update commande_client set etat = 'NON' , motif = '"+motif+"' , user_d = '"+this.login.replaceAll("'", "''")+"' where id = "+this.id) ;

             SimpleDateFormat sdf_1 = new SimpleDateFormat("yyyy-MM-dd") ;
        
        
        Date aujourdui = sdf_1.parse(sdf_1.format(new Date())) ;
        

            sql =  "select * from commande_client order by id desc , rdv asc limit 3000" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){
                
                if(rs.getDate("rdv").compareTo(aujourdui) < 0 || rs.getString("etat").equalsIgnoreCase("NON")){
                    
                    
                }else{

            // "DATE", "ID", "CLIENT", "RDV", "PRIX", "LOGIN", "CODE BARRE", "ETAT"
                
                dtm1.addRow(new Object[]{
                    
this.sdf.format(rs.getTimestamp("jour")) , rs.getLong("id") , rs.getString("client") , this.sdf.format(rs.getTimestamp("rdv")) ,
nf3.format(rs.getLong("devis")) , rs.getString("login") , rs.getInt("cb") , rs.getString("etat") , rs.getString("bon") , 
rs.getString("cd")
                        
                }) ;
                }
                
            }
            
             // d :
    
    SimpleDateFormat sdf_10 = new SimpleDateFormat("yyyy-MM-dd") ;
            Calendar calendar = Calendar.getInstance() ;
            Date today_ = calendar.getTime() ;
            calendar.add(Calendar.DAY_OF_YEAR, 1) ;
            Date tomorow = calendar.getTime() ;
            
            String lc = sdf_10.format(tomorow) ;
            // JOptionPane.showMessageDialog(null, lc);
            
            String today = sdf_10.format(new Date()) ;
          
           

            sql =  "select count(*) from commande_client where rdv like '%"+today+"%' and etat = 'OUI'" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){
                
                 GestionGateauFo.setCj(this.nf3.format(rs.getInt(1))) ;
                
                 }
            
             sql =  "select count(*) from commande_client where rdv like '%"+today+"%' and etat = 'OUI' and cd = 'OUI'" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){
                
                 GestionGateauFo.setD1(this.nf3.format(rs.getInt(1))) ;
                
                 }
            
            sql =  "select count(*) from commande_client where rdv like '%"+lc+"%' and etat = 'OUI'" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){
                
                 GestionGateauFo.setLc(this.nf3.format(rs.getInt(1))) ;
                
                 }
            
             sql =  "select count(*) from commande_client where rdv like '%"+lc+"%' and etat = 'OUI' and cd = 'OUI'" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){
                
              GestionGateauFo.setD2(this.nf3.format(rs.getInt(1))) ;
                
                 }
            
            
    
    // end :
    
            
            this.jTextField2.setText("") ;
            this.jTextField2.setEditable(false) ;
            this.an.setEnabled(false) ;
            

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
        
        }
        
    }//GEN-LAST:event_anActionPerformed

    private void bntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntActionPerformed
        // TODO add your handling code here:
        
      
        
        if(jTable1.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "SELECTIONNER UNE COMMANDE A GAUCHE") ;
            
        }else{
            
        if((this.bn_a.equalsIgnoreCase("1") && this.role.equalsIgnoreCase("ORDINAIRE")) || (this.bn_a.equalsIgnoreCase("1") && this.role.equalsIgnoreCase("ADMINII")) ){
            
            JOptionPane.showMessageDialog(null, "LIMITE COPIE ATTEINTE");
            
        }else if(this.bn_a.equalsIgnoreCase("0") || this.role.equalsIgnoreCase("ORDINAIRE") == false ){
            
            //vbon copie ici :
            
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
             SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
             SimpleDateFormat myf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
             
              String client = null , t1 = null, t2 = null, adresse = null, rdv = null, ecriture = null, g_gt = null, jour = null, moule = null, observ = null;
              Integer devis = null , mr = null, rl = null;
              String user = null ;
              String rdv_ = "" ;
            
              /*
              
               
              */
              
              
              // debut copie bon :
              
                // Mysql serveur saving our commande :
                   
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
            
            DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                                     dtm1.setRowCount(0) ;
                           
                  DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                                    dtm2.setRowCount(0) ;
                                    
            
             if(this.bn_a.equalsIgnoreCase("1")){

    
               
               }else if(this.bn_a.equalsIgnoreCase("0")){
                   
  stmt.executeUpdate("update commande_client set bon = '1' , user_bon = '"+this.login+"' where id = "+this.id) ;
               
               }
             
             
             
             
             sql =  "select * from commande_client order by id desc limit 3000" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

            // "DATE", "ID", "CLIENT", "RDV", "PRIX", "LOGIN", "CODE BARRE", "ETAT"
                
                dtm1.addRow(new Object[]{
                    
this.sdf.format(rs.getTimestamp("jour")) , rs.getLong("id") , rs.getString("client") , this.sdf.format(rs.getTimestamp("rdv")) ,
nf3.format(rs.getLong("devis")) , rs.getString("login") , rs.getInt("cb") , rs.getString("etat") , rs.getString("bon"),
 rs.getString("cd")
                }) ;

                
            }
            
             
             
          
             
             
            
               
                   // END SAVING :
        
     //   JOptionPane.showMessageDialog(null, "COMMANDE PRISE AVEC SUCCES");
    
     
                    
        
        
        // JASPERPRINTING FOR PRINT RECU BON COMMANDE :
        
       
            sql = "select * from commande_client where id = "+this.id ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                
               client = rs.getString("client") ;
               t1 = rs.getString("t1") ;
               t2 = rs.getString("t2") ;
               adresse = rs.getString("adresse") ;
               rdv = sdf.format(rs.getTimestamp("rdv"));
               rdv_ = myf.format(rs.getTimestamp("rdv"));
               ecriture = rs.getString("ecriture") ;
               g_gt = rs.getString("g_gt") ;
               jour = myf.format(rs.getTimestamp("jour")) ;
               user = rs.getString("login");
               
               devis = Integer.parseInt(rs.getString("devis").replaceAll("[^a-zA-Z0-9]", "")) ;
               mr = Integer.parseInt(rs.getString("mr").replaceAll("[^a-zA-Z0-9]", "")) ;
               rl = Integer.parseInt(rs.getString("rl").replaceAll("[^a-zA-Z0-9]", "")) ;
               
               moule = rs.getString("moule").replaceAll("'", "''") ;
               if(moule.isEmpty()){
                   moule = "0" ;
               }
               observ = rs.getString("observation").trim().replaceAll("'", "''") ;
               String etat = rs.getString("etat") ;
               
            }
               
               Integer cb ;
               
            cb = this.cb ;
             

         //   InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\RECU.jrxml")) ;
            
            InputStream in = getClass().getClassLoader().getResourceAsStream("reporting/RECU.jrxml") ;
          
            List mlist ;
            mlist = new ArrayList<>() ;
            
            
            sql = "select gest_format.id as ref, gest_format.description as produit , "
                    + "gest_format.dimension as dim, gest_format.prx as prix from "
                    + "gest_format , detail_commande_client where detail_commande_client.couleur = 'gs' and detail_commande_client.cb = "+cb+" "
                    + "and gest_format.description = detail_commande_client.description " ;
            
            rs = stmt.executeQuery(sql) ;
        
            while(rs.next()) {
                
                HashMap<String, Object> m = new HashMap<>();
                
                 
                m.put("id", rs.getString("ref").toUpperCase()) ;
                m.put("description", rs.getString("produit").toUpperCase()) ;
                m.put("dimension", rs.getString("dim").toUpperCase());
                m.put("prix", rs.getInt("prix"));
                 
               
                
                mlist.add(m) ;
                
            }
            
            
            ArrayList<Integer> list_model = new ArrayList<Integer>() ;
            
            sql = "select cb_model from detail_commande_client where cb = "+cb+" and couleur = 'model'" ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                list_model.add(rs.getInt("cb_model")) ;
            }
            
            
            
            
            for(int i = 0 ; i < list_model.size() ; i++){
                
                
                 sql = "select model_gt.id as m_id , model_gt.description as m_d , model_gt.prx as m_p , "
                    + "detail_model_gt.id as ref , detail_model_gt.description as produit , "
                    + "detail_model_gt.dimension as dim, detail_model_gt.prx as prix from "
                    + "model_gt , detail_model_gt where model_gt.cb = "+list_model.get(i).intValue()+" "
                    + "and detail_model_gt.cb = model_gt.cb" ;
            
                rs = stmt.executeQuery(sql) ;
        
            while(rs.next()) {
                
                if(rs.isFirst()){
                    
               HashMap<String, Object> m = new HashMap<>();
                
                 
                m.put("id", "") ;
                m.put("description", ("<>["+rs.getString("m_id")+"] "+rs.getString("m_d")+" ["+rs.getString("m_p")+"]").toUpperCase()) ;
                m.put("dimension", "");
                m.put("prix", Integer.parseInt("0")) ;
                 
               
                
                mlist.add(m) ;
                
                }
                    
               HashMap<String, Object> m = new HashMap<>();
                
                 
                m.put("id", rs.getString("ref").toUpperCase()) ;
                m.put("description", rs.getString("produit").toUpperCase()) ;
                m.put("dimension", rs.getString("dim").toUpperCase());
                m.put("prix", rs.getInt("prix"));
                 
               
                
                mlist.add(m);
                
                
                
                
                
            }

                
                
                
            } // end for our boucle collection model :
            
            
            
            long id_fact = 0 ;
            
            sql = "select id from "
                    + "commande_client where cb = "+cb ;
            
            rs = stmt.executeQuery(sql) ;
        
            while(rs.next()) {
               id_fact = rs.getLong("id") ;
                
            }

            
             
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist) ;
             

            SimpleDateFormat sdf10 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
            
            Map<String, Object> para = new HashMap<>();
            
           // para.put("sql", jrbean);
            
            if(Integer.parseInt(moule) > 0){
                
               para.put("talon_t","TALON CAUTION COMMANDE N? "+id_fact) ; 
               para.put("jour_t","DATE : "+jour) ; 
               para.put("rdv_t","RDV : "+rdv_) ;
               para.put("caution_t","CAUTION : "+nf3.format(Integer.parseInt(moule))) ;
               para.put("client_t","CLIENT : "+client) ;
               para.put("tel_t","TEL 1 : "+t1+" TEL 2 : "+t2) ;
               para.put("adresse_t","ADRESSE : "+adresse) ;
               para.put("nsg_t","ECRITURE : "+ecriture) ;
               para.put("p_c", "MODEL SUR MOULE") ;
               
                
                
            }else if(moule.equalsIgnoreCase("0")){
                
               para.put("talon","") ; 
               para.put("jour_t","") ; 
               para.put("rdv_t","") ;
               para.put("caution_t","") ;
               para.put("client_t","") ;
               para.put("tel_t","") ;
               para.put("adresse_t","") ;
               para.put("nsg_t","") ;
               para.put("talon_t","") ;
               para.put("p_c", "") ;
                
            }
           
            para.put("cb", cb); 
            para.put("op","OP : "+user);
            para.put("jour","DATE : "+jour);
            para.put("id_Fact","N? : "+id_fact) ;
            para.put("client","CLIENT : "+client);
            para.put("tel","TEL 1 : "+t1+" TEL 2 : "+t2) ;
            para.put("adresse","ADRESSE : "+adresse) ;
            para.put("rdv","RDV : "+rdv_) ;
            para.put("nsg","ECRITURE : "+ecriture) ;
            para.put("ecriture_gt","ECRITURE : "+ecriture) ;
            para.put("gg", g_gt) ;
            para.put("id_2", nf3.format(id_fact)) ;
            para.put("stotal",nf3.format(devis-Integer.parseInt(moule))) ;
           
           try{
                    
           para.put("caution",nf3.format(Integer.parseInt(moule))) ;     
           para.put("total",nf3.format(devis)) ;
           
            para.put("copie", "COPIE") ; 
           
           
           }catch(Exception e10){
               JOptionPane.showMessageDialog(null, e10.getMessage()) ;
           }
            
           para.put("reglement",nf3.format(mr)) ;  
           para.put("payer",nf3.format(rl)) ;
           para.put("observation","OBSERVATION: "+observ) ;
           para.put("talon","TALON CAUTION COMMANDE N? "+id_fact) ;
           
           
           
           

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
                   
        
               
        
              
              
              // end copie bon :
              
              
              
              
        }
            
        }
        
    }//GEN-LAST:event_bntActionPerformed

    private void clKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clKeyReleased
        // TODO add your handling code here:
        
        
        
         try{

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = this.cl.getText().trim().replaceAll("'", "''") ;
        
        
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
            
          

            sql =  "select * from commande_client where client like '%"+dte1+"%' order by rdv asc" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

            // "DATE", "ID", "CLIENT", "RDV", "PRIX", "LOGIN", "CODE BARRE", "ETAT"
                
                dtm1.addRow(new Object[]{
                    
this.sdf.format(rs.getTimestamp("jour")) , rs.getLong("id") , rs.getString("client") , this.sdf.format(rs.getTimestamp("rdv")) ,
nf3.format(rs.getLong("devis")) , rs.getString("login") , rs.getInt("cb") , rs.getString("etat"),rs.getString("bon"),
 rs.getString("cd")
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
                   
        
        
        
        
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "CLIENT INCORRECT");
            
        }
        
        
        
        
        
        
    }//GEN-LAST:event_clKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "SELECTIONNER UNE COMMANDE SVP !") ;
        }else{
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
            String jour = sdf.format(new Date()) ;
            
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
            
          stmt.executeUpdate("update commande_client set cd = 'OUI' , user_cd = '"+this.login+"' , date_cd  = '"+jour+"' where id = "+this.id) ;

            sql =  "select * from commande_client order by id desc limit 3000" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

            // "DATE", "ID", "CLIENT", "RDV", "PRIX", "LOGIN", "CODE BARRE", "ETAT"
                
                dtm1.addRow(new Object[]{
                    
this.sdf.format(rs.getTimestamp("jour")) , rs.getLong("id") , rs.getString("client") , this.sdf.format(rs.getTimestamp("rdv")) ,
nf3.format(rs.getLong("devis")) , rs.getString("login") , rs.getInt("cb") , rs.getString("etat") , rs.getString("bon") , rs.getString("cd")
    
                }) ;

                
            }
            
             
             // d :
    
    SimpleDateFormat sdf_10 = new SimpleDateFormat("yyyy-MM-dd") ;
            Calendar calendar = Calendar.getInstance() ;
            Date today_ = calendar.getTime() ;
            calendar.add(Calendar.DAY_OF_YEAR, 1) ;
            Date tomorow = calendar.getTime() ;
            
            String lc = sdf_10.format(tomorow) ;
            // JOptionPane.showMessageDialog(null, lc);
            
            String today = sdf_10.format(new Date()) ;
          
            

            sql =  "select count(*) from commande_client where rdv like '%"+today+"%' and etat = 'OUI'" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){
                
                 GestionGateauFo.setCj(this.nf3.format(rs.getInt(1))) ;
                
                 }
            
             sql =  "select count(*) from commande_client where rdv like '%"+today+"%' and etat = 'OUI' and cd = 'OUI'" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){
                
                 GestionGateauFo.setD1(this.nf3.format(rs.getInt(1))) ;
                
                 }
            
            sql =  "select count(*) from commande_client where rdv like '%"+lc+"%' and etat = 'OUI'" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){
                
                 GestionGateauFo.setLc(this.nf3.format(rs.getInt(1))) ;
                
                 }
            
             sql =  "select count(*) from commande_client where rdv like '%"+lc+"%' and etat = 'OUI' and cd = 'OUI'" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){
                
              GestionGateauFo.setD2(this.nf3.format(rs.getInt(1))) ;
                
                 }
            
            
    
    // end :
    

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
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void codeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeKeyReleased
        // TODO add your handling code here:
        
          try{

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = this.code.getText().trim().replaceAll("'", "''") ;
        
        
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
            
          

            sql =  "select * from commande_client where id like '%"+dte1+"%' order by rdv asc" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

            // "DATE", "ID", "CLIENT", "RDV", "PRIX", "LOGIN", "CODE BARRE", "ETAT"
           //   "DATE", "ID", "CLIENT", "RDV", "PRIX", "LOGIN", "CODE BARRE", "ETAT", "BON", "CONF.D"
                
                dtm1.addRow(new Object[]{
                    
this.sdf.format(rs.getTimestamp("jour")) , rs.getLong("id") , rs.getString("client") , this.sdf.format(rs.getTimestamp("rdv")) ,
nf3.format(rs.getLong("devis")) , rs.getString("login") , rs.getInt("cb") , rs.getString("etat"),rs.getString("bon"),
 rs.getString("cd")
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
                   
        
        
        
        
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "ID INCORRECT");
            
        }
        
        
        
        
        
        
    }//GEN-LAST:event_codeKeyReleased

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
            java.util.logging.Logger.getLogger(Suivit_gateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Suivit_gateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Suivit_gateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Suivit_gateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Suivit_gateau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton an;
    private javax.swing.JButton bnt;
    private javax.swing.JTextField cl;
    private javax.swing.JTextField code;
    private javax.swing.JLabel cp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JFormattedTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
