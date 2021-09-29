package view.gui;

import controller.command.CommandHistory;
import controller.command.ShapeList;
import controller.interfaces.Undoable;
import controller.interfaces.iCommand;
import model.Pointer;
import model.ShapeStat;
import model.persistence.UserChoicesImpl;
import model.interfaces.IShape;
import model.interfaces.IShapeStat;


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
    boolean result = ShapeList.removeFromSL();
    if(!result){
      new Exception("Nothing to undo");
    }
  }

  @Override
  public void redo(){
    boolean result = ShapeList.returnToSL();
    if(!result){
      new Exception("Nothing to redo");
    }
  }
}
