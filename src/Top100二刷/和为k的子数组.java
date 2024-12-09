package Top100二刷;

import java.util.HashMap;
import java.util.Map;

public class 和为k的子数组 {
    public static void main(String[] args) {
        和为k的子数组 test = new 和为k的子数组();
        System.out.println(test.subarraySum3(new int[]{1, 1, 1}, 1));
        System.out.println(test.subarraySum3(new int[]{1, 1, 1}, 2));
        System.out.println(test.subarraySum3(new int[]{1, 2, 3,2}, 5));
    }
    public int subarraySum(int[] nums,int k){
       //和为k的子数组，使用前缀和的方式来实现
        //前缀和的定义 s[i]等于前i个元素的和 s[0]=0;
        //s[i]=a[0]+....+a[i-1];
        //下标从i到j-1的非空子数组的元素和为
        //s[j]-s[i]==k s[i]=s[j]-k
        int n=nums.length;
        int ans=0;
        int[] s=new int[n+1];
        //求前缀和
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1); //s[0]=0单独统计
        for (int i=0;i<n;i++){
            //求前缀和信息
            s[i+1]=s[i]+nums[i];
            ans+=map.getOrDefault(s[i+1]-k,0);
            map.put(s[i+1],map.getOrDefault(s[i+1],0)+1);
        }
        return ans;


    }
    //方法一：暴力方法
    public int subarraySum2(int[] nums,int k){
        int n=nums.length;
        int ans=0;
        int sum=0;
        //枚举结尾i，然后j=i一次次递减
        for (int i=0;i<n;i++){
            sum=0;
            for (int j=i;j>=0;j--){
                sum+=nums[j];
                if (sum==k) ans++;
            }
        }
        return sum;
    }
    //方法二：使用前缀和的方式来计算
    public int subarraySum3(int[] nums,int k){
        int n=nums.length;
        int ans=0;
        int[] s=new int[n+1]; //s[i]=nums[0],nums[1],nums[i-1]
        //对于[i,j]的元素，等于 s[j]-s[i]=k;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1); //这种就是防止我们疏忽 0，n-1的和为k的情况
        //s表示到当前i的数组和，查看map中有没有值为pre-k的，有的话则
        for (int i=1;i<=n;i++){
            s[i]=s[i-1]+nums[i-1];
            if (map.containsKey(s[i]-k)){
                ans+=map.get(s[i]-k);
            }
            map.put(s[i],map.getOrDefault(s[i],0)+1);
        }
        return ans;
    }
    public int subarraySum4(int[] nums,int k){
        int ans=0;
        int n=nums.length;
        int s=0;
        Map<Integer,Integer> map=new HashMap<>(); //哈希表映射
        map.put(0,1);
        for (int x:nums){
            s+=x;
            if (map.containsKey(s-k)){
                ans+=map.get(s-k);
            }
            map.put(s,map.getOrDefault(s,0)+1);
        }
        return ans;
    }
}