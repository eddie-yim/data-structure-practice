package data.structure.stack;

import data.structure.stack.exception.EmptyStackException;

public class LinkedStack<T> implements Stackable<T> {
    private Node<T> top;

    @Override
    public T pop() {
        if (this.top == null) {
            throw new EmptyStackException();
        }
        T item = this.top.value;
        this.top = this.top.next;
        return item;
    }

    @Override
    public void push(T item) {
        Node<T> newbie = new Node<>(item);
        newbie.next = this.top;
        this.top = newbie;
    }

    @Override
    public T peek() {
        if (this.top == null) {
            throw new EmptyStackException();
        }
        return this.top.value;
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    private static class Node<T> {
        private final T value;

        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
