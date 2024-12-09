package 常用工具类;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays类 {
    public static void main(String[] args) {
        String[] intro=new String[]{"咔卡","是谁","?啊"};
        ArrayList<Object> objects = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        //copyOf函数，复制新数组
        String[] strings = Arrays.copyOf(intro, 3);
        String[] strings1 = Arrays.copyOf(intro, 5);
        int[] arr=new int[5];
        Arrays.fill(arr,12);
        Arrays.fill(strings1,"kakaen");
        //判断两个数组是否相等，使用equals方法
        System.out.println(Arrays.equals(intro,strings));
        //也可以使用hashCOde
        //binarySearch(),若查询到，则返回该下标，未查询到则返回-1
        System.out.println(Arrays.binarySearch(intro, "是谁"));
        System.out.println(Arrays.binarySearch(intro,"s w "));
        System.out.println(Arrays.hashCode(intro));
        System.out.println(Arrays.hashCode(strings));
        System.out.println(Arrays.toString(strings1));
        //底层调用的是StringBuilder的toString函数
        //数组传List，把数组类型转为list集合类型
        String[] intro1=new String[]{"卡卡","是","shu"};
        //因为它返回的是java.util.Arrays.ArrayList中的，长度是固定的
        List<String> list = Arrays.asList(intro1);
        ArrayList<String> list2 = new ArrayList<>();
        //只要是继承Collections接口的实现类对象都行
        new ArrayList<>(list);
        //Java.util.ArrayList
        list2.add("test");
        //setAll方法，
        Arrays.setAll(arr,i->i*10);
        System.out.println(list2);
        System.out.println(list);
        //stream流的方式

    }
}
