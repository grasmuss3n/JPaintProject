package view.gui;

import controller.ShapeArrays;
import controller.UndoRedoArrays;
import controller.command.CommandHistory;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.ClickCoordinates;
import model.CurrentCanvas;
import model.ShapeFactory;
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
  private final PaintCanvas paintCanvas = CurrentCanvas.paintCanvas;



  public OnDraw(ClickCoordinates clickCoordinates, UserChoicesImpl appState){
    this.clickCoordinates = clickCoordinates;
    this.appState = appState;
  }

  @Override
  public void run() {

    IShape shape = ShapeFactory.createShape(appState.getActiveShapeType());
    IShapeStat shapeStat = new ShapeStat(clickCoordinates, appState, shape);

    ArrayList<IShapeStat> shapeList = ShapeArrays.getShapeList();

    shapeList.add(shapeStat);


    CommandHistory.add(this);

    DrawShape.drawShape(CurrentCanvas.paintCanvas.getGraphics2D(), shapeStat);

  }


  @Override
  public void undo() {
    boolean result = !ShapeArrays.getShapeList().isEmpty();
    if(result){
      UndoRedoArrays.undoShapeList();
    }
    else{
      System.out.println("Nothing to undo");
    }
    paintCanvas.repaint();
  }

  @Override
  public void redo(){
    boolean result = !ShapeArrays.getRemovedShapeList().isEmpty();
    if(result){
      UndoRedoArrays.redoShapeList();
    }
    else{
      System.out.println("Nothing to redo");
    }
    paintCanvas.repaint();
  }
}
