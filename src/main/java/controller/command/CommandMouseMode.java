package controller.command;

import model.ClickCoordinates;
import model.persistence.UserChoicesImpl;
import view.gui.OnDraw;
import view.gui.OnMove;
import view.gui.OnSelect;
import view.gui.PaintCanvas;
import view.interfaces.EventCallback;

public class CommandMouseMode{

  public CommandMouseMode(ClickCoordinates clickCoordinates, UserChoicesImpl appState,
      PaintCanvas paintCanvas){

    EventCallback eventCommand = null;

    switch (appState.getActiveMouseMode()){
      case DRAW:
        eventCommand = new OnDraw(clickCoordinates, appState, paintCanvas);
        break;
      case SELECT:
        eventCommand = new OnSelect(clickCoordinates, paintCanvas);
        break;
      case MOVE:
        eventCommand = new OnMove(clickCoordinates, paintCanvas);
        break;
    }

    eventCommand.run();

  }


}
