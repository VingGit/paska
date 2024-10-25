package fi.utu.tech.ooj.exercise4.ui;

public interface UiInterface {

    void printText(String text);
    int selectQuestion(String[] questions) throws SelectionException;
    static UiInterface getUIInstance(UITypes uiType) {
        switch (uiType) {
            case GUI:
                return GuiUI.getUIInstance();
            case TERMINAL:
                return TerminalUI.getUIInstance();
            default:
                return TerminalUI.getUIInstance();
        }
    }
}
