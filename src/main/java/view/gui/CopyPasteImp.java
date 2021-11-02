package view.gui;

import controller.ShapeArrays;
import java.util.ArrayList;
import model.ClickCoordinates;
import model.ShapeStat;
import model.interfaces.IShapeStat;
import view.interfaces.EventCallback;

public class CopyPasteImp{

  private static final ArrayList<IShapeStat> copied = new ArrayList<>();

  public static void copy() {
    if(!copied.isEmpty()){
      copied.clear();
    }

    ArrayList<IShapeStat> selectedList = new ArrayList<>(ShapeArrays.getSelectedShapeList());

    for (IShapeStat s : selectedList){

      copied.add(s);
    }

  }

  public static void paste(){

    ArrayList<IShapeStat> sL = ShapeArrays.getShapeList();
    ArrayList<ArrayList<IShapeStat>> pasteL = ShapeArrays.getPasted();

    ArrayList<IShapeStat> pasting = new ArrayList<>();
    for (IShapeStat shapeStat : copied) {


      ClickCoordinates ss = shapeStat.getClickCoordinates();

      ClickCoordinates c = new ClickCoordinates();
      c.startCoordinates(ss.getX1()+50, ss.getY1()+50);
      c.endCoordinates(ss.getX2()+50, ss.getY2()+50);

      IShapeStat s = new ShapeStat(c, shapeStat.getAppState(), shapeStat.getShape());

      while(ShapeArrays.getShapeStat(s)){
        c.startCoordinates(c.getX1()+50, c.getY1()+50);
        c.endCoordinates(c.getX2()+50, c.getY2()+50);
        s.setClickCoordinates(c.getX1(),c.getY1(),c.getX2(),c.getY2());
      }

      sL.add(s);
      pasting.add(s);

    }
    pasteL.add(pasting);

    EventCallback eventCommand = new OnPaste();
    eventCommand.run();
  }



}
