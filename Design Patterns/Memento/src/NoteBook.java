import java.util.ArrayList;

public class NoteBook {

    private ArrayList<String> notes = new ArrayList<>();
    private final CareTaker careTaker = new CareTaker();

    public void writeNote(String note) {
        notes.add(note);
    }
    public void viewNotes() {
        for (String note : notes) {
            System.out.println(note);
        }
    }

    public void save() {
        careTaker.addMemento(new Memento((ArrayList<String>) notes.clone()));
    }

    public void revert() {
        this.notes = careTaker.getMemento().getNotes();
    }
}