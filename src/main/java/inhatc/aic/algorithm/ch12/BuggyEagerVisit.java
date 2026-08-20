package inhatc.aic.algorithm.ch12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BuggyEagerVisit {

    static final int INF = Integer.MAX_VALUE;

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static void addEdge(List<List<Edge>> graph, int u, int v, int weight) {
        graph.get(u).add(new Edge(v, weight));
        graph.get(v).add(new Edge(u, weight));
    }

    static String show(int d) {
        return d == INF ? "∞" : String.valueOf(d);
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E", "F"};
        int n = names.length;

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        addEdge(graph, 0, 1, 3);  // A-B
        addEdge(graph, 0, 2, 7);  // A-C
        addEdge(graph, 1, 2, 2);  // B-C
        addEdge(graph, 1, 3, 6);  // B-D
        addEdge(graph, 2, 3, 4);  // C-D
        addEdge(graph, 2, 4, 8);  // C-E
        addEdge(graph, 3, 4, 1);  // D-E
        addEdge(graph, 3, 5, 5);  // D-F
        addEdge(graph, 4, 5, 3);  // E-F

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(item -> item[0]));
        pq.add(new int[]{0, 0});
//        visited[0] = true;  // 이부분도 제거
//
//        while (!pq.isEmpty()) {
//            int[] item = pq.poll();
//            int u = item[1];
//
//            for (Edge e : graph.get(u)) {
//                if (!visited[e.to]) {              // BFS처럼: 처음 본 정점이면
//                    visited[e.to] = true;          // 큐에 넣으면서 바로 확정해 버린다!
//                    dist[e.to] = dist[u] + e.weight;
//                    pq.add(new int[]{dist[e.to], e.to});
//                }
//            }
//        }

        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            int currentDist = item[0];
            int u = item[1];

            // 이미 처리(확정)된 정점이라면 건너뜁니다.
            if (visited[u]) continue;
            visited[u] = true;

            for (Edge e : graph.get(u)) {
                // 더 짧은 경로를 발견한 경우에만 갱신 후 큐에 삽입
                if (!visited[e.to] && dist[u] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[u] + e.weight;
                    pq.add(new int[]{dist[e.to], e.to});
                }
            }
        }

        System.out.println("A에서 각 정점까지의 최단 거리:");
        for (int v = 0; v < n; v++) {
            System.out.println("  A -> " + names[v] + " : " + show(dist[v]));
        }
    }
}