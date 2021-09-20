package model;


import model.persistence.UserChoicesImpl;
import controller.Pointer;
import view.gui.DrawEllipse;
import view.gui.DrawRectangle;
import view.gui.DrawTriangle;

public class ShapeMaker{

  private UserChoicesImpl appState;

  public ShapeMaker(UserChoicesImpl appState, Pointer pointer){
    this.appState = appState;
    if (appState.getActiveShapeType().equals(ShapeType.RECTANGLE))
    {
      new DrawRectangle(pointer, appState.getActivePrimaryColor(), appState.getActiveSecondaryColor(), appState.getActiveShapeShadingType());
    }
    else if (appState.getActiveShapeType().equals(ShapeType.TRIANGLE))
    {
      new DrawTriangle();
    }
    else{
      new DrawEllipse();
    }
  }


}
