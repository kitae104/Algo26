package inhatc.aic.algorithm.ch08;

public class BuggyInsertIgnoreReturn {

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

    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        int[] values = {50, 30, 70, 20, 40, 60};

        Node root = null;
        for (int value : values) {
            insert(root, value);          // 반환값을 어디에도 저장하지 않았다!
//            root = insert(root, value);   // 반환값을 root에 다시 연결!
        }

        System.out.print("중위 순회 결과: ");
        inorder(root);
        System.out.println();
        System.out.println("root == null ? " + (root == null));
    }
}