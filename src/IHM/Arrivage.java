/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

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
public class Arrivage extends javax.swing.JFrame {
    
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
      Suggestion sg = new Suggestion() ;
      
      private String login;
      private String role;
      private String pos ;
      
      private int id_f;
      private int id_c;
      
      private ArrayList<Detail_op> list = new ArrayList<Detail_op>() ;
      private ArrayList<String> list_vy = new ArrayList<String>() ;
      
      Integer mtt = 0 ;
      
    
  
    public Arrivage() {
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
         DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
          DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
         
        
        dtm.setRowCount(0) ;
        dtm2.setRowCount(0) ;
        dtm3.setRowCount(0) ;
        
        
        
        
        
        
        
        
        
        // SET DICTIONARY PROVIDER FROM DICTIONARY PATH
   SpellChecker.setUserDictionaryProvider(new FileUserDictionary(userDictionaryPath)) ;
   

      //REGISTER DICTIONARY
  SpellChecker.registerDictionaries(getClass().getResource(userDictionaryPath), "fr") ;
 
 SpellChecker.register(desc) ;
 
 

     configurePopUp() ;
 
        
        desc.setText("");
        
    }
    
    
 public Arrivage(String login, String role, String pos) {
            
            
        initComponents();
        this.setLocationRelativeTo(null) ;
        
        this.login = login;
        this.role = role;
        this.pos = pos ;
        
        /*
            
             ADMINISTRATEUR
             SUPER ADMINISTRATEUR
             ADMINII
             TP3 SIBY
        
        */
        
        if(this.role.equalsIgnoreCase("TP3 SIBY")){
            
            this.du.setEnabled(false);
            this.au.setEnabled(false);
            this.h1.setEnabled(false);
            this.h2.setEnabled(false);
            
        }else{
            
            this.du.setEnabled(true);
            this.au.setEnabled(true);
            this.h1.setEnabled(true);
            this.h2.setEnabled(true);
            
            
        }
        
      
        
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
        
       
                  
                  
                  
               this.jTable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
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

          
                  
                  
                  
        
     
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
         DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
          DefaultTableModel dtm3 = (DefaultTableModel) this.jTable3.getModel() ;
         
        
        dtm.setRowCount(0) ;
        dtm2.setRowCount(0) ;
        dtm3.setRowCount(0) ;
        
        
        
        
        
        
        
        
        
        // SET DICTIONARY PROVIDER FROM DICTIONARY PATH
   SpellChecker.setUserDictionaryProvider(new FileUserDictionary(userDictionaryPath)) ;
   

      //REGISTER DICTIONARY
  SpellChecker.registerDictionaries(getClass().getResource(userDictionaryPath), "fr") ;
 
 SpellChecker.register(desc) ;
 
 

     configurePopUp() ;
 
        
        desc.setText("");
        
        
        
        
        
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
      
      
   
      
       sql = "SELECT * FROM categorie where type = 'OUI' order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
  
            this.cat.addItem(rs.getString("description")) ;
 
         }
   
     
       sql = "SELECT * FROM fournisseur where type = 'OUI' order by fournisseur asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
  
            this.four.addItem(rs.getString("fournisseur")) ;
 
         }
   
     this.h1.setText("00:00");
     this.h2.setText("23:59");
     
     
    
            
      // STEP 6: Clean-up environment
      
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
        
     }
     
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        du = new datechooser.beans.DateChooserCombo();
        pu = new javax.swing.JFormattedTextField();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        h2 = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        t1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        t2 = new javax.swing.JLabel();
        au = new datechooser.beans.DateChooserCombo();
        four = new javax.swing.JComboBox();
        h1 = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        desc = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        qt = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        cat = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        id = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1100, 610));
        setResizable(false);

        jLabel5.setText("DU");

        du.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        du.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 13));

        pu.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        pu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pu.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jButton4.setBackground(new java.awt.Color(51, 102, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("FILTRER");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 102, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("VALIDER");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        h2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h2.setText("23:59");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("P.U");

        jButton3.setBackground(new java.awt.Color(51, 102, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("RETIRER");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        t1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t1.setText("TOTAL :");
        t1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DESCRIPTION");

        jLabel6.setText("AU");

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DESCRIPTION", "QTE", "P.U", "MTT"
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
        jTable1.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMinWidth(90);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(2).setMinWidth(90);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(3).setMinWidth(90);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        t2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        t2.setText("TOTAL : 0");

        au.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 1));
        au.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 13));

        four.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        four.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR FOURNISSEUR" }));
        four.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        four.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        four.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourActionPerformed(evt);
            }
        });

        h1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        try {
            h1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        h1.setText("00:00");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("HEURE");

        desc.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        desc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        desc.setMaximumSize(new java.awt.Dimension(6, 21));
        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descKeyReleased(evt);
            }
        });

        jTable3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
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
        jTable3.setUpdateSelectionOnSort(false);
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
            jTable3.getColumnModel().getColumn(4).setMinWidth(0);
            jTable3.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable3.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("HEURE");

        qt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        qt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qt.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jButton1.setBackground(new java.awt.Color(51, 102, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AJOUTER");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR CATEGORIE" }));
        cat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("QTE");

        jTable2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.setUpdateSelectionOnSort(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(1).setMinWidth(35);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(35);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(35);
            jTable2.getColumnModel().getColumn(2).setMinWidth(90);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(90);
            jTable2.getColumnModel().getColumn(3).setMinWidth(120);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(120);
            jTable2.getColumnModel().getColumn(6).setMinWidth(0);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(6).setMaxWidth(0);
            jTable2.getColumnModel().getColumn(7).setMinWidth(0);
            jTable2.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable2.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        id.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idFocusGained(evt);
            }
        });
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idKeyReleased(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ID ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(t1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(222, 222, 222)
                                .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(649, 649, 649))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(qt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pu, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(du, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(h1)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel6))
                                    .addComponent(au, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(h2)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(desc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qt)
                            .addComponent(pu)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)))
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(du, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(au, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void fourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourActionPerformed
      
        String rech = this.four.getSelectedItem().toString().trim().replaceAll("'", "''") ;
        
         
                
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
       
      
      this.id_f = 0 ;
      
      String sql = null ;
      ResultSet rs = null ;
      
     
   
      
      sql = "SELECT id_fr FROM fournisseur where fournisseur = '"+rech+"' limit 1" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
       this.id_f = rs.getInt("id_fr") ;
        
         
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
        
          
        
    }//GEN-LAST:event_fourActionPerformed

    private void catActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catActionPerformed
      
           String rech = this.cat.getSelectedItem().toString().trim().replaceAll("'", "''") ;
        
         
                
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
       
      
      this.id_c = 0 ;
      
      String sql = null ;
      ResultSet rs = null ;
      
      
      
      sql = "SELECT id_cat FROM categorie where description = '"+rech+"' limit 1" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
       this.id_c = rs.getInt("id_cat") ;
        
         
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
        
          
        
        
    }//GEN-LAST:event_catActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        String four, cat, desc1, qt, pu ;
        
        four = this.four.getSelectedItem().toString() ;
        cat = this.cat.getSelectedItem().toString() ;
        
        desc1 = desc.getText().trim().replaceAll("'", "''") ;
        qt = this.qt.getText() ;
        pu = this.pu.getText() ;
        
        if(four.equalsIgnoreCase("CHOISIR FOURNISSEUR") || cat.equalsIgnoreCase("CHOISIR CATEGORIE") || desc1.isEmpty() || qt.isEmpty() || pu.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT") ;
            
        }else{
            
            this.four.setEnabled(false) ; this.cat.setEnabled(false);
            
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
                          desc.setText(""); this.qt.setText("") ; this.pu.setText("");
                          
                          
                      }
                      
                      
            
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  
    
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
                               
                               four.setSelectedItem("CHOISIR FOURNISSEUR") ;
                               cat.setSelectedItem("CHOISIR CATEGORIE") ;
                               
                               four.setEnabled(true);   cat.setEnabled(true) ;
                               
                               
                           }
                           
                           dtm.removeRow(this.jTable1.getSelectedRow()) ;
                           
        
            
             }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         
        
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
      
      if(stmt.executeUpdate("insert into arrivage(id_fourni, id_cat, pos, login, datej, cb, total) "
              + "values("+this.id_f+" , "+this.id_c+" , '"+this.pos+"' , '"+this.login+"' , '"+date+"' , "+cb+" , "+this.mtt+")") == 1){
          
          
      for(int i =0; i < this.list.size() ; i++){
          
          stmt.executeUpdate("insert into detail_arrivage(description, qte, pu, mtt, cb_arriv) "
              + "values('"+this.list.get(i).getDescription()+"' , "+this.list.get(i).getQte()+" , "+this.list.get(i).getPu()+" , "
                  +this.list.get(i).getMtt()+" , "+cb+")") ;
          
      }
          
     
       this.four.setSelectedItem(new String("CHOISIR FOURNISSEUR")) ; 
       this.desc.setText("") ; this.qt.setText(""); this.pu.setText("");
       this.cat.setSelectedItem(new String("CHOISIR CATEGORIE")) ;
       
       this.four.setEnabled(true) ;
       this.cat.setEnabled(true) ;
       
       
       this.list.removeAll(this.list) ; this.list_vy.removeAll(this.list_vy) ;
       
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
                           
                           this.mtt = 0 ;
                           this.t1.setText("TOTAL :");
      
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
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     
        
          
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
       
 //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
           
           sql = "select arrivage.pos as pos, arrivage.id_ar as id, arrivage.login as login, arrivage.datej as date, fournisseur.fournisseur as fourni, "
                   + "categorie.description as cat, arrivage.cb as cb, arrivage.etat as etat "
              + "from arrivage, fournisseur, categorie "
              + "where arrivage.datej between '"+dte1+"' and '"+dte2+"' and fournisseur.id_fr = arrivage.id_fourni and categorie.id_cat = arrivage.id_cat "
              + "order by arrivage.datej desc" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
     
          
        
   
      dtm.addRow(new Object[]{
     
      //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
   
  rs.getString("pos"), rs.getString("id") , rs.getString("login"), sdf1.format(rs.getTimestamp("date")), rs.getString("fourni"), rs.getString("cat") , rs.getInt("cb") 
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
        
             DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel() ;
                               dtm.setRowCount(0) ;
      
              
            
            JOptionPane.showMessageDialog(this, "Saisir une periode svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
       
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        
        
         String cb = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 6).toString() ;
         String etat = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 7).toString() ;
        
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
        
       String sql = null ;
       ResultSet rs = null ;
       
       long to = 0 ;
       
     //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
           
           sql = "select * from detail_arrivage where cb_arriv = "+cb ;
         
      
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

       
        t2.setText("TOTAL : "+this.nf3.format(to)) ;
        
        
        
        
        if(etat.equalsIgnoreCase(new String("NON"))){
            sql = "select login_an , date_an from arrivage where cb = "+cb ;
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
                              
                              int id = 0 ;
                              
                              try{
                                  id = Integer.parseInt(this.id.getText()) ;
                                  
                              }catch(Exception e){
                                  
                                  id = 0 ;
                                  
                              }
        
       String sql = null ;
       ResultSet rs = null ;
       
 //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
           
           sql = "select arrivage.pos as pos, arrivage.id_ar as id, arrivage.login as login, arrivage.datej as date, fournisseur.fournisseur as fourni, "
                   + "categorie.description as cat, arrivage.cb as cb "
              + "from arrivage, fournisseur, categorie "
              + "where arrivage.id_ar = "+id+" and fournisseur.id_fr = arrivage.id_fourni and categorie.id_cat = arrivage.id_cat "
              + "order by arrivage.datej desc" ;
           
           
     
      
        rs = stmt.executeQuery(sql) ;
     
      while(rs.next()){
     
     
          
        
   
      dtm.addRow(new Object[]{
     
      //  "POS", "ID", "USER", "DATE", "FOURNISSEUR", "CATEGORIE", "CB"
   
  rs.getString("pos"), rs.getString("id") , rs.getString("login"), sdf1.format(rs.getTimestamp("date")), rs.getString("fourni"), rs.getString("cat") , rs.getInt("cb") 
             
        
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

    private void idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idFocusGained
      this.id.setText("");
    }//GEN-LAST:event_idFocusGained

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
            java.util.logging.Logger.getLogger(Arrivage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Arrivage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Arrivage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Arrivage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Arrivage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo au;
    private javax.swing.JComboBox cat;
    private static javax.swing.JTextField desc;
    private datechooser.beans.DateChooserCombo du;
    private javax.swing.JComboBox four;
    private javax.swing.JFormattedTextField h1;
    private javax.swing.JFormattedTextField h2;
    private javax.swing.JFormattedTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JFormattedTextField pu;
    private javax.swing.JFormattedTextField qt;
    private javax.swing.JLabel t1;
    private javax.swing.JLabel t2;
    // End of variables declaration//GEN-END:variables
}
