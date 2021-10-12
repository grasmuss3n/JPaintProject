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


  private static final ArrayList<IShapeStat> selectedShapeList = new ArrayList<>();



  //retrieval method for shapeList
  public static ArrayList<IShapeStat> getShapeListStat(){
    return shapeList;
  }

  public static ArrayList<IShapeStat> getSelectedShapeListShapeList(){
    return selectedShapeList;
  }

  //adds to shapeList
  public static void addSL(IShapeStat shapeStat){
    shapeList.add(shapeStat);
  }


  //add shapes to selection
  public static void addSelectedSL(IShapeStat shapeStat){
    selectedShapeList.add(shapeStat);
  }

  //clear selectShapeList, done after move
  public static void clearSelectedSL(){
    selectedShapeList.clear();
  }

  //removes from shapeList and adds to removedShapeList
  public static boolean removeFromSL(){
    boolean result = !shapeList.isEmpty();
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








}
