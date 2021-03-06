/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Dimension;

/**
 *
 * @author ASUC-PC
 */
public class ItemTick extends javax.swing.JPanel {

    private int posX;
    private int posY;

    public enum ItemState {
        X, O, C
    }

    private ItemState state = ItemState.C;

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    private boolean isActive = false;

    /**
     * Creates new form ItemTick
     */
    public ItemTick(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        initComponents();
    }

    /**
     * Creates new form ItemTick
     *
     * @param posX
     * @param posY
     * @param itemState
     */
    public ItemTick(int posX, int posY, ItemState itemState, int size) {
        this.state = itemState;
        this.posX = posX;
        this.posY = posY;
        initComponents();

        if (size < 25) {
            size = 25;
        }
        setSize(new Dimension(size, size));
    }

    public void setText(String txt) {
        btnState.setText(txt);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnState = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(20, 20));
        setLayout(new java.awt.BorderLayout());

        btnState.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnState.setText("X");
        btnState.setToolTipText("");
        btnState.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnState.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnState.setPreferredSize(new java.awt.Dimension(25, 25));
        btnState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStateActionPerformed(evt);
            }
        });
        add(btnState, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStateActionPerformed
        // TODO add your handling code here:
        if (!isActive) {
            isActive = true;
        }
    }//GEN-LAST:event_btnStateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnState;
    // End of variables declaration//GEN-END:variables
}
