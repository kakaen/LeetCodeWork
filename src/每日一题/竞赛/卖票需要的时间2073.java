package 每日一题.竞赛;

public class 卖票需要的时间2073 {
    public static void main(String[] args) {

    }
}
class Soution2073{
    public int timeRequiredToBuy(int[] tickets,int k){
        int n=tickets.length;
        int totalTime=0;
        //要购买的人是下标为k的
        int i=0;
        while (true){
            if (tickets[i%n]!=0){
                totalTime++;
                tickets[i%n]--;
            }
            if (i==k&&tickets[i%n]==0){
                return totalTime;
            }
        }

    }
}
