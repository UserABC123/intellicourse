/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.UserControl;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import model.user.UserType;

/**
 *
 * @author Raphael
 */
public class LoginView extends javax.swing.JFrame
{

    public static String loginTitle = "Login";
    public static String registerTitle = "Register";
    private UserControl uc;

    /**
     * Creates new form LoginView
     */
    public LoginView(UserControl uc)
    {
        initComponents();
        this.uc = uc;
        this.setTitle(loginTitle);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfPassword = new javax.swing.JTextField();
        btLogin = new javax.swing.JButton();
        btSwitchToRegister = new javax.swing.JButton();
        registerPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfRegUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfRegPassword = new javax.swing.JTextField();
        btRegister = new javax.swing.JButton();
        btSwitchToLogin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfRegMatNumber = new javax.swing.JTextField();
        cbMatNumber = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 300));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        mainPanel.setMinimumSize(new java.awt.Dimension(160, 250));
        mainPanel.setLayout(new java.awt.CardLayout());

        java.awt.GridBagLayout loginPanelLayout = new java.awt.GridBagLayout();
        loginPanelLayout.columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0};
        loginPanel.setLayout(loginPanelLayout);

        jLabel1.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 0, 9);
        loginPanel.add(jLabel1, gridBagConstraints);

        tfUsername.setMaximumSize(new java.awt.Dimension(250, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 9, 0, 9);
        loginPanel.add(tfUsername, gridBagConstraints);

        jLabel2.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 0, 9);
        loginPanel.add(jLabel2, gridBagConstraints);

        tfPassword.setMaximumSize(new java.awt.Dimension(250, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 9, 4, 9);
        loginPanel.add(tfPassword, gridBagConstraints);

        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btLoginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 4, 9);
        loginPanel.add(btLogin, gridBagConstraints);

        btSwitchToRegister.setText("Register");
        btSwitchToRegister.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btSwitchToRegisterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 4, 9);
        loginPanel.add(btSwitchToRegister, gridBagConstraints);

        mainPanel.add(loginPanel, "login");

        java.awt.GridBagLayout registerPanelLayout = new java.awt.GridBagLayout();
        registerPanelLayout.columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0};
        registerPanel.setLayout(registerPanelLayout);

        jLabel3.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        registerPanel.add(jLabel3, gridBagConstraints);

        tfRegUsername.setMaximumSize(new java.awt.Dimension(200, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        registerPanel.add(tfRegUsername, gridBagConstraints);

        jLabel4.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        registerPanel.add(jLabel4, gridBagConstraints);

        tfRegPassword.setMaximumSize(new java.awt.Dimension(250, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        registerPanel.add(tfRegPassword, gridBagConstraints);

        btRegister.setText("Register");
        btRegister.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btRegisterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 9, 4, 9);
        registerPanel.add(btRegister, gridBagConstraints);

        btSwitchToLogin.setText("Login");
        btSwitchToLogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btSwitchToLoginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 9, 4, 9);
        registerPanel.add(btSwitchToLogin, gridBagConstraints);

        jLabel5.setText("Matriculation Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        registerPanel.add(jLabel5, gridBagConstraints);

        tfRegMatNumber.setMaximumSize(new java.awt.Dimension(250, 50));
        tfRegMatNumber.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                tfRegMatNumberKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        registerPanel.add(tfRegMatNumber, gridBagConstraints);

        cbMatNumber.setText("I do not have a matriculation Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        registerPanel.add(cbMatNumber, gridBagConstraints);

        mainPanel.add(registerPanel, "register");

        getContentPane().add(mainPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSwitchToRegisterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btSwitchToRegisterActionPerformed
    {//GEN-HEADEREND:event_btSwitchToRegisterActionPerformed
        CardLayout card = (CardLayout) mainPanel.getLayout();
        tfRegUsername.setText(tfUsername.getText());
        tfRegPassword.setText(tfPassword.getText());
        card.show(mainPanel, "register");
        this.setTitle(registerTitle);
    }//GEN-LAST:event_btSwitchToRegisterActionPerformed

    private void btRegisterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btRegisterActionPerformed
    {//GEN-HEADEREND:event_btRegisterActionPerformed
        String matNumber;
        // No username or password
        if (tfRegUsername.getText().equals("") || tfRegPassword.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Registration data is missing", "Registration failed", 0);
            return;
        }
        // Valid input without matriculation number
        else if (tfRegMatNumber.getText().equals("") && !cbMatNumber.isSelected())
        {
            if (!cbMatNumber.isVisible())
            {
                cbMatNumber.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "You need to agree that you do not have a matriculation number", "Registration failed", 0);
            }
            return;
        }
        else if(cbMatNumber.isSelected() && tfRegMatNumber.getText().equals(""))
        {
            matNumber = null;
        }
        // Valid input with matriculation number
        else
        {
            matNumber = tfRegMatNumber.getText();
        }
        if(!registerAndLogin(matNumber))
        {
             JOptionPane.showMessageDialog(rootPane, "The name you have chosen already exists", "Registration failed", 0);   
        }
    }//GEN-LAST:event_btRegisterActionPerformed

    private boolean registerAndLogin(String matNumberStr)
    {
        boolean result = false;
        if (matNumberStr != null)
        {
            try
            {
                int matNumber = Integer.parseInt(matNumberStr);
                result = uc.addUser(tfRegUsername.getText(), tfRegPassword.getText(), UserType.DEFAULT, matNumber);
            }
            catch (NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(rootPane, "Your matriculation number must be a positive integer", "Registration failed", 0);
            }
        }
        else
        {
            result = uc.addUser(tfRegUsername.getText(), tfRegPassword.getText(), UserType.DEFAULT, null);
        }

        if (result)
        {
            result = uc.logIn(tfRegUsername.getText(), tfRegPassword.getText());
            if (result)
            {
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "An unexpected error during login happened - please try again", "Login failed", 0);
            }
        }
        return result;
    }

    private void btSwitchToLoginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btSwitchToLoginActionPerformed
    {//GEN-HEADEREND:event_btSwitchToLoginActionPerformed
        CardLayout card = (CardLayout) mainPanel.getLayout();
        tfUsername.setText(tfRegUsername.getText());
        tfPassword.setText(tfRegPassword.getText());
        card.show(mainPanel, "login");
        this.setTitle(loginTitle);
    }//GEN-LAST:event_btSwitchToLoginActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btLoginActionPerformed
    {//GEN-HEADEREND:event_btLoginActionPerformed
        if (tfUsername.getText().equals("") || tfPassword.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Login data is missing", "Login failed", 0);
        }
        else if (uc.logIn(tfUsername.getText(), tfPassword.getText()))
        {
            dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Login data was incorrect", "Login failed", 0);
        }
    }//GEN-LAST:event_btLoginActionPerformed

    private void tfRegMatNumberKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_tfRegMatNumberKeyReleased
    {//GEN-HEADEREND:event_tfRegMatNumberKeyReleased
        if (!tfRegMatNumber.getText().equals(""))
        {
            cbMatNumber.setSelected(false);
            cbMatNumber.setVisible(false);
        }
        else
        {
            cbMatNumber.setVisible(true);
        }
    }//GEN-LAST:event_tfRegMatNumberKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btRegister;
    private javax.swing.JButton btSwitchToLogin;
    private javax.swing.JButton btSwitchToRegister;
    private javax.swing.JCheckBox cbMatNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfRegMatNumber;
    private javax.swing.JTextField tfRegPassword;
    private javax.swing.JTextField tfRegUsername;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}