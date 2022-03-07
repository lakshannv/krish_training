public class Test {

    public static void main(String[] args) {

        NoteBook noteBook = new NoteBook();
        noteBook.writeNote("Note 1");
        noteBook.writeNote("Note 2");
        noteBook.save();

        noteBook.viewNotes();

        System.out.println("--Modifying NoteBook--");
        noteBook.writeNote("Note 3");
        noteBook.writeNote("Note 4");
        noteBook.writeNote("Note 5");

        noteBook.viewNotes();

        System.out.println("--Restoring Notebook back to its previous state--");
        noteBook.revert(); //reverts to the last save point

        noteBook.viewNotes();
    }
}