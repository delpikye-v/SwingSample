/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Color;

/**
 *
 * @author ASUC-PC
 */
enum CELL_TYPE {
    X, O, N
};

public interface IFCellListen {

    public void remderValue(int row, int col, Color color);
}
