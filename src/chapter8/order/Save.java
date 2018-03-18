package chapter8.order;

public class Save implements Action {
    private final Editor editor;

    Save(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.save();
    }
}
