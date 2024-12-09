package 贪心算法;

import java.util.ArrayList;
import java.util.Arrays;

public class 根据身高重建队列406 {
    public static void main(String[] args) {
        Solution406 solution406 = new Solution406();
        int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        solution406.reconstructQueue(people);
    }
}
class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        int n= people.length; //总共有n个人
        int[][] queue = new int[n][2];
        //先进行排序，按身高高的进行排序，先确定身高高的人的位置
       Arrays.sort(people,(a,b)->{
           if (a[0]==b[0]) return a[1]-b[1];
           return b[0]-a[0];
       });
        ArrayList<int[]> arrayList = new ArrayList<>();
        //遍历每个人,进行插入
        for (int i=0;i<n;i++){
            //前面有多少个人在排队
            int count= people[i][1];
            arrayList.add(count,people[i]);
        }
        int i=0;
        for (int[] peoples:arrayList){
            queue[i++]=peoples;
        }
        return queue;
    }
}