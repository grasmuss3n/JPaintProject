package controller.command;

import model.ClickCoordinates;
import model.persistence.UserChoicesImpl;
import view.gui.OnDraw;
import view.gui.OnMove;
import view.gui.OnSelect;
import view.gui.PaintCanvas;
import view.interfaces.EventCallback;

public class CommandMouseMode{

  /** Code Created and Written by Gianna Rasmussen
   * Runs command based on active mouse mode.
   * This could also be at the end of MouseHandler mouseReleased
   * @param clickCoordinates is used in all three cases of mouse modes excluding error.
   * @param appState is used only in OnDraw in order to create a new shape.
   * @param paintCanvas is used for the painCanvas.repaint() command.
   */

  public CommandMouseMode(ClickCoordinates clickCoordinates, UserChoicesImpl appState,
      PaintCanvas paintCanvas){

    EventCallback eventCommand;

    switch (appState.getActiveMouseMode()){
      case DRAW:
        eventCommand = new OnDraw(clickCoordinates, appState, paintCanvas);
        break;
      case SELECT:
        eventCommand = new OnSelect(clickCoordinates);
        break;
      case MOVE:
        eventCommand = new OnMove(clickCoordinates, paintCanvas);
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + appState.getActiveMouseMode());
    }

    eventCommand.run();

  }


}
