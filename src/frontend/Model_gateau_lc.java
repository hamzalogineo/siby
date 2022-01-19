/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import allCollection.ListCommande;
import collection.materiel.List_com;
import static frontend.Genre_gateau.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HAMZA
 */
public class Model_gateau_lc extends javax.swing.JFrame {

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
      
    public Model_gateau_lc() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("MODEL GATEAU");
        
    }

    
    public Model_gateau_lc(String login , String rdv_l, String rdv_r ) {
        
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
     // tableau 2
        
        
        
        this.jTable2.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable2.getTableHeader().setOpaque(false); 
            this.jTable2.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable2.getTableHeader().setForeground(Color.white) ;
        
            this.jTable2.setRowHeight(25) ;
              
        
            // DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
             
                  headerRenderer.setBackground(Color.green) ;
                  headerRenderer.setForeground(Color.BLACK) ;
                  headerRenderer.setFont(new Font("Segoe UI" , Font.BOLD , 16)) ;

                  for (int i = 0; i < this.jTable2.getModel().getColumnCount(); i++) {
                    this.jTable2.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
   
     
        
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        
        
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm2.setRowCount(0) ;
        
       
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
        
          
        // BY SOFT-TECH : CEO DIAKITE
        
        
        
        
    }
    
    
    
    
    

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
        this.l.setText(l) ;
    }
    
    public void setR(String r){
        this.r.setText(r) ;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        desc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        dim = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        prx = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        l = new javax.swing.JLabel();
        r = new javax.swing.JLabel();
        img = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHOISIR MATERIEL POUR LE PANIER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DESCRIPTION", "DIMENSION", "PRIX", "QTE C", "PRIX C", "T.NOMBRE", "DISPONIBLE", "IMAGE"
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

        jButton1.setBackground(new java.awt.Color(51, 0, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AJOUTER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 0, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("VALIDER");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                false, false, false, false, false, true, false
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
            jTable2.getColumnModel().getColumn(0).setMinWidth(50);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable2.getColumnModel().getColumn(1).setMinWidth(250);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(250);
            jTable2.getColumnModel().getColumn(2).setMinWidth(80);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(80);
            jTable2.getColumnModel().getColumn(3).setMinWidth(90);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        jButton3.setBackground(new java.awt.Color(51, 0, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("RETIRER");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("DESCRIPTION");

        dim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dimKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("        ID");

        prx.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prxKeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("          PRIX");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("QTE");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("     JOUR");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 204, 102));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("MTT");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        l.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        l.setText("jLabel4");

        r.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        r.setText("jLabel5");

        img.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(160, 160, 160))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(l, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dim, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prx, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l)
                    .addComponent(r))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        
        this.jTextField1.setText("") ;
        this.jComboBox1.setSelectedItem(new String("CHOISIR")) ; this.jLabel3.setText("MTT") ;
        this.jTable2.getSelectionModel().clearSelection() ;
        
        
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
        
        
       String image = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 8).toString() ;
        
        ImageIcon icon = new ImageIcon("\\\\192.168.1.117\\TEST_IMG_LOCATION\\"+image) ;
        
        this.img.setIcon(icon) ;
      
        
        
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTextField1.getText().trim().isEmpty() || this.jTable1.getSelectedRow() == -1 || this.jComboBox1.getSelectedItem().toString().equalsIgnoreCase("CHOISIR")){
            
            this.jTextField1.setText("") ;
        this.jComboBox1.setSelectedItem(new String("CHOISIR")) ; this.jLabel3.setText("MTT") ;
        this.jTable1.getSelectionModel().clearSelection() ;
        
         JOptionPane.showMessageDialog(null, "SELECTIONNER UN MATERIEL DABORD !") ;
         
        }else{
            
        DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
        
        List_com lc = new List_com() ;
        
        
                      lc.setRef(ref);
                      lc.setMateriel(materiel);
                      lc.setDimension(dimension);
                      lc.setPrix(this.prix_);
                      lc.setQte(qte);
                      lc.setJour(this.jour);
                      lc.setMtt(mtt);
                      
                     
                        if(Nouvelle_cl1.getList_vy().contains(new String(this.materiel))  || this.list_vy.contains(new String(this.materiel))){
                            
                            this.jTextField1.setText("") ;
                            this.jComboBox1.setSelectedItem(new String("CHOISIR")) ; this.jLabel3.setText("MTT") ;
                            this.jTable1.getSelectionModel().clearSelection() ;
        
                             JOptionPane.showMessageDialog(null, "MATERIEL EXISTE DEJA !") ;
                             
                        }else{
                            
                      this.list_vy.add(new String(this.materiel)) ;
                      this.list.add(lc) ;
                      
                        // "ID", "DESCRIPTION", "DIMENSION", "PRIX", "QTE", "JOUR", "MTT"
                      
           Object[] i = new Object[]{lc.getRef(),lc.getMateriel(),lc.getDimension(),lc.getPrix(),lc.getQte(),lc.getJour(),lc.getMtt()} ;
      
           dtm2.addRow(i) ;
           
           
           this.jTextField1.setText("") ;
        this.jComboBox1.setSelectedItem(new String("CHOISIR")) ; this.jLabel3.setText("MTT") ;
        this.jTable1.getSelectionModel().clearSelection() ;
                     
           
                        }
                        
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable2.getSelectedRow() == -1){
           JOptionPane.showMessageDialog(null, "SELECTIONNER DANS LA LISTE A VALIDER") ;
        }else{
            DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                         
                              this.list_vy.remove(this.jTable2.getSelectedRow()) ;
                              this.list.remove(this.jTable2.getSelectedRow()) ;
                              dtm2.removeRow(this.jTable2.getSelectedRow());
                              
                              
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        
        this.jTable1.getSelectionModel().clearSelection() ;
        
    }//GEN-LAST:event_jTable2MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(list.size() > 0){
            
            String m1 = Nouvelle_cl1.getDevis() ;
            Integer mtt1 = Integer.parseInt(m1) ;
            Integer mtt2 = 0 ;
            
            for(int i = 0 ; i < this.list.size() ; i++){
                 mtt2 += this.list.get(i).getMtt() ;
            }
            
            String rm = Nouvelle_cl1.getRemise() ;
            Integer rm1 = Integer.parseInt(rm) ;
            
            Integer total = (mtt1 + mtt2 + rm1) ;
            
            Nouvelle_cl1.setMtt(total);
            
            Nouvelle_cl1.laodTable1(list) ;
            Nouvelle_cl1.setRemise() ;
            
            
            
            this.list.removeAll(list) ;
            DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
                              dtm2.setRowCount(0) ;
                              this.setVisible(false) ;
                              
            
            
        }else{
            
            JOptionPane.showMessageDialog(null, "PAS DE COMMANDE A VALIDER !") ;
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:

        String qte = "" ;
               qte = this.jTextField1.getText().trim() ;
               this.prix_ = 0 ;
        
        if(this.jTable1.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "CHOISIR UN MATERIEL SVP") ;
            
            
        }else{
            
            try{
                
                if(qte.isEmpty()){
                    JOptionPane.showMessageDialog(null, "QTE NE PEUT PAS ETRE VIDE") ;
                }else{
                    Integer qte1 = 0 ;
                            qte1 = Integer.parseInt(qte) ;
                            this.qte = qte1 ;
                            
                            
                            if(this.qte <= this.dispo){
                            
                            if(qte1 >= this.qte_c){
                                
                                this.prix_ = this.prix_c ;
                                
                            }else{
                                this.prix_ = this.prix ;
                            }
                            
                            
                           
                            
                            
                            }else{
                                
                                
                                
                                JOptionPane.showMessageDialog(null, "QTE INDISPONIBLE POUR : "+this.qte+" DISPONIBLE : "+this.dispo) ;
                                
                                this.jTextField1.setText("") ; this.jComboBox1.setSelectedItem(new String("CHOISIR")) ; this.jLabel3.setText("");
                                
                            }
                            
                }
                
            }catch(Exception e){
                 JOptionPane.showMessageDialog(null, e.getMessage()) ;
            }
            
            
        }
        
        
        
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
        
          String qte = "" ;
               qte = this.jTextField1.getText().trim() ;
               this.prix_ = 0 ;
        
        if(this.jTable1.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "CHOISIR UN MATERIEL SVP") ;
            
            
        }else{
            
            try{
                
                if(qte.isEmpty()){
                   // JOptionPane.showMessageDialog(null, "QTE NE PEUT PAS ETRE VIDE") ;
                }else{
                    Integer qte1 = 0 ;
                            qte1 = Integer.parseInt(qte) ;
                            this.qte = qte1 ;
                            
                            
                            if(this.qte <= this.dispo){
                            
                            if(qte1 >= this.qte_c){
                                
                                this.prix_ = this.prix_c ;
                                
                            }else{
                                this.prix_ = this.prix ;
                            }
                            
                            
                           
                             String jour = this.jComboBox1.getSelectedItem().toString().trim() ;
        
        if(jour.equalsIgnoreCase("CHOISIR") || this.jTextField1.getText().trim().isEmpty()){
         //    JOptionPane.showMessageDialog(null, "CHOISIR LE NOMBRE DE JOUR ET LA QTE SVP") ;
        }else{
            try{
                
                 this.mtt = (this.prix_ * this.qte) ;
                 
                Integer j = Integer.parseInt(jour) ;
                
                  this.jour = j ;                

                this.mtt = (mtt * j) ;
                this.jLabel3.setText(String.valueOf(this.mtt)) ;
                
                
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage()) ;
            }
        }
                            
                            }else{
                                
                                
                                
                                JOptionPane.showMessageDialog(null, "QTE INDISPONIBLE POUR : "+this.qte+" DISPONIBLE : "+this.dispo) ;
                                
                                this.jTextField1.setText("") ; this.jComboBox1.setSelectedItem(new String("CHOISIR")) ; this.jLabel3.setText("");
                                
                            }
                            
                }
                
            }catch(Exception e){
                 JOptionPane.showMessageDialog(null, e.getMessage()) ;
            }
            
            
        }
        
        
        
        
       
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Model_gateau_lc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Model_gateau_lc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Model_gateau_lc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Model_gateau_lc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Model_gateau_lc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField desc;
    private javax.swing.JTextField dim;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel l;
    private javax.swing.JTextField prx;
    private javax.swing.JLabel r;
    // End of variables declaration//GEN-END:variables
}
