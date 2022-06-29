/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingsample.control;

// Example from http://www.crionics.com/products/opensource/faq/swing_ex/SwingExamples.html
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Double.SIZE;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import swingsample.CellType;
import swingsample.Common;
import swingsample.LogicBoard;
import swingsample.NewJFrame1;

/**
 * @version 1.0 11/09/98
 */
public class ButtonCellEditor extends DefaultCellEditor {

    protected ButtonCellRenderer button;

    private JTable table;

    public int row;
    public int column;
    private String label;

    private boolean isPushed;

    private CellType[] cellTypes;

    public ButtonCellEditor() {
        super(new JCheckBox());
        button = new ButtonCellRenderer();
        button.setBorder(null);
        button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        button.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }

        if (!Common.isWin) {
            if (cellTypes[row] == CellType.N || cellTypes[row] == null) {
                if (NewJFrame1.cellState == CellType.X) {
                    NewJFrame1.cellState = CellType.O;
                    value = "O";
                } else {
                    NewJFrame1.cellState = CellType.X;
                    value = "X";
                }
                cellTypes[row] = NewJFrame1.cellState;

                this.row = row;
                this.column = column;
                isPushed = true;
            }
        }
        this.table = table;

        label = (value == null) ? "" : value.toString();
        button.setText(label);

        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            LogicBoard.checkWin(table, column, row);
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    public CellType[] getCellTypes() {
        if (cellTypes == null) {
            cellTypes = new CellType[SIZE];
        }
        return cellTypes;
    }

    public void setCellTypes(CellType[] cellTypes) {
        this.cellTypes = cellTypes;
    }

}
