package view.gui;

import controller.command.ShapeList;
import model.ShapeStat;

public class DrawExecution {

  public static void dE(PaintCanvas paintCanvas){
    for(ShapeStat shape: ShapeList.getShapeList()){
      DrawShape.drawShape(paintCanvas.getGraphics(), shape);
    }
  }

}
