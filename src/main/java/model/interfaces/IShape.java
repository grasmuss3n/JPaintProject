package model.interfaces;

import java.awt.Color;
import java.awt.Graphics;
import model.ClickCoordinates;

public interface IShape {

  /** Code Created and Written by Gianna Rasmussen
   *IShape is used for drawing the shapes
   * Fill is for filling in a shape
   * Outline is for creating an outline
   * Draw is a box containing the shape
   * @see view.gui.DrawRect
   * @see view.gui.DrawEllipse
   * @see view.gui.DrawTriangle
   *
   */


  void fill(Graphics g, ClickCoordinates clickCoordinates, Color c);

  void outline(Graphics g, ClickCoordinates clickCoordinates, Color c);

  void select(Graphics g, ClickCoordinates clickCoordinates);



}
