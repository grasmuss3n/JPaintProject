package model;

import java.awt.Color;
import model.persistence.UserChoicesImpl;
import model.interfaces.IShape;
import model.interfaces.IShapeStat;



public class ShapeStat implements IShapeStat {

  /**Code Created and Written by Gianna Rasmussen
   * Used in the shapeList
   * Easy retrieval of necessary information
   */
  private ClickCoordinates clickCoordinates;
  private IShape shape;

  private Color primaryColor;
  private Color secondaryColor;

  private ShapeType shapeType;
  private ShapeShadingType shapeShadingType;

  public ShapeStat(ClickCoordinates clickCoordinates,UserChoicesImpl appState, IShape shape){
    this.clickCoordinates = clickCoordinates;
    this.shape = shape;

    primaryColor = appState.getActivePrimaryColor().getColor();
    secondaryColor = appState.getActiveSecondaryColor().getColor();

    shapeType = appState.getActiveShapeType();
    shapeShadingType = appState.getActiveShapeShadingType();
  }

  @Override
  public ClickCoordinates getClickCoordinates(){
    return clickCoordinates;
  }

  //this is to be used in move.
  public void setClickCoordinates(int a, int b, int x, int y){
    clickCoordinates.startCoordinates(a,b);
    clickCoordinates.endCoordinates(x,y);
  }

  @Override
  public IShape getShape(){return shape;}


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
