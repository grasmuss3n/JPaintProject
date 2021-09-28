package view.gui;

import controller.Pointer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import view.interfaces.IShape;

public class DrawRect implements IShape{

  @Override
  public void fill(Graphics g, Pointer pointer, Color c) {
    //Graphics2D g2 = (Graphics2D) g;
    g.setColor(c);
    g.fillRect(pointer.getX1(), pointer.getY1(), pointer.getWidth(), pointer.getHeight());
  }

  @Override
  public void outline(Graphics g, Pointer pointer, Color c) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setStroke(new BasicStroke(5));
    g.setColor(c);
    g.drawRect(pointer.getX1()-1, pointer.getY1()-1, pointer.getWidth()+2, pointer.getHeight()+2);
  }
}
