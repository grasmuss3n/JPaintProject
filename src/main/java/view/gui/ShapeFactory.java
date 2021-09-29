package view.gui;

import model.ShapeType;
import model.persistence.UserChoicesImpl;
import model.interfaces.IShape;

public class ShapeFactory{

  public IShape createShape(UserChoicesImpl stat){
    IShape shape;
    if(stat.getActiveShapeType().equals(ShapeType.RECTANGLE)){
      //Println Confirms rectangle is drawn and not using others.
      //System.out.println("Drawing Rect");
      shape = new DrawRect();
    }
    else if(stat.getActiveShapeType().equals(ShapeType.ELLIPSE)){
      shape = new DrawEllipse();
    }
    else{
      shape = new DrawTriangle();
    }
    return shape;
  }



}
