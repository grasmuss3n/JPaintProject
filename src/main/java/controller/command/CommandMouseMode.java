package controller.command;

import static model.MouseMode.DRAW;
import static model.MouseMode.MOVE;
import static model.MouseMode.SELECT;

import controller.interfaces.Undoable;
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
        eventCommand = new OnMove();
        break;
    }

    eventCommand.run();

  }


}