package chapter8.order;

public class Open implements Action {
    private final Editor editor;

    Open(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.open();
    }
}
