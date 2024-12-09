package 滑动窗口算法.定长窗口二刷;

import javax.jws.soap.SOAPBinding;

public class 可获得的最大点数1423 {
    public static void main(String[] args) {
        Solution1423 solution1423 = new Solution1423();
        int[] arr={9,7,7,9,7,7,9};
        int i = solution1423.maxScore(arr, 7);
        System.out.println(i);
    }
}
class Solution1423{
    public int maxScore(int[] cardPoints, int k) {
        //返回最大点数，反着的思路就是，窗口大小为n-k，窗口内的点数最小
        int left=0,right=0;
        int result=Integer.MAX_VALUE,count=0;
        int totalPoint=0;
        int n=cardPoints.length;
        for (right=0;right<n;right++){
            totalPoint+=cardPoints[right];
            //右边界入窗口
            count+=cardPoints[right];
            if (right<n-k-1) continue;
            //更新答案
            result=Math.min(result,count);
            //左窗口出去
            count-=cardPoints[left++];
        }
        return totalPoint-result;
    }
}
