package controller.command;

import controller.interfaces.Paste;
import controller.interfaces.Undoable;
import java.util.Stack;
import view.interfaces.EventCallback;

public class PasteCommand implements EventCallback, Undoable{

  private static final Stack<Paste> pasteStack = new Stack<>();


  public static void add(Paste cmd) {
    pasteStack.push(cmd);
  }

  @Override
  public void run() {
    CommandHistory.add(this);
  }

  public static void paste() {
    if(!pasteStack.empty()){
      Paste p = pasteStack.get(0);
      p.paste();
    }

  }

  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }


}
