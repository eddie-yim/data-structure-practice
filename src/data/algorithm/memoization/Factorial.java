package data.algorithm.memoization;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Factorial {

    private final Map<Integer, BigInteger> cache;

    public Factorial() {
        this.cache = new HashMap<>();
    }

    private void memoize(int n) {
        if (n < 1) {
            return;
        }
        IntStream.range(1, 1 + n)
            .filter(x -> !this.cache.containsKey(x))
            .forEach(x -> {
                int prev = x - 1;
                BigInteger result = this.cache.containsKey(prev)
                        ? this.cache.get(prev).multiply(BigInteger.valueOf(x))
                        : BigInteger.valueOf(x);
                System.out.println(x + "! = " + result);
                this.cache.put(x, result);
            });
    }

    public BigInteger of(int n) {
        this.memoize(n);
        return this.cache.get(n);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.of(9));
        System.out.println(factorial.of(7));
        System.out.println(factorial.of(11));
    }
}
