package 难度训练;

import java.util.*;

public class 计算子数组的xsumQ1 {
    public int[] findXSum(int[] nums,int k,int x){
        int n=nums.length;
        int[] answer=new int[n-k+1];
        //answer[i]是子数组[i,...i+k-1];子树组尺度是k
        int left=0,right=0;
        //窗口，如何快速查找到前x个元素、、使用priorityQueue来实现
        Map<Integer,Integer> map=new TreeMap<>();
        return null;
    }
    public int xSum(Map<Integer,Integer> map,int x){
        //求出map中的前x个元素之和
        int n=map.size();
        return 0;
    }
}
