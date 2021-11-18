package controller;

import java.util.ArrayList;
import model.interfaces.IShapeStat;

public class UndoRedoArrays {

  /** Code Created and Written by Gianna Rasmussen
   * Undo-redo for the different calls.
   * Uses ShapeArrays.
   */
  public static void undoShapeList(){
    ArrayList<IShapeStat> shapeList = ShapeArrays.getShapeList();
    ArrayList<IShapeStat> removedShapeList = ShapeArrays.getRemovedShapeList();
    int last = shapeList.size()-1;
    removedShapeList.add(shapeList.remove(last));
  }

  public static void redoShapeList(){
    ArrayList<IShapeStat> shapeList = ShapeArrays.getShapeList();
    ArrayList<IShapeStat> removedShapeList = ShapeArrays.getRemovedShapeList();
    int last = removedShapeList.size()-1;
    shapeList.add(removedShapeList.remove(last));
  }


  public static void undoMove(){
    ArrayList<int[]> moveList = ShapeArrays.getMoveList();
    ArrayList<int[]> removedMoveList = ShapeArrays.getRemovedMoveList();

    ArrayList<ArrayList<IShapeStat>> selection = ShapeArrays.getMoveSelection();
    ArrayList<ArrayList<IShapeStat>> removedSelection = ShapeArrays.getRemovedSelection();


    int last = moveList.size()-1;
    removedMoveList.add(moveList.remove(last));

    removedSelection.add(selection.remove(last));

    ArrayList<IShapeStat> s = ShapeArrays.getSelectedShapeList();
    s.clear();

    if(!selection.isEmpty()){
      ArrayList<ArrayList<IShapeStat>> select = new ArrayList<>(ShapeArrays.getMoveSelection());
      last = select.size()-1;
      s.addAll(select.get(last));
    }
  }


  public static void redoMove(){
    ArrayList<int[]> moveList = ShapeArrays.getMoveList();
    ArrayList<int[]> removedMoveList = ShapeArrays.getRemovedMoveList();

    ArrayList<ArrayList<IShapeStat>> selection = ShapeArrays.getMoveSelection();
    ArrayList<ArrayList<IShapeStat>> removedSelection = ShapeArrays.getRemovedSelection();

    int last = removedMoveList.size()-1;
    moveList.add(removedMoveList.remove(last));

    selection.add(removedSelection.remove(last));
    ArrayList<IShapeStat> s = ShapeArrays.getSelectedShapeList();
    s.clear();
    ArrayList<ArrayList<IShapeStat>> select = new ArrayList<>(ShapeArrays.getMoveSelection());
    last = select.size()-1;
    s.addAll(select.get(last));

  }


  public static void undoPasted(){
    ArrayList<ArrayList<IShapeStat>> pasted = ShapeArrays.getPasted();
    ArrayList<ArrayList<IShapeStat>> removedPasted = ShapeArrays.getRemovedPasted();
    ArrayList<IShapeStat> shapeList = ShapeArrays.getShapeList();

    int last = pasted.size()-1;
    shapeList.removeAll(pasted.get(last));
    removedPasted.add(pasted.remove(last));

  }

  public static void redoPasted(){
    ArrayList<ArrayList<IShapeStat>> pasted = ShapeArrays.getPasted();
    ArrayList<ArrayList<IShapeStat>> removedPasted = ShapeArrays.getRemovedPasted();
    ArrayList<IShapeStat> shapeList = ShapeArrays.getShapeList();

    int last = removedPasted.size()-1;

    shapeList.addAll(removedPasted.get(last));
    pasted.add(removedPasted.remove(last));
  }


  public static void undoDelete(){
    ArrayList<IShapeStat> shapeList = ShapeArrays.getShapeList();
    ArrayList<ArrayList<IShapeStat>> deletedLast = ShapeArrays.getDeleted();
    ArrayList<ArrayList<IShapeStat>> deletedRemoved = ShapeArrays.getRemovedDeleted();

    int last = deletedLast.size()-1;

    shapeList.addAll(deletedLast.get(last));
    deletedRemoved.add(deletedLast.remove(last));

  }

  public static void redoDelete(){
    ArrayList<IShapeStat> shapeList = ShapeArrays.getShapeList();
    ArrayList<ArrayList<IShapeStat>> deletedLast = ShapeArrays.getDeleted();
    ArrayList<ArrayList<IShapeStat>> deletedRemoved = ShapeArrays.getRemovedDeleted();

    int last = deletedRemoved.size()-1;

    shapeList.removeAll(deletedRemoved.get(last));
    deletedLast.add(deletedRemoved.remove(last));

  }


}
