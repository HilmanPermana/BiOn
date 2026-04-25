import java.util.Stack;

public class TextEditor {
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();
    private String currentText = "";

    // Tambah teks
    public void addText(String text) {
        undoStack.push(currentText);

        if (currentText.isEmpty()) {
            currentText = text;
        } else {
            currentText += " " + text;
        }

        redoStack.clear();
    }

    // Undo
    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentText);
            currentText = undoStack.pop();
        } else {
            System.out.println("Tidak bisa undo!");
        }
    }

    // Redo
    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentText);
            currentText = redoStack.pop();
        } else {
            System.out.println("Tidak bisa redo!");
        }
    }

    // Getter (biar aman, tidak akses langsung)
    public String getText() {
        return currentText;
    }

    // Menampilkan teks
    public void showText() {
        System.out.println("Teks saat ini: \"" + currentText + "\"");
    }
}
