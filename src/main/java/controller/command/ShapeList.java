package controller.command;

import java.util.ArrayList;
import model.interfaces.IShapeStat;

public class ShapeList {

  /**Code Created and Written by Gianna Rasmussen
   * a list of shapes with the relevant drawing information
   * and a list of shapes taken out of list by undo
   * uses:
   * @see model.interfaces.IShapeStat
   * for lists.
   */


  private static final ArrayList<IShapeStat> shapeList = new ArrayList<>();
  private static final ArrayList<IShapeStat> removedShapeList = new ArrayList<>();


  //adds to shapeList
  public static void addSL(IShapeStat shapeStat){
    shapeList.add(shapeStat);
  }

  //removes from shapeList and adds to removedShapeList
  public static boolean removeFromSL(){
    boolean result = shapeList.isEmpty();
    if(result){
      int last = shapeList.size()-1;
      removedShapeList.add(shapeList.remove(last));
    }
    return result;
  }

  //removes from removedShapeList and adds back to shapeList
  public static boolean returnToSL(){
    boolean result = !removedShapeList.isEmpty();
    if(result){
      int last = removedShapeList.size()-1;
      shapeList.add(removedShapeList.remove(last));

    }
    return result;
  }

  //retrieval method for shapeList
  public static ArrayList<IShapeStat> getShapeListStat(){
    return shapeList;
  }

}
