package 每日一题;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 座位预约管理系统1845 {

}
//使用最小队列来实现该类
class SeatManager2{
    private final PriorityQueue<Integer> available=new PriorityQueue<>();
    public SeatManager2(int n){
        for (int i=1;i<=n;i++){
            available.add(i);
        }
    }
    public int reserve(){
        return available.poll();
    }
    public void unreserve(int seatNumber){
        available.add(seatNumber);
    }
}
class SeatManager{
    public int min=0; //维护最小可以预约的座位编号
    public boolean[] num=null; //
    public SeatManager(int n){
        num=new boolean[n];
        Arrays.fill(num,true); //true表示可以预约
        min=1;
    }
    public int reserve(){
        //直接返回维护的最小值
        int countMin=min;
        num[countMin-1]=false;
        //查找下一个最小可用值
        for (int i=countMin-1;i<num.length;i++){
            if (num[i]){
                min=i+1;
                break;
            }
        }
        min= num.length;
        return countMin;
    }
    public void unreserve(int seatNumber){
        num[seatNumber-1]=true;
        if (seatNumber<min){
            min=seatNumber;
        }
    }
}
