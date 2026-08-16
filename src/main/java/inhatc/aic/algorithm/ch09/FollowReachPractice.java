package inhatc.aic.algorithm.ch09;

import java.util.ArrayList;
import java.util.List;

public class FollowReachPractice {

    static List<List<Integer>> adjacency = new ArrayList<>();
    static boolean[] visited;
    static List<Integer> reached = new ArrayList<>();

    /** v를 방문하고, v가 소식을 전달할 수 있는 미방문 이웃으로 재귀한다 */
    static void dfs(int v) {
        // TODO 2: v를 방문 표시하고 reached에 추가한 뒤,
        //         미방문 이웃마다 dfs를 재귀 호출하세요.
        visited[v] = true;
        reached.add(v);
        for (int neighbor : adjacency.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int userCount = 6;
        // deliveries[i] = {a, b} : a가 b에게 소식을 전달한다 (a → b 한 방향!)
        int[][] deliveries = { {0, 1}, {0, 2}, {2, 3}, {3, 4}, {5, 0} };

        for (int v = 0; v < userCount; v++) {
            adjacency.add(new ArrayList<>());
        }

        // TODO 1: 방향 그래프이므로 a의 리스트에만 b를 추가하세요.
        for (int[] pair : deliveries) {
            adjacency.get(pair[0]).add(pair[1]);
        }

        visited = new boolean[userCount];
        dfs(0);
        System.out.println("0번의 소식이 도달하는 사용자: " + reached);
    }
}