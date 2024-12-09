package Top100.贪心算法;

public class 跳跃游戏II45 {
    public static void main(String[] args) {

    }
}
class Solution45{
    //使用贪心算法,正向查找可到达的最大位置
    public int jump(int[] nums){
        int n=nums.length;
        int steps=0; //表示步数
        int maxPos=0;
        int end=0;//表示上一次可到达的最大位置,如果到达该位置，需要修改第
        for (int i=0;i<n-1;i++){
            maxPos=Math.max(maxPos,i+nums[i]); //获取当前的最大位置
            if(i==end){
                end=maxPos;
                steps++;
            }
        }
        return steps;
    }
    public int jump2(int[] nums){
        int n=nums.length;
        int end=0; //表示当前步数能跳的最大位置
        int maxPos=0;
        int steps=0;
        for (int i=0;i<n-1;i++){
            //找下一次可以跳的最远的位置
            maxPos=Math.max(maxPos,i+nums[i]);
            if (i==end){ //遇到边界
                end=maxPos;
                steps++;
            }
        }
        return steps;
    }
}
