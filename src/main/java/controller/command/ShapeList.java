package controller.command;

import controller.Pointer;
import java.util.ArrayList;
import model.ShapeStat;
import model.persistence.UserChoicesImpl;

public class ShapeList {
  private static final ArrayList<ShapeStat> shapeList = new ArrayList<>();

  public static ArrayList<ShapeStat> add(Pointer pointer,UserChoicesImpl appState){
    //shapeList.add
    ShapeStat stat = new ShapeStat(pointer, appState);
    shapeList.add(stat);

    System.out.println("Added to list");

    return shapeList;
  }

  //Need to add more such as remove.


}
