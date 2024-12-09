package 代码随想录.栈和队列;

import java.util.*;

public class 前K个高频元素347 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int k=scanner.nextInt();
        Solution347 solution347 = new Solution347();
        for (int i : solution347.topKFrequent(arr, k)) {
            System.out.print(i+" ");
        }

    }
}
class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hmap=new HashMap<>();
        for (int num:nums){
            hmap.put(num, hmap.getOrDefault(num,0)+1);
        }
        int[] result=new int[k];
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(hmap.entrySet());
        Collections.sort(list,(o1,o2)->o2.getValue()-o1.getValue());
        Map<Integer,Integer> sotMap=new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sotMap.put(entry.getKey(),entry.getValue());
        }
        int i=0;
        for (Integer key : sotMap.keySet()) {
            if (i==k) break;
            result[i++]=key;
        }
        return result;
    }
}
