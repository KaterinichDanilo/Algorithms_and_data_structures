package Homework7;

import Homework3.Queue;
import Homework3.Stack;

import java.util.List;

public class Graph {
    class Vertex{
        public String label;
        public boolean isVisited;
        public Vertex parent;

        public Vertex(String label) {
            this.label = label;
            this.isVisited = false;
        }

        @Override
        public String toString() {
            return "V (" + label + ")";
        }
    }
    private final int MAX_VERTICES = 32;
    private Vertex[] vertices;
    private int[][] adjacency;
    private int size;

    public Graph() {
        vertices = new Vertex[MAX_VERTICES];
        adjacency = new int[MAX_VERTICES][MAX_VERTICES];
        size = 0;
    }

    public void addVertex(String label) {
        vertices[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjacency[start][end] = 1;
        adjacency[end][start] = 1;
    }

    public void displayVertex(int index) {
        System.out.println(vertices[index]);
    }

    public int getIndex(String label) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].label.equals(label)) {
                return i;
            }
        }
        return -1;
    }

    public int getUnvisited(int index) {
        for (int i = 0; i < size; i++) {
            if (adjacency[index][i] == 1 && !vertices[i].isVisited) {
                return i;
            }
        }
        return -1;
    }

    public void depthTravers() {
        Stack stack = new Stack(size);
        vertices[0].isVisited = true;
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()) {
            int v = getUnvisited(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertices[v].isVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int i = 0; i < size; i++) {
            vertices[i].isVisited = false;
        }
    }

    public void widthTravers() {
        Queue queue = new Queue(size);
        vertices[0].isVisited = true;
        displayVertex(0);
        queue.insert(0);
        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getUnvisited(v1)) != -1) {
                vertices[v2].isVisited = true;
                displayVertex(v2);
                queue.insert(v2);
            }
        }
        for (int i = 0; i < size; i++) {
            vertices[i].isVisited = false;
        }
    }

    public static Graph getNewGraph() {
        Graph graph = new Graph();

        for (int i = 0; i < 11; i++) {
            graph.addVertex(String.valueOf(((char) (65 + i))));
        }
        // A B C D E F G H I J K
        // 0 1 2 3 4 5 6 7 8 9 10
        graph.addEdge(0,2);//A <-> C
        graph.addEdge(1,3);//B <-> D
        graph.addEdge(1,4);//B <-> E
        graph.addEdge(2,3);//C <-> D
        graph.addEdge(2,5);//C <-> F
        graph.addEdge(3,4);//D <-> E
        graph.addEdge(3,6);//D <-> G
        graph.addEdge(4,8);//E <-> I
        graph.addEdge(5,9);//F <-> J
        graph.addEdge(6,7);//G <-> H
        graph.addEdge(6,9);//G <-> J
        graph.addEdge(8,10);//I <-> K
        graph.addEdge(9,10);//J <-> K
        return graph;
    }

    //К своему стыду, мне не удалось самому решить это задание :_), поэтому я обратился
    //к вашему объяснению в 8м уроке. Подсмотрел, признаю, зато осознал и преисполнился

    public Stack getMinWay(String begin, String end) {
        Stack result = new Stack(MAX_VERTICES);
        Queue queue = new Queue(MAX_VERTICES);

        int indexBegin = getIndex(begin);
        int indexEnd = getIndex(end);
        vertices[indexBegin].isVisited = true;
        queue.insert(indexBegin);

        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            int v2;
            while ((v2 = getUnvisited(v1)) != -1) {
                vertices[v2].parent = vertices[v1];
                vertices[v2].isVisited = true;
                if (v2 == indexEnd) break;
                queue.insert(v2);
            }
            if (v2 == indexEnd) break;
        }
        if (!vertices[indexEnd].isVisited) return null;
        result.push(indexEnd);
        int cur = indexEnd;
        while (vertices[cur].parent != null) {
            for (int i = 0; i < vertices.length; i++) {
                if (vertices[cur].parent.equals(vertices[i])) {
                    result.push(i);
                    cur = i;
                    break;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            vertices[i].isVisited = false;
            vertices[i].parent = null;
        }

        return result;
    }

    public void showStackGraph(Stack stack) {
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(vertices[stack.pop()]).append(" ->");
        }
        System.out.println(sb);
    }

}
