package Homework3;

import java.util.Arrays;

public class PriorityQueue {
    private int maxSize;
    private int[] queue;
    private int items;

    public int remove(){
        return queue[--items];
    }
    public int peek(){
        return queue[items - 1];
    }
    public boolean isEmpty(){
        return (items == 0);
    }
    public boolean isFull(){
        return (items == maxSize);
    }

    public PriorityQueue(int i){
        maxSize = i;
        queue = new int[maxSize];
        items = 0;
    }

    public void insert(int value){
        if (isFull()) {
            maxSize *= 2;
            int[] tmpArr = new int[maxSize];
            System.arraycopy(queue, 0, tmpArr, 0, queue.length);
            queue = tmpArr;
        }

        queue[items] = value;
        sortInsert();
        items++;
    }

    private void sortInsert() {
        int c;
        for (int i = items; i > 0; i--) {
            if (queue[i] > queue[i - 1]) {
                c = queue[i];
                queue[i] = queue[i - 1];
                queue[i - 1] = c;
            } else {
                return;
            }
        }
    }

    private void show() {
        System.out.println(Arrays.toString(queue));
    }

}
