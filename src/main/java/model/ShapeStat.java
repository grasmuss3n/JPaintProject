package model;

import controller.Pointer;
import java.awt.Color;
import model.persistence.UserChoicesImpl;

public class ShapeStat{
  private Pointer pointer;
  private UserChoicesImpl appState;

  public ShapeStat(Pointer pointer,UserChoicesImpl appState){
    this.pointer = pointer;
    this.appState = appState;
  }

  public Pointer getPointer(){
    return pointer;
  }

  public void setPointer(int a, int b, int x, int y){
    pointer.startCoordinates(a,b);
    pointer.endCoordinates(x,y);
  }


  public ShapeType getActiveShapeType() {

    return appState.getActiveShapeType();
  }

  public Color getActivePrimaryColor() {

    return appState.getActivePrimaryColor().getColor();
  }

  public Color getActiveSecondaryColor() {

    return appState.getActiveSecondaryColor().getColor();
  }


  public ShapeShadingType getActiveShapeShadingType() {
    return appState.getActiveShapeShadingType();
  }


}
