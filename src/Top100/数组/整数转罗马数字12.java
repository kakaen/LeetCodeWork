package Top100.数组;

import java.util.HashMap;
import java.util.Map;

public class 整数转罗马数字12 {
    public static void main(String[] args) {
        整数转罗马数字12 test = new 整数转罗马数字12();
        System.out.println(test.intoRoman(3749));
    }
    private Map<Integer,Character> map=new HashMap<>();
    public String intoRoman(int num){
        map.put(1,'I');map.put(5,'V');map.put(10,'X');map.put(50,'L');
        map.put(100,'C');map.put(500,'D');map.put(1000,'M');
        StringBuilder builder=new StringBuilder();
        int k=1;//表示乘积的倍数
        while (num!=0){
            int count=num%10; //表示当前位数
            addString(count,k,builder);
            num=num/10;
            k=k*10;
        }
        return builder.reverse().toString();
    }
    //num表示当前
    public void addString(int num,int k,StringBuilder builder){
        //如果是四或9开头的话
        int key=(num)*k;
        if (num==4||num==9){
            key=(num+1)*k;
            Character character = map.get(key);
            builder.append(character);
            builder.append(map.get(k));
        }else{
            if (num>=5){
                key=key-5*k;
                while (key>0){
                    builder.append(map.get(k));
                    key-=k;
                }
                builder.append(map.get(5*k));
            }else{
                while (key>0){
                    builder.append(map.get(k));
                    key-=k;
                }
            }
        }
    }
}
