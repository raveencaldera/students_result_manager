/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.results.management.view;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Lakmal
 */
public class administrator extends javax.swing.JFrame {
    private String role = null;
    /**
     * Creates new form administrator
     * @throws java.io.IOException
     */
    public administrator() throws IOException {
        initComponents();
        setIcon();
    }
    
    public administrator(String role) throws IOException {
        initComponents();
        setIcon();
        this.role = role;
        checkRole();
    }
    
    private void checkRole() {
        switch(role) {
            case "Manager":
                btnDepartment.setEnabled(false);
                btnUser.setEnabled(false);
                break;
            case "Lecturer":
                btnDepartment.setEnabled(false);
                btnUser.setEnabled(false);
                btnBatch.setEnabled(false);
                btnModule.setEnabled(false);
                btnStudent.setEnabled(false);
                break;
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
        btnModule = new javax.swing.JButton();
        btnStudent = new javax.swing.JButton();
        btnDepartment = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btnBatch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student results manager");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnModule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/results/management/assests/notebook.png"))); // NOI18N
        btnModule.setText("Module");
        btnModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModuleActionPerformed(evt);
            }
        });

        btnStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/results/management/assests/user_2.png"))); // NOI18N
        btnStudent.setText("Students");
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });

        btnDepartment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/results/management/assests/home.png"))); // NOI18N
        btnDepartment.setText("Department");
        btnDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartmentActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/results/management/assests/notepad.png"))); // NOI18N
        jButton5.setText("Results");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/results/management/assests/user_1.png"))); // NOI18N
        btnUser.setText("Users");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/results/management/assests/list_1.png"))); // NOI18N
        jButton8.setText("Reports");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btnBatch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/results/management/assests/folder.png"))); // NOI18N
        btnBatch.setText("Batch");
        btnBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnModule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBatch, btnDepartment, btnModule, btnStudent, btnUser, jButton5, jButton8});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModule, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatchActionPerformed
        try {
            JFrame b = new batch(this.role);
            b.setVisible(true);
            setVisible(false);
            dispose();
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBatchActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            JFrame r = new report(this.role);
            r.pack();
            r.setIconImage(ImageIO.read(new File(getClass().getResource("/student/results/management/assests/list.png").getFile())));
            r.setVisible(true);
            setVisible(false);
            dispose();
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        try {
            JFrame u = new user(this.role);
            u.setIconImage(ImageIO.read(new File(getClass().getResource("/student/results/management/assests/list.png").getFile())));
            u.setVisible(true);
            setVisible(false);
            dispose();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUserActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            JFrame r = new results(this.role);
            r.pack();
            r.setIconImage(ImageIO.read(new File(getClass().getResource("/student/results/management/assests/list.png").getFile())));
            r.setLocationRelativeTo(null);
            r.setVisible(true);
            setVisible(false);
            dispose();
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartmentActionPerformed
        try {
            JFrame d = new department(this.role);
            d.pack();
            d.setIconImage(ImageIO.read(new File(getClass().getResource("/student/results/management/assests/list.png").getFile())));
            d.setLocationRelativeTo(null);
            d.setVisible(true);
            setVisible(false);
            dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDepartmentActionPerformed

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        try {
            JFrame s = new student(this.role);
            s.pack();
            s.setIconImage(ImageIO.read(new File(getClass().getResource("/student/results/management/assests/list.png").getFile())));
            s.setTitle("Student results manager");
            s.setLocationRelativeTo(null);
            s.setVisible(true);
            setVisible(false);
            dispose();
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModuleActionPerformed
        try {
            JFrame m = new module(this.role);
            m.pack();
            m.setIconImage(ImageIO.read(new File(getClass().getResource("/student/results/management/assests/list.png").getFile())));
            m.setTitle("Student results manager");
            m.setLocationRelativeTo(null);
            m.setVisible(true);
            setVisible(false);
            dispose();
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModuleActionPerformed

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
            java.util.logging.Logger.getLogger(administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new administrator().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(administrator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void setIcon() throws IOException {
        setIconImage(ImageIO.read(new File(getClass().getResource("/student/results/management/assests/list.png").getFile())));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatch;
    private javax.swing.JButton btnDepartment;
    private javax.swing.JButton btnModule;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnUser;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
