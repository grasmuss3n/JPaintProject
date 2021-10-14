package view.gui;

import model.ShapeType;
import model.interfaces.IShape;

public class ShapeFactory{

  /** Code Created and Written by Gianna Rasmussen
   * Creates IShape shape with correct shape reference to Rectangle,
   * Triangle, or Ellipse
   * @param shapeType is the activeShapeType, used for creating new IShape
   * @return shape, which is used to create new ShapeStat
   * @see model.interfaces.IShapeStat
   */
  public static IShape createShape(ShapeType shapeType){
    IShape shape;
    if(shapeType.equals(ShapeType.RECTANGLE)){
      shape = new DrawRect();
    }
    else if(shapeType.equals(ShapeType.ELLIPSE)){
      shape = new DrawEllipse();
    }
    else{
      shape = new DrawTriangle();
    }
    return shape;
  }



}
