/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mohinhphanlop.GUI;

import Dao.ProductDao;
import Dao.UserDao;
import Model.Product;
import Model.User;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

/**
 *
 * @author tien
 */
public class UpdateKetQua extends javax.swing.JFrame {

    /**
     * Creates new form UpdateProduct
     */
    private int id;
    public UpdateKetQua(int id) {
        initComponents();
        this.id=id;
        ProductDao productDao=new ProductDao();
        Product product=productDao.getbyId(id);
        jTextFieldNameProduct.setText(product.getName());
        jTextFieldPrice.setText(String.valueOf(product.getPrice()));
        jTextFieldQuantity.setText(String.valueOf(product.getQuantity()));
        if (product.getCategoryID()==1) {
            jRadioButtonFood.isSelected();
        }else{
            jRadioButtonDrink.isSelected();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldNameProduct = new javax.swing.JTextField();
        jTextFieldQuantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldPrice = new javax.swing.JTextField();
        jLabelImage = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldPrice1 = new javax.swing.JTextField();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldNameProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldNameProduct.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldNameProduct.setText("Huỳnh Công Trí");
        jTextFieldNameProduct.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
        jTextFieldNameProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameProductActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNameProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 115, 166, -1));

        jTextFieldQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldQuantity.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldQuantity.setText("Nguyễn Quỳnh Như");
        jTextFieldQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
        jTextFieldQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQuantityActionPerformed(evt);
            }
        });
        jTextFieldQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldQuantityKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 232, 166, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Tên sinh viên");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 75, 75, 22));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("THÊM KẾT QUẢ KHOÁ HỌC");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Khoá học");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 173, 72, 22));

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 283, 107, 26));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Giảng viên");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 173, -1, 22));

        jTextFieldPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldPrice.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldPrice.setText("Kĩ năng mềm");
        jTextFieldPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
        jTextFieldPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPriceActionPerformed(evt);
            }
        });
        jTextFieldPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPriceKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 232, 142, -1));
        jPanel1.add(jLabelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 298, 242, 57));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Điểm số");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 75, 72, 22));

        jTextFieldPrice1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldPrice1.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldPrice1.setText("8.5");
        jTextFieldPrice1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(153, 153, 153)));
        jTextFieldPrice1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrice1ActionPerformed(evt);
            }
        });
        jTextFieldPrice1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPrice1KeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 115, 142, -1));

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 204, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 204, 102));
        kGradientPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel2MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Cập nhật");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(80, 80, 80))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 494, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kGradientPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel2MouseClicked
        String name=jTextFieldNameProduct.getText();
        int quantity=Integer.parseInt(jTextFieldQuantity.getText());
        int price=Integer.parseInt(jTextFieldPrice.getText());
        int cat=0;
        if (jRadioButtonFood.isSelected()) {
            cat=1;
        }else if(jRadioButtonDrink.isSelected()){
            cat=2;
        }
        Product product=new Product(this.id,name,cat,quantity,price);
        ProductDao productDao=new ProductDao();
        if (productDao.updateProduct(product)>0) {
            JOptionPane.showMessageDialog(UpdateProduct.this, "Update Thành Công !!!");
            this.dispose();
        }
    }//GEN-LAST:event_kGradientPanel2MouseClicked

    private void jTextFieldPrice1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrice1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrice1KeyPressed

    private void jTextFieldPrice1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrice1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrice1ActionPerformed

    private void jTextFieldPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPriceKeyPressed
        char c=evt.getKeyChar();
        if (Character.isLetter(c)) {
            jTextFieldPrice.setEditable(false);
            jLabel8.setText(" You must press number ! !!");
            jLabel8.setEnabled(true);
        }else{
            jTextFieldPrice.setEditable(true);
        }
    }//GEN-LAST:event_jTextFieldPriceKeyPressed

    private void jTextFieldPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPriceActionPerformed

    private void jTextFieldQuantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQuantityKeyPressed
        char c=evt.getKeyChar();
        if (Character.isLetter(c)) {
            jTextFieldQuantity.setEditable(false);
            jLabel8.setText(" You must press number ! !!");
            jLabel8.setEnabled(true);
        }else{
            jTextFieldQuantity.setEditable(true);
        }
    }//GEN-LAST:event_jTextFieldQuantityKeyPressed

    private void jTextFieldQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQuantityActionPerformed

    private void jTextFieldNameProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameProductActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UpdateProduct().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldNameProduct;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JTextField jTextFieldPrice1;
    private javax.swing.JTextField jTextFieldQuantity;
    private keeptoo.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables
}
