package 滑动窗口算法.定长窗口;

public class 可获得的最大点数1423 {
    public static void main(String[] args) {
        Solution1423 solution1423 = new Solution1423();
        int[] num={2,2,2};
        int k=2;
        System.out.println(solution1423.maxScore(num, k));
    }
}
class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        int totalPoint=0;
        for (int cardPoint : cardPoints) {
            totalPoint+=cardPoint;
        }
        //几张牌排成一行,从开头或末尾拿一张牌
        int result=0;

        //可以吧中间的数看做是一个窗口,即求窗口中的最小值
        int size=cardPoints.length-k;
        if (size==0) return totalPoint;
        int count=0;
        for (int i=0;i<cardPoints.length;i++){
            //入窗口
            count+=cardPoints[i];
            if (i<size-1){
                continue;
            }
            //更新答案
            result=Math.max(result,totalPoint-count);
            //出窗口
            count-=cardPoints[i-size+1];
        }
        return result;
    }
}