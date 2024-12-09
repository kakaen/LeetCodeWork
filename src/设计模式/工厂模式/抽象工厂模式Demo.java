package 设计模式.工厂模式;

public class 抽象工厂模式Demo {
    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        Book macBook = appleFactory.createBook();
        macBook.play();
        Phone phone = appleFactory.createPhone();
        phone.call();
        XiaoMiFactory xiaoMiFactory = new XiaoMiFactory();
        Phone xiaomiPhone = xiaoMiFactory.createPhone();
        xiaomiPhone.call();
        Book xiaomiBook = xiaoMiFactory.createBook();
        xiaomiBook.play();

    }
}
//围绕一个超级工厂创建其他工厂，每个工厂可以生产不同类型的产品
interface Factory{
    public Phone createPhone();
    public Book createBook();
}
//创建一个苹果工厂实现抽象工厂类
class AppleFactory implements Factory{
    @Override
    public Phone createPhone() {
        return new Iphone();
    }

    @Override
    public Book createBook() {
        return new MacBook();
    }
}
//创建一个小米工厂实现抽象工厂类
class XiaoMiFactory implements Factory{
    @Override
    public Phone createPhone() {
        return new MiPhone();
    }

    @Override
    public Book createBook() {
        return new MiBook();
    }
}
//
interface Phone{
    public void call();
}
class Iphone implements Phone{
    @Override
    public void call() {
        System.out.println("用苹果手机打电话");
    }
}
class MiPhone implements Phone{
    @Override
    public void call() {
        System.out.println("用小米手机打电话");
    }
}
interface Book{
    public void play();
}
class MacBook implements Book{
    @Override
    public void play() {
        System.out.println("用苹果电脑打游戏");
    }
}
class MiBook implements Book{
    @Override
    public void play() {
        System.out.println("用小米电脑打游戏");
    }
}
