/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import allCollection.ListCommande;
import collection.materiel.List_com;
import static frontend.Genre_gateau.JDBC_DRIVER;
import static frontend.Model_gateau_lc.JDBC_DRIVER;
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
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HAMZA
 */
public class Model_gateau_lc_cst extends javax.swing.JFrame {

    /**
     * Creates new form Model_gateau
     */
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
    
      String login ;
      String rdv_l ;
      String rdv_r ;
      
      
      
      String description;
   //   String dimension;
      Integer prx_ ;
      String observation;
      
      
    private Integer ref ;
    private String materiel ;
    private String dimension ;
    private Integer prix ;
    private Integer qte ;
    private Integer jour ;
    private Integer mtt ;
      
    
      ArrayList<List_com> list = new ArrayList<List_com>() ;
      ArrayList<String> list_vy = new ArrayList<String>() ;
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
      SimpleDateFormat sdfVy = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
      SimpleDateFormat sdfT_ = new SimpleDateFormat("dd-MM-yyyy HH:mm") ;
      SimpleDateFormat sdfT = new SimpleDateFormat("dd-MM-yyyy") ;
      
      private NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      
    public Model_gateau_lc_cst() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("LISTE DE MATERIEL");
        
    }

    
    public Model_gateau_lc_cst(String login , String rdv_l, String rdv_r ) {
        initComponents();
        this.setLocationRelativeTo(null) ;
        this.setTitle("LISTE DE MATERIEL") ;
        
        this.login = login ;
        this.rdv_l = rdv_l ;
        this.rdv_r = rdv_r ;
        
        
        
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
        
        
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm1.setRowCount(0) ;
        
       /*
        this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        // String status = (String) table.getModel().getValueAt(row, 3) ;
         
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
      
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
            setBackground(Color.gray);
            setForeground(Color.WHITE);
        } 
         
         
        
        if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
            
          
        return this ;
        
    }
    
});

 */       
     
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
     
        
       
        /*
        this.jTable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

     //   String status = (String) table.getModel().getValueAt(row, 3) ;
        
         
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
      
    
        if("oui".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("non".equalsIgnoreCase(status)){
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

    */    
        
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
      stmt  = conn.createStatement() ;
       
      
      //je crai ma requete
       
      
      
      String sql = null ;
      ResultSet rs = null ;
      
     
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
                           
       ArrayList<String> listM = new ArrayList<String>() ;
       ArrayList<String> listF = new ArrayList<String>() ;
       
         
         
   
      
       sql = "SELECT * FROM materiel_l where etat = 'oui' order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        listM.add(new String(rs.getString("description"))) ;
        
         
     }
     
     
     
     Integer nb_l = 0 ;
     Integer nb_d = 0 ;
     Integer nb = 0 ;
     
     
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
    
     
       sql = "select facture_lc.rdv_l as rdv_l, facture_lc.rdv_r as rdv_r , facture_lc.cb_f as code , facture_lc.etat as eta , detail_facture_lc.cb_f as dc , "
            +"detail_facture_lc.description as produit , sum(qte) as qte , id_m , materiel_l.id as ref ,"
            +"materiel_l.description as mat, materiel_l.dimension as dim , materiel_l.prix as prx , materiel_l.qte_m as qte_m , materiel_l.prx_c as prx_c , "
            +"materiel_l.nombre as nombre  from "
            +"facture_lc , detail_facture_lc , materiel_l "
            +"where facture_lc.etat = 'NON' and (facture_lc.rdv_l <= '"+this.rdv_l+"' OR facture_lc.rdv_l >= '"+this.rdv_l+"') "
            +"and detail_facture_lc.cb_f = facture_lc.cb_f and materiel_l.id = detail_facture_lc.id_m group by produit asc" ;
                                              // stmt1 = facture_lc.rdv_r < '"+this.rdv_l+"' "
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
         
         // debut :
         
         listF.add(new String(rs.getString("produit"))) ;
         
         
         nb_l = rs.getInt("qte") ;
         nb = rs.getInt("nombre") ;
         nb_d = (nb - nb_l) ;
         
         
         Integer nb_r = 0 ;
         
         
         if(rs.getTimestamp("rdv_r").before(sdf.parse(this.rdv_l)) || sdf.parse(this.rdv_r).before(rs.getTimestamp("rdv_l"))){
             
             nb_r = rs.getInt("qte") ;
             
         }
         
         nb_d = (nb_d + nb_r) ;
         
         if(nb_d < 0){
             
             nb_d = 0 ;
             
         }
         
         
         dtm.addRow(new Object[]{
            
        //  "ID", "DESCRIPTION", "DIMENSION", "PRIX", "QTE C", "PRIX C", "T.NOMBRE", "DISPONIBLE"
            
            rs.getInt("ref") , rs.getString("mat"), rs.getString("dim"), rs.getInt("prx") , rs.getInt("qte_m") ,
            rs.getInt("prx_c") , rs.getInt("nombre") , nb_d
         
        })  ;
            
         
         
         
         
        
         
         // fin :
        
       
        
        
     }
     
     
     
     for(int i = 0 ; i < listM.size() ; i++){
         
         if(listF.contains(new String(listM.get(i).toString()))){
             
         }else if(listF.contains(new String(listM.get(i).toString())) == false){
             
             sql = "select * from materiel_l where description = '"+listM.get(i).toString().replaceAll("'", "''")+"'" ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                 
                  dtm.addRow(new Object[]{
            
        //  "ID", "DESCRIPTION", "DIMENSION", "PRIX", "QTE C", "PRIX C", "T.NOMBRE", "DISPONIBLE"
            
            rs.getInt("id") , rs.getString("description"), rs.getString("dimension"), rs.getInt("prix") , rs.getInt("qte_m") ,
            rs.getInt("prx_c") , rs.getInt("nombre") , rs.getInt("nombre")
         
        }) ;
                 
             }
             
             
         }
         
         
         
     }
      
      
     
      
    
            
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
    
    
    
    public Model_gateau_lc_cst(String login) {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("LISTE DE MATERIEL");
        
        this.login = login ;
        
        
        
        
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
                          dtm1.setRowCount(0) ;
        
        
        
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
        dtm3.setRowCount(0) ;
     
 
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
        dtm4.setRowCount(0) ;
     
        
        
        
        
        
        
    }
    
    
    
    // end contructor cst :
    

    public String getRdv_l() {
        return rdv_l;
    }

    public void setRdv_l(String rdv_l) {
        this.rdv_l = rdv_l;
    }

    public String getRdv_r() {
        return rdv_r ;
    }

    public void setRdv_r(String rdv_r){
        this.rdv_r = rdv_r ;
    }
    

    public void setL(String l){
       // this.l.setText(l) ;
    }
    
    public void setR(String r){
        // this.r.setText(r) ;
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
        desc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        dim = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        prx = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        rdv = new com.toedter.calendar.JDateChooser();
        h = new javax.swing.JFormattedTextField();
        rdv1 = new com.toedter.calendar.JDateChooser();
        h1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTE MATERIEL DISPONIBLE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("               DESCRIPTION");

        dim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dimKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("          ID");

        prx.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prxKeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("            PRIX");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTE MATERIEL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DESCRIPTION", "DIMENSION", "PRIX", "QTE C", "PRIX C", "T.NOMBRE", "DISPONIBLE", "IMG"
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
            jTable1.getColumnModel().getColumn(0).setMinWidth(30);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(30);
            jTable1.getColumnModel().getColumn(1).setMinWidth(235);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(235);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(235);
            jTable1.getColumnModel().getColumn(2).setMinWidth(80);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(3).setMinWidth(75);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(4).setMinWidth(80);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(5).setMinWidth(76);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(76);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(76);
            jTable1.getColumnModel().getColumn(6).setMinWidth(80);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(7).setMinWidth(85);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(85);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(85);
            jTable1.getColumnModel().getColumn(8).setMinWidth(0);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FACTURE EN INTERACTION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jTable3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DATE", "ID", "CLIENT", "RDV L", "RDV R", "MTT", "LOGIN", "CODE BARRE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable3MouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setMinWidth(125);
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(125);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(125);
            jTable3.getColumnModel().getColumn(1).setMinWidth(30);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(30);
            jTable3.getColumnModel().getColumn(1).setMaxWidth(30);
            jTable3.getColumnModel().getColumn(2).setMinWidth(160);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(160);
            jTable3.getColumnModel().getColumn(2).setMaxWidth(160);
            jTable3.getColumnModel().getColumn(3).setMinWidth(125);
            jTable3.getColumnModel().getColumn(3).setPreferredWidth(125);
            jTable3.getColumnModel().getColumn(3).setMaxWidth(125);
            jTable3.getColumnModel().getColumn(4).setMinWidth(125);
            jTable3.getColumnModel().getColumn(4).setPreferredWidth(125);
            jTable3.getColumnModel().getColumn(4).setMaxWidth(125);
            jTable3.getColumnModel().getColumn(5).setMinWidth(80);
            jTable3.getColumnModel().getColumn(5).setPreferredWidth(80);
            jTable3.getColumnModel().getColumn(5).setMaxWidth(80);
            jTable3.getColumnModel().getColumn(6).setMinWidth(90);
            jTable3.getColumnModel().getColumn(6).setPreferredWidth(90);
            jTable3.getColumnModel().getColumn(6).setMaxWidth(90);
            jTable3.getColumnModel().getColumn(7).setMinWidth(0);
            jTable3.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable3.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DETAIL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jTable4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DESCRIPTION", "DIMENSION", "PRIX", "QTE", "JOUR", "MTT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable4.getTableHeader().setReorderingAllowed(false);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable4MouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setMinWidth(30);
            jTable4.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable4.getColumnModel().getColumn(0).setMaxWidth(30);
            jTable4.getColumnModel().getColumn(1).setMinWidth(260);
            jTable4.getColumnModel().getColumn(1).setPreferredWidth(260);
            jTable4.getColumnModel().getColumn(1).setMaxWidth(260);
            jTable4.getColumnModel().getColumn(2).setMinWidth(80);
            jTable4.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTable4.getColumnModel().getColumn(2).setMaxWidth(80);
            jTable4.getColumnModel().getColumn(3).setMinWidth(80);
            jTable4.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable4.getColumnModel().getColumn(3).setMaxWidth(80);
            jTable4.getColumnModel().getColumn(4).setMinWidth(80);
            jTable4.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTable4.getColumnModel().getColumn(4).setMaxWidth(80);
            jTable4.getColumnModel().getColumn(5).setMinWidth(80);
            jTable4.getColumnModel().getColumn(5).setPreferredWidth(80);
            jTable4.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        try {
            h.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hActionPerformed(evt);
            }
        });

        try {
            h1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("LIVRAISON *");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("RAMASSAGE *");

        jButton1.setBackground(new java.awt.Color(0, 102, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("VALIDER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdv, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(h, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(rdv1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(desc))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dim, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prx, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(rdv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(h)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rdv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void descKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyReleased
        
                // TODO add your handling code here :

                
                
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
      stmt  = conn.createStatement() ;
       
      
      //je crai ma requete
       
      
      
      String sql = null ;
      ResultSet rs = null ;
      
     
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
                           
       ArrayList<String> listM = new ArrayList<String>() ;
       ArrayList<Integer> listM_id = new ArrayList<Integer>() ;
       
       
       ArrayList<facture_test> listf_id = new ArrayList<facture_test>() ;
       ArrayList<facture_test> listf_id_f = new ArrayList<facture_test>() ;
       
       
       ArrayList<String> listF = new ArrayList<String>() ;
       
        ArrayList<Mat_list> listMat = new ArrayList<Mat_list>() ; 
        ArrayList<Mat_list> listMat_f = new ArrayList<Mat_list>() ;  
   
      
       sql = "SELECT * FROM materiel_l where etat = 'oui' group by id order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        listM.add(new String(rs.getString("description"))) ;
        listM_id.add(rs.getInt("id")) ;
        
         
     }
     
     
     
     Integer nb_l = 0 ;
     Integer nb_d = 0 ;
     Integer nb = 0 ;
     
     
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
    
           /*
      
       sql = "select facture_lc.id as id_fact, facture_lc.rdv_l as rdv_l, facture_lc.rdv_r as rdv_r , facture_lc.cb_f as code , facture_lc.etat as eta , detail_facture_lc.cb_f as dc , "
            +"detail_facture_lc.description as produit , sum(qte) as qte , id_m , materiel_l.id as ref ,"
            +"materiel_l.description as mat, materiel_l.dimension as dim , materiel_l.prix as prx , materiel_l.qte_m as qte_m , materiel_l.prx_c as prx_c , "
            +"materiel_l.nombre as nombre , materiel_l.code_img as img from "
            +"facture_lc , detail_facture_lc , materiel_l "
            +"where facture_lc.etat = 'NON' "
            +"and detail_facture_lc.cb_f = facture_lc.cb_f and materiel_l.id = detail_facture_lc.id_m group by ref order by produit asc" ;
       
                                              // stmt1 = facture_lc.rdv_r < '"+this.rdv_l+"' "
      
           */
      
       sql = "select id , rdv_l, rdv_r  from facture_lc where etat = 'NON' and etat_an = 'OUI'" ;
      
      
       rs = stmt.executeQuery(sql) ;
      
      
      while(rs.next()){
         
          int id = rs.getInt("id") ;
          String rdv_ll = sdf.format(rs.getTimestamp("rdv_l")) ;
          String rdv_rr = sdf.format(rs.getTimestamp("rdv_r")) ;
          
          facture_test ft = new facture_test(id, rdv_ll, rdv_rr) ;
         
         listf_id.add(ft) ;
        
        
        }
      
      
      for(int i = 0 ; i < listf_id.size() ; i++){
          
         
     if(sdf.parse(this.rdv_l).compareTo(sdf.parse(listf_id.get(i).getRdv_l())) * sdf.parse(listf_id.get(i).getRdv_l()).compareTo(sdf.parse(this.rdv_r)) >= 0){
       
        
         Integer id = listf_id.get(i).getId() ;
         String dl = listf_id.get(i).getRdv_l() ;
         String dr = listf_id.get(i).getRdv_r() ;
         
         facture_test ft = new facture_test(id, dl, dr) ;
         
         listf_id_f.add(ft) ;
        
         
    }else if(sdf.parse(this.rdv_l).compareTo(sdf.parse(listf_id.get(i).getRdv_r())) * sdf.parse(listf_id.get(i).getRdv_r()).compareTo(sdf.parse(this.rdv_r)) >= 0){
        
         
          Integer id = listf_id.get(i).getId() ;
          String dl = listf_id.get(i).getRdv_l() ;
          String dr = listf_id.get(i).getRdv_r() ;
         
         facture_test ft = new facture_test(id, dl, dr) ;
         
         listf_id_f.add(ft) ;
        
         
         
    }else if(sdf.parse(listf_id.get(i).getRdv_l()).before(sdf.parse(this.rdv_l)) && sdf.parse(listf_id.get(i).getRdv_r()).after(sdf.parse(this.rdv_r))){
        
          
           Integer id = listf_id.get(i).getId() ;
           String dl = listf_id.get(i).getRdv_l() ;
           String dr = listf_id.get(i).getRdv_r() ;
         
         facture_test ft = new facture_test(id, dl, dr) ;
         
         listf_id_f.add(ft) ;
         
   
     }else{
       
        
        
       }
         
         
          
      
      }
      
      ArrayList<Integer> listM_id_c = new ArrayList<Integer>() ;
      
      for(int i = 0 ; i < listf_id_f.size() ; i++){
          
          
           sql = "select facture_lc.id as id_fact, facture_lc.rdv_l as rdv_l, facture_lc.rdv_r as rdv_r , facture_lc.cb_f as code , facture_lc.etat as eta , detail_facture_lc.cb_f as dc , "
            +"detail_facture_lc.description as produit , qte as qte , id_m , materiel_l.id as ref ,"
            +"materiel_l.description as mat, materiel_l.dimension as dim , materiel_l.prix as prx , materiel_l.qte_m as qte_m , materiel_l.prx_c as prx_c , "
            +"materiel_l.nombre as nombre , materiel_l.code_img as img from "
            +"facture_lc , detail_facture_lc , materiel_l "
            +"where facture_lc.id = "+listf_id_f.get(i).getId()+" "
            +"and detail_facture_lc.cb_f = facture_lc.cb_f and materiel_l.id = detail_facture_lc.id_m and "
                   + "materiel_l.description like '%"+desc.getText().trim().replaceAll("'", "''")+"%'" ;
           
           rs = stmt.executeQuery(sql) ;
           while(rs.next()){
               
               Mat_list ml = new Mat_list() ;
                        ml.setId(rs.getInt("ref"));
                        ml.setQte(rs.getInt("qte"));
                        
                  listM_id_c.add(rs.getInt("ref")) ;
                  listMat.add(ml) ;
                        
           }
          
          
      } 
      
      
     Random rx = new Random() ;
     Integer cb = rx.nextInt() ;
     if(cb < 0){
         cb = Math.abs(cb) ;
     }
     
     
      for(int i = 0 ; i < listMat.size() ; i++){
          
           stmt.executeUpdate("insert into mat_cumul(id_m, qte, cb) values("+listMat.get(i).getId()+" , "+listMat.get(i).getQte()+" , "
                   +cb+")") ;
          
           
          System.out.println("id = "+listMat.get(i).getId()+" qte = "+listMat.get(i).getQte());
          
         }
      
      
      sql = "select id_m as ref , sum(qte) as nb "
              + "from mat_cumul "
              + "where cb = "+cb+" group by ref" ;
      
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          
          Integer id = rs.getInt("ref") ;
          Integer qte = rs.getInt("nb") ;
          
          Mat_list ml = new Mat_list() ;
                   ml.setId(id);
                   ml.setQte(qte);
             
                  listMat_f.add(ml) ;
          
      }
      
      stmt.executeUpdate("delete from mat_cumul where cb = "+cb) ;
      
      
      for(int i = 0 ; i < listMat_f.size() ; i++){
          
 
          Integer dispo = 0 ;
          
                       
             sql = "select * from materiel_l where id = "+listMat_f.get(i).getId() ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                 
                 dispo = (rs.getInt("nombre") - listMat_f.get(i).getQte()) ;
                 
                  dtm.addRow(new Object[]{
            
        //  "ID", "DESCRIPTION", "DIMENSION", "PRIX", "QTE C", "PRIX C", "T.NOMBRE", "DISPONIBLE"
            
            rs.getInt("id") , rs.getString("description"), rs.getString("dimension"), rs.getInt("prix") , rs.getInt("qte_m") ,
            rs.getInt("prx_c") , rs.getInt("nombre") , dispo , rs.getString("code_img")
         
        }) ;
                 
             }
            
          
          
          
         }
      
      
  
      
    
            
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
        
          
        
        
        
        
        
        
    }//GEN-LAST:event_descKeyReleased

    private void dimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dimKeyReleased
        // TODO add your handling code here:
        
         
                
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
      stmt  = conn.createStatement() ;
       
      
      //je crai ma requete
       
      
      
      String sql = null ;
      ResultSet rs = null ;
      
     
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
                           
       ArrayList<String> listM = new ArrayList<String>() ;
       ArrayList<Integer> listM_id = new ArrayList<Integer>() ;
       
       
       ArrayList<facture_test> listf_id = new ArrayList<facture_test>() ;
       ArrayList<facture_test> listf_id_f = new ArrayList<facture_test>() ;
       
       
       ArrayList<String> listF = new ArrayList<String>() ;
       
        ArrayList<Mat_list> listMat = new ArrayList<Mat_list>() ; 
        ArrayList<Mat_list> listMat_f = new ArrayList<Mat_list>() ;  
   
      
       sql = "SELECT * FROM materiel_l where etat = 'oui' group by id order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        listM.add(new String(rs.getString("description"))) ;
        listM_id.add(rs.getInt("id")) ;
        
         
     }
     
     
     
     Integer nb_l = 0 ;
     Integer nb_d = 0 ;
     Integer nb = 0 ;
     
     
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
    
           /*
      
       sql = "select facture_lc.id as id_fact, facture_lc.rdv_l as rdv_l, facture_lc.rdv_r as rdv_r , facture_lc.cb_f as code , facture_lc.etat as eta , detail_facture_lc.cb_f as dc , "
            +"detail_facture_lc.description as produit , sum(qte) as qte , id_m , materiel_l.id as ref ,"
            +"materiel_l.description as mat, materiel_l.dimension as dim , materiel_l.prix as prx , materiel_l.qte_m as qte_m , materiel_l.prx_c as prx_c , "
            +"materiel_l.nombre as nombre , materiel_l.code_img as img from "
            +"facture_lc , detail_facture_lc , materiel_l "
            +"where facture_lc.etat = 'NON' "
            +"and detail_facture_lc.cb_f = facture_lc.cb_f and materiel_l.id = detail_facture_lc.id_m group by ref order by produit asc" ;
       
                                              // stmt1 = facture_lc.rdv_r < '"+this.rdv_l+"' "
      
           */
      
       sql = "select id , rdv_l, rdv_r  from facture_lc where etat = 'NON' and etat_an = 'OUI'" ;
      
      
       rs = stmt.executeQuery(sql) ;
      
      
      while(rs.next()){
         
          int id = rs.getInt("id") ;
          String rdv_ll = sdf.format(rs.getTimestamp("rdv_l")) ;
          String rdv_rr = sdf.format(rs.getTimestamp("rdv_r")) ;
          
          facture_test ft = new facture_test(id, rdv_ll, rdv_rr) ;
         
         listf_id.add(ft) ;
        
        
        }
      
      
      for(int i = 0 ; i < listf_id.size() ; i++){
          
         
     if(sdf.parse(this.rdv_l).compareTo(sdf.parse(listf_id.get(i).getRdv_l())) * sdf.parse(listf_id.get(i).getRdv_l()).compareTo(sdf.parse(this.rdv_r)) >= 0){
       
        
         Integer id = listf_id.get(i).getId() ;
         String dl = listf_id.get(i).getRdv_l() ;
         String dr = listf_id.get(i).getRdv_r() ;
         
         facture_test ft = new facture_test(id, dl, dr) ;
         
         listf_id_f.add(ft) ;
        
         
    }else if(sdf.parse(this.rdv_l).compareTo(sdf.parse(listf_id.get(i).getRdv_r())) * sdf.parse(listf_id.get(i).getRdv_r()).compareTo(sdf.parse(this.rdv_r)) >= 0){
        
         
          Integer id = listf_id.get(i).getId() ;
          String dl = listf_id.get(i).getRdv_l() ;
          String dr = listf_id.get(i).getRdv_r() ;
         
         facture_test ft = new facture_test(id, dl, dr) ;
         
         listf_id_f.add(ft) ;
        
         
         
    }else if(sdf.parse(listf_id.get(i).getRdv_l()).before(sdf.parse(this.rdv_l)) && sdf.parse(listf_id.get(i).getRdv_r()).after(sdf.parse(this.rdv_r))){
        
          
           Integer id = listf_id.get(i).getId() ;
           String dl = listf_id.get(i).getRdv_l() ;
           String dr = listf_id.get(i).getRdv_r() ;
         
         facture_test ft = new facture_test(id, dl, dr) ;
         
         listf_id_f.add(ft) ;
         
   
     }else{
       
        
        
       }
         
         
          
      
      }
      
      ArrayList<Integer> listM_id_c = new ArrayList<Integer>() ;
      
      for(int i = 0 ; i < listf_id_f.size() ; i++){
          
          
           sql = "select facture_lc.id as id_fact, facture_lc.rdv_l as rdv_l, facture_lc.rdv_r as rdv_r , facture_lc.cb_f as code , facture_lc.etat as eta , detail_facture_lc.cb_f as dc , "
            +"detail_facture_lc.description as produit , qte as qte , id_m , materiel_l.id as ref ,"
            +"materiel_l.description as mat, materiel_l.dimension as dim , materiel_l.prix as prx , materiel_l.qte_m as qte_m , materiel_l.prx_c as prx_c , "
            +"materiel_l.nombre as nombre , materiel_l.code_img as img from "
            +"facture_lc , detail_facture_lc , materiel_l "
            +"where facture_lc.id = "+listf_id_f.get(i).getId()+" "
            +"and detail_facture_lc.cb_f = facture_lc.cb_f and materiel_l.id = detail_facture_lc.id_m and "
                   + "materiel_l.id like '%"+dim.getText().trim().replaceAll("'", "''")+"%'" ;
           
           rs = stmt.executeQuery(sql) ;
           while(rs.next()){
               
               Mat_list ml = new Mat_list() ;
                        ml.setId(rs.getInt("ref"));
                        ml.setQte(rs.getInt("qte"));
                        
                  listM_id_c.add(rs.getInt("ref")) ;
                  listMat.add(ml) ;
                        
           }
          
          
      } 
      
      
     Random rx = new Random() ;
     Integer cb = rx.nextInt() ;
     if(cb < 0){
         cb = Math.abs(cb) ;
     }
     
     
      for(int i = 0 ; i < listMat.size() ; i++){
          
           stmt.executeUpdate("insert into mat_cumul(id_m, qte, cb) values("+listMat.get(i).getId()+" , "+listMat.get(i).getQte()+" , "
                   +cb+")") ;
          
           
          System.out.println("id = "+listMat.get(i).getId()+" qte = "+listMat.get(i).getQte());
          
         }
      
      
      sql = "select id_m as ref , sum(qte) as nb "
              + "from mat_cumul "
              + "where cb = "+cb+" group by ref" ;
      
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          
          Integer id = rs.getInt("ref") ;
          Integer qte = rs.getInt("nb") ;
          
          Mat_list ml = new Mat_list() ;
                   ml.setId(id);
                   ml.setQte(qte);
             
                  listMat_f.add(ml) ;
          
      }
      
      stmt.executeUpdate("delete from mat_cumul where cb = "+cb) ;
      
      
      for(int i = 0 ; i < listMat_f.size() ; i++){
          
 
          Integer dispo = 0 ;
          
                       
             sql = "select * from materiel_l where id = "+listMat_f.get(i).getId() ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                 
                 dispo = (rs.getInt("nombre") - listMat_f.get(i).getQte()) ;
                 
                  dtm.addRow(new Object[]{
            
        //  "ID", "DESCRIPTION", "DIMENSION", "PRIX", "QTE C", "PRIX C", "T.NOMBRE", "DISPONIBLE"
            
            rs.getInt("id") , rs.getString("description"), rs.getString("dimension"), rs.getInt("prix") , rs.getInt("qte_m") ,
            rs.getInt("prx_c") , rs.getInt("nombre") , dispo , rs.getString("code_img")
         
        }) ;
                 
             }
            
          
          
          
         }
      
      
   
     
      
    
            
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
        
          
        
        
        
        
    }//GEN-LAST:event_dimKeyReleased

    private void prxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prxKeyReleased
        // TODO add your handling code here:
        
          
            
               
                
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
      stmt  = conn.createStatement() ;
       
      
      //je crai ma requete
       
      
      
      String sql = null ;
      ResultSet rs = null ;
      
     
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
                           
       ArrayList<String> listM = new ArrayList<String>() ;
       ArrayList<Integer> listM_id = new ArrayList<Integer>() ;
       
       
       ArrayList<facture_test> listf_id = new ArrayList<facture_test>() ;
       ArrayList<facture_test> listf_id_f = new ArrayList<facture_test>() ;
       
       
       ArrayList<String> listF = new ArrayList<String>() ;
       
        ArrayList<Mat_list> listMat = new ArrayList<Mat_list>() ; 
        ArrayList<Mat_list> listMat_f = new ArrayList<Mat_list>() ;  
   
      
       sql = "SELECT * FROM materiel_l where etat = 'oui' group by id order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        listM.add(new String(rs.getString("description"))) ;
        listM_id.add(rs.getInt("id")) ;
        
         
     }
     
     
     
     Integer nb_l = 0 ;
     Integer nb_d = 0 ;
     Integer nb = 0 ;
     
     
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
    
           /*
      
       sql = "select facture_lc.id as id_fact, facture_lc.rdv_l as rdv_l, facture_lc.rdv_r as rdv_r , facture_lc.cb_f as code , facture_lc.etat as eta , detail_facture_lc.cb_f as dc , "
            +"detail_facture_lc.description as produit , sum(qte) as qte , id_m , materiel_l.id as ref ,"
            +"materiel_l.description as mat, materiel_l.dimension as dim , materiel_l.prix as prx , materiel_l.qte_m as qte_m , materiel_l.prx_c as prx_c , "
            +"materiel_l.nombre as nombre , materiel_l.code_img as img from "
            +"facture_lc , detail_facture_lc , materiel_l "
            +"where facture_lc.etat = 'NON' "
            +"and detail_facture_lc.cb_f = facture_lc.cb_f and materiel_l.id = detail_facture_lc.id_m group by ref order by produit asc" ;
       
                                              // stmt1 = facture_lc.rdv_r < '"+this.rdv_l+"' "
      
           */
      
       sql = "select id , rdv_l, rdv_r  from facture_lc where etat = 'NON' and etat_an = 'OUI'" ;
      
      
       rs = stmt.executeQuery(sql) ;
      
      
      while(rs.next()){
         
          int id = rs.getInt("id") ;
          String rdv_ll = sdf.format(rs.getTimestamp("rdv_l")) ;
          String rdv_rr = sdf.format(rs.getTimestamp("rdv_r")) ;
          
          facture_test ft = new facture_test(id, rdv_ll, rdv_rr) ;
         
         listf_id.add(ft) ;
        
        
        }
      
      
      for(int i = 0 ; i < listf_id.size() ; i++){
          
         
     if(sdf.parse(this.rdv_l).compareTo(sdf.parse(listf_id.get(i).getRdv_l())) * sdf.parse(listf_id.get(i).getRdv_l()).compareTo(sdf.parse(this.rdv_r)) >= 0){
       
        
         Integer id = listf_id.get(i).getId() ;
         String dl = listf_id.get(i).getRdv_l() ;
         String dr = listf_id.get(i).getRdv_r() ;
         
         facture_test ft = new facture_test(id, dl, dr) ;
         
         listf_id_f.add(ft) ;
        
         
    }else if(sdf.parse(this.rdv_l).compareTo(sdf.parse(listf_id.get(i).getRdv_r())) * sdf.parse(listf_id.get(i).getRdv_r()).compareTo(sdf.parse(this.rdv_r)) >= 0){
        
         
          Integer id = listf_id.get(i).getId() ;
          String dl = listf_id.get(i).getRdv_l() ;
          String dr = listf_id.get(i).getRdv_r() ;
         
         facture_test ft = new facture_test(id, dl, dr) ;
         
         listf_id_f.add(ft) ;
        
         
         
    }else if(sdf.parse(listf_id.get(i).getRdv_l()).before(sdf.parse(this.rdv_l)) && sdf.parse(listf_id.get(i).getRdv_r()).after(sdf.parse(this.rdv_r))){
        
          
           Integer id = listf_id.get(i).getId() ;
           String dl = listf_id.get(i).getRdv_l() ;
           String dr = listf_id.get(i).getRdv_r() ;
         
         facture_test ft = new facture_test(id, dl, dr) ;
         
         listf_id_f.add(ft) ;
         
   
     }else{
       
        
        
       }
         
         
          
      
      }
      
      ArrayList<Integer> listM_id_c = new ArrayList<Integer>() ;
      
      for(int i = 0 ; i < listf_id_f.size() ; i++){
          
          
           sql = "select facture_lc.id as id_fact, facture_lc.rdv_l as rdv_l, facture_lc.rdv_r as rdv_r , facture_lc.cb_f as code , facture_lc.etat as eta , detail_facture_lc.cb_f as dc , "
            +"detail_facture_lc.description as produit , qte as qte , id_m , materiel_l.id as ref ,"
            +"materiel_l.description as mat, materiel_l.dimension as dim , materiel_l.prix as prx , materiel_l.qte_m as qte_m , materiel_l.prx_c as prx_c , "
            +"materiel_l.nombre as nombre , materiel_l.code_img as img from "
            +"facture_lc , detail_facture_lc , materiel_l "
            +"where facture_lc.id = "+listf_id_f.get(i).getId()+" "
            +"and detail_facture_lc.cb_f = facture_lc.cb_f and materiel_l.id = detail_facture_lc.id_m and "
                   + "materiel_l.prix like '%"+prx.getText().trim().replaceAll("'", "''")+"%'" ;
           
           rs = stmt.executeQuery(sql) ;
           while(rs.next()){
               
               Mat_list ml = new Mat_list() ;
                        ml.setId(rs.getInt("ref"));
                        ml.setQte(rs.getInt("qte"));
                        
                  listM_id_c.add(rs.getInt("ref")) ;
                  listMat.add(ml) ;
                        
           }
          
          
      } 
      
      
     Random rx = new Random() ;
     Integer cb = rx.nextInt() ;
     if(cb < 0){
         cb = Math.abs(cb) ;
     }
     
     
      for(int i = 0 ; i < listMat.size() ; i++){
          
           stmt.executeUpdate("insert into mat_cumul(id_m, qte, cb) values("+listMat.get(i).getId()+" , "+listMat.get(i).getQte()+" , "
                   +cb+")") ;
          
           
          System.out.println("id = "+listMat.get(i).getId()+" qte = "+listMat.get(i).getQte());
          
         }
      
      
      sql = "select id_m as ref , sum(qte) as nb "
              + "from mat_cumul "
              + "where cb = "+cb+" group by ref" ;
      
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          
          Integer id = rs.getInt("ref") ;
          Integer qte = rs.getInt("nb") ;
          
          Mat_list ml = new Mat_list() ;
                   ml.setId(id);
                   ml.setQte(qte);
             
                  listMat_f.add(ml) ;
          
      }
      
      stmt.executeUpdate("delete from mat_cumul where cb = "+cb) ;
      
      
      for(int i = 0 ; i < listMat_f.size() ; i++){
          
 
          Integer dispo = 0 ;
          
                       
             sql = "select * from materiel_l where id = "+listMat_f.get(i).getId() ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                 
                 dispo = (rs.getInt("nombre") - listMat_f.get(i).getQte()) ;
                 
                  dtm.addRow(new Object[]{
            
        //  "ID", "DESCRIPTION", "DIMENSION", "PRIX", "QTE C", "PRIX C", "T.NOMBRE", "DISPONIBLE"
            
            rs.getInt("id") , rs.getString("description"), rs.getString("dimension"), rs.getInt("prix") , rs.getInt("qte_m") ,
            rs.getInt("prx_c") , rs.getInt("nombre") , dispo , rs.getString("code_img")
         
        }) ;
                 
             }
            
          
          
          
         }
      
      
   
      
    
            
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
        
          
         
          
       
        
    }//GEN-LAST:event_prxKeyReleased
Integer prix_c ;
Integer qte_c ;
Integer dispo ;
Integer prix_ = 0 ;
    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
        this.jTable3.getSelectionModel().clearSelection();
        this.jTable4.getSelectionModel().clearSelection();
        
        
    this.ref = 0 ;
    this.materiel = "" ;
    this.dimension = "" ;
    this.prix = 0 ;
    this.qte = 0 ;
    this.jour = 0 ;
    this.mtt = 0 ;
    this.prix_c = 0 ;
    this.qte_c = 0 ;
    this.dispo = 0 ;
    
        
    // "ID", "DESCRIPTION", "DIMENSION", "PRIX", "QTE C", "PRIX C", "T.NOMBRE", "DISPONIBLE"
    
    
        this.ref = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString()) ;
        this.materiel = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString().replaceAll("'","''").trim() ;
        this.dimension = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString().replaceAll("'","''").trim() ;
        this.prix = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3).toString()) ;
        this.qte_c = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4).toString()) ;
        this.prix_c = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 5).toString()) ;
        this.dispo = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 7).toString()) ;
      
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hActionPerformed
        // TODO add your handling code here:
        
        
        //
    }//GEN-LAST:event_hActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try{
            
            if("  :  :  ".equalsIgnoreCase(this.h.getText()) || "  :  :  ".equalsIgnoreCase(this.h1.getText())){
                
                JOptionPane.showMessageDialog(null, "L'HEURE EST OBLIGATOIRE") ;
                
                }else{
                
                String rdv_l , rdv_r , jour ;
               rdv_l = sdf.format(this.rdv.getDate())+" "+this.h.getText() ;
               rdv_r = sdf.format(this.rdv1.getDate())+" "+this.h1.getText() ;
               
               jour = this.sdfVy.format(new Date()) ;
               
               
               if(this.sdfVy.parse(rdv_l).before(this.sdfVy.parse(rdv_r)) && this.sdfVy.parse(rdv_l).after(this.sdfVy.parse(jour))){
            
               // this.l.setText("LIVRAISON : "+sdfT.format(this.rdv.getDate())+" "+this.h.getText());
               //  this.r.setText("RAMASSAGE : "+sdfT.format(this.rdv1.getDate())+" "+this.h1.getText());
                
                
                // query :
                
                  
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
      stmt  = conn.createStatement() ;
       
      
      //je crai ma requete
       
      
      
      String sql = null ;
      ResultSet rs = null ;
      
     
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0) ;
                           
                           DefaultTableModel dtm3 =(DefaultTableModel) jTable3.getModel() ;
                           dtm3.setRowCount(0) ;
                           
                           DefaultTableModel dtm4 =(DefaultTableModel) jTable4.getModel() ;
                           dtm4.setRowCount(0) ;
                           
                           
                           
       
       
         
         this.rdv_l = rdv_l ;
         this.rdv_r = rdv_r ;
         
         // debut :
         
                                       
       ArrayList<String> listM = new ArrayList<String>() ;
       ArrayList<Integer> listM_id = new ArrayList<Integer>() ;
       
       
       ArrayList<facture_test> listf_id = new ArrayList<facture_test>() ;
       ArrayList<facture_test> listf_id_f = new ArrayList<facture_test>() ;
       
       
       ArrayList<String> listF = new ArrayList<String>() ;
       
        ArrayList<Mat_list> listMat = new ArrayList<Mat_list>() ; 
        ArrayList<Mat_list> listMat_f = new ArrayList<Mat_list>() ;  
   
      
       sql = "SELECT * FROM materiel_l where etat = 'oui' group by id order by description asc" ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        listM.add(new String(rs.getString("description"))) ;
        listM_id.add(rs.getInt("id")) ;
        
         
     }
     
     
     
     Integer nb_l = 0 ;
     Integer nb_d = 0 ;
     Integer nb = 0 ;
     
     
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
    
           /*
      
       sql = "select facture_lc.id as id_fact, facture_lc.rdv_l as rdv_l, facture_lc.rdv_r as rdv_r , facture_lc.cb_f as code , facture_lc.etat as eta , detail_facture_lc.cb_f as dc , "
            +"detail_facture_lc.description as produit , sum(qte) as qte , id_m , materiel_l.id as ref ,"
            +"materiel_l.description as mat, materiel_l.dimension as dim , materiel_l.prix as prx , materiel_l.qte_m as qte_m , materiel_l.prx_c as prx_c , "
            +"materiel_l.nombre as nombre , materiel_l.code_img as img from "
            +"facture_lc , detail_facture_lc , materiel_l "
            +"where facture_lc.etat = 'NON' "
            +"and detail_facture_lc.cb_f = facture_lc.cb_f and materiel_l.id = detail_facture_lc.id_m group by ref order by produit asc" ;
       
                                              // stmt1 = facture_lc.rdv_r < '"+this.rdv_l+"' "
      
           */
      
       sql = "select id , rdv_l, rdv_r  from facture_lc where etat = 'NON' and etat_an = 'OUI'" ;
      
      
       rs = stmt.executeQuery(sql) ;
      
      
      while(rs.next()){
         
          int id = rs.getInt("id") ;
          String rdv_ll = sdf.format(rs.getTimestamp("rdv_l")) ;
          String rdv_rr = sdf.format(rs.getTimestamp("rdv_r")) ;
          
          facture_test ft = new facture_test(id, rdv_ll, rdv_rr) ;
         
         listf_id.add(ft) ;
        
        
        }
      
      
      for(int i = 0 ; i < listf_id.size() ; i++){
          
         
     if(sdf.parse(this.rdv_l).compareTo(sdf.parse(listf_id.get(i).getRdv_l())) * sdf.parse(listf_id.get(i).getRdv_l()).compareTo(sdf.parse(this.rdv_r)) >= 0){
       
        
         Integer id = listf_id.get(i).getId() ;
         String dl = listf_id.get(i).getRdv_l() ;
         String dr = listf_id.get(i).getRdv_r() ;
         
         facture_test ft = new facture_test(id, dl, dr) ;
         
         listf_id_f.add(ft) ;
        
         
    }else if(sdf.parse(this.rdv_l).compareTo(sdf.parse(listf_id.get(i).getRdv_r())) * sdf.parse(listf_id.get(i).getRdv_r()).compareTo(sdf.parse(this.rdv_r)) >= 0){
        
         
          Integer id = listf_id.get(i).getId() ;
          String dl = listf_id.get(i).getRdv_l() ;
          String dr = listf_id.get(i).getRdv_r() ;
         
         facture_test ft = new facture_test(id, dl, dr) ;
         
         listf_id_f.add(ft) ;
        
         
         
    }else if(sdf.parse(listf_id.get(i).getRdv_l()).before(sdf.parse(this.rdv_l)) && sdf.parse(listf_id.get(i).getRdv_r()).after(sdf.parse(this.rdv_r))){
        
          
           Integer id = listf_id.get(i).getId() ;
           String dl = listf_id.get(i).getRdv_l() ;
           String dr = listf_id.get(i).getRdv_r() ;
         
         facture_test ft = new facture_test(id, dl, dr) ;
         
         listf_id_f.add(ft) ;
         
   
     }else{
       
        
        
       }
         
         
          
      
      }
      
      ArrayList<Integer> listM_id_c = new ArrayList<Integer>() ;
      
      for(int i = 0 ; i < listf_id_f.size() ; i++){
          
          
           sql = "select facture_lc.id as id_fact, facture_lc.rdv_l as rdv_l, facture_lc.rdv_r as rdv_r , facture_lc.cb_f as code , facture_lc.etat as eta , detail_facture_lc.cb_f as dc , "
            +"detail_facture_lc.description as produit , qte as qte , id_m , materiel_l.id as ref ,"
            +"materiel_l.description as mat, materiel_l.dimension as dim , materiel_l.prix as prx , materiel_l.qte_m as qte_m , materiel_l.prx_c as prx_c , "
            +"materiel_l.nombre as nombre , materiel_l.code_img as img from "
            +"facture_lc , detail_facture_lc , materiel_l "
            +"where facture_lc.id = "+listf_id_f.get(i).getId()+" "
            +"and detail_facture_lc.cb_f = facture_lc.cb_f and materiel_l.id = detail_facture_lc.id_m " ;
           
           rs = stmt.executeQuery(sql) ;
           while(rs.next()){
               
               Mat_list ml = new Mat_list() ;
                        ml.setId(rs.getInt("ref"));
                        ml.setQte(rs.getInt("qte"));
                        
                  listM_id_c.add(rs.getInt("ref")) ;
                  listMat.add(ml) ;
                        
           }
          
          
      } 
      
      
     Random rx = new Random() ;
     Integer cb = rx.nextInt() ;
     if(cb < 0){
         cb = Math.abs(cb) ;
     }
     
     
      for(int i = 0 ; i < listMat.size() ; i++){
          
           stmt.executeUpdate("insert into mat_cumul(id_m, qte, cb) values("+listMat.get(i).getId()+" , "+listMat.get(i).getQte()+" , "
                   +cb+")") ;
          
           
          System.out.println("id = "+listMat.get(i).getId()+" qte = "+listMat.get(i).getQte());
          
         }
      
      
      sql = "select id_m as ref , sum(qte) as nb "
              + "from mat_cumul "
              + "where cb = "+cb+" group by ref" ;
      
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          
          Integer id = rs.getInt("ref") ;
          Integer qte = rs.getInt("nb") ;
          
          Mat_list ml = new Mat_list() ;
                   ml.setId(id);
                   ml.setQte(qte);
             
                  listMat_f.add(ml) ;
          
      }
      
      stmt.executeUpdate("delete from mat_cumul where cb = "+cb) ;
      
      
      for(int i = 0 ; i < listMat_f.size() ; i++){
          
 
          Integer dispo = 0 ;
          
                       
             sql = "select * from materiel_l where id = "+listMat_f.get(i).getId() ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                 
                 dispo = (rs.getInt("nombre") - listMat_f.get(i).getQte()) ;
                 
                  dtm.addRow(new Object[]{
            
        //  "ID", "DESCRIPTION", "DIMENSION", "PRIX", "QTE C", "PRIX C", "T.NOMBRE", "DISPONIBLE"
            
            rs.getInt("id") , rs.getString("description"), rs.getString("dimension"), rs.getInt("prix") , rs.getInt("qte_m") ,
            rs.getInt("prx_c") , rs.getInt("nombre") , dispo , rs.getString("code_img")
         
        }) ;
                 
             }
            
          
          
          
         }
      
      
    //  JOptionPane.showMessageDialog(null, "ok");
      
     
      /*
      
         // debut :
         
    listF.add(new String(rs.getString("produit"))) ;
         
         
         
   //      Integer nb_r = 0 ;
         
         
         
          
         
             if(rs.getTimestamp("rdv_l").equals(this.rdv_l) || rs.getTimestamp("rdv_l").equals(this.rdv_r)){
     
       
     
             }else if(rs.getTimestamp("rdv_r").equals(this.rdv_l) || rs.getTimestamp("rdv_r").equals(this.rdv_r)){
         
     
              }else 
         
     
         
         
   if(sdf.parse(this.rdv_l).compareTo(rs.getTimestamp("rdv_l")) * rs.getTimestamp("rdv_l").compareTo(sdf.parse(this.rdv_r)) >= 0){
       
       JOptionPane.showMessageDialog(null, "ID = "+rs.getLong("id_fact")+System.getProperty("line.separator")+" RDV L = "+sdf.format(rs.getTimestamp("rdv_l"))
               +System.getProperty("line.separator")+"RDV R = "+sdf.format(rs.getTimestamp("rdv_r")));
       
       
       
        nb_l = rs.getInt("qte") ;
         
         
         
         nb = rs.getInt("nombre") ;
         
         
         nb_d = (nb - nb_l) ;
         
         
         
    }else if(sdf.parse(this.rdv_l).compareTo(rs.getTimestamp("rdv_r")) * rs.getTimestamp("rdv_r").compareTo(sdf.parse(this.rdv_r)) >= 0){
        
        
          JOptionPane.showMessageDialog(null, "ID = "+rs.getLong("id_fact")+System.getProperty("line.separator")+" RDV L = "+sdf.format(rs.getTimestamp("rdv_l"))
               +System.getProperty("line.separator")+"RDV R = "+sdf.format(rs.getTimestamp("rdv_r")));
         
        
         nb_l = rs.getInt("qte") ;
         
         
         
         nb = rs.getInt("nombre") ;
         
         
         nb_d = (nb - nb_l) ;
        
         
    }else if(rs.getTimestamp("rdv_l").before(sdf.parse(this.rdv_l)) && rs.getTimestamp("rdv_r").after(sdf.parse(this.rdv_r))){
        
         JOptionPane.showMessageDialog(null, "ID = "+rs.getLong("id_fact")+System.getProperty("line.separator")+" RDV L = "+sdf.format(rs.getTimestamp("rdv_l"))
               +System.getProperty("line.separator")+"RDV R = "+sdf.format(rs.getTimestamp("rdv_r")));
        
         nb_l = rs.getInt("qte") ;
         
         
         
         nb = rs.getInt("nombre") ;
         
         
         nb_d = (nb - nb_l) ;
         
         
   
     }
         
         
       
        
   
         if(rs.getTimestamp("rdv_r").before(sdf.parse(this.rdv_l)) || sdf.parse(this.rdv_r).before(rs.getTimestamp("rdv_l"))){
             
             nb_r = rs.getInt("qte") ;
             
         }
         
      
         
        nb_d = (nb_d + nb_r) ;
         
         if(nb_d < 0){
             
             nb_d = 0 ;
             
         }
         
       
   
   
   
         dtm.addRow(new Object[]{
            
        //  "ID", "DESCRIPTION", "DIMENSION", "PRIX", "QTE C", "PRIX C", "T.NOMBRE", "DISPONIBLE"
            
            rs.getInt("ref") , rs.getString("mat"), rs.getString("dim"), rs.getInt("prx") , rs.getInt("qte_m") ,
            rs.getInt("prx_c") , rs.getInt("nombre") , nb_d , rs.getString("img")
         
        })  ;
            
         
         
         
         
        
         
         // fin :
        
       
      
      */
      
      
     
for(int i = 0 ; i < listM_id.size() ; i++){
         
    if(listM_id_c.contains(listM_id.get(i).intValue())){
             
    }else if(listM_id_c.contains(listM_id.get(i).intValue()) == false){
             
             sql = "select * from materiel_l where id = "+listM_id.get(i).intValue()+" group by id" ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                 
                  dtm.addRow(new Object[]{
            
        //  "ID", "DESCRIPTION", "DIMENSION", "PRIX", "QTE C", "PRIX C", "T.NOMBRE", "DISPONIBLE"
            
            rs.getInt("id") , rs.getString("description"), rs.getString("dimension"), rs.getInt("prix") , rs.getInt("qte_m") ,
            rs.getInt("prx_c") , rs.getInt("nombre") , rs.getInt("nombre") , rs.getString("code_img")
         
        }) ;
                 
             }
             
             
         }
    
    
         
         /*
         
         if(listF.contains(new String(listM.get(i).toString()))){
             
         }else if(listF.contains(new String(listM.get(i).toString())) == false){
             
             sql = "select * from materiel_l where id = "+listM_id.get(i).intValue()+" group by id" ;
             rs = stmt.executeQuery(sql) ;
             while(rs.next()){
                 
                  dtm.addRow(new Object[]{
            
        //  "ID", "DESCRIPTION", "DIMENSION", "PRIX", "QTE C", "PRIX C", "T.NOMBRE", "DISPONIBLE"
            
            rs.getInt("id") , rs.getString("description"), rs.getString("dimension"), rs.getInt("prix") , rs.getInt("qte_m") ,
            rs.getInt("prx_c") , rs.getInt("nombre") , rs.getInt("nombre") , rs.getString("code_img")
         
        }) ;
                 
             }
             
             
         }
         
         */
         
     }
      
      
     
      
         
         // end :
         
  for(int i = 0 ; i < listf_id_f.size() ; i++){
     
      sql = "select id,client,rdv_l,rdv_r,datej,cb_f,devis,login  from "
            +"facture_lc "
            +"where facture_lc.id = "+listf_id_f.get(i).getId() ;
     
     
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          
         dtm3.addRow(new Object[]{
         // "DATE", "ID", "CLIENT", "RDV L", "RDV R", "MTT", "LOGIN", "CODE BARRE"
             
       sdfT_.format(rs.getTimestamp("datej")) , rs.getString("id") , rs.getString("client") , sdfT_.format(rs.getTimestamp("rdv_l")) ,
       sdfT_.format(rs.getTimestamp("rdv_r")) , nf3.format(rs.getInt("devis")) , rs.getString("login") , rs.getInt("cb_f")
         
         }) ;
          
      }
      
     
       }
    
            
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
        
                
                
                // end query :
               
             
                      
               }else{
                   
                   JOptionPane.showMessageDialog(null, "CHOISIR UN RDV DE LIVRAISON ET RAMASSAGE CORRECT SVP") ;
                   
               }
               
       
               }
            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage()) ;
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseReleased
        // TODO add your handling code here:
        
        this.jTable1.getSelectionModel().clearSelection();
        this.jTable4.getSelectionModel().clearSelection();
        
        
        Integer cb ;
                cb = Integer.parseInt(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 7).toString()) ;
                
                
                DefaultTableModel dtm = (DefaultTableModel) this.jTable4.getModel() ;
                                  dtm.setRowCount(0);
                                  
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
      stmt  = conn.createStatement() ;
       
      
      //je crai ma requete
       
      
      
      String sql = null ;
      ResultSet rs = null ;
      
     
sql = "select id_m,description,dimension,prix,qte,jour,mtt from detail_facture_lc where cb_f = "+cb ;
rs = stmt.executeQuery(sql) ;
while(rs.next()){
    
    dtm.addRow(new Object[]{
        
    //  "ID", "DESCRIPTION", "DIMENSION", "PRIX", "QTE", "JOUR", "MTT"
        
        rs.getString("id_m") , rs.getString("description") , rs.getString("dimension") , nf3.format(rs.getInt("prix"))
        , nf3.format(rs.getInt("qte")) , nf3.format(rs.getInt("jour")) , nf3.format(rs.getInt("mtt"))
            
     }) ;
    
      }
     
      
    
            
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
                 
                                  
        
        
    }//GEN-LAST:event_jTable3MouseReleased

    private void jTable4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseReleased
        // TODO add your handling code here:
        
        this.jTable1.getSelectionModel().clearSelection();
        this.jTable3.getSelectionModel().clearSelection();
        
    }//GEN-LAST:event_jTable4MouseReleased

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
            java.util.logging.Logger.getLogger(Model_gateau_lc_cst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Model_gateau_lc_cst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Model_gateau_lc_cst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Model_gateau_lc_cst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Model_gateau_lc_cst().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField desc;
    private javax.swing.JTextField dim;
    private javax.swing.JFormattedTextField h;
    private javax.swing.JFormattedTextField h1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField prx;
    private com.toedter.calendar.JDateChooser rdv;
    private com.toedter.calendar.JDateChooser rdv1;
    // End of variables declaration//GEN-END:variables
}
