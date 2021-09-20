package main;

import controller.EventConnector;
import controller.EventConnectorImpl;
import controller.KeyboardInterface;
import controller.MouseHandler;
import java.awt.Graphics2D;
import model.ShapeColor;
import model.persistence.ShapeColorTrans;
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
        mouse.paintCanvasMouseHandler(paintCanvas);
        paintCanvas.addMouseListener(mouse);
        paintCanvas.addMouseMotionListener(mouse);
        controller.setup();


        Thread.sleep(500);

        Graphics2D graphics2d = paintCanvas.getGraphics2D();

        //Tests
        ShapeColorTrans s = new ShapeColorTrans(ShapeColor.BLUE);

    }
}
