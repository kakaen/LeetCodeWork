package 每日一题;

public class 加油站134 {
    public static void main(String[] args) {
        Solution134 solution134 = new Solution134();
        int[] gas=new int[]{1,2,3,4,5};
        int[] gas2=new int[]{2,3,4};
        int[] cost=new int[]{3,4,5,1,2};
        int[] cost2=new int[]{3,4,3};
        System.out.println(solution134.canCompleteCircuit(gas, cost));
        System.out.println(solution134.canCompleteCircuit(gas2, cost2));
    }
}
class Solution134{
    public int canCompleteCircuit(int[] gas,int[] cost){
        //从第i个下标出发，可以绕一圈的意思是。可以到达任意地方
        //如果x到达不了y+1,那x-y之间的点也不可能到达y+1
        int n=gas.length;
        int i=0;
        while (i<n){
            int sumOfGas=0,sumOfCost=0;
            int cnt=0;
            while (cnt<n){
                int j=(i+cnt)%n;
                sumOfGas+=gas[j];
                sumOfCost+=cost[j];
                if (sumOfCost>sumOfGas){
                    break;
                }
                cnt++;
            }
            if (cnt==n){
                return i;
            }else {
                i=i+cnt+1;
            }
        }
        return -1;
    }
}
