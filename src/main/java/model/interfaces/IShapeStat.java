package model.interfaces;

import model.Pointer;
import java.awt.Color;
import model.ShapeShadingType;
import model.ShapeType;

public interface IShapeStat {
  Pointer getPointer();
  IShape getShape();
  Color getActivePrimaryColor();
  Color getActiveSecondaryColor();
  ShapeShadingType getActiveShapeShadingType();

  //might not need. Will asses after all shapes are able to be drawn.
  ShapeType getActiveShapeType();
}
