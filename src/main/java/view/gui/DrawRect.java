package view.gui;

import controller.Pointer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import view.interfaces.IShape;

public class DrawRect implements IShape{


  @Override
  public void fill(Graphics g, Pointer pointer, Color c) {
    //Graphics2D g2 = (Graphics2D) g;
    g.setColor(c);
    g.fillRect(pointer.getX1()+7, pointer.getY1()+7, pointer.getWidth()-15, pointer.getHeight()-15);
  }

  @Override
  public void outline(Graphics g, Pointer pointer, Color c) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setStroke(new BasicStroke(8));
    g.setColor(c);
    g.drawRect(pointer.getX1()+6, pointer.getY1()+6, pointer.getWidth()-10, pointer.getHeight()-10);
  }

  @Override
  public void draw(Graphics g, Pointer pointer) {
    Graphics2D graphics2D = (Graphics2D) g;
    Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    graphics2D.setStroke(stroke);
    graphics2D.setColor(Color.BLACK);
    graphics2D.drawRect(pointer.getX1(), pointer.getY1(), pointer.getWidth(), pointer.getHeight());
  }
}
