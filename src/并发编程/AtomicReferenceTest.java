package 并发编程;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    public static void main(String[] args) {
        Person p1 = new Person(101);
        Person p2 = new Person(102);
        //新建AtomicReference对象，初始化它的值为p1对象
        AtomicReference<Person> ar = new AtomicReference<>(p1);
        //通过CAS设置ar，如果ar的值为p1的话，则将其设置为p2.
        ar.compareAndSet(p1,p2);
        Person p3 = ar.get();
        System.out.println("p3 is"+p3);
        System.out.println("p2的array="+p2);
        System.out.println("p3的array="+p3);
        System.out.println("p3.equals(p1)="+p3.equals(p1));
    }
}

class Person{
    volatile long id;
    public Person(long id){
        this.id=id;
    }


}