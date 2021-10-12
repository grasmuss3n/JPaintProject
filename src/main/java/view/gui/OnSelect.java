package view.gui;

import controller.command.ShapeList;
import model.ClickCoordinates;
import view.interfaces.EventCallback;

public class OnSelect implements EventCallback {

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

  }


}
