/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.Reporting;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author HAMZA
 */
public class Alist extends javax.swing.JFrame {
    Integer id = 0 ;
    String nom = "" ;
    String prenom = "" ;
    
    ArrayList<Perso> list = new ArrayList<>() ;
    ArrayList<Perso> list2 = new ArrayList<>() ;
    ArrayList<Perso> list3 = new ArrayList<>() ;
    
    ArrayList<Integer> list4 = new ArrayList<>() ;
    ArrayList<String> list44 = new ArrayList<>() ;
    
    DefaultListModel dlm = new DefaultListModel() ;
    
    
    public Alist() {
        initComponents();
        
         // this.list4.add(0) ;
         // this.list4.add(1) ;
           
        //  this.list4.add(4) ;
        
        // ---------------- 1è choix --------------
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
        
        
                   // ---------------- 1è choix --------------
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
              
        
             
                  headerRenderer.setBackground(Color.green) ;
                  headerRenderer.setForeground(Color.BLACK) ;
                  headerRenderer.setFont(new Font("Segoe UI" , Font.BOLD , 16)) ;

                  for (int i = 0; i < this.jTable3.getModel().getColumnCount(); i++) {
                    this.jTable3.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------
                  
            this.jTable5.getTableHeader().setFont(new Font("Segoe UI" , Font.BOLD , 13)) ;
            this.jTable5.getTableHeader().setOpaque(false); 
            this.jTable5.getTableHeader().setBackground(Color.black); 
          
        //    this.jTable1.setBackground(Color.white);
        
       
            this.jTable5.getTableHeader().setForeground(Color.white) ;
        
              this.jTable5.setRowHeight(25) ;
              
         
                  headerRenderer.setBackground(Color.green) ;
                  headerRenderer.setForeground(Color.BLACK) ;
                  headerRenderer.setFont(new Font("Segoe UI" , Font.BOLD , 16)) ;

                  for (int i = 0; i < this.jTable5.getModel().getColumnCount(); i++) {
                    this.jTable5.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer) ;
                    
             }
        
     //   -------------------
        
        ArrayList<String> testList = new ArrayList<String>() ;
        testList.add("Ali") ;
        testList.add("Moussa") ;
        testList.add("Yaya") ;
        
        for(int i = 0 ; i < testList.size() ; i++){
            System.out.println(testList.get(i))  ;
        }
        
        for(String i : testList){
                System.out.println(i)  ;
             }
        
        testList.remove("Moussa") ;
        testList.remove("Ali") ;
        
         for(int i = 0 ; i < testList.size() ; i++){
            System.out.println(testList.get(i))  ;
        }
        
        for(String i : testList){
                System.out.println(i)  ;
             }
        
         testList.add("Ali") ;
         testList.add("Moussa") ;
         
          for(int i = 0 ; i < testList.size() ; i++){
            System.out.println(testList.get(i))  ;
        }
        
        for(String i : testList){
                System.out.println(i)  ;
             }
        
        
        /*
        
        DefaultTableModel model = (DefaultTableModel) this.jTable2.getModel() ;
        Object[] newIdentity = new Object[]{"id", "nom", "prenom", "img"} ;
        model.setColumnIdentifiers(newIdentity) ;
        //  "id", "nom", "prenom", "img"
        */
        
          this.list44.add("oui"+0) ;
          this.list44.add("oui"+1) ;
          this.list44.add("oui"+3) ;
          this.list44.add("oui"+6) ;
        
        this.jTable2.getColumn("img").setCellRenderer(new myTable()) ;

this.jTable5.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 3) ;
        
      
          System.out.print("Object in list 44 : "+list44.get(0));
        if (list44.get(0).toString().equals(status) || list44.get(1).toString().equals(status) || list44.get(2).toString().equals(status) || "non".equals(status) || list44.get(3).toString().equals(status)) {
            setBackground(Color.ORANGE);
            setForeground(Color.WHITE);
        } else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }   
               
          
        return this;
        
    }   
});



  DefaultTableModel dtm = (DefaultTableModel) this.jTable5.getModel() ;
        dtm.setRowCount(0) ;
        
       
        
        
        
        for(int i = 0 ; i < this.list4.size() ; i++){
          //   this.list3.remove(this.list2.get(i)) ;
            
           //  this.list3.remove(this.list4.get(i).intValue()) ;
            
        }
        
        
         for(int i = 0 ; i < this.list4.size() ; i++){
          //   this.list3.remove(this.list2.get(i)) ;
            
       //     this.list4.remove(i) ;
            
        }
        
        
       
        Perso perso = new Perso(1,"nom" , "prenom","oui0") ;
        Perso perso1 = new Perso(1,"nom" , "prenom","oui2") ;
        Perso perso2 = new Perso(1,"nom" , "prenom","oui1") ;
        Perso perso3 = new Perso(1,"nom" , "prenom","oui3") ;
        Perso perso4 = new Perso(1,"nom" , "prenom","oui6") ;
        Perso perso5 = new Perso(1,"nom" , "prenom","oui7") ;
        Perso perso6 = new Perso(1,"nom" , "prenom","oui9") ;
        Perso perso7 = new Perso(1,"nom" , "prenom","oui4") ;
        
        this.list3.add(perso) ;
       //  this.list3.add(perso1) ;
      //  this.list3.add(perso2) ;
     //   this.list3.add(perso3) ;
       // this.list3.add(perso4) ;
     //  this.list3.add(perso5) ;
    //   this.list3.add(perso6) ;
   //    this.list3.add(perso7) ;
        
        
        for(int i = 0 ; i < this.list3.size() ; i++){
            dtm.addRow(new Object[]{
            
            this.list3.get(i).getId() , this.list3.get(i).getNom() , this.list3.get(i).getPrenom() , this.list3.get(i).getStat()
                    
            });
            
        }
        
        
      // test :
     //   this.jTable5.setBackground(Color.ORANGE) ;
    //   this.jTable4.setForeground(Color.WHITE);
   // test :
        
        
    }
    
    
class myTable implements TableCellRenderer{
    
    
 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,  int row, int column){
      
                 jTable2.setRowHeight(100) ;
                 TableColumn tb = jTable2.getColumn("img") ;
                 tb.setMaxWidth(100) ;
                 tb.setMinWidth(100) ;
     
   
              return (Component) value ;
              
     
   
 }
                                      
                                      
                                     
                                    
                                      
    
    }
    
    
    

     public static void addjTable5Row(Object[] data){
         // setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)) ;
         
         DefaultTableModel dtm = (DefaultTableModel) jTable5.getModel() ;
         dtm.addRow(data) ;
         
         
          
     }
 

    // ImageIcon icon = new ImageIcon("images/middle.gif") ;
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jFileChooser1 = new javax.swing.JFileChooser();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nom", "prenom"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/download.jpg"))); // NOI18N
        jButton3.setText("SEND");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_P", "Nom", "Prenom", "img"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable2.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jTable3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_p", "nom", "Prenom"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable3.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("ADD ==>");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("DELETE");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton6.setText("ETAT : RST");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jList1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Nom & Prenom presonnel" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jList1);

        jTable5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_p", "Nom", "Prenom", "Status"
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
        jTable5.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable5.getTableHeader().setReorderingAllowed(false);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable5);

        jLabel1.setText("-");

        jFileChooser1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jFileChooser1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton7.setText("BROWSE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("ManulColor");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setText("Open Control");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(251, 251, 251))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Random rx = new Random() ;
        int i = 0 ;
        i = rx.nextInt() ;
        if(i < 0){
            i = Math.abs(i) ;
        }
        
        Perso perso = new Perso(i , "Nom Famille"+i, "Prenom"+i) ;
         this.list4.add(i) ;
         this.list4.add((i+2)) ;
         this.list44.add("Nom Famille"+i) ;
         // int ii = (i+10) ;
         
         // "oui"+i
        this.list.add(perso) ;
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
        
        dtm.addRow(new Object[]{
            perso.getId() , perso.getNom() , perso.getPrenom()
        });
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        this.id = 0 ;
        this.nom = "" ;
        this.prenom = "" ;
        
        this.id = Integer.parseInt(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString()) ;
        this.nom =this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString() ;
        this.prenom =this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString() ;
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable1.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "CHOISIR txt") ;
        }else{
            System.out.println("index int retour in Table selected : "+this.jTable1.getSelectedRow());
            Perso perso = new Perso(this.id , this.nom , this.prenom) ;
              // test.remove(test.indexOf(obj));
            System.out.println("Java index Object in my arrayList : "+this.list.indexOf(perso)) ;
          

         //   this.list.remove(this.list.indexOf(perso)) ; 
        //    this.list.remove(perso) ;
        
            this.list.remove(this.jTable1.getSelectedRow()) ;
         
       //  this.list.removeIf(t -> t.id == this.id) ;
            
            
            /*
            int i = 0 ;
            this.list.remove(this.list.get(i)) ;
            i++ ;
            */
            
            DefaultTableModel dtm = (DefaultTableModel) this.jTable1.getModel() ;
            dtm.setRowCount(0) ;
            
            for(Perso perso1 : this.list){
                  dtm.addRow(new Object[]{
                      
                  perso1.getId() , perso1.getNom() , perso1.getPrenom()
                          
                  });
            }
            
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
         this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
          
        DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
        
        dtm.setRowCount(0) ;
        this.dlm.clear();
        
        for(int i = 0 ; i < this.list.size() ; i++){
            Perso  p = (Perso) this.list.get(i) ;
            
            // creation d'image en provenance de mon serveur : 192.168.1.117 :
            
            ImageIcon icon = new ImageIcon("\\\\192.168.1.117\\img\\Penguins.jpg") ;
           // Object [][] data = {{1,"nom","prenom",}};
               //      setIconImage(icon.getImage());

                     // JLabel lbl1 = new JLabel(icon);   
                    // lbl1.setIcon(icon);
            
                     JLabel label1 = new JLabel() ;
                     label1.setSize(85, 85) ;
                     
                     Image image11 = icon.getImage().getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_SMOOTH) ;
                     ImageIcon icon11 = new ImageIcon(image11) ;
                     label1.setIcon(icon11) ;
                      
                     
                     Image image1 = icon.getImage().getScaledInstance(this.jLabel1.getWidth(), this.jLabel1.getHeight(), Image.SCALE_SMOOTH) ;
                     ImageIcon icon1 = new ImageIcon(image1) ;
                     this.jLabel1.setIcon(icon1);
                      
                     
                 
               //  this.jButton3.setIcon(icon1) ;  it work
                   this.list3.add(p) ;
            
                 dtm.addRow(new Object[]{
                     
                  this.list.get(i).getId() , this.list.get(i).getNom() , this.list.get(i).getPrenom() , label1
                         
                  });
                 
                 this.dlm.addElement(this.list.get(i).getNom() ) ;
                 
        }
        
        
        
        this.jList1.setModel(dlm) ;
        
        
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        if(this.jTable2.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "CHOISIR txt") ;
        }else{
            this.id = 0 ;
            this.nom = "" ;
            this.prenom = "" ;
            
            this.id = Integer.parseInt(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0).toString()) ;
            this.nom = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 1).toString() ;
            this.prenom = this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 2).toString() ;
            
            Perso perso = new Perso(this.id , this.nom , this.prenom) ;
            int index = this.list.indexOf(perso.id) ;
            System.out.println("this.list object select index value : "+index) ;
            this.list2.add(perso) ;
            
            
            DefaultTableModel dtm = (DefaultTableModel) this.jTable3.getModel() ;
            dtm.addRow(new Object[]{
            perso.getId() , perso.getNom() , perso.getPrenom()
            });
            
            this.list4.add(this.jTable2.getSelectedRow()) ;
            
            DefaultTableModel dtm2 = (DefaultTableModel) this.jTable2.getModel() ;
            dtm2.setRowCount(0) ;
            
            for(Perso p : this.list){
           dtm2.addRow(new Object[]{
            p.getId() , p.getNom() , p.getPrenom()
            });
            }
            
            
            
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(this.jTable3.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "CHOISIR txt");
        }else{
        
            this.list2.remove(this.jTable3.getSelectedRow()) ;
            DefaultTableModel dtm = (DefaultTableModel) this.jTable3.getModel() ;
            dtm.removeRow(this.jTable3.getSelectedRow()) ;
            
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
     //   TODO add your handling code here:
    //    TableCellRenderer render = null     ; // = new TableCellRenderer() ;
   //     prepareRender(this.jTable4 , render , 1 , 1) ;
        
        DefaultTableModel dtm = (DefaultTableModel) this.jTable5.getModel() ;
        dtm.setRowCount(0) ;
        
       
        
        
        
        for(int i = 0 ; i < this.list4.size() ; i++){
          //   this.list3.remove(this.list2.get(i)) ;
            
           //  this.list3.remove(this.list4.get(i).intValue()) ;
            
        }
        
        
         for(int i = 0 ; i < this.list4.size() ; i++){
          //   this.list3.remove(this.list2.get(i)) ;
            
       //     this.list4.remove(i) ;
            
        }
        
        
       
        
        
        for(int i = 0 ; i < this.list3.size() ; i++){
            dtm.addRow(new Object[]{
            
            this.list3.get(i).getId() , this.list3.get(i).getNom() , this.list3.get(i).getPrenom() , "oui"+i
                    
            });
            
        }
        
        
      // test :
     //   this.jTable5.setBackground(Color.ORANGE) ;
    //   this.jTable4.setForeground(Color.WHITE);
   // test :
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            // TODO add your handling code here:
        
          // JFileChooser jfc;
         // String path = "C:\\Users\\Public";
        // File file = new File("C:\\Users\\Public");
       // FileSystemView fsv = FileSystemView.getFileSystemView();

     // jfc = new JFileChooser();
    // jfc = new JFileChooser(path);
   //  jfc = new JFileChooser(file);
  //   jfc = new JFileChooser(fsv);
 //   jfc = new JFileChooser(path, fsv);
//   jfc = new JFileChooser(file, fsv);
        
        
           JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
                        
			System.out.println(selectedFile.getAbsolutePath());
                        
               try{
                   // With Java 7 or newer you can use Files.move(from, to, CopyOption... options).
                    int i = 10 ;
                   // pour deplacer le fichier 
                 //  Files.move(Paths.get(selectedFile.getAbsolutePath()), Paths.get("\\\\192.168.1.117\\img\\"+i+".jpg"), StandardCopyOption.REPLACE_EXISTING);
                  // faire une copie conforme du fichier :
                    
                  Files.copy(Paths.get(selectedFile.getAbsolutePath()), Paths.get("\\\\192.168.1.117\\img\\"+i+".jpg"), StandardCopyOption.REPLACE_EXISTING);
                    
                    
                   // System.out.println(" End for move this :"+selectedFile.getAbsolutePath()) ;
                  
                    System.out.println(" End for copy this :"+selectedFile.getAbsolutePath()) ;
                    ImageIcon ic = new ImageIcon("\\\\192.168.1.117\\img\\10.jpg") ;
                    
                    Image icon = ic.getImage().getScaledInstance(/*this.jLabel1.getWidth()*/ 85, /*this.jLabel1.getHeight()*/ 85 , Image.SCALE_SMOOTH) ;
                    this.jLabel1.setIcon(new ImageIcon(icon)) ;
                    
                    DefaultTableModel dtm = (DefaultTableModel) this.jTable2.getModel() ;
                    dtm.addRow(new Object[]{
                    "120", "nom 10", "prenom 10", this.jLabel1 
                    });
               
               }catch (IOException ex){
                   Logger.getLogger(Alist.class.getName()).log(Level.SEVERE, null, ex);
          
                          }
			 
                        
                        
		}
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
      /*
        this.jTable5.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col) ;

        String status = (String) table.getModel().getValueAt(row, 3) ;
        
      
        if ("oui0".equals(status)) {
            setBackground(Color.BLACK);
            setForeground(Color.WHITE);
        } else {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }   
        
         
          
        return this;
        
    }   
});
     */
        
        
         DefaultTableModel dtm = (DefaultTableModel) this.jTable5.getModel() ;
        dtm.setRowCount(0) ;
        
       
        
        
        
        for(int i = 0 ; i < this.list4.size() ; i++){
          //   this.list3.remove(this.list2.get(i)) ;
            
           //  this.list3.remove(this.list4.get(i).intValue()) ;
            
        }
        
        
         for(int i = 0 ; i < this.list4.size() ; i++){
          //   this.list3.remove(this.list2.get(i)) ;
            
       //     this.list4.remove(i) ;
            
        }
        
        
       
        
        
        for(int i = 0 ; i < this.list3.size() ; i++){
            dtm.addRow(new Object[]{
            
            this.list3.get(i).getId() , this.list3.get(i).getNom() , this.list3.get(i).getPrenom() , "oui"+i
                    
            });
            
        }
        
        
      // test :
     //   this.jTable5.setBackground(Color.ORANGE) ;
    //   this.jTable4.setForeground(Color.WHITE);
   // test :
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
        
        this.jTable1.getSelectionModel().clearSelection() ;
       if(this.jTable1.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(this , "table selection vide") ;
       }
        
        
        Control.setN(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), 1).toString());
        Control.setp(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), 2).toString());
        Control.setCombo(this.jTable5.getValueAt(this.jTable5.getSelectedRow(), 3).toString());
        System.out.println("id "+this.jTable5.getValueAt(this.jTable5.getSelectedRow(), 0).toString() + " "+"nom : "+this.jTable5.getValueAt(this.jTable5.getSelectedRow(), 1).toString()+" "+"nom : "+this.jTable5.getValueAt(this.jTable5.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_jTable5MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        Control ct = new Control() ;
        ct.setVisible(true) ;
        
        
         DefaultListModel dlm = new DefaultListModel() ;
        
        for(int i = 0 ; i < this.list.size() ; i++){
           dlm.addElement(this.list.get(i).getNom()) ;
        }
        
        Control.populateList1(dlm) ;
        
        
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)) ;
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
        
        
          
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:
          
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR)) ;
        
        Control.setIte(this.jList1.getSelectedValue().toString());
        DefaultListModel dlm = new DefaultListModel() ;
        
        for(int i = 0 ; i < this.list.size() ; i++){
           dlm.addElement(this.list.get(i).getNom()) ;
        }
        
        Control.populateList1(dlm) ;
        
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)) ;
        
    }//GEN-LAST:event_jList1MouseClicked

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
            java.util.logging.Logger.getLogger(Alist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private static javax.swing.JTable jTable5;
    // End of variables declaration//GEN-END:variables
}
