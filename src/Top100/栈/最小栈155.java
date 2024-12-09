package Top100.栈;

import java.util.Deque;
import java.util.LinkedList;

public class 最小栈155 {
    public static void main(String[] args) {

    }
}

/**
 * 设计一个最小的栈，可以在常数时间内检索到最小元素的栈
 */
class MinStack155{
    //保存最小元素的栈
    Deque<Integer> minStack=new LinkedList<>();
    Deque<Integer> stack;
    public MinStack155(){
        minStack.push(Integer.MAX_VALUE);
        stack=new LinkedList<>(); //初始化new一个Stack
    }
    public void push(int val){
        stack.push(val);
        if (val<minStack.peek()){
            minStack.push(val);
        }else{
            minStack.push(minStack.peek());
        }
    }
    public void pop(){
        stack.pop();
        minStack.pop();
    }
    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }
}
