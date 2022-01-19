/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import static frontend.ListOpStandart.JDBC_DRIVER;
import static frontend.ListOp_En_Fini.JDBC_DRIVER;
import static frontend.Rubrique.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HAMZA
 */
public class ListOp_En_Cours extends javax.swing.JFrame {

        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
        static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
        static final String USER = "root" ;
        static final String PASS = "interco" ;
      
        String login ;
        String role ;
        
        long total ;
        Integer cb ;
        long qte ;
        long pu ;
        String description ;
        long portions ;
        
        String pere ;
        String derive ;
        ArrayList<String> list = new ArrayList<String>() ;
        
         // an
        
      long osa = 0 ;
      long osd = 0 ;
      String ma ;
      String md ;
      String descrip ;
      Integer vy = 0 ;
      long nsa = 0 ;
      long nsd = 0 ;
      long qte_an = 0 ;
        
        // an
        
      
      
    public ListOp_En_Cours(){
        initComponents();
    }
    
    
    public ListOp_En_Cours(String login){
        initComponents() ;
        
        this.login = login ;
        this.b1.setVisible(false) ;
     // this.b2.setVisible(false) ;
        
         Date jour2 = new Date() ;
        this.jDateChooser1.setDate(jour2);
        // this.h1.setText("00:00") ;
        this.jDateChooser2.setDate(jour2) ;
       // this.h2.setText("23:59") ;
        
        this.setLocationRelativeTo(null) ;
        
        String jour ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
                         jour = sdf.format(new Date()) ;
        
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
              
        
        
        
        
       //   ---------------
        
        
        //
        
       
        
     
        
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
        
        
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm1.setRowCount(0) ;
        
       
       
        
        //
       
            this.jTable2.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable2.getTableHeader().setOpaque(false) ; 
            this.jTable2.getTableHeader().setBackground(Color.black) ; 
          
        //    this.jTable1.setBackground(Color.white) ;
        
       
            this.jTable2.getTableHeader().setForeground(Color.white) ;
        
            this.jTable2.setRowHeight(25) ;
              
        
             
                  for (int i = 0; i < this.jTable2.getModel().getColumnCount(); i++) {
                    this.jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
        
        
        
        
        //  ---------  2� choix
              
        
        
        
        
       //   ---------------
        
        
        //
        
       
        
     
        
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        
      
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm2.setRowCount(0) ;
        
        
          
        this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 10) ;
        
      
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

        
 this.jTable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 4) ;
        
      
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

        
       
                       Connection conn = null ;
                       Statement  stmt = null  ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...") ;
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      
      String sql = null ;
      ResultSet rs = null ;
             
      
      
      sql = "select * from op_pl_f where motif = 'DECOUPAGE' AND etat = 'OUVERT' AND type = 'oui' order by id DESC" ;
             rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          
          dtm1.addRow(new Object[]{
          
              // "CODE BARRE", "ID", "DATE OP", "DATE SAISIE", "P.DEPART", "P.ARRIVER", "COMMISS", "MOTIF", "UTILISATEUR"
              
              rs.getInt("cb") , rs.getLong("id") , sdfT.format(rs.getTimestamp("date1")) , sdfT.format(rs.getTimestamp("date2")) ,
              rs.getString("depart") , rs.getString("arriver") , rs.getString("perso") , rs.getString("motif") , 
              rs.getString("comt")
            , rs.getString("admin") , rs.getString("type")
          
          }) ;
          
      }
      
      
      
         
      String role = "" ;
      sql = "select role from comptes_u where login = '"+this.login.replaceAll("'", "''")+"'" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
      
          role = rs.getString("role") ;
          
      }
      
      this.role = role ;
      
      if(role.equalsIgnoreCase("SUPER ADMINISTRATEUR") || role.equalsIgnoreCase("ADMINISTRATEUR")){
          
      }else{
          
          this.an.setEnabled(false) ;
          
      }
      
      
      
      
      // fin partie unitile :
      
      
          
      //STEP 6: Clean-up environment
 
      rs.close() ;
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
        
        
        
    // end saveing .....
                         
        
        
        
    }
    
   
    
    public static void actuTables(){
        DefaultTableModel dtm1 = (DefaultTableModel) jTable1.getModel() ;
                          dtm1.setRowCount(0) ;
        DefaultTableModel dtm2 = (DefaultTableModel) jTable2.getModel() ;
                          dtm2.setRowCount(0) ;
                          
                          
                             Connection conn = null ;
                             Statement  stmt = null  ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...") ;
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      
      String sql = null ;
      ResultSet rs = null ;
             
      
      
      sql = "select * from op_pl_f where motif = 'DECOUPAGE' AND etat = 'OUVERT' AND type = 'oui' order by id DESC" ;
             rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          
          dtm1.addRow(new Object[]{
          
              // "CODE BARRE", "ID", "DATE OP", "DATE SAISIE", "P.DEPART", "P.ARRIVER", "COMMISS", "MOTIF", "UTILISATEUR"
              
              rs.getInt("cb") , rs.getLong("id") , sdfT.format(rs.getTimestamp("date1")) , sdfT.format(rs.getTimestamp("date2")) ,
              rs.getString("depart") , rs.getString("arriver") , rs.getString("perso") , rs.getString("motif") , 
              rs.getString("comt")
            , rs.getString("admin") , rs.getString("type")
          
          }) ;
          
      }
      
       
      // fin partie unitile :
      
      
          
      //STEP 6: Clean-up environment
 
      rs.close() ;
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
        
        
        
    // end saveing .....
                         
                          
                          
        
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
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        h1 = new javax.swing.JTextField();
        h2 = new javax.swing.JTextField();
        an = new javax.swing.JButton();
        id = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ecran = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTE OPERATION DE PLACEMENT EN COURS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FILTRE DES OPERATIONS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jDateChooser2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("DATE OP :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("DATE SAISIE OP :");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("FILTRER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("FILTRER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("HEURE");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("HEURE");

        an.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        an.setText("ANNULER");
        an.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        an.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anActionPerformed(evt);
            }
        });

        id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        id.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idKeyReleased(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h1)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(an, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(h1)
                            .addComponent(an, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h2)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE BARRE", "ID", "DATE OP", "DATE SAISIE", "P.DEPART", "P.ARRIVER", "COMMISS", "MOTIF", "COMT.", "UTILISATEUR", "TYPE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(40);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel3.setText("LA LISTE DES OPERATIONS DE PLACEMENT EN COURS");

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DESCRIPTION", "QTE", "P.U", "MONTANT", "TYPE"
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(5);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(5);
        }

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel4.setText("DETAIL & CONTENU DE L'OPERATION CHOISIE :");

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TACHES ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18))); // NOI18N

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("PORTIONS");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        b1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        b1.setText("ENVOIES");
        b1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        b2.setText("ACTUALISER");
        b2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("TOTAL MONTANT  :  ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setText("0");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ecran.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ecran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ecran, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(19, 19, 19))
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

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased

        // TODO add your handling code here :
        
        this.list.removeAll(this.list) ;
        
        
        this.total = 0 ;
        this.cb = 0 ;
        this.qte = 0 ;
        this.pu = 0 ;
        this.portions = 0 ;
        
         this.ma = "" ;
         this.md = "" ;
        
        this.cb = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString()) ;
        
        this.ma = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 5).toString().replaceAll("'", "''") ;
        this.md = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4).toString().replaceAll("'", "''") ;
        
        
        
         NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
               Connection conn = null ;
               Statement  stmt = null  ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...") ;
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                        dtm2.setRowCount(0) ;
       
      
      String sql ;
             sql = "select * from detail_pl where cb_op = "+this.cb+" AND etat = 'OUVERT' " ;
      ResultSet rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          
          if("OUI".equalsIgnoreCase(rs.getString("type"))){
          this.pere = rs.getString("description") ;
          }
          
          
          dtm2.addRow(new Object[]{
          
              // "DESCRIPTION", "QTE", "P.U", "MOTANT"
              
               
              
              rs.getString("description") , rs.getLong("qte") , rs.getLong("pu") , rs.getLong("mtt")  , rs.getString("type")
          
          }) ;
          
          
          this.total += rs.getLong("mtt") ;
          this.qte   += rs.getLong("qte") ;
          this.pu     = rs.getLong("pu") ;
          this.description = rs.getString("description") ;
          this.portions = rs.getLong("portions") ;
          
          
      }
      
          sql = "select description_d from p_derive where pere = '"+this.pere.replaceAll("'", "''")+"'" ;
          rs = stmt.executeQuery(sql) ;
          while(rs.next()){
              
              this.derive = rs.getString("description_d") ;
              String morceau = new String(this.derive) ; 
              this.list.add(morceau) ;
              
          }
          
      
      this.jLabel8.setText(nf3.format(this.total)) ;
      
      
       String et = "" ;
       String et_ = "" ;
      
             et_ = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 7).toString() ;
             et = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 10).toString() ;
             
             if(et.equalsIgnoreCase("non") || et_.equalsIgnoreCase("ARRIVAGE") || et_.equalsIgnoreCase("DEPART")){
                 this.an.setEnabled(false);
                 this.jButton3.setEnabled(false) ;
                 
             }else if(et.equalsIgnoreCase("oui")){
                 this.an.setEnabled(true) ;
                 this.jButton3.setEnabled(true) ;
                 
             }
      
             
      // fin partie unitile :
      
      
          
      //STEP 6: Clean-up environment
 
      rs.close() ;
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
        
        
        
    // end saveing .....
        
                            if(role.equalsIgnoreCase("SUPER ADMINISTRATEUR") || role.equalsIgnoreCase("ADMINISTRATEUR")){
          
      }else{
          
          this.an.setEnabled(false) ;
          
      }    
        
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "CHOISIR L'OPERATION DE PLACEMENT DANS LA LISTE A GAUCHE SVP !!! ") ;
            
        }else{
            
            if(this.list.size() == 0){
                JOptionPane.showMessageDialog(this, "ADMINISTRATEUR DOIT D'ABORD CREER LES PORTIONS OU MORCEAU DE CE PRODUIT MERCI DE LUI INFORMER") ;
            }else{
            
        Decoupage dec = new Decoupage(this.login , this.cb , this.list) ;
                  dec.setVisible(true) ;
                  
              
        }
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "SELECTIONNER L'OPERATION DE PLACEMENT DANS LA LISTE A GAUCHE ! ") ;
        }else{
            
        Envoi_op_fini  eop = new Envoi_op_fini(this.login, this.cb) ;
                       eop.setVisible(true) ;
              
        }
        
    }//GEN-LAST:event_b1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
         DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
         DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                           dtm1.setRowCount(0) ;
                           dtm2.setRowCount(0) ;
                           this.total = 0 ;
                          
                          try{
                              
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
                              
               Connection conn = null ;
               Statement  stmt = null  ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...") ;
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      
      String sql ;
             sql = "select * from op_pl_f where date1 like '%"+dte1+"%' AND motif = 'DECOUPAGE' AND etat = 'OUVERT' order by id desc" ;
      ResultSet rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          
          dtm1.addRow(new Object[]{
          
              // "CODE BARRE", "ID", "DATE OP", "DATE SAISIE", "P.DEPART", "P.ARRIVER", "COMMISS", "MOTIF", "UTILISATEUR"
              
              rs.getInt("cb") , rs.getLong("id") , sdfT.format(rs.getTimestamp("date1")) , sdfT.format(rs.getTimestamp("date2")) ,
              rs.getString("depart") , rs.getString("arriver") , rs.getString("perso") , rs.getString("motif") , rs.getString("comt")
            , rs.getString("admin"), rs.getString("type")
          
          }) ;
          
      }
      
      
      
      // fin partie unitile :
      
      
          
      //STEP 6: Clean-up environment
 
      rs.close() ;
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
        
        
        
    // end saveing .....
        
                              
                              
                          }catch(Exception e){
                              JOptionPane.showMessageDialog(this, "CHOISIR LA DATE ET L'HEURE CORRECTE SVP !!! ") ;
                          }
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        
         DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
         DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                          dtm1.setRowCount(0) ;
                          dtm2.setRowCount(0) ;
                          this.total = 0 ;
                          
                          try{
                              
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
                              
               Connection conn = null ;
               Statement  stmt = null  ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...") ;
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      
      String sql ;
             sql = "select * from op_pl_f where date2 like '%"+dte1+"%' AND motif = 'DECOUPAGE' AND etat = 'OUVERT' order by id desc" ;
      ResultSet rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          
          dtm1.addRow(new Object[]{
          
              // "CODE BARRE", "ID", "DATE OP", "DATE SAISIE", "P.DEPART", "P.ARRIVER", "COMMISS", "MOTIF", "UTILISATEUR"
              
              rs.getInt("cb") , rs.getLong("id") , sdfT.format(rs.getTimestamp("date1")) , sdfT.format(rs.getTimestamp("date2")) ,
              rs.getString("depart") , rs.getString("arriver") , rs.getString("perso") , rs.getString("motif") , rs.getString("comt")
            , rs.getString("admin"), rs.getString("type")
          
          }) ;
          
      }
      
      
      
      // fin partie unitile :
      
      
          
      //STEP 6: Clean-up environment
 
      rs.close() ;
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
        
        
        
    // end saveing .....
        
                              
                              
                          }catch(Exception e){
                              JOptionPane.showMessageDialog(this, "CHOISIR LA DATE ET L'HEURE CORRECTE SVP !!! ") ;
                          }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed
String nw = "" ;
    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
        
      //  this.jTable2.getSelectionModel().clearSelection() ;
        
         SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
        
        this.osa = 0 ;
        this.osd = 0 ;
        this.qte_an = 0 ;
        this.nsa = 0 ;
        this.nsd = 0 ;
        this.descrip = "" ;
        
        this.descrip = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString().replaceAll("'", "''") ;
        this.qte_an = Long.parseLong(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString()) ;
        this.nw = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 4).toString() ;
        
        
        if(this.nw.equalsIgnoreCase("non")){
            this.an.setEnabled(false) ;
        }else if(this.nw.equalsIgnoreCase("oui")){
            
            this.an.setEnabled(true) ;
            
        }
        
                Connection conn = null ;
                Statement  stmt = null  ;
       
       try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...") ;
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      
      stmt = conn.createStatement() ;
      
      //je crai ma requete
      
      
      
      String sql = null ;
      ResultSet rs = null ;
      
             sql = "select stock_dispo from stock_pl where magasin = '"+this.ma+"' and description = '"+this.descrip+"'" ;
             rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          this.osa = rs.getLong("stock_dispo") ;
      }
       
       sql = "select stock_dispo from stock_pl where magasin = '"+this.md+"' and description = '"+this.descrip+"'" ;
             rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          this.osd = rs.getLong("stock_dispo") ;
      }

      
      this.nsa = (this.osa - this.qte_an) ;
      this.nsd = (this.osd + this.qte_an) ;
      
      
      
      
  //    JOptionPane.showMessageDialog(this, " osa : "+this.osa+" , osd : "+this.osd) ;
       
      int a = 0 ;
             
             sql = "select * from detail_pl where cb_op = "+this.cb+" and type = 'non' and description = '"+this.descrip+"'" ;
             rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          try{
          this.ecran.setText(rs.getString("login_sup")+"   "+sdfT.format(rs.getTimestamp("date_sup"))) ;
         a = 1 ;
          }catch(Exception e){
              
          }
      }
      
      if(a==0){
          this.ecran.setText("");
      }
          
      //STEP 6: Clean-up environment
 
      rs.close() ;
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
        
   
          if(role.equalsIgnoreCase("SUPER ADMINISTRATEUR") || role.equalsIgnoreCase("ADMINISTRATEUR")){
          
      }else{
          
          this.an.setEnabled(false) ;
          
      }
        
        
        
        
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        // TODO add your handling code here:
        
         ListOp_En_Cours lopc = new ListOp_En_Cours(this.login) ;
                        lopc.setVisible(true) ;
                        this.setVisible(false) ;
        
        
    }//GEN-LAST:event_b2ActionPerformed

    private void anActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anActionPerformed

         // TODO add your handling code here :
        
  
        
        SimpleDateFormat sup = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
                         
        SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
        

        if(this.jTable1.getSelectedRow() == -1 || this.jTable2.getSelectedRow() == -1){

            JOptionPane.showMessageDialog(this, "SELECTIONNER L'OPERATION AVEC UN PRODUIT SVP ") ;

        }else{
            
             
            
             if(JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS ANNULER ? " , "AVERTISSEMENT" , JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            // yes option :
                 
                 /*
                 if(this.osa >= this.qte_an){
                 */

            this.vy = 0 ;

            Connection conn = null ;
            Statement  stmt = null  ;

            try{
                //STEP 2: Register JDBC driver
                Class.forName(JDBC_DRIVER) ;

                //STEP 3: Open a connection
                // System.out.println("Connecting to database...") ;

                conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

                //STEP 4: Execute a query
                //System.out.println("Creating statement...");

                stmt = conn.createStatement() ;

                //je crai ma requete

                String sql = null ;
                ResultSet rs = null ;
                
                 sql = "select stock_dispo from stock_pl where magasin = '"+this.ma+"' and description = '"+this.descrip+"'" ;
             rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          this.osa = rs.getLong("stock_dispo") ;
      }
       
       sql = "select stock_dispo from stock_pl where magasin = '"+this.md+"' and description = '"+this.descrip+"'" ;
             rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          this.osd = rs.getLong("stock_dispo") ;
      }

      
      this.nsa = (this.osa - this.qte_an) ;
      this.nsd = (this.osd + this.qte_an) ;
      
                
                

                if(stmt.executeUpdate("update stock_pl set stock_dispo = "+this.nsa+" where magasin = '"+this.ma+"' "
                    + "and description = '"+this.descrip+"'") >= 0){
                if(stmt.executeUpdate("update stock_pl set stock_dispo = "+this.nsd+" where magasin = '"+this.md+"' "
                    + "and description = '"+this.descrip+"'") >= 0){

                if(stmt.executeUpdate("update detail_pl set type = 'non' where cb_op = "+this.cb+" "
                    +"and description = '"+this.descrip+"'") >= 0){
                    
                       stmt.executeUpdate("update detail_pl set login_sup = '"+this.login+"' where cb_op = "+this.cb+" "
              +"and description = '"+this.descrip+"'") ;
                   stmt.executeUpdate("update detail_pl set date_sup = '"+sup.format(new Date())+"' where cb_op = "+this.cb+" "
              +"and description = '"+this.descrip+"'") ;

                if(stmt.executeUpdate("update stock_detail_pl set type = 'non' where cb_op = "+this.cb+" "
                    +"and description = '"+this.descrip+"'") >= 0){
                    
                     stmt.executeUpdate("update stock_detail_pl set login_sup = '"+this.login+"' where cb_op = "+this.cb+" "
              +"and description = '"+this.descrip+"'") ;
                   stmt.executeUpdate("update stock_detail_pl set date_sup = '"+sup.format(new Date())+"' where cb_op = "+this.cb+" "
              +"and description = '"+this.descrip+"'") ;

                sql = "select * from detail_pl where cb_op = "+this.cb+" and type = 'oui' " ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    this.vy = 1 ;
                }

                if(this.vy == 0){
                    if(stmt.executeUpdate("update op_pl_f set type = 'non' where cb = "+this.cb+"") == 1){
                    }
                }else if(this.vy == 1){

                }
                
                DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        
                         dtm1.setRowCount(0) ;
                         dtm2.setRowCount(0) ;
                
                
                sql = "select * from op_pl_f where motif = 'DECOUPAGE' AND etat = 'OUVERT' AND type = 'oui' order by id DESC" ;
                rs = stmt.executeQuery(sql) ;
         while(rs.next()){
          
               dtm1.addRow(new Object[]{
          
              // "CODE BARRE", "ID", "DATE OP", "DATE SAISIE", "P.DEPART", "P.ARRIVER", "COMMISS", "MOTIF", "UTILISATEUR"
              
              rs.getInt("cb") , rs.getLong("id") , sdfT.format(rs.getTimestamp("date1")) , sdfT.format(rs.getTimestamp("date2")) ,
              rs.getString("depart") , rs.getString("arriver") , rs.getString("perso") , rs.getString("motif") , 
              rs.getString("comt")
            , rs.getString("admin") , rs.getString("type")
          
          }) ;
          
      }

                JOptionPane.showMessageDialog(this, "OPERATION ANNULER AVEC SUCCES") ;

            }

        }

        }

        }

        //STEP 6: Clean-up environment

        rs.close() ;
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

            /*
                 }else{
                 
                     JOptionPane.showMessageDialog(null, "QUANTITE INSUFFISANTE AU POINT D'ARRIVER") ;
                     
                 } */
        }else{}
         
        }

    }//GEN-LAST:event_anActionPerformed

    private void idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyReleased

        Connection conn = null ;
        Statement  stmt = null  ;

        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER) ;

            //STEP 3: Open a connection
            // System.out.println("Connecting to database...") ;

            conn = DriverManager.getConnection(DB_URL,USER,PASS) ;

            //STEP 4: Execute a query
            //System.out.println("Creating statement...");

            stmt = conn.createStatement() ;

            //je crai ma requete

            SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
            NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;

            DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
            DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
            dtm1.setRowCount(0) ;
            dtm2.setRowCount(0) ;
            this.total = 0 ;

            String code = this.id.getText().trim() ;

            if(code.isEmpty()){
                code = "0" ;
            }else{

            }

            String sql ;
            sql = "select * from op_pl_f where id = "+code+" AND motif = 'DECOUPAGE' AND etat = 'OUVERT' order by id desc" ;
            ResultSet rs = stmt.executeQuery(sql) ;
            while(rs.next()){

                dtm1.addRow(new Object[]{

                    // "CODE BARRE", "ID", "DATE OP", "DATE SAISIE", "P.DEPART", "P.ARRIVER", "COMMISS", "MOTIF", "UTILISATEUR"

                    rs.getInt("cb") , rs.getLong("id") , sdfT.format(rs.getTimestamp("date1")) , sdfT.format(rs.getTimestamp("date2")) ,
                    rs.getString("depart") , rs.getString("arriver") , rs.getString("perso") , rs.getString("motif") , rs.getString("comt")
                    , rs.getString("admin"), rs.getString("type")

                }) ;

            }

            // fin partie unitile :

            //STEP 6: Clean-up environment

            rs.close() ;
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

        // end saveing .....

    }//GEN-LAST:event_idKeyReleased

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
            java.util.logging.Logger.getLogger(ListOp_En_Cours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListOp_En_Cours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListOp_En_Cours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListOp_En_Cours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListOp_En_Cours().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton an;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JLabel ecran;
    private javax.swing.JTextField h1;
    private javax.swing.JTextField h2;
    private javax.swing.JFormattedTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable jTable1;
    private static javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
