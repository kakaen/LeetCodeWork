package 并发编程;

import lombok.Data;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicFieldUpdateTest {
    public static void main(String[] args) {
        AtomicFieldUpdateTest test=new AtomicFieldUpdateTest();
        test.testValue();
    }
    public AtomicIntegerFieldUpdater<DataDemo> updater(String name){
        return AtomicIntegerFieldUpdater.newUpdater(DataDemo.class,name);
    }
    public void testValue(){
        DataDemo dataDemo = new DataDemo();
        System.out.println("staticVar="+updater("staticVar"));
    }
}

class Father{
    public volatile int fatherVar=4;
}
@Data
class DataDemo extends Father{
    public volatile int publicVar=3;
    protected volatile int protectVar=4;
    private volatile int privateVar=5;

    public volatile static int staticVar=10;
    //public  final volatile int finalVar=20;

}
