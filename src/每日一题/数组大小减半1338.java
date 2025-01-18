package 每日一题;

import java.util.*;

public class 数组大小减半1338 {
    public int minSetSize(int[] arr ){
        //返回至少能删除数组中的一半整数的整数集合的最小大小
        //Arr.length是偶数，删除一半，我们先将数组排序
        //然后从左到二分之一数组长度，遍历有多少个元素
        //然后
        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int ans=0;
        int count=0;
        //按照出现的次数进行排序
        ArrayList<Integer> list = new ArrayList<>(map.values());
        int[] array = map.values().stream().mapToInt(each -> (int) each).toArray();
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        for (int i=array.length-1;i>=0;i--){
            count+=array[i];
            ans++;
            if (count>=n/2) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        数组大小减半1338 test = new 数组大小减半1338();
        System.out.println(test.minSetSize(new int[]{3, 3, 3, 3, 5, 5,5, 2, 2, 7}));
    }
}
