package 代码随想录.栈和队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class 用栈实现队列 {
    public static void main(String[] args) {

    }
}
class MyQueue {
    public Deque<Integer> stack1=new ArrayDeque<>();
    public Deque<Integer> stack2=new ArrayDeque<>();

    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x); //入队列会存放到stack1中。
    }

    public int pop() {
        //pop弹出栈，如果当前stack2为空，则将stack1的元素全部转移到stack2中
        //如果stack2不为空则弹出stack2中的元素
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop(); //弹出栈顶元素，即队列的首元素。
    }

    public int peek() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek(); //返回栈顶元素，即队列的首元素。
    }

    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
