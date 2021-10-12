package view.gui;

import controller.command.CommandHistory;
import controller.command.MoveHistory;
import controller.command.ShapeList;
import controller.interfaces.Undoable;
import model.ClickCoordinates;
import view.interfaces.EventCallback;

public class OnSelect implements EventCallback, Undoable {

  private ClickCoordinates clickCoordinates;
  private PaintCanvas paintCanvas;

  public OnSelect(ClickCoordinates clickCoordinates, PaintCanvas paintCanvas){
    this.clickCoordinates = clickCoordinates;
    this.paintCanvas = paintCanvas;
  }


  @Override
  public void run() {
    ShapeList.clearSelectedSL();
    SelectedShapes.getShapes(clickCoordinates);



    //Test
    //SelectTest.selectionTest();

    CommandHistory.add(this);

    //paintCanvas.repaint();


  }


  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }
}
