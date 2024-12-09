package ACM模式练习;

import java.util.*;

public class ShopQuerySolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取顾客数量和商品数量
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 读取商品的保质期
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }

        // 读取商品的类型
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        // 处理每个顾客的查询
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt() - 1; // 转为0-based
            int r = scanner.nextInt() - 1; // 转为0-based
            int t = scanner.nextInt();
            int k = scanner.nextInt();

            // 获取满足条件的商品
            List<Item> items = new ArrayList<>();
            for (int j = l; j <= r; j++) {
                if (b[j] == t) {
                    items.add(new Item(a[j], j + 1)); // 存储保质期和商品编号，编号为1-based
                }
            }

            // 按保质期降序排序，保质期相同则编号升序
            items.sort((item1, item2) -> {
                if (item1.expiry != item2.expiry) {
                    return Integer.compare(item2.expiry, item1.expiry); // 降序
                }
                return Integer.compare(item1.index, item2.index); // 升序
            });

            // 输出结果
            if (items.size() < k) {
                System.out.println(-1);
            } else {
                for (int j = 0; j < k; j++) {
                    System.out.print(items.get(j).index + " ");
                }
                System.out.println();
            }
        }
    }

    // 商品类，存储保质期和编号
    static class Item {
        int expiry;
        int index;

        Item(int expiry, int index) {
            this.expiry = expiry;
            this.index = index;
        }
    }
}
