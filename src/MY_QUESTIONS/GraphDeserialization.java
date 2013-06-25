package MY_QUESTIONS;

import java.util.Arrays;

public class GraphDeserialization {
    public static void main(String[] args) {
        int[] inOrder = {1, 2, 3, 4, 5, 6, 7};
        int[] preOrder = {4, 2, 1, 3, 6, 5, 7};
        Node graph = new GraphDeserialization().createGraph(preOrder, inOrder, 0, inOrder.length - 1, new int[]{0});
        System.out.println(graph.value);
    }

    public Node createGraph(int[] preOrder, int[] inOrder, int i, int j, int[] index) {
        if (i > j) return null;
        Node current = new Node(preOrder[index[0]]);
        int location = Arrays.binarySearch(inOrder, preOrder[index[0]]);
        index[0]++;
        if (i == j) return current;
        current.setLeft(createGraph(preOrder, inOrder, i, location - 1, index));
        current.setRight(createGraph(preOrder, inOrder, location + 1, j, index));
        return current;
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
    public static class Test {

        public static void main(String[] args) {
            String i = "\uD83D\uDE09";
            System.out.println(i);

    //        byte[] a = new byte[]{(byte)0xD8,(byte)0x3D};

        }
    }
}
