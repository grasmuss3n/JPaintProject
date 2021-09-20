package model.persistence;

import java.awt.Color;
import model.ShapeColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShapeColorTrans{

  //part of test
  ///private static final Logger log = LoggerFactory.getLogger(ShapeColorTrans.class);

  Color c;

  public ShapeColorTrans(ShapeColor shapecolor){
    c = shapecolor.getColor();
    //test
    //log.debug("Color : " + c);
  }

}
