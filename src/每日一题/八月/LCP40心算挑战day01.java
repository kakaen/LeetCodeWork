package 每日一题.八月;

import java.util.Arrays;

public class LCP40心算挑战day01 {
    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        int[] cards={1,2,8,9}; int cnt=3;
        System.out.println(solution40.maxmiumScore(cards, cnt));
    }
}
class Solution40 {
    public int maxmiumScore(int[] cards, int cnt) {
        //定长窗口
        //先排序
        Arrays.sort(cards);
        int left=0,right=0;
        int result=0;
        int count=0;
        for (right=0;right<cards.length;right++){
            //右指针入窗口
            count+=cards[right];
            if (right<cnt-1) continue;
            //更新答案
            if (count%2==0){
                result=Math.max(result,count);
            }
            //左指针出窗口
            count-=cards[left++];
        }
        return result;
    }
}
