package fi.utu.tech.ooj.exercise4.ui;

public class GuiUI implements UiInterface{

    private static GuiUI uiInstance;
    private GuiUI() {
        System.out.println("GUI not implemented in this exercise.");
    }
    public static UiInterface getUIInstance() {
        if (uiInstance == null) {
            uiInstance = new GuiUI();
        }
        return uiInstance;
    }

    @Override
    public void printText(String text) {
        System.out.println("Printing text to GUI not implemented in this exercise.");
    }

    @Override
    public int selectQuestion(String[] questions) {
        System.out.println("Asking questions using GUI not implemented in this exercise.");
        return 0;
    }
}
