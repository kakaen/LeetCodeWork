package 排序方式.Map排序;

import java.util.*;

public class TreeMap实现value排序 {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("AA","N is AA");
        map.put("BB","D is BB");
        map.put("CC","KK is CC");
        //第一步，先创建一个List集合
        List<Map.Entry<String,String>> list=new ArrayList<>(map.entrySet());
        //第二步使用Collections方法的sort方法进行排序
        Collections.sort(list,(O1,O2)->O1.getValue().compareTo(O2.getValue()));
        //第三步，创建一个LinkedMap；确定顺序
        Map<String,String> result=new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : list) {
            result.put(entry.getKey(),entry.getValue());
        }
        //打印看看排序结果
        for (Map.Entry<String, String> stringStringEntry : result.entrySet()) {
            System.out.println(stringStringEntry.getKey()+" "+stringStringEntry.getValue());
        }
    }
}
