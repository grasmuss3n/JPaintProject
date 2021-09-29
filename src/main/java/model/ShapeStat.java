package model;

import controller.Pointer;
import java.awt.Color;
import model.persistence.UserChoicesImpl;
import view.interfaces.IShape;
import view.interfaces.IShapeStat;

public class ShapeStat implements IShapeStat {
  private Pointer pointer;
  private UserChoicesImpl appState;
  private IShape shape;

  public ShapeStat(Pointer pointer,UserChoicesImpl appState, IShape shape){
    this.pointer = pointer;
    this.appState = appState;
    this.shape = shape;
  }

  @Override
  public Pointer getPointer(){
    return pointer;
  }

  public void setPointer(int a, int b, int x, int y){
    pointer.startCoordinates(a,b);
    pointer.endCoordinates(x,y);
  }

  @Override
  public IShape getShape(){return shape;}


  @Override
  public ShapeType getActiveShapeType() {
    return appState.getActiveShapeType();
  }


  @Override
  public Color getActivePrimaryColor() {

    return appState.getActivePrimaryColor().getColor();
  }

  @Override
  public Color getActiveSecondaryColor() {

    return appState.getActiveSecondaryColor().getColor();
  }

  @Override
  public ShapeShadingType getActiveShapeShadingType() {
    return appState.getActiveShapeShadingType();
  }


}
