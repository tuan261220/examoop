/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import object.*;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ExamHome extends javax.swing.JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int tongCau;

    public static float tongDiem;

    public static String monHoc;

    public static long time;

    public static String maDe;

    //private String userName;

    /**
     * Creates new form Home
     */
    public ExamHome() {
        initComponents();   
        this.setTitle("Thi trắc nghiệm ");
        JTreeProcess.setSubjectCombox(cbMonHoc, ExamQuery.getArraySubject());
        //System.out.println("JComboBox " + cbMonHoc);

        String monHoc = cbMonHoc.getItemAt(0).toString().trim();

        String maMon = ExamQuery.getMaMonHoc(monHoc);

        cbDeThi.removeAllItems();
        JTreeProcess.setSubjectCombox(cbDeThi, ExamQuery.getListDeThi(maMon));
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
        cbMonHoc = new javax.swing.JComboBox();
        cbDeThi = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(Color.decode("#4CAF50")
        );

        cbMonHoc.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        cbMonHoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chọn môn học" }));
        cbMonHoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMonHocItemStateChanged(evt);
            }
        });

        cbDeThi.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        cbDeThi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        cbDeThi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDeThiItemStateChanged(evt);
            }
        });

        jButton1.setText("Thi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jButton1)))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMonHocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMonHocItemStateChanged
        // TODO add your handling code here:
        String monHoc = cbMonHoc.getSelectedItem().toString().trim();

        String maMon = ExamQuery.getMaMonHoc(monHoc);

        cbDeThi.removeAllItems(); 
        JTreeProcess.setSubjectCombox(cbDeThi, ExamQuery.getListDeThi(maMon));
    }//GEN-LAST:event_cbMonHocItemStateChanged

    private void cbDeThiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDeThiItemStateChanged
        // TODO add your handling code here:

        //String monHoc = cbMonHoc.getSelectedItem().toString().trim();

        //String maMon = ExamQuery.getMaMonHoc(monHoc);

        if (cbDeThi.getSelectedItem() != null) {
            String maDe = cbDeThi.getSelectedItem().toString().trim();

            Exam rs = ExamQuery.getDeThi(maDe);

            tongCau = rs.getTotalQuestion();

            tongDiem = rs.getPoint();

            time = rs.getTime();
        } else {
        }
    }//GEN-LAST:event_cbDeThiItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        maDe = cbDeThi.getSelectedItem().toString().trim();

        monHoc = cbMonHoc.getSelectedItem().toString().trim();

        System.out.println("MD" + time + "diem" + tongDiem);
        ExamTest hsTest = new ExamTest();

        dispose();
        hsTest.setLocationRelativeTo(null);
        hsTest.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MangerQuestionUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ExamHome().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbDeThi;
    private javax.swing.JComboBox cbMonHoc;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}