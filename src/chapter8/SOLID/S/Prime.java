package chapter8.SOLID.S;

import java.util.stream.IntStream;

public class Prime {
    public static void main(String[] args) {
        Prime prime = new Prime();
        assert prime.countPrimes1(10) == prime.countPrimes2(10);
        assert prime.countPrimes1(10) == prime.countPrimes3(10);
        assert prime.countPrimes1(10) == prime.countPrimes4(10);
    }

    private long countPrimes1(int upTo) {
        long total = 0;
        for (int i = 1; i < upTo; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                total++;
            }
        }
        return total;
    }

    private long countPrimes2(int upTo) {
        long total = 0;
        for (int i = 1; i < upTo; i++) {
            if (isPrime2(i)) {
                total++;
            }
        }
        return total;
    }

    private boolean isPrime2(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private long countPrimes3(int upTo) {
        return IntStream.range(1, upTo)
                .filter(this::isPrime3)
                .count();
    }

    private boolean isPrime3(int num) {
        return IntStream.range(2, num)
                .allMatch(x -> (num % x) != 0);
    }

    private long countPrimes4(int upTo) {
        return IntStream.range(1, upTo)
                .parallel()
                .filter(this::isPrime3)
                .count();
    }
}
