package inhatc.aic.algorithm.visual;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.HashSet;
import java.util.Set;

public class Dfs {

    // CSS 스타일시트 정의 (기본 상태 vs 방문 상태)
    private static final String STYLE_SHEET =
            "node {" +
                    "   size: 35px;" +
                    "   fill-color: #E3F2FD;" +
                    "   stroke-mode: plain;" +
                    "   stroke-color: #1E88E5;" +
                    "   stroke-width: 2px;" +
                    "   text-size: 16px;" +
                    "   text-style: bold;" +
                    "   text-alignment: center;" +
                    "}" +
                    "node.visited {" +
                    "   fill-color: #FF7043;" +
                    "   stroke-color: #D84315;" +
                    "   stroke-width: 3px;" +
                    "}" +
                    "edge {" +
                    "   size: 2px;" +
                    "   fill-color: #B0BEC5;" +
                    "}" +
                    "edge.traversed {" +
                    "   size: 4px;" +
                    "   fill-color: #E64A19;" +
                    "}";

    public static void main(String[] args) {
        // Swing 렌더러 지정 (GraphStream 2.0 필수 설정)
        System.setProperty("org.graphstream.ui", "swing");

        Graph graph = new SingleGraph("Binary Tree DFS");
        graph.setAttribute("ui.stylesheet", STYLE_SHEET);
        graph.setAttribute("ui.antialias");

        // 1. 트리 노드 생성 및 라벨 설정
        String[] nodes = {"1", "2", "3", "4", "5", "6", "7"};
        for (String id : nodes) {
            Node n = graph.addNode(id);
            n.setAttribute("ui.label", id);
        }

        // 2. 간선(Edge) 연결 (이진 트리 구조)
        //       1
        //     /   \
        //    2     3
        //   / \   / \
        //  4   5 6   7
        addEdge(graph, "1", "2");
        addEdge(graph, "1", "3");
        addEdge(graph, "2", "4");
        addEdge(graph, "2", "5");
        addEdge(graph, "3", "6");
        addEdge(graph, "3", "7");

        // 3. 화면에 그래프 띄우기 (true: 자동 레이아웃 배치 활성화)
        graph.display(true);

        // 4. 별도 스레드에서 DFS 애니메이션 실행
        new Thread(() -> {
            try {
                // 창이 렌더링되고 노드가 자리잡을 때까지 잠시 대기
                Thread.sleep(1500);

                Set<String> visited = new HashSet<>();
                runDfs(graph.getNode("1"), null, visited);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    // 재귀 DFS 구현 및 실시간 스타일 업데이트
    private static void runDfs(Node current, Node parent, Set<String> visited) throws InterruptedException {
        visited.add(current.getId());

        // 부모와 연결된 간선 스타일 변경
        if (parent != null) {
            Edge edge = current.getEdgeBetween(parent);
            if (edge != null) {
                edge.setAttribute("ui.class", "traversed");
            }
        }

        // 현재 노드 'visited' 클래스 적용 (주황색으로 변경)
        current.setAttribute("ui.class", "visited");
        Thread.sleep(1000); // 1초 대기

        // 인접 노드 탐색 (트리 자식 노드)
        current.neighborNodes().forEach(neighbor -> {
            if (!visited.contains(neighbor.getId())) {
                try {
                    runDfs(neighbor, current, visited);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    private static void addEdge(Graph graph, String from, String to) {
        graph.addEdge(from + "-" + to, from, to);
    }
}