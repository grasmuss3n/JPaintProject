package view.gui;

import controller.ShapeList;
import controller.interfaces.CopyPaste;
import model.ClickCoordinates;
import controller.SelectedShapes;
import view.interfaces.EventCallback;

public class OnSelect implements EventCallback, CopyPaste {

  /**Code Created and Written by Gianna Rasmussen
   * Creates a new array of selected shapes
   */
  private final ClickCoordinates clickCoordinates;
  private final PaintCanvas paintCanvas;

  public OnSelect(ClickCoordinates clickCoordinates, PaintCanvas paintCanvas){
    this.clickCoordinates = clickCoordinates;
    clickCoordinates.check();
    this.paintCanvas = paintCanvas;
  }



  @Override
  public void run() {
    ShapeList.clearSelectedShape();
    SelectedShapes.getShapes(clickCoordinates);

    //First Test
    //SelectTest.selectionTest();

    //Test 2: outline
    /*
    Graphics g= paintCanvas.getGraphics();
    Graphics2D graphics2D = (Graphics2D) g;
    Stroke stroke = new BasicStroke(8, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    graphics2D.setStroke(stroke);
    graphics2D.setColor(Color.BLACK);
    graphics2D.drawRect(clickCoordinates.getX1(), clickCoordinates.getY1(), clickCoordinates.getWidth(), clickCoordinates.getHeight());
     */

    paintCanvas.repaint();

  }

  @Override
  public void copy() {
    CopyPasteImp.setCopyList();
  }
}
