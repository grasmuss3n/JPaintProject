package view.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import model.ClickCoordinates;
import model.interfaces.IShape;

public class DrawEllipse implements IShape {

  /**Code Created and Written by Gianna Rasmussen
   * Draws ellipse. Technically a circle
   * but they're the same
   * @param g: graphics
   * @param clickCoordinates: x, y, height, and width
   * @param c: color
   */

  @Override
  public void fill(Graphics g, ClickCoordinates clickCoordinates, Color c) {
    g.setColor(c);
    clickCoordinates.check();
    g.fillOval(clickCoordinates.getX1(), clickCoordinates.getY1(),
        clickCoordinates.getWidth(), clickCoordinates.getHeight());
  }

  @Override
  public void outline(Graphics g, ClickCoordinates clickCoordinates, Color c) {
    clickCoordinates.check();
    Graphics2D g2 = (Graphics2D) g;
    g2.setStroke(new BasicStroke(8));
    g.setColor(c);

    g.drawOval(clickCoordinates.getX1(), clickCoordinates.getY1(),
        clickCoordinates.getWidth(), clickCoordinates.getHeight());

  }

  @Override
  public void select(Graphics g, ClickCoordinates clickCoordinates) {
    Graphics2D graphics2D = (Graphics2D) g;
    Stroke stroke = new BasicStroke(8, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    graphics2D.setStroke(stroke);
    graphics2D.setColor(Color.BLACK);
    graphics2D.drawOval(clickCoordinates.getX1()-10, clickCoordinates.getY1()-10, clickCoordinates.getWidth()+20, clickCoordinates.getHeight()+20);

  }
}
