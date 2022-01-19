/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import entity.ActiviteT;
import static frontend.ActiviteTransformation.JDBC_DRIVER;
import static frontend.ProductionPf.JDBC_DRIVER;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HAMZA
 */
public class Magasin extends javax.swing.JFrame {

    /**
     * Creates new form Magasin
     */
    
      static final String JDBC_DRIVER = "com.mysql.jdbc.Driver" ;  
      static final String DB_URL = "jdbc:mysql://192.168.1.117:3306/transformation" ;
      static final String USER = "root" ;
      static final String PASS = "interco" ;
      
      
      String user_c ;
      String currendate ;
      long id = 0 ;
      String role = "" ;
      private String etat ;
    
    public Magasin() {
        
       
        initComponents() ;
        this.setLocationRelativeTo(null);
         DateFormat datef = new SimpleDateFormat("dd/MM/yyyy") ;
         Date date = new Date() ;
         this.currendate = datef.format(date) ;
         
         
         //
       
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
        
       
        
         this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 4) ;
        
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        if ("oui".equalsIgnoreCase(status)) {
            
            setBackground(Color.GREEN);
            setForeground(Color.BLACK);
            
        } else {
            
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
            
        }   
        
        if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
            
          
        return this;
        
    }   
});
        
        
       
         
             //
        
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
      
       sql= "SELECT * FROM magasins ORDER BY magasin" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
     
      
        
        dtm.addRow(new Object[]{
            
   // "Ref", "DESCRIPTION", "DATE CREAT°", "SAISIE PAR :"
            
          rs.getLong("id") , rs.getString("magasin") , rs.getString("datec") 
       ,  rs.getString("admin") , rs.getString("etat")
        
        });
               
        
         
       
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
     
        
        
        //
        
      
        
    }
    
    
     public Magasin(String role) {
        
       
        initComponents() ;
        this.setLocationRelativeTo(null);
         DateFormat datef = new SimpleDateFormat("dd/MM/yyyy") ;
         Date date = new Date() ;
         this.currendate = datef.format(date) ;
         
         this.role = role ;
         
         if(this.role.equalsIgnoreCase("SUPER ADMINISTRATEUR")){
             
             this.conf.setVisible(true) ;
             
         }else if(this.role.equalsIgnoreCase("ADMINII")){
             
             this.supprimer.setEnabled(false) ;
         
         }else{
             
             this.conf.setVisible(false) ;
             
         }
         
         
         
         //
       
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
        
       
        
         this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 4) ;
        
      
        //  System.out.print("Object in list 44 : "+list44.get(0));
        
        if ("oui".equalsIgnoreCase(status)) {
            
            setBackground(Color.GREEN);
            setForeground(Color.BLACK);
            
        } else {
            
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
            
        }   
        
        if(isSelected){
            
            this.setBackground(Color.BLUE);
            this.setForeground(Color.white);
        }
            
          
        return this;
        
    }   
});
        
        
       
         
             //
        
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
      PreparedStatement pst = null ;
      
      
      //je crai ma requete
      
      
      String sql ;
      
       sql= "SELECT * FROM magasins ORDER BY magasin" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
     
      
        
        dtm.addRow(new Object[]{
            
   // "Ref", "DESCRIPTION", "DATE CREAT°", "SAISIE PAR :"
            
          rs.getLong("id") , rs.getString("magasin") , rs.getString("datec") 
       ,  rs.getString("admin") , rs.getString("etat")
        
        });
               
        
         
       
     }
      
    Integer et = 0 ;
     String qery = null ;
            qery = "select etat from conf_stock limit 1" ;
            ResultSet resultat = null ;
                      pst = conn.prepareStatement(qery) ;
                      resultat = pst.executeQuery() ;
      
                      while(resultat.next()){
                          
                          et = resultat.getInt("etat") ;
                          
                      }
                      
                      if(et == 1){
                          this.st.setSelected(true) ;
                          this.nst.setSelected(false);
                      }else if(et == 0){
                          this.nst.setSelected(true) ;
                          this.st.setSelected(false) ;
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
     
        
        
        //
        
      
        
    }
    
    public void setUserC(String usc){
        this.user_c = usc ;
    }

    public void setAjouter() {
        this.ajouter.setEnabled(false);
    }

    public void setModifier() {
        this.modifier.setEnabled(false);
    }

    public void setSupprimer() {
        this.supprimer.setEnabled(false);
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
     private void clear() {

        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        int n = model.getRowCount();
        for (int i = n - 1; i >= 0; --i) {
            model.removeRow(i);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        mag1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        mag = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ajouter = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        supprimer = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();
        conf = new javax.swing.JPanel();
        st = new javax.swing.JCheckBox();
        nst = new javax.swing.JCheckBox();
        ajouter1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 51, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" MAGASINS DE STOCK ");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ref", "DESCRIPTION", "DATE CREAT°", "SAISIE PAR :", "DEFAUT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(3);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(3);
        }

        mag1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mag1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mag1KeyReleased(evt);
            }
        });

        jLabel3.setText("MOT CLE :");

        mag.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("DESCRIPTION :");

        ajouter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ajouter.setText("AJOUTER");
        ajouter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        modifier.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        modifier.setText("MODIFIER");
        modifier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        supprimer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        supprimer.setText("SUPPRIMER");
        supprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(0, 204, 102));
        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("PRINCIPAL");
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mag, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ajouter)
                        .addGap(18, 18, 18)
                        .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mag, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(modifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton5.setText("ACTUALISER");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        conf.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONFIIGURATION STOCK", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 16), new java.awt.Color(153, 153, 0))); // NOI18N

        st.setText("STOCK");
        st.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        st.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                stMouseReleased(evt);
            }
        });

        nst.setText("NON STOCK");
        nst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nstMouseReleased(evt);
            }
        });

        ajouter1.setBackground(new java.awt.Color(0, 0, 255));
        ajouter1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ajouter1.setForeground(new java.awt.Color(255, 255, 255));
        ajouter1.setText("VALIDER");
        ajouter1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ajouter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout confLayout = new javax.swing.GroupLayout(conf);
        conf.setLayout(confLayout);
        confLayout.setHorizontalGroup(
            confLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(st, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nst, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(confLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(ajouter1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        confLayout.setVerticalGroup(
            confLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(confLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(st)
                    .addComponent(nst))
                .addGap(10, 10, 10)
                .addComponent(ajouter1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(mag1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mag1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(conf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mag1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mag1KeyPressed
        // TODO add your handling code here:
        
     
        
    }//GEN-LAST:event_mag1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
       
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        // TODO add your handling code here:
        
        String m1 = this.mag.getText().trim().replaceAll("'", "''") ;
        
        if("".equalsIgnoreCase(m1)){
            
            JOptionPane.showMessageDialog(this, "SAISIR UN MAGASIN SVP !!!") ;
            
        }else{
          
              SessionFactory sf=new Configuration().configure().buildSessionFactory();
              Session s=sf.openSession();
           
            
      
         List entreprise = s.createSQLQuery("SELECT * FROM magasins WHERE magasin = '"+m1+"'").list();
       
         
               // verification if qery is ok
         
            
            if(entreprise.size() == 1){
                
       JOptionPane jp = new JOptionPane() ;
       jp.showMessageDialog(null," Le magasin existe dejà ","Avertissement",JOptionPane.WARNING_MESSAGE) ;
        
                
            }else{
                
                if(this.jCheckBox1.isSelected()){
                    
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
      
        // je crai ma requete
      
      String sql = null ;
      ResultSet rs = null ;
      int vy = 0 ;
      
      sql = "select * from magasins where etat = 'oui' " ;
      rs = stmt.executeQuery(sql) ;
      while(rs.next()){
          vy = 1 ;
      }
      
      if(vy == 1){
          JOptionPane.showMessageDialog(null, "IL Y A DEJA UN MAGASIN PRINCIPAL PAR DEFAUT");
      }else if(vy == 0){
      
     if(stmt.executeUpdate("INSERT INTO magasins(magasin,datec,admin,etat) VALUES('"+m1+"' , '"+this.currendate+"' , '"+this.user_c.replaceAll("'", "''")+"' , 'oui' )") == 1){
         
          this.mag.setText("") ;
         
          DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                            dtm1.setRowCount(0) ;
      
      
          
         
         
      
         sql =  "SELECT * FROM magasins order by magasin" ;
      
         rs = stmt.executeQuery(sql) ;
      
      
       while(rs.next()){
        
     
      
        
        dtm1.addRow(new Object[]{
            
   // "Ref", "DESCRIPTION", "DATE CREAT°", "SAISIE PAR :"
            
          rs.getLong("id") , rs.getString("magasin") , rs.getString("datec") 
       ,  rs.getString("admin") , rs.getString("etat")
        
        }) ;
               
        
     }
      
    
     
         
         
         
         
     }
      
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
        
       
     
     // Fin configure :
     
       
        
        //
                    
                }else{
                 
                           
       //
        
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
      
        // je crai ma requete
      
     if(stmt.executeUpdate("INSERT INTO magasins(magasin,datec,admin,etat) VALUES('"+m1+"' , '"+this.currendate+"' , '"+this.user_c.replaceAll("'", "''")+"' , 'non' )") == 1){
         
          this.mag.setText("") ;
         
              DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                                dtm1.setRowCount(0) ;
      
        
         String sql ;
      
         sql=  "SELECT * FROM magasins order by magasin" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
       while(rs.next()){
        
     
      
        
        dtm1.addRow(new Object[]{
            
   // "Ref", "DESCRIPTION", "DATE CREAT°", "SAISIE PAR :"
            
          rs.getLong("id") , rs.getString("magasin") , rs.getString("datec") 
       ,  rs.getString("admin"), rs.getString("etat")
        
        });
               
        
     }
      
    
     
         
         
         
         
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
        
       
     
     // Fin configure :
     
        
        
        //
        
                     
                     }
            
            
            
            
        }    
        }
        
        
        
        
    }//GEN-LAST:event_ajouterActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        // TODO add your handling code here:
        
        
          if(jTable1.getSelectedRow() == -1){
           
            JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null,"Pour modifier un magasin selectionner dans le tableau","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
            
            
        }else{
        
         if(JOptionPane.showConfirmDialog(null, "Voulez-vous modifier ce magasin ? :"+" ","Confirmation",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            
             // ici je supprime le compte utilisateur :
             
             if(this.jCheckBox1.isSelected()){
                 
                 // debut
                 
               String m1 = this.mag.getText().trim().replaceAll("'", "''") ;
              
              if("".equalsIgnoreCase(m1)){
                  
                     JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null,"Pour modifier un magasin il faut saisir le magasin ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
                  
              }else{
              
               //
        
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
      
        // je crai ma requete
      
      String query = null ;
      ResultSet rst = null ;
      int vy = 0 ;
      String maga = null ;
      
      query = "select * from magasins where etat = 'oui' " ;
      rst = stmt.executeQuery(query) ;
      while(rst.next()){
          vy = 1 ;
          maga = rst.getString("magasin") ;
      }
      
      if(vy == 1){
          JOptionPane.showMessageDialog(null, "LE MAGASIN "+maga+" EST DEJA LE MAGASIN PRINCIPAL") ;
      }else if(vy == 0){
          
          
      if(stmt.executeUpdate("UPDATE stock1 SET maga = '"+m1+"' WHERE maga = '"+jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString().replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("UPDATE stock1 SET maga = '"+m1+"' WHERE maga = '"+jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString().replaceAll("'", "''")+"'") == 0){

          stmt.executeUpdate("UPDATE facture_fourni SET ref_saisie = '"+m1+"' WHERE ref_saisie = '"+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString().replaceAll("'", "''")+"'") ;
          
          if(stmt.executeUpdate("UPDATE magasins SET magasin ='"+m1+"' , etat = 'oui' WHERE id ="+this.id) == 1){
         
         this.mag.setText("") ;
          
           
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0);
         
         String sql ;
      
         sql=  "SELECT * FROM magasins order by magasin" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
       while(rs.next()){
        
     
      
        
        dtm.addRow(new Object[]{
            
   // "Ref", "DESCRIPTION", "DATE CREAT°", "SAISIE PAR :"
            
          rs.getLong("id") , rs.getString("magasin") , rs.getString("datec") 
       ,  rs.getString("admin") , rs.getString("etat")
        
        });
               
        
     }
      
    
     
         
         
         
         
     }
      
      }
      
          
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
        
       
     
     // Fin configure :
     
        
        
        //
              }
            
                 
                 // end
                 
             }else if(this.jCheckBox1.isSelected() == false){
                 
                 // debut
                 
                       String m1 = this.mag.getText().trim().replaceAll("'", "''") ;
              
              if("".equalsIgnoreCase(m1)){
                  
                     JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null,"Pour modifier un magasin il faut saisir le magasin ","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
                  
              }else{
              
               //
        
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
      
        // je crai ma requete
      
      
      
      if(stmt.executeUpdate("UPDATE stock1 SET maga = '"+m1+"' WHERE maga = '"+jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString().replaceAll("'", "''")+"'") > 0 || stmt.executeUpdate("UPDATE stock1 SET maga = '"+m1+"' WHERE maga = '"+jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString().replaceAll("'", "''")+"'") == 0){
          stmt.executeUpdate("UPDATE facture_fourni SET ref_saisie = '"+m1+"' WHERE ref_saisie = '"+this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString().replaceAll("'", "''")+"'") ;
          if(stmt.executeUpdate("UPDATE magasins SET magasin ='"+m1+"' , etat = 'non' WHERE id ="+this.id) == 1){
         
         this.mag.setText("") ;
          
           
      
      
      
         DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel() ;
                           dtm.setRowCount(0);
         
         String sql ;
      
         sql=  "SELECT * FROM magasins order by magasin" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
       while(rs.next()){
        
     
      
        
        dtm.addRow(new Object[]{
            
   // "Ref", "DESCRIPTION", "DATE CREAT°", "SAISIE PAR :"
            
          rs.getLong("id") , rs.getString("magasin") , rs.getString("datec") 
       ,  rs.getString("admin") , rs.getString("etat")
        
        });
               
        
     }
      
    
     
         
         
         
         
     }
      
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
        
       
     
     // Fin configure :
     
        
        
        //
              }
            
                 
                 // end
                 
             }
             
             
           
             
             }else{
            
                
            
            }
         
         
        
        }
        
        
        
    }//GEN-LAST:event_modifierActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        // TODO add your handling code here:
        
           if(jTable1.getSelectedRow() == -1){
           
            JOptionPane jp=new JOptionPane();
            jp.showMessageDialog(null,"Pour supprimer un magasin selectionner dans le tableau","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
        
            
            
        }else{
        
         if(JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce magasin ? :"+" ","Confirmation",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            
             // ici je supprime le compte utilisateur :
             
           
               //
        
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
      
        // je crai ma requete
      
     if(stmt.executeUpdate("DELETE FROM magasins WHERE id ="+this.id) == 1){
          
          this.mag.setText("") ;
          
             DefaultTableModel dtm1 = (DefaultTableModel) this.jTable1.getModel() ;
                               dtm1.setRowCount(0) ;
     
         
         String sql ;
      
         sql=  "SELECT * FROM magasins order by magasin" ;
      
         ResultSet rs = stmt.executeQuery(sql) ;
      
      
       while(rs.next()){
        
     
      
        
        dtm1.addRow(new Object[]{
            
   // "Ref", "DESCRIPTION", "DATE CREAT°", "SAISIE PAR :"
            
          rs.getLong("id") , rs.getString("magasin") , rs.getString("datec") 
       ,  rs.getString("admin"), rs.getString("etat")
        
        });
               
        
     }
      
    
     
         
         
         
         
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
        
       
     
     // Fin configure :
     
        
        
        //
              
            
            }else{
            
                
            
            }
         
         
        
        }
        
        
        
        
    }//GEN-LAST:event_supprimerActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
      
        
        /*
         Magasin mg = new Magasin() ;
         mg.setUserC(this.user_c) ;
        
         mg.setVisible(true) ;
         this.setVisible(false) ;
        
         */
            
          Magasin mg = new Magasin(this.role) ;
        mg.setUserC(this.user_c) ;
        mg.setRole(role);
        
        if(this.role.equalsIgnoreCase("ADMINISTRATEUR") || this.role.equalsIgnoreCase("ADMINII")){
                      mg.setAjouter();
                      mg.setModifier();
                      mg.setSupprimer();
                  }
        
        mg.setVisible(true) ;
        this.setVisible(false);
                 
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
        
        
        String code = jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString() ;
        
        this.id = Long.parseLong(code) ;
        
        this.mag.setText(jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString());
        
        
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        
         String code = jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString() ;
        
        this.id = Long.parseLong(code) ;
        
        this.mag.setText(jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString());
        this.etat = "" ;
        this.etat = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4).toString() ;
        
        if(this.etat.equalsIgnoreCase("oui")){
            this.jCheckBox1.setSelected(true) ;
        }else{
             this.jCheckBox1.setSelected(false) ;
        }
        
    }//GEN-LAST:event_jTable1MouseReleased

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        
        /*
        Integer i = 1000 ;
        JOptionPane.showMessageDialog(this, i);
        */
        
    }//GEN-LAST:event_jTable1KeyReleased

    private void mag1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mag1KeyReleased
        // TODO add your handling code here:
        
        
           
        String m1 = this.mag1.getText().trim().replaceAll("'", "''") ;
        
        if("".equalsIgnoreCase(m1)){
            
        }else{
            
            
             //
        
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
      
      
    clear() ;
      
      
      
      
         DefaultTableModel dtm=(DefaultTableModel) jTable1.getModel() ;
         
      String sql ;
      
       sql= "SELECT * FROM magasins WHERE magasin LIKE '%"+m1+"%'" ;
      
       ResultSet rs = stmt.executeQuery(sql) ;
      
      
     while(rs.next()){
        
     
      
        
        dtm.addRow(new Object[]{
            
   // "Ref", "DESCRIPTION", "DATE CREAT°", "SAISIE PAR :"
            
          rs.getLong("id") , rs.getString("magasin") , rs.getString("datec") 
       ,  rs.getString("admin") , rs.getString("etat")
        
        });
               
        
         
       
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
     
        
        
        //
        
      
        
            
        }
        
        
        
        
    }//GEN-LAST:event_mag1KeyReleased

    private void ajouter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter1ActionPerformed
        // TODO add your handling code here:
        
        if(this.st.isSelected() == false && this.nst.isSelected() == false){
            JOptionPane.showMessageDialog(null, "ACTIVER UN CHOIX SVP !!!");
        }else{
            
             if(JOptionPane.showConfirmDialog(null, "Voulez-vous activer votre choix ? :"+" ","Confirmation",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ 
             
                 // on valide le choix ici :
                 
                   Connection conn = null;
                   Statement stmt = null;
                   PreparedStatement pst = null ;
       
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
      
       sql = "update conf_stock set etat = "+this.vl+" where id = ?" ;
       pst = conn.prepareStatement(sql) ;
       pst.setInt(1, 1) ;
       pst.executeUpdate() ;
   
    JOptionPane.showMessageDialog(null, "VALIDATION REUSSIT !!!") ;
      
       
    
     
      
    
            
      //STEP 6: Clean-up environment
      
   // System.out.println("Goodbye!");
      
   
      
      //STEP 6: Clean-up environment
   //   rs.close();
      stmt.close();
      pst.close();
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
     
        
        
                 
                 
                 // end validation :
             
             }else{
                 
                 
             }
            
        }
        
        
        
    }//GEN-LAST:event_ajouter1ActionPerformed

    
    Integer vl = 0 ;
    
    private void stMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stMouseReleased
        // TODO add your handling code here:
        
        if(this.st.isSelected()){
            this.vl = 1 ;
            this.nst.setSelected(false) ;
            
        } 
        
    }//GEN-LAST:event_stMouseReleased

    private void nstMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nstMouseReleased
        // TODO add your handling code here:
        
        
        if(this.nst.isSelected()){
            this.vl = 0 ;
            this.st.setSelected(false) ;
            
        } 
        
        
    }//GEN-LAST:event_nstMouseReleased

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
            java.util.logging.Logger.getLogger(Magasin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Magasin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Magasin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Magasin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Magasin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JButton ajouter1;
    private javax.swing.JPanel conf;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField mag;
    private javax.swing.JTextField mag1;
    private javax.swing.JButton modifier;
    private javax.swing.JCheckBox nst;
    private javax.swing.JCheckBox st;
    private javax.swing.JButton supprimer;
    // End of variables declaration//GEN-END:variables
}
