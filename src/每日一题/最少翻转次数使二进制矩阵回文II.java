package 每日一题;

public class 最少翻转次数使二进制矩阵回文II {
    public int minFlips(int[][] grid) {
        //所有行和列都是回文，且1的数目可被整除
        int m=grid.length;
        int n=grid[0].length;
        //grid[i][j]=grid[i][n-1-j]=grid[m-1-i,j]=grid[m-1-i,n-1-j]
        //上面四个数要么都是0，要么都是1，i<=m/2,j<=n/2
        //如果行和列都是偶数的话，只需要考虑i<=m/2和j<=n/2:这个范围的值
        //行列都是偶数的话，只需要满足四个数都为0或1即可
        //如果行和列存在奇数的话,行是奇数的话需要考虑该行，列是奇数的话，需要考虑该列
        //行和列都是奇数的话，
        //首先计算偶数行列，只需判断修改为0还是修改为一
        int total=0;
        for (int i=0;i<m/2;i++){
            for (int j=0;j<n/2;j++){
                int cnt1= grid[i][j]+grid[i][n-1-j]+grid[m-1-i][j]+grid[m-1-i][n-1-j];
                total+=Math.min(cnt1,4-cnt1);
            }
        }

        if (m%2!=0&&n%2!=0){
            //如果行和列都是奇数的话
            //中间元素必须是0,
            total+=grid[m/2][n/2];
        }
        //现在考虑如果是奇数行的话，如何到达回文，且1的数字可以被4整除。
        //我们需要先计算1相等的回文对个数
        int cntOne=0;
        int diff=0;
        if (m%2!=0){
            int r=m/2;
            for (int j=0;j<n/2;j++){
                if (grid[r][j]==1&&grid[r][j]==grid[r][n-1-j]){
                    cntOne++; //得出1的对数
                }
                //不相等的对数，这个是必须要进行翻转的，是翻转成0还是1呢？
                if (grid[r][j]!=grid[r][n-1-j]){
                    diff++;
                }
            }
        }
        if (n%2!=0){
            int c=n/2;
            for (int i=0;i<m/2;i++){
                if (grid[i][c]!=grid[m-1-i][c]){
                    diff++;
                }
                if (grid[i][c]==grid[m-1-i][c]&&grid[i][c]==1){
                    cntOne++;
                }
            }

        }
        //最后才计算对数1的值和diff的对数
        if (cntOne%2!=0&&diff==0){
            total+=2;
        }
        total+=diff;
        return total;
    }

    public static void main(String[] args) {
        最少翻转次数使二进制矩阵回文II test = new 最少翻转次数使二进制矩阵回文II();
        System.out.println(test.minFlips(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }
}
