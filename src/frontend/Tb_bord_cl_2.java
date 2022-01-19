/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend ;

import static frontend.Lconsult.JDBC_DRIVER;
import static frontend.ProduitFini.DB_URL;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HAMZA
 */
public class Tb_bord_cl_2 extends javax.swing.JFrame {

    /**
     * Creates new form Tb_bord_cl
     */
    
    //Mysql server pool connectio info for java :
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      static final String NAME = "TABLEAU DE BORD II" ;
      
      NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      
        List mlist = new ArrayList<>() ;
    
    
    
    String login ;
    String role ;
    ArrayList<Integer> tb_conf_rubrique = new ArrayList<Integer>() ;
    ArrayList<Integer> tb_conf_srb = new ArrayList<Integer>() ;
    ArrayList<Integer> dr_rubrique = new ArrayList<Integer>() ;
    ArrayList<Integer> dr_srb = new ArrayList<Integer>() ;
    
    
    
     
    public Tb_bord_cl_2() {
        initComponents();
        
        
        this.setLocationRelativeTo(null) ;
        
    }
    
    
    
    public Tb_bord_cl_2(String login , String role) {
        
        initComponents();
        
        this.login = login ;
        this.role = role ;
        
        
        
        
        this.setLocationRelativeTo(null) ;
        
        Calendar cal = Calendar.getInstance();
      //  cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(cal.getTime());
		
        Date dte1 = null , dte2 = null ;
             dte1 = cal.getTime() ;
             
             
       Calendar cal2 = Calendar.getInstance();
      //  cal.setTime(date);
        cal2.set(Calendar.DAY_OF_MONTH, cal2.getActualMinimum(Calendar.DAY_OF_MONTH));
        System.out.println(cal2.getTime());
	
             dte1 = cal2.getTime() ;
             dte2 = cal.getTime() ;
                
        
        this.jDateChooser1.setDate(dte1) ;
        this.h1.setText("00:00") ;
        this.jDateChooser2.setDate(dte2) ;
        this.h2.setText("23:59:59") ;
        
        
        
         if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR")){
                      
                      
                      
                  }else{
                      
                      this.conf.setEnabled(false) ;
                      
          
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
        
        
        
        
        //  ---------  2è choix
              
        
        
        
        
       //   ---------------
        
        
        //
        
       
        
     
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
        
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        dtm.addRow(new Object[]{1,1,1,1,1,1,1,1,1,1});
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm.setRowCount(0) ;
 
         this.dep.setText("") ;
         this.ret.setText("") ;
         this.et.setText("") ;
         
        
            
        
         
        this.mlist.removeAll(this.mlist) ;
        this.tb_conf_rubrique.removeAll(this.tb_conf_rubrique) ;
        this.tb_conf_srb.removeAll(this.tb_conf_srb) ;
        this.dr_rubrique.removeAll(this.dr_rubrique) ;
        this.dr_srb.removeAll(this.dr_srb) ;
        
        
        try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte11 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte22 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ; 
            
       
            Connection conn = null;
            Statement stmt = null;
            PreparedStatement pst = null ;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
               
                 
                 String srb = "" ;
                 long td = 0 ;
                 long tr = 0 ;
                 long dep = 0 ;
                 long ret = 0 ;
                 
                 
                 String srb_d = "" ;
                 String srb_r = "" ;
                 
                 
                  
                                   dtm.setRowCount(0) ;
                  
                 
      String sql = null ;
      ResultSet rs = null ;
      
      sql = "select * from conf_tb where tb_name = '"+this.NAME+"'" ;
      rs = stmt.executeQuery(sql) ;
      
      while(rs.next()){
          this.tb_conf_rubrique.add(rs.getInt("id_rubrique")) ;
          this.tb_conf_srb.add(rs.getInt("id_srub")) ;
          
          
      }
      
      
      sql = "select id_rubrique,id_srub,tb_name, groupe , rub , sousrub.srb as srb , sum(mtt) as mtt , depot_retrait.type as nature from "
              + "depot_retrait , conf_tb , rubrique , sousrub "
              + "where tb_name = ? and  depot_retrait.dtec between ? and ? and depot_retrait.rubrique = id_rubrique "
              + "and depot_retrait.srb = id_srub and (depot_retrait.type = 'DEPOT' or depot_retrait.type = 'RETRAIT') and rubrique.id = depot_retrait.rubrique and "
              + "sousrub.id_srb = depot_retrait.srb group by groupe ,rub , srb , nature order by groupe asc , rub asc ,srb asc, nature asc" ;
      
      
      
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, this.NAME) ;
      pst.setString(2, dte11);
      pst.setString(3, dte22) ;
      
      
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if(rs.getString("nature").equalsIgnoreCase("DEPOT")){
              srb = rs.getString("srb") ;
              dep = rs.getLong("mtt") ;
              td += rs.getLong("mtt") ;
              
              HashMap<String, Object> m = new HashMap<>() ;
              
              /*
              report fields list order :
               1- groupe str
               2- rub    str
               3- srb    str
               4- mtt    str
               5- nature str
               6- dep    str
               7- ret    str
               8- et     str
              */
              
             
                 m.put("groupe", rs.getString("groupe")) ;
                 m.put("rub", rs.getString("rub")) ;
                 m.put("srb", rs.getString("srb")) ;
                 m.put("mtt", rs.getLong("mtt")) ;
                 m.put("nature", rs.getString("nature")) ;
                 
                     
                 m.put("dep", dep) ;
                 m.put("ret", ret) ;
                 m.put("et", (dep - ret)) ;
                        
              
                 this.mlist.add(m) ;
               
              
              
              
                dtm.addRow(new Object[]{ 
               srb , this.nf3.format(dep) , this.nf3.format(ret) , this.nf3.format(dep - ret)
                        
               }) ;
                
               
                srb_d = rs.getString("srb") ;
              
          }else if(rs.getString("nature").equalsIgnoreCase("RETRAIT")){
              
               srb = rs.getString("srb") ;
               ret = rs.getLong("mtt") ;
               tr += rs.getLong("mtt") ;
               
               
                HashMap<String, Object> m = new HashMap<>() ;
                
                 m.put("groupe", rs.getString("groupe")) ;
                 m.put("rub", rs.getString("rub")) ;
                 m.put("srb", rs.getString("srb")) ;
                 m.put("mtt", rs.getLong("mtt")) ;
                 m.put("nature", rs.getString("nature")) ;
                 
                 m.put("dep", dep) ;
                 m.put("ret", ret) ;
                 m.put("et", (dep - ret)) ;
              
                 this.mlist.add(m) ;
               
                
                
               
               dtm.addRow(new Object[]{ 
               srb , this.nf3.format(dep) , this.nf3.format(ret) , this.nf3.format(dep - ret)
               });
               
        
                srb_r = rs.getString("srb") ;
                
                dep = 0 ;
                ret = 0 ;
                
              
              
          }

          
          if(srb_r.equalsIgnoreCase(srb_d)){
          
           dtm.removeRow(dtm.getRowCount() - 2);
           this.mlist.remove(dtm.getRowCount() - 1) ;
           
           srb_d = "" ; srb_r = "" ;
          
          }
          
          this.dr_rubrique.add(rs.getInt("id_rubrique")) ;
          this.dr_srb.add(rs.getInt("id_srub")) ;
          
          

      }
      
      
     for(int i = 0 ; i < this.tb_conf_rubrique.size() ; i++){
         if(this.dr_rubrique.contains(this.tb_conf_rubrique.get(i).intValue())){
             
             if(this.dr_srb.contains(this.tb_conf_srb.get(i).intValue())){
                 
             }else{
                 
                 sql = "select groupe , rub , srb from rubrique , sousrub where id = "+this.tb_conf_rubrique.get(i).intValue()+" "
                         + "and id_srb = "+this.tb_conf_srb.get(i).intValue() ;
                 
                 rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                     
                     /*
                     
               HashMap<String, Object> m = new HashMap<>() ;
                
                 m.put("groupe", rs.getString("groupe")+" (VIDE)") ;
                 m.put("rub", rs.getString("rub")) ;
                 m.put("srb", rs.getString("srb")) ;
                 m.put("mtt", 0) ;
                 m.put("nature", "VIDE" ) ;
                 
                 m.put("dep",(long) 0) ;
                 m.put("ret",(long) 0) ;
                 m.put("et", (long) 0) ;
              
                 this.mlist.add(m) ;
               */
                
                
               
               dtm.addRow(new Object[]{ 
               rs.getString("srb") , 0 , 0 , 0
                       
               }) ;
               
                     
                 }
                 
                 
             }
             
         }else{
             
             sql = "select groupe , rub , srb from rubrique , sousrub where id = "+this.tb_conf_rubrique.get(i).intValue()+" "
                         + "and id_srb = "+this.tb_conf_srb.get(i).intValue() ;
                 
                 rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                     
                     /*
               HashMap<String, Object> m = new HashMap<>() ;
                
                 m.put("groupe", rs.getString("groupe")+" (VIDE)") ;
                 m.put("rub", rs.getString("rub")) ;
                 m.put("srb", rs.getString("srb")) ;
                 m.put("mtt", 0) ;
                 m.put("nature", "VIDE" ) ;
                 
                 m.put("dep", (long) 0) ;
                 m.put("ret", (long) 0) ;
                 m.put("et", (long) 0) ;
              
                 this.mlist.add(m) ;
               
                */
                
               
               dtm.addRow(new Object[]{ 
               rs.getString("srb") , 0 , 0 , 0
                       
               }) ;
               
                     
                 }
                 
                 
             
         }
     }
      
     
      this.dep.setText(this.nf3.format(td)); this.ret.setText(this.nf3.format(tr));
      long et = (td - tr) ; 
      this.et.setText(this.nf3.format(et)) ;
    
      
      
      rs.close() ;
      stmt.close() ;
      pst.close() ;
      conn.close() ;
     
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
        
             
                
                  dtm.setRowCount(0) ;
             
            JOptionPane.showMessageDialog(null, "SELECTIONNER LES DEUX DATES SVP") ;
            
            
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

        jPanel1 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        h1 = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        h2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        imprimer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        conf = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        dep = new javax.swing.JTextField();
        ret = new javax.swing.JTextField();
        et = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TABLEAU DE BORD COMPTE LIBRE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        h1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h1ActionPerformed(evt);
            }
        });

        h2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                h2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("RECHERCHER");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        imprimer.setBackground(new java.awt.Color(51, 51, 255));
        imprimer.setForeground(new java.awt.Color(255, 255, 255));
        imprimer.setText("IMPRIMER");
        imprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimerActionPerformed(evt);
            }
        });

        jLabel1.setText("DU");

        jLabel2.setText("AU");

        jLabel3.setText("HEURE");

        jLabel4.setText("HEURE");

        conf.setBackground(new java.awt.Color(51, 51, 255));
        conf.setForeground(new java.awt.Color(255, 255, 255));
        conf.setText("CONFIGURATION");
        conf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SOUS-RUBRIQUE", "DEPOT", "RETRAIT", "ETAT(D-R)"
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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(400);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(400);
        }

        dep.setEditable(false);
        dep.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        dep.setText("4.000.000.000");

        ret.setEditable(false);
        ret.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ret.setText("4.000.000.000");

        et.setEditable(false);
        et.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        et.setText("4.000.000.000");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("DEPOT");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("RETRAIT");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("ETAT ( D- R )");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(6, 6, 6))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40))
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(80, 80, 80)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(167, 167, 167)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(conf, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imprimer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(et, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ret, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(2, 2, 2)
                                .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(2, 2, 2)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(conf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ret, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(imprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(et))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void h1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_h1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_h1ActionPerformed

    private void h2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_h2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_h2ActionPerformed

    private void confActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confActionPerformed
        // TODO add your handling code here:
        
        Choix_tb ch = new Choix_tb(this.NAME) ;
                 ch.setVisible(true) ;
                 
        
    }//GEN-LAST:event_confActionPerformed

    private void imprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimerActionPerformed
        // TODO add your handling code here:
        
        
        // jasper rporting printer :  
        
        
          this.imprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        
       try{
           
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ;
        
        
        
           
           InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\tableau_bord.jrxml")) ;
           
          
           
              JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(this.mlist) ;
           
         
           Map<String, Object> para = new HashMap<>();
           
         // para.put("data", jrbean);
            para.put("tb_name", "PREMIUM") ;  // this.login
                                // SECONDAIRE
                               //  TERTIAIRE
            para.put("periode","LA PERIODE : DU "+dte1+"   AU : "+dte2) ;
            para.put("dep", this.dep.getText()) ;
            para.put("ret", this.ret.getText()) ;
            para.put("et", this.et.getText()) ;
           
            JasperReport report = JasperCompileManager.compileReport(in) ;
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print, false);
          
        
           
           
           
       }catch(Exception e){
       
           JOptionPane.showMessageDialog(null, e) ;
           System.out.println(e) ;
       
       }
        
       this.imprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
        
        
    }//GEN-LAST:event_imprimerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        this.mlist.removeAll(this.mlist) ;
        this.tb_conf_rubrique.removeAll(this.tb_conf_rubrique) ;
        this.tb_conf_srb.removeAll(this.tb_conf_srb) ;
        this.dr_rubrique.removeAll(this.dr_rubrique) ;
        this.dr_srb.removeAll(this.dr_srb) ;
        
        
        try{
             
         SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
       
        String dte1 = sdf.format(this.jDateChooser1.getDate())+" "+this.h1.getText() ;
        String dte2 = sdf.format(this.jDateChooser2.getDate())+" "+this.h2.getText() ; 
            
       
            Connection conn = null;
            Statement stmt = null;
            PreparedStatement pst = null ;
       
       try{
      Class.forName(JDBC_DRIVER); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement();
      
               
                 
                 String srb = "" ;
                 long td = 0 ;
                 long tr = 0 ;
                 long dep = 0 ;
                 long ret = 0 ;
                 
                 
                 String srb_d = "" ;
                 String srb_r = "" ;
                 
                 
                 DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                                   dtm.setRowCount(0) ;
                  
                 
      String sql = null ;
      ResultSet rs = null ;
      
      sql = "select * from conf_tb where tb_name = '"+this.NAME+"'" ;
      rs = stmt.executeQuery(sql) ;
      
      while(rs.next()){
          this.tb_conf_rubrique.add(rs.getInt("id_rubrique")) ;
          this.tb_conf_srb.add(rs.getInt("id_srub")) ;
          
          
      }
      
      
      sql = "select id_rubrique,id_srub,tb_name, groupe , rub , sousrub.srb as srb , sum(mtt) as mtt , depot_retrait.type as nature from "
              + "depot_retrait , conf_tb , rubrique , sousrub "
              + "where tb_name = ? and  depot_retrait.dtec between ? and ? and depot_retrait.rubrique = id_rubrique "
              + "and depot_retrait.srb = id_srub and (depot_retrait.type = 'DEPOT' or depot_retrait.type = 'RETRAIT') and rubrique.id = depot_retrait.rubrique and "
              + "sousrub.id_srb = depot_retrait.srb group by groupe ,rub , srb , nature order by groupe asc , rub asc ,srb asc, nature asc" ;
      
      
      
      pst = conn.prepareStatement(sql) ;
      pst.setString(1, this.NAME) ;
      pst.setString(2, dte1);
      pst.setString(3, dte2) ;
      
      
      
      rs = pst.executeQuery() ;
      
      while(rs.next()){
          
          if(rs.getString("nature").equalsIgnoreCase("DEPOT")){
              srb = rs.getString("srb") ;
              dep = rs.getLong("mtt") ;
              td += rs.getLong("mtt") ;
              
              HashMap<String, Object> m = new HashMap<>() ;
              
              /*
              report fields list order :
               1- groupe str
               2- rub    str
               3- srb    str
               4- mtt    str
               5- nature str
               6- dep    str
               7- ret    str
               8- et     str
              */
              
             
                 m.put("groupe", rs.getString("groupe")) ;
                 m.put("rub", rs.getString("rub")) ;
                 m.put("srb", rs.getString("srb")) ;
                 m.put("mtt", rs.getLong("mtt")) ;
                 m.put("nature", rs.getString("nature")) ;
                 
                     
                 m.put("dep", dep) ;
                 m.put("ret", ret) ;
                 m.put("et", (dep - ret)) ;
                        
              
                 this.mlist.add(m) ;
               
              
              
              
                dtm.addRow(new Object[]{ 
               srb , this.nf3.format(dep) , this.nf3.format(ret) , this.nf3.format(dep - ret)
                        
               }) ;
                
               
                srb_d = rs.getString("srb") ;
              
          }else if(rs.getString("nature").equalsIgnoreCase("RETRAIT")){
              
               srb = rs.getString("srb") ;
               ret = rs.getLong("mtt") ;
               tr += rs.getLong("mtt") ;
               
               
                HashMap<String, Object> m = new HashMap<>() ;
                
                 m.put("groupe", rs.getString("groupe")) ;
                 m.put("rub", rs.getString("rub")) ;
                 m.put("srb", rs.getString("srb")) ;
                 m.put("mtt", rs.getLong("mtt")) ;
                 m.put("nature", rs.getString("nature")) ;
                 
                 m.put("dep", dep) ;
                 m.put("ret", ret) ;
                 m.put("et", (dep - ret)) ;
              
                 this.mlist.add(m) ;
               
                
                
               
               dtm.addRow(new Object[]{ 
               srb , this.nf3.format(dep) , this.nf3.format(ret) , this.nf3.format(dep - ret)
               });
               
        
                srb_r = rs.getString("srb") ;
                
                dep = 0 ;
                ret = 0 ;
                
              
              
          }

          
          if(srb_r.equalsIgnoreCase(srb_d)){
          
           dtm.removeRow(dtm.getRowCount() - 2);
           this.mlist.remove(dtm.getRowCount() - 1) ;
           
           srb_d = "" ; srb_r = "" ;
          
          }
          
          this.dr_rubrique.add(rs.getInt("id_rubrique")) ;
          this.dr_srb.add(rs.getInt("id_srub")) ;
          
          

      }
      
      
     for(int i = 0 ; i < this.tb_conf_rubrique.size() ; i++){
         if(this.dr_rubrique.contains(this.tb_conf_rubrique.get(i).intValue())){
             
             if(this.dr_srb.contains(this.tb_conf_srb.get(i).intValue())){
                 
             }else{
                 
                 sql = "select groupe , rub , srb from rubrique , sousrub where id = "+this.tb_conf_rubrique.get(i).intValue()+" "
                         + "and id_srb = "+this.tb_conf_srb.get(i).intValue() ;
                 
                 rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                     /*
               HashMap<String, Object> m = new HashMap<>() ;
                
                 m.put("groupe", rs.getString("groupe")+" (VIDE)") ;
                 m.put("rub", rs.getString("rub")) ;
                 m.put("srb", rs.getString("srb")) ;
                 m.put("mtt", 0) ;
                 m.put("nature", "VIDE" ) ;
                 
                 m.put("dep",(long) 0) ;
                 m.put("ret",(long) 0) ;
                 m.put("et", (long) 0) ;
              
                 this.mlist.add(m) ;
               */
                
                
               
               dtm.addRow(new Object[]{ 
               rs.getString("srb") , 0 , 0 , 0
                       
               }) ;
               
                     
                 }
                 
                 
             }
             
         }else{
             
             sql = "select groupe , rub , srb from rubrique , sousrub where id = "+this.tb_conf_rubrique.get(i).intValue()+" "
                         + "and id_srb = "+this.tb_conf_srb.get(i).intValue() ;
                 
                 rs = stmt.executeQuery(sql) ;
                 
                 while(rs.next()){
                     
                     /*
               HashMap<String, Object> m = new HashMap<>() ;
                
                 m.put("groupe", rs.getString("groupe")+" (VIDE)") ;
                 m.put("rub", rs.getString("rub")) ;
                 m.put("srb", rs.getString("srb")) ;
                 m.put("mtt", 0) ;
                 m.put("nature", "VIDE" ) ;
                 
                 m.put("dep", (long) 0) ;
                 m.put("ret", (long) 0) ;
                 m.put("et", (long) 0) ;
              
                 this.mlist.add(m) ;
               
                */
                
               
               dtm.addRow(new Object[]{ 
               rs.getString("srb") , 0 , 0 , 0
                       
               }) ;
               
                     
                 }
                 
                 
             
         }
     }
      
     
      this.dep.setText(this.nf3.format(td)); this.ret.setText(this.nf3.format(tr));
      long et = (td - tr) ; 
      this.et.setText(this.nf3.format(et)) ;
    
      
      
      rs.close() ;
      stmt.close() ;
      pst.close() ;
      conn.close() ;
     
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
        
             
                  DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
                  dtm.setRowCount(0) ;
             
            JOptionPane.showMessageDialog(null, "SELECTIONNER LES DEUX DATES SVP") ;
            
            
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Tb_bord_cl_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tb_bord_cl_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tb_bord_cl_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tb_bord_cl_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tb_bord_cl_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton conf;
    private javax.swing.JTextField dep;
    private javax.swing.JTextField et;
    private javax.swing.JTextField h1;
    private javax.swing.JTextField h2;
    private javax.swing.JButton imprimer;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField ret;
    // End of variables declaration//GEN-END:variables
}
