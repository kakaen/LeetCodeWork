package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class 有序数组中的单一元素540 {
    public static void main(String[] args) {
        有序数组中的单一元素540 test = new 有序数组中的单一元素540();
        System.out.println(test.singleNonDuplicate2(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }
    public int singleNonDuplicate(int[] nums){
        //每个元素都会出现两次,有序数组，
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1) return entry.getKey();
        }
        return 0;
    }
    //O(logn)和O(1)
    public int singleNonDuplicate2(int[] nums){
        //对于单个元素下标为x，左边和右边都有偶数个元素
        //对于x的左侧，nums[y]=nums[y+1];则y一定是偶数
        //对于x的右侧，nums[z]=nums(z+1)的下标z一定是奇数
        //进行二分查找，左边界是0，右边界是数组的最大下标，
        int low=0,high=nums.length-1;
        while (low<high){
            int mid=(high-low)/2+low;
            //如果当前mid在x的左侧的话，则一定符合当mid为偶数时，mid==mid+1,
            // 则x一定在mid的右侧，如果mid为奇数的话，且mid-1
            if (mid%2==0&&nums[mid]==nums[mid+1]||mid%2!=0&&nums[mid-1]==nums[mid]){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        //调整右边界
        //返回全部元素的值，
        return nums[low];
    }
    public int singleNonDuplicate3(int[] nums){
        //第一个条件数组有序。第二个条件除了一个数出现一次外，其余每个数都出现两次
        //只出现一次的哪个数一定在偶数下标上。因此我们去检查偶数下标2k，如果nums[2k]==nums[2k+1].说明只出现一次的数的下标>2k
        //如果nums[2k]!=nums[2k+1]，说明只出现一次的数的下标<=2k
        return 0;
    }
}
