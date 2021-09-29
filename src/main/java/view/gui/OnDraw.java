package view.gui;

import controller.command.CommandHistory;
import controller.command.ShapeList;
import controller.interfaces.Undoable;
import model.Pointer;
import model.ShapeStat;
import model.persistence.UserChoicesImpl;
import model.interfaces.IShape;
import model.interfaces.IShapeStat;
import view.interfaces.EventCallback;


public class OnDraw implements EventCallback, Undoable {

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

    CommandHistory.add(this);

    paintCanvas.repaint();

  }

  @Override
  public void undo() {
    boolean result = ShapeList.removeFromSL();
    if(!result){
      System.out.println("Nothing to undo");
    }
    paintCanvas.repaint();
  }

  @Override
  public void redo(){
    boolean result = ShapeList.returnToSL();
    if(!result){
      System.out.println("Nothing to redo");
    }
    paintCanvas.repaint();
  }
}
