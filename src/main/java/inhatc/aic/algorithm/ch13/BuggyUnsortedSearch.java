package inhatc.aic.algorithm.ch13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BuggyUnsortedSearch {

    static class Product {
        int code;
        String name;

        Product(int code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    static Product binarySearchByCode(List<Product> list, int targetCode) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midCode = list.get(mid).code;
            if (midCode == targetCode) {
                return list.get(mid);
            }
            if (midCode < targetCode) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

//    static void insertionSort(List<Product> list, Comparator<Product> comparator) {
//        for (int i = 1; i < list.size(); i++) {
//            Product key = list.get(i);
//            int j = i - 1;
//            while (j >= 0 && comparator.compare(list.get(j), key) > 0) {
//                list.set(j + 1, list.get(j));
//                j--;
//            }
//            list.set(j + 1, key);
//        }
//    }

    public static void main(String[] args) {
        // 입고 순서 그대로의 리스트 — 정렬을 깜빡했다!
        List<Product> products = new ArrayList<>();
        products.add(new Product(2005, "유선 키보드"));
        products.add(new Product(1003, "무선 마우스"));
        products.add(new Product(3010, "머그컵"));
        products.add(new Product(1007, "마우스 패드"));
        products.add(new Product(2002, "USB 메모리"));
        products.add(new Product(3001, "텀블러"));
        products.add(new Product(1010, "노트북 파우치"));
        products.add(new Product(2008, "웹캠"));

        // 2005번은 분명히 리스트의 첫 번째 상품인데...
//        insertionSort(products, (a, b) -> a.code - b.code);  // 이 한 줄이 먼저!
        Product found = binarySearchByCode(products, 2005);
        System.out.println("코드 2005 검색 결과: " + (found == null ? "없음" : found.name));
    }
}