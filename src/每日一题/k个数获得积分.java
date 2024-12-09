package 每日一题;

import java.util.Scanner;

public class k个数获得积分 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T=scanner.nextInt();
        int[][] datas=new int[T][2];
        for (int i=0;i<T;i++){
            datas[i][0]=scanner.nextInt();
            datas[i][1]=scanner.nextInt();
        }
    }
    public int fun(int n,int k){
        //1-n,如果i+1没选，则积分加一
        if (k>=n){
            return 0;
        }else if (k<=(n/2)){
            return k;
        }else {

        }
        return 0;
    }
}
