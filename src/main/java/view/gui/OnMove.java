package view.gui;

import controller.ShapeArrays;
import controller.UndoRedoArrays;
import controller.command.CommandHistory;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.ClickCoordinates;
import controller.MoveSelected;
import model.CurrentCanvas;
import model.interfaces.IShapeStat;
import org.jetbrains.annotations.NotNull;
import view.interfaces.EventCallback;

public class OnMove implements EventCallback, Undoable {

  /** Code Created and Written by Gianna Rasmussen
   * When Mouse Mode is MOVE this program is called
   */
  private final PaintCanvas paintCanvas = CurrentCanvas.paintCanvas;

  private final int col;
  private final int row;


  public OnMove(@NotNull ClickCoordinates clickCoordinates){
    row = clickCoordinates.getRow();
    col = clickCoordinates.getCol();
  }

  @Override
  public void run() {

    int[] rc = new int[]{row,col};

    ArrayList<int[]> m = ShapeArrays.getMoveList();
    m.add(rc);

    ArrayList<IShapeStat> s = new ArrayList<>(ShapeArrays.getSelectedShapeList());
    ArrayList<ArrayList<IShapeStat>> select = ShapeArrays.getMoveSelection();
    select.add(s);

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
      UndoRedoArrays.undoMove();
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
      UndoRedoArrays.redoMove();
      MoveSelected.moveSelected(ShapeArrays.getRow(), ShapeArrays.getCol());

    }
    paintCanvas.repaint();
  }
}
