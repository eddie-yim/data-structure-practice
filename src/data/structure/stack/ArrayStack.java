package data.structure.stack;

import data.structure.stack.exception.EmptyStackException;

public class ArrayStack<T> implements Stackable<T> {
    private T[] container;

    private int topIndex = -1;

    private final int DEFAULT_ARRAY_SIZE = 10;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.container = (T[]) new Object[DEFAULT_ARRAY_SIZE];
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size should be greater than 0");
        }
        this.container = (T[]) new Object[size];
    }

    @Override
    public T pop() {
        if (this.topIndex < 0) {
            throw new EmptyStackException();
        }
        return this.container[topIndex--];
    }

    @SuppressWarnings("unchecked")
    @Override
    public void push(T item) {
        if (this.topIndex >= this.container.length - 1) {
            T[] copy = (T[]) new Object[this.container.length + DEFAULT_ARRAY_SIZE];
            System.arraycopy(this.container, 0, copy, 0, this.container.length);
            this.container = copy;
        }
        this.container[++topIndex] = item;
    }

    @Override
    public T peek() {
        if (this.topIndex < 0) {
            throw new EmptyStackException();
        }
        return this.container[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return this.topIndex < 0;
    }

    public static void main(String[] args) {
        ArrayStack<String> s = new ArrayStack<>(2);
        s.push("A");
        s.push("B");
        s.push("C");
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }
}
