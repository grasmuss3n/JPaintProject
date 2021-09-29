package model.interfaces;

import model.Pointer;
import java.awt.Color;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShape;

public interface IShapeStat {
  Pointer getPointer();
  IShape getShape();
  Color getActivePrimaryColor();
  Color getActiveSecondaryColor();
  ShapeShadingType getActiveShapeShadingType();
  ShapeType getActiveShapeType();
}
