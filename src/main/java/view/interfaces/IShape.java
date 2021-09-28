package view.interfaces;

import controller.Pointer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public interface IShape {


  void fill(Graphics g, Pointer pointer, Color c);

  void outline(Graphics g, Pointer pointer, Color c);


}
