package controller.command;

import controller.Pointer;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.ShapeStat;
import model.persistence.UserChoicesImpl;
import view.interfaces.IShape;

public class ShapeList {
  private static final ArrayList<ShapeStat> shapeList = new ArrayList<>();
  private static final ArrayList<ShapeStat> removedShapesList = new ArrayList<>();

  public static ArrayList<ShapeStat> addSL(Pointer pointer,UserChoicesImpl appState, IShape shape){
    ShapeStat stat = new ShapeStat(pointer, appState, shape);
    shapeList.add(stat);
    return shapeList;
  }

  public static ArrayList<ShapeStat> removeFromSL(){
    removedShapesList.add(shapeList.get(shapeList.size()-1));
    shapeList.remove(shapeList.size()-1);
    return shapeList;
  }

  public static ArrayList<ShapeStat> returnToSL(){
    shapeList.add(removedShapesList.get(shapeList.size()-1));
    removedShapesList.remove(shapeList.size()-1);
    return shapeList;
  }

  public static ArrayList<ShapeStat> getShapeList(){
    return shapeList;
  }
}
