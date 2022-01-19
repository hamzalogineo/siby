/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import allCollection.ListCommande;
import com.github.royken.converter.FrenchNumberToWords;
import static frontend.ConsultModelGateau.JDBC_DRIVER;
import static frontend.NewProd.JDBC_DRIVER;
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
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HAMZA
 */
public class Nouvelle_commande1 extends javax.swing.JFrame {

    /**
     * Creates new form Nouvelle_commande
     */
    
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      String login ;
      String date ;
      private String mode_payement = "" ;
      private static Integer caution = 0 ;
      
      private static ArrayList<ListCommande> commande = new ArrayList<ListCommande>() ;
      private static NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK")) ;
      private static Integer montant = 0 ;
      
    public Nouvelle_commande1() {
        initComponents();
        this.setLocationRelativeTo(null) ;
        this.setTitle("NOUVELLE COMMANDE") ;
    }


    public Nouvelle_commande1(String login) {
        initComponents();
        this.setLocationRelativeTo(null) ;
        this.setTitle("NOUVELLE COMMANDE") ;
        
        this.login = login ;
        this.jLabel14.setText("OP : "+this.login) ;
        
        commande.removeAll(commande) ;
        montant = 0 ;
        caution = 0 ;
        
        
        // JOptionPane.showMessageDialog(null, FrenchNumberToWords.convert(300));
        
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
        
       
        
     
        
        DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
        
        
        
       //  JOptionPane.showMessageDialog(null, new JScrollPane(this.jTable1));
        
        dtm1.setRowCount(0) ;
        
       
this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 4) ;
        
         
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
         
        if("gs".equalsIgnoreCase(status)) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }else if("model".equalsIgnoreCase(status)){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
            
            /*
            setBackground(Color.gray);
            setForeground(Color.WHITE);
            */
            
        } 
        
   
        
        
        if(isSelected){
            
            setBackground(Color.gray);
            setForeground(Color.WHITE);
        }
            
          
        return this;
        
    }   
});

   
   
        
        
                                   Connection conn = null ;
                                   Statement stmt = null ;

        try{

            // STEP 2: Register JDBC driver :
            Class.forName(JDBC_DRIVER) ;

            //STEP 3: Open a connection
            // System.out.println("Connecting to database...");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 4: Execute a query
            // System.out.println("Creating statement...") ;

            stmt = conn.createStatement() ;

            // je crai ma requete

            String sql = null ;
            ResultSet rs = null ;
            
          

            sql =  "select * from g_gateau where type = 'oui' order by description asc" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){

               this.jComboBox1.addItem(rs.getString("description")) ;

            }
            
            /*
            
            sql = "select "
                 +"detail_commande_client.id as ref, detail_commande_client.description as produit , "
                 +"detail_commande_client.dimension as dim , detail_commande_client.prx as prix , "
                 +"model_gt.id as ident , model_gt.cb as code, detail_model_gt.description as descript , "
                 +"detail_model_gt.dimension as dime , detail_model_gt.prx as cout "
                    + "from detail_commande_client , model_gt,detail_model_gt where "
                    + "detail_commande_client.description = model_gt.description and detail_model_gt.cb = model_gt.cb" ;
            
             rs = stmt.executeQuery(sql) ;

            while(rs.next()){

              System.out.println("id : "+rs.getString("ref")+" description : "+rs.getString("produit")+" "
                      + "dimension : "+rs.getString("dime")+" prix : "+rs.getString("cout")+" decript : "+rs.getString("descript"));

            }
            
            */
            
            

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
                   
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
        this.date = sdf.format(new Date()) ;
        this.jLabel1.setText("BAMAKO LE , "+this.date) ;
        
        
        
        
        
    }

    
    public static void laodTable1(ArrayList<ListCommande> e){
        
        commande.addAll(e) ;
        
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
        /*
        
        Integer devis = 0 ;
                devis = Integer.parseInt(dev.getText().replaceAll("[^a-zA-Z0-9]", "")) ;
           
        */  
        
        
        for(int i = 0 ; i < e.size(); i++){
                    
            dtm.addRow(new Object[]{
e.get(i).getDescription().toUpperCase(),e.get(i).getDimension().toUpperCase(),nf3.format(e.get(i).getPrx()),e.get(i).getObservation().toUpperCase() , 
e.get(i).getCl() , e.get(i).getCb()
            }) ;
            
        }
        
       // dev.setText(nf3.format(devis)) ;
        
        // paramtes :
        
        for(int i = 0 ; i < commande.size() ; i++){
            
            System.out.println("desc : "+commande.get(i).getDescription()+" , Dimension : "+commande.get(i).getDimension()+" , "
                    + "prx : "+commande.get(i).getPrx()+" , Observation : "+commande.get(i).getObservation());
            
            
        }
        
        System.out.println("New size for my commande : "+commande.size()) ;
        
       // paramtes () end :
        
        
        if(commande.size() > 0){
             
                       cm.setSelected(false); rd.setSelected(false); rd.setEnabled(true);
                       cm.setEnabled(true);  moule.setText("") ; moule.setEditable(false) ;
                       rp.setSelected(false) ;
                       rp.setEnabled(true) ;
                       av.setText(""); av.setEditable(false);
                       ri.setSelected(false); ri.setEnabled(true);
                 
        }
        
        
    }
    
    
    public static void setMtt(Integer mtt){
        
        caution = mtt ;
        dev.setText(nf3.format(mtt)) ;
        
    }
    
    public static Integer getMtt(){
        return montant ;
    }
    
    public static String getDevis(){
        return dev.getText().replaceAll("[^a-zA-Z0-9]", "") ;
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cm = new javax.swing.JCheckBox();
        moule = new javax.swing.JTextField();
        ri = new javax.swing.JCheckBox();
        rp = new javax.swing.JCheckBox();
        av = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        observ = new javax.swing.JTextField();
        vc = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        client = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        adresse = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rdv = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        ecriture = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        h = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        t1 = new javax.swing.JFormattedTextField();
        t2 = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        dev = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        mr = new javax.swing.JTextField();
        rl = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        rd = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOUVELLE COMMANDE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("GATEAU STANDARD");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("GATEAU COMPLEXE");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cm.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cm.setText("CONSIGNATION MOULE");
        cm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmMouseReleased(evt);
            }
        });

        moule.setEditable(false);
        moule.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mouleKeyReleased(evt);
            }
        });

        ri.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ri.setText("REGLEMENT INTEGRAL");
        ri.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                riMouseReleased(evt);
            }
        });

        rp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rp.setText("REGLEMENT PARTIEL ");
        rp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rpMouseReleased(evt);
            }
        });

        av.setEditable(false);
        av.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                avKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("OBSERVATION/");

        vc.setBackground(new java.awt.Color(0, 0, 255));
        vc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        vc.setForeground(new java.awt.Color(255, 255, 255));
        vc.setText("VALIDER COMMANDE");
        vc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vcActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFO CLIENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("NOM & PRENOM :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("TEL 1 :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("TEL 2 :");

        jLabel5.setText("*");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("ADRESSE :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("RDV ( D & H)");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("ECRITURE SUR LE GATEAU :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("BAMAKO LE , 15/07/2020 11:00:00");

        try {
            h.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("login");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOISIR" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("              FORMAT  GATEAU");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        try {
            t1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            t2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(ecriture, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdv, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(adresse)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(t1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(254, 254, 254))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(4, 4, 4)
                .addComponent(jLabel5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(rdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ecriture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel14)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PANIER DU CLIENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "DESCRIPTION GATEAU / OPTION", "DIMENSION", "PRIX", "OBSERVATION", "CL", "CB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setMinWidth(260);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(260);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(260);
            jTable1.getColumnModel().getColumn(1).setMinWidth(80);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(2).setMinWidth(90);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(90);
            jTable1.getColumnModel().getColumn(4).setMinWidth(0);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(5).setMinWidth(0);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        jLabel11.setText("DEVIS AUTO ");

        dev.setEditable(false);
        dev.setText("0");

        jLabel12.setText(" MONTANT REGLER ");

        mr.setEditable(false);
        mr.setText("0");

        rl.setEditable(false);
        rl.setText("0");

        jLabel13.setText(" ETAT (DEVIS - REGLER)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dev, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mr, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rl, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jButton3.setBackground(new java.awt.Color(0, 0, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("RETIRER DU PANIER");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        rd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rd.setText("REGLEMENT AU RDV");
        rd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rdMouseReleased(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 102, 51));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("COULEUR :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(201, 201, 201)
                                            .addComponent(av, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(cm, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(moule, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(26, 26, 26)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rd, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ri)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vc, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(observ, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rp, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd)
                    .addComponent(cm)
                    .addComponent(moule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rp)
                    .addComponent(av, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ri))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(observ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vc, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Model_gateau mg = new Model_gateau(this.login) ;
                     mg.setVisible(true) ;
                     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
         CommandeGateauComplexe mg = new CommandeGateauComplexe() ;
                     mg.setVisible(true) ;
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmMouseReleased
        // TODO add your handling code here:
        
        if(this.cm.isSelected()){
            this.moule.setEditable(true);
        }else if(this.cm.isSelected() == false){
            this.moule.setText("") ;
            this.moule.setEditable(false) ;
        }
        
        
    }//GEN-LAST:event_cmMouseReleased

    private void rpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rpMouseReleased
        // TODO add your handling code here:
        
        if(this.rp.isSelected()){
            
            this.mode_payement = "PARTIEL" ;
            
            this.av.setEditable(true) ;
            this.ri.setSelected(false) ;
            this.rd.setSelected(false) ; 
            
        this.mr.setText("0") ;
        this.rl.setText(dev.getText()) ;
            
        }else if(this.rp.isSelected() == false){
            
            this.av.setText("") ;
            this.av.setEditable(false) ;
            
            this.mr.setText("0") ;
            this.rl.setText("0") ;
            this.mode_payement = "" ;
            
        }
          
        
        
        
    }//GEN-LAST:event_rpMouseReleased

    private void riMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_riMouseReleased
        // TODO add your handling code here:

        if(this.ri.isSelected() == true){
        
        this.mode_payement = "INTEGRAL" ;
        this.rp.setSelected(false) ;
        this.rd.setSelected(false);
        this.av.setText("") ;
        this.av.setEditable(false) ;
        
        this.mr.setText(dev.getText()) ;
        this.rl.setText("0") ;
        
        }else{
        
            this.mode_payement = "" ;
            this.mr.setText("0") ;
            this.rl.setText("0") ;
        
        }
        
    }//GEN-LAST:event_riMouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        if(jTable1.getSelectedRow() == -1 || this.prx == 0){
            JOptionPane.showMessageDialog(null,"CHOISIR DANS LE PANIER DU CLIENT ET LES OPTIONS NE PEUVENT PAS ETRE RETIRER") ;
        }else{
            
            commande.remove(jTable1.getSelectedRow()) ;
            
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                              dtm.setRowCount(0) ;
                              
                              for(int i = 0; i < commande.size(); i++){

                                  dtm.addRow(new Object[]{
commande.get(i).getDescription().toUpperCase(),commande.get(i).getDimension().toUpperCase(),commande.get(i).getPrx(),commande.get(i).getObservation().toUpperCase() , 
commande.get(i).getCl() , commande.get(i).getCb()
                                  }) ;
                                  
                              }
                              
                              
            String m1 = Nouvelle_commande1.getDevis() ;
            Integer mtt1 = Integer.parseInt(m1) ;
            Integer mtt2 = this.prx ;
            
            
            Integer total = (mtt1 - mtt2) ;
            
            Nouvelle_commande1.setMtt(total); 
            
            Integer mr = 0 ;
                    mr = Integer.parseInt(this.mr.getText().replaceAll("[^a-zA-Z0-9]", "")) ;
                    
                    Integer rl = (total - mr) ;
            
                   this.rl.setText(nf3.format(rl)) ;
                   
                   if(commande.size() == 0){
                       
                       this.cm.setSelected(false); this.rd.setSelected(false); this.rd.setEnabled(false);
                       this.cm.setEnabled(false);this.moule.setText("") ; this.moule.setEditable(false) ;
                       this.rp.setSelected(false) ;
                       this.rp.setEnabled(false) ;
                       this.av.setText(""); this.av.setEditable(false);
                       this.ri.setSelected(false); this.ri.setEnabled(false);
                       
                       dev.setText("0"); this.mr.setText("0") ; this.rl.setText("0");
                       
                   }
                    
            
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed
Integer prx = 0 ;
String cl ;

Integer cb_model ;

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
this.prx = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString().replaceAll("[^a-zA-Z0-9]", "")) ;
this.cl = "" ;

this.cl = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString() ;
this.cb_model = 0 ;

this.cb_model = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString()) ;


if(this.cb_model == Integer.parseInt("0")){
    
}else{
    
    Detail_Panier_Gt dpc = new Detail_Panier_Gt(this.cb_model) ;
                     dpc.setVisible(true);
    
    }
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void avKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_avKeyReleased
        // TODO add your handling code here:
        
        try{
        String av = "" ;
               av = this.av.getText().trim() ;
       Integer mtt = Integer.parseInt(av) ;
       
       this.mr.setText(nf3.format(mtt)) ;
       
       int rl = 0 ;
           rl = (Integer.parseInt(dev.getText().replaceAll("[^a-zA-Z0-9]", "")) - mtt) ;
           
           this.rl.setText(nf3.format(rl)) ;
           
           
       
       
        }catch(Exception e){
            this.mr.setText("0") ;
            this.rl.setText("0") ;
           // JOptionPane.showMessageDialog(null, e.getMessage()) ;
        }
       
       
        
        
    }//GEN-LAST:event_avKeyReleased

    private void vcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vcActionPerformed
        // TODO add your handling code here:
        
        // for tibico : uuid="34a2ae4b-4055-476b-8676-d499f6af510b"
        
        
        SimpleDateFormat myf = new SimpleDateFormat("dd-MM-yyyy") ;
        
        this.vc.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
         try{
             
             // collection des donnee pour save cmd client :
             
        // SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;     
             
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault()) ;
        SimpleDateFormat sdf_ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        
        SimpleDateFormat sdf_1 = new SimpleDateFormat("yyyy-MM-dd") ;
        
        
        Date aujourdui = sdf_1.parse(sdf_1.format(new Date())) ;
        Date rdv_v = sdf.parse(sdf.format(this.rdv.getDate())) ;
        
        
         SimpleDateFormat sdf_jour = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
       
    //  String dte1 = sdf.format(this.rdv.getDate()) ;
        
        
        String client , t1 , t2 , adresse , rdv , ecriture , g_gt , jour , moule , observ ;
        Integer devis , mr , rl ;
        String rdv_ = "" ;
        String heure ;
               heure = this.h.getText() ;
             //  JOptionPane.showMessageDialog(null, heure);
        
               client = this.client.getText().trim().replaceAll("'", "''") ;
               t1 = this.t1.getText() ;
               t2 = this.t2.getText() ;
               adresse = this.adresse.getText().trim().replaceAll("'", "''") ;
               rdv = sdf.format(this.rdv.getDate())+" "+heure ;
               rdv_ = myf.format(this.rdv.getDate())+" "+heure ;
               ecriture = this.ecriture.getText().trim().replaceAll("'", "''") ;
               g_gt = this.jComboBox1.getSelectedItem().toString().replaceAll("'", "''") ;
               jour = sdf_.format(new Date()) ;
               
               devis = Integer.parseInt(dev.getText().replaceAll("[^a-zA-Z0-9]", "")) ;
               mr = Integer.parseInt(this.mr.getText().replaceAll("[^a-zA-Z0-9]", "")) ;
               rl = Integer.parseInt(this.rl.getText().replaceAll("[^a-zA-Z0-9]", "")) ;
               
               moule = this.moule.getText().trim().replaceAll("'", "''") ;
               if(moule.isEmpty()){
                   moule = "0" ;
               }
               observ = this.observ.getText().trim().replaceAll("'", "''") ;
               String etat = "OUI" ;
               
               Integer cb ;
               
               Random rx = new Random() ;
               cb = rx.nextInt() ;
               
               if(cb < 0){
                   cb = Math.abs(cb) ;
               }
               
        
        
        // end collection
       // mr == 0        
               
               if(client.isEmpty() || t1.isEmpty() || adresse.isEmpty() || ecriture.isEmpty() || rdv.isEmpty() || g_gt.isEmpty() || commande.size() == 0 || this.mode_payement.isEmpty() || observ.isEmpty() || "  :  :  ".equalsIgnoreCase(heure) || Integer.parseInt(this.rl.getText().replaceAll("[^a-zA-Z0-9]", "")) < 0 || "CHOISIR".equalsIgnoreCase(this.jComboBox1.getSelectedItem().toString())){
                  JOptionPane.showMessageDialog(null, "PARAMETTRE INCORRECT POUR LA COMMANDE") ;
               }else{
                   
                   if(rdv_v.compareTo(aujourdui) >= 0){
                   
                   if(this.rp.isSelected() && mr == 0){
                       
                       JOptionPane.showMessageDialog(null, "UNE AVANCE EST OBLIGATOIRE POUR UN REGLEMENT PARTIEL") ;
                       
                   }else{
                   
                   
                   // Mysql serveur saving our commande :
                   
                       Connection conn = null ;
                       Statement stmt = null ;
                   //    Statement stmt_2 = null ;

        try{

            // STEP 2: Register JDBC driver :
            Class.forName(JDBC_DRIVER) ;

            //STEP 3: Open a connection
            // System.out.println("Connecting to database...");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // STEP 4: Execute a query
            // System.out.println("Creating statement...") ;

            stmt   = conn.createStatement() ;
      //      stmt_2 = conn.createStatement() ;

            // je crai ma requete

    stmt.executeUpdate("insert into commande_client(client,t1,t2,adresse,rdv,ecriture,g_gt,login,jour,devis,mr,rl,moule,observation,etat,motif,cb,mode_payement) "
 +"values('"+client+"' , '"+t1+"' , '"+t2+"' , '"+adresse+"' , '"+rdv+"' , '"+ecriture+"' , '"+g_gt+"' , '"
 +login+"' , '"+jour+"' , "+devis+" , "+mr+" , "+rl+" , '"+moule+"' , '"+observ+"' , '"
 +etat+"' , '"+new String("")+"' , "+cb+" , '"+this.mode_payement+"')") ;

    for(int i = 0 ; i < commande.size() ; i++){
        
        stmt.executeUpdate("insert into detail_commande_client(description,dimension,prx,observation,cb,cb_model,couleur) values('"
        +commande.get(i).getDescription().replaceAll("'", "''").toUpperCase()+"' , '"+commande.get(i).getDimension()+"' , "
        +commande.get(i).getPrx()+" , '"+commande.get(i).getObservation().replaceAll("'", "''").toUpperCase()+"' , "
        +cb+" , "+commande.get(i).getCb()+" , '"+commande.get(i).getCl()+"')") ;
        
             }
            
            
               
                   // END SAVING :
        
     //   JOptionPane.showMessageDialog(null, "COMMANDE PRISE AVEC SUCCES");
    
    
    // d :
    
    SimpleDateFormat sdf_10 = new SimpleDateFormat("yyyy-MM-dd") ;
            Calendar calendar = Calendar.getInstance() ;
            Date today_ = calendar.getTime() ;
            calendar.add(Calendar.DAY_OF_YEAR, 1) ;
            Date tomorow = calendar.getTime() ;
            
            String lc = sdf_10.format(tomorow) ;
            // JOptionPane.showMessageDialog(null, lc);
            
            String today = sdf_10.format(new Date()) ;
          
            String sql = null ;
            ResultSet rs = null ;

            sql =  "select count(*) from commande_client where rdv like '%"+today+"%' and etat = 'OUI'" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){
                
                 GestionGateauFo.setCj(this.nf3.format(rs.getInt(1))) ;
                
                 }
            
             sql =  "select count(*) from commande_client where rdv like '%"+today+"%' and etat = 'OUI' and cd = 'OUI'" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){
                
                 GestionGateauFo.setD1(this.nf3.format(rs.getInt(1))) ;
                
                 }
            
            sql =  "select count(*) from commande_client where rdv like '%"+lc+"%' and etat = 'OUI'" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){
                
                 GestionGateauFo.setLc(this.nf3.format(rs.getInt(1))) ;
                
                 }
            
             sql =  "select count(*) from commande_client where rdv like '%"+lc+"%' and etat = 'OUI' and cd = 'OUI'" ;

            rs = stmt.executeQuery(sql) ;

            while(rs.next()){
                
              GestionGateauFo.setD2(this.nf3.format(rs.getInt(1))) ;
                
                 }
            
            
    
    // end :
    
    
    
     Nouvelle_commande1 nc = new Nouvelle_commande1(this.login) ;
                       nc.setVisible(true) ;
                   
                   this.setVisible(false) ;
        
        
               // JASPERPRINTING FOR PRINT RECU BON COMMANDE :
        
       
          
             

            InputStream in = new FileInputStream(new File("\\\\192.168.1.117\\sibycenter\\RECU.jrxml")) ;
            
          

            List mlist ;
            mlist = new ArrayList<>() ;
            
            
            sql = "select gest_format.id as ref, gest_format.description as produit , "
                    + "gest_format.dimension as dim, gest_format.prx as prix from "
                    + "gest_format , detail_commande_client where detail_commande_client.couleur = 'gs' and detail_commande_client.cb = "+cb+" "
                    + "and gest_format.description = detail_commande_client.description " ;
            
            rs = stmt.executeQuery(sql) ;
        
            while(rs.next()) {
                
                HashMap<String, Object> m = new HashMap<>();
                
                 
                m.put("id", rs.getString("ref").toUpperCase()) ;
                m.put("description", rs.getString("produit").toUpperCase()) ;
                m.put("dimension", rs.getString("dim").toUpperCase());
                m.put("prix", rs.getInt("prix"));
                 
               
                
                mlist.add(m) ;
                
            }
            
            
            ArrayList<Integer> list_model = new ArrayList<Integer>() ;
            
            sql = "select cb_model from detail_commande_client where cb = "+cb+" and couleur = 'model'" ;
            rs = stmt.executeQuery(sql) ;
            while(rs.next()){
                list_model.add(rs.getInt("cb_model")) ;
            }
            
            
            
            
            for(int i = 0 ; i < list_model.size() ; i++){
                
                
                 sql = "select model_gt.id as m_id , model_gt.description as m_d , model_gt.prx as m_p , "
                    + "detail_model_gt.id as ref , detail_model_gt.description as produit , "
                    + "detail_model_gt.dimension as dim, detail_model_gt.prx as prix from "
                    + "model_gt , detail_model_gt where model_gt.cb = "+list_model.get(i).intValue()+" "
                    + "and detail_model_gt.cb = model_gt.cb" ;
            
                rs = stmt.executeQuery(sql) ;
        
            while(rs.next()) {
                
                if(rs.isFirst()){
                    
               HashMap<String, Object> m = new HashMap<>();
                
                 
                m.put("id", "") ;
                m.put("description", ("<>["+rs.getString("m_id")+"] "+rs.getString("m_d")+" ["+rs.getString("m_p")+"]").toUpperCase()) ;
                m.put("dimension", "");
                m.put("prix", Integer.parseInt("0")) ;
                 
               
                
                mlist.add(m) ;
                
                }
                    
               HashMap<String, Object> m = new HashMap<>();
                
                 
                m.put("id", rs.getString("ref").toUpperCase()) ;
                m.put("description", rs.getString("produit").toUpperCase()) ;
                m.put("dimension", rs.getString("dim").toUpperCase());
                m.put("prix", rs.getInt("prix"));
                 
               
                
                mlist.add(m);
                
                
                
                
                
            }

                
                
                
            } // end for our boucle collection model :
            
            
          
            long id_fact = 0 ;
            
            sql = "select id from "
                    + "commande_client where cb = "+cb ;
            
            rs = stmt.executeQuery(sql) ;
        
            while(rs.next()) {
               id_fact = rs.getLong("id") ;
                
            }

            
             
            JRBeanCollectionDataSource jrbean = new JRBeanCollectionDataSource(mlist) ;
             

            SimpleDateFormat sdf10 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss") ;
            
            Map<String, Object> para = new HashMap<>();
            
           // para.put("sql", jrbean);
            
            if(Integer.parseInt(moule) > 0){
                
               para.put("talon_t","TALON CAUTION COMMANDE N° "+id_fact) ; 
               para.put("jour_t","DATE : "+sdf10.format(new Date())) ; 
               para.put("rdv_t","RDV : "+rdv_) ;
               para.put("caution_t","CAUTION : "+nf3.format(Integer.parseInt(moule))) ;
               para.put("client_t","CLIENT : "+client) ;
               para.put("tel_t","TEL 1 : "+t1+" TEL 2 : "+t2) ;
               para.put("adresse_t","ADRESSE : "+adresse) ;
               para.put("nsg_t","ECRITURE : "+ecriture) ;
               para.put("p_c", "MODEL SUR MOULE") ;
               
                
                
            }else if(moule.equalsIgnoreCase("0")){
                
               para.put("talon","") ; 
               para.put("jour_t","") ; 
               para.put("rdv_t","") ;
               para.put("caution_t","") ;
               para.put("client_t","") ;
               para.put("tel_t","") ;
               para.put("adresse_t","") ;
               para.put("nsg_t","") ;
               para.put("talon_t","") ;
               para.put("p_c", "") ;
                
            }
           
            para.put("cb", cb); 
            para.put("op","OP : "+this.login);
            para.put("jour","DATE : "+sdf10.format(new Date()));
            para.put("id_Fact","N° : "+id_fact) ;
            para.put("client","CLIENT : "+client);
            para.put("tel","TEL 1 : "+t1+" TEL 2 : "+t2) ;
            para.put("adresse","ADRESSE : "+adresse) ;
            para.put("rdv","RDV : "+rdv_) ;
            para.put("nsg","ECRITURE : "+ecriture) ;
            para.put("ecriture_gt","ECRITURE : "+ecriture) ;
            para.put("gg", g_gt) ;
            para.put("id_2", nf3.format(id_fact)) ;
            para.put("stotal",nf3.format(devis-Integer.parseInt(moule))) ;
           
           try{
                    
           para.put("caution",nf3.format(Integer.parseInt(moule))) ;     
           para.put("total",nf3.format(devis)) ;
           
            para.put("copie", ""); 
           
           
           }catch(Exception e10){
               JOptionPane.showMessageDialog(null, e10.getMessage()) ;
           }
            
           para.put("reglement",nf3.format(mr)) ;  
           para.put("payer",nf3.format(rl)) ;
           para.put("observation","OBSERVATION: "+observ) ;
           para.put("talon","TALON CAUTION COMMANDE N° "+id_fact) ;
           
           
           
           

            JasperReport report = JasperCompileManager.compileReport(in);
            
            JasperPrint print = JasperFillManager.fillReport(report, para, jrbean);
            JasperViewer.viewReport(print, false) ;
 
        
        // END FOR JASPERPRINT BON COMMANDE :
            
            
            
        
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
        
          Ancien place pour la nouvelle commande reneinitialisation : 
        
        */
                   
                   
               }
               }else{
                       JOptionPane.showMessageDialog(null, "RDV INCORRECT") ;
                   }
               }
            
         }catch(Exception e){
             
             JOptionPane.showMessageDialog(null, "SELECTIONNER UN RDV POUR LA COMMANDE") ;
             
         }
        
       
         
        this.vc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
        
    }//GEN-LAST:event_vcActionPerformed

    private void rdMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdMouseReleased
        // TODO add your handling code here:
        
        
        if(this.rd.isSelected() == true){
        
        this.mode_payement = "A LA LIVRAISON" ;
        this.rp.setSelected(false) ;
        this.ri.setSelected(false);
        this.av.setText("") ;
        this.av.setEditable(false) ;
        
        this.mr.setText("0") ;
        this.rl.setText(dev.getText()) ;
        
        }else{
        
            this.mode_payement = "" ;
            this.mr.setText("0") ;
            this.rl.setText("0") ;
        
        }
        
        
        
    }//GEN-LAST:event_rdMouseReleased
Integer consigne = 0 ;
    private void mouleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mouleKeyReleased
        // TODO add your handling code here :
        
        
        try{
            // av = consignation : 
            
        String av = "" ;
               av = this.moule.getText().trim().replaceAll("[^a-zA-Z0-9]", "") ;
       Integer mtt = Integer.parseInt(av) ;
               this.consigne = mtt ;
       
      // String cout = "" ;
         //     cout = this.dev.getText().replaceAll("[^a-zA-Z0-9]", "") ;
       
       Integer cout1 =  caution ; // Integer.parseInt(cout) ;
        
       this.dev.setText(nf3.format((cout1 + mtt))) ;
       
       
       /*
       
       int rl = 0 ;
           rl = (Integer.parseInt(dev.getText().replaceAll("[^a-zA-Z0-9]", "")) - mtt) ;
           
           this.rl.setText(nf3.format(rl)) ;
         
       */  
           
       
       
        }catch(Exception e){
            this.mr.setText("0") ;
            this.rl.setText("0") ;
           // JOptionPane.showMessageDialog(null, e.getMessage()) ;
        }
       
       
        
        
        
    }//GEN-LAST:event_mouleKeyReleased

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
            java.util.logging.Logger.getLogger(Nouvelle_commande1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nouvelle_commande1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nouvelle_commande1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nouvelle_commande1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nouvelle_commande1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresse;
    private static javax.swing.JTextField av;
    private javax.swing.JTextField client;
    private static javax.swing.JCheckBox cm;
    private static javax.swing.JTextField dev;
    private javax.swing.JTextField ecriture;
    private javax.swing.JFormattedTextField h;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    private static javax.swing.JTextField moule;
    private javax.swing.JTextField mr;
    private static javax.swing.JTextField observ;
    private static javax.swing.JCheckBox rd;
    private com.toedter.calendar.JDateChooser rdv;
    private static javax.swing.JCheckBox ri;
    private javax.swing.JTextField rl;
    private static javax.swing.JCheckBox rp;
    private javax.swing.JFormattedTextField t1;
    private javax.swing.JFormattedTextField t2;
    private javax.swing.JButton vc;
    // End of variables declaration//GEN-END:variables
}
