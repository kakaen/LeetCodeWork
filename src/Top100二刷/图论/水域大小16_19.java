package Top100二刷.图论;

import java.util.*;

public class 水域大小16_19 {
    public static void main(String[] args) {
        水域大小16_19 test = new 水域大小16_19();
        int[][] land=new int[][]{{0,2,1,0},
        {0,1,0,1},
        {1,1,0,1},
        {0,1,0,1}};
        int[] ints = test.pondSizes2(land);
        System.out.println(Arrays.toString(ints));
    }
    //优化二，不使用visited数组
    public int[] pondSizes2(int[][] land){
        int m= land.length;
        int n=land[0].length;
        List<Integer> ans=new ArrayList<>();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (land[i][j]==0){
                    land[i][j]=1;
                    ans.add(DFS(i,j,land));
                }
            }
        }
        return ans.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    public int DFS(int x,int y,int[][] land){
        int count=1;
        for (int[] dic:dict){
            int curX=x+dic[0];
            int curY=y+dic[1];
            if (curX>=0&&curX<land.length&&curY>=0&&curY<land[0].length&&land[curX][curY]==0){
                land[curX][curY]=1;
                count+=DFS(curX,curY,land);
            }
        }
        return count;
    }

    public int[] pondSizes(int[][] land) {
        int m=land.length;
        int n=land[0].length;
        boolean[][] visited=new boolean[m][n];
        List<Integer> ans=new ArrayList<>();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (!visited[i][j]&&land[i][j]==0){
                    visited[i][j]=true;
                    ans.add(BFS(i,j,visited,land));
                }
            }
        }
//        Collections.sort(ans);
        int[] array = ans.stream().sorted().mapToInt(Integer::intValue).toArray();
        return array;
    }
    public int[][] dict=new int[][] {{0,1},{1,0},{0,-1},{-1,0},{-1,1},{-1,-1},{1,-1},{1,1}};
    //计算
    public int BFS(int x,int y,boolean[][] visited,int[][] land){
        int count=0;
        Deque<int[]> deque=new ArrayDeque<>();
        visited[x][y]=true;
        count++;
        deque.push(new int[]{x,y});
        while (!deque.isEmpty()){
            int[] pop=deque.pop();
            for (int[] dic:dict){
                int curX=pop[0]+dic[0];
                int curY=pop[1]+dic[1];
                if (curX>=0&&curX<land.length&&curY>=0&&curY<land[0].length&&!visited[curX][curY]&&land[curX][curY]==0){
                    count++;
                    visited[curX][curY]=true;
                    deque.push(new int[]{curX,curY});
                }
            }
        }
        return count;
    }
}
