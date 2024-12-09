package 贪心算法;

public class 加油站134 {
    public static void main(String[] args) {
        Solution134 solution134 = new Solution134();
        int[] gas=new int[]{1,2,3,4,5};
        int[] cost=new int[]{3,4,5,1,2};
        System.out.println(solution134.canCompleteCircuit(gas, cost));
    }
}
class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int n=gas.length;
       int i=0; //表示最开始的加油站
       while (i<n){
           int sumOfGas=0,sumOfCost=0;
           int cnt=0; //cnt记录走过的加油站个数
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
               i=i+cnt-1; //从这个位置开始
           }
       }
       return -1;
    }
    public int canCompleteCircuit2(int[] gas,int[] cost){
        int cnt=0; //表示走过的加油站个数
        int n=gas.length; //表示加油站的总个数
        for (int i=0;i<n;i++){
            int sumOfCost=0,sumOfGas=0;
            while (cnt<n){
                int j=(i+cnt)%n;
                sumOfCost+=cost[j];
                sumOfGas+=gas[j];
                if (sumOfCost>sumOfGas){
                    break;
                }
                cnt++;
            }
        }
        return -1;
    }
}