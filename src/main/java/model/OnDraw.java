package model;

import controller.Pointer;
import controller.command.CommandHistory;
import controller.command.ShapeList;
import controller.interfaces.Undoable;
import controller.interfaces.iCommand;
import model.persistence.UserChoicesImpl;
import view.gui.DrawShape;
import view.gui.PaintCanvas;
import view.interfaces.IShape;
import view.interfaces.IShapeStat;


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
    IShapeStat shapeStat = new ShapeStat(pointer, appState, shape);


    ShapeList.addSL(shapeStat);


    DrawShape d = new DrawShape();
    d.paint(paintCanvas.getGraphics2D());


    CommandHistory.add(this);

  }

  @Override
  public void undo() {
    ShapeList.removeFromSL();
  }

  @Override
  public void redo() {
    ShapeList.returnToSL();
  }
}
