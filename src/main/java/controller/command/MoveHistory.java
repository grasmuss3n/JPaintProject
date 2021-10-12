package controller.command;

import java.util.ArrayList;
import model.interfaces.IShapeStat;

public class MoveHistory {

  private static final ArrayList<int[]> moveList = new ArrayList<>();
  private static final ArrayList<int[]> removedMoveList = new ArrayList<>();



  public static int getCol(){
    boolean result = !moveList.isEmpty();
    if(result){

    }
    int last = moveList.size()-1;

    int a = moveList.get(last)[1];
    return a;
  }

  public static int getRow(){
    int last = moveList.size()-1;

    int a = moveList.get(last)[0];
    return a;
  }

  public static void addMove(int[] rc){
    moveList.add(rc);
  }


  public static void undoMove(){
    int last = moveList.size()-1;
    removedMoveList.add(moveList.remove(last));
  }
  public static Boolean moveEmpty(){
    boolean result = !moveList.isEmpty();
    return result;

  }

  public static Boolean redoMove(){
    boolean result = !removedMoveList.isEmpty();
    if(result){
      int last = removedMoveList.size()-1;
      moveList.add(removedMoveList.remove(last));

    }
    return result;

  }

}
