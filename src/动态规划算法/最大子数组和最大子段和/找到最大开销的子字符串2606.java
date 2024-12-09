package 动态规划算法.最大子数组和最大子段和;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 找到最大开销的子字符串2606 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s=scanner.next();

        Solution2606 solution2606 = new Solution2606();
    }
}
class Solution2606{
    public int maximumCostSubstring(String s,String chars,int[] vals){
        //字符串的开销是一个子字符串所有字符对应价值之和。空字符串的开销是0；
        //dp[i]表示前i个字符的最大开销
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<chars.length();i++){
            map.put(chars.charAt(i),vals[i]);
        }
        //将String转为代价数组
        int n=s.length();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            char ch=s.charAt(i);
            if (map.containsKey(ch)){
                nums[i]=map.get(ch);
            }else {
                nums[i]=ch-'a'+1;
            }
        }
        //使用动态规划进行解决
        int[] dp=new int[n+1];
        dp[0]=0;
        int res=Integer.MIN_VALUE;
        for (int i=1;i<=n;i++){
            dp[i]=Math.max(dp[i-1]+nums[i-1],nums[i-1]);
            res=Math.max(res,dp[i]);
        }
       return res;
    }
}
