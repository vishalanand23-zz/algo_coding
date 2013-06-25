package MY_QUESTIONS;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class GraphCentre {

    private static void findCentre(Node node) {
        Queue<Node> q = new LinkedBlockingQueue<Node>();
        boolean[] isVisited = new boolean[10];
        Queue<Node> leaves = new LinkedBlockingQueue<Node>();

        q.add(node);
        isVisited[node.value] = true;
        if (node.neighbours.size() == 1) leaves.add(node);

        int num = recurseAndFindLeavesAndReturnCount(q, isVisited, leaves, 1);
        while (true) {
            Node leaf = leaves.poll();
            if (num == 1) {
                System.out.println(leaf.value);
                break;
            }
            num--;
            Node neighbour = leaf.neighbours.get(0);
            neighbour.neighbours.remove(leaf);
            if (neighbour.neighbours.size() == 1) {
                leaves.add(neighbour);
            }
        }
    }

    private static int recurseAndFindLeavesAndReturnCount(Queue<Node> q, boolean[] visited, Queue<Node> leaves, int count) {
        if (q.size() == 0) return count;
        Node p = q.poll();
        boolean isLeaf = true;
        for (Node neighbour : p.neighbours) {
            if (!visited[neighbour.value]) {
                isLeaf = false;
                visited[neighbour.value] = true;
                q.add(neighbour);
                count++;
            }
        }
        if (isLeaf) leaves.add(p);
        return recurseAndFindLeavesAndReturnCount(q, visited, leaves, count);
    }

    private static void recurseBfs(Queue<Node> q, boolean[] visited, ProcessNode p) {
        if (q.size() == 0) return;
        Node n = q.poll();
        p.process(n);
        for (Node neighbour : n.neighbours) {
            if (!visited[neighbour.value]) {
                visited[neighbour.value] = true;
                q.add(neighbour);
            }
        }
        recurseBfs(q, visited, p);
    }

    private static void bfs(Node n1) {
        Queue<Node> q = new LinkedBlockingQueue<Node>();
        boolean[] isVisited = new boolean[10];
        q.add(n1);
        isVisited[n1.value] = true;
        final int[] sum = {0};
        ProcessNode p = new ProcessNode() {
            public void process(Node node) {
                System.out.println(node.value);
                sum[0] +=node.value;
            }
        };
        recurseBfs(q, isVisited, p);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        n1.addNeighbour(n2);
        n2.addNeighbour(n7);
        n3.addNeighbour(n4);
        n4.addNeighbour(n6);
        n5.addNeighbour(n6);
        n6.addNeighbour(n7);
        n6.addNeighbour(n8);
        n4.addNeighbour(n9);
        bfs(n1);
        findCentre(n1);
    }

    public interface ProcessNode {
        void process(Node node);

    }

    public static class Node {
        public final int value;

        public ArrayList<Node> neighbours = new ArrayList<Node>();

        public Node(int value) {
            this.value = value;
        }

        public void addNeighbour(Node node) {
            this.neighbours.add(node);
            node.neighbours.add(this);
        }
    }
}
