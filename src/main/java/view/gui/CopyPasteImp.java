package view.gui;

import controller.ShapeList;
import java.util.ArrayList;
import model.interfaces.IShapeStat;

public class CopyPasteImp {

  private static final ArrayList<IShapeStat> copiedList = new ArrayList<>();

  public static void setCopyList(){
    //might need to check if getSelectedShapeList is empty
    if(!copiedList.isEmpty()){
      copiedList.clear();
    }

    ArrayList<IShapeStat> s = new ArrayList<>(ShapeList.getSelectedShapeList());
    copiedList.addAll(s);
  }

  public static ArrayList<IShapeStat> getCopiedList(){
    return copiedList;
  }

}
