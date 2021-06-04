package data.algorithm.memoization;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Factorial {

    private final Map<Integer, BigInteger> cache;

    private Factorial() {
        this.cache = new HashMap<>();
    }

    private void memoize(int n) {
        if (n < 1) {
            return;
        }
        IntStream.range(1, 1 + n).forEach(x -> {
            int prev = x - 1;
            BigInteger current = this.cache.containsKey(prev)
                    ? this.cache.get(prev).multiply(BigInteger.valueOf(x))
                    : BigInteger.valueOf(x);
            System.out.println(x + "! = " + current);
            this.cache.put(x, current);
        });
    }

    public static BigInteger of(int n) {
        Factorial f = new Factorial();
        f.memoize(n);
        return f.cache.get(n);
    }

    public static void main(String[] args) {
        System.out.println(Factorial.of(9));
    }
}
