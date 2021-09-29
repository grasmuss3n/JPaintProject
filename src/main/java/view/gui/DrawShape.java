package view.gui;

import controller.Pointer;
import controller.command.CommandHistory;
import controller.command.ShapeList;
import controller.interfaces.ShapeDraw;
import controller.interfaces.Undoable;
import java.awt.Color;
import java.awt.Graphics2D;
import model.ShapeShadingType;
import model.ShapeStat;
import view.interfaces.IShape;
import view.interfaces.IShapeStat;

public class DrawShape implements ShapeDraw{

  public void paint(Graphics2D graphics2D) {

    for (IShapeStat shapeStat : ShapeList.getShapeListStat()) {
      IShape shape = shapeStat.getShape();
      Pointer pointer = shapeStat.getPointer();

      ShapeShadingType shapeShadingType = shapeStat.getActiveShapeShadingType();
      Color primaryColor = shapeStat.getActivePrimaryColor();
      Color secondaryColor = shapeStat.getActiveSecondaryColor();

      if (shapeShadingType.equals(ShapeShadingType.FILLED_IN) ||
          shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
        shape.fill(graphics2D, pointer, primaryColor);
      }

      if (shapeShadingType.equals(ShapeShadingType.OUTLINE) ||
          shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
        shape.outline(graphics2D, pointer, secondaryColor);
      }

      shape.draw(graphics2D, pointer);

      ShapeList.add(this);


    }
  }

}
