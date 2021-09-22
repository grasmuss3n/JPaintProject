package model;

import controller.Pointer;
import controller.command.ShapeList;
import controller.interfaces.iCommand;
import java.util.ArrayList;
import model.persistence.UserChoicesImpl;
import view.gui.PaintCanvas;


public class OnDraw implements iCommand {

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
    ArrayList<ShapeStat> shapeList = ShapeList.add(pointer, appState);
    ShapeFactory s = new ShapeFactory();
    s.createShape(shapeList, paintCanvas);

  }
}
