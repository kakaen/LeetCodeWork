package 单调栈;

import java.util.Arrays;
import java.util.Stack;

public class 每日温度739 {
    public static void main(String[] args) {
        Solution739 solution739 = new Solution739();
        int[] arrr={73,74,75,71,69,72,76,73};
        int[] ints = solution739.dailyTemperatures2(arrr);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }
}
class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        //在哪个位置开始进行单调递增
        int n=temperatures.length;
        int[] result=new int[n];
        //暴力做法
        for (int i=0;i<n-1;i++){
            int temp=temperatures[i];
            int nextDay=1;
            for (int j=i+1;j<n;j++){
                if (temp<temperatures[j]){
                    result[i]=nextDay;
                    break;
                }
                nextDay++;
            }
        }
        return result;
    }
    public int[] dailyTemperatures2(int[] temperatures){
        //两种方式，从右往左遍历，由于5的出现，那5左侧的元素的下一个更大值不可能是2，或3
        int n=temperatures.length;
        int[] result=new int[n];
        Stack<Integer> stack=new Stack<>();
        for (int i=n-1;i>=0;i--){
            int t=temperatures[i]; //当前i的温度
            while (!stack.isEmpty()&&t>=temperatures[stack.peek()]){
                stack.pop();
            }
            if (!stack.isEmpty()){
                result[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        return result;
    }
}

