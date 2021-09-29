package view.interfaces;

import controller.Pointer;
import java.awt.Color;
import java.awt.Graphics;

public interface IShape {

  void fill(Graphics g, Pointer pointer, Color c);

  void outline(Graphics g, Pointer pointer, Color c);

  void draw(Graphics g, Pointer pointer);

}
