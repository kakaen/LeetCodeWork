package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class 分割数组3046 {
    public boolean isPossibleToSplit(int[] nums){
        //num1必须是互不相同的元素，nums2也必须是互不相同的元素
        //不可以有相同元素3个
        Map<Integer,Integer> map=new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if (map.get(num)>2) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        分割数组3046 test = new 分割数组3046();
        System.out.println(test.isPossibleToSplit(new int[]{1, 1, 2, 2, 3, 4}));
        System.out.println(test.isPossibleToSplit(new int[]{1, 1, 1, 1}));
    }
}
