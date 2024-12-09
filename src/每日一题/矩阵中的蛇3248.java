package 每日一题;

import java.util.ArrayList;
import java.util.List;

public class 矩阵中的蛇3248 {
    public int finalPositionOfSnake(int n, List<String> commands) {
        //commands字符串数组，包括UP、RIGHT、DOWN、LEFT
        //如果是right的话则，(i,j)-->(i,j+1).
        //如果是down的话，则(i,j)--->()
        int i=0,j=0;
        for (String str:commands){
            if ("UP".equals(str)){
                i=i-1;
            } else if ("DOWN".equals(str)) {
                i=i+1;
            } else if ("LEFT".equals(str)) {
                j=j-1;
            }else {
                j=j+1;
            }
        }
        return i*n+j;
    }

    public static void main(String[] args) {
        矩阵中的蛇3248 test = new 矩阵中的蛇3248();
        List<String> list=new ArrayList<>();
        list.add("RIGHT");
        list.add("DOWN");
//        list.add()
        System.out.println(test.finalPositionOfSnake(2, list));
    }
}
