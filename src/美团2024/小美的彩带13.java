package 美团2024;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 小美的彩带13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int q=scanner.nextInt();
        System.out.println(n);
        System.out.println(q);
        int[] pos=new int[n];
        for (int i=0;i<n;i++){
            pos[i]=scanner.nextInt();
        }
        scanner.nextLine();
        String[] str=new String[q]; //存储的是方向和个数
        for (int i=0;i<q;i++){
            str[i]=scanner.nextLine();
        }
        System.out.println(Arrays.toString(str));
        function(pos,str);
    }
    public static void function(int[] pos,String[] strs){
        int q=strs.length;
        int[] res=new int[q];
        //计算每个循环数组共有多少种颜色
        Set<Integer> set=new HashSet<>();
        for (int col:pos){
            set.add(col);
        }
        int totalCol=set.size();
        for (String str:strs){

        }
    }
    //index是记录上次裁剪的位置,这里的lindex和rindex只需要记录a1-an中元素的下标即可
    public static int cut(int[] pos,String str,int lindex,int rindex,int totalCol){
        int n=pos.length;
        String[] split = str.split(" ");
        int cutNum=Integer.valueOf(split[1]);
        if (cutNum>=n-1){
            //向左进行切割
            if (split[0]=="L"){
                lindex=(lindex+cutNum)%n+1;
            }else {
                //向右进行切割
                int cut=cutNum%n;
                rindex=rindex-(cutNum)%n;

            }
        }
        return n;
    }
}
