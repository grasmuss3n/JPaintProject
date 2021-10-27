package controller;

import java.util.ArrayList;
import model.ClickCoordinates;
import model.ShapeStat;
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

    ArrayList<IShapeStat> shapeList = new ArrayList<>(ShapeArrays.getShapeList());

    ArrayList<IShapeStat> shapeList2 = ShapeArrays.getSelectedShapeList();

    for(IShapeStat shapeStat: shapeList){

      ClickCoordinates pointer = shapeStat.getClickCoordinates();
      int px1 = pointer.getX1();
      int px2 = pointer.getX2();
      int py1 = pointer.getY1();
      int py2 = pointer.getY2();

      if((px1 >= x1 || px2 >= x1) && (px1 <= x2 || px2 <=x2)){
       if((py1 >= y1 || py2 >= y1) && (py1 <= y2 || py2 <=y2)) {

         shapeList2.add(shapeStat);

       }
     }

    }
  }

}
