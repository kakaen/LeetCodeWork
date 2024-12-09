package 设计模式.工厂模式;

public class 工厂方法模式 {
    public static void main(String[] args) {
        TankFactory tankFactory = new TankFactory();
        Weapon tank = tankFactory.get();

    }
}
abstract class WeaponFactory2{
    public abstract Weapon get();
}
/**
 * 具体工厂对象，生产具体的产品
 */
class GunFactory extends WeaponFactory2{
    @Override
    public Weapon get() {
        return new Gun();
    }
}
class TankFactory extends WeaponFactory2{
    @Override
    public Weapon get() {
        return new Tank();
    }
}
