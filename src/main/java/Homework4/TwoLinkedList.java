package Homework4;

class Node<T extends Human>{
    T data;
    Node next;
    Node previous;

    public Node(T data) {
        this.data = data;
    }
}
public class TwoLinkedList <T extends Human>{
    Node head;
    Node tail;
    Iterator iterator = new Iterator(this);

    public TwoLinkedList() {
        this.head = null;
        this.tail = null;
        iterator = new Iterator(this);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void pushRight(T d) {
        Node node = new Node(d);

        if (this.isEmpty()){
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.previous = this.tail;
            this.tail = node;
        }
    }

    public void pushLeft(T d) {
        Node node = new Node(d);

        if (this.isEmpty()){
            this.head = node;
            this.tail = node;
        } else {
            this.head.previous = node;
            node.next = this.head;
            this.head = node;
        }
    }

    public T peekHead() {
        if (isEmpty()){
            return null;
        }
        return (T) head.data;
    }

    public T peekTail() {
        if (isEmpty()){
            return null;
        }
        return (T) tail.data;
    }

    public T popHead() {
        if (isEmpty()){
            return null;
        }
        T d = (T) head.data;
        head = head.next;
        return d;
    }

    public T popTail() {
        if (isEmpty()){
            return null;
        }
        T d = (T) tail.data;
        tail = tail.previous;
        return d;
    }

    public T find(T d) {
        if (isEmpty()){
            return null;
        }
        Node current = head;
        while (!(current.data.age == d.age && current.data.name.equals(d.name))) {
            if (current.next == null) { return null; }
            else {
                current = current.next;
            }
        }

        return (T) current.data;
    }

    public Node findNode(T d) {
        if (isEmpty()){
            return null;
        }
        Node current = head;
        while (!(current.data.age == d.age && current.data.name.equals(d.name))) {
            if (current.next == null) { return null; }
            else {
                current = current.next;
            }
        }

        return current;
    }

    public T delete(T d) {
        Node toDelete = findNode(d);
        if (isEmpty()){
            return null;
        }
        if (toDelete.next == null) {
            toDelete.previous.next = null;
            this.tail = toDelete.previous;
            return (T) toDelete.data;
        }
        if (toDelete.previous == null) {
            toDelete.next.previous = null;
            this.head = toDelete.next;
            return (T) toDelete.data;
        }
        Node next = toDelete.next;
        Node prev = toDelete.previous;

        prev.next = next;
        next.previous = prev;
        return (T) toDelete.data;
    }

    public void show() {
        StringBuilder sb = new StringBuilder("[ ");
        Node current = head;

        while (current.next != null) {
            sb.append("( '" + current.data.name + "', " + current.data.age + ") ");
        }
        sb.append("\n");
        System.out.println(sb.toString());
    }
}

class Iterator<T extends Human>{
    private TwoLinkedList list;
    private Node current;

    public Iterator(TwoLinkedList twoLinkedList) {
        this.list = twoLinkedList;
        this.current = twoLinkedList.head;
    }

    public void reset() {
        while (current.previous != null) {
            current = current.previous;
        }
    }

    public void next() {
        if (current.next != null) {
            current = current.next;
        }
    }

    public T getCurrent() {
        return (T) current.data;
    }

    public boolean getEnd() {
        return (current.next == null);
    }

    public void insertAfter(T d) {
        Node node = new Node(d);
        if (list.isEmpty()) {
            list.pushRight(d);
            current = node;
            return;
        }
        node.next = current.next;
        current.next = node;
        node.previous = current;
        node.next.previous = node;
    }

    public void insertBefore(T d) {
        Node node = new Node(d);
        if (list.isEmpty()) {
            list.pushLeft(d);
            current = node;
            return;
        }
        node.next = current;
        node.previous = current.previous;
        current.previous.next = node;
        current.previous = node;
    }

    public void deleteCurrent() {
        current.next.previous = current.previous;
        current.previous.next = current.next;
    }
}
