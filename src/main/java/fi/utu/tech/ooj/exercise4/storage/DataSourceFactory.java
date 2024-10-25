package fi.utu.tech.ooj.exercise4.storage;

import fi.utu.tech.ooj.exercise4.ui.GuiUI;
import fi.utu.tech.ooj.exercise4.ui.TerminalUI;

public class DataSourceFactory {

    public static DataSource getDataSource(DataSourceTypes type) {
        return switch (type) {
            case SQLITE -> new SQLiteDataSource();
            case CSV -> new CSVDataSource();
        };
    }
}
