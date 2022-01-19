/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.OpDepot.JDBC_DRIVER;
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
import javax.swing.JOptionPane;
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
 * @author HAMZA
 */
public class Mycompte extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
       NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
    
    String login ;
    String role ;
    Integer nom_cpte = 0 ;
    Integer rb1 = 0 ;
    Integer srb1 = 0 ;
    Integer com1 = 0 ;
    String query = "" ;
    String op = "" ;
    
    List mlist = new ArrayList<>() ;
    
    List l_avis = new ArrayList<>() ;
    
    public Mycompte() {
        initComponents() ;
        
        
    }
    
     public Mycompte(String login){
        
         initComponents() ;
        
        this.login = login ;
        
        Date jour2 = new Date() ;
        this.jDateChooser1.setDate(jour2);
        this.h1.setText("00:00") ;
        this.jDateChooser2.setDate(jour2) ;
        this.h2.setText("23:59") ;
        
        this.u.setSelectedItem(new String("TOUT")) ;
        this.com.setSelectedItem(new String("TOUT")) ;
        this.r.setSelectedItem(new String("TOUT")) ;
        this.sr.setSelectedItem(new String("TOUT")) ;
        
        
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
      
      // filtre :
      
      String jour ;
      SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd") ;
                       jour = sdf1.format(new Date()) ;
      
            String sql10 ;
      
       sql10 = "SELECT rub FROM rubrique WHERE NOT type = 'non' ORDER BY rub ASC" ;
      
       ResultSet rs10 = stmt.executeQuery(sql10) ;
      
      
     while(rs10.next()){
         
         this.r.addItem(rs10.getString("rub")) ;
     
     }
     
      String sql22 ;
      
       sql22 = "SELECT perso FROM perso_t WHERE type = 'oui' AND domaine = 'CL' OR domaine = 'CL_PL' ORDER BY perso ASC" ;
      
       ResultSet rs22 = stmt.executeQuery(sql22) ;
      
      
     while(rs22.next()){
         
         this.com.addItem(rs22.getString("perso")) ;
     
     }
     
     this.com.setSelectedItem(new String("TOUT")) ;
     this.com.setEnabled(false) ;
     this.com.setEditable(false) ;
     
      
      
      //  end :
      
      this.nom_cpte = 0 ;
      String sql ;
      
       sql = "SELECT role FROM comptes_u WHERE login = '"+this.login+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
         this.role = rs.getString("role") ;
     
     }
     
      String sql2 ;
      
       sql2 = "SELECT distinct id FROM comptes_u WHERE login = '"+this.login+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
         
         this.nom_cpte = rs2.getInt("id") ;
     
     }
     
     sql2 = "select login , nom_cpte from compte_b , comptes_u where comptes_u.id = compte_b.nom_cpte" ;
     rs2 = stmt.executeQuery(sql2) ;
     while(rs2.next()){
         this.u.addItem(new String(rs2.getString("login")));
     }
     
     
     String sql3 ;
      
       sql3 = "SELECT solde_cfa_eco,solde_euro,solde_dollar FROM compte_b WHERE nom_cpte = "+this.nom_cpte ;
      
       ResultSet rs3 = stmt.executeQuery(sql3) ;
      
      
     while(rs3.next()){
         
         this.cfa.setText(nf3.format(rs3.getLong("solde_cfa_eco"))) ;
         this.euro.setText(nf3.format(rs3.getLong("solde_euro"))) ;
         this.dollar.setText(nf3.format(rs3.getLong("solde_dollar"))) ;
     
     }
     
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
     SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
     
     long td = 0 ;
     long tr = 0 ;
     long d = 0 ;
     long r = 0 ;
     
     if("SUPER ADMINISTRATEUR".equalsIgnoreCase(role)){
         
         this.ga.setEnabled(true) ;
         this.ga.setVisible(true) ;
         
         String sql4 = "select * , sousrub.srb from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec LIKE '%"+sdf.format(new Date())+"%' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id DESC" ;
         ResultSet rs4 = stmt.executeQuery(sql4) ;
         while(rs4.next()){
             
             HashMap<String, Object> m = new HashMap<>() ;
             
             
             HashMap<String, Object> m_a = new HashMap<>() ;
             
             
              
                 m_a.put("id", rs4.getString("depot_retrait.id")) ;
                 m_a.put("cb", rs4.getString("depot_retrait.cb")) ;
                 m_a.put("mtt", nf3.format(rs4.getLong("depot_retrait.mtt"))) ;
                 m_a.put("motif", rs4.getString("depot_retrait.motif")) ;
                 m_a.put("dtec", sdfT.format(rs4.getTimestamp("depot_retrait.dtec"))) ;
                 m_a.put("admin", rs4.getString("depot_retrait.admin")) ;
                 m_a.put("type", rs4.getString("depot_retrait.type")) ;
                 m_a.put("rub", rs4.getString("rubrique.rub")) ;
                 m_a.put("COLUMN_15", rs4.getString("sousrub.srb")) ;
                 m_a.put("perso", "") ;
                 m_a.put("ref", rs4.getString("depot_retrait.reference")) ;
                 m_a.put("tiers", rs4.getString("depot_retrait.tiers")) ;
                 m_a.put("copie", "[COPIE]") ;
                 
                 
                 this.l_avis.add(m_a) ;
                 
             
             
             
              
              
// "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "COMMISSIONAIRE", "UTILISATEUR", "MOTIF" 
             
             d = 0 ;
             r = 0 ;
             
             if("depot".equalsIgnoreCase(rs4.getString("type"))){
                 td += rs4.getLong("mtt") ;
                 d   = rs4.getLong("mtt") ;
                  
             }else if("retrait".equalsIgnoreCase(rs4.getString("type"))){
                 tr += rs4.getLong("mtt") ;
                  r  = rs4.getLong("mtt") ;
             }
             
             if(d == 0){
                 
                
                 
                 
                 
     // -------------------------------------------------------------------------------------------
                 
                 m.put("dtec", sdfT.format(rs4.getTimestamp("depot_retrait.dtec"))) ;
                 m.put("id", rs4.getLong("depot_retrait.id")) ;
                 m.put("depot", Long.parseLong("0")) ;
                 m.put("retrait", r) ;
                 m.put("rub", rs4.getString("rubrique.rub")) ;
                 m.put("sousrub", rs4.getString("sousrub.srb")) ;
                 m.put("perso", rs4.getString("tiers")) ;
                 m.put("admin", rs4.getString("depot_retrait.admin")) ;
                 m.put("motif", " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")) ;
                 
                 this.mlist.add(m) ;
                 
                 
  //
                 
                 
                 
  // "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "COMMISSIONAIRE", "UTILISATEUR", "MOTIF"
    dtm1.addRow(new Object[]{
   sdfT.format(rs4.getTimestamp("depot_retrait.dtec")),rs4.getLong("depot_retrait.id")," ",this.nf3.format(r),
   rs4.getString("rubrique.rub"),rs4.getString("sousrub.srb"),rs4.getString("tiers"),rs4.getString("depot_retrait.admin"),
    " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")  // ,rs4.getString("type")
             
             }); 
                 
                 
             }else if(r == 0){
                 
                 m.put("dtec", sdfT.format(rs4.getTimestamp("depot_retrait.dtec"))) ;
                 m.put("id", rs4.getLong("depot_retrait.id")) ;
                 m.put("depot", d) ;
                 m.put("retrait", Long.parseLong("0")) ;
                 m.put("rub", rs4.getString("rubrique.rub")) ;
                 m.put("sousrub", rs4.getString("sousrub.srb")) ;
                 m.put("perso", rs4.getString("tiers")) ;
                 m.put("admin", rs4.getString("depot_retrait.admin")) ;
                 m.put("motif",  " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")) ;
                 
                 this.mlist.add(m) ;
                 
              
                  // "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "COMMISSIONAIRE", "UTILISATEUR", "MOTIF"
    dtm1.addRow(new Object[]{
   sdfT.format(rs4.getTimestamp("depot_retrait.dtec")),rs4.getLong("depot_retrait.id"),this.nf3.format(d)," ",
   rs4.getString("rubrique.rub"),rs4.getString("sousrub.srb"),rs4.getString("tiers"),rs4.getString("depot_retrait.admin"),
    " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")  // ,rs4.getString("type")
             
            
             }); 
                 
                 
             }
             
             
             
         
         }
         
         
     }else{
         
          this.ga.setVisible(false) ;
         
         this.u.setSelectedItem(new String(this.login)) ;
         this.u.setEnabled(false) ;
         
         String sql4 = "select * , sousrub.srb from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec LIKE '%"+sdf.format(new Date())+"%' AND depot_retrait.admin = '"+this.login+"' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id DESC" ;
         ResultSet rs4 = stmt.executeQuery(sql4) ;
         while(rs4.next()){
             
             HashMap<String, Object> m = new HashMap<>() ;
             
             
              HashMap<String, Object> m_a = new HashMap<>() ;
             
             
              
                 m_a.put("id", rs4.getString("depot_retrait.id")) ;
                 m_a.put("cb", rs4.getString("depot_retrait.cb")) ;
                 m_a.put("mtt", nf3.format(rs4.getLong("depot_retrait.mtt"))) ;
                 m_a.put("motif", rs4.getString("depot_retrait.motif")) ;
                 m_a.put("dtec", sdfT.format(rs4.getTimestamp("depot_retrait.dtec"))) ;
                 m_a.put("admin", rs4.getString("depot_retrait.admin")) ;
                 m_a.put("type", rs4.getString("depot_retrait.type")) ;
                 m_a.put("rub", rs4.getString("rubrique.rub")) ;
                 m_a.put("COLUMN_15", rs4.getString("sousrub.srb")) ;
                 m_a.put("perso", "") ;
                 m_a.put("ref", rs4.getString("depot_retrait.reference")) ;
                 m_a.put("tiers", rs4.getString("depot_retrait.tiers")) ;
                 m_a.put("copie", "[COPIE]") ;
                 
                 
                 this.l_avis.add(m_a) ;
             
             
// "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "COMMISSIONAIRE", "UTILISATEUR", "MOTIF" 
             
             d = 0 ;
             r = 0 ;
             
             if("depot".equalsIgnoreCase(rs4.getString("type"))){
                 td += rs4.getLong("mtt") ;
                 d   = rs4.getLong("mtt") ;
                  
             }else if("retrait".equalsIgnoreCase(rs4.getString("type"))){
                 tr += rs4.getLong("mtt") ;
                  r  = rs4.getLong("mtt") ;
             }
             
             if(d == 0){
                 
                 m.put("dtec", sdfT.format(rs4.getTimestamp("depot_retrait.dtec"))) ;
                 m.put("id", rs4.getLong("depot_retrait.id")) ;
                 m.put("depot", Long.parseLong("0")) ;
                 m.put("retrait", r) ;
                 m.put("rub", rs4.getString("rubrique.rub")) ;
                 m.put("sousrub", rs4.getString("sousrub.srb")) ;
                 m.put("perso", rs4.getString("tiers")) ;
                 m.put("admin", rs4.getString("depot_retrait.admin")) ;
                 m.put("motif",  " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")) ;
                 
                 this.mlist.add(m) ;
                 
  // "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "COMMISSIONAIRE", "UTILISATEUR", "MOTIF"
    dtm1.addRow(new Object[]{
   sdfT.format(rs4.getTimestamp("depot_retrait.dtec")),rs4.getLong("depot_retrait.id")," ",this.nf3.format(r),
   rs4.getString("rubrique.rub"),rs4.getString("sousrub.srb"),rs4.getString("tiers"),rs4.getString("depot_retrait.admin"),
   " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")  // ,rs4.getString("type")
             
             }) ; 
                 
                 
             }else if(r == 0){
                 
                 m.put("dtec", sdfT.format(rs4.getTimestamp("depot_retrait.dtec"))) ;
                 m.put("id", rs4.getLong("depot_retrait.id")) ;
                 m.put("depot", d) ;
                 m.put("retrait", Long.parseLong("0")) ;
                 m.put("rub", rs4.getString("rubrique.rub")) ;
                 m.put("sousrub", rs4.getString("sousrub.srb")) ;
                 m.put("perso", rs4.getString("tiers")) ;
                 m.put("admin", rs4.getString("depot_retrait.admin")) ;
                 m.put("motif", " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")) ;
                 
                 this.mlist.add(m) ;
              
                  // "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "COMMISSIONAIRE", "UTILISATEUR", "MOTIF"
    dtm1.addRow(new Object[]{
   sdfT.format(rs4.getTimestamp("depot_retrait.dtec")),rs4.getLong("depot_retrait.id"),this.nf3.format(d)," ",
   rs4.getString("rubrique.rub"),rs4.getString("sousrub.srb"),rs4.getString("tiers"),rs4.getString("depot_retrait.admin"),
    " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")  // ,rs4.getString("type")
             
            
             }) ; 
                 
                 
             }
             
             
         }
         
         
     }
     
     if(this.role.equalsIgnoreCase("ADMINII")){
         
         this.jButton1.setEnabled(false) ;
         this.jLabel5.setVisible(false) ;
         this.etat.setVisible(false) ;
         
     }
     
      this.td.setText(nf3.format(td)) ; this.tr.setText(nf3.format(tr)) ;
      long et = 0 ;
           et = (td - tr) ;
           this.etat.setText(this.nf3.format(et)) ;
           
            
      //  STEP 6: Clean-up environment
      
    //    System.out.println("Goodbye!") ;
      
   
      
      // STEP 6: Clean-up environment
           
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
        jLabel2 = new javax.swing.JLabel();
        cfa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        euro = new javax.swing.JTextField();
        dollar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        td = new javax.swing.JTextField();
        tr = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        etat = new javax.swing.JTextField();
        ga = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        h1 = new javax.swing.JTextField();
        h2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        r = new javax.swing.JComboBox();
        sr = new javax.swing.JComboBox();
        com = new javax.swing.JComboBox();
        u = new javax.swing.JComboBox();
        a = new javax.swing.JComboBox();
        o = new javax.swing.JComboBox();
        ref = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ETAT DU COMPTE DEPOT - RETRAIT :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 11, 427, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SOLDE  FCFA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 34, 156, -1));

        cfa.setEditable(false);
        cfa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cfa.setText("1.000.000.000");
        jPanel1.add(cfa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 54, 156, 28));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SOLDE  EURO ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 34, 165, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SOLDE DOLLAR");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 34, 156, -1));

        euro.setEditable(false);
        euro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        euro.setText("1.000.000.000");
        jPanel1.add(euro, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 54, 165, 28));

        dollar.setEditable(false);
        dollar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dollar.setText("1.000.000.000");
        jPanel1.add(dollar, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 54, 156, 28));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "TIERS", "UTILISATEUR", "MOTIF"
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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(6).setMinWidth(80);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(85);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(175);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 165, 1163, 511));

        jPanel2.setBackground(new java.awt.Color(102, 102, 0));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("IMPRIMER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        td.setEditable(false);

        tr.setEditable(false);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TOTAL DEPOT");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TOTAL RETRAIT");

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("RECHERCHER");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ETAT ");

        etat.setEditable(false);

        ga.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ga.setText("GENERER AVIS");
        ga.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))))
                    .addComponent(etat)
                    .addComponent(td)
                    .addComponent(tr)
                    .addComponent(ga, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ga, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(td, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1179, 165, -1, 511));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 139, 144, -1));
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 139, 139, -1));

        jLabel6.setText("DU");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 119, 24, -1));

        jLabel7.setText("AU");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 119, -1, -1));

        jLabel10.setText("HEURE");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 119, -1, -1));

        jLabel11.setText("HEURE");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 119, 48, -1));
        jPanel1.add(h1, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 139, 54, -1));
        jPanel1.add(h2, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 139, 58, -1));

        jPanel3.setBackground(new java.awt.Color(51, 51, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPTION DE FILTRE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        r.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        r.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUT" }));
        r.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rActionPerformed(evt);
            }
        });

        sr.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        sr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUTE" }));
        sr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srActionPerformed(evt);
            }
        });

        com.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        com.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUT" }));
        com.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        com.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comActionPerformed(evt);
            }
        });

        u.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        u.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUT" }));
        u.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uActionPerformed(evt);
            }
        });

        a.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        a.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUTE", "SANS PIECE", "AVEC PIECE" }));
        a.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });

        o.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        o.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUTE", "DEPOT", "RETRAIT" }));
        o.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        o.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oActionPerformed(evt);
            }
        });

        ref.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        ref.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ref.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        ref.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                refKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("RECHERCHER : REFERENCE / MOTIF");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ref, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(com, javax.swing.GroupLayout.Alignment.LEADING, 0, 171, Short.MAX_VALUE)
                            .addComponent(u, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(r, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a, 0, 151, Short.MAX_VALUE)
                    .addComponent(o, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(u, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(com, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sr, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(o, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ref, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 11, 700, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
           this.jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
         
       
            
            try{
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
                
                
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\dep_ret_cl.jrxml")) ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.mlist) ;
            
            Map<String, Object> para = new HashMap<>();
         // para.put("data", jrbean);
            para.put("op", "OP : "+this.login) ;  // this.login
            para.put("periode","LA PERIODE : DU "+dte1+" AU : "+dte2) ;
         // para.put("zone", "LE POINT DE PLACEMENT : "+this.zone) ;
           
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print, false);
            
                
                
            }catch(Exception e){
                
                try{
                
                 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
                  String jour = "" ;
                         jour = sdf.format(new Date()) ;
                
                
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\dep_ret_cl.jrxml")) ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.mlist) ;
            
            Map<String, Object> para = new HashMap<>();
         // para.put("data", jrbean);
            para.put("op", "OP : "+this.login) ;  // this.login
            para.put("periode","LA PERIODE EST :  "+jour+"") ;
         // para.put("zone", "LE POINT DE PLACEMENT : "+this.zone) ;
           
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print, false);
            
                }catch(Exception e2){
                    JOptionPane.showMessageDialog(this, e.getMessage()) ;
                }
                
                // 
            }
            
            
       
        
        this.jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
        /*
        PrintDepot pd = new PrintDepot(this.login , this.role) ;
        
                   pd.setCfa(cfa.getText()) ;
                   pd.setEuro(euro.getText());
                   pd.setDollar(dollar.getText());
        
                   pd.setVisible(true) ;
                   
        */
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        this.mlist.removeAll(this.mlist) ;
        
        this.l_avis.removeAll(this.l_avis) ;
        
        
        
        
         try{
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
        
        
         DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
        
        
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm1.setRowCount(0) ;
        
        
        
        
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
      
      
       
     
//   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
      
      
      
      
     SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
     
     long td = 0 ;
     long tr = 0 ;
     long d = 0 ;
     long r = 0 ;
     long et = 0 ;
     
     if("SUPER ADMINISTRATEUR".equalsIgnoreCase(role)){
       
           
         int vy = 0 ;
         
         // reconfiguration for depot retrait hypothese : environ 12 hypotheses :
         
       if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" AND "
                    + "depot_retrait.reference = 'LIBRE' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" AND NOT "
                    + "depot_retrait.reference = 'LIBRE' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" AND "
                    + "depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'depot' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("retrait")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" AND "
                    + "depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'retrait' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" AND NOT "
                    + "depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" AND NOT "
                    + "depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND depot_retrait.srb = "+this.srb1+" AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND depot_retrait.srb = "+this.srb1+" "
                    + "AND depot_retrait.reference = 'LIBRE' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND depot_retrait.srb = "+this.srb1+" "
                    + "AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND depot_retrait.srb = "+this.srb1+" "
                    + "AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND depot_retrait.srb = "+this.srb1+" "
                    + "AND NOT depot_retrait.reference = 'LIBRE' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND depot_retrait.srb = "+this.srb1+" "
                    + "AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND depot_retrait.srb = "+this.srb1+" "
                    + "AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND depot_retrait.reference = 'LIBRE' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND NOT depot_retrait.reference = 'LIBRE' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND depot_retrait.type = 'DEPOT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND depot_retrait.type = 'RETRAIT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND depot_retrait.reference = 'LIBRE' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND depot_retrait.reference = 'LIBRE' "
                    + "AND depot_retrait.type = 'DEPOT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND depot_retrait.reference = 'LIBRE' "
                    + "AND depot_retrait.type = 'RETRAIT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND NOT depot_retrait.reference = 'LIBRE' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND NOT depot_retrait.reference = 'LIBRE' "
                    + "AND depot_retrait.type = 'DEPOT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND NOT depot_retrait.reference = 'LIBRE' "
                    + "AND depot_retrait.type = 'RETRAIT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' "
                    + "AND depot_retrait.reference = 'LIBRE' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' "
                    + "AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' "
                    + "AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' "
                    + "AND NOT depot_retrait.reference = 'LIBRE' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' "
                    + "AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' "
                    + "AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' "
                    + "AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' "
                    + "AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' "
                    + "AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' "
                    + "AND depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
            
            
            // --------------------------------------------------------X---------------------------------------------------------------------------------------------
            
            
              // debut hypothese : new 
            
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
         
           this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.reference = 'LIBRE'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
         
          this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND NOT depot_retrait.reference = 'LIBRE'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
         
          this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
         
          this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
         
          this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
         
          this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
         
             this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.type = 'DEPOT'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
         
         this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.type = 'RETRAIT'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else{
             vy = 1 ;
         }
       
         
         if(vy == 1){
             
              this.mlist.removeAll(this.mlist) ;
        
              this.l_avis.removeAll(this.l_avis) ;
              
              dtm1.setRowCount(0) ;
        
             
         }else if(vy == 0){
         
      
       
       
       
         ResultSet rs4 = stmt.executeQuery(this.query) ;
         while(rs4.next()){
// "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "COMMISSIONAIRE", "UTILISATEUR", "MOTIF" 
             
             HashMap<String, Object> m = new HashMap<>() ;
             
              HashMap<String, Object> m_a = new HashMap<>() ;
             
             
              
                 m_a.put("id", rs4.getString("depot_retrait.id")) ;
                 m_a.put("cb", rs4.getString("depot_retrait.cb")) ;
                 m_a.put("mtt", nf3.format(rs4.getLong("depot_retrait.mtt"))) ;
                 m_a.put("motif", rs4.getString("depot_retrait.motif")) ;
                 m_a.put("dtec", sdfT.format(rs4.getTimestamp("depot_retrait.dtec"))) ;
                 m_a.put("admin", rs4.getString("depot_retrait.admin")) ;
                 m_a.put("type", rs4.getString("depot_retrait.type")) ;
                 m_a.put("rub", rs4.getString("rubrique.rub")) ;
                 m_a.put("COLUMN_15", rs4.getString("sousrub.srb")) ;
                 m_a.put("perso", "") ;
                 m_a.put("ref", rs4.getString("depot_retrait.reference")) ;
                 m_a.put("tiers", rs4.getString("depot_retrait.tiers")) ;
                 m_a.put("copie", "[COPIE]") ;
                 
                 
                 this.l_avis.add(m_a) ;
             
             
             d = 0 ;
             r = 0 ;
          // et = 0 ;
             
             if("depot".equalsIgnoreCase(rs4.getString("type"))){
                 td += rs4.getLong("mtt") ;
                 d   = rs4.getLong("mtt") ;
                  
             }else if("retrait".equalsIgnoreCase(rs4.getString("type"))){
                 tr += rs4.getLong("mtt") ;
                  r  = rs4.getLong("mtt") ;
             }
             
             if(d == 0){
                 
                 m.put("dtec", sdfT.format(rs4.getTimestamp("depot_retrait.dtec"))) ;
                 m.put("id", rs4.getLong("depot_retrait.id")) ;
                 m.put("depot", Long.parseLong("0")) ;
                 m.put("retrait", r) ;
                 m.put("rub", rs4.getString("rubrique.rub")) ;
                 m.put("sousrub", rs4.getString("sousrub.srb")) ;
                 m.put("perso", rs4.getString("tiers")) ;
                 m.put("admin", rs4.getString("depot_retrait.admin")) ;
                 m.put("motif",  " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")) ;
                 
                 this.mlist.add(m) ;
                 
                 
  // "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "COMMISSIONAIRE", "UTILISATEUR", "MOTIF"
    dtm1.addRow(new Object[]{
   sdfT.format(rs4.getTimestamp("depot_retrait.dtec")),rs4.getLong("depot_retrait.id")," ",this.nf3.format(r),
   rs4.getString("rubrique.rub"),rs4.getString("sousrub.srb"),rs4.getString("tiers"),rs4.getString("depot_retrait.admin"),
    " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")  // ,rs4.getString("type")
             
             }); 
                 
                 
             }else if(r == 0){
                 
                 m.put("dtec", sdfT.format(rs4.getTimestamp("depot_retrait.dtec"))) ;
                 m.put("id", rs4.getLong("depot_retrait.id")) ;
                 m.put("depot", d) ;
                 m.put("retrait", Long.parseLong("0")) ;
                 m.put("rub", rs4.getString("rubrique.rub")) ;
                 m.put("sousrub", rs4.getString("sousrub.srb")) ;
                 m.put("perso", rs4.getString("tiers")) ;
                 m.put("admin", rs4.getString("depot_retrait.admin")) ;
                 m.put("motif",  " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")) ;
                 
                 this.mlist.add(m) ;
                 
              
                  // "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "COMMISSIONAIRE", "UTILISATEUR", "MOTIF"
    dtm1.addRow(new Object[]{
   sdfT.format(rs4.getTimestamp("depot_retrait.dtec")),rs4.getLong("depot_retrait.id"),this.nf3.format(d)," ",
   rs4.getString("rubrique.rub"),rs4.getString("sousrub.srb"),rs4.getString("tiers"),rs4.getString("depot_retrait.admin"),
   " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")  // ,rs4.getString("type")
             
            
             }) ; 
                 
                 
             }
             
             
         }
         
         
         }
        
         
     }else{
        
          
         int vy = 0 ;
         
         // reconfiguration for depot retrait hypothese : environ 12 hypotheses :
         
       if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" AND "
                    + "depot_retrait.reference = 'LIBRE' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" AND NOT "
                    + "depot_retrait.reference = 'LIBRE' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" AND "
                    + "depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'depot' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("retrait")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" AND "
                    + "depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'retrait' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" AND NOT "
                    + "depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" AND NOT "
                    + "depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND depot_retrait.srb = "+this.srb1+" AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND depot_retrait.srb = "+this.srb1+" "
                    + "AND depot_retrait.reference = 'LIBRE' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND depot_retrait.srb = "+this.srb1+" "
                    + "AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND depot_retrait.srb = "+this.srb1+" "
                    + "AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND depot_retrait.srb = "+this.srb1+" "
                    + "AND NOT depot_retrait.reference = 'LIBRE' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND depot_retrait.srb = "+this.srb1+" "
                    + "AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND depot_retrait.srb = "+this.srb1+" "
                    + "AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND depot_retrait.reference = 'LIBRE' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND NOT depot_retrait.reference = 'LIBRE' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND depot_retrait.type = 'DEPOT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if( this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND depot_retrait.type = 'RETRAIT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if( this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND depot_retrait.reference = 'LIBRE' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(  this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND depot_retrait.reference = 'LIBRE' "
                    + "AND depot_retrait.type = 'DEPOT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if( this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"'  AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND depot_retrait.reference = 'LIBRE' "
                    + "AND depot_retrait.type = 'RETRAIT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if( this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.login+"'  AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND NOT depot_retrait.reference = 'LIBRE' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if( this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"'  AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND NOT depot_retrait.reference = 'LIBRE' "
                    + "AND depot_retrait.type = 'DEPOT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if( this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"'  AND depot_retrait.admin = '"+this.login+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' "
                    + "AND NOT depot_retrait.reference = 'LIBRE' "
                    + "AND depot_retrait.type = 'RETRAIT' AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if( this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"'  AND depot_retrait.admin = '"+this.login+"' "
                    + "AND depot_retrait.reference = 'LIBRE' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if( this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"'  AND depot_retrait.admin = '"+this.login+"' "
                    + "AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if( this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"'  AND depot_retrait.admin = '"+this.login+"' "
                    + "AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if( this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"'  AND depot_retrait.admin = '"+this.login+"' "
                    + "AND NOT depot_retrait.reference = 'LIBRE' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if( this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"'  AND depot_retrait.admin = '"+this.login+"' "
                    + "AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if( this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"'  AND depot_retrait.admin = '"+this.login+"' "
                    + "AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if( this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"'  AND depot_retrait.admin = '"+this.login+"' "
                    + "AND depot_retrait.type = 'DEPOT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if( this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT")   
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"'  AND depot_retrait.admin = '"+this.login+"' "
                    + "AND depot_retrait.type = 'RETRAIT' "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if( this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"'  AND depot_retrait.admin = '"+this.login+"' "
                    + "AND depot_retrait.rubrique = "+this.rb1+" "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false  
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == false 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' "
                    + "AND depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.srb = "+this.srb1+" "
                    + "AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
             
            this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
              
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
         
           this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.reference = 'LIBRE'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("TOUTE")){
         
          this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND NOT depot_retrait.reference = 'LIBRE'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
         
          this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("AVEC PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
         
          this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND NOT depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
         
          this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'DEPOT'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("SANS PIECE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
         
          this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.reference = 'LIBRE' AND depot_retrait.type = 'RETRAIT'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("DEPOT")){
         
             this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.type = 'DEPOT'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else if(this.u.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false 
       && this.a.getSelectedItem().toString().equalsIgnoreCase("TOUTE") && this.sr.getSelectedItem().toString().equalsIgnoreCase("TOUTE") == true 
       && this.o.getSelectedItem().toString().equalsIgnoreCase("RETRAIT")){
         
         this.query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where "
                 + "depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND depot_retrait.admin = '"+this.u.getSelectedItem().toString()+"' AND "
                    + "depot_retrait.rubrique = "+this.rb1+" AND depot_retrait.type = 'RETRAIT'  AND "
                    + "rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
         
         }else{
             vy = 1 ;
         }
       
         
         if(vy == 1){
             
              this.mlist.removeAll(this.mlist) ;
        
              this.l_avis.removeAll(this.l_avis) ;
              
              dtm1.setRowCount(0) ;
        
             
         }else if(vy == 0){
         
      
       
       
       
         ResultSet rs4 = stmt.executeQuery(this.query) ;
         while(rs4.next()){
// "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "COMMISSIONAIRE", "UTILISATEUR", "MOTIF" 
             
             HashMap<String, Object> m = new HashMap<>() ;
             
              HashMap<String, Object> m_a = new HashMap<>() ;
             
             
              
                 m_a.put("id", rs4.getString("depot_retrait.id")) ;
                 m_a.put("cb", rs4.getString("depot_retrait.cb")) ;
                 m_a.put("mtt", nf3.format(rs4.getLong("depot_retrait.mtt"))) ;
                 m_a.put("motif", rs4.getString("depot_retrait.motif")) ;
                 m_a.put("dtec", sdfT.format(rs4.getTimestamp("depot_retrait.dtec"))) ;
                 m_a.put("admin", rs4.getString("depot_retrait.admin")) ;
                 m_a.put("type", rs4.getString("depot_retrait.type")) ;
                 m_a.put("rub", rs4.getString("rubrique.rub")) ;
                 m_a.put("COLUMN_15", rs4.getString("sousrub.srb")) ;
                 m_a.put("perso", "") ;
                 m_a.put("ref", rs4.getString("depot_retrait.reference")) ;
                 m_a.put("tiers", rs4.getString("depot_retrait.tiers")) ;
                 m_a.put("copie", "[COPIE]") ;
                 
                 
                 this.l_avis.add(m_a) ;
             
             
             d = 0 ;
             r = 0 ;
          // et = 0 ;
             
             if("depot".equalsIgnoreCase(rs4.getString("type"))){
                 td += rs4.getLong("mtt") ;
                 d   = rs4.getLong("mtt") ;
                  
             }else if("retrait".equalsIgnoreCase(rs4.getString("type"))){
                 tr += rs4.getLong("mtt") ;
                  r  = rs4.getLong("mtt") ;
             }
             
             if(d == 0){
                 
                 m.put("dtec", sdfT.format(rs4.getTimestamp("depot_retrait.dtec"))) ;
                 m.put("id", rs4.getLong("depot_retrait.id")) ;
                 m.put("depot", Long.parseLong("0")) ;
                 m.put("retrait", r) ;
                 m.put("rub", rs4.getString("rubrique.rub")) ;
                 m.put("sousrub", rs4.getString("sousrub.srb")) ;
                 m.put("perso", rs4.getString("tiers")) ;
                 m.put("admin", rs4.getString("depot_retrait.admin")) ;
                 m.put("motif",  " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")) ;
                 
                 this.mlist.add(m) ;
                 
                 
  // "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "COMMISSIONAIRE", "UTILISATEUR", "MOTIF"
    dtm1.addRow(new Object[]{
   sdfT.format(rs4.getTimestamp("depot_retrait.dtec")),rs4.getLong("depot_retrait.id")," ",this.nf3.format(r),
   rs4.getString("rubrique.rub"),rs4.getString("sousrub.srb"),rs4.getString("tiers"),rs4.getString("depot_retrait.admin"),
    " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")  // ,rs4.getString("type")
             
             }); 
                 
                 
             }else if(r == 0){
                 
                 m.put("dtec", sdfT.format(rs4.getTimestamp("depot_retrait.dtec"))) ;
                 m.put("id", rs4.getLong("depot_retrait.id")) ;
                 m.put("depot", d) ;
                 m.put("retrait", Long.parseLong("0")) ;
                 m.put("rub", rs4.getString("rubrique.rub")) ;
                 m.put("sousrub", rs4.getString("sousrub.srb")) ;
                 m.put("perso", rs4.getString("tiers")) ;
                 m.put("admin", rs4.getString("depot_retrait.admin")) ;
                 m.put("motif",  " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")) ;
                 
                 this.mlist.add(m) ;
                 
              
                  // "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "COMMISSIONAIRE", "UTILISATEUR", "MOTIF"
    dtm1.addRow(new Object[]{
   sdfT.format(rs4.getTimestamp("depot_retrait.dtec")),rs4.getLong("depot_retrait.id"),this.nf3.format(d)," ",
   rs4.getString("rubrique.rub"),rs4.getString("sousrub.srb"),rs4.getString("tiers"),rs4.getString("depot_retrait.admin"),
   " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")  // ,rs4.getString("type")
             
            
             }) ; 
                 
                 
             }
             
             
         }
         
         
         }
         
         
     }
     
      this.td.setText(nf3.format(td)) ; this.tr.setText(nf3.format(tr)) ;
        
        et = (td - tr) ;
      
      this.etat.setText(this.nf3.format(et)) ;  // (td - tr))) ;
            
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
        
       
     
     // Fin configure :
     
        
        
        
       
        
        
         }catch(Exception e){
             
             JOptionPane.showMessageDialog(this,"CHOISIR LES DEUX DATES ET HEURES SVP !!! ");
             
         }
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rActionPerformed
        // TODO add your handling code here:
        
        if(this.r.getSelectedItem().toString().equals("TOUT")){
            this.sr.removeAllItems();
        //    this.srb.addItem(new String("CHOISIR SOUS-RUBRIQUE")) ;
            this.sr.addItem(new String("TOUTE")) ;
            this.sr.setSelectedItem(new String("TOUTE")) ;
        }else{
        
        
         this.sr.removeAllItems() ;
          
        String rb = "" ;
               rb = this.r.getSelectedItem().toString().replaceAll("'", "''") ;
               int id = 0 ;
               this.rb1 = 0 ;
               
               
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
      
        
      String sql ;
      
       sql= "SELECT distinct id FROM rubrique WHERE rub = '"+rb+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
     
      this.rb1 =  rs.getInt("id")  ;
      id =  rs.getInt("id")  ;
     
     }
      
       
 //      this.srb.addItem(new String("CHOISIR SOUS RUBRIQUE"));
       this.sr.addItem(new String("TOUTE"));
       String sql2 ;
      
       sql2 = "SELECT srb FROM sousrub where id_r = "+id+" AND NOT type = 'non' ORDER BY srb ASC" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
                 
         this.sr.addItem(rs2.getString("srb"))  ;
         
       
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
     
        
        
        }
        
    }//GEN-LAST:event_rActionPerformed

    private void srActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srActionPerformed
        // TODO add your handling code here:
        
          try{
        String rb = "" ;
               rb = this.sr.getSelectedItem().toString().replaceAll("'", "''") ;
                this.srb1 = 0 ;
               
               
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
      
        
      String sql ;
      
       sql= "SELECT distinct id_srb FROM sousrub WHERE srb = '"+rb+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
     
      this.srb1 =  rs.getInt("id_srb")  ;
      
     
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
     
          }catch(Exception ex){
              
          }
        
        
    }//GEN-LAST:event_srActionPerformed

    private void comActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comActionPerformed
        // TODO add your handling code here:
        
        
         String rb = "" ;
               rb = this.com.getSelectedItem().toString().replaceAll("'", "''") ;
               this.com1 = 0 ;
               
               
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
      
        
      String sql ;
      
       sql= "SELECT distinct id_p FROM perso_t WHERE perso = '"+rb+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
     
      this.com1 =  rs.getInt("id_p")  ;
       
     
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
     
        
        
        
        
    }//GEN-LAST:event_comActionPerformed

    private void uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uActionPerformed
        // TODO add your handling code here:
        
        this.op = "" ;
        this.op = this.u.getSelectedItem().toString().replaceAll("'", "''") ;
        
        
    }//GEN-LAST:event_uActionPerformed

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aActionPerformed

    private void gaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gaActionPerformed
      
        
        this.ga.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
         
       
            
            try{
                
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
                
                
          InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Bon_d_r.jrxml")) ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.l_avis) ;
            
            Map<String, Object> para = new HashMap<>();
         // para.put("data", jrbean);
            
            
         // para.put("zone", "LE POINT DE PLACEMENT : "+this.zone) ;
           
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print, false);
            
                
                
            }catch(Exception e){
                
                
                 try{
                
                 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
                  String jour = "" ;
                         jour = sdf.format(new Date()) ;
                
                
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Bon_d_r.jrxml")) ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.l_avis) ;
            
            Map<String, Object> para = new HashMap<>();
            
         // para.put("data", jrbean);
           
            
            
         // para.put("zone", "LE POINT DE PLACEMENT : "+this.zone) ;
           
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print, false);
            
                }catch(Exception e2){
                    JOptionPane.showMessageDialog(this, e.getMessage()) ;
                }
                
                
                
            }
            
            
       
        
        this.ga.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
        
        
        
        
        
    }//GEN-LAST:event_gaActionPerformed

    private void oActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oActionPerformed

    private void refKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_refKeyReleased
       
        String ref = "" ;
        
        ref = this.ref.getText().trim().replaceAll("'", "''") ;
        
        
        
        
 
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
      
       
      
     
       
      
   
     DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                       dtm1.setRowCount(0) ;
                       
    SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
    
    long d = 0 ;
    long r = 0 ;
    long td = 0 ;
    long tr = 0 ;
    long et = 0 ;
    
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
     
        
      
             String query = "select * , sousrub.srb as sousrub from depot_retrait , rubrique , sousrub where depot_retrait.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND "
                 + "(depot_retrait.motif LIKE '%"+ref+"%' OR depot_retrait.reference LIKE '%"+ref+"%') "
                     +"AND rubrique.id = depot_retrait.rubrique AND id_srb = depot_retrait.srb "
                 + "ORDER BY depot_retrait.id desc , rub asc, sousrub asc" ;
    
        
         
         
         ResultSet rs4 = stmt.executeQuery(query) ;
         while(rs4.next()){
// "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "COMMISSIONAIRE", "UTILISATEUR", "MOTIF" 
             
             HashMap<String, Object> m = new HashMap<>() ;
             
              HashMap<String, Object> m_a = new HashMap<>() ;
             
             
              
                 m_a.put("id", rs4.getString("depot_retrait.id")) ;
                 m_a.put("cb", rs4.getString("depot_retrait.cb")) ;
                 m_a.put("mtt", nf3.format(rs4.getLong("depot_retrait.mtt"))) ;
                 m_a.put("motif", rs4.getString("depot_retrait.motif")) ;
                 m_a.put("dtec", sdfT.format(rs4.getTimestamp("depot_retrait.dtec"))) ;
                 m_a.put("admin", rs4.getString("depot_retrait.admin")) ;
                 m_a.put("type", rs4.getString("depot_retrait.type")) ;
                 m_a.put("rub", rs4.getString("rubrique.rub")) ;
                 m_a.put("COLUMN_15", rs4.getString("sousrub.srb")) ;
                 m_a.put("perso", "") ;
                 m_a.put("ref", rs4.getString("depot_retrait.reference")) ;
                 m_a.put("tiers", rs4.getString("depot_retrait.tiers")) ;
                 m_a.put("copie", "[COPIE]") ;
                 
                 
                 this.l_avis.add(m_a) ;
             
             
             d = 0 ;
             r = 0 ;
          // et = 0 ;
             
             if("depot".equalsIgnoreCase(rs4.getString("type"))){
                 td += rs4.getLong("mtt") ;
                 d   = rs4.getLong("mtt") ;
                  
             }else if("retrait".equalsIgnoreCase(rs4.getString("type"))){
                 tr += rs4.getLong("mtt") ;
                  r  = rs4.getLong("mtt") ;
             }
             
             if(d == 0){
                 
                 m.put("dtec", sdfT.format(rs4.getTimestamp("depot_retrait.dtec"))) ;
                 m.put("id", rs4.getLong("depot_retrait.id")) ;
                 m.put("depot", Long.parseLong("0")) ;
                 m.put("retrait", r) ;
                 m.put("rub", rs4.getString("rubrique.rub")) ;
                 m.put("sousrub", rs4.getString("sousrub.srb")) ;
                 m.put("perso", rs4.getString("tiers")) ;
                 m.put("admin", rs4.getString("depot_retrait.admin")) ;
                 m.put("motif",  " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")) ;
                 
                 this.mlist.add(m) ;
                 
                 
  // "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "COMMISSIONAIRE", "UTILISATEUR", "MOTIF"
    dtm1.addRow(new Object[]{
   sdfT.format(rs4.getTimestamp("depot_retrait.dtec")),rs4.getLong("depot_retrait.id")," ",this.nf3.format(r),
   rs4.getString("rubrique.rub"),rs4.getString("sousrub.srb"),rs4.getString("tiers"),rs4.getString("depot_retrait.admin"),
    " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")  // ,rs4.getString("type")
             
             }); 
                 
                 
             }else if(r == 0){
                 
                 m.put("dtec", sdfT.format(rs4.getTimestamp("depot_retrait.dtec"))) ;
                 m.put("id", rs4.getLong("depot_retrait.id")) ;
                 m.put("depot", d) ;
                 m.put("retrait", Long.parseLong("0")) ;
                 m.put("rub", rs4.getString("rubrique.rub")) ;
                 m.put("sousrub", rs4.getString("sousrub.srb")) ;
                 m.put("perso", rs4.getString("tiers")) ;
                 m.put("admin", rs4.getString("depot_retrait.admin")) ;
                 m.put("motif",  " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")) ;
                 
                 this.mlist.add(m) ;
                 
              
                  // "DATE & HEURE", "N°", "DEPOT", "RETRAIT", "RUBRIQUE", "SOUS-RUBRIQUE", "COMMISSIONAIRE", "UTILISATEUR", "MOTIF"
    dtm1.addRow(new Object[]{
   sdfT.format(rs4.getTimestamp("depot_retrait.dtec")),rs4.getLong("depot_retrait.id"),this.nf3.format(d)," ",
   rs4.getString("rubrique.rub"),rs4.getString("sousrub.srb"),rs4.getString("tiers"),rs4.getString("depot_retrait.admin"),
   " ["+rs4.getString("reference")+"]"+" "+rs4.getString("motif")  // ,rs4.getString("type")
             
            
             }) ; 
                 
                 
             }
             
             
         }
         
         
         
         
      
     
      this.td.setText(nf3.format(td)) ; this.tr.setText(nf3.format(tr)) ;
        
        et = (td - tr) ;
      
      this.etat.setText(this.nf3.format(et)) ;  // (td - tr))) ;
            
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
        
        
    }//GEN-LAST:event_refKeyReleased

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
            java.util.logging.Logger.getLogger(Mycompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mycompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mycompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mycompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mycompte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox a;
    private javax.swing.JTextField cfa;
    private javax.swing.JComboBox com;
    private javax.swing.JTextField dollar;
    private javax.swing.JTextField etat;
    private javax.swing.JTextField euro;
    private javax.swing.JButton ga;
    private javax.swing.JTextField h1;
    private javax.swing.JTextField h2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox o;
    private javax.swing.JComboBox r;
    private javax.swing.JTextField ref;
    private javax.swing.JComboBox sr;
    private javax.swing.JTextField td;
    private javax.swing.JTextField tr;
    private javax.swing.JComboBox u;
    // End of variables declaration//GEN-END:variables
}
