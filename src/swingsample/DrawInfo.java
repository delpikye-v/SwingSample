/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingsample;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUC-PC
 */
public class DrawInfo {

    public static void drawCheckWin(JTable table) {
        Graphics g = table.getGraphics();
        g.setColor(Color.ORANGE);

        for (Common.WinInfo winInfo : Common.winInfos) {
            List<Point> listColDraw = winInfo.listColDraw;
            Point cellTypese = listColDraw.get(0);
            Rectangle r = table.getCellRect(cellTypese.y, cellTypese.x, true);

            Point pFrom = SwingUtilities.convertPoint(table, r.x, r.y, table);

            float fromX = pFrom.x + (r.width / 2f);
            float fromY = pFrom.y + (r.height / 2f);

            Point cellTypeseTo = listColDraw.get(listColDraw.size() - 1);
            r = table.getCellRect(cellTypeseTo.y, cellTypeseTo.x, true);

            Point pTo = SwingUtilities.convertPoint(table, r.x, r.y, table);

            float toX = pTo.x + (r.width / 2f);
            float toY = pTo.y + (r.height / 2f);

            drawLine(g, winInfo.winType, (int) fromX, (int) fromY, (int) toX, (int) toY);
        }
    }

    public static void drawLine(Graphics g, Common.WinType winType, int x, int y, int w, int h) {
        for (int i = -2; i <= 2; i++) {
            if (winType == Common.WinType.TopLeft_BotRight) {
                g.drawLine(x + 1, y + i, w + i, h);
            }

            if (winType == Common.WinType.Top_Bot) {
                g.drawLine(x + i, y, w + i, h);
            }

            if (winType == Common.WinType.RIGHT_LEFT) {
                g.drawLine(x, y + i, w, h + i);
            }

            if (winType == Common.WinType.TopRight_BotLeft) {
                g.drawLine(x + i, y, w + i, h + i);
            }
        }
    }

    public static void drawO(Graphics g, float x, float y) {
        g.setColor(Color.BLUE);
        g.drawOval((int) (x / 2), (int) (y / 2), (int) x, (int) y);
        g.drawOval((int) (x / 2 + 1), (int) (y / 2 + 1), (int) (x - 1), (int) (y - 1));
        g.drawOval((int) (x / 2 + 2), (int) (y / 2 + 1), (int) (x - 2), (int) (y - 1));
        g.drawOval((int) (x / 2 + 3), (int) (y / 2 + 1), (int) (x - 3), (int) (y - 1));

        g.drawOval((int) (x / 2 + 1), (int) (y / 2 + 1), (int) (x - 1), (int) (y - 1));
        g.drawOval((int) (x / 2 + 1), (int) (y / 2 + 2), (int) (x - 1), (int) (y - 2));

    }

    public static void drawX(Graphics g, float x, float y) {
        g.setColor(Color.RED);

        g.drawLine((int) (x - x / 4), (int) (y - y / 4), (int) (x + x / 4), (int) (y + y / 4));
        for (int i = -4; i <= 4; i++) {
            g.drawLine((int) (x - x / 4 - i), (int) (y - y / 4), (int) (x + x / 4 - i), (int) (y + y / 4));
        }
        g.drawLine((int) (x + x / 4), (int) (y - y / 4), (int) (x - x / 4), (int) (y + y / 4));
        for (int i = -3; i <= 3; i++) {
            g.drawLine((int) (x + x / 4), (int) (y - y / 4 - i), (int) (x - x / 4), (int) (y + y / 4 - i));
        }
    }
}
