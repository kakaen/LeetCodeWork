package 滑动窗口算法.定长窗口;

public class 爱生气的书店老板1052 {
    public static void main(String[] args) {
        Solution1052 solution1052 = new Solution1052();
        int[] customers={1,0,1,2,1,1,7,5};
        int[] grumpy={0,1,0,1,0,1,0,1};
        int minutes=3;
        System.out.println(solution1052.maxSatisfied(customers, grumpy, minutes));
    }
    }
class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        //costomers,就是长度为minutes的窗口，找最多的grumpy[i]
        int n = customers.length;
        int grumpyCount = 0;
        int noGrumpyCount=0;
        int result=0;
        for (int i = 0; i < n; i++) {
            //第一步入,统计在窗口期间的生气的人数
            if (grumpy[i]==1){
                grumpyCount+=customers[i];
            }else {
                noGrumpyCount+=customers[i];
            }
            //当还没达到窗口值时，一直进入窗口
            if (i<minutes-1){
                continue;
            }
            //第二步,更新答案
            result=Math.max(result,grumpyCount);
            //第三步，退出窗口
            if (grumpy[i-minutes+1]==1){
                grumpyCount-=customers[i-minutes+1];
            }
        }
        return result+noGrumpyCount;
    }
}
