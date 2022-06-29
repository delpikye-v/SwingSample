///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package swingsample;
//
//// Example from http://www.crionics.com/products/opensource/faq/swing_ex/SwingExamples.html
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//import javax.swing.DefaultCellEditor;
//import javax.swing.JButton;
//import javax.swing.JCheckBox;
//import javax.swing.JLabel;
//import javax.swing.JTable;
//import javax.swing.UIManager;
//import javax.swing.table.TableCellRenderer;
//
//
///**
// * @version 1.0 11/09/98
// */
//
//class ButtonRenderer extends JButton implements TableCellRenderer {
//
//    public ButtonRenderer() {
//        setOpaque(true);
//    }
//
//    @Override
//    public Component getTableCellRendererComponent(JTable table, Object value,
//            boolean isSelected, boolean hasFocus, int row, int column) {
//        if (isSelected) {
////            setForeground(table.getSelectionForeground());
//            setBackground(table.getSelectionBackground());
//        } else {
////            setForeground(table.getForeground());
//            setBackground(UIManager.getColor("Button.background"));
//        }
//        setText((value == null) ? "" : value.toString());
//        return this;
//    }
//}
//
///**
// * @version 1.0 11/09/98
// */
//class ButtonEditor extends DefaultCellEditor {
//    public enum STATE {
//        X, O, N
//    };
//    private int indexCol;
//    
//    private int[] cellRow;
//    private STATE[] states;
//    
//    protected JLabel button;
//
//    private String label;
//
////    private boolean isPushed;
//
//    public ButtonEditor(int indexCol) {
//        super(new JCheckBox());
//        this.indexCol = indexCol;
//        this.cellRow = new int[NewJFrame.COL];
//        this.states = new STATE[NewJFrame.COL];
//        for (int i = 0; i < NewJFrame.COL; i++) {
//            states[i] = STATE.N;
//        }
//        
//        button = new JLabel();
//        button.setOpaque(true);
////        button.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                fireEditingStopped();
////            }
////        });
//        button.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                fireEditingStopped();
//            }
//        });
//        
//    }
//
//    @Override
//    public Component getTableCellEditorComponent(JTable table, Object value,
//            boolean isSelected, int row, int column) {
//        if (isSelected) {
////            button.setForeground(table.getSelectionForeground());
//            button.setBackground(table.getSelectionBackground());
//        } else {
////            button.setForeground(table.getForeground());
//            button.setBackground(table.getBackground());
//        }
//        label = "X";
//        if (states[row] == STATE.N) {
//            states[row] = STATE.X;
//            button.setForeground(Color.RED);
//        } else {
//            
//            states[row] = STATE.O;
//            label = "O";
//        }button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//button.setForeground(Color.BLUE);
////        label = (value == null) ? "" : value.toString();
//        button.setText(label);
////        isPushed = true;
//        return button;
//    }
//
//    @Override
//    public Object getCellEditorValue() {
////        if (isPushed) {
////            JOptionPane.showMessageDialog(button, label + ": Ouch!");
//            // System.out.println(label + ": Ouch!");
////        }
////        isPushed = false;
//        return label;
//    }
//
//    @Override
//    public boolean stopCellEditing() {
////        isPushed = false;
//        return super.stopCellEditing();
//    }
//
//    @Override
//    protected void fireEditingStopped() {
//        super.fireEditingStopped();
//    }
//}
