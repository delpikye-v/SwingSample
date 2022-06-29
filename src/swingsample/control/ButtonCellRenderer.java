/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingsample.control;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import swingsample.CellType;
import swingsample.Common;
import swingsample.DrawInfo;

/**
 *
 * @author ASUC-PC
 */
public class ButtonCellRenderer extends JButton implements TableCellRenderer {

    private CellType enCellType = CellType.N;
    private int col = -1;
    private int row = -1;

    public void onDraw(Graphics g) {
        int width = this.getWidth();
        int height = this.getHeight();
        float x = (width / 2f);
        float y = (height / 2f);

        if (enCellType == CellType.O) {
            DrawInfo.drawO(g, x, y);
        } else if (enCellType == CellType.X) {
            DrawInfo.drawX(g, x, y);
        }

        for (Common.WinInfo winInfo : Common.winInfos) {
            List<Point> listColDraw = winInfo.listColDraw;
            Common.WinType winType = winInfo.winType;

            if (winType != Common.WinType._NONE) {
                int dex = -1;
                for (int i = 0; i < listColDraw.size(); i++) {
                    Point point = listColDraw.get(i);
                    if (point.x == col && point.y == row) {
                        dex = i;
                        break;
                    }
                }

                if (dex != -1) {
                    g.setColor(Color.ORANGE);
                    if (winType == Common.WinType.TopLeft_BotRight) {
                        if (dex == 0) {
                            DrawInfo.drawLine(g, winType, (int) x, (int) y, width, height);
                        } else if (dex == listColDraw.size() - 1) {
                            DrawInfo.drawLine(g, winType, 0, 0, (int) x, (int) y);
                        } else {
                            DrawInfo.drawLine(g, winType, 0, 0, width, height);
                        }
                    }

                    if (winType == Common.WinType.Top_Bot) {
                        if (dex == 0) {
                            DrawInfo.drawLine(g, winType, (int) x, (int) (y), (int) x, height);
                        } else if (dex == listColDraw.size() - 1) {
                            DrawInfo.drawLine(g, winType, (int) x, 0, (int) x, (int) (y));
                        } else {
                            DrawInfo.drawLine(g, winType, (int) x, 0, (int) x, height);
                        }
                    }

                    if (winType == Common.WinType.TopRight_BotLeft) {
                        if (dex == 0) {
                            DrawInfo.drawLine(g, winType, (int) x, (int) y, 0, height);
                        } else if (dex == listColDraw.size() - 1) {
                            DrawInfo.drawLine(g, winType, width, 0, (int) x, (int) y);
                        } else {
                            DrawInfo.drawLine(g, winType, 0, height, width, 0);
                        }
                    }

                    if (winType == Common.WinType.RIGHT_LEFT) {
                        if (dex == 0) {
                            DrawInfo.drawLine(g, winType, (int) x, (int) y, 0, (int) y);
                        } else if (dex == listColDraw.size() - 1) {
                            DrawInfo.drawLine(g, winType, width, (int) y, (int) x, (int) y);
                        } else {
                            DrawInfo.drawLine(g, winType, width, (int) y, 0, (int) y);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        onDraw(g);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);     // paint parent's background

    }

    public ButtonCellRenderer() {
        setOpaque(true);
    }
    // Paint the round background and label.

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        ButtonCellEditor editor = (ButtonCellEditor) table.getCellEditor(row, column);
        enCellType = editor.getCellTypes()[row];
        this.row = row;
        this.col = column;

        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
//        setText((value == null) ? "" : value.toString());
        return this;
    }
}
