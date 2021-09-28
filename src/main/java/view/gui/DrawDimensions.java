package view.gui;

import controller.Pointer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class DrawDimensions {
  public static void drawDimensions(Pointer pointer, Graphics2D g2){
    Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    g2.setStroke(stroke);
    g2.setColor(Color.BLACK);
    g2.drawRect(pointer.getX1()-5, pointer.getY1()-5, pointer.getWidth()+10, pointer.getHeight()+10);
  }
}