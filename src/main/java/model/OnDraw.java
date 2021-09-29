package model;

import controller.Pointer;
import controller.command.CommandHistory;
import controller.command.ShapeList;
import controller.interfaces.Undoable;
import controller.interfaces.iCommand;
import model.persistence.UserChoicesImpl;
import view.gui.PaintCanvas;
import view.interfaces.IShape;


public class OnDraw implements iCommand, Undoable {

  private Pointer pointer;
  private UserChoicesImpl appState;
  private PaintCanvas paintCanvas;


  public OnDraw(Pointer pointer, UserChoicesImpl appState,PaintCanvas paintCanvas){
    this.pointer = pointer;
    this.appState = appState;
    this.paintCanvas = paintCanvas;
  }

  @Override
  public void run() {
    ShapeFactory s = new ShapeFactory();
    IShape shape = s.createShape(appState);
    ShapeList.addSL(pointer, appState, shape);
    CommandHistory.add(this);
    paintCanvas.paint(paintCanvas.getGraphics());

  }

  @Override
  public void undo() {
    CommandHistory.undo();
    ShapeList.removeFromSL();
  }

  @Override
  public void redo() {
    CommandHistory.redo();
    ShapeList.returnToSL();
  }
}
