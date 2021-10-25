package view.gui.tests;

import controller.ShapeList;
import java.awt.Color;
import model.interfaces.IShapeStat;
import view.gui.CopyPasteImp;


public class SelectTest {

  /**Code Created and Written by Gianna Rasmussen
   * This is a test class for personal use so
   * I can get visuals.
   */

  //Turns everything in selected area yellow.
  public static void selectionTest(){
    if(!ShapeList.getShapeList().isEmpty()){
      for (int i = 0; i < ShapeList.getShapeList().size(); i++){

        IShapeStat s = ShapeList.getShapeList().get(i);
        if(ShapeList.getSelectedShapeList().contains(s)){
          s.setActivePrimaryColor(Color.YELLOW);
          ShapeList.getShapeList().set(i, s);
        }

      }
    }


  }

}
