package fi.utu.tech.ooj.exercise4.storage;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLiteDataSource implements DataSource {
    private String databaseUrl;

    public SQLiteDataSource() {

        URL resource = CSVDataSource.class.getResource("/questionsAndAnswers.db");
        try {
            this.databaseUrl = "jdbc:sqlite:" + Paths.get(resource.toURI()).toString();
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
        try (Connection conn = DriverManager.getConnection(databaseUrl);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT type, text FROM qaData WHERE type = '" + targetType + "'")) {

            while (rs.next()) {
                String type = rs.getString("type");
                String text = rs.getString("text");
                items.add(new DataItem(type, text));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}

