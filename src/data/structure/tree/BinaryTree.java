package data.structure.tree;

import java.util.function.Consumer;

/**
 * 순회 방법별로 다음의 순서로 순회한다.
 *       (1)
 *      ↙   ↘
 *    (2)   (3)
 *   ↙   ↘
 * (4)   (5)
 * Inorder: Left, Parent, Right (4) (2) (5) (1) (3)
 * Preorder: Parent, Left, Right (1) (2) (4) (5) (3)
 * Postorder: Left, Right, Parent (4) (5) (2) (3) (1)
 */
public class BinaryTree<T> {

    private final Node<T> root;

    public BinaryTree(Node<T> root) {
        if (root == null) {
            throw new IllegalArgumentException("Node cannot be null.");
        }
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void inorderTraversal(Node<T> node, final Consumer<T> consumer) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, consumer);
        consumer.accept(node.value);
        inorderTraversal(node.right, consumer);
    }

    public void preorderTraversal(Node<T> node, final Consumer<T> consumer) {
        if (node == null) {
            return;
        }
        consumer.accept(node.value);
        preorderTraversal(node.left, consumer);
        preorderTraversal(node.right, consumer);
    }

    public void postorderTraversal(Node<T> node, final Consumer<T> consumer) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left, consumer);
        postorderTraversal(node.right, consumer);
        consumer.accept(node.value);
    }

    public static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            if (value == null) {
                throw new IllegalArgumentException("Node's value cannot be null.");
            }
            this.value = value;
        }

        public Node<T> setLeft(Node<T> left) {
            this.left = left;
            return this;
        }

        public Node<T> setRight(Node<T> right) {
            this.right = right;
            return this;
        }
    }

    public static void main(String[] args) {
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);

        Node<Integer> n2 = (new Node<>(2)).setLeft(n4).setRight(n5);
        Node<Integer> n3 = new Node<>(3);

        Node<Integer> n1AsRoot = (new Node<>(1)).setLeft(n2).setRight(n3);

        BinaryTree<Integer> tree = new BinaryTree<>(n1AsRoot);

        System.out.println("Inorder");
        tree.inorderTraversal(tree.getRoot(), System.out::println);
        System.out.println("Preorder");
        tree.preorderTraversal(tree.getRoot(), System.out::println);
        System.out.println("Postorder");
        tree.postorderTraversal(tree.getRoot(), System.out::println);
    }
}
