package Top100二刷.单调栈;

import java.util.*;

public class 下一个更大元素I496 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        下一个更大元素I496 test = new 下一个更大元素I496();
        int[] nums1=new int[]{4,1,2};
        int[] nums2=new int[]{1,3,4,2};
        int[] ints = test.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }
    public int[] nextGreaterElement(int[] nums1,int[] nums2){
        int n=nums1.length;
        int[] ans=new int[n];
        Map<Integer,Integer> map=new HashMap<>(); //元素值作为key，对应的下一个更大元素作为值
        Deque<Integer> stack=new ArrayDeque<>();
        for (int i=0;i<nums2.length;i++){
            while (!stack.isEmpty()&&nums2[i]>nums2[stack.peek()]){
                int j=stack.poll();
                map.put(nums2[j],nums2[i]);
            }
            stack.push(i);
        }
        for (int i=0;i<n;i++){
            ans[i]=map.getOrDefault(nums1[i],-1);
        }
        return ans;
    }
}
