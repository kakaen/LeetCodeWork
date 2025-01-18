package Top100二刷.二分查找.二分法求最大值;

import 基础转换.数组和List转换;

import java.util.*;

public class 可以到达的最远建筑1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //从建筑物0开始移动，以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标
        List<Integer> list = new ArrayList<>();
        int n = heights.length;
        //总共有n-1个坡要过,heights[i]表示到达下标i所需的砖块数量

        for (int i = 0; i < n-1; i++) {
            heights[i] = heights[i+1] - heights[i ];
        }

        //使用二分法进行判断能否到达建筑物
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (check(heights, m, bricks, ladders)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }

    //判断是否可以到达m下标
    public boolean check(int[] heights, int m, int bricks, int ladders) {
        if (m == 0) return true;
        //把前m个元素进行排序,然后从中选择最大的差值都使用ladders，较小的使用bricks
        List<Integer> list = new ArrayList<>();

        //m从1进行判断
        for (int i = 0; i <m; i++) {
            if (heights[i] <= 0) continue;
            list.add(heights[i]);
        }
        //从大到小进行排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //判断是否满足排序条件。
        for (int num : list) {
            //如果梯子不为0先使用梯子
            if (ladders > 0) {
                ladders--;
            } else if (bricks >= num) {
                bricks -= num;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        可以到达的最远建筑1642 test = new 可以到达的最远建筑1642();
        System.out.println(test.furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
        System.out.println(test.furthestBuilding(new int[]{4, 12,2, 7, 3, 18, 20,3,19 }, 10, 2));
    }
}