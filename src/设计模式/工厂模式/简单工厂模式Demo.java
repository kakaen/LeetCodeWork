package 设计模式.工厂模式;

public class 简单工厂模式Demo {
    public static void main(String[] args) {
        Weapon gun = WeaponFactory.get("Gun");
        gun.fire();
    }
}
class WeaponFactory{
    public static Weapon get(String weaponType){
        if ("Tank".equals(weaponType)){
            return new Tank();
        } else if ("Gun".equals(weaponType)) {
            return new Gun();
        }else {
            throw new RuntimeException("不支持该武器的生产");
        }
    }
}
//抽象产品类
class Weapon{
    public void fire(){
        System.out.println("武器的攻击方式");
    }
}
class Tank extends Weapon{
    @Override
    public void fire() {
        System.out.println("坦克的攻击方式为 ，砰砰砰");
    }
}
class Gun extends Weapon{
    @Override
    public void fire() {
        System.out.println("枪的攻击方式为：射击");
    }
}
