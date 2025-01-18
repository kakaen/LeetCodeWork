package Top100二刷.单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class 最大宽度坡962 {
    public int maxWidthRamp3(int[] nums){
        int n=nums.length;
        Integer[] arr=new Integer[n];
        for (int i=0;i<n;i++) arr[i]=i;
        //将元素排序
        Arrays.sort(arr,(i,j)->nums[i]-nums[j]);
        //遍历数组。找最小的下标
        int min=arr[0]; //这是最小坡度的下标
        int max=0;
        for (int i=1;i<arr.length;i++){
            if (arr[i]>min){
                max=Math.max(arr[i]-min,max);
            }else{
                min=arr[i];
            }
        }
        return max;
    }

    //以往的单调栈。我们得到的都是最右边的第一个大于的数，因此可以使用单调增栈
    public int maxWidthRamp(int[] nums) {
        //我们将下标进行存储，按照坡度的顺序存储
        int n=nums.length;
        Integer[] sortArr=new Integer[n];

        for (int i=0;i<n;i++){
            sortArr[i]=i; //sort[i]表示对应的i下标
        }
        //将下边进行排序，按照坡度来
        Arrays.sort(sortArr,(i,j)->{return nums[i]-nums[j];});
        //排序完后我们遍历这个数组，记录最小的下标
        int min=sortArr[0];
        int max=0;
        for (int i=1;i<sortArr.length;i++){
            if (sortArr[i]>min){
                max=Math.max(sortArr[i]-min,max);
            }else{
                min=sortArr[i];
            }
        }
        return max;
    }
    //使用单调栈来解决该问题
    public int stackRes(int[] nums){
        int n=nums.length;
        Deque<Integer> stack=new ArrayDeque<>();
        int j=n-1;
        int ans=0;
        for (int i=0;i<n;i++){
            //什么时候不需要考虑当前下标元素
            if (!stack.isEmpty()&&nums[i]>=nums[stack.peek()]) continue;
            stack.add(i); //如果当前元素的坡度小于栈顶的坡度，则入栈
            while (!stack.isEmpty()&&j>=0){
                while (j>=0&&nums[j]<nums[stack.peek()]){
                    j--;
                }
                if (j>=0){
                  ans=Math.max(ans,j-stack.peek());
                }
            }

        }
        return ans;
        //我们考虑左边界，如果num[i1]>=nums[i0]那 (i1,j)可以不用考虑了，
        // 因此我们使用单调减的栈来记录左边界
        //再考虑从右往左的遍历顺序，如果num[j1]<=nums
    }
    //使用栈来实现该题目
    public int maxStack(int[] nums){
        int n=nums.length;
        //我们枚举左边界i时，应该是单调递减的，因为如果 Nums[i1]>=num[i0],
        //那nums[i0]的结果会更优。
        Deque<Integer> stack=new ArrayDeque<>();
        for (int i=0;i<n;i++) {
            if (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                continue;
            }
            stack.push(i);//说明当前元素是递减的
        }
        int max=0;
        //逆序遍历数组，使用j下标来判断
        for (int j=n-1;j>=0;j--){
            //如果当前右指针j的坡度大于等于当前栈顶元素，则更新答案，并将栈顶元素弹出
            while (!stack.isEmpty()&&nums[j]>=nums[stack.peek()]){
                max=Math.max(max,j-stack.poll());
            }
        }
        return max;
    }
    //暴力解法
    public int maxWidthRamp2(int[] nums){
        int n=nums.length;
        int max=0;
        for (int i=0;i<n-1;i++){
            //枚举右侧的元素值
            for (int j=n-1;j>=i+1;j--){
                if (nums[j]>=nums[i]){
                    max=Math.max(j-i,max);
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        最大宽度坡962 test = new 最大宽度坡962();
        System.out.println(test.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
        System.out.println(test.maxStack(new int[]{6, 0, 8, 2, 1, 5}));
        System.out.println(test.maxStack(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }
    }
