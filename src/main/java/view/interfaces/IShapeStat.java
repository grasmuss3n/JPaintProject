package view.interfaces;

import controller.Pointer;
import java.awt.Color;
import java.awt.Graphics;
import model.ShapeShadingType;
import model.ShapeType;

public interface IShapeStat {
  Pointer getPointer();
  IShape getShape();
  Color getActivePrimaryColor();
  Color getActiveSecondaryColor();
  ShapeShadingType getActiveShapeShadingType();
  ShapeType getActiveShapeType();
}
