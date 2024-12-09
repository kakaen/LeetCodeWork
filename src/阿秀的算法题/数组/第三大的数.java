package 阿秀的算法题.数组;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.*;

public class 第三大的数 {
    public static void main(String[] args) {
        Solution414 solution414 = new Solution414();
        solution414.thirdMax(new int[]{1,2,-2147483648});
    }
}
class Solution414 {
    public int thirdMax(int[] nums) {
        int n=nums.length;
        //返回第三大的数（不同数字），如果都不存在，则返回最大的数
        //设计O(n)的时间复杂度
        long first=Long.MIN_VALUE,second=Long.MIN_VALUE,threed=Long.MIN_VALUE;
        System.out.println(first-1);
        for (int i=0;i<n;i++){
            if (nums[i]>first){
                //如果新来一个比最大值还大的数，则，都往后移一个
                threed=second;
                second=first;
                first=nums[i];
            }else if (nums[i]<first&&nums[i]>second){
                threed=second;
                second=nums[i];
            }else if (nums[i]<second&&nums[i]>threed){
                threed=nums[i];
            }
        }
        if (threed!=Long.MIN_VALUE){
            return (int)threed;
        }else{
            return (int)first;
        }
    }
    public int thirdMax2(int[] nums){
        Set<Integer> set=new HashSet<>();
        //去重的时间复杂度是O(n)
        for (int num:nums){
            set.add(num);
        }
        List<Integer> linkedList=new VirtualFlow.ArrayLinkedList<>();

        List<Integer> list=new ArrayList<>(set);
        Collections.sort(list);
        return list.size()<3?list.get(list.size()-1):list.get(list.size()-3);
    }
}