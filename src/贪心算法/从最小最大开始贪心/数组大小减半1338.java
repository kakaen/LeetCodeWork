package 贪心算法.从最小最大开始贪心;

import java.util.*;

public class 数组大小减半1338 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }
        Solution1338 solution1338 = new Solution1338();
        System.out.println(solution1338.minSetSize(arr));
    }
}
class Solution1338 {
    public int minSetSize(int[] arr) {
        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int num:arr){

            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] list=new int[map.size()];
        int i=0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list[i++]=entry.getValue();
        }
        //排序
        Arrays.sort(list);
        int deleteCount=0;
        int result=0;
        for (int j=list.length-1;j>=0;j--){
            deleteCount+=list[j];
            result++;
            if (deleteCount>=(n/2)) break;
        }

        return result;
    }
}
