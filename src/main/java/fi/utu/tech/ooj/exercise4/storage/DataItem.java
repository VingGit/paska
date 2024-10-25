package fi.utu.tech.ooj.exercise4.storage;

public class DataItem {
    private String type;
    private String text;

    public DataItem(String type, String text) {
        this.type = type;
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "type='" + type + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
