package Homework6;

import java.util.Random;

public class TreeInteger {
    public class TreeNode {
        public int value;
        public TreeNode leftChild;
        public TreeNode rightChild;

        public TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("TN(%d)", value);
        }
    }

    private TreeNode root;
    public TreeInteger() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int c) {
        TreeNode node = new TreeNode(c);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (c < current.value) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else if (c > current.value){
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                } else {
                    return;
                }
            }

        }
    }

    private void inOrderTravers(TreeNode current) {
        if (current != null) {
            System.out.println(current);
            inOrderTravers(current.leftChild);
            inOrderTravers(current.rightChild);
        }
    }
    public void displayTree() {
        inOrderTravers(root);
    }

    public int getTreeDeep(TreeNode root) {
        if (root == null) return 0;

        int deepLeft = 0;
        int deepRight = 0;

        deepLeft = Integer.max(deepLeft, getTreeDeep(root.leftChild));
        deepRight = Integer.max(deepRight, getTreeDeep(root.rightChild));

        return Integer.max(deepLeft, deepRight) + 1;
    }

    public static TreeInteger[] getArrayTree(int n) {
        TreeInteger[] treeIntegers = new TreeInteger[n];

        for (int i = 0; i < treeIntegers.length; i++) {
            treeIntegers[i] =getRandomTree();
        }
        return treeIntegers;
    }

    public static TreeInteger getRandomTree() {
        TreeInteger tree = new TreeInteger();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            tree.insert(-100 + random.nextInt(201));
        }
        return tree;
    }

    private static boolean isTreeBalanced(TreeInteger tree){
        int leftDeep = tree.getTreeDeep(tree.getRoot().leftChild);
        int rightDeep = tree.getTreeDeep(tree.getRoot().rightChild);

        if (Math.abs(leftDeep - rightDeep) > 1) return false;
        return true;
    }

    //После нескольких "экспериментов" я могу сказать, что процент несбалансированных деревьев
    // находится в интервале [0,81 - e, 0,81 + e]

    public static double getRateOfUnbalancedTree(TreeInteger[] treeArray) {
        int numberBalancedTrees = 0;

        for (TreeInteger tree : treeArray) {
            if (isTreeBalanced(tree)) {
                numberBalancedTrees++;
            }
        }
        System.out.println("balanced: " + numberBalancedTrees);
        return (1 - (double)numberBalancedTrees/treeArray.length);
    }
}
