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
public class Compte_fourni1_Departement extends javax.swing.JFrame {

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
    
       
       NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
       
       ArrayList<FactElem> liste_an = new ArrayList<FactElem>() ;
       List bonList = new ArrayList() ;
       
       // my reporting parameters variable :
       
       String fr_rp ;
       String rfs ;
       String cmt ;
       String periode;
       String ope ;
       String num ;
       String total;
      
      
    public Compte_fourni1_Departement() {
        this.setTitle("OPERATIONS DE STOCK ");
        initComponents();
        this.setLocationRelativeTo(null) ;
        
    }
    
    public Compte_fourni1_Departement(String user, String role){
        this.setTitle("OPERATIONS DE STOCK ");
        initComponents() ;
        this.setLocationRelativeTo(null) ;
        
        this.user = user ;
        this.role = role ;
        this.mf.setVisible(false) ;
        this.rgl.setVisible(false) ;
        this.et.setVisible(false) ;
        
        
        Date jour = new Date() ;
        this.jDateChooser1.setDate(jour);
        this.h1.setText("00:00") ;
        this.jDateChooser2.setDate(jour) ;
        this.h2.setText("23:59") ;
        
        
        
        // ---------------- 1è choix --------------
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
        
                  
        
                     
                     
                    
                      
                      this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 6) ;
        
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        if ("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        } else if("sortie".equalsIgnoreCase(status)) {
            setBackground(Color.RED);
            setForeground(Color.WHITE);
        } else if("non".equalsIgnoreCase(status)){
            
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
        } else if("sortie".equalsIgnoreCase(status)) {
            setBackground(Color.RED);
            setForeground(Color.WHITE);
        } else if("non".equalsIgnoreCase(status)){
           
            setBackground(Color.gray);
            setForeground(Color.WHITE);
            
            /*
            setBackground(Color.darkGray);
            setForeground(Color.WHITE);
            */
            
        }  
            
            
            /*
        if ("oui".equalsIgnoreCase(status)) {
             setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        } else {
            setBackground(Color.darkGray);
            setForeground(Color.WHITE);
          
        }   
              */
            
            
            
            
        if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
           
                  
          
        return this;
        
    }   
});


                
                   
                  
                   
                  
                  dtm1.setRowCount(0) ;
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
      
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
        
        
        String sql = null ;
        ResultSet rs = null ;      
        this.mtt_fact = 0 ;
        
        /*
        sql = "select entreprise from fournisseurs where id = "+this.fourni ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            this.fournisseur = rs.getString("entreprise") ;
        }
       
        this.fr.setText("NOM FOURNISSEUR : "+this.fournisseur);
        */
        
        sql = "select facture_fourni.id as id ,ref_saisie,comt,facture_fourni.datej as datej,mtt,op,etat,cb,description as entreprise from facture_fourni , departements where departements.id = facture_fourni.fourni and etat = 'sortie' order by facture_fourni.id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT" , "entreprise"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb") , rs.getString("entreprise")
                    
            }) ;
            
        }
        
        /*
        
        sql = "select facture_fourni.id as id ,ref_saisie,comt,datej,mtt,op,etat,cb from facture_fourni where etat = 'sortie' order by facture_fourni.id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT" , "entreprise"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb") , "PAS DE FOURNISSEUR"
                    
            }) ;
            
        }
        
        
        sql = "select mtt from facture_fourni where etat = 'oui' " ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            
            this.mtt_fact += rs.getLong("mtt") ;
            
        }
        
        
        this.mf.setText(this.nf3.format(this.mtt_fact));
        this.mtt_paye = 0 ;
        
        sql = "select * from payer_fourni order by id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
       //  "ID", "DATE HEURE", "MONTANT", "UTILISATEUR"
            
            this.mtt_paye += rs.getLong("mtt") ;
            
            
        }
       
        this.etat = (this.mtt_fact - this.mtt_paye) ;
        this.rgl.setText(this.nf3.format(this.mtt_paye)) ;
        this.et.setText(this.nf3.format(this.etat)) ;
        
        
        // ......
        
        
        */
        
        
        
        
            
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
    
       
       jLabel2.setVisible(false) ;
       ref1.setVisible(false) ;
       
       
       
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
        fr = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        ref = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
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
        rgl = new javax.swing.JTextField();
        et = new javax.swing.JTextField();
        ref1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setTitle("COMPTE FOURNISSEUR");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("OPERATIONS DE SORTIE");

        fr.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT", "SIBY ARS CB", "DEPARTEMENT"
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("LISTE FACTURE");

        ref.setText("REF FACTURE / MOTIF");
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

        rgl.setEditable(false);

        et.setEditable(false);

        ref1.setText("FOURNISSEUR");
        ref1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ref1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ref1FocusLost(evt);
            }
        });
        ref1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ref1ActionPerformed(evt);
            }
        });
        ref1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ref1KeyReleased(evt);
            }
        });

        jLabel2.setText("FOURNISSEUR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ref1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rgl, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mf, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(et, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fr, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(273, 273, 273))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(399, 399, 399)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ref)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)))
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(et, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fr, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ref1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
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

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        this.bonList.removeAll(this.bonList) ;
        this.cb = 0 ;
        
        this.cb = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 7).toString()) ;
        this.fr_rp = "Fournisseur : "+this.fournisseur ;
        this.rfs = "Ref saisie : "+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString() ;
        this.cmt = "Commentaire : "+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString() ;
        this.periode = "Date facture : "+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString() ;
        this.ope = "OP : "+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 5).toString() ;
        this.num = "Num : "+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString() ;
        this.total = "Total : "+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4).toString() ;
        
        
        
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
        
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void refFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_refFocusGained
        // TODO add your handling code here:
        
       this.ref.setText("") ;
        
    }//GEN-LAST:event_refFocusGained

    private void refFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_refFocusLost
        // TODO add your handling code here:
        
         String ref = this.ref.getText().trim()  ;
        
        if(ref.equalsIgnoreCase("")){
             this.ref.setText("REF FACTURE / MOTIF") ;
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
         
        
          
        sql = "select facture_fourni.id as id ,ref_saisie,comt,facture_fourni.datej as datej,mtt,op,etat,cb,description as entreprise from facture_fourni , departements where departements.id = facture_fourni.fourni and etat = 'sortie' order by facture_fourni.id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT" , "entreprise"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb") , rs.getString("entreprise")
                    
            }) ;
            
        }
        
        //
        
        /*
        sql = "select facture_fourni.id as id ,ref_saisie,comt,datej,mtt,op,etat,cb from facture_fourni where etat = 'sortie' order by facture_fourni.id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT" , "entreprise"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb") , "PAS DE FOURNISSEUR"
                    
            }) ;
            
        }
         */
        
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
         
        /*
          
         sql = "select facture_fourni.id as id ,ref_saisie,comt,datej,mtt,op,etat,cb,entreprise from facture_fourni , fournisseurs where fournisseurs.id = facture_fourni.fourni order by facture_fourni.id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT" , "entreprise"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb") , rs.getString("entreprise")
                    
            }) ;
            
        }
        
        */
        
          
        sql = "select facture_fourni.id as id ,ref_saisie,comt,facture_fourni.datej as datej,mtt,op,etat,cb,description as entreprise from facture_fourni , departements where ref_saisie like '%"+ref+"%' AND departements.id = facture_fourni.fourni and etat = 'sortie' order by facture_fourni.id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT"
            
             dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb") , rs.getString("entreprise")
                    
            }) ;
            
        }
    
        /*
        
         sql = "select facture_fourni.id as id ,ref_saisie,comt,datej,mtt,op,etat,cb from facture_fourni where ref_saisie like '%"+ref+"%' and etat = 'sortie' order by facture_fourni.id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT"
            
             dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb") , "PAS DE FOURNISSEUR"
                    
            }) ;
            
        }
        
         */
        
        
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
         
         /*
          
         sql = "select facture_fourni.id as id ,ref_saisie,comt,datej,mtt,op,etat,cb,entreprise from facture_fourni , fournisseurs where fournisseurs.id = facture_fourni.fourni order by facture_fourni.id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT" , "entreprise"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb") , rs.getString("entreprise")
                    
            }) ;
            
        }
        
        */
          
        sql = "select facture_fourni.id as id ,ref_saisie,comt,facture_fourni.datej as datej,mtt,op,etat,cb,description as entreprise from facture_fourni , departements where facture_fourni.datej BETWEEN '"+dte1+"' AND '"+dte2+"' AND departements.id = facture_fourni.fourni and etat = 'sortie' order by facture_fourni.id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb") , rs.getString("entreprise")
                    
            }) ;
            
        }
        
        /*
        
        sql = "select facture_fourni.id as id ,ref_saisie,comt,datej,mtt,op,etat,cb from facture_fourni where datej BETWEEN '"+dte1+"' AND '"+dte2+"' and etat = 'sortie' order by facture_fourni.id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb") , "PAS DE FOURNISSEUR"
                    
            }) ;
            
        }
        
         */
        
        
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

    private void ref1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ref1FocusGained
        // TODO add your handling code here:
        
          this.ref1.setText("") ;
          
    }//GEN-LAST:event_ref1FocusGained

    private void ref1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ref1FocusLost
        // TODO add your handling code here:
        
        String ref = this.ref1.getText().trim()  ;
        
        if(ref.equalsIgnoreCase("")){
             this.ref1.setText("FOURNISSEUR") ;
          }
        
    }//GEN-LAST:event_ref1FocusLost

    private void ref1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ref1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ref1ActionPerformed

    private void ref1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ref1KeyReleased
        // TODO add your handling code here:
        
        String ref = "" ;
               ref = this.ref1.getText().trim().replaceAll("'", "''") ;
               
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
         
        
          
        sql = "select facture_fourni.id as id ,ref_saisie,comt,datej,mtt,op,etat,cb,entreprise from facture_fourni , fournisseurs where fournisseurs.id = facture_fourni.fourni order by facture_fourni.id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT" , "entreprise"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb") , rs.getString("entreprise")
                    
            }) ;
            
        }
        
        
        sql = "select facture_fourni.id as id ,ref_saisie,comt,datej,mtt,op,etat,cb from facture_fourni where etat = 'sortie' order by facture_fourni.id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT" , "entreprise"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb") , "PAS DE FOURNISSEUR"
                    
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
         
        /*
          
         sql = "select facture_fourni.id as id ,ref_saisie,comt,datej,mtt,op,etat,cb,entreprise from facture_fourni , fournisseurs where fournisseurs.id = facture_fourni.fourni order by facture_fourni.id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT" , "entreprise"
            
            dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb") , rs.getString("entreprise")
                    
            }) ;
            
        }
        
        */
        
          
        sql = "select facture_fourni.id as id ,ref_saisie,comt,datej,mtt,op,etat,cb,entreprise, fournisseurs.id as ref from facture_fourni , fournisseurs where entreprise like '%"+ref+"%' AND facture_fourni.fourni = fournisseurs.id order by facture_fourni.id desc" ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
            // "ID", "REF.SAISIE", "COMMENTAIRE", "DATE HEURE", "MONTANT", "UTILISATEUR", "ETAT"
            
             dtm1.addRow(new Object[]{
                
              rs.getLong("id") , rs.getString("ref_saisie") , rs.getString("comt") , sdf.format(rs.getTimestamp("datej")) ,
              this.nf3.format(rs.getLong("mtt")) , rs.getString("op") , rs.getString("etat") , rs.getInt("cb") , rs.getString("entreprise")
                    
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
        
        
        
    }//GEN-LAST:event_ref1KeyReleased
        long id_p ;
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
            java.util.logging.Logger.getLogger(Compte_fourni1_Departement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compte_fourni1_Departement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compte_fourni1_Departement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compte_fourni1_Departement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compte_fourni1_Departement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField et;
    private javax.swing.JLabel fr;
    private javax.swing.JTextField h1;
    private javax.swing.JTextField h2;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField mf;
    private javax.swing.JTextField ref;
    private javax.swing.JTextField ref1;
    private javax.swing.JTextField rgl;
    // End of variables declaration//GEN-END:variables
}
