package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.ShapeMaker;
import model.ShapeType;
import model.interfaces.UserChoices;
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
  private int x;
  private int y;

  private Pointer pointer;
  private UserChoicesImpl appState;

  public MouseHandler(UserChoicesImpl appState){
    this.appState = appState;
  }


  public void paintCanvasMouseHandler(PaintCanvas paintCanvas){
    this.paintCanvas = paintCanvas;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    log.debug("Start " + e.getX() + " " + e.getY());
    x = e.getX();
    y = e.getY();
    pointer = new Pointer(x, y);

  }

  @Override
  public void mouseDragged(MouseEvent e) {
    log.debug("Drag " + e.getX() + " " + e.getY());
    //pointer.endCoordinates(e.getX(), e.getY());

  }

  @Override
  public void mouseReleased(MouseEvent e) {
    log.debug("End " + e.getX() + " " + e.getY());
    pointer.endCoordinates(e.getX(), e.getY());
    new ShapeMaker(appState, pointer);
  }


}

