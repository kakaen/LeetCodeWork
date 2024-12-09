package 每日一题;

import 滑动窗口算法.定长窗口.半径为k的子数组平均值;

import java.util.Deque;
import java.util.LinkedList;

public class 棒球比赛682 {
}
class Solution682 {
    public int calPoints(String[] operations) {
        Deque<Integer> stack=new LinkedList<>();
        for (String ops:operations){
            switch (ops){
                case "D":
                    int num = stack.peek() * 2;
                    stack.push(num);
                    break;
                case "C":
                    stack.pop();
                    break;
                case "+":
                    Integer first = stack.pop();
                    Integer secod=stack.peek();
                    Integer result=first+secod;
                    stack.push(first);
                    stack.push(result);
                    break;
                default:
                    int i = Integer.parseInt(ops);
                    stack.push(i);

            }
        }
        int count=0;
        for (Integer i : stack) {
            count+=i;
        }
        return count;
    }
    public int calPoints2(String[] operations){
        return 0;
    }
}