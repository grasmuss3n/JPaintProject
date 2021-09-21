package view.gui;

import controller.Pointer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import model.ShapeColor;
import model.ShapeShadingType;

public class DrawRectangle {

  private Pointer pointer;
  private Color primaryC;
  private Color secondaryC;
  private ShapeShadingType shadingType;

  public DrawRectangle(Pointer pointer, ShapeColor primaryC, ShapeColor secondaryC, ShapeShadingType shadingType){
    this.pointer = pointer;
    this.primaryC = primaryC.getColor();
    this.secondaryC = secondaryC.getColor();
    this.shadingType = shadingType;
  }

  public void paint(Graphics g){
    Graphics2D g2 = (Graphics2D) g;
    
  }


}
