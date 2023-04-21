package giaodien;

public class DataEvent extends java.util.EventObject {
    private final String data;

    public DataEvent(Object source, String data) {
        super(source);
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
