package 单调栈;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 每日温度739第二次 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] temperatures=new int[n];
        for (int i=0;i<n;i++){
            temperatures[i]=scanner.nextInt();
        }
        solution2(temperatures);
    }
    public static void solution(int[] temperatures){
        int n=temperatures.length;
        int[] result=new int[n];
        //创建栈,存储的是每个温度的下标
        Deque<Integer> stack=new LinkedList<>();
        //从右到左进行遍历
        for (int i=n-1;i>=0;i--){
            int temp=temperatures[i];
            int count=0;
            while (!stack.isEmpty()&&temperatures[stack.peek()]<=temp){
                stack.pop();
            }
            if (!stack.isEmpty()){
                result[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(result));
    }
    //从左到右遍历温度
    public static void solution2(int[] temperatures){
        int n=temperatures.length;
        int[] result=new int[n];
        Deque<Integer> stack=new LinkedList<>();
        for (int i=0;i<n;i++){
            while (!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]){
                Integer preIndex = stack.pop();
                result[preIndex]=i-preIndex;
            }
            stack.push(i);
//            if (stack.isEmpty()){
//                stack.push(i); //表明当前温度还没有找到最大值
//            }else{
//                if (stack.peek()<temperatures[i]){
//                    Integer preIndex = stack.pop();
//                    temperatures[preIndex]=i-preIndex;
//                }
//            }
        }
        System.out.println(Arrays.toString(result));
    }
}
