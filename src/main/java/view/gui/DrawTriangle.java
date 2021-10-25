package view.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import model.ClickCoordinates;
import model.interfaces.IShape;

public class DrawTriangle implements IShape {

  /**Code Created and Written by Gianna Rasmussen
   * Draws a triangle
   * @param g: graphics
   * @param clickCoordinates: x,y, height, width
   * @param c: color
   */

  @Override
  public void fill(Graphics g, ClickCoordinates clickCoordinates, Color c) {
    g.setColor(c);


    int x1 = clickCoordinates.getX1();
    int x2 = clickCoordinates.getX2();
    int y1 = clickCoordinates.getY1();
    int y2 = clickCoordinates.getY2();

    int[] xPoints = new int[]{x1,x1, x2};
    int[] yPoints = new int[]{y1, y2, y2};

    g.fillPolygon(xPoints, yPoints, 3);

  }

  @Override
  public void outline(Graphics g, ClickCoordinates clickCoordinates, Color c) {
    //triangle is super fucking rusty

    Graphics2D g2 = (Graphics2D) g;
    g2.setStroke(new BasicStroke(8));
    g.setColor(c);

    int x1 = clickCoordinates.getX1();
    int x2 = clickCoordinates.getX2();
    int y1 = clickCoordinates.getY1();
    int y2 = clickCoordinates.getY2();


    int[] xPoints = new int[]{x1,x1, x2};
    int[] yPoints = new int[]{y1, y2, y2};

    g.drawPolygon(xPoints, yPoints, 3);


  }


  public void select(Graphics g, ClickCoordinates clickCoordinates) {
    Graphics2D graphics2D = (Graphics2D) g;
    Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    graphics2D.setStroke(stroke);
    graphics2D.setColor(Color.BLACK);

    int x1 = clickCoordinates.getX1()+8;
    int x2 = clickCoordinates.getX2()-8;
    int y1 = clickCoordinates.getY1()+8;
    int y2 = clickCoordinates.getY2()-8;


    int[] xPoints = new int[]{x1,x1, x2};
    int[] yPoints = new int[]{y1, y2, y2};

    g.drawPolygon(xPoints, yPoints, 3);


  }
}
