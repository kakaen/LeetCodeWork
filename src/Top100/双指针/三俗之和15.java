package Top100.双指针;

import java.util.*;

public class 三俗之和15 {
    public static void main(String[] args) {
        三俗之和15 test = new 三俗之和15();
        List<List<Integer>> lists = test.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }

    }
    public List<List<Integer>> threeSum(int[] nums){
        //三个数之和为0。我们可以转化为两数之和
        List<List<Integer>> res=new ArrayList<>();
        //1.先将两个数进行相加
        Set<Integer> set=new HashSet<>();
        Map<Integer,Integer> map=new HashMap<>(); //存放第一个元素的值
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
            set.add(nums[i]);
        }
        for (int j=0;j<nums.length;j++){
            for (int k=j+1;k<nums.length;k++){
                int sum=nums[j]+nums[k];
                if (map.containsKey(-sum)&&map.get(-sum)!=j&&map.get(-sum)!=k){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[j]);
                    list.add(nums[k]);
                    list.add(-sum);
                    res.add(list);
                }
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum2(int[] nums){
        //先进行排序
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        //枚举第一个元素a
        for (int i=0;i<n;i++){
            //不可以和上一个枚举数相同,每一个值都只枚举一次
            if (i>0&&nums[i]==nums[i-1])continue;
            int k=n-1; //c的指针从最右侧开始
            int target=-nums[i];
            //枚举b,因为b是递增的
            for (int j=i+1;j<n;j++){
                if (j>0&&nums[j]==nums[j-1]) continue;
                //保证b的指针在c的右侧
                while (j<k&&nums[j]+nums[k]>target){
                    k--;
                }
                if (j==k) break; //说明无法
                if (nums[j]+nums[k]==target){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum3(int[] nums){
        //先进行排序
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        for (int i=0;i<n-2;i++){
            if (nums[i]>0) break; //因为nums[i]是最小的，不可能再有比它小的
            if (i>0&&nums[i]==nums[i-1]) continue; //防止重复计算
            int j=i+1, k=n-1;
            int target=-nums[i];
            //进行遍历查找是否存在target
            while (j<k){
                //防止相同元素被访问两次
                while (j<k&&j>i+1&&nums[j]==nums[j-1]){
                    j++;
                }
                //判断nums[j]+nums[k]>target
                while (j<k&&nums[j]+nums[k]>target){
                    k--;
                }
                if (j==k) break;
                if (nums[j]+nums[k]==target){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
                j++;
            }
        }
        return res;
    }
}
