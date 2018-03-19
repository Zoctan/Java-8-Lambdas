package chapter8.observer;

public class UsingObserver {
    public static void main(String[] args) {
        lambdaMethod();
    }

    private static void classMethod() {
        Moon moon = new Moon();
        moon.startSpying(new Nasa());
        moon.startSpying(new Aliens());

        System.out.println("Alien's asteroid land moon...");
        moon.land("An asteroid");
        System.out.println("Apollo 11 land moon...");
        moon.land("Apollo 11");
    }

    private static void lambdaMethod() {
        Moon moon = new Moon();
        moon.startSpying(name -> {
            if (name.contains("Apollo")) {
                System.out.println("Nasa: We made it!");
            }
        });
        moon.startSpying(name -> {
            if (name.contains("Apollo")) {
                System.out.println("Aliens: They're distracted, lets invade earth!");
            }
        });

        System.out.println("Alien's asteroid land moon...");
        moon.land("An asteroid");
        System.out.println("Apollo 11 land moon...");
        moon.land("Apollo 11");
    }
}
