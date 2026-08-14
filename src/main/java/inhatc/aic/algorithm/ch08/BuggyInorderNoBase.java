package inhatc.aic.algorithm.ch08;

public class BuggyInorderNoBase {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    /** 중위 순회 — 그런데 종료 조건이 없다! */
    static void inorder(Node node) {
//        if (node == null) {
//            return;              // 빈 자리에 도착하면 되돌아간다
//        }
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);

        inorder(root);
    }
}