package model;

import java.util.ArrayList;
import view.gui.DrawRect;
import view.gui.PaintCanvas;
import view.interfaces.IShape;

public class ShapeFactory {


  public void createShape(ArrayList<ShapeStat> shapeList, PaintCanvas paintCanvas){
    IShape shape;
    for(ShapeStat stat: shapeList){
      switch (stat.getActiveShapeType()){
        case RECTANGLE:
          //System.out.println("rect");
          shape = new DrawRect(stat);
        case ELLIPSE:
          shape = new DrawRect(stat);
        case TRIANGLE:
          shape = new DrawRect(stat);
          break;
        default:
          throw new IllegalStateException("Unexpected value: " + stat.getActiveShapeType());
      }
      shape.paint(paintCanvas.getGraphics());

    }
  }


}
