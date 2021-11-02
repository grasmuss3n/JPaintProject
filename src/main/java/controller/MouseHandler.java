package controller;

import controller.command.CommandMouseMode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.ClickCoordinates;
import model.persistence.UserChoicesImpl;


/**
 * MouseHandler is responsible for propagating mouse coordinates into our application
 * classes. This is a boundary class so very little code should be added here.
 */
public class MouseHandler extends MouseAdapter {

  private ClickCoordinates clickCoordinates;

  private UserChoicesImpl appState;


  public void paintCanvasMouseHandler(UserChoicesImpl appState){
    this.appState = appState;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    clickCoordinates = new ClickCoordinates();
    clickCoordinates.startCoordinates(e.getX(), e.getY());

  }



  @Override
  public void mouseReleased(MouseEvent e) {
    clickCoordinates.endCoordinates(e.getX(), e.getY());

    new CommandMouseMode(clickCoordinates, appState);

  }


}

