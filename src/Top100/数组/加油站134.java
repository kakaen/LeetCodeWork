package Top100.数组;

public class 加油站134 {
    public static void main(String[] args) {
        加油站134 test = new 加油站134();
        int[] gas=new int[]{1,2,3,4,5};
        int[] cost=new int[]{3,4,5,1,2};
        int[] gas2=new int[]{2,3,4};
        int[] cost2=new int[]{3,4,3};
        System.out.println(test.canCompleteCricuit(gas, cost));
        System.out.println(test.canCompleteCricuit(gas2, cost2));
    }
    public int canCompleteCricuit(int[] gas,int[] cost){
        int n=gas.length;//全部的加油站数量
        int i=0; //记录第一次出发的加油站下标
        while (i<n){
            int sumOfOil=0,costOfOil=0; //记录总油量,和所需油量
            int cnt=0;//记录从当前下标出发可以经过的加油站数量
            int j=i;
            while (cnt<n){
                j=(j)%n;
                sumOfOil+=gas[j];
                costOfOil+=cost[j];
                //如果当前油量小于所需成本油量则退出
                if (sumOfOil<costOfOil) break;
                cnt++;
                j++;
            }
            if (cnt==n){
                return i;
            }else{
                i=(i+cnt+1);
            }
        }
        return -1;
    }
}
