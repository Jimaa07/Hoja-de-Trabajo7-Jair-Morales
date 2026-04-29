package main;
public class Nodo<E> {
    E data;
    Nodo<E> left, right;

    public Nodo(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}