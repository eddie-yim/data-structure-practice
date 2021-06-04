package data.algorithm.basenotation;

import java.util.Arrays;

public class Base62 {
    private final static char[] CHARACTERS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    private final static int RADIX = 62;

    public static String toBase62(long base10Number) {// base10 -> base62
        StringBuilder base62 = new StringBuilder();

        while (base10Number > 0) {
            int index = (int) base10Number % RADIX;
            base62.insert(0, CHARACTERS[index]);
            base10Number /= RADIX;
        }

        return base62.toString();
    }

    public static long toDecimal(String base62Text) {// base62 -> base10
        long base10 = 0L;

        for (char c : base62Text.toCharArray()) {
            base10 = base10 * RADIX + Arrays.binarySearch(CHARACTERS, c);
        }

        return base10;
    }

    public static void main(String[] args) {
        long n = 100_000;
        String r = Base62.toBase62(n);
        System.out.println("R: " + r);
        System.out.println("N: " + Base62.toDecimal(r));
    }
}