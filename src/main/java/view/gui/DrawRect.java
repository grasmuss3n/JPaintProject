package view.gui;

import controller.Pointer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import model.ShapeShadingType;
import model.ShapeStat;
import view.gui.PaintCanvas;
import view.interfaces.IShape;

public class DrawRect implements IShape{

  private ShapeStat stats;
  private Pointer pointer;

  public DrawRect(ShapeStat stats){
    this.stats = stats;
    this.pointer = stats.getPointer();
  }

  @Override
  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D)  g;

    if (stats.getActiveShapeShadingType().equals(ShapeShadingType.FILLED_IN) ||
        stats.getActiveShapeShadingType().equals(ShapeShadingType.OUTLINE_AND_FILLED_IN) ){
      System.out.println("fill");
      g2.setColor(stats.getActivePrimaryColor());
      g2.fillRect(pointer.getX1(), pointer.getY1(), pointer.getWidth(), pointer.getHeight());
    }

    if (stats.getActiveShapeShadingType().equals(ShapeShadingType.OUTLINE) ||
        stats.getActiveShapeShadingType().equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)){
      System.out.println("outline");
      g2.setStroke(new BasicStroke(5));
      g2.setColor(stats.getActiveSecondaryColor());
      g2.drawRect(pointer.getX1(), pointer.getY1(), pointer.getWidth(), pointer.getHeight());
    }

    Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    g2.setStroke(stroke);
    g2.setColor(Color.BLACK);
    g2.drawRect(pointer.getX1()-5, pointer.getY1()-5, pointer.getWidth()+10, pointer.getHeight()+10);

  }
}
