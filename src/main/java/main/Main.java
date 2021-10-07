package main;

import controller.EventConnector;
import controller.EventConnectorImpl;
import controller.KeyboardInterface;
import controller.MouseHandler;
import model.persistence.UserChoicesImpl;
import view.gui.Gui;
import view.gui.GuiWindowImpl;
import view.gui.PaintCanvas;
import view.interfaces.GuiWindow;
import view.interfaces.UiModule;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        PaintCanvas paintCanvas = new PaintCanvas();
        GuiWindow guiWindow = new GuiWindowImpl(paintCanvas);
        UiModule uiModule = new Gui(guiWindow);
        UserChoicesImpl appState = new UserChoicesImpl(uiModule);
        EventConnector controller = new EventConnectorImpl(uiModule, appState);

        KeyboardInterface keys = new KeyboardInterface(paintCanvas, appState);
        keys.setup();


        MouseHandler mouse = new MouseHandler();
        mouse.paintCanvasMouseHandler(paintCanvas, appState);
        paintCanvas.addMouseListener(mouse);
        controller.setup();



        //Test Confirming that a shape will be created when onDraw is run.
/*

        Pointer pointer = new Pointer();
        pointer.startCoordinates(105, 50);
        pointer.endCoordinates(503, 190);

        //Size test
        int height = pointer.getHeight();
        int width = pointer.getWidth();
        System.out.println(height + ", " + width);

        EventCallback command = new OnDraw(pointer, appState, paintCanvas);
        command.run();

        //Test to see if the command.run lead to the shape being saved.
        System.out.println(ShapeList.getShapeListStat());

*/

        //End of tests on main





        Thread.sleep(500);



    }
}
