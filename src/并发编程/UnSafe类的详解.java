package 并发编程;

import java.util.concurrent.atomic.AtomicInteger;

public class UnSafe类的详解 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2);
        System.out.println(atomicInteger.addAndGet(2));
        atomicInteger.getAndAdd(1);
    }
}
