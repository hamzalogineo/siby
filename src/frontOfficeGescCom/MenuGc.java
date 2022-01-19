/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontOfficeGescCom;


import allCollection.Stock_gc;
import collection.P_stock;
import collection.Pannier_gc;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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

/**
 *
 * @author hp
 */
public class MenuGc extends javax.swing.JFrame {

      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
       private String role ;
       private String login ;
       double to = 0 ;
       
         private long id_ss = 0 ;
         private double balance = 0.0 ;
       
       private String pos ;
      
      ArrayList<Stock_gc> list_produit = new ArrayList<Stock_gc>() ;
      ArrayList<P_stock> list_ps = new ArrayList<P_stock>() ;
      ArrayList<String> list_vy = new ArrayList<String>() ;
      
      ArrayList<Pannier_gc> list_pn_v = new ArrayList<Pannier_gc>() ;
      ArrayList<String> list_pn_v_vy = new ArrayList<String>() ;
      
      List bonList = new ArrayList() ;
      
        private NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
        double total_p_v = 0.0 ;

    
    public MenuGc() {
        
        initComponents() ;
        
        this.setLocationRelativeTo(null) ;
        
    
             }
    
    
     public MenuGc(String role , String login , String pos) {
        
        initComponents() ;
        
        this.setLocationRelativeTo(null) ;
        
        this.role = role ;
        this.login = login ;
        this.pos = pos ;
        
        this.poste.setText("POS : "+this.pos) ;
        
        this.list_produit.removeAll(this.list_produit) ;
        
               
            this.jTable8.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable8.getTableHeader().setOpaque(false); 
            this.jTable8.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable8.getTableHeader().setForeground(Color.white) ;
        
            this.jTable8.setRowHeight(20) ;
              
        
             DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
             
                  headerRenderer.setBackground(Color.green) ;
                  headerRenderer.setForeground(Color.BLACK) ;
                  headerRenderer.setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;

                  for (int i = 0; i < this.jTable8.getModel().getColumnCount(); i++) {
                    
                       this.jTable8.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
      //   -------------------------------------------------------------------              
        
            this.t_produit_v.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.t_produit_v.getTableHeader().setOpaque(false) ; 
            this.t_produit_v.getTableHeader().setBackground(Color.black) ; 
          
 //     this.jTable1.setBackground(Color.white);
        
       
            this.t_produit_v.getTableHeader().setForeground(Color.white) ;
        
            this.t_produit_v.setRowHeight(20) ;
              
                  for (int i = 0; i < this.t_produit_v.getModel().getColumnCount(); i++) {
                    
                       this.t_produit_v.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
                  
  DefaultTableModel dtm_p_v = (DefaultTableModel) this.t_produit_v.getModel() ;
        
                    dtm_p_v.setRowCount(0) ;       
        
     //   -------------------------------------------------------------------
                    
//   -------------------------------------------------------------------              
        
            this.t_panier_v.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.t_panier_v.getTableHeader().setOpaque(false) ; 
            this.t_panier_v.getTableHeader().setBackground(Color.black) ; 
          
 //     this.jTable1.setBackground(Color.white);
        
       
            this.t_panier_v.getTableHeader().setForeground(Color.white) ;
        
            this.t_panier_v.setRowHeight(20) ;
              
                  for (int i = 0; i < this.t_panier_v.getModel().getColumnCount(); i++) {
                    
                       this.t_panier_v.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
                  
  DefaultTableModel dtm_pn_v = (DefaultTableModel) this.t_panier_v.getModel() ;
        
                    dtm_pn_v.setRowCount(0) ;       
        
     //   -------------------------------------------------------------------
        
        //   -------------------------------------------------------------------              
        
            this.t_client_v.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.t_client_v.getTableHeader().setOpaque(false) ; 
            this.t_client_v.getTableHeader().setBackground(Color.black) ; 
       
            this.t_client_v.getTableHeader().setForeground(Color.white) ;
        
            this.t_client_v.setRowHeight(20) ;
              
                  for (int i = 0; i < this.t_client_v.getModel().getColumnCount(); i++) {
                    
                       this.t_client_v.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
                      }
                  
                  
  DefaultTableModel dtm_cl_v = (DefaultTableModel) this.t_client_v.getModel() ;
        
                    dtm_cl_v.setRowCount(0) ;       
        
     //   -------------------------------------------------------------------
        
       
        
     
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable8.getModel() ;
        
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm.setRowCount(0) ;
        
      /*  
       
      */
        
        
        
            this.jTable9.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable9.getTableHeader().setOpaque(false); 
            this.jTable9.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable9.getTableHeader().setForeground(Color.white) ;
        
              this.jTable9.setRowHeight(20) ;
              
         
                  for (int i = 0; i < this.jTable9.getModel().getColumnCount(); i++) {
                      
                    this.jTable9.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
                    }
                  
                  
            this.jTable10.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable10.getTableHeader().setOpaque(false); 
            this.jTable10.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable10.getTableHeader().setForeground(Color.white) ;
        
            this.jTable10.setRowHeight(20) ;
             
                  headerRenderer.setBackground(Color.green) ;
                  headerRenderer.setForeground(Color.BLACK) ;
                  headerRenderer.setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;

                  for (int i = 0; i < this.jTable10.getModel().getColumnCount(); i++) {
                    
                       this.jTable10.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------------------------------------------------------
                  
                  
            this.jTable11.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable11.getTableHeader().setOpaque(false); 
            this.jTable11.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable11.getTableHeader().setForeground(Color.white) ;
        
            this.jTable11.setRowHeight(20) ;
             
                  headerRenderer.setBackground(Color.green) ;
                  headerRenderer.setForeground(Color.BLACK) ;
                  headerRenderer.setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;

                  for (int i = 0; i < this.jTable11.getModel().getColumnCount(); i++) {
                    
                       this.jTable11.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
                  }
        
     //   -------------------------------------------------------------------
        
        
        
      
 this.jTable10.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 5) ;
        
         
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        if("oui".equalsIgnoreCase(status)) {
            
            setBackground(Color.WHITE) ;
            setForeground(Color.MAGENTA) ;
            
        }else if("non".equalsIgnoreCase(status)){
            
            
            setBackground(Color.WHITE) ;
            setForeground(Color.BLACK) ;

            
        } 
        
       
        
        
        if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
            
          
        return this;
        
    }   
});

        
        //   -------------------------------------------------------------------
                  
                  
            this.t_op_s.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.t_op_s.getTableHeader().setOpaque(false); 
            this.t_op_s.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.t_op_s.getTableHeader().setForeground(Color.white) ;
        
            this.t_op_s.setRowHeight(20) ;
             
                  headerRenderer.setBackground(Color.green) ;
                  headerRenderer.setForeground(Color.BLACK) ;
                  headerRenderer.setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;

                  for (int i = 0; i < this.t_op_s.getModel().getColumnCount(); i++) {
                    
                       this.t_op_s.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
                  }
        
     //   -------------------------------------------------------------------
        // t_op_s1
                  
            this.t_op_s1.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.t_op_s1.getTableHeader().setOpaque(false); 
            this.t_op_s1.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.t_op_s1.getTableHeader().setForeground(Color.white) ;
        
            this.t_op_s1.setRowHeight(20) ;
             
                  headerRenderer.setBackground(Color.green) ;
                  headerRenderer.setForeground(Color.BLACK) ;
                  headerRenderer.setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;

                  for (int i = 0; i < this.t_op_s1.getModel().getColumnCount(); i++) {
                    
                       this.t_op_s1.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
                  }
                  
                  DefaultTableModel dtm12 = (DefaultTableModel) this.t_op_s1.getModel() ;
                                    dtm12.setRowCount(0) ;
        
    
      //   -------------------------------------------------------------------              
        
            this.t_rg_cl.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.t_rg_cl.getTableHeader().setOpaque(false) ; 
            this.t_rg_cl.getTableHeader().setBackground(Color.black) ; 
          
 //     this.jTable1.setBackground(Color.white);
        
       
            this.t_rg_cl.getTableHeader().setForeground(Color.white) ;
        
            this.t_rg_cl.setRowHeight(20) ;
              
                  for (int i = 0; i < this.t_rg_cl.getModel().getColumnCount(); i++) {
                    
                       this.t_rg_cl.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
                  
                  
 this.t_rg_cl.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 7) ;
        
         
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        if("OUI".equalsIgnoreCase(status)) {
            
            setBackground(Color.WHITE) ;
            setForeground(Color.BLACK) ;
           
            
        }else if("NON".equalsIgnoreCase(status)){
            
            
            setBackground(Color.WHITE) ;
            setForeground(Color.MAGENTA) ;  

            
        } 
        
       
        
        
        if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
            
          
        return this;
        
    }   
});
 
 
 
 //   -------------------------------------------------------------------              
        
            this.t_rg_pn.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.t_rg_pn.getTableHeader().setOpaque(false) ; 
            this.t_rg_pn.getTableHeader().setBackground(Color.black) ; 
          
 //     this.jTable1.setBackground(Color.white);
        
       
            this.t_rg_pn.getTableHeader().setForeground(Color.white) ;
        
            this.t_rg_pn.setRowHeight(20) ;
              
                  for (int i = 0; i < this.t_rg_pn.getModel().getColumnCount(); i++) {
                    
                       this.t_rg_pn.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
                  

   DefaultTableModel dtm_rg_pn = (DefaultTableModel) this.t_rg_pn.getModel() ;
        
                     dtm_rg_pn.setRowCount(0) ;                 
                  
  DefaultTableModel dtm_rg_cl = (DefaultTableModel) this.t_rg_cl.getModel() ;
        
                    dtm_rg_cl.setRowCount(0) ;       
        
              
//   -------------------------------------------------------------------              
        
            this.t_rg_py.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.t_rg_py.getTableHeader().setOpaque(false) ; 
            this.t_rg_py.getTableHeader().setBackground(Color.black) ; 
          
 //     this.jTable1.setBackground(Color.white);
        
       
            this.t_rg_py.getTableHeader().setForeground(Color.white) ;
        
            this.t_rg_py.setRowHeight(20) ;
              
                  for (int i = 0; i < this.t_rg_py.getModel().getColumnCount(); i++) {
                    
                       this.t_rg_py.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                 
            this.t_etat_ss.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.t_etat_ss.getTableHeader().setOpaque(false) ; 
            this.t_etat_ss.getTableHeader().setBackground(Color.black) ; 
          
 //     this.jTable1.setBackground(Color.white);
        
       
            this.t_etat_ss.getTableHeader().setForeground(Color.white) ;
        
            this.t_etat_ss.setRowHeight(20) ;
              
                  for (int i = 0; i < this.t_etat_ss.getModel().getColumnCount(); i++) {
                    
                       this.t_etat_ss.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
                  
        DefaultTableModel dtm_etat_ss = (DefaultTableModel) this.t_etat_ss.getModel() ;
        
                          dtm_etat_ss.setRowCount(0) ;       
        
     //   -------------------------------------------------------------------
     
            this.t_etat_op.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.t_etat_op.getTableHeader().setOpaque(false) ; 
            this.t_etat_op.getTableHeader().setBackground(Color.black) ; 
          
 //     this.jTable1.setBackground(Color.white);
        
       
            this.t_etat_op.getTableHeader().setForeground(Color.white) ;
        
            this.t_etat_op.setRowHeight(20) ;
              
                  for (int i = 0; i < this.t_etat_op.getModel().getColumnCount(); i++) {
                    
                       this.t_etat_op.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
                  
                  
        DefaultTableModel dtm_etat_op = (DefaultTableModel) this.t_etat_op.getModel() ;
        
                          dtm_etat_op.setRowCount(0) ;       
        
     //   -------------------------------------------------------------------
                  
                  
                  
                  
                  

   DefaultTableModel dtm_rg_py = (DefaultTableModel) this.t_rg_py.getModel() ;
        
                     dtm_rg_py.setRowCount(0) ;                                        
    
     
        
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable9.getModel() ;
                          dtm1.setRowCount(0) ;
                          
         DefaultTableModel dtm_s = (DefaultTableModel) this.jTable10.getModel() ;
                           dtm_s.setRowCount(0) ;
                           
        DefaultTableModel dtm_st = (DefaultTableModel) this.jTable11.getModel() ;
                          dtm_st.setRowCount(0) ;
                          
       DefaultTableModel dtm_op_s = (DefaultTableModel) this.t_op_s.getModel() ;
                         dtm_op_s.setRowCount(0) ;
        
        
        
         Connection conn = null ;
         Statement stmt = null  ; 
       
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
      
       sql= "SELECT * FROM matieres_p ORDER BY description ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
         
       
         

        if(rs.getString("unite_mesure").equalsIgnoreCase("OUI")){
            
              P_stock ps = new P_stock() ;
         
                 ps.setId(rs.getInt("id")) ;
                 ps.setDescription("KG "+rs.getString("description")) ;
                 ps.setPv(rs.getInt("prx_v_unite"));
                 ps.setSeuil(rs.getInt("stockMini"));
                 
                 this.list_ps.add(ps) ;
        
        dtm.addRow(new Object[]{
            
    // "ID", "CODE BARRE", "DESCRIPTION", "P.A", "P.V"
            
       rs.getLong("id") ,  rs.getString("code_barre") , "KG "+rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") , rs.getString("unite_mesure")
        
        }) ;
        
        
        
         dtm_p_v.addRow(new Object[]{
            
    // "ID", "CODE BARRE", "DESCRIPTION", "P.U", "CL"
            
       rs.getLong("id") ,  rs.getString("code_barre") , "KG "+rs.getString("description")  ,
       rs.getLong("prx_v_unite") , rs.getString("unite_mesure")
        
        }) ;
         
         
        
        }else if(rs.getString("unite_mesure").equalsIgnoreCase("vide")){
            
              P_stock ps = new P_stock() ;
         
                 ps.setId(rs.getInt("id")) ;
                 ps.setDescription(rs.getString("description")) ;
                 ps.setPv(rs.getInt("prx_v_unite")) ;
                 ps.setSeuil(rs.getInt("stockMini")) ;
                 
                 this.list_ps.add(ps) ;
        
    dtm.addRow(new Object[]{
            
    // "ID", "CODE BARRE", "DESCRIPTION", "P.A", "P.V"
            
       rs.getLong("id") ,  rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") , rs.getString("unite_mesure")
        
        }) ;
    
    dtm_p_v.addRow(new Object[]{
            
    // "ID", "CODE BARRE", "DESCRIPTION", "P.U", "CL"
            
       rs.getLong("id") ,  rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_v_unite") , rs.getString("unite_mesure")
        
        }) ;
       
        
        
        
        }
  
       
     }
     
     
       String sql2 ;
      
       sql2 = "SELECT * FROM produits_f ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
          if(rs2.getString("unite_m").equalsIgnoreCase("OUI")){
              
                P_stock ps = new P_stock() ;
         
                 ps.setId(rs2.getInt("id")) ;
                 ps.setDescription("KG "+rs2.getString("description")) ;
                 ps.setPv(rs2.getInt("pu"));
                 ps.setSeuil(rs2.getInt("stockMini"));
                 
                 this.list_ps.add(ps) ;
        
        dtm.addRow(new Object[]{
            
       //  "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getInt("id") , rs2.getString("code_barre") , "KG "+rs2.getString("description") , rs2.getLong("libelle") 
         ,  rs2.getLong("pu") , rs2.getString("unite_m")
         
        }) ;
        
        
        dtm_p_v.addRow(new Object[]{
            
       //  "ID", "CODE BARRE", "DESCRIPTION", "P.U", "CL"
            
            rs2.getInt("id") , rs2.getString("code_barre") , "KG "+rs2.getString("description") 
         ,  rs2.getLong("pu") , rs2.getString("unite_m")
         
        }) ;
        
        
              
          }else if(rs2.getString("unite_m").equalsIgnoreCase("vide")){
              
               P_stock ps = new P_stock() ;
         
                 ps.setId(rs2.getInt("id")) ;
                 ps.setDescription(rs2.getString("description")) ;
                 ps.setPv(rs2.getInt("pu"));
                 ps.setSeuil(rs2.getInt("stockMini"));
                 
                 this.list_ps.add(ps) ;
              
               dtm.addRow(new Object[]{
            
       //  "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getInt("id") , rs2.getString("code_barre") , rs2.getString("description") , rs2.getLong("libelle") 
         ,  rs2.getLong("pu") , rs2.getString("unite_m")
         
        }) ;
               
         dtm_p_v.addRow(new Object[]{
            
       //  "ID", "CODE BARRE", "DESCRIPTION", "P.U", "CL"
            
            rs2.getInt("id") , rs2.getString("code_barre") , rs2.getString("description")
         ,  rs2.getLong("pu") , rs2.getString("unite_m")
         
        }) ;
         
         
               
              
          }
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()); 
     }
      
      
    
       String sql3 ;
      
       sql3 = "SELECT * FROM fournisseurs ORDER BY entreprise" ;
      
       ResultSet rs3 = stmt.executeQuery(sql3) ;
      
      
     while(rs3.next()){
        
      
        
    this.fr.addItem(rs3.getString("entreprise")) ; 
         
       
     }
     
     
    sql= "SELECT * FROM clients ORDER BY entreprise asc" ;
      
    rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
   
        dtm_cl_v.addRow(new Object[]{
            
        //  "REF", "PRENOM & NOM", "TEL", "PLAFOND"
            
          rs.getInt("id") ,  rs.getString("entreprise") ,  rs.getString("tel1") ,
          rs.getLong("plafon_credit") 
       
        }) ;
               
       }
      
    
     // dtm_op_s
     
     sql = "select login, status from comptes_u order by login asc" ;
     rs = stmt.executeQuery(sql) ;
     while(rs.next()){
        String user = new String(rs.getString("login")) ;
         this.user_etat.addItem(user) ;
        
        }
     
     
 
            // end :      
      
    
       if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR")){
                      
                      
                      
      }else if(this.role.equalsIgnoreCase("ADMINII")){
             
                      
                  Calendar cal = Calendar.getInstance();
                  Calendar xdate = (Calendar)cal.clone();
                           xdate.set(Calendar.DAY_OF_YEAR,cal.getTime().getDate() - 6 );

                 System.out.println(" Current Time "+ cal.getTime().toString());
                 System.out.println(" X Time "+ xdate.getTime().toString());
            
            this.dte1.setSelectedDate(xdate) ;
            
            
                    this.dte1.setEnabled(false) ; 
                    this.dte2.setEnabled(false) ;
           
          
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
       
       
       
       
        String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
        String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
        String USER = "root" ;
        String PASS = "interco" ;
         
 
       
       try{
      // STEP 2: Register JDBC driver
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
      
       
            // end :  
      
      
      for(int i = 0 ; i < this.list_ps.size() ; i++){
          
      int seuil = 0 ;
      
      int stock = 0 ;
      String vu = "NON" ;
      
      seuil = this.list_ps.get(i).getSeuil() ;
      
      int vy = 0 ;
      // "ID", "DESCRIPTION", "P.V", "STOCK", "SEUIL", "ETAT"
      sql = "select stock , vu from stock_gc where description = '"+this.list_ps.get(i).getDescription().replaceAll("'", "''")+"'" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          stock = rs.getInt("stock") ;
          vu = rs.getString("vu") ;
          vy = 1 ;
          
         }
      
      if(vy == 1){
          
    if(seuil > stock){
        dtm_s.addRow(new Object[]{
        this.list_ps.get(i).getId(), this.list_ps.get(i).getDescription() , this.list_ps.get(i).getPv() , stock , seuil , vu
        }) ;
        
    }
            
           }
      
      
           }
      
      
      sql = "select * from stock_gc order by description asc" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          
          dtm_st.addRow(new Object[]{
          //  "REF", "ID", "CODE B", "DESCRIPTION", "P.A", "STOCK"
rs.getInt("id") , rs.getInt("id_p") , rs.getString("cb_p") , rs.getString("description") , rs.getDouble("pa") , rs.getInt("stock")
              
          }) ;
          
         }
      
      String id = "";
      String user = "" ; String date_s = "" ; String fc1 = "" ; String etat = "" ;
      int a = 0 ;
      
      
      String datej = null ;
      
      SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd") ;
      
      datej = sdf_.format(new Date()) ;
      
      Date date_jour = null ;
      
           date_jour = sdf_.parse(datej) ;
      String user_ = "" ;
      
      Date date_session = sdf_.parse(datej) ;
      
      SimpleDateFormat sdf_java_ = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      
     sql = "select * from session where pos = '"+this.pos+"' and etat = 'OUI'" ;
     rs = stmt.executeQuery(sql) ;
     while(rs.next()){

          date_session = rs.getDate("date_open") ;
          user_ = rs.getString("login") ;
          
          id = rs.getString("id") ;
          user = rs.getString("login") ;
          date_s = sdf_java_.format(rs.getTimestamp("date_open")) ;
          fc1 = rs.getString("fc") ;
          etat = "OUVERT" ;
          pos = rs.getString("pos") ;
          
          
          this.id_ss = rs.getLong("id") ;
          this.balance = rs.getDouble("balance") ;
    
          
         }
     
    
      
      
      
      
     sql = "select * from session where login = '"+this.login+"' and etat = 'OUI'" ;
     rs = stmt.executeQuery(sql) ;
     while(rs.next()){
         
          id = rs.getString("id") ;
          user = rs.getString("login") ;
          date_s = sdf_java_.format(rs.getTimestamp("date_open")) ;
          fc1 = rs.getString("fc") ;
          etat = "OUVERT" ;
          pos = rs.getString("pos") ;
          
          
          this.id_ss = rs.getLong("id") ;
          this.balance = rs.getDouble("balance") ;
          
          
          
     }
         

          
          this.jLabel2.setText("ID : "+id);
          this.jLabel3.setText("USER : "+user);
          this.jLabel4.setText("OUVERTE LE : "+date_s);
          this.jLabel5.setText("FOND DE CAISSE : "+fc1);
          this.poste.setText("POS : "+pos);
          
          this.d_s.setVisible(true) ;
          
           
          this.jTabbedPane2.setEnabledAt(1, true);
          this.jTabbedPane2.setEnabledAt(2, true);
 
         
         this.oss.setEnabled(false);
         
         this.jButton2.setEnabled(true) ;
          
         
      String pos1 = null ;
      
     sql = "select * from session where login = '"+this.login+"' and etat = 'OUI'" ;
     rs = stmt.executeQuery(sql) ;
     while(rs.next()){
         
          id = rs.getString("id") ;
          user = rs.getString("login") ;
          date_s = sdf_java_.format(rs.getTimestamp("date_open")) ;
          fc1 = rs.getString("fc") ;
          etat = "OUVERT" ;
          pos1 = rs.getString("pos") ;
          
          this.id_ss = rs.getLong("id") ;
          this.balance = rs.getDouble("balance") ;
          
          
          a = 1 ;
          
          }
         
  if(a == 1){
          
          this.jLabel2.setText("ID : "+id);
          this.jLabel3.setText("USER : "+user);
          this.jLabel4.setText("OUVERTE LE : "+date_s);
          this.jLabel5.setText("FOND DE CAISSE : "+fc1);
          this.poste.setText("POS : "+pos1);
          
          this.d_s.setVisible(true) ;
          
           
          this.jTabbedPane2.setEnabledAt(1, true);
          this.jTabbedPane2.setEnabledAt(2, true);
 
         
         this.oss.setEnabled(false);
         
         this.jButton2.setEnabled(true) ;
          
         
          
  }else if(a == 0){
  
          this.jButton2.setEnabled(false);
          this.jTabbedPane2.setEnabledAt(1, false);
          this.jTabbedPane2.setEnabledAt(2, false);
          
          this.oss.setEnabled(true) ;
          this.d_s.setVisible(false) ;
       
  }
      
     

      
       if(date_session.equals(date_jour) == true && this.login.equalsIgnoreCase(user_)){
         
          this.jButton2.setEnabled(true);
          this.jTabbedPane2.setEnabledAt(1, true);
          this.jTabbedPane2.setEnabledAt(2, true);
          
          this.oss.setEnabled(false) ;
          this.d_s.setVisible(true) ;
          this.copie_tiket.setEnabled(true) ;
         
           }else{
           
          this.jLabel2.setText("ID : "+id) ;
          this.jLabel3.setText("USER : "+user) ;
          this.jLabel4.setText("OUVERTE LE : "+date_s) ;
          this.jLabel5.setText("FOND DE CAISSE : "+fc1) ;
          this.poste.setText("POS : "+pos) ;
         
          this.jButton2.setEnabled(true);
          this.jTabbedPane2.setEnabledAt(1, false);
          this.jTabbedPane2.setEnabledAt(2, false);
          
          this.oss.setEnabled(false) ;
          this.d_s.setVisible(true) ;
          this.copie_tiket.setEnabled(false) ;
         
               }
      
      if(user.isEmpty() || user.equals("")){
          
          this.jButton2.setEnabled(false);
          this.jTabbedPane2.setEnabledAt(1, false);
          this.jTabbedPane2.setEnabledAt(2, false);
          
          this.oss.setEnabled(true) ;
          this.copie_tiket.setEnabled(false) ;
          
          }
      
      
           SimpleDateFormat sdf_java = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
           
       DefaultTableModel liste_op = (DefaultTableModel) this.t_op_s.getModel() ;
                         liste_op.setRowCount(0) ;
                                
       SimpleDateFormat sdf_ss = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
                                
                                sql = "select * from vente_gc where session = "+this.id_ss+" order by id desc" ;
                                rs = stmt.executeQuery(sql) ;
                                while(rs.next()){
                                    
                 // "ID", "DATE", "CLIENT", "MTT", "AVANCE", "RELIQUAT", "USER", "ETAT"
                                    
            Object[] x = new Object[]{
    rs.getString("id") , sdf_ss.format(rs.getTimestamp("datej")) , rs.getString("client") , this.nf3.format(rs.getDouble("mtt")) , this.nf3.format(rs.getDouble("avance"))
    , this.nf3.format(rs.getDouble("reliquat")) , rs.getString("user") , rs.getString("etat"), rs.getInt("cb")
                                    } ;
                                    
                        liste_op.addRow(x) ;
        
                                    
                                }
                                
 
sql = "select * from reglement where id_ss = "+this.id_ss ;
rs = stmt.executeQuery(sql) ;
while(rs.next()){
//  "ID", "DATE", "CLIENT", "MTT", "AVANCE", "RELIQUAT", "USER", "ETAT", "CB"

 Object[] ss = new Object[]{
rs.getString("id") , sdf_java.format(rs.getTimestamp("datej")) , "REGLEMENT CREDIT" , this.nf3.format(rs.getInt("mtt")) , "", "", rs.getString("login"), "OUI", 0
   } ;   
 
 liste_op.addRow(ss) ;
 
 }
                               
String var = "" ;
ArrayList<String> liste_vente = new ArrayList<String>() ;

 

                                
sql = "select vente_gc.datej as jour, vente_gc.id as ref, vente_gc.client as client, vente_gc.mtt as total, vente_gc.reliquat as reste, vente_gc.cb as cb, sum(reglement.mtt) as avance  "
        + "from vente_gc, reglement "
        + "where vente_gc.mode_payement = 'CREDIT' and vente_gc.cb = reglement.cb group by reglement.cb order by vente_gc.datej desc" ;

rs = stmt.executeQuery(sql) ;
while(rs.next()){ 

  liste_vente.add(rs.getString("ref")) ;
    
  if(rs.getInt("total") == rs.getInt("avance")){
      var = "NON" ;
  }else{
      var = "OUI" ;
  }
    
// "DATE", "ID", "CLIENT", "TOTAL", "AVANCE", "reliquat", "CB", "ETAT"    
 // Object[] i =  ;  
  
  dtm_rg_cl.addRow(new Object[]{
sdf_java.format(rs.getTimestamp("jour")) , rs.getLong("ref") , rs.getString("client") , this.nf3.format(rs.getInt("total")) , this.nf3.format(rs.getInt("avance")), this.nf3.format(rs.getInt("reste")) , 
      rs.getInt("cb") , var
  }) ;

    
       }




sql = "select vente_gc.datej as jour, vente_gc.id as ref, vente_gc.client as client, vente_gc.mtt as total, vente_gc.reliquat as reste, vente_gc.cb as cb  "
        + "from vente_gc "
        + "where vente_gc.mode_payement = 'CREDIT' order by vente_gc.datej desc" ;
rs = stmt.executeQuery(sql) ;
while(rs.next()){ 

    if(liste_vente.contains(new String(rs.getString("ref")))){
        
      }else{
    
// "DATE", "ID", "CLIENT", "TOTAL", "AVANCE", "reliquat", "CB", "ETAT"    
        
Object[] i = new Object[]{
sdf_java.format(rs.getTimestamp("jour")) , rs.getLong("ref") , rs.getString("client") , this.nf3.format(rs.getInt("total")) , this.nf3.format(0), this.nf3.format(rs.getInt("reste")) , 
      rs.getInt("cb") , "OUI"
        
  } ;  
  
  dtm_rg_cl.addRow(i) ;
        
        
          }
    
    
          }
          
// -----------------
          

                                      
                                
                                
            
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
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        fc = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        oss = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        d_s = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        poste = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        t_op_s = new javax.swing.JTable();
        id_op = new javax.swing.JTextField();
        copie_tiket = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        t_op_s1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_produit_v = new javax.swing.JTable();
        cb_v = new javax.swing.JTextField();
        desc_v = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_panier_v = new javax.swing.JTable();
        qt_v = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        s_v = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        t_client_v = new javax.swing.JTable();
        check1 = new javax.swing.JCheckBox();
        cl_v = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        check2 = new javax.swing.JCheckBox();
        check5 = new javax.swing.JCheckBox();
        check3 = new javax.swing.JCheckBox();
        mn_v = new javax.swing.JLabel();
        v_v = new javax.swing.JButton();
        init_v = new javax.swing.JButton();
        c_v = new javax.swing.JButton();
        r_v = new javax.swing.JButton();
        cash = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        t_rg_cl = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        t_rg_pn = new javax.swing.JTable();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        t_rg_py = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        cb1 = new javax.swing.JTextField();
        desc1 = new javax.swing.JTextField();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        fr = new javax.swing.JComboBox();
        rf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pa = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jTextField15 = new javax.swing.JTextField();
        qte = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        desc_alt = new javax.swing.JTextField();
        jCheckBox5 = new javax.swing.JCheckBox();
        jButton16 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        rch_1 = new javax.swing.JTextField();
        rch_2 = new javax.swing.JTextField();
        st_ = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        t_etat_ss = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        tfc = new javax.swing.JLabel();
        tbl = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        t_etat_op = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        tmtt = new javax.swing.JLabel();
        trl = new javax.swing.JLabel();
        dte1 = new datechooser.beans.DateChooserCombo();
        dte2 = new datechooser.beans.DateChooserCombo();
        user_etat = new javax.swing.JComboBox();
        mode_py = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 255));
        jTabbedPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("FERMER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(51, 51, 255));
        jButton18.setFont(new java.awt.Font("Nirmala UI", 1, 11)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("ACTUALISER");
        jButton18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 781, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton18))
                .addContainerGap(528, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ACCUEIL", jPanel2);

        jTabbedPane2.setBackground(new java.awt.Color(0, 0, 255));
        jTabbedPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTabbedPane2.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        fc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FOND DE CAISSE");

        oss.setBackground(new java.awt.Color(0, 0, 255));
        oss.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oss.setForeground(new java.awt.Color(255, 255, 255));
        oss.setText("OUVRIR");
        oss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ossActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("FERMER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        d_s.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFO SESSION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Nirmala UI", 1, 14))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ID");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("USER");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DATE OPEN");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("FOND DE CAISSE");

        poste.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poste.setText("POS :");

        javax.swing.GroupLayout d_sLayout = new javax.swing.GroupLayout(d_s);
        d_s.setLayout(d_sLayout);
        d_sLayout.setHorizontalGroup(
            d_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(d_sLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(poste, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        d_sLayout.setVerticalGroup(
            d_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, d_sLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(poste)
                .addGap(33, 33, 33))
        );

        t_op_s.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t_op_s.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        t_op_s.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DATE", "CLIENT", "MTT", "AVANCE", "RELIQUAT", "USER", "ETAT", "CB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_op_s.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        t_op_s.getTableHeader().setReorderingAllowed(false);
        t_op_s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t_op_sMouseReleased(evt);
            }
        });
        jScrollPane7.setViewportView(t_op_s);
        if (t_op_s.getColumnModel().getColumnCount() > 0) {
            t_op_s.getColumnModel().getColumn(0).setMinWidth(45);
            t_op_s.getColumnModel().getColumn(0).setPreferredWidth(45);
            t_op_s.getColumnModel().getColumn(0).setMaxWidth(45);
            t_op_s.getColumnModel().getColumn(8).setMinWidth(0);
            t_op_s.getColumnModel().getColumn(8).setPreferredWidth(0);
            t_op_s.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        id_op.setText("ID");
        id_op.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                id_opFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                id_opFocusLost(evt);
            }
        });
        id_op.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                id_opKeyReleased(evt);
            }
        });

        copie_tiket.setBackground(new java.awt.Color(0, 0, 255));
        copie_tiket.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        copie_tiket.setForeground(new java.awt.Color(255, 255, 255));
        copie_tiket.setText("COPIE TICKET");
        copie_tiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copie_tiketActionPerformed(evt);
            }
        });

        t_op_s1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t_op_s1.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        t_op_s1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CODE BARRE", "DESCRIPTION", "PU", "QTE", "MTT", "CB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_op_s1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        t_op_s1.getTableHeader().setReorderingAllowed(false);
        t_op_s1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t_op_s1MouseReleased(evt);
            }
        });
        jScrollPane12.setViewportView(t_op_s1);
        if (t_op_s1.getColumnModel().getColumnCount() > 0) {
            t_op_s1.getColumnModel().getColumn(0).setMinWidth(45);
            t_op_s1.getColumnModel().getColumn(0).setPreferredWidth(45);
            t_op_s1.getColumnModel().getColumn(0).setMaxWidth(45);
            t_op_s1.getColumnModel().getColumn(6).setMinWidth(0);
            t_op_s1.getColumnModel().getColumn(6).setPreferredWidth(0);
            t_op_s1.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(d_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fc)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(oss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(id_op, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(copie_tiket, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(oss)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(d_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_op, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(copie_tiket))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("SESSION", jPanel5);

        t_produit_v.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t_produit_v.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        t_produit_v.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "CODE BARRE", "DESCRIPTION", "P.U", "CL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_produit_v.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        t_produit_v.getTableHeader().setReorderingAllowed(false);
        t_produit_v.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t_produit_vMouseReleased(evt);
            }
        });
        t_produit_v.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_produit_vKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(t_produit_v);
        if (t_produit_v.getColumnModel().getColumnCount() > 0) {
            t_produit_v.getColumnModel().getColumn(0).setMinWidth(40);
            t_produit_v.getColumnModel().getColumn(0).setPreferredWidth(40);
            t_produit_v.getColumnModel().getColumn(0).setMaxWidth(40);
            t_produit_v.getColumnModel().getColumn(1).setMinWidth(120);
            t_produit_v.getColumnModel().getColumn(1).setPreferredWidth(120);
            t_produit_v.getColumnModel().getColumn(1).setMaxWidth(120);
            t_produit_v.getColumnModel().getColumn(3).setMinWidth(75);
            t_produit_v.getColumnModel().getColumn(3).setPreferredWidth(75);
            t_produit_v.getColumnModel().getColumn(3).setMaxWidth(75);
            t_produit_v.getColumnModel().getColumn(4).setMinWidth(0);
            t_produit_v.getColumnModel().getColumn(4).setPreferredWidth(0);
            t_produit_v.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        cb_v.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cb_v.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cb_v.setText("CB");
        cb_v.setFocusCycleRoot(true);
        cb_v.setFocusTraversalPolicyProvider(true);
        cb_v.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_vFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_vFocusLost(evt);
            }
        });
        cb_v.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cb_vKeyReleased(evt);
            }
        });

        desc_v.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        desc_v.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        desc_v.setText("DESCRIPTION");
        desc_v.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                desc_vFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                desc_vFocusLost(evt);
            }
        });
        desc_v.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desc_vKeyReleased(evt);
            }
        });

        t_panier_v.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t_panier_v.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        t_panier_v.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CODE BARRE", "DESCRIPTION", "QTE", "P.U", "MTT", "CL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_panier_v.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        t_panier_v.getTableHeader().setReorderingAllowed(false);
        t_panier_v.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t_panier_vMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(t_panier_v);
        if (t_panier_v.getColumnModel().getColumnCount() > 0) {
            t_panier_v.getColumnModel().getColumn(0).setMinWidth(40);
            t_panier_v.getColumnModel().getColumn(0).setPreferredWidth(40);
            t_panier_v.getColumnModel().getColumn(0).setMaxWidth(40);
            t_panier_v.getColumnModel().getColumn(1).setMinWidth(100);
            t_panier_v.getColumnModel().getColumn(1).setPreferredWidth(100);
            t_panier_v.getColumnModel().getColumn(1).setMaxWidth(100);
            t_panier_v.getColumnModel().getColumn(3).setMinWidth(75);
            t_panier_v.getColumnModel().getColumn(3).setPreferredWidth(75);
            t_panier_v.getColumnModel().getColumn(3).setMaxWidth(75);
            t_panier_v.getColumnModel().getColumn(4).setMinWidth(60);
            t_panier_v.getColumnModel().getColumn(4).setPreferredWidth(60);
            t_panier_v.getColumnModel().getColumn(4).setMaxWidth(60);
            t_panier_v.getColumnModel().getColumn(5).setMinWidth(75);
            t_panier_v.getColumnModel().getColumn(5).setPreferredWidth(75);
            t_panier_v.getColumnModel().getColumn(5).setMaxWidth(75);
            t_panier_v.getColumnModel().getColumn(6).setMinWidth(0);
            t_panier_v.getColumnModel().getColumn(6).setPreferredWidth(0);
            t_panier_v.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        qt_v.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qt_v.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qt_vKeyReleased(evt);
            }
        });

        jLabel7.setText("QTE :");

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("-");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        s_v.setBackground(new java.awt.Color(255, 0, 0));
        s_v.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        s_v.setForeground(new java.awt.Color(255, 255, 255));
        s_v.setText("SUPP.");
        s_v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_vActionPerformed(evt);
            }
        });

        t_client_v.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t_client_v.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        t_client_v.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "REF", "PRENOM & NOM", "TEL", "PLAFOND"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_client_v.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        t_client_v.getTableHeader().setReorderingAllowed(false);
        t_client_v.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t_client_vMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(t_client_v);
        if (t_client_v.getColumnModel().getColumnCount() > 0) {
            t_client_v.getColumnModel().getColumn(0).setMinWidth(40);
            t_client_v.getColumnModel().getColumn(0).setPreferredWidth(40);
            t_client_v.getColumnModel().getColumn(0).setMaxWidth(40);
            t_client_v.getColumnModel().getColumn(2).setMinWidth(80);
            t_client_v.getColumnModel().getColumn(2).setPreferredWidth(80);
            t_client_v.getColumnModel().getColumn(2).setMaxWidth(80);
            t_client_v.getColumnModel().getColumn(3).setMinWidth(75);
            t_client_v.getColumnModel().getColumn(3).setPreferredWidth(75);
            t_client_v.getColumnModel().getColumn(3).setMaxWidth(75);
        }

        check1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        check1.setText("CLIENT COMPTOIR");
        check1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                check1MouseReleased(evt);
            }
        });

        cl_v.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cl_v.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cl_v.setText("CLIENT");
        cl_v.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cl_vFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cl_vFocusLost(evt);
            }
        });
        cl_v.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cl_vKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("TOTAL :");

        jLabel9.setText("CASH");

        check2.setText("COMPTANT");
        check2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                check2MouseReleased(evt);
            }
        });

        check5.setText("CREDIT");
        check5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                check5MouseReleased(evt);
            }
        });

        check3.setText("ESPECE");
        check3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                check3MouseReleased(evt);
            }
        });

        mn_v.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mn_v.setText("MONNAIE = 0");

        v_v.setBackground(new java.awt.Color(0, 0, 255));
        v_v.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        v_v.setForeground(new java.awt.Color(255, 255, 255));
        v_v.setText("VALIDER");
        v_v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v_vActionPerformed(evt);
            }
        });

        init_v.setBackground(new java.awt.Color(255, 0, 0));
        init_v.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        init_v.setForeground(new java.awt.Color(255, 255, 255));
        init_v.setText("INIT.");
        init_v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                init_vActionPerformed(evt);
            }
        });

        c_v.setBackground(new java.awt.Color(0, 0, 255));
        c_v.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        c_v.setForeground(new java.awt.Color(255, 255, 255));
        c_v.setText("COPIE TICKET");
        c_v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_vActionPerformed(evt);
            }
        });

        r_v.setBackground(new java.awt.Color(255, 0, 0));
        r_v.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        r_v.setForeground(new java.awt.Color(255, 255, 255));
        r_v.setText("REPRISE");
        r_v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_vActionPerformed(evt);
            }
        });

        cash.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cashKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qt_v, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(s_v)
                                .addGap(42, 42, 42)
                                .addComponent(init_v, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 13, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(v_v, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(check3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(mn_v, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(c_v, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(check2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(check5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(r_v)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(cb_v, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(desc_v))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(check1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cl_v, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desc_v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check1)
                    .addComponent(cl_v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qt_v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(s_v)
                    .addComponent(jLabel8)
                    .addComponent(init_v)
                    .addComponent(r_v))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(check5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(check2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(check3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(v_v, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mn_v, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(c_v, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("VENTE", jPanel7);

        t_rg_cl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t_rg_cl.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        t_rg_cl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DATE", "ID", "CLIENT", "TOTAL", "AVANCE", "RELIQUAT", "CB", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_rg_cl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        t_rg_cl.getTableHeader().setReorderingAllowed(false);
        t_rg_cl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                t_rg_clMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(t_rg_cl);
        if (t_rg_cl.getColumnModel().getColumnCount() > 0) {
            t_rg_cl.getColumnModel().getColumn(0).setMinWidth(125);
            t_rg_cl.getColumnModel().getColumn(0).setPreferredWidth(125);
            t_rg_cl.getColumnModel().getColumn(0).setMaxWidth(125);
            t_rg_cl.getColumnModel().getColumn(6).setMinWidth(0);
            t_rg_cl.getColumnModel().getColumn(6).setPreferredWidth(0);
            t_rg_cl.getColumnModel().getColumn(6).setMaxWidth(0);
            t_rg_cl.getColumnModel().getColumn(7).setMinWidth(0);
            t_rg_cl.getColumnModel().getColumn(7).setPreferredWidth(0);
            t_rg_cl.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        t_rg_pn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t_rg_pn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "REF", "CODE BARRE", "DESCRIPTION", "P.U", "QTE", "MTT", "CB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_rg_pn.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        t_rg_pn.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(t_rg_pn);
        if (t_rg_pn.getColumnModel().getColumnCount() > 0) {
            t_rg_pn.getColumnModel().getColumn(6).setMinWidth(0);
            t_rg_pn.getColumnModel().getColumn(6).setPreferredWidth(0);
            t_rg_pn.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("ID :");
        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField6FocusLost(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("CLIENT :");
        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField7FocusLost(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setText("MONTANT :");

        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setText("OBSERV.");

        t_rg_py.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t_rg_py.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        t_rg_py.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "DATE", "REF", "MTT", "OBSERVATION", "LOGIN", "CB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_rg_py.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        t_rg_py.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(t_rg_py);
        if (t_rg_py.getColumnModel().getColumnCount() > 0) {
            t_rg_py.getColumnModel().getColumn(5).setMinWidth(0);
            t_rg_py.getColumnModel().getColumn(5).setPreferredWidth(0);
            t_rg_py.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        jButton11.setBackground(new java.awt.Color(0, 0, 255));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("VALIDER");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel13.setText("TOTAL :");
        jLabel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                            .addComponent(jTextField8)))
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jButton11)
                                .addGap(71, 71, 71))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("REGLEMENT CREDIT", jPanel9);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("CAISSE", jPanel3);

        jTabbedPane3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTable8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable8.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CODE BARRE", "DESCRIPTION", "P.A", "P.V", "1_1000"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable8.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable8.getTableHeader().setReorderingAllowed(false);
        jTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable8MouseReleased(evt);
            }
        });
        jScrollPane8.setViewportView(jTable8);
        if (jTable8.getColumnModel().getColumnCount() > 0) {
            jTable8.getColumnModel().getColumn(0).setMinWidth(40);
            jTable8.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable8.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable8.getColumnModel().getColumn(1).setMinWidth(75);
            jTable8.getColumnModel().getColumn(1).setPreferredWidth(75);
            jTable8.getColumnModel().getColumn(1).setMaxWidth(75);
            jTable8.getColumnModel().getColumn(3).setMinWidth(50);
            jTable8.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable8.getColumnModel().getColumn(3).setMaxWidth(50);
            jTable8.getColumnModel().getColumn(4).setMinWidth(50);
            jTable8.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable8.getColumnModel().getColumn(4).setMaxWidth(50);
            jTable8.getColumnModel().getColumn(5).setMinWidth(0);
            jTable8.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable8.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        cb1.setText("CB");
        cb1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb1FocusLost(evt);
            }
        });
        cb1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cb1KeyReleased(evt);
            }
        });

        desc1.setText("DESC");
        desc1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                desc1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                desc1FocusLost(evt);
            }
        });
        desc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desc1KeyReleased(evt);
            }
        });

        jTabbedPane4.setBackground(new java.awt.Color(0, 0, 255));
        jTabbedPane4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTabbedPane4.setForeground(new java.awt.Color(255, 255, 255));

        fr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR FOURNISSEUR" }));
        fr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frActionPerformed(evt);
            }
        });

        rf.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setText("REF.FACT");

        pa.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel14.setText("PRIX :");

        jButton13.setBackground(new java.awt.Color(0, 0, 255));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("AJOUTER");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jTable9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable9.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CODE BARRE", "DESCRIPTION", "P.A", "QTE", "MTT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable9.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable9.getTableHeader().setReorderingAllowed(false);
        jTable9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable9MouseReleased(evt);
            }
        });
        jScrollPane9.setViewportView(jTable9);
        if (jTable9.getColumnModel().getColumnCount() > 0) {
            jTable9.getColumnModel().getColumn(0).setMinWidth(40);
            jTable9.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable9.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable9.getColumnModel().getColumn(1).setMinWidth(120);
            jTable9.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTable9.getColumnModel().getColumn(1).setMaxWidth(120);
            jTable9.getColumnModel().getColumn(3).setMinWidth(60);
            jTable9.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTable9.getColumnModel().getColumn(3).setMaxWidth(60);
            jTable9.getColumnModel().getColumn(4).setMinWidth(75);
            jTable9.getColumnModel().getColumn(4).setPreferredWidth(75);
            jTable9.getColumnModel().getColumn(4).setMaxWidth(75);
            jTable9.getColumnModel().getColumn(5).setMinWidth(75);
            jTable9.getColumnModel().getColumn(5).setPreferredWidth(75);
            jTable9.getColumnModel().getColumn(5).setMaxWidth(75);
        }

        jButton14.setBackground(new java.awt.Color(255, 0, 51));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("RETIRER");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(0, 0, 255));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("VALIDER");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jTextField15.setEditable(false);
        jTextField15.setText("TOTAL : 0");

        qte.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel15.setText("QTE :");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qte, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(248, 248, 248))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jButton15)
                                .addGap(22, 22, 22)
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(fr, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jButton13)
                                .addGap(18, 18, 18)
                                .addComponent(jButton14))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rf, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(61, 61, 61))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(58, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jButton13)
                    .addComponent(jButton14)
                    .addComponent(qte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 363, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                    .addContainerGap(87, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)))
        );

        jTabbedPane4.addTab("ENTREE", jPanel11);

        jTable10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable10.setFont(new java.awt.Font("Nirmala UI", 0, 13)); // NOI18N
        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DESCRIPTION", "P.V", "STOCK", "SEUIL", "ETAT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable10.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable10.getTableHeader().setReorderingAllowed(false);
        jTable10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable10MouseReleased(evt);
            }
        });
        jScrollPane10.setViewportView(jTable10);
        if (jTable10.getColumnModel().getColumnCount() > 0) {
            jTable10.getColumnModel().getColumn(0).setMinWidth(35);
            jTable10.getColumnModel().getColumn(0).setPreferredWidth(35);
            jTable10.getColumnModel().getColumn(0).setMaxWidth(35);
            jTable10.getColumnModel().getColumn(5).setMinWidth(0);
            jTable10.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable10.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        desc_alt.setText("DESCRIPTION :");
        desc_alt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                desc_altFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                desc_altFocusLost(evt);
            }
        });
        desc_alt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                desc_altKeyReleased(evt);
            }
        });

        jCheckBox5.setText("VU");
        jCheckBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBox5MouseReleased(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(255, 153, 0));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("IMPRIMER");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(desc_alt, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jCheckBox5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desc_alt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox5)
                    .addComponent(jButton16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("ALERTE", jPanel12);

        jTable11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "REF", "ID", "CODE B", "DESCRIPTION", "P.A", "STOCK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable11.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable11.getTableHeader().setReorderingAllowed(false);
        jTable11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable11MouseReleased(evt);
            }
        });
        jScrollPane11.setViewportView(jTable11);
        if (jTable11.getColumnModel().getColumnCount() > 0) {
            jTable11.getColumnModel().getColumn(0).setMinWidth(0);
            jTable11.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable11.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable11.getColumnModel().getColumn(1).setMinWidth(50);
            jTable11.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable11.getColumnModel().getColumn(1).setMaxWidth(50);
            jTable11.getColumnModel().getColumn(2).setMinWidth(125);
            jTable11.getColumnModel().getColumn(2).setPreferredWidth(125);
            jTable11.getColumnModel().getColumn(2).setMaxWidth(125);
            jTable11.getColumnModel().getColumn(4).setMinWidth(75);
            jTable11.getColumnModel().getColumn(4).setPreferredWidth(75);
            jTable11.getColumnModel().getColumn(4).setMaxWidth(75);
            jTable11.getColumnModel().getColumn(5).setMinWidth(80);
            jTable11.getColumnModel().getColumn(5).setPreferredWidth(80);
            jTable11.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        rch_1.setText("CB");
        rch_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rch_1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rch_1FocusLost(evt);
            }
        });
        rch_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rch_1KeyReleased(evt);
            }
        });

        rch_2.setText("DESC");
        rch_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rch_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rch_2FocusLost(evt);
            }
        });
        rch_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rch_2KeyReleased(evt);
            }
        });

        st_.setText("STOCK :");

        jButton17.setBackground(new java.awt.Color(0, 0, 255));
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("MAJ");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rch_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rch_2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(st_, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton17)
                .addGap(18, 18, 18))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rch_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rch_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(st_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17))
                .addContainerGap(424, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                    .addContainerGap(45, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jTabbedPane4.addTab("MISE A JOUR", jPanel13);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(desc1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(desc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane4))
                .addContainerGap())
        );

        jTabbedPane3.addTab("STOCK", jPanel8);

        jTabbedPane5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        t_etat_ss.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t_etat_ss.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        t_etat_ss.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DATE OPEN", "DATE CLOSE", "FOND CAISSE", "BALANCE", "USER", "POS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_etat_ss.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        t_etat_ss.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(t_etat_ss);
        if (t_etat_ss.getColumnModel().getColumnCount() > 0) {
            t_etat_ss.getColumnModel().getColumn(0).setMinWidth(45);
            t_etat_ss.getColumnModel().getColumn(0).setPreferredWidth(45);
            t_etat_ss.getColumnModel().getColumn(0).setMaxWidth(45);
        }

        jButton6.setBackground(new java.awt.Color(255, 153, 0));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("IMPRIMER");

        tfc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfc.setText("TOTAL FC :");
        tfc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tbl.setText("TOTAL BALANCE :");
        tbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(tfc, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(tbl, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfc)
                    .addComponent(tbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane5.addTab("SESSION", jPanel6);

        t_etat_op.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        t_etat_op.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        t_etat_op.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CLIENT", "TOTAL", "RELIQUAT", "DATE", "USER"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_etat_op.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        t_etat_op.getTableHeader().setReorderingAllowed(false);
        jScrollPane14.setViewportView(t_etat_op);
        if (t_etat_op.getColumnModel().getColumnCount() > 0) {
            t_etat_op.getColumnModel().getColumn(0).setMinWidth(45);
            t_etat_op.getColumnModel().getColumn(0).setPreferredWidth(45);
            t_etat_op.getColumnModel().getColumn(0).setMaxWidth(45);
        }

        jButton7.setBackground(new java.awt.Color(255, 153, 0));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("IMPRIMER");

        tmtt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tmtt.setText("TOTAL MTT :");
        tmtt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        trl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        trl.setText("TOTAL RELIQUAT :");
        trl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(tmtt, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(trl, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tmtt)
                        .addComponent(trl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane5.addTab("OPERATION", jPanel14);

        user_etat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUT" }));

        mode_py.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUT", "COMPTANT", "ESPECE", "CREDIT" }));

        jButton4.setBackground(new java.awt.Color(51, 0, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("RECHERCHER");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel10.setText("DEBUT");

        jLabel16.setText("FIN");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane5)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(user_etat, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dte1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dte2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mode_py, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel10)
                .addGap(76, 76, 76)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dte2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user_etat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mode_py, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("ETAT", jPanel10);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("BACK-OFFICE", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb1FocusGained
        // TODO add your handling code here:
        
        
        String cb = this.cb1.getText() ;
        if(cb.equalsIgnoreCase("CB")){
            this.cb1.setText("") ;
        }
        
    }//GEN-LAST:event_cb1FocusGained

    private void cb1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb1FocusLost
       
        String cb = this.cb1.getText() ;
        if(cb.isEmpty()){
            this.cb1.setText("CB") ;
        }
        
        
    }//GEN-LAST:event_cb1FocusLost

    private void desc1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_desc1FocusGained
        
           String cb = this.desc1.getText() ;
        if(cb.equalsIgnoreCase("DESC")){
            this.desc1.setText("") ;
        }
        
        
    }//GEN-LAST:event_desc1FocusGained

    private void desc1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_desc1FocusLost
       
         String cb = this.desc1.getText() ;
        if(cb.isEmpty()){
            this.desc1.setText("DESC") ;
           }
        
    }//GEN-LAST:event_desc1FocusLost

    private void cb1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb1KeyReleased
           
        String n1 = this.cb1.getText().trim().replaceAll("'", "''") ;

        
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
      
      
      
         DefaultTableModel dtm =(DefaultTableModel) jTable8.getModel() ;
                           dtm.setRowCount(0);
                           
         
       String sql ;
      
        sql= "SELECT * FROM matieres_p WHERE code_barre LIKE '%"+n1+"%' ORDER BY description" ;
      
        ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){

  if(rs.getString("unite_mesure").equalsIgnoreCase("OUI")){
        
        dtm.addRow(new Object[]{
            
    // "ID", "CODE BARRE", "DESCRIPTION", "P.A", "P.V"
            
       rs.getLong("id") ,  rs.getString("code_barre") , "KG "+rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") , rs.getString("unite_mesure")
        
        }) ;
        
        }else if(rs.getString("unite_mesure").equalsIgnoreCase("vide")){
        
        dtm.addRow(new Object[]{
            
    // "ID", "CODE BARRE", "DESCRIPTION", "P.A", "P.V"
            
       rs.getLong("id") ,  rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") , rs.getString("unite_mesure")
        
        }) ;
        
        }
               
           
        
        }
     
     
     
     
      String sql2 ;
      
       sql2 = "SELECT * FROM produits_f WHERE code_barre LIKE '%"+n1+"%' ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){

         
          if(rs2.getString("unite_m").equalsIgnoreCase("OUI")){
        
        dtm.addRow(new Object[]{
            
       //  "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getInt("id") , rs2.getString("code_barre") , "KG "+rs2.getString("description") , rs2.getLong("libelle") 
         ,  rs2.getLong("pu") , rs2.getString("unite_m")
         
        }) ;
              
          }else if(rs2.getString("unite_m").equalsIgnoreCase("vide")){
              
               dtm.addRow(new Object[]{
            
       //  "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getInt("id") , rs2.getString("code_barre") , rs2.getString("description") , rs2.getLong("libelle") 
         ,  rs2.getLong("pu") , rs2.getString("unite_m")
         
        }) ;
              
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
   }  

      
        
    }//GEN-LAST:event_cb1KeyReleased

    private void desc1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desc1KeyReleased
       
        
           
        String n1 = this.desc1.getText().replaceAll("'", "''") ;
        
        
        
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
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable8.getModel() ;
                           dtm.setRowCount(0) ;
         
       String sql ;
      
        sql = "SELECT * FROM matieres_p WHERE description LIKE '%"+n1+"%' ORDER BY description" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
       while(rs.next()){
        
  if(rs.getString("unite_mesure").equalsIgnoreCase("OUI")){
        
        dtm.addRow(new Object[]{
            
    // "ID", "CODE BARRE", "DESCRIPTION", "P.A", "P.V"
            
       rs.getLong("id") ,  rs.getString("code_barre") , "KG "+rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") , rs.getString("unite_mesure")
        
        }) ;
        
        }else if(rs.getString("unite_mesure").equalsIgnoreCase("vide")){
        
        dtm.addRow(new Object[]{
            
    // "ID", "CODE BARRE", "DESCRIPTION", "P.A", "P.V"
            
       rs.getLong("id") ,  rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_a_unite") , rs.getLong("prx_v_unite") , rs.getString("unite_mesure")
        
        }) ;
        
        }
            
         
     
        
     }
       
       
       
       
         String sql2 ;
      
       sql2 = "SELECT * FROM produits_f WHERE description LIKE '%"+n1+"%' ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){

                  
          if(rs2.getString("unite_m").equalsIgnoreCase("OUI")){
        
        dtm.addRow(new Object[]{
            
       //  "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getInt("id") , rs2.getString("code_barre") , "KG "+rs2.getString("description") , rs2.getLong("libelle") 
         ,  rs2.getLong("pu") , rs2.getString("unite_m")
         
        }) ;
              
          }else if(rs2.getString("unite_m").equalsIgnoreCase("vide")){
              
               dtm.addRow(new Object[]{
            
       //  "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getInt("id") , rs2.getString("code_barre") , rs2.getString("description") , rs2.getLong("libelle") 
         ,  rs2.getLong("pu") , rs2.getString("unite_m")
         
        }) ;
              
          }
        
           
     
        
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
   }
 
        
        
        
        
    }//GEN-LAST:event_desc1KeyReleased

    Integer id ;
    String code_b;
    String description ;
    int pa_p ;
    int pv_p ;
    String rapport ;
    
    private void jTable8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable8MouseReleased
        // TODO add your handling code here:
        
        this.id = Integer.parseInt(this.jTable8.getValueAt(this.jTable8.getSelectedRow(), 0).toString()) ;
        this.code_b = this.jTable8.getValueAt(this.jTable8.getSelectedRow(), 1).toString() ;
        this.description = this.jTable8.getValueAt(this.jTable8.getSelectedRow(), 2).toString() ;
        this.pa_p = Integer.parseInt(this.jTable8.getValueAt(this.jTable8.getSelectedRow(), 3).toString()) ;
        this.pv_p = Integer.parseInt(this.jTable8.getValueAt(this.jTable8.getSelectedRow(), 4).toString()) ;
        
        this.pa.setText(String.valueOf(this.pa_p)) ;
        
        this.rapport = this.jTable8.getValueAt(this.jTable8.getSelectedRow(), 5).toString() ;
        
         
        
        
    }//GEN-LAST:event_jTable8MouseReleased

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        
        
        Integer pa = 0 , qte = 0 ;
        
        try{
            
        pa = Integer.parseInt(this.pa.getText().trim()) ;
        qte = Integer.parseInt(this.qte.getText().trim()) ;
        
        if(pa == 0 || qte == 0 || this.jTable8.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "SELECTIONNER UNE LIGNE , RENSEIGNER PRIX ET QTE") ;
        }else{
            
            
                     double mtt = 0.0 ;
                     
                  
                     if(this.rapport.equalsIgnoreCase("oui")){
                     
                         double prix = 0.0 ;
                         
                                prix = (pa / 1000.0) ;
                                
                                double montant = (prix * qte) ;
                                
                                mtt = montant ;
                                
                          
                         
                     }else if(this.rapport.equalsIgnoreCase("vide")){
                         
                         mtt = (pa * qte) ;
                         
                         
                          }
 
            
            Stock_gc stock = new Stock_gc() ;

                     stock.setId(this.id) ;
                     stock.setCb(this.code_b);
                     stock.setDescription(this.description) ;
                     stock.setPa(pa);
                     stock.setQte(qte) ;
                     stock.setMtt(mtt) ;
                    
                     
                     this.list_vy.add(new String(this.description)) ;
                     this.list_produit.add(stock) ;
                     
                     DefaultTableModel dtm = (DefaultTableModel) this.jTable9.getModel() ;
                     
                     dtm.addRow(new Object[]{
                         
                     // "ID", "CODE BARRE", "DESCRIPTION", "P.A", "QTE", "MTT"
                         
                         stock.getId() , stock.getCb() , stock.getDescription() , stock.getPa() , stock.getQte() , stock.getMtt()
                             
                          }) ;
                     
                     this.pa.setText("") ;
                     this.qte.setText("") ;
                     this.jTable8.getSelectionModel().clearSelection();
                     
                    
                     
                     to += mtt ;
                     
                     this.jTextField15.setText("TOTAL : "+this.nf3.format(to)) ;
            
            
            
            
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage()) ;
        }
        
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable9.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "CHOISIR DANS LE PANNIER SVP") ;
        }else{
            
            this.to = (this.to - this.mtt_r) ;
           
             DefaultTableModel dtm = (DefaultTableModel) this.jTable9.getModel() ; 
             
             this.list_produit.remove(this.jTable9.getSelectedRow()) ;
             this.list_vy.remove(this.jTable9.getSelectedRow()) ;
             
             dtm.removeRow(this.jTable9.getSelectedRow()) ;
            
             
             this.jTextField15.setText("TOTAL : "+this.nf3.format(to)) ;
            
            
           }
        
        
    }//GEN-LAST:event_jButton14ActionPerformed
double mtt_r = 0.0 ;
    private void jTable9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable9MouseReleased
        // TODO add your handling code here:
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable9.getModel() ;
        this.mtt_r = Double.parseDouble(dtm.getValueAt(this.jTable9.getSelectedRow(), 5).toString()) ;
        
        
        
    }//GEN-LAST:event_jTable9MouseReleased

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:

        this.jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
        String fr = "" , rf = "" ;
        this.bonList.removeAll(this.bonList) ;
        
        fr = this.fr.getSelectedItem().toString().replaceAll("'", "''") ;
        rf = this.rf.getText().trim().replaceAll("'", "''") ;
        
        if(fr.equalsIgnoreCase("CHOISIR FOURNISSEUR") || rf.isEmpty()){
            JOptionPane.showMessageDialog(null, "VEUILLEZ RENSEIGNER FOURNISSEUR & REFERENCE") ;
        }else{
            
            String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
            String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
            String USER = "root" ;
            String PASS = "interco" ;
            
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
            String datej = "" ;
            datej = sdf.format(new Date()) ;
            
            Integer code_barre ;
            
            Random rx = new Random() ;
            
            code_barre = rx.nextInt() ;
            
            if(code_barre < 0){
                code_barre = Math.abs(code_barre) ;
            }
            
            
             Connection conn = null ;
             Statement stmt = null ;
             Statement stmt_stock = null ;
       
       try{
      //STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      stmt_stock = conn.createStatement();
      
      //je crai ma requete
       
      
      
      String sql = null ;
      ResultSet rs = null ;
      
      String sql_ = null ;
      ResultSet rs_ = null ;
      
       
      
      if(stmt.executeUpdate("insert into op_stock(datej,user,fournisseur,total,etat,cb,rf) values('"
         +datej+"' , '"+this.login+"' , "+this.fourni+" , "+this.to+" , 'OUI' , "+code_barre+" , '"+rf+"')") == 1){
          
          for(int i = 0 ; i < this.list_produit.size() ; i++){
              
              
                 HashMap<String, Object> m = new HashMap<>() ;
                   
                   m.put("description", this.list_produit.get(i).getDescription()) ;
                   
                   m.put("pu", nf3.format(this.list_produit.get(i).getPa())) ;
                   
                   m.put("qte", nf3.format(this.list_produit.get(i).getQte())) ;
                   
                   m.put("mtt", this.nf3.format(this.list_produit.get(i).getMtt())) ;
                     
                              this.bonList.add(m) ;
              
          stmt.executeUpdate("insert into panier_stock(id_p,cb_p,description,prix_achat,qte,mtt,cb) values("
             +this.list_produit.get(i).getId()+" , '"+this.list_produit.get(i).getCb()+"' , '"
                  +this.list_produit.get(i).getDescription()+"' , "+this.list_produit.get(i).getPa()+" , "
                  +this.list_produit.get(i).getQte()+" , "+this.list_produit.get(i).getMtt()+" , "+code_barre+")") ;  
          
          
          stmt.executeUpdate("insert into tempon_panier(id_p, cb_p,nom_p,pu,qte,total) values("+this.list_produit.get(i).getId()+" , '"+this.list_produit.get(i).getCb()+"' , '"
                  +this.list_produit.get(i).getDescription()+"' , "+this.list_produit.get(i).getPa()+" , "
                  +this.list_produit.get(i).getQte()+" , "+this.list_produit.get(i).getMtt()+")") ;  
          
          
          
              
          }
          
          
         
          double total_qte = 0.0 ;
          double total_mtt = 0.0 ;
          double p_m = 0.0 ;
          
          
          
     
          sql = "select id_p, cb_p, nom_p, sum(qte) as qte , sum(total) as total , pu from "
                  + "tempon_panier group by nom_p order by nom_p asc" ;

          rs = stmt.executeQuery(sql) ;
          while(rs.next()){
              
             total_qte = Double.parseDouble(rs.getString("qte")) ;
             total_mtt = Double.parseDouble(rs.getString("total")) ; 
             
             Integer vy = 0 ;
             
             sql_ = "select description, stock , pa from stock_gc where description = '"+rs.getString("nom_p").replaceAll("'", "''")+"'" ;
             rs_ = stmt_stock.executeQuery(sql_) ;
             while(rs_.next()){
                 
                 String pro = rs_.getString("description").substring(0, 2) ;
                // JOptionPane.showMessageDialog(null, pro) ;
                 
                 if(pro.equalsIgnoreCase("KG")){
                     
                 total_qte = (total_qte + Double.parseDouble(rs_.getString("stock"))) ;
                 total_mtt = (total_mtt + (Double.parseDouble(rs_.getString("pa")) * (rs_.getInt("stock")/1000.0))) ;   
                     
                 }else{
                 
                  total_qte = (total_qte + Double.parseDouble(rs_.getString("stock"))) ;
                  total_mtt = (total_mtt + (Double.parseDouble(rs_.getString("pa")) * Double.parseDouble(rs_.getString("stock")))) ;
                  
                     }
                 
                
                 
                   vy = 1 ;
                  
                 }
             
             
             
             p_m = (total_mtt / total_qte) ;
             
                if(vy == 0){
                    
    stmt_stock.executeUpdate("insert into stock_gc(id_p,cb_p,description,pa,stock) values("
        +rs.getInt("id_p")+" , '"+rs.getString("cb_p")+"' , '"+rs.getString("nom_p").replaceAll("'", "''")+"' , "+p_m+" , "+total_qte+")") ;
                    
                  }else if(vy == 1){
                    
                     stmt_stock.executeUpdate("update stock_gc set pa = "+p_m+" , stock = "+total_qte+" where description = '"+rs.getString("nom_p").replaceAll("'", "''")+"'") ;  
                      
                    }
              
              
                }
          
          
            try{
                
                  
   InputStream in = getClass().getClassLoader().getResourceAsStream("papier_gescom/ticket.jrxml") ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.bonList) ;
            
            Map<String, Object> para = new HashMap<>();
            
            para.put("data", jrbean);
            
            para.put("login", this.pos+"/"+this.login.substring(0, 2)) ;  // this.login
            
            String id_op = "" ;
            sql = "select id from op_stock where cb = "+code_barre ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                id_op = rs.getString("id") ;
            }
            
            para.put("num", "TICKET ES N° "+"ES"+id_op) ;
            
            SimpleDateFormat sdf_java = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
            
            para.put("client", fr) ;
            para.put("total", this.jTextField15.getText());
            para.put("cash", "");
            para.put("monnaie", "") ;
            para.put("mode_py", "");
            para.put("datej", sdf_java.format(new Date())) ;
            para.put("copie", "") ;
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
       
       //  JasperViewer.viewReport(print, false) ;
            
            
          stmt.executeUpdate("delete from tempon_panier") ;
          this.list_produit.removeAll(this.list_produit) ;
          this.list_vy.removeAll(list_vy) ;
          this.fr.setSelectedItem(new String("CHOISIR FOURNISSEUR")) ;
          this.rf.setText(""); 
          
          DefaultTableModel dtm = (DefaultTableModel) this.jTable9.getModel() ;
                            dtm.setRowCount(0) ;
                            
          this.to = 0.0 ;                  
          this.jTextField15.setText("TOTAL : 0") ;
            
        JasperPrintManager.printReport(print, false) ;
         
    
        
                  }catch(Exception zt){
                      JOptionPane.showMessageDialog(null, zt.getMessage()) ;
                  }
                  
          
               
                   }
      
      
      
      
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
   // STEP 6: Clean-up environment
  //  rs.close();
      stmt.close();
      stmt_stock.close();
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
        
        this.jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
        
    }//GEN-LAST:event_jButton15ActionPerformed
private Integer fourni = 0 ;
    private void frActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frActionPerformed
        
        
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
      
       sql= "SELECT id FROM fournisseurs WHERE entreprise = '"+this.fr.getSelectedItem().toString().replaceAll("'", "''")+"'" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
         
         this.fourni = rs.getInt("id") ;  
           
     }
      
    
     
     // JOptionPane.showMessageDialog(this, "fournisseur id : "+this.compte_fourni) ;
    
            
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
        
    }//GEN-LAST:event_frActionPerformed

    private void desc_altFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_desc_altFocusGained
        // TODO add your handling code here:
        
        String desc_alt = this.desc_alt.getText().trim().replaceAll("'", "''") ;
        if(desc_alt.equalsIgnoreCase("DESCRIPTION :")){
           this.desc_alt.setText("") ;
           }
        
        
        
    }//GEN-LAST:event_desc_altFocusGained

    private void desc_altFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_desc_altFocusLost
       
                
        String desc_alt = this.desc_alt.getText().trim().replaceAll("'", "''") ;
        
        if(desc_alt.isEmpty()){
            
           this.desc_alt.setText("DESCRIPTION :") ;
           
                }
        
        
        
    }//GEN-LAST:event_desc_altFocusLost

    private void desc_altKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desc_altKeyReleased
        // TODO add your handling code here:
     
           
        
         Connection conn = null ;
         Statement stmt = null  ; 
       
       try{
           
      // STEP 2: Register JDBC driver
           
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
       String desc_alt = this.desc_alt.getText().trim().replaceAll("'", "''") ;
      
        this.list_ps.removeAll(this.list_ps) ;
         
      String sql ;
      
       sql= "SELECT * FROM matieres_p where description like '%"+desc_alt+"%' ORDER BY description ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
         
       
         

        if(rs.getString("unite_mesure").equalsIgnoreCase("OUI")){
            
              P_stock ps = new P_stock() ;
         
                 ps.setId(rs.getInt("id")) ;
                 ps.setDescription("KG "+rs.getString("description")) ;
                 ps.setPv(rs.getInt("prx_v_unite"));
                 ps.setSeuil(rs.getInt("stockMini"));
                 
                 this.list_ps.add(ps) ;
 
        
        }else if(rs.getString("unite_mesure").equalsIgnoreCase("vide")){
            
              P_stock ps = new P_stock() ;
         
                 ps.setId(rs.getInt("id")) ;
                 ps.setDescription(rs.getString("description")) ;
                 ps.setPv(rs.getInt("prx_v_unite"));
                 ps.setSeuil(rs.getInt("stockMini"));
                 
                 this.list_ps.add(ps) ;
   
        
                }
  
       
                }
     
     
     
       String sql2 ;
      
       sql2 = "SELECT * FROM produits_f where description like '%"+desc_alt+"%' ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
          if(rs2.getString("unite_m").equalsIgnoreCase("OUI")){
              
                P_stock ps = new P_stock() ;
         
                 ps.setId(rs2.getInt("id")) ;
                 ps.setDescription("KG "+rs2.getString("description")) ;
                 ps.setPv(rs2.getInt("pu"));
                 ps.setSeuil(rs2.getInt("stockMini"));
                 
                 this.list_ps.add(ps) ;
 
              
          }else if(rs2.getString("unite_m").equalsIgnoreCase("vide")){
              
               P_stock ps = new P_stock() ;
         
                 ps.setId(rs2.getInt("id")) ;
                 ps.setDescription(rs2.getString("description")) ;
                 ps.setPv(rs2.getInt("pu"));
                 ps.setSeuil(rs2.getInt("stockMini"));
                 
                 this.list_ps.add(ps) ;
 
              
             }
        
         
      
             }
      
      
    
      
 
            // end :      
      
    
            
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
       
       
       
       
       
          
       
         String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
         String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
         String USER = "root" ;
         String PASS = "interco" ;
         
 
       
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
      
        DefaultTableModel dtm_s = (DefaultTableModel) this.jTable10.getModel() ;
                          dtm_s.setRowCount(0) ;
         
      String sql = null ;
      ResultSet rs = null ;
      
       
            // end :  
      
      
      for(int i = 0 ; i < this.list_ps.size() ; i++){
          
      int seuil = 0 ;
      
      int stock = 0 ;
      String vu = "NON" ;
      
      seuil = this.list_ps.get(i).getSeuil() ;
      
      int vy = 0 ;
      
      // "ID", "DESCRIPTION", "P.V", "STOCK", "SEUIL", "ETAT"
      sql = "select stock , vu from stock_gc where description = '"+this.list_ps.get(i).getDescription().replaceAll("'", "''")+"'" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          stock = rs.getInt("stock") ;
          vu = rs.getString("vu") ;
          vy = 1 ;
          
         }
      
      if(vy == 1){
          
    if(seuil > stock){
        dtm_s.addRow(new Object[]{
        this.list_ps.get(i).getId(), this.list_ps.get(i).getDescription() , this.list_ps.get(i).getPv() , stock , seuil , vu
        }) ;
        
          }
            
           }
      
      rs.close();
      
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
       
       
       
       
        
        
        
    }//GEN-LAST:event_desc_altKeyReleased

    private void jCheckBox5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox5MouseReleased
        
        if(this.jTable10.getSelectedRow() == -1){
            
            JOptionPane.showMessageDialog(null, "CHOISIR DANS LA LISTE ");
            
        }else{
        
        
            
       
        
         Connection conn = null ;
         Statement stmt = null  ; 
       
       try{
           
      // STEP 2: Register JDBC driver
           
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
     // System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
      
       
      
        this.list_ps.removeAll(this.list_ps) ;
         
         String sql ;
      
       sql= "SELECT * FROM matieres_p where description = '"+this.description_alt.replaceAll("'", "''")+"' ORDER BY description ASC" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){
         
       
         

        if(rs.getString("unite_mesure").equalsIgnoreCase("OUI")){
            
              P_stock ps = new P_stock() ;
         
                 ps.setId(rs.getInt("id")) ;
                 ps.setDescription("KG "+rs.getString("description")) ;
                 ps.setPv(rs.getInt("prx_v_unite"));
                 ps.setSeuil(rs.getInt("stockMini"));
                 
                 this.list_ps.add(ps) ;
 
        
        }else if(rs.getString("unite_mesure").equalsIgnoreCase("vide")){
            
              P_stock ps = new P_stock() ;
         
                 ps.setId(rs.getInt("id")) ;
                 ps.setDescription(rs.getString("description")) ;
                 ps.setPv(rs.getInt("prx_v_unite"));
                 ps.setSeuil(rs.getInt("stockMini"));
                 
                 this.list_ps.add(ps) ;
   
        
                }
  
       
                }
     
     
     
       String sql2 ;
      
       sql2 = "SELECT * FROM produits_f where description = '"+this.description_alt.replaceAll("'", "''")+"' ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){
        
          if(rs2.getString("unite_m").equalsIgnoreCase("OUI")){
              
                P_stock ps = new P_stock() ;
         
                 ps.setId(rs2.getInt("id")) ;
                 ps.setDescription("KG "+rs2.getString("description")) ;
                 ps.setPv(rs2.getInt("pu"));
                 ps.setSeuil(rs2.getInt("stockMini"));
                 
                 this.list_ps.add(ps) ;
 
              
          }else if(rs2.getString("unite_m").equalsIgnoreCase("vide")){
              
               P_stock ps = new P_stock() ;
         
                 ps.setId(rs2.getInt("id")) ;
                 ps.setDescription(rs2.getString("description")) ;
                 ps.setPv(rs2.getInt("pu"));
                 ps.setSeuil(rs2.getInt("stockMini"));
                 
                 this.list_ps.add(ps) ;
 
              
             }
        
         
      
             }
      
      
    
      
 
            // end :      
      
    
            
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
       
       
       
       
       
          
       
         String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
         String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
         String USER = "root" ;
         String PASS = "interco" ;
         
 
       
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
      
        DefaultTableModel dtm_s = (DefaultTableModel) this.jTable10.getModel() ;
                       // dtm_s.setRowCount(0) ;
         
      String sql = null ;
      ResultSet rs = null ;
      
       
            // end :  
      
      
      for(int i = 0 ; i < this.list_ps.size() ; i++){
          
        if(this.vu_alt.equalsIgnoreCase("NON")){
              
         stmt.executeUpdate("update stock_gc set vu = 'OUI' where description = '"+this.list_ps.get(i).getDescription().replaceAll("'", "''")+"'") ;
              
            }else if(this.vu_alt.equalsIgnoreCase("OUI")){
              
         stmt.executeUpdate("update stock_gc set vu = 'NON' where description = '"+this.list_ps.get(i).getDescription().replaceAll("'", "''")+"'") ;
              
            }
          
      int seuil = 0 ;
      
      int stock = 0 ;
      String vu = "" ;
      
      seuil = this.list_ps.get(i).getSeuil() ;
      
      int vy = 0 ;
      
      // "ID", "DESCRIPTION", "P.V", "STOCK", "SEUIL", "ETAT"
      sql = "select stock , vu from stock_gc where description = '"+this.list_ps.get(i).getDescription().replaceAll("'", "''")+"'" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          stock = rs.getInt("stock") ;
          vu = rs.getString("vu") ;
          vy = 1 ;
          
         }
      
      if(vy == 1){
          
    if(seuil > stock){
        
        dtm_s.removeRow(this.jTable10.getSelectedRow()) ;
        
        dtm_s.addRow(new Object[]{
        this.list_ps.get(i).getId(), this.list_ps.get(i).getDescription() , this.list_ps.get(i).getPv() , stock , seuil , vu
        }) ;
        
    }
            
           }
      
      rs.close();
      
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
        
        
    }//GEN-LAST:event_jCheckBox5MouseReleased
String description_alt ;
String vu_alt ;
    private void jTable10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable10MouseReleased
        // TODO add your handling code here:
        
        this.description_alt = this.jTable10.getValueAt(this.jTable10.getSelectedRow(), 1).toString().replaceAll("'", "''") ;
        this.vu_alt = this.jTable10.getValueAt(this.jTable10.getSelectedRow(), 5).toString() ;
        
        if(this.vu_alt.equalsIgnoreCase("OUI")){
             this.jCheckBox5.setSelected(true) ;
          }else if(this.vu_alt.equalsIgnoreCase("NON")){
             this.jCheckBox5.setSelected(false) ;
          }
        
    }//GEN-LAST:event_jTable10MouseReleased
    
    private Integer stock = 0 ;
    private int ref = 0 ;
    private Integer new_stock = 0 ;
    private String descrip ;
    private Integer id_p ;
    
    private void jTable11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable11MouseReleased
        // TODO add your handling code here:
        
 this.stock = Integer.parseInt(this.jTable11.getValueAt(this.jTable11.getSelectedRow(), 5).toString()) ;
 this.ref = Integer.parseInt(this.jTable11.getValueAt(this.jTable11.getSelectedRow(), 0).toString()) ;
 this.descrip = this.jTable11.getValueAt(this.jTable11.getSelectedRow(), 3).toString() ;
 this.id_p = Integer.parseInt(this.jTable11.getValueAt(this.jTable11.getSelectedRow(), 1).toString()) ;
 
 
 this.st_.setText(String.valueOf(this.stock)) ;
 
 // Connexion with our DATABASE SERVER WITH SQL TECHNOLOGIE ...............
 
 
            
                        
         String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
         String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
         String USER = "root" ;
         String PASS = "interco" ;
         
         Connection conn = null ;
         Statement stmt = null  ;
       
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
      
     
      
      
     Integer vy = 0 ;
     
     String sql = null ;
     ResultSet rs = null ; 
     
    sql = "select * from histo_stock where description = '"+this.descrip.replaceAll("'", "''")+"'" ;
    rs = stmt.executeQuery(sql) ;
    while(rs.next()){
       vy = 1 ; 
       }
      
      if(vy == 1){
          
          Histo_Stock_Gc hs = new Histo_Stock_Gc(this.descrip) ;
                         hs.setVisible(true) ;
          
      }else if(vy == 0){}
      
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
       
       
       
 
 
 
 
        
    }//GEN-LAST:event_jTable11MouseReleased

    private void rch_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rch_1FocusGained
        // TODO add your handling code here:
        
     String rch_1 = this.rch_1.getText().trim() ;
        if(rch_1.equalsIgnoreCase("CB")){
            this.rch_1.setText("") ;
        }
        
    }//GEN-LAST:event_rch_1FocusGained

    private void rch_1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rch_1KeyReleased
 
        
         String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
         String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
         String USER = "root" ;
         String PASS = "interco" ;
         
         Connection conn = null ;
         Statement stmt = null  ;
       
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
      
         DefaultTableModel dtm_s = (DefaultTableModel) this.jTable11.getModel() ;
                           dtm_s.setRowCount(0) ;
                           
        String rch_1 = this.rch_1.getText().trim() ;
        
        
         
      String sql = null ;
      ResultSet rs = null ;
      

      
      
      sql = "select * from stock_gc where cb_p like '%"+rch_1+"%' order by description asc" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          
          dtm_s.addRow(new Object[]{
          //  "REF", "ID", "CODE B", "DESCRIPTION", "P.A", "STOCK"
rs.getInt("id") , rs.getInt("id_p") , rs.getString("cb_p") , rs.getString("description") , rs.getDouble("pa") , rs.getInt("stock")
              
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
       
       
       
       
        
        
    }//GEN-LAST:event_rch_1KeyReleased

    private void rch_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rch_1FocusLost
        // TODO add your handling code here :
        
       String rch_1 = this.rch_1.getText().trim() ;
       
        if(rch_1.isEmpty()){
            
            this.rch_1.setText("CB") ;
            
              }
        
        
    }//GEN-LAST:event_rch_1FocusLost

    private void rch_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rch_2FocusGained
        // TODO add your handling code here:
        
         String rch_1 = this.rch_2.getText().trim() ;
         
        if(rch_1.equalsIgnoreCase("DESC")){
            
            this.rch_2.setText("") ;
            
              }
        
    }//GEN-LAST:event_rch_2FocusGained

    private void rch_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rch_2FocusLost
         
        String rch_1 = this.rch_2.getText().trim() ;
         
        if(rch_1.isEmpty()){
            
            this.rch_2.setText("DESC") ;
            
              }
        
    }//GEN-LAST:event_rch_2FocusLost

    private void rch_2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rch_2KeyReleased

// TODO add your handling code here:
        
               
         String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
         String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
         String USER = "root" ;
         String PASS = "interco" ;
         
         Connection conn = null ;
         Statement stmt = null  ;
       
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
      
         DefaultTableModel dtm_s = (DefaultTableModel) this.jTable11.getModel() ;
                           dtm_s.setRowCount(0) ;
                           
        String rch_1 = this.rch_2.getText().trim() ;
        
        
         
      String sql = null ;
      ResultSet rs = null ;
      

      
      
      sql = "select * from stock_gc where description like '%"+rch_1+"%' order by description asc" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          
          dtm_s.addRow(new Object[]{
          //  "REF", "ID", "CODE B", "DESCRIPTION", "P.A", "STOCK"
rs.getInt("id") , rs.getInt("id_p") , rs.getString("cb_p") , rs.getString("description") , rs.getDouble("pa") , rs.getInt("stock")
              
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
       
       
       
       
        
        
    }//GEN-LAST:event_rch_2KeyReleased

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        
       try{
           
                        
         String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
         String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
         String USER = "root" ;
         String PASS = "interco" ;
         
         Connection conn = null ;
         Statement stmt = null  ;
       
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
      
        
                           
        Integer stock_saisie = Integer.parseInt(this.st_.getText()) ;
        this.new_stock = stock_saisie ;
        
        if(this.stock == this.new_stock){
            
            JOptionPane.showMessageDialog(null, "VEUILLEZ SAISIR UNE VALEUR DISTINCTE") ;
            
           }else{
        
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
  String datej = sdf.format(new Date()) ;

  
         
      String sql = null ;
      ResultSet rs = null ;
      
      
   if(stmt.executeUpdate("insert into histo_stock(datej,user,old_stock,new_stock,description,id_p) values('"
            +datej+"' , '"+this.login+"' , "+this.stock+" , "+this.new_stock+" , '"+this.descrip+"' , "+this.id_p+")") == 1){
        
        if(stmt.executeUpdate("update stock_gc set stock = "+this.new_stock+" where description = '"+this.descrip.replaceAll("'", "''")+"'") > 0){
            
                   DefaultTableModel dtm_s = (DefaultTableModel) this.jTable11.getModel() ;
                                     dtm_s.setRowCount(0) ;
                           
                           
      sql = "select * from stock_gc order by description asc" ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          
          dtm_s.addRow(new Object[]{
          //  "REF", "ID", "CODE B", "DESCRIPTION", "P.A", "STOCK"
rs.getInt("id") , rs.getInt("id_p") , rs.getString("cb_p") , rs.getString("description") , rs.getDouble("pa") , rs.getInt("stock")
              
          }) ;
          
         }
      
      
        rs.close() ;
        
        }
   
        }
    
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
       
       
       
         
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage()) ;
       }
        
        
        
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
     
          MenuGc mn = new MenuGc(this.role , this.login , this.pos) ;
                 mn.setVisible(true);
        
           this.dispose() ;
        
    }//GEN-LAST:event_jButton18ActionPerformed

    private void ossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ossActionPerformed
        // TODO add your handling code here:
 
    
            String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
            String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
            String USER = "root" ;
            String PASS = "interco" ;
            

  if (JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS OUVRIR UNE SESSION ?", "CONFIRMATION",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        // yes option
            
            String fc = this.fc.getText().trim().replaceAll("'", "''") ;
      
      if(fc.isEmpty()){
          JOptionPane.showMessageDialog(null, "SAISIR FOND DE CAISSE") ;
      }else{
          
          try{
              
              Integer f_s = Integer.parseInt(fc) ;
              double balance = f_s ;
              
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
      
      SimpleDateFormat sdf_java_ = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
      String sql = null ;
      ResultSet rs = null ;
      
     
         
         stmt.executeUpdate("insert into session(login,date_open,balance,fc,etat,pos,date_close) "
                 +"values('"+this.login+"' , '"+date+"' , "+balance+" , "+f_s+" , 'OUI' , '"+this.pos+"' , "+null+")") ;
         
         this.fc.setText("") ;
         
     sql = "select * from session where login = '"+this.login+"' and etat = 'OUI'" ;
     rs = stmt.executeQuery(sql) ;
     while(rs.next()){
         
          id = rs.getString("id") ;
          user = rs.getString("login") ;
          date_s = sdf_java_.format(rs.getTimestamp("date_open")) ;
          fc1 = rs.getString("fc") ;
          etat = "OUVERT" ;
          String pos = rs.getString("pos") ;
          
          
          this.id_ss = rs.getLong("id") ;
          this.balance = rs.getDouble("balance") ;
          
          
          
              }
         

          
          this.jLabel2.setText("ID : "+id);
          this.jLabel3.setText("USER : "+user);
          this.jLabel4.setText("OUVERTE LE : "+date_s);
          this.jLabel5.setText("FOND DE CAISSE : "+this.nf3.format(Integer.parseInt(fc1)));
          this.poste.setText("POS : "+pos);
          
          this.d_s.setVisible(true) ;
          
           
          this.jTabbedPane2.setEnabledAt(1, true);
          this.jTabbedPane2.setEnabledAt(2, true);
          this.copie_tiket.setEnabled(true) ;
 
         
         this.oss.setEnabled(false);
         
         this.jButton2.setEnabled(true) ;
          
         
     
      
    
            
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
        
      
        
       
    
        
    }//GEN-LAST:event_ossActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

            String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
            String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
            String USER = "root" ;
            String PASS = "interco" ;
            
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
      
      
     sql = "select * from session where login = '"+this.login+"' and etat = 'OUI'" ;
     rs = stmt.executeQuery(sql) ;
     while(rs.next()){
         vy = 1 ;
        }
     
     if(vy == 1){
         
         // stmt.executeUpdate("update session set date_close = '"+date+"' , etat = 'NON' where login = '"+this.login+"' and etat = 'OUI'") ;
          stmt.executeUpdate("update session set date_close = '"+date+"' , etat = 'NON' where pos = '"+this.pos+"' and etat = 'OUI'") ;
         
         this.fc.setText("");
         
          this.oss.setEnabled(true) ;
          this.d_s.setVisible(false);
          
          this.jTabbedPane2.setEnabledAt(1, false);
          this.jTabbedPane2.setEnabledAt(2, false);
 
          
          this.id_ss = 0 ;
          this.balance = 0.0 ;
         
         
         
           this.jButton2.setEnabled(false);
         
         
         
     }else if(vy == 0){
         
       // stmt.executeUpdate("update session set date_close = '"+date+"' , etat = 'NON' where login = '"+this.login+"' and etat = 'OUI'") ;
          stmt.executeUpdate("update session set date_close = '"+date+"' , etat = 'NON' where pos = '"+this.pos+"' and etat = 'OUI'") ;
         
         this.fc.setText("");
         
          this.oss.setEnabled(true) ;
          this.d_s.setVisible(false);
          
          this.jTabbedPane2.setEnabledAt(1, false);
          this.jTabbedPane2.setEnabledAt(2, false);
 
          
          this.id_ss = 0 ;
          this.balance = 0.0 ;
         
         
         
           this.jButton2.setEnabled(false) ;
     
           }
     
     
        DefaultTableModel dtm  = (DefaultTableModel) this.t_op_s1.getModel() ;
                          dtm.setRowCount(0) ;
                          
                          
                          
        DefaultTableModel dtm12 = (DefaultTableModel) this.t_op_s.getModel() ;
                          dtm12.setRowCount(0) ;
                          
       
      
    
            
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

    private void cb_vKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb_vKeyReleased
       
        
              
        String n1 = this.cb_v.getText().trim().replaceAll("'", "''") ;

        
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
      
      
      
         DefaultTableModel dtm =(DefaultTableModel) this.t_produit_v.getModel() ;
                           dtm.setRowCount(0);
                           
         
       String sql ;
      
        sql= "SELECT * FROM matieres_p WHERE code_barre LIKE '%"+n1+"%' ORDER BY description asc" ;
      
        ResultSet rs = stmt.executeQuery(sql);
      
      
     while(rs.next()){

  if(rs.getString("unite_mesure").equalsIgnoreCase("OUI")){
        
        dtm.addRow(new Object[]{
            
    // "ID", "CODE BARRE", "DESCRIPTION", "P.A", "P.V"
            
       rs.getLong("id") ,  rs.getString("code_barre") , "KG "+rs.getString("description")  ,
       rs.getLong("prx_v_unite") , rs.getString("unite_mesure")
        
        }) ;
        
        }else if(rs.getString("unite_mesure").equalsIgnoreCase("vide")){
        
        dtm.addRow(new Object[]{
            
    // "ID", "CODE BARRE", "DESCRIPTION", "P.A", "P.V"
            
       rs.getLong("id") ,  rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_v_unite") , rs.getString("unite_mesure")
        
        }) ;
        
        }
               
           
        
        }
     
     
     
     
      String sql2 ;
      
       sql2 = "SELECT * FROM produits_f WHERE code_barre LIKE '%"+n1+"%' ORDER BY description asc" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){

         
          if(rs2.getString("unite_m").equalsIgnoreCase("OUI")){
        
        dtm.addRow(new Object[]{
            
       //  "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getInt("id") , rs2.getString("code_barre") , "KG "+rs2.getString("description")
         ,  rs2.getLong("pu") , rs2.getString("unite_m")
         
        }) ;
              
          }else if(rs2.getString("unite_m").equalsIgnoreCase("vide")){
              
               dtm.addRow(new Object[]{
            
       //  "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getInt("id") , rs2.getString("code_barre") , rs2.getString("description")
         ,  rs2.getLong("pu") , rs2.getString("unite_m")
         
        }) ;
              
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
   }  

      
        
        
    }//GEN-LAST:event_cb_vKeyReleased

    private void cb_vFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_vFocusGained
        // TODO add your handling code here:
        
        
        String cb = this.cb_v.getText() ;
        if(cb.isEmpty()){
            
        }else if(cb.equalsIgnoreCase("CB")){
            
            this.cb_v.setText("");
            
          }
        
        
    }//GEN-LAST:event_cb_vFocusGained

    private void cb_vFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_vFocusLost
        
        String cb = this.cb_v.getText() ;
        if(cb.isEmpty()){
            this.cb_v.setText("CB");
        }
        
    }//GEN-LAST:event_cb_vFocusLost

    private void desc_vFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_desc_vFocusGained
        // TODO add your handling code here:
        
        String desc = this.desc_v.getText() ;
        if(desc.equalsIgnoreCase("DESCRIPTION")){
            this.desc_v.setText("");
        }
        
    }//GEN-LAST:event_desc_vFocusGained

    private void desc_vFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_desc_vFocusLost
        // TODO add your handling code here:
        
        String desc = this.desc_v.getText() ;
        if(desc.isEmpty()){
            this.desc_v.setText("DESCRIPTION");
        }
        
        
    }//GEN-LAST:event_desc_vFocusLost

    private void cl_vFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cl_vFocusGained
        // TODO add your handling code here:
        
        String client = this.cl_v.getText() ;
        if(client.equalsIgnoreCase("CLIENT")){
            this.cl_v.setText("");
        }
        
    }//GEN-LAST:event_cl_vFocusGained

    private void cl_vFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cl_vFocusLost
        
        String client = this.cl_v.getText() ;
        if(client.isEmpty()){
            this.cl_v.setText("CLIENT") ;
        }
        
        
    }//GEN-LAST:event_cl_vFocusLost

    private void desc_vKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desc_vKeyReleased

           
        String n1 = this.desc_v.getText().replaceAll("'", "''") ;
        
        
        
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
      
      
         DefaultTableModel dtm = (DefaultTableModel) this.t_produit_v.getModel() ;
                           dtm.setRowCount(0) ;
         
       String sql ;
      
        sql = "SELECT * FROM matieres_p WHERE description LIKE '%"+n1+"%' ORDER BY description" ;
      
       ResultSet rs = stmt.executeQuery(sql);
      
      
       while(rs.next()){
        
  if(rs.getString("unite_mesure").equalsIgnoreCase("OUI")){
        
        dtm.addRow(new Object[]{
            
    // "ID", "CODE BARRE", "DESCRIPTION", "P.A", "P.V"
            
       rs.getLong("id") ,  rs.getString("code_barre") , "KG "+rs.getString("description")  ,
       rs.getLong("prx_v_unite") , rs.getString("unite_mesure")
        
        }) ;
        
        }else if(rs.getString("unite_mesure").equalsIgnoreCase("vide")){
        
        dtm.addRow(new Object[]{
            
    // "ID", "CODE BARRE", "DESCRIPTION", "P.A", "P.V"
            
       rs.getLong("id") ,  rs.getString("code_barre") , rs.getString("description")  ,
       rs.getLong("prx_v_unite") , rs.getString("unite_mesure")
        
        }) ;
        
        }
            
         
     
        
     }
       
       
       
       
         String sql2 ;
      
       sql2 = "SELECT * FROM produits_f WHERE description LIKE '%"+n1+"%' ORDER BY description" ;
      
       ResultSet rs2 = stmt.executeQuery(sql2) ;
      
      
     while(rs2.next()){

                  
          if(rs2.getString("unite_m").equalsIgnoreCase("OUI")){
        
        dtm.addRow(new Object[]{
            
       //  "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getInt("id") , rs2.getString("code_barre") , "KG "+rs2.getString("description")
         ,  rs2.getLong("pu") , rs2.getString("unite_m")
         
        }) ;
              
          }else if(rs2.getString("unite_m").equalsIgnoreCase("vide")){
              
               dtm.addRow(new Object[]{
            
       //  "Code Barre", "Description", "Prix Achat", "Prix vente"
            
            rs2.getInt("id") , rs2.getString("code_barre") , rs2.getString("description")
         ,  rs2.getLong("pu") , rs2.getString("unite_m")
         
        }) ;
              
          }
        
           
     
        
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
   }
 
        
        
        
    }//GEN-LAST:event_desc_vKeyReleased

    private void cl_vKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cl_vKeyReleased
        // TODO add your handling code here:
        
        
          
   String n1 = this.cl_v.getText().replaceAll("'", "''").trim() ;

        
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
      
      
      
         DefaultTableModel dtm =(DefaultTableModel) this.t_client_v.getModel() ;
                           dtm.setRowCount(0) ;
         
      String sql ;
      
       sql = "SELECT * FROM clients WHERE entreprise LIKE '%"+n1+"%' ORDER BY entreprise" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        dtm.addRow(new Object[]{
            
                         //  "REF", "PRENOM & NOM", "TEL", "PLAFOND"
            
          rs.getInt("id") ,  rs.getString("entreprise") ,rs.getString("tel1")  ,
          rs.getLong("plafon_credit") 
       
          
                
        }) ;
               
        
         
     
        
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
     
        
        
    }//GEN-LAST:event_cl_vKeyReleased
    
    private Integer id_p_v ;
    private String cb_v_ ;
    private String description_v ;
    private double qte_v = 1.0 ;
    private Integer pu_v = 0 ;
    private double mtt_v_ = 0.0 ;
    private String cl ;
    
    private void t_produit_vMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_produit_vMouseReleased
        // TODO add your handling code here:
        
        this.id_p_v = Integer.parseInt(this.t_produit_v.getValueAt(this.t_produit_v.getSelectedRow(), 0).toString()) ;
        cb_v_  = this.t_produit_v.getValueAt(this.t_produit_v.getSelectedRow(), 1).toString() ;
        description_v  = this.t_produit_v.getValueAt(this.t_produit_v.getSelectedRow(), 2).toString();
        cl = this.t_produit_v.getValueAt(this.t_produit_v.getSelectedRow(), 4).toString();
        
        qte_v = 1 ;
        pu_v = Integer.parseInt(this.t_produit_v.getValueAt(this.t_produit_v.getSelectedRow(), 3).toString()) ;
        
        
        if(cl.equalsIgnoreCase("oui")){
           mtt_v_ = (this.pu_v / 1000.0) ;
        }else if(cl.equalsIgnoreCase("vide")){
            mtt_v_ = (this.pu_v * 1) ;
          }
        
        this.t_panier_v.getSelectionModel().clearSelection() ;
        this.t_client_v.getSelectionModel().clearSelection() ;
        
        
        
    }//GEN-LAST:event_t_produit_vMouseReleased

    private void t_produit_vKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_produit_vKeyReleased
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            if(this.t_produit_v.getSelectedRow() == -1 || description_v.isEmpty() || cl.isEmpty() || description_v.equalsIgnoreCase("")){
                
                this.t_produit_v.getSelectionModel().clearSelection() ;
                
                JOptionPane.showMessageDialog(null, "SELECTIONNER UN PRODUIT") ;
                
               }else{
            
          
              Pannier_gc pn = new Pannier_gc() ;
        
                  pn.setId_p(id_p_v) ;
                  pn.setCb(cb_v_);
                  pn.setDescription(description_v);
                  pn.setQte(qte_v);
                  pn.setPu(pu_v) ;
                  pn.setMtt(mtt_v_) ;
                  pn.setCl(cl);
                  
                  this.list_pn_v.add(pn) ;
                  
                //  this.list_pn_v_vy.add(new String(pn.getDescription())) ;
   DefaultTableModel dtm = (DefaultTableModel) this.t_panier_v.getModel() ;
   
         this.total_p_v += pn.getMtt() ;
         this.jLabel8.setText("TOTAL : "+this.nf3.format(this.total_p_v)+" FCFA") ;
   
   //  "ID", "CODE BARRE", "DESCRIPTION", "QTE", "P.U", "MTT"
   Object[] i = new Object[]{pn.getId_p(), pn.getCb(), pn.getDescription(), this.nf3.format(pn.getQte()), this.nf3.format(pn.getPu()), this.nf3.format(pn.getMtt()) , pn.getCl()} ;
                     dtm.addRow(i);
                     
   this.t_produit_v.getSelectionModel().clearSelection() ;
   this.qt_v.setText("1");
   
    id_p_v = 0;
    cb_v_  = "" ;
    description_v = "" ;
    qte_v = 1.0 ;
    pu_v = 0 ;
    mtt_v_ = 0.0 ;
    cl = "" ;
//  JOptionPane.showMessageDialog(null, "VALEUR CLAVIER TOUCHE TAPED : "+KeyEvent.VK_ENTER) ; En JAVA : LA TOUCHE ENTREE DU CLAVIER = 10
           
            }
            }
        
    }//GEN-LAST:event_t_produit_vKeyReleased

    private void t_panier_vMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_panier_vMouseReleased
        // TODO add your handling code here:
        
        
        Pannier_gc objet_pn = this.list_pn_v.get(this.t_panier_v.getSelectedRow()) ;
        
        this.qt_v.setText(String.valueOf(objet_pn.getQte())) ;
        
        this.t_produit_v.getSelectionModel().clearSelection() ;
        this.t_client_v.getSelectionModel().clearSelection() ;
        
        
        
        
    }//GEN-LAST:event_t_panier_vMouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        try{
            
             Pannier_gc objet_pn = this.list_pn_v.get(this.t_panier_v.getSelectedRow()) ;
             
           double qte = 0.0 ; 
                  qte = objet_pn.getQte() ;
                  
                  if(qte >= 1){
                  
                  qte++ ;
                  
                  double mtt = 0.0 ;
                  
                  if(objet_pn.getCl().equalsIgnoreCase("OUI")){
                      
                      mtt = ((qte / 1000.0) * objet_pn.getPu()) ;
                      
                  }else  if(objet_pn.getCl().equalsIgnoreCase("VIDE")){
                      
                      mtt = qte * objet_pn.getPu() ;
                  
                   }
                  
                  
                 
                  
                             objet_pn.setQte(qte) ;
                             objet_pn.setMtt(mtt);
                  
                  this.list_pn_v.set(this.t_panier_v.getSelectedRow(), objet_pn) ;
                  
                  DefaultTableModel dtm = (DefaultTableModel) this.t_panier_v.getModel() ;
                                    dtm.setValueAt(this.nf3.format(objet_pn.getQte()), this.t_panier_v.getSelectedRow(), 3) ;
                                    dtm.setValueAt(this.nf3.format(objet_pn.getMtt()), this.t_panier_v.getSelectedRow(), 5) ;
                                    
                this.total_p_v = 0.0 ;       
                for(int i = 0 ; i < this.list_pn_v.size(); i++){
                    
                    this.total_p_v += this.list_pn_v.get(i).getMtt() ;
                    System.out.println("DESCRIPTION : "+this.list_pn_v.get(i).getDescription()+" --- QUANTITE INSTANTANE = "+this.list_pn_v.get(i).getQte()) ;
                    
                                 }
                
                      this.jLabel8.setText("TOTAL : "+this.nf3.format(this.total_p_v)+" FCFA") ;   
                      this.qt_v.setText("");
                   
            
                  }else{
                      JOptionPane.showMessageDialog(null, "VALEUR NON AUTORISEE") ;
                  }
                  }catch(Exception e){
            
           
                  }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
          try{
            
             Pannier_gc objet_pn = this.list_pn_v.get(this.t_panier_v.getSelectedRow()) ;
             
           double qte = 0.0 ; 
                  qte = objet_pn.getQte() ;
                  
                  if(qte > 1){
                      
                  qte-- ;
                  
                   double mtt = 0.0 ;
                  
                  if(objet_pn.getCl().equalsIgnoreCase("OUI")){
                      
                      mtt = ((qte / 1000.0) * objet_pn.getPu()) ;
                      
                  }else  if(objet_pn.getCl().equalsIgnoreCase("VIDE")){
                      
                      mtt = qte * objet_pn.getPu() ;
                  
                   }
                  
                 
                  
                              objet_pn.setQte(qte) ;
                              objet_pn.setMtt(mtt);
                  
                  
                 
                  
                            
                  
                  this.list_pn_v.set(this.t_panier_v.getSelectedRow(), objet_pn) ;
                  
                  DefaultTableModel dtm = (DefaultTableModel) this.t_panier_v.getModel() ;
                                    dtm.setValueAt(this.nf3.format(objet_pn.getQte()), this.t_panier_v.getSelectedRow(), 3) ;
                                    dtm.setValueAt(this.nf3.format(objet_pn.getMtt()), this.t_panier_v.getSelectedRow(), 5) ;
                                    
                                    
                this.total_p_v = 0.0 ;       
                for(int i = 0 ; i < this.list_pn_v.size(); i++){
                    
                    this.total_p_v += this.list_pn_v.get(i).getMtt() ;
                    System.out.println("DESCRIPTION : "+this.list_pn_v.get(i).getDescription()+" --- QUANTITE INSTANTANE = "+this.list_pn_v.get(i).getQte()) ;
                    
                                 }
                
                      this.jLabel8.setText("TOTAL : "+this.nf3.format(this.total_p_v)+" FCFA") ;   
                      this.qt_v.setText("");
                   
                   
                  }else{
                      JOptionPane.showMessageDialog(null, "VALEUR NON AUTORISEE") ;
                  }
            
        }catch(Exception e){
            
           
          }
        
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void qt_vKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qt_vKeyReleased

        // TODO add your handling code here:
        
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            if(this.t_panier_v.getSelectedRow() == -1 || Integer.parseInt(this.qt_v.getText().trim()) < 1){
                
            }else{
                
                 try{
            
             Pannier_gc objet_pn = this.list_pn_v.get(this.t_panier_v.getSelectedRow()) ;
             
           double qte = 0.0 ; 
                  qte = Double.parseDouble(this.qt_v.getText().trim()) ;
                  
                   double mtt = 0.0 ;
                  
                  if(objet_pn.getCl().equalsIgnoreCase("OUI")){
                      
                      mtt = ((qte / 1000.0) * objet_pn.getPu()) ;
                      
                  }else  if(objet_pn.getCl().equalsIgnoreCase("VIDE")){
                      
                      mtt = qte * objet_pn.getPu() ;
                  
                   }
                  
                 
                  
                             objet_pn.setQte(qte) ;
                             objet_pn.setMtt(mtt);
                  
                 
                  
                             
                  
                  this.list_pn_v.set(this.t_panier_v.getSelectedRow(), objet_pn) ;
                  
                  DefaultTableModel dtm = (DefaultTableModel) this.t_panier_v.getModel() ;
                                    dtm.setValueAt(this.nf3.format(objet_pn.getQte()), this.t_panier_v.getSelectedRow(), 3) ;
                                    dtm.setValueAt(this.nf3.format(objet_pn.getMtt()), this.t_panier_v.getSelectedRow(), 5) ;
                                    
                                    this.total_p_v = 0.0 ;
                                    
                for(int i = 0 ; i < this.list_pn_v.size(); i++){
                    
                    this.total_p_v += this.list_pn_v.get(i).getMtt() ;
                    System.out.println("DESCRIPTION : "+this.list_pn_v.get(i).getDescription()+" --- QUANTITE INSTANTANE = "+this.list_pn_v.get(i).getQte()) ;
                    
                                 }
                
                      this.jLabel8.setText("TOTAL : "+this.nf3.format(this.total_p_v)+" FCFA") ;   
                      this.qt_v.setText("");
            
                         }catch(Exception e){
            
           
                          }
        
                
                          }
            
                          }
        
        
    }//GEN-LAST:event_qt_vKeyReleased

    private void s_vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_vActionPerformed
        // TODO add your handling code here:
        
        
         if (JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS SUPPRIMER LA LIGNE ?", "CONFIRMATION",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        // yes option
        
        if(this.t_panier_v.getSelectedRow() == -1){
            
            
              }else{
        
        DefaultTableModel dtm = (DefaultTableModel) this.t_panier_v.getModel() ;
                          this.list_pn_v.remove(this.t_panier_v.getSelectedRow()) ;
                          
                                               
                this.total_p_v = 0.0 ;       
                for(int i = 0 ; i < this.list_pn_v.size(); i++){
                    
                    this.total_p_v += this.list_pn_v.get(i).getMtt() ;
                    System.out.println("DESCRIPTION : "+this.list_pn_v.get(i).getDescription()+" --- QUANTITE INSTANTANE = "+this.list_pn_v.get(i).getQte()) ;
                    
                                 }
                
                      this.jLabel8.setText("TOTAL : "+this.nf3.format(this.total_p_v)+" FCFA") ;   
                      this.qt_v.setText("");
                   
                      
                          dtm.removeRow(this.t_panier_v.getSelectedRow());
        
                         }
        
             
                    }else{
                      // no option


                        } 

    }//GEN-LAST:event_s_vActionPerformed

    private void init_vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_init_vActionPerformed

        
 if (JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS VIDER LE PANNIER ?", "CONFIRMATION",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        // yes option
     
     
      DefaultTableModel dtm = (DefaultTableModel) this.t_panier_v.getModel() ;
                        this.list_pn_v.removeAll(this.list_pn_v) ;
                        dtm.setRowCount(0) ;
                        
                                             
                this.total_p_v = 0.0 ;       
                for(int i = 0 ; i < this.list_pn_v.size(); i++){
                    
                    this.total_p_v += this.list_pn_v.get(i).getMtt() ;
                    System.out.println("DESCRIPTION : "+this.list_pn_v.get(i).getDescription()+" --- QUANTITE INSTANTANE = "+this.list_pn_v.get(i).getQte()) ;
                    
                                 }
                
                      this.jLabel8.setText("TOTAL : "+this.nf3.format(this.total_p_v)+" FCFA") ;   
                      this.qt_v.setText("");
                      this.cash.setText("");
                        
                        

}else{
// no option


} 

        
       
     
        
        
    }//GEN-LAST:event_init_vActionPerformed

    private void r_vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_vActionPerformed
        
         if (JOptionPane.showConfirmDialog(null, "VOULEZ-VOUS FAIRE REPRISE VENTE DE LA LIGNE ?", "CONFIRMATION",
                     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        // yes option
             
                     
        
          try{
            
             Pannier_gc objet_pn = this.list_pn_v.get(this.t_panier_v.getSelectedRow()) ;
             
           double qte = 0.0 ; 
                  qte = objet_pn.getQte() ;
                  
                  qte = -qte ;
                  
                 double mtt = 0.0 ;
                  
                  if(objet_pn.getCl().equalsIgnoreCase("OUI")){
                      
                      mtt = ((qte / 1000.0) * objet_pn.getPu()) ;
                      
                  }else  if(objet_pn.getCl().equalsIgnoreCase("VIDE")){
                      
                      mtt = qte * objet_pn.getPu() ;
                  
                   }
                  
                 
                  
                             objet_pn.setQte(qte) ;
                             objet_pn.setMtt(mtt);
                  
                  this.list_pn_v.set(this.t_panier_v.getSelectedRow(), objet_pn) ;
                  
                  DefaultTableModel dtm = (DefaultTableModel) this.t_panier_v.getModel() ;
                                    dtm.setValueAt(objet_pn.getQte(), this.t_panier_v.getSelectedRow(), 3) ;
                                    dtm.setValueAt(objet_pn.getMtt(), this.t_panier_v.getSelectedRow(), 5) ;
                                    
                                    
                                    
                this.total_p_v = 0.0 ;       
                for(int i = 0 ; i < this.list_pn_v.size(); i++){
                    
                    this.total_p_v += this.list_pn_v.get(i).getMtt() ;
                    System.out.println("DESCRIPTION : "+this.list_pn_v.get(i).getDescription()+" --- QUANTITE INSTANTANE = "+this.list_pn_v.get(i).getQte()) ;
                    
                                 }
                
                      this.jLabel8.setText("TOTAL : "+this.nf3.format(this.total_p_v)+" FCFA") ;   
                      this.qt_v.setText("");
                   
                   
            
            
        }catch(Exception e){
            
           
                  }
        
        
        
             
             

            }else{
               // no option


                  } 


        
    }//GEN-LAST:event_r_vActionPerformed

private double avance = 0 ;
private double reliquat = 0 ;

    private void check2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check2MouseReleased
        // TODO add your handling code here:
        
        if(this.check2.isSelected()){
            
            this.avance = this.total_p_v ;
            this.reliquat = (this.total_p_v - this.avance) ;
            
            this.check3.setSelected(false) ;
            this.check3.setEnabled(false);
            this.check5.setSelected(false) ;
            this.check5.setEnabled(false);
            
            this.cash.setText("") ;
            this.cash.setEnabled(false) ;
            
            this.mn_v.setText("MONNAIE = 0") ;
            
              }else if(this.check2.isSelected() == false){
                  
                  this.avance = 0 ;
                  this.reliquat = 0 ;
                  
            this.check3.setSelected(false);
            this.check3.setEnabled(true) ;
            this.cash.setText("");
            this.cash.setEnabled(true);
            
           // this.check5.setSelected(false);
          //  this.check5.setEnabled(true) ;
     
                  
              }
        
        
    }//GEN-LAST:event_check2MouseReleased

    private void check1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check1MouseReleased
        // TODO add your handling code here:
        
        
        if(this.check1.isSelected()){
            
           this.id_client = 0 ;
           this.client = "CLIENT COMPTOIR" ;
           this.tel = "" ;
           this.plafon_cl = 0 ;
            
            this.check5.setSelected(false);
            this.check5.setEnabled(false) ;
            
            this.t_client_v.getSelectionModel().clearSelection();
            this.t_client_v.setEnabled(false) ;
            
        }else if(this.check1.isSelected() == false){
            
           this.id_client = 0 ;
           this.client = "" ;
           this.tel = "" ;
           this.plafon_cl = 0 ;
            
            this.check2.setSelected(false);
            this.check2.setEnabled(true) ;
            this.cash.setText("");
            this.cash.setEnabled(true);
            
            this.check5.setSelected(false);
            this.check5.setEnabled(true) ;
            
            this.check3.setSelected(false);
            this.check3.setEnabled(true) ;
            this.t_client_v.getSelectionModel().clearSelection();
            this.t_client_v.setEnabled(true) ;
            
             }
        
    }//GEN-LAST:event_check1MouseReleased
private double cash_vte = 0 ;
private double mn_vte = 0 ;
    private void cashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashKeyReleased
        // TODO add your handling code here:
        
        try{
            
        
        double cash = 0.0 ;
        
               cash = Double.parseDouble(this.cash.getText().trim()) ;
               
               double mn = cash - this.total_p_v ;
               
               this.mn_v.setText("MONNAIE = "+this.nf3.format(mn)+" FCFA") ;
               
               this.cash_vte = cash ;
               this.mn_vte = mn ;
               
              }catch(Exception e){
                  this.mn_v.setText("MONNAIE = "+0+" FCFA") ;
                  // JOptionPane.showMessageDialog(null, e.getMessage()) ;
              } 
        
        
    }//GEN-LAST:event_cashKeyReleased

    private void check3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check3MouseReleased
        // TODO add your handling code here:
        
        if(this.check3.isSelected()){
            
            this.avance = this.total_p_v ;
            this.reliquat = (this.total_p_v - this.avance) ;
            
            this.check2.setSelected(false) ;
            this.check2.setEnabled(false);
            this.check5.setSelected(false) ;
            this.check5.setEnabled(false);
            
            this.cash.setText("") ;
            this.cash.setEnabled(true) ;
            
            this.mn_v.setText("MONNAIE = 0") ;
            
              }else if(this.check3.isSelected() == false){
                  
                  this.avance = 0 ;
                  this.reliquat = 0 ;
                  
            this.check2.setSelected(false);
            this.check2.setEnabled(true) ;
            this.cash.setText("");
            this.cash.setEnabled(true);
            
            // this.check5.setSelected(false);
           // this.check5.setEnabled(true) ;
     
                  
              }
        
        
    }//GEN-LAST:event_check3MouseReleased

    private void check5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check5MouseReleased

        
         if(this.check5.isSelected()){
             
             this.avance = 0 ;
             this.reliquat = this.total_p_v ;
            
            this.check2.setSelected(false) ;
            this.check2.setEnabled(false);
            this.check3.setSelected(false) ;
            this.check3.setEnabled(false);
            
            this.cash.setText("") ;
            this.cash.setEnabled(false) ;
            
            this.mn_v.setText("MONNAIE = 0") ;
            
              }else if(this.check5.isSelected() == false){
                  
                  this.avance = 0 ;
                  this.reliquat = 0 ;
                  
            this.check2.setSelected(false);
            this.check2.setEnabled(true) ;
            this.cash.setText("");
            this.cash.setEnabled(true);
            
            this.check3.setSelected(false);
            this.check3.setEnabled(true) ;
     
                  
              }
        
        
        
    }//GEN-LAST:event_check5MouseReleased
private Integer id_client = 0 ;
private String client ;
private String tel ;
private Integer plafon_cl ;
    private void t_client_vMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_client_vMouseReleased
        // TODO add your handling code here:
        
     // JOptionPane.showMessageDialog(null, this.t_client_v.getSelectedRow()) ;
        
        try{
        
        this.t_panier_v.getSelectionModel().clearSelection() ;
        this.t_produit_v.getSelectionModel().clearSelection() ;
        
        if(this.t_client_v.getSelectedRow() == -1){
            
        }else{
            
        this.id_client = Integer.parseInt(this.t_client_v.getValueAt(this.t_client_v.getSelectedRow(), 0).toString()) ;
        this.client = this.t_client_v.getValueAt(this.t_client_v.getSelectedRow(), 1).toString() ;
        this.tel = this.t_client_v.getValueAt(this.t_client_v.getSelectedRow(), 2).toString() ;
        this.plafon_cl = Integer.parseInt(this.t_client_v.getValueAt(this.t_client_v.getSelectedRow(), 3).toString()) ;
        
        }
        }catch(Exception e){
            
                }
        
    }//GEN-LAST:event_t_client_vMouseReleased
private Integer code_tiket = 0 ;
    private void v_vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v_vActionPerformed
        // TODO add your handling code here:

         this.v_v.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
        double cash = 0.0 ;
        try{
            cash = Double.parseDouble(this.cash.getText().trim()) ;
        }catch(Exception e){
            cash = 0.0 ;
        }
        
 
        
        if(this.list_pn_v.size() > 0 ){
            
                 if((this.t_client_v.getSelectedRow() >= 0 || this.check1.isSelected())){
            
                  if((this.check2.isSelected() || (this.check3.isSelected() && cash >= this.total_p_v) || this.check5.isSelected())){
            
                 // can do validate vente
                      
                     // JOptionPane.showMessageDialog(null, "can do validate vente") ;
                      
                       String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
                       String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
                       String USER = "root" ;
                       String PASS = "interco" ;
                       
                       
   // connexion to DB GESCOM ...............
                       
                            
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
      
       
      
        this.bonList.removeAll(this.bonList) ;
       
        DefaultTableModel dtm =(DefaultTableModel) t_panier_v.getModel() ;
        
        String mode_py = "" ;
        
        if(this.check2.isSelected()){
            mode_py = "COMPTANT" ;
        }else if(this.check3.isSelected()){
            mode_py = "ESPECE" ;
            }else if(this.check5.isSelected()){
            mode_py = "CREDIT" ;
             }
        
             
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        SimpleDateFormat sdf_java = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
        Integer cb ;
        Random rx = new Random() ;
        cb = rx.nextInt() ;
        
        if(cb < 0){
        cb = Math.abs(cb) ;
           }
       
        this.code_tiket = cb ;
        
        String datej = sdf.format(new Date()) ;
        String etat = "OUI" ;
        // this.id_ss ;
        
        double balance = 0.0 ;
      
       sql = "select balance from session where id = "+this.id_ss ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
       
         balance = rs.getDouble("balance") ;
              
        }
      
      balance = (balance + this.avance) ;
      
      if(stmt.executeUpdate("update session set balance = "+balance+" where id = "+this.id_ss) == 1){
          
          if(stmt.executeUpdate("insert into vente_gc(id_client,client,tel,plafon_client,mtt,cash,monnaie,avance,reliquat,mode_payement,cb,datej,user,etat,session) values("
+this.id_client+", '"+this.client+"' , '"+this.tel+"' , "+this.plafon_cl+" , "+this.total_p_v+" , "+this.cash_vte+" , "+this.mn_vte+" , "+this.avance+" , "
+this.reliquat+" , '"+mode_py+"' , "+cb+" , '"+datej+"' , '"+this.login+"' , 'OUI' , "+this.id_ss+")") == 1){
          
              DefaultTableModel liste_op = (DefaultTableModel) this.t_op_s.getModel() ;
                                liste_op.setRowCount(0) ;
                                SimpleDateFormat sdf_ss = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
                                String id_vente = "0" ;
                                
                                sql = "select * from vente_gc where session = "+this.id_ss+" order by id desc" ;
                                rs = stmt.executeQuery(sql) ;
                                while(rs.next()){
                                    
                 // "ID", "DATE", "CLIENT", "MTT", "AVANCE", "RELIQUAT", "USER", "ETAT"
                                    
            Object[] x = new Object[]{
    rs.getString("id") , sdf_ss.format(rs.getTimestamp("datej")) , rs.getString("client") , this.nf3.format(rs.getDouble("mtt")) , this.nf3.format(rs.getDouble("avance"))
    , this.nf3.format(rs.getDouble("reliquat")) , rs.getString("user") , rs.getString("etat"), rs.getInt("cb")
                                    } ;
                                    
                        liste_op.addRow(x) ;
        
                                    
                                }
          
    for(int i = 0 ; i < this.list_pn_v.size(); i++){
    
        if(stmt.executeUpdate("insert into pannier_gc(id_p,cb_p,description,pu,qte,mtt,cb) values("
+this.list_pn_v.get(i).getId_p()+" , '"+this.list_pn_v.get(i).getCb()+"' , '"+this.list_pn_v.get(i).getDescription().replaceAll("'", "''")+"' , "
+this.list_pn_v.get(i).getPu()+" , "+this.list_pn_v.get(i).getQte()+" , "+this.list_pn_v.get(i).getMtt()+" , "+cb+")") == 1){
            
    double stock = 0.0 ;
    Integer vy = 0 ;
              
    sql = "select stock from stock_gc where id_p = "+this.list_pn_v.get(i).getId_p()+" and description = '"+this.list_pn_v.get(i).getDescription().replaceAll("'", "''")+"'" ;
    rs = stmt.executeQuery(sql) ;
    while(rs.next()){
        
       stock = rs.getDouble("stock") ;
       vy = 1 ;
       
       }
    
    stock = (stock - this.list_pn_v.get(i).getQte()) ;
    
    
    if(vy == 1){
    
       stmt.executeUpdate("update stock_gc set stock = "+stock+" where id_p = "+this.list_pn_v.get(i).getId_p()+" and description = '"+this.list_pn_v.get(i).getDescription().replaceAll("'", "''")+"'") ;
    
    }else if(vy == 0){
        
stmt.executeUpdate("insert into stock_gc(id_p,cb_p,description,pa,stock,vu) values("
+this.list_pn_v.get(i).getId_p()+" , '"+this.list_pn_v.get(i).getCb()+"' , '"+this.list_pn_v.get(i).getDescription().replaceAll("'", "''")+"' , "+this.list_pn_v.get(i).getPu()+" , "
        +stock+" , 'NON')") ;
           
    }  
    
    
                 HashMap<String, Object> m = new HashMap<>() ;
                   
                   m.put("description", this.list_pn_v.get(i).getDescription()) ;
                   
                   m.put("pu", nf3.format(this.list_pn_v.get(i).getPu())) ;
                   
                   m.put("qte", nf3.format(this.list_pn_v.get(i).getQte())) ;
                   
                   m.put("mtt", this.nf3.format(this.list_pn_v.get(i).getMtt())) ;
                     
                              this.bonList.add(m) ;
    
            
             }
        
        
             } 
    
    
    sql = "select id from vente_gc where cb = "+cb ;
    rs = stmt.executeQuery(sql) ;
    while(rs.next()){
        id_vente = rs.getString("id") ;
    }
                      
                  try{
                
                  
   InputStream in = getClass().getClassLoader().getResourceAsStream("papier_gescom/ticket.jrxml") ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.bonList) ;
            
            Map<String, Object> para = new HashMap<>();
            
            para.put("data", jrbean);
            
            para.put("login", this.pos+"/"+this.login.substring(0, 2)) ;  // this.login
            
            
            
            para.put("num", "TICKET CAISSE N° "+id_vente) ;
            
            
            para.put("client", this.client) ;
            para.put("total", this.jLabel8.getText());
            para.put("cash", "CASH "+this.nf3.format(this.cash_vte));
            para.put("monnaie", "MONNAIE "+this.nf3.format(this.mn_vte)) ;
            para.put("mode_py", "REGLEMENT "+mode_py);
            para.put("datej", sdf_java.format(new Date())) ;
            para.put("copie", "") ;
            
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
       
       //  JasperViewer.viewReport(print, false) ;
            
        JasperPrintManager.printReport(print, false) ;
         
        
        
                  }catch(Exception zt){
                      JOptionPane.showMessageDialog(null, zt.getMessage()) ;
                  }
                  
    
             
      
             }
          
      
             }
      
      
      dtm.setRowCount(0);
      this.total_p_v = 0 ;
      this.list_pn_v.removeAll(this.list_pn_v) ;
      this.list_pn_v_vy.removeAll(this.list_pn_v_vy) ;
      this.id_client = 0 ;
      this.client = "" ;
      this.tel = "" ;
      this.plafon_cl = 0 ;
      this.check1.setSelected(false);

      
      
                  this.check2.setSelected(false) ;
                  this.check3.setSelected(false) ;
                  this.cash.setText("") ;
                  this.cash.setEnabled(true) ;
                  this.check1.setEnabled(true) ;
                  this.t_client_v.getSelectionModel().clearSelection();
                  this.t_client_v.setEnabled(true) ;
                  this.check2.setEnabled(true) ;
                  this.check3.setEnabled(true) ;
                  this.check5.setSelected(false);
                  this.check5.setEnabled(true) ;
                  
                  this.jLabel8.setText("TOTAL = 0 FCFA") ;
                  this.mn_v.setText("MONNAIE = 0 FCFA") ;
      
   //   JOptionPane.showMessageDialog(null, "CALL TIBICO FOR PRINTING TICKET VENTE");
     
      
    
            
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
        

                       
                       // END CONNEXION CONNEXION .............
            
                      
                      
            
                  }else{
                      
                      JOptionPane.showMessageDialog(null, "VEUILLEZ CHOISIR LE MODE DE PAIEMENT; SI ESPECE, VEUILLEZ SAISIR LE CASH RECU") ;
                      
                  }
            
                  }else{
            
                  JOptionPane.showMessageDialog(null, "VEUILLEZ CHOISIR LE CLIENT") ;
            
                   }
            
               }else{
            
                  JOptionPane.showMessageDialog(null, "VEUILLEZ RENSEIGNER LE PANNIER ") ;
            
               }
        
        this.v_v.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
    }//GEN-LAST:event_v_vActionPerformed

    private void id_opFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_id_opFocusGained
        // TODO add your handling code here:
        
        this.id_op.setText("") ;
        
        
    }//GEN-LAST:event_id_opFocusGained

    private void id_opFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_id_opFocusLost
        // TODO add your handling code here:
        
        String id = "" ;
               id = this.id_op.getText() ;
       if(id.isEmpty()){
    this.id_op.setText("ID") ;
          } 
        
        
    }//GEN-LAST:event_id_opFocusLost

    private void id_opKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_opKeyReleased
        // TODO add your handling code here:

        
     String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
     String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
     String USER = "root" ;
     String PASS = "interco" ;

        
     
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
      
       
      
      
      String id = this.id_op.getText() ;

     
               DefaultTableModel liste_op = (DefaultTableModel) this.t_op_s.getModel() ;
                                liste_op.setRowCount(0) ;
               SimpleDateFormat sdf_ss = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
                                
                                sql = "select * from vente_gc where session = "+this.id_ss+" and id like '%"+id+"%' order by id desc" ;
                                rs = stmt.executeQuery(sql) ;
                                while(rs.next()){
                                    
                 // "ID", "DATE", "CLIENT", "MTT", "AVANCE", "RELIQUAT", "USER", "ETAT"
                                    
            Object[] x = new Object[]{
    rs.getString("id") , sdf_ss.format(rs.getTimestamp("datej")) , rs.getString("client") , this.nf3.format(rs.getDouble("mtt")) , this.nf3.format(rs.getDouble("avance"))
    , this.nf3.format(rs.getDouble("reliquat")) , rs.getString("user") , rs.getString("etat") , rs.getInt("cb")
                                    } ;
                                    
                        liste_op.addRow(x) ;
        
                                    
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
   
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_id_opKeyReleased
Integer code_brr ;
    private void t_op_sMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_op_sMouseReleased
        // TODO add your handling code here:
        
        // code barre est a la 8è colonne :
        
        this.code_brr = Integer.parseInt(this.t_op_s.getValueAt(this.t_op_s.getSelectedRow(), 8).toString()) ;
        
        DefaultTableModel dtm  = (DefaultTableModel) this.t_op_s1.getModel() ;
                          dtm.setRowCount(0) ;
                          
        



       String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
       String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
       String USER = "root" ;
       String PASS = "interco" ;
       
       
       
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
         
         
   
      
       sql = "select * from pannier_gc where cb = "+this.code_brr ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
           dtm.addRow(new Object[]{
            
        //   "ID", "CODE BARRE", "DESCRIPTION", "PU", "QTE", "MTT", "CB"
            
           rs.getString("id_p") , rs.getString("cb_p") , rs.getString("description") , this.nf3.format(rs.getInt("pu")) , this.nf3.format(rs.getDouble("qte")) , this.nf3.format(rs.getDouble("mtt")) , rs.getInt("cb")
         
             }) ;
               
        
         
      // System.out.print(" LE code patient est Systematique "+cp.getText()) ; 
        
     }
      
    Integer text = 0 ;  
     sql = "select copie from vente_gc where cb = "+this.code_brr ;
     rs = stmt.executeQuery(sql) ;
     while(rs.next()){
      text = rs.getInt("copie") ;
       }
      
     if(text == 0){
         this.copie_tiket.setEnabled(true) ;
     }else if(text == 1){
         this.copie_tiket.setEnabled(false) ;
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


                          
        
        
        
        
        
    }//GEN-LAST:event_t_op_sMouseReleased

    private void t_op_s1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_op_s1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_op_s1MouseReleased
private Integer total_vt = 0 ;
private Integer avance_vt = 0 ;
private Integer reliquat_vt = 0 ;
private String cb = "" ;

    private void t_rg_clMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_rg_clMouseReleased
       
 // TODO add your handling code here :
        
  this.cb = this.t_rg_cl.getValueAt(this.t_rg_cl.getSelectedRow(), 6).toString() ;
        
           this.total_vt =    Integer.parseInt(this.t_rg_cl.getValueAt(this.t_rg_cl.getSelectedRow(), 3).toString().replaceAll("[^a-zA-Z0-9]", "")) ;
           this.avance_vt =   Integer.parseInt(this.t_rg_cl.getValueAt(this.t_rg_cl.getSelectedRow(), 4).toString().replaceAll("[^a-zA-Z0-9]", "")) ;
           this.reliquat_vt = Integer.parseInt(this.t_rg_cl.getValueAt(this.t_rg_cl.getSelectedRow(), 5).toString().replaceAll("[^a-zA-Z0-9]", "")) ;
        
        
           String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
           String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
           String USER = "root" ;
           String PASS = "interco" ;
           
           
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
      
       
      
      
        DefaultTableModel dtm =(DefaultTableModel) this.t_rg_pn.getModel() ;
                          dtm.setRowCount(0) ;
                          
         DefaultTableModel dtm_py =(DefaultTableModel) this.t_rg_py.getModel() ;
                           dtm_py.setRowCount(0) ;
         
      
       sql = "SELECT * FROM pannier_gc where cb = "+this.cb ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
        
        dtm.addRow(new Object[]{
            
        //  "REF", "CODE BARRE", "DESCRIPTION", "P.U", "QTE", "MTT", "CB"
            
           rs.getString("id_p") , rs.getString("cb_p") , rs.getString("description") , this.nf3.format(rs.getInt("pu")) , 
           this.nf3.format(rs.getDouble("qte")) , this.nf3.format(rs.getDouble("mtt")) , rs.getString("cb") 
          
         
        }) ;
        
     }
     
     SimpleDateFormat sdf_ = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
     
     long to = 0 ;
     
      sql = "SELECT * FROM reglement where cb = "+this.cb ;
      rs = stmt.executeQuery(sql) ;  
     while(rs.next()){
         
         to += rs.getInt("mtt") ;
         
        dtm_py.addRow(new Object[]{
            
  // "DATE", "REF", "MTT", "OBSERVATION", "LOGIN", "CB"
            
           sdf_.format(rs.getTimestamp("datej")) , rs.getString("id") ,this.nf3.format(rs.getInt("mtt")) , rs.getString("observation") , rs.getString("login"), rs.getString("cb") 
          
         
        }) ;
            }
      
      this.jLabel13.setText("TOTAL : "+this.nf3.format(to)) ;
     
      
    
            
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


        
        
        /*
        
                                       
String var = "" ;
ArrayList<String> liste_vente = new ArrayList<String>() ;



 SimpleDateFormat sdf_java = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;

                                
sql = "select vente_gc.datej as jour, vente_gc.id as ref, vente_gc.client as client, vente_gc.mtt as total, vente_gc.reliquat as reste, vente_gc.cb as cb, sum(reglement.mtt) as avance  "
        + "from vente_gc, reglement "
        + "where vente_gc.mode_payement = 'CREDIT' and vente_gc.cb = reglement.cb order by vente_gc.datej desc" ;

rs = stmt.executeQuery(sql) ;
while(rs.next()){ 
    
    if(rs.getInt("avance") == 0 || rs.getInt("total") == 0){
        
    }else{
    
  liste_vente.add(rs.getString("ref")) ;
    
  if(rs.getInt("total") == rs.getInt("avance")){
      var = "NON" ;
  }else{
      var = "OUI" ;
  }
    
// "DATE", "ID", "CLIENT", "TOTAL", "AVANCE", "reliquat", "CB", "ETAT"    
 // Object[] i =  ;  
  
  dtm_rg_cl.addRow(new Object[]{
sdf_java.format(rs.getTimestamp("jour")) , rs.getLong("ref") , rs.getString("client") , this.nf3.format(rs.getInt("total")) , this.nf3.format(rs.getInt("avance")), this.nf3.format(rs.getInt("reste")) , 
      rs.getInt("cb") , var
  }) ;
  
          }
    
          }




sql = "select vente_gc.datej as jour, vente_gc.id as ref, vente_gc.client as client, vente_gc.mtt as total, vente_gc.reliquat as reste, vente_gc.cb as cb  "
        + "from vente_gc "
        + "where vente_gc.mode_payement = 'CREDIT' order by vente_gc.datej desc" ;
rs = stmt.executeQuery(sql) ;
while(rs.next()){ 

    if(liste_vente.contains(new String(rs.getString("ref")))){
        
      }else{
    
// "DATE", "ID", "CLIENT", "TOTAL", "AVANCE", "reliquat", "CB", "ETAT"    
        
Object[] i = new Object[]{
sdf_java.format(rs.getTimestamp("jour")) , rs.getLong("ref") , rs.getString("client") , this.nf3.format(rs.getInt("total")) , this.nf3.format(0), this.nf3.format(rs.getInt("reste")) , 
      rs.getInt("cb") , "OUI"
        
  } ;  
  
  dtm_rg_cl.addRow(i) ;
        
        
          }
    
    
          }
          
// -----------------
          

       
        
        */
        
        
        
    }//GEN-LAST:event_t_rg_clMouseReleased

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        
        
        try{
            
            String mtt , observation ;
            
                   mtt = this.jTextField8.getText() ;
                   observation = this.jTextField9.getText() ;
            
            if(mtt.isEmpty() || observation.isEmpty() || this.t_rg_cl.getSelectedRow() == -1){
                
                JOptionPane.showMessageDialog(null, "VEUILLEZ SELECTIONNER UNE LIGNE PUIS RENSEIGNER MONTANT ET OBSERVATION") ;
                
            }else{
                
                
                //   reccuperation dans le serveur et recalcule des chiffres ici :.....................
                    
                    
           String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
           String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
           String USER = "root" ;
           String PASS = "interco" ;
           
           
            Connection conn = null ;
            Statement stmt = null ;
       
       try{
      //STEP 2: Register JDBC driver :
      Class.forName(JDBC_DRIVER) ;

      // STEP 3: Open a connection
     //  System.out.println("Connecting to database...");
      
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      //System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      //je crai ma requete
       
      
      
            String sql = null ;
            ResultSet rs = null ;
      
       
            Integer avance = Integer.parseInt(mtt) ;
            
            
            sql = "select avance , reliquat from vente_gc where cb = "+this.cb ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                this.avance_vt = rs.getInt("avance") ;
                this.reliquat_vt = rs.getInt("reliquat") ;
            }
            
            
                
                if(avance == 0 || avance > this.reliquat_vt){
                    
                     JOptionPane.showMessageDialog(null, "VEUILLEZ SAISIR UNE VALEUR CORRECTE") ;
                    
                }else{
                    
      
      
        DefaultTableModel dtm =(DefaultTableModel) this.t_rg_py.getModel() ;
                          dtm.setRowCount(0) ;
         
         
   double balance = 0.0 ;
      
       sql = "SELECT balance FROM session where id = "+this.id_ss ;
      
       rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
      balance = rs.getDouble("balance") ;
        
        }
     
     balance = (balance + avance) ;
     
     Integer av_total = (this.avance_vt + avance) ;
     
     double reliquat = this.total_vt - av_total ;
     
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
     
     if(stmt.executeUpdate("update vente_gc set avance = "+av_total+" , reliquat = "+reliquat+" where cb = "+this.cb) == 1){
         if(stmt.executeUpdate("update session set balance = "+balance+" where id = "+this.id_ss) == 1){
             if(stmt.executeUpdate("insert into reglement(mtt,observation,login,cb,datej,id_ss) values("
+avance+" , '"+observation.replaceAll("'", "''")+"' , '"+this.login.replaceAll("'", "''")+"' , "+this.cb+" , '"+sdf.format(new Date())+"' , "+this.id_ss+")") == 1 ){
                 
                 
           DefaultTableModel dtm_rg_cl = (DefaultTableModel) this.t_rg_cl.getModel() ;
                             dtm_rg_cl.setRowCount(0);
           DefaultTableModel dtm_pn = (DefaultTableModel) this.t_rg_pn.getModel() ;
                             dtm_pn.setRowCount(0);
           DefaultTableModel dtm_rl = (DefaultTableModel) this.t_rg_py.getModel() ;
                             dtm_rl.setRowCount(0);
           DefaultTableModel dtm_s = (DefaultTableModel) this.t_op_s.getModel() ;
                             dtm_s.setRowCount(0) ;
           
               
                               
String var = "" ;
ArrayList<String> liste_vente = new ArrayList<String>() ;



SimpleDateFormat sdf_java = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;

                                
sql = "select vente_gc.datej as jour, vente_gc.id as ref, vente_gc.client as client, vente_gc.mtt as total, vente_gc.reliquat as reste, vente_gc.cb as cb, sum(reglement.mtt) as avance  "
        + "from vente_gc, reglement "
        + "where vente_gc.mode_payement = 'CREDIT' and vente_gc.cb = reglement.cb group by reglement.cb order by vente_gc.datej desc" ;

rs = stmt.executeQuery(sql) ;
while(rs.next()){ 
    
    if(rs.getInt("avance") == 0 || rs.getInt("total") == 0){
        
    }else{
    
  liste_vente.add(rs.getString("ref")) ;
    
  if(rs.getInt("total") == rs.getInt("avance")){
      var = "NON" ;
  }else{
      var = "OUI" ;
  }
    
// "DATE", "ID", "CLIENT", "TOTAL", "AVANCE", "reliquat", "CB", "ETAT"    
 // Object[] i =  ;  
  
  dtm_rg_cl.addRow(new Object[]{
sdf_java.format(rs.getTimestamp("jour")) , rs.getLong("ref") , rs.getString("client") , this.nf3.format(rs.getInt("total")) , this.nf3.format(rs.getInt("avance")), this.nf3.format(rs.getInt("reste")) , 
      rs.getInt("cb") , var
  }) ;
  
          }
    
          }




sql = "select vente_gc.datej as jour, vente_gc.id as ref, vente_gc.client as client, vente_gc.mtt as total, vente_gc.reliquat as reste, vente_gc.cb as cb  "
        + "from vente_gc "
        + "where vente_gc.mode_payement = 'CREDIT' order by vente_gc.datej desc" ;
rs = stmt.executeQuery(sql) ;
while(rs.next()){ 

    if(liste_vente.contains(new String(rs.getString("ref")))){
        
      }else{
    
// "DATE", "ID", "CLIENT", "TOTAL", "AVANCE", "reliquat", "CB", "ETAT"    
        
Object[] i = new Object[]{
sdf_java.format(rs.getTimestamp("jour")) , rs.getLong("ref") , rs.getString("client") , this.nf3.format(rs.getInt("total")) , this.nf3.format(0), this.nf3.format(rs.getInt("reste")) , 
      rs.getInt("cb") , "OUI"
        
  } ;  
  
  dtm_rg_cl.addRow(i) ;
        
        
          }
    
    
          }
          
// -----------------  -------------------------------------------------------------------------------------------------------------
 
                                
       SimpleDateFormat sdf_ss = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
                                
                                sql = "select * from vente_gc where session = "+this.id_ss+" order by id desc" ;
                                rs = stmt.executeQuery(sql) ;
                                while(rs.next()){
                                    
                 // "ID", "DATE", "CLIENT", "MTT", "AVANCE", "RELIQUAT", "USER", "ETAT"
                                    
            Object[] x = new Object[]{
    rs.getString("id") , sdf_ss.format(rs.getTimestamp("datej")) , rs.getString("client") , this.nf3.format(rs.getDouble("mtt")) , this.nf3.format(rs.getDouble("avance"))
    , this.nf3.format(rs.getDouble("reliquat")) , rs.getString("user") , rs.getString("etat"), rs.getInt("cb")
                                    } ;
                                    
                        dtm_s.addRow(x) ;
        
                                    
                                }




sql = "select * from reglement where id_ss = "+this.id_ss ;
rs = stmt.executeQuery(sql) ;
while(rs.next()){
//  "ID", "DATE", "CLIENT", "MTT", "AVANCE", "RELIQUAT", "USER", "ETAT", "CB"

 Object[] ss = new Object[]{
rs.getString("id") , sdf_java.format(rs.getTimestamp("datej")) , "REGLEMENT CREDIT" , this.nf3.format(rs.getInt("mtt")) , "", "", rs.getString("login"), "OUI", 0
   } ;   
 
 dtm_s.addRow(ss) ;
 
 }

        this.jTextField8.setText("") ;
        this.jTextField9.setText("") ;
        
                 
         }    
         }
         }
     
     
    
     
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
            
            
        }catch(Exception e){
            
            
        }
        
        
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusGained

        
        this.jTextField6.setText("") ;
        
        
    }//GEN-LAST:event_jTextField6FocusGained

    private void jTextField7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusGained
        // TODO add your handling code here :
        
        this.jTextField7.setText("") ;
        
        
    }//GEN-LAST:event_jTextField7FocusGained

    private void jTextField6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusLost
        
           // TODO add your handling code here :
        
        String id = this.jTextField6.getText() ;
        
               if(id.isEmpty()){
                   this.jTextField6.setText("ID :") ;
                }
        
    }//GEN-LAST:event_jTextField6FocusLost

    private void jTextField7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusLost
       
        // TODO add your handling code here :
        
           String id = this.jTextField7.getText() ;
        
               if(id.isEmpty()){
                   this.jTextField7.setText("CLIENT :") ;
                }
        
    }//GEN-LAST:event_jTextField7FocusLost

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased

               
              
        String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
        String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
        String USER = "root" ;
        String PASS = "interco" ;
         
   
         Connection conn = null ;
         Statement stmt = null  ; 
       
       try{
      // STEP 2: Register JDBC driver
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
  
    DefaultTableModel dtm_rg_cl = (DefaultTableModel) this.t_rg_cl.getModel() ;
                      dtm_rg_cl.setRowCount(0) ;
                      
                      DefaultTableModel dtm_rg_cl1 = (DefaultTableModel) this.t_rg_pn.getModel() ;
                                        dtm_rg_cl1.setRowCount(0) ;
                      
                      DefaultTableModel dtm_rg_cl2 = (DefaultTableModel) this.t_rg_py.getModel() ;
                                        dtm_rg_cl2.setRowCount(0) ;
 this.jLabel13.setText("TOTAL :") ;
  
 String var = "" ;
 ArrayList<String> liste_vente = new ArrayList<String>() ;

 SimpleDateFormat sdf_java = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;

                                
 sql = "select vente_gc.datej as jour, vente_gc.id as ref, vente_gc.client as client, vente_gc.mtt as total, vente_gc.reliquat as reste, vente_gc.cb as cb, sum(reglement.mtt) as avance  "
        + "from vente_gc, reglement "
        + "where vente_gc.id like '%"+this.jTextField6.getText()+"%' and vente_gc.mode_payement = 'CREDIT' and vente_gc.cb = reglement.cb group by reglement.cb order by vente_gc.datej desc" ;

rs = stmt.executeQuery(sql) ;
while(rs.next()){ 

  liste_vente.add(rs.getString("ref")) ;
    
  if(rs.getInt("total") == rs.getInt("avance")){
      var = "NON" ;
  }else{
      var = "OUI" ;
  }
    
// "DATE", "ID", "CLIENT", "TOTAL", "AVANCE", "reliquat", "CB", "ETAT"    
 // Object[] i =  ;  
  
  dtm_rg_cl.addRow(new Object[]{
sdf_java.format(rs.getTimestamp("jour")) , rs.getLong("ref") , rs.getString("client") , this.nf3.format(rs.getInt("total")) , this.nf3.format(rs.getInt("avance")), this.nf3.format(rs.getInt("reste")) , 
      rs.getInt("cb") , var
  }) ;

    
       }




sql = "select vente_gc.datej as jour, vente_gc.id as ref, vente_gc.client as client, vente_gc.mtt as total, vente_gc.reliquat as reste, vente_gc.cb as cb  "
        + "from vente_gc "
        + "where vente_gc.id like '%"+this.jTextField6.getText()+"%' and vente_gc.mode_payement = 'CREDIT' order by vente_gc.datej desc" ;
rs = stmt.executeQuery(sql) ;
while(rs.next()){ 

    if(liste_vente.contains(new String(rs.getString("ref")))){
        
      }else{
    
// "DATE", "ID", "CLIENT", "TOTAL", "AVANCE", "reliquat", "CB", "ETAT"    
        
Object[] i = new Object[]{
sdf_java.format(rs.getTimestamp("jour")) , rs.getLong("ref") , rs.getString("client") , this.nf3.format(rs.getInt("total")) , this.nf3.format(0), this.nf3.format(rs.getInt("reste")) , 
      rs.getInt("cb") , "OUI"
        
  } ;  
  
  dtm_rg_cl.addRow(i) ;
        
        
          }
    
    
          }
          
// -----------------
          

                                      
                                
                                
            
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
       
       
       
        
        
        
        
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // TODO add your handling code here:
        
        
               
              
        String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
        String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
        String USER = "root" ;
        String PASS = "interco" ;
         
   
         Connection conn = null ;
         Statement stmt = null  ; 
       
       try{
      // STEP 2: Register JDBC driver
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
  
    DefaultTableModel dtm_rg_cl = (DefaultTableModel) this.t_rg_cl.getModel() ;
                      dtm_rg_cl.setRowCount(0) ;
                      
     DefaultTableModel dtm_rg_cl1 = (DefaultTableModel) this.t_rg_pn.getModel() ;
                                        dtm_rg_cl1.setRowCount(0) ;
                      
                      DefaultTableModel dtm_rg_cl2 = (DefaultTableModel) this.t_rg_py.getModel() ;
                                        dtm_rg_cl2.setRowCount(0) ;
 
this.jLabel13.setText("TOTAL :") ;
 
  
 String var = "" ;
 ArrayList<String> liste_vente = new ArrayList<String>() ;

 SimpleDateFormat sdf_java = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;

                                
 sql = "select vente_gc.datej as jour, vente_gc.id as ref, vente_gc.client as client, vente_gc.mtt as total, vente_gc.reliquat as reste, vente_gc.cb as cb, sum(reglement.mtt) as avance  "
        + "from vente_gc, reglement "
        + "where vente_gc.client like '%"+this.jTextField7.getText()+"%' and vente_gc.mode_payement = 'CREDIT' and vente_gc.cb = reglement.cb group by reglement.cb order by vente_gc.datej desc" ;

rs = stmt.executeQuery(sql) ;
while(rs.next()){ 

  liste_vente.add(rs.getString("ref")) ;
    
  if(rs.getInt("total") == rs.getInt("avance")){
      var = "NON" ;
  }else{
      var = "OUI" ;
  }
    
// "DATE", "ID", "CLIENT", "TOTAL", "AVANCE", "reliquat", "CB", "ETAT"    
 // Object[] i =  ;  
  
  dtm_rg_cl.addRow(new Object[]{
sdf_java.format(rs.getTimestamp("jour")) , rs.getLong("ref") , rs.getString("client") , this.nf3.format(rs.getInt("total")) , this.nf3.format(rs.getInt("avance")), this.nf3.format(rs.getInt("reste")) , 
      rs.getInt("cb") , var
  }) ;

    
       }




sql = "select vente_gc.datej as jour, vente_gc.id as ref, vente_gc.client as client, vente_gc.mtt as total, vente_gc.reliquat as reste, vente_gc.cb as cb  "
        + "from vente_gc "
        + "where vente_gc.client like '%"+this.jTextField6.getText()+"%' and vente_gc.mode_payement = 'CREDIT' order by vente_gc.datej desc" ;
rs = stmt.executeQuery(sql) ;
while(rs.next()){ 

    if(liste_vente.contains(new String(rs.getString("ref")))){
        
      }else{
    
// "DATE", "ID", "CLIENT", "TOTAL", "AVANCE", "reliquat", "CB", "ETAT"    
        
Object[] i = new Object[]{
sdf_java.format(rs.getTimestamp("jour")) , rs.getLong("ref") , rs.getString("client") , this.nf3.format(rs.getInt("total")) , this.nf3.format(0), this.nf3.format(rs.getInt("reste")) , 
      rs.getInt("cb") , "OUI"
        
  } ;  
  
  dtm_rg_cl.addRow(i) ;
        
        
          }
    
    
          }
          
// -----------------
          

                                      
                                
                                
            
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
       
       
       
        
        
        
        
        
    }//GEN-LAST:event_jTextField7KeyReleased

    String n1 = "" , n2 = "" ;

    List mlist_s ;
    List mlist_v ;
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here :
        
        
        String user = "" ;
        String mode_py = "" ;
        
        user = this.user_etat.getSelectedItem().toString().replaceAll("'", "''") ;
        mode_py = this.mode_py.getSelectedItem().toString().replaceAll("'", "''") ;
        
        if(user.equalsIgnoreCase("TOUT")){
            user = "" ;
         }
        
        if(mode_py.equalsIgnoreCase("TOUT")){
            mode_py = "" ; 
         }
        
   

         try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.dte1.getSelectedDate().getTime()) ;
        String dte2 = sdf.format(this.dte2.getSelectedDate().getTime()) ; 
            
        long fc = 0 , bl = 0 , mtt = 0 , rl = 0 ;
        
        
      //  NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
        
           String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
           String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
           String USER = "root" ;
           String PASS = "interco" ;
            
            Connection conn = null;
            Statement stmt = null;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
    
         
        
       String sql = null ;
       ResultSet rs = null ;
       
       if(user.isEmpty() && mode_py.isEmpty()){
           
             DefaultTableModel dtm = (DefaultTableModel) this.t_etat_ss.getModel() ;
                               dtm.setRowCount(0) ;
                             
             DefaultTableModel dtm_v = (DefaultTableModel) this.t_etat_op.getModel() ;
                               dtm_v.setRowCount(0) ;
           
         
                sql = "select * from session where etat = 'NON' and date_open between '"+dte1+"' and '"+dte2+"' order by id desc" ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    
                    fc += rs.getInt("fc") ;
                    bl += rs.getDouble("balance") ;
                   
                    
   // "ID", "DATE OPEN", "DATE CLOSE", "FOND CAISSE", "BALANCE", "USER", "POS"                   
dtm.addRow(new Object[]{
  rs.getString("id") , sdf1.format(rs.getTimestamp("date_open")) , sdf1.format(rs.getTimestamp("date_close")) , this.nf3.format(rs.getInt("fc")) , this.nf3.format(rs.getDouble("balance")) 
        , rs.getString("login") , rs.getString("pos")
                    }) ;
                    
                    }
                
   
                sql = "select * from vente_gc where datej between '"+dte1+"' and '"+dte2+"' order by id desc" ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    
                     mtt += rs.getDouble("mtt") ;
                     rl += rs.getInt("reliquat") ;
                    
   // "ID", "CLIENT", "TOTAL", "RELIQUAT", "DATE", "USER"                
dtm_v.addRow(new Object[]{
  rs.getString("id") , rs.getString("client") , this.nf3.format(rs.getDouble("mtt")) , this.nf3.format(rs.getInt("reliquat")) , sdf1.format(rs.getTimestamp("datej")) , rs.getString("user")
                    }) ;
                    
                    }
                
                this.tfc.setText("TOTAL FC : "+this.nf3.format(fc)) ;
                this.tbl.setText("TOTAL BALANCE : "+this.nf3.format(bl)) ;
                
                this.tmtt.setText("TOTAL MTT : "+this.nf3.format(mtt)) ;
                this.trl.setText("TOTAL RELIQUAT : "+this.nf3.format(rl)) ;
                
                
                    }else if(user.isEmpty() == false && mode_py.isEmpty()){
                        
                         DefaultTableModel dtm = (DefaultTableModel) this.t_etat_ss.getModel() ;
                               dtm.setRowCount(0) ;
                             
             DefaultTableModel dtm_v = (DefaultTableModel) this.t_etat_op.getModel() ;
                               dtm_v.setRowCount(0) ;
           
         
                sql = "select * from session where etat = 'NON' and date_open between '"+dte1+"' and '"+dte2+"' and login = '"+user+"' order by id desc" ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    
                    fc += rs.getInt("fc") ;
                    bl += rs.getDouble("balance") ;
                   
                    
   // "ID", "DATE OPEN", "DATE CLOSE", "FOND CAISSE", "BALANCE", "USER", "POS"                   
dtm.addRow(new Object[]{
  rs.getString("id") , sdf1.format(rs.getTimestamp("date_open")) , sdf1.format(rs.getTimestamp("date_close")) , this.nf3.format(rs.getInt("fc")) , this.nf3.format(rs.getDouble("balance")) 
        , rs.getString("login") , rs.getString("pos")
                    }) ;
                    
                    }
                
   
                sql = "select * from vente_gc where datej between '"+dte1+"' and '"+dte2+"' and user = '"+user+"' order by id desc" ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    
                     mtt += rs.getDouble("mtt") ;
                     rl += rs.getInt("reliquat") ;
                    
   // "ID", "CLIENT", "TOTAL", "RELIQUAT", "DATE", "USER"                
dtm_v.addRow(new Object[]{
  rs.getString("id") , rs.getString("client") , this.nf3.format(rs.getDouble("mtt")) , this.nf3.format(rs.getInt("reliquat")) , sdf1.format(rs.getTimestamp("datej")) , rs.getString("user")
                    }) ;
                    
                    }
                
                this.tfc.setText("TOTAL FC : "+this.nf3.format(fc)) ;
                this.tbl.setText("TOTAL BALANCE : "+this.nf3.format(bl)) ;
                
                this.tmtt.setText("TOTAL MTT : "+this.nf3.format(mtt)) ;
                this.trl.setText("TOTAL RELIQUAT : "+this.nf3.format(rl)) ;
                
                        
                    }else if(user.isEmpty() && mode_py.isEmpty() == false){
                        
                                      
                         DefaultTableModel dtm = (DefaultTableModel) this.t_etat_ss.getModel() ;
                               dtm.setRowCount(0) ;
                             
             DefaultTableModel dtm_v = (DefaultTableModel) this.t_etat_op.getModel() ;
                               dtm_v.setRowCount(0) ;
           
         
                sql = "select * from session where etat = 'NON' and date_open between '"+dte1+"' and '"+dte2+"' order by id desc" ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    
                    fc += rs.getInt("fc") ;
                    bl += rs.getDouble("balance") ;
                   
                    
   // "ID", "DATE OPEN", "DATE CLOSE", "FOND CAISSE", "BALANCE", "USER", "POS"                   
dtm.addRow(new Object[]{
  rs.getString("id") , sdf1.format(rs.getTimestamp("date_open")) , sdf1.format(rs.getTimestamp("date_close")) , this.nf3.format(rs.getInt("fc")) , this.nf3.format(rs.getDouble("balance")) 
        , rs.getString("login") , rs.getString("pos")
                    }) ;
                    
                    }
                
   
                sql = "select * from vente_gc where datej between '"+dte1+"' and '"+dte2+"' and mode_payement = '"+mode_py+"' order by id desc" ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    
                     mtt += rs.getDouble("mtt") ;
                     rl += rs.getInt("reliquat") ;
                    
   // "ID", "CLIENT", "TOTAL", "RELIQUAT", "DATE", "USER"                
dtm_v.addRow(new Object[]{
  rs.getString("id") , rs.getString("client") , this.nf3.format(rs.getDouble("mtt")) , this.nf3.format(rs.getInt("reliquat")) , sdf1.format(rs.getTimestamp("datej")) , rs.getString("user")
                    }) ;
                    
                    }
                
                this.tfc.setText("TOTAL FC : "+this.nf3.format(fc)) ;
                this.tbl.setText("TOTAL BALANCE : "+this.nf3.format(bl)) ;
                
                this.tmtt.setText("TOTAL MTT : "+this.nf3.format(mtt)) ;
                this.trl.setText("TOTAL RELIQUAT : "+this.nf3.format(rl)) ;
                
                     
                        
                    }else if(user.isEmpty() == false && mode_py.isEmpty() == false){
                        
                            
                                      
                         DefaultTableModel dtm = (DefaultTableModel) this.t_etat_ss.getModel() ;
                               dtm.setRowCount(0) ;
                             
             DefaultTableModel dtm_v = (DefaultTableModel) this.t_etat_op.getModel() ;
                               dtm_v.setRowCount(0) ;
           
         
                sql = "select * from session where etat = 'NON' and date_open between '"+dte1+"' and '"+dte2+"' and login = '"+user+"' order by id desc" ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    
                    fc += rs.getInt("fc") ;
                    bl += rs.getDouble("balance") ;
                   
                    
   // "ID", "DATE OPEN", "DATE CLOSE", "FOND CAISSE", "BALANCE", "USER", "POS"                   
dtm.addRow(new Object[]{
  rs.getString("id") , sdf1.format(rs.getTimestamp("date_open")) , sdf1.format(rs.getTimestamp("date_close")) , this.nf3.format(rs.getInt("fc")) , this.nf3.format(rs.getDouble("balance")) 
        , rs.getString("login") , rs.getString("pos")
                    }) ;
                    
                    }
                
   
                sql = "select * from vente_gc where datej between '"+dte1+"' and '"+dte2+"' and mode_payement = '"+mode_py+"' and user = '"+user+"' order by id desc" ;
                rs = stmt.executeQuery(sql) ;
                while(rs.next()){
                    
                     mtt += rs.getDouble("mtt") ;
                     rl += rs.getInt("reliquat") ;
                    
   // "ID", "CLIENT", "TOTAL", "RELIQUAT", "DATE", "USER"                
dtm_v.addRow(new Object[]{
  rs.getString("id") , rs.getString("client") , this.nf3.format(rs.getDouble("mtt")) , this.nf3.format(rs.getInt("reliquat")) , sdf1.format(rs.getTimestamp("datej")) , rs.getString("user")
                    }) ;
                    
                    }
                
                this.tfc.setText("TOTAL FC : "+this.nf3.format(fc)) ;
                this.tbl.setText("TOTAL BALANCE : "+this.nf3.format(bl)) ;
                
                this.tmtt.setText("TOTAL MTT : "+this.nf3.format(mtt)) ;
                this.trl.setText("TOTAL RELIQUAT : "+this.nf3.format(rl)) ;
                
                     
                    // Bon_pl_v2
                        
                        
                    }else{
                         JOptionPane.showMessageDialog(this, "HYPOTHESE N'EST PAS PRIS EN CHARGE") ;
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
        
           DefaultTableModel dtm = (DefaultTableModel) this.t_etat_ss.getModel() ;
                             dtm.setRowCount(0) ;
                             
          DefaultTableModel dtm_v = (DefaultTableModel) this.t_etat_op.getModel() ;
                            dtm_v.setRowCount(0) ;
      
                this.tfc.setText("TOTAL FC : "+0) ;
                this.tbl.setText("TOTAL BALANCE : "+0) ;
                
                this.tmtt.setText("TOTAL MTT : "+0) ;
                this.trl.setText("TOTAL RELIQUAT : "+0) ;
            
            JOptionPane.showMessageDialog(this, "Saisir une date svp") ;
            
      //    JOptionPane.showMessageDialog(this, "Choisir les deux periodes svp") ;

           }
    
        
        // F :
        
        
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void c_vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_vActionPerformed
       
            // TODO add your handling code here:
    
     
                       String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
                       String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
                       String USER = "root" ;
                       String PASS = "interco" ;
                       
    // ------------------------------ BEGIN :
                       
    // connexion to DB GESCOM ...............
                       
                            
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
      Integer vy = 4 ;
      
      sql = "select copie from vente_gc where cb = "+this.code_tiket ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
       vy = rs.getInt("copie") ;
         }
      
       
if(vy == 0){
    
    
this.c_v.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;      
  
        this.bonList.removeAll(this.bonList) ;
       
       
       
             
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        SimpleDateFormat sdf_java = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
   
    sql = "select * from pannier_gc where cb = "+this.code_tiket ;
    rs = stmt.executeQuery(sql) ;
    while(rs.next()){
    
                 HashMap<String, Object> m = new HashMap<>() ;
                   
                   m.put("description", rs.getString("description")) ;
                   
                   m.put("pu", nf3.format(rs.getInt("pu"))) ;
                   
                   m.put("qte", nf3.format(rs.getDouble("qte"))) ;
                   
                   m.put("mtt", nf3.format(rs.getDouble("mtt"))) ;
                     
                              this.bonList.add(m) ;
    
                }
        
        
          
    
    
  
                      
                  try{
                
                  
   InputStream in = getClass().getClassLoader().getResourceAsStream("papier_gescom/ticket.jrxml") ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.bonList) ;
            
            Map<String, Object> para = new HashMap<>();
            
            para.put("data", jrbean);
            
            para.put("login", this.pos+"/"+this.login.substring(0, 2)) ;  // this.login
            
            
    sql = "select * from vente_gc where cb = "+this.code_tiket ;
    rs = stmt.executeQuery(sql) ;
    while(rs.next()){
        
            para.put("num", "TICKET CAISSE N° "+rs.getString("id"))  ;
            para.put("client", rs.getString("client")) ;
            para.put("total", "TOTAL : "+this.nf3.format(rs.getDouble("mtt")));
            para.put("cash", "CASH "+this.nf3.format(rs.getInt("cash")));
            para.put("monnaie", "MONNAIE "+this.nf3.format(rs.getInt("monnaie"))) ;
            para.put("mode_py", "REGLEMENT "+rs.getString("mode_payement")) ;
            para.put("datej", sdf_java.format(rs.getTimestamp("datej"))) ;
            
           }
            
        para.put("copie", "COPY") ;
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
       
       //  JasperViewer.viewReport(print, false) ;
            
            
if(stmt.executeUpdate("update vente_gc set copie = 1 where cb = "+this.code_tiket) == 1){
            
        JasperPrintManager.printReport(print, false) ;
         
        
                  }

  this.c_v.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;



                  }catch(Exception zt){
                      JOptionPane.showMessageDialog(null, zt.getMessage()) ;
                  }
                  
}else if(vy == 1){
    
    JOptionPane.showMessageDialog(null, "COPIE DEJA EDITEE") ;
    
  }else if(vy == 4){
    
    JOptionPane.showMessageDialog(null, "COPIE INDISPONIBLE") ;
      
         }




   //   JOptionPane.showMessageDialog(null, "CALL TIBICO FOR PRINTING TICKET VENTE");
     
      
    
            
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
        

                       
                       // END CONNEXION CONNEXION .............
            
                     
                       
                       
  // ------------------------------- END :
        
                       
                       
     
   
     
     
     
     
        
        
    }//GEN-LAST:event_c_vActionPerformed

    private void copie_tiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copie_tiketActionPerformed
        // TODO add your handling code here:
        
      
     
                       String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
                       String DB_URL = "jdbc:mysql://192.168.1.117:3306/gescom" ;
                       String USER = "root" ;
                       String PASS = "interco" ;
                       
    // ------------------------------ BEGIN :
                       
    // connexion to DB GESCOM ...............
                       
                            
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
      Integer vy = 4 ;
      
      sql = "select copie from vente_gc where cb = "+this.code_brr ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
       vy = rs.getInt("copie") ;
         }
      
       
if(vy == 0){
    
    
this.c_v.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;      
  
        this.bonList.removeAll(this.bonList) ;
       
       
       
             
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        SimpleDateFormat sdf_java = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
   
    sql = "select * from pannier_gc where cb = "+this.code_brr ;
    rs = stmt.executeQuery(sql) ;
    while(rs.next()){
    
                 HashMap<String, Object> m = new HashMap<>() ;
                   
                   m.put("description", rs.getString("description")) ;
                   
                   m.put("pu", nf3.format(rs.getInt("pu"))) ;
                   
                   m.put("qte", nf3.format(rs.getDouble("qte"))) ;
                   
                   m.put("mtt", nf3.format(rs.getDouble("mtt"))) ;
                     
                              this.bonList.add(m) ;
    
                }
        
        
          
    
    
  
                      
                  try{
                
                  
   InputStream in = getClass().getClassLoader().getResourceAsStream("papier_gescom/ticket.jrxml") ;
              
            
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.bonList) ;
            
            Map<String, Object> para = new HashMap<>();
            
            para.put("data", jrbean);
            
            para.put("login", this.pos+"/"+this.login.substring(0, 2)) ;  // this.login
            
            
    sql = "select * from vente_gc where cb = "+this.code_brr ;
    rs = stmt.executeQuery(sql) ;
    while(rs.next()){
        
            para.put("num", "TICKET CAISSE N° "+rs.getString("id"))  ;
            para.put("client", rs.getString("client")) ;
            para.put("total", "TOTAL : "+this.nf3.format(rs.getDouble("mtt"))+" FCFA");
            para.put("cash", "CASH "+this.nf3.format(rs.getInt("cash")));
            para.put("monnaie", "MONNAIE "+this.nf3.format(rs.getInt("monnaie"))) ;
            para.put("mode_py", "REGLEMENT "+rs.getString("mode_payement")) ;
            para.put("datej", sdf_java.format(rs.getTimestamp("datej"))) ;
            
           }
            
        para.put("copie", "COPY") ;
            
            JasperReport report = JasperCompileManager.compileReport(in);
            JasperPrint print = JasperFillManager.fillReport(report, para, new JREmptyDataSource());
       
       //  JasperViewer.viewReport(print, false) ;
            
            
if(stmt.executeUpdate("update vente_gc set copie = 1 where cb = "+this.code_brr) == 1){
            
        JasperPrintManager.printReport(print, false) ;
         
        
                  }

  this.c_v.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;



                  }catch(Exception zt){
                      JOptionPane.showMessageDialog(null, zt.getMessage()) ;
                  }
                  
}else if(vy == 1){
    
    JOptionPane.showMessageDialog(null, "COPIE DEJA EDITEE") ;
    
  }else if(vy == 4){
    
      JOptionPane.showMessageDialog(null, "COPIE INDISPONIBLE") ;
      
     }




   //   JOptionPane.showMessageDialog(null, "CALL TIBICO FOR PRINTING TICKET VENTE");
     
      
    
            
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
        

                       
                       // END CONNEXION CONNEXION .............
            
                     
                       
                       
  // ------------------------------- END :
        
                       
                       
     
   
     
     
       
        
        
        
        
    }//GEN-LAST:event_copie_tiketActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuGc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new MenuGc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton c_v;
    private javax.swing.JTextField cash;
    private javax.swing.JTextField cb1;
    private javax.swing.JTextField cb_v;
    private javax.swing.JCheckBox check1;
    private javax.swing.JCheckBox check2;
    private javax.swing.JCheckBox check3;
    private javax.swing.JCheckBox check5;
    private javax.swing.JTextField cl_v;
    private javax.swing.JButton copie_tiket;
    private javax.swing.JPanel d_s;
    private javax.swing.JTextField desc1;
    private javax.swing.JTextField desc_alt;
    private javax.swing.JTextField desc_v;
    private datechooser.beans.DateChooserCombo dte1;
    private datechooser.beans.DateChooserCombo dte2;
    private javax.swing.JFormattedTextField fc;
    private javax.swing.JComboBox fr;
    private javax.swing.JTextField id_op;
    private javax.swing.JButton init_v;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel mn_v;
    private javax.swing.JComboBox mode_py;
    private javax.swing.JButton oss;
    private javax.swing.JTextField pa;
    private javax.swing.JLabel poste;
    private javax.swing.JTextField qt_v;
    private javax.swing.JTextField qte;
    private javax.swing.JButton r_v;
    private javax.swing.JTextField rch_1;
    private javax.swing.JTextField rch_2;
    private javax.swing.JTextField rf;
    private javax.swing.JButton s_v;
    private javax.swing.JTextField st_;
    private javax.swing.JTable t_client_v;
    private javax.swing.JTable t_etat_op;
    private javax.swing.JTable t_etat_ss;
    private javax.swing.JTable t_op_s;
    private javax.swing.JTable t_op_s1;
    private javax.swing.JTable t_panier_v;
    private javax.swing.JTable t_produit_v;
    private javax.swing.JTable t_rg_cl;
    private javax.swing.JTable t_rg_pn;
    private javax.swing.JTable t_rg_py;
    private javax.swing.JLabel tbl;
    private javax.swing.JLabel tfc;
    private javax.swing.JLabel tmtt;
    private javax.swing.JLabel trl;
    private javax.swing.JComboBox user_etat;
    private javax.swing.JButton v_v;
    // End of variables declaration//GEN-END:variables
}
