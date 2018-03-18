package chapter8.order;

import java.util.ArrayList;
import java.util.List;

public class Macro {
    private final List<Action> actions;

    Macro() {
        actions = new ArrayList<>();
    }

    void record(Action action) {
        actions.add(action);
    }

    void run() {
        actions.forEach(Action::perform);
    }
}
