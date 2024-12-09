package 每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 新增道路查询后的最短距离I3243 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        //共有m次查询
        int m = queries.length;
        int[] res = new int[m]; //存储m次查询的结果
        Map<Integer, Integer> map = new HashMap<>(); //记录道路的最小映射
        for (int i = 0; i < n - 1; i++) {
            map.put(i, i + 1);
        }
        //类似于进行跳跃查询
        for (int i = 0; i < m; i++) {
            int s = map.get(queries[i][0]);
            map.put(queries[i][0], Math.max(queries[i][1], s));
            int star = 0; //从0下标出发
            int maxLen=map.get(star);
            res[i]++; //跳跃一次
            while (maxLen<n){
                if (maxLen==n-1) break;
                star++;
                if (maxLen<map.get(star)){
                    maxLen=map.get(star);
                }
                res[i]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        新增道路查询后的最短距离I3243 test = new 新增道路查询后的最短距离I3243();
        int[] ints = test.shortestDistanceAfterQueries(5, new int[][]{{2, 4}, {0, 2}, {0, 4}});
        int[] ints2 = test.shortestDistanceAfterQueries(4, new int[][]{{0, 3}, {0, 2}});
        int[] ints3 = test.shortestDistanceAfterQueries(6, new int[][]{{1, 4}, {0, 2}});
        int[] ints4 = test.shortestDistanceAfterQueries(7, new int[][]{{0, 4}, {2, 6}});
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));
        System.out.println(Arrays.toString(ints3));
        System.out.println(Arrays.toString(ints4));
    }
}
