package dental_management_system;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author bushra
 */
public class Login_Interface extends javax.swing.JFrame {

    /**
     * Creates new form Login_interface
     */
    public Login_Interface() {
        initComponents();
        this.setLocationRelativeTo(null);
        
         DataBase_Connection conn = new DataBase_Connection();
        
        try
        {
            conn.MakeConnection();

            ResultSet rs = conn.LoadUserTypes();

            while(rs.next())
            {
                jComboBoxUserType.addItem(rs.getString("Type"));
            }
        }
        catch (Exception e)
        {
            
        }
        finally
        {
            try
            {
                conn.CloseConnection();
            }
            catch (Exception e)
            {
                        
            }
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

        label_username = new javax.swing.JLabel();
        Button_SignIn = new javax.swing.JButton();
        Label_heading = new javax.swing.JLabel();
        TextField_username = new javax.swing.JTextField();
        label_PasswordField = new javax.swing.JPasswordField();
        jComboBoxUserType = new javax.swing.JComboBox();
        jLabel_backimage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 610, 492));
        setLocation(new java.awt.Point(100, 500));
        setPreferredSize(new java.awt.Dimension(610, 492));
        setResizable(false);
        getContentPane().setLayout(null);

        label_username.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dental_management_system/images/userbtn.png"))); // NOI18N
        label_username.setText("  UserName");
        getContentPane().add(label_username);
        label_username.setBounds(80, 130, 230, 200);

        Button_SignIn.setBackground(new java.awt.Color(255, 255, 255));
        Button_SignIn.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        Button_SignIn.setForeground(new java.awt.Color(255, 255, 255));
        Button_SignIn.setText("Sign in");
        Button_SignIn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Button_SignIn.setBorderPainted(false);
        Button_SignIn.setContentAreaFilled(false);
        Button_SignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SignInActionPerformed(evt);
            }
        });
        getContentPane().add(Button_SignIn);
        Button_SignIn.setBounds(370, 320, 140, 100);

        Label_heading.setBackground(new java.awt.Color(153, 255, 255));
        Label_heading.setFont(new java.awt.Font("Avenir", 1, 24)); // NOI18N
        Label_heading.setForeground(new java.awt.Color(255, 255, 255));
        Label_heading.setText("  ENTER  CREDIENTIALS");
        getContentPane().add(Label_heading);
        Label_heading.setBounds(150, 20, 310, 48);

        TextField_username.setBackground(new java.awt.Color(0, 153, 255));
        getContentPane().add(TextField_username);
        TextField_username.setBounds(330, 170, 230, 50);

        label_PasswordField.setBackground(new java.awt.Color(0, 153, 255));
        label_PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label_PasswordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(label_PasswordField);
        label_PasswordField.setBounds(330, 230, 230, 50);

        jComboBoxUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUserTypeActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxUserType);
        jComboBoxUserType.setBounds(320, 90, 250, 40);

        jLabel_backimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dental_management_system/images/appbackground.png"))); // NOI18N
        jLabel_backimage.setText("jLabel1");
        getContentPane().add(jLabel_backimage);
        jLabel_backimage.setBounds(0, -110, 610, 790);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label_PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_label_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_label_PasswordFieldActionPerformed

    private void Button_SignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SignInActionPerformed
     User user;
        
        if(jComboBoxUserType.getSelectedItem().toString()=="Receptionist")
        {
            user = new Receptionist(TextField_username.getText(),label_PasswordField.getText(),jComboBoxUserType.getSelectedItem().toString());
        }
        else if(jComboBoxUserType.getSelectedItem().toString()=="Doctor")
        {
            user = new Doctor(TextField_username.getText(),label_PasswordField.getText(),jComboBoxUserType.getSelectedItem().toString());
        }
        else
        {
            user = new Admin(TextField_username.getText(),label_PasswordField.getText(),jComboBoxUserType.getSelectedItem().toString());
        }
        
        
  
        boolean loginStatus = user.UserLogin();
        
        
        if(loginStatus == true)
        {
            JOptionPane.showMessageDialog(rootPane, "Login successful!, welcome "+user.userName);
            
            //if("Receptionist".equals(user.userType) || "Admin".equals(user.userType))
            //{
                new Welcome_page(user).setVisible(true);
                this.setVisible(false); //to close current window
            //}
            //else
           
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Incorrect username or password, please try again!");
                      
    }//GEN-LAST:event_Button_SignInActionPerformed

    private void jComboBoxUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUserTypeActionPerformed

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
            java.util.logging.Logger.getLogger(Login_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_SignIn;
    private javax.swing.JLabel Label_heading;
    private javax.swing.JTextField TextField_username;
    private javax.swing.JComboBox jComboBoxUserType;
    private javax.swing.JLabel jLabel_backimage;
    private javax.swing.JPasswordField label_PasswordField;
    private javax.swing.JLabel label_username;
    // End of variables declaration//GEN-END:variables
}
