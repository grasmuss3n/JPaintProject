package controller;

import controller.command.CommandHistory;
import model.interfaces.UserChoices;
import view.EventName;
import view.gui.CopyPasteImp;
import view.gui.OnDelete;
import view.interfaces.UiModule;

/**
 * @see controller.EventConnector
 */
public class EventConnectorImpl implements EventConnector {
    private final UiModule uiModule;
    private final UserChoices userChoices;



    public EventConnectorImpl(UiModule uiModule, UserChoices userChoices) {
        this.uiModule = uiModule;
        this.userChoices = userChoices;


    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> userChoices.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> userChoices.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> userChoices.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> userChoices.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> userChoices.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, () -> CommandHistory.undo());
        uiModule.addEvent(EventName.REDO, () -> CommandHistory.redo());
        uiModule.addEvent(EventName.COPY, () -> CopyPasteImp.copy());
        uiModule.addEvent(EventName.PASTE, () -> CopyPasteImp.paste());
        uiModule.addEvent(EventName.DELETE, () -> OnDelete.delete());
    }



}
