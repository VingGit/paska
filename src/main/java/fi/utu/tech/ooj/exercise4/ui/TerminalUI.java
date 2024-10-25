package fi.utu.tech.ooj.exercise4.ui;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class TerminalUI implements UiInterface{

    private static TerminalUI uiInstance;
    private final Scanner scanner;
    private TerminalUI() {
        this.scanner = new Scanner(System.in);
    }


    public static UiInterface getUIInstance() {
        if (uiInstance == null) {
            uiInstance = new TerminalUI();
        }
        return uiInstance;
    }

    @Override
    public void printText(String text) {
        System.out.println(text);
    }

    @Override
    public int selectQuestion(String[] questions) throws SelectionException {
        if (questions.length == 0) {
            throw new SelectionException();
        }
        System.out.println("Select from the following options:");
        int selection = -1;
        for(int i = 0; i <  questions.length; i++) {
            System.out.println("Question " + (i+1) +": " + questions[i]);
        }

        do {
            try {
                System.out.print("Give the number of the selected option:");
                selection = scanner.nextInt();
                if (selection < 1 || selection > questions.length) {
                    System.out.println("Please, give an integer between 1 and " + questions.length);
                }
            } catch (InputMismatchException ex) {
                scanner.next();
                System.out.println("Please, give an integer between 1 and " + questions.length);
            } catch (NoSuchElementException | IllegalStateException ex) {
                throw new SelectionException();
            }
        } while (selection < 1 || selection > questions.length );

        return selection;
    }
}
