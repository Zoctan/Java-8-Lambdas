package chapter8.order;

public class Close implements Action {
    private final Editor editor;

    Close(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.close();
    }
}
