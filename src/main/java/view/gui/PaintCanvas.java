package view.gui;

import controller.MouseHandler;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import java.awt.*;
import model.ShapeType;
import model.interfaces.UserChoices;
import model.persistence.UserChoicesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PaintCanvas is responsible for responding to the graphics system when it
 * is time to update the display.  This is a boundary class so very little code
 * should be added here.
 */
public class PaintCanvas extends JComponent {

    private int x1 = 0;
    private int x2 = 0;
    private int y1 = 0;
    private int y2 = 0;

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

    public void pointers(int a, int b, int x, int y){
        x1 = a;
        x2 = x;
        y1 = b;
        y2 = y;
    }

    @Override
    /**
     * This is an event handler.  If this function gets called, its time to
     * draw the entire picture.
     * It you want to force a paint event, call aPaintCanvas.repaint()
     */
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;


    }
}
