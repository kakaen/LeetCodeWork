package Top100二刷.图论;

import java.util.ArrayList;
import java.util.List;

public class 课程表207 {
    public boolean canFinish(int numCourses,int[][] prerequisites){
        //数组prerequisites, numCOurses是共有多少个课
        //邻接矩阵
        List<Integer>[] list=new ArrayList[numCourses];
        for (int i=0;i<numCourses;i++){
            list[i]=new ArrayList<>();
        }
        //只要没有环应该是就可以了
        return true;
    }
}
