/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import config.Reporting.FactElem;
import static frontend.NewProd1.JDBC_DRIVER;
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
public class Compte_fourni extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
       String user ;
       String role ;
       String fournisseur ;
      
       Integer fourni = 0 ;
       Integer cb ;
       
       long mtt_fact = 0 ;
       long mtt_paye = 0 ;
       long etat = 0 ;
       String et_ = "" ;
       String et_1 = "" ;
       
       NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
       
       ArrayList<FactElem> liste_an = new ArrayList<FactElem>() ;
       ArrayList<List_df> list = new ArrayList<List_df>() ;
       List bonList = new ArrayList() ;
       
       // my reporting parameters variable :
       
       String fr_rp ;
       String rfs ;
       String cmt ;
       String periode;
       String ope ;
       String num ;
       String total;
       Integer vy = 0 ;
       
       
       String ma = "" ;
       long osa = 0 ;
       long nsa = 0 ;
      
      
    public Compte_fourni() {
        initComponents();
        this.setLocationRelativeTo(null) ;
        
    }
    
    public Compte_fourni(String user, String role, Integer fourni){
        
        this.setTitle("Production en cours ") ;
        initComponents() ;
        this.setLocationRelativeTo(null) ;
        
        this.user = user ;
        this.role = role ;
        this.fourni = fourni ;
        
        
        Date jour = new Date() ;
        this.jDateChooser1.setDate(jour);
        this.h1.setText("00:00") ;
        this.jDateChooser2.setDate(jour) ;
        this.h2.setText("23:59") ;
        
        
        
        
        // ---------------- 1è choix --------------
        
        
            this.jTable1.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable1.getTableHeader().setOpaque(false); 
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
                  
                  DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                     dtm1.addRow(new Object[]{1 , "xxxxxxxxxxxxxxxxxxxx","100.000","150.000",0}) ;
        
     //   -------------------------------------------------------------------
        
        
                  
                   // ---------------- 1è choix --------------
            this.jTable2.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable2.getTableHeader().setOpaque(false); 
            this.jTable2.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable2.getTableHeader().setForeground(Color.white) ;
        
              this.jTable2.setRowHeight(25) ;
              
         
                  for (int i = 0; i < this.jTable2.getModel().getColumnCount(); i++) {
                    this.jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
                   DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                     dtm2.addRow(new Object[]{1 , "xxxxxxxxxxxxxxxxxxxx","100.000","150.000",0});
                  
     //   -------------------------------------------------------------------
        
                   // ---------------- 1è choix --------------
            this.jTable3.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable3.getTableHeader().setOpaque(false); 
            this.jTable3.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable3.getTableHeader().setForeground(Color.white) ;
        
              this.jTable3.setRowHeight(25) ;
              
        
            
                  for (int i = 0; i < this.jTable3.getModel().getColumnCount(); i++) {
                    this.jTable3.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
                   DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                     dtm3.addRow(new Object[]{1 , "xxxxxxxxxxxxxxxxxxxx","100.000","150.000" ,"150.000"}) ;
                     
     //   -------------------------------------------------------------------
        
        
                     
                     
                     
                      if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR") || this.role.equalsIgnoreCase("ADMINISTRATEUR")){
                      
                       
                      
                               }else{
                               
                                         this.an.setEnabled(false) ;
                                         this.an1.setEnabled(false) ;
                                         this.pyer.setEnabled(false) ;
                                       
                                      }
                      
                      
                      
                      
                      this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 6) ;
        String status_s = (String) table.getModel().getValueAt(row, 8) ;
        
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        if ("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        } else {
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

                  
                  // pour produit obtenu :
                  
                  
                   this.jTable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 4) ;
        
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
            table.setSelectionBackground(Color.LIGHT_GRAY);
            table.setSelectionForeground(Color.white) ;
            
        if ("oui".equalsIgnoreCase(status)) {
             setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        } else {
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

                   
                   this.jTable3.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 4) ;
        
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
            table.setSelectionBackground(Color.LIGHT_GRAY);
            table.setSelectionForeground(Color.white) ;
            
        if ("oui".equalsIgnoreCase(status)) {
             setBackground(Color.WHITE);
             setForeground(Color.BLACK);
        } else {
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


                
                   
                  
                   
                  
                  dtm1.setRowCount(0) ;
                  dtm2.setRowCount(0) ;
                  dtm3.setRowCount(0) ; 
        
        
                  
                  
                  //  chargement de la page :
                  
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
      
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        
        
        String sql = null ;
        ResultSet rs = null ;      
        this.mtt_fact = 0 ;
        
        sql = "select entreprise from fournisseurs where id = "+this.fourni ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            this.fournisseur = rs.getString("entreprise") ;
        }
       
        this.jLabel1.setText("COMPTE FOURNISSEUR :  "+this.fournisseur);
        
        sql = "select * from facture_fourni where fourni = "+this.fourni+" order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT"
            
            dtm1.addRow(new Object[]{
                
              "TR"+rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb"), "TR"
                    
            }) ;
            
        }
        
        
        sql = "select * from facture_fourni where fourni = "+this.fourni+" AND etat = 'oui' " ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            
            this.mtt_fact += rs.getLong("mtt") ;
            
        }
        
        
        this.mf.setText(this.nf3.format(this.mtt_fact));
        this.mtt_paye = 0 ;
        
        
        sql = "select mtt from payer_fourni where fourni = "+this.fourni+" AND type = 'oui' order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
       //  "ID", "DATE HEURE", "MONTANT", "UTILISATEUR"
            
          this.mtt_paye += rs.getLong("mtt") ;
          
 
        }
        
        
        
        sql = "select * from payer_fourni where fourni = "+this.fourni+" order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
       //  "ID", "DATE HEURE", "MONTANT", "UTILISATEUR"
            
         //   this.mtt_paye += rs.getLong("mtt") ;
            
            dtm3.addRow(new Object[]{
             rs.getLong("id") , sdf.format(rs.getTimestamp("datej")) , this.nf3.format(rs.getLong("mtt")) , 
                rs.getString("op") , rs.getString("type")
                    
            }) ;
 
        }
        
        
        
        
       
        this.etat = (this.mtt_fact - this.mtt_paye) ;
        this.rgl.setText(this.nf3.format(this.mtt_paye)) ;
        this.et.setText(this.nf3.format(this.etat)) ;
        
        
        // ......
        
        
        
        
        
        
        
            
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
        
       
       
       
       String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
       String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
       String USER = "root" ;
       String PASS = "interco" ;

       
       
         //  chargement de la page :
                  
                    
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
      
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        
        
        String sql = null ;
        ResultSet rs = null ;      
  
        
        sql = "select * from op_stock where fournisseur = "+this.fourni+" order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT"
            
            dtm1.addRow(new Object[]{
                
              "GC"+rs.getInt("id") , rs.getString("rf") , "GESCOM" , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getDouble("total")) , "" , rs.getString("etat") , rs.getInt("cb"), "GC"
                    
            }) ;
            
        }
        
        
        sql = "select * from op_stock where fournisseur = "+this.fourni+" AND etat = 'oui' " ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            
            this.mtt_fact += rs.getDouble("total") ;
            
        }
        
        
        this.mf.setText(this.nf3.format(this.mtt_fact));
        
        
   
        
        
       
        this.etat = (this.mtt_fact - this.mtt_paye) ;
        this.rgl.setText(this.nf3.format(this.mtt_paye)) ;
        this.et.setText(this.nf3.format(this.etat)) ;
        
        
        // ......
        
        
        
        
        
        
        
            
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        py = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pyer = new javax.swing.JButton();
        an = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        an1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ref = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        h1 = new javax.swing.JTextField();
        h2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        mf = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rgl = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        et = new javax.swing.JTextField();
        ecran = new javax.swing.JLabel();

        setTitle("COMPTE FOURNISSEUR");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("COMPTE FOURNISSEUR");

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT", "SIBY ARS CB", "SOURCE"
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(55);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(28);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(42);
            jTable1.getColumnModel().getColumn(8).setMinWidth(0);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPTION", "QTE ENTREE", "P.A", "MONTANT", "ETAT"
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
        jTable2.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(210);
        }

        jTable3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DATE HEURE", "MONTANT", "UTILISATEUR", "TYPE"
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
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable3.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTable3.getColumnModel().getColumn(4).setPreferredWidth(1);
        }

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LES OPERATIONS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 12))); // NOI18N

        py.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MONTANT");

        pyer.setBackground(new java.awt.Color(51, 102, 255));
        pyer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pyer.setForeground(new java.awt.Color(255, 255, 255));
        pyer.setText("PAYER FACTURE");
        pyer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pyerActionPerformed(evt);
            }
        });

        an.setBackground(new java.awt.Color(255, 51, 0));
        an.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        an.setForeground(new java.awt.Color(255, 255, 255));
        an.setText("ANNULER FACTURE");
        an.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        an.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 204, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("IMPRIMER FACTURE");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        an1.setBackground(new java.awt.Color(255, 51, 0));
        an1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        an1.setForeground(new java.awt.Color(255, 255, 255));
        an1.setText("ANNULER PAYEMENT");
        an1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        an1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                an1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pyer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(py)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(an, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(an1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(an1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(an, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(py, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pyer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("LISTE FACTURE");

        ref.setText("REF FACTURE");
        ref.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                refFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                refFocusLost(evt);
            }
        });
        ref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refActionPerformed(evt);
            }
        });
        ref.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                refKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("DETAIL FACTURE.");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("HISTORIQUE DE PAYEMENT");

        jLabel7.setText("DU");

        jLabel8.setText("HEURE");

        jLabel9.setText("HEURE");

        jLabel10.setText("AU");

        jButton5.setBackground(new java.awt.Color(51, 102, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("RECHERCHER");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        mf.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("MONTANT FACTURE");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("MONTANT PAYER");

        rgl.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("ETAT (TF - TP)");

        et.setEditable(false);

        ecran.setBackground(new java.awt.Color(255, 255, 255));
        ecran.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mf, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(281, 281, 281))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(234, 234, 234)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(399, 399, 399)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(ref)
                                                .addGap(27, 27, 27)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(rgl, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(33, 33, 33)
                                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(et, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                        .addGap(7, 7, 7)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1)
                                        .addGap(28, 28, 28)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(99, 99, 99))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ecran, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62)))))
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(et, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addComponent(ref, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ecran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refActionPerformed
private String source = "" ;
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        
        this.jTable3.getSelectionModel().clearSelection();
        
        this.bonList.removeAll(this.bonList) ;
        this.list.removeAll(this.list) ;
        
        this.cb = 0 ;
        
        this.cb = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 7).toString()) ;
        this.fr_rp = "Fournisseur : "+this.fournisseur ;
        this.rfs = "Ref saisie : "+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString() ;
        this.cmt = "Commentaire : "+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString() ;
        this.periode = "Date facture : "+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString() ;
        this.ope = "OP : "+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 5).toString() ;
        this.num = "Num : "+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString() ;
        this.total = "Total : "+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4).toString() ;
        this.source = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 8).toString() ;
        
        
        //
        
            this.et_1 = "" ;
        this.et_1 = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 6).toString() ;
        
        if(this.et_1.equalsIgnoreCase("non")){
            this.an.setEnabled(false);
        }else if(this.et_1.equalsIgnoreCase("oui")){
            
            this.an.setEnabled(true);
            
        }
        
        //
        
        
        
       // JOptionPane.showMessageDialog(null, "code barre : "+this.cb);
        
        
        
                      Connection conn = null ;
                      Statement stmt = null ;
       
       try{
        //  STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                          dtm2.setRowCount(0) ;
        
        
        String sql = null ;
        ResultSet rs = null ;      
        
        sql = "select * from detail_facture where cb_fact = "+this.cb ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            
             HashMap<String, Object> m = new HashMap<>() ;
                  
                   m.put("description",  rs.getString("description")) ;
                   m.put("qte", this.nf3.format(rs.getLong("qte"))) ;
                   m.put("pa", this.nf3.format(rs.getLong("pa"))) ;
                   m.put("mtt", this.nf3.format(rs.getLong("mtt"))) ;
                    
                   this.bonList.add(m) ;
            
            // "DESCRIPTION", "QTE ENTREE", "P.A", "MONTANT", "ETAT"

            dtm2.addRow(new Object[]{
              rs.getString("description") , this.nf3.format(rs.getLong("qte")) ,
                this.nf3.format(rs.getLong("pa")) , this.nf3.format(rs.getLong("mtt")) , rs.getString("etat")
            }) ;    
            
        }
        
        String e = "" ;
        this.vy = 0 ;
        sql = "select * from op_pl_f where cb = "+this.cb ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            this.ma = rs.getString("arriver") ;
            e = rs.getString("type") ;
            this.vy = 1 ;
            
        }
        
        sql = "select * from detail_pl where cb_op = "+this.cb ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            List_df  ld = new List_df(rs.getString("description") , rs.getLong("qte")) ;
                     this.list.add(ld) ;
            
        }
        
        
        int a = 0 ;
        
       sql = "select * from facture_fourni where cb = "+this.cb+" and etat = 'non'" ;
       rs = stmt.executeQuery(sql) ;
       while(rs.next()){
           
           try{
           this.ecran.setText(rs.getString("login_sup")+"    "+sdf.format(rs.getTimestamp("date_sup"))) ;
           a = 1 ;
           }catch(Exception e1){
               
           }
       }
       
       if(a==0){
           this.ecran.setText("");
       }
        
         
        // ......
        
        
        
        
        
        
        
            
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
       
       
        
        
       if(this.source.equalsIgnoreCase("GC")){
           
              
       
       
       String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
       String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
       String USER = "root" ;
       String PASS = "interco" ;

       
       
         //  chargement de la page :
    
       
       
       try{
        //  STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                          dtm2.setRowCount(0) ;
        
        
        String sql = null ;
        ResultSet rs = null ;      
        
        sql = "select * from panier_stock where cb = "+this.cb ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            
             HashMap<String, Object> m = new HashMap<>() ;
                  
                   m.put("description",  rs.getString("description")) ;
                   m.put("qte", this.nf3.format(rs.getInt("qte"))) ;
                   m.put("pa", this.nf3.format(rs.getInt("prix_achat"))) ;
                   m.put("mtt", this.nf3.format(rs.getDouble("mtt"))) ;
                    
                   this.bonList.add(m) ;
            
            // "DESCRIPTION", "QTE ENTREE", "P.A", "MONTANT", "ETAT"

            dtm2.addRow(new Object[]{
              rs.getString("description") , this.nf3.format(rs.getInt("qte")) ,
              this.nf3.format(rs.getInt("prix_achat")) , this.nf3.format(rs.getDouble("mtt")) , rs.getString("etat")
            }) ;    
            
        }
  
        
         
        // ......
        
        
        
        
        
        
        
            
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
        
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void pyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pyerActionPerformed
        // TODO add your handling code here:
        
        if("".equalsIgnoreCase(this.py.getText().trim())){
            JOptionPane.showMessageDialog(null, "ENTRER UN MONTANT");
        }else{
        
        long py = 0 ;
        
        try{
             py = Long.parseLong(this.py.getText()) ;
             
                      Connection conn = null ;
                      Statement stmt = null ;
       
       try{
           
        //  STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...") ;
      stmt = conn.createStatement();
      
      // je crai ma requete
      
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        
      //     DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
     //                     dtm2.setRowCount(0) ;
        
        
        String sql = null ;
        ResultSet rs = null ;      
        
       
        
        if(this.etat >= py && py > 4){
            
            if(stmt.executeUpdate("insert into payer_fourni(datej,mtt,op,fourni,type) values('"+sdf.format(new Date())+"' , "
                    +py+" , '"+this.user.replaceAll("'" , "''")+"' , "+this.fourni+" , 'oui' )") == 1){
                
                 this.mtt_paye = 0 ;
                 DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                   dtm3.setRowCount(0) ;
                                   
                                   
        sql = "select mtt from payer_fourni where fourni = "+this.fourni+" and type = 'oui' order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
       
             this.mtt_paye += rs.getLong("mtt") ;
             
              
        }                         
                                   
        
        
        sql = "select * from payer_fourni where fourni = "+this.fourni+" order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
             // "ID", "DATE HEURE", "MONTANT", "UTILISATEUR"
             
             dtm3.addRow(new Object[]{
               rs.getLong("id") , sdfT.format(rs.getTimestamp("datej")) , this.nf3.format(rs.getLong("mtt")) ,
                 rs.getString("op") , rs.getString("type")
             }) ;
 
        }
        
        this.etat = (this.mtt_fact - this.mtt_paye) ;
        this.rgl.setText(this.nf3.format(this.mtt_paye)) ;
        this.et.setText(this.nf3.format(this.etat)) ;
        
        this.py.setText("") ;
        
        JOptionPane.showMessageDialog(null, "OPERATION REUSSIT") ;
        
        rs.close();
                
            }
            
        }else{
        
            JOptionPane.showMessageDialog(null, "MONTANT POSSIBLE / LIMITE : "+nf3.format(this.etat)) ; 
            
        }
       
        
        
         
        // ......
        
        
        
        
        
        
        
            
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
        
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "LE MONTANT EN CHIFFRE") ;
        }
        
        }
        
    }//GEN-LAST:event_pyerActionPerformed

    private void refFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_refFocusGained
        // TODO add your handling code here:
        
       this.ref.setText("") ;
        
    }//GEN-LAST:event_refFocusGained

    private void refFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_refFocusLost
        // TODO add your handling code here:
        
         String ref = this.ref.getText().trim()  ;
        
        if(ref.equalsIgnoreCase("")){
             this.ref.setText("REF FACTURE") ;
          }
        
        
    }//GEN-LAST:event_refFocusLost

    private void refKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_refKeyReleased
        // TODO add your handling code here:
        
        
        String ref = "" ;
               ref = this.ref.getText().trim().replaceAll("'", "''") ;
               
               if(ref.equalsIgnoreCase("")){
                   
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
      
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                          dtm1.setRowCount(0) ;
                          
                          DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                          dtm2.setRowCount(0) ;
        
        
        String sql = null ;
        ResultSet rs = null ;      
         
        
          
        sql = "select * from facture_fourni where fourni = "+this.fourni+" order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb")
                    
            }) ;
            
        }
        
         
        
        // ......
        
         
            
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
                   
                   //  chargement de la page :
                  
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
      
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                          dtm1.setRowCount(0) ;
                          
                          DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                          dtm2.setRowCount(0) ;
        
        
        
        String sql = null ;
        ResultSet rs = null ;      
         
        
          
        sql = "select * from facture_fourni where ref_saisie like '%"+ref+"%' AND fourni = "+this.fourni ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb")
                    
            }) ;
            
        }
        
         
        
        // ......
        
         
            
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
        
        
    }//GEN-LAST:event_refKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
         try{
            
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
        SimpleDateFormat sdfT1 = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
       
      //  this.dte1 = sdfT1.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
     //   this.dte2 = sdfT1.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText().trim() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText().trim() ;
        
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                          dtm1.setRowCount(0) ;
                          
                          DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                          dtm2.setRowCount(0) ;
        
                          
                          
                            //  chargement de la page :
                  
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
      
       
        
        String sql = null ;
        ResultSet rs = null ;      
         
        
          
        sql = "select * from facture_fourni where datej BETWEEN '"+dte1+"' AND '"+dte2+"' AND fourni = "+this.fourni+" order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdfT1.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb")
                    
            }) ;
            
        }
        
         
        
        // ......
        
         
            
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
             
             this.h1.setText("");
             this.h2.setText("");
             DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                               dtm1.setRowCount(0) ;
                               
                               DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                          dtm2.setRowCount(0) ;
        
             
             
             JOptionPane.showMessageDialog(null, "CHOISIR LA PERIODE !");
         }
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void anActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "SELECTIONNER UNE FACTURE") ;
        }else{
            
             
        if(JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS ANNULER LA FACTURE ? ", "AVERTISSEMENT" , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            // yes option :
            
            if(this.vy == 1){
                // op pl f :
                
                 ArrayList<Integer> error = new ArrayList<Integer>() ;
        
                           error.add(Integer.parseInt(new String("0"))) ;
                 
         
                         Connection conn = null ;
                         Statement stmt = null ;
       
       try{
        //  STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      conn.setAutoCommit(false) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
       String sql = null ;
       ResultSet rs = null ;  
       
       ArrayList<String> list_etat = new ArrayList<String>() ;
       
       // Integer vy = 0 ;
       
       for(int i = 0 ; i < this.list.size(); i++){
           
           this.osa = 0 ;
           sql = "select stock_dispo from stock_pl where magasin = '"+this.ma.replaceAll("'", "''")+"' and "
                   + "description = '"+this.list.get(i).getDesi().replaceAll("'", "''")+"'" ;
           rs = stmt.executeQuery(sql) ;
           while(rs.next()){
               this.osa = rs.getLong("stock_dispo") ;
      
           }
           
           if(this.osa >= this.list.get(i).getQte()){
           
           this.nsa = (this.osa - this.list.get(i).getQte()) ;
           
           stmt.executeUpdate("update stock_pl set stock_dispo = "+this.nsa+" where magasin = '"+this.ma.replaceAll("'", "''")+"' and "
                   + "description = '"+this.list.get(i).getDesi().replaceAll("'", "''")+"'") ;
           stmt.executeUpdate("update detail_pl set type = 'non' where cb_op = "+this.cb) ;
           stmt.executeUpdate("update stock_detail_pl set type = 'non' where cb_op = "+this.cb) ;
           stmt.executeUpdate("update op_pl_f set type = 'non' where cb = "+this.cb) ;
           
         
           
           // deuxieme partie du code :
           
     
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        SimpleDateFormat sdf_sup = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        String date_sup = sdf_sup.format(new Date()) ;
        
        
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        
        stmt.executeUpdate("update facture_fourni set etat = 'non' where cb = "+this.cb) ;
        stmt.executeUpdate("update facture_fourni set login_sup = '"+this.user+"' where cb = "+this.cb) ;
        stmt.executeUpdate("update facture_fourni set date_sup = '"+date_sup+"' where cb = "+this.cb) ;
        stmt.executeUpdate("update detail_facture set etat = 'non' where cb_fact = "+this.cb) ;
         dtm1.setRowCount(0); dtm2.setRowCount(0) ;
        
        
               
                
                 
        
         sql = "select * from facture_fourni where fourni = "+this.fourni+" order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb")
                    
            }) ;
            
        }
        
        this.mtt_fact = 0 ;
        sql = "select * from facture_fourni where fourni = "+this.fourni+" AND etat = 'oui' " ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            
            this.mtt_fact += rs.getLong("mtt") ;
            
        }
        
        
        this.mf.setText(this.nf3.format(this.mtt_fact));
        this.mtt_paye = 0 ;
        
        sql = "select * from payer_fourni where fourni = "+this.fourni+" and type = 'oui' order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
       //  "ID", "DATE HEURE", "MONTANT", "UTILISATEUR"
            
            this.mtt_paye += rs.getLong("mtt") ;
            
            
        }

        
        
        this.etat = (this.mtt_fact - this.mtt_paye) ;
        this.rgl.setText(this.nf3.format(this.mtt_paye)) ;
        this.et.setText(this.nf3.format(this.etat)) ;
        
        
        list_etat.add(new String("0")) ;
        
         
        // ......
        
                
           
           
         // end for secondary party :
        
         
        
                           error.add(Integer.parseInt(new String("0"))) ;
           
           }else{
               
               error.add(Integer.parseInt(new String("1"))) ;
               list_etat.add(new String("1")) ;
               
               
           }
           
       } // end op_pl_f annuler :
       
    
               if(list_etat.contains(new String("1")) || error.contains(Integer.parseInt("1"))){
                   
                   conn.rollback();
                   Compte_fourni cf = new Compte_fourni(this.user, this.role, this.fourni) ;
                      cf.setVisible(true) ;
                      this.setVisible(false) ;
                      
                   JOptionPane.showMessageDialog(null, "UNE QTE INSUFFISANTE DONC PAS D'ANNULATION") ;
                   
                  }else{
                      
                   conn.commit() ;
                   
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
        
        
     
                
                // end op pl f
                
                
            }else if(this.vy == 0){
                
            this.liste_an.removeAll(this.liste_an) ;
        
         
                         Connection conn = null ;
                         Statement stmt = null ;
       
       try{
        //  STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      conn.setAutoCommit(false) ;
      

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        SimpleDateFormat sdf_sup = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        String date_sup = sdf_sup.format(new Date()) ;
        
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        
        if(stmt.executeUpdate("update facture_fourni set etat = 'non' where cb = "+this.cb) == 1){
               stmt.executeUpdate("update facture_fourni set login_sup = '"+this.user+"' where cb = "+this.cb) ;
               stmt.executeUpdate("update facture_fourni set date_sup = '"+date_sup+"' where cb = "+this.cb) ;
            if(stmt.executeUpdate("update detail_facture set etat = 'non' where cb_fact = "+this.cb) >= 0){
                
                dtm1.setRowCount(0); dtm2.setRowCount(0);
                
                 String sql = null ;
                 ResultSet rs = null ;      
        
        sql = "select * from detail_facture where cb_fact = "+this.cb ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            
            FactElem fl = new FactElem(rs.getString("description"), rs.getLong("qte")) ;
                     this.liste_an.add(fl) ;
                     
                      
        }
        
        
        for(int i = 0; i < this.liste_an.size(); i++){
            
            long oldStock = 0 ;
            long newStock = 0 ;
            String magasin = "" ;
            
            sql = "select magasin from magasins where etat = 'oui' " ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                magasin = rs.getString("magasin") ;
            }
            
            sql = "select stock from stock1 where desi = '"+this.liste_an.get(i).getDescription().replaceAll("'", "''")+"' and maga = '"+magasin.replaceAll("'", "''")+"'" ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                oldStock = rs.getLong("stock") ;
            }
            
            if(oldStock >= this.liste_an.get(i).getQte() ){
            newStock = (oldStock - this.liste_an.get(i).getQte()) ;
            
       if(stmt.executeUpdate("update stock1 set stock = "+newStock+" where desi = '"+this.liste_an.get(i).getDescription().replaceAll("'", "''")+"' and maga = '"+magasin.replaceAll("'", "''")+"'") >= 0){
                 
                     if(stmt.executeUpdate("update stock2 set et_ = 'non' where desi = '"+this.liste_an.get(i).getDescription().replaceAll("'", "''")+"' and maga = '"+magasin.replaceAll("'", "''")+"' "
                             + "and op_ = "+this.cb+"") >= 0){
                         
                         
                     }
                
            }
            
        }
       
        
         sql = "select * from facture_fourni where fourni = "+this.fourni+" order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb")
                    
            }) ;
            
        }
        
        this.mtt_fact = 0 ;
        sql = "select * from facture_fourni where fourni = "+this.fourni+" AND etat = 'oui' " ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            
            this.mtt_fact += rs.getLong("mtt") ;
            
        }
        
        
        this.mf.setText(this.nf3.format(this.mtt_fact));
        this.mtt_paye = 0 ;
        
        sql = "select * from payer_fourni where fourni = "+this.fourni+" and type = 'oui' order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
       //  "ID", "DATE HEURE", "MONTANT", "UTILISATEUR"
            
            this.mtt_paye += rs.getLong("mtt") ;
            
            
        }
        
        
       
        this.etat = (this.mtt_fact - this.mtt_paye) ;
        this.rgl.setText(this.nf3.format(this.mtt_paye)) ;
        this.et.setText(this.nf3.format(this.etat)) ;
        
        rs.close();
         
        // ......
        
                
                
                
            }
        }
                          
        }
        
       
        
       conn.commit() ;
            
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
        
        
     
          
             
       }    // end vy == 0
            
        }else{
            // NO OPTION :
            
        }
            
        
       
        
        }
        
        
    }//GEN-LAST:event_anActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "SELECTIONNER FACTURE") ;
            
        }else{
            
            // JPRINTING .....
            
            
               this.jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
         
        try{
                
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Facture_Fourni.jrxml")) ;
              
            
            JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(this.bonList) ;
            
            
            Map<String, Object> para = new HashMap<>() ;
            
            // para.put("data", jrbean);
             
            para.put("cb", this.cb) ;
            para.put("fr", this.fr_rp) ;
            para.put("rfs", this.rfs) ;
            para.put("cmt", this.cmt) ;
            para.put("periode", this.periode) ;
            para.put("op", this.ope) ;
            para.put("num", this.num) ;
            para.put("total", this.total) ;
      
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, data) ;
            
            JasperViewer.viewReport(print, false);
            
                
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage()) ;
            }
            
        this.jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
            
            // end ...
            
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void an1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_an1ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable3.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "SELECTIONNER UN PAYEMENT !") ;
        }else{
            
            /*
            
                if(this.et_.equalsIgnoreCase("non")){
                
                 if(JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS REACTIVER LE PAYEMENT ? ", "AVERTISSEMENT" , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    // yes option :
             
          
                      Connection conn = null ;
                      Statement stmt = null ;
       
       try{
           
        //  STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
          conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...") ;
         stmt = conn.createStatement();
      
      // je crai ma requete
      
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        
      //     DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
     //                     dtm2.setRowCount(0) ;
        
        
        String sql = null ;
        ResultSet rs = null ;      
        
       
        
        if(this.id_p > 0){
            
            if(stmt.executeUpdate("UPDATE payer_fourni SET type = 'oui' where id = "+this.id_p) == 1){
                
               
                
                 this.mtt_paye = 0 ;
                 DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                   dtm3.setRowCount(0) ;
                             
                                   
        sql = "select mtt from payer_fourni where fourni = "+this.fourni+" and type = 'oui' order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
       
             this.mtt_paye += rs.getLong("mtt") ;
                 
            }
        
        
        sql = "select * from payer_fourni where fourni = "+this.fourni+" order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
       
      //       this.mtt_paye += rs.getLong("mtt") ;
             
             // "ID", "DATE HEURE", "MONTANT", "UTILISATEUR"
             
             dtm3.addRow(new Object[]{
               rs.getLong("id") , sdfT.format(rs.getTimestamp("datej")) , this.nf3.format(rs.getLong("mtt")) ,
                 rs.getString("op") , rs.getString("type")
             }) ;
 
        }
        
        this.etat = (this.mtt_fact - this.mtt_paye) ;
        this.rgl.setText(this.nf3.format(this.mtt_paye)) ;
        this.et.setText(this.nf3.format(this.etat)) ;
        
        
        JOptionPane.showMessageDialog(null, "OPERATION REUSSIT") ;
        
        rs.close();
                
            }
            
        }else{
        
            JOptionPane.showMessageDialog(null, "SELECTIONNER DANS LA LISTE DES PAYEMENT") ; 
            
        }
       
        
        
         
        // ......
        
        
        
        
        
        
        
            
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
         
             
         }else{
             // no option :
             
             
         }
                
                
                
            }else
            
            */
            
             if(this.et_.equalsIgnoreCase("oui")){
        
        
         if(JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS ANNULER LE PAYEMENT ? ", "AVERTISSEMENT" , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
           
             // yes option :
             
          
                      Connection conn = null ;
                      Statement stmt = null ;
       
       try{
           
        //  STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
          conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...") ;
         stmt = conn.createStatement();
      
      // je crai ma requete
      
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        
      //     DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
     //                     dtm2.setRowCount(0) ;
        
        
        String sql = null ;
        ResultSet rs = null ;      
        
       
        
        if(this.id_p > 0){
            
            if(stmt.executeUpdate("UPDATE payer_fourni SET type = 'non' where id = "+this.id_p) == 1){
                
                 stmt.executeUpdate("UPDATE payer_fourni SET login_sup = '"+this.user+"' where id = "+this.id_p) ;
                 stmt.executeUpdate("UPDATE payer_fourni SET date_sup = '"+sdf.format(new Date())+"' where id = "+this.id_p) ;
                
                 this.mtt_paye = 0 ;
                 DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                   dtm3.setRowCount(0) ;
                             
                                   
        sql = "select mtt from payer_fourni where fourni = "+this.fourni+" and type = 'oui' order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
       
             this.mtt_paye += rs.getLong("mtt") ;
                 
            }
        
        
        sql = "select * from payer_fourni where fourni = "+this.fourni+" order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
       
      //       this.mtt_paye += rs.getLong("mtt") ;
             
             // "ID", "DATE HEURE", "MONTANT", "UTILISATEUR"
             
             dtm3.addRow(new Object[]{
               rs.getLong("id") , sdfT.format(rs.getTimestamp("datej")) , this.nf3.format(rs.getLong("mtt")) ,
                 rs.getString("op") , rs.getString("type")
             }) ;
 
        }
        
        this.etat = (this.mtt_fact - this.mtt_paye) ;
        this.rgl.setText(this.nf3.format(this.mtt_paye)) ;
        this.et.setText(this.nf3.format(this.etat)) ;
        
        
        JOptionPane.showMessageDialog(null, "OPERATION REUSSIT") ;
        
        rs.close();
                
            }
            
        }else{
        
            JOptionPane.showMessageDialog(null, "SELECTIONNER DANS LA LISTE DES PAYEMENT") ; 
            
        }
       
        
        
         
        // ......
        
        
        
        
        
        
        
            
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
         
             
         }else{
             // no option :
             
             
         }
         }
         } // else jtable == -1
        
    }//GEN-LAST:event_an1ActionPerformed
        long id_p ;
    private void jTable3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseReleased
        // TODO add your handling code here:
        
        this.jTable1.getSelectionModel().clearSelection();
        
        this.id_p = 0 ;
        this.id_p = Long.parseLong(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0).toString()) ;
        
        this.et_ = "" ;
        this.et_ = this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 4).toString() ;
        
        if(this.et_.equalsIgnoreCase("non")){
            this.an1.setEnabled(false);
        }else if(this.et_.equalsIgnoreCase("oui")){
            
            this.an1.setEnabled(true);
            
        }
        
        
        // ouverture sur le serveur :
        
                      Connection conn = null ;
                      Statement stmt = null ;
       
       try{
        //  STEP 2: Register JDBC driver
        Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        
        
        String sql = null ;
        ResultSet rs = null ;      
        
        
        int a = 0 ;
        
       sql = "select * from payer_fourni where id = "+this.id_p+" and type = 'non'" ;
       rs = stmt.executeQuery(sql) ;
       while(rs.next()){
           
           try{
           this.ecran.setText(rs.getString("login_sup")+"    "+sdf.format(rs.getTimestamp("date_sup"))) ;
           a = 1 ;
           }catch(Exception e1){
               
           }
       }
       
       if(a==0){
           this.ecran.setText("");
       }
        
         
        // ......
        
        
        
        
        
        
        
            
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
        
        
        
        
        // 
        
        
        
        
        
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
            java.util.logging.Logger.getLogger(Compte_fourni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compte_fourni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compte_fourni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compte_fourni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compte_fourni().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton an;
    private javax.swing.JButton an1;
    private javax.swing.JLabel ecran;
    private javax.swing.JTextField et;
    private javax.swing.JTextField h1;
    private javax.swing.JTextField h2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField mf;
    private javax.swing.JTextField py;
    private javax.swing.JButton pyer;
    private javax.swing.JTextField ref;
    private javax.swing.JTextField rgl;
    // End of variables declaration//GEN-END:variables
}
