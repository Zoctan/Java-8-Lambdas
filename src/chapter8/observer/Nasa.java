package chapter8.observer;

public class Nasa implements LandingObserver {
    @Override
    public void observerLanding(String name) {
        if (name.contains("Apollo")) {
            System.out.println("Nasa: We made it!");
        }
    }
}
