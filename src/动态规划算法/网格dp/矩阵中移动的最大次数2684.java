package 动态规划算法.网格dp;

import java.util.*;

public class 矩阵中移动的最大次数2684 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int m=scanner.nextInt();
//        int n=scanner.nextInt();
//        int[][] grid=new int[m][n];
//        scanner.nextLine();
//        for (int i=0;i<m;i++){
//            String str=scanner.nextLine();
//            String[] split = str.split(" ");
//            for (int j=0;j<n;j++){
//                grid[i][j]=Integer.parseInt(split[j]);
//            }
//        }
        int[][] grid2=new int[][]{
                {1000000,92910,1021,1022,1023,1024,1025,1026,1027,1028,1029,1030,1031,1032,1033,1034,1035,1036,1037,1038,1039,1040,1041,1042,1043,1044,1045,1046,1047,1048,1049,1050,1051,1052,1053,1054,1055,1056,1057,1058,1059,1060,1061,1062,1063,1064,1065,1066,1067,1068},{1069,1070,1071,1072,1073,1074,1075,1076,1077,1078,1079,1080,1081,1082,1083,1084,1085,1086,1087,1088,1089,1090,1091,1092,1093,1094,1095,1096,1097,1098,1099,1100,1101,1102,1103,1104,1105,1106,1107,1108,1109,1110,1111,1112,1113,1114,1115,1116,1117,1118}};
        Solution2684 solution2684 = new Solution2684();
        System.out.println(solution2684.maxMove3(grid2));
    }
}
class Solution2684 {
    public int maxMoves(int[][] grid) {
        int m=grid.length;//行
        int n=grid[0].length; //列值
        int[][] dp=new int[m][n]; //dp表示能够移动到i,j位置的最大次数
        int max=0;

        //初始化第一列
        for (int i=0;i<m;i++){
            dp[i][0]=0;
        }
        //遍历后续列
        for (int j=1;j<n;j++){
            //初始化第一行
            boolean flag=false;
            int t1=0,t2=0;
            if (grid[0][j]>grid[0][j-1]){
                t1=dp[0][j-1]+1;
                flag=true; //表示可以通过
            }
            if (grid[0][j]>grid[1][j-1]) {
                t2=dp[1][j-1]+1;
                flag=true;
            }
            dp[0][j]=Math.max(t1,t2);
            //如果大于等于三行的话
            for (int i=1;i<m-1;i++){
                int k1=0,k2=0,k3=0;
                if (grid[i][j]>grid[i-1][j-1]){
                    k1=dp[i-1][j-1]+1;
                }
                if (grid[i][j]>grid[i][j-1]){
                    k2=dp[i][j-1]+1;
                }
                if (grid[i][j]>grid[i+1][j-1]) {
                    k3=dp[i+1][j-1]+1;
                }
                dp[i][j]=Math.max(k1,Math.max(k2,k3));
            }
            //最后一行
            int v1=0,v2=0;
            if (grid[m-1][j]>grid[m-2][j-1]){
                v1=dp[m-2][j-1]+1;
            }
            if (grid[m-1][j]>grid[m-1][j-1]) {
                v2=dp[m-1][j-1]+1;
            }
            dp[m-1][j]=Math.max(v1,v2);
        }

        for (int j=1;j<n;j++){
            boolean flag=false;
            for (int i=0;i<m;i++){
                if (dp[i][j]!=0){
                    flag=true;
                    if (max<dp[i][j]) max=dp[i][j];
                }
            }
            if (flag==false) break;
        }
        return max;
    }
    //使用DFS进行，通过递归的方式来实现
    private int ans=0;
    public int maxMoves2(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        for (int i=0;i<m;i++){
            dfs(i,0,grid); //从第一列的任意一个元素出发。
        }
        return ans;
    }
    //i，j表示第i行第j列
    public void dfs(int i,int j,int[][] grid){
        ans=Math.max(ans,j);
        if (ans==grid[0].length-1) return; //ans值已经到达最大值
        //判断是否可以向右上，右，右下走
        for (int k=Math.max(i-1,0);k<Math.min(i+2, grid.length);k++){
            if (grid[k][j+1]>grid[i][j]){
                dfs(k,j+1,grid);//表示可以到达j+1这列
            }
        }
        grid[i][j]=0;
    }
    public int maxMove3(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n]; //dp[i][j]表示是否可以到达i，j
        //dp[i][j]=1，表示可以到达，dp[i][j]=0表示无法到达。
        //初始化
        for (int i=0;i<m;i++){
            dp[i][0]=1;
        }
        int total=0;
        for (int j=1;j<n;j++){
            boolean flag=false; //判断当前列是否都无法到达
            for (int i=0;i<m;i++){
                //如果i,j-1无法到达直接
                if (dp[i][j-1]==0) continue;
                if (i>0&&grid[i][j-1]<grid[i-1][j]){
                    flag=true;
                    dp[i-1][j]=1;
                }
                if (grid[i][j-1]<grid[i][j]){
                    flag=true;
                    dp[i][j]=1;
                }
                if ((i<m-1)&&grid[i][j-1]<grid[i+1][j]){
                    flag=true;
                    dp[i+1][j]=1;
                }
            }
            if (flag==false) return total;
            total++;
        }
        return total;
    }
}
