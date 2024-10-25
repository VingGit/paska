package fi.utu.tech.ooj.exercise4.storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVDataSource implements DataSource {
    private final String filePath;

    public CSVDataSource() {
        URL resource = CSVDataSource.class.getResource("/questionsAndAnswers.csv");
        try {
            this.filePath = Paths.get(resource.toURI()).toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DataItem> readQuestions() {
        return readByType("question");
    }

    @Override
    public List<DataItem> readAnswers() {
        return readByType("answer");
    }

    private List<DataItem> readByType(String targetType) {
        List<DataItem> items = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String type = parts[0].replaceAll("^\"|\"$", "");
                    String text = parts[1].replaceAll("^\"|\"$", "");
                    if (type.equals(targetType)) {
                        items.add(new DataItem(type, text));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
}

