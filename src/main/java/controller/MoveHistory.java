package controller;

import java.util.ArrayList;
import model.interfaces.IShapeStat;

public class MoveHistory {

  /** Code Created and Written by Gianna Rasmussen
   * How the program keeps track of moves and which shapes moved
   * previously.
   */

  private static final ArrayList<int[]> moveList = new ArrayList<>();
  private static final ArrayList<int[]> removedMoveList = new ArrayList<>();

  private static final ArrayList<ArrayList<IShapeStat>> selection = new ArrayList<>();
  private static final ArrayList<ArrayList<IShapeStat>> removedSelection = new ArrayList<>();


  public static ArrayList<IShapeStat> getSelected(){
    return selection.get(selection.size()-1);
  }


  public static int getCol(){
    int last = moveList.size()-1;
    return moveList.get(last)[1];
  }

  public static int getRow(){
    int last = moveList.size()-1;
    return  moveList.get(last)[0];
  }

  public static void addMove(int[] rc){
    moveList.add(rc);

    ArrayList<IShapeStat> s = new ArrayList<>(ShapeList.getSelectedShapeList());
    selection.add(s);
  }


  public static void undoMove(){
    int last = moveList.size()-1;
    removedMoveList.add(moveList.remove(last));
    removedSelection.add(selection.remove(last));
  }


  public static Boolean moveEmpty(){
    return !moveList.isEmpty();

  }

  public static Boolean redoMove(){
    boolean result = !removedMoveList.isEmpty();
    if(result){
      int last = removedMoveList.size()-1;
      moveList.add(removedMoveList.remove(last));
      selection.add(removedSelection.remove(last));

    }
    return result;

  }

}
