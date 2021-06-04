package data.algorithm.recursion;

/**
 * 일반적으로 f(n) == return f(n - 1) + f(n - 2) 로 작성하면
 * 기하 급수적으로 늘어나는 수열의 특성으로 n이 조금만 커지면 StackOverflowError가 발생하기 쉽다.
 * 이를 해결하고자 꼬리 재귀나 기본 loop 문을 활용한다.
 */
public class Fibonacci {

    public static long fibonacci(int n) {
        return tailRecursion(0, 1, n);
    }

    private static long tailRecursion(long beforePrev, long prev, int n) {
        if (n < 2) {
            return n;
        }

        long current = beforePrev + prev;
        if (n == 2) {
            return current;
        }

        return tailRecursion(prev, current, n - 1);
    }

    public static long forLoop(int n) {
        if (n < 2) {
            return n;
        }

        long current = 0, beforePrev = 0, prev = 1;// initial value
        for (int i = 2; i <= n; i++) {
            current = beforePrev + prev;
            if (i < n) {
                beforePrev = prev;
                prev = current;
            }
        }

        return current;
    }

    public static void main(String[] args) {//6 -> 8, 16 -> 987
        System.out.println(Fibonacci.fibonacci(6));
        System.out.println(Fibonacci.fibonacci(16));
        System.out.println(Fibonacci.forLoop(6));
        System.out.println(Fibonacci.forLoop(16));
    }
}
