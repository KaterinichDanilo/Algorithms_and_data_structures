package Homework4;

public class Deque<T extends Human> {
    private TwoLinkedList deque;
    private int items;

    public Deque() {
        items = 0;
    }

    public boolean isEmpty() { return (items == 0); }
    public int size() { return items; }

    public void insertRight(T i) {
        deque.pushRight(i);
    }

    public void insertLeft(T i) {
        deque.pushLeft(i);
    }

    public void removeRight() {
        deque.popTail();
    }

    public void removeLeft() {
        deque.popHead();
    }

    public void show() {
        deque.show();
    }
}
