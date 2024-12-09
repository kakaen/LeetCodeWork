package 并发编程;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    public static void main(String[] args) {

        new Thread(()->{
            increment2();
        },"A").start();
    }
    private AtomicInteger count=new AtomicInteger();
    private static int count2=0;
    public static void increment2(){
        count2++;
    }
    public int getCount2(){
        return count2;
    }
    public void increment(){
        count.incrementAndGet();
    }
    //使用AtomicInteger后，不需要加锁，也可以实现线程安全
    public int getCount(){
        return count.get();
    }
}
