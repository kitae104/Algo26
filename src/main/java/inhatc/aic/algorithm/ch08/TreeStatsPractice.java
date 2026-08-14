package inhatc.aic.algorithm.ch08;

public class TreeStatsPractice {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        return node;
    }

    /** 트리의 전체 노드 수 = 1(자신) + 왼쪽 서브트리 노드 수 + 오른쪽 서브트리 노드 수 */
    static int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    /** BST의 최댓값: 오른쪽 자식이 없어질 때까지 오른쪽으로만 내려간다 */
    static int maxValue(Node node) {
        if (node.right == null) {
            return node.value;
        }
        return maxValue(node.right);
    }

    public static void main(String[] args) {
        int[] values = {50, 30, 70, 20, 40, 60};

        Node root = null;
        for (int value : values) {
            root = insert(root, value);
        }

        System.out.println("전체 노드 수: " + countNodes(root));
        System.out.println("최댓값: " + maxValue(root));
    }
}