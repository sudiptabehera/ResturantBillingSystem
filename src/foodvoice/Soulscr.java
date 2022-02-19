/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodvoice;

import java.util.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.io.*;
import java.sql.*;
import java.sql.*;  
import javax.swing.table.*;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;
import java.util.List;
import java.io.*;
import static java.lang.Thread.sleep;
import java.sql.*;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
 
/**
 *
 * @author Sudipta Behera
 */

public class Soulscr extends javax.swing.JFrame {
static int v=0;
static int ay=0;
static String total="";
static int checkpur=1;
DefaultTableModel tableModel = new DefaultTableModel();


    public Soulscr() {
    
        initComponents();
       jTextField2.grabFocus();
         
        settable();
        idfetch();
       
        Outletname();
         
        buttongroupingr();
        AutoCompleteDecorator.decorate(jComboBox1);
        AutoCompleteDecorator.decorate(jComboBox2);
        AutoCompleteDecorator.decorate(jComboBox3);
       jComboBox3.addItem(" ");
        Connectforfood();
       
      datespecifing();
         
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
      jTextField1.requestFocus();  
      removeall();
       
    }
    


    private void Outletname()
    {
        try {  
Class.forName("com.mysql.jdbc.Driver");  
Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
Statement st = conn.createStatement();
 ResultSet r=st.executeQuery("select restroid,namer from config");
 System.out.println("nahi re3");
 while (r.next()) {
     int id=Integer.parseInt(r.getString(1));
 if (id==1)
 {
     jLabel2.setText(String.valueOf(r.getString(2)));
 }   
 }
 

    conn.close();
    } catch (Exception e) { 
        System.out.println(e);
System.exit(0);  
}
        
    }
    
    
    private static float roundFloat(float f, int places) {
		 
	    BigDecimal bigDecimal = new BigDecimal(Float.toString(f));
	    bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
	    return bigDecimal.floatValue();
	}
    
   private void settable()
   {
       jTable2.setModel(tableModel);
tableModel.addColumn("Sl no.");
       tableModel.addColumn("Dish");
tableModel.addColumn("Quantity");
tableModel.addColumn("Half/Full");
tableModel.addColumn("Price");
JTableHeader tableHeader = jTable2.getTableHeader();
Font headerFont = new Font("Verdana", Font.PLAIN, 22);
tableHeader.setFont(headerFont);
jTable2.setFont(new Font("Segoe UI", Font.BOLD, 20));
DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
jTable2.getColumn("Sl no.").setCellRenderer( rightRenderer );
jTable2.getColumn("Dish").setCellRenderer( rightRenderer );
jTable2.getColumn("Quantity").setCellRenderer( rightRenderer );
jTable2.getColumn("Half/Full").setCellRenderer( rightRenderer );
DefaultTableCellRenderer center = new DefaultTableCellRenderer();
center.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

jTable2.getColumn("Price").setCellRenderer( center );
jTable2.getColumnModel().getColumn(0).setPreferredWidth(1);
jTable2.getColumnModel().getColumn(1).setPreferredWidth(400);
jTable2.getColumnModel().getColumn(2).setPreferredWidth(1);
jTable2.getColumnModel().getColumn(3).setPreferredWidth(1);
jTable2.getColumnModel().getColumn(4).setPreferredWidth(2);
jTable2.setRowHeight(20);
   }
   private void idfetch()
   {
       try {  
Class.forName("com.mysql.jdbc.Driver");  
int l=0;
System.out.println("nahi re");
Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  

System.out.println("nahi re1");
Statement st = conn.createStatement();

System.out.println("nahi re2");
 ResultSet r=st.executeQuery("select purchaseid from purchase");
 System.out.println("nahi re3");
 while (r.next()) {
     System.out.println("nahi 67");
     int j=Integer.parseInt(r.getString(1));
     if(l<=j)
     {
         l=j+1;
     }}
 jLabel4.setText(String.valueOf(l));


    conn.close();
    } catch (Exception e) { 
        System.out.println("sorry bro");
System.exit(0);  
}
   }       
        
        
    
    public void datespecifing(){
    DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss a");  
   LocalDateTime now = LocalDateTime.now();
         jLabel8.setText(dtf.format(now));
         jLabel3.setText(dt.format(now));
          System.out.println(dt.format(now));
}
    private void buttongroupingr()
    {buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
    }
    private void Connectforfood()
    {
    int remo=jComboBox3.getItemCount();
   
     
        try {   
Class.forName("com.mysql.jdbc.Driver");  

Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
Statement st = conn.createStatement();

 ResultSet r=st.executeQuery("select name from fooditem ORDER BY name");
String arr[];

 while (r.next()) {  

     jComboBox3.addItem(r.getString(1));  
 }


    conn.close();
    } 
        catch (Exception e) { 
        System.out.println("boppaaa lo");
System.exit(0);  
    }
}
    private void newr()
{
 
        int result = JOptionPane.showConfirmDialog(null,"Are you sure?", "Remove all dishes?",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
               try{  tableModel.setRowCount(0);
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
  
PreparedStatement stmt=con.prepareStatement("DELETE FROM orderitem WHERE orderid = ?");
stmt.setString(1,jLabel4.getText());
int o=stmt.executeUpdate();  
System.out.println(o+" deleted"); 
con.close();
  
}catch(Exception e){ System.out.println("bahar kari paribini");}

     
 }
            else if (result == JOptionPane.NO_OPTION){
               
            }
redtotal();    
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSpinner2 = new javax.swing.JSpinner();
        jOptionPane1 = new javax.swing.JOptionPane();
        jLabel18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jPanel1.setMaximumSize(new java.awt.Dimension(1366, 768));
        jPanel1.setMinimumSize(new java.awt.Dimension(1366, 768));

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Invoice Details");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 28)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Customer name:");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 28)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Address:");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 28)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Type:");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 28)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Table:");
        jLabel12.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 28)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Service Provider:");
        jLabel13.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 28)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Agent name:");
        jLabel14.setEnabled(false);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField1.setText(" ");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField6.setEnabled(false);
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Swiggy", "Zomato", "Food Panda", "Uber Eats" }));
        jComboBox1.setEnabled(false);

        jRadioButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Takeaway");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jRadioButton2.setText("Dine In");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jRadioButton3.setText("Delivery");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " " }));
        jComboBox2.setEnabled(false);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        jComboBox4.setEnabled(false);
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(56, 56, 56))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton1))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
        );

        jPanel4.setBackground(new java.awt.Color(102, 153, 255));
        jPanel4.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanel4PropertyChange(evt);
            }
        });

        jComboBox3.setBackground(new java.awt.Color(0, 204, 102));
        jComboBox3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(0, 0, 255));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jComboBox3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox3PropertyChange(evt);
            }
        });
        jComboBox3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox3KeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSpinner1.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        jSpinner1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSpinner1PropertyChange(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel1.setText("Quantity");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jRadioButton4.setText("Half");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jRadioButton5.setText("Full");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel15.setText("Partition");

        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Configure");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel16.setText("Price");

        jLabel17.setBackground(new java.awt.Color(255, 0, 102));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 0, 153));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setToolTipText("0000");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButton10.setText("Refresh");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton5)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(102, 153, 255));

        jButton4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jButton4.setText("Remove");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jButton5.setText("Remove all");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dish", "Quantity", "Half/Full", "Price"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jSpinner2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner2StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(511, 511, 511)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel6.setBackground(new java.awt.Color(255, 102, 102));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Sub-Total");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Discount");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("GST");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Grand-Total");

        jLabel23.setBackground(new java.awt.Color(255, 0, 102));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("0");
        jLabel23.setToolTipText("0000");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel24.setBackground(new java.awt.Color(255, 0, 102));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("0");
        jLabel24.setToolTipText("0000");
        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel25.setBackground(new java.awt.Color(255, 0, 102));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("0");
        jLabel25.setToolTipText("0000");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("%");

        jButton7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jButton7.setText("Save");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jButton8.setText("Preview and Print");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel27.setBackground(new java.awt.Color(255, 0, 102));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 153));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("0");
        jLabel27.setToolTipText("0000");
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinner3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        jSpinner3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner3StateChanged(evt);
            }
        });
        jSpinner3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSpinner3PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)))
                .addGap(220, 220, 220))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(102, 0, 102));
        jPanel7.setPreferredSize(new java.awt.Dimension(1336, 62));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Outlet name or logo");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("from dabase");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 204));
        jLabel5.setText("Invoice No.");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Date");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("from function");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Time");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("from function");

        jButton9.setBackground(new java.awt.Color(153, 255, 255));
        jButton9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(153, 0, 153));
        jButton9.setText("NEW");
        jButton9.setFocusable(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton6.setText("<-- Back");
        jButton6.setFocusCycleRoot(true);
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 995, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)))
                                .addComponent(jLabel2))
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jLabel4.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1815, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1830, 1196);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
jLabel12.setEnabled(true);
jComboBox2.setEnabled(true);
jComboBox4.setEnabled(true);
jLabel13.setEnabled(false);
jLabel14.setEnabled(false);
jComboBox1.setEnabled(false);
jTextField6.setEnabled(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
jLabel13.setEnabled(true);
jLabel14.setEnabled(true);
jComboBox1.setEnabled(true);
jTextField6.setEnabled(true);
jLabel12.setEnabled(false);
jComboBox2.setEnabled(false);
jComboBox4.setEnabled(false);// TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        jLabel12.setEnabled(false);
jComboBox2.setEnabled(false);
jLabel13.setEnabled(false);
jLabel14.setEnabled(false);
jComboBox1.setEnabled(false);
jTextField6.setEnabled(false);
jComboBox4.setEnabled(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        new Configue().setVisible(true); 
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String qty=String.valueOf(jSpinner1.getValue().toString());
String foodn=jComboBox3.getSelectedItem().toString();
String prc=jLabel17.getText();
String idn=jLabel4.getText();
String half;
String food="";

if(jRadioButton4.isSelected()&&jRadioButton4.isEnabled())
{
   half="Half";
}
else if(jRadioButton5.isSelected()&&jRadioButton5.isEnabled())
{
   half="Full";
}
else
{
    half="NA";
}
try {  
Class.forName("com.mysql.jdbc.Driver");  

Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
Statement st = conn.createStatement();

 ResultSet r=st.executeQuery("select foodid,name from fooditem");
 while (r.next()) {
     String value=r.getString(2);
     if(value.equals(foodn))
     {food=r.getString(1);
     }}


    conn.close();
    } catch (Exception e) { 
        System.out.println(e);
System.exit(0);  
}
try{  
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
  
PreparedStatement stmt=con.prepareStatement("insert into orderitem (orderid,foodid,quantity,half,unitprice) values(?,?,?,?,?)");
stmt.setString(1,idn);
stmt.setString(2,food);
stmt.setString(3,qty);
stmt.setString(4,half);
stmt.setString(5,prc);
int i=stmt.executeUpdate();  
System.out.println(i+" records inserted"); 
con.close();
  
}catch(Exception e){ System.out.println("pasae paribini");}

ay=ay+1;
tableModel.insertRow(0, new Object[] { ay,foodn,qty,half,prc });
jTable2.setRowHeight(33);


jComboBox3.setSelectedItem(" ");
jSpinner1.setValue(0);
jRadioButton4.setSelected(true);
jLabel17.setText("0.00");
total=String.valueOf(jTable2.getModel().getValueAt(0,0));
redtotal(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel4PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanel4PropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel4PropertyChange

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
try {  
Class.forName("com.mysql.jdbc.Driver");  

Connection conne= DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
Statement st = conne.createStatement();

 ResultSet rs=st.executeQuery("select name, halfprice from fooditem");
 String value=jComboBox3.getSelectedItem().toString();
 while (rs.next()) {
     String value2=rs.getString(1);
     System.out.println(value+value2);
     if(value2.equals(value))
     {int i=Integer.parseInt(jSpinner1.getValue().toString());
         float j=Float.parseFloat(rs.getString(2));
         j=i*j;
         j=roundFloat(j,2);
         DecimalFormat decim = new DecimalFormat("0.00");
         
           
         jLabel17.setText(String.valueOf(decim.format(j)));
         System.out.println("sorry paisa miluni para beda");
     }}


    conne.close();
    } catch (Exception e) { 
        System.out.println("sorry paisa miluni");
System.exit(0);  
}        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
try {  
Class.forName("com.mysql.jdbc.Driver");  

Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
Statement st = conn.createStatement();

 ResultSet rs=st.executeQuery("select name,fullprice from fooditem");
 String value=jComboBox3.getSelectedItem().toString();
 while (rs.next()) {
     String value2=rs.getString(1);
     System.out.println(value+value2);
     if(value2.equals(value))
     {int i=Integer.parseInt(jSpinner1.getValue().toString());
         float j=Float.parseFloat(rs.getString(2));
         j=roundFloat(j,2);
         j=i*j;
          j=roundFloat(j,2);
          DecimalFormat decim = new DecimalFormat("0.00");
         
           
         jLabel17.setText(String.valueOf(decim.format(j)));
         
         System.out.println("sorry paisa miluni para beda");
     }}


    conn.close();
    } 
        catch (Exception e) { 
        System.out.println("sorry paisa dekhai hauni full");
        System.exit(0);  
}  
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jComboBox3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox3PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3PropertyChange

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
try {
 
Class.forName("com.mysql.jdbc.Driver");  
jLabel17.setText("");
Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
Statement st = conn.createStatement();
jRadioButton4.setEnabled(true);
         jRadioButton5.setEnabled(true);
         jLabel15.setEnabled(true);
 ResultSet r=st.executeQuery("select name,halfprice,fullprice from fooditem");
 
     
 String value=jComboBox3.getSelectedItem().toString();
 while (r.next()) {
     String value2=r.getString(1);
     String value3=r.getString(2);
     String value4=r.getString(3);
     
     if(value2.equals(value)&&value3.equals(value4))
     {   jRadioButton4.setSelected(true);
         jRadioButton4.setEnabled(false);
         jRadioButton5.setEnabled(false);
         jLabel15.setEnabled(false);
         int i=Integer.parseInt(jSpinner1.getValue().toString());
         float j=Float.valueOf(r.getString(2));
         j=i*j;
         j=roundFloat(j,2);
         jLabel17.setText(String.valueOf(j));
         
     }
     }


    conn.close();
    } 
        catch (Exception e) { 
        System.out.println(e);
        System.exit(0);  
}

        
  


// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3KeyPressed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        if(jRadioButton4.isSelected())
        {try {  
Class.forName("com.mysql.jdbc.Driver");  

Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
Statement st = conn.createStatement();

 ResultSet rs=st.executeQuery("select name,halfprice from fooditem");
 String value=jComboBox3.getSelectedItem().toString();
 while (rs.next()) {
     String value2=rs.getString(1);
     System.out.println(value+value2);
     if(value2.equals(value))
     {int i=Integer.parseInt(jSpinner1.getValue().toString());
         float j=Float.parseFloat(rs.getString(2));
         j=roundFloat(j,2);
         j=i*j;
          j=roundFloat(j,2);
          DecimalFormat decim = new DecimalFormat("0.00");
         
           
         jLabel17.setText(String.valueOf(decim.format(j)));
           
         System.out.println("sorry paisa miluni para beda");
     }}


    conn.close();
    } 
        catch (Exception e) { 
        System.out.println("sorry");
        System.exit(0);  
} } 
        else if(jRadioButton5.isSelected())
        {try {  
Class.forName("com.mysql.jdbc.Driver");  

Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
Statement st = conn.createStatement();

 ResultSet rs=st.executeQuery("select name,fullprice from fooditem");
 String value=jComboBox3.getSelectedItem().toString();
 while (rs.next()) {
     String value2=rs.getString(1);
     System.out.println(value+value2);
     if(value2.equals(value))
     {int i=Integer.parseInt(jSpinner1.getValue().toString());
         float j=Float.parseFloat(rs.getString(2));
         j=i*j;
         j=roundFloat(j,2);
         DecimalFormat decim = new DecimalFormat("0.00");
         
           
         jLabel17.setText(String.valueOf(decim.format(j)));
           
         System.out.println("sorry paisa miluni para beda");
     }}


    conn.close();
    } 
        catch (Exception e) { 
        System.out.println("sorry soinner bhai");
        System.exit(0);  
}  }
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
jComboBox3.setSelectedItem(" ");
jSpinner1.setValue(0);
jRadioButton4.setSelected(true);
jLabel17.setText("0.00");// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
ay=ay-1;
int i=Integer.parseInt(jSpinner2.getValue().toString());
int q=0;
int p=5;

String check="";
String foodd="";
String food="";
String half;

for(q=0;q<tableModel.getRowCount();q++)
{
   check=String.valueOf(jTable2.getModel().getValueAt(q,0));
   
 if(Integer.parseInt(check)==i)
 {
     foodd=String.valueOf(jTable2.getModel().getValueAt(q,1));
     half=String.valueOf(jTable2.getModel().getValueAt(q,3));
     try {  
Class.forName("com.mysql.jdbc.Driver");  

Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
Statement st = conn.createStatement();

 ResultSet r=st.executeQuery("select foodid,name from fooditem");
 while (r.next()) {
     String value=r.getString(2);
     if(value.equals(foodd))
     {food=r.getString(1);
     }}


    conn.close();
    } catch (Exception e) { 
        System.out.println("sorry food id extraction");
System.exit(0);}
     try{  
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
  
PreparedStatement stmt=con.prepareStatement("DELETE FROM orderitem WHERE orderid = ? AND foodid = ? AND half = ?");
stmt.setString(1,jLabel4.getText());
stmt.setString(2,food);
stmt.setString(3,half);
int o=stmt.executeUpdate();  
System.out.println(o+" deleted"); 
con.close();
  tableModel.removeRow(tableModel.getRowCount()-Integer.parseInt(check));
  int g=tableModel.getRowCount();
  for(q=0;q<tableModel.getRowCount();q++)
{
System.out.println("eee bhai loopu");
   jTable2.setValueAt(g,q,0);
   
   System.out.println(g--);
}
  redtotal(); 
  
}catch(Exception e){ System.out.println("bahar kari paribini");}

     
 }
 
}


// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner2StateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
newr();
        
            // Saving code her
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {  
Class.forName("com.mysql.jdbc.Driver");  

Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
Statement st = conn.createStatement();

 ResultSet r=st.executeQuery("select purchaseid from purchase");
 while (r.next()) {
     String value=r.getString(1);
     System.out.println("Checkpur dekhe "+r.getString(1));
     if(value.equals(jLabel4.getText()))
     {checkpur=0;
         System.out.println("Checkpur dekhe "+checkpur);
     break;
     }}


    conn.close();
    } catch (Exception e) { 
        System.out.println("sorry food id extraction");
System.exit(0);}
    
        
        
        try{redtotal();  
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
PreparedStatement stmt;
 if(checkpur==1)
 stmt=con.prepareStatement("insert into customer (address,namec,customerid) values(?,?,?)");
 
 
 else
     stmt=con.prepareStatement("update customer set address=?,namec=? where customerid=?");
     
stmt.setString(3,jLabel4.getText());
stmt.setString(1,jTextField1.getText());
stmt.setString(2,jTextField2.getText());
int o=stmt.executeUpdate();  
System.out.println(o+" deleted"); 

PreparedStatement pstmt;

if(checkpur==1)
pstmt=con.prepareStatement("insert into purchase (purchasedate,time,type,grandtotal,discount,tablenumber,serviceprovider,agent,subtotal,discountval,gst,purchaseid) values(?,?,?,?,?,?,?,?,?,?,?,?)");
else
pstmt=con.prepareStatement("update purchase set purchasedate=?,time=?,type=?,grandtotal=?,discount=?,tablenumber=?,serviceprovider=?,agent=?,subtotal=?,discountval=?,gst=? where purchaseid=?");
            System.out.println("hauchi bhai tame dekha ta!");
pstmt.setString(12,jLabel4.getText());
pstmt.setString(1,jLabel3.getText());
pstmt.setString(2,jLabel8.getText());
if(jRadioButton1.isSelected())
{  pstmt.setString(3,"Takeaway");
pstmt.setString(6,"NA");
pstmt.setString(7,"NA");
pstmt.setString(8,"NA");
}
else if(jRadioButton2.isSelected())
{ pstmt.setString(3,"Dine In");
pstmt.setString(6,jComboBox2.getSelectedItem().toString()+"-"+jComboBox4.getSelectedItem().toString());
pstmt.setString(7,"NA");
pstmt.setString(8,"NA");
}
else if(jRadioButton3.isSelected())
{pstmt.setString(3,"Delivery");
pstmt.setString(6,"NA");
pstmt.setString(7,jComboBox1.getSelectedItem().toString());
pstmt.setString(8,jTextField6.getText());
} 
String diss=String.valueOf(jSpinner3.getValue().toString());
pstmt.setString(4,jLabel25.getText());
pstmt.setString(5,diss);
pstmt.setString(9,jLabel23.getText());
pstmt.setString(10,jLabel27.getText());
pstmt.setString(11,jLabel24.getText());
int i=pstmt.executeUpdate();  
System.out.println(i+" records inserted"); 
con.close();
JOptionPane.showMessageDialog(null,"Details Saved!", "Updated", JOptionPane.INFORMATION_MESSAGE);

  
  
}catch(Exception e){ System.out.println(e);}

     
    // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    try {
        Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");
        InputStream in=new FileInputStream(new File("C:\\Users\\Sudipta Behera\\Documents\\NetBeansProjects\\Foodvoice\\report1.jrxml"));
        JasperDesign jd=JRXmlLoader.load(in);
        int l=Integer.valueOf(jLabel4.getText());
        String sql="select * from config cf, customer c, fooditem f, orderitem o, purchase p where c.customerid=p.purchaseid and f.foodid=o.foodid And o.orderid=p.purchaseid And p.purchaseid="+l;
        JRDesignQuery newQuery=new JRDesignQuery();
        newQuery.setText(sql);
        jd.setQuery(newQuery);
        JasperReport jr=JasperCompileManager.compileReport(jd);
        HashMap para=new HashMap();
        JasperPrint j=JasperFillManager.fillReport(jr,para,con);
        JasperViewer.viewReport( j,false);
        
         JasperExportManager.exportReportToPdfFile(j,"D:\\Bill Backup\\"+jLabel4.getText()+"report.pdf");
        
// TODO add your handling code here:
    } 
    catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        
    }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jSpinner1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSpinner1PropertyChange
if(jRadioButton4.isSelected())
        {try {  
Class.forName("com.mysql.jdbc.Driver");  

Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
Statement st = conn.createStatement();

 ResultSet rs=st.executeQuery("select name,halfprice from fooditem");
 String value=jComboBox3.getSelectedItem().toString();
 while (rs.next()) {
     String value2=rs.getString(1);
     System.out.println(value+value2);
     if(value2.equals(value))
     {int i=Integer.parseInt(jSpinner1.getValue().toString());
         float j=Float.parseFloat(rs.getString(2));
         j=roundFloat(j,2);
         j=i*j;
          j=roundFloat(j,2);
          DecimalFormat decim = new DecimalFormat("0.00");
         
           
         jLabel17.setText(String.valueOf(decim.format(j)));
           
         System.out.println("sorry paisa miluni para beda");
     }}


    conn.close();
    } 
        catch (Exception e) { 
        System.out.println(e);
        System.exit(0);  
} } 
        else if(jRadioButton5.isSelected())
        {try {  
Class.forName("com.mysql.jdbc.Driver");  

Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
Statement st = conn.createStatement();

 ResultSet rs=st.executeQuery("select name,fullprice from fooditem");
 String value=jComboBox3.getSelectedItem().toString();
 while (rs.next()) {
     String value2=rs.getString(1);
     System.out.println(value+value2);
     if(value2.equals(value))
     {int i=Integer.parseInt(jSpinner1.getValue().toString());
         float j=Float.parseFloat(rs.getString(2));
         j=i*j;
         j=roundFloat(j,2);
         DecimalFormat decim = new DecimalFormat("0.00");
         
           
         jLabel17.setText(String.valueOf(decim.format(j)));
           
         System.out.println("sorry paisa miluni para beda");
     }}


    conn.close();
    } 
        catch (Exception e) { 
        System.out.println("sorry soinner bhai");
        System.exit(0);  
}  }        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner1PropertyChange

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
new Soulscr().setVisible(true);
        this.setVisible(false);  
// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

int i=jComboBox3.getItemCount();
for(i=jComboBox3.getItemCount()-1;i>0;i--)
{   
    jComboBox3.removeItemAt(i);
}
jComboBox3.addItem(" ");
jComboBox3.removeItemAt(0);


        Connectforfood();
        JOptionPane.showMessageDialog(null," Updated list Successfully", "Updated", JOptionPane.INFORMATION_MESSAGE);// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jSpinner3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSpinner3PropertyChange
redtotal();        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner3PropertyChange

    private void jSpinner3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner3StateChanged
redtotal();         // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner3StateChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed
public void redtotal()
{
    
        float f=0;
try {  
Class.forName("com.mysql.jdbc.Driver");  
Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
Statement st = conn.createStatement();
 ResultSet r=st.executeQuery("select unitprice,orderid from orderitem");
  f=0;
 while (r.next()) {
     String value2=r.getString(1);
     String value3=r.getString(2);
     
     if(value3.equals(jLabel4.getText()))
     {   
         f=f+Float.valueOf(value2);
         
     }
     }
 DecimalFormat decim = new DecimalFormat("0.00");
         
           
         jLabel23.setText(String.valueOf(decim.format(f)));

 float disco=(Float.valueOf(jSpinner3.getValue().toString())/100)*f;

 jLabel27.setText(String.valueOf(decim.format(disco)));

 f=f-disco;
 float per=0.08f;
 
 disco=per*f;
 jLabel24.setText(String.valueOf(decim.format(disco)));
 f=f+disco;
 jLabel25.setText(String.valueOf(decim.format(f)));
 
 
 
 


    conn.close();
    } 
        catch (Exception e) { 
        System.out.println(e);
        System.exit(0);  
}
}
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
            java.util.logging.Logger.getLogger(Soulscr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Soulscr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Soulscr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Soulscr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Soulscr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables

    private void removeall() {
        try{
        tableModel.setRowCount(0);
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restrovoice1","root","");  
  
PreparedStatement stmt=con.prepareStatement("DELETE FROM orderitem WHERE orderid = ?");
stmt.setString(1,jLabel4.getText());
int o=stmt.executeUpdate();  
System.out.println(o+" deleted"); 
con.close();//To change body of generated methods, choose Tools | Templates.
    }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
}
