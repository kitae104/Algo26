package inhatc.aic.algorithm.ch12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuggyPickClosest {

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

    /** 미확정 정점 중 최솟값을 찾으려고 했는데... 무엇이 빠졌을까? */
    static int pickClosest(int[] dist, boolean[] visited) {
        int minVertex = -1;
        int minDist = INF;
        for (int v = 0; v < dist.length; v++) {
            if (dist[v] < minDist) {
//            if (!visited[v] && dist[v] < minDist) {  // 조건에 미확정 검사를 추가합니다.
                minDist = dist[v];
                minVertex = v;
            }
        }
        return minVertex;
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

        for (int round = 1; round <= n; round++) {
            int u = pickClosest(dist, visited);
            if (u == -1) {
                break;
            }
            visited[u] = true;
            for (Edge e : graph.get(u)) {
                if (dist[u] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[u] + e.weight;
                }
            }
        }

        System.out.println("A에서 각 정점까지의 최단 거리:");
        for (int v = 0; v < n; v++) {
            System.out.println("  A -> " + names[v] + " : " + show(dist[v]));
        }
    }
}