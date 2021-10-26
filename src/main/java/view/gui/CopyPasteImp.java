package view.gui;

import controller.ShapeArrays;
import controller.interfaces.Undoable;
import java.util.ArrayList;
import model.ShapeStat;
import model.interfaces.IShapeStat;
import view.interfaces.EventCallback;

public class CopyPasteImp {

  private static final ArrayList<IShapeStat> copiedList = new ArrayList<>();

  public static void copy() {
    //might need to check if getSelectedShapeList is empty
    if(!copiedList.isEmpty()){
      copiedList.clear();
    }

    ArrayList<IShapeStat> s = new ArrayList<>(ShapeArrays.getSelectedShapeList());
    copiedList.addAll(s);
  }



  public static void paste(){
    ArrayList<IShapeStat> newCL = new ArrayList<>();
    for(IShapeStat shapeStat : copiedList){
      IShapeStat s = new ShapeStat(shapeStat);


      newCL.add(s);
    }
    copiedList.clear();
    copiedList.addAll(newCL);


  }
}
