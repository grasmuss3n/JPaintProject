package model;

import controller.command.ShapeList;
import model.interfaces.IShapeStat;

public class MoveSelected {

  //idea: treat moves like new shapes.

  public static void moveSelected(int plusX, int plusY){
    if(!ShapeList.getShapeListStat().isEmpty()){


      for (int i = 0; i < ShapeList.getShapeListStat().size(); i++){

        IShapeStat s = ShapeList.getShapeListStat().get(i);
        if(ShapeList.getSelectedShapeListShapeList().contains(s)){


          int x1 = s.getClickCoordinates().getX1();
          int x2 = s.getClickCoordinates().getX2();
          int y1 = s.getClickCoordinates().getY1();
          int y2 = s.getClickCoordinates().getY2();

          s.setClickCoordinates(x1+plusX, y1+plusY, x2+plusX, y2+plusY);
          ShapeList.getShapeListStat().set(i, s);

          //ShapeList.removeFromSL(i);
          //ShapeList.addSL(s);

        }

      }
    }


  }


}
