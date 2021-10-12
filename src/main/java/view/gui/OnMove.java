package view.gui;

import controller.command.CommandHistory;
import controller.command.MoveHistory;
import controller.interfaces.Undoable;
import model.ClickCoordinates;
import model.MoveSelected;
import view.interfaces.EventCallback;

public class OnMove implements EventCallback, Undoable {


  //private ClickCoordinates clickCoordinates;
  private PaintCanvas paintCanvas;

  private int col;
  private int row;


  public OnMove(ClickCoordinates clickCoordinates, PaintCanvas paintCanvas){
    //this.clickCoordinates = clickCoordinates;
    this.paintCanvas = paintCanvas;

    row = clickCoordinates.getRow();
    col = clickCoordinates.getCol();
  }

  @Override
  public void run() {
    MoveSelected.moveSelected(row, col);
    int[] rc = new int[]{row,col};

    MoveHistory.addMove(rc);

    CommandHistory.add(this);

    paintCanvas.repaint();
  }


  @Override
  public void undo() {
    boolean result = MoveHistory.moveEmpty();
    if(!result){
      System.out.println("Nothing to undo");
    }else{
      MoveSelected.moveSelected(-MoveHistory.getRow(), -MoveHistory.getCol());
      MoveHistory.undoMove();
    }
    paintCanvas.repaint();
  }

  @Override
  public void redo() {
    boolean result = MoveHistory.redoMove();
    if(!result){
      System.out.println("Nothing to undo");
    }
    else{
      MoveSelected.moveSelected(MoveHistory.getRow(), MoveHistory.getCol());
    }
    paintCanvas.repaint();
  }
}
