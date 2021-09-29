package model;

import controller.Pointer;
import java.awt.Color;
import model.persistence.UserChoicesImpl;
import view.interfaces.IShape;
import view.interfaces.IShapeStat;

public class ShapeStat implements IShapeStat {
  private Pointer pointer;
  private IShape shape;

  private Color primaryColor;
  private Color secondaryColor;

  private ShapeType shapeType;
  private ShapeShadingType shapeShadingType;

  public ShapeStat(Pointer pointer,UserChoicesImpl appState, IShape shape){
    this.pointer = pointer;
    this.shape = shape;

    primaryColor = appState.getActivePrimaryColor().getColor();
    secondaryColor = appState.getActiveSecondaryColor().getColor();

    shapeType = appState.getActiveShapeType();
    shapeShadingType = appState.getActiveShapeShadingType();
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
    return shapeType;
  }


  @Override
  public Color getActivePrimaryColor() {

    return primaryColor;
  }

  @Override
  public Color getActiveSecondaryColor() {

    return secondaryColor;
  }

  @Override
  public ShapeShadingType getActiveShapeShadingType() {
    return shapeShadingType;
  }


}
