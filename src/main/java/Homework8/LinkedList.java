package Homework8;

public class LinkedList {
    class Node{
        Cat data;
        Node next;

        public Node(Cat data) {
            this.data = data;
        }
    }
    Node head;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Node current = head;
        while (current.next != null) {
            sb.append("(").append(current.data.getAge()).append(") ");
        }
        sb.append("}");
        return sb.toString();
    }

    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(Cat cat) {
        Node node = new Node(cat);

        if (this.isEmpty()){
            this.head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(cat);
        }
    }

    public Cat peekHead() {
        if (isEmpty()){
            return null;
        }
        return head.data;
    }

    public Cat popHead() {
        if (isEmpty()){
            return null;
        }
        Cat d = head.data;
        head = head.next;
        return d;
    }

    public Cat find(Cat d) {
        if (isEmpty()){
            return null;
        }
        Node current = head;
        while (!(current.data.equals(d))) {
            if (current == null) { return null; }
            current = current.next;
        }

        return current.data;
    }

    public Node findNode(Cat d) {
        if (isEmpty()){
            return null;
        }
        Node current = head;
        while (!(current.data.equals(d))) {
            if (current.next == null) { return null; }
            else {
                current = current.next;
            }
        }

        return current;
    }

    public Cat delete(Cat d) {
        Node previous = head;
        while (!(previous.next.data.equals(d))) {
            if (previous.next.next == null) { return null; }
            else {
                previous = previous.next;
            }
        }
        Node delete = previous.next;

        if (isEmpty()){
            return null;
        }
        if (delete.next == null) {
            previous.next = null;
            return delete.data;
        }
        if ((new Node(d)).equals(this.head)) {
            this.head = head.next;
            return delete.data;
        }
        previous.next = delete.next;

        return delete.data;
    }

    public void show() {
        StringBuilder sb = new StringBuilder("[ ");
        Node current = head;

        while (current.next != null) {
            sb.append("( '").append(current.data.getAge()).append(") ");
        }
        sb.append("\n");
        System.out.println(sb);
    }
}

