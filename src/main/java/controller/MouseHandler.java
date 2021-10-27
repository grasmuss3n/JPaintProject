package controller;

import controller.command.CommandMouseMode;
import controller.command.PasteCommand;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.ClickCoordinates;
import model.persistence.UserChoicesImpl;
import view.gui.PaintCanvas;


/**
 * MouseHandler is responsible for propagating mouse coordinates into our application
 * classes. This is a boundary class so very little code should be added here.
 */
public class MouseHandler extends MouseAdapter {



  private PaintCanvas paintCanvas;

  private ClickCoordinates clickCoordinates;

  private UserChoicesImpl appState;


  public void paintCanvasMouseHandler(PaintCanvas paintCanvas, UserChoicesImpl appState){
    this.paintCanvas = paintCanvas;
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

    new CommandMouseMode(clickCoordinates, appState, paintCanvas);

  }


}

