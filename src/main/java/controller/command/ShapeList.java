package controller.command;

import java.util.ArrayList;
import model.interfaces.IShapeStat;

public class ShapeList {
  private static final ArrayList<IShapeStat> shapeListStat = new ArrayList<>();
  private static final ArrayList<IShapeStat> removedShapesList = new ArrayList<>();


  public static void addSL(IShapeStat shapeStat){
    shapeListStat.add(shapeStat);
  }

  public static boolean removeFromSL(){
    boolean result = !shapeListStat.isEmpty();
    if(result){
      int last = shapeListStat.size()-1;
      removedShapesList.add(shapeListStat.remove(last));
    }
    return result;
  }

  public static boolean returnToSL(){
    boolean result = !removedShapesList.isEmpty();
    if(result){
      shapeListStat.add(removedShapesList.get(shapeListStat.size()-1));
      removedShapesList.remove(shapeListStat.size()-1);
    }
    return result;
  }

  public static ArrayList<IShapeStat> getShapeListStat(){
    return shapeListStat;
  }

}
