package 拼多多提单;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class 创建一个队列实现入队和出队 {

}
class MyQueue{
    private static int first;
    private static int last;
    private static int maxSize;
    private static Object[] arr;
    public MyQueue(){
        first=-1;
        last=-1;
        arr=new Object[16];
    }
    public static boolean isEmpty(){
        return first==last;
    }
    public static int getSize(){
        if(isEmpty()) {
            return 0;
        }else{
            return (maxSize+last-first+1)%maxSize;
        }
    }
    public void enqueue(Object num){
        if(getSize()==maxSize){
            AtomicInteger atomicInteger=new AtomicInteger(10);
        }
    }
}
