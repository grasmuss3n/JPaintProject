package controller;

import java.util.ArrayList;
import model.interfaces.IShapeStat;

public class UndoRedoArrays {

  public static void undoIShapeArray(ArrayList<IShapeStat> shapeList, ArrayList<IShapeStat> removedShapeList){
    int last = shapeList.size()-1;
    removedShapeList.add(shapeList.remove(last));
  }

  public static void redoIShapeArray(ArrayList<IShapeStat> shapeList, ArrayList<IShapeStat> removedShapeList){
    int last = removedShapeList.size()-1;
    shapeList.add(removedShapeList.remove(last));
  }


  public static void undoIntArray(ArrayList<int[]> moveList, ArrayList<int[]> removedMoveList){
    int last = moveList.size()-1;
    removedMoveList.add(moveList.remove(last));
  }
  public static void redoIntArray(ArrayList<int[]> moveList, ArrayList<int[]> removedMoveList){
    int last = removedMoveList.size()-1;
    moveList.add(removedMoveList.remove(last));
  }


  public static void undoArrayOfArray(ArrayList<ArrayList<IShapeStat>> selection, ArrayList<ArrayList<IShapeStat>> removedSelection){
    int last = selection.size() - 1;
    removedSelection.add(selection.remove(last));
    ArrayList<IShapeStat> s = ShapeArrays.getSelectedShapeList();
    s.clear();
    if(!selection.isEmpty()){
      ArrayList<ArrayList<IShapeStat>> selec = new ArrayList<>(ShapeArrays.getSelection());
      last = selec.size()-1;
      s.addAll(selec.get(last));
    }
  }

  public static void redoArrayOfArray(ArrayList<ArrayList<IShapeStat>> selection, ArrayList<ArrayList<IShapeStat>> removedSelection){
    int last = removedSelection.size() - 1;
    selection.add(removedSelection.remove(last));
    ArrayList<IShapeStat> s = ShapeArrays.getSelectedShapeList();
    s.clear();
    ArrayList<ArrayList<IShapeStat>> selec = new ArrayList<>(ShapeArrays.getSelection());
    last = selec.size()-1;
    s.addAll(selec.get(last));
  }



}
