package 难度训练;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class 第K近障碍物3275 {
    public static void main(String[] args) {
        Solution3275 solution3275 = new Solution3275();
        int[][] queries={{1,2},{3,4},{2,3},{-3,0}};
        int k=2;
        int[] ints = solution3275.resultsArray(queries, k);
        System.out.println(Arrays.toString(ints));
    }
}
class Solution3275 {
    public int[] resultsArray(int[][] queries, int k) {
        int n=queries.length;
        int[] result=new int[n];
        //按照从大到小排列
        PriorityQueue<Integer> minQueue=new PriorityQueue<>(k,(o1,o2)->{return o2-o1;});
        int now=k; //现在记录的是第几小
        for (int i=0;i<n;i++){
            int count=Math.abs(queries[i][0])+Math.abs(queries[i][1]);
            if (minQueue.size()<k||count<minQueue.peek()){
                minQueue.offer(count);
            }
            if (minQueue.size()>k){
                //删除队列头
                minQueue.poll();
            }
            if (i+1<k) {
                result[i]=-1;
            }else{
                result[i]=minQueue.peek();
            }
        }
        return result;
    }
}
