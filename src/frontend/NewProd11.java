/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import config.Reporting.ProdmpList;
import entity.Prodmp;
import entity.ProduitsF;
import static frontend.CumulProdPfObtenu.JDBC_DRIVER;
import static frontend.ProductionT.JDBC_DRIVER;
import static frontend.ProduitFini.JDBC_DRIVER;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HAMZA
 */
public class NewProd11 extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
    String login = "" ;
    String role = "" ;
    String rapport = "" ;
    
    String nom = "" ;
    int n = 0 ;
    String groupe = "" ;
    String dtec = "" ;
    long stock1 = 0 ;
    String article = "" ;
    long qt = 0 ;
    long pu = 0 ;
    long montant = 0 ;
    String f = "" ;
    String sf = "" ;
    long idpro = 0 ;
    long pa = 0 ;
    long profil = 0 ;
    long mu = 0 ;
    long newStock = 0 ;
    Integer idProduct = 0 ;
    private long ida ;
    
    Integer verify_1 = 0 ;
    Integer verify_2 = 0 ;
    Integer etat = 0 ;
    private Integer type = 0 ;
    
    ArrayList<ProdmpList> list_mp_newOp = new ArrayList<ProdmpList>() ;
    
    private Integer vy = 0 ;
    String stock_1 = new String("") ;
    
    Integer cf = 1 ;
    
    public NewProd11(){
        this.setTitle("Nouvelle production") ;
        initComponents() ;
        
        this.setLocationRelativeTo(null) ;
        
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
        
     //   -------------------------------------------------------------------
        
        
                   // ---------------- 1è choix --------------
            this.jTable4.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable4.getTableHeader().setOpaque(false); 
            this.jTable4.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable4.getTableHeader().setForeground(Color.white) ;
        
              this.jTable4.setRowHeight(25) ;
              
        
             

                  for (int i = 0; i < this.jTable4.getModel().getColumnCount(); i++) {
                    this.jTable4.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
        
                  
                  
                  
        
        
    }
    
    
    
    public NewProd11(String login, String role) {
        this.setTitle("Nouvelle production");
        initComponents() ;
        
        this.login = login ;
        this.role = role ;
        
        this.setLocationRelativeTo(null) ;
        
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
        
        
                   // ---------------- 1è choix --------------
                     
            this.jTable4.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable4.getTableHeader().setOpaque(false); 
            this.jTable4.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable4.getTableHeader().setForeground(Color.white) ;
        
              this.jTable4.setRowHeight(25) ;
              
        
             

                  for (int i = 0; i < this.jTable4.getModel().getColumnCount(); i++) {
                    this.jTable4.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
                   DefaultTableModel dtm4 = (DefaultTableModel) this.jTable4.getModel() ;
                     dtm4.addRow(new Object[]{1 , "xxxxxxxxxxxxxxxxxxxx","100.000","150.000","150.000"}) ;
        
     //   -------------------------------------------------------------------
        
        
                  if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR") || this.role.equalsIgnoreCase("ADMINISTRATEUR")){
                      
                      
                      
                  }else{
                      
                      this.vprod.setEnabled(false)  ;
                   // this.anprod.setEnabled(false) ;
                      this.print.setEnabled(false) ;
                      this.dep.setVisible(false) ;
                      this.rec.setVisible(false) ;
                      this.profit.setVisible(false) ;
                      this.d1.setVisible(false);
                      this.r1.setVisible(false);
                      this.p1.setVisible(false);
                      
                      
                  }
                  
                  
        
                  
                  
                  
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
      
        
      String sql ;
      
       sql= "SELECT * FROM activite_t ORDER BY description" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
      this.activity.addItem(rs.getString("description")) ;  
     
     }
      
     
       String sql2 ;
      
       sql2 = "SELECT * FROM magasins ORDER BY magasin" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
          this.mag.addItem(rs2.getString("magasin"))  ;
         
       
     }
     
     
      String sql3 ;
      // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
       sql3 = "SELECT * FROM productaire ORDER BY producteur ASC" ;
       ResultSet rs3 = stmt.executeQuery(sql3) ;
    
       while(rs3.next()){
        
        
      this.product.addItem(rs3.getString("productaire.producteur"))  ;
    
         
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
                  
                  
                  
               dtm1.setRowCount(0) ;
               dtm2.setRowCount(0) ;
               dtm3.setRowCount(0) ; 
               dtm4.setRowCount(0) ;
                  
        
    }
    
    
    //  debut en cours et fini 
    
    
    
           public NewProd11(String nom , Integer n ,String login, String role , Long ida) {
        this.setTitle("Production en cours ");
        initComponents() ;
        
        this.an1.setEnabled(false) ;
        this.an2.setEnabled(false) ;
        this.mag.setEnabled(false) ;
        
        
        this.nom = nom ;
        this.n = n ;
        this.login = login ;
        this.role = role ;
        this.ida = ida ;
        
        
        this.setLocationRelativeTo(null) ;
        
        this.activity.setVisible(false);
        
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
        
        
                   // ---------------- 1è choix --------------
                     
            this.jTable4.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable4.getTableHeader().setOpaque(false); 
            this.jTable4.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable4.getTableHeader().setForeground(Color.white) ;
        
              this.jTable4.setRowHeight(25) ;
              
        
             

                  for (int i = 0; i < this.jTable4.getModel().getColumnCount(); i++) {
                    this.jTable4.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
                   DefaultTableModel dtm4 = (DefaultTableModel) this.jTable4.getModel() ;
                     dtm4.addRow(new Object[]{1 , "xxxxxxxxxxxxxxxxxxxx","100.000","150.000","150.000"}) ;
        
     //   -------------------------------------------------------------------
        
        
                  if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR")){ //  || this.role.equalsIgnoreCase("ADMINISTRATEUR")
                      
                       /*
                      
                               
                      
                  }else if(this.role.equalsIgnoreCase("ADMINII")){
                      
                      this.v1.setEnabled(false) ;
                      this.v2.setEnabled(false);
                      this.print.setEnabled(false) ;
                      
                      this.p1.setVisible(false) ;
                      this.profit.setVisible(false) ;
                      
                      */
                      
                  }else{
                      
                      this.vprod.setEnabled(false)  ;
                   // this.anprod.setEnabled(false) ;
                      this.print.setEnabled(false) ;
                      this.dep.setVisible(false) ;
                      this.rec.setVisible(false) ;
                      this.profit.setVisible(false) ;
                      this.d1.setVisible(false);
                      this.r1.setVisible(false);
                      this.p1.setVisible(false);
                     // this.jPanel5.setVisible(false);
                      this.qt1.setEnabled(false);
                       this.nop1.setEnabled(false);
                        this.an1.setEnabled(false);
                         this.v1.setEnabled(false);
                          this.mag.setEnabled(false);
                           this.product.setEnabled(false);
                            this.qt2.setEnabled(false);
                             this.nop2.setEnabled(false);
                              this.an2.setEnabled(false);
                               this.v2.setEnabled(false);
                      
                  }
                  
                  
                  
                  this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 3) ;
        
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        if ("oui".equalsIgnoreCase(status)) {
            setBackground(Color.darkGray);
            setForeground(Color.WHITE);
        } else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
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

        String status = (String) table.getModel().getValueAt(row, 3) ;
        
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        if ("oui".equalsIgnoreCase(status)) {
            setBackground(Color.darkGray);
            setForeground(Color.WHITE);
        } else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
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
                  dtm4.setRowCount(0) ;
                   
                  
                  
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
        
        String sql ;
      
       sql= "SELECT * FROM prod WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
    
      this.nom1.setText("Production : "+this.nom);
      this.n1.setText("N° : "+this.n);
      this.dte.setText("DATE : "+sdf.format(rs.getTimestamp("dtec")));
      this.op.setText("Operateur : "+this.login);
      this.stat1.setText("STATUT : "+" OUVERTE");
     
     }
     
     String sql0 ;
      
       sql0 = "SELECT count(*) FROM prod WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND status = 'ouverte'" ;
      
       ResultSet rs0 = stmt.executeQuery(sql0) ;
      
      
     while(rs0.next()){
    
     
      this.nbc.setText("NOMBRE EN COURS : "+rs0.getInt(1)) ;
     
     }
     
     
     
     ArrayList<String> prendre1 = new ArrayList<String>() ;
     
       String sql8 ;
      // "Description", "QTE", "P.U", "Montant"
       
       sql8 = "SELECT article FROM prodmp WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" GROUP BY article ORDER BY article asc" ;
      
       ResultSet rs8 = stmt.executeQuery(sql8);
      
      
     while(rs8.next()){
        // "Description", "P.A", "P.V"
          
       prendre1.add(rs8.getString("article")) ;
        
     }
                     
    
     ArrayList<PmpL> listemp = new ArrayList<>() ;
     
       String sql2 ;
      
       sql2 = "SELECT * FROM pmp WHERE nomp = '"+this.nom.replaceAll("'", "''")+"' GROUP BY article ORDER BY article ASC" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        // "Description", "P.A", "P.V"
         
         PmpL mp = new PmpL() ;
         mp.setArticle(rs2.getString("article"));
         mp.setPa(rs2.getLong("pa"));
         mp.setPv(rs2.getLong("pv"));
         
       listemp.add(mp) ;
       
       
     }
     
     
     
     
          for(int i = 0 ; i < listemp.size() ; i++){
              
               
         
         if(prendre1.contains(new String(listemp.get(i).getArticle()))){
         
       dtm1.addRow(new Object[]{
           
       listemp.get(i).getArticle() , listemp.get(i).getPa() , listemp.get(i).getPv() , "oui"
       
       }) ;
       
         }else{
             
               dtm1.addRow(new Object[]{
           
     listemp.get(i).getArticle() , listemp.get(i).getPa() , listemp.get(i).getPv() , "non"
       
       }) ;
             
         }
             
          }     
         
         
     
     listemp.removeAll(listemp) ;
     prendre1.removeAll(prendre1) ;
     
     
      
    
          // code patient 
      
     
    
      String sql3 ;
      
       sql3 = "SELECT * FROM ppf WHERE nomp = '"+this.nom.replaceAll("'", "''")+"' GROUP BY article ORDER BY article" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3);
      
      
     while(rs3.next()){
        // "Description", "P.A", "P.V"
         
         PmpL mp = new PmpL() ;
         mp.setArticle(rs3.getString("article"));
         mp.setPa(rs3.getLong("pa"));
         mp.setPv(rs3.getLong("pu"));
         
       listemp.add(mp) ;
         
       
     }
     
     
     String sql18 ;
      // "Description", "QTE", "P.U", "Montant"
       
       sql18 = "SELECT article FROM prodpf WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" GROUP BY article ORDER BY article asc" ;
      
       ResultSet rs18 = stmt.executeQuery(sql18);
      
      
     while(rs18.next()){
        // "Description", "P.A", "P.V"
          
       prendre1.add(rs18.getString("article")) ;
        
     }
     
     
      for(int i = 0 ; i < listemp.size() ; i++){
              
               
         
         if(prendre1.contains(new String(listemp.get(i).getArticle()))){
         
       dtm2.addRow(new Object[]{
           
       listemp.get(i).getArticle() , listemp.get(i).getPa() , listemp.get(i).getPv() , "oui"
       
       }) ;
       
         }else{
             
               dtm2.addRow(new Object[]{
           
     listemp.get(i).getArticle() , listemp.get(i).getPa() , listemp.get(i).getPv() , "non"
       
       }) ;
             
         }
             
          }     
         
         
     listemp.removeAll(listemp) ;
     prendre1.removeAll(prendre1) ;
     
     
     
     
        
      
    
                     
        
     
        long dep = 0 ;
     
      String sql4 ;
      // "Description", "QTE", "P.U", "Montant"
       sql4 = "SELECT article , sum(qte) , pu , sum(montant) FROM prodmp WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" GROUP BY article ORDER BY article asc" ;
      
       ResultSet rs4 = stmt.executeQuery(sql4);
      
      
     while(rs4.next()){
        // "Description", "P.A", "P.V"
         
         if(rs4.getLong("sum(qte)") > 0){
         
       dtm3.addRow(new Object[]{
           
       rs4.getString("article") , rs4.getLong("sum(qte)") , rs4.getLong("pu") , rs4.getLong("sum(montant)")
       
       });
        
       dep += rs4.getLong("sum(montant)") ; 
         
         }else{
             // do no thing :
         }
       
     }
     
     this.dep.setText(String.valueOf(dep)) ;
     
     
    
         
        long rec = 0 ;
     
      String sql5 ;
      // "Description", "QTE", "P.U", "Montant"
       sql5 = "SELECT article , sum(qte) , pu , sum(montant) FROM prodpf WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" GROUP BY article ORDER BY article asc" ;
      
       ResultSet rs5 = stmt.executeQuery(sql5);
      
      
     while(rs5.next()){
        // "Description", "P.A", "P.V"
         if(rs5.getLong("sum(qte)") > 0){
       dtm4.addRow(new Object[]{
           
       rs5.getString("article") , rs5.getLong("sum(qte)") , rs5.getLong("pu") , rs5.getLong("sum(montant)")
       
       }) ;
        
       rec += rs5.getLong("sum(montant)") ; 
         
         }else{
             // do nothing :
             
         }
       
     }
     
     this.rec.setText(String.valueOf(rec)) ; 
     this.profit.setText(String.valueOf((Integer.parseInt(this.rec.getText()) - Integer.parseInt(this.dep.getText()))));
     
     
      
    
     
     
      
      
     
      
     
       String sql22 ;
      
       sql22 = "SELECT magasin FROM magasins where etat = 'oui' limit 1" ;
      
       ResultSet rs22 = stmt.executeQuery(sql22) ;
      
      
     while(rs22.next()){
        
          this.stock_1 = rs22.getString("magasin") ;
          this.mag.addItem(rs22.getString("magasin"))  ;
         
       
     }
     
     
      String sql33 ;
      // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
       sql33 = "SELECT * FROM productaire WHERE NOT type = 'oui' ORDER BY producteur ASC" ;
       ResultSet rs33 = stmt.executeQuery(sql33) ;
    
       while(rs33.next()){
        
        
      this.product.addItem(rs33.getString("productaire.producteur"))  ;
    
         
     }
    
        
    
        String sql44 ;
      
       sql44 = "SELECT etat FROM config " ;
      
       ResultSet rs44 = stmt.executeQuery(sql44) ;
      
      
     while(rs44.next()){
    
      this.etat = rs44.getInt("etat") ;  
     
     }
     
     
   sql = "select etat from conf_stock limit 1" ;
   rs = stmt.executeQuery(sql) ;
   while(rs.next()){
       this.cf = rs.getInt("etat") ;
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
                  
       
                  
                  /*
               
                  */
       
       
       
    }
    
    
    
    
    
    
    // fin en cours et fin 
    

    public void setLogin(String login) {
        this.login = login;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public void populate(){
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
        dtm.addRow(new Object[]{1,1,1});
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
        activity = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        print = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        dep = new javax.swing.JTextField();
        d1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        r1 = new javax.swing.JLabel();
        rec = new javax.swing.JTextField();
        p1 = new javax.swing.JLabel();
        profit = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        id3 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        id4 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        desc = new javax.swing.JTextField();
        stock = new javax.swing.JTextField();
        id1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        id2 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        nom1 = new javax.swing.JLabel();
        n1 = new javax.swing.JLabel();
        dte = new javax.swing.JLabel();
        op = new javax.swing.JLabel();
        stat1 = new javax.swing.JLabel();
        nbc = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nop1 = new javax.swing.JButton();
        an1 = new javax.swing.JButton();
        v1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        mag = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        nop2 = new javax.swing.JButton();
        an2 = new javax.swing.JButton();
        v2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        vprod = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        product = new javax.swing.JComboBox();
        qt1 = new javax.swing.JTextField();
        qt2 = new javax.swing.JTextField();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PRODUCTION DES ARTICLES DE L'ENTREPRISE :");

        activity.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        activity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR UNE PRODUCTION" }));
        activity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        activity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                activityMouseReleased(evt);
            }
        });
        activity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activityActionPerformed(evt);
            }
        });
        activity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                activityKeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nouvelle Operation pour validation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "QTE", "P.U", "Montant"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jTable3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable3KeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(190);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTable3.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        print.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        print.setText("IMPRIMER");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "QTE", "P.U", "Montant"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable4.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable4.getTableHeader().setReorderingAllowed(false);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable4MouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setPreferredWidth(190);
            jTable4.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTable4.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTable4.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        dep.setEditable(false);
        dep.setText("0");

        d1.setText("Depenses :");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("LES PRODUITS OBTENUS");

        r1.setText("Recettes :");

        rec.setEditable(false);
        rec.setText("0");

        p1.setText("Profit :");

        profit.setEditable(false);
        profit.setText("0");
        profit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profitActionPerformed(evt);
            }
        });

        jLabel24.setText("------------------------------------------------------------------------------------------------------------------");

        id3.setEditable(false);
        id3.setText("0");

        jLabel28.setText("QTE");

        jLabel29.setText("QTE");

        id4.setEditable(false);
        id4.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168)
                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(r1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rec, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profit)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(d1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel29)
                    .addComponent(id4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r1)
                    .addComponent(p1)
                    .addComponent(profit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Demarrage Production", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        desc.setText("Description");
        desc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                descFocusLost(evt);
            }
        });
        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descKeyPressed(evt);
            }
        });

        stock.setEditable(false);
        stock.setText("0");

        id1.setEditable(false);
        id1.setText("0");

        jLabel15.setText("stock dispo");

        jLabel16.setText("Ref.Pro");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "P.A", "P.V", "Pris"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(190);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(1);
        }

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description", "P.A", "P.V", "Pris"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(190);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(16);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(16);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(1);
        }

        jLabel17.setText("Matieres primaires :");

        jLabel18.setText("Produits fini :");

        jLabel25.setText("-----------------------------------------------------------------------------------------------------------------");

        id2.setEditable(false);
        id2.setText("0");

        jLabel27.setText("Ref.prod");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(id1)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel16)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFO PRODUCTION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        nom1.setText("Production :");

        n1.setText("N° :");

        dte.setText("DATE :");

        op.setText("Operateur :");

        stat1.setText("STATUT :");

        nbc.setText("NOMBRE EN COURS :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(n1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(op, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(stat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nbc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(nom1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(n1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(op)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stat1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nbc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("MATIERES PRIMAIRES");

        jLabel9.setText("QUANTITE :");

        nop1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nop1.setText("Nouv.Operation");
        nop1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nop1ActionPerformed(evt);
            }
        });

        an1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        an1.setText("ANNULER");
        an1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        an1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                an1ActionPerformed(evt);
            }
        });

        v1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        v1.setText("VALIDER");
        v1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        v1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v1ActionPerformed(evt);
            }
        });

        jLabel10.setText("------------------------------------------------------------------------------");

        jLabel11.setText("PRODUITS OBTENUS :");

        mag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR UN MAGASIN" }));
        mag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("qte recu :");

        nop2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nop2.setText("Nouv.Operation");
        nop2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nop2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nop2ActionPerformed(evt);
            }
        });

        an2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        an2.setText("ANNULER");
        an2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        an2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                an2ActionPerformed(evt);
            }
        });

        v2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        v2.setText("VALIDER");
        v2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        v2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v2ActionPerformed(evt);
            }
        });

        jLabel13.setText("-------------------------------------------------------------------------------");

        vprod.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        vprod.setText("VALIDER PROD");
        vprod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vprodActionPerformed(evt);
            }
        });

        jLabel14.setText("OPERATION ADMIN :");

        jLabel26.setText("Bon auto.unique");

        jLabel30.setText("Bon auto.unique");

        product.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR PRODUCTEUR" }));
        product.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(nop1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(an1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(v1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(qt1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(v2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(an2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(nop2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(qt2, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(vprod, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGap(88, 88, 88)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mag, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(product, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(qt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nop1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(an1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(v1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(qt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nop2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(an2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(v2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(vprod, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(activity, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(activity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void descFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descFocusGained
        // TODO add your handling code here:
       String desc = "" ;
       desc = this.desc.getText() ;
       if("Description".equals(desc)){
           this.desc.setText("") ;
       }
       
    }//GEN-LAST:event_descFocusGained

    private void descFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descFocusLost
        // TODO add your handling code here:
        
           String desc = "" ;
       desc = this.desc.getText().trim() ;
       if("".equals(desc)){
           this.desc.setText("Description") ;
       }
        
        
    }//GEN-LAST:event_descFocusLost

    private void profitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profitActionPerformed

    private void v1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v1ActionPerformed
        // TODO add your handling code here :
        
        
        if(this.cf == 1){
            
            //
            
               
     if(this.vy == 1 && this.list_mp_newOp.size() > 0){
        
        DateFormat datef = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
             Date date = new Date() ;
             
        String dc = datef.format(date) ;
        
        this.v1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
                          SessionFactory sf=new Configuration().configure().buildSessionFactory();
                          Session s=sf.openSession();

    List lib = s.createSQLQuery("SELECT * FROM prod WHERE nom ='"+this.nom+"' AND n = "+this.n).list();
              
            
               // verification if qery is ok
            
            if(lib.size() == 1){
                
                
                  Connection conn = null ;
                  Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

       // STEP 4: Execute a query
      //  System.out.println("Creating statement...") ;
          stmt = conn.createStatement() ;
      
   //     je crai ma requete
      
      
          int cpt = 0 ;
          int nbon = 0 ;
          int cb = 0 ;
          
          
          if(cpt == 0){
          String sql ;
          
      
       sql= "SELECT count(*) FROM histobon WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+"" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
        nbon = (rs.getInt(1) + 1) ;
        Random rx = new Random() ;
        cb = rx.nextInt() ;
        if(cb < 0){
            cb = Math.abs(cb) ;
        }
               cpt = 1 ;
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
     
  stmt.executeUpdate("INSERT INTO histobon(nom,n,nbon,code_barre,op,dtec,total,ida) VALUES('"+this.nom+"' , "+this.n+" , "+nbon+" , "+cb+" , '"+this.login+"' , '"+dc+"' , "+0+" , "+this.ida+" )") ;                     
      
          }     
            
               // verification if qery is ok
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
          String jour = sdf.format(new Date()) ;
          
             
                for(int i = 0 ; i < this.list_mp_newOp.size() ; i++){
                    
         stmt.executeUpdate("INSERT INTO prodmp(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu) VALUES('"+this.list_mp_newOp.get(i).getNom()+"' , "+this.list_mp_newOp.get(i).getN()+" , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getQte()+" , "+this.list_mp_newOp.get(i).getPu()+" , "+this.list_mp_newOp.get(i).getMontant()+" , '"+dc+"' , '"+this.list_mp_newOp.get(i).getAdmin().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getF().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getSf().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getIdpro()+" , "+this.list_mp_newOp.get(i).getPa()+" , "+0+" , "+0+")") ;                 
         stmt.executeUpdate("UPDATE stock1 SET  stock ="+this.list_mp_newOp.get(i).getStock()+" WHERE desi ='"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"'") ;
      // stmt.executeUpdate("UPDATE stock_pl SET  stock_dispo = "+this.list_mp_newOp.get(i).getStock()+" , dtec = '"+jour+"' WHERE description ='"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"'") ;
         stmt.executeUpdate("INSERT INTO detailbon(nbon,code_barre,desi,qte,pu,mtt) VALUES("+nbon+" , "+cb+" , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getQte()+" , "+this.list_mp_newOp.get(i).getPu()+" , "+this.list_mp_newOp.get(i).getMontant()+")") ;                     
         stmt.executeUpdate("INSERT INTO cumul_v_mp(idpro,qte,dtec,type) values("+this.list_mp_newOp.get(i).getIdpro()+" , "+this.list_mp_newOp.get(i).getQte()+" , '"+dc+"' , "+this.list_mp_newOp.get(i).getType()+" )") ;   
          // detail stock2 : 
         
  stmt.executeUpdate("insert into stock2(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,admin,datec,type,idpro,op_) values('"
 +this.list_mp_newOp.get(i).getF().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getSf().replaceAll("'", "''")+"' , '"
 +" "+"' , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getPa()+" , "
 +this.list_mp_newOp.get(i).getPu()+" , "+0+" , "+this.list_mp_newOp.get(i).getQte()+" , "
 +this.list_mp_newOp.get(i).getStock()+" , '"+"SIBY CENTER"+"' , '"
 +this.stock_1.replaceAll("'", "''")+"' , '"+this.login.replaceAll("'", "''")+"' , '"
 +jour+"' , 'matiere' , "+this.list_mp_newOp.get(i).getIdpro()+" , "+cb+")") ;
         
         // end :
                }
                
                DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                dtm3.setRowCount(0);
                
                 long dep = 0 ;
     
      String sql4 ;
      // "Description", "QTE", "P.U", "Montant"
       sql4 = "SELECT article , sum(qte) , pu , sum(montant) FROM prodmp WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" GROUP BY article ORDER BY article asc" ;
      
       ResultSet rs4 = stmt.executeQuery(sql4);
      
      
     while(rs4.next()){
        // "Description", "P.A", "P.V"
         
         if(rs4.getLong("sum(qte)") > 0){
         
       dtm3.addRow(new Object[]{
           
       rs4.getString("article") , rs4.getLong("sum(qte)") , rs4.getLong("pu") , rs4.getLong("sum(montant)")
       
       });
        
       dep += rs4.getLong("sum(montant)") ; 
         
         }else{
             // do no thing :
         }
       
     }
     
     this.dep.setText(String.valueOf(dep)) ;
     
     
                
                
                
                try{
                   
                    /*
                 
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\bonHamza.jrxml")) ;
            //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\bonCommande.jrxml")) ;
            
        //    long total = 0 ;
            
            List mlist;
            mlist = new ArrayList<>() ;
              for(int i = 0 ; i < this.list_mp_newOp.size() ; i++){
                HashMap<String, Object> m = new HashMap<>(); 
                m.put("desi", this.list_mp_newOp.get(i).getArticle());
                m.put("qte", this.list_mp_newOp.get(i).getQte());
                m.put("pu", this.list_mp_newOp.get(i).getPu());
                m.put("mt", this.list_mp_newOp.get(i).getMontant());
                // total += resultat.getInt("montant");
              //   m.put("total", total);
                
                mlist.add(m);
            }
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("data", jrbean);
            para.put("cb", cb);
            para.put("nom", this.nom);
            para.put("n", this.n);
            para.put("op", this.login) ;
            para.put("nbon", nbon) ;
            para.put("ident", "Matière Pre.") ;
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
            JasperViewer.viewReport(print, false);
            JasperPrintManager.printReport(print, false) ;
            
            
            */
            
       }catch(Exception e){
       
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       
       }
       
        
        
                
              DateFormat datef_ = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
              Date date_ = new Date() ;
             
      String dtf = datef_.format(date_) ;
      
      long profil = 0 ;
      profil = ( Long.parseLong(this.rec.getText().trim()) - Long.parseLong(this.dep.getText().trim()) );
          
      if(stmt.executeUpdate("UPDATE prod SET status = 'fermer' , dtef ='"+dtf+"' , dep = "+Long.parseLong(this.dep.getText().trim())+" , rec = "+Long.parseLong(this.rec.getText().trim())+" , profil = "+profil+" WHERE nom ='"+this.nom+"' AND n = "+this.n) == 1){
           
           this.vprod.setEnabled(false) ;
           
          JOptionPane.showMessageDialog(this, "la production a été cloturée avec succès");
          
      }else{
          JOptionPane.showMessageDialog(this, "Demarrer la production ensuite fermer la à la fin merci !!!");
      }
                
         
             
             this.jTable1.clearSelection();
             this.jTable2.clearSelection();
             this.jTable4.clearSelection();
             this.list_mp_newOp.removeAll(this.list_mp_newOp) ;
             this.vy = 0 ;
             this.id1.setText("0");
             this.id2.setText("0");
             this.id3.setText("0");
             this.id4.setText("0");
             this.stock.setText("0");
        //   this.dep.setText("0");
   //        this.rec.setText("0");
     //      this.profit.setText("0");
             this.verify_1 = 0 ;
             this.an1.setEnabled(false);
             this.v1.setEnabled(false) ;
 
                  
 
                 
                 
            
                 
        
             
          
              
         
      
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
     
        
            
            
            }else{
                
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
      
      
          int cpt = 0 ;
          int nbon = 0 ;
          int cb = 0 ;
          
          
          if(cpt == 0){
              
              stmt.executeUpdate("INSERT INTO prod(nom,n,status,dtec,admin,dep,rec,profil,nb,grouper,etat) VALUES('"+this.nom+"' , "+this.n+" , 'ouverte' , '"+dc+"' , '"+this.login.replaceAll("'", "''")+"' , 0 , 0 , 0 , "+0+" , '"+this.groupe.replaceAll("'", "''")+"' , 'NORMAL' )") ;
              
          String sql ;
          
      
       sql= "SELECT count(*) FROM histobon WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+"" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
        nbon = (rs.getInt(1) + 1) ;
        Random rx = new Random() ;
        cb = rx.nextInt() ;
        if(cb < 0){
            cb = Math.abs(cb) ;
        }
               cpt = 1 ;
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
     
  stmt.executeUpdate("INSERT INTO histobon(nom,n,nbon,code_barre,op,dtec,total,ida) VALUES('"+this.nom+"' , "+this.n+" , "+nbon+" , "+cb+" , '"+this.login+"' , '"+dc+"' , "+0+" , "+this.ida+" )") ;                     
      
          }     
            
               // verification if qery is ok
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
          String jour = sdf.format(new Date()) ;
          
             
                for(int i = 0 ; i < this.list_mp_newOp.size() ; i++){
                    
         stmt.executeUpdate("INSERT INTO prodmp(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu) VALUES('"+this.list_mp_newOp.get(i).getNom()+"' , "+this.list_mp_newOp.get(i).getN()+" , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getQte()+" , "+this.list_mp_newOp.get(i).getPu()+" , "+this.list_mp_newOp.get(i).getMontant()+" , '"+dc+"' , '"+this.list_mp_newOp.get(i).getAdmin().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getF().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getSf().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getIdpro()+" , "+this.list_mp_newOp.get(i).getPa()+" , "+0+" , "+0+")") ;                 
         stmt.executeUpdate("UPDATE stock1 SET  stock ="+this.list_mp_newOp.get(i).getStock()+" WHERE desi ='"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"'") ;
    //   stmt.executeUpdate("UPDATE stock_pl SET  stock_dispo = "+this.list_mp_newOp.get(i).getStock()+" , dtec = '"+jour+"' WHERE description ='"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"'") ;
         stmt.executeUpdate("INSERT INTO detailbon(nbon,code_barre,desi,qte,pu,mtt) VALUES("+nbon+" , "+cb+" , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getQte()+" , "+this.list_mp_newOp.get(i).getPu()+" , "+this.list_mp_newOp.get(i).getMontant()+")") ;                     
         stmt.executeUpdate("INSERT INTO cumul_v_mp(idpro,qte,dtec,type) values("+this.list_mp_newOp.get(i).getIdpro()+" , "+this.list_mp_newOp.get(i).getQte()+" , '"+dc+"' , "+this.list_mp_newOp.get(i).getType()+")") ;      
          // detail stock2 : 
         
  stmt.executeUpdate("insert into stock2(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,admin,datec,type,idpro,op_) values('"
 +this.list_mp_newOp.get(i).getF().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getSf().replaceAll("'", "''")+"' , '"
 +" "+"' , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getPa()+" , "
 +this.list_mp_newOp.get(i).getPu()+" , "+0+" , "+this.list_mp_newOp.get(i).getQte()+" , "
 +this.list_mp_newOp.get(i).getStock()+" , '"+"SIBY CENTER"+"' , '"
 +this.stock_1.replaceAll("'", "''")+"' , '"+this.login.replaceAll("'", "''")+"' , '"
 +jour+"' , 'matiere' , "+this.list_mp_newOp.get(i).getIdpro()+" , "+cb+")") ;
         
         // end :
  
                }
                
                
                  DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                  dtm3.setRowCount(0);
                
                 long dep = 0 ;
     
      String sql4 ;
      // "Description", "QTE", "P.U", "Montant"
       sql4 = "SELECT article , sum(qte) , pu , sum(montant) FROM prodmp WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" GROUP BY article ORDER BY article asc" ;
      
       ResultSet rs4 = stmt.executeQuery(sql4);
      
      
     while(rs4.next()){
        // "Description", "P.A", "P.V"
         
         if(rs4.getLong("sum(qte)") > 0){
         
       dtm3.addRow(new Object[]{
           
       rs4.getString("article") , rs4.getLong("sum(qte)") , rs4.getLong("pu") , rs4.getLong("sum(montant)")
       
       });
        
       dep += rs4.getLong("sum(montant)") ; 
         
         }else{
             // do no thing :
         }
       
     }
     
     this.dep.setText(String.valueOf(dep)) ;
     
     
                
                
                try{
                    
                 /*
                    
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\bonHamza.jrxml")) ;
            //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\bonCommande.jrxml")) ;
            
        //    long total = 0 ;
            
            List mlist ;
            mlist = new ArrayList<>() ;
            
              for(int i = 0 ; i < this.list_mp_newOp.size() ; i++){
                HashMap<String, Object> m = new HashMap<>(); 
                m.put("desi", this.list_mp_newOp.get(i).getArticle());
                m.put("qte", this.list_mp_newOp.get(i).getQte());
                m.put("pu", this.list_mp_newOp.get(i).getPu());
                m.put("mt", this.list_mp_newOp.get(i).getMontant());
                
                // total += resultat.getInt("montant");
               //   m.put("total", total);
                
                mlist.add(m);
            }
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("data", jrbean);
            para.put("cb", cb);
            para.put("nom", this.nom);
            para.put("n", this.n);
            para.put("op", this.login) ;
            para.put("nbon", nbon) ;
            para.put("ident", "Matière Pre.") ;
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
            JasperViewer.viewReport(print, false);
            JasperPrintManager.printReport(print, false) ;
            
            */
            
       }catch(Exception e){
       
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       
       }
       
        
        
                
              DateFormat datef_ = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
              Date date_ = new Date() ;
             
      String dtf = datef_.format(date_) ;
      
      long profil = 0 ;
      profil = ( Long.parseLong(this.rec.getText().trim()) - Long.parseLong(this.dep.getText().trim()) );
          
      if(stmt.executeUpdate("UPDATE prod SET status = 'fermer' , dtef ='"+dtf+"' , dep = "+Long.parseLong(this.dep.getText().trim())+" , rec = "+Long.parseLong(this.rec.getText().trim())+" , profil = "+profil+" WHERE nom ='"+this.nom+"' AND n = "+this.n) == 1){
           
           this.vprod.setEnabled(false) ;
           
          JOptionPane.showMessageDialog(this, "la production a été cloturée avec succès");
          
      }else{
          JOptionPane.showMessageDialog(this, "Demarrer la production ensuite fermer la à la fin merci !!!");
      }
                
           
 
             this.jTable1.clearSelection();
             this.jTable2.clearSelection();
             this.jTable4.clearSelection();
             this.list_mp_newOp.removeAll(this.list_mp_newOp) ;
             this.vy = 0 ;
              this.id1.setText("0");
             this.id2.setText("0");
             this.id3.setText("0");
             this.id4.setText("0");
             this.stock.setText("0");
             /*
             this.dep.setText("0");
             this.rec.setText("0");
             this.profit.setText("0");
             */
             this.v1.setEnabled(false) ;     
 
                 
                 
            
                 
        
             
          
              
         
      
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
        
        
        
        this.v1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        }else{
            JOptionPane.showMessageDialog(this, "Veiller valider les produits finis d'abord ! ") ;
        }
          
            
        //
     
     
     
     
     
            
        }else if(this.cf == 0){
            
            
            
            //
            
               
     if(this.vy == 1 && this.list_mp_newOp.size() > 0){
        
        DateFormat datef = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
             Date date = new Date() ;
             
        String dc = datef.format(date) ;
        
        this.v1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
                          SessionFactory sf=new Configuration().configure().buildSessionFactory();
                          Session s=sf.openSession();

    List lib = s.createSQLQuery("SELECT * FROM prod WHERE nom ='"+this.nom+"' AND n = "+this.n).list();
              
            
               // verification if qery is ok
            
            if(lib.size() == 1){
                
                
                  Connection conn = null ;
                  Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

       // STEP 4: Execute a query
      //  System.out.println("Creating statement...") ;
          stmt = conn.createStatement() ;
      
   //     je crai ma requete
      
      
          int cpt = 0 ;
          int nbon = 0 ;
          int cb = 0 ;
          
          
          if(cpt == 0){
          String sql ;
          
      
       sql= "SELECT count(*) FROM histobon WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+"" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
        nbon = (rs.getInt(1) + 1) ;
        Random rx = new Random() ;
        cb = rx.nextInt() ;
        if(cb < 0){
            cb = Math.abs(cb) ;
        }
               cpt = 1 ;
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
     
  stmt.executeUpdate("INSERT INTO histobon(nom,n,nbon,code_barre,op,dtec,total,ida) VALUES('"+this.nom+"' , "+this.n+" , "+nbon+" , "+cb+" , '"+this.login+"' , '"+dc+"' , "+0+" , "+this.ida+" )") ;                     
      
          }     
            
               // verification if qery is ok
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
          String jour = sdf.format(new Date()) ;
          
             
                for(int i = 0 ; i < this.list_mp_newOp.size() ; i++){
                    
         stmt.executeUpdate("INSERT INTO prodmp(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu) VALUES('"+this.list_mp_newOp.get(i).getNom()+"' , "+this.list_mp_newOp.get(i).getN()+" , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getQte()+" , "+this.list_mp_newOp.get(i).getPu()+" , "+this.list_mp_newOp.get(i).getMontant()+" , '"+dc+"' , '"+this.list_mp_newOp.get(i).getAdmin().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getF().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getSf().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getIdpro()+" , "+this.list_mp_newOp.get(i).getPa()+" , "+0+" , "+0+")") ;                 
     //    stmt.executeUpdate("UPDATE stock1 SET  stock ="+this.list_mp_newOp.get(i).getStock()+" WHERE desi ='"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"'") ;
      // stmt.executeUpdate("UPDATE stock_pl SET  stock_dispo = "+this.list_mp_newOp.get(i).getStock()+" , dtec = '"+jour+"' WHERE description ='"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"'") ;
         stmt.executeUpdate("INSERT INTO detailbon(nbon,code_barre,desi,qte,pu,mtt) VALUES("+nbon+" , "+cb+" , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getQte()+" , "+this.list_mp_newOp.get(i).getPu()+" , "+this.list_mp_newOp.get(i).getMontant()+")") ;                     
         stmt.executeUpdate("INSERT INTO cumul_v_mp(idpro,qte,dtec,type) values("+this.list_mp_newOp.get(i).getIdpro()+" , "+this.list_mp_newOp.get(i).getQte()+" , '"+dc+"' , "+this.list_mp_newOp.get(i).getType()+" )") ;   
          // detail stock2 : 
         
         /*
  stmt.executeUpdate("insert into stock2(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,admin,datec,type,idpro,op_) values('"
 +this.list_mp_newOp.get(i).getF().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getSf().replaceAll("'", "''")+"' , '"
 +" "+"' , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getPa()+" , "
 +this.list_mp_newOp.get(i).getPu()+" , "+0+" , "+this.list_mp_newOp.get(i).getQte()+" , "
 +this.list_mp_newOp.get(i).getStock()+" , '"+"SIBY CENTER"+"' , '"
 +this.stock_1.replaceAll("'", "''")+"' , '"+this.login.replaceAll("'", "''")+"' , '"
 +jour+"' , 'matiere' , "+this.list_mp_newOp.get(i).getIdpro()+" , "+cb+")") ;
         */
         
         
         // end :
                }
                
                DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                dtm3.setRowCount(0);
                
                 long dep = 0 ;
     
      String sql4 ;
      // "Description", "QTE", "P.U", "Montant"
       sql4 = "SELECT article , sum(qte) , pu , sum(montant) FROM prodmp WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" GROUP BY article ORDER BY article asc" ;
      
       ResultSet rs4 = stmt.executeQuery(sql4);
      
      
     while(rs4.next()){
        // "Description", "P.A", "P.V"
         
         if(rs4.getLong("sum(qte)") > 0){
         
       dtm3.addRow(new Object[]{
           
       rs4.getString("article") , rs4.getLong("sum(qte)") , rs4.getLong("pu") , rs4.getLong("sum(montant)")
       
       });
        
       dep += rs4.getLong("sum(montant)") ; 
         
         }else{
             // do no thing :
         }
       
     }
     
     this.dep.setText(String.valueOf(dep)) ;
     
     
                
                
                
                try{
                    
                 /*
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\bonHamza.jrxml")) ;
            //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\bonCommande.jrxml")) ;
            
        //    long total = 0 ;
            
            List mlist;
            mlist = new ArrayList<>() ;
              for(int i = 0 ; i < this.list_mp_newOp.size() ; i++){
                HashMap<String, Object> m = new HashMap<>(); 
                m.put("desi", this.list_mp_newOp.get(i).getArticle());
                m.put("qte", this.list_mp_newOp.get(i).getQte());
                m.put("pu", this.list_mp_newOp.get(i).getPu());
                m.put("mt", this.list_mp_newOp.get(i).getMontant());
                // total += resultat.getInt("montant");
              //   m.put("total", total);
                
                mlist.add(m);
            }
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("data", jrbean);
            para.put("cb", cb);
            para.put("nom", this.nom);
            para.put("n", this.n);
            para.put("op", this.login) ;
            para.put("nbon", nbon) ;
            para.put("ident", "Matière Pre.") ;
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
            JasperViewer.viewReport(print, false);
            JasperPrintManager.printReport(print, false) ;
            */
                    
       }catch(Exception e){
       
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       
       }
       
        
        
                
              DateFormat datef_ = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
              Date date_ = new Date() ;
             
      String dtf = datef_.format(date_) ;
      
      long profil = 0 ;
      profil = ( Long.parseLong(this.rec.getText().trim()) - Long.parseLong(this.dep.getText().trim()) );
          
      if(stmt.executeUpdate("UPDATE prod SET status = 'fermer' , dtef ='"+dtf+"' , dep = "+Long.parseLong(this.dep.getText().trim())+" , rec = "+Long.parseLong(this.rec.getText().trim())+" , profil = "+profil+" WHERE nom ='"+this.nom+"' AND n = "+this.n) == 1){
           
           this.vprod.setEnabled(false) ;
           
          JOptionPane.showMessageDialog(this, "la production a été cloturée avec succès");
          
      }else{
          JOptionPane.showMessageDialog(this, "Demarrer la production ensuite fermer la à la fin merci !!!");
      }
                
         
             
             this.jTable1.clearSelection();
             this.jTable2.clearSelection();
             this.jTable4.clearSelection();
             this.list_mp_newOp.removeAll(this.list_mp_newOp) ;
             this.vy = 0 ;
             this.id1.setText("0");
             this.id2.setText("0");
             this.id3.setText("0");
             this.id4.setText("0");
             this.stock.setText("0");
        //   this.dep.setText("0");
   //        this.rec.setText("0");
     //      this.profit.setText("0");
             this.verify_1 = 0 ;
             this.an1.setEnabled(false);
             this.v1.setEnabled(false) ;
 
                  
 
                 
                 
            
                 
        
             
          
              
         
      
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
     
        
            
            
            }else{
                
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
      
      
          int cpt = 0 ;
          int nbon = 0 ;
          int cb = 0 ;
          
          
          if(cpt == 0){
              
              stmt.executeUpdate("INSERT INTO prod(nom,n,status,dtec,admin,dep,rec,profil,nb,grouper,etat) VALUES('"+this.nom+"' , "+this.n+" , 'ouverte' , '"+dc+"' , '"+this.login.replaceAll("'", "''")+"' , 0 , 0 , 0 , "+0+" , '"+this.groupe.replaceAll("'", "''")+"' , 'NORMAL' )") ;
              
          String sql ;
          
      
       sql= "SELECT count(*) FROM histobon WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+"" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
        nbon = (rs.getInt(1) + 1) ;
        Random rx = new Random() ;
        cb = rx.nextInt() ;
        if(cb < 0){
            cb = Math.abs(cb) ;
        }
               cpt = 1 ;
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
     
  stmt.executeUpdate("INSERT INTO histobon(nom,n,nbon,code_barre,op,dtec,total,ida) VALUES('"+this.nom+"' , "+this.n+" , "+nbon+" , "+cb+" , '"+this.login+"' , '"+dc+"' , "+0+" , "+this.ida+" )") ;                     
      
          }     
            
               // verification if qery is ok
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
          String jour = sdf.format(new Date()) ;
          
             
                for(int i = 0 ; i < this.list_mp_newOp.size() ; i++){
                    
         stmt.executeUpdate("INSERT INTO prodmp(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu) VALUES('"+this.list_mp_newOp.get(i).getNom()+"' , "+this.list_mp_newOp.get(i).getN()+" , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getQte()+" , "+this.list_mp_newOp.get(i).getPu()+" , "+this.list_mp_newOp.get(i).getMontant()+" , '"+dc+"' , '"+this.list_mp_newOp.get(i).getAdmin().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getF().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getSf().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getIdpro()+" , "+this.list_mp_newOp.get(i).getPa()+" , "+0+" , "+0+")") ;                 
     //  stmt.executeUpdate("UPDATE stock1 SET  stock ="+this.list_mp_newOp.get(i).getStock()+" WHERE desi ='"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"'") ;
    //   stmt.executeUpdate("UPDATE stock_pl SET  stock_dispo = "+this.list_mp_newOp.get(i).getStock()+" , dtec = '"+jour+"' WHERE description ='"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"'") ;
         stmt.executeUpdate("INSERT INTO detailbon(nbon,code_barre,desi,qte,pu,mtt) VALUES("+nbon+" , "+cb+" , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getQte()+" , "+this.list_mp_newOp.get(i).getPu()+" , "+this.list_mp_newOp.get(i).getMontant()+")") ;                     
         stmt.executeUpdate("INSERT INTO cumul_v_mp(idpro,qte,dtec,type) values("+this.list_mp_newOp.get(i).getIdpro()+" , "+this.list_mp_newOp.get(i).getQte()+" , '"+dc+"' , "+this.list_mp_newOp.get(i).getType()+")") ;      
          // detail stock2 : 
         
         /*
  stmt.executeUpdate("insert into stock2(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,admin,datec,type,idpro,op_) values('"
 +this.list_mp_newOp.get(i).getF().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getSf().replaceAll("'", "''")+"' , '"
 +" "+"' , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getPa()+" , "
 +this.list_mp_newOp.get(i).getPu()+" , "+0+" , "+this.list_mp_newOp.get(i).getQte()+" , "
 +this.list_mp_newOp.get(i).getStock()+" , '"+"SIBY CENTER"+"' , '"
 +this.stock_1.replaceAll("'", "''")+"' , '"+this.login.replaceAll("'", "''")+"' , '"
 +jour+"' , 'matiere' , "+this.list_mp_newOp.get(i).getIdpro()+" , "+cb+")") ;
         */
         
         
         // end :
  
                }
                
                
                  DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                  dtm3.setRowCount(0);
                
                 long dep = 0 ;
     
      String sql4 ;
      // "Description", "QTE", "P.U", "Montant"
       sql4 = "SELECT article , sum(qte) , pu , sum(montant) FROM prodmp WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" GROUP BY article ORDER BY article asc" ;
      
       ResultSet rs4 = stmt.executeQuery(sql4);
      
      
     while(rs4.next()){
        // "Description", "P.A", "P.V"
         
         if(rs4.getLong("sum(qte)") > 0){
         
       dtm3.addRow(new Object[]{
           
       rs4.getString("article") , rs4.getLong("sum(qte)") , rs4.getLong("pu") , rs4.getLong("sum(montant)")
       
       });
        
       dep += rs4.getLong("sum(montant)") ; 
         
         }else{
             // do no thing :
         }
       
     }
     
     this.dep.setText(String.valueOf(dep)) ;
     
     
                
                
                try{
                    
                 /*
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\bonHamza.jrxml")) ;
            //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\bonCommande.jrxml")) ;
            
        //    long total = 0 ;
            
            List mlist ;
            mlist = new ArrayList<>() ;
            
              for(int i = 0 ; i < this.list_mp_newOp.size() ; i++){
                HashMap<String, Object> m = new HashMap<>(); 
                m.put("desi", this.list_mp_newOp.get(i).getArticle());
                m.put("qte", this.list_mp_newOp.get(i).getQte());
                m.put("pu", this.list_mp_newOp.get(i).getPu());
                m.put("mt", this.list_mp_newOp.get(i).getMontant());
                
                // total += resultat.getInt("montant");
               //   m.put("total", total);
                
                mlist.add(m);
            }
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("data", jrbean);
            para.put("cb", cb);
            para.put("nom", this.nom);
            para.put("n", this.n);
            para.put("op", this.login) ;
            para.put("nbon", nbon) ;
            para.put("ident", "Matière Pre.") ;
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
            JasperViewer.viewReport(print, false);
            JasperPrintManager.printReport(print, false) ;
            */
                    
       }catch(Exception e){
       
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       
       }
       
        
        
                
              DateFormat datef_ = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
              Date date_ = new Date() ;
             
      String dtf = datef_.format(date_) ;
      
      long profil = 0 ;
      profil = ( Long.parseLong(this.rec.getText().trim()) - Long.parseLong(this.dep.getText().trim()) );
          
      if(stmt.executeUpdate("UPDATE prod SET status = 'fermer' , dtef ='"+dtf+"' , dep = "+Long.parseLong(this.dep.getText().trim())+" , rec = "+Long.parseLong(this.rec.getText().trim())+" , profil = "+profil+" WHERE nom ='"+this.nom+"' AND n = "+this.n) == 1){
           
           this.vprod.setEnabled(false) ;
           
          JOptionPane.showMessageDialog(this, "la production a été cloturée avec succès");
          
      }else{
          JOptionPane.showMessageDialog(this, "Demarrer la production ensuite fermer la à la fin merci !!!");
      }
                
           
 
             this.jTable1.clearSelection();
             this.jTable2.clearSelection();
             this.jTable4.clearSelection();
             this.list_mp_newOp.removeAll(this.list_mp_newOp) ;
             this.vy = 0 ;
              this.id1.setText("0");
             this.id2.setText("0");
             this.id3.setText("0");
             this.id4.setText("0");
             this.stock.setText("0");
             /*
             this.dep.setText("0");
             this.rec.setText("0");
             this.profit.setText("0");
             */
             this.v1.setEnabled(false) ;     
 
                 
                 
            
                 
        
             
          
              
         
      
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
        
        
        
        this.v1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        }else{
            JOptionPane.showMessageDialog(this, "Veiller valider les produits finis d'abord ! ") ;
        }
          
            
        //
     
     
     
     
     
            
            
            
        }
        
    }//GEN-LAST:event_v1ActionPerformed

    private void v2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v2ActionPerformed
        // TODO add your handling code here:
        
        SimpleDateFormat sdfT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        String jour = sdfT.format(new Date()) ;
        
       if(this.vy == 2 && this.list_mp_newOp.size() > 0){
       
        this.v2.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
         if(this.product.getSelectedItem().toString().equalsIgnoreCase("CHOISIR PRODUCTEUR")){
             JOptionPane.showMessageDialog(null, "Choisir un magasin et un producteur") ;
        }else{
        
         DateFormat datef = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
             Date date = new Date() ;
             
        String dc = datef.format(date) ;
        
      
        
                          SessionFactory sf=new Configuration().configure().buildSessionFactory();
                          Session s=sf.openSession();

    List lib = s.createSQLQuery("SELECT * FROM prod WHERE nom ='"+this.nom+"' AND n = "+this.n).list();
              
            
               // verification if qery is ok
            
            if(lib.size() == 1){
                
                
                  Connection conn = null;
                  Statement stmt = null;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

       // STEP 4: Execute a query
      //  System.out.println("Creating statement...") ;
          stmt = conn.createStatement() ;
      
   //     je crai ma requete
      
      
          int cpt = 0 ;
          int nbon = 0 ;
          int cb = 0 ;
          
          
          if(cpt == 0){
          String sql ;
          
      
       sql= "SELECT count(*) FROM histobon WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+"" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
        nbon = (rs.getInt(1) + 1) ;
        Random rx = new Random() ;
        cb = rx.nextInt() ;
        if(cb < 0){
            cb = Math.abs(cb) ;
        }
               cpt = 1 ;
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
     
  stmt.executeUpdate("INSERT INTO histobon(nom,n,nbon,code_barre,op,dtec,total,ida) VALUES('"+this.nom+"' , "+this.n+" , "+nbon+" , "+cb+" , '"+this.login+"' , '"+dc+"' , "+0+" , "+this.ida+" )") ;                     
      
          }     
            
               // verification if qery is ok
            
             
                for(int i = 0 ; i < this.list_mp_newOp.size() ; i++){
                    
         stmt.executeUpdate("INSERT INTO prodpf(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu,producteur) VALUES('"+this.list_mp_newOp.get(i).getNom()+"' , "+this.list_mp_newOp.get(i).getN()+" , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getQte()+" , "+this.list_mp_newOp.get(i).getPu()+" , "+this.list_mp_newOp.get(i).getMontant()+" , '"+dc+"' , '"+this.list_mp_newOp.get(i).getAdmin().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getF().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getSf().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getIdpro()+" , "+this.list_mp_newOp.get(i).getPa()+" , "+0+" , "+0+" , "+this.idProduct+")") ;                 
        // stmt.executeUpdate("UPDATE stock1 SET  stock ="+this.list_mp_newOp.get(i).getStock()+" WHERE desi ='"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"'") ;
         stmt.executeUpdate("INSERT INTO detailbon(nbon,code_barre,desi,qte,pu,mtt) VALUES("+nbon+" , "+cb+" , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getQte()+" , "+this.list_mp_newOp.get(i).getPu()+" , "+this.list_mp_newOp.get(i).getMontant()+")") ;                     
          // detail stock2 : 
         
         /*
  stmt.executeUpdate("insert into stock2(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,admin,datec,type,idpro,op_) values('"
 +this.list_mp_newOp.get(i).getF().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getSf().replaceAll("'", "''")+"' , '"
 +" "+"' , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getPa()+" , "
 +this.list_mp_newOp.get(i).getPu()+" , "+this.list_mp_newOp.get(i).getQte()+" , "+0+" , "
 +this.list_mp_newOp.get(i).getStock()+" , '"+"SIBY CENTER"+"' , '"
 +this.stock_1.replaceAll("'", "''")+"' , '"+this.login.replaceAll("'", "''")+"' , '"
 +jour+"' , 'production' , "+this.list_mp_newOp.get(i).getIdpro()+" , "+cb+")") ;
         */
         
         // end :   
         
                }
                
                DefaultTableModel dtm4 = (DefaultTableModel) this.jTable4.getModel() ;
                dtm4.setRowCount(0);
                 long rec = 0 ;
     
      String sql5 ;
      // "Description", "QTE", "P.U", "Montant"
       sql5 = "SELECT article , sum(qte) , pu , sum(montant) FROM prodpf WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" GROUP BY article ORDER BY article asc" ;
      
       ResultSet rs5 = stmt.executeQuery(sql5);
      
      
     while(rs5.next()){
        // "Description", "P.A", "P.V"
         if(rs5.getLong("sum(qte)") > 0){
       dtm4.addRow(new Object[]{
           
       rs5.getString("article") , rs5.getLong("sum(qte)") , rs5.getLong("pu") , rs5.getLong("sum(montant)")
       
       }) ;
        
       rec += rs5.getLong("sum(montant)") ; 
         
         }else{
             // do nothing :
             
         }
       
     }
     
     this.rec.setText(String.valueOf(rec)) ; 
     this.profit.setText(String.valueOf((Integer.parseInt(this.rec.getText()) - Integer.parseInt(this.dep.getText())))) ;
     
     
                
                
                try{
                    
                 /*
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\bonHamza.jrxml")) ;
            //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\bonCommande.jrxml")) ;
            
        //    long total = 0 ;
            
            List mlist;
            mlist = new ArrayList<>() ;
              for(int i = 0 ; i < this.list_mp_newOp.size() ; i++){
                HashMap<String, Object> m = new HashMap<>(); 
                m.put("desi", this.list_mp_newOp.get(i).getArticle());
                m.put("qte", this.list_mp_newOp.get(i).getQte());
                m.put("pu", this.list_mp_newOp.get(i).getPu());
                m.put("mt", this.list_mp_newOp.get(i).getMontant());
                // total += resultat.getInt("montant");
              //   m.put("total", total);
                
                mlist.add(m);
            }
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("data", jrbean);
            para.put("cb", cb);
            para.put("nom", this.nom);
            para.put("n", this.n);
            para.put("op", this.login) ;
            para.put("nbon", nbon) ;
            para.put("ident", "Produit Fini.") ;
            
            if(this.etat == 1){
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
           //  JasperViewer.viewReport(print, false);
            JasperPrintManager.printReport(print, false) ;
            }else{
                
            }
            */
                    
       }catch(Exception e){
       
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       
       }
       
        
        
                
             DateFormat datef_ = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
              Date date_ = new Date() ;
             
      String dtf = datef_.format(date_) ;
      
      long profil = 0 ;
      profil = ( Long.parseLong(this.rec.getText().trim()) - Long.parseLong(this.dep.getText().trim()) );
          
      if(stmt.executeUpdate("UPDATE prod SET status = 'fermer' , dtef ='"+dtf+"' , dep = "+Long.parseLong(this.dep.getText().trim())+" , rec = "+Long.parseLong(this.rec.getText().trim())+" , profil = "+profil+" WHERE nom ='"+this.nom+"' AND n = "+this.n) == 1){
           
           this.vprod.setEnabled(false) ;
           
          JOptionPane.showMessageDialog(this, "la production a été cloturée avec succès");
          
      }else{
          JOptionPane.showMessageDialog(this, "Demarrer la production ensuite fermer la à la fin merci !!!");
      }
                
              
             
             this.jTable1.clearSelection();
             this.jTable2.clearSelection();
             this.jTable3.clearSelection();
             this.list_mp_newOp.removeAll(this.list_mp_newOp) ;
             this.vy = 0 ;
             this.id1.setText("0");
             this.id2.setText("0");
             this.id3.setText("0");
             this.id4.setText("0");
             this.stock.setText("0");
             /*
             this.dep.setText("0");
             this.rec.setText("0");
             this.profit.setText("0");
             */
             this.verify_2 = 0 ;
             this.an2.setEnabled(false);
             this.v2.setEnabled(false) ;
 
                  
 
                 
                 
            
                 
        
             
          
              
         
      
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
     
        
            
            
            }else{
                
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
      
      
          int cpt = 0 ;
          int nbon = 0 ;
          int cb = 0 ;
          
          
          if(cpt == 0){
              
              stmt.executeUpdate("INSERT INTO prod(nom,n,status,dtec,admin,dep,rec,profil,nb,grouper,etat) VALUES('"+this.nom+"' , "+this.n+" , 'ouverte' , '"+dc+"' , '"+this.login.replaceAll("'", "''")+"' , 0 , 0 , 0 , "+0+" , '"+this.groupe.replaceAll("'", "''")+"' , 'NORMAL' )") ;
              
          String sql ;
          
      
       sql= "SELECT count(*) FROM histobon WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+"" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
        nbon = (rs.getInt(1) + 1) ;
        Random rx = new Random() ;
        cb = rx.nextInt() ;
        if(cb < 0){
        cb = Math.abs(cb) ;
        
        }
               cpt = 1 ;
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()) ;
               
               
     }
     
  stmt.executeUpdate("INSERT INTO histobon(nom,n,nbon,code_barre,op,dtec,total,ida) VALUES('"+this.nom+"' , "+this.n+" , "+nbon+" , "+cb+" , '"+this.login+"' , '"+dc+"' , "+0+" , "+this.ida+" )") ;                     
      
          }     
            
               // verification if qery is ok
            
             
                for(int i = 0 ; i < this.list_mp_newOp.size() ; i++){
                    
         stmt.executeUpdate("INSERT INTO prodpf(nom,n,article,qte,pu,montant,dtec,admin,f,sf,idpro,pa,profil,mu,producteur) VALUES('"+this.list_mp_newOp.get(i).getNom()+"' , "+this.list_mp_newOp.get(i).getN()+" , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getQte()+" , "+this.list_mp_newOp.get(i).getPu()+" , "+this.list_mp_newOp.get(i).getMontant()+" , '"+dc+"' , '"+this.list_mp_newOp.get(i).getAdmin().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getF().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getSf().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getIdpro()+" , "+this.list_mp_newOp.get(i).getPa()+" , "+0+" , "+0+" , "+this.idProduct+")") ;                 
       //  stmt.executeUpdate("UPDATE stock1 SET  stock ="+this.list_mp_newOp.get(i).getStock()+" WHERE desi ='"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"'") ;
         stmt.executeUpdate("INSERT INTO detailbon(nbon,code_barre,desi,qte,pu,mtt) VALUES("+nbon+" , "+cb+" , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getQte()+" , "+this.list_mp_newOp.get(i).getPu()+" , "+this.list_mp_newOp.get(i).getMontant()+")") ;                     
          // detail stock2 : 
         
         /*
  stmt.executeUpdate("insert into stock2(f,sf,cb,desi,pa,pv,qteet,qtest,stock,four,maga,admin,datec,type,idpro,op_) values('"
 +this.list_mp_newOp.get(i).getF().replaceAll("'", "''")+"' , '"+this.list_mp_newOp.get(i).getSf().replaceAll("'", "''")+"' , '"
 +" "+"' , '"+this.list_mp_newOp.get(i).getArticle().replaceAll("'", "''")+"' , "+this.list_mp_newOp.get(i).getPa()+" , "
 +this.list_mp_newOp.get(i).getPu()+" , "+this.list_mp_newOp.get(i).getQte()+" , "+0+" , "
 +this.list_mp_newOp.get(i).getStock()+" , '"+"SIBY CENTER"+"' , '"
 +this.stock_1.replaceAll("'", "''")+"' , '"+this.login.replaceAll("'", "''")+"' , '"
 +jour+"' , 'production' , "+this.list_mp_newOp.get(i).getIdpro()+" , "+cb+")") ;
         */
         
         // end :   
         
                }
                
                   DefaultTableModel dtm4 = (DefaultTableModel) this.jTable4.getModel() ;
                   dtm4.setRowCount(0);
                   long rec = 0 ;
     
      String sql5 ;
      // "Description", "QTE", "P.U", "Montant"
       sql5 = "SELECT article , sum(qte) , pu , sum(montant) FROM prodpf WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" GROUP BY article ORDER BY article asc" ;
      
       ResultSet rs5 = stmt.executeQuery(sql5);
      
      
     while(rs5.next()){
        // "Description", "P.A", "P.V"
         if(rs5.getLong("sum(qte)") > 0){
       dtm4.addRow(new Object[]{
           
       rs5.getString("article") , rs5.getLong("sum(qte)") , rs5.getLong("pu") , rs5.getLong("sum(montant)")
       
       }) ;
        
       rec += rs5.getLong("sum(montant)") ; 
         
         }else{
             // do nothing :
             
         }
       
     }
     
     this.rec.setText(String.valueOf(rec)) ; 
     this.profit.setText(String.valueOf((Integer.parseInt(this.rec.getText()) - Integer.parseInt(this.dep.getText()))));
     
     
                
                
                try{
                    
                 /*
            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\bonHamza.jrxml")) ;
            //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\bonCommande.jrxml")) ;
            
        //    long total = 0 ;
            
            List mlist ;
            mlist = new ArrayList<>() ;
            
              for(int i = 0 ; i < this.list_mp_newOp.size() ; i++){
                HashMap<String, Object> m = new HashMap<>(); 
                m.put("desi", this.list_mp_newOp.get(i).getArticle());
                m.put("qte", this.list_mp_newOp.get(i).getQte());
                m.put("pu", this.list_mp_newOp.get(i).getPu());
                m.put("mt", this.list_mp_newOp.get(i).getMontant());
                
                // total += resultat.getInt("montant");
               //   m.put("total", total);
                
                mlist.add(m);
            }
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            
            Map<String, Object> para = new HashMap<>();
            para.put("data", jrbean);
            para.put("cb", cb);
            para.put("nom", this.nom);
            para.put("n", this.n);
            para.put("op", this.login) ;
            para.put("nbon", nbon) ;
            para.put("ident", "Produit Fini.") ;
            
            if(this.etat == 1){
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
            JasperViewer.viewReport(print, false);
            }else{
                
            }
            */
                    
       }catch(Exception e){
       
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       
       }
       
        
        
                
             
                DateFormat datef_ = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
              Date date_ = new Date() ;
             
      String dtf = datef_.format(date_) ;
      
      long profil = 0 ;
      profil = ( Long.parseLong(this.rec.getText().trim()) - Long.parseLong(this.dep.getText().trim()) );
          
      if(stmt.executeUpdate("UPDATE prod SET status = 'fermer' , dtef ='"+dtf+"' , dep = "+Long.parseLong(this.dep.getText().trim())+" , rec = "+Long.parseLong(this.rec.getText().trim())+" , profil = "+profil+" WHERE nom ='"+this.nom+"' AND n = "+this.n) == 1){
           
           this.vprod.setEnabled(false) ;
           
          JOptionPane.showMessageDialog(this, "la production a été cloturée avec succès");
          
      }else{
          JOptionPane.showMessageDialog(this, "Demarrer la production ensuite fermer la à la fin merci !!!");
      }
            
 
             this.jTable1.clearSelection();
             this.jTable2.clearSelection();
             this.jTable3.clearSelection();
             this.list_mp_newOp.removeAll(this.list_mp_newOp) ;
             this.vy = 0 ; 
             this.id1.setText("0");
             this.id2.setText("0");
             this.id3.setText("0");
             this.id4.setText("0");
             this.stock.setText("0");
             /*
             this.dep.setText("0");
             this.rec.setText("0");
             this.profit.setText("0");
             */
             this.verify_2 = 0 ;
             this.an2.setEnabled(false);
             this.v2.setEnabled(false) ;     
 
                 
                 
            
                 
        
             
          
              
         
      
    
            
     // STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   // rs.close() ;
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
        
        
        
      
         }
        
        this.v2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        }else{
            JOptionPane.showMessageDialog(this, "Valider les matieres primaires d'abord ! ") ;
        }
        
    }//GEN-LAST:event_v2ActionPerformed

    private void vprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vprodActionPerformed
        // TODO add your handling code here:
        
        this.vprod.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
         if("".equalsIgnoreCase(this.nom) || this.n == 0){
            
            JOptionPane.showMessageDialog(this, "Choisir une production svp") ;
            
        }else{
            
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
      
       DateFormat datef = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
       Date date = new Date() ;
             
      String dtf = datef.format(date) ;
      
      long profil = 0 ;
      profil = ( Long.parseLong(this.rec.getText().trim()) - Long.parseLong(this.dep.getText().trim()) );
          
      if(stmt.executeUpdate("UPDATE prod SET status = 'fermer' , dtef ='"+dtf+"' , dep = "+Long.parseLong(this.dep.getText().trim())+" , rec = "+Long.parseLong(this.rec.getText().trim())+" , profil = "+profil+" WHERE nom ='"+this.nom+"' AND n = "+this.n) == 1){
           
           this.vprod.setEnabled(false) ;
           
          JOptionPane.showMessageDialog(this, "la production a été cloturée avec succès");
          
      }else{
          JOptionPane.showMessageDialog(this, "Demarrer la production ensuite fermer la à la fin merci !!!");
      }
      
      
            
     // STEP 6: Clean-up environment
      
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
        
        
        this.vprod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
        
    }//GEN-LAST:event_vprodActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        
        
        this.print.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
          try{
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY);

            Connection connection2 = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement statement2 = connection2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY);

            ResultSet resultat = statement.executeQuery("SELECT article as desi , qte as qte, "
                + " pu as pu, montant as montant FROM prodmp WHERE nom = '"+this.nom+"' AND n = "+this.n+" ");

            ResultSet resultat2 = statement2.executeQuery("SELECT article as desi2 , qte as qte2, "
                + " pu as pu2, montant as montant2 FROM prodpf WHERE nom = '"+this.nom+"' AND n = "+this.n+" ");

            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\prodOuverte.jrxml")) ;
            //InputStream in = new FileInputStream(new File("D:\\SOFT-TECH\\SIBY\\UtpaSibyCenter\\src\\reports\\prodOuverte.jrxml")) ;
            
            long total = 0 ;
            long total2 = 0;
            long profil = 0;

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

            List mlist2;
            mlist2 = new ArrayList<>();
            while(resultat2.next()) {
                HashMap<String, Object> m = new HashMap<>();
                m.put("desi2", resultat2.getString("desi2"));
                m.put("qte2", resultat2.getInt("qte2"));
                m.put("pu2", resultat2.getInt("pu2"));
                m.put("montant2", resultat2.getInt("montant2"));
                total2 += resultat2.getInt("montant2");
                profil = total2 - total;
                m.put("total2", total2);
                m.put("profil", profil);
                mlist2.add(m);
            }

            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist);
            JRBeanCollectionDataSource jrbean2 = new JRBeanCollectionDataSource(mlist2);

            SimpleDateFormat sdf10 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss") ;
            
            Map<String, Object> para = new HashMap<>();
            para.put("sql", jrbean);
            para.put("data", jrbean2);
            para.put("nom", this.nom); 
            para.put("n", this.n);
            para.put("status", "ouverte");
            para.put("dtec", sdf10.format(new Date())) ;
            para.put("admin", this.login);

            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
            JasperViewer.viewReport(print, false);

        }catch(Exception e){

            JOptionPane.showMessageDialog(null, e) ;
            System.out.println(e) ;

        }

        
        this.print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
        
    }//GEN-LAST:event_printActionPerformed

    private void nop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nop1ActionPerformed
       
           // TODO add your handling code here :
        
        if(this.cf == 1){
            
             if(this.vy == 0 || this.vy == 1){
        
         if(Integer.parseInt(this.id1.getText()) > 0 || Integer.parseInt(this.stock.getText()) > 0){
         
         
      
        
        String qt = this.qt1.getText().trim() ;
        
        if("".equals(qt) || "0".equals(qt)){
            JOptionPane.showMessageDialog(this, "Saisir la quantité") ;
        }else{
            long qt10 = 0 ;
            qt10 = Long.parseLong(qt) ;
            
            
            if(qt10 < 0){
                
                if(this.qten >= Math.abs(qt10)){
                    
                    
                      this.newStock = 0 ;
                   if(this.stock1 > qt10){
                 
                        if(qt10 > 0){
                             this.newStock = (this.stock1 - qt10) ;
                       }else if(qt10 < 0){
                           long qt11 = Math.abs(qt10) ;
                             this.newStock = (this.stock1 + qt11) ;
                       }else if(qt10 == 0){
                           JOptionPane.showMessageDialog(this, "Operation impossible") ;
                       }
                 
                   if("oui".equalsIgnoreCase(this.rapport)){
                       double qt00 = 0.0 ;
                              qt00 = (qt10/1000.0) ;
                              double mt = 0.0 ;
                                     mt = (this.pu * qt00) ;
                                     this.montant = Math.round(mt) ;
                                     
                                     if(this.verify_1 == 0){
                                         
                                        DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                        dtm3.setRowCount(0);
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                   
                                      
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                       this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      
                                      this.verify_1 = 1 ;
                                      this.an1.setEnabled(true) ;
                                      
                                     }else{
                                         
                                          DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                       
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                    this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                       
                                         
                                     }
                                      
                                     
                                      
                                      
                                      this.jTable1.clearSelection();
                                      this.jTable2.clearSelection();
                                      this.jTable3.clearSelection();
                                      this.jTable4.clearSelection();
                                      
                           
                   }else{
                       double qt00 = 0.0 ;
                              qt00 = qt10 ;
                              double mt = 0.0 ;
                                     mt = (this.pu * qt00) ;
                                     this.montant = Math.round(mt) ;
                                     
                                     
                                      if(this.verify_1 == 0){
                                         
                                        DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                        dtm3.setRowCount(0);
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                    this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                      this.verify_1 = 1 ;
                                      this.an1.setEnabled(true) ;
                                      
                                     }else{
                                         
                                          DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                       
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                    this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                       
                                         
                                     }
                                      
                                      /*
                                     
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      
                                      DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                      */
                                      
                         //     this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                       //       this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()) )) ) ) ;
                           
                              
                                    /*
                        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                                      dtm1.removeRow(this.jTable1.getSelectedRow()) ;
                                    */         
                              
                                      this.jTable1.clearSelection();
                                      this.jTable2.clearSelection();
                                      this.jTable3.clearSelection();
                                      this.jTable4.clearSelection();
                           
                   }
                 
                 
                   }else{
                       JOptionPane.showMessageDialog(this, "le stock est insuffisant") ;
                   }
            
                    
                }else if(this.qten < Math.abs(qt10) ){
                     JOptionPane.showMessageDialog(this, "operation impossible le cumul ne vaut pas votre quantite à sustraire") ;
                }
                
            }else{
            
               this.newStock = 0 ;
                   if(this.stock1 > qt10){
                 this.newStock = (this.stock1 - qt10) ;
                 
                   if("oui".equalsIgnoreCase(this.rapport)){
                       double qt00 = 0.0 ;
                              qt00 = (qt10/1000.0) ;
                              double mt = 0.0 ;
                                     mt = (this.pu * qt00) ;
                                     this.montant = Math.round(mt) ;
                                     
                                     if(this.verify_1 == 0){
                                         
                                        DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                        dtm3.setRowCount(0);
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                   
                                       this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                      this.verify_1 = 1 ;
                                      this.an1.setEnabled(true) ;
                                      
                                     }else{
                                         
                                          DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                       
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                   
                                       this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                       
                                         
                                     }
                                      
                                      
                                       
                                      
                                      
                                      this.jTable1.clearSelection();
                                      this.jTable2.clearSelection();
                                      this.jTable3.clearSelection();
                                      this.jTable4.clearSelection();
                                      
                           
                   }else{
                       double qt00 = 0.0 ;
                              qt00 = qt10 ;
                              double mt = 0.0 ;
                                     mt = (this.pu * qt00) ;
                                     this.montant = Math.round(mt) ;
                                     
                                     
                                      if(this.verify_1 == 0){
                                         
                                        DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                        dtm3.setRowCount(0);
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                   
                                       this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                      this.verify_1 = 1 ;
                                      this.an1.setEnabled(true) ;
                                      
                                     }else{
                                         
                                          DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                       
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                    this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                       
                                         
                                     }
                                      
                                      /*
                                     
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      
                                      DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                      */
                                      
                               
                              
                                    /*
                        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                                      dtm1.removeRow(this.jTable1.getSelectedRow()) ;
                                    */         
                              
                                      this.jTable1.clearSelection();
                                      this.jTable2.clearSelection();
                                      this.jTable3.clearSelection();
                                      this.jTable4.clearSelection();
                           
                   }
                 
                 
                   }else{
                       JOptionPane.showMessageDialog(this, "le stock est insuffisant") ;
                   }
            
        }
              this.stock.setText("0"); this.id1.setText("0") ;
              this.qt1.setText("");
              
        }
         }else{
         JOptionPane.showMessageDialog(this, "veillez reselectionner ou utiliser la touche entre pour selectionner vos produits svp");
     }
        
        
        }else{
            JOptionPane.showMessageDialog(this, "Veiller valider les produits fini d'abord ! ") ;
        } 
            
        }else if(this.cf == 0){
            
            
             if(this.vy == 0 || this.vy == 1){
        
         if(Integer.parseInt(this.id1.getText()) > 0){
         
         
      
        
        String qt = this.qt1.getText().trim() ;
        
        if("".equals(qt) || "0".equals(qt)){
            JOptionPane.showMessageDialog(this, "Saisir la quantité") ;
        }else{
            long qt10 = 0 ;
            qt10 = Long.parseLong(qt) ;
            
            
            if(qt10 < 0){
                
                if(this.qten >= Math.abs(qt10)){
                    
                    
                      this.newStock = 0 ;
                    
                 
                        if(qt10 > 0){
                             this.newStock = (this.stock1 - qt10) ;
                       }else if(qt10 < 0){
                           long qt11 = Math.abs(qt10) ;
                             this.newStock = (this.stock1 + qt11) ;
                       }else if(qt10 == 0){
                           JOptionPane.showMessageDialog(this, "Operation impossible") ;
                       }
                 
                   if("oui".equalsIgnoreCase(this.rapport)){
                       double qt00 = 0.0 ;
                              qt00 = (qt10/1000.0) ;
                              double mt = 0.0 ;
                                     mt = (this.pu * qt00) ;
                                     this.montant = Math.round(mt) ;
                                     
                                     if(this.verify_1 == 0){
                                         
                                        DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                        dtm3.setRowCount(0);
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                   
                                      
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                       this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      
                                      this.verify_1 = 1 ;
                                      this.an1.setEnabled(true) ;
                                      
                                     }else{
                                         
                                          DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                       
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                    this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                       
                                         
                                     }
                                      
                                     
                                      
                                      
                                      this.jTable1.clearSelection();
                                      this.jTable2.clearSelection();
                                      this.jTable3.clearSelection();
                                      this.jTable4.clearSelection();
                                      
                           
                   }else{
                       double qt00 = 0.0 ;
                              qt00 = qt10 ;
                              double mt = 0.0 ;
                                     mt = (this.pu * qt00) ;
                                     this.montant = Math.round(mt) ;
                                     
                                     
                                      if(this.verify_1 == 0){
                                         
                                        DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                        dtm3.setRowCount(0);
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                    this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                      this.verify_1 = 1 ;
                                      this.an1.setEnabled(true) ;
                                      
                                     }else{
                                         
                                          DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                       
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                    this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                       
                                         
                                     }
                                      
                                      /*
                                     
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      
                                      DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                      */
                                      
                         //     this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                       //       this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()) )) ) ) ;
                           
                              
                                    /*
                        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                                      dtm1.removeRow(this.jTable1.getSelectedRow()) ;
                                    */         
                              
                                      this.jTable1.clearSelection();
                                      this.jTable2.clearSelection();
                                      this.jTable3.clearSelection();
                                      this.jTable4.clearSelection();
                           
                   }
                 
                  
            
                    
                }else if(this.qten < Math.abs(qt10) ){
                     JOptionPane.showMessageDialog(this, "operation impossible le cumul ne vaut pas votre quantite à sustraire") ;
                }
                
            }else{
            
               this.newStock = 0 ;
                   
                 this.newStock = (this.stock1 - qt10) ;
                 
                   if("oui".equalsIgnoreCase(this.rapport)){
                       double qt00 = 0.0 ;
                              qt00 = (qt10/1000.0) ;
                              double mt = 0.0 ;
                                     mt = (this.pu * qt00) ;
                                     this.montant = Math.round(mt) ;
                                     
                                     if(this.verify_1 == 0){
                                         
                                        DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                        dtm3.setRowCount(0);
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                   
                                       this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                      this.verify_1 = 1 ;
                                      this.an1.setEnabled(true) ;
                                      
                                     }else{
                                         
                                          DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                       
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                   
                                       this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                       
                                         
                                     }
                                      
                                      
                                       
                                      
                                      
                                      this.jTable1.clearSelection();
                                      this.jTable2.clearSelection();
                                      this.jTable3.clearSelection();
                                      this.jTable4.clearSelection();
                                      
                           
                   }else{
                       double qt00 = 0.0 ;
                              qt00 = qt10 ;
                              double mt = 0.0 ;
                                     mt = (this.pu * qt00) ;
                                     this.montant = Math.round(mt) ;
                                     
                                     
                                      if(this.verify_1 == 0){
                                         
                                        DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                        dtm3.setRowCount(0);
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                   
                                       this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                      this.verify_1 = 1 ;
                                      this.an1.setEnabled(true) ;
                                      
                                     }else{
                                         
                                          DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                       
                                      
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0") , this.type) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 1 ;
                                      
                                    this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( ((Integer.parseInt(this.rec.getText()))-(Integer.parseInt(this.dep.getText()))) ) ) ;
                           
                                       
                                      
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                       
                                         
                                     }
                                      
                                      /*
                                     
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      
                                      DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
                                      dtm3.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pu , this.montant
                                      }) ;
                                      
                                      */
                                      
                               
                              
                                    /*
                        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                                      dtm1.removeRow(this.jTable1.getSelectedRow()) ;
                                    */         
                              
                                      this.jTable1.clearSelection();
                                      this.jTable2.clearSelection();
                                      this.jTable3.clearSelection();
                                      this.jTable4.clearSelection();
                           
                   }
                 
                 
                  
            
        }
              this.stock.setText("0"); this.id1.setText("0") ;
              this.qt1.setText("");
              
        }
         }else{
         JOptionPane.showMessageDialog(this, "veillez reselectionner ou utiliser la touche entre pour selectionner vos produits svp");
     }
        
        
        }else{
            JOptionPane.showMessageDialog(this, "Veiller valider les produits fini d'abord ! ") ;
        } 
            
            
        }
        
       
    }//GEN-LAST:event_nop1ActionPerformed

    private void activityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activityActionPerformed
        // TODO add your handling code here:
        
        
        String act = this.activity.getSelectedItem().toString().replaceAll("'", "''") ;
        
         if("CHOISIR UNE PRODUCTION".equalsIgnoreCase(act)){
             JOptionPane.showMessageDialog(this, "Choisir une prodction svp") ;
         }else{
             
             String dt = "" ;
             SimpleDateFormat sdf10 = new SimpleDateFormat("yyyy-MM-dd") ;
             
             SessionFactory sf = new Configuration().configure().buildSessionFactory();
             Session s = sf.openSession() ;
             
       
         List lib = s.createSQLQuery("SELECT * FROM prod WHERE nom = '"+act.replaceAll("'", "''")+"' AND status = 'ouverte'").list() ;
         List lib1 = s.createSQLQuery("SELECT * FROM prod WHERE nom = '"+act.replaceAll("'", "''")+"' AND status = 'ouverte' AND dtec LIKE '%"+sdf10.format(new Date())+"%'").list() ;
            
               // verification if qery is ok
            
            if(lib.size() == 1 || lib.size() > 0){
                
           // Question :
                
                if (JOptionPane.showConfirmDialog(null, lib.size()+" ACTIVITE(S) "+act+" en gros dejà en cours et "+lib1.size()+" ACTIVITE(S) "+act+" pour aujourd'hui dejà en cours : Question voulez vous continuer ?", "Demande",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                               // yes option
                    
                                this.nom = "" ;
                                this.nom = act ;
                                this.n = 0 ;
                                this.groupe = "" ;
                                
                                // chargement
                                
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
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
       sql= "SELECT * FROM activite_t WHERE description = '"+this.nom+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        this.groupe = rs.getString("libelle") ;
        
       
     }
     
     String sql1 = "" ;
      sql1 = "SELECT count(*) FROM prod WHERE nom = '"+this.nom+"'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
     while(rs1.next()){
        
        this.n = (rs1.getInt(1)+1) ;
        
       
     }
     
     
     DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
     dtm1.setRowCount(0) ;
     
      String sql2 ;
      
       sql2 = "SELECT * FROM pmp WHERE nomp = '"+this.nom.replaceAll("'", "''")+"' GROUP BY article ORDER BY article" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
     while(rs2.next()){
        // "Description", "P.A", "P.V"
         
       dtm1.addRow(new Object[]{
           
       rs2.getString("article") , rs2.getLong("pa") , rs2.getLong("pv")
       
       });
        
       
     }
      
    
          // code patient 
      
     
     DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
     dtm2.setRowCount(0) ;
     
      String sql3 ;
      
       sql3 = "SELECT * FROM ppf WHERE nomp = '"+this.nom.replaceAll("'", "''")+"' GROUP BY article ORDER BY article" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3);
      
      
     while(rs3.next()){
        // "Description", "P.A", "P.V"
         
       dtm2.addRow(new Object[]{
           
       rs3.getString("article") , rs3.getLong("pa") , rs3.getLong("pu")
       
       });
        
       
     }
      
    
          // code patient 
      
     
     this.dtec = "" ;
     SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
     this.dtec = sdf.format(new Date()) ;
       
       
     this.nom1.setText("Production : "+" "+this.nom) ;
     this.n1.setText("N° : "+" "+this.n) ;
     this.dte.setText("DATE : "+" "+this.dtec) ;
     this.op.setText("Operateur : "+" "+this.login) ;
     this.stat1.setText("STATUT : "+" "+"nouvelle production / ouverte") ;
     this.nbc.setText("NOMBRE EN COURS : "+" "+(lib.size()+1)) ;
     
     
     
            
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
     
        
                                
                                
                                // end
                                
                                
                                
                    
                   } else {
                              // no option
                    
                      }
                
                
            }else{
                
                // chargement sans question :
                
                                this.nom = "" ;
                                this.nom = act ;
                                this.n = 0 ;
                                this.groupe = "" ;
                                
                                // chargement
                                
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
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
       sql= "SELECT * FROM activite_t WHERE description = '"+this.nom+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        this.groupe = rs.getString("libelle") ;
        
       
     }
     
     String sql1 = "" ;
      sql1 = "SELECT count(*) FROM prod WHERE nom = '"+this.nom+"'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
     while(rs1.next()){
        
        this.n = (rs1.getInt(1)+1) ;
        
       
     }
     
     
     DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
     dtm1.setRowCount(0) ;
     
      String sql2 ;
      
       sql2 = "SELECT * FROM pmp WHERE nomp = '"+this.nom.replaceAll("'", "''")+"' GROUP BY article ORDER BY article" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
     while(rs2.next()){
        // "Description", "P.A", "P.V"
         
       dtm1.addRow(new Object[]{
           
       rs2.getString("article") , rs2.getLong("pa") , rs2.getLong("pv")
       
       });
        
       
     }
      
    
          // code patient 
      
     
     DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
     dtm2.setRowCount(0) ;
     
      String sql3 ;
      
       sql3 = "SELECT * FROM ppf WHERE nomp = '"+this.nom.replaceAll("'", "''")+"' GROUP BY article ORDER BY article" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3);
      
      
     while(rs3.next()){
        // "Description", "P.A", "P.V"
         
       dtm2.addRow(new Object[]{
           
       rs3.getString("article") , rs3.getLong("pa") , rs3.getLong("pu")
       
       });
        
       
     }
      
    
          // code patient 
      
     
     this.dtec = "" ;
     SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
     this.dtec = sdf.format(new Date()) ;
       
     this.nom1.setText("Production : "+" "+this.nom) ;
     this.n1.setText("N° : "+" "+this.n) ;
     this.dte.setText("DATE : "+" "+this.dtec) ;
     this.op.setText("Operateur : "+" "+this.login) ;
     this.stat1.setText("STATUT : "+" "+"nouvelle production / ouverte") ;
     this.nbc.setText("NOMBRE EN COURS : "+" "+(lib.size()+1)) ;
     
     
            
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
             
             
             
         }
        
        
        
        
        
       
    }//GEN-LAST:event_activityActionPerformed

    private void descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyPressed
        // TODO add your handling code here:
        
        
        String desc = this.desc.getText().replaceAll("'", "''") ;
        
        if("".equals(desc.trim())){
            
        }else{
            DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
            dtm1.setRowCount(0) ;
            
            
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
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
     
      String sql2 ;
      
       sql2 = "SELECT * FROM pmp WHERE nomp = '"+this.nom+"' AND article like '%"+desc.replaceAll("'", "''")+"%'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
     while(rs2.next()){
        // "Description", "P.A", "P.V"
         
       dtm1.addRow(new Object[]{
           
       rs2.getString("article") , rs2.getLong("pa") , rs2.getLong("pv")
       
       });
        
       
     }
      
          // code patient 
      
     
      
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
      rs2.close();
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
        
        
        
    }//GEN-LAST:event_descKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
   
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
        
        
    this.stock1 = 0 ;
    this.article = "" ;
    this.qt = 0 ;
    this.pu = 0 ;
    this.montant = 0 ;
    this.f = "" ;
    this.sf = "" ;
    this.idpro = 0 ;
    this.pa = 0 ;
    this.profil = 0 ;
    this.mu = 0 ;
    this.rapport = "" ;
    
    this.jTable2.clearSelection() ;
    this.jTable3.clearSelection() ;
    this.jTable4.clearSelection() ;
    
    if(this.jTable1.getSelectedRow() == -1){
        
    }else{
        
        // this.id1.setText(f);
        
        this.article = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString() ;
         this.pa = Long.parseLong(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()) ;
          this.pu = Long.parseLong(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString()) ;
          
          
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
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
       sql= "SELECT * FROM produits_f WHERE description = '"+this.article.replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
          this.f = rs.getString("f");
          this.sf = rs.getString("sf") ;
          this.idpro = rs.getInt("id") ;
          this.rapport = rs.getString("unite_m") ;
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
     
      String sql1 ;
      
       sql1 = "SELECT * FROM matieres_p WHERE description = '"+this.article.replaceAll("'", "''")+"'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1);
      
      
     while(rs1.next()){
        
        
          this.f = rs1.getString("condition_livraison");
          this.sf = rs1.getString("conservation") ;
          this.idpro = rs1.getLong("id") ;
          this.rapport = rs1.getString("unite_mesure") ;
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
     
        String sql2 ;
      
       sql2 = "SELECT * FROM stock1 WHERE desi = '"+this.article.replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
     while(rs2.next()){
        
        this.stock1 = rs2.getLong("stock") ;  
       
     }
     
     this.stock.setText(String.valueOf(this.stock1)) ;
     
     this.id1.setText(String.valueOf(this.idpro));
     
     if(Integer.parseInt(this.id1.getText()) > 0 || Integer.parseInt(this.stock.getText()) > 0){
         
     }else{
         JOptionPane.showMessageDialog(this, "veillez reselectionner ou utiliser la touche entre pour selectionner vos produits svp");
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
    
    
    
        
        
        
        
        
        
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTable3MouseClicked

    private void an1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_an1ActionPerformed
        // TODO add your handling code here:
        
          if(Integer.parseInt(this.id3.getText()) > 0 || Integer.parseInt(this.id3.getText()) < 0){
      DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
      DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
      this.list_mp_newOp.remove(this.jTable3.getSelectedRow()) ;
      
      
      
      this.vy = 1 ;
      
       
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
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      
      /*
      String sql ;
      
       sql= "SELECT * FROM produits_f WHERE description = '"+this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0).toString().replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
         dtm1.addRow(new Object[]{rs.getString("description"),rs.getLong("libelle"),rs.getLong("pu")}) ;
       
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
     String sql1 ;
      
       sql1 = "SELECT * FROM matieres_p WHERE description = '"+this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0).toString().replaceAll("'", "''")+"'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
     while(rs1.next()){
        
    
        
          dtm1.addRow(new Object[]{rs1.getString("description"),rs1.getLong("prx_a_unite"),rs1.getLong("prx_v_unite")}) ;
       
        
        
       
     }
      
    
     */
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   //   rs.close();
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
     
        
      this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) - Integer.parseInt(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3).toString()) ) )) ;
      dtm3.removeRow(this.jTable3.getSelectedRow()) ;
      
      
           
      
      this.id3.setText("0") ;
         
        }else{
            JOptionPane.showMessageDialog(this, "Veillez reselectionner svp");
            
        }
        
        
    }//GEN-LAST:event_an1ActionPerformed

    private void jTable3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable3KeyTyped
        // TODO add your handling code here:
        
         if(this.jTable3.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Veillez reselectionner svp");
        }else{
             this.id3.setText(this.jTable3.getValueAt(this.jTable3.getSelectedRow() , 1).toString()) ;
        
        
        this.jTable1.clearSelection() ;
        this.jTable2.clearSelection() ;
        this.jTable4.clearSelection() ;
        
        // "Description", "QTE", "P.U", "Montant"
        
      
        
        
        
        
        }
        
        
    }//GEN-LAST:event_jTable3KeyTyped
     long qten = 0 ;
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        if(this.stock_1.isEmpty()){
            JOptionPane.showMessageDialog(null, "ADMIN DOIT PRECISER UN MAGASIN PRINCIPAL PAR DEFAUT !!") ;
        }else{
         
    this.stock1 = 0 ;
    this.article = "" ;
    this.qt = 0 ;
    this.pu = 0 ;
    this.montant = 0 ;
    this.f = "" ;
    this.sf = "" ;
    this.idpro = 0 ;
    this.pa = 0 ;
    this.profil = 0 ;
    this.mu = 0 ;
    this.rapport = "" ;
    
    this.jTable2.clearSelection() ;
    this.jTable3.clearSelection() ;
    this.jTable4.clearSelection() ;
    this.id2.setText("0");
    this.id3.setText("0");
    this.id4.setText("0");
    this.type = 0 ;
    
    if(this.jTable1.getSelectedRow() == -1){
        
    }else{
        
        // this.id1.setText(f);
        
        this.article = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString().replaceAll("'", "''") ;
         this.pa = Long.parseLong(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()) ;
          this.pu = Long.parseLong(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString()) ;
          
          
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
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
       sql= "SELECT * FROM produits_f WHERE description = '"+this.article.replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
          this.f = rs.getString("f");
          this.sf = rs.getString("sf") ;
          this.idpro = rs.getInt("id") ;
          this.rapport = rs.getString("unite_m") ;
          this.type = 0 ;
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
     
      String sql1 ;
      
       sql1 = "SELECT * FROM matieres_p WHERE description = '"+this.article.replaceAll("'", "''")+"'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1);
      
      
     while(rs1.next()){
        
        
          this.f = rs1.getString("condition_livraison");
          this.sf = rs1.getString("conservation") ;
          this.idpro = rs1.getLong("id") ;
          this.rapport = rs1.getString("unite_mesure") ;
          this.type = 1 ;
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
     
     sql = "select description , stock_dispo, prx_pm , derive_pl.id as ref , produit from stock_pl , derive_pl where stock_pl.description = '"+this.article.replaceAll("'", "''")+"' and derive_pl.produit = "
                + "stock_pl.description " ;
        rs = stmt.executeQuery(sql) ;
        while(rs.next()){
             
              this.f =  "PRODUIT DERIVE" ;
              this.sf = "PRODUIT DERIVE" ;
              this.idpro = rs.getInt("ref") ;
              this.rapport = "vide" ; 
              this.type = 2 ;
         //   this.stock1 = rs.getLong("stock_dispo") ; 
            
        }
     
        String sql2 ;
      
       sql2 = "SELECT * FROM stock1 WHERE desi = '"+this.article.replaceAll("'", "''")+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
     while(rs2.next()){
        
        this.stock1 = rs2.getLong("stock") ;  
       
     }
     
      this.qten = 0 ;
      String sqln ;
      
       sqln= "SELECT sum(qte) FROM prodmp WHERE nom = '"+this.nom.replaceAll("'", "''")+"' AND n = "+this.n+" AND article = '"+this.article+"' GROUP BY article ORDER BY article asc" ;
      
       ResultSet rsn = stmt.executeQuery(sqln);
      
      
     while(rsn.next()){
        
        
    this.qten = rsn.getLong("sum(qte)") ;
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
     
     
     
     this.stock.setText(String.valueOf(this.stock1)) ;
     
     this.id1.setText(String.valueOf(this.idpro));
     
     
     
     if(Integer.parseInt(this.id1.getText()) > 0 || Integer.parseInt(this.stock.getText()) > 0){
         
     }else{
         JOptionPane.showMessageDialog(this, "veillez reselectionner ou utiliser la touche entre pour selectionner vos produits svp / Stock epuisé pour le produit");
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
    
    
    
        
        
        }   
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseReleased
        // TODO add your handling code here:
        
        
        if(this.jTable3.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Veillez reselectionner svp");
        }else{
             this.id3.setText(this.jTable3.getValueAt(this.jTable3.getSelectedRow() , 1).toString()) ;
        
        
        this.jTable1.clearSelection() ;
        this.jTable2.clearSelection() ;
        this.jTable4.clearSelection() ;
        this.id1.setText("0"); 
        this.id2.setText("0");
        this.id4.setText("0") ;
        
        // "Description", "QTE", "P.U", "Montant"
        
      
        
        
        
        
        }
        
        
        
        
    }//GEN-LAST:event_jTable3MouseReleased

    private void activityMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activityMouseReleased
        // TODO add your handling code here:
      
         /*
             
        //deb
           
        String act = this.activity.getSelectedItem().toString().replaceAll("'", "''") ;
        
         if("CHOISIR UNE PRODUCTION".equalsIgnoreCase(act)){
           //  JOptionPane.showMessageDialog(this, "Choisir une prodction svp") ;
         }else{
             
             String dt = "" ;
             SimpleDateFormat sdf10 = new SimpleDateFormat("yyyy-MM-dd") ;
             
             SessionFactory sf = new Configuration().configure().buildSessionFactory();
             Session s = sf.openSession() ;
             
       
         List lib = s.createSQLQuery("SELECT * FROM prod WHERE nom = '"+act.replaceAll("'", "''")+"' AND status = 'ouverte'").list() ;
         List lib1 = s.createSQLQuery("SELECT * FROM prod WHERE nom = '"+act.replaceAll("'", "''")+"' AND status = 'ouverte' AND dtec LIKE '%"+sdf10.format(new Date())+"%'").list() ;
            
               // verification if qery is ok
            
            if(lib.size() == 1 || lib.size() > 0){
                
           // Question :
                
                if (JOptionPane.showConfirmDialog(null, lib.size()+" ACTIVITE(S) "+act+" en gros est dejà en cours et "+lib1.size()+" ACTIVITE(S) "+act+" aujourd'hui est dejà en cours : Question voulez vous continuer ?", "Demande",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                               // yes option
                    
                                this.nom = "" ;
                                this.nom = act ;
                                this.n = 0 ;
                                this.groupe = "" ;
                                
                                // chargement
                                
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
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
       sql= "SELECT * FROM activite_t WHERE description = '"+this.nom+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        this.groupe = rs.getString("libelle") ;
        
       
     }
     
     String sql1 = "" ;
      sql1 = "SELECT count(*) FROM prod WHERE nom = '"+this.nom+"'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
     while(rs1.next()){
        
        this.n = (rs1.getInt(1)+1) ;
        
       
     }
     
     
     DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
     dtm1.setRowCount(0) ;
     
      String sql2 ;
      
       sql2 = "SELECT * FROM pmp WHERE nomp = '"+this.nom+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
     while(rs2.next()){
        // "Description", "P.A", "P.V"
         
       dtm1.addRow(new Object[]{
           
       rs2.getString("article") , rs2.getLong("pa") , rs2.getLong("pv")
       
       });
        
       
     }
      
    
          // code patient 
      
     
     DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
     dtm2.setRowCount(0) ;
     
      String sql3 ;
      
       sql3 = "SELECT * FROM ppf WHERE nomp = '"+this.nom+"'" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3);
      
      
     while(rs3.next()){
        // "Description", "P.A", "P.V"
         
       dtm2.addRow(new Object[]{
           
       rs3.getString("article") , rs3.getLong("pa") , rs3.getLong("pu")
       
       });
        
       
     }
      
    
          // code patient 
      
     
     this.dtec = "" ;
     SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
     this.dtec = sdf.format(new Date()) ;
       
       
     this.nom1.setText("Production : "+" "+this.nom) ;
     this.n1.setText("N° : "+" "+this.n) ;
     this.dte.setText("DATE : "+" "+this.dtec) ;
     this.op.setText("Operateur : "+" "+this.login) ;
     this.stat1.setText("STATUT : "+" "+"nouvelle production / ouverte") ;
     this.nbc.setText("NOMBRE EN COURS : "+" "+(lib.size()+1)) ;
     
     
     
            
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
     
        
                                
                                
                                // end
                                
                                
                                
                    
                   } else {
                              // no option
                    
                      }
                
                
            }else{
                
                // chargement sans question :
                
                                this.nom = "" ;
                                this.nom = act ;
                                this.n = 0 ;
                                this.groupe = "" ;
                                
                                // chargement
                                
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
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
       sql= "SELECT * FROM activite_t WHERE description = '"+this.nom+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        this.groupe = rs.getString("libelle") ;
        
       
     }
     
     String sql1 = "" ;
      sql1 = "SELECT count(*) FROM prod WHERE nom = '"+this.nom+"'" ;
      
       ResultSet rs1 = stmt.executeQuery(sql1) ;
      
      
     while(rs1.next()){
        
        this.n = (rs1.getInt(1)+1) ;
        
       
     }
     
     
     DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
     dtm1.setRowCount(0) ;
     
      String sql2 ;
      
       sql2 = "SELECT * FROM pmp WHERE nomp = '"+this.nom+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
     while(rs2.next()){
        // "Description", "P.A", "P.V"
         
       dtm1.addRow(new Object[]{
           
       rs2.getString("article") , rs2.getLong("pa") , rs2.getLong("pv")
       
       });
        
       
     }
      
    
          // code patient 
      
     
     DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
     dtm2.setRowCount(0) ;
     
      String sql3 ;
      
       sql3 = "SELECT * FROM ppf WHERE nomp = '"+this.nom+"'" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3);
      
      
     while(rs3.next()){
        // "Description", "P.A", "P.V"
         
       dtm2.addRow(new Object[]{
           
       rs3.getString("article") , rs3.getLong("pa") , rs3.getLong("pu")
       
       });
        
       
     }
      
    
          // code patient 
      
     
     this.dtec = "" ;
     SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
     this.dtec = sdf.format(new Date()) ;
       
     this.nom1.setText("Production : "+" "+this.nom) ;
     this.n1.setText("N° : "+" "+this.n) ;
     this.dte.setText("DATE : "+" "+this.dtec) ;
     this.op.setText("Operateur : "+" "+this.login) ;
     this.stat1.setText("STATUT : "+" "+"nouvelle production / ouverte") ;
     this.nbc.setText("NOMBRE EN COURS : "+" "+(lib.size()+1)) ;
     
     
            
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
             
             
             
         }
        
        
        
        
        */
        
        
    }//GEN-LAST:event_activityMouseReleased

    private void activityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_activityKeyReleased
        // TODO add your handling code here:
        
        
      
        
        
    }//GEN-LAST:event_activityKeyReleased

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
        if(this.stock_1.isEmpty()){
            JOptionPane.showMessageDialog(null, "ADMIN DOIT DECLARER UN MAGASIN PRINCIPAL PAR DEFAUT !!!") ;
        }else{
            
    this.stock1 = 0 ;
    this.article = "" ;
    this.qt = 0 ;
    this.pu = 0 ;
    this.montant = 0 ;
    this.f = "" ;
    this.sf = "" ;
    this.idpro = 0 ;
    this.pa = 0 ;
    this.profil = 0 ;
    this.mu = 0 ;
    this.rapport = "" ;
    
    this.jTable1.clearSelection() ;
    this.jTable3.clearSelection() ;
    this.jTable4.clearSelection() ;
    this.id1.setText("0"); 
    this.id3.setText("0");
    this.id4.setText("0") ;
    
    if(this.jTable2.getSelectedRow() == -1){
        
    }else{
        
        // this.id1.setText(f);
        
        this.article = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString() ;
         this.pa = Long.parseLong(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString()) ;
          this.pu = Long.parseLong(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 2).toString()) ;
          
          
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
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
       sql= "SELECT * FROM produits_f WHERE description = '"+this.article.replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
        
          this.f = rs.getString("f");
          this.sf = rs.getString("sf") ;
          this.idpro = rs.getInt("id") ;
          this.rapport = rs.getString("unite_m") ;
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
     
      
      String sql2 ;
      
       sql2 = "SELECT * FROM stock1 WHERE desi = '"+this.article.replaceAll("'", "''")+"' AND maga = '"+this.stock_1.replaceAll("'", "''")+"'" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2);
      
      
     while(rs2.next()){
        
        this.stock1 = rs2.getLong("stock") ;  
       
     }
     
     
     this.id2.setText(String.valueOf(this.idpro)) ;
     
     
     
     if(Integer.parseInt(this.id2.getText()) > 0){
         
     }else{
         JOptionPane.showMessageDialog(this, "veillez reselectionner ou utiliser la touche entre pour selectionner vos produits svp / Stock epuisé pour le produit");
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
    
    
    
        
        
        
   }   
        
        
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void nop2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nop2ActionPerformed
        // TODO add your handling code here:
        
        if(this.vy == 0 || this.vy == 2){
            
        
         if(Integer.parseInt(this.id2.getText()) > 0){
         
    
      
        
        String qt = this.qt2.getText().trim() ;
        
        if("".equals(qt) || "0".equals(qt) || this.product.getSelectedItem().toString().equalsIgnoreCase("CHOISIR PRODUCTEUR")){
            JOptionPane.showMessageDialog(this, "Saisir la quantité , choisir le magasin et le producteur svp ") ;
        }else{
            long qt10 = 0 ;
            qt10 = Long.parseLong(qt) ;
            
               this.newStock = 0 ;
                   if(this.stock1 >= 0){
                       
                  if(qt10 > 0){
                             this.newStock = (this.stock1 + qt10) ;
                       }else if(qt10 < 0){
                           long qt11 = Math.abs(qt10) ;
                             this.newStock = (this.stock1 - qt11) ;
                       }else if(qt10 == 0){
                           JOptionPane.showMessageDialog(this, "Operation impossible") ;
                       }
                 
                   if("oui".equalsIgnoreCase(this.rapport)){
                       double qt00 = 0.0 ;
                              qt00 = (qt10/1000.0) ;
                              double mt = 0.0 ;
                                     mt = (this.pa * qt00) ;
                                     this.montant = Math.round(mt) ;
                                     
                                     if(this.verify_2 == 0 ){
                                         
                                         DefaultTableModel dtm4 = (DefaultTableModel) this.jTable4.getModel() ;
                                         dtm4.setRowCount(0);
                                         
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0")) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 2 ;
                                      
                                      this.rec.setText(String.valueOf( (Integer.parseInt(this.rec.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( (Integer.parseInt(this.rec.getText()) - Integer.parseInt(this.dep.getText())) ) ) ;
                                    
                                      dtm4.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pa , this.montant
                                      }) ;
                                      
                                      this.verify_2 = 1 ;
                                      this.an2.setEnabled(true);
                                      
                                     }else{
                                         
                                         DefaultTableModel dtm4 = (DefaultTableModel) this.jTable4.getModel() ;
                                          
                                         
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0")) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 2 ;
                                      
                                      this.rec.setText(String.valueOf( (Integer.parseInt(this.rec.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( (Integer.parseInt(this.rec.getText()) - Integer.parseInt(this.dep.getText())) ) ) ;
                                    
                                      dtm4.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pa , this.montant
                                      }) ;
                                      
                                    
                                         
                                     }
                                     
                                      
                                      /*
                                      DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                                      dtm2.removeRow(this.jTable2.getSelectedRow()) ;
                                      */
                                      
                                      this.jTable1.clearSelection();
                                      this.jTable2.clearSelection();
                                      this.jTable3.clearSelection();
                                      this.jTable4.clearSelection();
                                      
                           
                   }else{
                       double qt00 = 0.0 ;
                              qt00 = qt10 ;
                              double mt = 0.0 ;
                                     mt = (this.pa * qt00) ;
                                     this.montant = Math.round(mt) ;
                                        if(this.verify_2 == 0 ){
                                         
                                         DefaultTableModel dtm4 = (DefaultTableModel) this.jTable4.getModel() ;
                                         dtm4.setRowCount(0);
                                         
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0")) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 2 ;
                                      
                                      this.rec.setText(String.valueOf( (Integer.parseInt(this.rec.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( (Integer.parseInt(this.rec.getText()) - Integer.parseInt(this.dep.getText())) ) ) ;
                                    
                                      
                                      dtm4.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pa , this.montant
                                      }) ;
                                      
                                      this.verify_2 = 1 ;
                                      this.an2.setEnabled(true);
                                      
                                     }else{
                                         
                                         DefaultTableModel dtm4 = (DefaultTableModel) this.jTable4.getModel() ;
                                          
                                         
                           ProdmpList pmpl = new ProdmpList(this.nom, this.n, this.article, qt10, this.pu, this.montant, new Date(), this.login , this.f, this.sf, this.idpro, this.pa, this.profil, this.mu, this.newStock, Long.parseLong("0")) ;          
                                      this.list_mp_newOp.add(pmpl) ;
                                      this.vy = 2 ;
                                      
                                      this.rec.setText(String.valueOf( (Integer.parseInt(this.rec.getText()) + this.montant) ) ) ;
                                      this.profit.setText(String.valueOf( (Integer.parseInt(this.rec.getText()) - Integer.parseInt(this.dep.getText())) ) ) ;
                                    
                                      
                                      dtm4.addRow(new Object[]{
                                      // "Description", "QTE", "P.U", "Montant"
                                          this.article , qt10 , this.pa , this.montant
                                      }) ;
                                      
                                    
                                         
                                     }
                                     
                                      
                                     
                           /*
                        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                                      dtm2.removeRow(this.jTable2.getSelectedRow()) ;
                             */
       
                                      this.jTable1.clearSelection();
                                      this.jTable2.clearSelection();
                                      this.jTable3.clearSelection();
                                      this.jTable4.clearSelection();
                           
                   }
                 
                 
                   }else{
                       JOptionPane.showMessageDialog(this, "le stock est insuffisant") ;
                   }
            
        }
              this.id2.setText("0") ;
              this.qt2.setText("");
         }else{
         JOptionPane.showMessageDialog(this, "veillez reselectionner ou utiliser la touche entre pour selectionner vos produits svp");
     }
        
        
        
        }else{
            JOptionPane.showMessageDialog(this, "Valider les matieres primaires d'abord merci !!") ;
        }
        
    }//GEN-LAST:event_nop2ActionPerformed

    private void jTable4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseReleased
        // TODO add your handling code here:
        
        
          
        if(this.jTable4.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Veillez reselectionner svp");
        }else{
             this.id4.setText(this.jTable4.getValueAt(this.jTable4.getSelectedRow() , 1).toString()) ;
        
        
        this.jTable1.clearSelection() ;
        this.jTable2.clearSelection() ;
        this.jTable3.clearSelection() ;
        this.id1.setText("0"); 
        this.id2.setText("0");
        this.id3.setText("0") ;
        
        // "Description", "QTE", "P.U", "Montant"
        
      
        
        
        
        
        }
        
        
        
        
        
    }//GEN-LAST:event_jTable4MouseReleased

    private void an2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_an2ActionPerformed
        // TODO add your handling code here:
        
        
          if(Integer.parseInt(this.id4.getText()) > 0 || Integer.parseInt(this.id4.getText()) < 0 ){
      DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
      DefaultTableModel dtm4 = (DefaultTableModel) this.jTable4.getModel() ;
      this.list_mp_newOp.remove(this.jTable4.getSelectedRow()) ;
      
      
      this.vy = 2 ;
      
      
       
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
      
    //     DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
         
      /*
      String sql ;
      
       sql= "SELECT * FROM produits_f WHERE description = '"+this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 0).toString().replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
        
         dtm2.addRow(new Object[]{rs.getString("description"),rs.getLong("libelle"),rs.getLong("pu")}) ;
       
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
    
     */
    
            
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
     
        
   //   this.dep.setText(String.valueOf( (Integer.parseInt(this.dep.getText()) - Integer.parseInt(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3).toString()) ) )) ;
    
this.rec.setText(String.valueOf( (Integer.parseInt(this.rec.getText()) - Integer.parseInt(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 3).toString())) ) ) ;
this.profit.setText(String.valueOf( (Integer.parseInt(this.rec.getText()) - Integer.parseInt(this.dep.getText())) ) ) ;
                               
      dtm4.removeRow(this.jTable4.getSelectedRow()) ;
      
      
           
      
      this.id4.setText("0") ;
         
        }else{
            JOptionPane.showMessageDialog(this, "Veillez reselectionner svp");
            
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_an2ActionPerformed

    private void productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productActionPerformed
        // TODO add your handling code here:
        
        this.idProduct = 0 ;
        
        
         Connection conn = null ;
         Statement stmt = null ;
       
       try{
      Class.forName(JDBC_DRIVER);
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      
     String sql ;
      // "ID", "Producteur / Groupe Producteur", "Date", "Utilisateur"
       sql = "SELECT distinct id FROM productaire WHERE producteur = '"+this.product.getSelectedItem().toString().replaceAll("'", "''")+"'" ;
       ResultSet rs = stmt.executeQuery(sql) ;
    
       while(rs.next()){
        
        
      this.idProduct = rs.getInt("productaire.id") ;
    
         
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
        
        
    }//GEN-LAST:event_productActionPerformed

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
            java.util.logging.Logger.getLogger(NewProd11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewProd11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewProd11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewProd11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewProd11().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox activity;
    private javax.swing.JButton an1;
    private javax.swing.JButton an2;
    private javax.swing.JLabel d1;
    private javax.swing.JTextField dep;
    private javax.swing.JTextField desc;
    private javax.swing.JLabel dte;
    private javax.swing.JTextField id1;
    private javax.swing.JTextField id2;
    private javax.swing.JTextField id3;
    private javax.swing.JTextField id4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JComboBox mag;
    private javax.swing.JLabel n1;
    private javax.swing.JLabel nbc;
    private javax.swing.JLabel nom1;
    private javax.swing.JButton nop1;
    private javax.swing.JButton nop2;
    private javax.swing.JLabel op;
    private javax.swing.JLabel p1;
    private javax.swing.JButton print;
    private javax.swing.JComboBox product;
    private javax.swing.JTextField profit;
    private javax.swing.JTextField qt1;
    private javax.swing.JTextField qt2;
    private javax.swing.JLabel r1;
    private javax.swing.JTextField rec;
    private javax.swing.JLabel stat1;
    private javax.swing.JTextField stock;
    private javax.swing.JButton v1;
    private javax.swing.JButton v2;
    private javax.swing.JButton vprod;
    // End of variables declaration//GEN-END:variables
}
