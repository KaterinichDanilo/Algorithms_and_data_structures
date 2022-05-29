package Homework2;

import java.util.Arrays;

public class MyArray {
    int capacity;
    int [] array;

    public MyArray(int capacity) {
        this.capacity = capacity;
        this.array = new int[this.capacity];
    }

    public MyArray(int[] array) {
        this.capacity = array.length;
        this.array = array;
    }

    //1

    public boolean deleteAll(int value) {
        boolean wasDelete = false;
        for (int i = 0; i < this.capacity; i++) {
            if (this.array[i] == value) {
                capacity--;
                System.arraycopy(this.array, i + 1, this.array, i, this.capacity - i);
                wasDelete = true;
            }
        }
        return wasDelete;
    }

    //2

    public boolean deleteAll() {
        this.capacity = 0;
        this.array = new int[0];
        return true;
    }

    //3

    public void insert(int idx, int value) {
        if (this.capacity == this.array.length) {
            int [] arr = this.array;
            this.array = new int[this.capacity + 1];
            System.arraycopy(arr, 0, this.array, 0, arr.length);
        }
        int [] arr2 = this.array;
        System.arraycopy(arr2, idx, this.array, idx + 1, this.capacity - idx);
        this.array[idx] = value;
        this.capacity++;
    }

    private void swap(int a, int b) {
        int t = this.array[a];
        this.array[a] = this.array[b];
        this.array[b] = t;
    }

    public void show() {
        if (this.capacity == 0){
            System.out.println("Array is empty...");
            return;
        }
        for (int i = 0; i < this.capacity; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }

    //4

    public void bublSort(){
        boolean wasChanged = true;
        for (int iter = 0; iter < this.capacity; iter++) {
            if (!wasChanged) {
                return;
            }
            wasChanged = false;
            for (int idx = 0; idx < this.capacity - 1; idx++) {
                if (this.array[idx] > this.array[idx + 1]) {
                    swap(idx, idx + 1);
                    wasChanged = true;
                }
            }
        }
    }

    //5

    public void countingSort() {
        int min = this.array[0];
        for (int i : this.array) {
            if (i < min)
                min = i;
        }
        int max = this.array[0];
        for (int i : this.array) {
            if (i > max)
                max = i;
        }

        int [] countArray = new int[max - min + 1];
        for (int i : this.array) {
            for (int j = 0; j < countArray.length; j++) {
                if (i == j + min) {
                    countArray[j]++;
                    break;
                }
            }
        }
        //n*(max - min + 1) + (max - min + 1)*c = (max - min + 1)*(n + c) = n -> +00
        int counter = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                this.array[counter] = i + min;
                counter++;
            }
        }
    }
}
