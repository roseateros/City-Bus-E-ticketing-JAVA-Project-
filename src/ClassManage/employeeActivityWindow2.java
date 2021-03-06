/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassManage;

import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Muiz
 */
public class employeeActivityWindow2 extends javax.swing.JFrame {

    private String driverName;
    private String assistantName;
    private String busID;
    private String busStatus;
    private String routeNumber;

    private String userName;
    private String ticketNumber;
    private String from;
    private String to;
    private String fare;
    private String ID;

    private String newLocation;
    private String newStatus;
    private String takenSeat;
    private String totalSeat;
    
    private String requests = "";
    
    private String[] roadOptions = null;
    private String[] statusOptions = {"Up","Down"};
    
    Date date = Calendar.getInstance().getTime();  
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
    DateFormat dateFormat2 = new SimpleDateFormat("hh:mm:ss");  
    String strDate = dateFormat.format(date);
    String strtime = dateFormat2.format(date);

    private java.sql.Connection con;
  
    
    public employeeActivityWindow2(String name, String id) {
        this.userName = name;
        this.ID = id;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/photo/bus-icon-17.png")));
        
        this.assistantName = name;
		
		String url = "jdbc:mysql://localhost/citybusmgnt";
		String userNamee = "root";
		String pass = "";
		String dID;
		
		
		String query = "select id, driver_id,route_id,bus_status,seat_capacity, seat_taken from bus where assistant_id = " + Integer.parseInt(ID);
		String query1 = null;
		String query2 = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,userNamee,pass);
			//JOptionPane.showMessageDialog(null, "Connected to DataBase");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			busID = rs.getString(1);
			dID = rs.getString(2);
			routeNumber = rs.getString(3);
			busStatus = rs.getString(4);
                        totalSeat = rs.getString(5);
                        takenSeat = rs.getString(6);
                        
			
			//System.out.println(busID + "==" + dID);
			query1 = "select employee_id from driver where id = " + dID;
			ResultSet rs1 = st.executeQuery(query1);
			rs1.next();
			
			//System.out.println(rs1.getString(1));
			String edID = rs1.getString(1);
			
			query2 = "select name from employee where id = " + edID;
			ResultSet rs2 = st.executeQuery(query2);
			rs2.next();
			//System.out.println(rs2.getString(1));
			
			driverName = rs2.getString(1);
			
			con.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
                
                RoadUpdate();
                initComponents();
                seat_txt.setText(takenSeat);
               
    }
    
    
    
    public void RoadUpdate()
	{
		String url = "jdbc:mysql://localhost/citybusmgnt";
		String userName = "root";
		String pass = "";
		
		String query = "SELECT r.all_stopagges FROM route r, bus b WHERE r.id = b.route_id and b.id = " + busID + " ;";
		
		String stoppages = null;
		int sizeStoppages,countStoppages;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");				
			con = DriverManager.getConnection(url,userName,pass);
			//JOptionPane.showMessageDialog(null, "Connected to DataBase");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			rs.next();
			stoppages = rs.getString(1);
			rs.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
		sizeStoppages = stoppages.length();
		for(int i=0;i<sizeStoppages;i++)
		{
			roadOptions = stoppages.split(" "); //entry to stoppages
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
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username_txt = new javax.swing.JLabel();
        logout_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        display2_txt = new javax.swing.JTextArea();
        req_btn = new javax.swing.JButton();
        location_Combo = new javax.swing.JComboBox<>();
        UpdateLocation_btn = new javax.swing.JToggleButton();
        Status_combo = new javax.swing.JComboBox<>();
        busStatus_btn = new javax.swing.JButton();
        seat_txt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Search Buses");

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

        jLabel3.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Date: " + strDate);

        jLabel8.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Login time: "+strtime);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                    .addContainerGap(19, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout_btn)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(216, 216, 216)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel8)
                    .addContainerGap(217, Short.MAX_VALUE)))
        );

        display2_txt.setEditable(false);
        display2_txt.setColumns(20);
        display2_txt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        display2_txt.setRows(5);
        jScrollPane2.setViewportView(display2_txt);

        req_btn.setBackground(new java.awt.Color(102, 0, 153));
        req_btn.setForeground(new java.awt.Color(255, 255, 255));
        req_btn.setText("See new ride requests.. from the users..");
        req_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                req_btnActionPerformed(evt);
            }
        });

        location_Combo.setModel(new javax.swing.DefaultComboBoxModel(roadOptions));
        location_Combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                location_ComboActionPerformed(evt);
            }
        });

        UpdateLocation_btn.setText("Update Bus Location");
        UpdateLocation_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateLocation_btnActionPerformed(evt);
            }
        });

        Status_combo.setModel(new javax.swing.DefaultComboBoxModel(statusOptions));
        Status_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Status_comboActionPerformed(evt);
            }
        });

        busStatus_btn.setText("Update Bus Status");
        busStatus_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busStatus_btnActionPerformed(evt);
            }
        });

        jButton1.setText("Update No. of Seat Taken");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("/" + totalSeat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addComponent(req_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(location_Combo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Status_combo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(seat_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UpdateLocation_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(busStatus_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                        .addGap(48, 48, 48)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(location_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateLocation_btn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Status_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busStatus_btn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(req_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        super.dispose();
        EmployeeLoginWindow2 lw = new EmployeeLoginWindow2();
        lw.setLocationRelativeTo(null);
        lw.setVisible(true);
    }//GEN-LAST:event_logout_btnActionPerformed

    private void location_ComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_location_ComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_location_ComboActionPerformed

    private void Status_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Status_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Status_comboActionPerformed

    private void UpdateLocation_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateLocation_btnActionPerformed
                        String url = "jdbc:mysql://localhost/citybusmgnt";
			String userName = "root";
			String pass = "";
			int srcIndex = -1;
		
                        srcIndex = location_Combo.getSelectedIndex();
                        

                        newLocation = roadOptions[srcIndex];
                        
                        
			String query = "UPDATE bus set current_location = '" + newLocation + "' where id = " + busID;
					
			try
			{
				Statement st = con.createStatement();
				st.executeUpdate(query);
				
				st.close();
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
    }//GEN-LAST:event_UpdateLocation_btnActionPerformed

    private void busStatus_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busStatus_btnActionPerformed
                        String url = "jdbc:mysql://localhost/citybusmgnt";
			String userName = "root";
			String pass = "";
                        
                        int statusIndex = 0;
                        statusIndex = Status_combo.getSelectedIndex();
                        newStatus = statusOptions[statusIndex];
			
			String query = "UPDATE bus set bus_status = '" + newStatus + "' where id = " + busID;
			try
			{
				Statement st = con.createStatement();
				st.executeUpdate(query);
				
				st.close();
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
    }//GEN-LAST:event_busStatus_btnActionPerformed

    
    private void req_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_req_btnActionPerformed
                        String url = "jdbc:mysql://localhost/citybusmgnt";
			String userNamee = "root";
			String pass = "";
			
			String query = "select u.username,t.generated_code , t.fare , t.departure, t.destination from user u, ticket t "
					+ "where u.id = t.user_id and t.bus_id = " + busID + " ;";
			try
			{
				Class.forName("com.mysql.jdbc.Driver");				
				con = DriverManager.getConnection(url,userNamee,pass);
				//JOptionPane.showMessageDialog(null, "Connected to DataBase");
				
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				while(rs.next())
				{
					userName = rs.getString(1);
					ticketNumber = rs.getString(2);
					fare = Float.toString(rs.getFloat(3));
					from = rs.getString(4);
					to = rs.getString(5);
					
                                        
                                        requests += "\n\t\tUSER INFORMATION" 
                                                + "\n\t    User Name               \t:   " + userName +
                                                "\n\t    Ticket Number           \t:   " + ticketNumber +
                                                "\n\t    Current Location        \t:   " + from +
                                                "\n\t    Destination             \t:   " + to +
                                                "\n\t    Fare                    \t:   " + fare;
                                        display2_txt.setText(requests);
				}
				
				rs.close();			
				
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
                        
    }//GEN-LAST:event_req_btnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                        String url = "jdbc:mysql://localhost/citybusmgnt";
			String userNamee = "root";
			String pass = "";
			
                         takenSeat = seat_txt.getText();
                         String query = "update bus set seat_taken = '" + Float.parseFloat(takenSeat) 
							+ "' where id = " + busID;
                                //System.out.println(eid);
                                
				
                        
                      
                        
                        try
			{
				Class.forName("com.mysql.jdbc.Driver");				
				con = DriverManager.getConnection(url,userNamee,pass);
				//JOptionPane.showMessageDialog(null, "Connected to DataBase");
				
				Statement st = con.createStatement();
				st.executeUpdate(query);
				
				con.close();	
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
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
                java.util.logging.Logger.getLogger(employeeActivityWindow2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(employeeActivityWindow2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(employeeActivityWindow2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(employeeActivityWindow2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            //</editor-fold>

            /* Create and display the form */


            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    //new srcDesDecide2("aa","").setVisible(true);
                }
            });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Status_combo;
    private javax.swing.JToggleButton UpdateLocation_btn;
    private javax.swing.JButton busStatus_btn;
    private javax.swing.JTextArea display2_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> location_Combo;
    private javax.swing.JButton logout_btn;
    private javax.swing.JButton req_btn;
    private javax.swing.JTextField seat_txt;
    private javax.swing.JLabel username_txt;
    // End of variables declaration//GEN-END:variables
}
