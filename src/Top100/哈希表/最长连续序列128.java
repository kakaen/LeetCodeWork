package Top100.哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class 最长连续序列128 {
    public static void main(String[] args) {
        最长连续序列128 test = new 最长连续序列128();
        System.out.println(test.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
    public int longestConsecutive(int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        int OFFSET=1000000000;
        int[] table=new int[2*OFFSET+1];
        for (int num:nums){
            table[num+OFFSET]=1;
        }
        int max=0;
        int left=-1,right=0;
        for (int i=0;i<table.length;i++){
           if (table[i]==1){
               if (left==-1) left=i;
               max=Math.max(max,i-left+1);
           }else{
               left=-1;
           }
        }
        return max;
    }
    public int logestConsecutive2(int[] nums){
        //考虑枚举数组中的每个数x，以其为起点，不断尝试匹配x+1,x+2，是否存在
        Set<Integer> set=new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        //开始枚举x
        int max=0;
        for (int num:nums){
            if(!set.contains(num-1)){
                int curNum=num;
                int count=1;
                while (set.contains(curNum+1)){
                    curNum++;
                    count++;
                }
                max=Math.max(max,count);
            }
        }
        return max;
    }
}
