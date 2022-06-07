package Homework3;

import java.util.Arrays;

public class Deque {
    private int maxSize;
    private int[] deque;
    private int head;
    private int tail;
    private int items;

    public Deque(int s) {
        maxSize = s;
        deque = new int[maxSize];
        head = 0;
        tail = -1;
        items = 0;
    }

    public boolean isEmpty() { return (items == 0); }
    public boolean isFull() { return (items == maxSize); }
    public int size() { return items; }

    public void rightInsert(int i) {
        if (isFull()) {
            maxSize *= 2;
            int[] tmpArr = new int[maxSize];
            if (tail >= head) {
                System.arraycopy(deque, 0, tmpArr, 0, deque.length);
            } else {
                System.arraycopy(deque, 0, tmpArr, 0, tail + 1);
                System.arraycopy(deque, head, tmpArr,
                        maxSize - (deque.length - head), deque.length - head);
                head = maxSize - head - 1;
            }
        }
        if (tail == maxSize - 1) {
            tail = -1;
        }
        deque[++tail] = i;
        ++items;
    }

    public void insertLeft(int i) {
        if (isFull()) {
            maxSize *= 2;
            int[] tmpArr = new int[maxSize];
            if (tail >= head) {
                System.arraycopy(deque, 0, tmpArr, 0, deque.length);
            } else {
                System.arraycopy(deque, 0, tmpArr, 0, tail + 1);
                System.arraycopy(deque, head, tmpArr,
                        maxSize - (deque.length - head), deque.length - head);
                head = maxSize/2 + head;
            }
            deque = tmpArr;
        }
        if (head == 0) {
            head = maxSize;
        }
        deque[--head] = i;
        ++items;
    }

    public int removeLeft() {
        int temp = deque[head++];
        head %= maxSize;
        items--;
        return temp;
    }

    public int removeRight() {
        int temp = deque[tail--];
        tail %= maxSize;
        items--;
        return temp;
    }

    public void show() {
        System.out.println(Arrays.toString(this.deque));
    }


}
