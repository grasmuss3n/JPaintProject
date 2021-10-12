package view.gui;

import model.ClickCoordinates;
import model.MoveSelected;
import view.interfaces.EventCallback;

public class OnMove implements EventCallback{


  private ClickCoordinates clickCoordinates;
  private PaintCanvas paintCanvas;


  public OnMove(ClickCoordinates clickCoordinates, PaintCanvas paintCanvas){
    this.clickCoordinates = clickCoordinates;
    this.paintCanvas = paintCanvas;
  }

  @Override
  public void run() {
    MoveSelected.moveSelected(clickCoordinates);
    paintCanvas.repaint();
  }



}
