package 滑动窗口算法.定长窗口二刷;

public class 爱生气的书店老板1052 {
    public static void main(String[] args) {

    }
}
class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left=0,right=0;
        //minus相当于窗口值
        int result=0;
        int count=0; //记录生气人员
        int total=0;
        //求窗口内的生气的人的最大值
        for (right=0;right<grumpy.length;right++){
            //判断当前是否生气
            if (grumpy[right]==1){
                count+=customers[right];
            }else {
                //记录没有生气的人
                result+=customers[right];
            }
            if (right<minutes-1) continue;
            //更新答案
            total=Math.max(total,count);
            if (grumpy[left]==1){
                count-=customers[left];
            }
            left--;
        }
        return result+total;
    }
}
