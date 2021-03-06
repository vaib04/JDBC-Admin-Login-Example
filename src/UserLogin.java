
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vaibhav
 */
public class UserLogin extends javax.swing.JFrame {

    private final String user;
    static Database database;
    static DB_URL dbUrl;
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql=null;
    static Login L;
    /**
     * Creates new form UserLogin
     * @param user
     */
    public UserLogin(String user) {
        this.user = user;
        dbUrl=new DB_URL();
        database=new Database(dbUrl.URL);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jButtonLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldAmt = new javax.swing.JTextField();
        jButtonTransfer = new javax.swing.JButton();
        jButtonAllTransact = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCurrBal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Logged in:  "+user);

        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        jLabel1.setText("Transfer funds to:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(returnAccountStatus("e",user)));

        jLabel2.setText("Amount to transfer:");

        jButtonTransfer.setText("Transfer");
        jButtonTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransferActionPerformed(evt);
            }
        });

        jButtonAllTransact.setText("View All Transactions");
        jButtonAllTransact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAllTransactActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setText("Current balance = ");

        jTextFieldCurrBal.setEditable(false);
        jTextFieldCurrBal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCurrBalActionPerformed(evt);
            }
        });
        sql="select balance from account where user=?";
        Double bal=0.0;
        try {
            ps=database.conn.prepareStatement(sql);
            ps.setString(1,user);
            rs=ps.executeQuery();
            rs.next();
            bal=rs.getDouble("balance");
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextFieldCurrBal.setText(bal.toString());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonAllTransact)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldCurrBal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jButtonLogout))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonTransfer)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButtonLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTransfer))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCurrBal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAllTransact)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        // TODO add your handling code here:
        System.out.println("Logging out:  "+user);
        L=new Login();
        L.setVisible(true);
        UserLogin.this.dispose();
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jButtonTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransferActionPerformed
        // TODO add your handling code here:
        Double amt,bal=0.0;
        sql="select balance from account where user=?";
            try {
                ps=database.conn.prepareStatement(sql);
                ps.setString(1,user);
                rs=ps.executeQuery();
                rs.next();
                bal=rs.getDouble("balance");
            } catch (SQLException ex) {
                Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextFieldCurrBal.setText(bal.toString());
        String user2=(String) jComboBox1.getSelectedItem();
       
        try {
        amt=Double.parseDouble(jTextFieldAmt.getText());
        }catch(NumberFormatException nfe) {
            
            amt=-1.0;
        }
        if(amt==-1.0) {
            JOptionPane.showMessageDialog(UserLogin.this, "Only numerical data can be entered in Amount field","Nan Value", JOptionPane.ERROR_MESSAGE);
            jTextFieldAmt.setText("");
        }
        else {
            
            System.out.println("Number entered");
            sql="select balance from account where user=?";
            try {
                ps=database.conn.prepareStatement(sql);
                ps.setString(1,user);
                rs=ps.executeQuery();
                rs.next();
                bal=rs.getDouble("balance");
            } catch (SQLException ex) {
                Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            if((bal-amt)<0) {
                JOptionPane.showMessageDialog(UserLogin.this,"Insufficient balance","Balance Low!",JOptionPane.ERROR_MESSAGE);
            }
            else {
                System.out.println("Balance sufficient");
                boolean flag=true;
                bal-=amt;
                sql="update account set balance=? where user=?";
                try {
                    ps=database.conn.prepareStatement(sql);
                    ps.setDouble(1,bal);
                    ps.setString(2,user);
                    ps.executeUpdate();
                    sql="insert into transact values (?,?,?)";
                    ps=database.conn.prepareStatement(sql);
                    ps.setString(1,user);
                    ps.setString(2,user2);
                    ps.setDouble(3,amt);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
                    flag=false;
                }
                if(flag){
                    JOptionPane.showMessageDialog(UserLogin.this,"Transfer successful","Transfer complete",JOptionPane.INFORMATION_MESSAGE);
                    jTextFieldCurrBal.setText(bal.toString());
                }
            }
        }
        jTextFieldAmt.setText("");
        
    }//GEN-LAST:event_jButtonTransferActionPerformed

    private void jButtonAllTransactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAllTransactActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText("");
        sql="select * from transact where user1=?";
        try {
            ps=database.conn.prepareStatement(sql);
            ps.setString(1,user);
            rs=ps.executeQuery();
            while(rs.next()) {
                jTextArea1.append("To: "+rs.getString("user2")+";  Amount= "+rs.getDouble("amount")+"\n-------\n");
            }
            sql="select * from transact where user2=?";
            ps=database.conn.prepareStatement(sql);
            ps.setString(1,user);
            rs=ps.executeQuery();
            while(rs.next()) {
                jTextArea1.append("From: "+rs.getString("user1")+";  Amount= "+rs.getDouble("amount")+"\n-------\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonAllTransactActionPerformed

    private void jTextFieldCurrBalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCurrBalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCurrBalActionPerformed

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
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogin("dummyUser").setVisible(true);
            }
        });
    }
    
    static String[] returnAccountStatus(String id,String uname) {
        sql="select user from account where temp=?";
        System.out.println(id);
        ArrayList<String> names=new ArrayList<>();
        try {
            ps=database.conn.prepareStatement(sql);
            ps.setString(1,id);
            rs=ps.executeQuery();
            while(rs.next()) {
                if(rs.getString("user").equals(uname)) {
                    continue;
                }
                names.add(rs.getString("user"));
            }
            if(!names.isEmpty()) {
                String nameArr[]=new String[names.size()];
                nameArr=names.toArray(nameArr);
                return nameArr;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
            return new String[] {"SQLException"};
        }
        return new String[] {"No accounts enabled"};
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAllTransact;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonTransfer;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldAmt;
    private javax.swing.JTextField jTextFieldCurrBal;
    // End of variables declaration//GEN-END:variables
}
