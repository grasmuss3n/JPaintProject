package model.interfaces;

import model.Pointer;
import java.awt.Color;
import java.awt.Graphics;

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


  void fill(Graphics g, Pointer pointer, Color c);

  void outline(Graphics g, Pointer pointer, Color c);

  void draw(Graphics g, Pointer pointer);

}
