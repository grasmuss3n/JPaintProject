package view.gui;

import controller.ShapeArrays;
import controller.UndoRedoArrays;
import controller.command.CommandHistory;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.ClickCoordinates;
import controller.MoveSelected;
import model.interfaces.IShapeStat;
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

    ArrayList<int[]> m = ShapeArrays.getMoveList();
    m.add(rc);

    ArrayList<IShapeStat> s = new ArrayList<>(ShapeArrays.getSelectedShapeList());
    ArrayList<ArrayList<IShapeStat>> selec = ShapeArrays.getSelection();
    selec.add(s);

    MoveSelected.moveSelected(row, col);


    CommandHistory.add(this);

    paintCanvas.repaint();
  }


  @Override
  public void undo() {
    boolean result = !ShapeArrays.getMoveList().isEmpty();
    if(!result){
      System.out.println("Nothing to undo");
    }else{
      MoveSelected.moveSelected(-ShapeArrays.getRow(), -ShapeArrays.getCol());
      UndoRedoArrays.undoIntArray(ShapeArrays.getMoveList(), ShapeArrays.getRemovedMoveList());
      UndoRedoArrays.undoArrayOfArray(ShapeArrays.getSelection(), ShapeArrays.getRemovedSelection());
    }
    paintCanvas.repaint();
  }

  @Override
  public void redo() {
    boolean result = !ShapeArrays.getRemovedMoveList().isEmpty();
    if(!result){
      System.out.println("Nothing to redo");
    }
    else{
      UndoRedoArrays.redoIntArray(ShapeArrays.getMoveList(), ShapeArrays.getRemovedMoveList());
      UndoRedoArrays.redoArrayOfArray(ShapeArrays.getSelection(), ShapeArrays.getRemovedSelection());

      MoveSelected.moveSelected(ShapeArrays.getRow(), ShapeArrays.getCol());

    }
    paintCanvas.repaint();
  }
}
