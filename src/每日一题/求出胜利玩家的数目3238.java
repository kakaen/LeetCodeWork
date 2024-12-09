package 每日一题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class 求出胜利玩家的数目3238 {
    public int winningPlayerCount(int n, int[][] pick) {
        int res=0; //最终结果
        Arrays.sort(pick, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });
        //n 表示有多少个玩家
        if (pick[0][0]==0) res++; //玩家0是胜利玩家
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;//记录每个玩家的最大值
        int maxCount=0; //记录每个玩家的最大值
        for (int i=0;i<pick.length;i++){
            if (i>0&&pick[i][0]==pick[i-1][0]){
                if (pick[i][1]==pick[i-1][1]) {
                    count++;
                }else{
                    count=1;
                }
                maxCount=Math.max(count,maxCount);
                if (pick[i][0]>0&&maxCount>=pick[i][0]+1) res++;
            }else{
                count=1;
                maxCount=1;
            }
        }
        return res;
    }
    public int winningPlayerCount2(int n,int[][] pick){
        int[][] cnt=new int[n][11]; //因为总共有11种球
        for (int[] row:pick){
            cnt[row[0]][row[1]]++;
        }
        int res=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<11;j++){
                if (i==0&&cnt[i][j]>0){
                    res++;
                    break;
                }else if (cnt[i][j]>=i+1){
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        求出胜利玩家的数目3238 test = new 求出胜利玩家的数目3238();
        int[][] pick=new int[][]{{1,1},{1,0},{2,1},{0,0},{2,2}};
        int[][] pick2=new int[][]{{0,0},{1,0},{1,0},{2,1},{2,1},{2,0}};
        int[][] pick3=new int[][]{{1,1},{1,2},{1,3},{1,4}};
        int[][] pick4=new int[][]{{1,1},{2,4},{2,4},{2,4}};
        System.out.println(test.winningPlayerCount2(3, pick2));
        System.out.println(test.winningPlayerCount2(5, pick3));
        System.out.println(test.winningPlayerCount2(5, pick4));
    }
}
