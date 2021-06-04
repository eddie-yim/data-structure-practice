package data.algorithm.search;

import data.algorithm.search.exception.SearchFailedException;

import java.util.Arrays;

/**
 * Precondition
 * 탐색하고자 하는 자료구조는 인덱스로 값에 접근할 수 있어야 한다.
 * 탐색하고자 하는 자료구조는 정렬되어 있어야 한다.
 */
public class BinarySearch<T extends Comparable<T>> {

    public Result<T> search(T[] haystack, T needle) {
        if (haystack == null || needle == null || haystack.length < 1) {
            throw new SearchFailedException();
        }
        int from = 0;
        int to = haystack.length - 1;

        while (from <= to) {
            int mid = (from + to) >> 1;// (int)((from + to)/2)
            T value = haystack[mid];

            if (value.compareTo(needle) < 0) {
                from = mid + 1;
            } else if (value.compareTo(needle) > 0) {
                to = mid - 1;
            } else {
                return new Result<>(mid, value);
            }
        }

        return null;
    }

    public static class Result<T> {
        private final int index;

        private final T value;

        private Result(int index, T value) {
            this.index = index;
            this.value = value;
        }

        public int index() {
            return index;
        }

        public T value() {
            return value;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        Character[] alphabet = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };
        Arrays.stream(alphabet)
            .map(c -> {
                BinarySearch<Character> bs = new BinarySearch<>();
                return bs.search(alphabet, c);
            })
            .forEach(System.out::println);
    }
}
