package view.gui;

import controller.command.ShapeList;
import java.util.ArrayList;
import model.ClickCoordinates;
import model.interfaces.IShapeStat;

public class SelectedShapes {

  public static void getShapes(ClickCoordinates clickCoordinates){

    ArrayList<IShapeStat> selectedShapes = new ArrayList<>();

    int x1 = clickCoordinates.getX1();
    int y1 = clickCoordinates.getY1();

    int x2 = clickCoordinates.getX2();
    int y2 = clickCoordinates.getY2();


    for(IShapeStat shapeStat : ShapeList.getShapeListStat()){
      ClickCoordinates pointer = shapeStat.getClickCoordinates();
      int px1 = pointer.getX1();
      int px2 = pointer.getX2();
      int py1 = pointer.getY1();
      int py2 = pointer.getY2();

     if((px1 >= x1 || px2 >= x2) && (px1 <= x2 || px2 <=x2)){
       //System.out.println("PHASE 1");
       if((py1 >= y1 || py2 >= y2) && (py1 <= y2 || py2 <=y2)) {
         //System.out.println("PHASE 2");
         ShapeList.addSelectedSL(shapeStat);
       }
     }
    }
  }

}
