/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassManage;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Muiz Ahmed
 */
public class ticketUserWindow2 extends javax.swing.JFrame {

    private String userName;
    private String busID;
    private String userID;
    private String ticketNumber;
    private String CurrentLocation;
    private String Destination;
    private String fare;
    private String totalDistance;
    
    
    Date date = Calendar.getInstance().getTime();  
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
    DateFormat dateFormat2 = new SimpleDateFormat("hh:mm:ss");  
    String strDate = dateFormat.format(date);
    String strtime = dateFormat2.format(date);

    private Calendar calendar = Calendar.getInstance(); 
    private String display;

    private Connection con;
    /**
     * Creates new form ticketUserWindow2
     */
    public ticketUserWindow2(String userName, String busID,String CurrentLocation,String Destination,String userID,String fare,String totalDistance) {
        this.userName = userName;
        this.busID = busID;
        this.userID = userID;
        this.CurrentLocation = CurrentLocation;
        this.Destination = Destination;
        this.fare = fare;
        this.totalDistance = totalDistance;
        
        
        
        genarateTicketNumber();
        display = "\n  Bus ID: " + busID +
                "\n  Fare: " + fare +
                "\n  Ticket Number: " + ticketNumber +
                " (Show it to the Bus Assistant)" +
                "\n\n  -----------------------------------------------"
                + "\n\n  Please submit your valuable comments And don't forget to rate our Drivers and Assistants.."
                +"\n  Happy riding!!";
        
        getConnection();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/photo/bus-icon-17.png")));
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
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username_txt = new javax.swing.JLabel();
        logout_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        display_txt = new javax.swing.JTextArea();
        DriverRating_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        comment_txt = new javax.swing.JTextArea();
        Submit_btn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AssistantRating_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Rate_btn2 = new javax.swing.JButton();
        Rate_btn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/photo/profile-icons--download-1-130-free-profile-icon-page-1--7.png"))); // NOI18N
        jLabel4.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hello,");

        username_txt.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        username_txt.setForeground(new java.awt.Color(204, 0, 0));
        username_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username_txt.setText(userName+"!");

        logout_btn.setText("Logout");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(102, 0, 153));
        jTextField1.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Current Location:");
        jTextField1.setBorder(null);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(102, 0, 153));
        jTextField2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("Destination:");
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(102, 0, 153));
        jTextField3.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setText(CurrentLocation);
        jTextField3.setBorder(null);

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(102, 0, 153));
        jTextField4.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setText(Destination);
        jTextField4.setBorder(null);

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(102, 0, 153));
        jTextField5.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setText("Distance:");
        jTextField5.setBorder(null);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(102, 0, 153));
        jTextField6.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setText(totalDistance + " km");
        jTextField6.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Date: " + strDate);

        jLabel10.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Login time: "+strtime);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logout_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(back_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(133, 133, 133))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(12, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(username_txt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(back_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout_btn)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(222, 222, 222)
                    .addComponent(jLabel9)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel10)
                    .addContainerGap(223, Short.MAX_VALUE)))
        );

        display_txt.setEditable(false);
        display_txt.setColumns(20);
        display_txt.setRows(5);
        display_txt.setText(display);
        display_txt.setBorder(null);
        jScrollPane1.setViewportView(display_txt);

        DriverRating_txt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Driver:");

        comment_txt.setColumns(20);
        comment_txt.setRows(5);
        jScrollPane2.setViewportView(comment_txt);

        Submit_btn.setText("Submit");
        Submit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Submit_btnActionPerformed(evt);
            }
        });

        jButton2.setText("End Journey");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("/5");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("Assistant:");

        AssistantRating_txt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("/5");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Comment:");

        Rate_btn2.setText("Rate");
        Rate_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rate_btn2ActionPerformed(evt);
            }
        });

        Rate_btn1.setText("Rate");
        Rate_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rate_btn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 440, Short.MAX_VALUE)
                        .addComponent(Submit_btn)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DriverRating_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AssistantRating_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Rate_btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Rate_btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Submit_btn)
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DriverRating_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(Rate_btn2))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AssistantRating_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Rate_btn1)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        super.dispose();
        LoginWindow2 lw = new LoginWindow2();
        lw.setLocationRelativeTo(null);
        lw.setVisible(true);
    }//GEN-LAST:event_logout_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        super.dispose();
        srcDesDecide2 lw = new srcDesDecide2(userName,userID);
        lw.setLocationRelativeTo(null);
        lw.setVisible(true);
    }//GEN-LAST:event_back_btnActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void Rate_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rate_btn2ActionPerformed
                        String eID = null;
			String rate = null;
			String ttrip;
			float temp;
			
			String getRate = DriverRating_txt.getText();
			float rating = Float.parseFloat(getRate);
			
			if(rating>=0 && rating <=5)
			{
				String url = "jdbc:mysql://localhost/citybusmgnt";
				String userName = "root";
				String pass = "";
				
				String query = "select e.id,e.rating, e.total_trip from bus b left join driver d on b.driver_id = d.id "
						+ "left join employee e on d.employee_id = e.id  where b.id = " + Integer.parseInt(busID) + ";";
				
				
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					
					con = DriverManager.getConnection(url,userName,pass);
					
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					rs.next();
					
					eID = rs.getString(1);
					rate = rs.getString(2);
					ttrip = rs.getString(3);
				
					temp = (Float.parseFloat(rate) + rating) / 2 ;
					
					//System.out.println(temp);
					String updateQuery = "update employee set rating = " + temp + ", total_trip = "+ (Integer.parseInt(ttrip) + 1) +" where id = " + Integer.parseInt(eID);
					st.executeUpdate(updateQuery);
					con.close();
				}
				catch(Exception e)
				{
					System.out.println(e.toString());
				}
				
				Rate_btn2.setEnabled(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid Range (0~5)");
			}
			
        
    }//GEN-LAST:event_Rate_btn2ActionPerformed

    private void Rate_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rate_btn1ActionPerformed
       String eID = null;
			String rate = null;
			String ttrip;
			float temp;
			
			String getRate = AssistantRating_txt.getText();
			float rating = Float.parseFloat(getRate);
			
			if(rating>=0 && rating <=5)
			{
				String url = "jdbc:mysql://localhost/citybusmgnt";
				String userName = "root";
				String pass = "";
				
				String query = "select e.id,e.rating, e.total_trip from bus b left join assistant a on b.driver_id = a.id "
						+ "left join employee e on a.employee_id = e.id  where b.id = " + Integer.parseInt(busID) + ";";
				
				
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					
					con = DriverManager.getConnection(url,userName,pass);
					
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					rs.next();
					
					eID = rs.getString(1);
					rate = rs.getString(2);
					ttrip = rs.getString(3);
				
					temp = (Float.parseFloat(rate) + rating) / 2 ;
					
					//System.out.println(temp);
					String updateQuery = "update employee set rating = " + temp + ", total_trip = "+ (Integer.parseInt(ttrip) + 1) +" where id = " + Integer.parseInt(eID);
					st.executeUpdate(updateQuery);
					con.close();
				}
				catch(Exception e)
				{
					System.out.println(e.toString());
				}
				
				Rate_btn1.setEnabled(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid Range (0~5)");
			}
			
    }//GEN-LAST:event_Rate_btn1ActionPerformed

    private void Submit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Submit_btnActionPerformed
                        
                        String getComplain = comment_txt.getText();
			
			String url = "jdbc:mysql://localhost/citybusmgnt";
			String userName = "root";
			String pass = "";
			
			String var = Integer.parseInt(busID) + " , '" + getComplain + "' , ' " + userID + "' ";
			String query = "insert into complain(bus_id,complain,user_id) values(" + var + ") ;";
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection(url,userName,pass);
				
				Statement st = con.createStatement();
				st.executeUpdate(query);
				//System.out.println("Data Entry Successfull");
				
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
		
    }//GEN-LAST:event_Submit_btnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        String url = "jdbc:mysql://localhost/citybusmgnt";
			String userNamee = "root";
			String pass = "";
			
			String query = "select current_location from bus where id = " + busID;
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection(url,userNamee,pass);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				rs.next();
				
				CurrentLocation = rs.getString(1);
				//System.out.println(rs.getString(1));
				
				if(CurrentLocation.equals(Destination))
				{
					JOptionPane.showMessageDialog(null, "You Have Arrived " + Destination);
				}
				else
				{
					con = DriverManager.getConnection(url,userNamee,pass);
					Statement st1 = con.createStatement();
					
					String UpdateQuery = "update user set CurrentLocation = '" + CurrentLocation + "' where id = " + userID;
					
					st1.executeUpdate(UpdateQuery);
					con.close();
				}
				rs.close();				
				
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
        
        updateHistory();
        super.dispose();
        srcDesDecide2 lw = new srcDesDecide2(userName,userID);
        lw.setLocationRelativeTo(null);
        lw.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ticketUserWindow2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ticketUserWindow2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ticketUserWindow2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ticketUserWindow2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               //new ticketUserWindow2().setVisible(true);
            }
        });
    }
    
    
    public void updateHistory()
	{
		String url = "jdbc:mysql://localhost/citybusmgnt";
		String userName = "root";
		String pass = "";
		
		

		int uID = Integer.parseInt(userID);
		int bID = Integer.parseInt(busID);
		float  tdis = Float.parseFloat(totalDistance);
		float f = Float.parseFloat(fare);
		int getID;
				
		//System.out.println(uID + "--" + bID + "--" + CurrentLocation + "--" + Destination + "--" + tdis + "--" + f);
		
		String getIDquery  = "Select count(id) from user_history"; 
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,userName,pass);
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(getIDquery);
			rs.next();
			getID = rs.getInt(1)+1;
			
			String var = getID + ",'" + calendar.getTime() + "'," + uID + "," + bID + ",'" + CurrentLocation + "','" + Destination + "'," + tdis + "," + f;
			String query = "insert into user_history  values(" + var + ") ;";
			
			st.executeUpdate(query);
			//System.out.println("Data Entry Successfull");
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
	}
	
	public void getConnection()
	{
		String url = "jdbc:mysql://localhost/citybusmgnt";
		String userName = "root";
		String pass = "";
		
		String var = "'" + ticketNumber + "' , '" + userID + "' , ' " + busID + "' , ' " +  fare +" ' , ' " + CurrentLocation + " ' , ' " + Destination + " '";
		String query = "insert into ticket values(" + var + ") ;";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,userName,pass);
			
			Statement st = con.createStatement();
			st.executeUpdate(query);
			//System.out.println("Data Entry Successfull");
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	
	}
	
	public void genarateTicketNumber()
	{
		String ticketNo = "12" + busID + userID+strtime;
		ticketNumber = ticketNo;
		//System.out.println(ticketNo);
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AssistantRating_txt;
    private javax.swing.JTextField DriverRating_txt;
    private javax.swing.JButton Rate_btn1;
    private javax.swing.JButton Rate_btn2;
    private javax.swing.JButton Submit_btn;
    private javax.swing.JButton back_btn;
    private javax.swing.JTextArea comment_txt;
    private javax.swing.JTextArea display_txt;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton logout_btn;
    private javax.swing.JLabel username_txt;
    // End of variables declaration//GEN-END:variables
}
