package controller;


import model.interfaces.IShapeStat;

public class MoveSelected {

  /** Code Created and Written by Gianna Rasmussen
   * Is responsible for changing the ShapeList ClickCoordinate stats
   * @param plusX : how much to move left or right
   * @param plusY: how much to move up or down
   */

  public static void moveSelected(int plusX, int plusY){
    if(!ShapeList.getShapeList().isEmpty()){

      for (int i = 0; i < ShapeList.getShapeList().size(); i++){

        IShapeStat s = ShapeList.getShapeList().get(i);
        if(MoveHistory.getSelected().contains(s)){


          int x1 = s.getClickCoordinates().getX1();
          int x2 = s.getClickCoordinates().getX2();
          int y1 = s.getClickCoordinates().getY1();
          int y2 = s.getClickCoordinates().getY2();

          s.setClickCoordinates(x1+plusX, y1+plusY, x2+plusX, y2+plusY);
          ShapeList.getShapeList().set(i, s);

        }

      }
    }


  }


}
