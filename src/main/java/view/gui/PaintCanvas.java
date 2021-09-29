package view.gui;

import controller.command.ShapeList;
import controller.interfaces.ShapeDraw;
import javax.swing.JComponent;
import java.awt.*;
import model.ShapeStat;
import view.interfaces.IShape;
import view.interfaces.IShapeStat;

/**
 * PaintCanvas is responsible for responding to the graphics system when it
 * is time to update the display.  This is a boundary class so very little code
 * should be added here.
 */
public class PaintCanvas extends JComponent {




    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }




    @Override
    /**
     * This is an event handler.  If this function gets called, its time to
     * draw the entire picture.
     * It you want to force a paint event, call aPaintCanvas.repaint()
     */
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2d = (Graphics2D) graphics;

        for(ShapeDraw shapeDraw: ShapeList.getShapeList()){
          shapeDraw.paint(graphics2d);
        }

    }


}
