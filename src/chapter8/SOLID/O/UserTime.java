package chapter8.SOLID.O;

public class UserTime implements TimeSeries {
    private int value;

    @Override
    public int getValue() {
        return this.value;
    }
}
