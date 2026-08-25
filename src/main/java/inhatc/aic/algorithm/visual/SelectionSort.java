package inhatc.aic.algorithm.visual;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class SelectionSort {

    private static final String STYLE_SHEET =
            "node {" +
                    "   shape: box;" +
                    "   size: 55px, 45px;" +
                    "   fill-color: #ECEFF1;" +
                    "   stroke-mode: plain;" +
                    "   stroke-color: #607D8B;" +
                    "   stroke-width: 2px;" +
                    "   text-size: 16px;" +
                    "   text-style: bold;" +
                    "   text-alignment: center;" +
                    "}" +
                    "node.current {" +
                    "   fill-color: #FFF59D;" + // 현재 기준 위치 i (노란색)
                    "   stroke-color: #FBC02D;" +
                    "}" +
                    "node.comparing {" +
                    "   fill-color: #80DEEA;" + // 최솟값 비교 중인 위치 j (하늘색)
                    "   stroke-color: #00ACC1;" +
                    "}" +
                    "node.min {" +
                    "   fill-color: #FF8A80;" + // 현재까지 발견한 최솟값 (빨간색)
                    "   stroke-color: #D50000;" +
                    "   stroke-width: 3px;" +
                    "}" +
                    "node.sorted {" +
                    "   fill-color: #A5D6A7;" + // 정렬 완료된 원소 (초록색)
                    "   stroke-color: #2E7D32;" +
                    "}";

    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");

        Graph graph = new SingleGraph("Selection Sort Visualizer");
        graph.setAttribute("ui.stylesheet", STYLE_SHEET);
        graph.setAttribute("ui.antialias");

        // 물리 엔진 끄고 수동 X, Y 좌표 사용
        graph.display(false);

        // 초기 데이터 배열
        int[] arr = { 64, 25, 12, 22, 11 };
        Node[] nodes = new Node[arr.length];

        // 노드 생성 및 가로 일렬 배치
        for (int i = 0; i < arr.length; i++) {
            Node n = graph.addNode("node_" + i);
            n.setAttribute("xyz", i * 1.5, 0, 0); // X좌표 간격 1.5
            n.setAttribute("ui.label", String.valueOf(arr[i]));
            nodes[i] = n;
        }

        // 별도 스레드에서 선택 정렬 애니메이션 실행
        new Thread(() -> {
            try {
                Thread.sleep(1200);
                runSelectionSort(arr, nodes);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    private static void runSelectionSort(int[] arr, Node[] nodes) throws InterruptedException {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            nodes[i].setAttribute("ui.class", "current");
            Thread.sleep(600);

            for (int j = i + 1; j < n; j++) {
                nodes[j].setAttribute("ui.class", "comparing");
                Thread.sleep(500);

                if (arr[j] < arr[minIdx]) {
                    // 이전 min 노드 스타일 복원
                    if (minIdx != i) {
                        nodes[minIdx].removeAttribute("ui.class");
                    }
                    minIdx = j;
                    nodes[minIdx].setAttribute("ui.class", "min");
                    Thread.sleep(600);
                } else {
                    nodes[j].removeAttribute("ui.class");
                }
            }

            // 최솟값 위치와 현재 i 위치 교환
            if (minIdx != i) {
                swap(arr, nodes, i, minIdx);
            }

            // i번째 원소는 정렬 완료(sorted) 상태로 확정
            nodes[i].setAttribute("ui.class", "sorted");
            if (minIdx != i) {
                nodes[minIdx].removeAttribute("ui.class");
            }
            Thread.sleep(800);
        }

        // 마지막 남은 원소도 정렬 완료 처리
        nodes[n - 1].setAttribute("ui.class", "sorted");
    }

    // 값과 화면상의 X좌표, 라벨을 교환하는 함수
    private static void swap(int[] arr, Node[] nodes, int i, int j) throws InterruptedException {
        int tempVal = arr[i];
        arr[i] = arr[j];
        arr[j] = tempVal;

        // 노드 라벨 업데이트
        nodes[i].setAttribute("ui.label", String.valueOf(arr[i]));
        nodes[j].setAttribute("ui.label", String.valueOf(arr[j]));

        Thread.sleep(700);
    }
}