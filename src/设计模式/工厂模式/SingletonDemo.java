package 设计模式.工厂模式;

public class SingletonDemo {
    private static volatile SingletonDemo singletonDemo;

    private SingletonDemo(){
        //进行各种初始化操作
    }
    public static SingletonDemo getInstance(){
        if (singletonDemo==null){
            synchronized (SingletonDemo.class){
                if (singletonDemo==null){
                    singletonDemo=new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }

}
