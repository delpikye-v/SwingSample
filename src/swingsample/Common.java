/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingsample;

import java.awt.Point;
import static java.lang.Double.SIZE;
import java.util.ArrayList;
import java.util.List;
import static swingsample.NewJFrame1.cellState;

/**
 *
 * @author ASUC-PC
 */
public class Common {

    public enum WinType {
        TopLeft_BotRight, Top_Bot, TopRight_BotLeft, RIGHT_LEFT, _NONE
    }

    public static CellType[][] cellTypeses = new CellType[SIZE][SIZE];

    public static class WinInfo {

        public List<Point> listColDraw = new ArrayList<>();
        public WinType winType = WinType._NONE;

        public WinInfo(List<Point> listColDraw, WinType winType) {
            this.listColDraw = listColDraw;
            this.winType = winType;
        }
    }

    public static List<WinInfo> winInfos = new ArrayList();

    public static boolean isWin = false;
    public static boolean isStart = false;

    public static void clearToNew() {
        winInfos = new ArrayList<>();
        isWin = false;
        isStart = false;
    }

    public static boolean isWin(int xCol, int yRow) {
        int x = xCol;
        int y = yRow;

        int min_x = x - 4;
        int min_y = y - 4;

        int max_X = x + 4;
        int max_Y = y + 4;
//        listColDraw = new ArrayList<>();

        winInfos = new ArrayList<>();

        List<Point> listWin1 = checkWin(min_x, max_X, min_y, max_Y);
        if (listWin1.size() >= 5) {
            isWin = true;

            WinInfo info = new WinInfo(listWin1, WinType.TopLeft_BotRight);
            winInfos.add(info);
        }
        List<Point> listWin2 = checkWin(x, x, min_y, max_Y);
        if (listWin2.size() >= 5) {
            isWin = true;

            WinInfo info = new WinInfo(listWin2, WinType.Top_Bot);
            winInfos.add(info);
        }
        List<Point> listWin3 = checkWin(max_X, min_x, min_y, max_Y);
        if (listWin3.size() >= 5) {
            isWin = true;
            WinInfo info = new WinInfo(listWin3, WinType.TopRight_BotLeft);
            winInfos.add(info);
        }
        List<Point> listWin4 = checkWin(max_X, min_x, y, y);
        if (listWin4.size() >= 5) {
            isWin = true;
            WinInfo info = new WinInfo(listWin4, WinType.RIGHT_LEFT);
            winInfos.add(info);
        }

        return isWin;
    }

    private static boolean isValidCell(int cell) {
        return cell >= 0 && cell < SIZE;
    }

    private static List<Point> checkWin(int fromX, int toX, int fromY, int toY) {
        List<Point> list = new ArrayList<>();

        int from = fromX, to = toX;
        int addX = 1;
        int addY = 1;
        boolean isSSame = true;

        if (fromY == toY) {
            // X  X  X  X  X
            // 5  4  3  2  1
            // <- <- <- <- <-
            addY = 0;
            addX = -1;

            from = toX;
            to = fromX;
        } else {
            // move from top to botton
            // * * 1 * *
            // * * X * *
            // * * 3 * *
            // * * X * *
            // * * 5 * *
            if (fromX == toX) {
                addX = 0;

                from = fromY;
                to = toY;
            } else if (fromX > toX) {
                // move from bottom left to top right
                // * * * * 1
                // * * * X *
                // * * 3 * *
                // * X * * *
                // 5 * * * *
                addX = -1;

                from = fromY;
                to = toY;
            }
        }

        while (from <= to) {
            if (isValidCell(fromX) && isValidCell(fromY)) {
                if (!isSSame && list.size() >= 5) {
                    break;
                }
                if (cellTypeses[fromX][fromY] != cellState) {
                    isSSame = !(list.size() >= 5);
                    if (isSSame) {
                        list = new ArrayList<>();
                    }
                } else {
                    if (isSSame) {
                        list.add(new Point(fromX, fromY));
                    }
                }
            }
            from++;
            fromX = fromX + addX;
            fromY = fromY + addY;
        }

        return list;
    }
}
