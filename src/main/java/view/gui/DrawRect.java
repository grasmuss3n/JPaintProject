package view.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import model.ClickCoordinates;
import model.interfaces.IShape;

public class DrawRect implements IShape{

  /**Code Created and Written by Gianna Rasmussen
   *Draws a rectangle.
   * @param g, graphics used for drawing
   * @param clickCoordinates, used to get x and y, as well as height and width
   * @param c, the color that is to be used.
   */
  @Override
  public void fill(Graphics g, ClickCoordinates clickCoordinates, Color c) {
    g.setColor(c);
    g.fillRect(clickCoordinates.getX1()+7, clickCoordinates.getY1()+7, clickCoordinates.getWidth()-15, clickCoordinates.getHeight()-15);
  }

  @Override
  public void outline(Graphics g, ClickCoordinates clickCoordinates, Color c) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setStroke(new BasicStroke(8));
    g.setColor(c);
    g.drawRect(clickCoordinates.getX1()+6, clickCoordinates.getY1()+6, clickCoordinates.getWidth()-10, clickCoordinates.getHeight()-10);
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
