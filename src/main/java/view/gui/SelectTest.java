package view.gui;

import controller.command.ShapeList;
import java.awt.Color;
import model.interfaces.IShapeStat;

public class SelectTest {

  //Turns everything in selected area yellow.
  public static void selectionTest(){
    if(!ShapeList.getShapeListStat().isEmpty()){
      for (int i = 0; i < ShapeList.getShapeListStat().size(); i++){

        IShapeStat s = ShapeList.getShapeListStat().get(i);
        if(ShapeList.getSelectedShapeListShapeList().contains(s)){
          s.setActivePrimaryColor(Color.YELLOW);
          ShapeList.getShapeListStat().set(i, s);
        }

      }
    }


  }

}
