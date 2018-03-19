package chapter8.observer;

import java.util.ArrayList;
import java.util.List;

public class Moon {
    private final List<LandingObserver> observers = new ArrayList<>();

    public void land(String name) {
        observers.forEach(observer -> observer.observerLanding(name));
    }

    public void startSpying(LandingObserver observer) {
        observers.add(observer);
    }
}
