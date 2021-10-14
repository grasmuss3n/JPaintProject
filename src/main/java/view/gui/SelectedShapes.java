package view.gui;

import controller.command.ShapeList;
import model.ClickCoordinates;
import model.interfaces.IShapeStat;

public class SelectedShapes {

  /**Code Created and Written by Gianna Rasmussen
   * Retrieves shapes within selected area and puts them
   * in selected shape list used for moving.
   * @param clickCoordinates: x, y coordinates
   */

  public static void getShapes(ClickCoordinates clickCoordinates){

    int x1 = clickCoordinates.getX1();
    int y1 = clickCoordinates.getY1();

    int x2 = clickCoordinates.getX2();
    int y2 = clickCoordinates.getY2();


    for(IShapeStat shapeStat : ShapeList.getShapeList()){
      ClickCoordinates pointer = shapeStat.getClickCoordinates();
      int px1 = pointer.getX1();
      int px2 = pointer.getX2();
      int py1 = pointer.getY1();
      int py2 = pointer.getY2();

     if((px1 >= x1 || px2 >= x2) && (px1 <= x2 || px2 <=x2)){
       if((py1 >= y1 || py2 >= y2) && (py1 <= y2 || py2 <=y2)) {
         ShapeList.addSelectedShape(shapeStat);
       }
     }
    }
  }

}
