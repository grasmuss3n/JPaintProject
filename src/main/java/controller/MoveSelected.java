package controller;


import java.util.ArrayList;
import model.interfaces.IShapeStat;

public class MoveSelected {

  /** Code Created and Written by Gianna Rasmussen
   * Is responsible for changing the ShapeList ClickCoordinate stats
   * @param plusX : how much to move left or right
   * @param plusY: how much to move up or down
   */

  public static void moveSelected(int plusX, int plusY){
    if(!ShapeArrays.getShapeList().isEmpty()){

      for (int i = 0; i < ShapeArrays.getShapeList().size(); i++){

        IShapeStat s = ShapeArrays.getShapeList().get(i);

        ArrayList<ArrayList<IShapeStat>> sel = ShapeArrays.getSelection();

        if(sel.get(sel.size()-1).contains(s)) {
          int x1 = s.getClickCoordinates().getX1();
          int x2 = s.getClickCoordinates().getX2();
          int y1 = s.getClickCoordinates().getY1();
          int y2 = s.getClickCoordinates().getY2();

          s.setClickCoordinates(x1+plusX, y1+plusY, x2+plusX, y2+plusY);
          ShapeArrays.getShapeList().set(i, s);

        }

      }
    }


  }


}
