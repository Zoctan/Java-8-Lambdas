package chapter8.SOLID.O;

public interface MetricDataGraph {
    void updateUserTime(int value);

    void updateSystemTime(int value);

    void updateIOTime(int value);
}
