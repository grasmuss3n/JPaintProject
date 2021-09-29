package view.gui;

import controller.Pointer;
import controller.interfaces.ShapeDraw;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import model.ShapeStat;

public class DrawDimensions implements ShapeDraw {

  private Pointer pointer;

  public DrawDimensions(ShapeStat shapeStat){
    this.pointer = shapeStat.getPointer();
  }

  @Override
  public void paint(Graphics2D graphics2D) {
    Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    graphics2D.setStroke(stroke);
    graphics2D.setColor(Color.BLACK);
    graphics2D.drawRect(pointer.getX1(), pointer.getY1(), pointer.getWidth(), pointer.getHeight());
  }
}
