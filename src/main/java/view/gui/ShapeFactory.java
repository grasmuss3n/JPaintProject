package view.gui;

import model.ShapeType;
import model.persistence.UserChoicesImpl;
import model.interfaces.IShape;

public class ShapeFactory{

  public IShape createShape(UserChoicesImpl stat){
    IShape shape;
    if(stat.getActiveShapeType().equals(ShapeType.RECTANGLE)){
      shape = new DrawRect();
    }
    else if(stat.getActiveShapeType().equals(ShapeType.ELLIPSE)){
      shape = new DrawRect();
    }
    else{
      shape = new DrawRect();
    }
    return shape;
  }



}
