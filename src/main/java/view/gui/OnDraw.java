package view.gui;

import controller.command.CommandHistory;
import controller.ShapeList;
import controller.interfaces.Undoable;
import model.ClickCoordinates;
import model.ShapeStat;
import model.persistence.UserChoicesImpl;
import model.interfaces.IShape;
import model.interfaces.IShapeStat;
import view.interfaces.EventCallback;


public class OnDraw implements EventCallback, Undoable {

  /** Code Created and Written by Gianna Rasmussen
   * When mouse mode is DRAW this command class is implemented
   */

  private final ClickCoordinates clickCoordinates;
  private final UserChoicesImpl appState;
  private final PaintCanvas paintCanvas;



  public OnDraw(ClickCoordinates clickCoordinates, UserChoicesImpl appState,PaintCanvas paintCanvas){
    this.clickCoordinates = clickCoordinates;
    this.appState = appState;
    this.paintCanvas = paintCanvas;
  }

  @Override
  public void run() {

    IShape shape = ShapeFactory.createShape(appState.getActiveShapeType());
    IShapeStat shapeStat = new ShapeStat(clickCoordinates, appState, shape);

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
