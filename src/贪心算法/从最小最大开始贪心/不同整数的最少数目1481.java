package 贪心算法.从最小最大开始贪心;

import java.util.*;

public class 不同整数的最少数目1481 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int[]arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int k=scanner.nextInt();
        Solution1481 solution1481 = new Solution1481();
        System.out.println(solution1481.findLeastNumOfUniqueInts(arr, k));
    }
}
class Solution1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        //从数组中恰好移除k个元素
        //不同整数的最少数目,采用TreeMap进行
        Map<Integer,Integer> map=new HashMap<>();
        for (int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int count=map.size();
        int[] list=new int[count];
        int i=0;
        for (Integer value : map.values()) {
            list[i++]=value;
        }
        Arrays.sort(list);
        for (int num:list){
            if (k-count>=0){
                count--;
                k-=count;
            }else break;
        }
        return count;
    }
}
