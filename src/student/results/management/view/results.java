/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.results.management.view;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import student.results.management.controller.ResultController;
import student.results.management.modal.Batch;
import student.results.management.modal.Department;
import student.results.management.modal.Module;

/**
 *
 * @author Lakmal
 */
public class results extends javax.swing.JFrame {

    private String role;

    /**
     * Creates new form results
     * @throws java.sql.SQLException
     */
    public results() throws SQLException {
        setIcon();
        initComponents();
        fillTable();
        fillDepartment();
        fillBatch();
        fillModule();
    }
    
    public results(String role) throws IOException, SQLException {
        setIcon();
        initComponents();
        fillTable();
        fillDepartment();
        fillBatch();
        fillModule();
        this.role = role;
        checkRole();
    }
    
    private void setIcon() {
        try {
            setIconImage(ImageIO.read(new File(getClass().getResource("/student/results/management/assests/list.png").getFile())));
        } catch (IOException ex) {
            Logger.getLogger(results.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private void fillTable() throws SQLException {
        ResultController result = new ResultController();
        tblResult.setModel(DbUtils.resultSetToTableModel(result.getAllData()));
    }
    
    private void fillBatch() throws SQLException {
        Batch batch = new Batch();
        ResultSet rs = batch.selectAll();
        while(rs.next())
        {
            cmbBatch.addItem(rs.getString(1) + " - " + rs.getString(3));
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
    
    private void fillModule() throws SQLException {
        Module module = new Module();
        ResultSet rs = module.selectAll();
        while(rs.next())
        {
            cmbModule.addItem(rs.getString(1) + " - " + rs.getString(2));
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
        jLabel4 = new javax.swing.JLabel();
        tfResult = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbYear = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmbSemester = new javax.swing.JComboBox<>();
        tfStudentID = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton32 = new javax.swing.JButton();
        btnDepartment = new javax.swing.JButton();
        btnBatch = new javax.swing.JButton();
        btnModule = new javax.swing.JButton();
        btnStudent = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student results manager");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblResult);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Update new result"));

        jLabel1.setText("Department");

        jLabel2.setText("Batch");

        jLabel3.setText("Module");

        jLabel4.setText("Student ID");

        jLabel5.setText("Result");

        jLabel6.setText("Yaer");

        cmbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));

        jLabel7.setText("Semester");

        cmbSemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbDepartment, 0, 151, Short.MAX_VALUE)
                    .addComponent(tfStudentID))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbModule, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSemester, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfResult, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbBatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbModule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cmbSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(tfStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

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

        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/student/results/management/assests/list_1.png"))); // NOI18N
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
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
                .addComponent(btnReport)
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
                    .addComponent(btnReport))
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
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit)
                        .addGap(0, 298, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            int semester = Integer.parseInt(cmbSemester.getSelectedItem().toString());
            int year = Integer.parseInt(cmbYear.getSelectedItem().toString());
            int module_id = Integer.parseInt(cmbModule.getSelectedItem().toString().split(" - ")[0]);
            int student_id = Integer.parseInt(tfStudentID.getText());
            int marks = Integer.parseInt(tfResult.getText());

            if (marks > 0 && marks <= 100 && student_id > 0) {
                ResultController r = new ResultController();
                r.create(student_id, module_id, year , semester , marks);
                JOptionPane.showMessageDialog(this, "Student has been created", "Done" , JOptionPane.INFORMATION_MESSAGE);
                fillTable();
                tfStudentID.setText("");
                tfResult.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please check inputs", "ERROR" , JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            int row = tblResult.getSelectedRow();
           
            int student_id = (Integer) tblResult.getValueAt(row, 0);
            int module_id = (Integer) tblResult.getValueAt(row, 1);
            
            JTextField year = new JTextField();
            JTextField semester = new JTextField();
            JTextField results = new JTextField();
            
            year.setText(tblResult.getValueAt(row, 2).toString());
            semester.setText(tblResult.getValueAt(row, 3).toString());
            results.setText(tblResult.getValueAt(row, 4).toString());
            
            Object[] message = {
                "Year", year,
                "Semester", semester,
                "Result", results
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Edit Student", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                if (Integer.parseInt(results.getText()) > 0 && Integer.parseInt(results.getText()) <= 100 && student_id > 0) {
                    JOptionPane.showMessageDialog(this, "Student has been updated", "Updated" , JOptionPane.INFORMATION_MESSAGE);
                    ResultController result = new ResultController(); 
                    result.update(student_id, module_id, Integer.parseInt(year.getText()), Integer.parseInt(semester.getText()), Integer.parseInt(results.getText()));
                    fillTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Please re-check inputs", "Updated Error" , JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (HeadlessException | NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

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
            Logger.getLogger(results.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(results.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(results.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(results.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
       try {
            JFrame form = new report(this.role);
            form.setVisible(true);
            setVisible(false);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(results.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReportActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        try {
            JFrame form = new user(this.role);
            form.setVisible(true);
            setVisible(false);
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(results.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new results().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(results.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatch;
    private javax.swing.JButton btnDepartment;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnModule;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnUser;
    private javax.swing.JComboBox<String> cmbBatch;
    private javax.swing.JComboBox<String> cmbDepartment;
    private javax.swing.JComboBox<String> cmbModule;
    private javax.swing.JComboBox<String> cmbSemester;
    private javax.swing.JComboBox<String> cmbYear;
    private javax.swing.JButton jButton32;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextField tfResult;
    private javax.swing.JTextField tfStudentID;
    // End of variables declaration//GEN-END:variables
}
