package Homework8;

public class HashTable {
    private LinkedList[] hashArray;
    private int arrSize;
    private Cat nullItem;

    public HashTable(int arrSize) {
        this.arrSize = arrSize;
        this.hashArray = new LinkedList[arrSize];
        this.nullItem = new Cat(-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrSize; i++) {
            if (hashArray[i] != null) {
                sb.append(hashArray[i].toString());
            } else {
                sb.append(" * ");
            }
        }
        return sb.toString();
    }

    private int hashFunc(int key) {
        return key % arrSize;
    }

    private void insert(Cat item) {
        int key = item.getAge();
        int hashVal = hashFunc(key);

        hashArray[hashVal].add(item);
    }

    private Cat find(int key) {
        int hashVal = hashFunc(key);

        return hashArray[hashVal].find(new Cat(key));
    }

    private Cat delete(int key) {
        int hashVal = hashFunc(key);

        return hashArray[hashVal].delete(new Cat(key));
    }

    private int quadProbe(int hashVal, int step) {
        return hashVal + step * step;
    }

    private int hashFuncDbl(int key) {
        return 3 - (key % 3);
    }
}
