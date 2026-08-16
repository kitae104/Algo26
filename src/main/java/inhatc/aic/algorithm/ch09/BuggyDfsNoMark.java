package inhatc.aic.algorithm.ch09;

import java.util.ArrayList;
import java.util.List;

public class BuggyDfsNoMark {

    static List<List<Integer>> adjacency = new ArrayList<>();
    static boolean[] visited;

    static void dfs(int v) {
//        visited[v] = true;               // 도착 즉시 방문 표시!
        System.out.println(v + "번 방문");
        for (int neighbor : adjacency.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int vertexCount = 7;
        int[][] edges = { {0, 1}, {0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 5} };
        for (int v = 0; v < vertexCount; v++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacency.get(edge[0]).add(edge[1]);
            adjacency.get(edge[1]).add(edge[0]);
        }
        visited = new boolean[vertexCount];

        dfs(0);
    }
}