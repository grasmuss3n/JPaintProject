package view.gui;

import controller.ShapeList;
import java.awt.Color;
import java.awt.Graphics2D;
import model.ClickCoordinates;
import model.ShapeShadingType;
import model.interfaces.IShape;
import model.interfaces.IShapeStat;

public class DrawShape {

  /**Code Created and Written by Gianna Rasmussen
   *draws the shapes on the canvas,
   * @param graphics2D, used to draw the shapes on the canvas
   */

  public void drawShape(Graphics2D graphics2D) {

    for (IShapeStat shapeStat : ShapeList.getShapeList()) {
      //Color Check
      //System.out.println(shapeStat.getActivePrimaryColor());

      IShape shape = shapeStat.getShape();
      ClickCoordinates clickCoordinates = shapeStat.getClickCoordinates();

      ShapeShadingType shapeShadingType = shapeStat.getActiveShapeShadingType();
      Color primaryColor = shapeStat.getActivePrimaryColor();
      Color secondaryColor = shapeStat.getActiveSecondaryColor();

      if (shapeShadingType.equals(ShapeShadingType.FILLED_IN) ||
          shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
        shape.fill(graphics2D, clickCoordinates, primaryColor);
      }

      if (shapeShadingType.equals(ShapeShadingType.OUTLINE) ||
          shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
        shape.outline(graphics2D, clickCoordinates, secondaryColor);
      }

      //for test
      /*if(shapeStat.shapeSelect()){

      }*/

      //end of test

      if(ShapeList.getSelectedShapeList().contains(shapeStat)){
        shape.select(graphics2D, clickCoordinates);
      }

      //shape.select(graphics2D, clickCoordinates);
    }
  }

}
