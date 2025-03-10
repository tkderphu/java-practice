package BST;
public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    static class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;
        public Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }

        public Node<T> getLeft() {
            return left;
        }

        public T getData() {
            return data;
        }

        public Node<T> getRight() {
            return right;
        }
    }
//    public void add(T data) {
//        root = insert(root, data);
//    }
    public void add(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> r, T data) {
        if(r == null) {
            r =  new Node<>(data);
        } else if(r.data.compareTo(data) <= 0) {
            r.right = insert(r.right, data);
        } else if(r.data.compareTo(data) > 0) {
            r.left = insert(r.left, data);
        }
        return r;
    }
    public void show() {
        inOrder(root);
    }

    private void inOrder(Node<T> r) {
        if(r != null) {
            inOrder(r.left);
            System.out.print(r.data + " ");
            inOrder(r.right);
        }
    }

    public Node<T> getRoot() {
        return root;
    }
}