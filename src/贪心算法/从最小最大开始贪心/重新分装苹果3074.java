package 贪心算法.从最小最大开始贪心;

import java.util.Arrays;
import java.util.Scanner;

public class 重新分装苹果3074 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
    }
}
class Solution3074 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        //一共有n个包裹，第i个包裹中装有apple[i]个苹果。同时还有m个箱子，
        // 第i个箱子的容量为capacity[i]哥苹果
        int total=0;
        for (int num : apple) {
            total+=num;
        }
        Arrays.sort(capacity);
        int res=0;
        for (int i=capacity.length-1;i>=0;i--){
            total-=capacity[i];
            res++;
            if (total<=0) break;
        }
        return res;
    }
}
