package inhatc.aic.algorithm.ch13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryTopPractice {

    static class Product {
        String name;
        String category;
        int price;
        int stock;

        Product(String name, String category, int price, int stock) {
            this.name = name;
            this.category = category;
            this.price = price;
            this.stock = stock;
        }
    }

    /** 재고 자산이 가장 큰 카테고리 이름을 반환한다 */
    static String findTopCategory(List<String> categoryOrder, Map<String, Long> valueByCategory) {
        String top = null;
        long maxValue = -1;
        // TODO: categoryOrder를 순회하며 valueByCategory에서 재고 자산을 꺼내고,
        //       maxValue보다 크면 maxValue와 top을 갱신하세요. (2강 최댓값 찾기 패턴)
        for (String category : categoryOrder) {
            long value = valueByCategory.get(category);
            if (value > maxValue) {
                maxValue = value;
                top = category;
            }
        }

        return top;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("유선 키보드", "전자", 23000, 12));
        products.add(new Product("무선 마우스", "전자", 18000, 25));
        products.add(new Product("머그컵", "생활", 7000, 2));
        products.add(new Product("마우스 패드", "잡화", 4000, 18));
        products.add(new Product("USB 메모리", "전자", 9000, 5));
        products.add(new Product("텀블러", "생활", 12000, 30));
        products.add(new Product("노트북 파우치", "잡화", 15000, 3));
        products.add(new Product("웹캠", "전자", 45000, 4));

        Map<String, Long> valueByCategory = new HashMap<>();
        List<String> categoryOrder = new ArrayList<>();
        for (Product p : products) {
            if (!valueByCategory.containsKey(p.category)) {
                categoryOrder.add(p.category);
                valueByCategory.put(p.category, 0L);
            }
            valueByCategory.put(p.category,
                    valueByCategory.get(p.category) + (long) p.price * p.stock);
        }

        String top = findTopCategory(categoryOrder, valueByCategory);
        System.out.println("재고 자산 1위 카테고리: " + top
                + " (" + valueByCategory.get(top) + "원)");
    }
}