package view.gui;

import controller.ShapeList;
import controller.interfaces.CopyPaste;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import model.ClickCoordinates;
import controller.SelectedShapes;
import model.interfaces.IShapeStat;
import view.interfaces.EventCallback;

public class OnSelect implements EventCallback, CopyPaste {

  /**Code Created and Written by Gianna Rasmussen
   * Creates a new array of selected shapes
   */
  private final ClickCoordinates clickCoordinates;
  private final PaintCanvas paintCanvas;

  public OnSelect(ClickCoordinates clickCoordinates, PaintCanvas paintCanvas){
    clickCoordinates.check();
    this.clickCoordinates = clickCoordinates;
    this.paintCanvas = paintCanvas;
  }



  @Override
  public void run() {
    //Not selecting right
    //idk why
    ShapeList.clearSelectedShape();
    SelectedShapes.getShapes(clickCoordinates);

    //First Test
    //SelectTest.selectionTest();

    //Test 2: outline
    //test();


    paintCanvas.repaint();

  }

  //used to be sure everything that should be selected IS selected
  private void test(){
    Graphics g= paintCanvas.getGraphics();
    Graphics2D graphics2D = (Graphics2D) g;
    Stroke stroke = new BasicStroke(8, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    graphics2D.setStroke(stroke);
    graphics2D.setColor(Color.BLACK);
    graphics2D.drawRect(clickCoordinates.getX1(), clickCoordinates.getY1(), clickCoordinates.getWidth(), clickCoordinates.getHeight());

    for(IShapeStat shapeStat : ShapeList.getSelectedShapeList()){
     ClickCoordinates p = shapeStat.getClickCoordinates();
      graphics2D.drawRect(p.getX1()-10, p.getY1()-10, p.getWidth()+20, p.getHeight()+20);
    }



  }




  @Override
  public void copy() {
    CopyPasteImp.setCopyList();
  }
}
