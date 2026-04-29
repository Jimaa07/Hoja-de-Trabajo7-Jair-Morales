public class BinarySearchTree<E extends Comparable<E>> {

    private Nodo<E> root;

    public void add(E value) {
        root = addRec(root, value);
    }

    private Nodo<E> addRec(Nodo<E> node, E value) {
        if (node == null) {
            return new Nodo<>(value);
        }

        if (value.compareTo(node.data) < 0) {
            node.left = addRec(node.left, value);
        } else {
            node.right = addRec(node.right, value);
        }

        return node;
    }

    public E get(E value) {
        return getRec(root, value);
    }

    private E getRec(Nodo<E> node, E value) {
        if (node == null) return null;

        int cmp = value.compareTo(node.data);

        if (cmp == 0) return node.data;

        if (cmp < 0)
            return getRec(node.left, value);
        else
            return getRec(node.right, value);
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Nodo<E> node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.data);
            inOrderRec(node.right);
        }
    }
}