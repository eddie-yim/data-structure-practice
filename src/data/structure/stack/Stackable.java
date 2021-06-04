package data.structure.stack;

public interface Stackable<T> {
    T pop();

    void push(T item);

    T peek();

    boolean isEmpty();
}
