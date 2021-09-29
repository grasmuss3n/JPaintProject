package controller.command;

import controller.Pointer;
import controller.interfaces.ShapeDraw;
import java.util.ArrayList;
import model.ShapeStat;
import model.persistence.UserChoicesImpl;
import view.interfaces.IShape;
import view.interfaces.IShapeStat;

public class ShapeList {
  private static final ArrayList<IShapeStat> shapeListStat = new ArrayList<>();
  private static final ArrayList<IShapeStat> removedShapesList = new ArrayList<>();
  private static final ArrayList<ShapeDraw> shapeList = new ArrayList<>();


  public static ArrayList<ShapeDraw> add(ShapeDraw shape){
    shapeList.add(shape);
    return shapeList;
  }

  public static ArrayList<IShapeStat> addSL(IShapeStat shapeStat){
    shapeListStat.add(shapeStat);
    return shapeListStat;
  }

  public static ArrayList<IShapeStat> removeFromSL(){
    removedShapesList.add(shapeListStat.get(shapeListStat.size()-1));
    shapeListStat.remove(shapeListStat.size()-1);
    return shapeListStat;
  }

  public static ArrayList<IShapeStat> returnToSL(){
    shapeListStat.add(removedShapesList.get(shapeListStat.size()-1));
    removedShapesList.remove(shapeListStat.size()-1);
    return shapeListStat;
  }

  public static ArrayList<IShapeStat> getShapeListStat(){
    return shapeListStat;
  }

 public static ArrayList<ShapeDraw> getShapeList(){
    return shapeList;
  }
}
