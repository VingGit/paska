package fi.utu.tech.ooj.exercise4.gameLogic;

import fi.utu.tech.ooj.exercise4.storage.DataItem;
import fi.utu.tech.ooj.exercise4.storage.DataSource;
import fi.utu.tech.ooj.exercise4.ui.SelectionException;
import fi.utu.tech.ooj.exercise4.ui.UiInterface;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
    private final UiInterface ui;
    private final DataSource dataSource;
    private List<DataItem> questions;
    private List<DataItem> answers;
    private final Random random = new Random();

    public Game(UiInterface ui, DataSource dataSource) {
        this.ui = ui;
        this.dataSource = dataSource;
    }

    public void initialize() {
        this.questions = dataSource.readQuestions();
        this.answers = dataSource.readAnswers();
    }

    public void startGame(int numberOfQuestions) {
        ui.printText("\n***********************");
        ui.printText("***** Game starts *****");
        ui.printText("***********************\n");

        for (int i = 0; i < 3; i++) {
            askQuestion(numberOfQuestions);
            answerRandomAnswer();
        }

        ui.printText("\n*********************");
        ui.printText("***** Game ends *****");
        ui.printText("*********************\n");

    }

    private void askQuestion(int numberOfQuestions){
        String[] questionsToAsk = selectRandomQuestions(numberOfQuestions);
        try {
            int result = ui.selectQuestion(questionsToAsk);
            ui.printText("\n***********");
            ui.printText("**** Your question: " + questionsToAsk[result-1]);
        } catch (SelectionException e) {
            System.out.println("Selecting a question failed. Game ends.");
            throw new RuntimeException();

        }
    }
    private String[] selectRandomQuestions(int numberOfQuestions) {
        Collections.shuffle(questions);
        return questions.subList(0, Math.min(numberOfQuestions, questions.size())).stream().map(DataItem::getText).toArray(String[]::new);
    }

    private void answerRandomAnswer() {
        ui.printText("**** Well, I will answer: " +answers.get(random.nextInt(answers.size())).getText());
        ui.printText("***********\n");
    }
}
