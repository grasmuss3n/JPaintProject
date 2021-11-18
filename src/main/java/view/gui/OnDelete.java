package view.gui;

import controller.ShapeArrays;
import controller.UndoRedoArrays;
import controller.command.CommandHistory;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.CurrentCanvas;
import model.interfaces.IShapeStat;


public class OnDelete implements  Undoable {

  /** Code Created and Written by Gianna Rasmussen
   * This is how things get deleted.
   * It is by this point I realized
   * that I overcomplicated things
   * And now I have an array for every function
   * Feels a bit excessive.
   */

  public static void delete(){

    OnDelete del = new OnDelete();
    del.executeDelete();
  }


  public void executeDelete(){
    ArrayList<IShapeStat> selectedList = new ArrayList<>(ShapeArrays.getSelectedShapeList());
    ArrayList<ArrayList<IShapeStat>> deletedNow = ShapeArrays.getDeleted();
    deletedNow.add(selectedList);

    int i = deletedNow.size()-1;

    ArrayList<IShapeStat> sL = ShapeArrays.getShapeList();
    sL.removeAll(deletedNow.get(i));

    CommandHistory.add(this);
    CurrentCanvas.paintCanvas.repaint();
  }


  @Override
  public void undo() {
    boolean emptyList = ShapeArrays.getDeleted().isEmpty();
    if(emptyList){
      System.out.println("Nothing to undo");
    }
    else{
      UndoRedoArrays.undoDelete();
    }

    CurrentCanvas.paintCanvas.repaint();
  }

  @Override
  public void redo() {
    boolean emptyList = ShapeArrays.getRemovedDeleted().isEmpty();
    if(emptyList){
      System.out.println("Nothing to undo");
    }
    else{
      UndoRedoArrays.redoDelete();
    }
    CurrentCanvas.paintCanvas.repaint();
  }
}
