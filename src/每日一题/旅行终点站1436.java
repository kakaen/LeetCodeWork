package 每日一题;

import java.util.*;

public class 旅行终点站1436 {
    public static void main(String[] args) {
        旅行终点站1436 test = new 旅行终点站1436();
        String[][]pa=new String[][] {{"London","New York"},{"New York","Lima"},{"Lima","Sao Paulo"}};
        List<List<String>> paths=new ArrayList<>();

    }
    public String destCity(List<List<String>> paths){
        Set<String> startAddress=new HashSet<>();
        //终点站肯定只出现过一次
        for (List<String> path : paths) {
            startAddress.add(path.get(0));
        }
        for (List<String> path:paths){
            if (!startAddress.contains(path.get(1))) return path.get(1);
        }
        return null;
    }
}
