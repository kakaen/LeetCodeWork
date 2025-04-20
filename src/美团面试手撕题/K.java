package 美团面试手撕题;

import java.util.ArrayList;
import java.util.List;

public class K {
    public static void main(String[] args) {
        List<String> test=new ArrayList<>();
        test.add("123");
        test.add("123");
        test.add("123");
        test.add("123");
        System.out.println(String.join(".", test));
    }
}
