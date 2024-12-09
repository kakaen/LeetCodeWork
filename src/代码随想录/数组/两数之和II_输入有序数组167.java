package 代码随想录.数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 两数之和II_输入有序数组167 {
    public static void main(String[] args) {
        两数之和II_输入有序数组167 test = new 两数之和II_输入有序数组167();
        int[] nums=new int[]{2,7,11,15};
        int target=9;
        System.out.println(Arrays.toString(test.twoSum(nums, target)));
    }
    public int[] twoSum(int[] numbers,int target){
        int[] res=new int[2];
        //非递减，map来记录num和下标
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<numbers.length;i++){
            if (map.containsKey(target-numbers[i])){
                return new int[]{map.get(target-numbers[i]),i};
            }
            map.put(numbers[i],i);
        }
        return null;
    }
    public int[] twoSum2(int[] numbers,int target){
        //使用O(1)级的常量空间，双指针方法
        int n=numbers.length;
        int left=0,right=n-1;
        //非递减，就是非严格递增数组，
        int count=0;
        while (left<right){
            count=numbers[left]+numbers[right];
            if (count==target){
                return new int[]{left,right};
            } else if (count<target) {
                left++;
            }else {
                right--;
            }
        }
        return null;
    }
}
