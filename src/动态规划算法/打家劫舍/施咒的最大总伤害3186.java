package 动态规划算法.打家劫舍;

import sun.nio.cs.ext.MacHebrew;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 施咒的最大总伤害3186 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] powers=new int[n];
        for (int i=0;i<n;i++){
            powers[i]=scanner.nextInt();
        }
        Solution3186 solution3186 = new Solution3186();
        System.out.println(solution3186.maximumTotalDamage(powers));
    }
}
class Solution3186 {
    public long maximumTotalDamage(int[] power) {
        //将power值存储到哈希表中
        Map<Integer,Integer> cnt=new HashMap<>();
        for (int num:power){
            cnt.put(num,cnt.getOrDefault(num,0)+1);
        }
        //2.将power中的元素进行排序
        Arrays.sort(power);
        //3.对power数组进行打家劫舍
        //dp[i]表示选择到第i个伤害的咒语，可以得到的最大值
        //考虑power[i]选或者不选，
        //power[i]选，则power[i-1]不能选，power[i-2]也不能选
        //power[i]不选，则是从dp[i]=dp[i-1]
        int n=power.length;
        int[] dp=new int[n+1];
        for (int i=2;i<=n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-3]+0);
        }
        return 0;
    }
}
