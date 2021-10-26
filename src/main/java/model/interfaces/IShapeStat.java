package model.interfaces;

import java.awt.Color;
import model.ClickCoordinates;
import model.ShapeShadingType;

public interface IShapeStat {

  /**Code Created and Written by Gianna Rasmussen
   * The information needed in order to draw the shapes in
   * @see view.gui.DrawShape
   * Interface used in
   * @see model.ShapeStat
   * and is relevant to
   *
   */
  ClickCoordinates getClickCoordinates();
  IShape getShape();
  Color getActivePrimaryColor();
  Color getActiveSecondaryColor();
  ShapeShadingType getActiveShapeShadingType();

  void setClickCoordinates(int a, int b, int x, int y);


  //used in testing
  void setActivePrimaryColor(Color c);






}
