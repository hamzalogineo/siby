/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.CompteEx.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HAMZA
 */
public class TransfertOp extends javax.swing.JFrame{

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
       NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
    
    String login ;
    String role ;
    Integer nom_cpte = 0 ;
    String us ;
    
    public TransfertOp(){
        initComponents() ;
    }
    
     public TransfertOp(String login){
        initComponents();
        this.login = login ;
        
         Date jour = new Date() ;
        this.jDateChooser1.setDate(jour);
        this.h1.setText("00:00") ;
        this.jDateChooser2.setDate(jour) ;
        this.h2.setText("23:59") ;
        
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
      
     String query = null ;
     ResultSet resultat = null ;
     
     query = "select login from comptes_u " ;
     resultat = stmt.executeQuery(query) ;
     while(resultat.next()){
         this.util.addItem(new String(resultat.getString("login"))) ;
     }
     
      
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
     
     long ci = 0 ;
     long ei = 0 ;
     long di = 0 ;
     long cd = 0 ;
     long ed = 0 ;
     long dd = 0 ;
     
     if("SUPER ADMINISTRATEUR".equalsIgnoreCase(role)){
         // "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
         
         String sql4 = "select * from virement , comptes_u where "
                 + "dtec LIKE '%"+sdf.format(new Date())+"%' AND comptes_u.id = compte_nom ORDER BY virement.id DESC" ;
         ResultSet rs4 = stmt.executeQuery(sql4) ;
         while(rs4.next()){
             
// "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
             
             /*
             EURO
             DOLLAR
             FCFA ECO
             */
             
             
             // devise a : 
             
             if(this.nom_cpte == rs4.getInt("compte_nom") && "OUI".equalsIgnoreCase(rs4.getString("etat"))){
                 
                 /*
                 
                   EURO
                   DOLLAR
                   FRANC CFA
                 
                 */
                 
                 if("EURO".equalsIgnoreCase(rs4.getString("devise"))){
                 ed += rs4.getLong("mtt") ;
             }else if("DOLLAR".equalsIgnoreCase(rs4.getString("devise"))){
                 dd += rs4.getLong("mtt") ;
             }else if("FRANC CFA".equalsIgnoreCase(rs4.getString("devise"))){
                 cd += rs4.getLong("mtt") ;
             }
             
                 
             // "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
             
             dtm1.addRow(new Object[]{
       rs4.getInt("id"),rs4.getString("devise"),this.nf3.format(rs4.getLong("mtt")),"RECU",rs4.getString("motif"),rs4.getString("login") ,
       sdfT.format(rs4.getTimestamp("dtec")) ,
       rs4.getString("admin")
             
             });
             
             
         }else if(this.nom_cpte != rs4.getInt("compte_nom")){
                 
                  if("EURO".equalsIgnoreCase(rs4.getString("devise"))){
                 ei += rs4.getLong("mtt") ;
             }else if("DOLLAR".equalsIgnoreCase(rs4.getString("devise"))){
                 di += rs4.getLong("mtt") ;
             }else if("FRANC CFA".equalsIgnoreCase(rs4.getString("devise"))){
                 ci += rs4.getLong("mtt") ;
             }
                 
                 // "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
             
             dtm1.addRow(new Object[]{
       rs4.getInt("id"),rs4.getString("devise"),this.nf3.format(rs4.getLong("mtt")),"ENVOI",rs4.getString("motif"),rs4.getString("login") ,
       sdfT.format(rs4.getTimestamp("dtec")) ,
       rs4.getString("admin")
             
             });
             
             
                 
             }
             
         
         }
         
     }else{
         
         this.util.setSelectedItem(new String(this.login)) ;
         this.util.setEnabled(false) ;
         
         
         
        String sql4 = "select * from virement , comptes_u where "
                      + "virement.dtec LIKE '%"+sdf.format(new Date())+"%' AND ( virement.compte_nom = "+this.nom_cpte+" OR  virement.admin = '"+this.login+"' ) AND comptes_u.id = compte_nom ORDER BY virement.id desc" ;
         ResultSet rs4 = stmt.executeQuery(sql4) ;
         while(rs4.next()){
             
// "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
             
             /*
             EURO
             DOLLAR
             FCFA ECO
             */
             
             
             // devise a : 
             
             if(this.nom_cpte == rs4.getInt("compte_nom") && "OUI".equalsIgnoreCase(rs4.getString("etat"))){
                 
                 /*
                 
                   EURO
                   DOLLAR
                   FRANC CFA
                 
                 */
                 
                 if("EURO".equalsIgnoreCase(rs4.getString("devise"))){
                 ed += rs4.getLong("mtt") ;
             }else if("DOLLAR".equalsIgnoreCase(rs4.getString("devise"))){
                 dd += rs4.getLong("mtt") ;
             }else if("FRANC CFA".equalsIgnoreCase(rs4.getString("devise"))){
                 cd += rs4.getLong("mtt") ;
             }
             
                 
             // "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
             
             dtm1.addRow(new Object[]{
       rs4.getInt("id"),rs4.getString("devise"),this.nf3.format(rs4.getLong("mtt")),"RECU",rs4.getString("motif"),rs4.getString("login") ,
       sdfT.format(rs4.getTimestamp("dtec")) ,
       rs4.getString("admin")
             
             });
             
             
         }else if(this.nom_cpte != rs4.getInt("compte_nom")){
                 
                  if("EURO".equalsIgnoreCase(rs4.getString("devise"))){
                 ei += rs4.getLong("mtt") ;
             }else if("DOLLAR".equalsIgnoreCase(rs4.getString("devise"))){
                 di += rs4.getLong("mtt") ;
             }else if("FRANC CFA".equalsIgnoreCase(rs4.getString("devise"))){
                 ci += rs4.getLong("mtt") ;
             }
                 
                 // "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
             
             dtm1.addRow(new Object[]{
       rs4.getInt("id"),rs4.getString("devise"),this.nf3.format(rs4.getLong("mtt")),"ENVOI",rs4.getString("motif"),rs4.getString("login") ,
       sdfT.format(rs4.getTimestamp("dtec")) ,
       rs4.getString("admin")
             
             }) ;
             
             
                 
             }
             
         
         }
         
         
     }
     
     
     if(this.role.equalsIgnoreCase("ADMINII")){
         
         this.jButton1.setEnabled(false) ;
          
         
     }
     
     
      this.ci.setText(nf3.format(ci)) ; this.ei.setText(nf3.format(ei)) ; this.di.setText(nf3.format(di)) ;
      this.cd.setText(nf3.format(cd)) ; this.ed.setText(nf3.format(ed)) ; this.dd.setText(nf3.format(dd)) ;
            
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cfa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        euro = new javax.swing.JTextField();
        dollar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ci = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ei = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        di = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cd = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ed = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dd = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        h1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        h2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        util = new javax.swing.JComboBox();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ETAT DU COMPTE / OPERATION TRANSFERT :");

        cfa.setEditable(false);
        cfa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cfa.setText("1.000.000.000");

        jLabel2.setText("SOLDE  FCFA ");

        jLabel3.setText("SOLDE  EURO ");

        euro.setEditable(false);
        euro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        euro.setText("1.000.000.000");

        dollar.setEditable(false);
        dollar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dollar.setText("1.000.000.000");

        jLabel4.setText("SOLDE  DOLLAR");

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "BENEFICIAIRE", "DATE & HEURE", "EXPEDITEUR"
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
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        jPanel3.setBackground(new java.awt.Color(0, 153, 51));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("IMPRIMER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("AFFICHER");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(442, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("LES TOTAUX :"));

        jLabel5.setText("CFA ENVOI :");

        ci.setEditable(false);

        jLabel8.setText("EURO ENVOI :");

        ei.setEditable(false);

        jLabel9.setText("DOLLAR ENVOI :");

        di.setEditable(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel10.setText("CFA RECU :");

        cd.setEditable(false);

        jLabel11.setText("EURO RECU :");

        ed.setEditable(false);

        jLabel12.setText("DOLLAR RECU :");

        dd.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ci, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(di)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ei, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cd, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ed, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dd)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(di, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel13.setText("DU");

        jLabel14.setText("AU");

        jLabel6.setText("HEURE");

        jLabel7.setText("HEURE");

        util.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUT UTILISATEUR" }));
        util.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        util.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(cfa, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(177, 177, 177)
                                .addComponent(euro, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(164, 164, 164)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dollar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(util, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dollar)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cfa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(euro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(util, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(174, 174, 174))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Integer c1 = 0 ;
    String txt = null ;
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        String txt = this.util.getSelectedItem().toString().replaceAll("'", "''").trim() ;
               this.txt = txt ;
        if(txt.equalsIgnoreCase("TOUT UTILISATEUR")){
        
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
      
      /*
      
      
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
     
     
     String sql3 ;
      
       sql3 = "SELECT solde_cfa_eco,solde_euro,solde_dollar FROM compte_b WHERE nom_cpte = "+this.nom_cpte ;
      
       ResultSet rs3 = stmt.executeQuery(sql3) ;
      
      
     while(rs3.next()){
         
         this.cfa.setText(nf3.format(rs3.getLong("solde_cfa_eco"))) ;
         this.euro.setText(nf3.format(rs3.getLong("solde_euro"))) ;
         this.dollar.setText(nf3.format(rs3.getLong("solde_dollar"))) ;
     
     }
      
      */
      
     
  // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
     SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
     
     long ci = 0 ;
     long ei = 0 ;
     long di = 0 ;
     long cd = 0 ;
     long ed = 0 ;
     long dd = 0 ;
     
     if("SUPER ADMINISTRATEUR".equalsIgnoreCase(role)){
         // "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
         
         String sql4 = "select * from virement , comptes_u where "
                 + "dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND comptes_u.id = compte_nom ORDER BY virement.id desc" ;
         ResultSet rs4 = stmt.executeQuery(sql4) ;
         while(rs4.next()){
             
// "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
             
             /*
             EURO
             DOLLAR
             FCFA ECO
             */
             
             
             // devise a : 
             
             if(this.nom_cpte == rs4.getInt("compte_nom") && "OUI".equalsIgnoreCase(rs4.getString("etat"))){
                 
                 /*
                 
                   EURO
                   DOLLAR
                   FRANC CFA
                 
                 */
                 
                 if("EURO".equalsIgnoreCase(rs4.getString("devise"))){
                 ed += rs4.getLong("mtt") ;
             }else if("DOLLAR".equalsIgnoreCase(rs4.getString("devise"))){
                 dd += rs4.getLong("mtt") ;
             }else if("FRANC CFA".equalsIgnoreCase(rs4.getString("devise"))){
                 cd += rs4.getLong("mtt") ;
             }
             
                 
             // "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
             
             dtm1.addRow(new Object[]{
       rs4.getInt("id"),rs4.getString("devise"),this.nf3.format(rs4.getLong("mtt")),"RECU",rs4.getString("motif"),rs4.getString("login") ,
       sdfT.format(rs4.getTimestamp("dtec")) ,
       rs4.getString("admin")
             
             });
             
             
         }else if(this.nom_cpte != rs4.getInt("compte_nom")){
                 
                  if("EURO".equalsIgnoreCase(rs4.getString("devise"))){
                 ei += rs4.getLong("mtt") ;
             }else if("DOLLAR".equalsIgnoreCase(rs4.getString("devise"))){
                 di += rs4.getLong("mtt") ;
             }else if("FRANC CFA".equalsIgnoreCase(rs4.getString("devise"))){
                 ci += rs4.getLong("mtt") ;
             }
                 
                 // "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
             
             dtm1.addRow(new Object[]{
       rs4.getInt("id"),rs4.getString("devise"),this.nf3.format(rs4.getLong("mtt")),"ENVOI",rs4.getString("motif"),rs4.getString("login") ,
       sdfT.format(rs4.getTimestamp("dtec")) ,
       rs4.getString("admin")
             
             });
             
             
                 
             }
             
         
         }
         
     }
      
     
      this.ci.setText(nf3.format(ci)) ; this.ei.setText(nf3.format(ei)) ; this.di.setText(nf3.format(di)) ;
      this.cd.setText(nf3.format(cd)) ; this.ed.setText(nf3.format(ed)) ; this.dd.setText(nf3.format(dd)) ;
      
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
               
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
        
       
     
     // Fin configure :
     
        
        
        
      
        
        
         }catch(Exception e){
            JOptionPane.showMessageDialog(this,"CHOISIR LES DEUX DATES ET HEURES SVP !!! ");
         }
         
        }else{
            
            // debut :
            
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
      
       String sql2 ;
       Integer nom_cpte = 0 ;
      
       sql2 = "SELECT distinct id FROM comptes_u WHERE login = '"+txt+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
         
        nom_cpte = rs2.getInt("id") ;
        this.c1 = nom_cpte ;
     
     }
      
      
  // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
     SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
     
     long ci = 0 ;
     long ei = 0 ;
     long di = 0 ;
     long cd = 0 ;
     long ed = 0 ;
     long dd = 0 ;
     
     if("SUPER ADMINISTRATEUR".equalsIgnoreCase(role)){
         // "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
         
         String sql4 = "select * from virement , comptes_u where "
                 + "dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND ( virement.compte_nom = "+nom_cpte+" OR  virement.admin = '"+txt+"' )   AND comptes_u.id = compte_nom ORDER BY virement.id desc" ;
         ResultSet rs4 = stmt.executeQuery(sql4) ;
         while(rs4.next()){
             
// "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
             
             /*
             EURO
             DOLLAR
             FCFA ECO
             */
             
             
             // devise a : 
             
             if(nom_cpte == rs4.getInt("compte_nom") && "OUI".equalsIgnoreCase(rs4.getString("etat"))){
                 
                 /*
                 
                   EURO
                   DOLLAR
                   FRANC CFA
                 
                 */
                 
                 if("EURO".equalsIgnoreCase(rs4.getString("devise"))){
                 ed += rs4.getLong("mtt") ;
             }else if("DOLLAR".equalsIgnoreCase(rs4.getString("devise"))){
                 dd += rs4.getLong("mtt") ;
             }else if("FRANC CFA".equalsIgnoreCase(rs4.getString("devise"))){
                 cd += rs4.getLong("mtt") ;
             }
             
                 
             // "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
             
             dtm1.addRow(new Object[]{
       rs4.getInt("id"),rs4.getString("devise"),this.nf3.format(rs4.getLong("mtt")),"RECU",rs4.getString("motif"),rs4.getString("login") ,
       sdfT.format(rs4.getTimestamp("dtec")) ,
       rs4.getString("admin")
             
             });
             
             
         }else if(nom_cpte != rs4.getInt("compte_nom")){
                 
                  if("EURO".equalsIgnoreCase(rs4.getString("devise"))){
                 ei += rs4.getLong("mtt") ;
             }else if("DOLLAR".equalsIgnoreCase(rs4.getString("devise"))){
                 di += rs4.getLong("mtt") ;
             }else if("FRANC CFA".equalsIgnoreCase(rs4.getString("devise"))){
                 ci += rs4.getLong("mtt") ;
             }
                 
                 // "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
             
             dtm1.addRow(new Object[]{
       rs4.getInt("id"),rs4.getString("devise"),this.nf3.format(rs4.getLong("mtt")),"ENVOI",rs4.getString("motif"),rs4.getString("login") ,
       sdfT.format(rs4.getTimestamp("dtec")) ,
       rs4.getString("admin")
             
             });
             
             
                 
             }
             
         
         }
         
     }else{
        String sql4 = "select * from virement , comptes_u where "
                 + "dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND ( virement.compte_nom = "+nom_cpte+" OR  virement.admin = '"+txt+"' )  AND comptes_u.id = compte_nom ORDER BY virement.id desc" ;
         ResultSet rs4 = stmt.executeQuery(sql4) ;
         while(rs4.next()){
             
// "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
             
             /*
             EURO
             DOLLAR
             FCFA ECO
             */
             
             
             // devise a : 
             
             if(nom_cpte == rs4.getInt("compte_nom") && "OUI".equalsIgnoreCase(rs4.getString("etat"))){
                 
                 /*
                 
                   EURO
                   DOLLAR
                   FRANC CFA
                 
                 */
                 
                 if("EURO".equalsIgnoreCase(rs4.getString("devise"))){
                 ed += rs4.getLong("mtt") ;
             }else if("DOLLAR".equalsIgnoreCase(rs4.getString("devise"))){
                 dd += rs4.getLong("mtt") ;
             }else if("FRANC CFA".equalsIgnoreCase(rs4.getString("devise"))){
                 cd += rs4.getLong("mtt") ;
             }
             
                 
             // "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
             
             dtm1.addRow(new Object[]{
       rs4.getInt("id"),rs4.getString("devise"),this.nf3.format(rs4.getLong("mtt")),"RECU",rs4.getString("motif"),rs4.getString("login") ,
       sdfT.format(rs4.getTimestamp("dtec")) ,
       rs4.getString("admin")
             
             });
             
             
         }else if(nom_cpte != rs4.getInt("compte_nom")){
                 
                  if("EURO".equalsIgnoreCase(rs4.getString("devise"))){
                 ei += rs4.getLong("mtt") ;
             }else if("DOLLAR".equalsIgnoreCase(rs4.getString("devise"))){
                 di += rs4.getLong("mtt") ;
             }else if("FRANC CFA".equalsIgnoreCase(rs4.getString("devise"))){
                 ci += rs4.getLong("mtt") ;
             }
                 
                 // "N°", "MONNAIE", "MONTANT", "TYPE", "MOTIF", "DESTINATAIRE", "DATE & HEURE", "UTILISATEUR"
             
             dtm1.addRow(new Object[]{
       rs4.getInt("id"),rs4.getString("devise"),this.nf3.format(rs4.getLong("mtt")),"ENVOI",rs4.getString("motif"),rs4.getString("login") ,
       sdfT.format(rs4.getTimestamp("dtec")) ,
       rs4.getString("admin")
             
             });
             
             
                 
             }
             
         
         }
         
         
     }
     
     
      this.ci.setText(nf3.format(ci)) ; this.ei.setText(nf3.format(ei)) ; this.di.setText(nf3.format(di)) ;
      this.cd.setText(nf3.format(cd)) ; this.ed.setText(nf3.format(ed)) ; this.dd.setText(nf3.format(dd)) ;
      
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
               
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
        
       
     
     // Fin configure :
     
        
        
        
      
        
        
         }catch(Exception e){
            JOptionPane.showMessageDialog(this,"CHOISIR LES DEUX DATES ET HEURES SVP !!! ");
         }
         
            
            // fin :
            
            
            
            
        }
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try{
         
        this.jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
        
            // debut : 
        
          if("TOUT UTILISATEUR".equalsIgnoreCase(this.util.getSelectedItem().toString())){
              
              
             try{
                 
                      
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Transfert_compte.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql = "select * from virement , comptes_u \n " +
" where virement.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND comptes_u.id = virement.compte_nom ORDER BY virement.id DESC" ;
           
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql) ;
           jd.setQuery(newQuery) ;
           JasperReport jr = JasperCompileManager.compileReport(jd) ;
           HashMap para = new HashMap() ;
           
           para.put("periode", "PERIODE : DU "+dte1+" AU "+dte2) ;
           para.put("cfa", "FCFA : "+this.cfa.getText()) ;
           para.put("euro", "EURO : "+this.euro.getText()) ;
           para.put("usd", "DOLLAR USD: "+this.dollar.getText()) ;
           para.put("ci", "FCFA : "+this.ci.getText()) ;
           para.put("ei", "EURO : "+this.ei.getText()) ;
           para.put("di", "DOLLAR USD : "+this.di.getText()) ;
           para.put("cd", "FCFA : "+this.cd.getText()) ;
           para.put("ed", "EURO : "+this.ed.getText()) ;
           para.put("dd", "DOLLAR USD : "+this.dd.getText()) ;
           
           
           JasperPrint j = JasperFillManager.fillReport(jr, para, DriverManager.getConnection(DB_URL,USER,PASS)) ;
           JasperViewer.viewReport(j , false) ;
          
            //  si besoin :
           
               File f = new File("E:\\reports") ;
           
                if(f.exists()){
                  if(f.setWritable(true)){
                 
                    
                   OutputStream os = new FileOutputStream(f) ;
                                    
                    JasperExportManager.exportReportToPdfStream(j, os) ;
                  
                     os.flush();
                     os.close() ;
                   
                   JOptionPane.showMessageDialog(null, "Enregistrement terminer avec succes") ;
           
                
                }
              
              }

           
           //
           
           
           
       }catch(Exception e){
       
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       
       }
            
        
            
            }else if("TOUT UTILISATEUR".equalsIgnoreCase(this.util.getSelectedItem().toString()) == false){
                  
                    
             try{
                 
                      
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\Transfert_compte.jrxml")) ;
           JasperDesign jd = JRXmlLoader.load(in) ;
           
           String sql = "select * from virement , comptes_u where "
                 + "virement.dtec BETWEEN '"+dte1+"' AND '"+dte2+"' AND ( virement.compte_nom = "+this.c1+" OR  virement.admin = '"+this.txt+"' )   AND comptes_u.id = compte_nom ORDER BY virement.id DESC" ;
           
           JRDesignQuery newQuery = new JRDesignQuery() ;
           newQuery.setText(sql) ;
           jd.setQuery(newQuery) ;
           JasperReport jr = JasperCompileManager.compileReport(jd) ;
           HashMap para = new HashMap() ;
           
           para.put("periode", "PERIODE : DU "+dte1+" AU "+dte2) ;
           para.put("cfa", "FCFA : "+this.cfa.getText()) ;
           para.put("euro", "EURO : "+this.euro.getText()) ;
           para.put("usd", "DOLLAR USD: "+this.dollar.getText()) ;
           para.put("ci", "FCFA : "+this.ci.getText()) ;
           para.put("ei", "EURO : "+this.ei.getText()) ;
           para.put("di", "DOLLAR USD : "+this.di.getText()) ;
           para.put("cd", "FCFA : "+this.cd.getText()) ;
           para.put("ed", "EURO : "+this.ed.getText()) ;
           para.put("dd", "DOLLAR USD : "+this.dd.getText()) ;
           
           
           JasperPrint j = JasperFillManager.fillReport(jr, para, DriverManager.getConnection(DB_URL,USER,PASS)) ;
           JasperViewer.viewReport(j , false) ;
          
            //  si besoin :
           
               File f = new File("E:\\reports") ;
           
                if(f.exists()){
                  if(f.setWritable(true)){
                 
                    
                   OutputStream os = new FileOutputStream(f) ;
                                    
                    JasperExportManager.exportReportToPdfStream(j, os) ;
                  
                     os.flush();
                     os.close() ;
                   
                   JOptionPane.showMessageDialog(null, "Enregistrement terminer avec succes") ;
           
                
                }
              
              }

           
           //
           
           
           
       }catch(Exception e){
       
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       
       }
            
                  
                 }
        
         this.jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "EFFECTUER LA RECHERCHER AVANT L'IMPRESSION");
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void utilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utilActionPerformed
        // TODO add your handling code here:
        
        this.us = null ;
        this.us = this.util.getSelectedItem().toString().replaceAll("'", "''") ;
        
    }//GEN-LAST:event_utilActionPerformed

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
            java.util.logging.Logger.getLogger(TransfertOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransfertOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransfertOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransfertOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransfertOp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cd;
    private javax.swing.JTextField cfa;
    private javax.swing.JTextField ci;
    private javax.swing.JTextField dd;
    private javax.swing.JTextField di;
    private javax.swing.JTextField dollar;
    private javax.swing.JTextField ed;
    private javax.swing.JTextField ei;
    private javax.swing.JTextField euro;
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox util;
    // End of variables declaration//GEN-END:variables
}
