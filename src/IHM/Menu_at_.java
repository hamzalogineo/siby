/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import static IHM.Arrivage.JDBC_DRIVER;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class Menu_at_ extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/tp3_siby" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
    

  SimpleDateFormat sdf_mysql = new SimpleDateFormat("yyyy-MM-dd") ;
  SimpleDateFormat sdf_mysql_ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
  SimpleDateFormat sdf_java = new SimpleDateFormat("dd-MM-yyyy") ;
  SimpleDateFormat sdf_java_ = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
  
  
  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
  
  
      String userDictionaryPath = "/dico_fr/" ;
      Suggestion11 sg = new Suggestion11() ;
      
      private String login;
      private String role;
      private String pos ;
      
      private int id_1;
      private int id_2;
      
      private ArrayList<Detail_op> list = new ArrayList<Detail_op>() ;
      private ArrayList<String> list_vy = new ArrayList<String>() ;
      
      Integer mtt = 0 ;
    
      
    
    
     public Menu_at_() {
        
        initComponents();
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
         DefaultTableModel dtm4 = (DefaultTableModel) this.jTable4.getModel() ;
          DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
         
        
        dtm.setRowCount(0) ;
        dtm4.setRowCount(0) ;
        dtm3.setRowCount(0) ;
        
        
        
          this.jTable5.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable5.getTableHeader().setOpaque(false); 
            this.jTable5.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable5.getTableHeader().setForeground(Color.white) ;
        
              this.jTable5.setRowHeight(25) ;
              
        
            

                  for (int i = 0; i < this.jTable5.getModel().getColumnCount(); i++) {
                    this.jTable5.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
                  
                    this.jTable6.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable6.getTableHeader().setOpaque(false); 
            this.jTable6.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable6.getTableHeader().setForeground(Color.white) ;
        
              this.jTable6.setRowHeight(25) ;
              

                  for (int i = 0; i < this.jTable6.getModel().getColumnCount(); i++) {
                    this.jTable6.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
        
            this.jTable7.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable7.getTableHeader().setOpaque(false); 
            this.jTable7.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable7.getTableHeader().setForeground(Color.white) ;
        
              this.jTable7.setRowHeight(25) ;
              

                  for (int i = 0; i < this.jTable7.getModel().getColumnCount(); i++) {
                    this.jTable7.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
        
        //  ---------  2è choix
              
        
        
        
        
       //   ---------------
        
        
        //
                  
                  
                  
        
       
        
     
        
        DefaultTableModel dtm5 = (DefaultTableModel) this.jTable5.getModel() ;
         DefaultTableModel dtm6 = (DefaultTableModel) this.jTable6.getModel() ;
          DefaultTableModel dtm7 = (DefaultTableModel) this.jTable7.getModel() ;
         
        
        dtm5.setRowCount(0) ;
        dtm6.setRowCount(0) ;
        dtm7.setRowCount(0) ;
        
        
        
        
        
        
        
        
        
    }

     
      public Menu_at_(String pos, String login, String role) {
        
        initComponents();
        
        this.pos = pos ;
        this.login = login ;
        this.role = role ;
        
        
        if(this.role.equalsIgnoreCase("TP3 SIBY")){
            this.jButton7.setVisible(false) ;
            this.jButton15.setVisible(false) ;
            
        }
        
        this.h1.setText("00:00") ;
        this.h2.setText("23:59") ;
        
        this.h11.setText("00:00") ;
        this.h12.setText("23:59") ;
        
        
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
         DefaultTableModel dtm4 = (DefaultTableModel) this.jTable4.getModel() ;
          DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
         
        
        dtm.setRowCount(0) ;
        dtm4.setRowCount(0) ;
        dtm3.setRowCount(0) ;
        
        
        
          this.jTable5.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable5.getTableHeader().setOpaque(false); 
            this.jTable5.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable5.getTableHeader().setForeground(Color.white) ;
        
              this.jTable5.setRowHeight(25) ;
              
        
            

                  for (int i = 0; i < this.jTable5.getModel().getColumnCount(); i++) {
                    this.jTable5.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
                  
                    this.jTable6.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable6.getTableHeader().setOpaque(false); 
            this.jTable6.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable6.getTableHeader().setForeground(Color.white) ;
        
              this.jTable6.setRowHeight(25) ;
              

                  for (int i = 0; i < this.jTable6.getModel().getColumnCount(); i++) {
                    this.jTable6.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
        
            this.jTable7.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable7.getTableHeader().setOpaque(false); 
            this.jTable7.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable7.getTableHeader().setForeground(Color.white) ;
        
              this.jTable7.setRowHeight(25) ;
              

                  for (int i = 0; i < this.jTable7.getModel().getColumnCount(); i++) {
                    this.jTable7.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
        
        //  ---------  2è choix
              
        
        
        
        
       //   ---------------
        
        
        //
                  
                  
                  
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

      
        
                  
           this.jTable4.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
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
        
                     
                  
        this.jTable6.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
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

      
        
                  
           this.jTable7.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
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

      
           
        
        DefaultTableModel dtm5 = (DefaultTableModel) this.jTable5.getModel() ;
         DefaultTableModel dtm6 = (DefaultTableModel) this.jTable6.getModel() ;
          DefaultTableModel dtm7 = (DefaultTableModel) this.jTable7.getModel() ;
         
        
        dtm5.setRowCount(0) ;
        dtm6.setRowCount(0) ;
        dtm7.setRowCount(0) ;
        
        
        
        
        
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
          this.tech.addItem(new String(rs.getString("technicien"))) ;
          this.tech_r.addItem(new String(rs.getString("technicien"))) ;
          
          
           this.tech1.addItem(new String(rs.getString("technicien"))) ;
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
        
       
        
        // SET DICTIONARY PROVIDER FROM DICTIONARY PATH
   SpellChecker.setUserDictionaryProvider(new FileUserDictionary(userDictionaryPath)) ;
   

      //REGISTER DICTIONARY
  SpellChecker.registerDictionaries(getClass().getResource(userDictionaryPath), "fr") ;
 
 SpellChecker.register(desc) ;  SpellChecker.register(desc1) ;
 
 

     configurePopUp() ;
 
        
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
   
    }
    
     public static void changeText(String txt){
        
        int i = desc.getText().lastIndexOf(" ") ;
        
        if(i < 0 ){
             desc.setText(txt) ;
        }else if(i > 0){
            
       String text1 = desc.getText()   ; // .substring(1, (i)) ;
        
        desc.setText(text1+" "+txt) ;
            
        }
        
        
        
         int i1 = desc1.getText().lastIndexOf(" ") ;
        
        if(i1 < 0 ){
             desc1.setText(txt) ;
        }else if(i1 > 0){
            
       String text1 = desc1.getText()   ; // .substring(1, (i)) ;
        
        desc1.setText(text1+" "+txt) ;
            
        }
          
     
         }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        atelier = new javax.swing.JPanel();
        vierge = new javax.swing.JPanel();
        in_at = new javax.swing.JPanel();
        tech = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        desc = new javax.swing.JTextField();
        qt = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pu = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        du = new datechooser.beans.DateChooserCombo();
        jLabel5 = new javax.swing.JLabel();
        h1 = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        au = new datechooser.beans.DateChooserCombo();
        jLabel7 = new javax.swing.JLabel();
        h2 = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        to = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        tech_r = new javax.swing.JComboBox();
        t1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        out_at = new javax.swing.JPanel();
        tech1 = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        desc1 = new javax.swing.JTextField();
        qt1 = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        pu1 = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        du1 = new datechooser.beans.DateChooserCombo();
        jLabel21 = new javax.swing.JLabel();
        tech_r1 = new javax.swing.JComboBox();
        h11 = new javax.swing.JFormattedTextField();
        jLabel22 = new javax.swing.JLabel();
        au1 = new datechooser.beans.DateChooserCombo();
        jLabel23 = new javax.swing.JLabel();
        t11 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        h12 = new javax.swing.JFormattedTextField();
        jButton11 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        to1 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setResizable(false);

        atelier.setBackground(new java.awt.Color(255, 255, 255));
        atelier.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TACHE EN ATELIER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        atelier.setLayout(new java.awt.CardLayout());

        vierge.setBackground(new java.awt.Color(255, 255, 255));
        vierge.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu ATELIER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        vierge.setMaximumSize(new java.awt.Dimension(900, 595));
        vierge.setMinimumSize(new java.awt.Dimension(900, 595));
        vierge.setPreferredSize(new java.awt.Dimension(900, 595));

        javax.swing.GroupLayout viergeLayout = new javax.swing.GroupLayout(vierge);
        vierge.setLayout(viergeLayout);
        viergeLayout.setHorizontalGroup(
            viergeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1075, Short.MAX_VALUE)
        );
        viergeLayout.setVerticalGroup(
            viergeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );

        atelier.add(vierge, "card4");

        in_at.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ENTREE EN ATELEIR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tech.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tech.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR TECHNICIEN" }));
        tech.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                techActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DESCRIPTION (DICTIONNAIRE INTEG.)");

        desc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        desc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        desc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descKeyReleased(evt);
            }
        });

        qt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        qt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        qt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NBRE");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("P.U");

        pu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pu.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        pu.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton3.setBackground(new java.awt.Color(51, 0, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("AJOUTER");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 0, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("RETIRER");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        du.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));

        jLabel5.setText("DU");

        h1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h1.setText("00:00");
        h1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("HEURE");

        au.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));

        jLabel7.setText("AU");

        h2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h2.setText("23:59");
        h2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("HEURE");

        jButton5.setBackground(new java.awt.Color(51, 0, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("RECHERCHER");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton5.setBorderPainted(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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
                "POS", "ID", "DATE", "USER", "TECHNICIEN", "TOTAL", "CB", "ETAT"
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
            jTable1.getColumnModel().getColumn(1).setMinWidth(35);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(35);
            jTable1.getColumnModel().getColumn(2).setMinWidth(120);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(3).setMinWidth(60);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(6).setMinWidth(0);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(7).setMinWidth(0);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        jButton6.setBackground(new java.awt.Color(51, 0, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("VALIDER");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton6.setBorderPainted(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        to.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        to.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        to.setText("TOTAL ENTREE :");
        to.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTable3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DESCRIPTION", "NBRE", "P.U", "MTT"
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
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(1).setMinWidth(90);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTable3.getColumnModel().getColumn(1).setMaxWidth(90);
            jTable3.getColumnModel().getColumn(2).setMinWidth(90);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable3.getColumnModel().getColumn(2).setMaxWidth(90);
            jTable3.getColumnModel().getColumn(3).setMinWidth(90);
            jTable3.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable3.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        tech_r.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tech_r.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUT" }));
        tech_r.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tech_r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tech_rActionPerformed(evt);
            }
        });

        t1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t1.setText("TOTAL :");
        t1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTable4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DESCRIPTION", "NBRE", "P.U", "MTT", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(1).setMinWidth(90);
            jTable4.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTable4.getColumnModel().getColumn(1).setMaxWidth(90);
            jTable4.getColumnModel().getColumn(2).setMinWidth(90);
            jTable4.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable4.getColumnModel().getColumn(2).setMaxWidth(90);
            jTable4.getColumnModel().getColumn(3).setMinWidth(90);
            jTable4.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable4.getColumnModel().getColumn(3).setMaxWidth(90);
            jTable4.getColumnModel().getColumn(4).setMinWidth(0);
            jTable4.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable4.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jButton7.setBackground(new java.awt.Color(255, 51, 51));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("ANNULER");
        jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton7.setBorderPainted(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout in_atLayout = new javax.swing.GroupLayout(in_at);
        in_at.setLayout(in_atLayout);
        in_atLayout.setHorizontalGroup(
            in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(in_atLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(in_atLayout.createSequentialGroup()
                        .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(in_atLayout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, in_atLayout.createSequentialGroup()
                        .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(in_atLayout.createSequentialGroup()
                                .addComponent(tech, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tech_r, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(in_atLayout.createSequentialGroup()
                                .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(in_atLayout.createSequentialGroup()
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(in_atLayout.createSequentialGroup()
                                        .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(desc)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(qt)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pu)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(in_atLayout.createSequentialGroup()
                                        .addComponent(du, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, in_atLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(64, 64, 64)))
                                .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(h1)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(in_atLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(au, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(h2)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(in_atLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, in_atLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        in_atLayout.setVerticalGroup(
            in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(in_atLayout.createSequentialGroup()
                .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(in_atLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(tech, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tech_r, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(in_atLayout.createSequentialGroup()
                        .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(0, 0, 0)
                        .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(au, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(h2)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(in_atLayout.createSequentialGroup()
                        .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, in_atLayout.createSequentialGroup()
                                .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, 0)
                                .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(h1)
                                    .addComponent(du, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(in_atLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(0, 0, 0)
                                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(in_atLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(3, 3, 3)
                                        .addComponent(pu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(in_atLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, 0)
                                        .addComponent(qt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(in_atLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(in_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(in_atLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        atelier.add(in_at, "card2");

        out_at.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SORTIE DE L'ATELIER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        tech1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tech1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR TECHNICIEN" }));
        tech1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tech1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tech1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("DESCRIPTION (DICTIONNAIRE INTEG.)");

        desc1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        desc1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        desc1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        desc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desc1KeyReleased(evt);
            }
        });

        qt1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        qt1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        qt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("NBRE");

        pu1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pu1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        pu1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("P.U");

        du1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du1.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));

        jLabel21.setText("DU");

        tech_r1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tech_r1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUT" }));
        tech_r1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tech_r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tech_r1ActionPerformed(evt);
            }
        });

        h11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h11.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h11.setText("00:00");
        h11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("HEURE");

        au1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au1.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));

        jLabel23.setText("AU");

        t11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        t11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t11.setText("TOTAL :");
        t11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("HEURE");

        h12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h12.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h12.setText("23:59");
        h12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton11.setBackground(new java.awt.Color(51, 0, 255));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("RECHERCHER");
        jButton11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton11.setBorderPainted(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jTable5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DESCRIPTION", "NBRE", "P.U", "MTT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable5.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(1).setMinWidth(90);
            jTable5.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTable5.getColumnModel().getColumn(1).setMaxWidth(90);
            jTable5.getColumnModel().getColumn(2).setMinWidth(90);
            jTable5.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable5.getColumnModel().getColumn(2).setMaxWidth(90);
            jTable5.getColumnModel().getColumn(3).setMinWidth(90);
            jTable5.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable5.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        jTable6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "POS", "ID", "DATE", "USER", "TECHNICIEN", "TOTAL", "CB", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable6.getTableHeader().setReorderingAllowed(false);
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable6MouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(1).setMinWidth(35);
            jTable6.getColumnModel().getColumn(1).setPreferredWidth(35);
            jTable6.getColumnModel().getColumn(1).setMaxWidth(35);
            jTable6.getColumnModel().getColumn(2).setMinWidth(120);
            jTable6.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable6.getColumnModel().getColumn(2).setMaxWidth(120);
            jTable6.getColumnModel().getColumn(3).setMinWidth(60);
            jTable6.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTable6.getColumnModel().getColumn(3).setMaxWidth(60);
            jTable6.getColumnModel().getColumn(6).setMinWidth(0);
            jTable6.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable6.getColumnModel().getColumn(6).setMaxWidth(0);
            jTable6.getColumnModel().getColumn(7).setMinWidth(0);
            jTable6.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable6.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        jButton12.setBackground(new java.awt.Color(51, 0, 255));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("AJOUTER");
        jButton12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton12.setBorderPainted(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(51, 0, 255));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("RETIRER");
        jButton13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton13.setBorderPainted(false);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jTable7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DESCRIPTION", "NBRE", "P.U", "MTT", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable7.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable7.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jTable7);
        if (jTable7.getColumnModel().getColumnCount() > 0) {
            jTable7.getColumnModel().getColumn(1).setMinWidth(90);
            jTable7.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTable7.getColumnModel().getColumn(1).setMaxWidth(90);
            jTable7.getColumnModel().getColumn(2).setMinWidth(90);
            jTable7.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable7.getColumnModel().getColumn(2).setMaxWidth(90);
            jTable7.getColumnModel().getColumn(3).setMinWidth(90);
            jTable7.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable7.getColumnModel().getColumn(3).setMaxWidth(90);
            jTable7.getColumnModel().getColumn(4).setMinWidth(0);
            jTable7.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable7.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        to1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        to1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        to1.setText("TOTAL SORTIE :");
        to1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton14.setBackground(new java.awt.Color(51, 0, 255));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("VALIDER");
        jButton14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton14.setBorderPainted(false);
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(255, 0, 0));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("ANNULER");
        jButton15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton15.setBorderPainted(false);
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout out_atLayout = new javax.swing.GroupLayout(out_at);
        out_at.setLayout(out_atLayout);
        out_atLayout.setHorizontalGroup(
            out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(out_atLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(out_atLayout.createSequentialGroup()
                        .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(out_atLayout.createSequentialGroup()
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(to1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, out_atLayout.createSequentialGroup()
                        .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(out_atLayout.createSequentialGroup()
                                .addComponent(tech1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tech_r1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(out_atLayout.createSequentialGroup()
                                .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(out_atLayout.createSequentialGroup()
                                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(out_atLayout.createSequentialGroup()
                                        .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(desc1)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(qt1)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pu1)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(out_atLayout.createSequentialGroup()
                                        .addComponent(du1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, out_atLayout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(64, 64, 64)))
                                .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(h11)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(out_atLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(au1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(h12)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(out_atLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(t11, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, out_atLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        out_atLayout.setVerticalGroup(
            out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(out_atLayout.createSequentialGroup()
                .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(out_atLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(tech1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tech_r1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(out_atLayout.createSequentialGroup()
                        .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel25))
                        .addGap(0, 0, 0)
                        .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(au1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(h12)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(out_atLayout.createSequentialGroup()
                        .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, out_atLayout.createSequentialGroup()
                                .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22))
                                .addGap(0, 0, 0)
                                .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(h11)
                                    .addComponent(du1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(out_atLayout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addGap(0, 0, 0)
                                    .addComponent(desc1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(out_atLayout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(3, 3, 3)
                                        .addComponent(pu1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(out_atLayout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(0, 0, 0)
                                        .addComponent(qt1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(out_atLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(out_atLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(to1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(out_atLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        atelier.add(out_at, "card3");

        jButton1.setBackground(new java.awt.Color(51, 0, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ENTREE");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("SORTIE");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(atelier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(406, 406, 406)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atelier, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.vierge.setVisible(false) ;
       this.out_at.setVisible(false) ;
       this.in_at.setVisible(true) ;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.vierge.setVisible(false) ;
       this.out_at.setVisible(true) ;
       this.in_at.setVisible(false) ;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void techActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_techActionPerformed
       
        
        
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
      
      this.id_1 = 0 ;
      
      sql = "select * from technicien where technicien = '"+this.tech.getSelectedItem().toString().replaceAll("'", "''")+"' and type = 'OUI' order by technicien asc" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          this.id_1 = rs.getInt("id_tech") ;
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
        
       
        
        
    }//GEN-LAST:event_techActionPerformed

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
        
        
        String four, desc1, qt, pu ;
        
        four = this.tech.getSelectedItem().toString() ;
        
        
        desc1 = desc.getText().trim().replaceAll("'", "''") ;
        qt = this.qt.getText() ;
        pu = this.pu.getText() ;
        
        if(four.equalsIgnoreCase("CHOISIR TECHNICIEN") || desc1.isEmpty() || qt.isEmpty() || pu.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }else{
            
            this.tech.setEnabled(false) ;
            
            this.mtt += (Integer.parseInt(qt) * Integer.parseInt(pu)) ;

            Detail_op dt = new Detail_op() ;
             
                      dt.setDescription(desc1) ;
                      dt.setQte(Integer.parseInt(qt)) ;
                      dt.setPu(Integer.parseInt(pu)) ;
                      dt.setMtt((Integer.parseInt(qt) * Integer.parseInt(pu))) ;
                      
                      
                      if(this.list_vy.contains(new String(dt.getDescription()))){
                          JOptionPane.showMessageDialog(null, "PRODUIT EXISTE DEJA") ;
                      }else{
                          
                          DefaultTableModel dtm = (DefaultTableModel) this.jTable3.getModel() ;
                          
                          this.list_vy.add(new String(dt.getDescription())) ;
                          this.list.add(dt) ;
                          
                          dtm.addRow(new Object[]{
                          
                              dt.getDescription(), dt.getQte(), dt.getPu(), dt.getMtt()
                              
                          }) ;
                          
                          this.to.setText("TOTAL ENTREE : "+this.nf3.format(this.mtt)) ;
                          desc.setText(""); this.qt.setText("") ; this.pu.setText("");
                          
                          
                      }
                      
                      
            
        }
        
        
        
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       if(this.jTable3.getSelectedRow() == -1){
            
             JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }else{
            
        Integer mt = Integer.parseInt(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 3).toString()) ;
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable3.getModel() ;
                          
                          this.list_vy.remove(this.jTable3.getSelectedRow()) ;
                          this.list.remove(this.jTable3.getSelectedRow()) ;
                          
                          this.mtt -= mt ;
                          
                           this.to.setText("TOTAL ENTRE : "+this.nf3.format(this.mtt)) ;
                           
                           
                           if(this.list.size() == 0){
                               
                               tech.setSelectedItem("CHOISIR TECHNICIEN") ;
                             
                               
                               tech.setEnabled(true); 
                               
                               
                           }
                           
                           dtm.removeRow(this.jTable3.getSelectedRow()) ;
                           
        
            
             }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
        
           if(this.list.size() > 0){
            
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
             
             Random rx = new Random() ;
             Integer cb = rx.nextInt() ;
             
             if(cb < 0){
                 
                 cb = Math.abs(cb) ;
                 
             }
      
      if(stmt.executeUpdate("insert into tache_at(pos, datej, user, technicien, total, type_at, cb) "
              + "values('"+this.pos+"' , '"+date+"' , '"+this.login+"' , "+this.id_1+" , "+this.mtt+" , 'IN' , "+cb+")") == 1){
          
          
      for(int i =0; i < this.list.size() ; i++){
          
          stmt.executeUpdate("insert into detail_at(description, nbre, pu, mtt, cb_dt) "
              + "values('"+this.list.get(i).getDescription()+"' , "+this.list.get(i).getQte()+" , "+this.list.get(i).getPu()+" , "
                  +this.list.get(i).getMtt()+" , "+cb+")") ;
          
      }
          
     
       this.tech.setSelectedItem(new String("CHOISIR TECHNICIEN")) ; 
       this.desc.setText("") ; this.qt.setText(""); this.pu.setText("");
        
       
       this.tech.setEnabled(true) ;
        
       
       
       this.list.removeAll(this.list) ; this.list_vy.removeAll(this.list_vy) ;
       
         DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel() ;
                           dtm.setRowCount(0) ;
                           
                           this.mtt = 0 ;
                           this.to.setText("TOTAL :");
      
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
        
       
            
            
        }else{
        
            JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tech_rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tech_rActionPerformed
    
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
      
      this.id_2 = 0 ;
      
      sql = "select * from technicien where technicien = '"+this.tech_r.getSelectedItem().toString().replaceAll("'", "''")+"' and type = 'OUI' order by technicien asc" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          this.id_2 = rs.getInt("id_tech") ;
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
        
       
    }//GEN-LAST:event_tech_rActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        
            
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
        
       String sql = null ;
       ResultSet rs = null ;
       
       if(this.tech_r.getSelectedItem().toString().equalsIgnoreCase("TOUT")){
       
 //  "POS", "ID", "DATE", "USER", "TECHNICIEN", "TOTAL", "CB"
           
           sql = "select tache_at.pos as pos, tache_at.id_at as id, tache_at.user as login, tache_at.datej as date, technicien.technicien as fourni, "
                   + "tache_at.total as cat, tache_at.cb as cb, tache_at.etat as etat "
              + "from tache_at, technicien "
              + "where tache_at.datej between '"+dte1+"' and '"+dte2+"' and tache_at.type_at = 'IN' and technicien.id_tech = tache_at.technicien "
              + "order by tache_at.datej desc" ;
           
       }else if(this.tech_r.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false){
       
     //  "POS", "ID", "DATE", "USER", "TECHNICIEN", "TOTAL", "CB"
           
           sql = "select tache_at.pos as pos, tache_at.id_at as id, tache_at.user as login, tache_at.datej as date, technicien.technicien as fourni, "
                   + "tache_at.total as cat, tache_at.cb as cb, tache_at.etat as etat "
              + "from tache_at, technicien "
              + "where tache_at.datej between '"+dte1+"' and '"+dte2+"' and tache_at.type_at = 'IN' and tache_at.technicien = "+this.id_2+" "
                   + "and technicien.id_tech = tache_at.technicien "
              + "order by tache_at.datej desc" ;
           
       }
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
     
          
        
   
      dtm.addRow(new Object[]{
     
      //  "POS", "ID", "DATE", "USER", "TECHNICIEN", "TOTAL", "CB"
   
  rs.getString("pos"), rs.getString("id") , sdf1.format(rs.getTimestamp("date")), rs.getString("login"), rs.getString("fourni"), this.nf3.format(rs.getInt("cat")) , rs.getInt("cb") 
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
        
             DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                               dtm.setRowCount(0) ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
       
        String cb = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 6).toString() ;
        String etat = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 7).toString() ;
        
        if(etat.equalsIgnoreCase(new String("NON"))){
            jButton7.setEnabled(false);
        }else if(etat.equalsIgnoreCase(new String("OUI"))){
            jButton7.setEnabled(true);
        }
        
        
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
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable4.getModel() ;
                             dtm.setRowCount(0) ;
        
       String sql = null ;
       ResultSet rs = null ;
       
       long to = 0 ;
       
 //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
           
           sql = "select * from detail_at where cb_dt = "+cb ;
         
      
         rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
     
             if(etat.equalsIgnoreCase("NON")){
                 
             }else{
             
                 to += rs.getInt("mtt") ;
      
             }
             
       dtm.addRow(new Object[]{
     
   //   "DESCRIPTION", "QTE", "P.U", "MTT"
   
          rs.getString("description"), this.nf3.format(rs.getInt("nbre")) , this.nf3.format(rs.getInt("pu")), this.nf3.format(rs.getInt("mtt")), etat
             
        
         }) ;
 
         }

       
        t1.setText("TOTAL : "+this.nf3.format(to)) ;
        
        
        if(etat.equalsIgnoreCase(new String("NON"))){
            sql = "select login_an , date_an from tache_at where cb = "+cb ;
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

    private void desc1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desc1KeyReleased
        String txt = "" ;

        int i = desc1.getText().lastIndexOf(" ") ;

        if(i < 0 ){
            txt = desc1.getText() ;
        }else if(i > 0){

            txt = desc1.getText().substring(i) ;

        }

        this.sg.laodList(txt) ;
             sg.setVisible(false) ;

        this.addWindowListener( new WindowAdapter() {
            public void windowOpened( WindowEvent e ){
                desc1.requestFocus();
            }
        }) ;
    }//GEN-LAST:event_desc1KeyReleased

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        
        String four, desc1, qt, pu ;
        
        four = this.tech1.getSelectedItem().toString() ;
        
        
        desc1 = this.desc1.getText().trim().replaceAll("'", "''") ;
        qt = this.qt1.getText() ;
        pu = this.pu1.getText() ;
        
        if(four.equalsIgnoreCase("CHOISIR TECHNICIEN") || desc1.isEmpty() || qt.isEmpty() || pu.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }else{
            
            this.tech1.setEnabled(false) ;
            
            this.mtt += (Integer.parseInt(qt) * Integer.parseInt(pu)) ;

            Detail_op dt = new Detail_op() ;
             
                      dt.setDescription(desc1) ;
                      dt.setQte(Integer.parseInt(qt)) ;
                      dt.setPu(Integer.parseInt(pu)) ;
                      dt.setMtt((Integer.parseInt(qt) * Integer.parseInt(pu))) ;
                      
                      
                      if(this.list_vy.contains(new String(dt.getDescription()))){
                          JOptionPane.showMessageDialog(null, "PRODUIT EXISTE DEJA") ;
                      }else{
                          
                          DefaultTableModel dtm = (DefaultTableModel) this.jTable5.getModel() ;
                          
                          this.list_vy.add(new String(dt.getDescription())) ;
                          this.list.add(dt) ;
                          
                          dtm.addRow(new Object[]{
                          
                              dt.getDescription(), dt.getQte(), dt.getPu(), dt.getMtt()
                              
                          }) ;
                          
                          this.to1.setText("TOTAL ENTREE : "+this.nf3.format(this.mtt)) ;
                          this.desc1.setText(""); this.qt1.setText("") ; this.pu1.setText("");
                          
                          
                      }
                      
                      
            
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void tech1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tech1ActionPerformed
        
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
      
      this.id_1 = 0 ;
      
      sql = "select * from technicien where technicien = '"+this.tech1.getSelectedItem().toString().replaceAll("'", "''")+"' and type = 'OUI' order by technicien asc" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          this.id_1 = rs.getInt("id_tech") ;
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
        
       
        
    }//GEN-LAST:event_tech1ActionPerformed

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
      
      this.id_2 = 0 ;
      
      sql = "select * from technicien where technicien = '"+this.tech_r1.getSelectedItem().toString().replaceAll("'", "''")+"' and type = 'OUI' order by technicien asc" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          this.id_2 = rs.getInt("id_tech") ;
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

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
       if(this.jTable5.getSelectedRow() == -1){
            
             JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }else{
            
        Integer mt = Integer.parseInt(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), 3).toString()) ;
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable5.getModel() ;
                          
                          this.list_vy.remove(this.jTable5.getSelectedRow()) ;
                          this.list.remove(this.jTable5.getSelectedRow()) ;
                          
                          this.mtt -= mt ;
                          
                           this.to1.setText("TOTAL ENTRE : "+this.nf3.format(this.mtt)) ;
                           
                           
                           if(this.list.size() == 0){
                               
                               tech1.setSelectedItem("CHOISIR TECHNICIEN") ;
                             
                               
                               tech1.setEnabled(true); 
                               
                               
                           }
                           
                           dtm.removeRow(this.jTable5.getSelectedRow()) ;
                           
        
            
             }
        
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
      
        
           if(this.list.size() > 0){
            
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
             
             Random rx = new Random() ;
             Integer cb = rx.nextInt() ;
             
             if(cb < 0){
                 
                 cb = Math.abs(cb) ;
                 
             }
      
      if(stmt.executeUpdate("insert into tache_at(pos, datej, user, technicien, total, type_at, cb) "
              + "values('"+this.pos+"' , '"+date+"' , '"+this.login+"' , "+this.id_1+" , "+this.mtt+" , 'OUT' , "+cb+")") == 1){
          
          
      for(int i =0; i < this.list.size() ; i++){
          
          stmt.executeUpdate("insert into detail_at(description, nbre, pu, mtt, cb_dt) "
              + "values('"+this.list.get(i).getDescription()+"' , "+this.list.get(i).getQte()+" , "+this.list.get(i).getPu()+" , "
                  +this.list.get(i).getMtt()+" , "+cb+")") ;
          
      }
          
     
       this.tech1.setSelectedItem(new String("CHOISIR TECHNICIEN")) ; 
       this.desc1.setText("") ; this.qt1.setText(""); this.pu1.setText("");
        
       
       this.tech1.setEnabled(true) ;
        
       
       
       this.list.removeAll(this.list) ; this.list_vy.removeAll(this.list_vy) ;
       
         DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel() ;
                           dtm.setRowCount(0) ;
                           
                           this.mtt = 0 ;
                           this.to1.setText("TOTAL :");
      
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
        
       
            
            
        }else{
        
            JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }
        
        
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

            
        // D : 
        
         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du1.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au1.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h11.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h12.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable6.getModel() ;
                             dtm.setRowCount(0) ;
        
       String sql = null ;
       ResultSet rs = null ;
       
       if(this.tech_r1.getSelectedItem().toString().equalsIgnoreCase("TOUT")){
       
 //  "POS", "ID", "DATE", "USER", "TECHNICIEN", "TOTAL", "CB"
           
           sql = "select tache_at.pos as pos, tache_at.id_at as id, tache_at.user as login, tache_at.datej as date, technicien.technicien as fourni, "
                   + "tache_at.total as cat, tache_at.cb as cb, tache_at.etat as etat "
              + "from tache_at, technicien "
              + "where tache_at.datej between '"+dte1+"' and '"+dte2+"' and tache_at.type_at = 'OUT' and technicien.id_tech = tache_at.technicien "
              + "order by tache_at.datej desc" ;
           
       }else if(this.tech_r1.getSelectedItem().toString().equalsIgnoreCase("TOUT") == false){
       
     //  "POS", "ID", "DATE", "USER", "TECHNICIEN", "TOTAL", "CB"
           
           sql = "select tache_at.pos as pos, tache_at.id_at as id, tache_at.user as login, tache_at.datej as date, technicien.technicien as fourni, "
                   + "tache_at.total as cat, tache_at.cb as cb, tache_at.etat as etat "
              + "from tache_at, technicien "
              + "where tache_at.datej between '"+dte1+"' and '"+dte2+"' and tache_at.type_at = 'OUT' and tache_at.technicien = "+this.id_2+" "
                   + "and technicien.id_tech = tache_at.technicien "
              + "order by tache_at.datej desc" ;
           
       }
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
     
          
        
   
      dtm.addRow(new Object[]{
     
      //  "POS", "ID", "DATE", "USER", "TECHNICIEN", "TOTAL", "CB"
   
  rs.getString("pos"), rs.getString("id") , sdf1.format(rs.getTimestamp("date")), rs.getString("login"), rs.getString("fourni"), this.nf3.format(rs.getInt("cat")) , rs.getInt("cb") 
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
        
             DefaultTableModel dtm = (DefaultTableModel) jTable6.getModel() ;
                               dtm.setRowCount(0) ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTable6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseReleased
        
         
        String cb = this.jTable6.getValueAt(this.jTable6.getSelectedRow(), 6).toString() ;
        String etat = this.jTable6.getValueAt(this.jTable6.getSelectedRow(), 7).toString() ;
        
        
            // D : 
        
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.du1.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.au1.getSelectedDate().getTime()) ; 
            
            
        dte1 = dte1+" "+this.h11.getText() ;
        // System.out.println(this.n1) ;
        dte2 = dte2+" "+this.h12.getText() ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
      
        
      
           DefaultTableModel dtm = (DefaultTableModel) jTable7.getModel() ;
                             dtm.setRowCount(0) ;
        
       String sql = null ;
       ResultSet rs = null ;
       
       long to = 0 ;
       
 //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
           
           sql = "select * from detail_at where cb_dt = "+cb ;
         
      
         rs = stmt.executeQuery(sql) ;
     
         while(rs.next()){
             
             if(etat.equalsIgnoreCase("NON")){
                 
             }else{
     
             to += rs.getInt("mtt") ;
      
             }
             
       dtm.addRow(new Object[]{
     
   //   "DESCRIPTION", "QTE", "P.U", "MTT"
   
          rs.getString("description"), this.nf3.format(rs.getInt("nbre")) , this.nf3.format(rs.getInt("pu")), this.nf3.format(rs.getInt("mtt")) , etat
             
        
         }) ;
 
         }

       
        t11.setText("TOTAL : "+this.nf3.format(to)) ;
        
          if(etat.equalsIgnoreCase("NON")){
              
              this.jButton15.setEnabled(false) ;
              
               sql = "select login_an , date_an from tache_at where cb = "+cb ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    JOptionPane.showMessageDialog(null, "LOGIN : "+rs.getString("login_an")+System.getProperty("line.separator")+new String("DATE : "+this.sdf_java_.format(rs.getTimestamp("date_an")))) ;
                }
                 
             }else if(etat.equalsIgnoreCase("OUI")){
              
                this.jButton15.setEnabled(true) ;
                
               
                 
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
            
       
        
        
        
        
    }//GEN-LAST:event_jTable6MouseReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

          if (JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS ANNULER ?", "CONFIRMATION",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        // yes option
        
        if(this.jTable1.getSelectedRow() == -1){
            
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
      
  
      
if(stmt.executeUpdate("update tache_at set etat = 'NON' , login_an = '"+this.login.replace("'", "''")+"' , date_an = '"+this.sdf_mysql_.format(new Date())+"' "
              + "where id_at = "+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString()) == 1){
      
      
         
       this.jTable1.setValueAt("NON", this.jTable1.getSelectedRow(), 7);
       this.jTable1.getSelectionModel().clearSelection();
      
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
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
       
          if (JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS ANNULER ?", "CONFIRMATION",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        // yes option
        
        if(this.jTable6.getSelectedRow() == -1){
            
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
      
  
      
if(stmt.executeUpdate("update tache_at set etat = 'NON' , login_an = '"+this.login.replace("'", "''")+"' , date_an = '"+this.sdf_mysql_.format(new Date())+"' "
              + "where id_at = "+this.jTable6.getValueAt(this.jTable6.getSelectedRow(), 1).toString()) == 1){
      
      
         
       this.jTable6.setValueAt("NON", this.jTable6.getSelectedRow(), 7);
       this.jTable6.getSelectionModel().clearSelection();
      
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
        
        
    }//GEN-LAST:event_jButton15ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_at_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_at_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_at_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_at_.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_at_().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel atelier;
    private datechooser.beans.DateChooserCombo au;
    private datechooser.beans.DateChooserCombo au1;
    private static javax.swing.JTextField desc;
    private static javax.swing.JTextField desc1;
    private datechooser.beans.DateChooserCombo du;
    private datechooser.beans.DateChooserCombo du1;
    private javax.swing.JFormattedTextField h1;
    private javax.swing.JFormattedTextField h11;
    private javax.swing.JFormattedTextField h12;
    private javax.swing.JFormattedTextField h2;
    private javax.swing.JPanel in_at;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JPanel out_at;
    private javax.swing.JFormattedTextField pu;
    private javax.swing.JFormattedTextField pu1;
    private javax.swing.JFormattedTextField qt;
    private javax.swing.JFormattedTextField qt1;
    private javax.swing.JLabel t1;
    private javax.swing.JLabel t11;
    private javax.swing.JComboBox tech;
    private javax.swing.JComboBox tech1;
    private javax.swing.JComboBox tech_r;
    private javax.swing.JComboBox tech_r1;
    private javax.swing.JLabel to;
    private javax.swing.JLabel to1;
    private javax.swing.JPanel vierge;
    // End of variables declaration//GEN-END:variables
}
