package controller;

import java.util.ArrayList;
import model.ClickCoordinates;
import model.interfaces.IShapeStat;

public class ShapeArrays {


  private static final ArrayList<IShapeStat> shapeList = new ArrayList<>();
  private static final ArrayList<IShapeStat> removedShapeList = new ArrayList<>();

  private static final ArrayList<IShapeStat> selectedShapeList = new ArrayList<>();

  private static final ArrayList<int[]> moveList = new ArrayList<>();
  private static final ArrayList<int[]> removedMoveList = new ArrayList<>();

  private static final ArrayList<ArrayList<IShapeStat>> moveSelection = new ArrayList<>();
  private static final ArrayList<ArrayList<IShapeStat>> removedMoveSelection = new ArrayList<>();


  private static final ArrayList<ArrayList<IShapeStat>> pasted = new ArrayList<>();
  private static final ArrayList<ArrayList<IShapeStat>> removedPasted = new ArrayList<>();


  public static ArrayList<IShapeStat> getShapeList(){
    return shapeList;
  }

  public static ArrayList<IShapeStat> getRemovedShapeList(){
    return removedShapeList;
  }

  public static ArrayList<IShapeStat> getSelectedShapeList(){
    return selectedShapeList;
  }

  public static ArrayList<int[]> getMoveList(){
    return moveList;
  }

  public static ArrayList<int[]> getRemovedMoveList(){
    return removedMoveList;
  }

  public static ArrayList<ArrayList<IShapeStat>> getMoveSelection(){
    return moveSelection;
  }

  public static ArrayList<ArrayList<IShapeStat>> getRemovedSelection(){
    return removedMoveSelection;
  }

  public static ArrayList<ArrayList<IShapeStat>> getPasted(){
    return pasted;
  }

  public static ArrayList<ArrayList<IShapeStat>> getRemovedPasted(){
    return removedPasted;
  }

  public static int getCol(){
    int last = moveList.size()-1;
    return moveList.get(last)[1];
  }

  public static int getRow(){
    int last = moveList.size()-1;
    return  moveList.get(last)[0];
  }

  public static Boolean getShapeStat(IShapeStat shapeStat){

    ClickCoordinates shapeS1 = shapeStat.getClickCoordinates();

    for(IShapeStat iShapeStat: shapeList){
      ClickCoordinates shapeS2 = iShapeStat.getClickCoordinates();
     if(shapeS1.getX1() == shapeS2.getX1() && shapeS1.getX2() == shapeS2.getX2() &&
         shapeS1.getY1() == shapeS2.getY1() && shapeS1.getY2() == shapeS2.getY2()) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }







}
