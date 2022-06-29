//    private static List<Point> checkWin(int x, int y, int type) {
//        List<Point> list = new ArrayList<>();
//
//        int addX = 1;
//        int addY = 1;
//
//        if (type == 2) {
//            addX = 0;
//        } else if (type == 3) {
//            addX = -1;
//        } else if (type == 4) {
//            addY = 0;
//        }
//        List<Point> listMoveNext = moveCheckWin(x + 1, y + 1, addX, addY, true);
//
//        addX = -1;
//        addY = -1;
//
//        if (type == 2) {
//            addX = 0;
//        } else if (type == 3) {
//            addX = 1;
//        } else if (type == 4) {
//            addY = 0;
//        }
//        List<Point> listMoveBack = moveCheckWin(x, y, addX, addY, false);
//
//        list.addAll(listMoveBack);
//        list.addAll(listMoveNext);
//        return list;
//    }
//
//import java.awt.Point;
//import java.util.ArrayList;
//import java.util.List;
//


/**
 * 
    private static List<Point> moveCheckWin(int nX, int nY, int addX, int addY, boolean isNext) {
        List<Point> list = new ArrayList<>();
        while (true) {
            if (isValidCell(nX) && isValidCell(nY)) {
                if (cellTypeses[nX][nY] == cellState) {
                    if (isNext) {
                        list.add(0, new Point(nX, nY));
                    } else {
                        list.add(new Point(nX, nY));
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
            nX = nX + addX;
            nX = nX + addY;
        }
        return list;
    }

 */
