package inhatc.aic.algorithm.ch09;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BuggyBfsLateVisit {
    public static void main(String[] args) {
        int vertexCount = 7;
        int[][] edges = { {0, 1}, {0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 5} };

        List<List<Integer>> adjacency = new ArrayList<>();
        for (int v = 0; v < vertexCount; v++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacency.get(edge[0]).add(edge[1]);
            adjacency.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[vertexCount];
        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();

//        visited[0] = true;          // 시작 정점도 넣으면서 표시

        queue.offer(0);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            visited[v] = true;   // 큐에서 "꺼낼 때" 방문 표시한다 (?)
            order.add(v);
            for (int neighbor : adjacency.get(v)) {
                if (!visited[neighbor]) {
//                    visited[neighbor] = true;   // 큐에 넣는 순간 방문 표시!
                    queue.offer(neighbor);
                }
            }
        }

        System.out.println("BFS 방문 순서: " + order);
    }
}