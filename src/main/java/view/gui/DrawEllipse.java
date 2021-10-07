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
   *
   * @param g: graphics
   * @param clickCoordinates: x, y, height, and width
   * @param c: color
   */

  @Override
  public void fill(Graphics g, ClickCoordinates clickCoordinates, Color c) {

  }

  @Override
  public void outline(Graphics g, ClickCoordinates clickCoordinates, Color c) {

  }

  @Override
  public void draw(Graphics g, ClickCoordinates clickCoordinates) {
    Graphics2D graphics2D = (Graphics2D) g;
    Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    graphics2D.setStroke(stroke);
    graphics2D.setColor(Color.BLACK);
    graphics2D.drawRect(clickCoordinates.getX1(), clickCoordinates.getY1(), clickCoordinates.getWidth(), clickCoordinates.getHeight());
  }
}
