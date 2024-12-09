package 单调栈;

import java.util.*;

public class 下一个更大元素I496 {
    public static void main(String[] args) {
        Solution496 solution496 = new Solution496();
        int[] nums1=new int[]{2,4};
        int[] nums2=new int[]{1,2,3,4};
        int[] ints = solution496.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }
}
class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //使用哈希表存储答案,快速定位答案
        int[] hashTable=new int[10000];
        Arrays.fill(hashTable,-1);
        Deque<Integer> stack=new ArrayDeque<>();
        for (int i=0;i<nums2.length;i++){
            while (!stack.isEmpty()&&nums2[stack.peek()]<nums2[i]){
                Integer preIndex = stack.pop();
                hashTable[nums2[preIndex]]=nums2[i];
            }
            stack.push(i);
        }
        for (int i=0;i<nums1.length;i++){
            nums1[i]=hashTable[nums1[i]];
        }
        return nums1;
    }
    public int[] nextGreaterElement2(int[] nums1,int[] nums2){
        int n=nums1.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],i);
        }
        Deque<Integer> stack=new ArrayDeque<>();
        int[] result=new int[n];
        Arrays.fill(result,-1);
        for (int i=0;i<nums2.length;i++){
            while (!stack.isEmpty()&&nums2[stack.pop()]>nums2[i]){
                Integer preIndex = stack.pop();
                if (map.containsKey(nums2[preIndex])){
                    result[map.get(nums2[preIndex])]=nums2[i];
                }
            }
            stack.push(i);
        }
        return result;
    }
}
