package view.gui;

import controller.ShapeArrays;
import controller.UndoRedoArrays;
import controller.command.CommandHistory;
import controller.interfaces.Undoable;
import model.CurrentCanvas;
import view.interfaces.EventCallback;

public class OnPaste implements EventCallback, Undoable{


  @Override
  public void run() {
    CommandHistory.add(this);
    CurrentCanvas.paintCanvas.repaint();
  }

  @Override
  public void undo() {
    boolean result = !ShapeArrays.getPasted().isEmpty();
    if(result){
      UndoRedoArrays.undoPasted();
    }
    else{
      System.out.println("Nothing to undo");
    }

    CurrentCanvas.paintCanvas.repaint();
    
  }

  @Override
  public void redo() {
    boolean result = !ShapeArrays.getRemovedPasted().isEmpty();
    if(result){
      UndoRedoArrays.redoPasted();
    }
    else{
      System.out.println("Nothing to redo");
    }
    CurrentCanvas.paintCanvas.repaint();
  }


}
