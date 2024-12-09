package 每日一题.竞赛;

import java.util.HashMap;
import java.util.Map;

public class 统计1显著的字符串数量3234 {
    public static void main(String[] args) {
        Solution3234 solution3234 = new Solution3234();
        System.out.println(solution3234.numberOfSubstrings("101101"));
    }
}
class Solution3234 {
    public int numberOfSubstrings(String s) {
        //使用滑动窗口进行
        int left=0,right=0;
        //
        int result=0;
        int[] map=new int[2];
        char[] arr=s.toCharArray();
        for (right=0;right<s.length();right++){
            //右侧进入窗口
            map[arr[right]-'0']++;
            //判断是否为显著
            while (left<=right&&map[1]<(map[0]*map[0])){
                //移动左窗口
                map[arr[left]-'0']--;
                left++;
            }
            result++;
        }
        return result;
    }
}
