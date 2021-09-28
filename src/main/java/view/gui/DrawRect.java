package view.gui;

import controller.Pointer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import view.interfaces.IShape;

public class DrawRect implements IShape{

  @Override
  public void fill(Graphics2D g2, Pointer pointer, Color c) {
    g2.setColor(c);
    g2.fillRect(pointer.getX1(), pointer.getY1(), pointer.getWidth(), pointer.getHeight());
  }

  @Override
  public void outline(Graphics2D g2, Pointer pointer, Color c) {
    g2.setStroke(new BasicStroke(5));
    g2.setColor(c);
    g2.drawRect(pointer.getX1()-1, pointer.getY1()-1, pointer.getWidth()+2, pointer.getHeight()+2);
  }
}
