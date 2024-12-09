package 贪心算法.从最小最大开始贪心;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class 从一个范围内选择最多整数I2554 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int len=scanner.nextInt();
        int maxSum=scanner.nextInt();
        Solution2554 solution2554 = new Solution2554();
        System.out.println(solution2554.maxCount(arr, len, maxSum));
    }
}
class Solution2554 {
    public int maxCount(int[] banned, int n, int maxSum) {
        int total=0; //记录选择整数的个数
        //顺序应该是从1-n的去选取
        Set<Integer> hset=new HashSet<>();
        for (int num:banned){
            hset.add(num);
        }
        for (int i=1;i<=n;i++){
            if (!hset.contains(i)){
               if (maxSum-i>=0){
                   maxSum-=i;
                   total++;
               }else{
                   break;
               }
            }
        }
        return total;
    }
}
