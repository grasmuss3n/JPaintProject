package view.gui;

import controller.ShapeList;
import model.ClickCoordinates;
import controller.SelectedShapes;
import view.interfaces.EventCallback;

public class OnSelect implements EventCallback{

  /**Code Created and Written by Gianna Rasmussen
   * Creates a new array of selected shapes
   */
  private final ClickCoordinates clickCoordinates;

  public OnSelect(ClickCoordinates clickCoordinates){
    this.clickCoordinates = clickCoordinates;
  }


  @Override
  public void run() {
    ShapeList.clearSelectedShape();
    SelectedShapes.getShapes(clickCoordinates);



    //Test
    //SelectTest.selectionTest();



  }


}
