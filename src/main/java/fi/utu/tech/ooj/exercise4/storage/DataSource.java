package fi.utu.tech.ooj.exercise4.storage;

import java.util.List;

public interface DataSource {
    List<DataItem> readQuestions();
    List<DataItem> readAnswers();
}
