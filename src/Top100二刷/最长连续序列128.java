package Top100二刷;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列128 {
    public int longestConsecutive2(int[] nums) {
        //找出数字连续的的最长序列
        int[] flags=new int[20];
        return 20;
    }
    public int longestConscutive(int[] nums){
        Set<Integer> set=new HashSet<>();
        int max=0;
        for (int num:nums){
            set.add(num);
        }
        for (int num:nums){
            if (!set.contains(num-1)){
                int curNum=num;
                int count=1;
                while (set.contains(curNum+1)){
                    curNum++;
                    count++;
                }
                max=Math.max(count,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        最长连续序列128 test = new 最长连续序列128();
        System.out.println(test.longestConscutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
