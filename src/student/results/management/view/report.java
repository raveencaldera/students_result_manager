/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.results.management.view;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import net.proteanit.sql.DbUtils;
import student.results.management.controller.ResultController;
import student.results.management.modal.Batch;
import student.results.management.modal.Department;
import student.results.management.modal.Module;

/**
 *
 * @author Lakmal
 */
public class report extends javax.swing.JFrame {

    private String role;

    /**
     * Creates new form report
     * @throws java.sql.SQLException
     */
    public report() throws SQLException {
        setIcon();
        initComponents();
        fillDepartment();
        fillBatch();
    }
    
    public report(String role) throws IOException, SQLException {
        setIcon();
        initComponents();
        fillDepartment();
        fillBatch();
        this.role = role;
        checkRole();
    }
    
    private void setIcon() {
        try {
            setIconImage(ImageIO.read(new File(getClass().getResource("/student/results/management/assests/list.png").getFile())));
        } catch (IOException ex) {
            Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    private void fillDepartment() throws SQLException {
        Department department = new Department();
        ResultSet rs = department.selectAll();
        while(rs.next())
        {
            cmbDepartment.addItem(rs.getString(1) + " - " + rs.getString(2));
        }
    }
    
    private void fillBatch() throws SQLException {
        Batch batch = new Batch();
        ResultSet rs = batch.selectAll();
        while(rs.next())
        {
            cmbBatch.addItem(rs.getString(1) + " - " + rs.getString(2));
        }
    }
    
    private void fillModule() throws SQLException {
        String batch_id = cmbBatch.getSelectedItem().toString().split(" - ")[0];
        String department_id = cmbDepartment.getSelectedItem().toString().split(" - ")[0];
            
        Module module = new Module();
        ResultSet rs = module.getByDepartmentAndBatch(department_id, batch_id);
        while(rs.next())
        {
            cmbModule.addItem(rs.getString(1) + " - " + rs.getString(2));
        }
        
        btnFind.setEnabled(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbDepartment = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbBatch = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbModule = new javax.swing.JComboBox<>();
        btnFind = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfStudent = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton32 = new javax.swing.JButton();
        btnDepartment = new javax.swing.JButton();
        btnBatch = new javax.swing.JButton();
        btnModule = new javax.swing.JButton();
        btnStudent = new javax.swing.JButton();
        btnResult = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student results manager");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblResult);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Module"));

        jLabel1.setText("Department");

        cmbDepartment.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDepartmentItemStateChanged(evt);
            }
        });
        cmbDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartmentActionPerformed(evt);
            }
        });

        jLabel2.setText("Batch");

        cmbBatch.setEnabled(false);
        cmbBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBatchActionPerformed(evt);
            }
        });

        jLabel3.setText("Module");

        cmbModule.setEnabled(false);
        cmbModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbModuleActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.setEnabled(false);
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbBatch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbModule, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cmbBatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbModule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnFind)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Student"));

        jLabel4.setText("Student ID");

        jButton2.setText("Find");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfStudent))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));

        jButton3.setText("Email semester results to student");

        jButton4.setText("Email semester results to all students");
        jButton4.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/results/management/assests/menu.png"))); // NOI18N
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        btnDepartment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/results/management/assests/home.png"))); // NOI18N
        btnDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartmentActionPerformed(evt);
            }
        });

        btnBatch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/results/management/assests/folder.png"))); // NOI18N
        btnBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatchActionPerformed(evt);
            }
        });

        btnModule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/results/management/assests/notebook.png"))); // NOI18N
        btnModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModuleActionPerformed(evt);
            }
        });

        btnStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/results/management/assests/user_2.png"))); // NOI18N
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });

        btnResult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/results/management/assests/notepad.png"))); // NOI18N
        btnResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultActionPerformed(evt);
            }
        });

        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/results/management/assests/user_1.png"))); // NOI18N
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDepartment)
                .addGap(18, 18, 18)
                .addComponent(btnBatch)
                .addGap(18, 18, 18)
                .addComponent(btnModule)
                .addGap(18, 18, 18)
                .addComponent(btnStudent)
                .addGap(18, 18, 18)
                .addComponent(btnResult)
                .addGap(18, 18, 18)
                .addComponent(btnUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUser)
                    .addComponent(btnModule)
                    .addComponent(btnStudent)
                    .addComponent(btnBatch)
                    .addComponent(btnDepartment)
                    .addComponent(jButton32)
                    .addComponent(btnResult))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartmentActionPerformed
        cmbBatch.setEnabled(true);
    }//GEN-LAST:event_cmbDepartmentActionPerformed

    private void cmbBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBatchActionPerformed
        try {
            cmbModule.removeAllItems();
            fillModule();
            cmbModule.setEnabled(true);
            btnFind.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbBatchActionPerformed

    private void cmbModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbModuleActionPerformed

    }//GEN-LAST:event_cmbModuleActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String module_id = cmbModule.getSelectedItem().toString().split(" - ")[0];
        
        ResultController result = new ResultController();
        tblResult.setModel(DbUtils.resultSetToTableModel(result.getAllDataFromRelatedTable(module_id)));
    }//GEN-LAST:event_btnFindActionPerformed

    private void cmbDepartmentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDepartmentItemStateChanged

    }//GEN-LAST:event_cmbDepartmentItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String student_id = tfStudent.getText();
        
        ResultController result = new ResultController();
        tblResult.setModel(DbUtils.resultSetToTableModel(result.getAllDataByStudentId(student_id)));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        try {
            JFrame admin = new administrator(this.role);
            admin.setVisible(true);
            setVisible(false);
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(department.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton32ActionPerformed

    private void btnBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatchActionPerformed
        try {
            JFrame form = new batch(this.role);
            form.setVisible(true);
            setVisible(false);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(department.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBatchActionPerformed

    private void btnDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartmentActionPerformed
        try {
            JFrame form = new department(this.role);
            form.setVisible(true);
            setVisible(false);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDepartmentActionPerformed

    private void btnModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModuleActionPerformed
        try {
            JFrame form = new module(this.role);
            form.setVisible(true);
            setVisible(false);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModuleActionPerformed

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        try {
            JFrame form = new student(this.role);
            form.setVisible(true);
            setVisible(false);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultActionPerformed
        try {
            JFrame form = new results(this.role);
            form.setVisible(true);
            setVisible(false);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResultActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        try {
            JFrame form = new user(this.role);
            form.setVisible(true);
            setVisible(false);
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUserActionPerformed

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
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new report().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatch;
    private javax.swing.JButton btnDepartment;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnModule;
    private javax.swing.JButton btnResult;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnUser;
    private javax.swing.JComboBox<String> cmbBatch;
    private javax.swing.JComboBox<String> cmbDepartment;
    private javax.swing.JComboBox<String> cmbModule;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextField tfStudent;
    // End of variables declaration//GEN-END:variables
}
