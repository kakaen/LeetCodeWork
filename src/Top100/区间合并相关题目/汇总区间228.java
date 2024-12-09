package Top100.区间合并相关题目;

import java.util.ArrayList;
import java.util.List;

public class 汇总区间228 {
    public List<String> summaryRanges(int[] nums){
       int n=nums.length;
       List<String> res=new ArrayList<>();
       int i=0;
       while (i<n){
           int low=i;
           i++;
           while (i<n&&nums[i]==nums[i-1]+1){
               i++;
           }
           int high=i-1;
           StringBuilder builder=new StringBuilder();
           builder.append(nums[low]);
           if (low<high){
               builder.append("->");
               builder.append(nums[high]);
           }
           res.add(builder.toString());
       }
       return res;
    }
}
