package chapter8.observer;

public class Aliens implements LandingObserver {
    @Override
    public void observerLanding(String name) {
        if (name.contains("Apollo")) {
            System.out.println("Aliens: They're distracted, lets invade earth!");
        }
    }
}
