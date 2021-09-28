package controller;

import controller.command.CommandHistory;
import controller.command.ShapeList;
import controller.interfaces.Undoable;
import view.gui.PaintCanvas;

public class UndoRedoCommand implements Undoable {

  @Override
  public void undo() {
    ShapeList.removeFromSL();
    CommandHistory.undo();

  }

  @Override
  public void redo() {
    ShapeList.returnToSL();
    CommandHistory.redo();

  }
}
