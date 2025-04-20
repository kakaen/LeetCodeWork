package Top100二刷.子数组;

import Top100二刷.缺少的第一个正数41;

public class 缺失的第一个正数41 {
    public static void main(String[] args) {
        缺少的第一个正数41 test = new 缺少的第一个正数41();
        System.out.println(test.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(test.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
    public int firstMissingPositive(int[] nums){
        //找出其中没有出现的最小的正整数
        //没有出现的最小整数一定是从[1,N+1],如果1到N都出现了，那答案就是N+1；
        //第x个数，映射到位置上就是[x-1]
        //我们遍历数组，对于遍历到数x，如果他在(1-N)的范围内，就将数组中的第x-1位置进行标记
        //如何进行打标记呢，我们可以先遍历数组，将不在[1-N]范围内的数修改为N+1
        //因此我们就可以将标记设置为负数
        int n=nums.length;
        for (int i=0;i<n;i++){
            if (nums[i]<=0) nums[i]=n+1;
        }
        //遍历数组元素，进行打标记
        for (int i=0;i<n;i++){
            //如果nums[i]小于0，说明该位置被标记了
            int temp=nums[i]>0?nums[i]:-nums[i];
            //将temp处的位置进行标记
            if (temp<n+1){

            }
        }
        //遍历，找到第一个大于0的位置
        int ans=0;
        for (ans=0;ans<n;ans++){
            if (nums[ans]>0) return ans+1;
        }
        return ans+1;
    }
}
