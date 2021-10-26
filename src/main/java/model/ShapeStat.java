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
  private final ClickCoordinates clickCoordinates;
  private final IShape shape;

  private Color primaryColor;
  private final Color secondaryColor;


  private final ShapeShadingType shapeShadingType;

  public ShapeStat(ClickCoordinates clickCoordinates,UserChoicesImpl appState, IShape shape){
    this.clickCoordinates = clickCoordinates;
    this.shape = shape;

    primaryColor = appState.getActivePrimaryColor().getColor();
    secondaryColor = appState.getActiveSecondaryColor().getColor();


    shapeShadingType = appState.getActiveShapeShadingType();

  }

  public ShapeStat(IShapeStat shapeStat){

    ClickCoordinates p = shapeStat.getClickCoordinates();
    p.startCoordinates(p.getX1()+5, p.getY1()+5);
    p.endCoordinates(p.getX2()+5, p.getY2()+5);

    this.clickCoordinates = p;
    this.shape = shapeStat.getShape();
    primaryColor = shapeStat.getActivePrimaryColor();
    secondaryColor = shapeStat.getActiveSecondaryColor();
    shapeShadingType = shapeStat.getActiveShapeShadingType();
  }

  @Override
  public ClickCoordinates getClickCoordinates(){
    return clickCoordinates;
  }

  @Override
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

  //this is only used for the test
  @Override
  public void setActivePrimaryColor(Color c) {
    primaryColor = c;
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
