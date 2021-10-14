package view.gui;

import controller.command.CommandHistory;
import controller.MoveHistory;
import controller.interfaces.Undoable;
import model.ClickCoordinates;
import controller.MoveSelected;
import view.interfaces.EventCallback;

public class OnMove implements EventCallback, Undoable {

  /** Code Created and Written by Gianna Rasmussen
   * When Mouse Mode is MOVE this program is called
   */
  private final PaintCanvas paintCanvas;

  private final int col;
  private final int row;


  public OnMove(ClickCoordinates clickCoordinates, PaintCanvas paintCanvas){
    this.paintCanvas = paintCanvas;

    row = clickCoordinates.getRow();
    col = clickCoordinates.getCol();
  }

  @Override
  public void run() {

    int[] rc = new int[]{row,col};

    MoveHistory.addMove(rc);

    MoveSelected.moveSelected(row, col);

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
      System.out.println("Nothing to redo");
    }
    else{
      MoveSelected.moveSelected(MoveHistory.getRow(), MoveHistory.getCol());
    }
    paintCanvas.repaint();
  }
}
