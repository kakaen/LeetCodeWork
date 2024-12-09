package 难度训练;

import jdk.internal.dynalink.linker.LinkerServices;

import java.util.*;

public class 与车相交的点2848 {
    public static void main(String[] args) {
        List<List<Integer>> nums=new ArrayList<>();
        int[][] table=new int[][]{{1,3},{5,8}};
        for (int i=0;i<table.length;i++){
            List<Integer> list=new ArrayList<>();
            for (int j=0;j<2;j++){
                list.add(table[i][j]);
            }
            nums.add(list);
        }
        Solution2848 solution2848 = new Solution2848();
        System.out.println(solution2848.numberOfPoints2(nums));
    }
}
class Solution2848{
    public int numberOfPoints(List<List<Integer>> nums){
        Collections.sort(nums,(o1,o2)->{return o1.get(0)-o2.get(0);});
        List<List<Integer>> res=new ArrayList<>();
        int starIndex=nums.get(0).get(0),endIndex=nums.get(0).get(1);
        int count=0;
        for (int i=1;i<nums.size();i++){
            if (starIndex==-1){
                starIndex=nums.get(i).get(0);
                endIndex=nums.get(i).get(1);
            }

            //如果后一个的starIndex大于前一个的endIndex
            if (nums.get(i).get(0)>endIndex){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(starIndex);
                list.add(endIndex);
                count+=(endIndex-starIndex)+1;
                if (i!=nums.size()-1){
                    starIndex=nums.get(i+1).get(0);
                    endIndex=nums.get(i+1).get(1);
                }
            }else {
                endIndex=Math.max(endIndex,nums.get(i).get(1));
                if (i==nums.size()-1){
                    count+=(endIndex-starIndex)+1;
                }
            }
        }
        return count;
    }
    public int numberOfPoints2(List<List<Integer>> nums){
        Set<Integer> set=new HashSet<>();
        for (List<Integer> num : nums) {
            for (int i=num.get(0);i<=num.get(1);i++){
                set.add(i);
            }
        }
        return set.size();
    }
}
