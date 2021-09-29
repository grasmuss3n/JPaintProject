package controller;

import controller.command.CommandHistory;
import model.OnDraw;
import controller.interfaces.iCommand;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.persistence.UserChoicesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import view.gui.PaintCanvas;

/**
 * MouseHandler is responsible for propagating mouse coordinates into our application
 * classes. This is a boundary class so very little code should be added here.
 */
public class MouseHandler extends MouseAdapter {

  private static final Logger log = LoggerFactory.getLogger(MouseHandler.class);


  private PaintCanvas paintCanvas;

  private Pointer pointer;

  private UserChoicesImpl appState;


  public void paintCanvasMouseHandler(PaintCanvas paintCanvas, UserChoicesImpl appState){
    this.paintCanvas = paintCanvas;
    this.appState = appState;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    log.debug("Start " + e.getX() + " " + e.getY());
    this.pointer = new Pointer();
    pointer.startCoordinates(e.getX(), e.getY());

  }



  @Override
  public void mouseReleased(MouseEvent e) {
    log.debug("End " + e.getX() + " " + e.getY());
    pointer.endCoordinates(e.getX(), e.getY());

    iCommand command = null;
    switch (appState.getActiveMouseMode()){
      case DRAW:
         command = new OnDraw(pointer, appState, paintCanvas);
      case SELECT:
        break;
      case MOVE:
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + appState.getActiveMouseMode());
    }
    command.run();


  }


}

