package view.gui;

import controller.Pointer;
import controller.command.ShapeList;
import controller.interfaces.ShapeDraw;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import model.ShapeShadingType;
import model.ShapeStat;
import view.interfaces.IShape;

public class DrawShape implements ShapeDraw {

  @Override
  public void draw(Graphics2D graphics2D) {

    for(ShapeStat shapeStat: ShapeList.getShapeList()){
      DrawDimensions drawDimensions = new DrawDimensions(shapeStat);
      IShape shape = shapeStat.getShape();
      Pointer pointer = shapeStat.getPointer();

      ShapeShadingType shapeShadingType = shapeStat.getActiveShapeShadingType();
      Color primaryColor = shapeStat.getActivePrimaryColor();
      Color secondaryColor = shapeStat.getActiveSecondaryColor();

      if(shapeShadingType.equals(ShapeShadingType.FILLED_IN)||
          shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)){
        shape.fill(graphics2D, pointer, primaryColor);
      }

      if(shapeShadingType.equals(ShapeShadingType.OUTLINE) ||
          shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)){
        shape.outline(graphics2D, pointer, secondaryColor);
      }

      drawDimensions.draw(graphics2D);
    }

  }
}
