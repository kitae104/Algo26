package inhatc.aic.algorithm.visual;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.*;

public class Dijkstra {

    // CSS 스타일시트 (상태별 색상 지정)
    private static final String STYLE_SHEET =
            "node {" +
                    "   size: 40px;" +
                    "   fill-color: #ECEFF1;" +
                    "   stroke-mode: plain;" +
                    "   stroke-color: #607D8B;" +
                    "   stroke-width: 2px;" +
                    "   text-size: 13px;" +
                    "   text-style: bold;" +
                    "   text-alignment: center;" +
                    "}" +
                    "node.current {" +
                    "   fill-color: #FFF176;" + // 현재 처리 중인 노드 (노란색)
                    "   stroke-color: #FBC02D;" +
                    "}" +
                    "node.settled {" +
                    "   fill-color: #81C784;" + // 최단 거리가 확정된 노드 (초록색)
                    "   stroke-color: #388E3C;" +
                    "}" +
                    "node.path {" +
                    "   fill-color: #FF7043;" + // 최종 최단 경로 노드 (주황색)
                    "   stroke-color: #D84315;" +
                    "   stroke-width: 3px;" +
                    "}" +
                    "edge {" +
                    "   size: 2px;" +
                    "   fill-color: #CFD8DC;" +
                    "   text-size: 14px;" +
                    "   text-style: bold;" +
                    "   text-color: #37474F;" +
                    "}" +
                    "edge.checking {" +
                    "   fill-color: #FDD835;" + // 가중치 완화(Relaxation) 검사 중인 간선
                    "   size: 3px;" +
                    "}" +
                    "edge.path {" +
                    "   fill-color: #E64A19;" + // 최종 최단 경로 간선
                    "   size: 5px;" +
                    "}";

    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");

        Graph graph = new SingleGraph("Dijkstra Visualizer");
        graph.setAttribute("ui.stylesheet", STYLE_SHEET);
        graph.setAttribute("ui.antialias");

        // 1. 노드 생성
        String[] nodes = {"A", "B", "C", "D", "E"};
        for (String id : nodes) {
            Node n = graph.addNode(id);
            n.setAttribute("ui.label", id + " (∞)"); // 초기 거리 무한대
        }

        // 2. 가중치 간선(Edge) 생성
        addEdge(graph, "A", "B", 6);
        addEdge(graph, "A", "D", 1);
        addEdge(graph, "D", "B", 2);
        addEdge(graph, "D", "E", 1);
        addEdge(graph, "B", "E", 2);
        addEdge(graph, "B", "C", 5);
        addEdge(graph, "E", "C", 5);

        // 3. 그래프 표시 (자동 물리 레이아웃)
        graph.display(true);

        // 4. 별도 스레드에서 다익스트라 실행 (A -> C 최단 경로)
        new Thread(() -> {
            try {
                Thread.sleep(1500); // 뷰어가 안정화될 때까지 대기
                runDijkstra(graph, "A", "C");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    private static void runDijkstra(Graph graph, String startId, String targetId) throws InterruptedException {
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prevNode = new HashMap<>();
        Set<String> settled = new HashSet<>();

        // 거리 초기화
        for (Node node : graph) {
            dist.put(node.getId(), Integer.MAX_VALUE);
        }
        dist.put(startId, 0);
        updateNodeLabel(graph.getNode(startId), startId, 0);

        // 우선순위 큐 (노드 ID, 현재까지의 거리)
        PriorityQueue<NodeDistance> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        pq.offer(new NodeDistance(startId, 0));

        while (!pq.isEmpty()) {
            NodeDistance current = pq.poll();
            String uId = current.id;
            Node uNode = graph.getNode(uId);

            if (settled.contains(uId)) continue;
            settled.add(uId);

            // 현재 노드 시각적 강조
            uNode.setAttribute("ui.class", "current");
            Thread.sleep(800);

            // 인접 노드 탐색 및 거리 갱신 (Edge Relaxation)
            for (Edge edge : uNode) {
                Node vNode = edge.getOpposite(uNode);
                String vId = vNode.getId();

                if (settled.contains(vId)) continue;

                int weight = edge.getAttribute("weight", Integer.class);
                edge.setAttribute("ui.class", "checking");
                Thread.sleep(500);

                if (dist.get(uId) + weight < dist.get(vId)) {
                    int newDist = dist.get(uId) + weight;
                    dist.put(vId, newDist);
                    prevNode.put(vId, uId);
                    pq.offer(new NodeDistance(vId, newDist));

                    // 노드 라벨 업데이트
                    updateNodeLabel(vNode, vId, newDist);
                }
                edge.removeAttribute("ui.class"); // 검사 완료 후 스타일 원복
            }

            // 확정된 노드로 스타일 변경
            uNode.setAttribute("ui.class", "settled");
            Thread.sleep(600);
        }

        // 5. 최종 최단 경로(Path) 역추적 및 빨간색 강조
        Thread.sleep(1000);
        String curr = targetId;
        while (prevNode.containsKey(curr)) {
            String prev = prevNode.get(curr);
            Node n = graph.getNode(curr);
            n.setAttribute("ui.class", "path");

            Edge e = n.getEdgeBetween(prev);
            if (e != null) {
                e.setAttribute("ui.class", "path");
            }
            curr = prev;
        }
        graph.getNode(startId).setAttribute("ui.class", "path");
    }

    private static void addEdge(Graph graph, String from, String to, int weight) {
        String edgeId = from + "-" + to;
        Edge edge = graph.addEdge(edgeId, from, to);
        edge.setAttribute("weight", weight);
        edge.setAttribute("ui.label", String.valueOf(weight)); // 간선에 가중치 텍스트 표시
    }

    private static void updateNodeLabel(Node node, String id, int d) {
        String distStr = (d == Integer.MAX_VALUE) ? "∞" : String.valueOf(d);
        node.setAttribute("ui.label", id + " (" + distStr + ")");
    }

    private static class NodeDistance {
        String id;
        int distance;

        NodeDistance(String id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }
}