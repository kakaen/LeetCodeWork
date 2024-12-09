package ACM模式练习;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("b");
        int size=list.size();
        for (int i=0;i<size;i++){
            if (list.get(i).equals("b")){
                list.remove(i);
            }
        }
    }
}
