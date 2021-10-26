package view.gui.tests;

import controller.ShapeArrays;
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
    if(!ShapeArrays.getShapeList().isEmpty()){
      for (int i = 0; i < ShapeArrays.getShapeList().size(); i++){

        IShapeStat s = ShapeArrays.getShapeList().get(i);
        if(ShapeArrays.getSelectedShapeList().contains(s)){
          s.setActivePrimaryColor(Color.YELLOW);
          ShapeArrays.getShapeList().set(i, s);
        }

      }
    }


  }

}
