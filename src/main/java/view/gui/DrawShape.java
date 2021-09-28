package view.gui;

import controller.Pointer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import model.ShapeShadingType;
import model.ShapeStat;
import view.interfaces.IShape;

public class DrawShape {

  public static void drawShape(Graphics2D g2, ShapeStat stat){
    IShape shape = stat.getShape();
    Pointer pointer = stat.getPointer();

    ShapeShadingType shapeShadingType = stat.getActiveShapeShadingType();
    Color primaryColor = stat.getActivePrimaryColor();
    Color secondaryColor = stat.getActiveSecondaryColor();

    if(shapeShadingType.equals(ShapeShadingType.FILLED_IN)||
    shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)){
      shape.fill(g2, pointer, primaryColor);
    }

    if(shapeShadingType.equals(ShapeShadingType.OUTLINE) ||
    shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)){
      shape.outline(g2, pointer, secondaryColor);
    }

    DrawDimensions.drawDimensions(pointer,g2);
  }



}
