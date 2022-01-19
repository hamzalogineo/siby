/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;


import static IHM.Arrivage.JDBC_DRIVER;
import static IHM.Menu_at_.JDBC_DRIVER;
import static IHM.Py_cr.JDBC_DRIVER;
import collection.Detail_op;
import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.PopupListener;
import com.inet.jortho.SpellChecker;
import com.inet.jortho.SpellCheckerOptions;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
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
 * @author HAMZA
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/tp3_siby" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
      static final String JDBC_DRIVERT = "com.mysql.jdbc.Driver" ;  
      static final String DB_URLT = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USERT = "root" ;
      static final String PASST = "interco" ;
      
      
    String user_c ;
    String role ;
    String phone ;
    String nom_c ;
    String pos ;
    
    long id_ss = 0 ;
    Integer balance = 0 ;
    
    InetAddress ip ;
    String hostUser ;
    String debutJour;
    String dateExpi;
    
    
    List<String> list_desi = new ArrayList();
    List<Integer> list_pu = new ArrayList();
    List<Integer> list_stockMini = new ArrayList();
     
    
    
  SimpleDateFormat sdf_mysql = new SimpleDateFormat("yyyy-MM-dd") ;
  SimpleDateFormat sdf_mysql_ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
  SimpleDateFormat sdf_java = new SimpleDateFormat("dd-MM-yyyy") ;
  SimpleDateFormat sdf_java_ = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
  
  
      String userDictionaryPath = "/dico_fr/" ;
      Suggestion1 sg = new Suggestion1() ;
      
      
           private ArrayList<Detail_op> list = new ArrayList<Detail_op>() ;
           private ArrayList<String> list_vy = new ArrayList<String>() ;
      
           Integer mtt = 0 ;
           
           List mlist1 ;
           
           List mlist2 ;
           List mlist3 ;
           List mlist4 ;
      
           int v_s = 0 ;
    
    public Menu() {
        
        //this.setLocation(15, 10);
        
        initComponents();
        this.setLocationRelativeTo(null);
        
        DateFormat datef = new SimpleDateFormat("yyyy-MM-dd") ;
        this.debutJour = datef.format(new Date()) ;
        
       
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
                  
                   //  ---------  3è choix
              
        
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
        
        
         this.jTable21.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable21.getTableHeader().setOpaque(false); 
            this.jTable21.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable21.getTableHeader().setForeground(Color.white) ;
        
              this.jTable21.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable21.getModel().getColumnCount(); i++) {
                    this.jTable21.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
                  
                     this.jTable22.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable22.getTableHeader().setOpaque(false); 
            this.jTable22.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable22.getTableHeader().setForeground(Color.white) ;
        
              this.jTable22.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable22.getModel().getColumnCount(); i++) {
                    this.jTable22.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
                  
                       
                     this.jTable23.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable23.getTableHeader().setOpaque(false); 
            this.jTable23.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable23.getTableHeader().setForeground(Color.white) ;
        
              this.jTable23.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable23.getModel().getColumnCount(); i++) {
                    this.jTable23.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
        
          this.jTable24.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable24.getTableHeader().setOpaque(false); 
            this.jTable24.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable24.getTableHeader().setForeground(Color.white) ;
        
              this.jTable24.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable24.getModel().getColumnCount(); i++) {
                    this.jTable24.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                    this.jTable25.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable25.getTableHeader().setOpaque(false); 
            this.jTable25.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable25.getTableHeader().setForeground(Color.white) ;
        
              this.jTable25.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable25.getModel().getColumnCount(); i++) {
                    this.jTable25.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                     
                    this.jTable26.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable26.getTableHeader().setOpaque(false); 
            this.jTable26.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable26.getTableHeader().setForeground(Color.white) ;
        
              this.jTable26.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable26.getModel().getColumnCount(); i++) {
                    this.jTable26.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
        
         this.jTable27.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable27.getTableHeader().setOpaque(false); 
            this.jTable27.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable27.getTableHeader().setForeground(Color.white) ;
        
              this.jTable27.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable27.getModel().getColumnCount(); i++) {
                    this.jTable27.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                   this.jTable28.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable28.getTableHeader().setOpaque(false); 
            this.jTable28.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable28.getTableHeader().setForeground(Color.white) ;
        
              this.jTable28.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable28.getModel().getColumnCount(); i++) {
                    this.jTable28.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                   this.jTable29.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable29.getTableHeader().setOpaque(false); 
            this.jTable29.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable29.getTableHeader().setForeground(Color.white) ;
        
              this.jTable29.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable29.getModel().getColumnCount(); i++) {
                    this.jTable29.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                   this.jTable13.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable13.getTableHeader().setOpaque(false); 
            this.jTable13.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable13.getTableHeader().setForeground(Color.white) ;
        
              this.jTable13.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable13.getModel().getColumnCount(); i++) {
                    this.jTable13.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                    this.jTable15.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable15.getTableHeader().setOpaque(false); 
            this.jTable15.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable15.getTableHeader().setForeground(Color.white) ;
        
              this.jTable15.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable15.getModel().getColumnCount(); i++) {
                    this.jTable15.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                    this.jTable16.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable16.getTableHeader().setOpaque(false); 
            this.jTable16.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable16.getTableHeader().setForeground(Color.white) ;
        
              this.jTable16.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable16.getModel().getColumnCount(); i++) {
                    this.jTable16.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                    this.jTable18.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable18.getTableHeader().setOpaque(false); 
            this.jTable18.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable18.getTableHeader().setForeground(Color.white) ;
        
              this.jTable18.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable18.getModel().getColumnCount(); i++) {
                    this.jTable18.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
        
                    this.jTable19.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable19.getTableHeader().setOpaque(false); 
            this.jTable19.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable19.getTableHeader().setForeground(Color.white) ;
        
              this.jTable19.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable19.getModel().getColumnCount(); i++) {
                    this.jTable19.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                    this.jTable20.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable20.getTableHeader().setOpaque(false); 
            this.jTable20.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable20.getTableHeader().setForeground(Color.white) ;
        
              this.jTable20.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable20.getModel().getColumnCount(); i++) {
                    this.jTable20.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                  
       //   ---------------
        
        
        //
        
       
        
     
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
        DefaultTableModel dtm21 = (DefaultTableModel) this.jTable21.getModel() ;
        DefaultTableModel dtm22 = (DefaultTableModel) this.jTable22.getModel() ;
        DefaultTableModel dtm23 = (DefaultTableModel) this.jTable23.getModel() ;
        DefaultTableModel dtm24 = (DefaultTableModel) this.jTable24.getModel() ;
        DefaultTableModel dtm25 = (DefaultTableModel) this.jTable25.getModel() ;
        DefaultTableModel dtm26 = (DefaultTableModel) this.jTable26.getModel() ;
        
        DefaultTableModel dtm27 = (DefaultTableModel) this.jTable27.getModel() ;
        DefaultTableModel dtm28 = (DefaultTableModel) this.jTable28.getModel() ;
        DefaultTableModel dtm29 = (DefaultTableModel) this.jTable29.getModel() ;
        
        DefaultTableModel dtm13 = (DefaultTableModel) this.jTable13.getModel() ;
        
         DefaultTableModel dtm15 = (DefaultTableModel) this.jTable15.getModel() ;
         DefaultTableModel dtm16 = (DefaultTableModel) this.jTable16.getModel() ;
         DefaultTableModel dtm18 = (DefaultTableModel) this.jTable18.getModel() ;
         DefaultTableModel dtm19 = (DefaultTableModel) this.jTable19.getModel() ;
         DefaultTableModel dtm20 = (DefaultTableModel) this.jTable20.getModel() ;
                          
                           dtm.setRowCount(0) ;
                           dtm2.setRowCount(0) ;
                           dtm3.setRowCount(0) ;
                           
                           dtm21.setRowCount(0) ;
                           dtm22.setRowCount(0) ;
                           dtm23.setRowCount(0) ;
                           
                           dtm24.setRowCount(0) ;
                           dtm25.setRowCount(0) ;
                           dtm26.setRowCount(0) ;
                           
                           
                           dtm27.setRowCount(0) ;
                           dtm28.setRowCount(0) ;
                           dtm29.setRowCount(0) ;
                           
                           dtm13.setRowCount(0) ;
                           
                           dtm15.setRowCount(0) ;
                           dtm16.setRowCount(0) ;
                           
                           dtm18.setRowCount(0) ;
                           
                           dtm19.setRowCount(0) ;
                           dtm20.setRowCount(0) ;
                           
                           
                           
                           
                           
                           
                           
                           
        
                           


        
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
      
       sql= "SELECT description, pu, stockMini FROM produits_f WHERE stockMini > 0" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
         
         list_desi.add(rs.getString("description"));
         list_pu.add(rs.getInt("pu"));
         list_stockMini.add(rs.getInt("stockMini"));
         
     }
      
        
        
        String sql1 ;
      
       sql1 = "SELECT description, prx_a_unite, stockMini FROM matieres_p WHERE stockMini > 0 ORDER BY description " ;
      
       ResultSet rs1 = stmt.executeQuery(sql1);
      
      
     while(rs1.next()){
         
         list_desi.add(rs1.getString("description"));
         list_pu.add(rs1.getInt("prx_a_unite"));
         list_stockMini.add(rs1.getInt("stockMini"));
         
     }
      
     
      String sql3 ;
      
      for (int i = 0; i < list_desi.size() && i < list_stockMini.size() ; i++) {
          sql3 = "SELECT * FROM stock1 WHERE desi = '"+list_desi.get(i)+"' AND stock <= "+list_stockMini.get(i)+" ORDER BY desi " ;
          ResultSet rs3 = stmt.executeQuery(sql3);
      
      
     while(rs3.next()){
         
     }
      } 
      
      
      
      
      
      
       
         
       
       
         String sql2 ;
      
       sql2 = "SELECT * FROM stock1 WHERE date_expiMoins15 <= '"+this.debutJour+"' ORDER BY desi " ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
       while (rs2.next()){
           
     }
       
        
         
      
    
      try{
        // security :
       
         ip = InetAddress.getLocalHost() ;
         hostUser = ip.getHostName() ;
         
         System.out.println("IP adresse : "+" "+this.ip) ;
         System.out.println("Computer used name : "+" "+this.hostUser) ;
       
       //  security :
                 }catch(Exception e){
                     System.out.println("test security error");
                 }
      
    
            
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
      
       
       
       
       
       
       // SET DICTIONARY PROVIDER FROM DICTIONARY PATH
   SpellChecker.setUserDictionaryProvider(new FileUserDictionary(userDictionaryPath)) ;
   

      //REGISTER DICTIONARY
  SpellChecker.registerDictionaries(getClass().getResource(userDictionaryPath), "fr") ;
 
 SpellChecker.register(desc) ;
 
 

     configurePopUp() ;
 
        
        desc.setText("");
        
        
        
        
    }

    
    
    // constructor with param :
    
    
     public Menu(String nom_c) {
        //this.setLocation(15, 10);
          this.nom_c = nom_c ;
          this.setTitle("BIENVENUE  "+this.nom_c) ;
         
        // this.setTitle("WELCOME") ;
         
        initComponents();
        
        
        this.setLocationRelativeTo(null);
        
        DateFormat datef = new SimpleDateFormat("yyyy-MM-dd") ;
        this.debutJour = datef.format(new Date()) ;
        
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
                  
                   //  ---------  3è choix
              
        
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
        
        
         this.jTable21.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable21.getTableHeader().setOpaque(false); 
            this.jTable21.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable21.getTableHeader().setForeground(Color.white) ;
        
              this.jTable21.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable21.getModel().getColumnCount(); i++) {
                    this.jTable21.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
                  
                     this.jTable22.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable22.getTableHeader().setOpaque(false); 
            this.jTable22.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable22.getTableHeader().setForeground(Color.white) ;
        
              this.jTable22.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable22.getModel().getColumnCount(); i++) {
                    this.jTable22.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
                  
                       
                     this.jTable23.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable23.getTableHeader().setOpaque(false); 
            this.jTable23.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable23.getTableHeader().setForeground(Color.white) ;
        
              this.jTable23.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable23.getModel().getColumnCount(); i++) {
                    this.jTable23.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
        
          this.jTable24.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable24.getTableHeader().setOpaque(false); 
            this.jTable24.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable24.getTableHeader().setForeground(Color.white) ;
        
              this.jTable24.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable24.getModel().getColumnCount(); i++) {
                    this.jTable24.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                    this.jTable25.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable25.getTableHeader().setOpaque(false); 
            this.jTable25.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable25.getTableHeader().setForeground(Color.white) ;
        
              this.jTable25.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable25.getModel().getColumnCount(); i++) {
                    this.jTable25.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                     
                    this.jTable26.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable26.getTableHeader().setOpaque(false); 
            this.jTable26.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable26.getTableHeader().setForeground(Color.white) ;
        
              this.jTable26.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable26.getModel().getColumnCount(); i++) {
                    this.jTable26.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
        
         this.jTable27.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable27.getTableHeader().setOpaque(false); 
            this.jTable27.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable27.getTableHeader().setForeground(Color.white) ;
        
              this.jTable27.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable27.getModel().getColumnCount(); i++) {
                    this.jTable27.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                   this.jTable28.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable28.getTableHeader().setOpaque(false); 
            this.jTable28.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable28.getTableHeader().setForeground(Color.white) ;
        
              this.jTable28.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable28.getModel().getColumnCount(); i++) {
                    this.jTable28.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                   this.jTable29.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable29.getTableHeader().setOpaque(false); 
            this.jTable29.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable29.getTableHeader().setForeground(Color.white) ;
        
              this.jTable29.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable29.getModel().getColumnCount(); i++) {
                    this.jTable29.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                   this.jTable13.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable13.getTableHeader().setOpaque(false); 
            this.jTable13.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable13.getTableHeader().setForeground(Color.white) ;
        
              this.jTable13.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable13.getModel().getColumnCount(); i++) {
                    this.jTable13.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                    this.jTable15.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable15.getTableHeader().setOpaque(false); 
            this.jTable15.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable15.getTableHeader().setForeground(Color.white) ;
        
              this.jTable15.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable15.getModel().getColumnCount(); i++) {
                    this.jTable15.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                    this.jTable16.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable16.getTableHeader().setOpaque(false); 
            this.jTable16.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable16.getTableHeader().setForeground(Color.white) ;
        
              this.jTable16.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable16.getModel().getColumnCount(); i++) {
                    this.jTable16.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                    this.jTable18.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable18.getTableHeader().setOpaque(false); 
            this.jTable18.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable18.getTableHeader().setForeground(Color.white) ;
        
              this.jTable18.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable18.getModel().getColumnCount(); i++) {
                    this.jTable18.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
        
                    this.jTable19.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable19.getTableHeader().setOpaque(false); 
            this.jTable19.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable19.getTableHeader().setForeground(Color.white) ;
        
              this.jTable19.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable19.getModel().getColumnCount(); i++) {
                    this.jTable19.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                    this.jTable20.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable20.getTableHeader().setOpaque(false); 
            this.jTable20.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable20.getTableHeader().setForeground(Color.white) ;
        
              this.jTable20.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable16.getModel().getColumnCount(); i++) {
                    this.jTable20.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                  
       //   ---------------
        
        
        //
        
       
        
     
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
        DefaultTableModel dtm21 = (DefaultTableModel) this.jTable21.getModel() ;
        DefaultTableModel dtm22 = (DefaultTableModel) this.jTable22.getModel() ;
        DefaultTableModel dtm23 = (DefaultTableModel) this.jTable23.getModel() ;
        DefaultTableModel dtm24 = (DefaultTableModel) this.jTable24.getModel() ;
        DefaultTableModel dtm25 = (DefaultTableModel) this.jTable25.getModel() ;
        DefaultTableModel dtm26 = (DefaultTableModel) this.jTable26.getModel() ;
        
        DefaultTableModel dtm27 = (DefaultTableModel) this.jTable27.getModel() ;
        DefaultTableModel dtm28 = (DefaultTableModel) this.jTable28.getModel() ;
        DefaultTableModel dtm29 = (DefaultTableModel) this.jTable29.getModel() ;
        
        DefaultTableModel dtm13 = (DefaultTableModel) this.jTable13.getModel() ;
        
         DefaultTableModel dtm15 = (DefaultTableModel) this.jTable15.getModel() ;
         DefaultTableModel dtm16 = (DefaultTableModel) this.jTable16.getModel() ;
         DefaultTableModel dtm18 = (DefaultTableModel) this.jTable18.getModel() ;
         DefaultTableModel dtm19 = (DefaultTableModel) this.jTable19.getModel() ;
         DefaultTableModel dtm20 = (DefaultTableModel) this.jTable20.getModel() ;
                          
                           dtm.setRowCount(0) ;
                           dtm2.setRowCount(0) ;
                           dtm3.setRowCount(0) ;
                           
                           dtm21.setRowCount(0) ;
                           dtm22.setRowCount(0) ;
                           dtm23.setRowCount(0) ;
                           
                           dtm24.setRowCount(0) ;
                           dtm25.setRowCount(0) ;
                           dtm26.setRowCount(0) ;
                           
                           
                           dtm27.setRowCount(0) ;
                           dtm28.setRowCount(0) ;
                           dtm29.setRowCount(0) ;
                           
                           dtm13.setRowCount(0) ;
                           
                           dtm15.setRowCount(0) ;
                           dtm16.setRowCount(0) ;
                           
                           dtm18.setRowCount(0) ;
                           
                           dtm19.setRowCount(0) ;
                           dtm20.setRowCount(0) ;
                           
                           
                           
                           
        
        
        
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
      
       sql= "SELECT description, pu, stockMini FROM produits_f WHERE stockMini > 0" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
         
         list_desi.add(rs.getString("description"));
         list_pu.add(rs.getInt("pu"));
         list_stockMini.add(rs.getInt("stockMini"));
         
     }
      
        
        
        String sql1 ;
      
       sql1 = "SELECT description, prx_a_unite, stockMini FROM matieres_p WHERE stockMini > 0 ORDER BY description " ;
      
       ResultSet rs1 = stmt.executeQuery(sql1);
      
      
     while(rs1.next()){
         
         list_desi.add(rs1.getString("description"));
         list_pu.add(rs1.getInt("prx_a_unite"));
         list_stockMini.add(rs1.getInt("stockMini"));
         
     }
      
     
      String sql3 ;
      
      for (int i = 0; i < list_desi.size() && i < list_stockMini.size() ; i++) {
          sql3 = "SELECT * FROM stock1 WHERE desi = '"+list_desi.get(i)+"' AND stock <= "+list_stockMini.get(i)+" ORDER BY desi " ;
          ResultSet rs3 = stmt.executeQuery(sql3);
      
      
     while(rs3.next()){
         
     }
      } 
      
      
       
         String sql2 ;
      
       sql2 = "SELECT * FROM stock1 WHERE date_expiMoins15 <= '"+this.debutJour+"' ORDER BY desi " ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
       while (rs2.next()){
          
     }
       
        
         
      
    
      try{
        // security :
       
         ip = InetAddress.getLocalHost() ;
         hostUser = ip.getHostName() ;
         
         System.out.println("IP adresse : "+" "+this.ip) ;
         System.out.println("Computer used name : "+" "+this.hostUser) ;
       
       //  security :
                 }catch(Exception e){
                     System.out.println("test security error");
                 }
      
    
            
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
     
 public Menu(String login, String role, String n_c, String pos){
         
         
        //this.setLocation(15, 10) ;
         
        initComponents();
        this.setLocationRelativeTo(null);
        
    this.user_c = login ;
    this.role = role ;
    this.phone = "" ;
    this.nom_c = n_c ;
    this.pos = pos ;
    
    jCheckBox4.setVisible(false) ;
    this.h1.setText("00:00");
    this.h2.setText("23:59");
    
    this.h11.setText("00:00");
    this.h22.setText("23:59");
    
    this.h13.setText("00:00");
    this.h23.setText("23:59");
    
    this.h14.setText("00:00");
    this.h24.setText("23:59");
    
    this.h17.setText("00:00");
    this.h27.setText("23:59");
    
      this.h15.setText("00:00");
      this.h25.setText("23:59");
      
      this.h16.setText("00:00");
      this.h26.setText("23:59");
    
    
         this.log.setText("BIENVENUE : "+this.nom_c) ;
    
         
    
    if(this.role.equalsIgnoreCase("ORDINAIRE")){
        this.bof.setEnabled(false);
    }
    
    
    if(this.role.equalsIgnoreCase("tp3 siby")){
        
        this.jButton24.setVisible(false) ;
        this.jButton31.setVisible(false) ;
        this.jButton53.setVisible(false) ;
        this.jButton54.setVisible(false) ;
        
        
        this.sui1.setVisible(false) ;
    }else{
        this.sui1.setVisible(true);
        }
        
    
        DateFormat datef = new SimpleDateFormat("yyyy-MM-dd") ;
        this.debutJour = datef.format(new Date()) ;
        
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
        
        
        
        
        //  ---------  2� choix
              
        
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
                  
                   //  ---------  3è choix
              
        
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
        
        
         this.jTable21.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable21.getTableHeader().setOpaque(false); 
            this.jTable21.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable21.getTableHeader().setForeground(Color.white) ;
        
              this.jTable21.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable21.getModel().getColumnCount(); i++) {
                    this.jTable21.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
                  
                     this.jTable22.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable22.getTableHeader().setOpaque(false); 
            this.jTable22.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable22.getTableHeader().setForeground(Color.white) ;
        
              this.jTable22.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable22.getModel().getColumnCount(); i++) {
                    this.jTable22.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
                  
                       
                     this.jTable23.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable23.getTableHeader().setOpaque(false); 
            this.jTable23.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable23.getTableHeader().setForeground(Color.white) ;
        
              this.jTable23.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable23.getModel().getColumnCount(); i++) {
                    this.jTable23.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
        
          this.jTable24.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable24.getTableHeader().setOpaque(false); 
            this.jTable24.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable24.getTableHeader().setForeground(Color.white) ;
        
              this.jTable24.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable24.getModel().getColumnCount(); i++) {
                    this.jTable24.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                    this.jTable25.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable25.getTableHeader().setOpaque(false); 
            this.jTable25.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable25.getTableHeader().setForeground(Color.white) ;
        
              this.jTable25.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable25.getModel().getColumnCount(); i++) {
                    this.jTable25.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                     
                    this.jTable26.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable26.getTableHeader().setOpaque(false); 
            this.jTable26.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable26.getTableHeader().setForeground(Color.white) ;
        
              this.jTable26.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable26.getModel().getColumnCount(); i++) {
                    this.jTable26.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
        
         this.jTable27.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable27.getTableHeader().setOpaque(false); 
            this.jTable27.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable27.getTableHeader().setForeground(Color.white) ;
        
              this.jTable27.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable27.getModel().getColumnCount(); i++) {
                    this.jTable27.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                   this.jTable28.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable28.getTableHeader().setOpaque(false); 
            this.jTable28.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable28.getTableHeader().setForeground(Color.white) ;
        
              this.jTable28.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable28.getModel().getColumnCount(); i++) {
                    this.jTable28.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                   this.jTable29.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable29.getTableHeader().setOpaque(false); 
            this.jTable29.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable29.getTableHeader().setForeground(Color.white) ;
        
              this.jTable29.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable29.getModel().getColumnCount(); i++) {
                    this.jTable29.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                   this.jTable13.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable13.getTableHeader().setOpaque(false); 
            this.jTable13.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable13.getTableHeader().setForeground(Color.white) ;
        
              this.jTable13.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable13.getModel().getColumnCount(); i++) {
                    this.jTable13.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                    this.jTable15.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable15.getTableHeader().setOpaque(false); 
            this.jTable15.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable15.getTableHeader().setForeground(Color.white) ;
        
              this.jTable15.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable15.getModel().getColumnCount(); i++) {
                    this.jTable15.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                    this.jTable16.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable16.getTableHeader().setOpaque(false); 
            this.jTable16.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable16.getTableHeader().setForeground(Color.white) ;
        
              this.jTable16.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable16.getModel().getColumnCount(); i++) {
                    this.jTable16.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                    this.jTable18.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable18.getTableHeader().setOpaque(false); 
            this.jTable18.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable18.getTableHeader().setForeground(Color.white) ;
        
              this.jTable18.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable18.getModel().getColumnCount(); i++) {
                    this.jTable18.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
        
                    this.jTable19.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable19.getTableHeader().setOpaque(false); 
            this.jTable19.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable19.getTableHeader().setForeground(Color.white) ;
        
              this.jTable19.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable19.getModel().getColumnCount(); i++) {
                    this.jTable19.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                    this.jTable20.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable20.getTableHeader().setOpaque(false); 
            this.jTable20.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable20.getTableHeader().setForeground(Color.white) ;
        
              this.jTable20.setRowHeight(25) ;
               
                  for (int i = 0; i < this.jTable20.getModel().getColumnCount(); i++) {
                    this.jTable20.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
        
                  
     //   -------------------------------------------------------------------
                  
                  
       //   ---------------
        
        
        //
                  
                  
                  
                   this.jTable16.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 8) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
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

      
        
                  
           this.jTable15.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 4) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
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

      
        
    // -----------------------------------------------X--------------------------------------------------------------
           
                             
        this.jTable19.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 10) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
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

      
        
                  
           this.jTable18.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 4) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
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

      
           
           
           
       //    ---------------
        
                     
                  
        this.jTable20.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 6) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)){
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
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

      
        
        
        
        this.jTable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 9) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
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

      
        
                  
           this.jTable3.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 4) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
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

          
                  
                  
     // suite :  
           
           
           this.jTable23.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 9) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
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

      
        
                  
           this.jTable22.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 4) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
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

          
                  
                  
     // suite :  
        
           
            this.jTable26.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 8) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
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

      
        
                  
           this.jTable24.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 4) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
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

          
                  
                  
     // suite :  
        
           
             this.jTable29.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 9) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
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

      
        
                  
           this.jTable27.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 4) ;

        
        //  System.out.print("Object in list 44 : "+list44.get(0)) ;
        
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
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

          
                  
                  
     // suite :  
      
        
                  
           this.jTable13.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
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

          
                  
                  
     // suite :  
        
           
           
        
     
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
        DefaultTableModel dtm21 = (DefaultTableModel) this.jTable21.getModel() ;
        DefaultTableModel dtm22 = (DefaultTableModel) this.jTable22.getModel() ;
        DefaultTableModel dtm23 = (DefaultTableModel) this.jTable23.getModel() ;
        DefaultTableModel dtm24 = (DefaultTableModel) this.jTable24.getModel() ;
        DefaultTableModel dtm25 = (DefaultTableModel) this.jTable25.getModel() ;
        DefaultTableModel dtm26 = (DefaultTableModel) this.jTable26.getModel() ;
        
        DefaultTableModel dtm27 = (DefaultTableModel) this.jTable27.getModel() ;
        DefaultTableModel dtm28 = (DefaultTableModel) this.jTable28.getModel() ;
        DefaultTableModel dtm29 = (DefaultTableModel) this.jTable29.getModel() ;
        
        DefaultTableModel dtm13 = (DefaultTableModel) this.jTable13.getModel() ;
        
         DefaultTableModel dtm15 = (DefaultTableModel) this.jTable15.getModel() ;
         DefaultTableModel dtm16 = (DefaultTableModel) this.jTable16.getModel() ;
         DefaultTableModel dtm18 = (DefaultTableModel) this.jTable18.getModel() ;
         DefaultTableModel dtm19 = (DefaultTableModel) this.jTable19.getModel() ;
         DefaultTableModel dtm20 = (DefaultTableModel) this.jTable20.getModel() ;
                          
                           dtm.setRowCount(0) ;
                           dtm2.setRowCount(0) ;
                           dtm3.setRowCount(0) ;
                           
                           dtm21.setRowCount(0) ;
                           dtm22.setRowCount(0) ;
                           dtm23.setRowCount(0) ;
                           
                           dtm24.setRowCount(0) ;
                           dtm25.setRowCount(0) ;
                           dtm26.setRowCount(0) ;
                           
                           
                           dtm27.setRowCount(0) ;
                           dtm28.setRowCount(0) ;
                           dtm29.setRowCount(0) ;
                           
                           dtm13.setRowCount(0) ;
                           
                           dtm15.setRowCount(0) ;
                           dtm16.setRowCount(0) ;
                           
                           dtm18.setRowCount(0) ;
                           
                           dtm19.setRowCount(0) ;
                           dtm20.setRowCount(0) ;
                           
                           
                           
                           
        
        
        
       Connection conn = null ;
       Statement  stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVERT);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URLT,USERT,PASST);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
      String sql = null ;
      ResultSet rs = null ;
      
      sql = "select login from comptes_u where role = 'TP3 SIBY' and status = 'activer'" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          this.user.addItem(new String(rs.getString("login"))) ;
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
        
       
       
       
       Connection conn_s = null;
       Statement stmt_s = null;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn_s = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt_s = conn_s.createStatement();
      
      // je crai ma requete
      
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
      
      Date today = new Date() ;
      
      String jour = sdf.format(today) ;
      
      today = sdf.parse(jour) ;
      
      
      Date ds = new Date() ;
      String dss = sdf.format(ds) ;
      ds = sdf.parse(dss) ;
      
      
      
      
      String sql = null ;
      ResultSet rs = null ;
       
      
       String id = "";
       String user = "" ; String date_s = "" ; String fc1 = "" ; String etat = "" ;
       int a = 0 ;
      
       
         
     sql = "select * from session where user = '"+this.user_c+"' and etat = 'OUI'" ;
     rs = stmt_s.executeQuery(sql) ;
     while(rs.next()){
         
          id = rs.getString("id_ss") ;
          user = rs.getString("user") ;
          date_s = this.sdf_java_.format(rs.getTimestamp("date_op")) ;
          fc1 = rs.getString("f_c") ;
          etat = "OUVERT" ;
          
          this.id_ss = rs.getLong("id_ss") ;
          this.balance = rs.getInt("balance") ;
          
          
          a = 1 ;
          
     }
         
  if(a == 1){
          
          this.jLabel5.setText("ID : "+id);
          this.jLabel13.setText("USER : "+user);
          this.jLabel14.setText("DATE OUVERTURE : "+date_s);
          this.jLabel15.setText("FOND DE CAISSE : "+this.nf3.format(Integer.parseInt(fc1)));
          this.jLabel16.setText("ETAT : "+etat);
          
          this.jButton2.setEnabled(true);
          this.v.setEnabled(true);
          this.sav.setEnabled(true);
          this.r.setEnabled(true);
          this.reserv.setEnabled(true);
          this.st.setEnabled(true);
          this.jButton1.setEnabled(false) ;
          this.d_s.setVisible(true) ;
          
  }else if(a == 0){
  
          this.jButton2.setEnabled(false);
          this.v.setEnabled(false);
          this.sav.setEnabled(false);
          this.r.setEnabled(false);
          this.reserv.setEnabled(false);
          this.st.setEnabled(false);
          this.jButton1.setEnabled(true) ;
          this.d_s.setVisible(false) ;
       
  }
      
     
       
      sql = "select date_op from session where user = '"+this.user_c+"' and etat = 'OUI' order by id_ss desc limit 1" ;
      rs = stmt_s.executeQuery(sql) ;
      while(rs.next()){
          
          String d_s = sdf.format(rs.getDate("date_op")) ;
          ds =  sdf.parse(d_s) ;
          
      }
      
      
      
      if(ds.equals(today) == true){
        this.v_s = 0 ;
      }else{
          
        
        
         this.jButton1.setEnabled(true) ;
          
          
          this.v.setEnabled(false);
          this.sav.setEnabled(false);
          this.r.setEnabled(false);
          this.reserv.setEnabled(false);
          this.st.setEnabled(false);
          
          this.jButton1.setEnabled(false); 
          this.jButton2.setEnabled(true);
          
          this.v_s = 1 ;
         
         // 
          
      }
  
  
  
       
      
      
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
     
      rs.close() ;
      stmt_s.close() ;
      conn_s.close() ;
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt_s != null)
            stmt_s.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn_s != null)
            conn_s.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
        
       
     
     // Fin configure :
      
       
        
    }

    
     
     
     
     
      private void configurePopUp(){
         
        SpellCheckerOptions sco = new SpellCheckerOptions() ;
        
        sco.setCaseSensitive(true) ;
        sco.setSuggestionsLimitMenu(15) ;
        sco.setLanguageDisableVisible(true) ;
        sco.setIgnoreAllCapsWords(true) ;
        sco.setIgnoreWordsWithNumbers(true) ;
    JPopupMenu popup = SpellChecker.createCheckerPopup(sco) ;
     
   
    desc.addMouseListener(new PopupListener(popup)) ;
    desc2.addMouseListener(new PopupListener(popup)) ;
    desc3.addMouseListener(new PopupListener(popup)) ;
    desc4.addMouseListener(new PopupListener(popup)) ;
   
    }
    
     public static void changeText(String txt){
        
        int i = desc.getText().lastIndexOf(" ") ;
        
        if(i < 0 ){
             desc.setText(txt) ;
        }else if(i > 0){
            
       String text1 = desc.getText()   ; // .substring(1, (i)) ;
        
        desc.setText(text1+" "+txt) ;
            
        }
        
        
        
        
        int i2 = desc2.getText().lastIndexOf(" ") ;
        
        if(i2 < 0 ){
             desc2.setText(txt) ;
        }else if(i2 > 0){
            
       String text1 = desc2.getText()   ; // .substring(1, (i)) ;
        
        desc2.setText(text1+" "+txt) ;
            
        }
        
        
        int i3 = desc3.getText().lastIndexOf(" ") ;
        
        if(i3 < 0 ){
             desc3.setText(txt) ;
        }else if(i3 > 0){
            
       String text1 = desc3.getText()   ; // .substring(1, (i)) ;
        
        desc3.setText(text1+" "+txt) ;
            
        }
        
        
          int i4 = desc4.getText().lastIndexOf(" ") ;
        
        if(i4 < 0 ){
             desc4.setText(txt) ;
        }else if(i4 > 0){
            
       String text1 = desc4.getText()   ; // .substring(1, (i)) ;
        
        desc4.setText(text1+" "+txt) ;
            
        }
        
        
        
        
     }
     
     
    
    // getter and setter :
    
    public String getUser_c() {
        return user_c;
    }

    public void setUser_c(String user_c) {
        this.user_c = user_c;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLog() {
        return this.log.getText() ;
    }

    public void setLog(String log) {
        this.log.setText(log) ;
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        r = new javax.swing.JButton();
        v = new javax.swing.JButton();
        sav = new javax.swing.JButton();
        s = new javax.swing.JButton();
        reserv = new javax.swing.JButton();
        st = new javax.swing.JButton();
        sui1 = new javax.swing.JButton();
        sui2 = new javax.swing.JButton();
        bof = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        bof1 = new javax.swing.JButton();
        bof2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        log = new javax.swing.JLabel();
        alerteStock = new javax.swing.JLabel();
        alerteExpi = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        center = new javax.swing.JPanel();
        accueil = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        session = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fc = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        d_s = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        vente = new javax.swing.JPanel();
        desc = new javax.swing.JTextField();
        client1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        contact1 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        qte = new javax.swing.JFormattedTextField();
        pu = new javax.swing.JFormattedTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        t1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        du = new datechooser.beans.DateChooserCombo();
        h1 = new javax.swing.JFormattedTextField();
        h2 = new javax.swing.JFormattedTextField();
        au = new datechooser.beans.DateChooserCombo();
        jButton7 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        id = new javax.swing.JFormattedTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        observ = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        service = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        client2 = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        contact2 = new javax.swing.JFormattedTextField();
        jLabel77 = new javax.swing.JLabel();
        id2 = new javax.swing.JFormattedTextField();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        desc2 = new javax.swing.JTextField();
        qte2 = new javax.swing.JFormattedTextField();
        pu2 = new javax.swing.JFormattedTextField();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTable21 = new javax.swing.JTable();
        jButton42 = new javax.swing.JButton();
        observ2 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        t2 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jTable22 = new javax.swing.JTable();
        jScrollPane23 = new javax.swing.JScrollPane();
        jTable23 = new javax.swing.JTable();
        du1 = new datechooser.beans.DateChooserCombo();
        h11 = new javax.swing.JFormattedTextField();
        au1 = new datechooser.beans.DateChooserCombo();
        h22 = new javax.swing.JFormattedTextField();
        jButton43 = new javax.swing.JButton();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        reprise = new javax.swing.JPanel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jTable24 = new javax.swing.JTable();
        jLabel87 = new javax.swing.JLabel();
        client3 = new javax.swing.JTextField();
        contact3 = new javax.swing.JFormattedTextField();
        jLabel88 = new javax.swing.JLabel();
        id3 = new javax.swing.JFormattedTextField();
        jLabel89 = new javax.swing.JLabel();
        desc3 = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        qte3 = new javax.swing.JFormattedTextField();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        pu3 = new javax.swing.JFormattedTextField();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jScrollPane25 = new javax.swing.JScrollPane();
        jTable25 = new javax.swing.JTable();
        jButton46 = new javax.swing.JButton();
        observ3 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        t3 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        jTable26 = new javax.swing.JTable();
        du3 = new datechooser.beans.DateChooserCombo();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        h13 = new javax.swing.JFormattedTextField();
        au3 = new datechooser.beans.DateChooserCombo();
        jLabel97 = new javax.swing.JLabel();
        h23 = new javax.swing.JFormattedTextField();
        jLabel98 = new javax.swing.JLabel();
        jButton47 = new javax.swing.JButton();
        jCheckBox3 = new javax.swing.JCheckBox();
        reservation = new javax.swing.JPanel();
        jScrollPane27 = new javax.swing.JScrollPane();
        jTable27 = new javax.swing.JTable();
        jLabel99 = new javax.swing.JLabel();
        client4 = new javax.swing.JTextField();
        contact4 = new javax.swing.JFormattedTextField();
        jLabel100 = new javax.swing.JLabel();
        id4 = new javax.swing.JFormattedTextField();
        jLabel101 = new javax.swing.JLabel();
        desc4 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        qte4 = new javax.swing.JFormattedTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        pu4 = new javax.swing.JFormattedTextField();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jScrollPane28 = new javax.swing.JScrollPane();
        jTable28 = new javax.swing.JTable();
        jButton50 = new javax.swing.JButton();
        jLabel105 = new javax.swing.JLabel();
        t4 = new javax.swing.JLabel();
        jScrollPane29 = new javax.swing.JScrollPane();
        jTable29 = new javax.swing.JTable();
        du4 = new datechooser.beans.DateChooserCombo();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        h14 = new javax.swing.JFormattedTextField();
        au4 = new datechooser.beans.DateChooserCombo();
        jLabel109 = new javax.swing.JLabel();
        h24 = new javax.swing.JFormattedTextField();
        jLabel110 = new javax.swing.JLabel();
        jButton51 = new javax.swing.JButton();
        observ4 = new javax.swing.JFormattedTextField();
        jButton11 = new javax.swing.JButton();
        jCheckBox4 = new javax.swing.JCheckBox();
        sortie_caisse = new javax.swing.JPanel();
        montant = new javax.swing.JFormattedTextField();
        jLabel43 = new javax.swing.JLabel();
        ref = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        obs = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        du5 = new datechooser.beans.DateChooserCombo();
        h15 = new javax.swing.JFormattedTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        au5 = new datechooser.beans.DateChooserCombo();
        h25 = new javax.swing.JFormattedTextField();
        jLabel50 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        suivi_ope_session = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable15 = new javax.swing.JTable();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTable16 = new javax.swing.JTable();
        du6 = new datechooser.beans.DateChooserCombo();
        jLabel57 = new javax.swing.JLabel();
        h16 = new javax.swing.JFormattedTextField();
        jLabel58 = new javax.swing.JLabel();
        au6 = new datechooser.beans.DateChooserCombo();
        jLabel59 = new javax.swing.JLabel();
        h26 = new javax.swing.JFormattedTextField();
        jLabel60 = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();
        user = new javax.swing.JComboBox();
        op = new javax.swing.JComboBox();
        id6 = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jButton31 = new javax.swing.JButton();
        cl = new javax.swing.JTextField();
        suivi_op_cred = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTable18 = new javax.swing.JTable();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTable19 = new javax.swing.JTable();
        du7 = new datechooser.beans.DateChooserCombo();
        jLabel67 = new javax.swing.JLabel();
        h17 = new javax.swing.JFormattedTextField();
        jLabel68 = new javax.swing.JLabel();
        au7 = new datechooser.beans.DateChooserCombo();
        jLabel69 = new javax.swing.JLabel();
        h27 = new javax.swing.JFormattedTextField();
        jLabel70 = new javax.swing.JLabel();
        jButton39 = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTable20 = new javax.swing.JTable();
        py = new javax.swing.JLabel();
        rl = new javax.swing.JLabel();
        mt = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        ob = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        rch_c = new javax.swing.JTextField();
        autre = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(102, 102, 0));

        jPanel4.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        r.setBackground(new java.awt.Color(0, 51, 51));
        r.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        r.setForeground(new java.awt.Color(255, 255, 255));
        r.setText("REPRISE VENTE");
        r.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rActionPerformed(evt);
            }
        });

        v.setBackground(new java.awt.Color(0, 51, 51));
        v.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        v.setForeground(new java.awt.Color(255, 255, 255));
        v.setText("VENTE DIRECTE");
        v.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vActionPerformed(evt);
            }
        });

        sav.setBackground(new java.awt.Color(0, 51, 51));
        sav.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sav.setForeground(new java.awt.Color(255, 255, 255));
        sav.setText("SERVICE APRES VENTE");
        sav.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savActionPerformed(evt);
            }
        });

        s.setBackground(new java.awt.Color(0, 51, 51));
        s.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        s.setForeground(new java.awt.Color(255, 255, 255));
        s.setText("SESSION");
        s.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sActionPerformed(evt);
            }
        });

        reserv.setBackground(new java.awt.Color(0, 51, 51));
        reserv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        reserv.setForeground(new java.awt.Color(255, 255, 255));
        reserv.setText("VENTE A CREDIT");
        reserv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reserv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservActionPerformed(evt);
            }
        });

        st.setBackground(new java.awt.Color(0, 51, 51));
        st.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        st.setForeground(new java.awt.Color(255, 255, 255));
        st.setText("SORTIE DE CAISSE");
        st.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stActionPerformed(evt);
            }
        });

        sui1.setBackground(new java.awt.Color(0, 51, 51));
        sui1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sui1.setForeground(new java.awt.Color(255, 255, 255));
        sui1.setText("SUIVI OPERATION SESSION");
        sui1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sui1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sui1ActionPerformed(evt);
            }
        });

        sui2.setBackground(new java.awt.Color(0, 51, 51));
        sui2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sui2.setForeground(new java.awt.Color(255, 255, 255));
        sui2.setText("SUIVI OPERATION CREDIT");
        sui2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sui2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sui2ActionPerformed(evt);
            }
        });

        bof.setBackground(new java.awt.Color(0, 51, 51));
        bof.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bof.setForeground(new java.awt.Color(255, 255, 255));
        bof.setText("ARRIVAGE");
        bof.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bofActionPerformed(evt);
            }
        });

        jButton32.setBackground(new java.awt.Color(0, 51, 51));
        jButton32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton32.setForeground(new java.awt.Color(255, 255, 255));
        jButton32.setText("TACHE EN ATELIER");
        jButton32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        bof1.setBackground(new java.awt.Color(0, 51, 51));
        bof1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bof1.setForeground(new java.awt.Color(255, 255, 255));
        bof1.setText("ACCUEIL");
        bof1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bof1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bof1ActionPerformed(evt);
            }
        });

        bof2.setBackground(new java.awt.Color(0, 51, 51));
        bof2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bof2.setForeground(new java.awt.Color(255, 255, 255));
        bof2.setText("ACTUALISER");
        bof2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bof2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bof2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(v, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(s, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reserv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(st, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sui1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sui2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bof, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bof1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bof2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bof1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bof, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(s, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(v, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sav, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reserv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(st, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sui2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sui1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bof2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        log.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        log.setForeground(new java.awt.Color(255, 255, 255));
        log.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        log.setText("CLIENT TP3");

        alerteStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        alerteStock.setForeground(new java.awt.Color(255, 0, 51));
        alerteStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alerteStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alerteStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alerteStockMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                alerteStockMouseReleased(evt);
            }
        });

        alerteExpi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        alerteExpi.setForeground(new java.awt.Color(255, 0, 51));
        alerteExpi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alerteExpi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alerteExpi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alerteExpiMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                alerteExpiMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(alerteStock, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(alerteExpi, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alerteStock)
                    .addComponent(alerteExpi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Copyright � 2021       SIBY CENTER ARS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        center.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MARCHE TP3", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N
        center.setLayout(new java.awt.CardLayout());

        accueil.setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setBackground(new java.awt.Color(51, 102, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("DECONNEXION");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout accueilLayout = new javax.swing.GroupLayout(accueil);
        accueil.setLayout(accueilLayout);
        accueilLayout.setHorizontalGroup(
            accueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, accueilLayout.createSequentialGroup()
                .addContainerGap(959, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        accueilLayout.setVerticalGroup(
            accueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accueilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(481, Short.MAX_VALUE))
        );

        center.add(accueil, "card11");

        session.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FOND DE CAISSE");

        fc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        fc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton1.setBackground(new java.awt.Color(102, 102, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("NOUVELLE SESSION");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("FIN DE SESSION");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        d_s.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMATION DE LA SESSION EN COURS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ID :");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("USER :");
        jLabel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("DATE OUVERTURE :");
        jLabel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("FOND DE CAISSE");
        jLabel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("ETAT : ");
        jLabel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout d_sLayout = new javax.swing.GroupLayout(d_s);
        d_s.setLayout(d_sLayout);
        d_sLayout.setHorizontalGroup(
            d_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_sLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(d_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
                .addContainerGap())
        );
        d_sLayout.setVerticalGroup(
            d_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(d_sLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sessionLayout = new javax.swing.GroupLayout(session);
        session.setLayout(sessionLayout);
        sessionLayout.setHorizontalGroup(
            sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sessionLayout.createSequentialGroup()
                .addContainerGap(485, Short.MAX_VALUE)
                .addGroup(sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fc, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(465, 465, 465))
            .addGroup(sessionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(d_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sessionLayout.setVerticalGroup(
            sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sessionLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(d_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(fc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        center.add(session, "card2");

        vente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VENTE DIRECTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 24))); // NOI18N

        desc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        desc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        desc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descKeyReleased(evt);
            }
        });

        client1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        client1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        client1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CLIENT");

        contact1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            contact1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        contact1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setText("DESCRIPTION");

        qte.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        qte.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        qte.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        pu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pu.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        pu.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton4.setBackground(new java.awt.Color(102, 102, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("AJOUTER");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(102, 102, 0));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("RETIRER");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DESCRIPTION", "QTE", "PU", "MTT"
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
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMinWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(2).setMinWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(3).setMinWidth(90);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        t1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t1.setText("TOTAL :");
        t1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton6.setBackground(new java.awt.Color(102, 102, 0));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("VALIDER");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CONTACT");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("QTE");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("P.U");

        du.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

        h1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h1.setText("00:00");

        h2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h2.setText("23:59");

        au.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("VALIDER");
        jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DU");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("HEURE");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("AU");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("HEURE");

        jTable2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB", "OBSERVATION", "ETAT"
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
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(1).setMinWidth(40);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable2.getColumnModel().getColumn(2).setMinWidth(100);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable2.getColumnModel().getColumn(3).setMinWidth(90);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(90);
            jTable2.getColumnModel().getColumn(7).setMinWidth(0);
            jTable2.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(7).setMaxWidth(0);
            jTable2.getColumnModel().getColumn(8).setMinWidth(0);
            jTable2.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(8).setMaxWidth(0);
            jTable2.getColumnModel().getColumn(9).setMinWidth(0);
            jTable2.getColumnModel().getColumn(9).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(9).setMaxWidth(0);
        }

        jTable3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(1).setMinWidth(40);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable3.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable3.getColumnModel().getColumn(2).setMinWidth(100);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable3.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable3.getColumnModel().getColumn(3).setMinWidth(90);
            jTable3.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable3.getColumnModel().getColumn(3).setMaxWidth(90);
            jTable3.getColumnModel().getColumn(4).setMinWidth(0);
            jTable3.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable3.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        id.setBackground(new java.awt.Color(153, 153, 153));
        id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        id.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idKeyReleased(evt);
            }
        });

        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("ID");

        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("OBSERVATION");

        observ.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        observ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        observ.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setText("IMP.FACTURE");
        jButton9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("C.DEFAUT");
        jCheckBox1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout venteLayout = new javax.swing.GroupLayout(vente);
        vente.setLayout(venteLayout);
        venteLayout.setHorizontalGroup(
            venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(venteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(venteLayout.createSequentialGroup()
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(client1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(contact1))
                        .addGap(55, 55, 55)
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id)
                            .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(du, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h1)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(au, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h2)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(venteLayout.createSequentialGroup()
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(venteLayout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(observ)
                                    .addGroup(venteLayout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 43, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, venteLayout.createSequentialGroup()
                                .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(venteLayout.createSequentialGroup()
                                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, venteLayout.createSequentialGroup()
                                                .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(venteLayout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(jLabel3)
                                                .addGap(147, 147, 147)))
                                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(qte)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                                    .addGroup(venteLayout.createSequentialGroup()
                                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pu, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))))
                .addContainerGap())
        );
        venteLayout.setVerticalGroup(
            venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(venteLayout.createSequentialGroup()
                .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(venteLayout.createSequentialGroup()
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(venteLayout.createSequentialGroup()
                                .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, venteLayout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(contact1)
                                .addComponent(client1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(au, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(du, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(venteLayout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(venteLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(desc)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(qte, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(venteLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(venteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(venteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel74)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(observ, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(venteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        center.add(vente, "card3");

        service.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SERVICE APRES VENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("CLIENT");

        client2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        client2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        client2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel76.setText("DESCRIPTION");

        contact2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            contact2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        contact2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("CONTACT");

        id2.setBackground(new java.awt.Color(153, 153, 153));
        id2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        id2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        id2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                id2KeyReleased(evt);
            }
        });

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("ID");

        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("P.U");

        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("QTE");

        desc2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        desc2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        desc2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        desc2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desc2KeyReleased(evt);
            }
        });

        qte2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        qte2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        qte2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        pu2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pu2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        pu2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton40.setBackground(new java.awt.Color(102, 102, 0));
        jButton40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton40.setForeground(new java.awt.Color(255, 255, 255));
        jButton40.setText("RETIRER");
        jButton40.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton41.setBackground(new java.awt.Color(102, 102, 0));
        jButton41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton41.setForeground(new java.awt.Color(255, 255, 255));
        jButton41.setText("AJOUTER");
        jButton41.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jTable21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable21.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DESCRIPTION", "QTE", "PU", "MTT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable21.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable21.getTableHeader().setReorderingAllowed(false);
        jScrollPane21.setViewportView(jTable21);
        if (jTable21.getColumnModel().getColumnCount() > 0) {
            jTable21.getColumnModel().getColumn(1).setMinWidth(40);
            jTable21.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable21.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable21.getColumnModel().getColumn(2).setMinWidth(100);
            jTable21.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable21.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable21.getColumnModel().getColumn(3).setMinWidth(90);
            jTable21.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable21.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        jButton42.setBackground(new java.awt.Color(102, 102, 0));
        jButton42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton42.setForeground(new java.awt.Color(255, 255, 255));
        jButton42.setText("VALIDER");
        jButton42.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        observ2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        observ2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        observ2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("OBSERVATION");

        t2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t2.setText("TOTAL :");
        t2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTable22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable22.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable22.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable22.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable22.getTableHeader().setReorderingAllowed(false);
        jScrollPane22.setViewportView(jTable22);
        if (jTable22.getColumnModel().getColumnCount() > 0) {
            jTable22.getColumnModel().getColumn(1).setMinWidth(40);
            jTable22.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable22.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable22.getColumnModel().getColumn(2).setMinWidth(100);
            jTable22.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable22.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable22.getColumnModel().getColumn(3).setMinWidth(90);
            jTable22.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable22.getColumnModel().getColumn(3).setMaxWidth(90);
            jTable22.getColumnModel().getColumn(4).setMinWidth(0);
            jTable22.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable22.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jTable23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable23.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable23.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB", "OBSERVATION", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable23.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable23.getTableHeader().setReorderingAllowed(false);
        jTable23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable23MouseReleased(evt);
            }
        });
        jScrollPane23.setViewportView(jTable23);
        if (jTable23.getColumnModel().getColumnCount() > 0) {
            jTable23.getColumnModel().getColumn(1).setMinWidth(120);
            jTable23.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTable23.getColumnModel().getColumn(1).setMaxWidth(120);
            jTable23.getColumnModel().getColumn(2).setMinWidth(35);
            jTable23.getColumnModel().getColumn(2).setPreferredWidth(35);
            jTable23.getColumnModel().getColumn(2).setMaxWidth(35);
            jTable23.getColumnModel().getColumn(3).setMinWidth(90);
            jTable23.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable23.getColumnModel().getColumn(3).setMaxWidth(90);
            jTable23.getColumnModel().getColumn(7).setMinWidth(0);
            jTable23.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable23.getColumnModel().getColumn(7).setMaxWidth(0);
            jTable23.getColumnModel().getColumn(8).setMinWidth(0);
            jTable23.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTable23.getColumnModel().getColumn(8).setMaxWidth(0);
            jTable23.getColumnModel().getColumn(9).setMinWidth(0);
            jTable23.getColumnModel().getColumn(9).setPreferredWidth(0);
            jTable23.getColumnModel().getColumn(9).setMaxWidth(0);
        }

        du1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du1.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

        h11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h11.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h11.setText("00:00");

        au1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au1.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

        h22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h22.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h22.setText("23:59");

        jButton43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton43.setText("VALIDER");
        jButton43.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton43.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("HEURE");

        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("AU");

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("HEURE");

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("DU");

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setText("IMP.FACTURE");
        jButton10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox2.setText("C.DEFAUT");
        jCheckBox2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jCheckBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBox2MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout serviceLayout = new javax.swing.GroupLayout(service);
        service.setLayout(serviceLayout);
        serviceLayout.setHorizontalGroup(
            serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serviceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(serviceLayout.createSequentialGroup()
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(client2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(contact2))
                        .addGap(55, 55, 55)
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id2)
                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(du1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h11)
                            .addComponent(jLabel85, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(au1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel84, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h22)
                            .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(serviceLayout.createSequentialGroup()
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(serviceLayout.createSequentialGroup()
                                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(observ2)
                                    .addGroup(serviceLayout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 39, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane21, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, serviceLayout.createSequentialGroup()
                                .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(serviceLayout.createSequentialGroup()
                                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serviceLayout.createSequentialGroup()
                                                .addComponent(desc2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(serviceLayout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(jLabel76)
                                                .addGap(147, 147, 147)))
                                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(qte2)
                                            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                                    .addGroup(serviceLayout.createSequentialGroup()
                                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                        .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pu2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                            .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))))
                .addContainerGap())
        );
        serviceLayout.setVerticalGroup(
            serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serviceLayout.createSequentialGroup()
                .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(serviceLayout.createSequentialGroup()
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(serviceLayout.createSequentialGroup()
                                .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel75)
                                    .addComponent(jLabel77)
                                    .addComponent(jLabel86)
                                    .addComponent(jLabel85)
                                    .addComponent(jLabel84)
                                    .addComponent(jLabel83))
                                .addGap(8, 8, 8))
                            .addGroup(serviceLayout.createSequentialGroup()
                                .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(contact2)
                                .addComponent(client2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(au1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(h22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(du1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(h11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(serviceLayout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(serviceLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel76)
                            .addComponent(jLabel80)
                            .addComponent(jLabel79))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(desc2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(qte2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pu2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(serviceLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(serviceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(serviceLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel81)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(observ2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(serviceLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        center.add(service, "card4");

        reprise.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REPRISE VENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jTable24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable24.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable24.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable24.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable24.getTableHeader().setReorderingAllowed(false);
        jScrollPane24.setViewportView(jTable24);
        if (jTable24.getColumnModel().getColumnCount() > 0) {
            jTable24.getColumnModel().getColumn(1).setMinWidth(40);
            jTable24.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable24.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable24.getColumnModel().getColumn(2).setMinWidth(100);
            jTable24.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable24.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable24.getColumnModel().getColumn(3).setMinWidth(90);
            jTable24.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable24.getColumnModel().getColumn(3).setMaxWidth(90);
            jTable24.getColumnModel().getColumn(4).setMinWidth(0);
            jTable24.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable24.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("CLIENT");

        client3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        client3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        client3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        contact3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            contact3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        contact3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("CONTACT");

        id3.setBackground(new java.awt.Color(153, 153, 153));
        id3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        id3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        id3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                id3KeyReleased(evt);
            }
        });

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("ID");

        desc3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        desc3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        desc3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        desc3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desc3KeyReleased(evt);
            }
        });

        jLabel90.setText("DESCRIPTION");

        qte3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        qte3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        qte3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("QTE");

        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("P.U");

        pu3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pu3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        pu3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton44.setBackground(new java.awt.Color(102, 102, 0));
        jButton44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton44.setForeground(new java.awt.Color(255, 255, 255));
        jButton44.setText("RETIRER");
        jButton44.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton44.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jButton45.setBackground(new java.awt.Color(102, 102, 0));
        jButton45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton45.setForeground(new java.awt.Color(255, 255, 255));
        jButton45.setText("AJOUTER");
        jButton45.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton45.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jTable25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable25.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable25.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DESCRIPTION", "QTE", "PU", "MTT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable25.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable25.getTableHeader().setReorderingAllowed(false);
        jScrollPane25.setViewportView(jTable25);
        if (jTable25.getColumnModel().getColumnCount() > 0) {
            jTable25.getColumnModel().getColumn(1).setMinWidth(40);
            jTable25.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable25.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable25.getColumnModel().getColumn(2).setMinWidth(100);
            jTable25.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable25.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable25.getColumnModel().getColumn(3).setMinWidth(90);
            jTable25.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable25.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        jButton46.setBackground(new java.awt.Color(102, 102, 0));
        jButton46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton46.setForeground(new java.awt.Color(255, 255, 255));
        jButton46.setText("VALIDER");
        jButton46.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton46.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        observ3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        observ3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        observ3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("OBSERVATION");

        t3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t3.setText("TOTAL :");
        t3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTable26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable26.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable26.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable26.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable26.getTableHeader().setReorderingAllowed(false);
        jTable26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable26MouseReleased(evt);
            }
        });
        jScrollPane26.setViewportView(jTable26);
        if (jTable26.getColumnModel().getColumnCount() > 0) {
            jTable26.getColumnModel().getColumn(1).setMinWidth(120);
            jTable26.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTable26.getColumnModel().getColumn(1).setMaxWidth(120);
            jTable26.getColumnModel().getColumn(2).setMinWidth(35);
            jTable26.getColumnModel().getColumn(2).setPreferredWidth(35);
            jTable26.getColumnModel().getColumn(2).setMaxWidth(35);
            jTable26.getColumnModel().getColumn(4).setMinWidth(90);
            jTable26.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTable26.getColumnModel().getColumn(4).setMaxWidth(90);
            jTable26.getColumnModel().getColumn(7).setMinWidth(0);
            jTable26.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable26.getColumnModel().getColumn(7).setMaxWidth(0);
            jTable26.getColumnModel().getColumn(8).setMinWidth(0);
            jTable26.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTable26.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        du3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du3.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("DU");

        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("HEURE");

        h13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h13.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h13.setText("00:00");

        au3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au3.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("AU");

        h23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h23.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h23.setText("23:59");

        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("HEURE");

        jButton47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton47.setText("VALIDER");
        jButton47.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton47.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox3.setText("C.DEFAUT");
        jCheckBox3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jCheckBox3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBox3MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout repriseLayout = new javax.swing.GroupLayout(reprise);
        reprise.setLayout(repriseLayout);
        repriseLayout.setHorizontalGroup(
            repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(repriseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(repriseLayout.createSequentialGroup()
                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(client3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(contact3))
                        .addGap(55, 55, 55)
                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id3)
                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(du3, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h13)
                            .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(au3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h23)
                            .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(repriseLayout.createSequentialGroup()
                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(repriseLayout.createSequentialGroup()
                                .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(observ3)
                                    .addGroup(repriseLayout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 39, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane25, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, repriseLayout.createSequentialGroup()
                                .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(repriseLayout.createSequentialGroup()
                                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, repriseLayout.createSequentialGroup()
                                                .addComponent(desc3, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(repriseLayout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(jLabel90)
                                                .addGap(147, 147, 147)))
                                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(qte3)
                                            .addComponent(jLabel91, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                                    .addGroup(repriseLayout.createSequentialGroup()
                                        .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                        .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pu3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel92, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                            .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))))
                .addContainerGap())
        );
        repriseLayout.setVerticalGroup(
            repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(repriseLayout.createSequentialGroup()
                .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(repriseLayout.createSequentialGroup()
                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel87)
                            .addComponent(jLabel88)
                            .addComponent(jLabel95)
                            .addComponent(jLabel96)
                            .addComponent(jLabel97)
                            .addComponent(jLabel98))
                        .addGap(8, 8, 8)
                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(contact3)
                                .addComponent(client3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(au3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(h23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(du3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(h13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(repriseLayout.createSequentialGroup()
                        .addComponent(jLabel89)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(repriseLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel90)
                            .addComponent(jLabel91)
                            .addComponent(jLabel92))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(desc3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(qte3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pu3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(repriseLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(repriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(repriseLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel93)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(observ3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(repriseLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        center.add(reprise, "card5");

        reservation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VENTE A CREDIT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jTable27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable27.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable27.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable27.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable27.getTableHeader().setReorderingAllowed(false);
        jScrollPane27.setViewportView(jTable27);
        if (jTable27.getColumnModel().getColumnCount() > 0) {
            jTable27.getColumnModel().getColumn(1).setMinWidth(40);
            jTable27.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable27.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable27.getColumnModel().getColumn(2).setMinWidth(100);
            jTable27.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable27.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable27.getColumnModel().getColumn(3).setMinWidth(90);
            jTable27.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable27.getColumnModel().getColumn(3).setMaxWidth(90);
            jTable27.getColumnModel().getColumn(4).setMinWidth(0);
            jTable27.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable27.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("CLIENT");

        client4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        client4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        client4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        contact4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            contact4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        contact4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("CONTACT");

        id4.setBackground(new java.awt.Color(153, 153, 153));
        id4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        id4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        id4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                id4KeyReleased(evt);
            }
        });

        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("ID");

        desc4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        desc4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        desc4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        desc4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desc4KeyReleased(evt);
            }
        });

        jLabel102.setText("DESCRIPTION");

        qte4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        qte4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        qte4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel103.setText("QTE");

        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setText("P.U");

        pu4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pu4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        pu4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton48.setBackground(new java.awt.Color(102, 102, 0));
        jButton48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton48.setForeground(new java.awt.Color(255, 255, 255));
        jButton48.setText("RETIRER");
        jButton48.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton48.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jButton49.setBackground(new java.awt.Color(102, 102, 0));
        jButton49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton49.setForeground(new java.awt.Color(255, 255, 255));
        jButton49.setText("AJOUTER");
        jButton49.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton49.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        jTable28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable28.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable28.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DESCRIPTION", "QTE", "PU", "MTT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable28.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable28.getTableHeader().setReorderingAllowed(false);
        jScrollPane28.setViewportView(jTable28);
        if (jTable28.getColumnModel().getColumnCount() > 0) {
            jTable28.getColumnModel().getColumn(1).setMinWidth(40);
            jTable28.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable28.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable28.getColumnModel().getColumn(2).setMinWidth(100);
            jTable28.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable28.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable28.getColumnModel().getColumn(3).setMinWidth(90);
            jTable28.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable28.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        jButton50.setBackground(new java.awt.Color(102, 102, 0));
        jButton50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton50.setForeground(new java.awt.Color(255, 255, 255));
        jButton50.setText("VALIDER");
        jButton50.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton50.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setText("PAIEMENT ESPECE ");

        t4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t4.setText("TOTAL :");
        t4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTable29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable29.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable29.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB", "OBSERVATION", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable29.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable29.getTableHeader().setReorderingAllowed(false);
        jTable29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable29MouseReleased(evt);
            }
        });
        jScrollPane29.setViewportView(jTable29);
        if (jTable29.getColumnModel().getColumnCount() > 0) {
            jTable29.getColumnModel().getColumn(1).setMinWidth(120);
            jTable29.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTable29.getColumnModel().getColumn(1).setMaxWidth(120);
            jTable29.getColumnModel().getColumn(2).setMinWidth(35);
            jTable29.getColumnModel().getColumn(2).setPreferredWidth(35);
            jTable29.getColumnModel().getColumn(2).setMaxWidth(35);
            jTable29.getColumnModel().getColumn(4).setMinWidth(90);
            jTable29.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTable29.getColumnModel().getColumn(4).setMaxWidth(90);
            jTable29.getColumnModel().getColumn(7).setMinWidth(0);
            jTable29.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable29.getColumnModel().getColumn(7).setMaxWidth(0);
            jTable29.getColumnModel().getColumn(8).setMinWidth(0);
            jTable29.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTable29.getColumnModel().getColumn(8).setMaxWidth(0);
            jTable29.getColumnModel().getColumn(9).setMinWidth(0);
            jTable29.getColumnModel().getColumn(9).setPreferredWidth(0);
            jTable29.getColumnModel().getColumn(9).setMaxWidth(0);
        }

        du4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du4.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setText("DU");

        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setText("HEURE");

        h14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h14.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h14.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        au4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au4.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setText("AU");

        h24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h24.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h24.setText("23:59");

        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setText("HEURE");

        jButton51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton51.setText("VALIDER");
        jButton51.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton51.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        observ4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        observ4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        observ4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton11.setText("IMP.FACTURE");
        jButton11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox4.setText("C.DEFAUT");
        jCheckBox4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jCheckBox4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBox4MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout reservationLayout = new javax.swing.GroupLayout(reservation);
        reservation.setLayout(reservationLayout);
        reservationLayout.setHorizontalGroup(
            reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reservationLayout.createSequentialGroup()
                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(client4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(contact4))
                        .addGap(55, 55, 55)
                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id4)
                            .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(du4, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(jLabel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h14)
                            .addComponent(jLabel108, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(au4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel109, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h24)
                            .addComponent(jLabel110, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(reservationLayout.createSequentialGroup()
                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(reservationLayout.createSequentialGroup()
                                .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel105, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(observ4))
                                .addGap(46, 46, 46)
                                .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane28, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reservationLayout.createSequentialGroup()
                                .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(reservationLayout.createSequentialGroup()
                                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationLayout.createSequentialGroup()
                                                .addComponent(desc4, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(reservationLayout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(jLabel102)
                                                .addGap(147, 147, 147)))
                                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(qte4)
                                            .addComponent(jLabel103, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                                    .addGroup(reservationLayout.createSequentialGroup()
                                        .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pu4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane29, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                            .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationLayout.createSequentialGroup()
                                .addGap(387, 387, 387)
                                .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        reservationLayout.setVerticalGroup(
            reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationLayout.createSequentialGroup()
                .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reservationLayout.createSequentialGroup()
                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel99)
                            .addComponent(jLabel100)
                            .addComponent(jLabel107)
                            .addComponent(jLabel108)
                            .addComponent(jLabel109)
                            .addComponent(jLabel110))
                        .addGap(0, 0, 0)
                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(id4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(client4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(contact4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(au4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton51, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(h24, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(du4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(h14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel101))
                .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reservationLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel102)
                            .addComponent(jLabel103)
                            .addComponent(jLabel104)))
                    .addGroup(reservationLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(reservationLayout.createSequentialGroup()
                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(desc4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(qte4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pu4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(reservationLayout.createSequentialGroup()
                                    .addComponent(jLabel105)
                                    .addGap(0, 0, 0)
                                    .addComponent(observ4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(reservationLayout.createSequentialGroup()
                        .addComponent(jScrollPane29, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        center.add(reservation, "card6");

        sortie_caisse.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SORTIE DE CAISSE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        montant.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        montant.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        montant.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("REFERENCE");

        ref.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ref.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ref.setToolTipText("");
        ref.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("MONTANT");

        obs.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        obs.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("OBSERVATION");

        jButton22.setBackground(new java.awt.Color(0, 0, 204));
        jButton22.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("VALIDER");
        jButton22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jTable13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable13.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "POS", "DATE", "ID", "USER", "REF SORTIE", "MONTANT", "OBSERVATION", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable13.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable13.getTableHeader().setReorderingAllowed(false);
        jTable13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable13MouseReleased(evt);
            }
        });
        jScrollPane13.setViewportView(jTable13);
        if (jTable13.getColumnModel().getColumnCount() > 0) {
            jTable13.getColumnModel().getColumn(2).setMinWidth(35);
            jTable13.getColumnModel().getColumn(2).setPreferredWidth(35);
            jTable13.getColumnModel().getColumn(2).setMaxWidth(35);
            jTable13.getColumnModel().getColumn(5).setMinWidth(90);
            jTable13.getColumnModel().getColumn(5).setPreferredWidth(90);
            jTable13.getColumnModel().getColumn(5).setMaxWidth(90);
            jTable13.getColumnModel().getColumn(7).setMinWidth(0);
            jTable13.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable13.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        du5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du5.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 13));

        h15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h15.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h15.setText("00:00");
        h15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("DU");

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("HEURE");

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("AU");

        au5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au5.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 13));

        h25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h25.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h25.setText("23:59");
        h25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("HEURE");

        jButton23.setBackground(new java.awt.Color(0, 0, 204));
        jButton23.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("RECHERCHER");
        jButton23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("TOTAL :");
        jLabel19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton24.setBackground(new java.awt.Color(255, 0, 0));
        jButton24.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jButton24.setForeground(new java.awt.Color(255, 255, 255));
        jButton24.setText("ANNULER");
        jButton24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sortie_caisseLayout = new javax.swing.GroupLayout(sortie_caisse);
        sortie_caisse.setLayout(sortie_caisseLayout);
        sortie_caisseLayout.setHorizontalGroup(
            sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sortie_caisseLayout.createSequentialGroup()
                .addGap(442, 442, 442)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sortie_caisseLayout.createSequentialGroup()
                .addContainerGap(187, Short.MAX_VALUE)
                .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sortie_caisseLayout.createSequentialGroup()
                        .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(du5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h15)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(au5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h25)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sortie_caisseLayout.createSequentialGroup()
                        .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane13)
                            .addGroup(sortie_caisseLayout.createSequentialGroup()
                                .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ref, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(montant)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(obs)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        sortie_caisseLayout.setVerticalGroup(
            sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sortie_caisseLayout.createSequentialGroup()
                .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45))
                .addGap(0, 0, 0)
                .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(montant, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ref, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(obs, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton22)
                .addGap(19, 19, 19)
                .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sortie_caisseLayout.createSequentialGroup()
                        .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48))
                        .addGap(0, 0, 0)
                        .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h15)
                            .addComponent(du5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(sortie_caisseLayout.createSequentialGroup()
                        .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50))
                        .addGap(0, 0, 0)
                        .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(au5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(h25))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(sortie_caisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        center.add(sortie_caisse, "card7");

        suivi_ope_session.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SUIVI OPERATION DE SESSION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jTable15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable15.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable15.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable15.getTableHeader().setReorderingAllowed(false);
        jScrollPane15.setViewportView(jTable15);
        if (jTable15.getColumnModel().getColumnCount() > 0) {
            jTable15.getColumnModel().getColumn(1).setMinWidth(40);
            jTable15.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable15.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable15.getColumnModel().getColumn(2).setMinWidth(100);
            jTable15.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable15.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable15.getColumnModel().getColumn(3).setMinWidth(90);
            jTable15.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable15.getColumnModel().getColumn(3).setMaxWidth(90);
            jTable15.getColumnModel().getColumn(4).setMinWidth(0);
            jTable15.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable15.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jTable16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable16.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable16.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable16.getTableHeader().setReorderingAllowed(false);
        jTable16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable16MouseReleased(evt);
            }
        });
        jScrollPane16.setViewportView(jTable16);
        if (jTable16.getColumnModel().getColumnCount() > 0) {
            jTable16.getColumnModel().getColumn(1).setMinWidth(120);
            jTable16.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTable16.getColumnModel().getColumn(1).setMaxWidth(120);
            jTable16.getColumnModel().getColumn(2).setMinWidth(35);
            jTable16.getColumnModel().getColumn(2).setPreferredWidth(35);
            jTable16.getColumnModel().getColumn(2).setMaxWidth(35);
            jTable16.getColumnModel().getColumn(3).setMinWidth(90);
            jTable16.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable16.getColumnModel().getColumn(3).setMaxWidth(90);
            jTable16.getColumnModel().getColumn(7).setMinWidth(0);
            jTable16.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable16.getColumnModel().getColumn(7).setMaxWidth(0);
            jTable16.getColumnModel().getColumn(8).setMinWidth(0);
            jTable16.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTable16.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        du6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du6.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

        jLabel57.setText("DU");

        h16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h16.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h16.setText("00:00");

        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("HEURE");

        au6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au6.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("AU");

        h26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h26.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h26.setText("23:59");

        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("HEURE");

        jButton30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton30.setText("RECHERCHER");
        jButton30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        user.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUT" }));
        user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        op.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUT", "VENTE DIRECT", "SERVICE APRES VENTE", "REPRISE", "RESERVATION" }));
        op.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        op.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opActionPerformed(evt);
            }
        });

        id6.setBackground(new java.awt.Color(153, 153, 153));
        id6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        id6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        id6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                id6KeyReleased(evt);
            }
        });

        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel111.setText("ID");

        jButton31.setBackground(new java.awt.Color(255, 0, 51));
        jButton31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton31.setForeground(new java.awt.Color(255, 255, 255));
        jButton31.setText("ANNULER");
        jButton31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        cl.setBackground(new java.awt.Color(204, 204, 204));
        cl.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        cl.setForeground(new java.awt.Color(102, 102, 0));
        cl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cl.setText("CLIENT");
        cl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                clFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                clFocusLost(evt);
            }
        });
        cl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout suivi_ope_sessionLayout = new javax.swing.GroupLayout(suivi_ope_session);
        suivi_ope_session.setLayout(suivi_ope_sessionLayout);
        suivi_ope_sessionLayout.setHorizontalGroup(
            suivi_ope_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suivi_ope_sessionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(suivi_ope_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(suivi_ope_sessionLayout.createSequentialGroup()
                        .addGroup(suivi_ope_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(suivi_ope_sessionLayout.createSequentialGroup()
                                .addGroup(suivi_ope_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(du6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(suivi_ope_sessionLayout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel57)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(suivi_ope_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(h16)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(suivi_ope_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(au6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(suivi_ope_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(h26)
                                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cl, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(suivi_ope_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(suivi_ope_sessionLayout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(suivi_ope_sessionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(suivi_ope_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(suivi_ope_sessionLayout.createSequentialGroup()
                                        .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(id6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addComponent(jScrollPane16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suivi_ope_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suivi_ope_sessionLayout.createSequentialGroup()
                        .addComponent(user, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(op, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        suivi_ope_sessionLayout.setVerticalGroup(
            suivi_ope_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suivi_ope_sessionLayout.createSequentialGroup()
                .addGroup(suivi_ope_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60)
                    .addComponent(jLabel111))
                .addGap(0, 0, 0)
                .addGroup(suivi_ope_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(au6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(h26, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(du6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(h16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(user)
                    .addComponent(op)
                    .addComponent(jButton30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(id6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(7, 7, 7)
                .addGroup(suivi_ope_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(cl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suivi_ope_sessionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        center.add(suivi_ope_session, "card8");

        suivi_op_cred.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SUIVI OPERATION CREDIT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jTable18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable18.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable18.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable18.getTableHeader().setReorderingAllowed(false);
        jScrollPane18.setViewportView(jTable18);
        if (jTable18.getColumnModel().getColumnCount() > 0) {
            jTable18.getColumnModel().getColumn(1).setMinWidth(40);
            jTable18.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable18.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable18.getColumnModel().getColumn(2).setMinWidth(50);
            jTable18.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable18.getColumnModel().getColumn(2).setMaxWidth(50);
            jTable18.getColumnModel().getColumn(3).setMinWidth(80);
            jTable18.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable18.getColumnModel().getColumn(3).setMaxWidth(80);
            jTable18.getColumnModel().getColumn(4).setMinWidth(0);
            jTable18.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable18.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jTable19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable19.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB", "AVANCE", "RELIQUAT", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable19.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable19.getTableHeader().setReorderingAllowed(false);
        jTable19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable19MouseReleased(evt);
            }
        });
        jScrollPane19.setViewportView(jTable19);
        if (jTable19.getColumnModel().getColumnCount() > 0) {
            jTable19.getColumnModel().getColumn(1).setMinWidth(90);
            jTable19.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTable19.getColumnModel().getColumn(1).setMaxWidth(90);
            jTable19.getColumnModel().getColumn(2).setMinWidth(35);
            jTable19.getColumnModel().getColumn(2).setPreferredWidth(35);
            jTable19.getColumnModel().getColumn(2).setMaxWidth(35);
            jTable19.getColumnModel().getColumn(3).setMinWidth(70);
            jTable19.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable19.getColumnModel().getColumn(3).setMaxWidth(70);
            jTable19.getColumnModel().getColumn(4).setMinWidth(120);
            jTable19.getColumnModel().getColumn(4).setPreferredWidth(120);
            jTable19.getColumnModel().getColumn(4).setMaxWidth(120);
            jTable19.getColumnModel().getColumn(5).setMinWidth(80);
            jTable19.getColumnModel().getColumn(5).setPreferredWidth(80);
            jTable19.getColumnModel().getColumn(5).setMaxWidth(80);
            jTable19.getColumnModel().getColumn(7).setMinWidth(0);
            jTable19.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable19.getColumnModel().getColumn(7).setMaxWidth(0);
            jTable19.getColumnModel().getColumn(10).setMinWidth(0);
            jTable19.getColumnModel().getColumn(10).setPreferredWidth(0);
            jTable19.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        du7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du7.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

        jLabel67.setText("DU");

        h17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h17.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h17.setText("00:00");
        h17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("HEURE");

        au7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au7.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("AU");

        h27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h27.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h27.setText("23:59");
        h27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("HEURE");

        jButton39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton39.setText("RECHERCHER");
        jButton39.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jTable20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable20.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "POS", "ID", "DATE", "USER", "MONTANT", "OBSERVATION", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable20.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable20.getTableHeader().setReorderingAllowed(false);
        jTable20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable20MouseReleased(evt);
            }
        });
        jScrollPane20.setViewportView(jTable20);
        if (jTable20.getColumnModel().getColumnCount() > 0) {
            jTable20.getColumnModel().getColumn(1).setMinWidth(40);
            jTable20.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable20.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable20.getColumnModel().getColumn(2).setMinWidth(100);
            jTable20.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable20.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable20.getColumnModel().getColumn(3).setMinWidth(90);
            jTable20.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable20.getColumnModel().getColumn(3).setMaxWidth(90);
            jTable20.getColumnModel().getColumn(4).setMinWidth(85);
            jTable20.getColumnModel().getColumn(4).setPreferredWidth(85);
            jTable20.getColumnModel().getColumn(4).setMaxWidth(85);
            jTable20.getColumnModel().getColumn(6).setMinWidth(0);
            jTable20.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable20.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        py.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        py.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        py.setText("TOTAL PAYE :");
        py.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        rl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rl.setText("RESTE A PAYER :");
        rl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        mt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        mt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("MONTANT");

        ob.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ob.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("OBSERVATION");

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("VALIDER");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton52.setText("IMPRIMER");
        jButton52.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton52.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        jButton53.setBackground(new java.awt.Color(255, 51, 51));
        jButton53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton53.setForeground(new java.awt.Color(255, 255, 255));
        jButton53.setText("ANNULER OP");
        jButton53.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton53.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        jButton54.setBackground(new java.awt.Color(255, 51, 51));
        jButton54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton54.setForeground(new java.awt.Color(255, 255, 255));
        jButton54.setText("ANNULER PY");
        jButton54.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton54.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        rch_c.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rch_c.setText("CLIENT / CONTACT");
        rch_c.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rch_cFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rch_cFocusLost(evt);
            }
        });
        rch_c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rch_cKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout suivi_op_credLayout = new javax.swing.GroupLayout(suivi_op_cred);
        suivi_op_cred.setLayout(suivi_op_credLayout);
        suivi_op_credLayout.setHorizontalGroup(
            suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suivi_op_credLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(suivi_op_credLayout.createSequentialGroup()
                        .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(du7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(suivi_op_credLayout.createSequentialGroup()
                                    .addGap(52, 52, 52)
                                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(suivi_op_credLayout.createSequentialGroup()
                                .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(h17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(au7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(h27, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suivi_op_credLayout.createSequentialGroup()
                                .addComponent(rch_c, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(suivi_op_credLayout.createSequentialGroup()
                        .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mt)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ob)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suivi_op_credLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suivi_op_credLayout.createSequentialGroup()
                                    .addComponent(rl, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                    .addComponent(py, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        suivi_op_credLayout.setVerticalGroup(
            suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suivi_op_credLayout.createSequentialGroup()
                .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(suivi_op_credLayout.createSequentialGroup()
                            .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel67)
                                .addComponent(jLabel68)
                                .addComponent(jLabel69)
                                .addComponent(jLabel70))
                            .addGap(0, 0, 0)
                            .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(au7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(h27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                .addComponent(du7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(h17, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suivi_op_credLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(jLabel18))
                            .addGap(0, 1, Short.MAX_VALUE)
                            .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(mt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ob, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(suivi_op_credLayout.createSequentialGroup()
                        .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton52, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(jButton53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9))
                    .addGroup(suivi_op_credLayout.createSequentialGroup()
                        .addComponent(rch_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(suivi_op_credLayout.createSequentialGroup()
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(suivi_op_credLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(py, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        center.add(suivi_op_cred, "card9");

        javax.swing.GroupLayout autreLayout = new javax.swing.GroupLayout(autre);
        autre.setLayout(autreLayout);
        autreLayout.setHorizontalGroup(
            autreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1118, Short.MAX_VALUE)
        );
        autreLayout.setVerticalGroup(
            autreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        center.add(autre, "card10");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alerteExpiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alerteExpiMouseClicked
      
    }//GEN-LAST:event_alerteExpiMouseClicked

    private void alerteStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alerteStockMouseClicked
      
    }//GEN-LAST:event_alerteStockMouseClicked

    private void rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rActionPerformed
        // TODO add your handling code here:

          this.session.setVisible(false);
        this.vente.setVisible(false);
        this.service.setVisible(false);
        this.reprise.setVisible(true);
        this.reservation.setVisible(false);
        this.sortie_caisse.setVisible(false);
        this.suivi_op_cred.setVisible(false);
        this.suivi_ope_session.setVisible(false);
        this.accueil.setVisible(false);
   
        
    }//GEN-LAST:event_rActionPerformed

    private void vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vActionPerformed
        // TODO add your handling code here:
 
        
        this.session.setVisible(false);
        this.vente.setVisible(true);
        this.service.setVisible(false);
        this.reprise.setVisible(false);
        this.reservation.setVisible(false);
        this.sortie_caisse.setVisible(false);
        this.suivi_op_cred.setVisible(false);
        this.suivi_ope_session.setVisible(false);
        this.accueil.setVisible(false);

    }//GEN-LAST:event_vActionPerformed

    private void savActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savActionPerformed
        // TODO add your handling code here:

        this.session.setVisible(false);
        this.vente.setVisible(false);
        this.service.setVisible(true);
        this.reprise.setVisible(false);
        this.reservation.setVisible(false);
        this.sortie_caisse.setVisible(false);
        this.suivi_op_cred.setVisible(false);
        this.suivi_ope_session.setVisible(false);
        this.accueil.setVisible(false);
         
    }//GEN-LAST:event_savActionPerformed

    private void sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sActionPerformed
        // TODO add your handling code here :
 
        this.session.setVisible(true);
        this.accueil.setVisible(false);
        this.vente.setVisible(false);
        this.service.setVisible(false);
        this.reprise.setVisible(false);
        this.reservation.setVisible(false);
        this.sortie_caisse.setVisible(false);
        this.suivi_op_cred.setVisible(false);
        this.suivi_ope_session.setVisible(false);
        
         if(this.v_s == 1){
            JOptionPane.showMessageDialog(null, "VEUILLEZ METTRE A JOUR LA SESSION") ;
        }else{
            
        }

    }//GEN-LAST:event_sActionPerformed

    private void reservActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservActionPerformed

        this.session.setVisible(false);
        this.vente.setVisible(false);
        this.service.setVisible(false);
        this.reprise.setVisible(false);
        this.reservation.setVisible(true);
        this.sortie_caisse.setVisible(false);
        this.suivi_op_cred.setVisible(false);
        this.suivi_ope_session.setVisible(false);
        this.accueil.setVisible(false);
        
    }//GEN-LAST:event_reservActionPerformed

    private void stActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stActionPerformed

        this.session.setVisible(false);
        this.vente.setVisible(false);
        this.service.setVisible(false);
        this.reprise.setVisible(false);
        this.reservation.setVisible(false);
        this.sortie_caisse.setVisible(true);
        this.suivi_op_cred.setVisible(false);
        this.suivi_ope_session.setVisible(false);
        this.accueil.setVisible(false);
        
        
    }//GEN-LAST:event_stActionPerformed

    private void sui1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sui1ActionPerformed

        this.session.setVisible(false);
        this.vente.setVisible(false);
        this.service.setVisible(false);
        this.reprise.setVisible(false);
        this.reservation.setVisible(false);
        this.sortie_caisse.setVisible(false);
        this.suivi_op_cred.setVisible(false);
        this.suivi_ope_session.setVisible(true);
        this.accueil.setVisible(false);
        
    }//GEN-LAST:event_sui1ActionPerformed

    private void sui2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sui2ActionPerformed

        this.session.setVisible(false);
        this.vente.setVisible(false);
        this.service.setVisible(false);
        this.reprise.setVisible(false);
        this.reservation.setVisible(false);
        this.sortie_caisse.setVisible(false);
        this.suivi_op_cred.setVisible(true);
        this.suivi_ope_session.setVisible(false);
        this.accueil.setVisible(false);
        
    }//GEN-LAST:event_sui2ActionPerformed

    private void bofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bofActionPerformed
        
       Arrivage ar = new Arrivage(this.user_c, this.role, this.pos) ;
                ar.setVisible(true) ;
                
        
    }//GEN-LAST:event_bofActionPerformed

    private void alerteStockMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alerteStockMouseReleased
        // TODO add your handling code here:
        
         
        
    }//GEN-LAST:event_alerteStockMouseReleased

    private void alerteExpiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alerteExpiMouseReleased

      
        
        
    }//GEN-LAST:event_alerteExpiMouseReleased

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
       
        Menu_at_ ma = new Menu_at_(this.pos, this.user_c , this.role ) ;
                 ma.setVisible(true) ;
               
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        if (JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS OUVRIR UNE SESSION ?", "CONFIRMATION",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        // yes option
            
            String fc = this.fc.getText().trim().replaceAll("'", "''") ;
      
      if(fc.isEmpty()){
          JOptionPane.showMessageDialog(null, "SAISIR FOND DE CAISSE");
      }else{
          
          try{
              
              Integer f_s = Integer.parseInt(fc) ;
              Integer balance = f_s ;
              
              String date ;
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
              
              date = sdf.format(new Date()) ;
              String dt_close = null ;
              
              
              
              
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
       
    
      String id = "";
      String user = "" ; String date_s = "" ; String fc1 = "" ; String etat = "" ;
      
      
      String sql = null ;
      ResultSet rs = null ;
      
     
         
         stmt.executeUpdate("insert into session(pos, user, date_op, date_close, f_c, balance, etat) "
                 + "values('"+this.pos+"' , '"+this.user_c+"' , '"+date+"' , "+null+" , "+f_s+" , "+balance+" , 'OUI')") ;
         
         this.fc.setText("");
         
     sql = "select * from session where user = '"+this.user_c+"' and etat = 'OUI'" ;
     rs = stmt.executeQuery(sql) ;
     while(rs.next()){
         
          id = rs.getString("id_ss") ;
          user = rs.getString("user") ;
          date_s = this.sdf_java_.format(rs.getTimestamp("date_op")) ;
          fc1 = rs.getString("f_c") ;
          etat = "OUVERT" ;
          
          
          this.id_ss = rs.getLong("id_ss") ;
          this.balance = rs.getInt("balance") ;
          
          
          
     }
         

          
          this.jLabel5.setText("ID : "+id);
          this.jLabel13.setText("USER : "+user);
          this.jLabel14.setText("DATE OUVERTURE : "+date_s);
          this.jLabel15.setText("FOND DE CAISSE : "+this.nf3.format(Integer.parseInt(fc1)));
          this.jLabel16.setText("ETAT : "+etat);
          
          this.d_s.setVisible(true) ;
          
           
          this.v.setEnabled(true);
          this.sav.setEnabled(true);
          this.r.setEnabled(true);
          this.reserv.setEnabled(true);
          this.st.setEnabled(true);
         
         this.jButton2.setEnabled(true);
         
         this.jButton1.setEnabled(false) ;
          
         
     
      
    
            
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
              JOptionPane.showMessageDialog(null, e.getMessage());
          }
          
      }
        
      
      
      
            
               } else {
                    // no option
            
            
            
                  }
        
      
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        
        if (JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS FERMER LA SESSION ?", "CONFIRMATION",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                              // yes option
            
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
       
      int vy = 0 ;
      
      
      String sql = null ;
      ResultSet rs = null ;
      
       String date ;
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
              
              date = sdf.format(new Date()) ;
      
      
     sql = "select * from session where user = '"+this.user_c+"' and etat = 'OUI'" ;
     rs = stmt.executeQuery(sql) ;
     while(rs.next()){
         vy = 1 ;
     }
     
     if(vy == 1){
         
          stmt.executeUpdate("update session set date_close = '"+date+"' , etat = 'NON' where user = '"+this.user_c+"' and etat = 'OUI'") ;
         
         this.fc.setText("");
         
          this.jButton1.setEnabled(true) ;
          this.d_s.setVisible(false);
          
          this.v.setEnabled(false);
          this.sav.setEnabled(false);
          this.r.setEnabled(false);
          this.reserv.setEnabled(false);
          this.st.setEnabled(false);
          
          this.id_ss = 0 ;
          this.balance = 0 ;
         
         
         
           this.jButton2.setEnabled(false);
           this.v_s = 0 ;
         
         
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
        
       
              
        
            
                           
                     } else {
                       // no option
            
                        }
        
                
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   //    System.exit(1);
        
        this.setVisible(false) ;
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void descKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyReleased
           String txt = "" ;
        
        int i = desc.getText().lastIndexOf(" ") ;
        
        if(i < 0 ){
             txt = desc.getText() ;
        }else if(i > 0){
            
       txt = desc.getText().substring(i) ;
        
            
        }
        
       
        
            this.sg.laodList(txt) ;
                 sg.setVisible(false) ;
            
        this.addWindowListener( new WindowAdapter() {
               public void windowOpened( WindowEvent e ){
               desc.requestFocus();
               }
               }) ; 
        
        
    }//GEN-LAST:event_descKeyReleased
private long etat = 0 ;
private String cb ;


private int id_op1 = 0 ;
private int total_op1 = 0 ;

    private void jTable19MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable19MouseReleased
      
        
        
        
         
        this.cb = this.jTable19.getValueAt(this.jTable19.getSelectedRow(), 7).toString() ;
        String etat = this.jTable19.getValueAt(this.jTable19.getSelectedRow(), 10).toString() ;
         
        
         this.id_op1 = Integer.parseInt(this.jTable19.getValueAt(this.jTable19.getSelectedRow(), 2).toString().replaceAll("[^a-zA-Z0-9]", "")) ;
         this.total_op1 = Integer.parseInt(this.jTable19.getValueAt(this.jTable19.getSelectedRow(), 8).toString().replaceAll("[^a-zA-Z0-9]", "")) ;
        
        
        
            // D : 
        
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du7.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au7.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h17.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h27.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable18.getModel() ;
                             dtm.setRowCount(0) ;
                             
           DefaultTableModel dtm_ = (DefaultTableModel) jTable20.getModel() ;
                             dtm_.setRowCount(0) ;
        
       String sql = null ;
       ResultSet rs = null ;
       
       long to = 0 ;
       long py = 0 ;
       
 //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
           
           sql = "select * from detail_vente where cb_op = "+cb ;
         
      
         rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
             
             if(etat.equalsIgnoreCase("NON")){
                 
             }else if(etat.equalsIgnoreCase("OUI")){
     
             to += rs.getInt("mtt") ;
      
             }
             
       dtm.addRow(new Object[]{
     
   //   "DESCRIPTION", "QTE", "P.U", "MTT"
   
          rs.getString("description"), this.nf3.format(rs.getInt("qte")) , this.nf3.format(rs.getInt("pu")), this.nf3.format(rs.getInt("mtt")), etat
             
        
         }) ;
 
         }
         
         
         sql = "select * from payement where cb_op = "+cb ;
         
      
         rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
             
             if(rs.getString("etat").equalsIgnoreCase("NON") || etat.equalsIgnoreCase("NON")){
                 
                 
             }else{
     
             py += rs.getInt("mtt") ;
             
             }
             
             if(etat.equalsIgnoreCase("NON")){
                 
                   dtm_.addRow(new Object[]{
     
   //    "POS", "ID", "DATE", "USER", "MONTANT", "OBSERVATION"
   
           rs.getString("pos"), rs.getLong("id_py"), this.sdf_java_.format(rs.getTimestamp("datej")), 
           rs.getString("user"), this.nf3.format(rs.getInt("mtt")) , rs.getString("observation"), etat
             
        
         }) ;
                 
             }else if(etat.equalsIgnoreCase("OUI")){
             
      
       dtm_.addRow(new Object[]{
     
   //    "POS", "ID", "DATE", "USER", "MONTANT", "OBSERVATION"
   
           rs.getString("pos"), rs.getLong("id_py"), this.sdf_java_.format(rs.getTimestamp("datej")), 
           rs.getString("user"), this.nf3.format(rs.getInt("mtt")) , rs.getString("observation"), rs.getString("etat")
             
        
         }) ;
       
       
             }
             
 
         }

       
    long etat1 = (to - py) ;
    
    this.etat = etat1 ;
    
    this.py.setText("TOTAL PAYE : "+this.nf3.format(py)); 
    this.rl.setText("RESTE A PAYER : "+this.nf3.format(etat1));
       
       
       if(this.etat > 0){
           
           this.jButton8.setEnabled(true);
  
     // Py_cr py_ = new Py_cr(this.pos, this.user_c, Integer.parseInt(cb), etat) ;
       //     py_.setVisible(true) ;
            
       }else{
           this.jButton8.setEnabled(false) ;
       }
            
       
       if(etat.equalsIgnoreCase("NON")){
           
           jButton53.setEnabled(false);
            
          this.jButton54.setEnabled(false);
           
           
           sql = "select login_an , date_an from op_session where cb = "+this.cb ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    JOptionPane.showMessageDialog(null, "LOGIN : "+rs.getString("login_an")+System.getProperty("line.separator")+new String("DATE : "+this.sdf_java_.format(rs.getTimestamp("date_an")))) ;
                }
           
           
       }else  if(etat.equalsIgnoreCase("OUI")){
           
           jButton53.setEnabled(true);
         
       this.jButton54.setEnabled(true);
           
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
            
       
        
        
        
        
            
    }//GEN-LAST:event_jTable19MouseReleased

    private void bof1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bof1ActionPerformed
      
        this.session.setVisible(false);
        this.accueil.setVisible(true);
        this.vente.setVisible(false);
        this.service.setVisible(false);
        this.reprise.setVisible(false);
        this.reservation.setVisible(false);
        this.sortie_caisse.setVisible(false);
        this.suivi_op_cred.setVisible(false);
        this.suivi_ope_session.setVisible(false);
        
    }//GEN-LAST:event_bof1ActionPerformed

    private void desc2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desc2KeyReleased
         String txt = "" ;
        
        int i = desc2.getText().lastIndexOf(" ") ;
        
        if(i < 0 ){
             txt = desc2.getText() ;
        }else if(i > 0){
            
       txt = desc2.getText().substring(i) ;
        
            
        }
        
       
        
            this.sg.laodList(txt) ;
                 sg.setVisible(false) ;
            
        this.addWindowListener( new WindowAdapter() {
               public void windowOpened( WindowEvent e ){
               desc2.requestFocus();
               }
               }) ; 
        
        
    }//GEN-LAST:event_desc2KeyReleased

    private void desc3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desc3KeyReleased
         String txt = "" ;
        
        int i = desc3.getText().lastIndexOf(" ") ;
        
        if(i < 0 ){
             txt = desc3.getText() ;
        }else if(i > 0){
            
       txt = desc3.getText().substring(i) ;
        
            
        }
        
       
        
            this.sg.laodList(txt) ;
                 sg.setVisible(false) ;
            
        this.addWindowListener( new WindowAdapter() {
               public void windowOpened( WindowEvent e ){
               desc3.requestFocus();
               }
               }) ; 
        
    }//GEN-LAST:event_desc3KeyReleased

    private void desc4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desc4KeyReleased
       String txt = "" ;
        
        int i = desc4.getText().lastIndexOf(" ") ;
        
        if(i < 0 ){
             txt = desc4.getText() ;
        }else if(i > 0){
            
       txt = desc4.getText().substring(i) ;
        
            
        }
        
       
        
            this.sg.laodList(txt) ;
                 sg.setVisible(false) ;
            
        this.addWindowListener( new WindowAdapter() {
               public void windowOpened( WindowEvent e ){
               desc4.requestFocus();
               }
               }) ; 
        
    }//GEN-LAST:event_desc4KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
         
        String four, cat, desc1, qt, pu ;
        
        four = this.client1.getText().trim().replaceAll("'", "''") ;
        cat = this.contact1.getText().trim().replaceAll("'", "''") ;
        
        desc1 = desc.getText().trim().replaceAll("'", "''") ;
        qt = this.qte.getText() ;
        pu = this.pu.getText() ;
        
        if(four.isEmpty() || cat.isEmpty() || desc1.isEmpty() || qt.isEmpty() || pu.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }else{
            
            this.client1.setEnabled(false) ; this.contact1.setEnabled(false);
            
            this.mtt += (Integer.parseInt(qt) * Integer.parseInt(pu)) ;

            Detail_op dt = new Detail_op() ;
             
                      dt.setDescription(desc1) ;
                      dt.setQte(Integer.parseInt(qt)) ;
                      dt.setPu(Integer.parseInt(pu)) ;
                      dt.setMtt((Integer.parseInt(qt) * Integer.parseInt(pu))) ;
                      
                      
                      if(this.list_vy.contains(new String(dt.getDescription()))){
                          JOptionPane.showMessageDialog(null, "PRODUIT EXISTE DEJA") ;
                      }else{
                          
                          DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                          
                          this.list_vy.add(new String(dt.getDescription())) ;
                          this.list.add(dt) ;
                          
                          dtm.addRow(new Object[]{
                          
                              dt.getDescription(), dt.getQte(), dt.getPu(), dt.getMtt()
                              
                          }) ;
                          
                          this.t1.setText("TOTAL : "+this.nf3.format(this.mtt)) ;
                          desc.setText(""); this.qte.setText("") ; this.pu.setText("");
                          
                          
                      }
                      
                      
            
        }
        
        
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
           if(this.jTable1.getSelectedRow() == -1){
            
             JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }else{
            
        Integer mt = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString()) ;
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                          
                          this.list_vy.remove(this.jTable1.getSelectedRow()) ;
                          this.list.remove(this.jTable1.getSelectedRow()) ;
                          
                          this.mtt -= mt ;
                          
                           this.t1.setText("TOTAL : "+this.nf3.format(this.mtt)) ;
                           
                           
                           if(this.list.size() == 0){
                               
                              client1.setText("") ;
                              contact1.setText("") ;
                               
                                
                               
                               
                           }
                           
                           dtm.removeRow(this.jTable1.getSelectedRow()) ;
                           
        
            
             }
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
            
        if(this.list.size() > 0 && this.observ.getText().isEmpty() == false){
            
            
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
             
             Random rx = new Random() ;
             Integer cb = rx.nextInt() ;
             
             if(cb < 0){
                 
                 cb = Math.abs(cb) ;
                 
             }
      
      if(stmt.executeUpdate("insert into op_session(client, contact, pos, datej, user, total, type, observation, cb, id_ss) "
              + "values('"+this.client1.getText().replaceAll("'", "''")+"' , '"+this.contact1.getText().replaceAll("'", "''")+"' , '"+this.pos+"' , '"+date+"' , '"
              +this.user_c+"' , "+this.mtt+" , 'VENTE' , '"+this.observ.getText().replaceAll("'", "''")+"' , "+cb+" , "+this.id_ss+")") == 1){
          
          
      for(int i =0; i < this.list.size() ; i++){
          
          stmt.executeUpdate("insert into detail_vente(description, qte, pu, mtt, cb_op) "
              + "values('"+this.list.get(i).getDescription()+"' , "+this.list.get(i).getQte()+" , "+this.list.get(i).getPu()+" , "
                  +this.list.get(i).getMtt()+" , "+cb+")") ;
          
      }
      
      
          sql = "select * from session where id_ss = "+this.id_ss ;
          rs = stmt.executeQuery(sql) ;
          while(rs.next()){
              this.balance = rs.getInt("balance") ;
          }
          
          this.balance = ( this.balance + this.mtt ) ;
          
          stmt.executeUpdate("update session set balance = "+this.balance+" where id_ss = "+this.id_ss) ;
     
       this.client1.setText(""); this.contact1.setText(""); 
       this.desc.setText("") ; this.qte.setText(""); this.pu.setText("");
        
        
       this.list.removeAll(this.list) ; this.list_vy.removeAll(this.list_vy) ;
       
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
                           
                           this.mtt = 0 ;
                           this.t1.setText("TOTAL :") ;
                           
                           this.observ.setText("") ;
                           this.client1.setEnabled(true) ;
                           this.contact1.setEnabled(true) ;
                           
      JOptionPane.showMessageDialog(null, "OPERATION REUSSIT !!!") ;
      
      
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
        
       
            
            
        }else{
        
            JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }
        
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      
              
          
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
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
                             dtm.setRowCount(0) ;
                             
                             
        
       String sql = null ;
       ResultSet rs = null ;
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.observation as observ, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' and op_session.user = '"+this.user_c.replaceAll("'", "''")+"' and op_session.type = 'VENTE' "
              + "order by op_session.datej desc" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
    
   
      dtm.addRow(new Object[]{
     
      //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
   
  rs.getString("pos"), sdf1.format(rs.getTimestamp("date")), rs.getString("id") , rs.getString("login"), rs.getString("client"), rs.getString("contact")
  , this.nf3.format(rs.getInt("total")) , rs.getInt("cb") , rs.getString("observ"), rs.getString("etat")
             
        
        }) ;
 
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
        
             DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
                               dtm.setRowCount(0) ;
                               
                               this.mlist2 = new ArrayList<>() ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
        
        
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
       
        // , op_session.etat as etat
         
        String cb = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 7).toString() ;
        String etat = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 9).toString() ;
        
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
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel() ;
                             dtm.setRowCount(0) ;
                             
                             this.mlist2 = new ArrayList<>() ;
                             
                             
        
       String sql = null ;
       ResultSet rs = null ;
       
       long to = 0 ;
       
 //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
           
           sql = "select * from detail_vente where cb_op = "+cb ;
         
      
         rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
             
              
       HashMap<String, Object> m = new HashMap<>() ;
          
          m.put("description",  rs.getString("description")) ;
          m.put("qte", this.nf3.format(rs.getInt("qte"))) ;
          m.put("pu", this.nf3.format(rs.getInt("pu"))) ;
          m.put("mtt", this.nf3.format(rs.getInt("mtt"))) ;
                 
                this.mlist2.add(m) ;
          
     
             to += rs.getInt("mtt") ;
      
       dtm.addRow(new Object[]{
     
   //   "DESCRIPTION", "QTE", "P.U", "MTT"
   
          rs.getString("description"), this.nf3.format(rs.getInt("qte")) , this.nf3.format(rs.getInt("pu")), this.nf3.format(rs.getInt("mtt")), etat
             
        
         }) ;
 
         }

       
       if(etat.equalsIgnoreCase(new String("NON"))){
            sql = "select login_an , date_an from op_session where cb = "+cb ;
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
            
       
        
        
  
        
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyReleased
       
        
          
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
                             dtm.setRowCount(0) ;
                             
                               SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;    
                               
                               Integer id = 0 ;
                               
                               try{
                                   
                                   id = Integer.parseInt(this.id.getText()) ;
                                   
                               }catch(Exception e){
                                   id = 0 ;
                               }
        
       String sql = null ;
       ResultSet rs = null ;
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb "
              + "from op_session "
              + "where op_session.id_op = "+id+" and op_session.type = 'VENTE'" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
     
          
        
   
      dtm.addRow(new Object[]{
     
      //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
   
  rs.getString("pos"), sdf1.format(rs.getTimestamp("date")), rs.getString("id") , rs.getString("login"), rs.getString("client"), rs.getString("contact")
  , this.nf3.format(rs.getInt("total")) , rs.getInt("cb") 
             
        
        }) ;
 
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
            
       
        
        
        
    }//GEN-LAST:event_idKeyReleased

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        
         
        String four, cat, desc1, qt, pu ;
        
        four = this.client2.getText().trim().replaceAll("'", "''") ;
        cat = this.contact2.getText().trim().replaceAll("'", "''") ;
        
        desc1 = desc2.getText().trim().replaceAll("'", "''") ;
        qt = this.qte2.getText() ;
        pu = this.pu2.getText() ;
        
        if(four.isEmpty() || cat.isEmpty() || desc1.isEmpty() || qt.isEmpty() || pu.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }else{
            
            this.client2.setEnabled(false) ; this.contact2.setEnabled(false);
            
            this.mtt += (Integer.parseInt(qt) * Integer.parseInt(pu)) ;

            Detail_op dt = new Detail_op() ;
             
                      dt.setDescription(desc1) ;
                      dt.setQte(Integer.parseInt(qt)) ;
                      dt.setPu(Integer.parseInt(pu)) ;
                      dt.setMtt((Integer.parseInt(qt) * Integer.parseInt(pu))) ;
                      
                      
                      if(this.list_vy.contains(new String(dt.getDescription()))){
                          JOptionPane.showMessageDialog(null, "PRODUIT EXISTE DEJA") ;
                      }else{
                          
                          DefaultTableModel dtm = (DefaultTableModel) this.jTable21.getModel() ;
                          
                          this.list_vy.add(new String(dt.getDescription())) ;
                          this.list.add(dt) ;
                          
                          dtm.addRow(new Object[]{
                          
                              dt.getDescription(), dt.getQte(), dt.getPu(), dt.getMtt()
                              
                          }) ;
                          
                          this.t2.setText("TOTAL : "+this.nf3.format(this.mtt)) ;
                          desc2.setText(""); this.qte2.setText("") ; this.pu2.setText("");
                          
                          
                      }
                      
                      
            
        }
        
        
        
        
        
        
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        if(this.jTable21.getSelectedRow() == -1){
            
             JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }else{
            
        Integer mt = Integer.parseInt(this.jTable21.getValueAt(this.jTable21.getSelectedRow(), 3).toString()) ;
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable21.getModel() ;
                          
                          this.list_vy.remove(this.jTable21.getSelectedRow()) ;
                          this.list.remove(this.jTable21.getSelectedRow()) ;
                          
                          this.mtt -= mt ;
                          
                           this.t2.setText("TOTAL : "+this.nf3.format(this.mtt)) ;
                           
                           
                           if(this.list.size() == 0){
                               
                              client2.setText("") ;
                              contact2.setText("") ;
                               
                                
                               
                               
                           }
                           
                           dtm.removeRow(this.jTable21.getSelectedRow()) ;
                           
        
            
             }
        
        
        
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
     
        
            
        if(this.list.size() > 0 && this.observ2.getText().isEmpty() == false){
            
            
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
             
             Random rx = new Random() ;
             Integer cb = rx.nextInt() ;
             
             if(cb < 0){
                 
                 cb = Math.abs(cb) ;
                 
             }
      
      if(stmt.executeUpdate("insert into op_session(client, contact, pos, datej, user, total, type, observation, cb, id_ss) "
              + "values('"+this.client2.getText().replaceAll("'", "''")+"' , '"+this.contact2.getText().replaceAll("'", "''")+"' , '"+this.pos+"' , '"+date+"' , '"
              +this.user_c+"' , "+this.mtt+" , 'SERVICE' , '"+this.observ2.getText().replaceAll("'", "''")+"' , "+cb+" , "+this.id_ss+")") == 1){
          
          
      for(int i =0; i < this.list.size() ; i++){
          
          stmt.executeUpdate("insert into detail_vente(description, qte, pu, mtt, cb_op) "
              + "values('"+this.list.get(i).getDescription()+"' , "+this.list.get(i).getQte()+" , "+this.list.get(i).getPu()+" , "
                  +this.list.get(i).getMtt()+" , "+cb+")") ;
          
      }
          
          sql = "select * from session where id_ss = "+this.id_ss ;
          rs = stmt.executeQuery(sql) ;
          while(rs.next()){
              this.balance = rs.getInt("balance") ;
          }
          
          this.balance = ( this.balance + this.mtt ) ;
          
          stmt.executeUpdate("update session set balance = "+this.balance+" where id_ss = "+this.id_ss) ;
     
     
       this.client2.setText(""); this.contact2.setText(""); 
       this.desc2.setText("") ; this.qte2.setText(""); this.pu2.setText("");
        
        
       this.list.removeAll(this.list) ; this.list_vy.removeAll(this.list_vy) ;
       
         DefaultTableModel dtm = (DefaultTableModel) jTable21.getModel() ;
                           dtm.setRowCount(0) ;
                           
                           this.mtt = 0 ;
                           this.t2.setText("TOTAL :") ;
                           
                           this.observ2.setText("") ;
                           this.client2.setEnabled(true) ;
                           this.contact2.setEnabled(true) ;
                           
      JOptionPane.showMessageDialog(null, "OPERATION REUSSIT !!!") ;
      
      
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
        
       
            
            
        }else{
        
            JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
       
        
                   
          
        // D : 
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du1.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au1.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h11.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h22.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable23.getModel() ;
                             dtm.setRowCount(0) ;
        
       String sql = null ;
       ResultSet rs = null ;
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.observation as observ, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' and op_session.user = '"+this.user_c.replaceAll("'", "''")+"' and op_session.type = 'SERVICE' "
              + "order by op_session.datej desc" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
     
          
        
   
      dtm.addRow(new Object[]{
     
      //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
   
  rs.getString("pos"), sdf1.format(rs.getTimestamp("date")), rs.getString("id") , rs.getString("login"), rs.getString("client"), rs.getString("contact")
  , this.nf3.format(rs.getInt("total")) , rs.getInt("cb") , rs.getString("observ"), rs.getString("etat")
             
        
        }) ;
 
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
        
             DefaultTableModel dtm = (DefaultTableModel) jTable23.getModel() ;
                               dtm.setRowCount(0) ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
        
        
        
    }//GEN-LAST:event_jButton43ActionPerformed

    private void id2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id2KeyReleased
        
             
          
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable23.getModel() ;
                             dtm.setRowCount(0) ;
                             
                               SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;    
                               
                               Integer id = 0 ;
                               
                               try{
                                   
                                   id = Integer.parseInt(this.id2.getText()) ;
                                   
                               }catch(Exception e){
                                   id = 0 ;
                               }
        
       String sql = null ;
       ResultSet rs = null ;
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb "
              + "from op_session "
              + "where op_session.id_op = "+id+" and op_session.type = 'SERVICE'" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
     
          
        
   
      dtm.addRow(new Object[]{
     
      //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
   
  rs.getString("pos"), sdf1.format(rs.getTimestamp("date")), rs.getString("id") , rs.getString("login"), rs.getString("client"), rs.getString("contact")
  , this.nf3.format(rs.getInt("total")) , rs.getInt("cb") 
             
        
        }) ;
 
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
            
       
        
        
        
    }//GEN-LAST:event_id2KeyReleased

    private void jTable23MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable23MouseReleased
      
         
         
        String cb = this.jTable23.getValueAt(this.jTable23.getSelectedRow(), 7).toString() ;
        String etat = this.jTable23.getValueAt(this.jTable23.getSelectedRow(), 9).toString() ;
        
        
            // D : 
        
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du1.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au1.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h11.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h22.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable22.getModel() ;
                             dtm.setRowCount(0) ;
                             
                               this.mlist3 = new ArrayList<>() ;
                             
                             
                             
        
       String sql = null ;
       ResultSet rs = null ;
       
       long to = 0 ;
       
 //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
           
           sql = "select * from detail_vente where cb_op = "+cb ;
         
      
         rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
             
              HashMap<String, Object> m = new HashMap<>() ;
          
              //  this.mlist3 = new ArrayList<>() ;
              
          m.put("description",  rs.getString("description")) ;
          m.put("qte", this.nf3.format(rs.getInt("qte"))) ;
          m.put("pu", this.nf3.format(rs.getInt("pu"))) ;
          m.put("mtt", this.nf3.format(rs.getInt("mtt"))) ;
                 
                this.mlist3.add(m) ;
     
             to += rs.getInt("mtt") ;
      
       dtm.addRow(new Object[]{
     
   //   "DESCRIPTION", "QTE", "P.U", "MTT"
   
          rs.getString("description"), this.nf3.format(rs.getInt("qte")) , this.nf3.format(rs.getInt("pu")), this.nf3.format(rs.getInt("mtt")), etat
             
        
         }) ;
 
         }

       
         if(etat.equalsIgnoreCase(new String("NON"))){
            sql = "select login_an , date_an from op_session where cb = "+cb ;
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
            
       
        
        
        
    }//GEN-LAST:event_jTable23MouseReleased

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
         
        String four, cat, desc1, qt, pu ;
        
        four = this.client3.getText().trim().replaceAll("'", "''") ;
        cat = this.contact3.getText().trim().replaceAll("'", "''") ;
        
        desc1 = desc3.getText().trim().replaceAll("'", "''") ;
        qt = this.qte3.getText() ;
        pu = this.pu3.getText() ;
        
        if(four.isEmpty() || cat.isEmpty() || desc1.isEmpty() || qt.isEmpty() || pu.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }else{
            
            this.client3.setEnabled(false) ; this.contact3.setEnabled(false);
            
            this.mtt += (Integer.parseInt(qt) * Integer.parseInt(pu)) ;

            Detail_op dt = new Detail_op() ;
             
                      dt.setDescription(desc1) ;
                      dt.setQte(Integer.parseInt(qt)) ;
                      dt.setPu(Integer.parseInt(pu)) ;
                      dt.setMtt((Integer.parseInt(qt) * Integer.parseInt(pu))) ;
                      
                      
                      if(this.list_vy.contains(new String(dt.getDescription()))){
                          JOptionPane.showMessageDialog(null, "PRODUIT EXISTE DEJA") ;
                      }else{
                          
                          DefaultTableModel dtm = (DefaultTableModel) this.jTable25.getModel() ;
                          
                          this.list_vy.add(new String(dt.getDescription())) ;
                          this.list.add(dt) ;
                          
                          dtm.addRow(new Object[]{
                          
                              dt.getDescription(), dt.getQte(), dt.getPu(), dt.getMtt()
                              
                          }) ;
                          
                          this.t3.setText("TOTAL : "+this.nf3.format(this.mtt)) ;
                          desc3.setText(""); this.qte3.setText("") ; this.pu3.setText("");
                          
                          
                      }
                      
                      
            
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
         
        
        if(this.jTable25.getSelectedRow() == -1){
            
             JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }else{
            
        Integer mt = Integer.parseInt(this.jTable25.getValueAt(this.jTable25.getSelectedRow(), 3).toString()) ;
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable25.getModel() ;
                          
                          this.list_vy.remove(this.jTable25.getSelectedRow()) ;
                          this.list.remove(this.jTable25.getSelectedRow()) ;
                          
                          this.mtt -= mt ;
                          
                           this.t3.setText("TOTAL : "+this.nf3.format(this.mtt)) ;
                           
                           
                           if(this.list.size() == 0){
                               
                              client3.setText("") ;
                              contact3.setText("") ;
                               
                                
                               
                               
                           }
                           
                           dtm.removeRow(this.jTable25.getSelectedRow()) ;
                           
        
            
             }
        
        
        
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
       
        
            
        if(this.list.size() > 0 && this.observ3.getText().isEmpty() == false){
            
            
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
             
             Random rx = new Random() ;
             Integer cb = rx.nextInt() ;
             
             if(cb < 0){
                 
                 cb = Math.abs(cb) ;
                 
             }
      
      if(stmt.executeUpdate("insert into op_session(client, contact, pos, datej, user, total, type, observation, cb, id_ss) "
              + "values('"+this.client3.getText().replaceAll("'", "''")+"' , '"+this.contact3.getText().replaceAll("'", "''")+"' , '"+this.pos+"' , '"+date+"' , '"
              +this.user_c+"' , "+this.mtt+" , 'REPRISE' , '"+this.observ3.getText().replaceAll("'", "''")+"' , "+cb+" , "+this.id_ss+")") == 1){
          
          
      for(int i =0; i < this.list.size() ; i++){
          
          stmt.executeUpdate("insert into detail_vente(description, qte, pu, mtt, cb_op) "
              + "values('"+this.list.get(i).getDescription()+"' , "+this.list.get(i).getQte()+" , "+this.list.get(i).getPu()+" , "
                  +this.list.get(i).getMtt()+" , "+cb+")") ;
          
      }
      
      
          sql = "select * from session where id_ss = "+this.id_ss ;
          rs = stmt.executeQuery(sql) ;
          while(rs.next()){
              this.balance = rs.getInt("balance") ;
          }
          
          this.balance = ( this.balance - this.mtt ) ;
          
          stmt.executeUpdate("update session set balance = "+this.balance+" where id_ss = "+this.id_ss) ;
     
          
          
          
     
       this.client3.setText(""); this.contact3.setText(""); 
       this.desc3.setText("") ; this.qte3.setText(""); this.pu3.setText("");
        
        
       this.list.removeAll(this.list) ; this.list_vy.removeAll(this.list_vy) ;
       
         DefaultTableModel dtm = (DefaultTableModel) jTable25.getModel() ;
                           dtm.setRowCount(0) ;
                           
                           this.mtt = 0 ;
                           this.t2.setText("TOTAL :") ;
                           
                           this.observ3.setText("") ;
                           this.client3.setEnabled(true) ;
                           this.contact3.setEnabled(true) ;
                           
      JOptionPane.showMessageDialog(null, "OPERATION REUSSIT !!!") ;
      
      
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
        
       
            
            
        }else{
        
            JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }
        
        
        
        
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
       
                   
          
        // D : 
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du3.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au3.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h13.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h23.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable26.getModel() ;
                             dtm.setRowCount(0) ;
        
       String sql = null ;
       ResultSet rs = null ;
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' and op_session.user = '"+this.user_c.replaceAll("'", "''")+"' and op_session.type = 'REPRISE' "
              + "order by op_session.datej desc" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
     
          
        
   
      dtm.addRow(new Object[]{
     
      //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
   
  rs.getString("pos"), sdf1.format(rs.getTimestamp("date")), rs.getString("id") , rs.getString("login"), rs.getString("client"), rs.getString("contact")
  , this.nf3.format(rs.getInt("total")) , rs.getInt("cb") , rs.getString("etat")
             
        
        }) ;
 
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
        
             DefaultTableModel dtm = (DefaultTableModel) jTable26.getModel() ;
                               dtm.setRowCount(0) ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
        
    }//GEN-LAST:event_jButton47ActionPerformed

    private void id3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id3KeyReleased
     
          
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable26.getModel() ;
                             dtm.setRowCount(0) ;
                             
                               SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;    
                               
                               Integer id = 0 ;
                               
                               try{
                                   
                                   id = Integer.parseInt(this.id3.getText()) ;
                                   
                               }catch(Exception e){
                                   id = 0 ;
                               }
        
       String sql = null ;
       ResultSet rs = null ;
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb "
              + "from op_session "
              + "where op_session.id_op = "+id+" and op_session.type = 'REPRISE'" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
     
          
        
   
      dtm.addRow(new Object[]{
     
      //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
   
  rs.getString("pos"), sdf1.format(rs.getTimestamp("date")), rs.getString("id") , rs.getString("login"), rs.getString("client"), rs.getString("contact")
  , this.nf3.format(rs.getInt("total")) , rs.getInt("cb") 
             
        
        }) ;
 
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
            
       
    }//GEN-LAST:event_id3KeyReleased

    private void jTable26MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable26MouseReleased
      
         
        String cb = this.jTable26.getValueAt(this.jTable26.getSelectedRow(), 7).toString() ;
        String etat = this.jTable26.getValueAt(this.jTable26.getSelectedRow(), 8).toString() ;
        
            // D : 
        
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du3.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au3.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h13.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h23.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable24.getModel() ;
                             dtm.setRowCount(0) ;
        
       String sql = null ;
       ResultSet rs = null ;
       
       long to = 0 ;
       
 //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
           
           sql = "select * from detail_vente where cb_op = "+cb ;
         
      
         rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
     
             to += rs.getInt("mtt") ;
      
       dtm.addRow(new Object[]{
     
   //   "DESCRIPTION", "QTE", "P.U", "MTT"
   
          rs.getString("description"), this.nf3.format(rs.getInt("qte")) , this.nf3.format(rs.getInt("pu")), this.nf3.format(rs.getInt("mtt")), etat
             
        
         }) ;
 
         }

       
        if(etat.equalsIgnoreCase(new String("NON"))){
            sql = "select login_an , date_an from op_session where cb = "+cb ;
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
            
       
        
        
        
    }//GEN-LAST:event_jTable26MouseReleased

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
     
       
        String ref, montant, observ ;
               ref = this.ref.getText().trim() ;
               montant = this.montant.getText().trim() ;
               observ = this.obs.getText().trim().replaceAll("'", "''") ;
               
               if(ref.isEmpty() || montant.isEmpty() || observ.isEmpty()){
                   
                    JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
                   
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
             
             Random rx = new Random() ;
             Integer cb = rx.nextInt() ;
             
             if(cb < 0){
                 
                 cb = Math.abs(cb) ;
                 
             }
             
              sql = "select * from session where id_ss = "+this.id_ss ;
          rs = stmt.executeQuery(sql) ;
          while(rs.next()){
              this.balance = rs.getInt("balance") ;
          }
          
          
              
          this.balance = ( this.balance - Integer.parseInt(montant) ) ;
          
          stmt.executeUpdate("update session set balance = "+this.balance+" where id_ss = "+this.id_ss) ;
          
         
      
      if(stmt.executeUpdate("insert into sortie_caisse(pos, datej, user, ref, mtt, observation, id_ss) "
              + "values('"+this.pos+"' , '"+date+"' , '"+this.user_c+"' , '"+ref+"', "+montant+" , '"+observ+"' , "+this.id_ss+")") == 1){
          
          
     
         
          
         
     
       this.ref.setText("") ; 
       this.montant.setText("") ; this.obs.setText("");  
       
       
       
       
         DefaultTableModel dtm = (DefaultTableModel) jTable13.getModel() ;
                           dtm.setRowCount(0) ;
                           
                           
      
      JOptionPane.showMessageDialog(null, "OPERATION REUSSIT !!!") ;
      
      
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
        
               
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
      
           
          
        // D : 
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du5.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au5.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h15.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h25.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable13.getModel() ;
                             dtm.setRowCount(0) ;
                             
                             long to = 0 ;
        
       String sql = null ;
       ResultSet rs = null ;
       
       
           
           sql = "select sortie_caisse.pos as pos, sortie_caisse.id_st as id, sortie_caisse.user as login, sortie_caisse.datej as date, sortie_caisse.ref as ref, "
                   + "sortie_caisse.mtt as mtt, sortie_caisse.observation as observation, sortie_caisse.etat as etat "
              + "from sortie_caisse "
              + "where sortie_caisse.datej between '"+dte1+"' and '"+dte2+"' "
              + "order by sortie_caisse.datej desc" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
     if(rs.getString("etat").equalsIgnoreCase("OUI")){

             to += rs.getInt("mtt") ;
          
          }else{
         
          
            }
        
   
      dtm.addRow(new Object[]{
     
      //  "POS", "DATE", "ID", "USER", "REF SORTIE", "MONTANT", "OBSERVATION"
   
  rs.getString("pos"), sdf1.format(rs.getTimestamp("date"))  , rs.getString("id"), rs.getString("login") , rs.getString("ref"), this.nf3.format(rs.getInt("mtt"))
 , rs.getString("observation") , rs.getString("etat")
             
        
        }) ;
 
     }

       
      this.jLabel19.setText("TOTAL : "+this.nf3.format(to)) ;
       

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
        
             DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
                               dtm.setRowCount(0) ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
        
        
        
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
    
        
           
        String four, cat, desc1, qt, pu ;
        
        four = this.client4.getText().trim().replaceAll("'", "''") ;
        cat = this.contact4.getText().trim().replaceAll("'", "''") ;
        
        desc1 = desc4.getText().trim().replaceAll("'", "''") ;
        qt = this.qte4.getText() ;
        pu = this.pu4.getText() ;
        
        if(four.isEmpty() || cat.isEmpty() || desc1.isEmpty() || qt.isEmpty() || pu.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }else{
            
            this.client4.setEnabled(false) ; this.contact4.setEnabled(false);
            
            this.mtt += (Integer.parseInt(qt) * Integer.parseInt(pu)) ;

            Detail_op dt = new Detail_op() ;
             
                      dt.setDescription(desc1) ;
                      dt.setQte(Integer.parseInt(qt)) ;
                      dt.setPu(Integer.parseInt(pu)) ;
                      dt.setMtt((Integer.parseInt(qt) * Integer.parseInt(pu))) ;
                      
                      
                      if(this.list_vy.contains(new String(dt.getDescription()))){
                          JOptionPane.showMessageDialog(null, "PRODUIT EXISTE DEJA") ;
                      }else{
                          
                          DefaultTableModel dtm = (DefaultTableModel) this.jTable28.getModel() ;
                          
                          this.list_vy.add(new String(dt.getDescription())) ;
                          this.list.add(dt) ;
                          
                          dtm.addRow(new Object[]{
                          
                              dt.getDescription(), dt.getQte(), dt.getPu(), dt.getMtt()
                              
                          }) ;
                          
                          this.t4.setText("TOTAL : "+this.nf3.format(this.mtt)) ;
                          desc4.setText(""); this.qte4.setText("") ; this.pu4.setText("") ;
                          
                          
                      }
                      
                      
                      
            
                      }
        
        
        
        
        
        
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
       
            if(this.jTable28.getSelectedRow() == -1){
            
             JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }else{
            
        Integer mt = Integer.parseInt(this.jTable28.getValueAt(this.jTable28.getSelectedRow(), 3).toString()) ;
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable28.getModel() ;
                          
                          this.list_vy.remove(this.jTable28.getSelectedRow()) ;
                          this.list.remove(this.jTable28.getSelectedRow()) ;
                          
                          this.mtt -= mt ;
                          
                           this.t4.setText("TOTAL : "+this.nf3.format(this.mtt)) ;
                           
                           
                           if(this.list.size() == 0){
                               
                              client4.setText("") ;
                              this.client4.setEnabled(true);
                              contact4.setText("") ;
                              this.contact4.setEnabled(true) ;
                              
                               
                                
                               
                               
                           }
                           
                           dtm.removeRow(this.jTable28.getSelectedRow()) ;
                           
        
            
             }
        
        
        
        
        
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
       
               
        if(this.list.size() > 0 && this.observ4.getText().isEmpty() == false){
            
            
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
             
             Random rx = new Random() ;
             Integer cb = rx.nextInt() ;
             
             if(cb < 0){
                 
                 cb = Math.abs(cb) ;
                 
             }
      
      if(stmt.executeUpdate("insert into op_session(client, contact, pos, datej, user, total, type, avance, cb, id_ss) "
              + "values('"+this.client4.getText().replaceAll("'", "''")+"' , '"+this.contact4.getText().replaceAll("'", "''")+"' , '"+this.pos+"' , '"+date+"' , '"
              +this.user_c+"' , "+this.mtt+" , 'RESERVATION' , "+this.observ4.getText()+" , "+cb+" , "+this.id_ss+")") == 1){
          
          stmt.executeUpdate("insert into payement(pos,datej,user,mtt,observation,cb_op,id_ss) values('"+this.pos+"' , '"
    +date+"' , '"+this.user_c+"' , "+this.observ4.getText()+" , ' ' , "+cb+" , "+this.id_ss+")") ;
          
          
      for(int i =0; i < this.list.size() ; i++){
          
          stmt.executeUpdate("insert into detail_vente(description, qte, pu, mtt, cb_op) "
              + "values('"+this.list.get(i).getDescription()+"' , "+this.list.get(i).getQte()+" , "+this.list.get(i).getPu()+" , "
                  +this.list.get(i).getMtt()+" , "+cb+")") ;
          
          
      }
      
      
          sql = "select * from session where id_ss = "+this.id_ss ;
          rs = stmt.executeQuery(sql) ;
          while(rs.next()){
              this.balance = rs.getInt("balance") ;
          }
          
          
           String av0 = "" ;
                 av0 = this.observ4.getText().trim() ;
                 
                 if(av0.isEmpty()){
                     av0 = "0" ;
                  }
          
          this.balance = ( this.balance + Integer.parseInt(av0) ) ;
          
          stmt.executeUpdate("update session set balance = "+this.balance+" where id_ss = "+this.id_ss) ;
     
      
          
     
       this.client4.setText(""); this.contact4.setText(""); 
       this.desc4.setText("") ; this.qte4.setText(""); this.pu4.setText("");
        
        
       this.list.removeAll(this.list) ; this.list_vy.removeAll(this.list_vy) ;
       
         DefaultTableModel dtm = (DefaultTableModel) jTable28.getModel() ;
                           dtm.setRowCount(0) ;
                           
                           this.mtt = 0 ;
                           this.t4.setText("TOTAL :") ;
                           
                           this.observ4.setText("") ;
                           this.client4.setEnabled(true) ;
                           this.contact4.setEnabled(true) ;
                           
      JOptionPane.showMessageDialog(null, "OPERATION REUSSIT !!!") ;
      
      
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
        
       
            
            
        }else{
        
            JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton50ActionPerformed

    private void id4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id4KeyReleased
      
        
         
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable29.getModel() ;
                             dtm.setRowCount(0) ;
                             
                               SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;    
                               
                               Integer id = 0 ;
                               
                               try{
                                   
                                   id = Integer.parseInt(this.id4.getText()) ;
                                   
                               }catch(Exception e){
                                   id = 0 ;
                               }
        
       String sql = null ;
       ResultSet rs = null ;
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb "
              + "from op_session "
              + "where op_session.id_op = "+id+" and op_session.type = 'RESERVATION'" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
     
          
        
   
      dtm.addRow(new Object[]{
     
      //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
   
  rs.getString("pos"), sdf1.format(rs.getTimestamp("date")), rs.getString("id") , rs.getString("login"), rs.getString("client"), rs.getString("contact")
  , this.nf3.format(rs.getInt("total")) , rs.getInt("cb") 
             
        
        }) ;
 
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
            
       
        
    }//GEN-LAST:event_id4KeyReleased

    private void jTable29MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable29MouseReleased
      
        
         
        String cb = this.jTable29.getValueAt(this.jTable29.getSelectedRow(), 7).toString() ;
        String etat = this.jTable29.getValueAt(this.jTable29.getSelectedRow(), 9).toString() ;
        
        
            // D : 
        
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du4.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au4.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h14.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h24.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable27.getModel() ;
                             dtm.setRowCount(0) ;
                             
                             
                             this.mlist4 = new ArrayList<>() ;
                             
                             
        
       String sql = null ;
       ResultSet rs = null ;
       
       long to = 0 ;
       
 //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
           
           sql = "select * from detail_vente where cb_op = "+cb ;
         
      
         rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
             
          HashMap<String, Object> m = new HashMap<>() ;
          
              //  this.mlist3 = new ArrayList<>() ;
              
          m.put("description",  rs.getString("description")) ;
          m.put("qte", this.nf3.format(rs.getInt("qte"))) ;
          m.put("pu", this.nf3.format(rs.getInt("pu"))) ;
          m.put("mtt", this.nf3.format(rs.getInt("mtt"))) ;
                 
                this.mlist4.add(m) ;
     
             
     
             to += rs.getInt("mtt") ;
      
       dtm.addRow(new Object[]{
     
   //   "DESCRIPTION", "QTE", "P.U", "MTT"
   
          rs.getString("description"), this.nf3.format(rs.getInt("qte")) , this.nf3.format(rs.getInt("pu")), this.nf3.format(rs.getInt("mtt")), etat
             
        
         }) ;
 
         }

       
          if(etat.equalsIgnoreCase(new String("NON"))){
            sql = "select login_an , date_an from op_session where cb = "+cb ;
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
            
       
        
        
        
        
    }//GEN-LAST:event_jTable29MouseReleased

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
     
        
            
          
        // D : 
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du4.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au4.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h14.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h24.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable29.getModel() ;
                             dtm.setRowCount(0) ;
        
       String sql = null ;
       ResultSet rs = null ;
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.observation as observ, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' and op_session.user = '"+this.user_c.replaceAll("'", "''")+"' and op_session.type = 'RESERVATION' "
              + "order by op_session.datej desc" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
     
          
        
   
      dtm.addRow(new Object[]{
     
      //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
   
  rs.getString("pos"), sdf1.format(rs.getTimestamp("date")), rs.getString("id") , rs.getString("login"), rs.getString("client"), rs.getString("contact")
  , this.nf3.format(rs.getInt("total")) , rs.getInt("cb") , rs.getString("observ"), rs.getString("etat")
             
        
        }) ;
 
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
        
             DefaultTableModel dtm = (DefaultTableModel) jTable29.getModel() ;
                               dtm.setRowCount(0) ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
        
        
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
      
         
          
        // D : 
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du6.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au6.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h16.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h26.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable16.getModel() ;
                             dtm.setRowCount(0) ;
        
       String sql = null ;
       ResultSet rs = null ;
       
       
       if(this.user.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.op.getSelectedItem().toString().equalsIgnoreCase("TOUT")){
           
           
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' "
              + "order by op_session.datej desc" ;
           
       }else if(this.user.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.op.getSelectedItem().toString().equalsIgnoreCase("TOUT")){
           
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' and op_session.user = '"+this.user.getSelectedItem().toString().replaceAll("'", "''")+"' "
              + "order by op_session.datej desc" ;
           
           
}else if(this.user.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.op.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false){
    
    String op = null ;
    
    
    if(this.op.getSelectedItem().toString().equalsIgnoreCase("VENTE DIRECT")){
        op = "VENTE" ;
      }else if(this.op.getSelectedItem().toString().equalsIgnoreCase("SERVICE APRES VENTE")){
        op = "SERVICE" ;
      }else if(this.op.getSelectedItem().toString().equalsIgnoreCase("REPRISE")){
        op = "REPRISE" ;
      }else if(this.op.getSelectedItem().toString().equalsIgnoreCase("RESERVATION")){
        op = "RESERVATION" ;
      }
    
           
            sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' and op_session.user = '"+this.user.getSelectedItem().toString().replaceAll("'", "''")+"' "
              + "and op_session.type = '"+op+"' order by op_session.datej desc" ;
           
       }else if(this.user.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.op.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false){
           
           String op = null ;
    
    
    if(this.op.getSelectedItem().toString().equalsIgnoreCase("VENTE DIRECT")){
        op = "VENTE" ;
      }else if(this.op.getSelectedItem().toString().equalsIgnoreCase("SERVICE APRES VENTE")){
        op = "SERVICE" ;
      }else if(this.op.getSelectedItem().toString().equalsIgnoreCase("REPRISE")){
        op = "REPRISE" ;
      }else if(this.op.getSelectedItem().toString().equalsIgnoreCase("RESERVATION")){
        op = "RESERVATION" ;
      }
    
           
            sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' "
              + "and op_session.type = '"+op+"' order by op_session.datej desc" ;
           
           
       }
     
      
        rs = stmt.executeQuery(sql) ;
     
        while(rs.next()){
   
      dtm.addRow(new Object[]{
     
      //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
   
  rs.getString("pos"), sdf1.format(rs.getTimestamp("date")), rs.getString("id") , rs.getString("login"), rs.getString("client"), rs.getString("contact")
  , this.nf3.format(rs.getInt("total")) , rs.getInt("cb") , rs.getString("etat")
             
        
        }) ;
 
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
        
             DefaultTableModel dtm = (DefaultTableModel) jTable29.getModel() ;
                               dtm.setRowCount(0) ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
        
        
    }//GEN-LAST:event_jButton30ActionPerformed
private int id_op = 0 ;
private int total_op = 0 ;

    private void jTable16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable16MouseReleased
      
         
        String cb = this.jTable16.getValueAt(this.jTable16.getSelectedRow(), 7).toString() ;
        String etat = this.jTable16.getValueAt(this.jTable16.getSelectedRow(), 8).toString() ;
        
        this.id_op = Integer.parseInt(this.jTable16.getValueAt(this.jTable16.getSelectedRow(), 2).toString().replaceAll("[^a-zA-Z0-9]", "")) ;
        this.total_op = Integer.parseInt(this.jTable16.getValueAt(this.jTable16.getSelectedRow(), 6).toString().replaceAll("[^a-zA-Z0-9]", "")) ;
        
        
        if(etat.equalsIgnoreCase(new String("NON"))){
            jButton31.setEnabled(false);
        }else if(etat.equalsIgnoreCase(new String("OUI"))){
            jButton31.setEnabled(true);
        }
        
        
            // D : 
        
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du6.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au6.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h16.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h26.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable15.getModel() ;
                             dtm.setRowCount(0) ;
        
       String sql = null ;
       ResultSet rs = null ;
       
       long to = 0 ;
       
 //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
           
           sql = "select * from detail_vente where cb_op = "+cb ;
         
      
         rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
             
             if(etat.equalsIgnoreCase("NON")){
                  
             }else{
     
             to += rs.getInt("mtt") ;
              
             
             }
      
       dtm.addRow(new Object[]{
     
   //   "DESCRIPTION", "QTE", "P.U", "MTT"
   
          rs.getString("description"), this.nf3.format(rs.getInt("qte")) , this.nf3.format(rs.getInt("pu")), this.nf3.format(rs.getInt("mtt")), etat
             
        
         }) ;
 
         }

       
        if(etat.equalsIgnoreCase(new String("NON"))){
            sql = "select login_an , date_an from op_session where cb = "+cb ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    JOptionPane.showMessageDialog(null, "LOGIN : "+rs.getString("login_an")+System.getProperty("line.separator")+new String("DATE : "+this.sdf_java_.format(rs.getTimestamp("date_an")))) ;
                }
        }
        
        
        
         if(etat.equalsIgnoreCase("NON")){
                 this.jButton31.setEnabled(false);
             }else if("RESERVATION".equalsIgnoreCase(this.op.getSelectedItem().toString())){
      
             this.jButton31.setEnabled(false);
             
             }else{
                  this.jButton31.setEnabled(true);
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
            
       
        
        
    }//GEN-LAST:event_jTable16MouseReleased

    private void id6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id6KeyReleased
    
        
         
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable16.getModel() ;
                             dtm.setRowCount(0) ;
                             
                               SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;    
                               
                               Integer id = 0 ;
                               
                               try{
                                   
                                   id = Integer.parseInt(this.id6.getText()) ;
                                   
                               }catch(Exception e){
                                   id = 0 ;
                               }
        
       String sql = null ;
       ResultSet rs = null ;
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.id_op = "+id ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
     
          
        
   
      dtm.addRow(new Object[]{
     
      //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
   
  rs.getString("pos"), sdf1.format(rs.getTimestamp("date")), rs.getString("id") , rs.getString("login"), rs.getString("client"), rs.getString("contact")
  , this.nf3.format(rs.getInt("total")) , rs.getInt("cb") , rs.getString("etat")
             
        
        }) ;
 
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
            
        
    }//GEN-LAST:event_id6KeyReleased

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        
          
        // D : 
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du7.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au7.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h17.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h27.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable19.getModel() ;
                             dtm.setRowCount(0) ;
                             
                             this.mlist1 = new ArrayList<>() ;
        
       String sql = null ;
       ResultSet rs = null ;
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb , sum(payement.mtt) as paye, op_session.etat as etat "
              + "from op_session, payement "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' and op_session.type = 'RESERVATION' and payement.cb_op = op_session.cb "
                   + "and payement.etat = 'OUI' "
              + "group by op_session.cb order by op_session.datej desc" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
          if(rs.getString("etat").equalsIgnoreCase("NON")){
              
          }else{
     
          HashMap<String, Object> m = new HashMap<>() ;
          
          m.put("pos",  rs.getString("pos")) ;
          m.put("date", sdf1.format(rs.getTimestamp("date"))) ;
          m.put("id", rs.getString("id")) ;
          m.put("user", rs.getString("login")) ;
          m.put("client", rs.getString("client")) ;
          m.put("contact", rs.getString("contact")) ;
          m.put("total", this.nf3.format(rs.getInt("total"))) ;
          m.put("avance",  this.nf3.format(rs.getInt("paye"))) ;
          m.put("reliquat", this.nf3.format((rs.getInt("total") - rs.getInt("paye")))) ;
                      
                this.mlist1.add(m) ;
        
          }
          
      dtm.addRow(new Object[]{
     
      //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
   
  rs.getString("pos"), sdf1.format(rs.getTimestamp("date")), rs.getString("id") , rs.getString("login"), rs.getString("client"), rs.getString("contact")
  , this.nf3.format(rs.getInt("total")) , rs.getInt("cb") , this.nf3.format(rs.getInt("paye")) , this.nf3.format((rs.getInt("total") - rs.getInt("paye")))
  , rs.getString("etat")
        
        }) ;
 
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
        
             DefaultTableModel dtm = (DefaultTableModel) jTable19.getModel() ;
                               dtm.setRowCount(0) ;
      
                              this.mlist1 = new ArrayList<>() ;
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
        
        
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        
          String mt, observ ;
               mt = this.mt.getText().trim() ;
               observ = this.ob.getText().trim().replaceAll("'", "''") ;
               
               if(mt.isEmpty() || observ.isEmpty()){
                   JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
                }else{
                   
                   long vy_m = Long.parseLong(mt) ;
                   
                   if(vy_m > this.etat){
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
          
      
          
    stmt.executeUpdate("insert into payement(pos,datej,user,mtt,observation,cb_op, etat,id_ss) values('"+this.pos+"' , '"
    +date+"' , '"+this.user_c+"' , "+mt+" , '"+observ+"' , "+this.cb+" , 'OUI' , "+this.id_ss+")") ;
    
    String sql = null ;
    ResultSet rs = null ;
      sql = "select * from session where id_ss = "+this.id_ss ;
          rs = stmt.executeQuery(sql) ;
          while(rs.next()){
              this.balance = rs.getInt("balance") ;
          }
          
          
           String av0 = "" ;
                 av0 = this.mt.getText().trim() ;
                 
                 if(av0.isEmpty()){
                     av0 = "0" ;
                  }
          
          this.balance = ( this.balance + Integer.parseInt(av0) ) ;
          
          stmt.executeUpdate("update session set balance = "+this.balance+" where id_ss = "+this.id_ss) ;
     
      
          
          
    
     
       this.mt.setText(""); this.ob.setText("") ; 
        
       
               
               
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
        
      
        
        
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        // TODO add your handling code here:
        
         try{
             
        this.jButton52.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
                  
                        // charge in local
         InputStream in = getClass().getClassLoader().getResourceAsStream("tp3_reporting/so_credit.jrxml") ;
         
               // collection generate
         JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.mlist1) ;
            
               // initialise parameter to send in reporting:
                 Map<String, Object> para = new HashMap<>() ;
                 
                 
                 
                 
   para.put("periode", "PERIODE : DU "+this.sdf_java.format(this.du.getSelectedDate().getTime())+" "+this.h1.getText()+" AU "+this.sdf_java.format(this.au.getSelectedDate().getTime())+" "+this.h2.getText()) ;
               
                
                  
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para,   jrbean) ; // new JREmptyDataSource());
           
           JasperViewer.viewReport(print, false) ;
            
          //  JasperPrintManager.printReport(print, false) ;
            
            
             this.jButton52.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
               
             //   jasper printer :
        //
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        
        
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable2.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "PARAMETRE INCORRECT !") ;
            
        }else{
            
             try{
            
              this.jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
                  
                        // charge in local
         InputStream in = getClass().getClassLoader().getResourceAsStream("tp3_reporting/facture.jrxml") ;
         
               // collection generate
         JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.mlist2) ;
            
               // initialise parameter to send in reporting:
                 Map<String, Object> para = new HashMap<>() ;
             
                 para.put("cb", this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 7).toString()) ;
                 para.put("id", "N°FACTURE : "+this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 2).toString()) ;
                 para.put("client", "CLIENT : "+this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 4).toString()) ;
                 para.put("contact", "CONTACT : "+this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 5).toString()) ;
                 para.put("op", "LOGIN : "+this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 3).toString()) ;
                 para.put("date", "BAMAKO LE, "+this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString()) ;
                 para.put("pos", "POST : "+this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString()) ;
                 para.put("observ", "OBSERVATION : "+this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 8).toString()) ;
                 para.put("total", "TOTAL : "+this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 6).toString()) ;
               
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para,   jrbean) ; // new JREmptyDataSource());
           
           JasperViewer.viewReport(print, false) ;
            
          //  JasperPrintManager.printReport(print, false) ;
            
            
             this.jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
               
             //   jasper printer :
        //
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
            
            
        }
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        
         
        if(this.jTable23.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "PARAMETRE INCORRECT !") ;
            
        }else{
            
             try{
            
              this.jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
                  
                        // charge in local
         InputStream in = getClass().getClassLoader().getResourceAsStream("tp3_reporting/facture.jrxml") ;
         
               // collection generate
         JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.mlist3) ;
            
               // initialise parameter to send in reporting:
                 Map<String, Object> para = new HashMap<>() ;
             
                 para.put("cb", this.jTable23.getValueAt(this.jTable23.getSelectedRow(), 7).toString()) ;
                 para.put("id", "N°FACTURE : "+this.jTable23.getValueAt(this.jTable23.getSelectedRow(), 2).toString()) ;
                 para.put("client", "CLIENT : "+this.jTable23.getValueAt(this.jTable23.getSelectedRow(), 4).toString()) ;
                 para.put("contact", "CONTACT : "+this.jTable23.getValueAt(this.jTable23.getSelectedRow(), 5).toString()) ;
                 para.put("op", "LOGIN : "+this.jTable23.getValueAt(this.jTable23.getSelectedRow(), 3).toString()) ;
                 para.put("date", "BAMAKO LE, "+this.jTable23.getValueAt(this.jTable23.getSelectedRow(), 1).toString()) ;
                 para.put("pos", "POST : "+this.jTable23.getValueAt(this.jTable23.getSelectedRow(), 0).toString()) ;
                 para.put("observ", "OBSERVATION : "+this.jTable23.getValueAt(this.jTable23.getSelectedRow(), 8).toString()) ;
                 para.put("total", "TOTAL : "+this.jTable23.getValueAt(this.jTable23.getSelectedRow(), 6).toString()) ;
               
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para,   jrbean) ; // new JREmptyDataSource());
           
           JasperViewer.viewReport(print, false) ;
            
          //  JasperPrintManager.printReport(print, false) ;
            
            
             this.jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
               
             //   jasper printer :
        //
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
            
            
        }
        
        
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
      
          
        if(this.jTable29.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "PARAMETRE INCORRECT !") ;
            
        }else{
            
             try{
            
              this.jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
                  
                        // charge in local
         InputStream in = getClass().getClassLoader().getResourceAsStream("tp3_reporting/facture.jrxml") ;
         
               // collection generate
         JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.mlist4) ;
            
               // initialise parameter to send in reporting:
                 Map<String, Object> para = new HashMap<>() ;
             
                 para.put("cb", this.jTable29.getValueAt(this.jTable29.getSelectedRow(), 7).toString()) ;
                 para.put("id", "N°FACTURE : "+this.jTable29.getValueAt(this.jTable29.getSelectedRow(), 2).toString()) ;
                 para.put("client", "CLIENT : "+this.jTable29.getValueAt(this.jTable29.getSelectedRow(), 4).toString()) ;
                 para.put("contact", "CONTACT : "+this.jTable29.getValueAt(this.jTable29.getSelectedRow(), 5).toString()) ;
                 para.put("op", "LOGIN : "+this.jTable29.getValueAt(this.jTable29.getSelectedRow(), 3).toString()) ;
                 para.put("date", "BAMAKO LE, "+this.jTable29.getValueAt(this.jTable29.getSelectedRow(), 1).toString()) ;
                 para.put("pos", "POST : "+this.jTable29.getValueAt(this.jTable29.getSelectedRow(), 0).toString()) ;
                 para.put("observ",   "") ; // "OBSERVATION : "+this.jTable29.getValueAt(this.jTable29.getSelectedRow(), 8).toString()) ;
                 para.put("total", "TOTAL : "+this.jTable29.getValueAt(this.jTable29.getSelectedRow(), 6).toString()) ;
               
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para,   jrbean) ; // new JREmptyDataSource());
           
           JasperViewer.viewReport(print, false) ;
            
          //  JasperPrintManager.printReport(print, false) ;
            
            
             this.jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
               
             //   jasper printer :
        //
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
            
            
        }
        
        
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed

        
         if (JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS ANNULER ?", "CONFIRMATION",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        // yes option


        
        if(this.jTable16.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "PARAMETRE INCORRECT !") ;
            
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
      
  int bl = 0 ;
  long session = 0 ;
  
  sql = "select id_ss from op_session where id_op = "+this.id_op ;
  rs = stmt.executeQuery(sql) ;
  while(rs.next()){
      session = rs.getLong("id_ss") ;
  }
  
  sql = "select balance from session where id_ss = "+session ;
  rs = stmt.executeQuery(sql) ;
  while(rs.next()){
      bl = rs.getInt("balance") ;
  }
  
  Integer new_bl = 0 ;
  
  if("REPRISE".equalsIgnoreCase(this.op.getSelectedItem().toString()) == true){
      
       new_bl = (bl + this.total_op) ;
      
  }else{
  
   new_bl = (bl - this.total_op) ;
  
  }
  
  stmt.executeUpdate("update session set balance = "+new_bl+" where id_ss = "+session) ;
      
if(stmt.executeUpdate("update op_session set etat = 'NON' , login_an = '"+this.user_c.replace("'", "''")+"' , date_an = '"+this.sdf_mysql_.format(new Date())+"' "
              + "where id_op = "+this.jTable16.getValueAt(this.jTable16.getSelectedRow(), 2).toString()) == 1){
      
      
         
       this.jTable16.setValueAt(new String("NON"), this.jTable16.getSelectedRow(), 8) ;
       this.jTable16.getSelectionModel().clearSelection() ;
      
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
        
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed

         if (JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS ANNULER ?", "CONFIRMATION",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        // yes option
        
        if(this.jTable19.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "PARAMETRE INCORRECT !") ;
            
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
      
      
       int bl = 0 ;
       long session = 0 ;
  
  sql = "select id_ss from op_session where id_op = "+this.id_op1 ;
  rs = stmt.executeQuery(sql) ;
  while(rs.next()){
      session = rs.getLong("id_ss") ;
  }
  
  sql = "select balance from session where id_ss = "+session ;
  rs = stmt.executeQuery(sql) ;
  while(rs.next()){
      bl = rs.getInt("balance") ;
  }
  
  Integer new_bl = (bl - this.total_op1) ;
  
  stmt.executeUpdate("update session set balance = "+new_bl+" where id_ss = "+session) ;
      
  
      
if(stmt.executeUpdate("update op_session set etat = 'NON' , login_an = '"+this.user_c.replace("'", "''")+"' , date_an = '"+this.sdf_mysql_.format(new Date())+"' "
              + "where id_op = "+this.jTable19.getValueAt(this.jTable19.getSelectedRow(), 2).toString()) == 1){
      
      
         
       this.jTable19.setValueAt("NON", this.jTable19.getSelectedRow(), 10);
       this.jTable19.getSelectionModel().clearSelection();
       
       this.jButton53.setEnabled(false);
       this.jButton54.setEnabled(false);
      
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
        
        
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed

         if (JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS ANNULER ?", "CONFIRMATION",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        // yes option


        
        if(this.jTable20.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "PARAMETRE INCORRECT !") ;
            
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
      
  
      
if(stmt.executeUpdate("update payement set etat = 'NON' , login_an = '"+this.user_c.replace("'", "''")+"' , date_an = '"+this.sdf_mysql_.format(new Date())+"' "
              + "where id_py = "+this.jTable20.getValueAt(this.jTable20.getSelectedRow(), 1).toString()) == 1){
      
      
         
       this.jTable20.setValueAt("NON", this.jTable20.getSelectedRow(), 6);
       this.jTable20.getSelectionModel().clearSelection();
      
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
        
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jTable20MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable20MouseReleased
       
        String etat = this.jTable20.getValueAt(this.jTable20.getSelectedRow(), 6).toString() ;
        
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
       
            
       String sql = null ;
       ResultSet rs = null ;
       
        
       if(etat.equalsIgnoreCase("NON")){
           
           jButton54.setEnabled(false);
           
           
           sql = "select login_an , date_an from payement where id_py = "+this.jTable20.getValueAt(this.jTable20.getSelectedRow(), 1).toString() ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    JOptionPane.showMessageDialog(null, "LOGIN : "+rs.getString("login_an")+System.getProperty("line.separator")+new String("DATE : "+this.sdf_java_.format(rs.getTimestamp("date_an")))) ;
                }
                
                
                rs.close();
           
           
       }else  if(etat.equalsIgnoreCase("OUI")){
           
           jButton54.setEnabled(true);
           
       }
            

 //     rs.close();
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
            
       
        
        
        
    }//GEN-LAST:event_jTable20MouseReleased

    
    private int id_op2 = 0 ;
    private int total_op2 = 0 ;
    
    
    private void jTable13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable13MouseReleased
     
        
        
      String id = this.jTable13.getValueAt(this.jTable13.getSelectedRow(), 2).toString() ;
      String etat = this.jTable13.getValueAt(this.jTable13.getSelectedRow(), 7).toString() ;
      
      
      if(etat.equalsIgnoreCase("NON")){
          this.jButton24.setEnabled(false);
      }
      
      
        this.id_op2 = Integer.parseInt(this.jTable13.getValueAt(this.jTable13.getSelectedRow(), 2).toString().replaceAll("[^a-zA-Z0-9]", "")) ;
        this.total_op2 = Integer.parseInt(this.jTable13.getValueAt(this.jTable13.getSelectedRow(), 5).toString().replaceAll("[^a-zA-Z0-9]", "")) ;
        
         
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
       
         
        
       String sql = null ;
       ResultSet rs = null ;
       
        
       
          if(etat.equalsIgnoreCase(new String("NON"))){
            sql = "select login_an , date_an from sortie_caisse where id_st = "+id ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    JOptionPane.showMessageDialog(null, "LOGIN : "+rs.getString("login_an")+System.getProperty("line.separator")+new String("DATE : "+this.sdf_java_.format(rs.getTimestamp("date_an")))) ;
                }
                
                 rs.close();
        }
        
        

     
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
            
       
          
        
        
    }//GEN-LAST:event_jTable13MouseReleased

    private void jCheckBox1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseReleased
    
        
        if(this.jCheckBox1.isSelected()){
            this.client1.setText("CLIENT COMPTOIR");
            this.contact1.setText("00000000");
        }else{
             this.client1.setText("");
             this.contact1.setText("");
        }
        
    }//GEN-LAST:event_jCheckBox1MouseReleased

    private void jCheckBox2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox2MouseReleased
      if(this.jCheckBox2.isSelected()){
            this.client2.setText("CLIENT COMPTOIR");
            this.contact2.setText("00000000");
        }else{
             this.client2.setText("");
             this.contact2.setText("");
        }
    }//GEN-LAST:event_jCheckBox2MouseReleased

    private void jCheckBox3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox3MouseReleased
      
       if(this.jCheckBox3.isSelected()){
            this.client3.setText("CLIENT COMPTOIR");
            this.contact3.setText("00000000");
        }else{
             this.client3.setText("");
             this.contact3.setText("");
        } 
        
        
    }//GEN-LAST:event_jCheckBox3MouseReleased

    private void jCheckBox4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox4MouseReleased
        if(this.jCheckBox4.isSelected()){
            this.client4.setText("CLIENT COMPTOIR");
            this.contact4.setText("00000000");
        }else{
             this.client4.setText("");
             this.contact4.setText("");
        } 
    }//GEN-LAST:event_jCheckBox4MouseReleased

    private void bof2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bof2ActionPerformed

        Menu mf = new Menu(this.user_c, this.role, this.nom_c, this.pos) ; // (login1 , role, n_c, id_post, nom_ordi, pos) ;

        mf.setVisible(true) ;

        this.dispose() ;

    }//GEN-LAST:event_bof2ActionPerformed

    private void clFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clFocusGained
      
        
        String cl = this.cl.getText() ;
        
               if(cl.equalsIgnoreCase("CLIENT")){
                   this.cl.setText("");
               }
        
    }//GEN-LAST:event_clFocusGained

    private void clFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clFocusLost
        String cl = this.cl.getText().trim() ;
        
               if(cl.isEmpty()){
                   this.cl.setText("CLIENT");
               }
    }//GEN-LAST:event_clFocusLost

    private void clKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clKeyReleased
        
        
        
          
        // D : 
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du6.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au6.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h16.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h26.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable16.getModel() ;
                             dtm.setRowCount(0) ;
        
       String sql = null ;
       ResultSet rs = null ;
       
       
       if(this.user.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.op.getSelectedItem().toString().equalsIgnoreCase("TOUT")){
           
           
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' and op_session.client like '%"+this.cl.getText().trim().replaceAll("'", "''")+"%' "
              + "order by op_session.datej desc" ;
           
       }else if(this.user.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.op.getSelectedItem().toString().equalsIgnoreCase("TOUT")){
           
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' and op_session.user = '"+this.user.getSelectedItem().toString().replaceAll("'", "''")+"' "
                   + "and op_session.client like '%"+this.cl.getText().trim().replaceAll("'", "''")+"%' "
              + "order by op_session.datej desc" ;
           
           
}else if(this.user.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false && this.op.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false){
    
    String op = null ;
    
    
    if(this.op.getSelectedItem().toString().equalsIgnoreCase("VENTE DIRECT")){
        op = "VENTE" ;
      }else if(this.op.getSelectedItem().toString().equalsIgnoreCase("SERVICE APRES VENTE")){
        op = "SERVICE" ;
      }else if(this.op.getSelectedItem().toString().equalsIgnoreCase("REPRISE")){
        op = "REPRISE" ;
      }else if(this.op.getSelectedItem().toString().equalsIgnoreCase("RESERVATION")){
        op = "RESERVATION" ;
      }
    
           
            sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' and op_session.user = '"+this.user.getSelectedItem().toString().replaceAll("'", "''")+"' "
              + "and op_session.type = '"+op+"' "
                    + "and op_session.client like '%"+this.cl.getText().trim().replaceAll("'", "''")+"%' "
                    + "order by op_session.datej desc" ;
           
       }else if(this.user.getSelectedItem().toString().equalsIgnoreCase("TOUT") && this.op.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false){
           
           String op = null ;
    
    
    if(this.op.getSelectedItem().toString().equalsIgnoreCase("VENTE DIRECT")){
        op = "VENTE" ;
      }else if(this.op.getSelectedItem().toString().equalsIgnoreCase("SERVICE APRES VENTE")){
        op = "SERVICE" ;
      }else if(this.op.getSelectedItem().toString().equalsIgnoreCase("REPRISE")){
        op = "REPRISE" ;
      }else if(this.op.getSelectedItem().toString().equalsIgnoreCase("RESERVATION")){
        op = "RESERVATION" ;
      }
    
           
            sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb, op_session.etat as etat "
              + "from op_session "
              + "where op_session.datej between '"+dte1+"' and '"+dte2+"' "
              + "and op_session.type = '"+op+"' "
                    + "and op_session.client like '%"+this.cl.getText().trim().replaceAll("'", "''")+"%' "
                    + "order by op_session.datej desc" ;
           
           
       }
     
      
        rs = stmt.executeQuery(sql) ;
     
        while(rs.next()){
   
      dtm.addRow(new Object[]{
     
      //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
   
  rs.getString("pos"), sdf1.format(rs.getTimestamp("date")), rs.getString("id") , rs.getString("login"), rs.getString("client"), rs.getString("contact")
  , this.nf3.format(rs.getInt("total")) , rs.getInt("cb") , rs.getString("etat")
             
        
        }) ;
 
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
        
             DefaultTableModel dtm = (DefaultTableModel) jTable29.getModel() ;
                               dtm.setRowCount(0) ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
        
        
        
        
    }//GEN-LAST:event_clKeyReleased

    private void rch_cKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rch_cKeyReleased
    
        // TODO add your handling code here:
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
        String rch = this.rch_c.getText().trim().replaceAll("'", "''") ;
         
              
       
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable19.getModel() ;
                             dtm.setRowCount(0) ;
                             
                             this.mlist1 = new ArrayList<>() ;
        
       String sql = null ;
       ResultSet rs = null ;
       
           //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
           
           sql = "select op_session.pos as pos, op_session.datej as date, op_session.id_op as id, op_session.user as login, "
                   + "op_session.client as client, "
                   + "op_session.contact as contact, op_session.total as total, op_session.cb as cb , sum(payement.mtt) as paye, op_session.etat as etat "
              + "from op_session, payement "
              + "where op_session.type = 'RESERVATION' and (op_session.client like '%"+rch+"%' or op_session.contact like '%"+rch+"%') and payement.cb_op = op_session.cb "
                   + "and payement.etat = 'OUI' "
              + "group by op_session.cb order by op_session.datej desc" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
          if(rs.getString("etat").equalsIgnoreCase("NON")){
              
          }else{
     
          HashMap<String, Object> m = new HashMap<>() ;
          
          m.put("pos",  rs.getString("pos")) ;
          m.put("date", sdf1.format(rs.getTimestamp("date"))) ;
          m.put("id", rs.getString("id")) ;
          m.put("user", rs.getString("login")) ;
          m.put("client", rs.getString("client")) ;
          m.put("contact", rs.getString("contact")) ;
          m.put("total", this.nf3.format(rs.getInt("total"))) ;
          m.put("avance",  this.nf3.format(rs.getInt("paye"))) ;
          m.put("reliquat", this.nf3.format((rs.getInt("total") - rs.getInt("paye")))) ;
                      
                this.mlist1.add(m) ;
        
          }
          
      dtm.addRow(new Object[]{
     
      //  "POS", "DATE", "ID", "USER", "CLIENT", "CONTACT", "TOTAL", "CB"
   
  rs.getString("pos"), sdf1.format(rs.getTimestamp("date")), rs.getString("id") , rs.getString("login"), rs.getString("client"), rs.getString("contact")
  , this.nf3.format(rs.getInt("total")) , rs.getInt("cb") , this.nf3.format(rs.getInt("paye")) , this.nf3.format((rs.getInt("total") - rs.getInt("paye")))
  , rs.getString("etat")
        
        }) ;
 
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
            
          
        
        
    }//GEN-LAST:event_rch_cKeyReleased

    private void rch_cFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rch_cFocusGained
        // TODO add your handling code here:
        
        String rch = this.rch_c.getText().trim().replaceAll("'", "''") ;
        
        if(rch.equalsIgnoreCase("CLIENT / CONTACT")){
        
            this.rch_c.setText("");
        
        }
        
    }//GEN-LAST:event_rch_cFocusGained

    private void rch_cFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rch_cFocusLost
        // TODO add your handling code here:
        
         
        String rch = this.rch_c.getText().trim().replaceAll("'", "''") ;
        
        if(rch.isEmpty()){
        
            this.rch_c.setText("CLIENT / CONTACT");
        
        }
        
    }//GEN-LAST:event_rch_cFocusLost

    private void opActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opActionPerformed
       
        
     String op = this.op.getSelectedItem().toString() ;
     
     if(op.equalsIgnoreCase("RESERVATION")){
         this.jButton31.setEnabled(false);
     }else{
         this.jButton31.setEnabled(true);
     }
        
        
    }//GEN-LAST:event_opActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        
        
          if (JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS ANNULER ?", "CONFIRMATION",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        // yes option


        
        if(this.jTable13.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "PARAMETRE INCORRECT !") ;
            
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
      
  int bl = 0 ;
  long session = 0 ;
  
  sql = "select id_ss from sortie_caisse where id_st = "+this.id_op2 ;
  rs = stmt.executeQuery(sql) ;
  while(rs.next()){
      session = rs.getLong("id_ss") ;
  }
  
  sql = "select balance from session where id_ss = "+session ;
  rs = stmt.executeQuery(sql) ;
  while(rs.next()){
      bl = rs.getInt("balance") ;
  }
  
  Integer new_bl = (bl + this.total_op2) ;
  
  stmt.executeUpdate("update session set balance = "+new_bl+" where id_ss = "+session) ;
      
 if(stmt.executeUpdate("update sortie_caisse set etat = 'NON' , login_an = '"+this.user_c.replace("'", "''")+"' , date_an = '"+this.sdf_mysql_.format(new Date())+"' "
              + "where id_st = "+this.jTable13.getValueAt(this.jTable13.getSelectedRow(), 2).toString()) == 1){
      
      
         
       this.jTable13.setValueAt(new String("NON"), this.jTable13.getSelectedRow(), 7) ;
       this.jTable13.getSelectionModel().clearSelection() ;
      
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
        
        
        
        
        
    }//GEN-LAST:event_jButton24ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accueil;
    private javax.swing.JLabel alerteExpi;
    private javax.swing.JLabel alerteStock;
    private datechooser.beans.DateChooserCombo au;
    private datechooser.beans.DateChooserCombo au1;
    private datechooser.beans.DateChooserCombo au3;
    private datechooser.beans.DateChooserCombo au4;
    private datechooser.beans.DateChooserCombo au5;
    private datechooser.beans.DateChooserCombo au6;
    private datechooser.beans.DateChooserCombo au7;
    private javax.swing.JPanel autre;
    private javax.swing.JButton bof;
    private javax.swing.JButton bof1;
    private javax.swing.JButton bof2;
    private javax.swing.JPanel center;
    private javax.swing.JTextField cl;
    private javax.swing.JTextField client1;
    private javax.swing.JTextField client2;
    private javax.swing.JTextField client3;
    private javax.swing.JTextField client4;
    private javax.swing.JFormattedTextField contact1;
    private javax.swing.JFormattedTextField contact2;
    private javax.swing.JFormattedTextField contact3;
    private javax.swing.JFormattedTextField contact4;
    private javax.swing.JPanel d_s;
    private static javax.swing.JTextField desc;
    private static javax.swing.JTextField desc2;
    private static javax.swing.JTextField desc3;
    private static javax.swing.JTextField desc4;
    private datechooser.beans.DateChooserCombo du;
    private datechooser.beans.DateChooserCombo du1;
    private datechooser.beans.DateChooserCombo du3;
    private datechooser.beans.DateChooserCombo du4;
    private datechooser.beans.DateChooserCombo du5;
    private datechooser.beans.DateChooserCombo du6;
    private datechooser.beans.DateChooserCombo du7;
    private javax.swing.JFormattedTextField fc;
    private javax.swing.JFormattedTextField h1;
    private javax.swing.JFormattedTextField h11;
    private javax.swing.JFormattedTextField h13;
    private javax.swing.JFormattedTextField h14;
    private javax.swing.JFormattedTextField h15;
    private javax.swing.JFormattedTextField h16;
    private javax.swing.JFormattedTextField h17;
    private javax.swing.JFormattedTextField h2;
    private javax.swing.JFormattedTextField h22;
    private javax.swing.JFormattedTextField h23;
    private javax.swing.JFormattedTextField h24;
    private javax.swing.JFormattedTextField h25;
    private javax.swing.JFormattedTextField h26;
    private javax.swing.JFormattedTextField h27;
    private javax.swing.JFormattedTextField id;
    private javax.swing.JFormattedTextField id2;
    private javax.swing.JFormattedTextField id3;
    private javax.swing.JFormattedTextField id4;
    private javax.swing.JTextField id6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable15;
    private javax.swing.JTable jTable16;
    private javax.swing.JTable jTable18;
    private javax.swing.JTable jTable19;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable20;
    private javax.swing.JTable jTable21;
    private javax.swing.JTable jTable22;
    private javax.swing.JTable jTable23;
    private javax.swing.JTable jTable24;
    private javax.swing.JTable jTable25;
    private javax.swing.JTable jTable26;
    private javax.swing.JTable jTable27;
    private javax.swing.JTable jTable28;
    private javax.swing.JTable jTable29;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel log;
    private javax.swing.JFormattedTextField montant;
    private javax.swing.JFormattedTextField mt;
    private javax.swing.JTextField ob;
    private javax.swing.JTextField obs;
    private javax.swing.JTextField observ;
    private javax.swing.JTextField observ2;
    private javax.swing.JTextField observ3;
    private javax.swing.JFormattedTextField observ4;
    private javax.swing.JComboBox op;
    private javax.swing.JFormattedTextField pu;
    private javax.swing.JFormattedTextField pu2;
    private javax.swing.JFormattedTextField pu3;
    private javax.swing.JFormattedTextField pu4;
    private javax.swing.JLabel py;
    private javax.swing.JFormattedTextField qte;
    private javax.swing.JFormattedTextField qte2;
    private javax.swing.JFormattedTextField qte3;
    private javax.swing.JFormattedTextField qte4;
    private javax.swing.JButton r;
    private javax.swing.JTextField rch_c;
    private javax.swing.JTextField ref;
    private javax.swing.JPanel reprise;
    private javax.swing.JButton reserv;
    private javax.swing.JPanel reservation;
    private javax.swing.JLabel rl;
    private javax.swing.JButton s;
    private javax.swing.JButton sav;
    private javax.swing.JPanel service;
    private javax.swing.JPanel session;
    private javax.swing.JPanel sortie_caisse;
    private javax.swing.JButton st;
    private javax.swing.JButton sui1;
    private javax.swing.JButton sui2;
    private javax.swing.JPanel suivi_op_cred;
    private javax.swing.JPanel suivi_ope_session;
    private javax.swing.JLabel t1;
    private javax.swing.JLabel t2;
    private javax.swing.JLabel t3;
    private javax.swing.JLabel t4;
    private javax.swing.JComboBox user;
    private javax.swing.JButton v;
    private javax.swing.JPanel vente;
    // End of variables declaration//GEN-END:variables
}
