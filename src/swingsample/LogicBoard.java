/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingsample;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static swingsample.Common.cellTypeses;
import swingsample.control.ButtonCellEditor;
import swingsample.control.ButtonCellRenderer;

/**
 *
 * @author ASUC-PC
 */
public class LogicBoard {

    public static final int SIZE = 20;
    public static final int CELL_INFO = 30;

    public static void checkWin(JTable table, int xCol, int yRow) {
        boolean isWin = Common.isWin(xCol, yRow);
        if (isWin) {
            DrawInfo.drawCheckWin(table);
        }
    }

    public static JTable createBoard(JTable table) {
        cellTypeses = new CellType[SIZE][SIZE];
        DefaultTableModel dm = new DefaultTableModel();
        Object[][] data = new Object[SIZE][SIZE];
        Object[] title = new Object[SIZE];
        for (int i = 0; i < SIZE; i++) {
            title[i] = String.valueOf(i);
        }
        dm.setDataVector(data, title);

        table.setModel(dm);

        // custom cell
        for (int i = 0; i < SIZE; i++) {
            table.getColumn(String.valueOf(i)).setCellRenderer(new ButtonCellRenderer());

            ButtonCellEditor editor = new ButtonCellEditor();
            editor.setCellTypes(cellTypeses[i]);
            table.getColumn(String.valueOf(i)).setCellEditor(editor);
        }

        table.setRowHeight(CELL_INFO);
        table.setSize(CELL_INFO * SIZE, CELL_INFO * SIZE);

        return table;
    }
}
