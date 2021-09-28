package model;

import controller.Pointer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import model.persistence.UserChoicesImpl;
import view.interfaces.IShape;

public class ShapeStat{
  private Pointer pointer;
  private UserChoicesImpl appState;
  private IShape shape;

  public ShapeStat(Pointer pointer,UserChoicesImpl appState, IShape shape){
    this.pointer = pointer;
    this.appState = appState;
    this.shape = shape;
  }

  public Pointer getPointer(){
    return pointer;
  }

  public void setPointer(int a, int b, int x, int y){
    pointer.startCoordinates(a,b);
    pointer.endCoordinates(x,y);
  }

  public IShape getShape(){return shape;}


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
