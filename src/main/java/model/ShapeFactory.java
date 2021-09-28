package model;

import java.util.ArrayList;
import model.persistence.UserChoicesImpl;
import view.gui.DrawEllipse;
import view.gui.DrawRect;
import view.interfaces.IShape;

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
