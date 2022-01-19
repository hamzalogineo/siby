/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import dao.Stock;
import static frontend.Clients1.JDBC_DRIVER;
import static frontend.Lacaisse.JDBC_DRIVER;
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
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author HAMZA
 */
public class Admin1 extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
    String user_c ;
    String role ;
    String phone ;
    String nom_c ;
    
    InetAddress ip ;
    String hostUser ;
    String debutJour;
    String dateExpi;
    List<Stock> list_date_expi = new ArrayList();
    List<String> list_date_compare = new ArrayList();
    Stock st;
    
    List<String> list_desi = new ArrayList();
    List<Integer> list_pu = new ArrayList();
    List<Integer> list_stockMini = new ArrayList();
    Stock st1;  
    List<Stock> list_stock = new ArrayList();
    
    
    public Admin1() {
        //this.setLocation(15, 10);
        initComponents();
        this.setLocationRelativeTo(null);
        
        DateFormat datef = new SimpleDateFormat("yyyy-MM-dd") ;
        this.debutJour = datef.format(new Date()) ;
        
        //this.alerteStock.setText("");
        
       /* int n = 1000000;

        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String val = nf.format(n);

        System.out.println(val);
        
        NumberFormat nf2 = NumberFormat.getInstance(new Locale("sk", "SK"));
        String val2 = nf2.format(n);

        System.out.println(val2);        

        NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
        String val3 = nf3.format(n);

        System.out.println(val3); */
        
        
        
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
         st1 = new Stock();
         st1.setCb(rs3.getString("cb"));
         st1.setDesi(rs3.getString("desi"));
         st1.setStock(rs3.getInt("stock"));
         this.list_stock.add(st1);
     }
      } 
      
      if (this.list_stock.isEmpty() ) {
          this.alerteStock.setText("");
      } else {
          this.alerteStock.setText("Alerte Stock");
      }
      
      
      
      
       
         
       
       
         String sql2 ;
      
       sql2 = "SELECT * FROM stock1 WHERE date_expiMoins15 <= '"+this.debutJour+"' ORDER BY desi " ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
       while (rs2.next()){
          st = new Stock();
          st.setCb(rs2.getString("cb"));
          st.setDesi(rs2.getString("desi"));
          st.setStock(rs2.getInt("stock"));
          st.setDate_expi(rs2.getString("date_expi"));
          this.list_date_expi.add(st);
     }
       
       if (this.list_date_expi.isEmpty() ) {
          this.alerteExpi.setText("");
      } else {
          this.alerteExpi.setText("Alerte Expiration");
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

    
    
    // constructor with param :
    
    
     public Admin1(String nom_c) {
        //this.setLocation(15, 10);
          this.nom_c = nom_c ;
          this.setTitle("BIENVENUE  "+this.nom_c) ;
         
        // this.setTitle("WELCOME") ;
         
        initComponents();
        
        
        this.setLocationRelativeTo(null);
        
        DateFormat datef = new SimpleDateFormat("yyyy-MM-dd") ;
        this.debutJour = datef.format(new Date()) ;
        
        //this.alerteStock.setText("");
        
       /* int n = 1000000;

        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String val = nf.format(n);

        System.out.println(val);
        
        NumberFormat nf2 = NumberFormat.getInstance(new Locale("sk", "SK"));
        String val2 = nf2.format(n);

        System.out.println(val2);        

        NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
        String val3 = nf3.format(n);

        System.out.println(val3); */
        
        
        
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
         st1 = new Stock();
         st1.setCb(rs3.getString("cb"));
         st1.setDesi(rs3.getString("desi"));
         st1.setStock(rs3.getInt("stock"));
         this.list_stock.add(st1);
     }
      } 
      
      if (this.list_stock.isEmpty() ) {
          this.alerteStock.setText("");
      } else {
          this.alerteStock.setText("Alerte Stock");
      }
      
      
      
      
       
         
       
       
         String sql2 ;
      
       sql2 = "SELECT * FROM stock1 WHERE date_expiMoins15 <= '"+this.debutJour+"' ORDER BY desi " ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
       while (rs2.next()){
          st = new Stock();
          st.setCb(rs2.getString("cb"));
          st.setDesi(rs2.getString("desi"));
          st.setStock(rs2.getInt("stock"));
          st.setDate_expi(rs2.getString("date_expi"));
          this.list_date_expi.add(st);
     }
       
       if (this.list_date_expi.isEmpty() ) {
          this.alerteExpi.setText("");
      } else {
          this.alerteExpi.setText("Alerte Expiration");
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
     
     public Admin1(String login, String role, String n_c) {
        //this.setLocation(15, 10);
        initComponents();
        this.setLocationRelativeTo(null);
        
    this.user_c = login ;
    this.role = role ;
    this.phone = "" ;
    this.nom_c = n_c ;
    
    if(this.role.equalsIgnoreCase("ORDINAIRE")){
        this.bof.setEnabled(false);
    }else if(this.role.equalsIgnoreCase("ADMINII")){
        
        this.jButton31.setVisible(false) ;
        this.jButton37.setVisible(false) ;
        this.jButton34.setVisible(false) ;  
        
    }
        
        DateFormat datef = new SimpleDateFormat("yyyy-MM-dd") ;
        this.debutJour = datef.format(new Date()) ;
        
        //this.alerteStock.setText("");
        
       /* int n = 1000000;

        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String val = nf.format(n);

        System.out.println(val);
        
        NumberFormat nf2 = NumberFormat.getInstance(new Locale("sk", "SK"));
        String val2 = nf2.format(n);

        System.out.println(val2);        

        NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
        String val3 = nf3.format(n);

        System.out.println(val3); */
        
        
        
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
         st1 = new Stock();
         st1.setCb(rs3.getString("cb"));
         st1.setDesi(rs3.getString("desi"));
         st1.setStock(rs3.getInt("stock"));
         this.list_stock.add(st1);
     }
      } 
      
      if (this.list_stock.isEmpty() ) {
          this.alerteStock.setText("");
      } else {
          this.alerteStock.setText("Alerte Stock");
      }
      
      
      
      
       
         
       
       
         String sql2 ;
      
       sql2 = "SELECT * FROM stock1 WHERE date_expiMoins15 <= '"+this.debutJour+"' ORDER BY desi " ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
       while (rs2.next()){
          st = new Stock();
          st.setCb(rs2.getString("cb"));
          st.setDesi(rs2.getString("desi"));
          st.setStock(rs2.getInt("stock"));
          st.setDate_expi(rs2.getString("date_expi"));
          this.list_date_expi.add(st);
     }
       
       if (this.list_date_expi.isEmpty() ) {
          this.alerteExpi.setText("");
      } else {
          this.alerteExpi.setText("Alerte Expiration");
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
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        bof = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        log = new javax.swing.JLabel();
        alerteStock = new javax.swing.JLabel();
        alerteExpi = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

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

        jButton20.setBackground(new java.awt.Color(0, 51, 51));
        jButton20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("FOURNISSEUR");
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(0, 51, 51));
        jButton21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("MATIERE PREMIERE");
        jButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(0, 51, 51));
        jButton24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton24.setForeground(new java.awt.Color(255, 255, 255));
        jButton24.setText("PRODUIT FINI");
        jButton24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(0, 51, 51));
        jButton26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setText("LA PRODUCTION");
        jButton26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(0, 51, 51));
        jButton34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setText("COMPTE CLIENT");
        jButton34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(0, 51, 51));
        jButton27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setText("CHANGER M.D.P");
        jButton27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton31.setBackground(new java.awt.Color(0, 51, 51));
        jButton31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton31.setForeground(new java.awt.Color(255, 255, 255));
        jButton31.setText("VENTE ARTICLE");
        jButton31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton37.setBackground(new java.awt.Color(0, 51, 51));
        jButton37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton37.setForeground(new java.awt.Color(255, 255, 255));
        jButton37.setText("GESTION STOCK");
        jButton37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        bof.setBackground(new java.awt.Color(0, 51, 51));
        bof.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bof.setForeground(new java.awt.Color(255, 255, 255));
        bof.setText("BACK-OFFICE");
        bof.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bofActionPerformed(evt);
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
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bof, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bof, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        log.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        log.setForeground(new java.awt.Color(255, 255, 255));
        log.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        log.setText("jLabel2");

        alerteStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        alerteStock.setForeground(new java.awt.Color(255, 0, 51));
        alerteStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alerteStock.setText("     Stock");
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
        alerteExpi.setText("Expiration");
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
                .addGap(92, 92, 92)
                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(alerteStock)
                        .addComponent(alerteExpi))
                    .addComponent(log))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Copyright © 2021       SIBY CENTER ARS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(453, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alerteExpiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alerteExpiMouseClicked
      
    }//GEN-LAST:event_alerteExpiMouseClicked

    private void alerteStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alerteStockMouseClicked
      
    }//GEN-LAST:event_alerteStockMouseClicked

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:

        
      Fournisseur cptes = new Fournisseur(this.role) ;

        cptes.setUser_c(this.user_c) ;
        cptes.setRole(this.role) ;
        cptes.setPhone(this.phone) ;
        
         if(this.role.equalsIgnoreCase("ADMINISTRATEUR")){
                      // cptes.setAjouter();
                      // cptes.setModifier();
                      
                         cptes.setSupprimer();
                         
                  }else if(this.role.equalsIgnoreCase("ADMINII")){
                      // cptes.setAjouter();
                      // cptes.setModifier();
                      
                         cptes.setSupprimer();
                  }

        cptes.setVisible(true) ;
        
     
        /*
        
         Fournisseur cptes = new Fournisseur() ;

        cptes.setUser_c(this.user_c);
        cptes.setRole(this.role);
        cptes.setPhone(this.phone);
        
        
        

        cptes.setVisible(true) ;
        this.setVisible(false) ;

        */
        
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:

        MatierePri cptes = new MatierePri() ;

        cptes.setUser_c(this.user_c);
        cptes.setRole(this.role);
        
         if(this.role.equalsIgnoreCase("ORDINAIRE")){
            cptes.setAjouter();
            cptes.setHistorique();
            cptes.setModifier();
            cptes.setImprimer();
            cptes.setSupprimer();
        }
         
          if(this.role.equalsIgnoreCase("ADMINISTRATEUR")){
                      // cptes.setAjouter();
                      // cptes.setModifier();
                      
                         cptes.setSupprimer();
                  }else if(this.role.equalsIgnoreCase("ADMINII")){
                      
                      cptes.setSupprimer() ;
                  }
          

        cptes.setVisible(true) ;
         

    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:

         ProduitFini cptes = new ProduitFini() ;

        cptes.setUser_c(this.user_c);
        cptes.setRole(this.role);
        cptes.setPhone(this.phone);
        
        if(this.role.equalsIgnoreCase("ORDINAIRE")){
            cptes.setAjouter();
            cptes.setModifier();
            cptes.setImprimer();
            cptes.setSupprimer();
            cptes.setDetail();
        }else if(this.role.equalsIgnoreCase("ADMINII")){
            
            cptes.setSupprimer();
            
        }else if(this.role.equalsIgnoreCase("ADMINISTRATEUR")){
                      // cptes.setAjouter();
                      // cptes.setModifier();
                      
                         cptes.setSupprimer();
                  }

        cptes.setVisible(true) ;
         

    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here :

        NEwProduction np = new NEwProduction() ;

        np.setUser_c(this.user_c) ;
        np.setRole(this.role) ;
        np.setPhone(this.phone) ;

        np.setVisible(true) ;

        /*
        ProductionT cptes = new ProductionT() ;

        cptes.setVisible(true) ;
        */

    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        ComptesClient vart = new ComptesClient(this.role) ;
        vart.setAdmin(this.user_c) ;
        vart.setVisible(true) ;
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        ChangerMp  uc = new ChangerMp() ;

        uc.setAdmin(this.user_c);

        uc.setVisible(true) ;
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
         VenteArticles vart = new VenteArticles() ;
        vart.setAdmin(this.user_c) ;
        vart.setVisible(true) ;
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed

        Menu_stock ms = new Menu_stock() ;
        ms.setVisible(true) ;

        ms.setOp(this.user_c) ;
        ms.setRole(this.role);

        /*
        StockFinal cptes = new StockFinal(this.role) ;

        cptes.setAdmin(this.user_c) ;

        cptes.setVisible(true) ;
        */
    }//GEN-LAST:event_jButton37ActionPerformed

    private void bofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bofActionPerformed
       
        Menu_Bo mb = new Menu_Bo(this.user_c, this.role) ;
               mb.setVisible(true) ;
               
       
       
    }//GEN-LAST:event_bofActionPerformed

    private void alerteStockMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alerteStockMouseReleased
        // TODO add your handling code here:
        
          AlerteStock as = new AlerteStock(this.list_stock);
          as.setVisible(true);
        
    }//GEN-LAST:event_alerteStockMouseReleased

    private void alerteExpiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alerteExpiMouseReleased

        
        AlerteExpi ae = new AlerteExpi(this.list_date_expi);
        ae.setVisible(true);
        
        
    }//GEN-LAST:event_alerteExpiMouseReleased

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
            java.util.logging.Logger.getLogger(Admin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Admin1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alerteExpi;
    private javax.swing.JLabel alerteStock;
    private javax.swing.JButton bof;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel log;
    // End of variables declaration//GEN-END:variables
}
