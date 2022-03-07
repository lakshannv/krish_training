import java.util.ArrayList;

public class Memento {

    private final ArrayList<String> notes;

    public Memento(ArrayList<String> notes) {
        this.notes = notes;
    }

    public ArrayList<String> getNotes() {
        return notes;
    }
}