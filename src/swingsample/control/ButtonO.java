/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingsample.control;

import java.awt.Graphics;
import javax.swing.JRadioButton;
import swingsample.CellType;
import swingsample.DrawInfo;

/**
 *
 * @author ASUC-PC
 */
public class ButtonO extends JRadioButton implements IFCellType {

    public ButtonO() {
        super("");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

        int width = this.getWidth();
        int height = this.getHeight();
        float x = (width / 2f) + width / 10f;
        float y = (height / 2f);

        DrawInfo.drawO(g, x, y);
    }

    @Override
    public CellType getCellType() {
        return CellType.X;
    }

}
