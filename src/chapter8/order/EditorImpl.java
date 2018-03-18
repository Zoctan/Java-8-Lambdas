package chapter8.order;

public class EditorImpl implements Editor {
    @Override
    public void save() {
        System.out.println("success save");
    }

    @Override
    public void open() {
        System.out.println("success open");
    }

    @Override
    public void close() {
        System.out.println("success close");
    }
}
