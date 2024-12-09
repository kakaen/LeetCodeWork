package 单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 车队853 {
    public static void main(String[] args) {
        int target=100;
        int[] psoition={0,5,4};
        int[] speed={4,2,1};
        Solution853 solution853 = new Solution853();
        System.out.println(solution853.carFleet(target, psoition, speed));
    }
}
class Solution853{
    public int carFleet(int target, int[] position, int[] speed) {
        //position和speed，长度都是n，其中position[i]是第i辆车的位置sped[i]是第i辆车的熟读
        //按起始位置进行降排序,速度也进行相应修改
        int n=position.length;
        sortArr(position,speed); //进行排序
        double[] times=new double[n];
        for (int i=0;i<n;i++){
            times[i]=(double) (target-position[i])/speed[i];
        }
        Deque<Double> stack=new LinkedList<>();
        for (double t:times){
            if (!stack.isEmpty()&&t>=stack.peek()){
                stack.pop();
            }
            stack.push(t);
        }
        return stack.size();
    }
    public boolean mergeCar(int pos_i,int speed_i,int pos_i1,int speed_i1,int target){
        //判断i是否能追上.
        if (speed_i<=speed_i1) return false;
        double time1=(double)(target-pos_i)/speed_i;
        double time2=(double)(target-pos_i1)/speed_i1;
        if (time1>time2) return false;
        return true;
    }
    public void sortArr(int[] position,int[] speed){
        int n=position.length;
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                if (position[j]<position[i]){
                    int temp=position[i];
                    position[i]=position[j];
                    position[j]=temp;
                    int temp2=speed[i];
                    speed[i]=speed[j];
                    speed[j]=temp2;
                }
            }
        }

    }
}
