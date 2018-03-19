package chapter8.order;

public class UsingMacro {
    private static Editor editor = new EditorImpl();

    public static void main(String[] args) {
        orderMode();
        lambda();
        methodReference();
    }

    private static void orderMode() {
        Macro macro = new Macro();
        macro.record(new Open(editor));
        macro.record(new Save(editor));
        macro.record(new Close(editor));
        macro.run();
    }

    private static void lambda() {
        Macro macro = new Macro();
        macro.record(() -> editor.open());
        macro.record(() -> editor.save());
        macro.record(() -> editor.close());
        macro.run();
    }

    private static void methodReference() {
        Macro macro = new Macro();
        macro.record(editor::open);
        macro.record(editor::save);
        macro.record(editor::close);
        macro.run();
    }
}
