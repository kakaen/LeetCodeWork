package 基础转换;

import sun.net.www.HeaderParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class 数组和List转换 {
    public static void main(String[] args) {
        int[] arr=new int[]{1,4,5,2,7};
        //基本类型的数组转为List类型的
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 7, 1);
        //迭代的方式生成3个元素的stream流 f(x)=x+3; f(0)=3,f(3)=6,f(6)=9;
        Stream<Integer> limit = Stream.iterate(0, (x) -> x + 3).limit(3);
        limit.forEach(each->{
            System.out.println(each+"---");
        });
        Arrays.stream(arr).forEach(e->{
            System.out.println(e+"--");
        });
    }
}
