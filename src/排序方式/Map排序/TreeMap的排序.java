package 排序方式.Map排序;

import java.util.*;

public class TreeMap的排序 {
    public static void main(String[] args) {
        Map<String,String> map=new TreeMap<>(
//                //lambda表达式的写法
//                (str1,str2)->{return str2.compareTo(str1);}
        );
//        Map<String ,String> map=new TreeMap<>();
        map.put("A","A I am a");
        map.put("B2","E I am a2");
        map.put("B","B I am B");
        map.put("C","C I am C");
        //先将value的值取出，存储到list中
        List<Map.Entry<String,String>> list=new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        Map<String,String> result=new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : list) {
            result.put(entry.getKey(),entry.getValue());
        }
        System.out.println("排序后的顺序为");
        for (Map.Entry<String,String> entry:result.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
